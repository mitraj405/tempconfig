package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzasx {
    private final byte[] zza = new byte[256];
    private int zzb;
    private int zzc;

    public zzasx(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zza[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr2 = this.zza;
            byte b2 = bArr2[i2];
            b = (b + b2 + bArr[i2 % bArr.length]) & UnsignedBytes.MAX_VALUE;
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.zzb = 0;
        this.zzc = 0;
    }

    public final void zza(byte[] bArr) {
        int i = this.zzb;
        int i2 = this.zzc;
        for (int i3 = 0; i3 < 256; i3++) {
            byte[] bArr2 = this.zza;
            i = (i + 1) & Constants.MAX_HOST_LENGTH;
            byte b = bArr2[i];
            i2 = (i2 + b) & Constants.MAX_HOST_LENGTH;
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + b) & Constants.MAX_HOST_LENGTH] ^ bArr[i3]);
        }
        this.zzb = i;
        this.zzc = i2;
    }
}
