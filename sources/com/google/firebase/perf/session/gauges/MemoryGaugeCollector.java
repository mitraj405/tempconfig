package com.google.firebase.perf.session.gauges;

import android.annotation.SuppressLint;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.AndroidMemoryReading;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MemoryGaugeCollector {
    public static final long INVALID_MEMORY_COLLECTION_FREQUENCY = -1;
    private static final int UNSET_MEMORY_METRIC_COLLECTION_RATE = -1;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private long memoryMetricCollectionRateMs;
    private final ScheduledExecutorService memoryMetricCollectorExecutor;
    private ScheduledFuture memoryMetricCollectorJob;
    public final ConcurrentLinkedQueue<AndroidMemoryReading> memoryMetricReadings;
    private final Runtime runtime;

    @SuppressLint({"ThreadPoolCreation"})
    public MemoryGaugeCollector() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    private int getCurrentUsedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.totalMemory() - this.runtime.freeMemory()));
    }

    public static boolean isInvalidCollectionFrequency(long j) {
        if (j <= 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionOnce$1(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleMemoryMetricCollectionWithRate$0(Timer timer) {
        AndroidMemoryReading syncCollectMemoryMetric = syncCollectMemoryMetric(timer);
        if (syncCollectMemoryMetric != null) {
            this.memoryMetricReadings.add(syncCollectMemoryMetric);
        }
    }

    private synchronized void scheduleMemoryMetricCollectionOnce(Timer timer) {
        try {
            this.memoryMetricCollectorExecutor.schedule(new A1(3, this, timer), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to collect Memory Metric: " + e.getMessage());
        }
        return;
    }

    private synchronized void scheduleMemoryMetricCollectionWithRate(long j, Timer timer) {
        this.memoryMetricCollectionRateMs = j;
        try {
            this.memoryMetricCollectorJob = this.memoryMetricCollectorExecutor.scheduleAtFixedRate(new C0428zq(5, this, timer), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            AndroidLogger androidLogger = logger;
            androidLogger.warn("Unable to start collecting Memory Metrics: " + e.getMessage());
        }
        return;
    }

    private AndroidMemoryReading syncCollectMemoryMetric(Timer timer) {
        if (timer == null) {
            return null;
        }
        return (AndroidMemoryReading) AndroidMemoryReading.newBuilder().setClientTimeUs(timer.getCurrentTimestampMicros()).setUsedAppJavaHeapMemoryKb(getCurrentUsedAppJavaHeapMemoryKb()).build();
    }

    public void collectOnce(Timer timer) {
        scheduleMemoryMetricCollectionOnce(timer);
    }

    public void startCollecting(long j, Timer timer) {
        if (!isInvalidCollectionFrequency(j)) {
            if (this.memoryMetricCollectorJob == null) {
                scheduleMemoryMetricCollectionWithRate(j, timer);
            } else if (this.memoryMetricCollectionRateMs != j) {
                stopCollecting();
                scheduleMemoryMetricCollectionWithRate(j, timer);
            }
        }
    }

    public void stopCollecting() {
        ScheduledFuture scheduledFuture = this.memoryMetricCollectorJob;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.memoryMetricCollectorJob = null;
            this.memoryMetricCollectionRateMs = -1;
        }
    }

    public MemoryGaugeCollector(ScheduledExecutorService scheduledExecutorService, Runtime runtime2) {
        this.memoryMetricCollectorJob = null;
        this.memoryMetricCollectionRateMs = -1;
        this.memoryMetricCollectorExecutor = scheduledExecutorService;
        this.memoryMetricReadings = new ConcurrentLinkedQueue<>();
        this.runtime = runtime2;
    }
}
