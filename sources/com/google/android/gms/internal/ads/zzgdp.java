package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgdp {
    private final InputStream zza;

    private zzgdp(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzgdp zzb(byte[] bArr) {
        return new zzgdp(new ByteArrayInputStream(bArr));
    }

    public final zzgth zza() throws IOException {
        try {
            return zzgth.zzg(this.zza, zzgxi.zza());
        } finally {
            this.zza.close();
        }
    }
}
