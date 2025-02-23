package org.spongycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import org.spongycastle.util.Memoable;

public class RIPEMD256Digest extends GeneralDigest {
    public final int[] a = new int[16];
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    public RIPEMD256Digest() {
        reset();
    }

    public final Memoable a() {
        return new RIPEMD256Digest(this);
    }

    public final String b() {
        return "RIPEMD256";
    }

    public final int c(int i2, byte[] bArr) {
        j();
        x(this.b, bArr, i2);
        x(this.c, bArr, i2 + 4);
        x(this.d, bArr, i2 + 8);
        x(this.e, bArr, i2 + 12);
        x(this.f, bArr, i2 + 16);
        x(this.g, bArr, i2 + 20);
        x(this.h, bArr, i2 + 24);
        x(this.i, bArr, i2 + 28);
        reset();
        return 32;
    }

    public final void e(Memoable memoable) {
        w((RIPEMD256Digest) memoable);
    }

    public final int f() {
        return 32;
    }

    public final void k() {
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        int i5 = this.e;
        int i6 = this.f;
        int i7 = this.g;
        int i8 = this.h;
        int i9 = this.i;
        int[] iArr = this.a;
        int n = n(i2, i3, i4, i5, iArr[0], 11);
        int n2 = n(i5, n, i3, i4, iArr[1], 14);
        int n3 = n(i4, n2, n, i3, iArr[2], 15);
        int n4 = n(i3, n3, n2, n, iArr[3], 12);
        int n5 = n(n, n4, n3, n2, iArr[4], 5);
        int n6 = n(n2, n5, n4, n3, iArr[5], 8);
        int n7 = n(n3, n6, n5, n4, iArr[6], 7);
        int n8 = n(n4, n7, n6, n5, iArr[7], 9);
        int n9 = n(n5, n8, n7, n6, iArr[8], 11);
        int n10 = n(n6, n9, n8, n7, iArr[9], 13);
        int n11 = n(n7, n10, n9, n8, iArr[10], 14);
        int n12 = n(n8, n11, n10, n9, iArr[11], 15);
        int n13 = n(n9, n12, n11, n10, iArr[12], 6);
        int n14 = n(n10, n13, n12, n11, iArr[13], 7);
        int n15 = n(n11, n14, n13, n12, iArr[14], 9);
        int n16 = n(n12, n15, n14, n13, iArr[15], 8);
        int u = u(i6, i7, i8, i9, iArr[5], 8);
        int u2 = u(i9, u, i7, i8, iArr[14], 9);
        int u3 = u(i8, u2, u, i7, iArr[7], 9);
        int u4 = u(i7, u3, u2, u, iArr[0], 11);
        int u5 = u(u, u4, u3, u2, iArr[9], 13);
        int u6 = u(u2, u5, u4, u3, iArr[2], 15);
        int u7 = u(u3, u6, u5, u4, iArr[11], 15);
        int u8 = u(u4, u7, u6, u5, iArr[4], 5);
        int u9 = u(u5, u8, u7, u6, iArr[13], 7);
        int u10 = u(u6, u9, u8, u7, iArr[6], 7);
        int u11 = u(u7, u10, u9, u8, iArr[15], 8);
        int u12 = u(u8, u11, u10, u9, iArr[8], 11);
        int u13 = u(u9, u12, u11, u10, iArr[1], 14);
        int u14 = u(u10, u13, u12, u11, iArr[10], 14);
        int u15 = u(u11, u14, u13, u12, iArr[3], 12);
        int u16 = u(u12, u15, u14, u13, iArr[12], 6);
        int o = o(u13, n16, n15, n14, iArr[7], 7);
        int o2 = o(n14, o, n16, n15, iArr[4], 6);
        int o3 = o(n15, o2, o, n16, iArr[13], 8);
        int o4 = o(n16, o3, o2, o, iArr[1], 13);
        int o5 = o(o, o4, o3, o2, iArr[10], 11);
        int o6 = o(o2, o5, o4, o3, iArr[6], 9);
        int o7 = o(o3, o6, o5, o4, iArr[15], 7);
        int o8 = o(o4, o7, o6, o5, iArr[3], 15);
        int o9 = o(o5, o8, o7, o6, iArr[12], 7);
        int o10 = o(o6, o9, o8, o7, iArr[0], 12);
        int o11 = o(o7, o10, o9, o8, iArr[9], 15);
        int o12 = o(o8, o11, o10, o9, iArr[5], 9);
        int o13 = o(o9, o12, o11, o10, iArr[2], 11);
        int o14 = o(o10, o13, o12, o11, iArr[14], 7);
        int o15 = o(o11, o14, o13, o12, iArr[11], 13);
        int o16 = o(o12, o15, o14, o13, iArr[8], 12);
        int t = t(n13, u16, u15, u14, iArr[6], 9);
        int t2 = t(u14, t, u16, u15, iArr[11], 13);
        int t3 = t(u15, t2, t, u16, iArr[3], 15);
        int t4 = t(u16, t3, t2, t, iArr[7], 7);
        int t5 = t(t, t4, t3, t2, iArr[0], 12);
        int t6 = t(t2, t5, t4, t3, iArr[13], 8);
        int t7 = t(t3, t6, t5, t4, iArr[5], 9);
        int t8 = t(t4, t7, t6, t5, iArr[10], 11);
        int t9 = t(t5, t8, t7, t6, iArr[14], 7);
        int t10 = t(t6, t9, t8, t7, iArr[15], 7);
        int t11 = t(t7, t10, t9, t8, iArr[8], 12);
        int t12 = t(t8, t11, t10, t9, iArr[12], 7);
        int t13 = t(t9, t12, t11, t10, iArr[4], 6);
        int t14 = t(t10, t13, t12, t11, iArr[9], 15);
        int t15 = t(t11, t14, t13, t12, iArr[1], 13);
        int t16 = t(t12, t15, t14, t13, iArr[2], 11);
        int p = p(o13, t16, o15, o14, iArr[3], 11);
        int p2 = p(o14, p, t16, o15, iArr[10], 13);
        int p3 = p(o15, p2, p, t16, iArr[14], 6);
        int p4 = p(t16, p3, p2, p, iArr[4], 7);
        int p5 = p(p, p4, p3, p2, iArr[9], 14);
        int p6 = p(p2, p5, p4, p3, iArr[15], 9);
        int p7 = p(p3, p6, p5, p4, iArr[8], 13);
        int p8 = p(p4, p7, p6, p5, iArr[1], 15);
        int p9 = p(p5, p8, p7, p6, iArr[2], 14);
        int p10 = p(p6, p9, p8, p7, iArr[7], 8);
        int p11 = p(p7, p10, p9, p8, iArr[0], 13);
        int p12 = p(p8, p11, p10, p9, iArr[6], 6);
        int p13 = p(p9, p12, p11, p10, iArr[13], 5);
        int p14 = p(p10, p13, p12, p11, iArr[11], 12);
        int p15 = p(p11, p14, p13, p12, iArr[5], 7);
        int p16 = p(p12, p15, p14, p13, iArr[12], 5);
        int s = s(t13, o16, t15, t14, iArr[15], 9);
        int s2 = s(t14, s, o16, t15, iArr[5], 7);
        int s3 = s(t15, s2, s, o16, iArr[1], 15);
        int s4 = s(o16, s3, s2, s, iArr[3], 11);
        int s5 = s(s, s4, s3, s2, iArr[7], 8);
        int s6 = s(s2, s5, s4, s3, iArr[14], 6);
        int s7 = s(s3, s6, s5, s4, iArr[6], 6);
        int s8 = s(s4, s7, s6, s5, iArr[9], 14);
        int s9 = s(s5, s8, s7, s6, iArr[11], 12);
        int s10 = s(s6, s9, s8, s7, iArr[8], 13);
        int s11 = s(s7, s10, s9, s8, iArr[12], 5);
        int s12 = s(s8, s11, s10, s9, iArr[2], 14);
        int s13 = s(s9, s12, s11, s10, iArr[10], 13);
        int s14 = s(s10, s13, s12, s11, iArr[0], 13);
        int s15 = s(s11, s14, s13, s12, iArr[4], 7);
        int s16 = s(s12, s15, s14, s13, iArr[13], 5);
        int q = q(p13, p16, s15, p14, iArr[1], 11);
        int q2 = q(p14, q, p16, s15, iArr[9], 12);
        int q3 = q(s15, q2, q, p16, iArr[11], 14);
        int q4 = q(p16, q3, q2, q, iArr[10], 15);
        int q5 = q(q, q4, q3, q2, iArr[0], 14);
        int q6 = q(q2, q5, q4, q3, iArr[8], 15);
        int q7 = q(q3, q6, q5, q4, iArr[12], 9);
        int q8 = q(q4, q7, q6, q5, iArr[4], 8);
        int q9 = q(q5, q8, q7, q6, iArr[13], 9);
        int q10 = q(q6, q9, q8, q7, iArr[3], 14);
        int q11 = q(q7, q10, q9, q8, iArr[7], 5);
        int q12 = q(q8, q11, q10, q9, iArr[15], 6);
        int q13 = q(q9, q12, q11, q10, iArr[14], 8);
        int q14 = q(q10, q13, q12, q11, iArr[5], 6);
        int q15 = q(q11, q14, q13, q12, iArr[6], 5);
        int q16 = q(q12, q15, q14, q13, iArr[2], 12);
        int r = r(s13, s16, p15, s14, iArr[8], 15);
        int r2 = r(s14, r, s16, p15, iArr[6], 5);
        int r3 = r(p15, r2, r, s16, iArr[4], 8);
        int r4 = r(s16, r3, r2, r, iArr[1], 11);
        int r5 = r(r, r4, r3, r2, iArr[3], 14);
        int r6 = r(r2, r5, r4, r3, iArr[11], 14);
        int r7 = r(r3, r6, r5, r4, iArr[15], 6);
        int r8 = r(r4, r7, r6, r5, iArr[0], 14);
        int r9 = r(r5, r8, r7, r6, iArr[5], 6);
        int r10 = r(r6, r9, r8, r7, iArr[12], 9);
        int r11 = r(r7, r10, r9, r8, iArr[2], 12);
        int r12 = r(r8, r11, r10, r9, iArr[13], 9);
        int r13 = r(r9, r12, r11, r10, iArr[9], 12);
        int r14 = r(r10, r13, r12, r11, iArr[7], 5);
        int r15 = r(r11, r14, r13, r12, iArr[10], 15);
        int r16 = r(r12, r15, r14, r13, iArr[14], 8);
        this.b += q13;
        this.c += q16;
        this.d += q15;
        this.e += r14;
        this.f += r13;
        this.g += r16;
        this.h += r15;
        this.i += q14;
        this.j = 0;
        for (int i10 = 0; i10 != iArr.length; i10++) {
            iArr[i10] = 0;
        }
    }

