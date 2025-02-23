package org.spongycastle.pqc.crypto.sphincs;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;

public class SPHINCSPublicKeyParameters extends AsymmetricKeyParameter {
    public final byte[] a;

    public SPHINCSPublicKeyParameters(byte[] bArr) {
        super(false);
        this.a = Arrays.c(bArr);
    }
}
