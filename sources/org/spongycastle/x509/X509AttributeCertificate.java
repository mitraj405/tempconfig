package org.spongycastle.x509;

import java.io.IOException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Extension;
import java.util.Date;

public interface X509AttributeCertificate extends X509Extension {
    AttributeCertificateIssuer a();

    AttributeCertificateHolder b();

    X509Attribute[] c(String str);

    void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException;

    byte[] getEncoded() throws IOException;

    Date getNotAfter();
}
