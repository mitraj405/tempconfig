package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzceu implements zzgbp {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzauo zzb;
    public final /* synthetic */ VersionInfoParcel zzc;
    public final /* synthetic */ zza zzd;
    public final /* synthetic */ zzeds zze;
    public final /* synthetic */ zzffk zzf;
    public final /* synthetic */ String zzg;

    public /* synthetic */ zzceu(Context context, zzauo zzauo, VersionInfoParcel versionInfoParcel, zza zza2, zzeds zzeds, zzffk zzffk, String str) {
        this.zza = context;
        this.zzb = zzauo;
        this.zzc = versionInfoParcel;
        this.zzd = zza2;
        this.zze = zzeds;
        this.zzf = zzffk;
        this.zzg = str;
    }

    public final ListenableFuture zza() {
        zzu.zzz();
        Context context = this.zza;
        zzcgd zza2 = zzcgd.zza();
        zzauo zzauo = this.zzb;
        zzeds zzeds = this.zze;
        zza zza3 = this.zzd;
        zzcej zza4 = zzcew.zza(context, zza2, "", false, false, zzauo, (zzbcz) null, this.zzc, (zzbcl) null, (zzm) null, zza3, zzbav.zza(), (zzfel) null, (zzfeo) null, zzeds, this.zzf);
        zzbzs zza5 = zzbzs.zza(zza4);
        zza4.zzN().zzB(new zzcet(zza5));
        zza4.loadUrl(this.zzg);
        return zza5;
    }
}
