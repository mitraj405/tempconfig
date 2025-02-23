package org.spongycastle.math.ec.custom.djb;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;

public class Curve25519Point extends ECPoint.AbstractFp {
    public Curve25519Point() {
        throw null;
    }

    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.f6622a = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: org.spongycastle.math.ec.ECFieldElement[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.spongycastle.math.ec.custom.djb.Curve25519Point A(boolean r18) {
        /*
            r17 = this;
            r0 = r17
            org.spongycastle.math.ec.ECFieldElement r1 = r0.f6621a
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r1 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r1
            org.spongycastle.math.ec.ECFieldElement r2 = r0.f6624b
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r2 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement[] r3 = r0.f6623a
            r4 = 0
            r5 = r3[r4]
            r6 = r5
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r6 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r6
            r7 = 1
            r8 = r3[r7]
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r8 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r8
            r9 = 0
            if (r8 != 0) goto L_0x0022
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r5 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r5
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r8 = r0.z(r5, r9)
            r3[r7] = r8
        L_0x0022:
            r3 = 8
            int[] r5 = new int[r3]
            int[] r10 = r1.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.d(r10, r5)
            int r10 = org.spongycastle.math.raw.Nat256.b(r5, r5, r5)
            int[] r11 = r8.a
            r12 = r11[r4]
            long r12 = (long) r12
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r12 = r12 & r14
            r9 = r5[r4]
            r16 = r8
            long r7 = (long) r9
            long r7 = r7 & r14
            long r12 = r12 + r7
            r7 = 0
            long r12 = r12 + r7
            int r7 = (int) r12
            r5[r4] = r7
            r7 = 32
            long r8 = r12 >>> r7
            r12 = 1
            r13 = r11[r12]
            long r3 = (long) r13
            long r3 = r3 & r14
            r13 = r5[r12]
            long r12 = (long) r13
            long r12 = r12 & r14
            long r3 = r3 + r12
            long r3 = r3 + r8
            int r8 = (int) r3
            r9 = 1
            r5[r9] = r8
            long r3 = r3 >>> r7
            r8 = 2
            r9 = r11[r8]
            long r12 = (long) r9
            long r12 = r12 & r14
            r9 = r5[r8]
            long r7 = (long) r9
            long r7 = r7 & r14
            long r12 = r12 + r7
            long r12 = r12 + r3
            int r3 = (int) r12
            r4 = 2
            r5[r4] = r3
            r3 = 32
            long r7 = r12 >>> r3
            r3 = 3
            r4 = r11[r3]
            long r12 = (long) r4
            long r12 = r12 & r14
            r4 = r5[r3]
            long r3 = (long) r4
            long r3 = r3 & r14
            long r12 = r12 + r3
            long r12 = r12 + r7
            int r3 = (int) r12
            r4 = 3
            r5[r4] = r3
            r3 = 32
            long r7 = r12 >>> r3
            r3 = 4
            r4 = r11[r3]
            long r12 = (long) r4
            long r12 = r12 & r14
            r4 = r5[r3]
            long r3 = (long) r4
            long r3 = r3 & r14
            long r12 = r12 + r3
            long r12 = r12 + r7
            int r3 = (int) r12
            r4 = 4
            r5[r4] = r3
            r3 = 32
            long r7 = r12 >>> r3
            r3 = 5
            r4 = r11[r3]
            long r12 = (long) r4
            long r12 = r12 & r14
            r4 = r5[r3]
            long r3 = (long) r4
            long r3 = r3 & r14
            long r12 = r12 + r3
            long r12 = r12 + r7
            int r3 = (int) r12
            r4 = 5
            r5[r4] = r3
            r3 = 32
            long r7 = r12 >>> r3
            r3 = 6
            r4 = r11[r3]
            long r12 = (long) r4
            long r12 = r12 & r14
            r4 = r5[r3]
            long r3 = (long) r4
            long r3 = r3 & r14
            long r12 = r12 + r3
            long r12 = r12 + r7
            int r3 = (int) r12
            r4 = 6
            r5[r4] = r3
            r3 = 32
            long r7 = r12 >>> r3
            r3 = 7
            r4 = r11[r3]
            long r11 = (long) r4
            long r11 = r11 & r14
            r4 = r5[r3]
            long r3 = (long) r4
            long r3 = r3 & r14
            long r11 = r11 + r3
            long r11 = r11 + r7
            int r3 = (int) r11
            r4 = 7
            r5[r4] = r3
            r3 = 32
            long r3 = r11 >>> r3
            int r3 = (int) r3
            int r10 = r10 + r3
            org.spongycastle.math.ec.custom.djb.Curve25519Field.c(r10, r5)
            r3 = 8
            int[] r4 = new int[r3]
            int[] r7 = r2.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.h(r7, r4)
            int[] r7 = new int[r3]
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r4, r2, r7)
            int[] r2 = new int[r3]
            int[] r1 = r1.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r7, r1, r2)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.h(r2, r2)
            int[] r1 = new int[r3]
            org.spongycastle.math.ec.custom.djb.Curve25519Field.d(r7, r1)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.h(r1, r1)
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r10 = new org.spongycastle.math.ec.custom.djb.Curve25519FieldElement
            r10.<init>((int[]) r7)
            int[] r3 = r10.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.d(r5, r3)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r3, r2, r3)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r3, r2, r3)
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r11 = new org.spongycastle.math.ec.custom.djb.Curve25519FieldElement
            r11.<init>((int[]) r2)
            int[] r7 = r11.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r2, r3, r7)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r7, r5, r7)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r7, r1, r7)
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r2 = new org.spongycastle.math.ec.custom.djb.Curve25519FieldElement
            r2.<init>((int[]) r4)
            int[] r3 = r6.a
            boolean r3 = org.spongycastle.math.raw.Nat256.k(r3)
            if (r3 != 0) goto L_0x0128
            int[] r3 = r2.a
            int[] r4 = r6.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r3, r4, r3)
        L_0x0128:
            if (r18 == 0) goto L_0x013c
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r9 = new org.spongycastle.math.ec.custom.djb.Curve25519FieldElement
            r9.<init>((int[]) r1)
            int[] r1 = r9.a
            r8 = r16
            int[] r3 = r8.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r1, r3, r1)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.h(r1, r1)
            goto L_0x013d
        L_0x013c:
            r9 = 0
        L_0x013d:
            org.spongycastle.math.ec.custom.djb.Curve25519Point r1 = new org.spongycastle.math.ec.custom.djb.Curve25519Point
            org.spongycastle.math.ec.ECCurve r3 = r0.f6620a
            r4 = 2
            org.spongycastle.math.ec.ECFieldElement[] r12 = new org.spongycastle.math.ec.ECFieldElement[r4]
            r4 = 0
            r12[r4] = r2
            r2 = 1
            r12[r2] = r9
            boolean r13 = r0.f6622a
            r8 = r1
            r9 = r3
            r8.<init>(r9, r10, r11, r12, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.djb.Curve25519Point.A(boolean):org.spongycastle.math.ec.custom.djb.Curve25519Point");
    }

    /* JADX WARNING: type inference failed for: r26v0, types: [org.spongycastle.math.ec.ECPoint] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.spongycastle.math.ec.ECPoint a(org.spongycastle.math.ec.ECPoint r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            boolean r2 = r25.k()
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r2 = r26.k()
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0012:
            if (r0 != r1) goto L_0x0019
            org.spongycastle.math.ec.ECPoint r1 = r25.x()
            return r1
        L_0x0019:
            org.spongycastle.math.ec.ECCurve r3 = r0.f6620a
            org.spongycastle.math.ec.ECFieldElement r2 = r0.f6621a
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r2 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r4 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement[] r5 = r0.f6623a
            r6 = 0
            r5 = r5[r6]
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r5 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r7 = r1.f6621a
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r7 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r8 = r26.i()
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r8 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r8
            org.spongycastle.math.ec.ECFieldElement r1 = r26.j()
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r1 = (org.spongycastle.math.ec.custom.djb.Curve25519FieldElement) r1
            r9 = 16
            int[] r10 = new int[r9]
            r11 = 8
            int[] r12 = new int[r11]
            int[] r13 = new int[r11]
            int[] r14 = new int[r11]
            boolean r15 = r5.h()
            int[] r5 = r5.a
            if (r15 == 0) goto L_0x0053
            int[] r7 = r7.a
            int[] r8 = r8.a
            goto L_0x0065
        L_0x0053:
            org.spongycastle.math.ec.custom.djb.Curve25519Field.d(r5, r13)
            int[] r7 = r7.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r13, r7, r12)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r13, r5, r13)
            int[] r7 = r8.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r13, r7, r13)
            r7 = r12
            r8 = r13
        L_0x0065:
            boolean r16 = r1.h()
            int[] r1 = r1.a
            if (r16 == 0) goto L_0x0072
            int[] r2 = r2.a
            int[] r4 = r4.a
            goto L_0x0084
        L_0x0072:
            org.spongycastle.math.ec.custom.djb.Curve25519Field.d(r1, r14)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r14, r2, r10)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r14, r1, r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r14, r2, r14)
            r2 = r10
            r4 = r14
        L_0x0084:
            int[] r6 = new int[r11]
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r2, r7, r6)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r4, r8, r12)
            boolean r7 = org.spongycastle.math.raw.Nat256.m(r6)
            if (r7 == 0) goto L_0x00a2
            boolean r1 = org.spongycastle.math.raw.Nat256.m(r12)
            if (r1 == 0) goto L_0x009d
            org.spongycastle.math.ec.ECPoint r1 = r25.x()
            return r1
        L_0x009d:
            org.spongycastle.math.ec.ECPoint r1 = r3.l()
            return r1
        L_0x00a2:
            int[] r7 = new int[r11]
            org.spongycastle.math.ec.custom.djb.Curve25519Field.d(r6, r7)
            int[] r8 = new int[r11]
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r7, r6, r8)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r7, r2, r13)
            boolean r2 = org.spongycastle.math.raw.Nat256.m(r8)
            if (r2 == 0) goto L_0x00b9
            org.spongycastle.math.raw.Nat256.w(r8)
            goto L_0x00be
        L_0x00b9:
            int[] r2 = org.spongycastle.math.ec.custom.djb.Curve25519Field.a
            org.spongycastle.math.raw.Nat256.r(r2, r8, r8)
        L_0x00be:
            org.spongycastle.math.raw.Nat256.o(r4, r8, r10)
            int r2 = org.spongycastle.math.raw.Nat256.b(r13, r13, r8)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.c(r2, r8)
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r4 = new org.spongycastle.math.ec.custom.djb.Curve25519FieldElement
            r4.<init>((int[]) r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.d(r12, r2)
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r2, r8, r2)
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r14 = new org.spongycastle.math.ec.custom.djb.Curve25519FieldElement
            r14.<init>((int[]) r8)
            int[] r8 = r14.a
            org.spongycastle.math.ec.custom.djb.Curve25519Field.g(r13, r2, r8)
            org.spongycastle.math.raw.Nat256.p(r8, r12, r10)
            int[] r2 = org.spongycastle.math.ec.custom.djb.Curve25519Field.b
            boolean r9 = org.spongycastle.math.raw.Nat.k(r10, r9, r2)
            if (r9 == 0) goto L_0x0152
            r9 = 0
            r13 = r10[r9]
            long r11 = (long) r13
            r17 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r11 = r11 & r17
            r13 = r2[r9]
            r19 = r10
            long r9 = (long) r13
            long r9 = r9 & r17
            long r11 = r11 - r9
            int r9 = (int) r11
            r10 = 0
            r19[r10] = r9
            r9 = 32
            long r10 = r11 >> r9
            r12 = 0
            int r20 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r12 = r19
            r9 = 8
            if (r20 == 0) goto L_0x0115
            r13 = 1
            int r10 = org.spongycastle.math.raw.Nat.h(r9, r13, r12)
            long r10 = (long) r10
        L_0x0115:
            r13 = r12[r9]
            r21 = r10
            long r9 = (long) r13
            long r9 = r9 & r17
            r23 = 19
            long r9 = r9 + r23
            long r9 = r9 + r21
            int r11 = (int) r9
            r13 = 8
            r12[r13] = r11
            r11 = 32
            long r9 = r9 >> r11
            r19 = 0
            int r11 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
            r13 = 15
            if (r11 == 0) goto L_0x0139
            r9 = 9
            int r9 = org.spongycastle.math.raw.Nat.n(r13, r9, r12)
            long r9 = (long) r9
        L_0x0139:
            r11 = r12[r13]
            r19 = r3
            r26 = r4
            long r3 = (long) r11
            long r3 = r3 & r17
            r2 = r2[r13]
            r11 = 1
            int r2 = r2 + r11
            r11 = r14
            long r13 = (long) r2
            long r13 = r13 & r17
            long r3 = r3 - r13
            long r3 = r3 + r9
            int r2 = (int) r3
            r3 = 15
            r12[r3] = r2
            goto L_0x0158
        L_0x0152:
            r19 = r3
            r26 = r4
            r12 = r10
            r11 = r14
        L_0x0158:
            org.spongycastle.math.ec.custom.djb.Curve25519Field.b(r12, r8)
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r2 = new org.spongycastle.math.ec.custom.djb.Curve25519FieldElement
            r2.<init>((int[]) r6)
            int[] r3 = r2.a
            if (r15 != 0) goto L_0x0167
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r3, r5, r3)
        L_0x0167:
            if (r16 != 0) goto L_0x016c
            org.spongycastle.math.ec.custom.djb.Curve25519Field.a(r3, r1, r3)
        L_0x016c:
            if (r15 == 0) goto L_0x0171
            if (r16 == 0) goto L_0x0171
            goto L_0x0172
        L_0x0171:
            r7 = 0
        L_0x0172:
            org.spongycastle.math.ec.custom.djb.Curve25519FieldElement r1 = r0.z(r2, r7)
            r3 = 2
            org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.ec.ECFieldElement[r3]
            r3 = 0
            r6[r3] = r2
            r2 = 1
            r6[r2] = r1
            org.spongycastle.math.ec.custom.djb.Curve25519Point r1 = new org.spongycastle.math.ec.custom.djb.Curve25519Point
            boolean r7 = r0.f6622a
            r2 = r1
            r3 = r19
            r4 = r26
            r5 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.djb.Curve25519Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new Curve25519Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECFieldElement j() {
        return super.j();
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new Curve25519Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
    }

    public final ECPoint v() {
        if (!k() && !this.f6624b.i()) {
            return A(false).a(this);
        }
        return this;
    }

    public final ECPoint x() {
        if (k()) {
            return this;
        }
        if (this.f6624b.i()) {
            return this.f6620a.l();
        }
        return A(true);
    }

    public final ECPoint y(ECPoint eCPoint) {
        if (this == eCPoint) {
            return v();
        }
        if (k()) {
            return eCPoint;
        }
        if (eCPoint.k()) {
            return x();
        }
        if (this.f6624b.i()) {
            return eCPoint;
        }
        return A(false).a(eCPoint);
    }

    public final Curve25519FieldElement z(Curve25519FieldElement curve25519FieldElement, int[] iArr) {
        Curve25519FieldElement curve25519FieldElement2 = (Curve25519FieldElement) this.f6620a.f6610a;
        if (curve25519FieldElement.h()) {
            return curve25519FieldElement2;
        }
        Curve25519FieldElement curve25519FieldElement3 = new Curve25519FieldElement();
        int[] iArr2 = curve25519FieldElement3.a;
        if (iArr == null) {
            Curve25519Field.d(curve25519FieldElement.a, iArr2);
            iArr = iArr2;
        }
        Curve25519Field.d(iArr, iArr2);
        Curve25519Field.a(iArr2, curve25519FieldElement2.a, iArr2);
        return curve25519FieldElement3;
    }

    public Curve25519Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
