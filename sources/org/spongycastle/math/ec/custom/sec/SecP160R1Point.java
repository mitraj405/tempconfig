package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160R1Point extends ECPoint.AbstractFp {
    public SecP160R1Point() {
        throw null;
    }

    public SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.f6622a = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [org.spongycastle.math.ec.ECPoint] */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fc, code lost:
        if (org.spongycastle.math.raw.Nat.k(r10, 10, org.spongycastle.math.ec.custom.sec.SecP160R1Field.b) != false) goto L_0x0101;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011e  */
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
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r2 = (org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r4 = (org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r1.f6621a
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r5 = (org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r18.i()
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r6 = (org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f6623a
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r7 = (org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r18.j()
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r1 = (org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement) r1
            r9 = 10
            int[] r10 = new int[r9]
            r11 = 5
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
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.d(r7, r13)
            int[] r5 = r5.a
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r13, r5, r12)
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r13, r7, r13)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r13, r5, r13)
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
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.d(r1, r14)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r14, r2, r10)
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r14, r1, r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r14, r2, r14)
            r2 = r10
            r4 = r14
        L_0x0083:
            int[] r9 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.f(r2, r5, r9)
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.f(r4, r6, r12)
            boolean r5 = org.spongycastle.math.raw.Nat160.g(r9)
            if (r5 == 0) goto L_0x00a1
            boolean r1 = org.spongycastle.math.raw.Nat160.g(r12)
            if (r1 == 0) goto L_0x009c
            org.spongycastle.math.ec.ECPoint r1 = r17.x()
            return r1
        L_0x009c:
            org.spongycastle.math.ec.ECPoint r1 = r3.l()
            return r1
        L_0x00a1:
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.d(r9, r13)
            int[] r5 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r13, r9, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r13, r2, r13)
            boolean r2 = org.spongycastle.math.raw.Nat160.g(r5)
            r6 = 1
            if (r2 == 0) goto L_0x00c1
            r5[r8] = r8
            r5[r6] = r8
            r2 = 2
            r5[r2] = r8
            r2 = 3
            r5[r2] = r8
            r2 = 4
            r5[r2] = r8
            goto L_0x00c6
        L_0x00c1:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP160R1Field.a
            org.spongycastle.math.raw.Nat160.k(r2, r5, r5)
        L_0x00c6:
            org.spongycastle.math.raw.Nat160.h(r4, r5, r10)
            int r2 = org.spongycastle.math.raw.Nat160.b(r13, r13, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.c(r2, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement
            r4.<init>((int[]) r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.d(r12, r2)
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.f(r2, r5, r2)
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r11 = new org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement
            r11.<init>((int[]) r5)
            int[] r5 = r11.a
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.f(r13, r2, r5)
            int r2 = org.spongycastle.math.raw.Nat160.i(r5, r12, r10)
            if (r2 != 0) goto L_0x00ff
            r2 = 9
            r2 = r10[r2]
            r12 = -1
            if (r2 != r12) goto L_0x010d
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP160R1Field.b
            r12 = 10
            boolean r2 = org.spongycastle.math.raw.Nat.k(r10, r12, r2)
            if (r2 == 0) goto L_0x010d
            goto L_0x0101
        L_0x00ff:
            r12 = 10
        L_0x0101:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP160R1Field.c
            r13 = 7
            int r2 = org.spongycastle.math.raw.Nat.d(r2, r13, r10)
            if (r2 == 0) goto L_0x010d
            org.spongycastle.math.raw.Nat.n(r12, r13, r10)
        L_0x010d:
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.b(r10, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP160R1FieldElement
            r2.<init>((int[]) r9)
            int[] r5 = r2.a
            if (r15 != 0) goto L_0x011c
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r5, r7, r5)
        L_0x011c:
            if (r16 != 0) goto L_0x0121
            org.spongycastle.math.ec.custom.sec.SecP160R1Field.a(r5, r1, r5)
        L_0x0121:
            org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.ec.ECFieldElement[r6]
            r6[r8] = r2
            org.spongycastle.math.ec.custom.sec.SecP160R1Point r1 = new org.spongycastle.math.ec.custom.sec.SecP160R1Point
            boolean r7 = r0.f6622a
            r2 = r1
            r5 = r11
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP160R1Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new SecP160R1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new SecP160R1Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
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
        SecP160R1FieldElement secP160R1FieldElement = (SecP160R1FieldElement) this.f6624b;
        if (secP160R1FieldElement.i()) {
            return eCCurve.l();
        }
        SecP160R1FieldElement secP160R1FieldElement2 = (SecP160R1FieldElement) this.f6621a;
        SecP160R1FieldElement secP160R1FieldElement3 = (SecP160R1FieldElement) this.f6623a[0];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        int[] iArr4 = new int[5];
        int[] iArr5 = secP160R1FieldElement.a;
        SecP160R1Field.d(iArr5, iArr4);
        int[] iArr6 = new int[5];
        SecP160R1Field.d(iArr4, iArr6);
        boolean h = secP160R1FieldElement3.h();
        int[] iArr7 = secP160R1FieldElement3.a;
        if (!h) {
            SecP160R1Field.d(iArr7, iArr3);
            iArr = iArr3;
        } else {
            iArr = iArr7;
        }
        SecP160R1Field.f(secP160R1FieldElement2.a, iArr, iArr2);
        int[] iArr8 = secP160R1FieldElement2.a;
        int a = Nat160.a(iArr8, iArr, iArr3);
        int[] iArr9 = SecP160R1Field.a;
        if (a != 0 || (iArr3[4] == -1 && Nat160.e(iArr3, iArr9))) {
            Nat.g(5, -2147483647, iArr3);
        }
        SecP160R1Field.a(iArr3, iArr2, iArr3);
        SecP160R1Field.c(Nat160.b(iArr3, iArr3, iArr3), iArr3);
        SecP160R1Field.a(iArr4, iArr8, iArr4);
        SecP160R1Field.c(Nat.s(5, iArr4), iArr4);
        SecP160R1Field.c(Nat.t(5, iArr6, iArr2), iArr2);
        SecP160R1FieldElement secP160R1FieldElement4 = new SecP160R1FieldElement(iArr6);
        int[] iArr10 = secP160R1FieldElement4.a;
        SecP160R1Field.d(iArr3, iArr10);
        SecP160R1Field.f(iArr10, iArr4, iArr10);
        SecP160R1Field.f(iArr10, iArr4, iArr10);
        SecP160R1FieldElement secP160R1FieldElement5 = new SecP160R1FieldElement(iArr4);
        int[] iArr11 = secP160R1FieldElement5.a;
        SecP160R1Field.f(iArr4, iArr10, iArr11);
        SecP160R1Field.a(iArr11, iArr3, iArr11);
        SecP160R1Field.f(iArr11, iArr2, iArr11);
        SecP160R1FieldElement secP160R1FieldElement6 = new SecP160R1FieldElement(iArr3);
        int[] iArr12 = secP160R1FieldElement6.a;
        if (Nat.r(5, 0, iArr5, iArr12) != 0 || (iArr12[4] == -1 && Nat160.e(iArr12, iArr9))) {
            Nat.g(5, -2147483647, iArr12);
        }
        if (!h) {
            SecP160R1Field.a(iArr12, iArr7, iArr12);
        }
        return new SecP160R1Point(eCCurve, secP160R1FieldElement4, secP160R1FieldElement5, new ECFieldElement[]{secP160R1FieldElement6}, this.f6622a);
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

    public SecP160R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
