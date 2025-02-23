package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT409R1Curve extends ECCurve.AbstractF2m {
    public final SecT409R1Point a = new SecT409R1Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT409R1Curve() {
        super(409, 87, 0, 0);
        this.f6610a = new SecT409FieldElement(BigInteger.valueOf(1));
        this.f6614b = new SecT409FieldElement(new BigInteger(1, Hex.a("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F")));
        this.f6609a = new BigInteger(1, Hex.a("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT409R1Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT409R1Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT409R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
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
        return false;
    }
}
