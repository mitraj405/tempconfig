package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class EncryptedPrivateKeyInfo extends ASN1Object {
    public final ASN1OctetString a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5691a;

    public EncryptedPrivateKeyInfo(ASN1Sequence aSN1Sequence) {
        Enumeration t = aSN1Sequence.t();
        this.f5691a = AlgorithmIdentifier.g(t.nextElement());
        this.a = ASN1OctetString.q(t.nextElement());
    }

    public static EncryptedPrivateKeyInfo g(Object obj) {
        if (obj instanceof EncryptedPrivateKeyInfo) {
            return (EncryptedPrivateKeyInfo) obj;
        }
        if (obj != null) {
            return new EncryptedPrivateKeyInfo(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5691a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedPrivateKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.f5691a = algorithmIdentifier;
        this.a = new DEROctetString(bArr);
    }
}
