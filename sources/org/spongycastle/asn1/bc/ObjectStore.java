package org.spongycastle.asn1.bc;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;

public class ObjectStore extends ASN1Object {
    public final ASN1Encodable a;

    /* renamed from: a  reason: collision with other field name */
    public final ObjectStoreIntegrityCheck f5680a;

    public ObjectStore(EncryptedObjectStoreData encryptedObjectStoreData, ObjectStoreIntegrityCheck objectStoreIntegrityCheck) {
        this.a = encryptedObjectStoreData;
        this.f5680a = objectStoreIntegrityCheck;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(this.f5680a);
        return new DERSequence(aSN1EncodableVector);
    }

    public ObjectStore(ASN1Sequence aSN1Sequence) {
        ObjectStoreIntegrityCheck objectStoreIntegrityCheck;
        ObjectStoreIntegrityCheck objectStoreIntegrityCheck2;
        EncryptedObjectStoreData encryptedObjectStoreData;
        ASN1Encodable s = aSN1Sequence.s(0);
        if (s instanceof EncryptedObjectStoreData) {
            this.a = s;
        } else if (s instanceof ObjectStoreData) {
            this.a = s;
        } else {
            ASN1Sequence q = ASN1Sequence.q(s);
            if (q.size() == 2) {
                if (q instanceof EncryptedObjectStoreData) {
                    encryptedObjectStoreData = (EncryptedObjectStoreData) q;
                } else {
                    encryptedObjectStoreData = new EncryptedObjectStoreData(ASN1Sequence.q(q));
                }
                this.a = encryptedObjectStoreData;
            } else {
                this.a = ObjectStoreData.g(q);
            }
        }
        ASN1Encodable s2 = aSN1Sequence.s(1);
        if (s2 instanceof ObjectStoreIntegrityCheck) {
            objectStoreIntegrityCheck = (ObjectStoreIntegrityCheck) s2;
        } else {
            if (s2 instanceof byte[]) {
                try {
                    objectStoreIntegrityCheck2 = new ObjectStoreIntegrityCheck(ASN1Primitive.k((byte[]) s2));
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Unable to parse integrity check details.");
                }
            } else if (s2 != null) {
                objectStoreIntegrityCheck2 = new ObjectStoreIntegrityCheck(s2);
            } else {
                objectStoreIntegrityCheck = null;
            }
            objectStoreIntegrityCheck = objectStoreIntegrityCheck2;
        }
        this.f5680a = objectStoreIntegrityCheck;
    }
}
