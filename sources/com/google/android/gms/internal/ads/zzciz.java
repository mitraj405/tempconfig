package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzciz implements zzfba {
    private final Context zza;
    private final zzq zzb;
    private final String zzc;
    private final zzcif zzd;
    private final zzhfl zze;
    private final zzhfl zzf;
    private final zzhfl zzg;
    private final zzhfl zzh;
    private final zzhfl zzi;
    private final zzhfl zzj;

    public /* synthetic */ zzciz(zzcif zzcif, Context context, String str, zzq zzq, zzciy zzciy) {
        this.zzd = zzcif;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        zzhfc zza2 = zzhfd.zza(context);
        this.zze = zza2;
        zzhfc zza3 = zzhfd.zza(zzq);
        this.zzf = zza3;
        zzhfl zzc2 = zzhfb.zzc(new zzeml(zzcif.zzM));
        this.zzg = zzc2;
        zzhfl zzc3 = zzhfb.zzc(zzemq.zza());
        this.zzh = zzc3;
        zzhfl zzc4 = zzhfb.zzc(zzdbr.zza());
        this.zzi = zzc4;
        this.zzj = zzhfb.zzc(new zzfay(zza2, zzcif.zzc, zza3, zzcif.zzO, zzc2, zzc3, zzffi.zza(), zzc4));
    }

    public final zzelq zza() {
        VersionInfoParcel zze2 = this.zzd.zza.zze();
        zzhfk.zzb(zze2);
        return new zzelq(this.zza, this.zzb, this.zzc, (zzfax) this.zzj.zzb(), (zzemk) this.zzg.zzb(), zze2, (zzdsk) this.zzd.zzM.zzb());
    }
}
