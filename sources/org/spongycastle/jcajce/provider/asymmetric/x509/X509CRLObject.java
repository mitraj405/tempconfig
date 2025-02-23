package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.CRLNumber;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

class X509CRLObject extends X509CRL {
    public final CertificateList a;

    /* renamed from: a  reason: collision with other field name */
    public final JcaJceHelper f6492a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6493a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6494a;
    public boolean b = false;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final String f6495c;

    public X509CRLObject(BCJcaJceHelper bCJcaJceHelper, CertificateList certificateList) throws CRLException {
        boolean z = false;
        this.f6492a = bCJcaJceHelper;
        this.a = certificateList;
        this.f6495c = X509SignatureUtil.b(certificateList.f5734a);
        ASN1Encodable aSN1Encodable = certificateList.f5734a.a;
        if (aSN1Encodable != null) {
            this.f6494a = aSN1Encodable.b().f("DER");
        } else {
            this.f6494a = null;
        }
        try {
            byte[] extensionValue = getExtensionValue(Extension.h1.c);
            if (extensionValue != null && IssuingDistributionPoint.h(ASN1OctetString.q(extensionValue).s()).c) {
                z = true;
            }
            this.f6493a = z;
        } catch (Exception e) {
            throw new ExtCRLException(e);
        } catch (Exception e2) {
            throw new CRLException("CRL contents invalid: " + e2);
        }
    }

