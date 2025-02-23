package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.DerivationParameters;

public class DHKDFParameters implements DerivationParameters {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1ObjectIdentifier f5806a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f5807a;
    public final byte[] b;

    public DHKDFParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, byte[] bArr, byte[] bArr2) {
        this.f5806a = aSN1ObjectIdentifier;
        this.a = i;
        this.f5807a = bArr;
        this.b = bArr2;
    }
}
