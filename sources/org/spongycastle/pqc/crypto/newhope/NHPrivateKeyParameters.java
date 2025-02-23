package org.spongycastle.pqc.crypto.newhope;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;

public class NHPrivateKeyParameters extends AsymmetricKeyParameter {
    public final short[] a;

    public NHPrivateKeyParameters(short[] sArr) {
        super(true);
        this.a = Arrays.g(sArr);
    }
}
