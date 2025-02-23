package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcah implements Runnable {
    final /* synthetic */ zzcao zza;

    public zzcah(zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void run() {
        zzcao zzcao = this.zza;
        if (zzcao.zzq != null) {
            zzcao.zzq.zza();
        }
    }
}
