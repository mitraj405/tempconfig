package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcbm implements Runnable {
    private final zzcay zza;
    private boolean zzb = false;

    public zzcbm(zzcay zzcay) {
        this.zza = zzcay;
    }

    private final void zzc() {
        zzfru zzfru = zzt.zza;
        zzfru.removeCallbacks(this);
        zzfru.postDelayed(this, 250);
    }

    public final void run() {
        if (!this.zzb) {
            this.zza.zzt();
            zzc();
        }
    }

    public final void zza() {
        this.zzb = true;
        this.zza.zzt();
    }

    public final void zzb() {
        this.zzb = false;
        zzc();
    }
}
