package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat576;

public class SecT571K1Point extends ECPoint.AbstractF2m {
    public SecT571K1Point() {
        throw null;
    }

    public SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
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
                    secT571FieldElement2 = (SecT571FieldElement) d.o().a(d).a(secT571FieldElement10);
                    if (secT571FieldElement2.i()) {
                        return new SecT571K1Point(eCCurve, secT571FieldElement2, eCCurve.f6614b, this.f6622a);
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
                        return new SecT571K1Point(eCCurve, secT571FieldElement11, eCCurve.f6614b, this.f6622a);
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
                return new SecT571K1Point(eCCurve, secT571FieldElement2, secT571FieldElement, new ECFieldElement[]{secT571FieldElement3}, this.f6622a);
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
        return new SecT571K1Point((ECCurve) null, this.f6621a, e(), false);
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
        return new SecT571K1Point(this.f6620a, eCFieldElement, this.f6624b.a(eCFieldElement2), new ECFieldElement[]{eCFieldElement2}, this.f6622a);
    }

    public final ECPoint x() {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        ECFieldElement eCFieldElement3;
        if (k()) {
            return this;
        }
        ECCurve eCCurve = this.f6620a;
        ECFieldElement eCFieldElement4 = this.f6621a;
        if (eCFieldElement4.i()) {
            return eCCurve.l();
        }
        ECFieldElement eCFieldElement5 = this.f6623a[0];
        boolean h = eCFieldElement5.h();
        if (h) {
            eCFieldElement = eCFieldElement5;
        } else {
            eCFieldElement = eCFieldElement5.o();
        }
        ECFieldElement eCFieldElement6 = this.f6624b;
        if (h) {
            eCFieldElement2 = eCFieldElement6.o().a(eCFieldElement6);
        } else {
            eCFieldElement2 = eCFieldElement6.a(eCFieldElement5).j(eCFieldElement6);
        }
        if (eCFieldElement2.i()) {
            return new SecT571K1Point(eCCurve, eCFieldElement2, eCCurve.f6614b, this.f6622a);
        }
        ECFieldElement o = eCFieldElement2.o();
        if (h) {
            eCFieldElement3 = eCFieldElement2;
        } else {
            eCFieldElement3 = eCFieldElement2.j(eCFieldElement);
        }
        ECFieldElement o2 = eCFieldElement6.a(eCFieldElement4).o();
        if (!h) {
            eCFieldElement5 = eCFieldElement.o();
        }
        return new SecT571K1Point(eCCurve, o, o2.a(eCFieldElement2).a(eCFieldElement).j(o2).a(eCFieldElement5).a(o).a(eCFieldElement3), new ECFieldElement[]{eCFieldElement3}, this.f6622a);
    }

    public final ECPoint y(ECPoint eCPoint) {
        if (k()) {
            return eCPoint;
        }
        if (eCPoint.k()) {
            return x();
        }
        ECCurve eCCurve = this.f6620a;
        ECFieldElement eCFieldElement = this.f6621a;
        if (eCFieldElement.i()) {
            return eCPoint;
        }
        ECFieldElement j = eCPoint.j();
        ECFieldElement eCFieldElement2 = eCPoint.f6621a;
        if (eCFieldElement2.i() || !j.h()) {
            return x().a(eCPoint);
        }
        ECFieldElement eCFieldElement3 = this.f6623a[0];
        ECFieldElement o = eCFieldElement.o();
        ECFieldElement eCFieldElement4 = this.f6624b;
        ECFieldElement o2 = eCFieldElement4.o();
        ECFieldElement o3 = eCFieldElement3.o();
        ECFieldElement a = o2.a(eCFieldElement4.j(eCFieldElement3));
        ECFieldElement b = eCPoint.f6624b.b();
        ECFieldElement l = b.j(o3).a(o2).l(a, o, o3);
        ECFieldElement j2 = eCFieldElement2.j(o3);
        ECFieldElement o4 = j2.a(a).o();
        if (o4.i()) {
            if (l.i()) {
                return eCPoint.x();
            }
            return eCCurve.l();
        } else if (l.i()) {
            return new SecT571K1Point(eCCurve, l, eCCurve.f6614b, this.f6622a);
        } else {
            ECFieldElement j3 = l.o().j(j2);
            ECFieldElement j4 = l.j(o4).j(o3);
            return new SecT571K1Point(eCCurve, j3, l.a(o4).o().l(a, b, j4), new ECFieldElement[]{j4}, this.f6622a);
        }
    }

    public SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
