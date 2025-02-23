package org.spongycastle.jcajce;

import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import java.util.Collection;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;

public class PKIXCRLStoreSelector<T extends CRL> implements Selector<T> {
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public final CRLSelector f6313a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6314a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6315a;
    public final boolean b;

    public static class Builder {
        public BigInteger a = null;

        /* renamed from: a  reason: collision with other field name */
        public final CRLSelector f6316a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f6317a = false;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6318a = null;
        public boolean b = false;

        public Builder(X509CRLSelector x509CRLSelector) {
            this.f6316a = (CRLSelector) x509CRLSelector.clone();
        }
    }

    public static class SelectorClone extends X509CRLSelector {
        public final PKIXCRLStoreSelector a;

        public SelectorClone(PKIXCRLStoreSelector pKIXCRLStoreSelector) {
            this.a = pKIXCRLStoreSelector;
            CRLSelector cRLSelector = pKIXCRLStoreSelector.f6313a;
            if (cRLSelector instanceof X509CRLSelector) {
                X509CRLSelector x509CRLSelector = (X509CRLSelector) cRLSelector;
                setCertificateChecking(x509CRLSelector.getCertificateChecking());
                setDateAndTime(x509CRLSelector.getDateAndTime());
                setIssuers(x509CRLSelector.getIssuers());
                setMinCRLNumber(x509CRLSelector.getMinCRL());
                setMaxCRLNumber(x509CRLSelector.getMaxCRL());
            }
        }

        public final boolean match(CRL crl) {
            PKIXCRLStoreSelector pKIXCRLStoreSelector = this.a;
            if (pKIXCRLStoreSelector != null) {
                return pKIXCRLStoreSelector.match(crl);
            }
            if (crl != null) {
                return true;
            }
            return false;
        }
    }

    public PKIXCRLStoreSelector(Builder builder) {
        this.f6313a = builder.f6316a;
        this.f6314a = builder.f6317a;
        this.a = builder.a;
        this.f6315a = builder.f6318a;
        this.b = builder.b;
    }

    public static Collection<? extends CRL> a(PKIXCRLStoreSelector pKIXCRLStoreSelector, CertStore certStore) throws CertStoreException {
        return certStore.getCRLs(new SelectorClone(pKIXCRLStoreSelector));
    }

    public final boolean match(CRL crl) {
        ASN1Integer aSN1Integer;
        BigInteger bigInteger;
        boolean z = crl instanceof X509CRL;
        CRLSelector cRLSelector = this.f6313a;
        if (!z) {
            return cRLSelector.match(crl);
        }
        X509CRL x509crl = (X509CRL) crl;
        try {
            byte[] extensionValue = x509crl.getExtensionValue(Extension.g1.c);
            if (extensionValue != null) {
                aSN1Integer = ASN1Integer.q(ASN1OctetString.q(extensionValue).s());
            } else {
                aSN1Integer = null;
            }
            if (this.f6314a && aSN1Integer != null) {
                return false;
            }
            if (aSN1Integer != null && (bigInteger = this.a) != null && aSN1Integer.s().compareTo(bigInteger) == 1) {
                return false;
            }
            if (this.b) {
                byte[] extensionValue2 = x509crl.getExtensionValue(Extension.h1.c);
                byte[] bArr = this.f6315a;
                if (bArr == null) {
                    if (extensionValue2 != null) {
                        return false;
                    }
                } else if (!Arrays.a(extensionValue2, bArr)) {
                    return false;
                }
            }
            return cRLSelector.match(crl);
        } catch (Exception unused) {
            return false;
        }
    }

    public final Object clone() {
        return this;
    }
}
