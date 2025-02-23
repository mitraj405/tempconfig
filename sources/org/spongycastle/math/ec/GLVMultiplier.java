package org.spongycastle.math.ec;

import java.math.BigInteger;
import org.spongycastle.math.ec.endo.GLVEndomorphism;

public class GLVMultiplier extends AbstractECMultiplier {
    public final ECCurve a;

    /* renamed from: a  reason: collision with other field name */
    public final GLVEndomorphism f6627a;

    public GLVMultiplier(ECCurve eCCurve, GLVEndomorphism gLVEndomorphism) {
        if (eCCurve == null || eCCurve.f6609a == null) {
            throw new IllegalArgumentException("Need curve with known group order");
        }
        this.a = eCCurve;
        this.f6627a = gLVEndomorphism;
    }

    public final ECPoint b(ECPoint eCPoint, BigInteger bigInteger) {
        boolean z;
        ECPoint[] eCPointArr;
        ECPoint[] eCPointArr2;
        ECPoint[] eCPointArr3;
        ECPoint[] eCPointArr4;
        if (this.a.i(eCPoint.f6620a)) {
            BigInteger mod = bigInteger.mod(eCPoint.f6620a.f6609a);
            GLVEndomorphism gLVEndomorphism = this.f6627a;
            BigInteger[] a2 = gLVEndomorphism.a(mod);
            boolean z2 = false;
            BigInteger bigInteger2 = a2[0];
            BigInteger bigInteger3 = a2[1];
            ScaleXPointMap b = gLVEndomorphism.b();
            gLVEndomorphism.c();
            if (bigInteger2.signum() < 0) {
                z = true;
            } else {
                z = false;
            }
            if (bigInteger3.signum() < 0) {
                z2 = true;
            }
            BigInteger abs = bigInteger2.abs();
            BigInteger abs2 = bigInteger3.abs();
            int max = Math.max(2, Math.min(16, WNafUtil.e(Math.max(abs.bitLength(), abs2.bitLength()))));
            ECPoint f = WNafUtil.f(eCPoint, max, b);
            WNafPreCompInfo d = WNafUtil.d(eCPoint);
            WNafPreCompInfo d2 = WNafUtil.d(f);
            if (z) {
                eCPointArr = d.b;
            } else {
                eCPointArr = d.f6635a;
            }
            ECPoint[] eCPointArr5 = eCPointArr;
            if (z2) {
                eCPointArr2 = d2.b;
            } else {
                eCPointArr2 = d2.f6635a;
            }
            ECPoint[] eCPointArr6 = eCPointArr2;
            if (z) {
                eCPointArr3 = d.f6635a;
            } else {
                eCPointArr3 = d.b;
            }
            ECPoint[] eCPointArr7 = eCPointArr3;
            if (z2) {
                eCPointArr4 = d2.f6635a;
            } else {
                eCPointArr4 = d2.b;
            }
            return ECAlgorithms.b(eCPointArr5, eCPointArr7, WNafUtil.b(max, abs), eCPointArr6, eCPointArr4, WNafUtil.b(max, abs2));
        }
        throw new IllegalStateException();
    }
}
