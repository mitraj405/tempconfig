package org.spongycastle.asn1.isismtt.x509;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;

public class ProfessionInfo extends ASN1Object {
    static {
        StringBuilder sb = new StringBuilder();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NamingAuthority.Z0;
        sb.append(aSN1ObjectIdentifier);
        sb.append(".1");
        new ASN1ObjectIdentifier(sb.toString());
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".2");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".3");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".4");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".5");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".6");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".7");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".8");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".9");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".10");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".11");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".12");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".13");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".14");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".15");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".16");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".17");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".18");
        new ASN1ObjectIdentifier(aSN1ObjectIdentifier + ".19");
    }

    public final ASN1Primitive b() {
        return new DERSequence(C1058d.E((ASN1Encodable) null));
    }
}
