package org.spongycastle.pqc.crypto.sphincs;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;

public class SPHINCSPrivateKeyParameters extends AsymmetricKeyParameter {
    public final byte[] a;

    public SPHINCSPrivateKeyParameters(byte[] bArr) {
        super(true);
        this.a = Arrays.c(bArr);
    }
}
