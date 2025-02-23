package org.spongycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class NameConstraints extends ASN1Object {
    public final GeneralSubtree[] a;
    public final GeneralSubtree[] b;

    public NameConstraints(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        while (t.hasMoreElements()) {
            ASN1TaggedObject q = ASN1TaggedObject.q(t.nextElement());
            int i = q.c;
            if (i == 0) {
                this.a = g(ASN1Sequence.r(q, false));
            } else if (i == 1) {
                this.b = g(ASN1Sequence.r(q, false));
            } else {
                throw new IllegalArgumentException("Unknown tag encountered: " + q.c);
            }
        }
    }

    public static GeneralSubtree[] g(ASN1Sequence aSN1Sequence) {
        GeneralSubtree generalSubtree;
        int size = aSN1Sequence.size();
        GeneralSubtree[] generalSubtreeArr = new GeneralSubtree[size];
        for (int i = 0; i != size; i++) {
            ASN1Encodable s = aSN1Sequence.s(i);
            BigInteger bigInteger = GeneralSubtree.a;
            if (s == null) {
                generalSubtree = null;
            } else if (s instanceof GeneralSubtree) {
                generalSubtree = (GeneralSubtree) s;
            } else {
                generalSubtree = new GeneralSubtree(ASN1Sequence.q(s));
            }
            generalSubtreeArr[i] = generalSubtree;
        }
        return generalSubtreeArr;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralSubtree[] generalSubtreeArr = this.a;
        if (generalSubtreeArr != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 0, new DERSequence((ASN1Encodable[]) generalSubtreeArr)));
        }
        GeneralSubtree[] generalSubtreeArr2 = this.b;
        if (generalSubtreeArr2 != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 1, new DERSequence((ASN1Encodable[]) generalSubtreeArr2)));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
