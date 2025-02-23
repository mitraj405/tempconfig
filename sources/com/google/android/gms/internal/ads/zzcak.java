package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcak implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzcao zzc;

    public zzcak(zzcao zzcao, int i, int i2) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzcao;
    }

    public final void run() {
        zzcao zzcao = this.zzc;
        if (zzcao.zzq != null) {
            zzcao.zzq.zzj(this.zza, this.zzb);
        }
    }
}
