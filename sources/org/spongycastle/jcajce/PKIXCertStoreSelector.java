package org.spongycastle.jcajce;

import java.io.IOException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import org.spongycastle.util.Selector;

public class PKIXCertStoreSelector<T extends Certificate> implements Selector<T> {
    public final CertSelector a;

    public static class Builder {
        public final CertSelector a;

        public Builder(CertSelector certSelector) {
            this.a = (CertSelector) certSelector.clone();
        }

        public final PKIXCertStoreSelector<? extends Certificate> a() {
            return new PKIXCertStoreSelector<>(this.a);
        }
    }

    public static class SelectorClone extends X509CertSelector {
        public final PKIXCertStoreSelector a;

        public SelectorClone(PKIXCertStoreSelector pKIXCertStoreSelector) {
            this.a = pKIXCertStoreSelector;
            CertSelector certSelector = pKIXCertStoreSelector.a;
            if (certSelector instanceof X509CertSelector) {
                X509CertSelector x509CertSelector = (X509CertSelector) certSelector;
                setAuthorityKeyIdentifier(x509CertSelector.getAuthorityKeyIdentifier());
                setBasicConstraints(x509CertSelector.getBasicConstraints());
                setCertificate(x509CertSelector.getCertificate());
                setCertificateValid(x509CertSelector.getCertificateValid());
                setKeyUsage(x509CertSelector.getKeyUsage());
                setMatchAllSubjectAltNames(x509CertSelector.getMatchAllSubjectAltNames());
                setPrivateKeyValid(x509CertSelector.getPrivateKeyValid());
                setSerialNumber(x509CertSelector.getSerialNumber());
                setSubjectKeyIdentifier(x509CertSelector.getSubjectKeyIdentifier());
                setSubjectPublicKey(x509CertSelector.getSubjectPublicKey());
                try {
                    setExtendedKeyUsage(x509CertSelector.getExtendedKeyUsage());
                    setIssuer(x509CertSelector.getIssuerAsBytes());
                    setNameConstraints(x509CertSelector.getNameConstraints());
                    setPathToNames(x509CertSelector.getPathToNames());
                    setPolicy(x509CertSelector.getPolicy());
                    setSubject(x509CertSelector.getSubjectAsBytes());
                    setSubjectAlternativeNames(x509CertSelector.getSubjectAlternativeNames());
                    setSubjectPublicKeyAlgID(x509CertSelector.getSubjectPublicKeyAlgID());
                } catch (IOException e) {
                    throw new IllegalStateException(C0709Uj.g(e, new StringBuilder("base selector invalid: ")), e);
                }
            }
        }

        public final boolean match(Certificate certificate) {
            PKIXCertStoreSelector pKIXCertStoreSelector = this.a;
            if (pKIXCertStoreSelector != null) {
                return pKIXCertStoreSelector.a.match(certificate);
            }
            if (certificate != null) {
                return true;
            }
            return false;
        }
    }

    public PKIXCertStoreSelector(CertSelector certSelector) {
        this.a = certSelector;
    }

    public static Collection<? extends Certificate> a(PKIXCertStoreSelector pKIXCertStoreSelector, CertStore certStore) throws CertStoreException {
        return certStore.getCertificates(new SelectorClone(pKIXCertStoreSelector));
    }

    public final Object clone() {
        return new PKIXCertStoreSelector(this.a);
    }
}
