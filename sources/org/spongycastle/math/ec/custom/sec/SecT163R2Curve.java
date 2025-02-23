package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT163R2Curve extends ECCurve.AbstractF2m {
    public final SecT163R2Point a = new SecT163R2Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT163R2Curve() {
        super(163, 3, 6, 7);
        this.f6610a = new SecT163FieldElement(BigInteger.valueOf(1));
        this.f6614b = new SecT163FieldElement(new BigInteger(1, Hex.a("020A601907B8C953CA1481EB10512F78744A3205FD")));
        this.f6609a = new BigInteger(1, Hex.a("040000000000000000000292FE77E70C12A4234C33"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT163R2Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT163R2Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT163R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
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
        return false;
    }
}
