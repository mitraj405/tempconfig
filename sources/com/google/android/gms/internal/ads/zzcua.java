package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcua implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;

    public zzcua(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
        this.zzd = zzhfu4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzctz((Clock) this.zza.zzb(), (zzcub) this.zzb.zzb(), ((zzcwh) this.zzc).zza(), (String) this.zzd.zzb());
    }
}
