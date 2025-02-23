package org.spongycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRL;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLSelector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Selector;

public class X509CRLStoreSelector extends X509CRLSelector implements Selector {
    public BigInteger a = null;

    /* renamed from: a  reason: collision with other field name */
    public X509AttributeCertificate f6872a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6873a = false;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6874a = null;
    public boolean b = false;
    public boolean c = false;

    public final boolean a(Object obj) {
        ASN1Integer aSN1Integer;
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        X509CRL x509crl = (X509CRL) obj;
        try {
            byte[] extensionValue = x509crl.getExtensionValue(X509Extensions.Z0.c);
            if (extensionValue != null) {
                aSN1Integer = ASN1Integer.q(ASN1Primitive.k(((ASN1OctetString) ASN1Primitive.k(extensionValue)).s()));
            } else {
                aSN1Integer = null;
            }
            if (this.f6873a && aSN1Integer == null) {
                return false;
            }
            if (this.b && aSN1Integer != null) {
                return false;
            }
            if (aSN1Integer != null && this.a != null && aSN1Integer.s().compareTo(this.a) == 1) {
                return false;
            }
            if (this.c) {
                byte[] extensionValue2 = x509crl.getExtensionValue(X509Extensions.a1.c);
                byte[] bArr = this.f6874a;
                if (bArr == null) {
                    if (extensionValue2 != null) {
                        return false;
                    }
                } else if (!Arrays.a(extensionValue2, bArr)) {
                    return false;
                }
            }
            return super.match(x509crl);
        } catch (Exception unused) {
            return false;
        }
    }

    public final Object clone() {
        X509CRLStoreSelector x509CRLStoreSelector = new X509CRLStoreSelector();
        x509CRLStoreSelector.setCertificateChecking(getCertificateChecking());
        x509CRLStoreSelector.setDateAndTime(getDateAndTime());
        try {
            x509CRLStoreSelector.setIssuerNames(getIssuerNames());
            x509CRLStoreSelector.setIssuers(getIssuers());
            x509CRLStoreSelector.setMaxCRLNumber(getMaxCRL());
            x509CRLStoreSelector.setMinCRLNumber(getMinCRL());
            x509CRLStoreSelector.f6873a = this.f6873a;
            x509CRLStoreSelector.b = this.b;
            x509CRLStoreSelector.a = this.a;
            x509CRLStoreSelector.f6872a = this.f6872a;
            x509CRLStoreSelector.c = this.c;
            x509CRLStoreSelector.f6874a = Arrays.c(this.f6874a);
            return x509CRLStoreSelector;
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public final boolean match(CRL crl) {
        return a(crl);
    }
}
