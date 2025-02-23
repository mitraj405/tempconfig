package org.spongycastle.crypto.params;

public class ECKeyParameters extends AsymmetricKeyParameter {
    public final ECDomainParameters a;

    public ECKeyParameters(boolean z, ECDomainParameters eCDomainParameters) {
        super(z);
        this.a = eCDomainParameters;
    }
}
