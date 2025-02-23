package org.spongycastle.crypto.macs;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithSBox;

public class GOST28147Mac implements Mac {
    public final int a = 8;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6103a = true;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6104a = new byte[8];

    /* renamed from: a  reason: collision with other field name */
    public int[] f6105a = null;
    public final int b = 4;

    /* renamed from: b  reason: collision with other field name */
    public final byte[] f6106b = new byte[8];
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f6107c = null;
    public final byte[] d = {9, 6, 3, 2, 8, Ascii.VT, 1, 7, 10, 4, Ascii.SO, Ascii.SI, Ascii.FF, 0, Ascii.CR, 5, 3, 7, Ascii.SO, 9, 8, 10, Ascii.SI, 0, 5, 2, 6, Ascii.FF, Ascii.VT, 4, Ascii.CR, 1, Ascii.SO, 4, 6, 2, Ascii.VT, 3, Ascii.CR, 8, Ascii.FF, Ascii.SI, 5, 10, 0, 7, 1, 9, Ascii.SO, 7, 10, Ascii.FF, Ascii.CR, 1, 3, 9, 0, 2, Ascii.VT, 4, Ascii.SI, 8, 5, 6, Ascii.VT, 5, 1, 9, 8, Ascii.CR, Ascii.SI, 0, Ascii.SO, 4, 2, 3, Ascii.FF, 7, 10, 6, 3, 10, Ascii.CR, Ascii.FF, 1, 2, 0, Ascii.VT, 7, 5, 9, 4, 8, Ascii.SI, Ascii.SO, 6, 1, Ascii.CR, 2, 9, 7, 10, 6, 0, 8, Ascii.FF, 4, 5, Ascii.SI, 3, Ascii.VT, Ascii.SO, Ascii.VT, 10, Ascii.SI, 5, 0, Ascii.FF, Ascii.SO, 8, 6, 2, 3, 9, 1, 7, Ascii.CR, 4};

