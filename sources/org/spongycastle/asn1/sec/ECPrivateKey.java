package org.spongycastle.asn1.sec;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.util.BigIntegers;

public class ECPrivateKey extends ASN1Object {
    public final ASN1Sequence a;

    public ECPrivateKey() {
        throw null;
    }

    public ECPrivateKey(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static ECPrivateKey g(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ECPrivateKey) {
            return (ECPrivateKey) aSN1Primitive;
        }
        if (aSN1Primitive != null) {
            return new ECPrivateKey(ASN1Sequence.q(aSN1Primitive));
        }
        return null;
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public final BigInteger h() {
        return new BigInteger(1, ((ASN1OctetString) this.a.s(1)).s());
    }

    public final DERBitString i() {
        ASN1Primitive aSN1Primitive;
        Enumeration t = this.a.t();
        while (true) {
            if (!t.hasMoreElements()) {
                aSN1Primitive = null;
                break;
            }
            ASN1Encodable aSN1Encodable = (ASN1Encodable) t.nextElement();
            if (aSN1Encodable instanceof ASN1TaggedObject) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Encodable;
                if (aSN1TaggedObject.c == 1) {
                    aSN1Primitive = aSN1TaggedObject.r();
                    aSN1Primitive.getClass();
                    break;
                }
            }
        }
        return (DERBitString) aSN1Primitive;
    }

    public ECPrivateKey(int i, BigInteger bigInteger, DERBitString dERBitString, X962Parameters x962Parameters) {
        byte[] a2 = BigIntegers.a((i + 7) / 8, bigInteger);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(1));
        aSN1EncodableVector.a(new DEROctetString(a2));
        aSN1EncodableVector.a(new DERTaggedObject(true, 0, x962Parameters));
        if (dERBitString != null) {
            aSN1EncodableVector.a(new DERTaggedObject(true, 1, dERBitString));
        }
        this.a = new DERSequence(aSN1EncodableVector);
    }
}
