package org.spongycastle.asn1.x509;

import java.io.IOException;
import java.util.Hashtable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;

public class V2TBSCertListGenerator {
    static {
        a(0);
        a(1);
        a(2);
        a(3);
        a(4);
        a(5);
        a(6);
        a(7);
        a(8);
        a(9);
        a(10);
    }

    public V2TBSCertListGenerator() {
        new ASN1Integer(1);
        new ASN1EncodableVector();
    }

    public static DERSequence a(int i) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Integer valueOf = Integer.valueOf(i);
        Hashtable hashtable = CRLReason.a;
        if (!hashtable.containsKey(valueOf)) {
            hashtable.put(valueOf, new CRLReason(i));
        }
        CRLReason cRLReason = (CRLReason) hashtable.get(valueOf);
        try {
            aSN1EncodableVector.a(Extension.f1);
            aSN1EncodableVector.a(new DEROctetString(cRLReason.e()));
            return new DERSequence(aSN1EncodableVector);
        } catch (IOException e) {
            throw new IllegalArgumentException("error encoding reason: " + e);
        }
    }
}
