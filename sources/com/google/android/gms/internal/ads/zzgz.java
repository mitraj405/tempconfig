package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgz {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    public /* synthetic */ zzgz(MediaCodec.CryptoInfo cryptoInfo, zzgy zzgy) {
        this.zza = cryptoInfo;
    }

    public static /* bridge */ /* synthetic */ void zza(zzgz zzgz, int i, int i2) {
        zzgz.zzb.set(i, i2);
        zzgz.zza.setPattern(zzgz.zzb);
    }
}
