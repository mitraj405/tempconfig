package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT233R1Curve extends ECCurve.AbstractF2m {
    public final SecT233R1Point a = new SecT233R1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT233R1Curve() {
        super(233, 74, 0, 0);
        this.f6610a = new SecT233FieldElement(BigInteger.valueOf(1));
        this.f6614b = new SecT233FieldElement(new BigInteger(1, Hex.a("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD")));
        this.f6609a = new BigInteger(1, Hex.a("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT233R1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT233R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT233R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
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
        return false;
    }
}
