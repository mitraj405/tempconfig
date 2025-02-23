package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.math.raw.Nat160;

public class SecP160K1Point extends ECPoint.AbstractFp {
    public SecP160K1Point() {
        throw null;
    }

    public SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r2 = (org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement) r2
            org.spongycastle.math.ec.ECFieldElement r4 = r0.f6624b
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r4 = (org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement) r4
            org.spongycastle.math.ec.ECFieldElement r5 = r1.f6621a
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r5 = (org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement) r5
            org.spongycastle.math.ec.ECFieldElement r6 = r17.i()
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r6 = (org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement) r6
            org.spongycastle.math.ec.ECFieldElement[] r7 = r0.f6623a
            r8 = 0
            r7 = r7[r8]
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r7 = (org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement) r7
            org.spongycastle.math.ec.ECFieldElement r1 = r17.j()
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r1 = (org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement) r1
            r9 = 10
            int[] r9 = new int[r9]
            r10 = 5
            int[] r11 = new int[r10]
            int[] r12 = new int[r10]
            int[] r13 = new int[r10]
            boolean r14 = r7.h()
            int[] r7 = r7.a
            if (r14 == 0) goto L_0x0052
            int[] r5 = r5.a
            int[] r6 = r6.a
            goto L_0x0064
        L_0x0052:
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.e(r7, r12)
            int[] r5 = r5.a
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r12, r5, r11)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r12, r7, r12)
            int[] r5 = r6.a
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r12, r5, r12)
            r5 = r11
            r6 = r12
        L_0x0064:
            boolean r15 = r1.h()
            int[] r1 = r1.a
            if (r15 == 0) goto L_0x0071
            int[] r2 = r2.a
            int[] r4 = r4.a
            goto L_0x0083
        L_0x0071:
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.e(r1, r13)
            int[] r2 = r2.a
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r13, r2, r9)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r13, r1, r13)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r13, r2, r13)
            r2 = r9
            r4 = r13
        L_0x0083:
            int[] r8 = new int[r10]
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.g(r2, r5, r8)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.g(r4, r6, r11)
            boolean r5 = org.spongycastle.math.raw.Nat160.g(r8)
            if (r5 == 0) goto L_0x00a1
            boolean r1 = org.spongycastle.math.raw.Nat160.g(r11)
            if (r1 == 0) goto L_0x009c
            org.spongycastle.math.ec.ECPoint r1 = r16.x()
            return r1
        L_0x009c:
            org.spongycastle.math.ec.ECPoint r1 = r3.l()
            return r1
        L_0x00a1:
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.e(r8, r12)
            int[] r5 = new int[r10]
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r12, r8, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r12, r2, r12)
            boolean r2 = org.spongycastle.math.raw.Nat160.g(r5)
            r6 = 1
            if (r2 == 0) goto L_0x00c2
            r2 = 0
            r5[r2] = r2
            r5[r6] = r2
            r10 = 2
            r5[r10] = r2
            r10 = 3
            r5[r10] = r2
            r10 = 4
            r5[r10] = r2
            goto L_0x00c7
        L_0x00c2:
            int[] r2 = org.spongycastle.math.ec.custom.sec.SecP160R2Field.a
            org.spongycastle.math.raw.Nat160.k(r2, r5, r5)
        L_0x00c7:
            org.spongycastle.math.raw.Nat160.h(r4, r5, r9)
            int r2 = org.spongycastle.math.raw.Nat160.b(r12, r12, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.d(r2, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r4 = new org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement
            r4.<init>((int[]) r13)
            int[] r2 = r4.a
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.e(r11, r2)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.g(r2, r5, r2)
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r10 = new org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement
            r10.<init>((int[]) r5)
            int[] r5 = r10.a
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.g(r12, r2, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.b(r5, r11, r9)
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.c(r9, r5)
            org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement r2 = new org.spongycastle.math.ec.custom.sec.SecP160R2FieldElement
            r2.<init>((int[]) r8)
            int[] r5 = r2.a
            if (r14 != 0) goto L_0x00fa
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r5, r7, r5)
        L_0x00fa:
            if (r15 != 0) goto L_0x00ff
            org.spongycastle.math.ec.custom.sec.SecP160R2Field.a(r5, r1, r5)
        L_0x00ff:
            org.spongycastle.math.ec.ECFieldElement[] r6 = new org.spongycastle.math.ec.ECFieldElement[r6]
            r1 = 0
            r6[r1] = r2
            org.spongycastle.math.ec.custom.sec.SecP160K1Point r1 = new org.spongycastle.math.ec.custom.sec.SecP160K1Point
            boolean r7 = r0.f6622a
            r2 = r1
            r5 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.ec.custom.sec.SecP160K1Point.a(org.spongycastle.math.ec.ECPoint):org.spongycastle.math.ec.ECPoint");
    }

    public final ECPoint c() {
        b();
        return new SecP160K1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        return new SecP160K1Point(this.f6620a, this.f6621a, this.f6624b.m(), this.f6623a, this.f6622a);
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
        SecP160R2FieldElement secP160R2FieldElement = (SecP160R2FieldElement) this.f6624b;
        if (secP160R2FieldElement.i()) {
            return eCCurve.l();
        }
        SecP160R2FieldElement secP160R2FieldElement2 = (SecP160R2FieldElement) this.f6621a;
        SecP160R2FieldElement secP160R2FieldElement3 = (SecP160R2FieldElement) this.f6623a[0];
        int[] iArr = new int[5];
        int[] iArr2 = secP160R2FieldElement.a;
        SecP160R2Field.e(iArr2, iArr);
        int[] iArr3 = new int[5];
        SecP160R2Field.e(iArr, iArr3);
        int[] iArr4 = new int[5];
        SecP160R2Field.e(secP160R2FieldElement2.a, iArr4);
        SecP160R2Field.d(Nat160.b(iArr4, iArr4, iArr4), iArr4);
        SecP160R2Field.a(iArr, secP160R2FieldElement2.a, iArr);
        SecP160R2Field.d(Nat.s(5, iArr), iArr);
        int[] iArr5 = new int[5];
        SecP160R2Field.d(Nat.t(5, iArr3, iArr5), iArr5);
        SecP160R2FieldElement secP160R2FieldElement4 = new SecP160R2FieldElement(iArr3);
        int[] iArr6 = secP160R2FieldElement4.a;
        SecP160R2Field.e(iArr4, iArr6);
        SecP160R2Field.g(iArr6, iArr, iArr6);
        SecP160R2Field.g(iArr6, iArr, iArr6);
        SecP160R2FieldElement secP160R2FieldElement5 = new SecP160R2FieldElement(iArr);
        int[] iArr7 = secP160R2FieldElement5.a;
        SecP160R2Field.g(iArr, iArr6, iArr7);
        SecP160R2Field.a(iArr7, iArr4, iArr7);
        SecP160R2Field.g(iArr7, iArr5, iArr7);
        SecP160R2FieldElement secP160R2FieldElement6 = new SecP160R2FieldElement(iArr4);
        int[] iArr8 = secP160R2FieldElement6.a;
        if (Nat.r(5, 0, iArr2, iArr8) != 0 || (iArr8[4] == -1 && Nat160.e(iArr8, SecP160R2Field.a))) {
            Nat.b(5, 21389, iArr8);
        }
        if (!secP160R2FieldElement3.h()) {
            SecP160R2Field.a(iArr8, secP160R2FieldElement3.a, iArr8);
        }
        return new SecP160K1Point(eCCurve, secP160R2FieldElement4, secP160R2FieldElement5, new ECFieldElement[]{secP160R2FieldElement6}, this.f6622a);
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

    public SecP160K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
