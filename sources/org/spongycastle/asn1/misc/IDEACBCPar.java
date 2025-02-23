package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class IDEACBCPar extends ASN1Object {
    public final ASN1OctetString a;

    public IDEACBCPar(byte[] bArr) {
        this.a = new DEROctetString(bArr);
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1OctetString aSN1OctetString = this.a;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.a(aSN1OctetString);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public IDEACBCPar(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1) {
            this.a = (ASN1OctetString) aSN1Sequence.s(0);
        } else {
            this.a = null;
        }
    }
}
