package org.spongycastle.asn1.bc;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;

public class ObjectStoreIntegrityCheck extends ASN1Object implements ASN1Choice {
    public final PbkdMacIntegrityCheck a;

    public ObjectStoreIntegrityCheck(ASN1Encodable aSN1Encodable) {
        PbkdMacIntegrityCheck pbkdMacIntegrityCheck;
        if ((aSN1Encodable instanceof ASN1Sequence) || (aSN1Encodable instanceof PbkdMacIntegrityCheck)) {
            if (aSN1Encodable instanceof PbkdMacIntegrityCheck) {
                pbkdMacIntegrityCheck = (PbkdMacIntegrityCheck) aSN1Encodable;
            } else if (aSN1Encodable != null) {
                pbkdMacIntegrityCheck = new PbkdMacIntegrityCheck(ASN1Sequence.q(aSN1Encodable));
            } else {
                pbkdMacIntegrityCheck = null;
            }
            this.a = pbkdMacIntegrityCheck;
            return;
        }
        throw new IllegalArgumentException("Unknown check object in integrity check.");
    }

    public final ASN1Primitive b() {
        return this.a.b();
    }
}
