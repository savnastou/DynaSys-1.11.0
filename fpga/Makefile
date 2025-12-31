#########################################################################################
# fpga prototype makefile
#########################################################################################

#########################################################################################
# general path variables
#########################################################################################
base_dir=$(abspath ..)
sim_dir=$(abspath .)

# do not generate simulation files
sim_name := none

#########################################################################################
# include shared variables
#########################################################################################
SUB_PROJECT ?= vcu118

ifeq ($(SUB_PROJECT),vc707)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= VC707FPGATestHarness
	VLOG_MODEL        ?= VC707FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.vc707
	CONFIG            ?= RocketVC707Config
	CONFIG_PACKAGE    ?= chipyard.fpga.vc707
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= vc707
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),vcu118)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= VCU118FPGATestHarness
	VLOG_MODEL        ?= VCU118FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.vcu118
	CONFIG            ?= RocketVCU118Config
	CONFIG_PACKAGE    ?= chipyard.fpga.vcu118
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= vcu118
	FPGA_BRAND        ?= xilinx
endif

# // INITIAL
# // bring rqt buffer back
ifeq ($(SUB_PROJECT),listpref6alb256corrmednobwslowcomplete39initialrqtnoswaitexactlysamenol2finalrevert)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitExactlySameNoL2FinalRocketZCU106ConfigREVERT
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),listpref6alb256corrmednobwslowcomplete39initialrqtnoswaitdisableprefexactlysamenol2finalrevert)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref6ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitDISABLEPREFExactlySameNoL2FinalRocketZCU106ConfigREVERT
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),listpref7alb256corrmednobwslowcomplete39initialrqtnoswaitrptlookuponlyexactlysamenol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTLOOKUPONLYExactlySameNoL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),listpref7alb256corrmednobwslowcomplete39initialrqtnoswaitrptdisableredundchecksexactlysamenol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTDISABLEREDUNDCHECKSExactlySameNoL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),listpref7alb256corrmednobwslowcomplete39exactlysamenol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256CorrectMedNoBwslowdownComplete39ExactlySameNoL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),listpref7alb256corrmednobwslowcomplete39initialrqtnoswaitrpt8xsystembusexactlysamenol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPT8xSYSTEMBUSExactlySameNoL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),listpref7alb256corrmednobwslowcomplete39initialrqtnoswaitrptclosetoslowexactlysamenol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTCLOSERTOSLOWExactlySameNoL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# ------------------------------------------------------------------------------------------------------------------------------------------

# Cores only ---------------------------------------------------------------------------------------------------------------------------

# Small -----------------------------------------------

