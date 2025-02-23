package org.spongycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAPublicKeySpec;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.isismtt.ISISMTTObjectIdentifiers;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x500.style.RFC4519Style;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.AuthorityKeyIdentifier;
import org.spongycastle.asn1.x509.CRLDistPoint;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.PKIXCRLStore;
import org.spongycastle.jcajce.PKIXCRLStoreSelector;
import org.spongycastle.jcajce.PKIXCertStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Store;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.X509AttributeCertificate;

class CertPathValidatorUtilities {
    public static final String a = Extension.h1.c;

    /* renamed from: a  reason: collision with other field name */
    public static final PKIXCRLUtil f6569a = new PKIXCRLUtil();
    public static final String b = Extension.n1.c;
    public static final String c = Extension.e1.c;

    static {
        Extension.l1.getClass();
        Extension.d1.getClass();
        Extension.m1.getClass();
        Extension.b1.getClass();
        Extension.j1.getClass();
        Extension.a1.getClass();
        Extension.r1.getClass();
        Extension.g1.getClass();
        Extension.o1.getClass();
        Extension.q1.getClass();
        Extension.k1.getClass();
    }

    public static LinkedHashSet a(PKIXCertStoreSelector pKIXCertStoreSelector, List list) throws AnnotatedException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object next : list) {
            if (next instanceof Store) {
                try {
                    linkedHashSet.addAll(((Store) next).a(pKIXCertStoreSelector));
                } catch (StoreException e) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e);
                }
            } else {
                try {
                    linkedHashSet.addAll(PKIXCertStoreSelector.a(pKIXCertStoreSelector, (CertStore) next));
                } catch (CertStoreException e2) {
                    throw new AnnotatedException("Problem while picking certificates from certificate store.", e2);
                }
            }
        }
        return linkedHashSet;
    }

    public static LinkedHashSet b(X509Certificate x509Certificate, List list, ArrayList arrayList) throws AnnotatedException {
        AuthorityKeyIdentifier authorityKeyIdentifier;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(X500Name.g(x509Certificate.getIssuerX500Principal().getEncoded()).e());
            try {
                byte[] extensionValue = x509Certificate.getExtensionValue(b);
                if (extensionValue != null) {
                    byte[] s = ASN1OctetString.q(extensionValue).s();
                    byte[] bArr = null;
                    if (s instanceof AuthorityKeyIdentifier) {
                        authorityKeyIdentifier = (AuthorityKeyIdentifier) s;
                    } else if (s != null) {
                        authorityKeyIdentifier = new AuthorityKeyIdentifier(ASN1Sequence.q(s));
                    } else {
                        authorityKeyIdentifier = null;
                    }
                    ASN1OctetString aSN1OctetString = authorityKeyIdentifier.f5726a;
                    if (aSN1OctetString != null) {
                        bArr = aSN1OctetString.s();
                    }
                    if (bArr != null) {
                        x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(bArr).e());
                    }
                }
            } catch (Exception unused) {
            }
            PKIXCertStoreSelector<? extends Certificate> a2 = new PKIXCertStoreSelector.Builder(x509CertSelector).a();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(a(a2, list));
                arrayList2.addAll(a(a2, arrayList));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add((X509Certificate) it.next());
                }
                return linkedHashSet;
            } catch (AnnotatedException e) {
                throw new AnnotatedException("Issuer certificate cannot be searched.", e);
            }
        } catch (IOException e2) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate could not be set.", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0018 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.TrustAnchor c(java.security.cert.X509Certificate r7, java.util.Set r8, java.lang.String r9) throws org.spongycastle.jce.provider.AnnotatedException {
        /*
            java.security.cert.X509CertSelector r0 = new java.security.cert.X509CertSelector
            r0.<init>()
            org.spongycastle.asn1.x500.X500Name r1 = org.spongycastle.jce.provider.PrincipalUtils.a(r7)
            byte[] r2 = r1.e()     // Catch:{ IOException -> 0x0084 }
            r0.setSubject(r2)     // Catch:{ IOException -> 0x0084 }
            java.util.Iterator r8 = r8.iterator()
            r2 = 0
            r3 = r2
            r4 = r3
            r5 = r4
        L_0x0018:
            boolean r6 = r8.hasNext()
            if (r6 == 0) goto L_0x0076
            if (r3 != 0) goto L_0x0076
            java.lang.Object r3 = r8.next()
            java.security.cert.TrustAnchor r3 = (java.security.cert.TrustAnchor) r3
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            if (r6 == 0) goto L_0x003f
            java.security.cert.X509Certificate r6 = r3.getTrustedCert()
            boolean r6 = r0.match(r6)
            if (r6 == 0) goto L_0x0062
            java.security.cert.X509Certificate r5 = r3.getTrustedCert()
            java.security.PublicKey r5 = r5.getPublicKey()
            goto L_0x0063
        L_0x003f:
            java.lang.String r6 = r3.getCAName()
            if (r6 == 0) goto L_0x0062
            java.security.PublicKey r6 = r3.getCAPublicKey()
            if (r6 == 0) goto L_0x0062
            javax.security.auth.x500.X500Principal r6 = r3.getCA()     // Catch:{ IllegalArgumentException -> 0x0062 }
            byte[] r6 = r6.getEncoded()     // Catch:{ IllegalArgumentException -> 0x0062 }
            org.spongycastle.asn1.x500.X500Name r6 = org.spongycastle.asn1.x500.X500Name.g(r6)     // Catch:{ IllegalArgumentException -> 0x0062 }
            boolean r6 = r1.equals(r6)     // Catch:{ IllegalArgumentException -> 0x0062 }
            if (r6 == 0) goto L_0x0062
            java.security.PublicKey r5 = r3.getCAPublicKey()     // Catch:{ IllegalArgumentException -> 0x0062 }
            goto L_0x0063
        L_0x0062:
            r3 = r2
        L_0x0063:
            if (r5 == 0) goto L_0x0018
            if (r9 != 0) goto L_0x006d
            r7.verify(r5)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0018
        L_0x006b:
            r4 = r3
            goto L_0x0073
        L_0x006d:
            r7.verify(r5, r9)     // Catch:{ Exception -> 0x0071 }
            goto L_0x0018
        L_0x0071:
            r3 = move-exception
            goto L_0x006b
        L_0x0073:
            r3 = r2
            r5 = r3
            goto L_0x0018
        L_0x0076:
            if (r3 != 0) goto L_0x0083
            if (r4 != 0) goto L_0x007b
            goto L_0x0083
        L_0x007b:
            org.spongycastle.jce.provider.AnnotatedException r7 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r8 = "TrustAnchor found but certificate validation failed."
            r7.<init>(r8, r4)
            throw r7
        L_0x0083:
            return r3
        L_0x0084:
            r7 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r8 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r9 = "Cannot set subject search criteria for trust anchor."
            r8.<init>(r9, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.CertPathValidatorUtilities.c(java.security.cert.X509Certificate, java.util.Set, java.lang.String):java.security.cert.TrustAnchor");
    }

    public static List<PKIXCertStore> d(byte[] bArr, Map<GeneralName, PKIXCertStore> map) throws CertificateParsingException {
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        GeneralName[] h = GeneralNames.g(ASN1OctetString.q(bArr).s()).h();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != h.length; i++) {
            PKIXCertStore pKIXCertStore = map.get(h[i]);
            if (pKIXCertStore != null) {
                arrayList.add(pKIXCertStore);
            }
        }
        return arrayList;
    }

    public static List<PKIXCRLStore> e(CRLDistPoint cRLDistPoint, Map<GeneralName, PKIXCRLStore> map) throws AnnotatedException {
        if (cRLDistPoint == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            DistributionPoint[] g = cRLDistPoint.g();
            ArrayList arrayList = new ArrayList();
            for (DistributionPoint distributionPoint : g) {
                DistributionPointName distributionPointName = distributionPoint.a;
                if (distributionPointName != null && distributionPointName.c == 0) {
                    GeneralName[] h = GeneralNames.g(distributionPointName.a).h();
                    for (GeneralName generalName : h) {
                        PKIXCRLStore pKIXCRLStore = map.get(generalName);
                        if (pKIXCRLStore != null) {
                            arrayList.add(pKIXCRLStore);
                        }
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            throw new AnnotatedException("Distribution points could not be read.", e);
        }
    }

    public static AlgorithmIdentifier f(PublicKey publicKey) throws CertPathValidatorException {
        try {
            return SubjectPublicKeyInfo.g(new ASN1InputStream(publicKey.getEncoded()).j()).f5753a;
        } catch (Exception e) {
            throw new ExtCertPathValidatorException("Subject public key cannot be decoded.", e);
        }
    }

    public static void g(DistributionPoint distributionPoint, HashSet hashSet, X509CRLSelector x509CRLSelector) throws AnnotatedException {
        ArrayList arrayList = new ArrayList();
        GeneralNames generalNames = distributionPoint.f5738a;
        if (generalNames != null) {
            GeneralName[] h = generalNames.h();
            for (GeneralName generalName : h) {
                if (generalName.c == 4) {
                    try {
                        arrayList.add(X500Name.g(generalName.a.b().e()));
                    } catch (IOException e) {
                        throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e);
                    }
                }
            }
        } else if (distributionPoint.a != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        } else {
            throw new AnnotatedException("CRL issuer is omitted from distribution point but no distributionPoint field present.", (Exception) null);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                x509CRLSelector.addIssuerName(((X500Name) it2.next()).e());
            } catch (IOException e2) {
                throw new AnnotatedException("Cannot decode CRL issuer information.", e2);
            }
        }
    }

    public static void h(Date date, X509CRL x509crl, Object obj, CertStatus certStatus) throws AnnotatedException {
        X509CRLEntry x509CRLEntry;
        ASN1Enumerated aSN1Enumerated;
        X500Name x500Name;
        try {
            if (X509CRLObject.f(x509crl)) {
                x509CRLEntry = x509crl.getRevokedCertificate(((X509Certificate) obj).getSerialNumber());
                if (x509CRLEntry != null) {
                    X500Principal certificateIssuer = x509CRLEntry.getCertificateIssuer();
                    if (certificateIssuer == null) {
                        x500Name = PrincipalUtils.b(x509crl);
                    } else {
                        x500Name = X500Name.g(certificateIssuer.getEncoded());
                    }
                    if (!PrincipalUtils.a(obj).equals(x500Name)) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (!PrincipalUtils.a(obj).equals(PrincipalUtils.b(x509crl)) || (x509CRLEntry = x509crl.getRevokedCertificate(((X509Certificate) obj).getSerialNumber())) == null) {
                return;
            }
            if (x509CRLEntry.hasExtensions()) {
                try {
                    aSN1Enumerated = ASN1Enumerated.q(k(x509CRLEntry, Extension.f1.c));
                } catch (Exception e) {
                    throw new AnnotatedException("Reason code CRL entry extension could not be decoded.", e);
                }
            } else {
                aSN1Enumerated = null;
            }
            if (date.getTime() >= x509CRLEntry.getRevocationDate().getTime() || aSN1Enumerated == null || aSN1Enumerated.r().intValue() == 0 || aSN1Enumerated.r().intValue() == 1 || aSN1Enumerated.r().intValue() == 2 || aSN1Enumerated.r().intValue() == 8) {
                if (aSN1Enumerated != null) {
                    certStatus.a = aSN1Enumerated.r().intValue();
                } else {
                    certStatus.a = 0;
                }
                certStatus.f6570a = x509CRLEntry.getRevocationDate();
            }
        } catch (CRLException e2) {
            throw new AnnotatedException("Failed check for indirect CRL.", e2);
        }
    }

    public static HashSet i(DistributionPoint distributionPoint, Object obj, PKIXExtendedParameters pKIXExtendedParameters) throws AnnotatedException {
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            HashSet hashSet = new HashSet();
            hashSet.add(PrincipalUtils.a(obj));
            g(distributionPoint, hashSet, x509CRLSelector);
            if (obj instanceof X509Certificate) {
                x509CRLSelector.setCertificateChecking((X509Certificate) obj);
            }
            PKIXCRLStoreSelector.Builder builder = new PKIXCRLStoreSelector.Builder(x509CRLSelector);
            builder.f6317a = true;
            PKIXCRLStoreSelector pKIXCRLStoreSelector = new PKIXCRLStoreSelector(builder);
            pKIXExtendedParameters.b();
            Date b2 = pKIXExtendedParameters.b();
            PKIXCRLUtil pKIXCRLUtil = f6569a;
            List<CertStore> a2 = pKIXExtendedParameters.a();
            pKIXCRLUtil.getClass();
            HashSet a3 = PKIXCRLUtil.a(pKIXCRLStoreSelector, b2, a2, pKIXExtendedParameters.b);
            if (!a3.isEmpty()) {
                return a3;
            }
            if (obj instanceof X509AttributeCertificate) {
                throw new AnnotatedException("No CRLs found for issuer \"" + ((X509AttributeCertificate) obj).a().a()[0] + "\"", (Exception) null);
            }
            throw new AnnotatedException("No CRLs found for issuer \"" + RFC4519Style.a.a(X500Name.g(((X509Certificate) obj).getIssuerX500Principal().getEncoded())) + "\"", (Exception) null);
        } catch (AnnotatedException e) {
            throw new AnnotatedException("Could not get issuer information from distribution point.", e);
        }
    }

    public static HashSet j(Date date, X509CRL x509crl, List list, List list2) throws AnnotatedException {
        BigInteger bigInteger;
        boolean z;
        X509CRLSelector x509CRLSelector = new X509CRLSelector();
        try {
            x509CRLSelector.addIssuerName(PrincipalUtils.b(x509crl).e());
            try {
                ASN1Primitive k = k(x509crl, c);
                BigInteger bigInteger2 = null;
                if (k != null) {
                    bigInteger = ASN1Integer.q(k).s();
                } else {
                    bigInteger = null;
                }
                try {
                    byte[] extensionValue = x509crl.getExtensionValue(a);
                    if (bigInteger != null) {
                        bigInteger2 = bigInteger.add(BigInteger.valueOf(1));
                    }
                    x509CRLSelector.setMinCRLNumber(bigInteger2);
                    PKIXCRLStoreSelector.Builder builder = new PKIXCRLStoreSelector.Builder(x509CRLSelector);
                    builder.f6318a = Arrays.c(extensionValue);
                    builder.b = true;
                    builder.a = bigInteger;
                    PKIXCRLStoreSelector pKIXCRLStoreSelector = new PKIXCRLStoreSelector(builder);
                    f6569a.getClass();
                    HashSet a2 = PKIXCRLUtil.a(pKIXCRLStoreSelector, date, list, list2);
                    HashSet hashSet = new HashSet();
                    Iterator it = a2.iterator();
                    while (it.hasNext()) {
                        X509CRL x509crl2 = (X509CRL) it.next();
                        Set<String> criticalExtensionOIDs = x509crl2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs == null) {
                            z = false;
                        } else {
                            z = criticalExtensionOIDs.contains(RFC3280CertPathUtilities.e);
                        }
                        if (z) {
                            hashSet.add(x509crl2);
                        }
                    }
                    return hashSet;
                } catch (Exception e) {
                    throw new AnnotatedException("Issuing distribution point extension value could not be read.", e);
                }
            } catch (Exception e2) {
                throw new AnnotatedException("CRL number extension could not be extracted from CRL.", e2);
            }
        } catch (IOException e3) {
            throw new AnnotatedException("Cannot extract issuer from CRL.", e3);
        }
    }

    public static ASN1Primitive k(X509Extension x509Extension, String str) throws AnnotatedException {
        byte[] extensionValue = x509Extension.getExtensionValue(str);
        if (extensionValue == null) {
            return null;
        }
        try {
            return new ASN1InputStream(((ASN1OctetString) new ASN1InputStream(extensionValue).j()).s()).j();
        } catch (Exception e) {
            throw new AnnotatedException(C0709Uj.i("exception processing extension ", str), e);
        }
    }

    public static PublicKey l(List list, int i, BCJcaJceHelper bCJcaJceHelper) throws CertPathValidatorException {
        DSAPublicKey dSAPublicKey;
        PublicKey publicKey = ((Certificate) list.get(i)).getPublicKey();
        if (!(publicKey instanceof DSAPublicKey)) {
            return publicKey;
        }
        DSAPublicKey dSAPublicKey2 = (DSAPublicKey) publicKey;
        if (dSAPublicKey2.getParams() != null) {
            return dSAPublicKey2;
        }
        do {
            i++;
            if (i < list.size()) {
                PublicKey publicKey2 = ((X509Certificate) list.get(i)).getPublicKey();
                if (publicKey2 instanceof DSAPublicKey) {
                    dSAPublicKey = (DSAPublicKey) publicKey2;
                } else {
                    throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
                }
            } else {
                throw new CertPathValidatorException("DSA parameters cannot be inherited from previous certificate.");
            }
        } while (dSAPublicKey.getParams() == null);
        DSAParams params = dSAPublicKey.getParams();
        try {
            return bCJcaJceHelper.c("DSA").generatePublic(new DSAPublicKeySpec(dSAPublicKey2.getY(), params.getP(), params.getQ(), params.getG()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static final HashSet m(ASN1Sequence aSN1Sequence) throws CertPathValidatorException {
        HashSet hashSet = new HashSet();
        if (aSN1Sequence == null) {
            return hashSet;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
        Enumeration t = aSN1Sequence.t();
        while (t.hasMoreElements()) {
            try {
                aSN1OutputStream.g((ASN1Encodable) t.nextElement());
                hashSet.add(new PolicyQualifierInfo(byteArrayOutputStream.toByteArray()));
                byteArrayOutputStream.reset();
            } catch (IOException e) {
                throw new ExtCertPathValidatorException("Policy qualifier info cannot be decoded.", e);
            }
        }
        return hashSet;
    }

    public static Date n(PKIXExtendedParameters pKIXExtendedParameters, CertPath certPath, int i) throws AnnotatedException {
        if (pKIXExtendedParameters.c != 1) {
            return pKIXExtendedParameters.b();
        }
        if (i <= 0) {
            return pKIXExtendedParameters.b();
        }
        int i2 = i - 1;
        if (i2 != 0) {
            return ((X509Certificate) certPath.getCertificates().get(i2)).getNotBefore();
        }
        ASN1GeneralizedTime aSN1GeneralizedTime = null;
        try {
            byte[] extensionValue = ((X509Certificate) certPath.getCertificates().get(i2)).getExtensionValue(ISISMTTObjectIdentifiers.a.c);
            if (extensionValue != null) {
                aSN1GeneralizedTime = ASN1GeneralizedTime.r(ASN1Primitive.k(extensionValue));
            }
            if (aSN1GeneralizedTime == null) {
                return ((X509Certificate) certPath.getCertificates().get(i2)).getNotBefore();
            }
            try {
                return aSN1GeneralizedTime.q();
            } catch (ParseException e) {
                throw new AnnotatedException("Date from date of cert gen extension could not be parsed.", e);
            }
        } catch (IOException unused) {
            throw new AnnotatedException("Date of cert gen extension could not be read.", (Exception) null);
        } catch (IllegalArgumentException unused2) {
            throw new AnnotatedException("Date of cert gen extension could not be read.", (Exception) null);
        }
    }

    public static boolean o(X509Certificate x509Certificate) {
        return x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN());
    }

    public static PKIXPolicyNode p(PKIXPolicyNode pKIXPolicyNode, List[] listArr, PKIXPolicyNode pKIXPolicyNode2) {
        PKIXPolicyNode pKIXPolicyNode3 = (PKIXPolicyNode) pKIXPolicyNode2.getParent();
        if (pKIXPolicyNode == null) {
            return null;
        }
        if (pKIXPolicyNode3 == null) {
            for (int i = 0; i < listArr.length; i++) {
                listArr[i] = new ArrayList();
            }
            return null;
        }
        pKIXPolicyNode3.f6595a.remove(pKIXPolicyNode2);
        q(listArr, pKIXPolicyNode2);
        return pKIXPolicyNode;
    }

    public static void q(List[] listArr, PKIXPolicyNode pKIXPolicyNode) {
        listArr[pKIXPolicyNode.getDepth()].remove(pKIXPolicyNode);
        if (!pKIXPolicyNode.f6595a.isEmpty()) {
            Iterator children = pKIXPolicyNode.getChildren();
            while (children.hasNext()) {
                q(listArr, (PKIXPolicyNode) children.next());
            }
        }
    }
}
