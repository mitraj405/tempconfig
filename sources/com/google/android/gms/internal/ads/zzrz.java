package com.google.android.gms.internal.ads;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzrz {
    public final zzsf zza;
    public final MediaFormat zzb;
    public final zzaf zzc;
    public final Surface zzd;
    public final MediaCrypto zze = null;

    private zzrz(zzsf zzsf, MediaFormat mediaFormat, zzaf zzaf, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.zza = zzsf;
        this.zzb = mediaFormat;
        this.zzc = zzaf;
        this.zzd = surface;
    }

    public static zzrz zza(zzsf zzsf, MediaFormat mediaFormat, zzaf zzaf, MediaCrypto mediaCrypto) {
        return new zzrz(zzsf, mediaFormat, zzaf, (Surface) null, (MediaCrypto) null, 0);
    }

    public static zzrz zzb(zzsf zzsf, MediaFormat mediaFormat, zzaf zzaf, Surface surface, MediaCrypto mediaCrypto) {
        return new zzrz(zzsf, mediaFormat, zzaf, surface, (MediaCrypto) null, 0);
    }
}
