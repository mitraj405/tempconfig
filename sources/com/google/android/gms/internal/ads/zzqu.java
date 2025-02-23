package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzqu implements zzpi {
    final /* synthetic */ zzqv zza;

    public /* synthetic */ zzqu(zzqv zzqv, zzqt zzqt) {
        this.zza = zzqv;
    }

    public final void zza(Exception exc) {
        zzea.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }
}
