package chipyard.fpga.zcu106

import sys.process._

import org.chipsalliance.cde.config.{Config, Parameters}
import freechips.rocketchip.subsystem.{SystemBusKey, PeripheryBusKey, ControlBusKey, ExtMem}
import freechips.rocketchip.devices.debug.{DebugModuleKey, ExportDebug, JTAG}
import freechips.rocketchip.devices.tilelink.{DevNullParams, BootROMLocated}
import freechips.rocketchip.diplomacy.{DTSModel, DTSTimebase, RegionType, AddressSet}
import freechips.rocketchip.tile.{XLen}

import sifive.blocks.devices.spi.{PeripherySPIKey, SPIParams}
import sifive.blocks.devices.uart.{PeripheryUARTKey, UARTParams}

import sifive.fpgashells.shell.{DesignKey}
import sifive.fpgashells.shell.xilinx.{ZCU106ShellPMOD, ZCU106DDRSize}

import testchipip.serdes.{SerialTLKey}

import chipyard._
import chipyard.harness._

import freechips.rocketchip.diplomacy.{AsynchronousCrossing}

// import sys.process._

// import org.chipsalliance.cde.config.{Config, Parameters}
// import freechips.rocketchip.subsystem.{SystemBusKey, PeripheryBusKey, ControlBusKey, ExtMem}
// import freechips.rocketchip.devices.debug.{DebugModuleKey, ExportDebug, JTAG}
// import freechips.rocketchip.devices.tilelink.{DevNullParams, BootROMLocated}
// import freechips.rocketchip.diplomacy.{RegionType, AddressSet}
// import freechips.rocketchip.resources.{DTSModel, DTSTimebase}

// import sifive.blocks.devices.spi.{PeripherySPIKey, SPIParams}
// import sifive.blocks.devices.uart.{PeripheryUARTKey, UARTParams}

// import sifive.fpgashells.shell.{DesignKey}
// import sifive.fpgashells.shell.xilinx.{ZCU106ShellPMOD, ZCU106DDRSize}

// import testchipip.serdes.{SerialTLKey}

// import chipyard._
// import chipyard.harness._

// import freechips.rocketchip.prci.{AsynchronousCrossing}

class WithDefaultPeripherals extends Config((site, here, up) => {
  case PeripheryUARTKey => List(UARTParams(address = BigInt(0x64000000L)))
  case PeripherySPIKey => List(SPIParams(rAddress = BigInt(0x64001000L)))
  case ZCU106ShellPMOD => "SDIO"
})

class WithSystemModifications extends Config((site, here, up) => {
  case DTSTimebase => BigInt((1e6).toLong)
  case BootROMLocated(x) => up(BootROMLocated(x), site).map { p =>
    // invoke makefile for sdboot
    val freqMHz = (site(SystemBusKey).dtsFrequency.get / (1000 * 1000)).toLong
    val make = s"make -C fpga/src/main/resources/zcu106/sdboot PBUS_CLK=${freqMHz} bin"
    require (make.! == 0, "Failed to build bootrom")
    p.copy(hang = 0x10000, contentFileName = s"./fpga/src/main/resources/zcu106/sdboot/build/sdboot.bin")
  }
  case ExtMem => up(ExtMem, site).map(x => x.copy(master = x.master.copy(size = site(ZCU106DDRSize)))) // set extmem to DDR size
  case SerialTLKey => Nil // remove serialized tl port
})

class WithZCU106Tweaks extends Config(
  new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
  new chipyard.clocking.WithPassthroughClockGenerator ++
  new chipyard.config.WithMemoryBusFrequency(100) ++
  new chipyard.config.WithSystemBusFrequency(100) ++
  new chipyard.config.WithControlBusFrequency(100) ++
  new chipyard.config.WithPeripheryBusFrequency(100) ++
  new chipyard.config.WithControlBusFrequency(100) ++
  new chipyard.config.WithFrontBusFrequency(100)++
  // new chipyard.config.WithUniformBusFrequencies(100) ++
  new WithFPGAFrequency(100) ++ // default 100MHz freq
 // new WithJTAG ++  //George had it. I removed it cause I added WithNoDebug
  // harness binders
  new WithUART ++
  new WithSPISDCard ++
  new WithDDRMem ++
  // other configuration
  new WithDefaultPeripherals ++
  new chipyard.config.WithTLBackingMemory ++ // use TL backing memory
  new WithSystemModifications ++ // setup busses, use sdboot bootrom, setup ext. mem. size
  new chipyard.config.WithNoDebug ++ // remove debug module
  new freechips.rocketchip.subsystem.WithoutTLMonitors ++
  new freechips.rocketchip.subsystem.WithNMemoryChannels(1) 
)

