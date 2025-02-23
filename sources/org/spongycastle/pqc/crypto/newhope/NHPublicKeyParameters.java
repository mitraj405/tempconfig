package org.spongycastle.pqc.crypto.newhope;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;

public class NHPublicKeyParameters extends AsymmetricKeyParameter {
    public final byte[] a;

    public NHPublicKeyParameters(byte[] bArr) {
        super(false);
        this.a = Arrays.c(bArr);
    }
}
