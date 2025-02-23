package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;

public class MixedNafR2LMultiplier extends AbstractECMultiplier {
    public final int a = 2;
    public final int b = 4;

    public static ECCurve c(ECCurve eCCurve, int i) {
        if (eCCurve.a == i) {
            return eCCurve;
        }
        if (eCCurve.r(i)) {
            ECCurve.Config b2 = eCCurve.b();
            b2.a = i;
            return b2.a();
        }
        throw new IllegalArgumentException(C1058d.y("Coordinate system ", i, " not supported by this curve"));
    }

    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        ECCurve eCCurve = eCPoint.f6620a;
        ECCurve c = c(eCCurve, this.a);
        ECCurve c2 = c(eCCurve, this.b);
        int[] a2 = WNafUtil.a(bigInteger);
        ECPoint l = c.l();
        ECPoint n = c2.n(eCPoint);
        int i = 0;
        ECPoint eCPoint2 = l;
        int i2 = 0;
        while (i < a2.length) {
            int i3 = a2[i];
            int i4 = i3 >> 16;
            n = n.w(i2 + (i3 & 65535));
            ECPoint n2 = c.n(n);
            if (i4 < 0) {
                n2 = n2.n();
            }
            eCPoint2 = eCPoint2.a(n2);
            i++;
            i2 = 1;
        }
        return eCCurve.n(eCPoint2);
    }
}
