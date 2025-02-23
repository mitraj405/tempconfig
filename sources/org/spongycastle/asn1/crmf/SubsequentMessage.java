package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Integer;

public class SubsequentMessage extends ASN1Integer {
    static {
        new SubsequentMessage(0);
        new SubsequentMessage(1);
    }

    public SubsequentMessage(int i) {
        super((long) i);
    }
}
