package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Strings;

public class DistributionPoint extends ASN1Object {
    public final DistributionPointName a;

    /* renamed from: a  reason: collision with other field name */
    public final GeneralNames f5738a;

    /* renamed from: a  reason: collision with other field name */
    public final ReasonFlags f5739a;

    public DistributionPoint(ASN1Sequence aSN1Sequence) {
        DistributionPointName distributionPointName;
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject q = ASN1TaggedObject.q(aSN1Sequence.s(i));
            int i2 = q.c;
            if (i2 == 0) {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) q.r();
                if (aSN1TaggedObject == null || (aSN1TaggedObject instanceof DistributionPointName)) {
                    distributionPointName = (DistributionPointName) aSN1TaggedObject;
                } else {
                    distributionPointName = new DistributionPointName(aSN1TaggedObject);
                }
                this.a = distributionPointName;
            } else if (i2 == 1) {
                this.f5739a = new ReasonFlags(DERBitString.v(q));
            } else if (i2 == 2) {
                this.f5738a = GeneralNames.g(ASN1Sequence.r(q, false));
            } else {
                throw new IllegalArgumentException("Unknown tag encountered in structure: " + q.c);
            }
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        DistributionPointName distributionPointName = this.a;
        if (distributionPointName != null) {
            aSN1EncodableVector.a(new DERTaggedObject(0, distributionPointName));
        }
        ReasonFlags reasonFlags = this.f5739a;
        if (reasonFlags != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 1, reasonFlags));
        }
        GeneralNames generalNames = this.f5738a;
        if (generalNames != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 2, generalNames));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final void g(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    public final String toString() {
        String str = Strings.a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistributionPoint: [");
        stringBuffer.append(str);
        DistributionPointName distributionPointName = this.a;
        if (distributionPointName != null) {
            g(stringBuffer, str, "distributionPoint", distributionPointName.toString());
        }
        ReasonFlags reasonFlags = this.f5739a;
        if (reasonFlags != null) {
            g(stringBuffer, str, "reasons", reasonFlags.toString());
        }
        GeneralNames generalNames = this.f5738a;
        if (generalNames != null) {
            g(stringBuffer, str, "cRLIssuer", generalNames.toString());
        }
        stringBuffer.append("]");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public DistributionPoint(DistributionPointName distributionPointName) {
        this.a = distributionPointName;
        this.f5739a = null;
        this.f5738a = null;
    }
}
