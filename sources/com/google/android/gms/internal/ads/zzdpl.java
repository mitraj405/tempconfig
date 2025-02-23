package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdpl {
    private final Context zza;
    private final zzauo zzb;
    private final zzbcz zzc;
    private final VersionInfoParcel zzd;
    private final zza zze;
    private final zzbav zzf;
    /* access modifiers changed from: private */
    public final zzczj zzg;
    private final zzeds zzh;
    private final zzffk zzi;

    public zzdpl(zzcew zzcew, Context context, zzauo zzauo, zzbcz zzbcz, VersionInfoParcel versionInfoParcel, zza zza2, zzbav zzbav, zzczj zzczj, zzeds zzeds, zzffk zzffk) {
        this.zza = context;
        this.zzb = zzauo;
        this.zzc = zzbcz;
        this.zzd = versionInfoParcel;
        this.zze = zza2;
        this.zzf = zzbav;
        this.zzg = zzczj;
        this.zzh = zzeds;
        this.zzi = zzffk;
    }

    public final zzcej zza(zzq zzq, zzfel zzfel, zzfeo zzfeo) throws zzcev {
        zzcgd zzc2 = zzcgd.zzc(zzq);
        String str = zzq.zza;
        zzdpa zzdpa = new zzdpa(this);
        zzeds zzeds = this.zzh;
        zzffk zzffk = this.zzi;
        zza zza2 = this.zze;
        zzbav zzbav = this.zzf;
        return zzcew.zza(this.zza, zzc2, str, false, false, this.zzb, this.zzc, this.zzd, (zzbcl) null, zzdpa, zza2, zzbav, zzfel, zzfeo, zzeds, zzffk);
    }
}
