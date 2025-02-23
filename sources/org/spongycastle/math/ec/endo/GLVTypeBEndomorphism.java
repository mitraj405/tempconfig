package org.spongycastle.math.ec.endo;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ScaleXPointMap;

public class GLVTypeBEndomorphism implements GLVEndomorphism {
    public final ScaleXPointMap a;

    /* renamed from: a  reason: collision with other field name */
    public final GLVTypeBParameters f6639a;

    public GLVTypeBEndomorphism(ECCurve.AbstractFp abstractFp, GLVTypeBParameters gLVTypeBParameters) {
        this.f6639a = gLVTypeBParameters;
        this.a = new ScaleXPointMap(abstractFp.j(gLVTypeBParameters.f6640a));
    }

    public static BigInteger d(int i, BigInteger bigInteger, BigInteger bigInteger2) {
        boolean z;
        if (bigInteger2.signum() < 0) {
            z = true;
        } else {
            z = false;
        }
        BigInteger multiply = bigInteger.multiply(bigInteger2.abs());
        boolean testBit = multiply.testBit(i - 1);
        BigInteger shiftRight = multiply.shiftRight(i);
        if (testBit) {
            shiftRight = shiftRight.add(ECConstants.b);
        }
        if (z) {
            return shiftRight.negate();
        }
        return shiftRight;
    }

    public final BigInteger[] a(BigInteger bigInteger) {
        GLVTypeBParameters gLVTypeBParameters = this.f6639a;
        int i = gLVTypeBParameters.a;
        BigInteger d = d(i, bigInteger, gLVTypeBParameters.f);
        BigInteger d2 = d(i, bigInteger, gLVTypeBParameters.g);
        return new BigInteger[]{bigInteger.subtract(d.multiply(gLVTypeBParameters.b).add(d2.multiply(gLVTypeBParameters.d))), d.multiply(gLVTypeBParameters.c).add(d2.multiply(gLVTypeBParameters.e)).negate()};
    }

    public final ScaleXPointMap b() {
        return this.a;
    }

    public final void c() {
    }
}
