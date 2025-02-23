package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzem implements zzdj {
    public final long zza() {
        return SystemClock.elapsedRealtime();
    }

    public final zzdt zzb(Looper looper, Handler.Callback callback) {
        return new zzep(new Handler(looper, callback));
    }
}
