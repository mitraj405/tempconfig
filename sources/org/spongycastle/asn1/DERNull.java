package org.spongycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null {
    public static final DERNull a = new DERNull();

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f5671a = new byte[0];

    public final void h(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.d(5, f5671a);
    }

    public final int i() {
        return 2;
    }

    public final boolean n() {
        return false;
    }
}
