package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeuf implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzeuf(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu3;
        this.zzc = zzhfu4;
    }

    /* renamed from: zza */
    public final zzeud zzb() {
        Context zza2 = ((zzcgp) this.zza).zza();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzeud(zza2, zzgcu, ((zzcwh) this.zzb).zza(), ((zzchc) this.zzc).zza());
    }
}
