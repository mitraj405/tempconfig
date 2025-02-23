package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzcaa {
    private final zzbzt zza;
    /* access modifiers changed from: private */
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzcaa() {
        zzbzt zzbzt = new zzbzt();
        this.zza = zzbzt;
        zzgcj.zzr(zzbzt, new zzbzy(this), zzbzo.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgS)).booleanValue()) {
            zzu.zzo().zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzbzx zzbzx, zzbzv zzbzv) {
        zzgcj.zzr(this.zza, new zzbzz(this, zzbzx, zzbzv), zzbzo.zzf);
    }
}
