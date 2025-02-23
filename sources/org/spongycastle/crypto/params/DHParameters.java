package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class DHParameters implements CipherParameters {
    public final BigInteger a;
    public final BigInteger b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public final BigInteger f6228c;
    public final int d;

    public DHParameters() {
        throw null;
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(0, bigInteger, bigInteger2, (BigInteger) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        BigInteger bigInteger = this.f6228c;
        if (bigInteger != null) {
            if (!bigInteger.equals(dHParameters.f6228c)) {
                return false;
            }
        } else if (dHParameters.f6228c != null) {
            return false;
        }
        if (!dHParameters.b.equals(this.b)) {
            return false;
        }
        if (dHParameters.a.equals(this.a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.b.hashCode() ^ this.a.hashCode();
        BigInteger bigInteger = this.f6228c;
        if (bigInteger != null) {
            i = bigInteger.hashCode();
        } else {
            i = 0;
        }
        return hashCode ^ i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DHParameters(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, (i != 0 && i < 160) ? i : 160, i);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            } else if (i2 < i) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        this.a = bigInteger2;
        this.b = bigInteger;
        this.f6228c = bigInteger3;
        this.c = i;
        this.d = i2;
    }
}
