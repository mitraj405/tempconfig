package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcnf implements Runnable {
    public final /* synthetic */ zzcnh zza;
    public final /* synthetic */ Throwable zzb;
    public final /* synthetic */ zzfll zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzcnf(zzcnh zzcnh, Throwable th, zzfll zzfll, String str) {
        this.zza = zzcnh;
        this.zzb = th;
        this.zzc = zzfll;
        this.zzd = str;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzju)).booleanValue();
        zzcnh zzcnh = this.zza;
        Throwable th = this.zzb;
        if (booleanValue) {
            zzcni zzcni = zzcnh.zzc;
            zzcni.zzb = zzbtq.zzc(zzcni.zzc);
            zzcnh.zzc.zzb.zzh(th, "AttributionReporting.registerSourceAndPingClickUrl");
        } else {
            zzcni zzcni2 = zzcnh.zzc;
            zzcni2.zza = zzbtq.zza(zzcni2.zzc);
            zzcnh.zzc.zza.zzh(th, "AttributionReportingSampled.registerSourceAndPingClickUrl");
        }
        this.zzc.zzc(this.zzd, (zzfkf) null);
    }
}
