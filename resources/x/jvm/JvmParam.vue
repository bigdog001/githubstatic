<template>
  <div style="margin-top: 5px">
    <!-- <el-checkbox v-model="checked3" label="Option1" border size="medium"></el-checkbox> -->

    <el-checkbox
      v-for="param in boollParams"
      :label="param"
      :key="param"
      border
      size="medium"
      style="margin-top:10px"
      @change="handleBool">{{ param }}</el-checkbox>
 
      <!-- <el-input-number v-for="(ke) in bossParams" :key="ke.id"  v-model="num" size="mini"  controls-position="right">{{ ke }}</el-input-number> -->
      
        <el-col v-for="(ke) in bossParams" :key="ke.id"  :span="5" style="margin-top:20px">
          <div class="sub-title">{{ke}}</div>
          <el-input-number :label="ke" size="large"
          :controls=false
          :placeholder="ke"
          @blur="handleChange"
           ></el-input-number>
        </el-col>
     




        <div><el-input @blur="handleStrChange" placeholder="CompileCommand"  v-model="CompileCommand" style="margin-top:20px"><template slot="prepend">CompileCommand</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="CompileOnly"  v-model="CompileOnly" style="margin-top:20px"><template slot="prepend">CompileOnly</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="OnError"  v-model="OnError" style="margin-top:20px"><template slot="prepend">OnError</template></el-input></div>
        <div><el-input @blur="handleStrChange"  placeholder="OnOutOfMemoryError"  v-model="OnOutOfMemoryError" style="margin-top:20px"><template slot="prepend">OnOutOfMemoryError</template></el-input></div>

        <div><el-input @blur="handleStrChange"  placeholder="CompileCommandFile"  v-model="CompileCommandFile" style="margin-top:20px"><template slot="prepend">CompileCommandFile</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="DumpLoadedClassList"  v-model="DumpLoadedClassList" style="margin-top:20px"><template slot="prepend">DumpLoadedClassList</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="ErrorFile"  v-model="ErrorFile" style="margin-top:20px"><template slot="prepend">ErrorFile</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="ErrorReportServer"  v-model="ErrorReportServer" style="margin-top:20px"><template slot="prepend">ErrorReportServer</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="ExtraSharedClassListFile"  v-model="ExtraSharedClassListFile" style="margin-top:20px"><template slot="prepend">ExtraSharedClassListFile</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="FlightRecorderOptions"  v-model="FlightRecorderOptions" style="margin-top:20px"><template slot="prepend">FlightRecorderOptions</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="HeapDumpPath"  v-model="HeapDumpPath" style="margin-top:20px"><template slot="prepend">HeapDumpPath</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="TraceJVMTI"  v-model="TraceJVMTI" style="margin-top:20px"><template slot="prepend">TraceJVMTI</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="ReplayDataFile"  v-model="ReplayDataFile" style="margin-top:20px"><template slot="prepend">ReplayDataFile</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="SyncKnobs"  v-model="SyncKnobs" style="margin-top:20px"><template slot="prepend">SyncKnobs</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="SharedClassListFile"  v-model="SharedClassListFile" style="margin-top:20px"><template slot="prepend">SharedClassListFile</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="PerfDataSaveFile"  v-model="PerfDataSaveFile" style="margin-top:20px"><template slot="prepend">PerfDataSaveFile</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="NativeMemoryTracking"  v-model="NativeMemoryTracking" style="margin-top:20px"><template slot="prepend">NativeMemoryTracking</template></el-input></div>
        <div><el-input  @blur="handleStrChange" placeholder="InlineDataFile"  v-model="InlineDataFile" style="margin-bottom:50px;margin-top:20px"><template slot="prepend">InlineDataFile</template></el-input></div>





  </div>

</template>

