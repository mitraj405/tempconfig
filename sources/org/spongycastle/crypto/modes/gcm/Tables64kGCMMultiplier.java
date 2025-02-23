package org.spongycastle.crypto.modes.gcm;

import com.google.common.primitives.UnsignedBytes;
import java.lang.reflect.Array;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class Tables64kGCMMultiplier implements GCMMultiplier {
    public byte[] a;

    /* renamed from: a  reason: collision with other field name */
    public int[][][] f6225a;

    public final void a(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i = 15; i >= 0; i--) {
            int[] iArr2 = this.f6225a[i][bArr[i] & UnsignedBytes.MAX_VALUE];
            iArr[0] = iArr[0] ^ iArr2[0];
            iArr[1] = iArr[1] ^ iArr2[1];
            iArr[2] = iArr[2] ^ iArr2[2];
            iArr[3] = iArr2[3] ^ iArr[3];
        }
        Pack.d(bArr, iArr);
    }

    public final void b(byte[] bArr) {
        if (this.f6225a == null) {
            this.f6225a = (int[][][]) Array.newInstance(Integer.TYPE, new int[]{16, 256, 4});
        } else if (Arrays.a(this.a, bArr)) {
            return;
        }
        this.a = Arrays.c(bArr);
        int i = 0;
        int[] iArr = this.f6225a[0][128];
        int[] iArr2 = GCMUtil.a;
        Pack.b(bArr, iArr);
        for (int i2 = 64; i2 >= 1; i2 >>= 1) {
            int[][] iArr3 = this.f6225a[0];
            GCMUtil.c(iArr3[i2 + i2], iArr3[i2]);
        }
        while (true) {
            for (int i3 = 2; i3 < 256; i3 += i3) {
                for (int i4 = 1; i4 < i3; i4++) {
                    int[][] iArr4 = this.f6225a[i];
                    GCMUtil.f(iArr4[i3], iArr4[i4], iArr4[i3 + i4]);
                }
            }
            i++;
            if (i != 16) {
                for (int i5 = 128; i5 > 0; i5 >>= 1) {
                    int[][][] iArr5 = this.f6225a;
                    GCMUtil.d(iArr5[i - 1][i5], iArr5[i][i5]);
                }
            } else {
                return;
            }
        }
    }
}
