package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzecp implements zzfjm {
    private final zzecd zza;
    private final zzech zzb;

    public zzecp(zzecd zzecd, zzech zzech) {
        this.zza = zzecd;
        this.zzb = zzech;
    }

    public final void zzd(zzfjf zzfjf, String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfB)).booleanValue() && zzfjf.RENDERER == zzfjf && this.zza.zzc() != 0) {
            this.zza.zzf(zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdD(zzfjf zzfjf, String str, Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfB)).booleanValue() && zzfjf.RENDERER == zzfjf && this.zza.zzc() != 0) {
            this.zza.zzf(zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdE(zzfjf zzfjf, String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzfB)).booleanValue()) {
            if (zzfjf.RENDERER == zzfjf) {
                this.zza.zzg(zzu.zzB().elapsedRealtime());
            } else if (zzfjf.PRELOADED_LOADER == zzfjf || zzfjf.SERVER_TRANSACTION == zzfjf) {
                this.zza.zzh(zzu.zzB().elapsedRealtime());
                zzech zzech = this.zzb;
                zzech.zza.zza(new zzecg(zzech, this.zza.zzd()));
            }
        }
    }

    public final void zzdC(zzfjf zzfjf, String str) {
    }
}