    public final void l(long j2) {
        if (this.j > 14) {
            k();
        }
        int[] iArr = this.a;
        iArr[14] = (int) (-1 & j2);
        iArr[15] = (int) (j2 >>> 32);
    }

    public final void m(int i2, byte[] bArr) {
        int i3 = this.j;
        int i4 = i3 + 1;
        this.j = i4;
        int i5 = (bArr[i2 + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN;
        this.a[i3] = i5 | (bArr[i2] & UnsignedBytes.MAX_VALUE) | ((bArr[i2 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i2 + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
        if (i4 == 16) {
            k();
        }
    }

    public final int n(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(i2 + ((i3 ^ i4) ^ i5) + i6, i7);
    }

    public final int o(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(i2 + (((~i3) & i5) | (i4 & i3)) + i6 + 1518500249, i7);
    }

    public final int p(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(i2 + ((i3 | (~i4)) ^ i5) + i6 + 1859775393, i7);
    }

    public final int q(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(((i2 + ((i3 & i5) | (i4 & (~i5)))) + i6) - 1894007588, i7);
    }

    public final int r(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(i2 + ((i3 ^ i4) ^ i5) + i6, i7);
    }

    public final void reset() {
        super.reset();
        this.b = 1732584193;
        this.c = -271733879;
        this.d = -1732584194;
        this.e = 271733878;
        this.f = 1985229328;
        this.g = -19088744;
        this.h = -1985229329;
        this.i = 19088743;
        this.j = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 != iArr.length) {
                iArr[i2] = 0;
                i2++;
            } else {
                return;
            }
        }
    }

    public final int s(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(i2 + (((~i3) & i5) | (i4 & i3)) + i6 + 1836072691, i7);
    }

    public final int t(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(i2 + ((i3 | (~i4)) ^ i5) + i6 + 1548603684, i7);
    }

    public final int u(int i2, int i3, int i4, int i5, int i6, int i7) {
        return v(i2 + ((i3 & i5) | (i4 & (~i5))) + i6 + 1352829926, i7);
    }

    public final int v(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public final void w(RIPEMD256Digest rIPEMD256Digest) {
        i(rIPEMD256Digest);
        this.b = rIPEMD256Digest.b;
        this.c = rIPEMD256Digest.c;
        this.d = rIPEMD256Digest.d;
        this.e = rIPEMD256Digest.e;
        this.f = rIPEMD256Digest.f;
        this.g = rIPEMD256Digest.g;
        this.h = rIPEMD256Digest.h;
        this.i = rIPEMD256Digest.i;
        int[] iArr = this.a;
        int[] iArr2 = rIPEMD256Digest.a;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this.j = rIPEMD256Digest.j;
    }

    public final void x(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 3] = (byte) (i2 >>> 24);
    }

    public RIPEMD256Digest(RIPEMD256Digest rIPEMD256Digest) {
        super(rIPEMD256Digest);
        w(rIPEMD256Digest);
    }
}
