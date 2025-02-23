package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class CramerShoupParameters implements CipherParameters {
    public final boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        ((CramerShoupParameters) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }
}
