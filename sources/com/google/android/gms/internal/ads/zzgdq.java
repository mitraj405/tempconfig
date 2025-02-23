package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgdq {
    private final OutputStream zza;

    private zzgdq(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzgdq zzb(OutputStream outputStream) {
        return new zzgdq(outputStream);
    }

    public final void zza(zzgth zzgth) throws IOException {
        try {
            zzgth.zzaU(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
