package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class DHPublicKeyParameters extends DHKeyParameters {
    public static final BigInteger b = BigInteger.valueOf(1);
    public static final BigInteger c = BigInteger.valueOf(2);
    public final BigInteger a;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        if (bigInteger != null) {
            BigInteger bigInteger2 = c;
            if (bigInteger.compareTo(bigInteger2) < 0 || bigInteger.compareTo(dHParameters.b.subtract(bigInteger2)) > 0) {
                throw new IllegalArgumentException("invalid DH public key");
            }
            BigInteger bigInteger3 = dHParameters.f6228c;
            if (bigInteger3 != null) {
                if (!b.equals(bigInteger.modPow(bigInteger3, dHParameters.b))) {
                    throw new IllegalArgumentException("Y value does not appear to be in correct group");
                }
            }
            this.a = bigInteger;
            return;
        }
        throw new NullPointerException("y value cannot be null");
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).a.equals(this.a) && super.equals(obj)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ super.hashCode();
    }
}
