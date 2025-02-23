package org.spongycastle.asn1.x500.style;

import org.spongycastle.asn1.x500.RDN;
import org.spongycastle.asn1.x500.X500Name;

public class BCStrictStyle extends BCStyle {
    static {
        new BCStrictStyle();
    }

    public final boolean b(X500Name x500Name, X500Name x500Name2) {
        RDN[] h = x500Name.h();
        RDN[] h2 = x500Name2.h();
        if (h.length != h2.length) {
            return false;
        }
        for (int i = 0; i != h.length; i++) {
            if (!AbstractX500NameStyle.e(h[i], h2[i])) {
                return false;
            }
        }
        return true;
    }
}
