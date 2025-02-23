package org.spongycastle.asn1.cryptopro;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class GOST28147Parameters extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1OctetString a;

    public GOST28147Parameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.a = new DEROctetString(bArr);
        this.Z0 = aSN1ObjectIdentifier;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.Z0);
        return new DERSequence(aSN1EncodableVector);
    }

    public GOST28147Parameters(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.a = (ASN1OctetString) t.nextElement();
        this.Z0 = (ASN1ObjectIdentifier) t.nextElement();
    }
}
