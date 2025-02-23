package org.spongycastle.x509;

import java.io.IOException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.util.Arrays;

public class X509V2AttributeCertificate implements X509AttributeCertificate {
    public final AttributeCertificateIssuer a() {
        throw null;
    }

    public final AttributeCertificateHolder b() {
        throw null;
    }

    public final X509Attribute[] c(String str) {
        throw null;
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.after((Date) null)) {
            throw new CertificateExpiredException("certificate expired on " + null);
        } else if (date.before((Date) null)) {
            throw new CertificateNotYetValidException("certificate not valid till " + null);
        }
    }

    public final HashSet d(boolean z) {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509AttributeCertificate)) {
            return false;
        }
        try {
            return Arrays.a(getEncoded(), ((X509AttributeCertificate) obj).getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    public final Set getCriticalExtensionOIDs() {
        return d(true);
    }

    public final byte[] getEncoded() throws IOException {
        throw null;
    }

    public final byte[] getExtensionValue(String str) {
        throw null;
    }

    public final Set getNonCriticalExtensionOIDs() {
        return d(false);
    }

    public final Date getNotAfter() {
        return null;
    }

    public final boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            return Arrays.t(getEncoded());
        } catch (IOException unused) {
            return 0;
        }
    }
}
