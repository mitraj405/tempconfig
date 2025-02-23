package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzckb implements zzfef {
    private final zzcif zza;
    private final zzhfl zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;

    public /* synthetic */ zzckb(zzcif zzcif, Context context, String str, zzcka zzcka) {
        this.zza = zzcif;
        zzhfc zza2 = zzhfd.zza(context);
        this.zzb = zza2;
        zzfcf zzfcf = new zzfcf(zza2, zzcif.zzaH, zzcif.zzaI);
        this.zzc = zzfcf;
        zzhfl zzc2 = zzhfb.zzc(new zzfdp(zzcif.zzaH));
        this.zzd = zzc2;
        zzhfl zzc3 = zzhfb.zzc(zzffd.zza());
        this.zze = zzc3;
        zzhfl zzc4 = zzhfb.zzc(new zzfdz(zza2, zzcif.zzc, zzcif.zzO, zzfcf, zzc2, zzffi.zza(), zzc3));
        this.zzf = zzc4;
        this.zzg = zzhfb.zzc(new zzfej(zzc4, zzc2, zzc3));
        zzhfc zzc5 = zzhfd.zzc(str);
        this.zzh = zzc5;
        this.zzi = zzhfb.zzc(new zzfed(zzc5, zzc4, zza2, zzc2, zzc3, zzcif.zzl, zzcif.zzQ, zzcif.zzM));
    }

    public final zzfec zza() {
        return (zzfec) this.zzi.zzb();
    }

    public final zzfei zzb() {
        return (zzfei) this.zzg.zzb();
    }
}
