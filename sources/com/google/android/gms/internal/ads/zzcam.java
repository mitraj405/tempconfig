package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcam implements Runnable {
    final /* synthetic */ zzcao zza;

    public zzcam(zzcao zzcao) {
        this.zza = zzcao;
    }

    public final void run() {
        zzcao zzcao = this.zza;
        if (zzcao.zzq != null) {
            if (!zzcao.zzr) {
                zzcao.zzq.zzg();
                this.zza.zzr = true;
            }
            this.zza.zzq.zze();
        }
    }
}
