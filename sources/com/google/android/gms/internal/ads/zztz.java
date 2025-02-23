package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zztz {
    private static final AtomicLong zza = new AtomicLong();

    public zztz(long j, zzfy zzfy, long j2) {
        Uri uri = zzfy.zza;
        Collections.emptyMap();
    }

    public zztz(long j, zzfy zzfy, Uri uri, Map map, long j2, long j3, long j4) {
    }

    public static long zza() {
        return zza.getAndIncrement();
    }
}
