package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP160K1Curve extends ECCurve.AbstractFp {
    public static final BigInteger c = SecP160R2Curve.c;
    public final SecP160K1Point a = new SecP160K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecP160K1Curve() {
        super(c);
        this.f6610a = new SecP160R2FieldElement(ECConstants.a);
        this.f6614b = new SecP160R2FieldElement(BigInteger.valueOf(7));
        this.f6609a = new BigInteger(1, Hex.a("0100000000000000000001B8FA16DFAB9ACA16B6B3"));
        this.b = BigInteger.valueOf(1);
        this.a = 2;
    }

    public final ECCurve a() {
        return new SecP160K1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP160K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP160K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecP160R2FieldElement(bigInteger);
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