// Rocket Configs found in /home/riscv/Documents/Chipyard/latest/generators/rocket-chip/src/main/scala/rocket/Configs.scala
// freechips.rocketchip.rocket.WithNHugeCores
// freechips.rocketchip.rocket.WithNBigCores
// freechips.rocketchip.rocket.WithNMedCores
// freechips.rocketchip.rocket.WithNSmallCores
// Boom Configs found in /home/riscv/Documents/Chipyard/latest/generators/boom/src/main/scala/v4/common/config-mixins.scala
// boom.v4.common.WithNSmallBooms
// boom.v4.common.WithNMediumBooms
// boom.v4.common.WithNLargeBooms
// boom.v4.common.WithNMegaBooms
// boom.v4.common.WithNGigaBooms

class SmallRocket extends Config(
  new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
  new chipyard.clocking.WithPassthroughClockGenerator ++
  //new chipyard.config.WithUniformBusFrequencies(100) ++
  new WithFPGAFrequency(100) ++
  new WithZCU106Tweaks ++
  new freechips.rocketchip.subsystem.WithNSmallCores(1) ++
  new chipyard.config.AbstractConfig
)

class MediumRocket extends Config(
  new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
  new chipyard.clocking.WithPassthroughClockGenerator ++
  //new chipyard.config.WithUniformBusFrequencies(100) ++
  new WithFPGAFrequency(100) ++
  new WithZCU106Tweaks ++
  new freechips.rocketchip.subsystem.WithNMedCores(1) ++
  new chipyard.config.AbstractConfig
)

class BigRocket extends Config(
  new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
  new chipyard.clocking.WithPassthroughClockGenerator ++
  //new chipyard.config.WithUniformBusFrequencies(100) ++
  new WithFPGAFrequency(100) ++
  new WithZCU106Tweaks ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new chipyard.config.AbstractConfig
)

class HugeRocket extends Config(
  new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
  new chipyard.clocking.WithPassthroughClockGenerator ++
  //new chipyard.config.WithUniformBusFrequencies(125) ++
  new WithFPGAFrequency(125) ++
  new WithZCU106Tweaks ++
  //new freechips.rocketchip.subsystem.WithNHugeCores(1) ++
  new chipyard.config.AbstractConfig
)

// class SmallBoom extends Config(
//   new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
//   new chipyard.clocking.WithPassthroughClockGenerator ++
//   //new chipyard.config.WithUniformBusFrequencies(100) ++
//   new WithFPGAFrequency(100) ++
//   new WithZCU106Tweaks ++
//   new boom.v4.common.WithNSmallBooms(1) ++
//   new chipyard.config.AbstractConfig
// )

// class MediumBoom extends Config(
//   new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
//   new chipyard.clocking.WithPassthroughClockGenerator ++
//   //new chipyard.config.WithUniformBusFrequencies(150) ++
//   new WithFPGAFrequency(150) ++
//   new WithZCU106Tweaks ++
//   new boom.v4.common.WithNMediumBooms(1) ++
//   new chipyard.config.AbstractConfig
// )

// class LargeBoom extends Config(
//   new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
//   new chipyard.clocking.WithPassthroughClockGenerator ++
//   //new chipyard.config.WithUniformBusFrequencies(100) ++
//   new WithFPGAFrequency(100) ++
//   new WithZCU106Tweaks ++
//   new boom.v4.common.WithNLargeBooms(1) ++
//   new chipyard.config.AbstractConfig
// )

// class MegaBoom extends Config(
//   new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
//   new chipyard.clocking.WithPassthroughClockGenerator ++
//   //new chipyard.config.WithUniformBusFrequencies(100) ++
//   new WithFPGAFrequency(100) ++
//   new WithZCU106Tweaks ++
//   new boom.v4.common.WithNMegaBooms(1) ++
//   new chipyard.config.AbstractConfig
// )

// class GigaBoom extends Config(
//   new chipyard.harness.WithAllClocksFromHarnessClockInstantiator ++
//   new chipyard.clocking.WithPassthroughClockGenerator ++
//   //new chipyard.config.WithUniformBusFrequencies(100) ++
//   new WithFPGAFrequency(100) ++
//   new WithZCU106Tweaks ++
//   new boom.v4.common.WithNGigaBooms(1) ++
//   new chipyard.config.AbstractConfig
// )

class RocketMultiDomain1GHz extends Config(
  new WithZCU106Tweaks ++
  //new freechips.rocketchip.rocket.WithAsynchronousCDCs(8, 3) ++ // Add async crossings between RocketTile and uncore
  new chipyard.config.WithControlBusFrequency(100.0) ++
  new chipyard.config.WithSystemBusFrequency(100.0) ++
  new chipyard.config.WithMemoryBusFrequency(100.0) ++    
  new chipyard.config.WithFrontBusFrequency(100.0) ++
  new chipyard.config.WithPeripheryBusFrequency(100.0) ++ 
  new chipyard.config.WithTileFrequency(500.0) ++ 
  new chipyard.config.WithFbusToSbusCrossingType(AsynchronousCrossing()) ++ // Add Async crossing between FBUS and SBUS
  new chipyard.config.WithCbusToPbusCrossingType(AsynchronousCrossing()) ++ // Add Async crossing between PBUS and CBUS
  new chipyard.config.WithSbusToMbusCrossingType(AsynchronousCrossing()) ++ // Add Async crossings between backside of L2 and MBUS
 // new freechips.rocketchip.subsystem.WithNHugeCores(1) ++
  new chipyard.config.AbstractConfig
)

