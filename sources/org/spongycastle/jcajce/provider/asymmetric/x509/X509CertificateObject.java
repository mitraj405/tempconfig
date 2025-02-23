package org.spongycastle.jcajce.provider.asymmetric.x509;

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
import java.security.Signature;
import java.security.SignatureException;
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
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1String;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.misc.MiscObjectIdentifiers;
import org.spongycastle.asn1.misc.NetscapeCertType;
import org.spongycastle.asn1.misc.NetscapeRevocationURL;
import org.spongycastle.asn1.misc.VerisignCzagExtension;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.AbstractX500NameStyle;
import org.spongycastle.asn1.x500.style.BCStyle;
import org.spongycastle.asn1.x500.style.RFC4519Style;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.KeyUsage;
import org.spongycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jcajce.util.JcaJceHelper;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Hex;

class X509CertificateObject extends X509Certificate implements PKCS12BagAttributeCarrier {
    public final BasicConstraints a;

    /* renamed from: a  reason: collision with other field name */
    public final Certificate f6496a;

    /* renamed from: a  reason: collision with other field name */
    public final PKCS12BagAttributeCarrierImpl f6497a = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: a  reason: collision with other field name */
    public final JcaJceHelper f6498a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6499a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean[] f6500a;
    public int c;

    public X509CertificateObject(BCJcaJceHelper bCJcaJceHelper, Certificate certificate) throws CertificateParsingException {
        boolean z;
        this.f6498a = bCJcaJceHelper;
        this.f6496a = certificate;
        try {
            byte[] j = j("2.5.29.19");
            if (j != null) {
                this.a = BasicConstraints.g(ASN1Primitive.k(j));
            }
            try {
                byte[] j2 = j("2.5.29.15");
                if (j2 != null) {
                    DERBitString u = DERBitString.u(ASN1Primitive.k(j2));
                    byte[] r = u.r();
                    int length = (r.length * 8) - u.c;
                    int i = 9;
                    if (length >= 9) {
                        i = length;
                    }
                    this.f6500a = new boolean[i];
                    for (int i2 = 0; i2 != length; i2++) {
                        boolean[] zArr = this.f6500a;
                        if ((r[i2 / 8] & (128 >>> (i2 % 8))) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zArr[i2] = z;
                    }
                    return;
                }
                this.f6500a = null;
            } catch (Exception e) {
                throw new CertificateParsingException("cannot construct KeyUsage: " + e);
            }
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + e2);
        }
    }

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
        return this.f6497a.d(aSN1ObjectIdentifier);
    }

    public final Enumeration e() {
        return this.f6497a.e();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CertificateObject)) {
            return super.equals(obj);
        }
        X509CertificateObject x509CertificateObject = (X509CertificateObject) obj;
        if (!this.f6499a || !x509CertificateObject.f6499a || this.c == x509CertificateObject.c) {
            return this.f6496a.equals(x509CertificateObject.f6496a);
        }
        return false;
    }

    public final void f(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f6497a.f(aSN1ObjectIdentifier, aSN1Encodable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r2.equals(org.spongycastle.asn1.DERNull.a) == false) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (r1.equals(org.spongycastle.asn1.DERNull.a) == false) goto L_0x002e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.security.PublicKey r6, java.security.Signature r7) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.SignatureException, java.security.InvalidKeyException {
        /*
            r5 = this;
            org.spongycastle.asn1.x509.Certificate r0 = r5.f6496a
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r0.f5732a
            org.spongycastle.asn1.x509.TBSCertificate r2 = r0.f5733a
            org.spongycastle.asn1.x509.AlgorithmIdentifier r2 = r2.f5763a
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r1.Z0
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r2.Z0
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0013
            goto L_0x002e
        L_0x0013:
            org.spongycastle.asn1.ASN1Encodable r2 = r2.a
            org.spongycastle.asn1.ASN1Encodable r1 = r1.a
            if (r1 != 0) goto L_0x0024
            if (r2 == 0) goto L_0x0030
            org.spongycastle.asn1.DERNull r1 = org.spongycastle.asn1.DERNull.a
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x0030
            goto L_0x002e
        L_0x0024:
            if (r2 != 0) goto L_0x0032
            org.spongycastle.asn1.DERNull r2 = org.spongycastle.asn1.DERNull.a
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0030
        L_0x002e:
            r1 = 0
            goto L_0x0036
        L_0x0030:
            r1 = 1
            goto L_0x0036
        L_0x0032:
            boolean r1 = r1.equals(r2)
        L_0x0036:
            if (r1 == 0) goto L_0x00bd
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r0.f5732a
            org.spongycastle.asn1.ASN1Encodable r0 = r0.a
            if (r0 == 0) goto L_0x009e
            org.spongycastle.asn1.DERNull r1 = org.spongycastle.jcajce.provider.asymmetric.x509.X509SignatureUtil.a
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x00a0
            java.lang.String r1 = r7.getAlgorithm()
            java.security.Provider r2 = r7.getProvider()
            java.security.AlgorithmParameters r1 = java.security.AlgorithmParameters.getInstance(r1, r2)
            org.spongycastle.asn1.ASN1Primitive r0 = r0.b()     // Catch:{ IOException -> 0x008c }
            byte[] r0 = r0.e()     // Catch:{ IOException -> 0x008c }
            r1.init(r0)     // Catch:{ IOException -> 0x008c }
            java.lang.String r0 = r7.getAlgorithm()
            java.lang.String r2 = "MGF1"
            boolean r0 = r0.endsWith(r2)
            if (r0 == 0) goto L_0x00a0
            java.lang.Class<java.security.spec.PSSParameterSpec> r0 = java.security.spec.PSSParameterSpec.class
            java.security.spec.AlgorithmParameterSpec r0 = r1.getParameterSpec(r0)     // Catch:{ GeneralSecurityException -> 0x0073 }
            r7.setParameter(r0)     // Catch:{ GeneralSecurityException -> 0x0073 }
            goto L_0x00a0
        L_0x0073:
            r6 = move-exception
            java.security.SignatureException r7 = new java.security.SignatureException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Exception extracting parameters: "
            r0.<init>(r1)
            java.lang.String r6 = r6.getMessage()
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x008c:
            r6 = move-exception
            java.security.SignatureException r7 = new java.security.SignatureException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "IOException decoding parameters: "
            r0.<init>(r1)
            java.lang.String r6 = defpackage.C0709Uj.g(r6, r0)
            r7.<init>(r6)
            throw r7
        L_0x009e:
            org.spongycastle.asn1.DERNull r0 = org.spongycastle.jcajce.provider.asymmetric.x509.X509SignatureUtil.a
        L_0x00a0:
            r7.initVerify(r6)
            byte[] r6 = r5.getTBSCertificate()
            r7.update(r6)
            byte[] r6 = r5.getSignature()
            boolean r6 = r7.verify(r6)
            if (r6 == 0) goto L_0x00b5
            return
        L_0x00b5:
            java.security.SignatureException r6 = new java.security.SignatureException
            java.lang.String r7 = "certificate does not verify with supplied key"
            r6.<init>(r7)
            throw r6
        L_0x00bd:
            java.security.cert.CertificateException r6 = new java.security.cert.CertificateException
            java.lang.String r7 = "signature algorithm in TBS cert not same as outer cert"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.x509.X509CertificateObject.g(java.security.PublicKey, java.security.Signature):void");
    }

    public final int getBasicConstraints() {
        BasicConstraints basicConstraints = this.a;
        if (basicConstraints == null || !basicConstraints.i()) {
            return -1;
        }
        if (basicConstraints.h() == null) {
            return Integer.MAX_VALUE;
        }
        return basicConstraints.h().intValue();
    }

    public final Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.f6496a.f5733a.f5764a;
        if (extensions == null) {
            return null;
        }
        Enumeration i = extensions.i();
        while (i.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) i.nextElement();
            if (extensions.g(aSN1ObjectIdentifier).f5740a) {
                hashSet.add(aSN1ObjectIdentifier.c);
            }
        }
        return hashSet;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.f6496a.f("DER");
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
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
        Extension g;
        Extensions extensions = this.f6496a.f5733a.f5764a;
        if (extensions == null || (g = extensions.g(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        try {
            return g.a.e();
        } catch (Exception e) {
            throw new IllegalStateException(C1058d.x(e, new StringBuilder("error parsing ")));
        }
    }

    public final Collection getIssuerAlternativeNames() throws CertificateParsingException {
        return i(j(Extension.c1.c));
    }

    public final Principal getIssuerDN() {
        try {
            return new X509Principal(X500Name.g(this.f6496a.f5733a.f5762a.e()));
        } catch (IOException unused) {
            return null;
        }
    }

    public final boolean[] getIssuerUniqueID() {
        boolean z;
        DERBitString dERBitString = this.f6496a.f5733a.f5761a;
        if (dERBitString == null) {
            return null;
        }
        byte[] r = dERBitString.r();
        int length = (r.length * 8) - dERBitString.c;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            if ((r[i / 8] & (128 >>> (i % 8))) != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
        }
        return zArr;
    }

    public final X500Principal getIssuerX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ASN1OutputStream(byteArrayOutputStream).g(this.f6496a.f5733a.f5762a);
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final boolean[] getKeyUsage() {
        return this.f6500a;
    }

    public final Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.f6496a.f5733a.f5764a;
        if (extensions == null) {
            return null;
        }
        Enumeration i = extensions.i();
        while (i.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) i.nextElement();
            if (!extensions.g(aSN1ObjectIdentifier).f5740a) {
                hashSet.add(aSN1ObjectIdentifier.c);
            }
        }
        return hashSet;
    }

    public final Date getNotAfter() {
        return this.f6496a.f5733a.f5769b.g();
    }

    public final Date getNotBefore() {
        return this.f6496a.f5733a.f5766a.g();
    }

    public final PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.g(this.f6496a.f5733a.f5765a);
        } catch (IOException unused) {
            return null;
        }
    }

    public final BigInteger getSerialNumber() {
        return this.f6496a.f5733a.b.t();
    }

    public final String getSigAlgName() {
        return X509SignatureUtil.b(this.f6496a.f5732a);
    }

    public final String getSigAlgOID() {
        return this.f6496a.f5732a.Z0.c;
    }

    public final byte[] getSigAlgParams() {
        ASN1Encodable aSN1Encodable = this.f6496a.f5732a.a;
        if (aSN1Encodable != null) {
            try {
                return aSN1Encodable.b().f("DER");
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public final byte[] getSignature() {
        return this.f6496a.f5731a.s();
    }

    public final Collection getSubjectAlternativeNames() throws CertificateParsingException {
        return i(j(Extension.b1.c));
    }

    public final Principal getSubjectDN() {
        return new X509Principal(X500Name.g(this.f6496a.f5733a.f5768b.b()));
    }

    public final boolean[] getSubjectUniqueID() {
        boolean z;
        DERBitString dERBitString = this.f6496a.f5733a.f5767b;
        if (dERBitString == null) {
            return null;
        }
        byte[] r = dERBitString.r();
        int length = (r.length * 8) - dERBitString.c;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            if ((r[i / 8] & (128 >>> (i % 8))) != 0) {
                z = true;
            } else {
                z = false;
            }
            zArr[i] = z;
        }
        return zArr;
    }

    public final X500Principal getSubjectX500Principal() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ASN1OutputStream(byteArrayOutputStream).g(this.f6496a.f5733a.f5768b);
            return new X500Principal(byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.f6496a.f5733a.f("DER");
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    public final int getVersion() {
        return this.f6496a.f5733a.a.t().intValue() + 1;
    }

    public final boolean hasUnsupportedCriticalExtension() {
        Extensions extensions;
        if (getVersion() != 3 || (extensions = this.f6496a.f5733a.f5764a) == null) {
            return false;
        }
        Enumeration i = extensions.i();
        while (i.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) i.nextElement();
            if (!aSN1ObjectIdentifier.equals(Extension.a1) && !aSN1ObjectIdentifier.equals(Extension.l1) && !aSN1ObjectIdentifier.equals(Extension.m1) && !aSN1ObjectIdentifier.equals(Extension.r1) && !aSN1ObjectIdentifier.equals(Extension.k1) && !aSN1ObjectIdentifier.equals(Extension.h1) && !aSN1ObjectIdentifier.equals(Extension.g1) && !aSN1ObjectIdentifier.equals(Extension.o1) && !aSN1ObjectIdentifier.equals(Extension.d1) && !aSN1ObjectIdentifier.equals(Extension.b1) && !aSN1ObjectIdentifier.equals(Extension.j1) && extensions.g(aSN1ObjectIdentifier).f5740a) {
                return true;
            }
        }
        return false;
    }

    public final synchronized int hashCode() {
        if (!this.f6499a) {
            this.c = super.hashCode();
            this.f6499a = true;
        }
        return this.c;
    }

    public final byte[] j(String str) {
        Extension g;
        Extensions extensions = this.f6496a.f5733a.f5764a;
        if (extensions == null || (g = extensions.g(new ASN1ObjectIdentifier(str))) == null) {
            return null;
        }
        return g.a.s();
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
        Extensions extensions = this.f6496a.f5733a.f5764a;
        if (extensions != null) {
            Enumeration i2 = extensions.i();
            if (i2.hasMoreElements()) {
                stringBuffer.append("       Extensions: \n");
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
                        if (aSN1ObjectIdentifier.equals(Extension.d1)) {
                            stringBuffer.append(BasicConstraints.g(aSN1InputStream.j()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(Extension.a1)) {
                            stringBuffer.append(KeyUsage.g(aSN1InputStream.j()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(MiscObjectIdentifiers.a)) {
                            stringBuffer.append(new NetscapeCertType((DERBitString) aSN1InputStream.j()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(MiscObjectIdentifiers.b)) {
                            stringBuffer.append(new NetscapeRevocationURL((DERIA5String) aSN1InputStream.j()));
                            stringBuffer.append(str);
                        } else if (aSN1ObjectIdentifier.equals(MiscObjectIdentifiers.c)) {
                            stringBuffer.append(new VerisignCzagExtension((DERIA5String) aSN1InputStream.j()));
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
        return stringBuffer.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String b = X509SignatureUtil.b(this.f6496a.f5732a);
        try {
            signature = this.f6498a.a(b);
        } catch (Exception unused) {
            signature = Signature.getInstance(b);
        }
        g(publicKey, signature);
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        int i = (date.getTime() > getNotAfter().getTime() ? 1 : (date.getTime() == getNotAfter().getTime() ? 0 : -1));
        Certificate certificate = this.f6496a;
        if (i > 0) {
            throw new CertificateExpiredException("certificate expired on " + certificate.f5733a.f5769b.i());
        } else if (date.getTime() < getNotBefore().getTime()) {
            throw new CertificateNotYetValidException("certificate not valid till " + certificate.f5733a.f5766a.i());
        }
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        Signature signature;
        String b = X509SignatureUtil.b(this.f6496a.f5732a);
        if (str != null) {
            signature = Signature.getInstance(b, str);
        } else {
            signature = Signature.getInstance(b);
        }
        g(publicKey, signature);
    }

    public final void verify(PublicKey publicKey, Provider provider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature;
        String b = X509SignatureUtil.b(this.f6496a.f5732a);
        if (provider != null) {
            signature = Signature.getInstance(b, provider);
        } else {
            signature = Signature.getInstance(b);
        }
        g(publicKey, signature);
    }
}
