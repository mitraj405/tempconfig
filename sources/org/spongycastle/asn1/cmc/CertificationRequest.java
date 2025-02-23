package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;

public class CertificationRequest extends ASN1Object {

    public class CertificationRequestInfo extends ASN1Object {
        public final ASN1Primitive b() {
            ASN1EncodableVector F = C1058d.F((ASN1Encodable) null, (ASN1Encodable) null, (ASN1Encodable) null);
            F.a(new DERTaggedObject(false, 0, (ASN1Encodable) null));
            return new DERSequence(F);
        }
    }

    static {
        new ASN1Integer(0);
    }

    public final ASN1Primitive b() {
        return new DERSequence(C1058d.F((ASN1Encodable) null, (ASN1Encodable) null, (ASN1Encodable) null));
    }
}
