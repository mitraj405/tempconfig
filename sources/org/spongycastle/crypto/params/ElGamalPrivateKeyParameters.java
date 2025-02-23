package org.spongycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPrivateKeyParameters extends ElGamalKeyParameters {
    public final BigInteger a;

    public ElGamalPrivateKeyParameters(BigInteger bigInteger, ElGamalParameters elGamalParameters) {
        super(true, elGamalParameters);
        this.a = bigInteger;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ElGamalPrivateKeyParameters) && ((ElGamalPrivateKeyParameters) obj).a.equals(this.a)) {
            return super.equals(obj);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
