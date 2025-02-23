package org.spongycastle.crypto;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class AsymmetricCipherKeyPair {
    public final AsymmetricKeyParameter a;
    public final AsymmetricKeyParameter b;

    public AsymmetricCipherKeyPair(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2) {
        this.a = asymmetricKeyParameter;
        this.b = asymmetricKeyParameter2;
    }
}
