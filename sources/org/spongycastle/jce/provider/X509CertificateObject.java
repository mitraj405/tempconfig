package org.spongycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.AbstractX500NameStyle;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.asn1.x500.style.RFC4519Style;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

public class X509CertificateObject extends X509Certificate implements PKCS12BagAttributeCarrier {
    public boolean a;
    public int c;

    public static Collection i(byte[] bArr) throws CertificateParsingException {
        X500Name x500Name;
        if (bArr == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration t = ASN1Sequence.q(bArr).t();
            while (t.hasMoreElements()) {
                GeneralName g = GeneralName.g(t.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integer.valueOf(g.c));
                int i = g.c;
                ASN1Encodable aSN1Encodable = g.a;
                switch (i) {
                    case 0:
                    case 3:
                    case 5:
                        arrayList2.add(g.e());
                        break;
                    case 1:
                    case 2:
                    case 6:
                        arrayList2.add(((ASN1String) aSN1Encodable).c());
                        break;
                    case 4:
                        RFC4519Style rFC4519Style = RFC4519Style.a;
                        BCStyle bCStyle = X500Name.a;
                        if (aSN1Encodable instanceof X500Name) {
                            x500Name = new X500Name(rFC4519Style, (X500Name) aSN1Encodable);
                        } else if (aSN1Encodable != null) {
                            x500Name = new X500Name((AbstractX500NameStyle) rFC4519Style, ASN1Sequence.q(aSN1Encodable));
                        } else {
                            x500Name = null;
                        }
                        arrayList2.add(x500Name.toString());
                        break;
                    case 7:
                        try {
                            arrayList2.add(InetAddress.getByAddress(ASN1OctetString.q(aSN1Encodable).s()).getHostAddress());
                            break;
                        } catch (UnknownHostException unused) {
                            break;
                        }
                    case 8:
                        arrayList2.add(ASN1ObjectIdentifier.u(aSN1Encodable).c);
                        break;
                    default:
                        throw new IOException("Bad tag number: " + i);
                }
                arrayList.add(Collections.unmodifiableList(arrayList2));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(new Date());
    }

    public final ASN1Encodable d(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        throw null;
    }

    public final Enumeration e() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Certificate)) {
            return false;
        }
        try {
            return Arrays.a(getEncoded(), ((Certificate) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        throw null;
    }

    public final void g(PublicKey publicKey, Signature signature) throws CertificateException, NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        throw null;
    }

    public final int getBasicConstraints() {
        return -1;
    }

    public final Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        new HashSet();
        throw null;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        throw null;
    }

    public final List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] j = j("2.5.29.37");
        if (j == null) {
            return null;
        }
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream(j).j();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != aSN1Sequence.size(); i++) {
                arrayList.add(((ASN1ObjectIdentifier) aSN1Sequence.s(i)).c);
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception unused) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    public final byte[] getExtensionValue(String str) {
        throw null;
    }

    public final Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return i(j(Extension.c1.c));
    }

    public final Principal getIssuerDN() {
        try {
            throw null;
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean[] getIssuerUniqueID() {
        throw null;
    }

    public final X500Principal getIssuerX500Principal() {
        try {
            new ASN1OutputStream(new ByteArrayOutputStream());
            throw null;
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final boolean[] getKeyUsage() {
        return null;
    }

    public final Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        new HashSet();
        throw null;
    }

    public final Date getNotAfter() {
        throw null;
    }

    public final Date getNotBefore() {
        throw null;
    }

    public final PublicKey getPublicKey() {
        throw null;
    }

    public final BigInteger getSerialNumber() {
        throw null;
    }

    public final String getSigAlgName() {
        Provider provider = Security.getProvider("SC");
        if (provider != null) {
            String property = provider.getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i != providers.length; i++) {
            Provider provider2 = providers[i];
            String property2 = provider2.getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property2 != null) {
                return property2;
            }
        }
        return getSigAlgOID();
    }

    public final String getSigAlgOID() {
        throw null;
    }

    public final byte[] getSigAlgParams() {
        throw null;
    }

    public final byte[] getSignature() {
        throw null;
    }

    public final Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return i(j(Extension.b1.c));
    }

    public final Principal getSubjectDN() {
        throw null;
    }

    public final boolean[] getSubjectUniqueID() {
        throw null;
    }

    public final X500Principal getSubjectX500Principal() {
        try {
            new ASN1OutputStream(new ByteArrayOutputStream());
            throw null;
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        throw null;
    }

    public final int getVersion() {
        throw null;
    }

    public final boolean hasUnsupportedCriticalExtension() {
        if (getVersion() != 3) {
            return false;
        }
        throw null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:4|5|6|(3:9|10|7)|20|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int hashCode() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.a     // Catch:{ all -> 0x0020 }
            if (r0 != 0) goto L_0x001c
            r0 = 1
            r1 = 0
            byte[] r2 = r6.getEncoded()     // Catch:{ CertificateEncodingException -> 0x0018 }
            r3 = r0
            r4 = r1
        L_0x000d:
            int r5 = r2.length     // Catch:{ CertificateEncodingException -> 0x0018 }
            if (r3 >= r5) goto L_0x0017
            byte r5 = r2[r3]     // Catch:{ CertificateEncodingException -> 0x0018 }
            int r5 = r5 * r3
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L_0x000d
        L_0x0017:
            r1 = r4
        L_0x0018:
            r6.c = r1     // Catch:{ all -> 0x0020 }
            r6.a = r0     // Catch:{ all -> 0x0020 }
        L_0x001c:
            int r0 = r6.c     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)
            return r0
        L_0x0020:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.X509CertificateObject.hashCode():int");
    }

    public final byte[] j(String str) {
        throw null;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("  [0]         Version: ");
        String str = Strings.a;
        stringBuffer.append(getVersion());
        stringBuffer.append(str);
        stringBuffer.append("         SerialNumber: ");
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(str);
        stringBuffer.append("             IssuerDN: ");
        stringBuffer.append(getIssuerDN());
        stringBuffer.append(str);
        stringBuffer.append("           Start Date: ");
        stringBuffer.append(getNotBefore());
        stringBuffer.append(str);
        stringBuffer.append("           Final Date: ");
        stringBuffer.append(getNotAfter());
        stringBuffer.append(str);
        stringBuffer.append("            SubjectDN: ");
        stringBuffer.append(getSubjectDN());
        stringBuffer.append(str);
        stringBuffer.append("           Public Key: ");
        stringBuffer.append(getPublicKey());
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

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        throw null;
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        if (date.getTime() > getNotAfter().getTime()) {
            throw null;
        } else if (date.getTime() < getNotBefore().getTime()) {
            throw null;
        }
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        throw null;
    }

    public final void verify(PublicKey publicKey, Provider provider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        throw null;
    }
}
