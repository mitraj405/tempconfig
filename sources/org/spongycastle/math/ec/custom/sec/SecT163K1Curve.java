package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.WTauNafMultiplier;
import org.spongycastle.util.encoders.Hex;

public class SecT163K1Curve extends ECCurve.AbstractF2m {
    public final SecT163K1Point a = new SecT163K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT163K1Curve() {
        super(163, 3, 6, 7);
        SecT163FieldElement secT163FieldElement = new SecT163FieldElement(BigInteger.valueOf(1));
        this.f6610a = secT163FieldElement;
        this.f6614b = secT163FieldElement;
        this.f6609a = new BigInteger(1, Hex.a("04000000000000000000020108A2E0CC0D99F8A5EF"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT163K1Curve();
    }

    public final ECMultiplier c() {
        return new WTauNafMultiplier();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT163K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT163K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
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
        return true;
    }
}
