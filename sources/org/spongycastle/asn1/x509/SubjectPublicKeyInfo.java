package org.spongycastle.asn1.x509;

import java.io.IOException;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERSequence;

public class SubjectPublicKeyInfo extends ASN1Object {
    public final DERBitString a;

    /* renamed from: a  reason: collision with other field name */
    public final AlgorithmIdentifier f5753a;

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, ASN1Object aSN1Object) throws IOException {
        this.a = new DERBitString(aSN1Object);
        this.f5753a = algorithmIdentifier;
    }

    public static SubjectPublicKeyInfo g(Object obj) {
        if (obj instanceof SubjectPublicKeyInfo) {
            return (SubjectPublicKeyInfo) obj;
        }
        if (obj != null) {
            return new SubjectPublicKeyInfo(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5753a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public final ASN1Primitive h() throws IOException {
        return new ASN1InputStream(this.a.s()).j();
    }

    public SubjectPublicKeyInfo(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.a = new DERBitString(bArr);
        this.f5753a = algorithmIdentifier;
    }

    public SubjectPublicKeyInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            Enumeration t = aSN1Sequence.t();
            this.f5753a = AlgorithmIdentifier.g(t.nextElement());
            this.a = DERBitString.u(t.nextElement());
            return;
        }
        throw new IllegalArgumentException(C0709Uj.k(aSN1Sequence, new StringBuilder("Bad sequence size: ")));
    }
}
