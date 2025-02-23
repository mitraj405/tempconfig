package org.spongycastle.asn1;

import java.io.IOException;

public class ASN1Exception extends IOException {
    public final Throwable a;

    public ASN1Exception(String str) {
        super(str);
    }

    public final Throwable getCause() {
        return this.a;
    }

    public ASN1Exception(String str, IllegalArgumentException illegalArgumentException) {
        super(str);
        this.a = illegalArgumentException;
    }
}
