package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.x509.Certificate;

public class EncryptedPrivateKeyData extends ASN1Object {
    public final EncryptedPrivateKeyInfo a;

    /* renamed from: a  reason: collision with other field name */
    public final Certificate[] f5676a;

    public EncryptedPrivateKeyData(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo, Certificate[] certificateArr) {
        this.a = encryptedPrivateKeyInfo;
        Certificate[] certificateArr2 = new Certificate[certificateArr.length];
        this.f5676a = certificateArr2;
        System.arraycopy(certificateArr, 0, certificateArr2, 0, certificateArr.length);
    }

    public static EncryptedPrivateKeyData g(Object obj) {
        if (obj instanceof EncryptedPrivateKeyData) {
            return (EncryptedPrivateKeyData) obj;
        }
        if (obj != null) {
            return new EncryptedPrivateKeyData(ASN1Sequence.q(obj));
        }
        return null;
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.a(this.a);
        aSN1EncodableVector.a(new DERSequence((ASN1Encodable[]) this.f5676a));
        return new DERSequence(aSN1EncodableVector);
    }

    public EncryptedPrivateKeyData(ASN1Sequence aSN1Sequence) {
        int i = 0;
        this.a = EncryptedPrivateKeyInfo.g(aSN1Sequence.s(0));
        ASN1Sequence q = ASN1Sequence.q(aSN1Sequence.s(1));
        this.f5676a = new Certificate[q.size()];
        while (true) {
            Certificate[] certificateArr = this.f5676a;
            if (i != certificateArr.length) {
                certificateArr[i] = Certificate.g(q.s(i));
                i++;
            } else {
                return;
            }
        }
    }
}
