package org.spongycastle.asn1.x500;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;

public class RDN extends ASN1Object {
    public final ASN1Set a;

    public RDN(ASN1Set aSN1Set) {
        this.a = aSN1Set;
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public final AttributeTypeAndValue g() {
        ASN1Set aSN1Set = this.a;
        if (aSN1Set.size() == 0) {
            return null;
        }
        ASN1Encodable s = aSN1Set.s(0);
        if (s instanceof AttributeTypeAndValue) {
            return (AttributeTypeAndValue) s;
        }
        if (s != null) {
            return new AttributeTypeAndValue(ASN1Sequence.q(s));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    public final AttributeTypeAndValue[] h() {
        AttributeTypeAndValue attributeTypeAndValue;
        ASN1Set aSN1Set = this.a;
        int size = aSN1Set.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i = 0; i != size; i++) {
            ASN1Encodable s = aSN1Set.s(i);
            if (s instanceof AttributeTypeAndValue) {
                attributeTypeAndValue = (AttributeTypeAndValue) s;
            } else if (s != null) {
                attributeTypeAndValue = new AttributeTypeAndValue(ASN1Sequence.q(s));
            } else {
                throw new IllegalArgumentException("null value in getInstance()");
            }
            attributeTypeAndValueArr[i] = attributeTypeAndValue;
        }
        return attributeTypeAndValueArr;
    }

    public final boolean i() {
        if (this.a.size() > 1) {
            return true;
        }
        return false;
    }
}