ifeq ($(SUB_PROJECT),corrmednobwslowdown1way1dtlb1mshrexactsamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= CorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# Medium  -----------------------------------------------

ifeq ($(SUB_PROJECT),corrmednobwslowdownfinalexactsamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= CorrectMedNoBwslowdownFinalExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# Big    -----------------------------------------------

ifeq ($(SUB_PROJECT),corrmednobwslowdown8way16dtlb16mshrexactsamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# Big    -----------------------------------------------
# Perf Counters
ifeq ($(SUB_PROJECT),corrmednobwslowdown8way16dtlb16mshrexactsamenol2perf)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= CorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# List Prefetcher + Cores ----------------------------------------------------------------------------------------------------------------

# Small -----------------------------------------------

# 256 tagIDs
ifeq ($(SUB_PROJECT),listpref7alb256initialrqtnoswaitrptcorrmednobwslow1way1dtlb1mshrexactlysamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialrqtnoswaitrptcorrmednobwslow1way1dtlb1mshrexactlysamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow1way1dtlbset1mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow1way1dtlbset1mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#-----------------With L2

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialrqtnoswaitrptcorrmednobwslow1way1dtlb1mshrexactlysamewithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameWithL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow1way1dtlbset1mshrwithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow1way1dtlbset1mshrwithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRWithL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#-----------------No RQT

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialnorqtnoswaitrptcorrmednobwslow1way1dtlb1mshrexactlysamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown1Way1DTLBSet1MSHRExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialnorqtnoswaitrptexactsamecorrmednobwslow1way1dtlbset1mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialnorqtnoswaitrptexactsamecorrmednobwslow1way1dtlbset1mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown1Way1DTLBSet1MSHRNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# Medium  -----------------------------------------------

# 256 tagIDs
# Granul 7
ifeq ($(SUB_PROJECT),listpref7alb256corrmednobwslowcomplete39initialrqtnoswaitrptexactlysamenol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#CORRECTED VERSION
# Granul 7
ifeq ($(SUB_PROJECT),listpref7alb256mapupdateinitialrqtnoswaitrptexactlysamecorrmednobwslownol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#CORRECTED VERSION
# Granul 6
ifeq ($(SUB_PROJECT),listpref6alb256mapupdateinitialrqtnoswaitrptexactlysamecorrmednobwslownol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref6ALB256MAPUPDATEInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256corrmednobwslowcomplete39initialrqtnoswaitrptexactlysamenol2final)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameNoL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 7
ifeq ($(SUB_PROJECT),listpref7alb5122048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslowfinalnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslowfinalnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256 
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslowfinalnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#-----------------With L2

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT), listpref8alb256initialrqtnoswaitrptcorrmednobwslowfinalexactlysamewithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256CorrectMedNoBwslowdownComplete39InitialRqtNoswaitRPTExactlySameWithL2FinalRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslowfinalwithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketZCU106Config 
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslowfinalwithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalWithL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#-----------------No RQT

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialnorqtnoswaitrptcorrmednobwslowfinalexactlysamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdownFinalExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialnorqtnoswaitrptexactsamecorrmednobwslowfinalnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialnorqtnoswaitrptexactsamecorrmednobwslowfinalnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdownFinalNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# Big    -----------------------------------------------

# 256 tagIDs
ifeq ($(SUB_PROJECT),listpref7alb256initialrqtnoswaitrptcorrmednobwslow8way16dtlb16mshrexactlysamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref7ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialrqtnoswaitrptcorrmednobwslow8way16dtlb16mshrexactlysamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# PERF COUNTERS
# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialrqtnoswaitrptcorrmednobwslow8way16dtlb16mshrexactlysamenol2perf)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameNoL2PERFRocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow8way16dtlbset16mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow8way16dtlbset16mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#-----------------With L2

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialrqtnoswaitrptcorrmednobwslow8way16dtlbsets16mshrsexactlysamewithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRExactlySameWithL2RocketZCU106Config
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow8way16dtlbsets16mshrswithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketZCU106Config 
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialrqtnoswaitrptexactsamecorrmednobwslow8way16dtlbsets16mshrswithl2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRWithL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

#-----------------No RQT

# 256 tagIDs
# Granul 8
ifeq ($(SUB_PROJECT),listpref8alb256initialnorqtnoswaitrptcorrmednobwslow8way16dtlb16mshrexactlysamenol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB256InitialNoRqtNoswaitRPTCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 512
ifeq ($(SUB_PROJECT),listpref8alb5122048x11cyclerdlatencynoreninitialnorqtnoswaitrptexactsamecorrmednobwslow8way16dtlbset16mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB5122048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# 2048 tagIDs
# Granul 8
# ALB 256
ifeq ($(SUB_PROJECT),listpref8alb2562048x11cyclerdlatencynoreninitialnorqtnoswaitrptexactsamecorrmednobwslow8way16dtlbset16mshrnol2)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= ListPref8ALB2562048X11CycleRDLatencyNorenInitialNoRqtNoswaitRPTExactlySameCorrectMedNoBwslowdown8Way16DTLBSets16MSHRsNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# Only MetaSys Intruction Implementation Module + Cores ----------------------------------------------------------------------------------------------------------

# Medium -----------------------------------------------
# 2048 tagIDs
ifeq ($(SUB_PROJECT),atomaddressmapcontr2048x11cyclerdlatencynorencorrmednobwslowfinalexactsamenol2zcu106)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= ZCU106FPGATestHarness
	VLOG_MODEL        ?= ZCU106FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.zcu106
	CONFIG            ?= AtomAddressMapController2048X11CycleRDLatencyNorenCorrectMedNoBwslowdownFinalExactlySameNoL2RocketZCU106Config
	CONFIG_PACKAGE    ?= chipyard.fpga.zcu106
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= zcu106
	FPGA_BRAND        ?= xilinx
endif

# ------------------------------------------------------------------------------------------------------------------------------------------

ifeq ($(SUB_PROJECT),bringup)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= BringupVCU118FPGATestHarness
	VLOG_MODEL        ?= BringupVCU118FPGATestHarness
	MODEL_PACKAGE     ?= chipyard.fpga.vcu118.bringup
	CONFIG            ?= RocketBringupConfig
	CONFIG_PACKAGE    ?= chipyard.fpga.vcu118.bringup
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= vcu118
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),nexysvideo)
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= NexysVideoHarness
	VLOG_MODEL        ?= NexysVideoHarness
	MODEL_PACKAGE     ?= chipyard.fpga.nexysvideo
	CONFIG            ?= RocketNexysVideoConfig
	CONFIG_PACKAGE    ?= chipyard.fpga.nexysvideo
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= nexys_video
	FPGA_BRAND        ?= xilinx
endif

ifeq ($(SUB_PROJECT),arty35t)
	# TODO: Fix with Arty
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= Arty35THarness
	VLOG_MODEL        ?= Arty35THarness
	MODEL_PACKAGE     ?= chipyard.fpga.arty
	CONFIG            ?= TinyRocketArtyConfig
	CONFIG_PACKAGE    ?= chipyard.fpga.arty
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= arty
	FPGA_BRAND        ?= xilinx
endif
ifeq ($(SUB_PROJECT),arty100t)
	# TODO: Fix with Arty
	SBT_PROJECT       ?= fpga_platforms
	MODEL             ?= Arty100THarness
	VLOG_MODEL        ?= Arty100THarness
	MODEL_PACKAGE     ?= chipyard.fpga.arty100t
	CONFIG            ?= RocketArty100TConfig
	CONFIG_PACKAGE    ?= chipyard.fpga.arty100t
	GENERATOR_PACKAGE ?= chipyard
	TB                ?= none # unused
	TOP               ?= ChipTop
	BOARD             ?= arty_a7_100
	FPGA_BRAND        ?= xilinx
endif

include $(base_dir)/variables.mk

# default variables to build the arty example
# setup the board to use

.PHONY: default
default: $(mcs)

#########################################################################################
# misc. directories
#########################################################################################
fpga_dir := $(base_dir)/fpga/fpga-shells/$(FPGA_BRAND)
fpga_common_script_dir := $(fpga_dir)/common/tcl

#########################################################################################
# setup misc. sim files
#########################################################################################
# copy files but ignore *.h files in *.f (match vcs)
$(sim_files): $(SIM_FILE_REQS) $(ALL_MODS_FILELIST) | $(GEN_COLLATERAL_DIR)
	-cp -f $(SIM_FILE_REQS) $(GEN_COLLATERAL_DIR)
	touch $@
	$(foreach file,\
		$(SIM_FILE_REQS),\
		$(if $(filter %.h,$(file)),\
			,\
			echo "$(addprefix $(GEN_COLLATERAL_DIR)/, $(notdir $(file)))" >> $@;))

#########################################################################################
# import other necessary rules and variables
#########################################################################################
include $(base_dir)/common.mk

#########################################################################################
# copy from other directory
#########################################################################################
all_vsrcs := \
	$(base_dir)/generators/rocket-chip-blocks/vsrc/SRLatch.v

#########################################################################################
# vivado rules
#########################################################################################
# combine all sources into single .f
synth_list_f := $(build_dir)/$(long_name).vsrcs.f
$(synth_list_f): $(sim_common_files) $(all_vsrcs)
	$(foreach file,$(all_vsrcs),echo "$(file)" >> $@;)
	cat $(sim_common_files) >> $@

BIT_FILE := $(build_dir)/obj/$(MODEL).bit
$(BIT_FILE): $(synth_list_f)
	cd $(build_dir);# ulimit \
		# -m 8388608 \
		# -v 8388608 &&\
		vivado \
		-nojournal -mode batch \
		-source $(fpga_common_script_dir)/vivado.tcl \
		-tclargs \
			-top-module "$(MODEL)" \
			-F "$(synth_list_f)" \
			-board "$(BOARD)" \
			-ip-vivado-tcls "$(shell find '$(build_dir)' -name '*.vivado.tcl')"

.PHONY: bitstream
bitstream: $(BIT_FILE)

.PHONY: debug-bitstream
debug-bitstream: $(build_dir)/obj/post_synth.dcp
	cd $(build_dir); vivado \
		-nojournal -mode batch \
		-source $(sim_dir)/scripts/run_impl_bitstream.tcl \
		-tclargs \
			$(build_dir)/obj/post_synth.dcp \
			$(BOARD) \
			$(build_dir)/debug_obj \
			$(fpga_common_script_dir)

#########################################################################################
# general cleanup rules
#########################################################################################
.PHONY: clean
clean:
	rm -rf $(gen_dir)
