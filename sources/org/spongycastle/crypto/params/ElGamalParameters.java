package org.spongycastle.crypto.params;

import java.math.BigInteger;
import org.spongycastle.crypto.CipherParameters;

public class ElGamalParameters implements CipherParameters {
    public final BigInteger a;
    public final BigInteger b;
    public final int c;

    public ElGamalParameters() {
        throw null;
    }

    public ElGamalParameters(int i, BigInteger bigInteger, BigInteger bigInteger2) {
        this.a = bigInteger2;
        this.b = bigInteger;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        if (!elGamalParameters.b.equals(this.b)) {
            return false;
        }
        if (!elGamalParameters.a.equals(this.a) || elGamalParameters.c != this.c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.b.hashCode() ^ this.a.hashCode()) + this.c;
    }
}
