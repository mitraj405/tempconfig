package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzboe {
    private static zzboe zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public static zzboe zza() {
        if (zza == null) {
            zza = new zzboe();
        }
        return zza;
    }

    public final Thread zzb(Context context, String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbod(this, context, str));
        thread.start();
        return thread;
    }
}
