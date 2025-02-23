package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.WTauNafMultiplier;
import org.spongycastle.util.encoders.Hex;

public class SecT409K1Curve extends ECCurve.AbstractF2m {
    public final SecT409K1Point a = new SecT409K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT409K1Curve() {
        super(409, 87, 0, 0);
        this.f6610a = new SecT409FieldElement(BigInteger.valueOf(0));
        this.f6614b = new SecT409FieldElement(BigInteger.valueOf(1));
        this.f6609a = new BigInteger(1, Hex.a("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.b = BigInteger.valueOf(4);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT409K1Curve();
    }

    public final ECMultiplier c() {
        return new WTauNafMultiplier();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT409FieldElement(bigInteger);
    }

    public final int k() {
        return 409;
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
