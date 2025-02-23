package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.DigestDerivationFunction;
import org.spongycastle.util.Pack;

public class ECDHKEKGenerator implements DigestDerivationFunction {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public ASN1ObjectIdentifier f5811a;

    public final void a(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.f5811a = dHKDFParameters.f5806a;
        this.a = dHKDFParameters.a;
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new AlgorithmIdentifier(this.f5811a, DERNull.a));
        byte[] bArr2 = new byte[4];
        Pack.c(this.a, bArr2, 0);
        aSN1EncodableVector.a(new DERTaggedObject(true, 2, new DEROctetString(bArr2)));
        try {
            new DERSequence(aSN1EncodableVector).f("DER");
            throw null;
        } catch (IOException e) {
            throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("unable to initialise kdf: ")));
        }
    }
}
