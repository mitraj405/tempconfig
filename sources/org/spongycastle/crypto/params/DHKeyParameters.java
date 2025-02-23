package org.spongycastle.crypto.params;

public class DHKeyParameters extends AsymmetricKeyParameter {
    public final DHParameters a;

    public DHKeyParameters(boolean z, DHParameters dHParameters) {
        super(z);
        this.a = dHParameters;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHKeyParameters)) {
            return false;
        }
        DHKeyParameters dHKeyParameters = (DHKeyParameters) obj;
        DHParameters dHParameters = this.a;
        if (dHParameters != null) {
            return dHParameters.equals(dHKeyParameters.a);
        }
        if (dHKeyParameters.a == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        boolean z = !this.a;
        DHParameters dHParameters = this.a;
        return dHParameters != null ? z ^ dHParameters.hashCode() ? 1 : 0 : z ? 1 : 0;
    }
}
