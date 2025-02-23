package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzchk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzchk(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    /* renamed from: zza */
    public final zzbuv zzb() {
        Context zza2 = ((zzcgp) this.zza).zza();
        zzfki zzfki = (zzfki) this.zzb.zzb();
        zzbno zzb2 = zzu.zzf().zzb(zza2, VersionInfoParcel.forPackage(), zzfki);
        zzbni zzbni = zzbnl.zza;
        zzb2.zza("google.afma.request.getAdDictionary", zzbni, zzbni);
        return new zzbux(zza2, zzu.zzf().zzb(zza2, VersionInfoParcel.forPackage(), zzfki).zza("google.afma.sdkConstants.getSdkConstants", zzbni, zzbni), VersionInfoParcel.forPackage());
    }
}
