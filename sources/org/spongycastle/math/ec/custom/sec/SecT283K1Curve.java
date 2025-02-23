package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECMultiplier;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.ec.WTauNafMultiplier;
import org.spongycastle.util.encoders.Hex;

public class SecT283K1Curve extends ECCurve.AbstractF2m {
    public final SecT283K1Point a = new SecT283K1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT283K1Curve() {
        super(283, 5, 7, 12);
        this.f6610a = new SecT283FieldElement(BigInteger.valueOf(0));
        this.f6614b = new SecT283FieldElement(BigInteger.valueOf(1));
        this.f6609a = new BigInteger(1, Hex.a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
        this.b = BigInteger.valueOf(4);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT283K1Curve();
    }

    public final ECMultiplier c() {
        return new WTauNafMultiplier();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT283K1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT283K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT283FieldElement(bigInteger);
    }

    public final int k() {
        return 283;
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
