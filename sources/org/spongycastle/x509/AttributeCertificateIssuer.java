package org.spongycastle.x509;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.x509.AttCertIssuer;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuerSerial;
import org.spongycastle.asn1.x509.V2Form;
import org.spongycastle.util.Selector;

public class AttributeCertificateIssuer implements CertSelector, Selector {
    public final ASN1Encodable a;

    public AttributeCertificateIssuer(AttCertIssuer attCertIssuer) {
        this.a = attCertIssuer.a;
    }

    public static boolean b(X500Principal x500Principal, GeneralNames generalNames) {
        GeneralName[] h = generalNames.h();
        for (int i = 0; i != h.length; i++) {
            GeneralName generalName = h[i];
            if (generalName.c == 4) {
                try {
                    if (new X500Principal(generalName.a.b().e()).equals(x500Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    public final Principal[] a() {
        GeneralNames generalNames;
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable instanceof V2Form) {
            generalNames = ((V2Form) aSN1Encodable).a;
        } else {
            generalNames = (GeneralNames) aSN1Encodable;
        }
        GeneralName[] h = generalNames.h();
        ArrayList arrayList = new ArrayList(h.length);
        for (int i = 0; i != h.length; i++) {
            if (h[i].c == 4) {
                try {
                    arrayList.add(new X500Principal(h[i].a.b().e()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        Object[] array = arrayList.toArray(new Object[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 != array.length; i2++) {
            Object obj = array[i2];
            if (obj instanceof Principal) {
                arrayList2.add(obj);
            }
        }
        return (Principal[]) arrayList2.toArray(new Principal[arrayList2.size()]);
    }

    public final Object clone() {
        return new AttributeCertificateIssuer(AttCertIssuer.g(this.a));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateIssuer)) {
            return false;
        }
        return this.a.equals(((AttributeCertificateIssuer) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean match(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        ASN1Encodable aSN1Encodable = this.a;
        if (aSN1Encodable instanceof V2Form) {
            V2Form v2Form = (V2Form) aSN1Encodable;
            IssuerSerial issuerSerial = v2Form.f5771a;
            if (issuerSerial != null) {
                if (!issuerSerial.a.t().equals(x509Certificate.getSerialNumber()) || !b(x509Certificate.getIssuerX500Principal(), v2Form.f5771a.f5747a)) {
                    return false;
                }
                return true;
            } else if (b(x509Certificate.getSubjectX500Principal(), v2Form.a)) {
                return true;
            }
        } else {
            if (b(x509Certificate.getSubjectX500Principal(), (GeneralNames) aSN1Encodable)) {
                return true;
            }
        }
        return false;
    }
}