<script>
//A:16,B:7,C:50,D:14,E:14,F:6,G:2,H:3,I:6,J:2,k:0,L:4,M:5,N:4,O:6,P:64,Q:0,R:17,S:9,T:23,U:111,V:3,W:0,X:0,Y:0,Z:1
//A:16,B:7,C:50,D:14,E:14,F:6,G:2,H:3,I:6,J:2,K:0,L:4,M:5,N:4,O:6,P:64,Q:0,R:17,S:9,T:23,U:111,V:3,W:0,X:0,Y:0,Z:1
const allBoolParams = ["AdjustConcurrency","AggressiveHeap","AggressiveOpts","AlignVector","AllowJNIEnvProxy","AllowNonVirtualCalls","AllowParallelDefineClass","AllowUserSignalHandlers","AlwaysActAsServerClassMachine","AlwaysCompileLoopMethods","AlwaysLockClassLoader","AlwaysPreTouch","AlwaysRestoreFPU","AlwaysTenure","AssertOnSuspendWaitFailure","AssumeMP","CheckEndorsedAndExtDirs","CheckJNICalls","ClassUnloading","ClassUnloadingWithConcurrentMark","ClipInlining","CollectGen0First","CompactFields","CompilerThreadHintNoPreempt","ConvertSleepToYield","ConvertYieldToSleep","CrashOnOutOfMemoryError","CreateMinidumpOnCrash","CriticalJNINatives","DTraceAllocProbes","DTraceMethodProbes","DTraceMonitorProbes","Debugging","BackgroundCompilation","BindGCTaskThreadsToCPUs","BlockLayoutByFrequency","BlockLayoutRotateLoops","BranchOnRegister","BytecodeVerificationLocal","BytecodeVerificationRemote","C1OptimizeVirtualCallProfiling","C1ProfileBranches","C1ProfileCalls","C1ProfileCheckcasts","C1ProfileInlinedCalls","C1ProfileVirtualCalls","C1UpdateMethodData","CICompilerCountPerCPU","CITime","CMSAbortSemantics","CMSClassUnloadingEnabled","CMSCleanOnEnter","CMSCompactWhenClearAllSoftRefs","CMSConcurrentMTEnabled","CMSDumpAtPromotionFailure","CMSEdenChunksRecordAlways","CMSExtrapolateSweep","CMSIncrementalMode","CMSIncrementalPacing","CMSLoopWarn","CMSOldPLABResizeQuicker","CMSPLABRecordAlways","CMSParallelInitialMarkEnabled","CMSParallelRemarkEnabled","CMSParallelSurvivorRemarkEnabled","CMSPrecleanRefLists1","CMSPrecleanRefLists2","CMSPrecleanSurvivors1","CMSPrecleanSurvivors2","CMSPrecleaningEnabled","CMSPrintChunksInDump","CMSPrintEdenSurvivorChunks","CMSPrintObjectsInDump","CMSReplenishIntermediate","CMSScavengeBeforeRemark","CMSSplitIndexedFreeListBlocks","CMSYield","DeoptimizeRandom","DisableAttachMechanism","DisableExplicitGC","DisplayVMOutputToStderr","DisplayVMOutputToStdout","DoEscapeAnalysis","DontCompileHugeMethods","DontYieldALot","DumpReplayDataOnError","DumpSharedSpaces","EagerXrunInit","EliminateAllocations","EliminateAutoBox","EliminateLocks","EliminateNestedLocks","EnableContended","EnableResourceManagementTLABCache","EnableSharedLookupCache","EnableTracing","EstimateArgEscape","ExitOnOutOfMemoryError","ExplicitGCInvokesConcurrent","ExplicitGCInvokesConcurrentAndUnloadsClasses","ExtendedDTraceProbes","FLSAlwaysCoalesceLarge","FailOverToOldVerifier","FastTLABRefill","FilterSpuriousWakeups","ForceNUMA","ForceTimeHighResolution","G1UseAdaptiveConcRefinement","GCLockerInvokesConcurrent","HeapDumpAfterFullGC","HeapDumpBeforeFullGC","HeapDumpOnOutOfMemoryError","UseSSE42Intrinsics","UseSerialGC","UseSharedSpaces","UseSignalChaining","UseSquareToLenIntrinsic","UseStoreImmI16","UseStringDeduplication","UseSuperWord","UseTLAB","UseThreadPriorities","UseTypeProfile","UseTypeSpeculation","UseUnalignedLoadStores","UseVMInterruptibleIO","UseXMMForArrayCopy","UseXmmI2D","UseXmmI2F","UseXmmLoadAndClearUpper","UseXmmRegToRegMoveAll","VMThreadHintNoPreempt","UseAdaptiveGCBoundary","UseAdaptiveGenerationSizePolicyAtMajorCollection","UseAdaptiveGenerationSizePolicyAtMinorCollection","UseAdaptiveNUMAChunkSizing","UseAdaptiveSizeDecayMajorGCCost","UseAdaptiveSizePolicy","UseAdaptiveSizePolicyFootprintGoal","UseAdaptiveSizePolicyWithSystemGC","UseAddressNop","UseAltSigs","UseAutoGCSelectPolicy","UseBMI1Instructions","UseBMI2Instructions","UseBiasedLocking","UseBimorphicInlining","UseBoundThreads","UseBsdPosixThreadCPUClocks","UseCLMUL","UseCMSBestFit","UseCMSCollectionPassing","UseCMSCompactAtFullCollection","UseCMSInitiatingOccupancyOnly","UseCRC32Intrinsics","UseCodeCacheFlushing","UseCompiler","UseCompilerSafepoints","UseCompressedClassPointers","UseCompressedOops","UseConcMarkSweepGC","UseCondCardMark","UseCountLeadingZerosInstruction","UseCountTrailingZerosInstruction","UseCountedLoopSafepoints","UseCounterDecay","UseDivMod","UseDynamicNumberOfGCThreads","UseFPUForSpilling","UseFastAccessorMethods","UseFastEmptyMethods","UseFastJNIAccessors","UseFastStosb","UseG1GC","UseGCLogFileRotation","UseGCOverheadLimit","UseGCTaskAffinity","UseHeavyMonitors","UseHugeTLBFS","UseInlineCaches","UseInterpreter","UseJumpTables","UseLWPSynchronization","UseLargePages","UseLargePagesInMetaspace","UseLargePagesIndividualAllocation","UseLockedTracing","UseLoopCounter","UseLoopInvariantCodeMotion","UseLoopPredicate","UseMathExactIntrinsics","UseMaximumCompactionOnSystemGC","UseMembar","UseMontgomeryMultiplyIntrinsic","UseMontgomerySquareIntrinsic","UseMulAddIntrinsic","UseMultiplyToLenIntrinsic","UseNUMA","UseNUMAInterleaving","UseNewLongLShift","UseOSErrorReporting","UseOldInlining","UseOnStackReplacement","UseOnlyInlinedBimorphic","UseOprofile","UseOptoBiasInlining","UsePSAdaptiveSurvivorSizePolicy","UseParNewGC","UseParallelGC","UseParallelOldGC","UsePerfData","UsePopCountInstruction","UseRDPCForConstantTableBase","UseRTMDeopt","UseRTMLocking","UseSHA","UseSHA1Intrinsics","UseSHA256Intrinsics","UseSHA512Intrinsics","UseSHM","UnlinkSymbolsALot","Use486InstrsOnly","UseAES","UseAESIntrinsics","TimeLinearScan","TraceBiasedLocking","TraceClassLoading","TraceClassLoadingPreorder","TraceClassPaths","TraceClassResolution","TraceClassUnloading","TraceDynamicGCThreads","TraceGen0Time","TraceGen1Time","PrintSharedArchiveAndExit","PrintSharedDictionary","PrintSharedSpaces","PrintStringDeduplicationStatistics","PrintStringTableStatistics","PrintTLAB","PrintTenuringDistribution","PrintTieredEvents","PrintVMOptions","PrintVMQWaitTime","PrintWarnings","PrintFlagsFinal","PrintFlagsInitial","PrintGC","PrintGCApplicationConcurrentTime","PrintGCApplicationStoppedTime","PrintGCCause","PrintGCDateStamps","PrintGCDetails","PrintGCID","PrintGCTaskTimeStamps","PrintGCTimeStamps","PrintHeapAtGC","PrintHeapAtGCExtended","PrintHeapAtSIGBREAK","PrintJNIGCStalls","PrintJNIResolving","PrintOldPLAB","PrintOopAddress","PrintPLAB","PrintParallelOldGCPhaseTimes","PrintPromotionFailure","PrintReferenceGC","PrintSafepointStatistics","PrintClassHistogram","PrintClassHistogramAfterFullGC","PrintClassHistogramBeforeFullGC","PrintCodeCache","PrintCodeCacheOnCompilation","PrintCommandLineFlags","PrintCompilation","PrintConcurrentLocks","ParallelRefProcBalancingEnabled","ParallelRefProcEnabled","PartialPeelAtUnsignedTests","PartialPeelLoop","OptimizeFill","OptimizePtrCompare","OptimizeStringConcat","OptoBundling","VerifyMergedCPBytecodes","VerifySharedSpaces","ZeroTLAB","TraceLoaderConstraints","TraceMetadataHumongousAllocation","TraceMonitorInflation","TraceParallelOldGCTasks","TraceSafepointCleanupTime","TraceSharedLookupCache","TraceSuspendWaitFailures","TransmitErrorReport","TrapBasedNullChecks","TrapBasedRangeChecks","TieredCompilation","ResizeOldPLAB","ResizePLAB","ResizeTLAB","RestoreMXCSROnJNICalls","RestrictContended","RewriteBytecodes","RewriteFrequentPairs","ReflectionWrapResolutionErrors","RegisterFinalizersAtInit","RelaxAccessControlCheck","RequireSharedSpaces","ReassociateInvariants","ReduceBulkZeroing","ReduceFieldZeroing","ReduceInitialCardMarks","ReduceSignalUsage","SafepointTimeout","ThreadPriorityVerbose","TLABStats","SuppressFatalErrorMessage","StressLdcRewrite","StartAttachListener","StackTraceInThrowable","SpecialEncodeISOArray","SplitIfBlocks","ShowMessageBoxOnError","RangeCheckElimination","ScavengeBeforeFullGC","ProfileVM","ProfilerPrintByteCodeStatistics","ProfilerRecordPC","ProfileInterpreter","ProfileIntervals","PrintAdaptiveSizePolicy","PrintCMSInitiationStatistics","PreserveAllAnnotations","PreserveFramePointer","PreferInterpreterNativeStubs","PerfDataSaveToFile","PerfDisableSharedMem","PerfAllowAtExitRegistration","PerfBypassFileSystemCheck","ParallelGCVerbose","ParGCTrimOverflow","ParGCUseLocalOverflow","PSChunkLargeArrays","OptoScheduling","OmitStackTraceInFastThrow","NeedsDeoptSuspend","NeverActAsServerClassMachine","NeverTenure","NUMAStats","MustCallLoadClassInternal","MonitorInUseLists","MethodFlushing","MaxFDLimit","LoopUnswitching","ManagementServer","LogCommercialFeatures","LazyBootClassLoader","LIRFillDelaySlots","JNIDetachReleasesMonitors","JavaMonitorsInStackTrace","InlineSynchronizedMethods","InsertMemBarAfterArraycopy","Inline","IgnoreEmptyClassPaths","IgnoreUnrecognizedVMOptions","IncrementalInline"];

