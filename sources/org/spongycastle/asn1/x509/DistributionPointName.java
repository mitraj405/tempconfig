package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.util.Strings;

public class DistributionPointName extends ASN1Object implements ASN1Choice {
    public final ASN1Encodable a;
    public final int c;

    public DistributionPointName(GeneralNames generalNames) {
        this.c = 0;
        this.a = generalNames;
    }

    public final ASN1Primitive b() {
        return new DERTaggedObject(false, this.c, this.a);
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
        stringBuffer.append("DistributionPointName: [");
        stringBuffer.append(str);
        int i = this.c;
        ASN1Encodable aSN1Encodable = this.a;
        if (i == 0) {
            g(stringBuffer, str, "fullName", aSN1Encodable.toString());
        } else {
            g(stringBuffer, str, "nameRelativeToCRLIssuer", aSN1Encodable.toString());
        }
        stringBuffer.append("]");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public DistributionPointName(ASN1TaggedObject aSN1TaggedObject) {
        int i = aSN1TaggedObject.c;
        this.c = i;
        if (i == 0) {
            this.a = GeneralNames.g(ASN1Sequence.r(aSN1TaggedObject, false));
        } else {
            this.a = ASN1Set.r(aSN1TaggedObject);
        }
    }
}
