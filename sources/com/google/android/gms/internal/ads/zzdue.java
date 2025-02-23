package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdue implements Runnable {
    public final /* synthetic */ zzdun zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzbzt zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ zzfju zzf;

    public /* synthetic */ zzdue(zzdun zzdun, Object obj, zzbzt zzbzt, String str, long j, zzfju zzfju) {
        this.zza = zzdun;
        this.zzb = obj;
        this.zzc = zzbzt;
        this.zzd = str;
        this.zze = j;
        this.zzf = zzfju;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
