package org.spongycastle.asn1.sec;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.util.BigIntegers;

public class ECPrivateKeyStructure extends ASN1Object {
    public final ASN1Sequence a;

    public ECPrivateKeyStructure(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public ECPrivateKeyStructure(BigInteger bigInteger, DERBitString dERBitString, X962Parameters x962Parameters) {
        byte[] b = BigIntegers.b(bigInteger);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(1));
        aSN1EncodableVector.a(new DEROctetString(b));
        aSN1EncodableVector.a(new DERTaggedObject(true, 0, x962Parameters));
        if (dERBitString != null) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 1, dERBitString));
        }
        this.a = new DERSequence(aSN1EncodableVector);
    }
}
