package org.spongycastle.jce.provider;

import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreSpi;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import java.util.HashSet;

public class X509LDAPCertStoreSpi extends CertStoreSpi {
    public final Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        throw null;
    }

    public final Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        if (!(certSelector instanceof X509CertSelector)) {
            throw new CertStoreException("selector is not a X509CertSelector");
        }
        X509CertSelector x509CertSelector = (X509CertSelector) certSelector;
        new HashSet();
        throw null;
    }
}
