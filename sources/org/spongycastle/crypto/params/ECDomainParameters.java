package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Arrays;

public class ECDomainParameters implements ECConstants {
    public final ECCurve a;

    /* renamed from: a  reason: collision with other field name */
    public final ECPoint f6230a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6231a;
    public final BigInteger g;
    public final BigInteger h;

    public ECDomainParameters(ECCurve.Fp fp, ECPoint eCPoint, BigInteger bigInteger) {
        this(fp, eCPoint, bigInteger, ECConstants.b, (byte[]) null);
    }

    public final byte[] a() {
        return Arrays.c(this.f6231a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters) obj;
        if (!this.a.i(eCDomainParameters.a) || !this.f6230a.d(eCDomainParameters.f6230a) || !this.g.equals(eCDomainParameters.g) || !this.h.equals(eCDomainParameters.h)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 37) ^ this.f6230a.hashCode()) * 37) ^ this.g.hashCode()) * 37) ^ this.h.hashCode();
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eCCurve, eCPoint, bigInteger, bigInteger2, (byte[]) null);
    }

    public ECDomainParameters(ECCurve eCCurve, ECPoint eCPoint, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.a = eCCurve;
        this.f6230a = eCPoint.o();
        this.g = bigInteger;
        this.h = bigInteger2;
        this.f6231a = bArr;
    }
}
