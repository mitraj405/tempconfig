package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcag implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcao zzb;

    public zzcag(zzcao zzcao, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        this.zzb = zzcao;
    }

    public final void run() {
        zzcao.zzl(this.zzb, this.zza);
        zzcao zzcao = this.zzb;
        if (zzcao.zzq != null) {
            zzcao.zzq.zzf();
        }
    }
}
