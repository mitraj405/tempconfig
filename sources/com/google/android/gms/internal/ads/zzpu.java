package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzpu implements Runnable {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzpi zzb;
    public final /* synthetic */ Handler zzc;
    public final /* synthetic */ zzpf zzd;
    public final /* synthetic */ zzdm zze;

    public /* synthetic */ zzpu(AudioTrack audioTrack, zzpi zzpi, Handler handler, zzpf zzpf, zzdm zzdm) {
        this.zza = audioTrack;
        this.zzb = zzpi;
        this.zzc = handler;
        this.zzd = zzpf;
        this.zze = zzdm;
    }

    public final void run() {
        zzqp.zzH(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
