package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class DSAParameters implements CipherParameters {
    public final BigInteger a;
    public final BigInteger b;
    public final BigInteger c;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        if (!dSAParameters.c.equals(this.c)) {
            return false;
        }
        if (!dSAParameters.b.equals(this.b)) {
            return false;
        }
        if (dSAParameters.a.equals(this.a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.c.hashCode() ^ this.b.hashCode()) ^ this.a.hashCode();
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this.a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
    }
}
