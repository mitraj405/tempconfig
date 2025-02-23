package org.spongycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.encoders.Hex;

public class SecT193R2Curve extends ECCurve.AbstractF2m {
    public final SecT193R2Point a = new SecT193R2Point(this, (ECFieldElement) null, (ECFieldElement) null, false);

    public SecT193R2Curve() {
        super(193, 15, 0, 0);
        this.f6610a = new SecT193FieldElement(new BigInteger(1, Hex.a("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.f6614b = new SecT193FieldElement(new BigInteger(1, Hex.a("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.f6609a = new BigInteger(1, Hex.a("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.b = BigInteger.valueOf(2);
        this.a = 6;
    }

    public final ECCurve a() {
        return new SecT193R2Curve();
    }

    public final ECPoint e(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        return new SecT193R2Point(this, eCFieldElement, eCFieldElement2, z);
    }

    public final ECPoint f(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        return new SecT193R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr, z);
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
