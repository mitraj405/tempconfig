package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcaj implements Runnable {
    final /* synthetic */ zzcao zza;

    public zzcaj(zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void run() {
        zzcao zzcao = this.zza;
        if (zzcao.zzq != null) {
            zzcao.zzq.zzh();
        }
    }
}
