package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeaz implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;
    private final zzhfu zzd;
    private final zzhfu zze;

    public zzeaz(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4, zzhfu zzhfu5, zzhfu zzhfu6, zzhfu zzhfu7, zzhfu zzhfu8) {
        this.zza = zzhfu;
        this.zzb = zzhfu4;
        this.zzc = zzhfu5;
        this.zzd = zzhfu6;
        this.zze = zzhfu8;
    }

    public final /* synthetic */ Object zzb() {
        Context zza2 = ((zzcgp) this.zza).zza();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        return new zzeay(zza2, zzgcu, new zzbvj(), ((zzcgz) this.zzb).zzb(), ((zzebr) this.zzc).zzb(), (ArrayDeque) this.zzd.zzb(), new zzebn(), (zzfki) this.zze.zzb());
    }
}
