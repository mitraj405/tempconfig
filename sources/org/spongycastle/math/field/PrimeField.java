package org.spongycastle.math.field;

import java.math.BigInteger;

class PrimeField implements FiniteField {
    public final BigInteger a;

    public PrimeField(BigInteger bigInteger) {
        this.a = bigInteger;
    }

    public final int a() {
        return 1;
    }

    public final BigInteger b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrimeField)) {
            return false;
        }
        return this.a.equals(((PrimeField) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
