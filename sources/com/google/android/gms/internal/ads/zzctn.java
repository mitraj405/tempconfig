package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzctn implements zzhfc {
    private final zzhfu zza;

    public zzctn(zzhfu zzhfu) {
        this.zza = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxw zzfxw;
        zzctz zzctz = (zzctz) this.zza.zzb();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeZ)).booleanValue()) {
            zzfxw = zzfxw.zzo(new zzdei(zzctz, zzbzo.zzf));
        } else {
            zzfxw = zzfxw.zzn();
        }
        zzhfk.zzb(zzfxw);
        return zzfxw;
    }
}
