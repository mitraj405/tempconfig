package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfkc implements zzgcf {
    final /* synthetic */ zzfkf zza;
    final /* synthetic */ zzfju zzb;
    final /* synthetic */ boolean zzc;

    public zzfkc(zzfkf zzfkf, zzfju zzfju, boolean z) {
        this.zza = zzfkf;
        this.zzb = zzfju;
        this.zzc = z;
    }

    public final void zza(Throwable th) {
        zzfju zzfju = this.zzb;
        if (zzfju.zzk()) {
            zzfkf zzfkf = this.zza;
            zzfju.zzh(th);
            zzfju.zzg(false);
            zzfkf.zza(zzfju);
            if (this.zzc) {
                this.zza.zzh();
            }
        }
    }

    public final void zzb(Object obj) {
        zzfju zzfju = this.zzb;
        zzfju.zzg(true);
        this.zza.zza(zzfju);
        if (this.zzc) {
            this.zza.zzh();
        }
    }
}
