package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.WTauNafMultiplier;
import org.spongycastle.util.encoders.Hex;

public class SecT233K1Curve extends ECCurve.AbstractF2m {
    public final SecT233K1Point a = new SecT233K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT233K1Curve() {
        super(233, 74, 0, 0);
        this.f6610a = new SecT233FieldElement(BigInteger.valueOf(0));
        this.f6614b = new SecT233FieldElement(BigInteger.valueOf(1));
        this.f6609a = new BigInteger(1, Hex.a("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
        this.b = BigInteger.valueOf(4);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT233K1Curve();
    }

    public final ECMultiplier c() {
        return new WTauNafMultiplier();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT233K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT233K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT233FieldElement(bigInteger);
    }

    public final int k() {
        return 233;
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