//C:4,E:1,F:1,G:1,M:2,I:1
const allDoubleParams =["CMSLargeCoalSurplusPercent","CMSLargeSplitSurplusPercent","CMSSmallCoalSurplusPercent","CMSSmallSplitSurplusPercent","EscapeAnalysisTimeout","FLSLargestBlockCoalesceProximity","G1ConcMarkStepDurationMillis","MinRAMPercentage","MaxRAMPercentage","InitialRAMPercentage"];

//A:9,B:7,C:13,D:3,E:2,F:3,G:11,H:0,I:3,J:10,K:0,L:5,M:18,N:5,O:3,P:20,Q:0,R:2,S:13,T:34,U:3,V:5,W:1,X:0,Y:0,Z:0
const allIntxParam=["ActiveProcessorCount","AliasLevel","AllocateInstancePrefetchLines","AllocatePrefetchDistance","AllocatePrefetchInstr","AllocatePrefetchLines","AllocatePrefetchStepSize","AllocatePrefetchStyle","ClearFPUAtPark","CMSTriggerInterval","CMSWaitDuration","CompilationPolicyChoice","CompileThreshold","CompilerThreadPriority","CompilerThreadStackSize","AutoBoxCacheMax","BCEATraceLevel","BackEdgeThreshold","BiasedLockingBulkRebiasThreshold","BiasedLockingBulkRevokeThreshold","BiasedLockingDecayTime","BiasedLockingStartupDelay","BlockLayoutMinDiamondPercentage","CICompilerCount","CMSInitiatingOccupancyFraction","CMSAbortablePrecleanWaitMillis","CMSMaxAbortablePrecleanTime","ConditionalMoveLimit","ContendedPaddingWidth","DefaultThreadPriority","DeferPollingPageLoopCount","DeferThrSuspendLoopCount","EliminateAllocationArraySizeLimit","EmitSync","FenceInstruction","FieldsAllocationStyle","FreqInlineSize","G1ConcRefinementGreenZone","G1ConcRefinementRedZone","G1ConcRefinementServiceIntervalMillis","G1ConcRefinementThresholdStep","G1ConcRefinementYellowZone","G1RSetRegionEntries","G1RSetSparseRegionEntries","G1RSetUpdatingPauseTimePercent","G1RefProcDrainInterval","G1SATBBufferSize","G1UpdateBufferSize","Tier0BackedgeNotifyFreqLog","Tier0InvokeNotifyFreqLog","Tier0ProfilingStartPercentage","Tier23InlineeNotifyFreqLog","Tier2BackEdgeThreshold","Tier2BackedgeNotifyFreqLog","Tier2CompileThreshold","Tier2InvokeNotifyFreqLog","Tier3BackEdgeThreshold","Tier3BackedgeNotifyFreqLog","Tier3CompileThreshold","Tier3DelayOff","Tier3DelayOn","Tier3InvocationThreshold","Tier3InvokeNotifyFreqLog","Tier3LoadFeedback","Tier3MinInvocationThreshold","Tier4BackEdgeThreshold","Tier4CompileThreshold","Tier4InvocationThreshold","Tier4LoadFeedback","Tier4MinInvocationThreshold","NmethodSweepActivity","NmethodSweepCheckInterval","NmethodSweepFraction","NodeLimitFudgeFactor","hashCode","TypeProfileMajorReceiverPercent","TypeProfileParmsLimit","TypeProfileWidth","UnguardOnExecutionViolation","UseAVX","UseSSE","VMThreadPriority","VMThreadStackSize","ValueMapInitialSize","ValueMapMaxLoopSize","ValueSearchLimit","WorkAroundNPTLTimedWaitHang","TypeProfileArgsLimit","TraceRedefineClasses","TrackedInitializationLimit","TieredCompileTaskTimeout","TieredRateUpdateMaxTime","TieredRateUpdateMinTime","TieredStopAtLevel","RefDiscoveryPolicy","SafepointPollOffset","SafepointSpinBeforeYield","ReadPrefetchInstr","SafepointTimeoutDelay","ThreadStackSize","ThreadPriorityPolicy","SyncVerbose","SuspendRetryCount","SuspendRetryDelay","SyncFlags","StarvationMonitorInterval","StackYellowPages","SoftRefLRUPolicyMSPerMB","SelfDestructTimer","ProfileIntervalsTicks","ProfileMaturityPercentage","PrintCMSStatistics","PrintFLSCensus","PrintFLSStatistics","PrintSafepointStatisticsCount","PrintSafepointStatisticsTimeout","PrefetchCopyIntervalInBytes","PrefetchFieldsAhead","PrefetchScanIntervalInBytes","PerfMaxStringConstLength","PreInflateSpin","PerfDataMemorySize","PerfDataSamplingInterval","PerBytecodeRecompilationCutoff","PerBytecodeTrapLimit","PerMethodRecompilationCutoff","PerMethodTrapLimit","PartialPeelNewPhiDelta","ParGCArrayScanChunk","OnStackReplacePercentage","OptoLoopAlignment","NumberOfLoopInstrToAlign","ObjectAlignmentInBytes","MultiArrayExpandLimit","MonitorBound","MinInliningThreshold","MinJumpTableSize","MaxTrivialSize","MaxVectorSize","MaxRecursiveInlineLevel","MaxInlineLevel","MaxInlineSize","MaxJNILocalCapacity","MaxJavaStackTraceDepth","MaxJumpTableSize","MaxJumpTableSparseness","MaxLabelRootDepth","MaxLoopPad","MaxNodeLimit","MaxBCEAEstimateLevel","MaxBCEAEstimateSize","LoopMaxUnroll","LoopOptsCount","LoopUnrollLimit","LoopUnrollMin","LiveNodeCountInliningCutoff","JavaPriority10_To_OSPriority","JavaPriority1_To_OSPriority","JavaPriority2_To_OSPriority","JavaPriority3_To_OSPriority","JavaPriority4_To_OSPriority","JavaPriority5_To_OSPriority","JavaPriority6_To_OSPriority","JavaPriority7_To_OSPriority","JavaPriority8_To_OSPriority","JavaPriority9_To_OSPriority","InteriorEntryAlignment","InterpreterProfilePercentage","InlineSmallCode","StackRedPages","StackShadowPages"];


