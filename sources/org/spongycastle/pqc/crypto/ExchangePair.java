package org.spongycastle.pqc.crypto;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.newhope.NHPublicKeyParameters;
import org.spongycastle.util.Arrays;

public class ExchangePair {
    public final AsymmetricKeyParameter a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6659a;

    public ExchangePair(NHPublicKeyParameters nHPublicKeyParameters, byte[] bArr) {
        this.a = nHPublicKeyParameters;
        this.f6659a = Arrays.c(bArr);
    }
}