class WithFPGAFrequency(fMHz: Double) extends Config(
  new chipyard.harness.WithHarnessBinderClockFreqMHz(fMHz)
  // new chipyard.config.WithSystemBusFrequency(fMHz) ++
  // new chipyard.config.WithPeripheryBusFrequency(fMHz) ++
  // new chipyard.config.WithControlBusFrequency(fMHz) ++
  // new chipyard.config.WithFrontBusFrequency(fMHz) ++
  // new chipyard.config.WithMemoryBusFrequency(fMHz)
)

class WithFPGAFreq25MHz extends WithFPGAFrequency(25)
class WithFPGAFreq50MHz extends WithFPGAFrequency(50)
class WithFPGAFreq75MHz extends WithFPGAFrequency(75)
class WithFPGAFreq100MHz extends WithFPGAFrequency(100)

class RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.RocketConfig
)

// class RocketDefaultZCU106Config extends Config(
//   new WithZCU106Tweaks ++
//   new chipyard.RocketConfigDefault
// )

// bring rqt buffer back

// INITIAL
class ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitExactlySameNoL2FinalRocketZCU106ConfigREVERT extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitExactlySameNoL2FinalRocketConfig
)

class ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitDISABLEPREFExactlySameNoL2FinalRocketZCU106ConfigREVERT extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitDISABLEPREFExactlySameNoL2FinalRocketConfig
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTLOOKUPONLYExactlySameNoL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTLOOKUPONLYExactlySameNoL2FinalRocketConfig
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTDISABLEREDUNDCHECKSExactlySameNoL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTDISABLEREDUNDCHECKSExactlySameNoL2FinalRocketConfig
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39ExactlySameNoL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256CorrectMedNoBwslowdownComplete39ExactlySameNoL2FinalRocketConfig
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPT8xSYSTEMBUSExactlySameNoL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPT8xSYSTEMBUSExactlySameNoL2FinalRocketConfig
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTCLOSERTOSLOWExactlySameNoL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTCLOSERTOSLOWExactlySameNoL2FinalRocketConfig
)

// ------------------------------------------------------------------------------------------------------------------------------------------

// Cores only ---------------------------------------------------------------------------------------------------------------------------

// Small -----------------------------------------------

class CorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.CorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig
)

// Medium -----------------------------------------------
class CorrectMedNoBwslowdownFinalExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.CorrectMedNoBwslowdownFinalExactlySameNoL2RocketConfig
)

// Big    -----------------------------------------------
class CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketConfig
)

// Big    -----------------------------------------------
// Perf Counters
class CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketConfig
)

// List Prefetcher + Cores ----------------------------------------------------------------------------------------------------------------

// Small ------------------------------------------------

// 256 tagIDs
class ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig
)

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig
)

//-----------------With L2

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameWithL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketConfig
)

//-----------------No RQT

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig
)

// Medium -----------------------------------------------

// 256 tagIDs
// Granul 7
class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketConfig
)

// CORRECTED VERSION
// Granul 7
class ListPref7ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig
)

// CORRECTED VERSION
// Granul 6
class ListPref6ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref6ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig
)

// 256 tagIDs
// Granul 8
class ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketConfig
)

// 2048 tagIDs
// Granul 7
class ListPref7ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig
)

//-----------------With L2

// 256 tagIDs
// Granul 8
class ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameWithL2FinalRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameWithL2FinalRocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketConfig
)

//-----------------No RQT

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdownFinalExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdownFinalExactlySameNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig
)

// Big    -----------------------------------------------

// 256 tagIDs
class ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketConfig
)

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketConfig
)

// PERF COUNTERS
// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketConfig
)

//-----------------With L2

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameWithL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketConfig
)

//-----------------No RQT

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsExactlySameNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketConfig
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketConfig
)

// Only MetaSys Intruction Implementation Module + Cores ----------------------------------------------------------------------------------------------------------

// Medium -----------------------------------------------
// 2048 tagIDs
class AtomAddressMapController2048X11CycleRDLatencyNorenCorrectMedNoBwslowdownFinalExactlySameNoL2RocketZCU106Config extends Config(
  new WithZCU106Tweaks ++
  new chipyard.AtomAddressMapController2048X11CycleRDLatencyNorenCorrectMedNoBwslowdownFinalExactlySameNoL2RocketConfig
)