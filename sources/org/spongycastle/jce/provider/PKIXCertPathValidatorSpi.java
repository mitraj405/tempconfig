package org.spongycastle.jce.provider;

import java.security.cert.CertPathValidatorSpi;
import org.spongycastle.jcajce.util.BCJcaJceHelper;

public class PKIXCertPathValidatorSpi extends CertPathValidatorSpi {
    public final BCJcaJceHelper a = new BCJcaJceHelper();

    /* JADX WARNING: Removed duplicated region for block: B:478:0x0ac1  */
    /* JADX WARNING: Removed duplicated region for block: B:479:0x0b05  */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0b1e A[SYNTHETIC, Splitter:B:483:0x0b1e] */
    /* JADX WARNING: Removed duplicated region for block: B:490:0x0b37  */
    /* JADX WARNING: Removed duplicated region for block: B:578:0x0cab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.cert.CertPathValidatorResult engineValidate(java.security.cert.CertPath r54, java.security.cert.CertPathParameters r55) throws java.security.cert.CertPathValidatorException, java.security.InvalidAlgorithmParameterException {
        /*
            r53 = this;
            r1 = r54
            r0 = r55
            java.lang.String r2 = "unable to process TBSCertificate"
            java.lang.String r3 = "Policy mappings extension could not be decoded."
            java.lang.String r4 = "Could not read certificate policies extension from certificate."
            boolean r5 = r0 instanceof java.security.cert.PKIXParameters
            if (r5 == 0) goto L_0x002a
            org.spongycastle.jcajce.PKIXExtendedParameters$Builder r5 = new org.spongycastle.jcajce.PKIXExtendedParameters$Builder
            r6 = r0
            java.security.cert.PKIXParameters r6 = (java.security.cert.PKIXParameters) r6
            r5.<init>((java.security.cert.PKIXParameters) r6)
            boolean r6 = r0 instanceof org.spongycastle.x509.ExtendedPKIXParameters
            if (r6 == 0) goto L_0x0024
            org.spongycastle.x509.ExtendedPKIXParameters r0 = (org.spongycastle.x509.ExtendedPKIXParameters) r0
            boolean r6 = r0.f6864a
            r5.f6338b = r6
            int r0 = r0.c
            r5.a = r0
        L_0x0024:
            org.spongycastle.jcajce.PKIXExtendedParameters r0 = new org.spongycastle.jcajce.PKIXExtendedParameters
            r0.<init>(r5)
            goto L_0x0039
        L_0x002a:
            boolean r5 = r0 instanceof org.spongycastle.jcajce.PKIXExtendedBuilderParameters
            if (r5 == 0) goto L_0x0033
            org.spongycastle.jcajce.PKIXExtendedBuilderParameters r0 = (org.spongycastle.jcajce.PKIXExtendedBuilderParameters) r0
            org.spongycastle.jcajce.PKIXExtendedParameters r0 = r0.f6319a
            goto L_0x0039
        L_0x0033:
            boolean r5 = r0 instanceof org.spongycastle.jcajce.PKIXExtendedParameters
            if (r5 == 0) goto L_0x0d2a
            org.spongycastle.jcajce.PKIXExtendedParameters r0 = (org.spongycastle.jcajce.PKIXExtendedParameters) r0
        L_0x0039:
            java.util.Set<java.security.cert.TrustAnchor> r5 = r0.f6325a
            if (r5 == 0) goto L_0x0d22
            java.util.List r5 = r54.getCertificates()
            int r6 = r5.size()
            boolean r7 = r5.isEmpty()
            if (r7 != 0) goto L_0x0d18
            java.security.cert.PKIXParameters r7 = r0.a
            java.util.Set r10 = r7.getInitialPolicies()
            r11 = 1
            int r12 = r5.size()     // Catch:{ AnnotatedException -> 0x0cde }
            int r12 = r12 - r11
            java.lang.Object r12 = r5.get(r12)     // Catch:{ AnnotatedException -> 0x0cde }
            java.security.cert.X509Certificate r12 = (java.security.cert.X509Certificate) r12     // Catch:{ AnnotatedException -> 0x0cde }
            java.util.Set<java.security.cert.TrustAnchor> r13 = r0.f6325a     // Catch:{ AnnotatedException -> 0x0cde }
            java.lang.String r7 = r7.getSigProvider()     // Catch:{ AnnotatedException -> 0x0cde }
            java.security.cert.TrustAnchor r7 = org.spongycastle.jce.provider.CertPathValidatorUtilities.c(r12, r13, r7)     // Catch:{ AnnotatedException -> 0x0cde }
            if (r7 == 0) goto L_0x0cfa
            java.security.cert.X509Certificate r12 = r7.getTrustedCert()     // Catch:{ AnnotatedException -> 0x0cde }
            byte[] r12 = r12.getTBSCertificate()     // Catch:{ CertificateEncodingException -> 0x0cf1, IllegalArgumentException -> 0x0ce1 }
            boolean r13 = r12 instanceof org.spongycastle.asn1.x509.TBSCertificate     // Catch:{ CertificateEncodingException -> 0x0cf1, IllegalArgumentException -> 0x0ce1 }
            if (r13 == 0) goto L_0x0078
            org.spongycastle.asn1.x509.TBSCertificate r12 = (org.spongycastle.asn1.x509.TBSCertificate) r12     // Catch:{ CertificateEncodingException -> 0x0cf1, IllegalArgumentException -> 0x0ce1 }
            goto L_0x0088
        L_0x0078:
            if (r12 == 0) goto L_0x0088
            org.spongycastle.asn1.x509.TBSCertificate r13 = new org.spongycastle.asn1.x509.TBSCertificate     // Catch:{ CertificateEncodingException -> 0x0cf1, IllegalArgumentException -> 0x0ce1 }
            org.spongycastle.asn1.ASN1Sequence r12 = org.spongycastle.asn1.ASN1Sequence.q(r12)     // Catch:{ CertificateEncodingException -> 0x0cf1, IllegalArgumentException -> 0x0ce1 }
            r13.<init>(r12)     // Catch:{ CertificateEncodingException -> 0x0cf1, IllegalArgumentException -> 0x0ce1 }
            goto L_0x0088
        L_0x0084:
            r32 = r5
            goto L_0x0d06
        L_0x0088:
            org.spongycastle.jcajce.PKIXExtendedParameters$Builder r12 = new org.spongycastle.jcajce.PKIXExtendedParameters$Builder
            r12.<init>((org.spongycastle.jcajce.PKIXExtendedParameters) r0)
            java.util.Set r0 = java.util.Collections.singleton(r7)
            r12.f6334a = r0
            org.spongycastle.jcajce.PKIXExtendedParameters r0 = r12.a()
            int r12 = r6 + 1
            java.util.ArrayList[] r15 = new java.util.ArrayList[r12]
            r14 = 0
            r13 = r14
        L_0x009d:
            if (r13 >= r12) goto L_0x00a9
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            r15[r13] = r16
            int r13 = r13 + 1
            goto L_0x009d
        L_0x00a9:
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            java.lang.String r11 = "2.5.29.32.0"
            r13.add(r11)
            org.spongycastle.jce.provider.PKIXPolicyNode r8 = new org.spongycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r17 = new java.util.ArrayList
            r17.<init>()
            r18 = 0
            r20 = 0
            java.util.HashSet r21 = new java.util.HashSet
            r21.<init>()
            java.lang.String r22 = "2.5.29.32.0"
            r23 = 0
            r16 = r8
            r19 = r13
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)
            r13 = r15[r14]
            r13.add(r8)
            org.spongycastle.jce.provider.PKIXNameConstraintValidator r13 = new org.spongycastle.jce.provider.PKIXNameConstraintValidator
            r13.<init>()
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            java.security.cert.PKIXParameters r14 = r0.a
            boolean r17 = r14.isExplicitPolicyRequired()
            if (r17 == 0) goto L_0x00e8
            r17 = 0
            goto L_0x00ea
        L_0x00e8:
            r17 = r12
        L_0x00ea:
            boolean r18 = r14.isAnyPolicyInhibited()
            if (r18 == 0) goto L_0x00f3
            r18 = 0
            goto L_0x00f5
        L_0x00f3:
            r18 = r12
        L_0x00f5:
            boolean r19 = r14.isPolicyMappingInhibited()
            if (r19 == 0) goto L_0x00fe
            r19 = 0
            goto L_0x0100
        L_0x00fe:
            r19 = r12
        L_0x0100:
            java.security.cert.X509Certificate r21 = r7.getTrustedCert()
            if (r21 == 0) goto L_0x0117
            javax.security.auth.x500.X500Principal r22 = r21.getSubjectX500Principal()     // Catch:{ IllegalArgumentException -> 0x0cd4 }
            byte[] r22 = r22.getEncoded()     // Catch:{ IllegalArgumentException -> 0x0cd4 }
            org.spongycastle.asn1.x500.X500Name r22 = org.spongycastle.asn1.x500.X500Name.g(r22)     // Catch:{ IllegalArgumentException -> 0x0cd4 }
            java.security.PublicKey r23 = r21.getPublicKey()     // Catch:{ IllegalArgumentException -> 0x0cd4 }
            goto L_0x0127
        L_0x0117:
            javax.security.auth.x500.X500Principal r22 = r7.getCA()     // Catch:{ IllegalArgumentException -> 0x0cd4 }
            byte[] r22 = r22.getEncoded()     // Catch:{ IllegalArgumentException -> 0x0cd4 }
            org.spongycastle.asn1.x500.X500Name r22 = org.spongycastle.asn1.x500.X500Name.g(r22)     // Catch:{ IllegalArgumentException -> 0x0cd4 }
            java.security.PublicKey r23 = r7.getCAPublicKey()     // Catch:{ IllegalArgumentException -> 0x0cd4 }
        L_0x0127:
            org.spongycastle.asn1.x509.AlgorithmIdentifier r24 = org.spongycastle.jce.provider.CertPathValidatorUtilities.f(r23)     // Catch:{ CertPathValidatorException -> 0x0cc9 }
            r24.getClass()
            r24 = r8
            org.spongycastle.jcajce.PKIXCertStoreSelector r8 = r0.f6326a
            r25 = r15
            if (r8 == 0) goto L_0x0152
            r15 = 0
            java.lang.Object r16 = r5.get(r15)
            r15 = r16
            java.security.cert.X509Certificate r15 = (java.security.cert.X509Certificate) r15
            java.security.cert.CertSelector r8 = r8.a
            boolean r8 = r8.match(r15)
            if (r8 == 0) goto L_0x0148
            goto L_0x0152
        L_0x0148:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "Target certificate in certification path does not match targetConstraints."
            r3 = 0
            r8 = 0
            r0.<init>(r2, r3, r1, r8)
            throw r0
        L_0x0152:
            r8 = 0
            java.util.List r15 = r14.getCertPathCheckers()
            java.util.Iterator r16 = r15.iterator()
        L_0x015b:
            boolean r26 = r16.hasNext()
            if (r26 == 0) goto L_0x0171
            java.lang.Object r26 = r16.next()
            r27 = r13
            r13 = r26
            java.security.cert.PKIXCertPathChecker r13 = (java.security.cert.PKIXCertPathChecker) r13
            r13.init(r8)
            r13 = r27
            goto L_0x015b
        L_0x0171:
            r27 = r13
            int r13 = r5.size()
            r16 = -1
            int r13 = r13 + -1
            r29 = r10
            r28 = r12
            r26 = r21
            r8 = r22
            r12 = r23
            r10 = r6
            r21 = r17
            r22 = r18
            r23 = r19
            r17 = 0
        L_0x018e:
            if (r13 < 0) goto L_0x0a5d
            r30 = r2
            int r2 = r6 - r13
            java.lang.Object r17 = r5.get(r13)
            r31 = r4
            r4 = r17
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4
            int r17 = r5.size()
            r19 = r15
            int r15 = r17 + -1
            if (r13 != r15) goto L_0x01aa
            r15 = 1
            goto L_0x01ab
        L_0x01aa:
            r15 = 0
        L_0x01ab:
            r32 = r5
            byte[] r5 = r4.getTBSCertificate()     // Catch:{ CertificateEncodingException -> 0x0a47, IllegalArgumentException -> 0x0a38, AnnotatedException -> 0x0a35 }
            r33 = r3
            boolean r3 = r5 instanceof org.spongycastle.asn1.x509.TBSCertificate     // Catch:{ CertificateEncodingException -> 0x0a47, IllegalArgumentException -> 0x0a38, AnnotatedException -> 0x0a35 }
            if (r3 == 0) goto L_0x01ba
            org.spongycastle.asn1.x509.TBSCertificate r5 = (org.spongycastle.asn1.x509.TBSCertificate) r5     // Catch:{ CertificateEncodingException -> 0x0a47, IllegalArgumentException -> 0x0a38, AnnotatedException -> 0x0a35 }
            goto L_0x01c9
        L_0x01ba:
            if (r5 == 0) goto L_0x01c9
            org.spongycastle.asn1.x509.TBSCertificate r3 = new org.spongycastle.asn1.x509.TBSCertificate     // Catch:{ CertificateEncodingException -> 0x0a47, IllegalArgumentException -> 0x0a38, AnnotatedException -> 0x0a35 }
            org.spongycastle.asn1.ASN1Sequence r5 = org.spongycastle.asn1.ASN1Sequence.q(r5)     // Catch:{ CertificateEncodingException -> 0x0a47, IllegalArgumentException -> 0x0a38, AnnotatedException -> 0x0a35 }
            r3.<init>(r5)     // Catch:{ CertificateEncodingException -> 0x0a47, IllegalArgumentException -> 0x0a38, AnnotatedException -> 0x0a35 }
            goto L_0x01c9
        L_0x01c6:
            r4 = r13
            goto L_0x0a51
        L_0x01c9:
            r3 = r53
            org.spongycastle.jcajce.util.BCJcaJceHelper r5 = r3.a
            java.lang.String r16 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.a
            java.lang.String r3 = "Could not validate certificate: "
            r16 = r3
            java.util.List r3 = r54.getCertificates()
            java.lang.Object r17 = r3.get(r13)
            r34 = r10
            r10 = r17
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10
            if (r15 != 0) goto L_0x01fb
            java.lang.String r15 = r14.getSigProvider()     // Catch:{ GeneralSecurityException -> 0x01ed }
            if (r15 != 0) goto L_0x01ef
            r10.verify(r12)     // Catch:{ GeneralSecurityException -> 0x01ed }
            goto L_0x01fb
        L_0x01ed:
            r0 = move-exception
            goto L_0x01f3
        L_0x01ef:
            r10.verify(r12, r15)     // Catch:{ GeneralSecurityException -> 0x01ed }
            goto L_0x01fb
        L_0x01f3:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Could not validate certificate signature."
            r2.<init>(r3, r0, r1, r13)
            throw r2
        L_0x01fb:
            java.util.Date r15 = org.spongycastle.jce.provider.CertPathValidatorUtilities.n(r0, r1, r13)     // Catch:{ CertificateExpiredException -> 0x0a1b, CertificateNotYetValidException -> 0x0a01, AnnotatedException -> 0x09f7 }
            r10.checkValidity(r15)     // Catch:{ CertificateExpiredException -> 0x0a1b, CertificateNotYetValidException -> 0x0a01, AnnotatedException -> 0x09f7 }
            boolean r15 = r0.f6327a
            if (r15 == 0) goto L_0x0242
            java.util.Date r15 = org.spongycastle.jce.provider.CertPathValidatorUtilities.n(r0, r1, r13)     // Catch:{ AnnotatedException -> 0x022a }
            r35 = r7
            r7 = r27
            r27 = r4
            r4 = r13
            r13 = r0
            r36 = r0
            r37 = r14
            r0 = 0
            r14 = r10
            r39 = r19
            r38 = r25
            r16 = r26
            r17 = r12
            r18 = r3
            r19 = r5
            org.spongycastle.jce.provider.RFC3280CertPathUtilities.b(r13, r14, r15, r16, r17, r18, r19)     // Catch:{ AnnotatedException -> 0x0228 }
            goto L_0x0252
        L_0x0228:
            r0 = move-exception
            goto L_0x022c
        L_0x022a:
            r0 = move-exception
            r4 = r13
        L_0x022c:
            java.lang.Throwable r2 = r0.getCause()
            if (r2 == 0) goto L_0x0237
            java.lang.Throwable r2 = r0.getCause()
            goto L_0x0238
        L_0x0237:
            r2 = r0
        L_0x0238:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r3 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r0 = r0.getMessage()
            r3.<init>(r0, r2, r1, r4)
            throw r3
        L_0x0242:
            r36 = r0
            r35 = r7
            r37 = r14
            r39 = r19
            r38 = r25
            r7 = r27
            r0 = 0
            r27 = r4
            r4 = r13
        L_0x0252:
            org.spongycastle.asn1.x500.X500Name r3 = org.spongycastle.jce.provider.PrincipalUtils.a(r10)
            boolean r3 = r3.equals(r8)
            if (r3 == 0) goto L_0x09cf
            java.util.List r3 = r54.getCertificates()
            java.lang.Object r10 = r3.get(r4)
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10
            int r3 = r3.size()
            int r13 = r3 - r4
            boolean r14 = org.spongycastle.jce.provider.CertPathValidatorUtilities.o(r10)
            if (r14 == 0) goto L_0x027d
            if (r13 < r3) goto L_0x0275
            goto L_0x027d
        L_0x0275:
            r25 = r5
            r19 = r8
            r18 = r12
            goto L_0x0356
        L_0x027d:
            javax.security.auth.x500.X500Principal r3 = r10.getSubjectX500Principal()
            byte[] r3 = r3.getEncoded()
            org.spongycastle.asn1.x500.X500Name r3 = org.spongycastle.asn1.x500.X500Name.g(r3)
            byte[] r3 = r3.e()     // Catch:{ Exception -> 0x09c6 }
            org.spongycastle.asn1.ASN1Sequence r3 = org.spongycastle.asn1.ASN1Sequence.q(r3)     // Catch:{ Exception -> 0x09c6 }
            r7.e(r3)     // Catch:{ PKIXNameConstraintValidatorException -> 0x09bd }
            r7.c(r3)     // Catch:{ PKIXNameConstraintValidatorException -> 0x09bd }
            java.lang.String r13 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.i     // Catch:{ Exception -> 0x09b4 }
            org.spongycastle.asn1.ASN1Primitive r10 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r10, r13)     // Catch:{ Exception -> 0x09b4 }
            org.spongycastle.asn1.x509.GeneralNames r10 = org.spongycastle.asn1.x509.GeneralNames.g(r10)     // Catch:{ Exception -> 0x09b4 }
            org.spongycastle.asn1.x500.X500Name r3 = org.spongycastle.asn1.x500.X500Name.g(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = org.spongycastle.asn1.x500.style.BCStyle.a
            org.spongycastle.asn1.x500.RDN[] r3 = r3.f5721a
            int r14 = r3.length
            org.spongycastle.asn1.x500.RDN[] r14 = new org.spongycastle.asn1.x500.RDN[r14]
            r15 = r0
            r18 = r12
        L_0x02af:
            int r12 = r3.length
            if (r15 == r12) goto L_0x02fa
            r12 = r3[r15]
            boolean r17 = r12.i()
            if (r17 == 0) goto L_0x02da
            r17 = r3
            org.spongycastle.asn1.x500.AttributeTypeAndValue[] r3 = r12.h()
            r25 = r5
            r19 = r8
            r8 = 0
        L_0x02c5:
            int r5 = r3.length
            if (r8 == r5) goto L_0x02f1
            r5 = r3[r8]
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = r5.Z0
            boolean r5 = r5.equals(r13)
            if (r5 == 0) goto L_0x02d7
            int r3 = r0 + 1
            r14[r0] = r12
            goto L_0x02f0
        L_0x02d7:
            int r8 = r8 + 1
            goto L_0x02c5
        L_0x02da:
            r17 = r3
            r25 = r5
            r19 = r8
            org.spongycastle.asn1.x500.AttributeTypeAndValue r3 = r12.g()
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r3.Z0
            boolean r3 = r3.equals(r13)
            if (r3 == 0) goto L_0x02f1
            int r3 = r0 + 1
            r14[r0] = r12
        L_0x02f0:
            r0 = r3
        L_0x02f1:
            int r15 = r15 + 1
            r3 = r17
            r8 = r19
            r5 = r25
            goto L_0x02af
        L_0x02fa:
            r25 = r5
            r19 = r8
            org.spongycastle.asn1.x500.RDN[] r3 = new org.spongycastle.asn1.x500.RDN[r0]
            r5 = 0
            java.lang.System.arraycopy(r14, r5, r3, r5, r0)
            r14 = 0
        L_0x0305:
            if (r14 == r0) goto L_0x032c
            r5 = r3[r14]
            org.spongycastle.asn1.x500.AttributeTypeAndValue r5 = r5.g()
            org.spongycastle.asn1.ASN1Encodable r5 = r5.a
            org.spongycastle.asn1.ASN1String r5 = (org.spongycastle.asn1.ASN1String) r5
            java.lang.String r5 = r5.c()
            org.spongycastle.asn1.x509.GeneralName r8 = new org.spongycastle.asn1.x509.GeneralName
            r8.<init>((java.lang.String) r5)
            r7.d(r8)     // Catch:{ PKIXNameConstraintValidatorException -> 0x0323 }
            r7.b(r8)     // Catch:{ PKIXNameConstraintValidatorException -> 0x0323 }
            int r14 = r14 + 1
            goto L_0x0305
        L_0x0323:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Subtree check for certificate subject alternative email failed."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x032c:
            if (r10 == 0) goto L_0x0356
            org.spongycastle.asn1.x509.GeneralName[] r0 = r10.h()     // Catch:{ Exception -> 0x034c }
            r14 = 0
        L_0x0333:
            int r3 = r0.length
            if (r14 >= r3) goto L_0x0356
            r3 = r0[r14]     // Catch:{ PKIXNameConstraintValidatorException -> 0x0343 }
            r7.d(r3)     // Catch:{ PKIXNameConstraintValidatorException -> 0x0343 }
            r3 = r0[r14]     // Catch:{ PKIXNameConstraintValidatorException -> 0x0343 }
            r7.b(r3)     // Catch:{ PKIXNameConstraintValidatorException -> 0x0343 }
            int r14 = r14 + 1
            goto L_0x0333
        L_0x0343:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Subtree check for certificate subject alternative name failed."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x034c:
            r0 = move-exception
            r2 = r0
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Subject alternative name contents could not be decoded."
            r0.<init>(r3, r2, r1, r4)
            throw r0
        L_0x0356:
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.a
            java.util.List r3 = r54.getCertificates()
            java.lang.Object r5 = r3.get(r4)
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5
            int r3 = r3.size()
            int r8 = r3 - r4
            org.spongycastle.asn1.ASN1Primitive r10 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r5, r0)     // Catch:{ AnnotatedException -> 0x09ab }
            org.spongycastle.asn1.ASN1Sequence r10 = org.spongycastle.asn1.ASN1Sequence.q(r10)     // Catch:{ AnnotatedException -> 0x09ab }
            if (r10 == 0) goto L_0x05b5
            if (r24 == 0) goto L_0x05b5
            java.util.Enumeration r12 = r10.t()
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
        L_0x037d:
            boolean r14 = r12.hasMoreElements()
            if (r14 == 0) goto L_0x0477
            java.lang.Object r14 = r12.nextElement()
            org.spongycastle.asn1.x509.PolicyInformation r14 = org.spongycastle.asn1.x509.PolicyInformation.g(r14)
            org.spongycastle.asn1.ASN1ObjectIdentifier r15 = r14.Z0
            r17 = r12
            java.lang.String r12 = r15.c
            r13.add(r12)
            java.lang.String r12 = r15.c
            boolean r40 = r11.equals(r12)
            if (r40 != 0) goto L_0x045b
            org.spongycastle.asn1.ASN1Sequence r14 = r14.a     // Catch:{ CertPathValidatorException -> 0x0452 }
            java.util.HashSet r14 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m(r14)     // Catch:{ CertPathValidatorException -> 0x0452 }
            int r48 = r8 + -1
            r49 = r7
            r7 = r38
            r38 = r2
            r2 = r7[r48]
            r51 = r0
            r50 = r6
            r6 = 0
        L_0x03b1:
            int r0 = r2.size()
            if (r6 >= r0) goto L_0x0402
            java.lang.Object r0 = r2.get(r6)
            org.spongycastle.jce.provider.PKIXPolicyNode r0 = (org.spongycastle.jce.provider.PKIXPolicyNode) r0
            r40 = r2
            java.util.Set r2 = r0.getExpectedPolicies()
            boolean r2 = r2.contains(r12)
            if (r2 == 0) goto L_0x03fb
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r2.add(r12)
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = new org.spongycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r41 = new java.util.ArrayList
            r41.<init>()
            r52 = r10
            java.lang.String r10 = r15.c
            r47 = 0
            r40 = r6
            r42 = r8
            r43 = r2
            r44 = r0
            r45 = r14
            r46 = r10
            r40.<init>(r41, r42, r43, r44, r45, r46, r47)
            java.util.List r2 = r0.f6595a
            r2.add(r6)
            r6.f6594a = r0
            r0 = r7[r8]
            r0.add(r6)
            r0 = 1
            goto L_0x0405
        L_0x03fb:
            r52 = r10
            int r6 = r6 + 1
            r2 = r40
            goto L_0x03b1
        L_0x0402:
            r52 = r10
            r0 = 0
        L_0x0405:
            if (r0 != 0) goto L_0x0467
            r0 = r7[r48]
            r2 = 0
        L_0x040a:
            int r6 = r0.size()
            if (r2 >= r6) goto L_0x0467
            java.lang.Object r6 = r0.get(r2)
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = (org.spongycastle.jce.provider.PKIXPolicyNode) r6
            java.lang.String r10 = r6.getValidPolicy()
            boolean r10 = r11.equals(r10)
            if (r10 == 0) goto L_0x044f
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            r0.add(r12)
            org.spongycastle.jce.provider.PKIXPolicyNode r2 = new org.spongycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r41 = new java.util.ArrayList
            r41.<init>()
            java.lang.String r10 = r15.c
            r47 = 0
            r40 = r2
            r42 = r8
            r43 = r0
            r44 = r6
            r45 = r14
            r46 = r10
            r40.<init>(r41, r42, r43, r44, r45, r46, r47)
            java.util.List r0 = r6.f6595a
            r0.add(r2)
            r2.f6594a = r6
            r0 = r7[r8]
            r0.add(r2)
            goto L_0x0467
        L_0x044f:
            int r2 = r2 + 1
            goto L_0x040a
        L_0x0452:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Policy qualifier info set could not be build."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x045b:
            r51 = r0
            r50 = r6
            r49 = r7
            r52 = r10
            r7 = r38
            r38 = r2
        L_0x0467:
            r12 = r17
            r2 = r38
            r6 = r50
            r0 = r51
            r10 = r52
            r38 = r7
            r7 = r49
            goto L_0x037d
        L_0x0477:
            r51 = r0
            r50 = r6
            r49 = r7
            r52 = r10
            r7 = r38
            r38 = r2
            boolean r0 = r9.isEmpty()
            if (r0 != 0) goto L_0x04b4
            boolean r0 = r9.contains(r11)
            if (r0 == 0) goto L_0x0490
            goto L_0x04b4
        L_0x0490:
            java.util.Iterator r0 = r9.iterator()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
        L_0x0499:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x04ad
            java.lang.Object r6 = r0.next()
            boolean r10 = r13.contains(r6)
            if (r10 == 0) goto L_0x0499
            r2.add(r6)
            goto L_0x0499
        L_0x04ad:
            r9.clear()
            r9.addAll(r2)
            goto L_0x04ba
        L_0x04b4:
            r9.clear()
            r9.addAll(r13)
        L_0x04ba:
            if (r22 > 0) goto L_0x04c4
            if (r8 >= r3) goto L_0x0567
            boolean r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.o(r5)
            if (r0 == 0) goto L_0x0567
        L_0x04c4:
            java.util.Enumeration r0 = r52.t()
        L_0x04c8:
            boolean r2 = r0.hasMoreElements()
            if (r2 == 0) goto L_0x0567
            java.lang.Object r2 = r0.nextElement()
            org.spongycastle.asn1.x509.PolicyInformation r2 = org.spongycastle.asn1.x509.PolicyInformation.g(r2)
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r2.Z0
            java.lang.String r3 = r3.c
            boolean r3 = r11.equals(r3)
            if (r3 == 0) goto L_0x04c8
            org.spongycastle.asn1.ASN1Sequence r0 = r2.a
            java.util.HashSet r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m(r0)
            int r2 = r8 + -1
            r2 = r7[r2]
            r14 = 0
        L_0x04eb:
            int r3 = r2.size()
            if (r14 >= r3) goto L_0x0567
            java.lang.Object r3 = r2.get(r14)
            org.spongycastle.jce.provider.PKIXPolicyNode r3 = (org.spongycastle.jce.provider.PKIXPolicyNode) r3
            java.util.Set r6 = r3.getExpectedPolicies()
            java.util.Iterator r6 = r6.iterator()
        L_0x04ff:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0564
            java.lang.Object r10 = r6.next()
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L_0x0510
            java.lang.String r10 = (java.lang.String) r10
            goto L_0x0518
        L_0x0510:
            boolean r12 = r10 instanceof org.spongycastle.asn1.ASN1ObjectIdentifier
            if (r12 == 0) goto L_0x04ff
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r10
            java.lang.String r10 = r10.c
        L_0x0518:
            java.util.Iterator r12 = r3.getChildren()
            r13 = 0
        L_0x051d:
            boolean r15 = r12.hasNext()
            if (r15 == 0) goto L_0x0535
            java.lang.Object r15 = r12.next()
            org.spongycastle.jce.provider.PKIXPolicyNode r15 = (org.spongycastle.jce.provider.PKIXPolicyNode) r15
            java.lang.String r15 = r15.getValidPolicy()
            boolean r15 = r10.equals(r15)
            if (r15 == 0) goto L_0x051d
            r13 = 1
            goto L_0x051d
        L_0x0535:
            if (r13 != 0) goto L_0x04ff
            java.util.HashSet r12 = new java.util.HashSet
            r12.<init>()
            r12.add(r10)
            org.spongycastle.jce.provider.PKIXPolicyNode r13 = new org.spongycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r41 = new java.util.ArrayList
            r41.<init>()
            r47 = 0
            r40 = r13
            r42 = r8
            r43 = r12
            r44 = r3
            r45 = r0
            r46 = r10
            r40.<init>(r41, r42, r43, r44, r45, r46, r47)
            java.util.List r10 = r3.f6595a
            r10.add(r13)
            r13.f6594a = r3
            r10 = r7[r8]
            r10.add(r13)
            goto L_0x04ff
        L_0x0564:
            int r14 = r14 + 1
            goto L_0x04eb
        L_0x0567:
            int r0 = r8 + -1
        L_0x0569:
            if (r0 < 0) goto L_0x0595
            r2 = r7[r0]
            r3 = r24
            r14 = 0
        L_0x0570:
            int r6 = r2.size()
            if (r14 >= r6) goto L_0x0590
            java.lang.Object r6 = r2.get(r14)
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = (org.spongycastle.jce.provider.PKIXPolicyNode) r6
            java.util.List r10 = r6.f6595a
            boolean r10 = r10.isEmpty()
            r12 = 1
            r10 = r10 ^ r12
            if (r10 != 0) goto L_0x058d
            org.spongycastle.jce.provider.PKIXPolicyNode r3 = org.spongycastle.jce.provider.CertPathValidatorUtilities.p(r3, r7, r6)
            if (r3 != 0) goto L_0x058d
            goto L_0x0590
        L_0x058d:
            int r14 = r14 + 1
            goto L_0x0570
        L_0x0590:
            r24 = r3
            int r0 = r0 + -1
            goto L_0x0569
        L_0x0595:
            java.util.Set r0 = r5.getCriticalExtensionOIDs()
            if (r0 == 0) goto L_0x05bf
            r2 = r51
            boolean r0 = r0.contains(r2)
            r2 = r7[r8]
            r14 = 0
        L_0x05a4:
            int r3 = r2.size()
            if (r14 >= r3) goto L_0x05bf
            java.lang.Object r3 = r2.get(r14)
            org.spongycastle.jce.provider.PKIXPolicyNode r3 = (org.spongycastle.jce.provider.PKIXPolicyNode) r3
            r3.f6597a = r0
            int r14 = r14 + 1
            goto L_0x05a4
        L_0x05b5:
            r50 = r6
            r49 = r7
            r7 = r38
            r38 = r2
            r24 = 0
        L_0x05bf:
            java.util.List r0 = r54.getCertificates()
            java.lang.Object r0 = r0.get(r4)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r2 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.a     // Catch:{ AnnotatedException -> 0x09a2 }
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r0, r2)     // Catch:{ AnnotatedException -> 0x09a2 }
            org.spongycastle.asn1.ASN1Sequence r0 = org.spongycastle.asn1.ASN1Sequence.q(r0)     // Catch:{ AnnotatedException -> 0x09a2 }
            if (r0 != 0) goto L_0x05d7
            r24 = 0
        L_0x05d7:
            if (r21 > 0) goto L_0x05e5
            if (r24 == 0) goto L_0x05dc
            goto L_0x05e5
        L_0x05dc:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r2 = "No valid policy tree found when one expected."
            r3 = 0
            r0.<init>(r2, r3, r1, r4)
            throw r0
        L_0x05e5:
            r6 = r38
            r0 = r50
            if (r6 == r0) goto L_0x0974
            int r2 = r27.getVersion()
            r3 = 1
            if (r2 != r3) goto L_0x060d
            if (r6 != r3) goto L_0x0604
            java.security.cert.X509Certificate r2 = r35.getTrustedCert()
            r3 = r27
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0604
            r50 = r0
            goto L_0x0978
        L_0x0604:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "Version 1 certificates can't be used as CA ones."
            r3 = 0
            r0.<init>(r2, r3, r1, r4)
            throw r0
        L_0x060d:
            r3 = r27
            java.util.List r2 = r54.getCertificates()
            java.lang.Object r2 = r2.get(r4)
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            java.lang.String r5 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.b     // Catch:{ AnnotatedException -> 0x096b }
            org.spongycastle.asn1.ASN1Primitive r2 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r2, r5)     // Catch:{ AnnotatedException -> 0x096b }
            org.spongycastle.asn1.ASN1Sequence r2 = org.spongycastle.asn1.ASN1Sequence.q(r2)     // Catch:{ AnnotatedException -> 0x096b }
            if (r2 == 0) goto L_0x0674
            r14 = 0
        L_0x0626:
            int r5 = r2.size()
            if (r14 >= r5) goto L_0x0674
            org.spongycastle.asn1.ASN1Encodable r5 = r2.s(r14)     // Catch:{ Exception -> 0x066b }
            org.spongycastle.asn1.ASN1Sequence r5 = org.spongycastle.asn1.ASN1Sequence.q(r5)     // Catch:{ Exception -> 0x066b }
            r6 = 0
            org.spongycastle.asn1.ASN1Encodable r8 = r5.s(r6)     // Catch:{ Exception -> 0x066b }
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = org.spongycastle.asn1.ASN1ObjectIdentifier.u(r8)     // Catch:{ Exception -> 0x066b }
            r8 = 1
            org.spongycastle.asn1.ASN1Encodable r5 = r5.s(r8)     // Catch:{ Exception -> 0x066b }
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.ASN1ObjectIdentifier.u(r5)     // Catch:{ Exception -> 0x066b }
            java.lang.String r6 = r6.c
            boolean r6 = r11.equals(r6)
            if (r6 != 0) goto L_0x0662
            java.lang.String r5 = r5.c
            boolean r5 = r11.equals(r5)
            if (r5 != 0) goto L_0x0659
            int r14 = r14 + 1
            goto L_0x0626
        L_0x0659:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "SubjectDomainPolicy is anyPolicy,"
            r3 = 0
            r0.<init>(r2, r3, r1, r4)
            throw r0
        L_0x0662:
            r3 = 0
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "IssuerDomainPolicy is anyPolicy"
            r0.<init>(r2, r3, r1, r4)
            throw r0
        L_0x066b:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Policy mappings extension contents could not be decoded."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0674:
            java.lang.String r2 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.a
            java.util.List r5 = r54.getCertificates()
            java.lang.Object r6 = r5.get(r4)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            int r5 = r5.size()
            int r5 = r5 - r4
            java.lang.String r8 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.b     // Catch:{ AnnotatedException -> 0x0962 }
            org.spongycastle.asn1.ASN1Primitive r8 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r6, r8)     // Catch:{ AnnotatedException -> 0x0962 }
            org.spongycastle.asn1.ASN1Sequence r8 = org.spongycastle.asn1.ASN1Sequence.q(r8)     // Catch:{ AnnotatedException -> 0x0962 }
            if (r8 == 0) goto L_0x085d
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.util.HashSet r12 = new java.util.HashSet
            r12.<init>()
            r14 = 0
        L_0x069c:
            int r13 = r8.size()
            if (r14 >= r13) goto L_0x06e1
            org.spongycastle.asn1.ASN1Encodable r13 = r8.s(r14)
            org.spongycastle.asn1.ASN1Sequence r13 = (org.spongycastle.asn1.ASN1Sequence) r13
            r15 = 0
            org.spongycastle.asn1.ASN1Encodable r17 = r13.s(r15)
            r15 = r17
            org.spongycastle.asn1.ASN1ObjectIdentifier r15 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r15
            java.lang.String r15 = r15.c
            r17 = r8
            r8 = 1
            org.spongycastle.asn1.ASN1Encodable r13 = r13.s(r8)
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r13
            java.lang.String r8 = r13.c
            boolean r13 = r10.containsKey(r15)
            if (r13 != 0) goto L_0x06d3
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            r13.add(r8)
            r10.put(r15, r13)
            r12.add(r15)
            goto L_0x06dc
        L_0x06d3:
            java.lang.Object r13 = r10.get(r15)
            java.util.Set r13 = (java.util.Set) r13
            r13.add(r8)
        L_0x06dc:
            int r14 = r14 + 1
            r8 = r17
            goto L_0x069c
        L_0x06e1:
            java.util.Iterator r8 = r12.iterator()
        L_0x06e5:
            boolean r12 = r8.hasNext()
            if (r12 == 0) goto L_0x085d
            java.lang.Object r12 = r8.next()
            java.lang.String r12 = (java.lang.String) r12
            if (r23 <= 0) goto L_0x07d6
            r13 = r7[r5]
            java.util.Iterator r13 = r13.iterator()
        L_0x06f9:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0719
            java.lang.Object r14 = r13.next()
            org.spongycastle.jce.provider.PKIXPolicyNode r14 = (org.spongycastle.jce.provider.PKIXPolicyNode) r14
            java.lang.String r15 = r14.getValidPolicy()
            boolean r15 = r15.equals(r12)
            if (r15 == 0) goto L_0x06f9
            java.lang.Object r13 = r10.get(r12)
            java.util.Set r13 = (java.util.Set) r13
            r14.f6596a = r13
            r14 = 1
            goto L_0x071a
        L_0x0719:
            r14 = 0
        L_0x071a:
            if (r14 != 0) goto L_0x07d2
            r13 = r7[r5]
            java.util.Iterator r13 = r13.iterator()
        L_0x0722:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x07d2
            java.lang.Object r14 = r13.next()
            org.spongycastle.jce.provider.PKIXPolicyNode r14 = (org.spongycastle.jce.provider.PKIXPolicyNode) r14
            java.lang.String r15 = r14.getValidPolicy()
            boolean r15 = r11.equals(r15)
            if (r15 == 0) goto L_0x0722
            org.spongycastle.asn1.ASN1Primitive r13 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r6, r2)     // Catch:{ AnnotatedException -> 0x07c9 }
            org.spongycastle.asn1.ASN1Sequence r13 = (org.spongycastle.asn1.ASN1Sequence) r13     // Catch:{ AnnotatedException -> 0x07c9 }
            java.util.Enumeration r13 = r13.t()
        L_0x0742:
            boolean r15 = r13.hasMoreElements()
            if (r15 == 0) goto L_0x077a
            java.lang.Object r15 = r13.nextElement()     // Catch:{ Exception -> 0x0771 }
            org.spongycastle.asn1.x509.PolicyInformation r15 = org.spongycastle.asn1.x509.PolicyInformation.g(r15)     // Catch:{ Exception -> 0x0771 }
            r50 = r0
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r15.Z0
            java.lang.String r0 = r0.c
            boolean r0 = r11.equals(r0)
            if (r0 == 0) goto L_0x076e
            org.spongycastle.asn1.ASN1Sequence r0 = r15.a     // Catch:{ CertPathValidatorException -> 0x0765 }
            java.util.HashSet r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.m(r0)     // Catch:{ CertPathValidatorException -> 0x0765 }
            r45 = r0
            goto L_0x077e
        L_0x0765:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Policy qualifier info set could not be decoded."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x076e:
            r0 = r50
            goto L_0x0742
        L_0x0771:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Policy information could not be decoded."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x077a:
            r50 = r0
            r45 = 0
        L_0x077e:
            java.util.Set r0 = r6.getCriticalExtensionOIDs()
            if (r0 == 0) goto L_0x078f
            java.util.Set r0 = r6.getCriticalExtensionOIDs()
            boolean r0 = r0.contains(r2)
            r47 = r0
            goto L_0x0791
        L_0x078f:
            r47 = 0
        L_0x0791:
            java.security.cert.PolicyNode r0 = r14.getParent()
            org.spongycastle.jce.provider.PKIXPolicyNode r0 = (org.spongycastle.jce.provider.PKIXPolicyNode) r0
            java.lang.String r13 = r0.getValidPolicy()
            boolean r13 = r11.equals(r13)
            if (r13 == 0) goto L_0x0851
            org.spongycastle.jce.provider.PKIXPolicyNode r13 = new org.spongycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r41 = new java.util.ArrayList
            r41.<init>()
            java.lang.Object r14 = r10.get(r12)
            r43 = r14
            java.util.Set r43 = (java.util.Set) r43
            r40 = r13
            r42 = r5
            r44 = r0
            r46 = r12
            r40.<init>(r41, r42, r43, r44, r45, r46, r47)
            java.util.List r12 = r0.f6595a
            r12.add(r13)
            r13.f6594a = r0
            r0 = r7[r5]
            r0.add(r13)
            goto L_0x0851
        L_0x07c9:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Certificate policies extension could not be decoded."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x07d2:
            r50 = r0
            goto L_0x0851
        L_0x07d6:
            r50 = r0
            if (r23 > 0) goto L_0x0851
            r0 = r7[r5]
            java.util.Iterator r0 = r0.iterator()
        L_0x07e0:
            boolean r13 = r0.hasNext()
            if (r13 == 0) goto L_0x0851
            java.lang.Object r13 = r0.next()
            org.spongycastle.jce.provider.PKIXPolicyNode r13 = (org.spongycastle.jce.provider.PKIXPolicyNode) r13
            java.lang.String r14 = r13.getValidPolicy()
            boolean r14 = r14.equals(r12)
            if (r14 == 0) goto L_0x0844
            java.security.cert.PolicyNode r14 = r13.getParent()
            org.spongycastle.jce.provider.PKIXPolicyNode r14 = (org.spongycastle.jce.provider.PKIXPolicyNode) r14
            java.util.List r14 = r14.f6595a
            r14.remove(r13)
            r0.remove()
            int r13 = r5 + -1
        L_0x0806:
            if (r13 < 0) goto L_0x0844
            r14 = r7[r13]
            r17 = r0
            r18 = r2
            r0 = r24
            r15 = 0
        L_0x0811:
            int r2 = r14.size()
            if (r15 >= r2) goto L_0x0837
            java.lang.Object r2 = r14.get(r15)
            org.spongycastle.jce.provider.PKIXPolicyNode r2 = (org.spongycastle.jce.provider.PKIXPolicyNode) r2
            r19 = r5
            java.util.List r5 = r2.f6595a
            boolean r5 = r5.isEmpty()
            r24 = 1
            r5 = r5 ^ 1
            if (r5 != 0) goto L_0x0832
            org.spongycastle.jce.provider.PKIXPolicyNode r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.p(r0, r7, r2)
            if (r0 != 0) goto L_0x0832
            goto L_0x0839
        L_0x0832:
            int r15 = r15 + 1
            r5 = r19
            goto L_0x0811
        L_0x0837:
            r19 = r5
        L_0x0839:
            r24 = r0
            int r13 = r13 + -1
            r0 = r17
            r2 = r18
            r5 = r19
            goto L_0x0806
        L_0x0844:
            r17 = r0
            r18 = r2
            r19 = r5
            r0 = r17
            r2 = r18
            r5 = r19
            goto L_0x07e0
        L_0x0851:
            r18 = r2
            r19 = r5
            r2 = r18
            r5 = r19
            r0 = r50
            goto L_0x06e5
        L_0x085d:
            r50 = r0
            r0 = r49
            org.spongycastle.jce.provider.RFC3280CertPathUtilities.c(r1, r4, r0)
            java.util.List r2 = r54.getCertificates()
            java.lang.Object r2 = r2.get(r4)
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            boolean r2 = org.spongycastle.jce.provider.CertPathValidatorUtilities.o(r2)
            if (r2 != 0) goto L_0x0878
            if (r21 == 0) goto L_0x0878
            int r21 = r21 + -1
        L_0x0878:
            r2 = r21
            java.util.List r5 = r54.getCertificates()
            java.lang.Object r5 = r5.get(r4)
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5
            boolean r5 = org.spongycastle.jce.provider.CertPathValidatorUtilities.o(r5)
            if (r5 != 0) goto L_0x088e
            if (r23 == 0) goto L_0x088e
            int r23 = r23 + -1
        L_0x088e:
            r5 = r23
            java.util.List r6 = r54.getCertificates()
            java.lang.Object r6 = r6.get(r4)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            boolean r6 = org.spongycastle.jce.provider.CertPathValidatorUtilities.o(r6)
            if (r6 != 0) goto L_0x08a4
            if (r22 == 0) goto L_0x08a4
            int r22 = r22 + -1
        L_0x08a4:
            r6 = r22
            int r2 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.d(r1, r4, r2)
            int r5 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.e(r1, r4, r5)
            java.util.List r8 = r54.getCertificates()
            java.lang.Object r8 = r8.get(r4)
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8
            java.lang.String r10 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.c     // Catch:{ Exception -> 0x0959 }
            org.spongycastle.asn1.ASN1Primitive r8 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r8, r10)     // Catch:{ Exception -> 0x0959 }
            org.spongycastle.asn1.ASN1Integer r8 = org.spongycastle.asn1.ASN1Integer.q(r8)     // Catch:{ Exception -> 0x0959 }
            if (r8 == 0) goto L_0x08cf
            java.math.BigInteger r8 = r8.t()
            int r8 = r8.intValue()
            if (r8 >= r6) goto L_0x08cf
            r6 = r8
        L_0x08cf:
            org.spongycastle.jce.provider.RFC3280CertPathUtilities.f(r1, r4)
            r8 = r34
            int r8 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.g(r1, r4, r8)
            int r8 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.h(r1, r4, r8)
            org.spongycastle.jce.provider.RFC3280CertPathUtilities.i(r1, r4)
            java.util.Set r12 = r3.getCriticalExtensionOIDs()
            if (r12 == 0) goto L_0x091b
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>(r12)
            java.lang.String r12 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.l
            r13.remove(r12)
            java.lang.String r12 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.a
            r13.remove(r12)
            java.lang.String r12 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.b
            r13.remove(r12)
            r13.remove(r10)
            java.lang.String r10 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.d
            r13.remove(r10)
            java.lang.String r10 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.e
            r13.remove(r10)
            java.lang.String r10 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.f
            r13.remove(r10)
            java.lang.String r10 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.g
            r13.remove(r10)
            java.lang.String r10 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.i
            r13.remove(r10)
            java.lang.String r10 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.j
            r13.remove(r10)
            goto L_0x0920
        L_0x091b:
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
        L_0x0920:
            r10 = r39
            org.spongycastle.jce.provider.RFC3280CertPathUtilities.j(r4, r1, r10, r13)
            javax.security.auth.x500.X500Principal r12 = r3.getSubjectX500Principal()
            byte[] r12 = r12.getEncoded()
            org.spongycastle.asn1.x500.X500Name r12 = org.spongycastle.asn1.x500.X500Name.g(r12)
            java.util.List r13 = r54.getCertificates()     // Catch:{ CertPathValidatorException -> 0x0950 }
            r14 = r25
            java.security.PublicKey r13 = org.spongycastle.jce.provider.CertPathValidatorUtilities.l(r13, r4, r14)     // Catch:{ CertPathValidatorException -> 0x0950 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r14 = org.spongycastle.jce.provider.CertPathValidatorUtilities.f(r13)
            r14.getClass()
            r21 = r2
            r26 = r3
            r23 = r5
            r22 = r6
            r2 = r8
            r8 = r12
            r12 = r13
            r5 = r33
            goto L_0x0985
        L_0x0950:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Next working key could not be retrieved."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0959:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Inhibit any-policy extension cannot be decoded."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0962:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r5 = r33
            r2.<init>(r5, r0, r1, r4)
            throw r2
        L_0x096b:
            r0 = move-exception
            r5 = r33
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r2.<init>(r5, r0, r1, r4)
            throw r2
        L_0x0974:
            r50 = r0
            r3 = r27
        L_0x0978:
            r5 = r33
            r8 = r34
            r10 = r39
            r0 = r49
            r2 = r8
            r12 = r18
            r8 = r19
        L_0x0985:
            int r13 = r4 + -1
            r27 = r0
            r17 = r3
            r3 = r5
            r25 = r7
            r15 = r10
            r4 = r31
            r5 = r32
            r7 = r35
            r0 = r36
            r14 = r37
            r6 = r50
            r16 = -1
            r10 = r2
            r2 = r30
            goto L_0x018e
        L_0x09a2:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r3 = r31
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x09ab:
            r0 = move-exception
            r3 = r31
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x09b4:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Subject alternative name extension could not be decoded."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x09bd:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Subtree check for certificate subject failed."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x09c6:
            r0 = move-exception
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = "Exception extracting subject name when checking subtrees."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x09cf:
            r19 = r8
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "IssuerName("
            r2.<init>(r3)
            org.spongycastle.asn1.x500.X500Name r3 = org.spongycastle.jce.provider.PrincipalUtils.a(r10)
            r2.append(r3)
            java.lang.String r3 = ") does not match SubjectName("
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = ") of signing certificate."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            r0.<init>(r2, r3, r1, r4)
            throw r0
        L_0x09f7:
            r0 = move-exception
            r4 = r13
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Could not validate time of certificate."
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0a01:
            r0 = move-exception
            r4 = r13
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r5 = r16
            r3.<init>(r5)
            java.lang.String r5 = r0.getMessage()
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0a1b:
            r0 = move-exception
            r4 = r13
            r5 = r16
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r5)
            java.lang.String r5 = r0.getMessage()
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0a35:
            r0 = move-exception
            goto L_0x01c6
        L_0x0a38:
            r0 = move-exception
            r4 = r13
            org.spongycastle.jce.provider.AnnotatedException r2 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x0a45 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ AnnotatedException -> 0x0a45 }
            r3 = 0
            r2.<init>(r0, r3)     // Catch:{ AnnotatedException -> 0x0a45 }
            throw r2     // Catch:{ AnnotatedException -> 0x0a45 }
        L_0x0a45:
            r0 = move-exception
            goto L_0x0a51
        L_0x0a47:
            r4 = r13
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x0a45 }
            r2 = r30
            r3 = 0
            r0.<init>(r2, r3)     // Catch:{ AnnotatedException -> 0x0a45 }
            throw r0     // Catch:{ AnnotatedException -> 0x0a45 }
        L_0x0a51:
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = r0.getMessage()
            java.lang.Throwable r0 = r0.a
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0a5d:
            r35 = r7
            r4 = r13
            r37 = r14
            r10 = r15
            r7 = r25
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.a
            boolean r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.o(r17)
            if (r0 != 0) goto L_0x0a71
            if (r21 == 0) goto L_0x0a71
            int r21 = r21 + -1
        L_0x0a71:
            r14 = r21
            int r13 = r4 + 1
            java.util.List r0 = r54.getCertificates()
            java.lang.Object r0 = r0.get(r13)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.lang.String r2 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.f     // Catch:{ AnnotatedException -> 0x0cc0 }
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r0, r2)     // Catch:{ AnnotatedException -> 0x0cc0 }
            org.spongycastle.asn1.ASN1Sequence r0 = org.spongycastle.asn1.ASN1Sequence.q(r0)     // Catch:{ AnnotatedException -> 0x0cc0 }
            if (r0 == 0) goto L_0x0aba
            java.util.Enumeration r0 = r0.t()
        L_0x0a8f:
            boolean r2 = r0.hasMoreElements()
            if (r2 == 0) goto L_0x0aba
            java.lang.Object r2 = r0.nextElement()
            org.spongycastle.asn1.ASN1TaggedObject r2 = (org.spongycastle.asn1.ASN1TaggedObject) r2
            int r3 = r2.c
            if (r3 == 0) goto L_0x0aa0
            goto L_0x0a8f
        L_0x0aa0:
            r3 = 0
            org.spongycastle.asn1.ASN1Integer r2 = org.spongycastle.asn1.ASN1Integer.r(r2, r3)     // Catch:{ Exception -> 0x0ab1 }
            java.math.BigInteger r2 = r2.t()     // Catch:{ Exception -> 0x0ab1 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0ab1 }
            if (r2 != 0) goto L_0x0a8f
            r14 = r3
            goto L_0x0abb
        L_0x0ab1:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Policy constraints requireExplicitPolicy field could not be decoded."
            r2.<init>(r3, r0, r1, r13)
            throw r2
        L_0x0aba:
            r3 = 0
        L_0x0abb:
            java.util.Set r0 = r17.getCriticalExtensionOIDs()
            if (r0 == 0) goto L_0x0b05
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.l
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.a
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.b
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.c
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.d
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.e
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.f
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.g
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.i
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.j
            r2.remove(r0)
            java.lang.String r0 = org.spongycastle.jce.provider.RFC3280CertPathUtilities.h
            r2.remove(r0)
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.x509.Extension.p1
            java.lang.String r0 = r0.c
            r2.remove(r0)
            goto L_0x0b0a
        L_0x0b05:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
        L_0x0b0a:
            java.util.List r0 = r54.getCertificates()
            java.lang.Object r0 = r0.get(r13)
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            java.util.Iterator r5 = r10.iterator()
        L_0x0b18:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0b31
            java.lang.Object r6 = r5.next()     // Catch:{ CertPathValidatorException -> 0x0b28 }
            java.security.cert.PKIXCertPathChecker r6 = (java.security.cert.PKIXCertPathChecker) r6     // Catch:{ CertPathValidatorException -> 0x0b28 }
            r6.check(r0, r2)     // Catch:{ CertPathValidatorException -> 0x0b28 }
            goto L_0x0b18
        L_0x0b28:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Additional certificate path checker failed."
            r2.<init>(r3, r0, r1, r13)
            throw r2
        L_0x0b31:
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0cab
            java.util.List r0 = r54.getCertificates()
            int r0 = r0.size()
            java.lang.String r2 = "Explicit policy requested but none available."
            if (r24 != 0) goto L_0x0b53
            boolean r0 = r37.isExplicitPolicyRequired()
            if (r0 != 0) goto L_0x0b4c
            r6 = 0
            goto L_0x0c91
        L_0x0b4c:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r3 = 0
            r0.<init>(r2, r3, r1, r13)
            throw r0
        L_0x0b53:
            org.spongycastle.jce.provider.PKIXCRLUtil r5 = org.spongycastle.jce.provider.CertPathValidatorUtilities.f6569a
            r5 = r29
            if (r29 == 0) goto L_0x0b68
            boolean r6 = r5.contains(r11)
            if (r6 != 0) goto L_0x0b68
            boolean r6 = r5.isEmpty()
            if (r6 == 0) goto L_0x0b66
            goto L_0x0b68
        L_0x0b66:
            r6 = r3
            goto L_0x0b69
        L_0x0b68:
            r6 = 1
        L_0x0b69:
            if (r6 == 0) goto L_0x0c00
            boolean r5 = r37.isExplicitPolicyRequired()
            if (r5 == 0) goto L_0x0bfc
            boolean r5 = r9.isEmpty()
            if (r5 != 0) goto L_0x0bf5
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r5 = r3
            r6 = r28
        L_0x0b7f:
            if (r5 >= r6) goto L_0x0bb2
            r8 = r7[r5]
            r10 = r3
        L_0x0b84:
            int r12 = r8.size()
            if (r10 >= r12) goto L_0x0baf
            java.lang.Object r12 = r8.get(r10)
            org.spongycastle.jce.provider.PKIXPolicyNode r12 = (org.spongycastle.jce.provider.PKIXPolicyNode) r12
            java.lang.String r13 = r12.getValidPolicy()
            boolean r13 = r11.equals(r13)
            if (r13 == 0) goto L_0x0bac
            java.util.Iterator r12 = r12.getChildren()
        L_0x0b9e:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0bac
            java.lang.Object r13 = r12.next()
            r2.add(r13)
            goto L_0x0b9e
        L_0x0bac:
            int r10 = r10 + 1
            goto L_0x0b84
        L_0x0baf:
            int r5 = r5 + 1
            goto L_0x0b7f
        L_0x0bb2:
            java.util.Iterator r2 = r2.iterator()
        L_0x0bb6:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x0bca
            java.lang.Object r5 = r2.next()
            org.spongycastle.jce.provider.PKIXPolicyNode r5 = (org.spongycastle.jce.provider.PKIXPolicyNode) r5
            java.lang.String r5 = r5.getValidPolicy()
            r9.contains(r5)
            goto L_0x0bb6
        L_0x0bca:
            r5 = 1
            int r0 = r0 - r5
        L_0x0bcc:
            if (r0 < 0) goto L_0x0bfc
            r2 = r7[r0]
            r5 = r3
            r6 = r24
        L_0x0bd3:
            int r8 = r2.size()
            if (r5 >= r8) goto L_0x0bf0
            java.lang.Object r8 = r2.get(r5)
            org.spongycastle.jce.provider.PKIXPolicyNode r8 = (org.spongycastle.jce.provider.PKIXPolicyNode) r8
            java.util.List r9 = r8.f6595a
            boolean r9 = r9.isEmpty()
            r10 = 1
            r9 = r9 ^ r10
            if (r9 != 0) goto L_0x0bed
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = org.spongycastle.jce.provider.CertPathValidatorUtilities.p(r6, r7, r8)
        L_0x0bed:
            int r5 = r5 + 1
            goto L_0x0bd3
        L_0x0bf0:
            int r0 = r0 + -1
            r24 = r6
            goto L_0x0bcc
        L_0x0bf5:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            r3 = 0
            r0.<init>(r2, r3, r1, r13)
            throw r0
        L_0x0bfc:
            r6 = r24
            goto L_0x0c91
        L_0x0c00:
            r6 = r28
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            r8 = r3
        L_0x0c08:
            if (r8 >= r6) goto L_0x0c47
            r9 = r7[r8]
            r10 = r3
        L_0x0c0d:
            int r12 = r9.size()
            if (r10 >= r12) goto L_0x0c44
            java.lang.Object r12 = r9.get(r10)
            org.spongycastle.jce.provider.PKIXPolicyNode r12 = (org.spongycastle.jce.provider.PKIXPolicyNode) r12
            java.lang.String r13 = r12.getValidPolicy()
            boolean r13 = r11.equals(r13)
            if (r13 == 0) goto L_0x0c41
            java.util.Iterator r12 = r12.getChildren()
        L_0x0c27:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x0c41
            java.lang.Object r13 = r12.next()
            org.spongycastle.jce.provider.PKIXPolicyNode r13 = (org.spongycastle.jce.provider.PKIXPolicyNode) r13
            java.lang.String r15 = r13.getValidPolicy()
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x0c27
            r2.add(r13)
            goto L_0x0c27
        L_0x0c41:
            int r10 = r10 + 1
            goto L_0x0c0d
        L_0x0c44:
            int r8 = r8 + 1
            goto L_0x0c08
        L_0x0c47:
            java.util.Iterator r2 = r2.iterator()
            r6 = r24
        L_0x0c4d:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0c68
            java.lang.Object r8 = r2.next()
            org.spongycastle.jce.provider.PKIXPolicyNode r8 = (org.spongycastle.jce.provider.PKIXPolicyNode) r8
            java.lang.String r9 = r8.getValidPolicy()
            boolean r9 = r5.contains(r9)
            if (r9 != 0) goto L_0x0c4d
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = org.spongycastle.jce.provider.CertPathValidatorUtilities.p(r6, r7, r8)
            goto L_0x0c4d
        L_0x0c68:
            if (r6 == 0) goto L_0x0c91
            r2 = 1
            int r0 = r0 - r2
        L_0x0c6c:
            if (r0 < 0) goto L_0x0c91
            r2 = r7[r0]
            r5 = r3
        L_0x0c71:
            int r8 = r2.size()
            if (r5 >= r8) goto L_0x0c8e
            java.lang.Object r8 = r2.get(r5)
            org.spongycastle.jce.provider.PKIXPolicyNode r8 = (org.spongycastle.jce.provider.PKIXPolicyNode) r8
            java.util.List r9 = r8.f6595a
            boolean r9 = r9.isEmpty()
            r10 = 1
            r9 = r9 ^ r10
            if (r9 != 0) goto L_0x0c8b
            org.spongycastle.jce.provider.PKIXPolicyNode r6 = org.spongycastle.jce.provider.CertPathValidatorUtilities.p(r6, r7, r8)
        L_0x0c8b:
            int r5 = r5 + 1
            goto L_0x0c71
        L_0x0c8e:
            int r0 = r0 + -1
            goto L_0x0c6c
        L_0x0c91:
            if (r14 > 0) goto L_0x0c9f
            if (r6 == 0) goto L_0x0c96
            goto L_0x0c9f
        L_0x0c96:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "Path processing failed on policy."
            r3 = 0
            r0.<init>(r2, r3, r1, r4)
            throw r0
        L_0x0c9f:
            java.security.cert.PKIXCertPathValidatorResult r0 = new java.security.cert.PKIXCertPathValidatorResult
            java.security.PublicKey r1 = r17.getPublicKey()
            r2 = r35
            r0.<init>(r2, r6, r1)
            return r0
        L_0x0cab:
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Certificate has unsupported critical extension: "
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r3 = 0
            r0.<init>(r2, r3, r1, r13)
            throw r0
        L_0x0cc0:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Policy constraints could not be decoded."
            r2.<init>(r3, r0, r1, r13)
            throw r2
        L_0x0cc9:
            r0 = move-exception
            r2 = r0
            org.spongycastle.jce.exception.ExtCertPathValidatorException r0 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Algorithm identifier of public key of trust anchor could not be read."
            r4 = -1
            r0.<init>(r3, r2, r1, r4)
            throw r0
        L_0x0cd4:
            r0 = move-exception
            org.spongycastle.jce.exception.ExtCertPathValidatorException r2 = new org.spongycastle.jce.exception.ExtCertPathValidatorException
            java.lang.String r3 = "Subject of trust anchor could not be (re)encoded."
            r4 = -1
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0cde:
            r0 = move-exception
            goto L_0x0084
        L_0x0ce1:
            r0 = move-exception
            r32 = r5
            org.spongycastle.jce.provider.AnnotatedException r2 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x0cef }
            java.lang.String r0 = r0.getMessage()     // Catch:{ AnnotatedException -> 0x0cef }
            r3 = 0
            r2.<init>(r0, r3)     // Catch:{ AnnotatedException -> 0x0cef }
            throw r2     // Catch:{ AnnotatedException -> 0x0cef }
        L_0x0cef:
            r0 = move-exception
            goto L_0x0d06
        L_0x0cf1:
            r32 = r5
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x0cef }
            r3 = 0
            r0.<init>(r2, r3)     // Catch:{ AnnotatedException -> 0x0cef }
            throw r0     // Catch:{ AnnotatedException -> 0x0cef }
        L_0x0cfa:
            r32 = r5
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException     // Catch:{ AnnotatedException -> 0x0cef }
            java.lang.String r2 = "Trust anchor for certification path not found."
            r3 = -1
            r4 = 0
            r0.<init>(r2, r4, r1, r3)     // Catch:{ AnnotatedException -> 0x0cef }
            throw r0     // Catch:{ AnnotatedException -> 0x0cef }
        L_0x0d06:
            java.security.cert.CertPathValidatorException r2 = new java.security.cert.CertPathValidatorException
            java.lang.String r3 = r0.getMessage()
            int r4 = r32.size()
            r5 = 1
            int r4 = r4 - r5
            java.lang.Throwable r0 = r0.a
            r2.<init>(r3, r0, r1, r4)
            throw r2
        L_0x0d18:
            java.security.cert.CertPathValidatorException r0 = new java.security.cert.CertPathValidatorException
            java.lang.String r2 = "Certification path is empty."
            r3 = -1
            r4 = 0
            r0.<init>(r2, r4, r1, r3)
            throw r0
        L_0x0d22:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.String r1 = "trustAnchors is null, this is not allowed for certification path validation."
            r0.<init>(r1)
            throw r0
        L_0x0d2a:
            java.security.InvalidAlgorithmParameterException r0 = new java.security.InvalidAlgorithmParameterException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Parameters must be a "
            r1.<init>(r2)
            java.lang.Class<java.security.cert.PKIXParameters> r2 = java.security.cert.PKIXParameters.class
            java.lang.String r2 = r2.getName()
            r1.append(r2)
            java.lang.String r2 = " instance."
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXCertPathValidatorSpi.engineValidate(java.security.cert.CertPath, java.security.cert.CertPathParameters):java.security.cert.CertPathValidatorResult");
    }
}
