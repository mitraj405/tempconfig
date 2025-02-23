package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecP128R1Curve extends ECCurve.AbstractFp {
    public static final BigInteger c = new BigInteger(1, Hex.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
    public final SecP128R1Point a = new SecP128R1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecP128R1Curve() {
        super(c);
        this.f6610a = new SecP128R1FieldElement(new BigInteger(1, Hex.a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f6614b = new SecP128R1FieldElement(new BigInteger(1, Hex.a("E87579C11079F43DD824993C2CEE5ED3")));
        this.f6609a = new BigInteger(1, Hex.a("FFFFFFFE0000000075A30D1B9038A115"));
        this.b = BigInteger.valueOf(1);
        this.a = 2;
    }

    public final ECCurve a() {
        return new SecP128R1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecP128R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecP128R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecP128R1FieldElement(bigInteger);
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
