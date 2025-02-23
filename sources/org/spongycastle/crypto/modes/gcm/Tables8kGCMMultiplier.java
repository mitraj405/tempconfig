package org.spongycastle.crypto.modes.gcm;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class Tables8kGCMMultiplier implements GCMMultiplier {
    public byte[] a;

    /* renamed from: a  reason: collision with other field name */
    public int[][][] f6226a;

    public final void a(byte[] bArr) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        for (int i = 15; i >= 0; i--) {
            int[][][] iArr2 = this.f6226a;
            int i2 = i + i;
            int[][] iArr3 = iArr2[i2];
            byte b = bArr2[i];
            int[] iArr4 = iArr3[b & Ascii.SI];
            int i3 = iArr[0] ^ iArr4[0];
            iArr[0] = i3;
            int i4 = iArr[1] ^ iArr4[1];
            iArr[1] = i4;
            int i5 = iArr[2] ^ iArr4[2];
            iArr[2] = i5;
            int i6 = iArr[3] ^ iArr4[3];
            iArr[3] = i6;
            int[] iArr5 = iArr2[i2 + 1][(b & 240) >>> 4];
            iArr[0] = iArr5[0] ^ i3;
            iArr[1] = iArr5[1] ^ i4;
            iArr[2] = iArr5[2] ^ i5;
            iArr[3] = iArr5[3] ^ i6;
        }
        Pack.d(bArr2, iArr);
    }

    public final void b(byte[] bArr) {
        if (this.f6226a == null) {
            this.f6226a = (int[][][]) Array.newInstance(Integer.TYPE, new int[]{32, 16, 4});
        } else if (Arrays.a(this.a, bArr)) {
            return;
        }
        this.a = Arrays.c(bArr);
        int[] iArr = this.f6226a[1][8];
        int[] iArr2 = GCMUtil.a;
        Pack.b(bArr, iArr);
        for (int i = 4; i >= 1; i >>= 1) {
            int[][] iArr3 = this.f6226a[1];
            GCMUtil.c(iArr3[i + i], iArr3[i]);
        }
        int[][][] iArr4 = this.f6226a;
        int i2 = 0;
        GCMUtil.c(iArr4[1][1], iArr4[0][8]);
        for (int i3 = 4; i3 >= 1; i3 >>= 1) {
            int[][] iArr5 = this.f6226a[0];
            GCMUtil.c(iArr5[i3 + i3], iArr5[i3]);
        }
        while (true) {
            for (int i4 = 2; i4 < 16; i4 += i4) {
                for (int i5 = 1; i5 < i4; i5++) {
                    int[][] iArr6 = this.f6226a[i2];
                    GCMUtil.f(iArr6[i4], iArr6[i5], iArr6[i4 + i5]);
                }
            }
            i2++;
            if (i2 != 32) {
                if (i2 > 1) {
                    for (int i6 = 8; i6 > 0; i6 >>= 1) {
                        int[][][] iArr7 = this.f6226a;
                        GCMUtil.d(iArr7[i2 - 2][i6], iArr7[i2][i6]);
                    }
                }
            } else {
                return;
            }
        }
    }
}
