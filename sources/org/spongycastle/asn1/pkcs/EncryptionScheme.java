package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptionScheme extends ASN1Object {
    public final AlgorithmIdentifier a;

    public EncryptionScheme(ASN1ObjectIdentifier aSN1ObjectIdentifier, CCMParameters cCMParameters) {
        this.a = new AlgorithmIdentifier(aSN1ObjectIdentifier, cCMParameters);
    }

    public final ASN1Primitive b() {
        return this.a.b();
    }

    public EncryptionScheme(ASN1Sequence aSN1Sequence) {
        this.a = AlgorithmIdentifier.g(aSN1Sequence);
    }
}