const allUint64Param=["MaxRAM"];

// A:10,B:1,C:44,D:1,E:1,F:1,G:18,H:4,I:8,J:0,K:0,L:2,M:23,N:8,O:3,P:10,Q:1,R:2,S:9,T:13,U:0,V:0,W:0,X:0,Y:4,Z:0
const allUintxParam=["AdaptiveSizeDecrementScaleFactor","AdaptiveSizeMajorGCDecayTimeScale","AdaptiveSizePausePolicy","AdaptiveSizePolicyCollectionCostMargin","AdaptiveSizePolicyInitializingSteps","AdaptiveSizePolicyOutputInterval","AdaptiveSizePolicyWeight","AdaptiveSizeThroughPutPolicy","AdaptiveTimeWeight","AutoGCSelectPauseMillis","BaseFootPrintEstimate","CMSAbortablePrecleanMinWorkPerIteration","CMSBitMapYieldQuantum","CMSBootstrapOccupancy","CMSClassUnloadingMaxInterval","CMSConcMarkMultiple","CMSCoordinatorYieldSleepCount","CMSExpAvgFactor","CMSFullGCsBeforeCompaction","CMSIncrementalDutyCycle","CMSIncrementalDutyCycleMin","CMSIncrementalOffset","CMSIncrementalSafetyFactor","CMSIndexedFreeListReplenish","CMSIsTooFullPercentage","CMSMaxAbortablePrecleanLoops","CMSOldPLABMax","CMSOldPLABMin","CMSOldPLABNumRefills","CMSOldPLABReactivityFactor","CMSOldPLABToleranceFactor","CMSParPromoteBlocksToClaim","CMSPrecleanDenominator","CMSPrecleanIter","CMSPrecleanNumerator","CMSPrecleanThreshold","CMSRemarkVerifyVariant","CMSRescanMultiple","CMSSamplingGrain","CMSScheduleRemarkEdenPenetration","CMSScheduleRemarkEdenSizeThreshold","CMSScheduleRemarkSamplingRatio","CMSTriggerRatio","CMSWorkQueueDrainThreshold","CMSYieldSleepCount","CMSYoungGenPerWorker","CMS_FLSPadding","CMS_FLSWeight","CMS_SweepPadding","CMS_SweepTimerThresholdMillis","CMS_SweepWeight","CodeCacheExpansionSize","CodeCacheMinimumFreeSpace","CompressedClassSpaceSize","ConcGCThreads","DefaultMaxRAMFraction","ErgoHeapSizeLimit","FLSCoalescePolicy","G1ConcRSHotCardLimit","G1ConcRSLogCacheSize","G1ConcRefinementThreads","G1ConfidencePercent","G1HeapRegionSize","G1HeapWastePercent","G1MixedGCCountTarget","G1RSetScanBlockSize","G1ReservePercent","G1SATBBufferEnqueueingThresholdPercent","GCDrainStackTargetSize","GCHeapFreeLimit","GCLockerEdenExpansionPercent","GCLogFileSize","GCPauseIntervalMillis","GCTaskTimeStampEntries","GCTimeLimit","GCTimeRatio","HeapBaseMinAddress","HeapFirstMaximumCompactionCount","HeapMaximumCompactionInterval","HeapSizePerGCThread","TLABWasteIncrement","TLABWasteTargetPercent","TargetPLABWastePct","TargetSurvivorRatio","TenuredGenerationSizeIncrement","TenuredGenerationSizeSupplement","TenuredGenerationSizeSupplementDecay","TypeProfileLevel","YoungGenerationSizeIncrement","YoungGenerationSizeSupplement","YoungGenerationSizeSupplementDecay","YoungPLABSize","ReservedCodeCacheSize","ThreadSafetyMargin","ThresholdTolerance","TLABAllocationWeight","TLABRefillWasteFraction","TLABSize","SurvivorPadding","SurvivorRatio","StringDeduplicationAgeThreshold","StringTableSize","SharedMiscCodeSize","SharedMiscDataSize","SharedReadOnlySize","SharedReadWriteSize","SharedBaseAddress","PromotedPadding","QueuedAllocationWarningCount","RTMRetryCount","ProcessDistributionStride","PretenureSizeThreshold","ParallelOldDeadWoodLimiterMean","ParallelOldDeadWoodLimiterStdDev","PausePadding","ParallelGCBufferWastePct","ParallelGCThreads","ParGCDesiredObjsFromOverflowList","PLABWeight","OldPLABSize","OldPLABWeight","OldSize","NewRatio","NewSize","NewSizeThreadIncrease","NumberOfGCLogFiles","NUMAChunkResizeWeight","NUMAInterleaveGranularity","NUMAPageScanRate","NUMASpaceResizeRate","MinSurvivorRatio","MinTLABSize","MinMetaspaceExpansion","MinMetaspaceFreeRatio","MinRAMFraction","MinHeapDeltaBytes","MinHeapFreeRatio","MetaspaceSize","MaxTenuringThreshold","MaxGCMinorPauseMillis","MaxGCPauseMillis","MaxHeapFreeRatio","MaxHeapSize","MaxMetaspaceExpansion","MaxMetaspaceFreeRatio","MaxMetaspaceSize","MaxNewSize","MaxRAMFraction","MaxDirectMemorySize","MarkStackSize","MarkStackSizeMax","MarkSweepAlwaysCompactCount","MarkSweepDeadRatio","LargePageHeapSizeThreshold","LargePageSizeInBytes","InitialSurvivorRatio","InitialTenuringThreshold","InitiatingHeapOccupancyPercent","InitialBootClassLoaderMetaspaceSize","InitialCodeCacheSize","InitialHeapSize","InitialRAMFraction","IncreaseFirstTierCompileThresholdAt"];

