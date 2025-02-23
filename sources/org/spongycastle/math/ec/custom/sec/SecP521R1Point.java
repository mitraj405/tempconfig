package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;

public class SecP521R1Point extends ECPoint.AbstractFp {
    public SecP521R1Point() {
        throw null;
    }

    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.f6622a = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX WARNING: type inference failed for: r17v0, types: [org.spongycastle.math.ec.ECPoint] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.spongycastle.math.ec.ECPoint a(org.spongycastle.math.ec.ECPoint r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            boolean r2 = r16.k()
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r2 = r17.k()
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0012:
            if (r0 != r1) goto L_0x0019
            org.spongycastle.math.ec.ECPoint r1 = r16.x()
            return r1
        L_0x0019:
            org.spongycastle.math.ec.ECCurve r3 = r0.f6620a
            org.spongycastle.math.ec.ECFieldElement r2 = r0.f6621a
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r2 = (org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r4 = (org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r1.f6621a
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r5 = (org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r17.i()
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r6 = (org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f6623a
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r7 = (org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r17.j()
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r1 = (org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement) r1
            r9 = 17
            int[] r10 = new int[r9]
            int[] r11 = new int[r9]
            int[] r12 = new int[r9]
            int[] r13 = new int[r9]
            boolean r14 = r7.h()
            int[] r7 = r7.a
            if (r14 == 0) goto L_0x0051
            int[] r5 = r5.a
            int[] r6 = r6.a
            goto L_0x0063
        L_0x0051:
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.f(r7, r12)
            int[] r5 = r5.a
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r12, r5, r11)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r12, r7, r12)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x0063:
            boolean r15 = r1.h()
            int[] r1 = r1.a
            if (r15 == 0) goto L_0x0070
            int[] r2 = r2.a
            int[] r4 = r4.a
            goto L_0x0082
        L_0x0070:
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.f(r1, r13)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r13, r2, r10)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r13, r1, r13)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r13, r2, r13)
            r2 = r10
            r4 = r13
        L_0x0082:
            int[] r8 = new int[r9]
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.g(r2, r5, r8)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.g(r4, r6, r11)
            boolean r5 = org.spongycastle.math.raw.Nat.q(r9, r8)
            if (r5 == 0) goto L_0x00a0
            boolean r1 = org.spongycastle.math.raw.Nat.q(r9, r11)
            if (r1 == 0) goto L_0x009b
            org.spongycastle.math.ec.ECPoint r1 = r16.x()
            return r1
        L_0x009b:
            org.spongycastle.math.ec.ECPoint r1 = r3.l()
            return r1
        L_0x00a0:
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.f(r8, r12)
            int[] r5 = new int[r9]
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r12, r8, r5)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r12, r2, r12)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r4, r5, r10)
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement
            r4.<init>((int[]) r13)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.f(r11, r2)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.a(r2, r5, r2)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.g(r2, r12, r2)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.g(r2, r12, r2)
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r6 = new org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement
            r6.<init>((int[]) r5)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.g(r12, r2, r5)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r5, r11, r11)
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.g(r11, r10, r5)
            org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement
            r2.<init>((int[]) r8)
            int[] r5 = r2.a
            if (r14 != 0) goto L_0x00dd
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r5, r7, r5)
        L_0x00dd:
            if (r15 != 0) goto L_0x00e2
            org.spongycastle.math.ec.custom.sec.SecP521R1Field.c(r5, r1, r5)
        L_0x00e2:
            r1 = 1
            org.spongycastle.math.ec.ECFieldElement[] r1 = new org.spongycastle.math.ec.ECFieldElement[r1]
            r5 = 0
            r1[r5] = r2
            org.spongycastle.math.ec.custom.sec.SecP521R1Point r8 = new org.spongycastle.math.ec.custom.sec.SecP521R1Point
            boolean r7 = r0.f6622a
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP521R1Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new SecP521R1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new SecP521R1Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
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
        SecP521R1FieldElement secP521R1FieldElement = (SecP521R1FieldElement) this.f6624b;
        if (secP521R1FieldElement.i()) {
            return eCCurve.l();
        }
        SecP521R1FieldElement secP521R1FieldElement2 = (SecP521R1FieldElement) this.f6621a;
        SecP521R1FieldElement secP521R1FieldElement3 = (SecP521R1FieldElement) this.f6623a[0];
        int[] iArr2 = new int[17];
        int[] iArr3 = new int[17];
        int[] iArr4 = new int[17];
        int[] iArr5 = secP521R1FieldElement.a;
        SecP521R1Field.f(iArr5, iArr4);
        int[] iArr6 = new int[17];
        SecP521R1Field.f(iArr4, iArr6);
        boolean h = secP521R1FieldElement3.h();
        int[] iArr7 = secP521R1FieldElement3.a;
        if (!h) {
            SecP521R1Field.f(iArr7, iArr3);
            iArr = iArr3;
        } else {
            iArr = iArr7;
        }
        SecP521R1Field.g(secP521R1FieldElement2.a, iArr, iArr2);
        int[] iArr8 = secP521R1FieldElement2.a;
        SecP521R1Field.a(iArr8, iArr, iArr3);
        SecP521R1Field.c(iArr3, iArr2, iArr3);
        Nat.c(17, iArr3, iArr3, iArr3);
        SecP521R1Field.e(iArr3);
        SecP521R1Field.c(iArr4, iArr8, iArr4);
        Nat.s(17, iArr4);
        SecP521R1Field.e(iArr4);
        Nat.t(17, iArr6, iArr2);
        SecP521R1Field.e(iArr2);
        SecP521R1FieldElement secP521R1FieldElement4 = new SecP521R1FieldElement(iArr6);
        int[] iArr9 = secP521R1FieldElement4.a;
        SecP521R1Field.f(iArr3, iArr9);
        SecP521R1Field.g(iArr9, iArr4, iArr9);
        SecP521R1Field.g(iArr9, iArr4, iArr9);
        SecP521R1FieldElement secP521R1FieldElement5 = new SecP521R1FieldElement(iArr4);
        int[] iArr10 = secP521R1FieldElement5.a;
        SecP521R1Field.g(iArr4, iArr9, iArr10);
        SecP521R1Field.c(iArr10, iArr3, iArr10);
        SecP521R1Field.g(iArr10, iArr2, iArr10);
        SecP521R1FieldElement secP521R1FieldElement6 = new SecP521R1FieldElement(iArr3);
        int i = iArr5[16];
        int[] iArr11 = secP521R1FieldElement6.a;
        iArr11[16] = (Nat.r(16, i << 23, iArr5, iArr11) | (i << 1)) & 511;
        if (!h) {
            SecP521R1Field.c(iArr11, iArr7, iArr11);
        }
        return new SecP521R1Point(eCCurve, secP521R1FieldElement4, secP521R1FieldElement5, new ECFieldElement[]{secP521R1FieldElement6}, this.f6622a);
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

    public SecP521R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
