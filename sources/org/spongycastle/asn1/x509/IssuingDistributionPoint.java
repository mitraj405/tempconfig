package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Boolean;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.util.Strings;

public class IssuingDistributionPoint extends ASN1Object {
    public final ASN1Sequence a;

    /* renamed from: a  reason: collision with other field name */
    public final DistributionPointName f5748a;

    /* renamed from: a  reason: collision with other field name */
    public final ReasonFlags f5749a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5750a;
    public final boolean b;
    public final boolean c;
    public final boolean d;

    public IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        DistributionPointName distributionPointName;
        this.a = aSN1Sequence;
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
                this.f5748a = distributionPointName;
            } else if (i2 == 1) {
                this.f5750a = ASN1Boolean.s(q).t();
            } else if (i2 == 2) {
                this.b = ASN1Boolean.s(q).t();
            } else if (i2 == 3) {
                this.f5749a = new ReasonFlags(DERBitString.v(q));
            } else if (i2 == 4) {
                this.c = ASN1Boolean.s(q).t();
            } else if (i2 == 5) {
                this.d = ASN1Boolean.s(q).t();
            } else {
                throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
            }
        }
    }

    public static IssuingDistributionPoint h(Object obj) {
        if (obj instanceof IssuingDistributionPoint) {
            return (IssuingDistributionPoint) obj;
        }
        if (obj != null) {
            return new IssuingDistributionPoint(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        return this.a;
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
        String str;
        String str2;
        String str3;
        String str4 = Strings.a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(str4);
        DistributionPointName distributionPointName = this.f5748a;
        if (distributionPointName != null) {
            g(stringBuffer, str4, "distributionPoint", distributionPointName.toString());
        }
        String str5 = "true";
        boolean z = this.f5750a;
        if (z) {
            if (z) {
                str3 = str5;
            } else {
                str3 = "false";
            }
            g(stringBuffer, str4, "onlyContainsUserCerts", str3);
        }
        boolean z2 = this.b;
        if (z2) {
            if (z2) {
                str2 = str5;
            } else {
                str2 = "false";
            }
            g(stringBuffer, str4, "onlyContainsCACerts", str2);
        }
        ReasonFlags reasonFlags = this.f5749a;
        if (reasonFlags != null) {
            g(stringBuffer, str4, "onlySomeReasons", reasonFlags.toString());
        }
        boolean z3 = this.d;
        if (z3) {
            if (z3) {
                str = str5;
            } else {
                str = "false";
            }
            g(stringBuffer, str4, "onlyContainsAttributeCerts", str);
        }
        boolean z4 = this.c;
        if (z4) {
            if (!z4) {
                str5 = "false";
            }
            g(stringBuffer, str4, "indirectCRL", str5);
        }
        stringBuffer.append("]");
        stringBuffer.append(str4);
        return stringBuffer.toString();
    }
}
