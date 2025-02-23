package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcuu implements zzhfc {
    private final zzhfu zza;

    public zzcuu(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxw zzfxw;
        zzctx zzctx = (zzctx) this.zza.zzb();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeZ)).booleanValue()) {
            zzfxw = zzfxw.zzo(new zzdei(zzctx, zzgcu));
        } else {
            zzfxw = zzfxw.zzn();
        }
        zzhfk.zzb(zzfxw);
        return zzfxw;
    }
}
