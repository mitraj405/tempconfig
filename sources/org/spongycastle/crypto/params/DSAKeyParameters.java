package org.spongycastle.crypto.params;

public class DSAKeyParameters extends AsymmetricKeyParameter {
    public final DSAParameters a;

    public DSAKeyParameters(boolean z, DSAParameters dSAParameters) {
        super(z);
        this.a = dSAParameters;
    }
}
