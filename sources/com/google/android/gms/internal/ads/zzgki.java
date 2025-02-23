package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgki {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i = 0;
        long zzb = zzb(bArr3, 0, 0);
        long zzb2 = zzb(bArr3, 3, 2) & 67108611;
        long zzb3 = zzb(bArr3, 6, 4) & 67092735;
        long zzb4 = zzb(bArr3, 9, 6) & 66076671;
        long zzb5 = zzb(bArr3, 12, 8) & 1048575;
        int i2 = 17;
        byte[] bArr5 = new byte[17];
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        while (true) {
            int length = bArr4.length;
            long j6 = zzb;
            if (i < length) {
                int min = Math.min(16, length - i);
                System.arraycopy(bArr4, i, bArr5, 0, min);
                bArr5[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr5, min + 1, i2, (byte) 0);
                }
                long j7 = zzb5 * 5;
                long j8 = zzb4 * 5;
                long j9 = zzb3 * 5;
                long zzb6 = j5 + zzb(bArr5, 0, 0);
                long zzb7 = j + zzb(bArr5, 3, 2);
                long zzb8 = j2 + zzb(bArr5, 6, 4);
                long zzb9 = j3 + zzb(bArr5, 9, 6);
                long j10 = zzb2;
                long zzb10 = j4 + (zzb(bArr5, 12, 8) | ((long) (bArr5[16] << Ascii.CAN)));
                long j11 = zzb7 * j6;
                long j12 = zzb7 * j10;
                long j13 = zzb8 * j6;
                long j14 = zzb7 * zzb3;
                long j15 = zzb8 * j10;
                long j16 = zzb9 * j6;
                long j17 = zzb7 * zzb4;
                long j18 = zzb8 * zzb3;
                long j19 = zzb9 * j10;
                long j20 = zzb10 * j6;
                long j21 = (zzb2 * 5 * zzb10) + (zzb9 * j9) + (zzb8 * j8) + (zzb7 * j7) + (zzb6 * j6);
                long j22 = j21 & 67108863;
                long j23 = zzb9 * j8;
                long a = C0437ME.a(j9, zzb10, j23 + (zzb8 * j7) + (zzb6 * j10) + j11, j21 >> 26);
                long j24 = zzb10;
                long a2 = C0437ME.a(j8, j24, (zzb9 * j7) + (zzb6 * zzb3) + j12 + j13, a >> 26);
                long j25 = a2 >> 26;
                j2 = a2 & 67108863;
                long a3 = C0437ME.a(zzb10, j7, (zzb6 * zzb4) + j14 + j15 + j16, j25);
                long j26 = (zzb6 * zzb5) + j17 + j18 + j19 + j20 + (a3 >> 26);
                j4 = j26 & 67108863;
                long j27 = ((j26 >> 26) * 5) + j22;
                j5 = j27 & 67108863;
                j = (a & 67108863) + (j27 >> 26);
                i += 16;
                i2 = 17;
                j3 = a3 & 67108863;
                zzb = j6;
                zzb2 = j10;
            } else {
                long j28 = j2 + (j >> 26);
                long j29 = j28 & 67108863;
                long j30 = j3 + (j28 >> 26);
                long j31 = j30 & 67108863;
                long j32 = j4 + (j30 >> 26);
                long j33 = j32 & 67108863;
                long j34 = ((j32 >> 26) * 5) + j5;
                long j35 = j34 >> 26;
                long j36 = j34 & 67108863;
                long j37 = j36 + 5;
                long j38 = (j & 67108863) + j35;
                long j39 = (j37 >> 26) + j38;
                long j40 = (j39 >> 26) + j29;
                long j41 = j31 + (j40 >> 26);
                long j42 = (j33 + (j41 >> 26)) - 67108864;
                long j43 = j42 >> 63;
                long j44 = j33;
                long j45 = ~j43;
                long j46 = (j38 & j43) | (j39 & 67108863 & j45);
                long j47 = (j29 & j43) | (j40 & 67108863 & j45);
                long j48 = (j31 & j43) | (j41 & 67108863 & j45);
                long j49 = (j44 & j43) | (j42 & j45);
                byte[] bArr6 = bArr;
                long zzc = (((j36 & j43) | (j37 & 67108863 & j45) | (j46 << 26)) & 4294967295L) + zzc(bArr6, 16);
                long zzc2 = (((j46 >> 6) | (j47 << 20)) & 4294967295L) + zzc(bArr6, 20);
                long zzc3 = (((j48 << 14) | (j47 >> 12)) & 4294967295L) + zzc(bArr6, 24);
                long zzc4 = (((j48 >> 18) | (j49 << 8)) & 4294967295L) + zzc(bArr6, 28);
                byte[] bArr7 = new byte[16];
                zzd(bArr7, zzc & 4294967295L, 0);
                long j50 = zzc2 + (zzc >> 32);
                zzd(bArr7, j50 & 4294967295L, 4);
                long j51 = zzc3 + (j50 >> 32);
                zzd(bArr7, j51 & 4294967295L, 8);
                zzd(bArr7, (zzc4 + (j51 >> 32)) & 4294967295L, 12);
                return bArr7;
            }
        }
    }

    private static long zzb(byte[] bArr, int i, int i2) {
        return (zzc(bArr, i) >> i2) & 67108863;
    }

    private static long zzc(byte[] bArr, int i) {
        byte b = bArr[i] & UnsignedBytes.MAX_VALUE;
        byte b2 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        byte b3 = bArr[i + 2] & UnsignedBytes.MAX_VALUE;
        return ((long) (((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (b2 << 8) | b | (b3 << Ascii.DLE))) & 4294967295L;
    }

    private static void zzd(byte[] bArr, long j, int i) {
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            j >>= 8;
        }
    }
}
