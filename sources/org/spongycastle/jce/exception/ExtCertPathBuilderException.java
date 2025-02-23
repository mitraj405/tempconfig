package org.spongycastle.jce.exception;

import java.security.cert.CertPathBuilderException;

public class ExtCertPathBuilderException extends CertPathBuilderException implements ExtException {
    public final Throwable a;

    public ExtCertPathBuilderException(String str, Exception exc) {
        super(str);
        this.a = exc;
    }

    public final Throwable getCause() {
        return this.a;
    }
}
