package org.spongycastle.x509;

import java.security.cert.CertificateEncodingException;

class ExtCertificateEncodingException extends CertificateEncodingException {
    public final Throwable getCause() {
        return null;
    }
}
