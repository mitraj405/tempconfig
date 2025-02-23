package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;

public class SecP384R1Point extends ECPoint.AbstractFp {
    public SecP384R1Point() {
        throw null;
    }

    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r2 = (org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = (org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r1.f6621a
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r5 = (org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r18.i()
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r6 = (org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f6623a
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r7 = (org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r18.j()
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r1 = (org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement) r1
            r9 = 24
            int[] r10 = new int[r9]
            int[] r11 = new int[r9]
            r12 = 12
            int[] r13 = new int[r12]
            int[] r14 = new int[r12]
            boolean r15 = r7.h()
            int[] r7 = r7.a
            if (r15 == 0) goto L_0x0053
            int[] r5 = r5.a
            int[] r6 = r6.a
            goto L_0x0065
        L_0x0053:
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.e(r7, r13)
            int[] r5 = r5.a
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r13, r5, r11)
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r13, r7, r13)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r13, r5, r13)
            r5 = r11
            r6 = r13
        L_0x0065:
            boolean r16 = r1.h()
            int[] r1 = r1.a
            if (r16 == 0) goto L_0x0072
            int[] r2 = r2.a
            int[] r4 = r4.a
            goto L_0x0084
        L_0x0072:
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.e(r1, r14)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r14, r2, r10)
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r14, r1, r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r14, r2, r14)
            r2 = r10
            r4 = r14
        L_0x0084:
            int[] r9 = new int[r12]
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.g(r2, r5, r9)
            int[] r5 = new int[r12]
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.g(r4, r6, r5)
            boolean r6 = org.spongycastle.math.raw.Nat.q(r12, r9)
            if (r6 == 0) goto L_0x00a4
            boolean r1 = org.spongycastle.math.raw.Nat.q(r12, r5)
            if (r1 == 0) goto L_0x009f
            org.spongycastle.math.ec.ECPoint r1 = r17.x()
            return r1
        L_0x009f:
            org.spongycastle.math.ec.ECPoint r1 = r3.l()
            return r1
        L_0x00a4:
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.e(r9, r13)
            int[] r6 = new int[r12]
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r13, r9, r6)
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r13, r2, r13)
            boolean r2 = org.spongycastle.math.raw.Nat.q(r12, r6)
            if (r2 == 0) goto L_0x00bd
            r2 = r8
        L_0x00b6:
            if (r2 >= r12) goto L_0x00c2
            r6[r2] = r8
            int r2 = r2 + 1
            goto L_0x00b6
        L_0x00bd:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP384R1Field.a
            org.spongycastle.math.raw.Nat.u(r12, r2, r6, r6)
        L_0x00c2:
            org.spongycastle.math.raw.Nat384.a(r4, r6, r10)
            int r2 = org.spongycastle.math.raw.Nat.c(r12, r13, r13, r6)
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.d(r2, r6)
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement
            r4.<init>((int[]) r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.e(r5, r2)
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.g(r2, r6, r2)
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r12 = new org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement
            r12.<init>((int[]) r6)
            int[] r6 = r12.a
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.g(r13, r2, r6)
            org.spongycastle.math.raw.Nat384.a(r6, r5, r11)
            r2 = 24
            int r5 = org.spongycastle.math.raw.Nat.a(r2, r10, r11, r10)
            if (r5 != 0) goto L_0x00fd
            r5 = 23
            r5 = r10[r5]
            r11 = -1
            if (r5 != r11) goto L_0x010a
            int[] r5 = org.spongycastle.math.ec.custom.sec.SecP384R1Field.b
            boolean r5 = org.spongycastle.math.raw.Nat.k(r10, r2, r5)
            if (r5 == 0) goto L_0x010a
        L_0x00fd:
            int[] r5 = org.spongycastle.math.ec.custom.sec.SecP384R1Field.c
            r11 = 17
            int r5 = org.spongycastle.math.raw.Nat.d(r5, r11, r10)
            if (r5 == 0) goto L_0x010a
            org.spongycastle.math.raw.Nat.n(r2, r11, r10)
        L_0x010a:
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.c(r10, r6)
            org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement
            r2.<init>((int[]) r9)
            int[] r5 = r2.a
            if (r15 != 0) goto L_0x0119
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r5, r7, r5)
        L_0x0119:
            if (r16 != 0) goto L_0x011e
            org.spongycastle.math.ec.custom.sec.SecP384R1Field.b(r5, r1, r5)
        L_0x011e:
            r1 = 1
            org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.ec.ECFieldElement[r1]
            r6[r8] = r2
            org.spongycastle.math.ec.custom.sec.SecP384R1Point r1 = new org.spongycastle.math.ec.custom.sec.SecP384R1Point
            boolean r7 = r0.f6622a
            r2 = r1
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP384R1Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new SecP384R1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new SecP384R1Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
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
        SecP384R1FieldElement secP384R1FieldElement = (SecP384R1FieldElement) this.f6624b;
        if (secP384R1FieldElement.i()) {
            return eCCurve.l();
        }
        SecP384R1FieldElement secP384R1FieldElement2 = (SecP384R1FieldElement) this.f6621a;
        SecP384R1FieldElement secP384R1FieldElement3 = (SecP384R1FieldElement) this.f6623a[0];
        int[] iArr2 = new int[12];
        int[] iArr3 = new int[12];
        int[] iArr4 = new int[12];
        int[] iArr5 = secP384R1FieldElement.a;
        SecP384R1Field.e(iArr5, iArr4);
        int[] iArr6 = new int[12];
        SecP384R1Field.e(iArr4, iArr6);
        boolean h = secP384R1FieldElement3.h();
        int[] iArr7 = secP384R1FieldElement3.a;
        if (!h) {
            SecP384R1Field.e(iArr7, iArr3);
            iArr = iArr3;
        } else {
            iArr = iArr7;
        }
        SecP384R1Field.g(secP384R1FieldElement2.a, iArr, iArr2);
        int[] iArr8 = secP384R1FieldElement2.a;
        int a = Nat.a(12, iArr8, iArr, iArr3);
        int[] iArr9 = SecP384R1Field.a;
        if (a != 0 || (iArr3[11] == -1 && Nat.k(iArr3, 12, iArr9))) {
            SecP384R1Field.a(iArr3);
        }
        SecP384R1Field.b(iArr3, iArr2, iArr3);
        SecP384R1Field.d(Nat.c(12, iArr3, iArr3, iArr3), iArr3);
        SecP384R1Field.b(iArr4, iArr8, iArr4);
        SecP384R1Field.d(Nat.s(12, iArr4), iArr4);
        SecP384R1Field.d(Nat.t(12, iArr6, iArr2), iArr2);
        SecP384R1FieldElement secP384R1FieldElement4 = new SecP384R1FieldElement(iArr6);
        int[] iArr10 = secP384R1FieldElement4.a;
        SecP384R1Field.e(iArr3, iArr10);
        SecP384R1Field.g(iArr10, iArr4, iArr10);
        SecP384R1Field.g(iArr10, iArr4, iArr10);
        SecP384R1FieldElement secP384R1FieldElement5 = new SecP384R1FieldElement(iArr4);
        int[] iArr11 = secP384R1FieldElement5.a;
        SecP384R1Field.g(iArr4, iArr10, iArr11);
        SecP384R1Field.b(iArr11, iArr3, iArr11);
        SecP384R1Field.g(iArr11, iArr2, iArr11);
        SecP384R1FieldElement secP384R1FieldElement6 = new SecP384R1FieldElement(iArr3);
        int[] iArr12 = secP384R1FieldElement6.a;
        if (Nat.r(12, 0, iArr5, iArr12) != 0 || (iArr12[11] == -1 && Nat.k(iArr12, 12, iArr9))) {
            SecP384R1Field.a(iArr12);
        }
        if (!h) {
            SecP384R1Field.b(iArr12, iArr7, iArr12);
        }
        return new SecP384R1Point(eCCurve, secP384R1FieldElement4, secP384R1FieldElement5, new ECFieldElement[]{secP384R1FieldElement6}, this.f6622a);
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

    public SecP384R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
