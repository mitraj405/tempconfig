package org.spongycastle.asn1.pkcs;

import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class PrivateKeyInfo extends ASN1Object {
    public final ASN1OctetString a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1Set f5701a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5702a;

    public PrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Object aSN1Object) throws IOException {
        this.a = new DEROctetString(aSN1Object.b().f("DER"));
        this.f5702a = algorithmIdentifier;
        this.f5701a = null;
    }

    public static PrivateKeyInfo g(Object obj) {
        if (obj instanceof PrivateKeyInfo) {
            return (PrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new PrivateKeyInfo(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(new ASN1Integer(0));
        aSN1EncodableVector.a(this.f5702a);
        aSN1EncodableVector.a(this.a);
        ASN1Set aSN1Set = this.f5701a;
        if (aSN1Set != null) {
            aSN1EncodableVector.a(new DERTaggedObject(false, 0, aSN1Set));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public final ASN1Primitive h() throws IOException {
        return ASN1Primitive.k(this.a.s());
    }

    public PrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        if (((ASN1Integer) t.nextElement()).t().intValue() == 0) {
            this.f5702a = AlgorithmIdentifier.g(t.nextElement());
            this.a = ASN1OctetString.q(t.nextElement());
            if (t.hasMoreElements()) {
                this.f5701a = ASN1Set.r((ASN1TaggedObject) t.nextElement());
                return;
            }
            return;
        }
        throw new IllegalArgumentException("wrong version for private key info");
    }
}
