package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class PolicyInformation extends ASN1Object {
    public final ASN1ObjectIdentifier Z0;
    public final ASN1Sequence a;

    public PolicyInformation(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
        }
        this.Z0 = ASN1ObjectIdentifier.u(aSN1Sequence.s(0));
        if (aSN1Sequence.size() > 1) {
            this.a = ASN1Sequence.q(aSN1Sequence.s(1));
        }
    }

    public static PolicyInformation g(Object obj) {
        if (obj == null || (obj instanceof PolicyInformation)) {
            return (PolicyInformation) obj;
        }
        return new PolicyInformation(ASN1Sequence.q(obj));
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.Z0);
        ASN1Sequence aSN1Sequence = this.a;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.a(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final String toString() {
        PolicyQualifierInfo policyQualifierInfo;
        StringBuffer stringBuffer = new StringBuffer("Policy information: ");
        stringBuffer.append(this.Z0);
        ASN1Sequence aSN1Sequence = this.a;
        if (aSN1Sequence != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i = 0; i < aSN1Sequence.size(); i++) {
                if (stringBuffer2.length() != 0) {
                    stringBuffer2.append(", ");
                }
                ASN1Encodable s = aSN1Sequence.s(i);
                if (s instanceof PolicyQualifierInfo) {
                    policyQualifierInfo = (PolicyQualifierInfo) s;
                } else if (s != null) {
                    policyQualifierInfo = new PolicyQualifierInfo(ASN1Sequence.q(s));
                } else {
                    policyQualifierInfo = null;
                }
                stringBuffer2.append(policyQualifierInfo);
            }
            stringBuffer.append("[");
            stringBuffer.append(stringBuffer2);
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }
}