//C:1,D:1,E:3,F:1,H:1,T:1,R:1,S:2,P:1,N:1,I:1
//Note that after parsing the commands passed on the command line using the -XX:CompileCommand options, the JIT compiler then reads commands from the .hotspot_compiler file. You can add commands to this file or specify a different file using the -XX:CompileCommandFile option.
//java -XX:DumpLoadedClassList=/tmp/classes.lst #使用XX:DumpLoadedClassList来生成应用程序加载class的列表
//-XX:ErrorFile=targetDir/hs_err_pid_%p.log

//java -cp hello.jar -Xshare:dump -XX:SharedArchiveFile=base.jsa -XX:ExtraSharedClassListFile=mylist Hello
//-XX:FlightRecorderOptions=defaultrecording=true,dumponexit=true,dumponexitpath=path,loglevel=debug
//java -Xms512M -Xmx512M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/usr/local/log/ 


//-XX:SharedClassListFile=hello.lst 
//-XX:PerfDataSaveFile ：指定保存PerfData文件的路径
//-XX:NativeMemoryTracking=[off | summary | detail]  #off: 默认关闭,打开NMT会带来5%-10%的性能损耗。
// -XX:InlineDataFile=inline_pid12345.txt

const allCcstrParam=["CompileCommandFile","DumpLoadedClassList","ErrorFile","ErrorReportServer","ExtraSharedClassListFile",
"FlightRecorderOptions","HeapDumpPath","TraceJVMTI","ReplayDataFile","SyncKnobs","SharedClassListFile","PerfDataSaveFile",
"NativeMemoryTracking","InlineDataFile"];

