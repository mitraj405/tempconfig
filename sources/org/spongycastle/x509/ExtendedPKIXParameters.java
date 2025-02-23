package org.spongycastle.x509;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.X509CertSelector;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.spongycastle.util.Selector;

public class ExtendedPKIXParameters extends PKIXParameters {
    public ArrayList a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public HashSet f6862a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    public Selector f6863a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6864a = false;
    public ArrayList b = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    public HashSet f6865b = new HashSet();
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public HashSet f6866c = new HashSet();
    public HashSet d = new HashSet();

    public ExtendedPKIXParameters(Set set) throws InvalidAlgorithmParameterException {
        super(set);
    }

    public void a(PKIXParameters pKIXParameters) {
        Selector selector;
        setDate(pKIXParameters.getDate());
        setCertPathCheckers(pKIXParameters.getCertPathCheckers());
        setCertStores(pKIXParameters.getCertStores());
        setAnyPolicyInhibited(pKIXParameters.isAnyPolicyInhibited());
        setExplicitPolicyRequired(pKIXParameters.isExplicitPolicyRequired());
        setPolicyMappingInhibited(pKIXParameters.isPolicyMappingInhibited());
        setRevocationEnabled(pKIXParameters.isRevocationEnabled());
        setInitialPolicies(pKIXParameters.getInitialPolicies());
        setPolicyQualifiersRejected(pKIXParameters.getPolicyQualifiersRejected());
        setSigProvider(pKIXParameters.getSigProvider());
        setTargetCertConstraints(pKIXParameters.getTargetCertConstraints());
        try {
            setTrustAnchors(pKIXParameters.getTrustAnchors());
            if (pKIXParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXParameters extendedPKIXParameters = (ExtendedPKIXParameters) pKIXParameters;
                this.c = extendedPKIXParameters.c;
                this.f6864a = extendedPKIXParameters.f6864a;
                Selector selector2 = extendedPKIXParameters.f6863a;
                if (selector2 == null) {
                    selector = null;
                } else {
                    selector = (Selector) selector2.clone();
                }
                this.f6863a = selector;
                this.a = new ArrayList(extendedPKIXParameters.a);
                this.b = new ArrayList(extendedPKIXParameters.b);
                this.f6862a = new HashSet(extendedPKIXParameters.f6862a);
                this.f6866c = new HashSet(extendedPKIXParameters.f6866c);
                this.f6865b = new HashSet(extendedPKIXParameters.f6865b);
                this.d = new HashSet(extendedPKIXParameters.d);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Object clone() {
        try {
            ExtendedPKIXParameters extendedPKIXParameters = new ExtendedPKIXParameters(getTrustAnchors());
            extendedPKIXParameters.a(this);
            return extendedPKIXParameters;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public final void setCertStores(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                addCertStore((CertStore) it.next());
            }
        }
    }

    public final void setTargetCertConstraints(CertSelector certSelector) {
        super.setTargetCertConstraints(certSelector);
        if (certSelector != null) {
            X509CertSelector x509CertSelector = (X509CertSelector) certSelector;
            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
            x509CertStoreSelector.setAuthorityKeyIdentifier(x509CertSelector.getAuthorityKeyIdentifier());
            x509CertStoreSelector.setBasicConstraints(x509CertSelector.getBasicConstraints());
            x509CertStoreSelector.setCertificate(x509CertSelector.getCertificate());
            x509CertStoreSelector.setCertificateValid(x509CertSelector.getCertificateValid());
            x509CertStoreSelector.setMatchAllSubjectAltNames(x509CertSelector.getMatchAllSubjectAltNames());
            try {
                x509CertStoreSelector.setPathToNames(x509CertSelector.getPathToNames());
                x509CertStoreSelector.setExtendedKeyUsage(x509CertSelector.getExtendedKeyUsage());
                x509CertStoreSelector.setNameConstraints(x509CertSelector.getNameConstraints());
                x509CertStoreSelector.setPolicy(x509CertSelector.getPolicy());
                x509CertStoreSelector.setSubjectPublicKeyAlgID(x509CertSelector.getSubjectPublicKeyAlgID());
                x509CertStoreSelector.setSubjectAlternativeNames(x509CertSelector.getSubjectAlternativeNames());
                x509CertStoreSelector.setIssuer(x509CertSelector.getIssuer());
                x509CertStoreSelector.setKeyUsage(x509CertSelector.getKeyUsage());
                x509CertStoreSelector.setPrivateKeyValid(x509CertSelector.getPrivateKeyValid());
                x509CertStoreSelector.setSerialNumber(x509CertSelector.getSerialNumber());
                x509CertStoreSelector.setSubject(x509CertSelector.getSubject());
                x509CertStoreSelector.setSubjectKeyIdentifier(x509CertSelector.getSubjectKeyIdentifier());
                x509CertStoreSelector.setSubjectPublicKey(x509CertSelector.getSubjectPublicKey());
                this.f6863a = x509CertStoreSelector;
            } catch (IOException e) {
                throw new IllegalArgumentException("error in passed in selector: " + e);
            }
        } else {
            this.f6863a = null;
        }
    }
}
