package org.spongycastle.crypto.params;

public class CramerShoupKeyParameters extends AsymmetricKeyParameter {
    public CramerShoupKeyParameters() {
        throw null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupKeyParameters)) {
            return false;
        }
        ((CramerShoupKeyParameters) obj).getClass();
        return true;
    }

    public int hashCode() {
        return this.a ^ true ? 1 : 0;
    }
}
