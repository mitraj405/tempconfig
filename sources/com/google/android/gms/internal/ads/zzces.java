package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzces implements zzfvk {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcgd zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzauo zzf;
    public final /* synthetic */ zzbcz zzg;
    public final /* synthetic */ VersionInfoParcel zzh;
    public final /* synthetic */ zzm zzi;
    public final /* synthetic */ zza zzj;
    public final /* synthetic */ zzbav zzk;
    public final /* synthetic */ zzfel zzl;
    public final /* synthetic */ zzfeo zzm;
    public final /* synthetic */ zzffk zzn;
    public final /* synthetic */ zzeds zzo;

    public /* synthetic */ zzces(Context context, zzcgd zzcgd, String str, boolean z, boolean z2, zzauo zzauo, zzbcz zzbcz, VersionInfoParcel versionInfoParcel, zzbcl zzbcl, zzm zzm2, zza zza2, zzbav zzbav, zzfel zzfel, zzfeo zzfeo, zzffk zzffk, zzeds zzeds) {
        this.zza = context;
        this.zzb = zzcgd;
        this.zzc = str;
        this.zzd = z;
        this.zze = z2;
        this.zzf = zzauo;
        this.zzg = zzbcz;
        this.zzh = versionInfoParcel;
        this.zzi = zzm2;
        this.zzj = zza2;
        this.zzk = zzbav;
        this.zzl = zzfel;
        this.zzm = zzfeo;
        this.zzn = zzffk;
        this.zzo = zzeds;
    }

    public final Object zza() {
        zzcgd zzcgd = this.zzb;
        String str = this.zzc;
        boolean z = this.zzd;
        zzbav zzbav = this.zzk;
        boolean z2 = this.zze;
        zzauo zzauo = this.zzf;
        zzfel zzfel = this.zzl;
        zzbcz zzbcz = this.zzg;
        zzm zzm2 = this.zzi;
        zzfeo zzfeo = this.zzm;
        Context context = this.zza;
        VersionInfoParcel versionInfoParcel = this.zzh;
        zza zza2 = this.zzj;
        zzffk zzffk = this.zzn;
        zzeds zzeds = this.zzo;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = zzcfi.zza;
            zzcfi zzcfi = r2;
            zzeds zzeds2 = zzeds;
            zzfeo zzfeo2 = zzfeo;
            zza zza3 = zza2;
            zzfel zzfel2 = zzfel;
            zzcfi zzcfi2 = new zzcfi(new zzcgc(context), zzcgd, str, z, z2, zzauo, zzbcz, versionInfoParcel, (zzbcl) null, zzm2, zza3, zzbav, zzfel2, zzfeo2, zzffk);
            zzcfb zzcfb = new zzcfb(zzcfi2);
            zzcfb.setWebViewClient(zzu.zzq().zzc(zzcfb, zzbav, z2, zzeds2));
            zzcfb.setWebChromeClient(new zzcei(zzcfb));
            return zzcfb;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
