package org.spongycastle.jce.provider;

import java.security.cert.CertPathValidatorSpi;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public class PKIXAttrCertPathValidatorSpi extends CertPathValidatorSpi {
    public final BCJcaJceHelper a = new BCJcaJceHelper();

    /* JADX WARNING: Removed duplicated region for block: B:209:0x03fa  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0444  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.cert.CertPathValidatorResult engineValidate(java.security.cert.CertPath r22, java.security.cert.CertPathParameters r23) throws java.security.cert.CertPathValidatorException, java.security.InvalidAlgorithmParameterException {
        /*
            r21 = this;
            r0 = r23
            boolean r1 = r0 instanceof org.spongycastle.x509.ExtendedPKIXParameters
            if (r1 != 0) goto L_0x002a
            boolean r2 = r0 instanceof org.spongycastle.jcajce.PKIXExtendedParameters
            if (r2 == 0) goto L_0x000b
            goto L_0x002a
        L_0x000b:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Parameters must be a "
            r1.<init>(r2)
            java.lang.Class<org.spongycastle.x509.ExtendedPKIXParameters> r2 = org.spongycastle.x509.ExtendedPKIXParameters.class
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = " instance."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x002a:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            boolean r6 = r0 instanceof java.security.cert.PKIXParameters
            if (r6 == 0) goto L_0x006e
            org.spongycastle.jcajce.PKIXExtendedParameters$Builder r6 = new org.spongycastle.jcajce.PKIXExtendedParameters$Builder
            r7 = r0
            java.security.cert.PKIXParameters r7 = (java.security.cert.PKIXParameters) r7
            r6.<init>((java.security.cert.PKIXParameters) r7)
            if (r1 == 0) goto L_0x0068
            org.spongycastle.x509.ExtendedPKIXParameters r0 = (org.spongycastle.x509.ExtendedPKIXParameters) r0
            boolean r1 = r0.f6864a
            r6.f6338b = r1
            int r1 = r0.c
            r6.a = r1
            java.util.HashSet r1 = r0.d
            java.util.Set r2 = java.util.Collections.unmodifiableSet(r1)
            java.util.HashSet r1 = r0.f6866c
            java.util.Set r3 = java.util.Collections.unmodifiableSet(r1)
            java.util.HashSet r0 = r0.f6865b
            java.util.Set r4 = java.util.Collections.unmodifiableSet(r0)
        L_0x0068:
            org.spongycastle.jcajce.PKIXExtendedParameters r0 = new org.spongycastle.jcajce.PKIXExtendedParameters
            r0.<init>(r6)
            goto L_0x0070
        L_0x006e:
            org.spongycastle.jcajce.PKIXExtendedParameters r0 = (org.spongycastle.jcajce.PKIXExtendedParameters) r0
        L_0x0070:
            r1 = r0
            org.spongycastle.jcajce.PKIXCertStoreSelector r0 = r1.f6326a
            boolean r6 = r0 instanceof org.spongycastle.x509.X509AttributeCertStoreSelector
            if (r6 == 0) goto L_0x04d9
            org.spongycastle.x509.X509AttributeCertStoreSelector r0 = (org.spongycastle.x509.X509AttributeCertStoreSelector) r0
            org.spongycastle.x509.X509AttributeCertificate r14 = r0.f6871a
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3281CertPathUtilities.a
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            org.spongycastle.x509.AttributeCertificateHolder r6 = r14.b()
            org.spongycastle.asn1.x509.Holder r6 = r6.a
            org.spongycastle.asn1.x509.IssuerSerial r6 = r6.f5744a
            if (r6 == 0) goto L_0x0093
            org.spongycastle.asn1.x509.GeneralNames r6 = r6.f5747a
            java.security.Principal[] r6 = org.spongycastle.x509.AttributeCertificateHolder.b(r6)
            goto L_0x0094
        L_0x0093:
            r6 = 0
        L_0x0094:
            r15 = 0
            java.lang.String r7 = "Unable to encode X500 principal."
            java.lang.String r8 = "Public key certificate for attribute certificate cannot be searched."
            if (r6 == 0) goto L_0x010e
            java.security.cert.X509CertSelector r6 = new java.security.cert.X509CertSelector
            r6.<init>()
            org.spongycastle.x509.AttributeCertificateHolder r9 = r14.b()
            org.spongycastle.asn1.x509.Holder r9 = r9.a
            org.spongycastle.asn1.x509.IssuerSerial r9 = r9.f5744a
            if (r9 == 0) goto L_0x00b1
            org.spongycastle.asn1.ASN1Integer r9 = r9.a
            java.math.BigInteger r9 = r9.t()
            goto L_0x00b2
        L_0x00b1:
            r9 = 0
        L_0x00b2:
            r6.setSerialNumber(r9)
            org.spongycastle.x509.AttributeCertificateHolder r9 = r14.b()
            org.spongycastle.asn1.x509.Holder r9 = r9.a
            org.spongycastle.asn1.x509.IssuerSerial r9 = r9.f5744a
            if (r9 == 0) goto L_0x00c6
            org.spongycastle.asn1.x509.GeneralNames r9 = r9.f5747a
            java.security.Principal[] r9 = org.spongycastle.x509.AttributeCertificateHolder.b(r9)
            goto L_0x00c7
        L_0x00c6:
            r9 = 0
        L_0x00c7:
            r10 = r15
        L_0x00c8:
            int r11 = r9.length
            if (r10 >= r11) goto L_0x00ff
            r11 = r9[r10]     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            boolean r12 = r11 instanceof javax.security.auth.x500.X500Principal     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            if (r12 == 0) goto L_0x00da
            javax.security.auth.x500.X500Principal r11 = (javax.security.auth.x500.X500Principal) r11     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            byte[] r11 = r11.getEncoded()     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            r6.setIssuer(r11)     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
        L_0x00da:
            org.spongycastle.jcajce.PKIXCertStoreSelector$Builder r11 = new org.spongycastle.jcajce.PKIXCertStoreSelector$Builder     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            r11.<init>(r6)     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            org.spongycastle.jcajce.PKIXCertStoreSelector r11 = r11.a()     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            java.util.List r12 = r1.a()     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            java.util.LinkedHashSet r11 = org.spongycastle.jce.provider.CertPathValidatorUtilities.a(r11, r12)     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            r0.addAll(r11)     // Catch:{ AnnotatedException -> 0x00f8, IOException -> 0x00f1 }
            int r10 = r10 + 1
            goto L_0x00c8
        L_0x00f1:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r7, r0)
            throw r1
        L_0x00f8:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r8, r0)
            throw r1
        L_0x00ff:
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x0106
            goto L_0x010e
        L_0x0106:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Public key certificate specified in base certificate ID for attribute certificate cannot be found."
            r0.<init>(r1)
            throw r0
        L_0x010e:
            org.spongycastle.x509.AttributeCertificateHolder r6 = r14.b()
            java.security.Principal[] r6 = r6.a()
            if (r6 == 0) goto L_0x016c
            org.spongycastle.x509.X509CertStoreSelector r6 = new org.spongycastle.x509.X509CertStoreSelector
            r6.<init>()
            org.spongycastle.x509.AttributeCertificateHolder r9 = r14.b()
            java.security.Principal[] r9 = r9.a()
            r10 = r15
        L_0x0126:
            int r11 = r9.length
            if (r10 >= r11) goto L_0x015d
            r11 = r9[r10]     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            boolean r12 = r11 instanceof javax.security.auth.x500.X500Principal     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            if (r12 == 0) goto L_0x0138
            javax.security.auth.x500.X500Principal r11 = (javax.security.auth.x500.X500Principal) r11     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            byte[] r11 = r11.getEncoded()     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            r6.setIssuer(r11)     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
        L_0x0138:
            org.spongycastle.jcajce.PKIXCertStoreSelector$Builder r11 = new org.spongycastle.jcajce.PKIXCertStoreSelector$Builder     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            r11.<init>(r6)     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            org.spongycastle.jcajce.PKIXCertStoreSelector r11 = r11.a()     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            java.util.List r12 = r1.a()     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            java.util.LinkedHashSet r11 = org.spongycastle.jce.provider.CertPathValidatorUtilities.a(r11, r12)     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            r0.addAll(r11)     // Catch:{ AnnotatedException -> 0x0156, IOException -> 0x014f }
            int r10 = r10 + 1
            goto L_0x0126
        L_0x014f:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r7, r0)
            throw r1
        L_0x0156:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r8, r0)
            throw r1
        L_0x015d:
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x0164
            goto L_0x016c
        L_0x0164:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Public key certificate specified in entity name for attribute certificate cannot be found."
            r0.<init>(r1)
            throw r0
        L_0x016c:
            org.spongycastle.jcajce.PKIXExtendedParameters$Builder r6 = new org.spongycastle.jcajce.PKIXExtendedParameters$Builder
            r6.<init>((org.spongycastle.jcajce.PKIXExtendedParameters) r1)
            java.util.Iterator r7 = r0.iterator()
            r0 = 0
            r8 = 0
        L_0x0177:
            boolean r9 = r7.hasNext()
            java.lang.String r10 = "SC"
            java.lang.String r11 = "PKIX"
            java.lang.String r12 = "Support class could not be created."
            if (r9 == 0) goto L_0x01d9
            org.spongycastle.x509.X509CertStoreSelector r9 = new org.spongycastle.x509.X509CertStoreSelector
            r9.<init>()
            java.lang.Object r13 = r7.next()
            java.security.cert.X509Certificate r13 = (java.security.cert.X509Certificate) r13
            r9.setCertificate(r13)
            org.spongycastle.jcajce.PKIXCertStoreSelector$Builder r13 = new org.spongycastle.jcajce.PKIXCertStoreSelector$Builder
            r13.<init>(r9)
            org.spongycastle.jcajce.PKIXCertStoreSelector r9 = r13.a()
            r6.f6335a = r9
            java.security.cert.CertPathBuilder r9 = java.security.cert.CertPathBuilder.getInstance(r11, r10)     // Catch:{ NoSuchProviderException -> 0x01d1, NoSuchAlgorithmException -> 0x01c9 }
            org.spongycastle.jcajce.PKIXExtendedBuilderParameters$Builder r10 = new org.spongycastle.jcajce.PKIXExtendedBuilderParameters$Builder     // Catch:{ CertPathBuilderException -> 0x01bf, InvalidAlgorithmParameterException -> 0x01b4 }
            org.spongycastle.jcajce.PKIXExtendedParameters r11 = new org.spongycastle.jcajce.PKIXExtendedParameters     // Catch:{ CertPathBuilderException -> 0x01bf, InvalidAlgorithmParameterException -> 0x01b4 }
            r11.<init>(r6)     // Catch:{ CertPathBuilderException -> 0x01bf, InvalidAlgorithmParameterException -> 0x01b4 }
            r10.<init>((org.spongycastle.jcajce.PKIXExtendedParameters) r11)     // Catch:{ CertPathBuilderException -> 0x01bf, InvalidAlgorithmParameterException -> 0x01b4 }
            org.spongycastle.jcajce.PKIXExtendedBuilderParameters r11 = new org.spongycastle.jcajce.PKIXExtendedBuilderParameters     // Catch:{ CertPathBuilderException -> 0x01bf, InvalidAlgorithmParameterException -> 0x01b4 }
            r11.<init>(r10)     // Catch:{ CertPathBuilderException -> 0x01bf, InvalidAlgorithmParameterException -> 0x01b4 }
            java.security.cert.CertPathBuilderResult r8 = r9.build(r11)     // Catch:{ CertPathBuilderException -> 0x01bf, InvalidAlgorithmParameterException -> 0x01b4 }
            goto L_0x0177
        L_0x01b4:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r0 = r0.getMessage()
            r1.<init>(r0)
            throw r1
        L_0x01bf:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r9 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r10 = "Certification path for public key certificate of attribute certificate could not be build."
            r9.<init>(r10, r0)
            r0 = r9
            goto L_0x0177
        L_0x01c9:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r0.<init>(r12, r1)
            throw r0
        L_0x01d1:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r0.<init>(r12, r1)
            throw r0
        L_0x01d9:
            if (r0 != 0) goto L_0x04d8
            r8.getCertPath()
            java.security.cert.CertPathValidator r0 = java.security.cert.CertPathValidator.getInstance(r11, r10)     // Catch:{ NoSuchProviderException -> 0x04d0, NoSuchAlgorithmException -> 0x04c8 }
            r6 = r22
            java.security.cert.CertPathValidatorResult r16 = r0.validate(r6, r1)     // Catch:{ CertPathValidatorException -> 0x04be, InvalidAlgorithmParameterException -> 0x04b2 }
            java.util.List r0 = r22.getCertificates()
            java.lang.Object r0 = r0.get(r15)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            boolean[] r7 = r0.getKeyUsage()
            r17 = 1
            if (r7 == 0) goto L_0x0213
            boolean[] r7 = r0.getKeyUsage()
            boolean r7 = r7[r15]
            if (r7 != 0) goto L_0x0213
            boolean[] r7 = r0.getKeyUsage()
            boolean r7 = r7[r17]
            if (r7 == 0) goto L_0x020b
            goto L_0x0213
        L_0x020b:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate issuer public key cannot be used to validate digital signatures."
            r0.<init>(r1)
            throw r0
        L_0x0213:
            int r7 = r0.getBasicConstraints()
            r8 = -1
            if (r7 != r8) goto L_0x04aa
            java.util.Iterator r5 = r5.iterator()
            r7 = r15
        L_0x021f:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x024c
            java.lang.Object r9 = r5.next()
            java.security.cert.TrustAnchor r9 = (java.security.cert.TrustAnchor) r9
            javax.security.auth.x500.X500Principal r10 = r0.getSubjectX500Principal()
            java.lang.String r11 = "RFC2253"
            java.lang.String r10 = r10.getName(r11)
            java.lang.String r11 = r9.getCAName()
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0249
            java.security.cert.X509Certificate r9 = r9.getTrustedCert()
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x021f
        L_0x0249:
            r7 = r17
            goto L_0x021f
        L_0x024c:
            if (r7 == 0) goto L_0x04a2
            java.lang.String r5 = "Attribute certificate is not valid."
            org.spongycastle.jce.provider.PKIXCRLUtil r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.f6569a     // Catch:{ CertificateExpiredException -> 0x049b, CertificateNotYetValidException -> 0x0494 }
            java.util.Date r0 = r1.b()     // Catch:{ CertificateExpiredException -> 0x049b, CertificateNotYetValidException -> 0x0494 }
            r14.checkValidity(r0)     // Catch:{ CertificateExpiredException -> 0x049b, CertificateNotYetValidException -> 0x0494 }
            java.lang.String r5 = "Target information extension could not be read."
            java.util.Set r0 = r14.getCriticalExtensionOIDs()
            java.lang.String r7 = org.spongycastle.jce.provider.RFC3281CertPathUtilities.a
            boolean r9 = r0.contains(r7)
            if (r9 == 0) goto L_0x028c
            org.spongycastle.asn1.ASN1Primitive r9 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r14, r7)     // Catch:{ AnnotatedException -> 0x0285, IllegalArgumentException -> 0x027e }
            boolean r10 = r9 instanceof org.spongycastle.asn1.x509.TargetInformation     // Catch:{ AnnotatedException -> 0x0285, IllegalArgumentException -> 0x027e }
            if (r10 == 0) goto L_0x0272
            org.spongycastle.asn1.x509.TargetInformation r9 = (org.spongycastle.asn1.x509.TargetInformation) r9     // Catch:{ AnnotatedException -> 0x0285, IllegalArgumentException -> 0x027e }
            goto L_0x028c
        L_0x0272:
            if (r9 == 0) goto L_0x028c
            org.spongycastle.asn1.x509.TargetInformation r10 = new org.spongycastle.asn1.x509.TargetInformation     // Catch:{ AnnotatedException -> 0x0285, IllegalArgumentException -> 0x027e }
            org.spongycastle.asn1.ASN1Sequence r9 = org.spongycastle.asn1.ASN1Sequence.q(r9)     // Catch:{ AnnotatedException -> 0x0285, IllegalArgumentException -> 0x027e }
            r10.<init>(r9)     // Catch:{ AnnotatedException -> 0x0285, IllegalArgumentException -> 0x027e }
            goto L_0x028c
        L_0x027e:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r5, r0)
            throw r1
        L_0x0285:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r5, r0)
            throw r1
        L_0x028c:
            r0.remove(r7)
            java.util.Iterator r2 = r2.iterator()
        L_0x0293:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x02a3
            java.lang.Object r5 = r2.next()
            org.spongycastle.x509.PKIXAttrCertChecker r5 = (org.spongycastle.x509.PKIXAttrCertChecker) r5
            r5.a()
            goto L_0x0293
        L_0x02a3:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x0480
            java.util.Iterator r0 = r3.iterator()
        L_0x02ad:
            boolean r2 = r0.hasNext()
            java.lang.String r3 = "."
            if (r2 == 0) goto L_0x02ce
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            org.spongycastle.x509.X509Attribute[] r5 = r14.c(r2)
            if (r5 != 0) goto L_0x02c2
            goto L_0x02ad
        L_0x02c2:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate contains prohibited attribute: "
            java.lang.String r1 = defpackage.lf.j(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x02ce:
            java.util.Iterator r0 = r4.iterator()
        L_0x02d2:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x02f1
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            org.spongycastle.x509.X509Attribute[] r4 = r14.c(r2)
            if (r4 == 0) goto L_0x02e5
            goto L_0x02d2
        L_0x02e5:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate does not contain necessary attribute: "
            java.lang.String r1 = defpackage.lf.j(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x02f1:
            r0 = 0
            java.util.Date r2 = org.spongycastle.jce.provider.CertPathValidatorUtilities.n(r1, r0, r8)     // Catch:{ AnnotatedException -> 0x0476 }
            java.util.List r3 = r22.getCertificates()
            r4 = r21
            org.spongycastle.jcajce.util.BCJcaJceHelper r5 = r4.a
            boolean r0 = r1.f6327a
            if (r0 == 0) goto L_0x0475
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3281CertPathUtilities.b
            byte[] r0 = r14.getExtensionValue(r0)
            java.lang.String r6 = org.spongycastle.jce.provider.RFC3281CertPathUtilities.c
            if (r0 != 0) goto L_0x045e
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r14, r6)     // Catch:{ AnnotatedException -> 0x0455 }
            org.spongycastle.asn1.x509.CRLDistPoint r0 = org.spongycastle.asn1.x509.CRLDistPoint.h(r0)     // Catch:{ AnnotatedException -> 0x0455 }
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Map<org.spongycastle.asn1.x509.GeneralName, org.spongycastle.jcajce.PKIXCRLStore> r7 = r1.f6328b     // Catch:{ AnnotatedException -> 0x044c }
            java.util.List r7 = org.spongycastle.jce.provider.CertPathValidatorUtilities.e(r0, r7)     // Catch:{ AnnotatedException -> 0x044c }
            r6.addAll(r7)     // Catch:{ AnnotatedException -> 0x044c }
            org.spongycastle.jcajce.PKIXExtendedParameters$Builder r7 = new org.spongycastle.jcajce.PKIXExtendedParameters$Builder
            r7.<init>((org.spongycastle.jcajce.PKIXExtendedParameters) r1)
            java.util.Iterator r1 = r6.iterator()
        L_0x032b:
            boolean r8 = r1.hasNext()
            if (r8 == 0) goto L_0x033a
            r8 = r6
            org.spongycastle.jcajce.PKIXCRLStore r8 = (org.spongycastle.jcajce.PKIXCRLStore) r8
            java.util.ArrayList r9 = r7.b
            r9.add(r8)
            goto L_0x032b
        L_0x033a:
            org.spongycastle.jcajce.PKIXExtendedParameters r1 = new org.spongycastle.jcajce.PKIXExtendedParameters
            r1.<init>(r7)
            org.spongycastle.jce.provider.CertStatus r13 = new org.spongycastle.jce.provider.CertStatus
            r13.<init>()
            org.spongycastle.jce.provider.ReasonsMask r18 = new org.spongycastle.jce.provider.ReasonsMask
            r18.<init>()
            r6 = 11
            java.lang.String r12 = "No valid CRL for distribution point found."
            if (r0 == 0) goto L_0x0398
            org.spongycastle.asn1.x509.DistributionPoint[] r0 = r0.g()     // Catch:{ Exception -> 0x038e }
            r11 = r15
            r19 = r11
        L_0x0356:
            int r7 = r0.length     // Catch:{ AnnotatedException -> 0x0385 }
            if (r11 >= r7) goto L_0x0382
            int r7 = r13.a     // Catch:{ AnnotatedException -> 0x0385 }
            if (r7 != r6) goto L_0x0382
            boolean r6 = r18.a()     // Catch:{ AnnotatedException -> 0x0385 }
            if (r6 != 0) goto L_0x0382
            r6 = r0[r11]     // Catch:{ AnnotatedException -> 0x0385 }
            r7 = r14
            r8 = r1
            r9 = r2
            r10 = r13
            r20 = r11
            r11 = r18
            r15 = r12
            r12 = r3
            r4 = r13
            r13 = r5
            org.spongycastle.jce.provider.RFC3281CertPathUtilities.a(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ AnnotatedException -> 0x0380 }
            int r11 = r20 + 1
            r6 = 11
            r13 = r4
            r12 = r15
            r19 = r17
            r15 = 0
            r4 = r21
            goto L_0x0356
        L_0x0380:
            r0 = move-exception
            goto L_0x0388
        L_0x0382:
            r15 = r12
            r4 = r13
            goto L_0x039c
        L_0x0385:
            r0 = move-exception
            r15 = r12
            r4 = r13
        L_0x0388:
            org.spongycastle.jce.provider.AnnotatedException r6 = new org.spongycastle.jce.provider.AnnotatedException
            r6.<init>(r15, r0)
            goto L_0x039d
        L_0x038e:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "Distribution points could not be read."
            r0.<init>(r2, r1)
            throw r0
        L_0x0398:
            r15 = r12
            r4 = r13
            r19 = 0
        L_0x039c:
            r6 = 0
        L_0x039d:
            r0 = r6
            int r6 = r4.a
            r7 = 11
            if (r6 != r7) goto L_0x03f6
            boolean r6 = r18.a()
            if (r6 != 0) goto L_0x03f6
            org.spongycastle.asn1.ASN1InputStream r6 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ Exception -> 0x03e6 }
            org.spongycastle.x509.AttributeCertificateIssuer r7 = r14.a()     // Catch:{ Exception -> 0x03e6 }
            java.security.Principal[] r7 = r7.a()     // Catch:{ Exception -> 0x03e6 }
            r8 = 0
            r7 = r7[r8]     // Catch:{ Exception -> 0x03e6 }
            javax.security.auth.x500.X500Principal r7 = (javax.security.auth.x500.X500Principal) r7     // Catch:{ Exception -> 0x03e6 }
            byte[] r7 = r7.getEncoded()     // Catch:{ Exception -> 0x03e6 }
            r6.<init>((byte[]) r7)     // Catch:{ Exception -> 0x03e6 }
            org.spongycastle.asn1.ASN1Primitive r6 = r6.j()     // Catch:{ Exception -> 0x03e6 }
            org.spongycastle.asn1.x509.DistributionPoint r7 = new org.spongycastle.asn1.x509.DistributionPoint     // Catch:{ AnnotatedException -> 0x03ef }
            org.spongycastle.asn1.x509.DistributionPointName r8 = new org.spongycastle.asn1.x509.DistributionPointName     // Catch:{ AnnotatedException -> 0x03ef }
            org.spongycastle.asn1.x509.GeneralNames r9 = new org.spongycastle.asn1.x509.GeneralNames     // Catch:{ AnnotatedException -> 0x03ef }
            org.spongycastle.asn1.x509.GeneralName r10 = new org.spongycastle.asn1.x509.GeneralName     // Catch:{ AnnotatedException -> 0x03ef }
            r11 = 4
            r10.<init>(r11, r6)     // Catch:{ AnnotatedException -> 0x03ef }
            r9.<init>((org.spongycastle.asn1.x509.GeneralName) r10)     // Catch:{ AnnotatedException -> 0x03ef }
            r8.<init>((org.spongycastle.asn1.x509.GeneralNames) r9)     // Catch:{ AnnotatedException -> 0x03ef }
            r7.<init>((org.spongycastle.asn1.x509.DistributionPointName) r8)     // Catch:{ AnnotatedException -> 0x03ef }
            r6 = r7
            r7 = r14
            r8 = r1
            r9 = r2
            r10 = r4
            r11 = r18
            r12 = r3
            r13 = r5
            org.spongycastle.jce.provider.RFC3281CertPathUtilities.a(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ AnnotatedException -> 0x03ef }
            goto L_0x03f8
        L_0x03e6:
            r0 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r1 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x03ef }
            java.lang.String r2 = "Issuer from certificate for CRL could not be reencoded."
            r1.<init>(r2, r0)     // Catch:{ AnnotatedException -> 0x03ef }
            throw r1     // Catch:{ AnnotatedException -> 0x03ef }
        L_0x03ef:
            r0 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r1 = new org.spongycastle.jce.provider.AnnotatedException
            r1.<init>(r15, r0)
            r0 = r1
        L_0x03f6:
            r17 = r19
        L_0x03f8:
            if (r17 == 0) goto L_0x0444
            int r0 = r4.a
            r1 = 11
            if (r0 != r1) goto L_0x041b
            boolean r0 = r18.a()
            r2 = 12
            if (r0 != 0) goto L_0x040e
            int r0 = r4.a
            if (r0 != r1) goto L_0x040e
            r4.a = r2
        L_0x040e:
            int r0 = r4.a
            if (r0 == r2) goto L_0x0413
            goto L_0x0475
        L_0x0413:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate status could not be determined."
            r0.<init>(r1)
            throw r0
        L_0x041b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Attribute certificate revocation after "
            r0.<init>(r1)
            java.util.Date r1 = r4.f6570a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = ", reason: "
            java.lang.StringBuilder r0 = defpackage.lf.n(r0, r1)
            java.lang.String[] r1 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.f6598a
            int r2 = r4.a
            r1 = r1[r2]
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            r1.<init>(r0)
            throw r1
        L_0x0444:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "No valid CRL found."
            r1.<init>(r2, r0)
            throw r1
        L_0x044c:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "No additional CRL locations could be decoded from CRL distribution point extension."
            r1.<init>(r2, r0)
            throw r1
        L_0x0455:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "CRL distribution point extension could not be read."
            r1.<init>(r2, r0)
            throw r1
        L_0x045e:
            byte[] r0 = r14.getExtensionValue(r6)
            if (r0 != 0) goto L_0x046d
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3281CertPathUtilities.d
            byte[] r0 = r14.getExtensionValue(r0)
            if (r0 != 0) goto L_0x046d
            goto L_0x0475
        L_0x046d:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "No rev avail extension is set, but also an AC revocation pointer."
            r0.<init>(r1)
            throw r0
        L_0x0475:
            return r16
        L_0x0476:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "Could not get validity date from attribute certificate."
            r0.<init>(r2, r1)
            throw r0
        L_0x0480:
            java.security.cert.CertPathValidatorException r1 = new java.security.cert.CertPathValidatorException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Attribute certificate contains unsupported critical extensions: "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0494:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r5, r0)
            throw r1
        L_0x049b:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r1 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r1.<init>(r5, r0)
            throw r1
        L_0x04a2:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate issuer is not directly trusted."
            r0.<init>(r1)
            throw r0
        L_0x04aa:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r1 = "Attribute certificate issuer is also a public key certificate issuer."
            r0.<init>(r1)
            throw r0
        L_0x04b2:
            r0 = move-exception
            r1 = r0
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = r1.getMessage()
            r0.<init>(r1)
            throw r0
        L_0x04be:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "Certification path for issuer certificate of attribute certificate could not be validated."
            r0.<init>(r2, r1)
            throw r0
        L_0x04c8:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r0.<init>(r12, r1)
            throw r0
        L_0x04d0:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r0.<init>(r12, r1)
            throw r0
        L_0x04d8:
            throw r0
        L_0x04d9:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "TargetConstraints must be an instance of "
            r1.<init>(r2)
            java.lang.Class<org.spongycastle.x509.X509AttributeCertStoreSelector> r2 = org.spongycastle.x509.X509AttributeCertStoreSelector.class
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = " for "
            r1.append(r2)
            java.lang.Class r2 = r21.getClass()
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = " class."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi.engineValidate(java.security.cert.CertPath, java.security.cert.CertPathParameters):java.security.cert.CertPathValidatorResult");
    }
}
