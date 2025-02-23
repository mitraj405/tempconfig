package com.google.android.gms.internal.ads;

import com.google.firebase.perf.util.Constants;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
abstract class zzgwy extends zzgxd {
    final byte[] zza;
    final int zzb;
    int zzc;
    int zzd;

    public zzgwy(int i) {
        super((zzgxc) null);
        if (i >= 0) {
            byte[] bArr = new byte[Math.max(i, 20)];
            this.zza = bArr;
            this.zzb = bArr.length;
            return;
        }
        throw new IllegalArgumentException("bufferSize must be >= 0");
    }

    public final int zzb() {
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
    }

    public final void zzc(byte b) {
        int i = this.zzc;
        this.zzc = i + 1;
        this.zza[i] = b;
        this.zzd++;
    }

    public final void zzd(int i) {
        int i2 = this.zzc;
        int i3 = i2 + 1;
        byte[] bArr = this.zza;
        bArr[i2] = (byte) (i & Constants.MAX_HOST_LENGTH);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >> 8) & Constants.MAX_HOST_LENGTH);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >> 16) & Constants.MAX_HOST_LENGTH);
        this.zzc = i5 + 1;
        bArr[i5] = (byte) ((i >> 24) & Constants.MAX_HOST_LENGTH);
        this.zzd += 4;
    }

    public final void zze(long j) {
        int i = this.zzc;
        int i2 = i + 1;
        byte[] bArr = this.zza;
        bArr[i] = (byte) ((int) (j & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >> 8) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >> 16) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (255 & (j >> 24)));
        int i6 = i5 + 1;
        bArr[i5] = (byte) (((int) (j >> 32)) & Constants.MAX_HOST_LENGTH);
        int i7 = i6 + 1;
        bArr[i6] = (byte) (((int) (j >> 40)) & Constants.MAX_HOST_LENGTH);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (((int) (j >> 48)) & Constants.MAX_HOST_LENGTH);
        this.zzc = i8 + 1;
        bArr[i8] = (byte) (((int) (j >> 56)) & Constants.MAX_HOST_LENGTH);
        this.zzd += 8;
    }

    public final void zzf(int i) {
        if (zzgxd.zzb) {
            long j = (long) this.zzc;
            while ((i & -128) != 0) {
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = i2 + 1;
                zzhaz.zzq(bArr, (long) i2, (byte) ((i | 128) & Constants.MAX_HOST_LENGTH));
                i >>>= 7;
            }
            byte[] bArr2 = this.zza;
            int i3 = this.zzc;
            this.zzc = i3 + 1;
            zzhaz.zzq(bArr2, (long) i3, (byte) i);
            this.zzd += (int) (((long) this.zzc) - j);
            return;
        }
        while ((i & -128) != 0) {
            byte[] bArr3 = this.zza;
            int i4 = this.zzc;
            this.zzc = i4 + 1;
            bArr3[i4] = (byte) ((i | 128) & Constants.MAX_HOST_LENGTH);
            this.zzd++;
            i >>>= 7;
        }
        byte[] bArr4 = this.zza;
        int i5 = this.zzc;
        this.zzc = i5 + 1;
        bArr4[i5] = (byte) i;
        this.zzd++;
    }

    public final void zzg(long j) {
        if (zzgxd.zzb) {
            long j2 = (long) this.zzc;
            while (true) {
                int i = (int) j;
                if ((j & -128) == 0) {
                    byte[] bArr = this.zza;
                    int i2 = this.zzc;
                    this.zzc = i2 + 1;
                    zzhaz.zzq(bArr, (long) i2, (byte) i);
                    this.zzd += (int) (((long) this.zzc) - j2);
                    return;
                }
                byte[] bArr2 = this.zza;
                int i3 = this.zzc;
                this.zzc = i3 + 1;
                zzhaz.zzq(bArr2, (long) i3, (byte) ((i | 128) & Constants.MAX_HOST_LENGTH));
                j >>>= 7;
            }
        } else {
            while (true) {
                int i4 = (int) j;
                if ((j & -128) == 0) {
                    byte[] bArr3 = this.zza;
                    int i5 = this.zzc;
                    this.zzc = i5 + 1;
                    bArr3[i5] = (byte) i4;
                    this.zzd++;
                    return;
                }
                byte[] bArr4 = this.zza;
                int i6 = this.zzc;
                this.zzc = i6 + 1;
                bArr4[i6] = (byte) ((i4 | 128) & Constants.MAX_HOST_LENGTH);
                this.zzd++;
                j >>>= 7;
            }
        }
    }
}
