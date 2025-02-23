package org.spongycastle.util;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

public abstract class Pack {
    public static int a(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] & UnsignedBytes.MAX_VALUE) | (bArr[i] << Ascii.CAN) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public static void b(byte[] bArr, int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = a(i, bArr);
            i += 4;
        }
    }

    public static void c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void d(byte[] bArr, int[] iArr) {
        int i = 0;
        for (int c : iArr) {
            c(c, bArr, i);
            i += 4;
        }
    }

    public static void e(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static int f(int i, byte[] bArr) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        return (bArr[i3 + 1] << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i2] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i3] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    public static void g(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = f(i, bArr);
            i += 4;
        }
    }

    public static long h(int i, byte[] bArr) {
        return ((((long) f(i + 4, bArr)) & 4294967295L) << 32) | (((long) f(i, bArr)) & 4294967295L);
    }

    public static void i(int i, byte[] bArr, long[] jArr) {
        for (int i2 = 0; i2 < jArr.length; i2++) {
            jArr[i2] = h(i, bArr);
            i += 8;
        }
    }

    public static void j(long j, byte[] bArr, int i) {
        c((int) (j >>> 32), bArr, i);
        c((int) (j & 4294967295L), bArr, i + 4);
    }

    public static void k(int i, byte[] bArr, long[] jArr) {
        for (long l : jArr) {
            l(l, bArr, i);
            i += 8;
        }
    }

    public static void l(long j, byte[] bArr, int i) {
        e((int) (4294967295L & j), bArr, i);
        e((int) (j >>> 32), bArr, i + 4);
    }
}
