package org.spongycastle.x509;

import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import org.spongycastle.util.Selector;

public class X509CertStoreSelector extends X509CertSelector implements Selector {
    public final boolean a(Object obj) {
        if (!(obj instanceof X509Certificate)) {
            return false;
        }
        return super.match((X509Certificate) obj);
    }

    public final Object clone() {
        return (X509CertStoreSelector) super.clone();
    }

    public final boolean match(Certificate certificate) {
        return a(certificate);
    }
}
