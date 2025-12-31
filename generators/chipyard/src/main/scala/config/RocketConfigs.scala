package chipyard

import org.chipsalliance.cde.config.{Config}
import freechips.rocketchip.diplomacy.{AsynchronousCrossing}
import freechips.rocketchip.subsystem.{InCluster}

// --------------
// Rocket Configs
// --------------

/////////////////////////////////////////Final Configs//////////////////////////////////////////////////////////


// Cores only ---------------------------------------------------------------------------------------------------------------------------

// Small -----------------------------------------------
class CorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// Medium -----------------------------------------------
class CorrectMedNoBwslowdownFinalExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// Big    -----------------------------------------------
class CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++
  new chipyard.config.AbstractConfigNoL2 
)

// Big    -----------------------------------------------
// Perf Counters
class CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketConfig extends Config(
  new chipyard.config.WithNPerfCounters(29) ++
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++
  new chipyard.config.AbstractConfigNoL2 
)

// List Prefetcher + Cores ----------------------------------------------------------------------------------------------------------------

// Small -----------------------------------------------
// 256 tagIDs
class ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 7, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++  
  new chipyard.config.AbstractConfigNoL2 
)

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++  
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(512, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++
  new chipyard.config.AbstractConfigNoL2 
)

//-----------------With L2
// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++  
  new chipyard.config.AbstractConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(512, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++
  new chipyard.config.AbstractConfig 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++
  new chipyard.config.AbstractConfig
)

