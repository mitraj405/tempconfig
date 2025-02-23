package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP224K1Curve extends ECCurve.AbstractFp {
    public static final BigInteger c = new BigInteger(1, Hex.a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
    public final SecP224K1Point a = new SecP224K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecP224K1Curve() {
        super(c);
        this.f6610a = new SecP224K1FieldElement(ECConstants.a);
        this.f6614b = new SecP224K1FieldElement(BigInteger.valueOf(5));
        this.f6609a = new BigInteger(1, Hex.a("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
        this.b = BigInteger.valueOf(1);
        this.a = 2;
    }

    public final ECCurve a() {
        return new SecP224K1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP224K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP224K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecP224K1FieldElement(bigInteger);
    }

    public final int k() {
        return c.bitLength();
    }

    public final ECPoint l() {
        return this.a;
    }

    public final boolean r(int i) {
        if (i != 2) {
            return false;
        }
        return true;
    }
}
