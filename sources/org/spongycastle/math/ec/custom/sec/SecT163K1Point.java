package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;

public class SecT163K1Point extends ECPoint.AbstractF2m {
    public SecT163K1Point() {
        throw null;
    }

    public SecT163K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.f6622a = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    public final ECPoint a(ECPoint eCPoint) {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        ECFieldElement eCFieldElement3;
        ECFieldElement eCFieldElement4;
        ECFieldElement eCFieldElement5;
        ECFieldElement eCFieldElement6;
        ECFieldElement eCFieldElement7;
        if (k()) {
            return eCPoint;
        }
        if (eCPoint.k()) {
            return this;
        }
        ECCurve eCCurve = this.f6620a;
        ECFieldElement eCFieldElement8 = this.f6621a;
        boolean i = eCFieldElement8.i();
        ECFieldElement eCFieldElement9 = eCPoint.f6621a;
        if (!i) {
            ECFieldElement eCFieldElement10 = this.f6623a[0];
            ECFieldElement j = eCPoint.j();
            boolean h = eCFieldElement10.h();
            ECFieldElement eCFieldElement11 = eCPoint.f6624b;
            if (!h) {
                eCFieldElement2 = eCFieldElement9.j(eCFieldElement10);
                eCFieldElement = eCFieldElement11.j(eCFieldElement10);
            } else {
                eCFieldElement = eCFieldElement11;
                eCFieldElement2 = eCFieldElement9;
            }
            boolean h2 = j.h();
            ECFieldElement eCFieldElement12 = this.f6624b;
            if (!h2) {
                eCFieldElement8 = eCFieldElement8.j(j);
                eCFieldElement3 = eCFieldElement12.j(j);
            } else {
                eCFieldElement3 = eCFieldElement12;
            }
            ECFieldElement a = eCFieldElement3.a(eCFieldElement);
            ECFieldElement a2 = eCFieldElement8.a(eCFieldElement2);
            if (!a2.i()) {
                if (eCFieldElement9.i()) {
                    ECPoint o = o();
                    ECFieldElement eCFieldElement13 = o.f6621a;
                    ECFieldElement i2 = o.i();
                    ECFieldElement d = i2.a(eCFieldElement11).d(eCFieldElement13);
                    eCFieldElement5 = d.o().a(d).a(eCFieldElement13).b();
                    if (eCFieldElement5.i()) {
                        return new SecT163K1Point(eCCurve, eCFieldElement5, eCCurve.f6614b, this.f6622a);
                    }
                    eCFieldElement4 = d.j(eCFieldElement13.a(eCFieldElement5)).a(eCFieldElement5).a(i2).d(eCFieldElement5).a(eCFieldElement5);
                    eCFieldElement6 = eCCurve.j(ECConstants.b);
                } else {
                    ECFieldElement o2 = a2.o();
                    ECFieldElement j2 = a.j(eCFieldElement8);
                    ECFieldElement j3 = a.j(eCFieldElement2);
                    ECFieldElement j4 = j2.j(j3);
                    if (j4.i()) {
                        return new SecT163K1Point(eCCurve, j4, eCCurve.f6614b, this.f6622a);
                    }
                    ECFieldElement j5 = a.j(o2);
                    if (!h2) {
                        eCFieldElement7 = j5.j(j);
                    } else {
                        eCFieldElement7 = j5;
                    }
                    eCFieldElement4 = j3.a(o2).p(eCFieldElement7, eCFieldElement12.a(eCFieldElement10));
                    if (!h) {
                        eCFieldElement5 = j4;
                        eCFieldElement6 = eCFieldElement7.j(eCFieldElement10);
                    } else {
                        eCFieldElement5 = j4;
                        eCFieldElement6 = eCFieldElement7;
                    }
                }
                return new SecT163K1Point(eCCurve, eCFieldElement5, eCFieldElement4, new ECFieldElement[]{eCFieldElement6}, this.f6622a);
            } else if (a.i()) {
                return x();
            } else {
                return eCCurve.l();
            }
        } else if (eCFieldElement9.i()) {
            return eCCurve.l();
        } else {
            return eCPoint.a(this);
        }
    }

    public final ECPoint c() {
        b();
        return new SecT163K1Point((ECCurve) null, this.f6621a, e(), false);
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
        return new SecT163K1Point(this.f6620a, eCFieldElement, this.f6624b.a(eCFieldElement2), new ECFieldElement[]{eCFieldElement2}, this.f6622a);
    }

    public final ECPoint x() {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        if (k()) {
            return this;
        }
        ECCurve eCCurve = this.f6620a;
        ECFieldElement eCFieldElement3 = this.f6621a;
        if (eCFieldElement3.i()) {
            return eCCurve.l();
        }
        ECFieldElement eCFieldElement4 = this.f6623a[0];
        boolean h = eCFieldElement4.h();
        ECFieldElement eCFieldElement5 = this.f6624b;
        if (h) {
            eCFieldElement = eCFieldElement5;
        } else {
            eCFieldElement = eCFieldElement5.j(eCFieldElement4);
        }
        if (!h) {
            eCFieldElement4 = eCFieldElement4.o();
        }
        ECFieldElement N = xx.N(eCFieldElement5, eCFieldElement, eCFieldElement4);
        if (N.i()) {
            return new SecT163K1Point(eCCurve, N, eCCurve.f6614b, this.f6622a);
        }
        ECFieldElement o = N.o();
        if (h) {
            eCFieldElement2 = N;
        } else {
            eCFieldElement2 = N.j(eCFieldElement4);
        }
        ECFieldElement o2 = eCFieldElement5.a(eCFieldElement3).o();
        ECFieldElement[] eCFieldElementArr = {eCFieldElement2};
        return new SecT163K1Point(eCCurve, o, o2.a(N).a(eCFieldElement4).j(o2).a(o), eCFieldElementArr, this.f6622a);
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
        ECFieldElement a = o3.a(o2).a(eCFieldElement4.j(eCFieldElement3));
        ECFieldElement eCFieldElement5 = eCPoint.f6624b;
        ECFieldElement l = eCFieldElement5.j(o3).a(o2).l(a, o, o3);
        ECFieldElement j2 = eCFieldElement2.j(o3);
        ECFieldElement o4 = j2.a(a).o();
        if (o4.i()) {
            if (l.i()) {
                return eCPoint.x();
            }
            return eCCurve.l();
        } else if (l.i()) {
            return new SecT163K1Point(eCCurve, l, eCCurve.f6614b, this.f6622a);
        } else {
            ECFieldElement j3 = l.o().j(j2);
            ECFieldElement j4 = l.j(o4).j(o3);
            return new SecT163K1Point(eCCurve, j3, l.a(o4).o().l(a, eCFieldElement5.b(), j4), new ECFieldElement[]{j4}, this.f6622a);
        }
    }

    public SecT163K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.f6622a = z;
    }
}
