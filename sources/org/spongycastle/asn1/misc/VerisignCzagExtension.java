package org.spongycastle.asn1.misc;

import org.spongycastle.asn1.DERIA5String;

public class VerisignCzagExtension extends DERIA5String {
    public VerisignCzagExtension(DERIA5String dERIA5String) {
        super(dERIA5String.c());
    }

    public final String toString() {
        return "VerisignCzagExtension: ".concat(c());
    }
}
