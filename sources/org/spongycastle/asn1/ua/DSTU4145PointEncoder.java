package org.spongycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;

public abstract class DSTU4145PointEncoder {
    public static ECPoint a(ECCurve eCCurve, byte[] bArr) {
        ECFieldElement eCFieldElement;
        ECFieldElement j = eCCurve.j(BigInteger.valueOf((long) (bArr[bArr.length - 1] & 1)));
        ECFieldElement j2 = eCCurve.j(new BigInteger(1, bArr));
        if (!b(j2).equals(eCCurve.f6610a)) {
            j2 = j2.b();
        }
        if (j2.i()) {
            eCFieldElement = eCCurve.f6614b.n();
        } else {
            ECFieldElement a = j2.o().g().j(eCCurve.f6614b).a(eCCurve.f6610a).a(j2);
            if (!a.i()) {
                ECFieldElement j3 = eCCurve.j(ECConstants.a);
                Random random = new Random();
                int f = a.f();
                while (true) {
                    ECFieldElement j4 = eCCurve.j(new BigInteger(f, random));
                    ECFieldElement eCFieldElement2 = a;
                    ECFieldElement eCFieldElement3 = j3;
                    for (int i = 1; i <= f - 1; i++) {
                        ECFieldElement o = eCFieldElement2.o();
                        eCFieldElement3 = eCFieldElement3.o().a(o.j(j4));
                        eCFieldElement2 = o.a(a);
                    }
                    if (eCFieldElement2.i()) {
                        if (!eCFieldElement3.o().a(eCFieldElement3).i()) {
                            a = eCFieldElement3;
                            break;
                        }
                    } else {
                        a = null;
                        break;
                    }
                }
            }
            if (a != null) {
                if (!b(a).equals(j)) {
                    a = a.b();
                }
                eCFieldElement = j2.j(a);
            } else {
                eCFieldElement = null;
            }
        }
        if (eCFieldElement != null) {
            return eCCurve.s(j2.t(), eCFieldElement.t());
        }
        throw new IllegalArgumentException("Invalid point compression");
    }

    public static ECFieldElement b(ECFieldElement eCFieldElement) {
        ECFieldElement eCFieldElement2 = eCFieldElement;
        for (int i = 1; i < eCFieldElement.f(); i++) {
            eCFieldElement2 = eCFieldElement2.o().a(eCFieldElement);
        }
        return eCFieldElement2;
    }
}
