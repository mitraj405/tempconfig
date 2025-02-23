package org.spongycastle.asn1.pkcs;

import java.math.BigInteger;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;

public class Pfx extends ASN1Object implements PKCSObjectIdentifiers {
    public final ContentInfo a;

    /* renamed from: a  reason: collision with other field name */
    public final MacData f5700a = null;

    public Pfx(ASN1Sequence aSN1Sequence) {
        MacData macData = null;
        if (((ASN1Integer) aSN1Sequence.s(0)).t().intValue() == 3) {
            this.a = ContentInfo.g(aSN1Sequence.s(1));
            if (aSN1Sequence.size() == 3) {
                ASN1Encodable s = aSN1Sequence.s(2);
                BigInteger bigInteger = MacData.b;
                if (s instanceof MacData) {
                    macData = (MacData) s;
                } else if (s != null) {
                    macData = new MacData(ASN1Sequence.q(s));
                }
                this.f5700a = macData;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for PFX PDU");
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(3));
        aSN1EncodableVector.a(this.a);
        MacData macData = this.f5700a;
        if (macData != null) {
            aSN1EncodableVector.a(macData);
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public Pfx(ContentInfo contentInfo, MacData macData) {
        this.a = contentInfo;
        this.f5700a = macData;
    }
}
