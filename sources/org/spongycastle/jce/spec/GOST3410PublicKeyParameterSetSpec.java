package org.spongycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec {
    public final BigInteger a;
    public final BigInteger b;
    public final BigInteger c;

    public GOST3410PublicKeyParameterSetSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.a = bigInteger;
        this.b = bigInteger2;
        this.c = bigInteger3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GOST3410PublicKeyParameterSetSpec)) {
            return false;
        }
        GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec = (GOST3410PublicKeyParameterSetSpec) obj;
        if (!this.c.equals(gOST3410PublicKeyParameterSetSpec.c) || !this.a.equals(gOST3410PublicKeyParameterSetSpec.a) || !this.b.equals(gOST3410PublicKeyParameterSetSpec.b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.c.hashCode() ^ this.a.hashCode()) ^ this.b.hashCode();
    }
}
