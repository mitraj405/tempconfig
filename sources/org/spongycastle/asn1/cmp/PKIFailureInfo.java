package org.spongycastle.asn1.cmp;

import org.spongycastle.asn1.DERBitString;

public class PKIFailureInfo extends DERBitString {
    public final String toString() {
        return "PKIFailureInfo: 0x" + Integer.toHexString(t());
    }
}
