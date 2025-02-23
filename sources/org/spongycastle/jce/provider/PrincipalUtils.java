package org.spongycastle.jce.provider;

import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.x509.X509AttributeCertificate;

class PrincipalUtils {
    public static X500Name a(Object obj) {
        if (obj instanceof X509Certificate) {
            return X500Name.g(((X509Certificate) obj).getIssuerX500Principal().getEncoded());
        }
        return X500Name.g(((X500Principal) ((X509AttributeCertificate) obj).a().a()[0]).getEncoded());
    }

    public static X500Name b(X509CRL x509crl) {
        return X500Name.g(x509crl.getIssuerX500Principal().getEncoded());
    }
}
