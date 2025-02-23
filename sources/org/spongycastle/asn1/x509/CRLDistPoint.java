package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.util.Strings;

public class CRLDistPoint extends ASN1Object {
    public final ASN1Sequence a = null;

    public CRLDistPoint(ASN1Sequence aSN1Sequence) {
        this.a = aSN1Sequence;
    }

    public static CRLDistPoint h(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof CRLDistPoint) {
            return (CRLDistPoint) aSN1Primitive;
        }
        if (aSN1Primitive != null) {
            return new CRLDistPoint(ASN1Sequence.q(aSN1Primitive));
        }
        return null;
    }

    public final ASN1Primitive b() {
        return this.a;
    }

    public final DistributionPoint[] g() {
        DistributionPoint distributionPoint;
        ASN1Sequence aSN1Sequence = this.a;
        DistributionPoint[] distributionPointArr = new DistributionPoint[aSN1Sequence.size()];
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1Encodable s = aSN1Sequence.s(i);
            if (s == null || (s instanceof DistributionPoint)) {
                distributionPoint = (DistributionPoint) s;
            } else if (s instanceof ASN1Sequence) {
                distributionPoint = new DistributionPoint((ASN1Sequence) s);
            } else {
                throw new IllegalArgumentException("Invalid DistributionPoint: ".concat(s.getClass().getName()));
            }
            distributionPointArr[i] = distributionPoint;
        }
        return distributionPointArr;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("CRLDistPoint:");
        String str = Strings.a;
        stringBuffer.append(str);
        DistributionPoint[] g = g();
        for (int i = 0; i != g.length; i++) {
            stringBuffer.append("    ");
            stringBuffer.append(g[i]);
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }
}
