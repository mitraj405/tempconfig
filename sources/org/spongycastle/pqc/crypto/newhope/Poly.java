package org.spongycastle.pqc.crypto.newhope;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import org.spongycastle.util.Pack;

class Poly {
    public static void a(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < 1024; i++) {
            short s = ((short) (sArr[i] + sArr2[i])) & 65535;
            sArr3[i] = (short) (s - (((s * 5) >>> 16) * 12289));
        }
    }

    public static void b(byte[] bArr, short[] sArr) {
        for (int i = 0; i < 256; i++) {
            int i2 = i * 7;
            byte b = bArr[i2 + 0] & UnsignedBytes.MAX_VALUE;
            byte b2 = bArr[i2 + 1] & UnsignedBytes.MAX_VALUE;
            byte b3 = bArr[i2 + 2] & UnsignedBytes.MAX_VALUE;
            byte b4 = bArr[i2 + 3] & UnsignedBytes.MAX_VALUE;
            byte b5 = bArr[i2 + 4] & UnsignedBytes.MAX_VALUE;
            byte b6 = bArr[i2 + 5] & UnsignedBytes.MAX_VALUE;
            byte b7 = bArr[i2 + 6] & UnsignedBytes.MAX_VALUE;
            int i3 = i * 4;
            sArr[i3 + 0] = (short) (b | ((b2 & 63) << 8));
            sArr[i3 + 1] = (short) ((b2 >>> 6) | (b3 << 2) | ((b4 & Ascii.SI) << 10));
            sArr[i3 + 2] = (short) ((b4 >>> 4) | (b5 << 4) | ((b6 & 3) << Ascii.FF));
            sArr[i3 + 3] = (short) ((b7 << 6) | (b6 >>> 2));
        }
    }

    public static void c(short[] sArr) {
        for (int i = 0; i < 1024; i++) {
            short s = NTT.a[i];
            if (i < s) {
                short s2 = sArr[i];
                sArr[i] = sArr[s];
                sArr[s] = s2;
            }
        }
        NTT.a(sArr, Precomp.b);
        short[] sArr2 = Precomp.d;
        for (int i2 = 0; i2 < 1024; i2++) {
            sArr[i2] = Reduce.a((sArr[i2] & 65535) * (65535 & sArr2[i2]));
        }
    }

    public static void d(short[] sArr, byte[] bArr, byte b) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = b;
        byte[] bArr3 = new byte[4096];
        ChaCha20.a(4096, bArr, bArr2, bArr3);
        for (int i = 0; i < 1024; i++) {
            int a = Pack.a(i * 4, bArr3);
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                i2 += (a >> i3) & 16843009;
            }
            sArr[i] = (short) (((((i2 >>> 24) + (i2 >>> 0)) & Constants.MAX_HOST_LENGTH) + 12289) - (((i2 >>> 16) + (i2 >>> 8)) & Constants.MAX_HOST_LENGTH));
        }
    }

    public static short e(short s) {
        short s2 = s & 65535;
        short s3 = (short) (s2 - (((s2 * 5) >>> 16) * 12289));
        int i = s3 - 12289;
        return (short) (((s3 ^ i) & (i >> 31)) ^ i);
    }

    public static void f(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < 1024; i++) {
            sArr3[i] = Reduce.a((sArr[i] & 65535) * (65535 & Reduce.a((sArr2[i] & 65535) * 3186)));
        }
    }

    public static void g(byte[] bArr, short[] sArr) {
        for (int i = 0; i < 256; i++) {
            int i2 = i * 4;
            short e = e(sArr[i2 + 0]);
            short e2 = e(sArr[i2 + 1]);
            short e3 = e(sArr[i2 + 2]);
            short e4 = e(sArr[i2 + 3]);
            int i3 = i * 7;
            bArr[i3 + 0] = (byte) e;
            bArr[i3 + 1] = (byte) ((e >> 8) | (e2 << 6));
            bArr[i3 + 2] = (byte) (e2 >> 2);
            bArr[i3 + 3] = (byte) ((e2 >> 10) | (e3 << 4));
            bArr[i3 + 4] = (byte) (e3 >> 4);
            bArr[i3 + 5] = (byte) ((e3 >> 12) | (e4 << 2));
            bArr[i3 + 6] = (byte) (e4 >> 6);
        }
    }
}
