package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;

class ExtCRLException extends CRLException {
    public final Throwable a;

    public ExtCRLException(Exception exc) {
        super("Exception reading IssuingDistributionPoint");
        this.a = exc;
    }

    public final Throwable getCause() {
        return this.a;
    }
}
