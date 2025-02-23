package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.WTauNafMultiplier;
import org.spongycastle.util.encoders.Hex;

public class SecT239K1Curve extends ECCurve.AbstractF2m {
    public final SecT239K1Point a = new SecT239K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT239K1Curve() {
        super(239, 158, 0, 0);
        this.f6610a = new SecT239FieldElement(BigInteger.valueOf(0));
        this.f6614b = new SecT239FieldElement(BigInteger.valueOf(1));
        this.f6609a = new BigInteger(1, Hex.a("2000000000000000000000000000005A79FEC67CB6E91F1C1DA800E478A5"));
        this.b = BigInteger.valueOf(4);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT239K1Curve();
    }

    public final ECMultiplier c() {
        return new WTauNafMultiplier();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT239K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT239K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT239FieldElement(bigInteger);
    }

    public final int k() {
        return 239;
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
