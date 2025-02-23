package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256R1Point extends ECPoint.AbstractFp {
    public SecP256R1Point() {
        throw null;
    }

    public SecP256R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.f6622a = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [org.spongycastle.math.ec.ECPoint] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.spongycastle.math.ec.ECPoint a(org.spongycastle.math.ec.ECPoint r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r17.k()
            if (r2 == 0) goto L_0x000b
            return r1
        L_0x000b:
            boolean r2 = r18.k()
            if (r2 == 0) goto L_0x0012
            return r0
        L_0x0012:
            if (r0 != r1) goto L_0x0019
            org.spongycastle.math.ec.ECPoint r1 = r17.x()
            return r1
        L_0x0019:
            org.spongycastle.math.ec.ECCurve r3 = r0.f6620a
            org.spongycastle.math.ec.ECFieldElement r2 = r0.f6621a
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r2 = (org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r4 = (org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r1.f6621a
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r5 = (org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r18.i()
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r6 = (org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f6623a
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r7 = (org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r18.j()
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r1 = (org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement) r1
            r9 = 16
            int[] r10 = new int[r9]
            r11 = 8
            int[] r12 = new int[r11]
            int[] r13 = new int[r11]
            int[] r14 = new int[r11]
            boolean r15 = r7.h()
            int[] r7 = r7.a
            if (r15 == 0) goto L_0x0053
            int[] r5 = r5.a
            int[] r6 = r6.a
            goto L_0x0065
        L_0x0053:
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.e(r7, r13)
            int[] r5 = r5.a
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r13, r5, r12)
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r13, r7, r13)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r13, r5, r13)
            r5 = r12
            r6 = r13
        L_0x0065:
            boolean r16 = r1.h()
            int[] r1 = r1.a
            if (r16 == 0) goto L_0x0072
            int[] r2 = r2.a
            int[] r4 = r4.a
            goto L_0x0084
        L_0x0072:
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.e(r1, r14)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r14, r2, r10)
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r14, r1, r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r14, r2, r14)
            r2 = r10
            r4 = r14
        L_0x0084:
            int[] r8 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.g(r2, r5, r8)
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.g(r4, r6, r12)
            boolean r5 = org.spongycastle.math.raw.Nat256.m(r8)
            if (r5 == 0) goto L_0x00a2
            boolean r1 = org.spongycastle.math.raw.Nat256.m(r12)
            if (r1 == 0) goto L_0x009d
            org.spongycastle.math.ec.ECPoint r1 = r17.x()
            return r1
        L_0x009d:
            org.spongycastle.math.ec.ECPoint r1 = r3.l()
            return r1
        L_0x00a2:
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.e(r8, r13)
            int[] r5 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r13, r8, r5)
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r13, r2, r13)
            boolean r2 = org.spongycastle.math.raw.Nat256.m(r5)
            if (r2 == 0) goto L_0x00b7
            org.spongycastle.math.raw.Nat256.w(r5)
            goto L_0x00bc
        L_0x00b7:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP256R1Field.a
            org.spongycastle.math.raw.Nat256.r(r2, r5, r5)
        L_0x00bc:
            org.spongycastle.math.raw.Nat256.o(r4, r5, r10)
            int r2 = org.spongycastle.math.raw.Nat256.b(r13, r13, r5)
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.d(r2, r5)
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement
            r4.<init>((int[]) r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.e(r12, r2)
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.g(r2, r5, r2)
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r6 = new org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement
            r6.<init>((int[]) r5)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.g(r13, r2, r5)
            int r2 = org.spongycastle.math.raw.Nat256.p(r5, r12, r10)
            int[] r11 = org.spongycastle.math.ec.custom.sec.SecP256R1Field.b
            r12 = 1
            if (r2 != 0) goto L_0x00f6
            r2 = 15
            r2 = r10[r2]
            int r2 = r2 >>> r12
            r13 = 2147483647(0x7fffffff, float:NaN)
            if (r2 < r13) goto L_0x00f9
            boolean r2 = org.spongycastle.math.raw.Nat.k(r10, r9, r11)
            if (r2 == 0) goto L_0x00f9
        L_0x00f6:
            org.spongycastle.math.raw.Nat.x(r11, r9, r10)
        L_0x00f9:
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.c(r10, r5)
            org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP256R1FieldElement
            r2.<init>((int[]) r8)
            int[] r5 = r2.a
            if (r15 != 0) goto L_0x0108
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r5, r7, r5)
        L_0x0108:
            if (r16 != 0) goto L_0x010d
            org.spongycastle.math.ec.custom.sec.SecP256R1Field.b(r5, r1, r5)
        L_0x010d:
            org.spongycastle.math.ec.ECFieldElement[] r1 = new org.spongycastle.math.ec.ECFieldElement[r12]
            r5 = 0
            r1[r5] = r2
            org.spongycastle.math.ec.custom.sec.SecP256R1Point r8 = new org.spongycastle.math.ec.custom.sec.SecP256R1Point
            boolean r7 = r0.f6622a
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP256R1Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new SecP256R1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new SecP256R1Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
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
        SecP256R1FieldElement secP256R1FieldElement = (SecP256R1FieldElement) this.f6624b;
        if (secP256R1FieldElement.i()) {
            return eCCurve.l();
        }
        SecP256R1FieldElement secP256R1FieldElement2 = (SecP256R1FieldElement) this.f6621a;
        SecP256R1FieldElement secP256R1FieldElement3 = (SecP256R1FieldElement) this.f6623a[0];
        int[] iArr2 = new int[8];
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[8];
        int[] iArr5 = secP256R1FieldElement.a;
        SecP256R1Field.e(iArr5, iArr4);
        int[] iArr6 = new int[8];
        SecP256R1Field.e(iArr4, iArr6);
        boolean h = secP256R1FieldElement3.h();
        int[] iArr7 = secP256R1FieldElement3.a;
        if (!h) {
            SecP256R1Field.e(iArr7, iArr3);
            iArr = iArr3;
        } else {
            iArr = iArr7;
        }
        SecP256R1Field.g(secP256R1FieldElement2.a, iArr, iArr2);
        int[] iArr8 = secP256R1FieldElement2.a;
        int a = Nat256.a(iArr8, iArr, iArr3);
        int[] iArr9 = SecP256R1Field.a;
        if (a != 0 || (iArr3[7] == -1 && Nat256.j(iArr3, iArr9))) {
            SecP256R1Field.a(iArr3);
        }
        SecP256R1Field.b(iArr3, iArr2, iArr3);
        SecP256R1Field.d(Nat256.b(iArr3, iArr3, iArr3), iArr3);
        SecP256R1Field.b(iArr4, iArr8, iArr4);
        SecP256R1Field.d(Nat.s(8, iArr4), iArr4);
        SecP256R1Field.d(Nat.t(8, iArr6, iArr2), iArr2);
        SecP256R1FieldElement secP256R1FieldElement4 = new SecP256R1FieldElement(iArr6);
        int[] iArr10 = secP256R1FieldElement4.a;
        SecP256R1Field.e(iArr3, iArr10);
        SecP256R1Field.g(iArr10, iArr4, iArr10);
        SecP256R1Field.g(iArr10, iArr4, iArr10);
        SecP256R1FieldElement secP256R1FieldElement5 = new SecP256R1FieldElement(iArr4);
        int[] iArr11 = secP256R1FieldElement5.a;
        SecP256R1Field.g(iArr4, iArr10, iArr11);
        SecP256R1Field.b(iArr11, iArr3, iArr11);
        SecP256R1Field.g(iArr11, iArr2, iArr11);
        SecP256R1FieldElement secP256R1FieldElement6 = new SecP256R1FieldElement(iArr3);
        int[] iArr12 = secP256R1FieldElement6.a;
        if (Nat.r(8, 0, iArr5, iArr12) != 0 || (iArr12[7] == -1 && Nat256.j(iArr12, iArr9))) {
            SecP256R1Field.a(iArr12);
        }
        if (!h) {
            SecP256R1Field.b(iArr12, iArr7, iArr12);
        }
        return new SecP256R1Point(eCCurve, secP256R1FieldElement4, secP256R1FieldElement5, new ECFieldElement[]{secP256R1FieldElement6}, this.f6622a);
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

    public SecP256R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