//C:2,O:2
//-XX:CompileCommand=exclude,com/jvmpocket/Dummy.test   #设置编译器跳过编译com.jvmpocket.Dummy类test方法的4种写法
//-XX:CompileOnly=java/lang/String.length,java/util/List.size  #Sets the list of methods (separated by commas) to which compilation should be restricted. Only the specified methods will be compiled.
//-XX:OnError="gcore %p;dbx - %p"
//-XX:OnOutOfMemoryError="kill -9 %p"
const allCcstrlistParam=["CompileCommand","CompileOnly","OnError","OnOutOfMemoryError"];

//const BossVars = allDoubleParams.concat( allIntxParam).concat(allUint64Param).concat(allUintxParam).concat(allCcstrParam).concat(allCcstrlistParam);


const BossVars = ["CMSLargeCoalSurplusPercent","CMSLargeSplitSurplusPercent","CMSSmallCoalSurplusPercent","CMSSmallSplitSurplusPercent","EscapeAnalysisTimeout","FLSLargestBlockCoalesceProximity","G1ConcMarkStepDurationMillis","MinRAMPercentage","MaxRAMPercentage","InitialRAMPercentage","ActiveProcessorCount","AliasLevel","AllocateInstancePrefetchLines","AllocatePrefetchDistance","AllocatePrefetchInstr","AllocatePrefetchLines","AllocatePrefetchStepSize","AllocatePrefetchStyle","ClearFPUAtPark","CMSTriggerInterval","CMSWaitDuration","CompilationPolicyChoice","CompileThreshold","CompilerThreadPriority","CompilerThreadStackSize","AutoBoxCacheMax","BCEATraceLevel","BackEdgeThreshold","BiasedLockingBulkRebiasThreshold","BiasedLockingBulkRevokeThreshold","BiasedLockingDecayTime","BiasedLockingStartupDelay","BlockLayoutMinDiamondPercentage","CICompilerCount","CMSInitiatingOccupancyFraction","CMSAbortablePrecleanWaitMillis","CMSMaxAbortablePrecleanTime","ConditionalMoveLimit","ContendedPaddingWidth","DefaultThreadPriority","DeferPollingPageLoopCount","DeferThrSuspendLoopCount","EliminateAllocationArraySizeLimit","EmitSync","FenceInstruction","FieldsAllocationStyle","FreqInlineSize","G1ConcRefinementGreenZone","G1ConcRefinementRedZone","G1ConcRefinementServiceIntervalMillis","G1ConcRefinementThresholdStep","G1ConcRefinementYellowZone","G1RSetRegionEntries","G1RSetSparseRegionEntries","G1RSetUpdatingPauseTimePercent","G1RefProcDrainInterval","G1SATBBufferSize","G1UpdateBufferSize","Tier0BackedgeNotifyFreqLog","Tier0InvokeNotifyFreqLog","Tier0ProfilingStartPercentage","Tier23InlineeNotifyFreqLog","Tier2BackEdgeThreshold","Tier2BackedgeNotifyFreqLog","Tier2CompileThreshold","Tier2InvokeNotifyFreqLog","Tier3BackEdgeThreshold","Tier3BackedgeNotifyFreqLog","Tier3CompileThreshold","Tier3DelayOff","Tier3DelayOn","Tier3InvocationThreshold","Tier3InvokeNotifyFreqLog","Tier3LoadFeedback","Tier3MinInvocationThreshold","Tier4BackEdgeThreshold","Tier4CompileThreshold","Tier4InvocationThreshold","Tier4LoadFeedback","Tier4MinInvocationThreshold","NmethodSweepActivity","NmethodSweepCheckInterval","NmethodSweepFraction","NodeLimitFudgeFactor","hashCode","TypeProfileMajorReceiverPercent","TypeProfileParmsLimit","TypeProfileWidth","UnguardOnExecutionViolation","UseAVX","UseSSE","VMThreadPriority","VMThreadStackSize","ValueMapInitialSize","ValueMapMaxLoopSize","ValueSearchLimit","WorkAroundNPTLTimedWaitHang","TypeProfileArgsLimit","TraceRedefineClasses","TrackedInitializationLimit","TieredCompileTaskTimeout","TieredRateUpdateMaxTime","TieredRateUpdateMinTime","TieredStopAtLevel","RefDiscoveryPolicy","SafepointPollOffset","SafepointSpinBeforeYield","ReadPrefetchInstr","SafepointTimeoutDelay","ThreadStackSize","ThreadPriorityPolicy","SyncVerbose","SuspendRetryCount","SuspendRetryDelay","SyncFlags","StarvationMonitorInterval","StackYellowPages","SoftRefLRUPolicyMSPerMB","SelfDestructTimer","ProfileIntervalsTicks","ProfileMaturityPercentage","PrintCMSStatistics","PrintFLSCensus","PrintFLSStatistics","PrintSafepointStatisticsCount","PrintSafepointStatisticsTimeout","PrefetchCopyIntervalInBytes","PrefetchFieldsAhead","PrefetchScanIntervalInBytes","PerfMaxStringConstLength","PreInflateSpin","PerfDataMemorySize","PerfDataSamplingInterval","PerBytecodeRecompilationCutoff","PerBytecodeTrapLimit","PerMethodRecompilationCutoff","PerMethodTrapLimit","PartialPeelNewPhiDelta","ParGCArrayScanChunk","OnStackReplacePercentage","OptoLoopAlignment","NumberOfLoopInstrToAlign","ObjectAlignmentInBytes","MultiArrayExpandLimit","MonitorBound","MinInliningThreshold","MinJumpTableSize","MaxTrivialSize","MaxVectorSize","MaxRecursiveInlineLevel","MaxInlineLevel","MaxInlineSize","MaxJNILocalCapacity","MaxJavaStackTraceDepth","MaxJumpTableSize","MaxJumpTableSparseness","MaxLabelRootDepth","MaxLoopPad","MaxNodeLimit","MaxBCEAEstimateLevel","MaxBCEAEstimateSize","LoopMaxUnroll","LoopOptsCount","LoopUnrollLimit","LoopUnrollMin","LiveNodeCountInliningCutoff","JavaPriority10_To_OSPriority","JavaPriority1_To_OSPriority","JavaPriority2_To_OSPriority","JavaPriority3_To_OSPriority","JavaPriority4_To_OSPriority","JavaPriority5_To_OSPriority","JavaPriority6_To_OSPriority","JavaPriority7_To_OSPriority","JavaPriority8_To_OSPriority","JavaPriority9_To_OSPriority","InteriorEntryAlignment","InterpreterProfilePercentage","InlineSmallCode","StackRedPages","StackShadowPages","AdaptiveSizeDecrementScaleFactor","AdaptiveSizeMajorGCDecayTimeScale","AdaptiveSizePausePolicy","AdaptiveSizePolicyCollectionCostMargin","AdaptiveSizePolicyInitializingSteps","AdaptiveSizePolicyOutputInterval","AdaptiveSizePolicyWeight","AdaptiveSizeThroughPutPolicy","AdaptiveTimeWeight","AutoGCSelectPauseMillis","BaseFootPrintEstimate","CMSAbortablePrecleanMinWorkPerIteration","CMSBitMapYieldQuantum","CMSBootstrapOccupancy","CMSClassUnloadingMaxInterval","CMSConcMarkMultiple","CMSCoordinatorYieldSleepCount","CMSExpAvgFactor","CMSFullGCsBeforeCompaction","CMSIncrementalDutyCycle","CMSIncrementalDutyCycleMin","CMSIncrementalOffset","CMSIncrementalSafetyFactor","CMSIndexedFreeListReplenish","CMSIsTooFullPercentage","CMSMaxAbortablePrecleanLoops","CMSOldPLABMax","CMSOldPLABMin","CMSOldPLABNumRefills","CMSOldPLABReactivityFactor","CMSOldPLABToleranceFactor","CMSParPromoteBlocksToClaim","CMSPrecleanDenominator","CMSPrecleanIter","CMSPrecleanNumerator","CMSPrecleanThreshold","CMSRemarkVerifyVariant","CMSRescanMultiple","CMSSamplingGrain","CMSScheduleRemarkEdenPenetration","CMSScheduleRemarkEdenSizeThreshold","CMSScheduleRemarkSamplingRatio","CMSTriggerRatio","CMSWorkQueueDrainThreshold","CMSYieldSleepCount","CMSYoungGenPerWorker","CMS_FLSPadding","CMS_FLSWeight","CMS_SweepPadding","CMS_SweepTimerThresholdMillis","CMS_SweepWeight","CodeCacheExpansionSize","CodeCacheMinimumFreeSpace","CompressedClassSpaceSize","ConcGCThreads","DefaultMaxRAMFraction","ErgoHeapSizeLimit","FLSCoalescePolicy","G1ConcRSHotCardLimit","G1ConcRSLogCacheSize","G1ConcRefinementThreads","G1ConfidencePercent","G1HeapRegionSize","G1HeapWastePercent","G1MixedGCCountTarget","G1RSetScanBlockSize","G1ReservePercent","G1SATBBufferEnqueueingThresholdPercent","GCDrainStackTargetSize","GCHeapFreeLimit","GCLockerEdenExpansionPercent","GCLogFileSize","GCPauseIntervalMillis","GCTaskTimeStampEntries","GCTimeLimit","GCTimeRatio","HeapBaseMinAddress","HeapFirstMaximumCompactionCount","HeapMaximumCompactionInterval","HeapSizePerGCThread","TLABWasteIncrement","TLABWasteTargetPercent","TargetPLABWastePct","TargetSurvivorRatio","TenuredGenerationSizeIncrement","TenuredGenerationSizeSupplement","TenuredGenerationSizeSupplementDecay","TypeProfileLevel","YoungGenerationSizeIncrement","YoungGenerationSizeSupplement","YoungGenerationSizeSupplementDecay","YoungPLABSize","ReservedCodeCacheSize","ThreadSafetyMargin","ThresholdTolerance","TLABAllocationWeight","TLABRefillWasteFraction","TLABSize","SurvivorPadding","SurvivorRatio","StringDeduplicationAgeThreshold","StringTableSize","SharedMiscCodeSize","SharedMiscDataSize","SharedReadOnlySize","SharedReadWriteSize","SharedBaseAddress","PromotedPadding","QueuedAllocationWarningCount","RTMRetryCount","ProcessDistributionStride","PretenureSizeThreshold","ParallelOldDeadWoodLimiterMean","ParallelOldDeadWoodLimiterStdDev","PausePadding","ParallelGCBufferWastePct","ParallelGCThreads","ParGCDesiredObjsFromOverflowList","PLABWeight","OldPLABSize","OldPLABWeight","OldSize","NewRatio","NewSize","NewSizeThreadIncrease","NumberOfGCLogFiles","NUMAChunkResizeWeight","NUMAInterleaveGranularity","NUMAPageScanRate","NUMASpaceResizeRate","MinSurvivorRatio","MinTLABSize","MinMetaspaceExpansion","MinMetaspaceFreeRatio","MinRAMFraction","MinHeapDeltaBytes","MinHeapFreeRatio","MetaspaceSize","MaxTenuringThreshold","MaxGCMinorPauseMillis","MaxGCPauseMillis","MaxHeapFreeRatio","MaxHeapSize","MaxMetaspaceExpansion","MaxMetaspaceFreeRatio","MaxMetaspaceSize","MaxNewSize","MaxRAMFraction","MaxDirectMemorySize","MarkStackSize","MarkStackSizeMax","MarkSweepAlwaysCompactCount","MarkSweepDeadRatio","LargePageHeapSizeThreshold","LargePageSizeInBytes","InitialSurvivorRatio","InitialTenuringThreshold","InitiatingHeapOccupancyPercent","InitialBootClassLoaderMetaspaceSize","InitialCodeCacheSize","InitialHeapSize","InitialRAMFraction","IncreaseFirstTierCompileThresholdAt","MaxRAM"];




