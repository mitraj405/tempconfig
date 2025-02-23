package org.spongycastle.asn1.dvcs;

import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;

public class ServiceType extends ASN1Object {
    public static final ServiceType a = new ServiceType(1);
    public static final ServiceType b = new ServiceType(2);
    public static final ServiceType c = new ServiceType(3);
    public static final ServiceType d = new ServiceType(4);

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Enumerated f5687a;

    public ServiceType(int i) {
        this.f5687a = new ASN1Enumerated(i);
    }

    public final ASN1Primitive b() {
        return this.f5687a;
    }

    public final String toString() {
        String str;
        int intValue = this.f5687a.r().intValue();
        StringBuilder sb = new StringBuilder("");
        sb.append(intValue);
        if (intValue == a.f5687a.r().intValue()) {
            str = "(CPD)";
        } else if (intValue == b.f5687a.r().intValue()) {
            str = "(VSD)";
        } else if (intValue == c.f5687a.r().intValue()) {
            str = "(VPKC)";
        } else if (intValue == d.f5687a.r().intValue()) {
            str = "(CCPD)";
        } else {
            str = "?";
        }
        sb.append(str);
        return sb.toString();
    }
}