//-----------------No RQT
// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialNoRqtNoswaitRPTExactlySame39Config(256, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++  
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameConfig(512, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameConfig(256, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdown1Way1DTLBSet1MSHR(1, 1) ++
  new chipyard.config.AbstractConfigNoL2 
)

// Medium -----------------------------------------------
// 256 tagIDs
// Granul 7
class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 7, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// CORRECTED VERSION
// Granul 7
class ListPref7ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherComplete39MAPUPDATEInitialRqtNoswaitRPTExactlySameConfig(256, 7, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// CORRECTED VERSION
// Granul 6
class ListPref6ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherComplete39MAPUPDATEInitialRqtNoswaitRPTExactlySameConfig(256, 6, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 256 tagIDs
// Granul 8
class ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 7
class ListPref7ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(512, 7, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(512, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

//-----------------With L2

// 256 tagIDs
// Granul 8
class ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameWithL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfig
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(512, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfig 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfig 
)

//-----------------No RQT
// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdownFinalExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialNoRqtNoswaitRPTExactlySame39Config(256, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameConfig(512, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameConfig(256, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// Big    -----------------------------------------------
// 256 tagIDs
class ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 7, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// PERF COUNTERS
// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketConfig extends Config(
  new chipyard.config.WithNPerfCounters(29) ++
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(512, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++        // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++        // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

//-----------------With L2

// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++         // single rocket-core
  new chipyard.config.AbstractConfig 
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(512, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++        // single rocket-core
  new chipyard.config.AbstractConfig 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameConfig(256, 8, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++        // single rocket-core
  new chipyard.config.AbstractConfig 
)

//-----------------No RQT
// 256 tagIDs
// Granul 8
class ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialNoRqtNoswaitRPTExactlySame39Config(256, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 512
class ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameConfig(512, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// 2048 tagIDs
// Granul 8
// ALB 256
class ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcher2048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameConfig(256, 8, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal8Way16DTLBSets16MSHR(1, 16) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// Only MetaSys Intruction Implementation Module + Cores ----------------------------------------------------------------------------------------------------------

// Medium -----------------------------------------------
// 2048 tagIDs
class AtomAddressMapController2048X11CycleRDLatencyNorenCorrectMedNoBwslowdownFinalExactlySameNoL2RocketConfig extends Config(
  new freechips.rocketchip.subsystem.AtomAddressMapController2048X11CycleRDLatencyNorenSubsystemConfig(7, false, false) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

// ------------------------------------------------------------------------------------------------------------------------------------------

// INITIAL
// bring rqt buffer back
class ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitExactlySame39Config(256, 6, true, false, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

class ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitDISABLEPREFExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitExactlySame39Config(256, 6, false, true, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPT8xSYSTEMBUSExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPT8xSYSTEMBUSExactlySame39Config(256, 7, true, false, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTLOOKUPONLYExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 7, true, true, false, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTDISABLEREDUNDCHECKSExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherCompleteInitialRqtNoswaitRPTExactlySame39Config(256, 7, true, false, true, 4, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39ExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherComplete39Config(256, 7, true, false) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

class ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTCLOSERTOSLOWExactlySameNoL2FinalRocketConfig extends Config(
  new freechips.rocketchip.subsystem.ListPrefetcherComplete39InitialRqtNoswaitRPTCLOSERTOSLOWConfig(256, 7, true, false, false, 4) ++  
  new freechips.rocketchip.subsystem.CorrectWithNMediumCoresNoBwslowdownFinal(1, 2) ++         // single rocket-core
  new chipyard.config.AbstractConfigNoL2 
)

/////////////////////////////////////////Existing Configs////////////////////////////////////////////////////

class RocketConfig extends Config(
  new chipyard.config.WithNPerfCounters(32) ++
  new freechips.rocketchip.subsystem.WithoutTLMonitors ++ //speedup RTL simulation
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++         // single rocket-core
  new chipyard.config.AbstractConfig)

class TinyRocketConfig extends Config(
  new chipyard.harness.WithDontTouchChipTopPorts(false) ++        // TODO FIX: Don't dontTouch the ports
  new testchipip.soc.WithNoScratchpads ++                         // All memory is the Rocket TCMs
  new freechips.rocketchip.subsystem.WithIncoherentBusTopology ++ // use incoherent bus topology
  new freechips.rocketchip.subsystem.WithNBanks(0) ++             // remove L2$
  new freechips.rocketchip.subsystem.WithNoMemPort ++             // remove backing memory
  new freechips.rocketchip.subsystem.With1TinyCore ++             // single tiny rocket-core
  new chipyard.config.AbstractConfig)

class QuadRocketConfig extends Config(
  new freechips.rocketchip.subsystem.WithNBigCores(4) ++    // quad-core (4 RocketTiles)
  new chipyard.config.AbstractConfig)

class Cloned64RocketConfig extends Config(
  new freechips.rocketchip.subsystem.WithCloneRocketTiles(63, 0) ++ // copy tile0 63 more times
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++            // tile0 is a BigRocket
  new chipyard.config.AbstractConfig)

class RV32RocketConfig extends Config(
  new freechips.rocketchip.subsystem.WithRV32 ++            // set RocketTiles to be 32-bit
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new chipyard.config.AbstractConfig)

// DOC include start: l1scratchpadrocket
class ScratchpadOnlyRocketConfig extends Config(
  new chipyard.config.WithL2TLBs(0) ++
  new testchipip.soc.WithNoScratchpads ++                      // remove subsystem scratchpads, confusingly named, does not remove the L1D$ scratchpads
  new freechips.rocketchip.subsystem.WithNBanks(0) ++
  new freechips.rocketchip.subsystem.WithNoMemPort ++          // remove offchip mem port
  new freechips.rocketchip.subsystem.WithScratchpadsOnly ++    // use rocket l1 DCache scratchpad as base phys mem
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new chipyard.config.AbstractConfig)
// DOC include end: l1scratchpadrocket

class MMIOScratchpadOnlyRocketConfig extends Config(
  new freechips.rocketchip.subsystem.WithDefaultMMIOPort ++  // add default external master port
  new freechips.rocketchip.subsystem.WithDefaultSlavePort ++ // add default external slave port
  new ScratchpadOnlyRocketConfig
)

class L1ScratchpadRocketConfig extends Config(
  new chipyard.config.WithRocketICacheScratchpad ++         // use rocket ICache scratchpad
  new chipyard.config.WithRocketDCacheScratchpad ++         // use rocket DCache scratchpad
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new chipyard.config.AbstractConfig)

class MulticlockRocketConfig extends Config(
  new freechips.rocketchip.subsystem.WithAsynchronousRocketTiles(3, 3) ++ // Add async crossings between RocketTile and uncore
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  // Frequency specifications
  new chipyard.config.WithTileFrequency(1000.0) ++        // Matches the maximum frequency of U540
  new chipyard.clocking.WithClockGroupsCombinedByName(("uncore"   , Seq("sbus", "cbus", "implicit", "clock_tap"), Nil),
                                                      ("periphery", Seq("pbus", "fbus"), Nil)) ++
  new chipyard.config.WithSystemBusFrequency(500.0) ++    // Matches the maximum frequency of U540
  new chipyard.config.WithMemoryBusFrequency(500.0) ++    // Matches the maximum frequency of U540
  new chipyard.config.WithPeripheryBusFrequency(500.0) ++ // Matches the maximum frequency of U540
  //  Crossing specifications
  new chipyard.config.WithFbusToSbusCrossingType(AsynchronousCrossing()) ++ // Add Async crossing between FBUS and SBUS
  new chipyard.config.WithCbusToPbusCrossingType(AsynchronousCrossing()) ++ // Add Async crossing between PBUS and CBUS
  new chipyard.config.WithSbusToMbusCrossingType(AsynchronousCrossing()) ++ // Add Async crossings between backside of L2 and MBUS
  new chipyard.config.AbstractConfig)

class CustomIOChipTopRocketConfig extends Config(
  new chipyard.example.WithBrokenOutUARTIO ++
  new chipyard.example.WithCustomChipTop ++
  new chipyard.example.WithCustomIOCells ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++         // single rocket-core
  new chipyard.config.AbstractConfig)

class PrefetchingRocketConfig extends Config(
  new barf.WithHellaCachePrefetcher(Seq(0), barf.SingleStridedPrefetcherParams()) ++   // strided prefetcher, sits in front of the L1D$, monitors core requests to prefetching into the L1D$
  new barf.WithTLICachePrefetcher(barf.MultiNextLinePrefetcherParams()) ++             // next-line prefetcher, sits between L1I$ and L2, monitors L1I$ misses to prefetch into L2
  new barf.WithTLDCachePrefetcher(barf.SingleAMPMPrefetcherParams()) ++                // AMPM prefetcher, sits between L1D$ and L2, monitors L1D$ misses to prefetch into L2
  new chipyard.config.WithTilePrefetchers ++                                           // add TL prefetchers between tiles and the sbus
  new freechips.rocketchip.subsystem.WithNonblockingL1(2) ++                           // non-blocking L1D$, L1 prefetching only works with non-blocking L1D$
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++                               // single rocket-core
  new chipyard.config.AbstractConfig)

class ClusteredRocketConfig extends Config(
  new freechips.rocketchip.subsystem.WithNBigCores(4, location=InCluster(1)) ++
  new freechips.rocketchip.subsystem.WithNBigCores(4, location=InCluster(0)) ++
  new freechips.rocketchip.subsystem.WithCluster(1) ++
  new freechips.rocketchip.subsystem.WithCluster(0) ++
  new chipyard.config.AbstractConfig)

class FastRTLSimRocketConfig extends Config(
  new freechips.rocketchip.subsystem.WithoutTLMonitors ++
  new chipyard.RocketConfig)
