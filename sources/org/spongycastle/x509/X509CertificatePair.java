package org.spongycastle.x509;

public class X509CertificatePair {
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof X509CertificatePair)) {
            return false;
        }
        X509CertificatePair x509CertificatePair = (X509CertificatePair) obj;
        x509CertificatePair.getClass();
        x509CertificatePair.getClass();
        return true;
    }

    public final int hashCode() {
        return -1;
    }
}
