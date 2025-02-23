package org.spongycastle.asn1.pkcs;

import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class PBES2Parameters extends ASN1Object implements PKCSObjectIdentifiers {
    public final EncryptionScheme a;

    /* renamed from: a  reason: collision with other field name */
    public final KeyDerivationFunc f5695a;

    public PBES2Parameters(KeyDerivationFunc keyDerivationFunc, EncryptionScheme encryptionScheme) {
        this.f5695a = keyDerivationFunc;
        this.a = encryptionScheme;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.f5695a);
        aSN1EncodableVector.a(this.a);
        return new DERSequence(aSN1EncodableVector);
    }

    public PBES2Parameters(ASN1Sequence aSN1Sequence) {
        EncryptionScheme encryptionScheme;
        KeyDerivationFunc keyDerivationFunc;
        Enumeration t = aSN1Sequence.t();
        ASN1Sequence q = ASN1Sequence.q(((ASN1Encodable) t.nextElement()).b());
        ASN1Encodable s = q.s(0);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.x;
        if (s.equals(aSN1ObjectIdentifier)) {
            this.f5695a = new KeyDerivationFunc(aSN1ObjectIdentifier, PBKDF2Params.g(q.s(1)));
        } else {
            if (q instanceof KeyDerivationFunc) {
                keyDerivationFunc = (KeyDerivationFunc) q;
            } else {
                keyDerivationFunc = new KeyDerivationFunc(ASN1Sequence.q(q));
            }
            this.f5695a = keyDerivationFunc;
        }
        Object nextElement = t.nextElement();
        if (nextElement instanceof EncryptionScheme) {
            encryptionScheme = (EncryptionScheme) nextElement;
        } else {
            encryptionScheme = nextElement != null ? new EncryptionScheme(ASN1Sequence.q(nextElement)) : null;
        }
        this.a = encryptionScheme;
    }
}
