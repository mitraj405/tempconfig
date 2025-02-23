package com.google.firebase.sessions;

import android.os.SystemClock;
import kotlin.time.Duration;

/* compiled from: TimeProvider.kt */
public final class WallClock implements TimeProvider {
    public static final WallClock INSTANCE = new WallClock();
    private static final long US_PER_MILLIS = 1000;

    private WallClock() {
    }

    public long currentTimeUs() {
        return System.currentTimeMillis() * US_PER_MILLIS;
    }

    /* renamed from: elapsedRealtime-UwyO8pc  reason: not valid java name */
    public long m12elapsedRealtimeUwyO8pc() {
        int i = Duration.c;
        return C1354qp.I0(SystemClock.elapsedRealtime(), C0513G9.MILLISECONDS);
    }
}
