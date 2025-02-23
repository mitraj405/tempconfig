package org.spongycastle.crypto.params;

public class ElGamalKeyParameters extends AsymmetricKeyParameter {
    public final ElGamalParameters a;

    public ElGamalKeyParameters(boolean z, ElGamalParameters elGamalParameters) {
        super(z);
        this.a = elGamalParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalKeyParameters)) {
            return false;
        }
        ElGamalKeyParameters elGamalKeyParameters = (ElGamalKeyParameters) obj;
        ElGamalParameters elGamalParameters = this.a;
        if (elGamalParameters != null) {
            return elGamalParameters.equals(elGamalKeyParameters.a);
        }
        if (elGamalKeyParameters.a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        ElGamalParameters elGamalParameters = this.a;
        if (elGamalParameters != null) {
            return elGamalParameters.hashCode();
        }
        return 0;
    }
}
