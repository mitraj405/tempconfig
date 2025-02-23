package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcai implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzcao zzc;

    public zzcai(zzcao zzcao, String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzcao;
    }

    public final void run() {
        zzcao zzcao = this.zzc;
        if (zzcao.zzq != null) {
            zzcao.zzq.zzb(this.zza, this.zzb);
        }
    }
}
