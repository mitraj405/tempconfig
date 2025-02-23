package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT113R2Curve extends ECCurve.AbstractF2m {
    public final SecT113R2Point a = new SecT113R2Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT113R2Curve() {
        super(113, 9, 0, 0);
        this.f6610a = new SecT113FieldElement(new BigInteger(1, Hex.a("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.f6614b = new SecT113FieldElement(new BigInteger(1, Hex.a("0095E9A9EC9B297BD4BF36E059184F")));
        this.f6609a = new BigInteger(1, Hex.a("010000000000000108789B2496AF93"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT113R2Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT113R2Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT113R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
    }

    public final ECFieldElement j(BigInteger bigInteger) {
        return new SecT113FieldElement(bigInteger);
    }

    public final int k() {
        return 113;
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
