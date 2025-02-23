package org.spongycastle.crypto.params;

import org.spongycastle.crypto.CipherParameters;

public class AsymmetricKeyParameter implements CipherParameters {
    public final boolean a;

    public AsymmetricKeyParameter(boolean z) {
        this.a = z;
    }
}