    public static byte[] f(byte[] bArr, int i, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length - i)];
        System.arraycopy(bArr, i, bArr3, 0, bArr2.length);
        for (int i2 = 0; i2 != bArr2.length; i2++) {
            bArr3[i2] = (byte) (bArr3[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    public static int g(int i, byte[] bArr) {
        return ((bArr[i + 3] << Ascii.CAN) & -16777216) + ((bArr[i + 2] << Ascii.DLE) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & UnsignedBytes.MAX_VALUE);
    }

    public static int[] h(byte[] bArr) {
        if (bArr.length == 32) {
            int[] iArr = new int[8];
            for (int i = 0; i != 8; i++) {
                iArr[i] = g(i * 4, bArr);
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public final void a(CipherParameters cipherParameters) throws IllegalArgumentException {
        reset();
        this.f6104a = new byte[this.a];
        this.f6107c = null;
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            byte[] bArr = parametersWithSBox.f6235a;
            System.arraycopy(bArr, 0, this.d, 0, bArr.length);
            CipherParameters cipherParameters2 = parametersWithSBox.a;
            if (cipherParameters2 != null) {
                this.f6105a = h(((KeyParameter) cipherParameters2).a);
            }
        } else if (cipherParameters instanceof KeyParameter) {
            this.f6105a = h(((KeyParameter) cipherParameters).a);
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f6105a = h(((KeyParameter) parametersWithIV.a).a);
            byte[] bArr2 = this.f6106b;
            int length = bArr2.length;
            byte[] bArr3 = parametersWithIV.f6233a;
            System.arraycopy(bArr3, 0, bArr2, 0, length);
            this.f6107c = bArr3;
        } else {
            throw new IllegalArgumentException(xx.H(cipherParameters, "invalid parameter passed to GOST28147 init - "));
        }
    }

    public final String b() {
        return "GOST28147Mac";
    }

    public final int c(int i, byte[] bArr) throws DataLengthException, IllegalStateException {
        while (true) {
            int i2 = this.c;
            if (i2 >= this.a) {
                break;
            }
            this.f6104a[i2] = 0;
            this.c = i2 + 1;
        }
        byte[] bArr2 = this.f6104a;
        byte[] bArr3 = new byte[bArr2.length];
        byte[] bArr4 = this.f6106b;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr4.length);
        if (this.f6103a) {
            this.f6103a = false;
        } else {
            bArr3 = f(this.f6104a, 0, bArr4);
        }
        i(this.f6105a, bArr3, bArr4);
        int i3 = this.b;
        System.arraycopy(bArr4, (bArr4.length / 2) - i3, bArr, i, i3);
        reset();
        return i3;
    }

    public final void d(byte b2) throws IllegalStateException {
        int i = this.c;
        byte[] bArr = this.f6104a;
        if (i == bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            byte[] bArr3 = this.f6106b;
            System.arraycopy(bArr, 0, bArr2, 0, bArr3.length);
            if (this.f6103a) {
                this.f6103a = false;
                byte[] bArr4 = this.f6107c;
                if (bArr4 != null) {
                    bArr2 = f(this.f6104a, 0, bArr4);
                }
            } else {
                bArr2 = f(this.f6104a, 0, bArr3);
            }
            i(this.f6105a, bArr2, bArr3);
            this.c = 0;
        }
        byte[] bArr5 = this.f6104a;
        int i2 = this.c;
        this.c = i2 + 1;
        bArr5[i2] = b2;
    }

    public final int e() {
        return this.b;
    }

    public final void i(int[] iArr, byte[] bArr, byte[] bArr2) {
        int g = g(0, bArr);
        int g2 = g(4, bArr);
        for (int i = 0; i < 2; i++) {
            int i2 = 0;
            while (i2 < 8) {
                int i3 = iArr[i2] + g;
                byte[] bArr3 = this.d;
                int i4 = (bArr3[((i3 >> 0) & 15) + 0] << 0) + (bArr3[((i3 >> 4) & 15) + 16] << 4) + (bArr3[((i3 >> 8) & 15) + 32] << 8) + (bArr3[((i3 >> 12) & 15) + 48] << Ascii.FF) + (bArr3[((i3 >> 16) & 15) + 64] << Ascii.DLE) + (bArr3[((i3 >> 20) & 15) + 80] << Ascii.DC4) + (bArr3[((i3 >> 24) & 15) + 96] << Ascii.CAN) + (bArr3[((i3 >> 28) & 15) + 112] << Ascii.FS);
                i2++;
                int i5 = g;
                g = g2 ^ ((i4 << 11) | (i4 >>> 21));
                g2 = i5;
            }
        }
        bArr2[3] = (byte) (g >>> 24);
        bArr2[2] = (byte) (g >>> 16);
        bArr2[1] = (byte) (g >>> 8);
        bArr2[0] = (byte) g;
        bArr2[7] = (byte) (g2 >>> 24);
        bArr2[6] = (byte) (g2 >>> 16);
        bArr2[5] = (byte) (g2 >>> 8);
        bArr2[4] = (byte) g2;
    }

    public final void reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f6104a;
            if (i < bArr.length) {
                bArr[i] = 0;
                i++;
            } else {
                this.c = 0;
                this.f6103a = true;
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e A[LOOP:0: B:11:0x003c->B:12:0x003e, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void update(byte[] r8, int r9, int r10) throws org.spongycastle.crypto.DataLengthException, java.lang.IllegalStateException {
        /*
            r7 = this;
            if (r10 < 0) goto L_0x0057
            int r0 = r7.c
            int r1 = r7.a
            int r2 = r1 - r0
            if (r10 <= r2) goto L_0x004a
            byte[] r3 = r7.f6104a
            java.lang.System.arraycopy(r8, r9, r3, r0, r2)
            byte[] r0 = r7.f6104a
            int r3 = r0.length
            byte[] r3 = new byte[r3]
            byte[] r4 = r7.f6106b
            int r5 = r4.length
            r6 = 0
            java.lang.System.arraycopy(r0, r6, r3, r6, r5)
            boolean r0 = r7.f6103a
            if (r0 == 0) goto L_0x002c
            r7.f6103a = r6
            byte[] r0 = r7.f6107c
            if (r0 == 0) goto L_0x0033
            byte[] r3 = r7.f6104a
            byte[] r0 = f(r3, r6, r0)
            goto L_0x0032
        L_0x002c:
            byte[] r0 = r7.f6104a
            byte[] r0 = f(r0, r6, r4)
        L_0x0032:
            r3 = r0
        L_0x0033:
            int[] r0 = r7.f6105a
            r7.i(r0, r3, r4)
            r7.c = r6
            int r10 = r10 - r2
            int r9 = r9 + r2
        L_0x003c:
            if (r10 <= r1) goto L_0x004a
            byte[] r0 = f(r8, r9, r4)
            int[] r2 = r7.f6105a
            r7.i(r2, r0, r4)
            int r10 = r10 - r1
            int r9 = r9 + r1
            goto L_0x003c
        L_0x004a:
            byte[] r0 = r7.f6104a
            int r1 = r7.c
            java.lang.System.arraycopy(r8, r9, r0, r1, r10)
            int r8 = r7.c
            int r8 = r8 + r10
            r7.c = r8
            return
        L_0x0057:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "Can't have a negative input length!"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.macs.GOST28147Mac.update(byte[], int, int):void");
    }
}
