package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbmu extends zzcaa {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzbmz zzb;
    private boolean zzc;

    public zzbmu(zzbmz zzbmz) {
        this.zzb = zzbmz;
    }

    public final void zzb() {
        zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("release: Lock acquired");
            if (this.zzc) {
                zze.zza("release: Lock already released");
                return;
            }
            this.zzc = true;
            zzj(new zzbmr(this), new zzbzw());
            zzj(new zzbms(this), new zzbmt(this));
            zze.zza("release: Lock released");
        }
    }
}
