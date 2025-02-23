package org.spongycastle.jce.provider;

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
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class X509CRLObject extends X509CRL {
    public boolean a;
    public int c;

    public static boolean f(X509CRL x509crl) throws CRLException {
        try {
            byte[] extensionValue = x509crl.getExtensionValue(Extension.h1.c);
            if (extensionValue == null || !IssuingDistributionPoint.h(ASN1OctetString.q(extensionValue).s()).c) {
                return false;
            }
            return true;
        } catch (Exception e) {
            throw new ExtCRLException(e);
        }
    }

    public final void d(PublicKey publicKey, Signature signature) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        throw null;
    }

    public final HashSet e(boolean z) {
        if (getVersion() != 2) {
            return null;
        }
        throw null;
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
        if (this.a && x509CRLObject.a && x509CRLObject.c != this.c) {
            return false;
        }
        x509CRLObject.getClass();
        throw null;
    }

    public final Set getCriticalExtensionOIDs() {
        return e(true);
    }

    public final byte[] getEncoded() throws CRLException {
        throw null;
    }

    public final byte[] getExtensionValue(String str) {
        throw null;
    }

    public final Principal getIssuerDN() {
        throw null;
    }

    public final X500Principal getIssuerX500Principal() {
        try {
            throw null;
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final Date getNextUpdate() {
        throw null;
    }

    public final Set getNonCriticalExtensionOIDs() {
        return e(false);
    }

    public final X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        throw null;
    }

    public final Set getRevokedCertificates() {
        new HashSet();
        throw null;
    }

    public final String getSigAlgName() {
        return null;
    }

    public final String getSigAlgOID() {
        throw null;
    }

    public final byte[] getSigAlgParams() {
        return null;
    }

    public final byte[] getSignature() {
        throw null;
    }

    public final byte[] getTBSCertList() throws CRLException {
        throw null;
    }

    public final Date getThisUpdate() {
        throw null;
    }

    public final int getVersion() {
        throw null;
    }

    public final boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null) {
            return false;
        }
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.d);
        criticalExtensionOIDs.remove(RFC3280CertPathUtilities.e);
        return !criticalExtensionOIDs.isEmpty();
    }

    public final int hashCode() {
        if (!this.a) {
            this.a = true;
            this.c = super.hashCode();
        }
        return this.c;
    }

    public final boolean isRevoked(Certificate certificate) {
        if (certificate.getType().equals("X.509")) {
            throw null;
        }
        throw new RuntimeException("X.509 CRL used with non X.509 Cert");
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
        throw null;
    }

    public final void verify(PublicKey publicKey) throws CRLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        try {
            signature = Signature.getInstance(getSigAlgName(), "SC");
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
