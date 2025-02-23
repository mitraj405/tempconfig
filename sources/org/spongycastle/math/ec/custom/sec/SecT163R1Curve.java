package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT163R1Curve extends ECCurve.AbstractF2m {
    public final SecT163R1Point a = new SecT163R1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT163R1Curve() {
        super(163, 3, 6, 7);
        this.f6610a = new SecT163FieldElement(new BigInteger(1, Hex.a("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2")));
        this.f6614b = new SecT163FieldElement(new BigInteger(1, Hex.a("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9")));
        this.f6609a = new BigInteger(1, Hex.a("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT163R1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT163R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT163R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT163FieldElement(bigInteger);
    }

    public final int k() {
        return 163;
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
