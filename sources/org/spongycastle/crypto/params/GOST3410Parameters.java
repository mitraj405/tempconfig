package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class GOST3410Parameters implements CipherParameters {
    public final BigInteger a;
    public final BigInteger b;
    public final BigInteger c;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        if (!gOST3410Parameters.a.equals(this.a)) {
            return false;
        }
        if (!gOST3410Parameters.b.equals(this.b)) {
            return false;
        }
        if (gOST3410Parameters.c.equals(this.c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.a.hashCode() ^ this.b.hashCode()) ^ this.c.hashCode();
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i) {
        this.c = bigInteger3;
        this.a = bigInteger;
        this.b = bigInteger2;
    }
}
