package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcvu {
    private final zzfjl zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhew zzg;
    private final String zzh;
    private final zzevr zzi;
    private final zzg zzj;
    private final zzffg zzk;
    private final zzdcc zzl;

    public zzcvu(zzfjl zzfjl, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhew zzhew, zzg zzg2, String str2, zzevr zzevr, zzffg zzffg, zzdcc zzdcc) {
        this.zza = zzfjl;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhew;
        this.zzh = str2;
        this.zzi = zzevr;
        this.zzj = zzg2;
        this.zzk = zzffg;
        this.zzl = zzdcc;
    }

    public final /* synthetic */ zzbvb zza(ListenableFuture listenableFuture, Bundle bundle) throws Exception {
        boolean z;
        Bundle bundle2 = (Bundle) listenableFuture.get();
        String str = (String) ((ListenableFuture) this.zzg.zzb()).get();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzgu)).booleanValue() || !this.zzj.zzS()) {
            z = false;
        } else {
            z = true;
        }
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        return new zzbvb(bundle2, this.zzb, this.zzc, this.zzd, list, packageInfo, str, str2, (zzfhb) null, (String) null, z, this.zzk.zzb(), bundle);
    }

    public final ListenableFuture zzb(Bundle bundle) {
        this.zzl.zza();
        return zzfiv.zzc(this.zzi.zza(new Bundle(), bundle), zzfjf.SIGNALS, this.zza).zza();
    }

    public final ListenableFuture zzc() {
        Bundle bundle = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue()) {
            Bundle bundle2 = this.zzk.zzs;
            if (bundle2 != null) {
                bundle.putAll(bundle2);
            }
            bundle.putBoolean("ls", false);
        }
        ListenableFuture zzb2 = zzb(bundle);
        return this.zza.zza(zzfjf.REQUEST_PARCEL, zzb2, (ListenableFuture) this.zzg.zzb()).zza(new zzcvt(this, zzb2, bundle)).zza();
    }
}