export default {
  name: "JvmParam",
  data() {
    return {
      checked1: true,
      checked2: false,
      checked3: false,
      checked4: true,
      checkboxGroup1: [],
      checkboxGroup2: [],
      boollParams: allBoolParams.sort(),
      bossParams: BossVars.sort(),
      num: 1,
      input1: '',
      OnOutOfMemoryError:'',
      OnError:'',
      CompileOnly:'',
      CompileCommand:'',
      CompileCommandFile:'', 
      DumpLoadedClassList:'', 
      ErrorFile:'', 
      ErrorReportServer:'', 
      ExtraSharedClassListFile:'',
      FlightRecorderOptions:'', 
      HeapDumpPath:'', 
      TraceJVMTI:'', 
      ReplayDataFile:'', 
      SyncKnobs:'', 
      SharedClassListFile:'', 
      PerfDataSaveFile:'',
      NativeMemoryTracking:'', 
      InlineDataFile :''
    };
  },methods: {
      handleStrChange(value) {
        //eval("x=10;y=20;document.write(x*y)")
        let nodeName = value.srcElement.attributes.placeholder.nodeValue;
        let valu_ = eval("this."+nodeName);
        if(valu_ === ''){
          console.log("null value ,give up!");
          return;
        }
        console.log(nodeName,valu_);

        let data_cpy_str = " -XX:"+nodeName+"="+valu_+" ";
         this.$copyText(data_cpy_str).then(()=> {
            console.log("复制成功"+data_cpy_str);
            this.$message('复制成功.');
        },()=> {
            console.log("复制失败了");
            this.$message('复制失败了.');
            }
        );

      },
      handleChange(value) {
        console.log(value);
        if(value.srcElement.ariaValueNow ==="undefined"){
          console.log("null value ,give up!");
          return;
        }
        console.log(value.srcElement.ariaValueNow,value.srcElement.ariaLabel);
        
        // -XX:G1HeapRegionSize=32m 
        let data_cpy_i = " -XX:"+value.srcElement.ariaLabel+"="+value.srcElement.ariaValueNow+" ";
         this.$copyText(data_cpy_i).then(()=> {
            console.log("复制成功"+data_cpy_i);
            this.$message('复制成功.');
        },()=> {
            console.log("复制失败了");
            this.$message('复制失败了.');
            }
        );
        

      },handleSelect(item) {
        console.log(item);
      },handleBool(value,y){
        console.log(y.srcElement.defaultValue+" is :"+value);
        let flag_value = "";
        // -XX:+PrintGCDetails  
        if(value){
            console.log("ok");
            flag_value = "+";
        }else{
            console.log("no");
            flag_value = "-";
        }
        let data_cpy = " -XX:"+flag_value+y.srcElement.defaultValue+" ";
         this.$copyText(data_cpy).then(()=> {
            console.log("复制成功"+data_cpy);
            this.$message('复制成功.');
        },()=> {
            console.log("复制失败了");
            this.$message('复制失败了.');
            }
        );
       
        


        /*
         let count = 0;
       let ux = [...Array(26)].map((v,i)=>String.fromCharCode(i+65));
        ux.forEach(x=>{
          allCcstrParam.forEach(item =>{
            if(item.startsWith(x)){
              count ++;
            }
        });
        console.log(x+":"+count);
        count = 0;
        });
        */

      }
    }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
 .el-select .el-input .el-checkbox {
    width: 100px;
    margin: 10px;
  }
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }
  .demo-input-label {
    display: inline-block;
    width: 130px;
  }
</style>
