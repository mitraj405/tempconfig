package org.spongycastle.pqc.crypto.gmss;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class GMSSKeyParameters extends AsymmetricKeyParameter {
    public GMSSKeyParameters(boolean z, GMSSParameters gMSSParameters) {
        super(z);
    }
}
