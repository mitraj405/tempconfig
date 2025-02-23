package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdwv implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzdwv(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcgp) this.zzb).zza();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        ListenableFuture zzb2 = zzgcu.zzb(new zzdws((zzauo) this.zza.zzb(), zza2));
        zzhfk.zzb(zzb2);
        return zzb2;
    }
}
