package org.spongycastle.asn1.pkcs;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BERSequence;
import org.spongycastle.asn1.DLSequence;

public class AuthenticatedSafe extends ASN1Object {
    public final boolean a = true;

    /* renamed from: a  reason: collision with other field name */
    public final ContentInfo[] f5689a;

    public AuthenticatedSafe(ASN1Sequence aSN1Sequence) {
        this.f5689a = new ContentInfo[aSN1Sequence.size()];
        int i = 0;
        while (true) {
            ContentInfo[] contentInfoArr = this.f5689a;
            if (i != contentInfoArr.length) {
                contentInfoArr[i] = ContentInfo.g(aSN1Sequence.s(i));
                i++;
            } else {
                this.a = aSN1Sequence instanceof BERSequence;
                return;
            }
        }
    }

    public final ASN1Primitive b() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            ContentInfo[] contentInfoArr = this.f5689a;
            if (i == contentInfoArr.length) {
                break;
            }
            aSN1EncodableVector.a(contentInfoArr[i]);
            i++;
        }
        if (this.a) {
            return new BERSequence(aSN1EncodableVector);
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public AuthenticatedSafe(ContentInfo[] contentInfoArr) {
        this.f5689a = contentInfoArr;
    }
}
