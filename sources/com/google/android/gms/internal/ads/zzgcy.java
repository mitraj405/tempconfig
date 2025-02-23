package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgax;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgcy extends zzgax.zzi implements Runnable {
    private final Runnable zza;

    public zzgcy(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }

    public final String zza() {
        return lf.j("task=[", this.zza.toString(), "]");
    }
}
