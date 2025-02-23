package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class RSAPrivateKeyStructure extends ASN1Object {
    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer((long) 0));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        aSN1EncodableVector.a(new ASN1Integer((BigInteger) null));
        return new DERSequence(aSN1EncodableVector);
    }
}
