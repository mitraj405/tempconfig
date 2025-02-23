package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT193R1Curve extends ECCurve.AbstractF2m {
    public final SecT193R1Point a = new SecT193R1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT193R1Curve() {
        super(193, 15, 0, 0);
        this.f6610a = new SecT193FieldElement(new BigInteger(1, Hex.a("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.f6614b = new SecT193FieldElement(new BigInteger(1, Hex.a("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.f6609a = new BigInteger(1, Hex.a("01000000000000000000000000C7F34A778F443ACC920EBA49"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT193R1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT193R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT193R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT193FieldElement(bigInteger);
    }

    public final int k() {
        return 193;
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
