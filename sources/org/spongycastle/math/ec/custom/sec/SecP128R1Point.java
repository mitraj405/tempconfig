package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat128;

public class SecP128R1Point extends ECPoint.AbstractFp {
    public SecP128R1Point() {
        throw null;
    }

    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.f6622a = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX WARNING: type inference failed for: r38v0, types: [org.spongycastle.math.ec.ECPoint] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.spongycastle.math.ec.ECPoint a(org.spongycastle.math.ec.ECPoint r38) {
        /*
            r37 = this;
            r0 = r37
            r1 = r38
            boolean r2 = r37.k()
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r2 = r38.k()
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0012:
            if (r0 != r1) goto L_0x0019
            org.spongycastle.math.ec.ECPoint r1 = r37.x()
            return r1
        L_0x0019:
            org.spongycastle.math.ec.ECCurve r3 = r0.f6620a
            org.spongycastle.math.ec.ECFieldElement r2 = r0.f6621a
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r2 = (org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r4 = (org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r1.f6621a
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r5 = (org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r38.i()
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r6 = (org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f6623a
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r7 = (org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r38.j()
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r1 = (org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement) r1
            r9 = 8
            int[] r10 = new int[r9]
            r11 = 4
            int[] r12 = new int[r11]
            int[] r13 = new int[r11]
            int[] r14 = new int[r11]
            boolean r15 = r7.h()
            int[] r7 = r7.a
            if (r15 == 0) goto L_0x0052
            int[] r5 = r5.a
            int[] r6 = r6.a
            goto L_0x0064
        L_0x0052:
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.f(r7, r13)
            int[] r5 = r5.a
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r13, r5, r12)
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r13, r7, r13)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r13, r5, r13)
            r5 = r12
            r6 = r13
        L_0x0064:
            boolean r16 = r1.h()
            int[] r1 = r1.a
            if (r16 == 0) goto L_0x0071
            int[] r2 = r2.a
            int[] r4 = r4.a
            goto L_0x0083
        L_0x0071:
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.f(r1, r14)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r14, r2, r10)
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r14, r1, r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r14, r2, r14)
            r2 = r10
            r4 = r14
        L_0x0083:
            int[] r9 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.h(r2, r5, r9)
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.h(r4, r6, r12)
            boolean r5 = org.spongycastle.math.raw.Nat128.c(r9)
            if (r5 == 0) goto L_0x00a1
            boolean r1 = org.spongycastle.math.raw.Nat128.c(r12)
            if (r1 == 0) goto L_0x009c
            org.spongycastle.math.ec.ECPoint r1 = r37.x()
            return r1
        L_0x009c:
            org.spongycastle.math.ec.ECPoint r1 = r3.l()
            return r1
        L_0x00a1:
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.f(r9, r13)
            int[] r5 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r13, r9, r5)
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r13, r2, r13)
            boolean r2 = org.spongycastle.math.raw.Nat128.c(r5)
            r6 = 3
            r17 = 2
            r11 = 1
            if (r2 == 0) goto L_0x00bf
            r5[r8] = r8
            r5[r11] = r8
            r5[r17] = r8
            r5[r6] = r8
            goto L_0x00c4
        L_0x00bf:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP128R1Field.a
            org.spongycastle.math.raw.Nat128.f(r2, r5, r5)
        L_0x00c4:
            org.spongycastle.math.raw.Nat128.d(r4, r5, r10)
            int r2 = org.spongycastle.math.raw.Nat128.a(r13, r13, r5)
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.e(r2, r5)
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement
            r4.<init>((int[]) r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.f(r12, r2)
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.h(r2, r5, r2)
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r14 = new org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement
            r14.<init>((int[]) r5)
            int[] r5 = r14.a
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.h(r13, r2, r5)
            r2 = r12[r8]
            r19 = r9
            long r8 = (long) r2
            r20 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r8 = r8 & r20
            r2 = r12[r11]
            r22 = r14
            long r13 = (long) r2
            long r13 = r13 & r20
            r2 = r12[r17]
            r17 = r3
            long r2 = (long) r2
            long r2 = r2 & r20
            r6 = r12[r6]
            long r11 = (long) r6
            long r11 = r11 & r20
            r23 = 0
            r18 = r1
            r25 = r4
            r0 = r23
            r4 = 4
            r6 = 0
        L_0x010e:
            if (r6 >= r4) goto L_0x0181
            r4 = r5[r6]
            r26 = r5
            long r4 = (long) r4
            long r4 = r4 & r20
            long r27 = r4 * r8
            int r29 = r6 + 0
            r30 = r8
            r8 = r10[r29]
            long r8 = (long) r8
            long r8 = r8 & r20
            long r27 = r27 + r8
            long r8 = r27 + r23
            r27 = r7
            int r7 = (int) r8
            r10[r29] = r7
            r7 = 32
            long r8 = r8 >>> r7
            long r28 = r4 * r13
            int r32 = r6 + 1
            r7 = r10[r32]
            r33 = r13
            long r13 = (long) r7
            long r13 = r13 & r20
            long r28 = r28 + r13
            long r7 = r28 + r8
            int r9 = (int) r7
            r10[r32] = r9
            r9 = 32
            long r7 = r7 >>> r9
            long r13 = r4 * r2
            int r28 = r6 + 2
            r9 = r10[r28]
            r35 = r2
            long r2 = (long) r9
            long r2 = r2 & r20
            long r13 = r13 + r2
            long r13 = r13 + r7
            int r2 = (int) r13
            r10[r28] = r2
            r2 = 32
            long r7 = r13 >>> r2
            long r4 = r4 * r11
            int r3 = r6 + 3
            r9 = r10[r3]
            long r13 = (long) r9
            long r13 = r13 & r20
            long r4 = r4 + r13
            long r4 = r4 + r7
            int r7 = (int) r4
            r10[r3] = r7
            long r3 = r4 >>> r2
            int r6 = r6 + 4
            r5 = r10[r6]
            long r7 = (long) r5
            long r7 = r7 & r20
            long r0 = r0 + r7
            long r0 = r0 + r3
            int r3 = (int) r0
            r10[r6] = r3
            long r0 = r0 >>> r2
            r5 = r26
            r7 = r27
            r8 = r30
            r6 = r32
            r13 = r33
            r2 = r35
            r4 = 4
            goto L_0x010e
        L_0x0181:
            r26 = r5
            r27 = r7
            int r0 = (int) r0
            if (r0 != 0) goto L_0x019a
            r0 = 7
            r0 = r10[r0]
            r1 = 1
            int r0 = r0 >>> r1
            r1 = 2147483646(0x7ffffffe, float:NaN)
            if (r0 < r1) goto L_0x01a1
            int[] r0 = org.spongycastle.math.ec.custom.sec.SecP128R1Field.b
            boolean r0 = org.spongycastle.math.raw.Nat256.j(r10, r0)
            if (r0 == 0) goto L_0x01a1
        L_0x019a:
            int[] r0 = org.spongycastle.math.ec.custom.sec.SecP128R1Field.c
            r1 = 8
            org.spongycastle.math.raw.Nat.d(r0, r1, r10)
        L_0x01a1:
            r0 = r26
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.d(r10, r0)
            org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement r0 = new org.spongycastle.math.ec.custom.sec.SecP128R1FieldElement
            r1 = r19
            r0.<init>((int[]) r1)
            int[] r1 = r0.a
            if (r15 != 0) goto L_0x01b6
            r2 = r27
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r1, r2, r1)
        L_0x01b6:
            if (r16 != 0) goto L_0x01bd
            r2 = r18
            org.spongycastle.math.ec.custom.sec.SecP128R1Field.c(r1, r2, r1)
        L_0x01bd:
            r1 = 1
            org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.ec.ECFieldElement[r1]
            r1 = 0
            r6[r1] = r0
            org.spongycastle.math.ec.custom.sec.SecP128R1Point r0 = new org.spongycastle.math.ec.custom.sec.SecP128R1Point
            r1 = r37
            boolean r7 = r1.f6622a
            r2 = r0
            r3 = r17
            r4 = r25
            r5 = r22
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP128R1Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new SecP128R1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new SecP128R1Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
    }

    public final ECPoint v() {
        if (k() || this.f6624b.i()) {
            return this;
        }
        return x().a(this);
    }

    public final ECPoint x() {
        int[] iArr;
        if (k()) {
            return this;
        }
        ECCurve eCCurve = this.f6620a;
        SecP128R1FieldElement secP128R1FieldElement = (SecP128R1FieldElement) this.f6624b;
        if (secP128R1FieldElement.i()) {
            return eCCurve.l();
        }
        SecP128R1FieldElement secP128R1FieldElement2 = (SecP128R1FieldElement) this.f6621a;
        SecP128R1FieldElement secP128R1FieldElement3 = (SecP128R1FieldElement) this.f6623a[0];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        int[] iArr5 = secP128R1FieldElement.a;
        SecP128R1Field.f(iArr5, iArr4);
        int[] iArr6 = new int[4];
        SecP128R1Field.f(iArr4, iArr6);
        boolean h = secP128R1FieldElement3.h();
        int[] iArr7 = secP128R1FieldElement3.a;
        if (!h) {
            SecP128R1Field.f(iArr7, iArr3);
            iArr = iArr3;
        } else {
            iArr = iArr7;
        }
        SecP128R1Field.h(secP128R1FieldElement2.a, iArr, iArr2);
        int[] iArr8 = secP128R1FieldElement2.a;
        SecP128R1Field.a(iArr8, iArr, iArr3);
        SecP128R1Field.c(iArr3, iArr2, iArr3);
        SecP128R1Field.e(Nat128.a(iArr3, iArr3, iArr3), iArr3);
        SecP128R1Field.c(iArr4, iArr8, iArr4);
        SecP128R1Field.e(Nat.s(4, iArr4), iArr4);
        SecP128R1Field.e(Nat.t(4, iArr6, iArr2), iArr2);
        SecP128R1FieldElement secP128R1FieldElement4 = new SecP128R1FieldElement(iArr6);
        int[] iArr9 = secP128R1FieldElement4.a;
        SecP128R1Field.f(iArr3, iArr9);
        SecP128R1Field.h(iArr9, iArr4, iArr9);
        SecP128R1Field.h(iArr9, iArr4, iArr9);
        SecP128R1FieldElement secP128R1FieldElement5 = new SecP128R1FieldElement(iArr4);
        int[] iArr10 = secP128R1FieldElement5.a;
        SecP128R1Field.h(iArr4, iArr9, iArr10);
        SecP128R1Field.c(iArr10, iArr3, iArr10);
        SecP128R1Field.h(iArr10, iArr2, iArr10);
        SecP128R1FieldElement secP128R1FieldElement6 = new SecP128R1FieldElement(iArr3);
        int[] iArr11 = secP128R1FieldElement6.a;
        if (Nat.r(4, 0, iArr5, iArr11) != 0 || ((iArr11[3] >>> 1) >= 2147483646 && Nat128.b(iArr11, SecP128R1Field.a))) {
            SecP128R1Field.b(iArr11);
        }
        if (!h) {
            SecP128R1Field.c(iArr11, iArr7, iArr11);
        }
        return new SecP128R1Point(eCCurve, secP128R1FieldElement4, secP128R1FieldElement5, new ECFieldElement[]{secP128R1FieldElement6}, this.f6622a);
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
        return x().a(eCPoint);
    }

    public SecP128R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
