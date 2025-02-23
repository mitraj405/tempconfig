package org.spongycastle.pqc.crypto.rainbow;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class RainbowKeyParameters extends AsymmetricKeyParameter {
    public final int c;

    public RainbowKeyParameters(boolean z, int i) {
        super(z);
        this.c = i;
    }
}
