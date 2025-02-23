package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.KeyDerivationFunc;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;

public class PbkdMacIntegrityCheck extends ASN1Object {
    public final ASN1OctetString a;

    /* renamed from: a  reason: collision with other field name */
    public final KeyDerivationFunc f5684a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5685a;

    public PbkdMacIntegrityCheck(AlgorithmIdentifier algorithmIdentifier, KeyDerivationFunc keyDerivationFunc, byte[] bArr) {
        this.f5685a = algorithmIdentifier;
        this.f5684a = keyDerivationFunc;
        this.a = new DEROctetString(Arrays.c(bArr));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5685a);
        aSN1EncodableVector.a(this.f5684a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public PbkdMacIntegrityCheck(ASN1Sequence aSN1Sequence) {
        KeyDerivationFunc keyDerivationFunc;
        this.f5685a = AlgorithmIdentifier.g(aSN1Sequence.s(0));
        ASN1Encodable s = aSN1Sequence.s(1);
        if (s instanceof KeyDerivationFunc) {
            keyDerivationFunc = (KeyDerivationFunc) s;
        } else {
            keyDerivationFunc = s != null ? new KeyDerivationFunc(ASN1Sequence.q(s)) : null;
        }
        this.f5684a = keyDerivationFunc;
        this.a = ASN1OctetString.q(aSN1Sequence.s(2));
    }
}
