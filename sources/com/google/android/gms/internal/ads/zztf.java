package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zztf implements zzsd {
    private final MediaCodec zza;

    public zztf(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    public final void zzd(int i, int i2, int i3, long j, int i4) {
        this.zza.queueInputBuffer(i, 0, i3, j, i4);
    }

    public final void zze(int i, int i2, zzha zzha, long j, int i3) {
        this.zza.queueSecureInputBuffer(i, 0, zzha.zza(), j, 0);
    }

    public final void zzf(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzg() {
    }

    public final void zzh() {
    }
}
