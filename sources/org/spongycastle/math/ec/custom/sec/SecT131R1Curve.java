package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT131R1Curve extends ECCurve.AbstractF2m {
    public final SecT131R1Point a = new SecT131R1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT131R1Curve() {
        super(131, 2, 3, 8);
        this.f6610a = new SecT131FieldElement(new BigInteger(1, Hex.a("07A11B09A76B562144418FF3FF8C2570B8")));
        this.f6614b = new SecT131FieldElement(new BigInteger(1, Hex.a("0217C05610884B63B9C6C7291678F9D341")));
        this.f6609a = new BigInteger(1, Hex.a("0400000000000000023123953A9464B54D"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT131R1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT131R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT131R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT131FieldElement(bigInteger);
    }

    public final int k() {
        return 131;
    }

    public final ECPoint l() {
        return this.a;
    }

    public final boolean r(int i) {
        if (i != 6) {
            return false;
        }
        return true;
    }

    public final boolean t() {
        return false;
    }
}