    public final void d(PublicKey publicKey, Signature signature) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        CertificateList certificateList = this.a;
        if (certificateList.f5734a.equals(certificateList.f5735a.f5756a)) {
            signature.initVerify(publicKey);
            signature.update(getTBSCertList());
            if (!signature.verify(getSignature())) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
            return;
        }
        throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
    }

    public final HashSet e(boolean z) {
        Extensions extensions;
        if (getVersion() != 2 || (extensions = this.a.f5735a.f5757a) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration i = extensions.i();
        while (i.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) i.nextElement();
            if (z == extensions.g(aSN1ObjectIdentifier).f5740a) {
                hashSet.add(aSN1ObjectIdentifier.c);
            }
        }
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X509CRL)) {
            return false;
        }
        if (!(obj instanceof X509CRLObject)) {
            return super.equals(obj);
        }
        X509CRLObject x509CRLObject = (X509CRLObject) obj;
        if (!this.b || !x509CRLObject.b || x509CRLObject.c == this.c) {
            return this.a.equals(x509CRLObject.a);
        }
        return false;
    }

    public final Set getCriticalExtensionOIDs() {
        return e(true);
    }

    public final byte[] getEncoded() throws CRLException {
        try {
            return this.a.f("DER");
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public final byte[] getExtensionValue(String str) {
        Extension g;
        Extensions extensions = this.a.f5735a.f5757a;
        if (extensions == null || (g = extensions.g(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return g.a.e();
        } catch (Exception e) {
            throw new IllegalStateException(C1058d.x(e, new StringBuilder("error parsing ")));
        }
    }

    public final Principal getIssuerDN() {
        return new X509Principal(X500Name.g(this.a.f5735a.f5755a.b()));
    }

    public final X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.a.f5735a.f5755a.e());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final Date getNextUpdate() {
        Time time = this.a.f5735a.b;
        if (time != null) {
            return time.g();
        }
        return null;
    }

    public final Set getNonCriticalExtensionOIDs() {
        return e(false);
    }

    public final X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        Extension g;
        Enumeration h = this.a.h();
        X500Name x500Name = null;
        while (h.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) h.nextElement();
            boolean equals = bigInteger.equals(cRLEntry.i().t());
            boolean z = this.f6493a;
            if (equals) {
                return new X509CRLEntryObject(cRLEntry, z, x500Name);
            }
            if (z && cRLEntry.k() && (g = cRLEntry.g().g(Extension.i1)) != null) {
                x500Name = X500Name.g(GeneralNames.g(g.g()).h()[0].a);
            }
        }
        return null;
    }

    public final Set getRevokedCertificates() {
        Extension g;
        HashSet hashSet = new HashSet();
        Enumeration h = this.a.h();
        X500Name x500Name = null;
        while (h.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) h.nextElement();
            boolean z = this.f6493a;
            hashSet.add(new X509CRLEntryObject(cRLEntry, z, x500Name));
            if (z && cRLEntry.k() && (g = cRLEntry.g().g(Extension.i1)) != null) {
                x500Name = X500Name.g(GeneralNames.g(g.g()).h()[0].a);
            }
        }
        if (!hashSet.isEmpty()) {
            return Collections.unmodifiableSet(hashSet);
        }
        return null;
    }

    public final String getSigAlgName() {
        return this.f6495c;
    }

    public final String getSigAlgOID() {
        return this.a.f5734a.Z0.c;
    }

    public final byte[] getSigAlgParams() {
        byte[] bArr = this.f6494a;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public final byte[] getSignature() {
        return this.a.a.s();
    }

    public final byte[] getTBSCertList() throws CRLException {
        try {
            return this.a.f5735a.f("DER");
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public final Date getThisUpdate() {
        return this.a.f5735a.f5758a.g();
    }

    public final int getVersion() {
        ASN1Integer aSN1Integer = this.a.f5735a.a;
        if (aSN1Integer == null) {
            return 1;
        }
        return 1 + aSN1Integer.t().intValue();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(Extension.h1.c);
        criticalExtensionOIDs.remove(Extension.g1.c);
        return !criticalExtensionOIDs.isEmpty();
    }

    public final int hashCode() {
        if (!this.b) {
            this.b = true;
            this.c = super.hashCode();
        }
        return this.c;
    }

    public final boolean isRevoked(Certificate certificate) {
        X500Name x500Name;
        Extension g;
        if (certificate.getType().equals("X.509")) {
            CertificateList certificateList = this.a;
            Enumeration h = certificateList.h();
            X500Name x500Name2 = certificateList.f5735a.f5755a;
            if (h.hasMoreElements()) {
                X509Certificate x509Certificate = (X509Certificate) certificate;
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                while (h.hasMoreElements()) {
                    TBSCertList.CRLEntry h2 = TBSCertList.CRLEntry.h(h.nextElement());
                    if (this.f6493a && h2.k() && (g = h2.g().g(Extension.i1)) != null) {
                        x500Name2 = X500Name.g(GeneralNames.g(g.g()).h()[0].a);
                    }
                    if (h2.i().t().equals(serialNumber)) {
                        if (certificate instanceof X509Certificate) {
                            x500Name = X500Name.g(x509Certificate.getIssuerX500Principal().getEncoded());
                        } else {
                            try {
                                x500Name = org.spongycastle.asn1.x509.Certificate.g(certificate.getEncoded()).f5733a.f5762a;
                            } catch (CertificateEncodingException e) {
                                throw new IllegalArgumentException("Cannot process certificate: " + e.getMessage());
                            }
                        }
                        if (!x500Name2.equals(x500Name)) {
                            return false;
                        }
                        return true;
                    }
                }
            }
            return false;
        }
        throw new IllegalArgumentException("X.509 CRL used with non X.509 Cert");
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("              Version: ");
        String str = Strings.a;
        stringBuffer.append(getVersion());
        stringBuffer.append(str);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(str);
        stringBuffer.append("          This update: ");
        stringBuffer.append(getThisUpdate());
        stringBuffer.append(str);
        stringBuffer.append("          Next update: ");
        stringBuffer.append(getNextUpdate());
        stringBuffer.append(str);
        stringBuffer.append("  Signature Algorithm: ");
        stringBuffer.append(getSigAlgName());
        stringBuffer.append(str);
        byte[] signature = getSignature();
        stringBuffer.append("            Signature: ");
        stringBuffer.append(new String(Hex.b(0, signature, 20)));
        stringBuffer.append(str);
        for (int i = 20; i < signature.length; i += 20) {
            if (i < signature.length - 20) {
                stringBuffer.append("                       ");
                stringBuffer.append(new String(Hex.b(i, signature, 20)));
                stringBuffer.append(str);
            } else {
                stringBuffer.append("                       ");
                stringBuffer.append(new String(Hex.b(i, signature, signature.length - i)));
                stringBuffer.append(str);
            }
        }
        Extensions extensions = this.a.f5735a.f5757a;
        if (extensions != null) {
            Enumeration i2 = extensions.i();
            if (i2.hasMoreElements()) {
                stringBuffer.append("           Extensions: ");
                stringBuffer.append(str);
            }
            while (i2.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) i2.nextElement();
                Extension g = extensions.g(aSN1ObjectIdentifier);
                ASN1OctetString aSN1OctetString = g.a;
                if (aSN1OctetString != null) {
                    ASN1InputStream aSN1InputStream = new ASN1InputStream(aSN1OctetString.s());
                    stringBuffer.append("                       critical(");
                    stringBuffer.append(g.f5740a);
                    stringBuffer.append(") ");
                    try {
                        if (aSN1ObjectIdentifier.equals(Extension.e1)) {
                            stringBuffer.append(new CRLNumber(ASN1Integer.q(aSN1InputStream.j()).s()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(Extension.g1)) {
                            stringBuffer.append("Base CRL: " + new CRLNumber(ASN1Integer.q(aSN1InputStream.j()).s()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(Extension.h1)) {
                            stringBuffer.append(IssuingDistributionPoint.h(aSN1InputStream.j()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(Extension.k1)) {
                            stringBuffer.append(CRLDistPoint.h(aSN1InputStream.j()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(Extension.q1)) {
                            stringBuffer.append(CRLDistPoint.h(aSN1InputStream.j()));
                            stringBuffer.append(str);
                        } else {
                            stringBuffer.append(aSN1ObjectIdentifier.c);
                            stringBuffer.append(" value = ");
                            stringBuffer.append(ASN1Dump.b(aSN1InputStream.j()));
                            stringBuffer.append(str);
                        }
                    } catch (Exception unused) {
                        stringBuffer.append(aSN1ObjectIdentifier.c);
                        stringBuffer.append(" value = *****");
                        stringBuffer.append(str);
                    }
                } else {
                    stringBuffer.append(str);
                }
            }
        }
        Set<Object> revokedCertificates = getRevokedCertificates();
        if (revokedCertificates != null) {
            for (Object append : revokedCertificates) {
                stringBuffer.append(append);
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    public final void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        try {
            signature = this.f6492a.a(getSigAlgName());
        } catch (Exception unused) {
            signature = Signature.getInstance(getSigAlgName());
        }
        d(publicKey, signature);
    }

    public final void verify(PublicKey publicKey, String str) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        if (str != null) {
            signature = Signature.getInstance(getSigAlgName(), str);
        } else {
            signature = Signature.getInstance(getSigAlgName());
        }
        d(publicKey, signature);
    }

    public final void verify(PublicKey publicKey, Provider provider) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature;
        if (provider != null) {
            signature = Signature.getInstance(getSigAlgName(), provider);
        } else {
            signature = Signature.getInstance(getSigAlgName());
        }
        d(publicKey, signature);
    }
}
