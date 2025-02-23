package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat256;

public class SecP256K1Point extends ECPoint.AbstractFp {
    public SecP256K1Point() {
        throw null;
    }

    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r2 = (org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r4 = (org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r1.f6621a
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r5 = (org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r18.i()
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r6 = (org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f6623a
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r7 = (org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r18.j()
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r1 = (org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement) r1
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
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.d(r7, r13)
            int[] r5 = r5.a
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r13, r5, r12)
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r13, r7, r13)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r13, r5, r13)
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
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.d(r1, r14)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r14, r2, r10)
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r14, r1, r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r14, r2, r14)
            r2 = r10
            r4 = r14
        L_0x0084:
            int[] r8 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.f(r2, r5, r8)
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.f(r4, r6, r12)
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
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.d(r8, r13)
            int[] r5 = new int[r11]
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r13, r8, r5)
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r13, r2, r13)
            boolean r2 = org.spongycastle.math.raw.Nat256.m(r5)
            if (r2 == 0) goto L_0x00b7
            org.spongycastle.math.raw.Nat256.w(r5)
            goto L_0x00bc
        L_0x00b7:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP256K1Field.a
            org.spongycastle.math.raw.Nat256.r(r2, r5, r5)
        L_0x00bc:
            org.spongycastle.math.raw.Nat256.o(r4, r5, r10)
            int r2 = org.spongycastle.math.raw.Nat256.b(r13, r13, r5)
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.c(r2, r5)
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement
            r4.<init>((int[]) r14)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.d(r12, r2)
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.f(r2, r5, r2)
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r6 = new org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement
            r6.<init>((int[]) r5)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.f(r13, r2, r5)
            int r2 = org.spongycastle.math.raw.Nat256.p(r5, r12, r10)
            if (r2 != 0) goto L_0x00f2
            r2 = 15
            r2 = r10[r2]
            r11 = -1
            if (r2 != r11) goto L_0x00ff
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP256K1Field.b
            boolean r2 = org.spongycastle.math.raw.Nat.k(r10, r9, r2)
            if (r2 == 0) goto L_0x00ff
        L_0x00f2:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP256K1Field.c
            r11 = 10
            int r2 = org.spongycastle.math.raw.Nat.d(r2, r11, r10)
            if (r2 == 0) goto L_0x00ff
            org.spongycastle.math.raw.Nat.n(r9, r11, r10)
        L_0x00ff:
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.b(r10, r5)
            org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP256K1FieldElement
            r2.<init>((int[]) r8)
            int[] r5 = r2.a
            if (r15 != 0) goto L_0x010e
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r5, r7, r5)
        L_0x010e:
            if (r16 != 0) goto L_0x0113
            org.spongycastle.math.ec.custom.sec.SecP256K1Field.a(r5, r1, r5)
        L_0x0113:
            r1 = 1
            org.spongycastle.math.ec.ECFieldElement[] r1 = new org.spongycastle.math.ec.ECFieldElement[r1]
            r5 = 0
            r1[r5] = r2
            org.spongycastle.math.ec.custom.sec.SecP256K1Point r8 = new org.spongycastle.math.ec.custom.sec.SecP256K1Point
            boolean r7 = r0.f6622a
            r2 = r8
            r5 = r6
            r6 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP256K1Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new SecP256K1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new SecP256K1Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
    }

    public final ECPoint v() {
        if (k() || this.f6624b.i()) {
            return this;
        }
        return x().a(this);
    }

    public final ECPoint x() {
        if (k()) {
            return this;
        }
        ECCurve eCCurve = this.f6620a;
        SecP256K1FieldElement secP256K1FieldElement = (SecP256K1FieldElement) this.f6624b;
        if (secP256K1FieldElement.i()) {
            return eCCurve.l();
        }
        SecP256K1FieldElement secP256K1FieldElement2 = (SecP256K1FieldElement) this.f6621a;
        SecP256K1FieldElement secP256K1FieldElement3 = (SecP256K1FieldElement) this.f6623a[0];
        int[] iArr = new int[8];
        int[] iArr2 = secP256K1FieldElement.a;
        SecP256K1Field.d(iArr2, iArr);
        int[] iArr3 = new int[8];
        SecP256K1Field.d(iArr, iArr3);
        int[] iArr4 = new int[8];
        SecP256K1Field.d(secP256K1FieldElement2.a, iArr4);
        SecP256K1Field.c(Nat256.b(iArr4, iArr4, iArr4), iArr4);
        SecP256K1Field.a(iArr, secP256K1FieldElement2.a, iArr);
        SecP256K1Field.c(Nat.s(8, iArr), iArr);
        int[] iArr5 = new int[8];
        SecP256K1Field.c(Nat.t(8, iArr3, iArr5), iArr5);
        SecP256K1FieldElement secP256K1FieldElement4 = new SecP256K1FieldElement(iArr3);
        int[] iArr6 = secP256K1FieldElement4.a;
        SecP256K1Field.d(iArr4, iArr6);
        SecP256K1Field.f(iArr6, iArr, iArr6);
        SecP256K1Field.f(iArr6, iArr, iArr6);
        SecP256K1FieldElement secP256K1FieldElement5 = new SecP256K1FieldElement(iArr);
        int[] iArr7 = secP256K1FieldElement5.a;
        SecP256K1Field.f(iArr, iArr6, iArr7);
        SecP256K1Field.a(iArr7, iArr4, iArr7);
        SecP256K1Field.f(iArr7, iArr5, iArr7);
        SecP256K1FieldElement secP256K1FieldElement6 = new SecP256K1FieldElement(iArr4);
        int[] iArr8 = secP256K1FieldElement6.a;
        if (Nat.r(8, 0, iArr2, iArr8) != 0 || (iArr8[7] == -1 && Nat256.j(iArr8, SecP256K1Field.a))) {
            Nat.b(8, 977, iArr8);
        }
        if (!secP256K1FieldElement3.h()) {
            SecP256K1Field.a(iArr8, secP256K1FieldElement3.a, iArr8);
        }
        return new SecP256K1Point(eCCurve, secP256K1FieldElement4, secP256K1FieldElement5, new ECFieldElement[]{secP256K1FieldElement6}, this.f6622a);
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

    public SecP256K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
