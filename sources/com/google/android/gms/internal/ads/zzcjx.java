package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcjx implements zzfcr {
    private final zzcif zza;
    private final zzhfl zzb;
    private final zzhfl zzc;
    private final zzhfl zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;

    public /* synthetic */ zzcjx(zzcif zzcif, Context context, String str, zzq zzq, zzcjw zzcjw) {
        this.zza = zzcif;
        zzhfc zza2 = zzhfd.zza(context);
        this.zzb = zza2;
        zzhfc zza3 = zzhfd.zza(zzq);
        this.zzc = zza3;
        zzhfc zza4 = zzhfd.zza(str);
        this.zzd = zza4;
        zzhfl zzc2 = zzhfb.zzc(new zzeml(zzcif.zzM));
        this.zze = zzc2;
        zzhfl zzc3 = zzhfb.zzc(new zzfdp(zzcif.zzaH));
        this.zzf = zzc3;
        zzhfl zzhfl = zzc2;
        zzhfl zzhfl2 = zzc3;
        zzhfl zzc4 = zzhfb.zzc(new zzfcp(zza2, zzcif.zzc, zzcif.zzO, zzhfl, zzhfl2, zzffi.zza()));
        this.zzg = zzc4;
        this.zzh = zzhfb.zzc(new zzemt(zza2, zza3, zza4, zzc4, zzhfl, zzhfl2, zzcif.zzl, zzcif.zzQ, zzcif.zzM));
    }

    public final zzems zza() {
        return (zzems) this.zzh.zzb();
    }
}
