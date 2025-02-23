package org.spongycastle.jce.provider;

import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreSpi;
import java.util.ArrayList;
import java.util.Collection;

public class CertStoreCollectionSpi extends CertStoreSpi {
    public final Collection engineGetCRLs(CRLSelector cRLSelector) throws CertStoreException {
        new ArrayList();
        throw null;
    }

    public final Collection engineGetCertificates(CertSelector certSelector) throws CertStoreException {
        new ArrayList();
        throw null;
    }
}
