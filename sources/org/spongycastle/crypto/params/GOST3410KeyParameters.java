package org.spongycastle.crypto.params;

public class GOST3410KeyParameters extends AsymmetricKeyParameter {
    public final GOST3410Parameters a;

    public GOST3410KeyParameters(boolean z, GOST3410Parameters gOST3410Parameters) {
        super(z);
        this.a = gOST3410Parameters;
    }
}
