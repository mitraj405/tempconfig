package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat576;

public class SecT571R1Point extends ECPoint.AbstractF2m {
    public SecT571R1Point() {
        throw null;
    }

    public SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.f6622a = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    public final ECPoint a(ECPoint eCPoint) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        long[] jArr5;
        SecT571FieldElement secT571FieldElement;
        SecT571FieldElement secT571FieldElement2;
        SecT571FieldElement secT571FieldElement3;
        ECPoint eCPoint2 = eCPoint;
        if (k()) {
            return eCPoint2;
        }
        if (eCPoint.k()) {
            return this;
        }
        ECCurve eCCurve = this.f6620a;
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.f6621a;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) eCPoint2.f6621a;
        if (!secT571FieldElement4.i()) {
            SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) this.f6624b;
            SecT571FieldElement secT571FieldElement7 = (SecT571FieldElement) this.f6623a[0];
            SecT571FieldElement secT571FieldElement8 = (SecT571FieldElement) eCPoint2.f6624b;
            SecT571FieldElement secT571FieldElement9 = (SecT571FieldElement) eCPoint.j();
            long[] jArr6 = new long[9];
            long[] jArr7 = new long[9];
            long[] jArr8 = new long[9];
            long[] jArr9 = new long[9];
            boolean h = secT571FieldElement7.h();
            long[] jArr10 = secT571FieldElement7.a;
            if (h) {
                jArr = null;
            } else {
                jArr = SecT571Field.h(jArr10);
            }
            if (jArr == null) {
                jArr2 = secT571FieldElement5.a;
                jArr3 = secT571FieldElement8.a;
            } else {
                SecT571Field.g(secT571FieldElement5.a, jArr, jArr7);
                SecT571Field.g(secT571FieldElement8.a, jArr, jArr9);
                jArr3 = jArr9;
                jArr2 = jArr7;
            }
            if (secT571FieldElement9.h()) {
                jArr4 = null;
            } else {
                jArr4 = SecT571Field.h(secT571FieldElement9.a);
            }
            long[] jArr11 = secT571FieldElement4.a;
            if (jArr4 == null) {
                jArr5 = secT571FieldElement6.a;
            } else {
                SecT571Field.g(jArr11, jArr4, jArr6);
                SecT571Field.g(secT571FieldElement6.a, jArr4, jArr8);
                jArr11 = jArr6;
                jArr5 = jArr8;
            }
            SecT571Field.a(jArr5, jArr3, jArr8);
            SecT571Field.a(jArr11, jArr2, jArr9);
            if (!Nat576.a(jArr9)) {
                if (secT571FieldElement5.i()) {
                    ECPoint o = o();
                    SecT571FieldElement secT571FieldElement10 = (SecT571FieldElement) o.f6621a;
                    ECFieldElement i = o.i();
                    ECFieldElement d = i.a(secT571FieldElement8).d(secT571FieldElement10);
                    secT571FieldElement2 = (SecT571FieldElement) d.o().a(d).a(secT571FieldElement10).b();
                    if (secT571FieldElement2.i()) {
                        return new SecT571R1Point(eCCurve, secT571FieldElement2, SecT571R1Curve.b, this.f6622a);
                    }
                    secT571FieldElement3 = (SecT571FieldElement) eCCurve.j(ECConstants.b);
                    secT571FieldElement = (SecT571FieldElement) d.j(secT571FieldElement10.a(secT571FieldElement2)).a(secT571FieldElement2).a(i).d(secT571FieldElement2).a(secT571FieldElement2);
                } else {
                    SecT571Field.k(jArr9, jArr9);
                    long[] h2 = SecT571Field.h(jArr8);
                    SecT571Field.g(jArr11, h2, jArr6);
                    SecT571Field.g(jArr2, h2, jArr7);
                    SecT571FieldElement secT571FieldElement11 = new SecT571FieldElement(jArr6);
                    SecT571Field.e(jArr6, jArr7, secT571FieldElement11.a);
                    if (secT571FieldElement11.i()) {
                        return new SecT571R1Point(eCCurve, secT571FieldElement11, SecT571R1Curve.b, this.f6622a);
                    }
                    SecT571FieldElement secT571FieldElement12 = new SecT571FieldElement(jArr8);
                    long[] jArr12 = secT571FieldElement12.a;
                    SecT571Field.g(jArr9, h2, jArr12);
                    if (jArr4 != null) {
                        SecT571Field.g(jArr12, jArr4, jArr12);
                    }
                    long[] jArr13 = new long[18];
                    SecT571Field.a(jArr7, jArr9, jArr9);
                    long[] jArr14 = new long[18];
                    SecT571Field.d(jArr9, jArr14);
                    for (int i2 = 0; i2 < 18; i2++) {
                        jArr13[i2] = jArr13[i2] ^ jArr14[i2];
                    }
                    SecT571Field.a(secT571FieldElement6.a, jArr10, jArr9);
                    SecT571Field.f(jArr9, jArr12, jArr13);
                    SecT571FieldElement secT571FieldElement13 = new SecT571FieldElement(jArr9);
                    SecT571Field.i(jArr13, secT571FieldElement13.a);
                    if (jArr != null) {
                        SecT571Field.g(jArr12, jArr, jArr12);
                    }
                    secT571FieldElement = secT571FieldElement13;
                    secT571FieldElement2 = secT571FieldElement11;
                    secT571FieldElement3 = secT571FieldElement12;
                }
                return new SecT571R1Point(eCCurve, secT571FieldElement2, secT571FieldElement, new ECFieldElement[]{secT571FieldElement3}, this.f6622a);
            } else if (Nat576.a(jArr8)) {
                return x();
            } else {
                return eCCurve.l();
            }
        } else if (secT571FieldElement5.i()) {
            return eCCurve.l();
        } else {
            return eCPoint2.a(this);
        }
    }

    public final ECPoint c() {
        b();
        return new SecT571R1Point((ECCurve) null, this.f6621a, e(), false);
    }

    public final boolean f() {
        ECFieldElement eCFieldElement = this.f6621a;
        if (!eCFieldElement.i() && this.f6624b.s() != eCFieldElement.s()) {
            return true;
        }
        return false;
    }

    public final ECFieldElement i() {
        boolean k = k();
        ECFieldElement eCFieldElement = this.f6624b;
        if (!k) {
            ECFieldElement eCFieldElement2 = this.f6621a;
            if (!eCFieldElement2.i()) {
                ECFieldElement j = eCFieldElement.a(eCFieldElement2).j(eCFieldElement2);
                ECFieldElement eCFieldElement3 = this.f6623a[0];
                if (!eCFieldElement3.h()) {
                    return j.d(eCFieldElement3);
                }
                return j;
            }
        }
        return eCFieldElement;
    }

    public final ECPoint n() {
        if (k()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.f6621a;
        if (eCFieldElement.i()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.f6623a[0];
        return new SecT571R1Point(this.f6620a, eCFieldElement, this.f6624b.a(eCFieldElement2), new ECFieldElement[]{eCFieldElement2}, this.f6622a);
    }

    public final ECPoint x() {
        long[] jArr;
        long[] jArr2;
        if (k()) {
            return this;
        }
        ECCurve eCCurve = this.f6620a;
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement) this.f6621a;
        if (secT571FieldElement.i()) {
            return eCCurve.l();
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement) this.f6624b;
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement) this.f6623a[0];
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        boolean h = secT571FieldElement3.h();
        long[] jArr5 = secT571FieldElement3.a;
        if (h) {
            jArr = null;
        } else {
            jArr = SecT571Field.h(jArr5);
        }
        if (jArr == null) {
            jArr2 = secT571FieldElement2.a;
        } else {
            SecT571Field.g(secT571FieldElement2.a, jArr, jArr3);
            SecT571Field.k(jArr5, jArr4);
            jArr2 = jArr3;
            jArr5 = jArr4;
        }
        long[] jArr6 = new long[9];
        SecT571Field.k(secT571FieldElement2.a, jArr6);
        SecT571Field.b(jArr2, jArr5, jArr6);
        if (Nat576.a(jArr6)) {
            return new SecT571R1Point(eCCurve, new SecT571FieldElement(jArr6), SecT571R1Curve.b, this.f6622a);
        }
        long[] jArr7 = new long[18];
        SecT571Field.f(jArr6, jArr2, jArr7);
        SecT571FieldElement secT571FieldElement4 = new SecT571FieldElement(jArr3);
        long[] jArr8 = secT571FieldElement4.a;
        SecT571Field.k(jArr6, jArr8);
        SecT571FieldElement secT571FieldElement5 = new SecT571FieldElement(jArr6);
        long[] jArr9 = secT571FieldElement5.a;
        if (jArr != null) {
            SecT571Field.e(jArr9, jArr5, jArr9);
        }
        long[] jArr10 = secT571FieldElement.a;
        if (jArr != null) {
            SecT571Field.g(jArr10, jArr, jArr4);
            jArr10 = jArr4;
        }
        long[] jArr11 = new long[18];
        SecT571Field.d(jArr10, jArr11);
        for (int i = 0; i < 18; i++) {
            jArr7[i] = jArr7[i] ^ jArr11[i];
        }
        SecT571Field.i(jArr7, jArr4);
        SecT571Field.b(jArr8, jArr9, jArr4);
        return new SecT571R1Point(eCCurve, secT571FieldElement4, new SecT571FieldElement(jArr4), new ECFieldElement[]{secT571FieldElement5}, this.f6622a);
    }

    public final ECPoint y(ECPoint eCPoint) {
        ECPoint eCPoint2 = eCPoint;
        if (k()) {
            return eCPoint2;
        }
        if (eCPoint.k()) {
            return x();
        }
        ECCurve eCCurve = this.f6620a;
        SecT571FieldElement secT571FieldElement = (SecT571FieldElement) this.f6621a;
        if (secT571FieldElement.i()) {
            return eCPoint2;
        }
        SecT571FieldElement secT571FieldElement2 = (SecT571FieldElement) eCPoint2.f6621a;
        SecT571FieldElement secT571FieldElement3 = (SecT571FieldElement) eCPoint.j();
        if (secT571FieldElement2.i() || !secT571FieldElement3.h()) {
            return x().a(eCPoint2);
        }
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.f6624b;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) this.f6623a[0];
        SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) eCPoint2.f6624b;
        long[] jArr = new long[9];
        long[] jArr2 = new long[9];
        long[] jArr3 = new long[9];
        long[] jArr4 = new long[9];
        SecT571Field.k(secT571FieldElement.a, jArr);
        SecT571Field.k(secT571FieldElement4.a, jArr2);
        SecT571Field.k(secT571FieldElement5.a, jArr3);
        SecT571Field.e(secT571FieldElement4.a, secT571FieldElement5.a, jArr4);
        SecT571Field.b(jArr3, jArr2, jArr4);
        long[] h = SecT571Field.h(jArr3);
        SecT571Field.g(secT571FieldElement6.a, h, jArr3);
        SecT571Field.a(jArr3, jArr2, jArr3);
        long[] jArr5 = new long[18];
        SecT571Field.f(jArr3, jArr4, jArr5);
        long[] jArr6 = new long[18];
        SecT571Field.c(jArr, h, jArr6);
        for (int i = 0; i < 18; i++) {
            jArr5[i] = jArr5[i] ^ jArr6[i];
        }
        SecT571Field.i(jArr5, jArr3);
        SecT571Field.g(secT571FieldElement2.a, h, jArr);
        SecT571Field.a(jArr, jArr4, jArr2);
        SecT571Field.k(jArr2, jArr2);
        if (Nat576.a(jArr2)) {
            if (Nat576.a(jArr3)) {
                return eCPoint.x();
            }
            return eCCurve.l();
        } else if (Nat576.a(jArr3)) {
            return new SecT571R1Point(eCCurve, new SecT571FieldElement(jArr3), SecT571R1Curve.b, this.f6622a);
        } else {
            SecT571FieldElement secT571FieldElement7 = new SecT571FieldElement();
            long[] jArr7 = secT571FieldElement7.a;
            SecT571Field.k(jArr3, jArr7);
            SecT571Field.e(jArr7, jArr, jArr7);
            SecT571FieldElement secT571FieldElement8 = new SecT571FieldElement(jArr);
            long[] jArr8 = secT571FieldElement8.a;
            SecT571Field.e(jArr3, jArr2, jArr8);
            SecT571Field.g(jArr8, h, jArr8);
            SecT571FieldElement secT571FieldElement9 = new SecT571FieldElement(jArr2);
            long[] jArr9 = secT571FieldElement9.a;
            SecT571Field.a(jArr3, jArr2, jArr9);
            SecT571Field.k(jArr9, jArr9);
            for (int i2 = 0; i2 < 18; i2++) {
                jArr5[i2] = 0;
            }
            SecT571Field.f(jArr9, jArr4, jArr5);
            long[] jArr10 = secT571FieldElement6.a;
            jArr4[0] = jArr10[0] ^ 1;
            for (int i3 = 1; i3 < 9; i3++) {
                jArr4[i3] = jArr10[i3];
            }
            SecT571Field.f(jArr4, jArr8, jArr5);
            SecT571Field.i(jArr5, jArr9);
            return new SecT571R1Point(eCCurve, secT571FieldElement7, secT571FieldElement9, new ECFieldElement[]{secT571FieldElement8}, this.f6622a);
        }
    }

    public SecT571R1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
