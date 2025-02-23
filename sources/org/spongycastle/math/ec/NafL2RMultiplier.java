package org.spongycastle.math.ec;

import java.math.BigInteger;

public class NafL2RMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPoint2;
        int[] a = WNafUtil.a(bigInteger);
        ECPoint o = eCPoint.o();
        ECPoint n = o.n();
        ECPoint l = eCPoint.f6620a.l();
        int length = a.length;
        while (true) {
            length--;
            if (length < 0) {
                return l;
            }
            int i = a[length];
            int i2 = i >> 16;
            int i3 = i & 65535;
            if (i2 < 0) {
                eCPoint2 = n;
            } else {
                eCPoint2 = o;
            }
            l = l.y(eCPoint2).w(i3);
        }
    }
}
