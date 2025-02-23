package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadr {
    private final byte[] zza;
    private final int zzb;
    private int zzc;
    private int zzd;

    public zzadr(byte[] bArr) {
        this.zza = bArr;
        this.zzb = bArr.length;
    }

    public final int zza() {
        return (this.zzc * 8) + this.zzd;
    }

    public final int zzb(int i) {
        int i2 = this.zzc;
        int i3 = i2 + 1;
        byte[] bArr = this.zza;
        int min = Math.min(i, 8 - this.zzd);
        int i4 = ((bArr[i2] & UnsignedBytes.MAX_VALUE) >> this.zzd) & (Constants.MAX_HOST_LENGTH >> (8 - min));
        while (min < i) {
            i4 |= (this.zza[i3] & UnsignedBytes.MAX_VALUE) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & (-1 >>> (32 - i));
        zzc(i);
        return i5;
    }

    public final void zzc(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.zzc + i3;
        this.zzc = i4;
        int i5 = (i - (i3 * 8)) + this.zzd;
        this.zzd = i5;
        if (i5 > 7) {
            i4++;
            this.zzc = i4;
            i5 -= 8;
            this.zzd = i5;
        }
        boolean z = false;
        if (i4 >= 0 && (i4 < (i2 = this.zzb) || (i4 == i2 && i5 == 0))) {
            z = true;
        }
        zzdi.zzf(z);
    }

    public final boolean zzd() {
        zzc(1);
        if (1 != (((this.zza[this.zzc] & UnsignedBytes.MAX_VALUE) >> this.zzd) & 1)) {
            return false;
        }
        return true;
    }
}
