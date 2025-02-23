package org.spongycastle.x509;

import org.spongycastle.util.Selector;

public class X509CertPairStoreSelector implements Selector {
    public X509CertStoreSelector a;

    /* renamed from: a  reason: collision with other field name */
    public X509CertificatePair f6875a;
    public X509CertStoreSelector b;

    public final Object clone() {
        X509CertPairStoreSelector x509CertPairStoreSelector = new X509CertPairStoreSelector();
        x509CertPairStoreSelector.f6875a = this.f6875a;
        X509CertStoreSelector x509CertStoreSelector = this.a;
        if (x509CertStoreSelector != null) {
            x509CertPairStoreSelector.a = (X509CertStoreSelector) x509CertStoreSelector.clone();
        }
        X509CertStoreSelector x509CertStoreSelector2 = this.b;
        if (x509CertStoreSelector2 != null) {
            x509CertPairStoreSelector.b = (X509CertStoreSelector) x509CertStoreSelector2.clone();
        }
        return x509CertPairStoreSelector;
    }
}
