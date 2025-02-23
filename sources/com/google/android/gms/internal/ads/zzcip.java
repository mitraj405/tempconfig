package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcip implements zzezm {
    private final zzcif zza;
    private final zzhfl zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;

    public /* synthetic */ zzcip(zzcif zzcif, Context context, String str, zzcio zzcio) {
        this.zza = zzcif;
        zzhfc zza2 = zzhfd.zza(context);
        this.zzb = zza2;
        zzhfc zza3 = zzhfd.zza(str);
        this.zzc = zza3;
        zzfce zzfce = new zzfce(zza2, zzcif.zzaH, zzcif.zzaI);
        this.zzd = zzfce;
        zzhfl zzc2 = zzhfb.zzc(new zzfak(zzcif.zzaH));
        this.zze = zzc2;
        zzhfl zzhfl = zzc2;
        zzhfl zzc3 = zzhfb.zzc(new zzfam(zza2, zzcif.zzc, zzcif.zzO, zzfce, zzhfl, zzffi.zza(), zzcif.zzl));
        this.zzf = zzc3;
        this.zzg = zzhfb.zzc(new zzfas(zzcif.zzO, zza2, zza3, zzc3, zzhfl, zzcif.zzl, zzcif.zzM));
    }

    public final zzfar zza() {
        return (zzfar) this.zzg.zzb();
    }
}
