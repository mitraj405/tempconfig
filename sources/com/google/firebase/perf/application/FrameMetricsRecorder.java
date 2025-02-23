package com.google.firebase.perf.application;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import androidx.fragment.app.Fragment;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.FrameMetricsCalculator;
import com.google.firebase.perf.util.Optional;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class FrameMetricsRecorder {
    private static final String FRAME_METRICS_AGGREGATOR_CLASSNAME = "androidx.core.app.FrameMetricsAggregator";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Activity activity;
    private final Map<Fragment, FrameMetricsCalculator.PerfFrameMetrics> fragmentSnapshotMap;
    private final FrameMetricsAggregator frameMetricsAggregator;
    private boolean isRecording;

    public FrameMetricsRecorder(Activity activity2) {
        this(activity2, new FrameMetricsAggregator(), new HashMap());
    }

    public static boolean isFrameMetricsRecordingSupported() {
        return true;
    }

    private Optional<FrameMetricsCalculator.PerfFrameMetrics> snapshot() {
        if (!this.isRecording) {
            logger.debug("No recording has been started.");
            return Optional.absent();
        }
        SparseIntArray[] sparseIntArrayArr = this.frameMetricsAggregator.a.f1728a;
        if (sparseIntArrayArr == null) {
            logger.debug("FrameMetricsAggregator.mMetrics is uninitialized.");
            return Optional.absent();
        } else if (sparseIntArrayArr[0] != null) {
            return Optional.of(FrameMetricsCalculator.calculateFrameMetrics(sparseIntArrayArr));
        } else {
            logger.debug("FrameMetricsAggregator.mMetrics[TOTAL_INDEX] is uninitialized.");
            return Optional.absent();
        }
    }

    public void start() {
        if (this.isRecording) {
            logger.debug("FrameMetricsAggregator is already recording %s", this.activity.getClass().getSimpleName());
            return;
        }
        FrameMetricsAggregator frameMetricsAggregator2 = this.frameMetricsAggregator;
        Activity activity2 = this.activity;
        FrameMetricsAggregator.a aVar = frameMetricsAggregator2.a;
        aVar.getClass();
        if (FrameMetricsAggregator.a.f1724a == null) {
            HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
            FrameMetricsAggregator.a.f1724a = handlerThread;
            handlerThread.start();
            FrameMetricsAggregator.a.a = new Handler(FrameMetricsAggregator.a.f1724a.getLooper());
        }
        for (int i = 0; i <= 8; i++) {
            SparseIntArray[] sparseIntArrayArr = aVar.f1728a;
            if (sparseIntArrayArr[i] == null && (aVar.f1725a & (1 << i)) != 0) {
                sparseIntArrayArr[i] = new SparseIntArray();
            }
        }
        activity2.getWindow().addOnFrameMetricsAvailableListener(aVar.f1726a, FrameMetricsAggregator.a.a);
        aVar.f1727a.add(new WeakReference(activity2));
        this.isRecording = true;
    }

    public void startFragment(Fragment fragment) {
        if (!this.isRecording) {
            logger.debug("Cannot start sub-recording because FrameMetricsAggregator is not recording");
        } else if (this.fragmentSnapshotMap.containsKey(fragment)) {
            logger.debug("Cannot start sub-recording because one is already ongoing with the key %s", fragment.getClass().getSimpleName());
        } else {
            Optional<FrameMetricsCalculator.PerfFrameMetrics> snapshot = snapshot();
            if (!snapshot.isAvailable()) {
                logger.debug("startFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
                return;
            }
            this.fragmentSnapshotMap.put(fragment, snapshot.get());
        }
    }

    public Optional<FrameMetricsCalculator.PerfFrameMetrics> stop() {
        if (!this.isRecording) {
            logger.debug("Cannot stop because no recording was started");
            return Optional.absent();
        }
        if (!this.fragmentSnapshotMap.isEmpty()) {
            logger.debug("Sub-recordings are still ongoing! Sub-recordings should be stopped first before stopping Activity screen trace.");
            this.fragmentSnapshotMap.clear();
        }
        Optional<FrameMetricsCalculator.PerfFrameMetrics> snapshot = snapshot();
        try {
            this.frameMetricsAggregator.a(this.activity);
        } catch (IllegalArgumentException | NullPointerException e) {
            if (!(e instanceof NullPointerException) || Build.VERSION.SDK_INT <= 28) {
                logger.warn("View not hardware accelerated. Unable to collect FrameMetrics. %s", e.toString());
                snapshot = Optional.absent();
            } else {
                throw e;
            }
        }
        FrameMetricsAggregator.a aVar = this.frameMetricsAggregator.a;
        SparseIntArray[] sparseIntArrayArr = aVar.f1728a;
        aVar.f1728a = new SparseIntArray[9];
        this.isRecording = false;
        return snapshot;
    }

    public Optional<FrameMetricsCalculator.PerfFrameMetrics> stopFragment(Fragment fragment) {
        if (!this.isRecording) {
            logger.debug("Cannot stop sub-recording because FrameMetricsAggregator is not recording");
            return Optional.absent();
        } else if (!this.fragmentSnapshotMap.containsKey(fragment)) {
            logger.debug("Sub-recording associated with key %s was not started or does not exist", fragment.getClass().getSimpleName());
            return Optional.absent();
        } else {
            FrameMetricsCalculator.PerfFrameMetrics remove = this.fragmentSnapshotMap.remove(fragment);
            Optional<FrameMetricsCalculator.PerfFrameMetrics> snapshot = snapshot();
            if (snapshot.isAvailable()) {
                return Optional.of(snapshot.get().deltaFrameMetricsFromSnapshot(remove));
            }
            logger.debug("stopFragment(%s): snapshot() failed", fragment.getClass().getSimpleName());
            return Optional.absent();
        }
    }

    public FrameMetricsRecorder(Activity activity2, FrameMetricsAggregator frameMetricsAggregator2, Map<Fragment, FrameMetricsCalculator.PerfFrameMetrics> map) {
        this.isRecording = false;
        this.activity = activity2;
        this.frameMetricsAggregator = frameMetricsAggregator2;
        this.fragmentSnapshotMap = map;
    }
}
