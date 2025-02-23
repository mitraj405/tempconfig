package org.spongycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class ECParameterSpec implements AlgorithmParameterSpec {
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final ECCurve f6602a;

    /* renamed from: a  reason: collision with other field name */
    public final ECPoint f6603a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6604a;
    public final BigInteger b;

    public ECParameterSpec(ECCurve.F2m f2m, ECPoint eCPoint, BigInteger bigInteger) {
        this.f6602a = f2m;
        this.f6603a = eCPoint.o();
        this.a = bigInteger;
        this.b = BigInteger.valueOf(1);
        this.f6604a = null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ECParameterSpec)) {
            return false;
        }
        ECParameterSpec eCParameterSpec = (ECParameterSpec) obj;
        if (!this.f6602a.i(eCParameterSpec.f6602a) || !this.f6603a.d(eCParameterSpec.f6603a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f6602a.hashCode() ^ this.f6603a.hashCode();
    }

    public ECParameterSpec(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.f6602a = eCCurve;
        this.f6603a = eCPoint.o();
        this.a = bigInteger;
        this.b = bigInteger2;
        this.f6604a = bArr;
    }
}
