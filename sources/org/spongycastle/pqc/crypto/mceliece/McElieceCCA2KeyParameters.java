package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceCCA2KeyParameters extends AsymmetricKeyParameter {
    public final String c;

    public McElieceCCA2KeyParameters(String str, boolean z) {
        super(z);
        this.c = str;
    }
}
