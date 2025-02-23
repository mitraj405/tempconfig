package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcnh implements zzgcf {
    final /* synthetic */ zzfll zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcni zzc;

    public zzcnh(zzcni zzcni, zzfll zzfll, String str) {
        this.zza = zzfll;
        this.zzb = str;
        this.zzc = zzcni;
    }

    public final void zza(Throwable th) {
        this.zzc.zzg.zza(new zzcnf(this, th, this.zza, this.zzb));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzc.zzg.zza(new zzcng(this.zza, (String) obj));
    }
}
