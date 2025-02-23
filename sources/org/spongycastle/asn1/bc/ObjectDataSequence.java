package org.spongycastle.asn1.bc;

import java.util.Iterator;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Iterable;

public class ObjectDataSequence extends ASN1Object implements Iterable<ASN1Encodable> {
    public final ASN1Encodable[] a;

    public ObjectDataSequence(ObjectData[] objectDataArr) {
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[objectDataArr.length];
        this.a = aSN1EncodableArr;
        System.arraycopy(objectDataArr, 0, aSN1EncodableArr, 0, objectDataArr.length);
    }

    public final ASN1Primitive b() {
        return new DERSequence(this.a);
    }

    public final Iterator<ASN1Encodable> iterator() {
        return new Arrays.Iterator(this.a);
    }

    public ObjectDataSequence(ASN1Sequence aSN1Sequence) {
        ObjectData objectData;
        this.a = new ASN1Encodable[aSN1Sequence.size()];
        int i = 0;
        while (true) {
            ASN1Encodable[] aSN1EncodableArr = this.a;
            if (i != aSN1EncodableArr.length) {
                ASN1Encodable s = aSN1Sequence.s(i);
                if (s instanceof ObjectData) {
                    objectData = (ObjectData) s;
                } else {
                    objectData = s != null ? new ObjectData(ASN1Sequence.q(s)) : null;
                }
                aSN1EncodableArr[i] = objectData;
                i++;
            } else {
                return;
            }
        }
    }
}
