package org.spongycastle.math.ec;

import java.math.BigInteger;

public class NafR2LMultiplier extends AbstractECMultiplier {
    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        ECPoint eCPoint2;
        int[] a = WNafUtil.a(bigInteger);
        ECPoint l = eCPoint.f6620a.l();
        int i = 0;
        int i2 = 0;
        while (i < a.length) {
            int i3 = a[i];
            int i4 = i3 >> 16;
            eCPoint = eCPoint.w(i2 + (i3 & 65535));
            if (i4 < 0) {
                eCPoint2 = eCPoint.n();
            } else {
                eCPoint2 = eCPoint;
            }
            l = l.a(eCPoint2);
            i++;
            i2 = 1;
        }
        return l;
    }
}
