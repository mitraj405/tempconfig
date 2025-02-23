package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.WTauNafMultiplier;
import org.spongycastle.util.encoders.Hex;

public class SecT571K1Curve extends ECCurve.AbstractF2m {
    public final SecT571K1Point a = new SecT571K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT571K1Curve() {
        super(571, 2, 5, 10);
        this.f6610a = new SecT571FieldElement(BigInteger.valueOf(0));
        this.f6614b = new SecT571FieldElement(BigInteger.valueOf(1));
        this.f6609a = new BigInteger(1, Hex.a("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
        this.b = BigInteger.valueOf(4);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT571K1Curve();
    }

    public final ECMultiplier c() {
        return new WTauNafMultiplier();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT571K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT571K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT571FieldElement(bigInteger);
    }

    public final int k() {
        return 571;
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
