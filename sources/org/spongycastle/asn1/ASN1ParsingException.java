package org.spongycastle.asn1;

public class ASN1ParsingException extends IllegalStateException {
    public final Throwable a;

    public ASN1ParsingException(String str) {
        super(str);
    }

    public final Throwable getCause() {
        return this.a;
    }

    public ASN1ParsingException(String str, Exception exc) {
        super(str);
        this.a = exc;
    }
}
