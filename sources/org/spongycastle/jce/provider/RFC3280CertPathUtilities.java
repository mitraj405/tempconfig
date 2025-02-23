package org.spongycastle.jce.provider;

import com.google.firebase.ktx.BuildConfig;
import java.io.IOException;
import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.BasicConstraints;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.DistributionPointName;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.GeneralSubtree;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;
import org.spongycastle.asn1.x509.NameConstraints;
import org.spongycastle.asn1.x509.ReasonFlags;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.exception.ExtCertPathValidatorException;
import org.spongycastle.util.Arrays;

class RFC3280CertPathUtilities {
    public static final String a = Extension.l1.c;

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f6598a = {BuildConfig.VERSION_NAME, "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise"};
    public static final String b = Extension.m1.c;
    public static final String c = Extension.r1.c;
    public static final String d = Extension.h1.c;
    public static final String e = Extension.g1.c;
    public static final String f = Extension.o1.c;
    public static final String g = Extension.d1.c;
    public static final String h = Extension.k1.c;
    public static final String i = Extension.b1.c;
    public static final String j = Extension.j1.c;
    public static final String k = Extension.n1.c;
    public static final String l = Extension.a1.c;

    static {
        new PKIXCRLUtil();
        Extension.q1.getClass();
        Extension.e1.getClass();
    }

    public static void a(DistributionPoint distributionPoint, PKIXExtendedParameters pKIXExtendedParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, CertStatus certStatus, ReasonsMask reasonsMask, List list, BCJcaJceHelper bCJcaJceHelper) throws AnnotatedException {
        Set<String> criticalExtensionOIDs;
        DistributionPoint distributionPoint2 = distributionPoint;
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        X509Certificate x509Certificate3 = x509Certificate;
        Date date2 = date;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        if (date.getTime() <= new Date(System.currentTimeMillis()).getTime()) {
            Iterator it = CertPathValidatorUtilities.i(distributionPoint2, x509Certificate3, pKIXExtendedParameters2).iterator();
            AnnotatedException e2 = null;
            boolean z = false;
            while (it.hasNext() && certStatus2.a == 11 && !reasonsMask.a()) {
                try {
                    X509CRL x509crl = (X509CRL) it.next();
                    ReasonsMask n = n(x509crl, distributionPoint2);
                    int i2 = n.f6599a;
                    if ((i2 | (reasonsMask2.f6599a ^ i2)) != 0) {
                        ReasonsMask reasonsMask3 = n;
                        X509CRL x509crl2 = x509crl;
                        PublicKey p = p(x509crl2, o(x509crl, x509Certificate2, publicKey, pKIXExtendedParameters, list, bCJcaJceHelper));
                        pKIXExtendedParameters.b();
                        Date b2 = pKIXExtendedParameters.b();
                        boolean z2 = pKIXExtendedParameters2.f6329b;
                        X509CRL q = z2 ? q(CertPathValidatorUtilities.j(b2, x509crl2, pKIXExtendedParameters.a(), pKIXExtendedParameters2.b), p) : null;
                        if (pKIXExtendedParameters2.c != 1) {
                            if (x509Certificate.getNotAfter().getTime() < x509crl2.getThisUpdate().getTime()) {
                                throw new AnnotatedException("No valid CRL for current time found.", (Exception) null);
                            }
                        }
                        k(distributionPoint2, x509Certificate3, x509crl2);
                        l(distributionPoint2, x509Certificate3, x509crl2);
                        m(q, x509crl2, pKIXExtendedParameters2);
                        if (z2 && q != null) {
                            CertPathValidatorUtilities.h(date2, q, x509Certificate3, certStatus2);
                        }
                        if (certStatus2.a == 11) {
                            CertPathValidatorUtilities.h(date2, x509crl2, x509Certificate3, certStatus2);
                        }
                        if (certStatus2.a == 8) {
                            certStatus2.a = 11;
                        }
                        reasonsMask2.f6599a |= reasonsMask3.f6599a;
                        Set<String> criticalExtensionOIDs2 = x509crl2.getCriticalExtensionOIDs();
                        if (criticalExtensionOIDs2 != null) {
                            HashSet hashSet = new HashSet(criticalExtensionOIDs2);
                            hashSet.remove(Extension.h1.c);
                            hashSet.remove(Extension.g1.c);
                            if (!hashSet.isEmpty()) {
                                throw new AnnotatedException("CRL contains unsupported critical extensions.", (Exception) null);
                            }
                        }
                        if (!(q == null || (criticalExtensionOIDs = q.getCriticalExtensionOIDs()) == null)) {
                            HashSet hashSet2 = new HashSet(criticalExtensionOIDs);
                            hashSet2.remove(Extension.h1.c);
                            hashSet2.remove(Extension.g1.c);
                            if (!hashSet2.isEmpty()) {
                                throw new AnnotatedException("Delta CRL contains unsupported critical extension.", (Exception) null);
                            }
                        }
                        z = true;
                    }
                } catch (AnnotatedException e3) {
                    e2 = e3;
                }
            }
            if (!z) {
                throw e2;
            }
            return;
        }
        throw new AnnotatedException("Validation time is in future.", (Exception) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(org.spongycastle.jcajce.PKIXExtendedParameters r20, java.security.cert.X509Certificate r21, java.util.Date r22, java.security.cert.X509Certificate r23, java.security.PublicKey r24, java.util.List r25, org.spongycastle.jcajce.util.BCJcaJceHelper r26) throws org.spongycastle.jce.provider.AnnotatedException {
        /*
            r1 = r20
            java.lang.String r0 = h     // Catch:{ Exception -> 0x0163 }
            r12 = r21
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.k(r12, r0)     // Catch:{ Exception -> 0x0163 }
            org.spongycastle.asn1.x509.CRLDistPoint r0 = org.spongycastle.asn1.x509.CRLDistPoint.h(r0)     // Catch:{ Exception -> 0x0163 }
            org.spongycastle.jcajce.PKIXExtendedParameters$Builder r2 = new org.spongycastle.jcajce.PKIXExtendedParameters$Builder
            r2.<init>((org.spongycastle.jcajce.PKIXExtendedParameters) r1)
            java.util.Map<org.spongycastle.asn1.x509.GeneralName, org.spongycastle.jcajce.PKIXCRLStore> r3 = r1.f6328b     // Catch:{ AnnotatedException -> 0x015a }
            java.util.List r3 = org.spongycastle.jce.provider.CertPathValidatorUtilities.e(r0, r3)     // Catch:{ AnnotatedException -> 0x015a }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ AnnotatedException -> 0x015a }
        L_0x001d:
            boolean r4 = r3.hasNext()     // Catch:{ AnnotatedException -> 0x015a }
            if (r4 == 0) goto L_0x002f
            java.lang.Object r4 = r3.next()     // Catch:{ AnnotatedException -> 0x015a }
            org.spongycastle.jcajce.PKIXCRLStore r4 = (org.spongycastle.jcajce.PKIXCRLStore) r4     // Catch:{ AnnotatedException -> 0x015a }
            java.util.ArrayList r5 = r2.b     // Catch:{ AnnotatedException -> 0x015a }
            r5.add(r4)     // Catch:{ AnnotatedException -> 0x015a }
            goto L_0x001d
        L_0x002f:
            org.spongycastle.jce.provider.CertStatus r13 = new org.spongycastle.jce.provider.CertStatus
            r13.<init>()
            org.spongycastle.jce.provider.ReasonsMask r14 = new org.spongycastle.jce.provider.ReasonsMask
            r14.<init>()
            org.spongycastle.jcajce.PKIXExtendedParameters r15 = new org.spongycastle.jcajce.PKIXExtendedParameters
            r15.<init>(r2)
            r2 = 0
            r16 = 1
            r3 = 0
            r11 = 11
            if (r0 == 0) goto L_0x0093
            org.spongycastle.asn1.x509.DistributionPoint[] r10 = r0.g()     // Catch:{ Exception -> 0x0089 }
            r9 = r2
            r17 = r9
            r0 = r3
        L_0x004e:
            int r2 = r10.length
            if (r9 >= r2) goto L_0x0087
            int r2 = r13.a
            if (r2 != r11) goto L_0x0087
            boolean r2 = r14.a()
            if (r2 != 0) goto L_0x0087
            r2 = r10[r9]     // Catch:{ AnnotatedException -> 0x0079 }
            r3 = r15
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r13
            r18 = r9
            r9 = r14
            r19 = r10
            r10 = r25
            r12 = r11
            r11 = r26
            a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ AnnotatedException -> 0x0077 }
            r17 = r16
            goto L_0x007f
        L_0x0077:
            r0 = move-exception
            goto L_0x007f
        L_0x0079:
            r0 = move-exception
            r18 = r9
            r19 = r10
            r12 = r11
        L_0x007f:
            int r9 = r18 + 1
            r11 = r12
            r10 = r19
            r12 = r21
            goto L_0x004e
        L_0x0087:
            r12 = r11
            goto L_0x0097
        L_0x0089:
            r0 = move-exception
            r1 = r0
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "Distribution points could not be read."
            r0.<init>(r2, r1)
            throw r0
        L_0x0093:
            r12 = r11
            r0 = 0
            r17 = r2
        L_0x0097:
            int r2 = r13.a
            if (r2 != r12) goto L_0x00eb
            boolean r2 = r14.a()
            if (r2 != 0) goto L_0x00eb
            org.spongycastle.asn1.ASN1InputStream r2 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ Exception -> 0x00e1 }
            org.spongycastle.asn1.x500.X500Name r3 = org.spongycastle.jce.provider.PrincipalUtils.a(r21)     // Catch:{ Exception -> 0x00e1 }
            byte[] r3 = r3.e()     // Catch:{ Exception -> 0x00e1 }
            r2.<init>((byte[]) r3)     // Catch:{ Exception -> 0x00e1 }
            org.spongycastle.asn1.ASN1Primitive r2 = r2.j()     // Catch:{ Exception -> 0x00e1 }
            org.spongycastle.asn1.x509.DistributionPoint r3 = new org.spongycastle.asn1.x509.DistributionPoint     // Catch:{ AnnotatedException -> 0x00ea }
            org.spongycastle.asn1.x509.DistributionPointName r4 = new org.spongycastle.asn1.x509.DistributionPointName     // Catch:{ AnnotatedException -> 0x00ea }
            org.spongycastle.asn1.x509.GeneralNames r5 = new org.spongycastle.asn1.x509.GeneralNames     // Catch:{ AnnotatedException -> 0x00ea }
            org.spongycastle.asn1.x509.GeneralName r6 = new org.spongycastle.asn1.x509.GeneralName     // Catch:{ AnnotatedException -> 0x00ea }
            r7 = 4
            r6.<init>(r7, r2)     // Catch:{ AnnotatedException -> 0x00ea }
            r5.<init>((org.spongycastle.asn1.x509.GeneralName) r6)     // Catch:{ AnnotatedException -> 0x00ea }
            r4.<init>((org.spongycastle.asn1.x509.GeneralNames) r5)     // Catch:{ AnnotatedException -> 0x00ea }
            r3.<init>((org.spongycastle.asn1.x509.DistributionPointName) r4)     // Catch:{ AnnotatedException -> 0x00ea }
            java.lang.Object r1 = r20.clone()     // Catch:{ AnnotatedException -> 0x00ea }
            r2 = r1
            org.spongycastle.jcajce.PKIXExtendedParameters r2 = (org.spongycastle.jcajce.PKIXExtendedParameters) r2     // Catch:{ AnnotatedException -> 0x00ea }
            r1 = r3
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r13
            r8 = r14
            r9 = r25
            r10 = r26
            a(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ AnnotatedException -> 0x00ea }
            goto L_0x00ed
        L_0x00e1:
            r0 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r1 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00ea }
            java.lang.String r2 = "Issuer from certificate for CRL could not be reencoded."
            r1.<init>(r2, r0)     // Catch:{ AnnotatedException -> 0x00ea }
            throw r1     // Catch:{ AnnotatedException -> 0x00ea }
        L_0x00ea:
            r0 = move-exception
        L_0x00eb:
            r16 = r17
        L_0x00ed:
            if (r16 != 0) goto L_0x00fc
            boolean r1 = r0 instanceof org.spongycastle.jce.provider.AnnotatedException
            if (r1 == 0) goto L_0x00f4
            throw r0
        L_0x00f4:
            org.spongycastle.jce.provider.AnnotatedException r1 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "No valid CRL found."
            r1.<init>(r2, r0)
            throw r1
        L_0x00fc:
            int r0 = r13.a
            if (r0 != r12) goto L_0x011c
            boolean r0 = r14.a()
            r1 = 12
            if (r0 != 0) goto L_0x010e
            int r0 = r13.a
            if (r0 != r12) goto L_0x010e
            r13.a = r1
        L_0x010e:
            int r0 = r13.a
            if (r0 == r1) goto L_0x0113
            return
        L_0x0113:
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r1 = "Certificate status could not be determined."
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        L_0x011c:
            r0 = 0
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss Z"
            r1.<init>(r2)
            java.lang.String r2 = "UTC"
            java.util.TimeZone r2 = java.util.TimeZone.getTimeZone(r2)
            r1.setTimeZone(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Certificate revocation after "
            r2.<init>(r3)
            java.util.Date r3 = r13.f6570a
            java.lang.String r1 = r1.format(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = ", reason: "
            java.lang.StringBuilder r1 = defpackage.lf.n(r1, r2)
            int r2 = r13.a
            java.lang.String[] r3 = f6598a
            r2 = r3[r2]
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            org.spongycastle.jce.provider.AnnotatedException r2 = new org.spongycastle.jce.provider.AnnotatedException
            r2.<init>(r1, r0)
            throw r2
        L_0x015a:
            r0 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r1 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "No additional CRL locations could be decoded from CRL distribution point extension."
            r1.<init>(r2, r0)
            throw r1
        L_0x0163:
            r0 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r1 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r2 = "CRL distribution point extension could not be read."
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.RFC3280CertPathUtilities.b(org.spongycastle.jcajce.PKIXExtendedParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.List, org.spongycastle.jcajce.util.BCJcaJceHelper):void");
    }

    public static void c(CertPath certPath, int i2, PKIXNameConstraintValidator pKIXNameConstraintValidator) throws CertPathValidatorException {
        NameConstraints nameConstraints;
        GeneralSubtree[] generalSubtreeArr;
        try {
            ASN1Sequence q = ASN1Sequence.q(CertPathValidatorUtilities.k((X509Certificate) certPath.getCertificates().get(i2), j));
            GeneralSubtree[] generalSubtreeArr2 = null;
            if (q == null) {
                nameConstraints = null;
            } else if (q instanceof NameConstraints) {
                nameConstraints = (NameConstraints) q;
            } else {
                nameConstraints = new NameConstraints(ASN1Sequence.q(q));
            }
            if (nameConstraints != null) {
                int i3 = 0;
                GeneralSubtree[] generalSubtreeArr3 = nameConstraints.a;
                if (generalSubtreeArr3 != null) {
                    int length = generalSubtreeArr3.length;
                    generalSubtreeArr = new GeneralSubtree[length];
                    System.arraycopy(generalSubtreeArr3, 0, generalSubtreeArr, 0, length);
                } else {
                    generalSubtreeArr = null;
                }
                if (generalSubtreeArr != null) {
                    try {
                        pKIXNameConstraintValidator.j(generalSubtreeArr);
                    } catch (Exception e2) {
                        throw new ExtCertPathValidatorException("Permitted subtrees cannot be build from name constraints extension.", e2, certPath, i2);
                    }
                }
                GeneralSubtree[] generalSubtreeArr4 = nameConstraints.b;
                if (generalSubtreeArr4 != null) {
                    int length2 = generalSubtreeArr4.length;
                    GeneralSubtree[] generalSubtreeArr5 = new GeneralSubtree[length2];
                    System.arraycopy(generalSubtreeArr4, 0, generalSubtreeArr5, 0, length2);
                    generalSubtreeArr2 = generalSubtreeArr5;
                }
                if (generalSubtreeArr2 != null) {
                    while (i3 != generalSubtreeArr2.length) {
                        try {
                            pKIXNameConstraintValidator.a(generalSubtreeArr2[i3]);
                            i3++;
                        } catch (Exception e3) {
                            throw new ExtCertPathValidatorException("Excluded subtrees cannot be build from name constraints extension.", e3, certPath, i2);
                        }
                    }
                }
            }
        } catch (Exception e4) {
            throw new ExtCertPathValidatorException("Name constraints extension could not be decoded.", e4, certPath, i2);
        }
    }

    public static int d(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        try {
            ASN1Sequence q = ASN1Sequence.q(CertPathValidatorUtilities.k((X509Certificate) certPath.getCertificates().get(i2), f));
            if (q != null) {
                Enumeration t = q.t();
                while (true) {
                    if (!t.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject q2 = ASN1TaggedObject.q(t.nextElement());
                        if (q2.c == 0) {
                            int intValue = ASN1Integer.r(q2, false).t().intValue();
                            if (intValue < i3) {
                                return intValue;
                            }
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e2, certPath, i2);
                    }
                }
            }
            return i3;
        } catch (Exception e3) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e3, certPath, i2);
        }
    }

    public static int e(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        try {
            ASN1Sequence q = ASN1Sequence.q(CertPathValidatorUtilities.k((X509Certificate) certPath.getCertificates().get(i2), f));
            if (q != null) {
                Enumeration t = q.t();
                while (true) {
                    if (!t.hasMoreElements()) {
                        break;
                    }
                    try {
                        ASN1TaggedObject q2 = ASN1TaggedObject.q(t.nextElement());
                        if (q2.c == 1) {
                            int intValue = ASN1Integer.r(q2, false).t().intValue();
                            if (intValue < i3) {
                                return intValue;
                            }
                        }
                    } catch (IllegalArgumentException e2) {
                        throw new ExtCertPathValidatorException("Policy constraints extension contents cannot be decoded.", e2, certPath, i2);
                    }
                }
            }
            return i3;
        } catch (Exception e3) {
            throw new ExtCertPathValidatorException("Policy constraints extension cannot be decoded.", e3, certPath, i2);
        }
    }

    public static void f(CertPath certPath, int i2) throws CertPathValidatorException {
        try {
            BasicConstraints g2 = BasicConstraints.g(CertPathValidatorUtilities.k((X509Certificate) certPath.getCertificates().get(i2), g));
            if (g2 == null) {
                throw new CertPathValidatorException("Intermediate certificate lacks BasicConstraints");
            } else if (!g2.i()) {
                throw new CertPathValidatorException("Not a CA certificate");
            }
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e2, certPath, i2);
        }
    }

    public static int g(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        if (CertPathValidatorUtilities.o((X509Certificate) certPath.getCertificates().get(i2))) {
            return i3;
        }
        if (i3 > 0) {
            return i3 - 1;
        }
        throw new ExtCertPathValidatorException("Max path length not greater than zero", (Throwable) null, certPath, i2);
    }

    public static int h(CertPath certPath, int i2, int i3) throws CertPathValidatorException {
        BigInteger h2;
        int intValue;
        try {
            BasicConstraints g2 = BasicConstraints.g(CertPathValidatorUtilities.k((X509Certificate) certPath.getCertificates().get(i2), g));
            if (g2 == null || (h2 = g2.h()) == null || (intValue = h2.intValue()) >= i3) {
                return i3;
            }
            return intValue;
        } catch (Exception e2) {
            throw new ExtCertPathValidatorException("Basic constraints extension cannot be decoded.", e2, certPath, i2);
        }
    }

    public static void i(CertPath certPath, int i2) throws CertPathValidatorException {
        boolean[] keyUsage = ((X509Certificate) certPath.getCertificates().get(i2)).getKeyUsage();
        if (keyUsage != null && !keyUsage[5]) {
            throw new ExtCertPathValidatorException("Issuer certificate keyusage extension is critical and does not permit key signing.", (Throwable) null, certPath, i2);
        }
    }

    public static void j(int i2, CertPath certPath, List list, HashSet hashSet) throws CertPathValidatorException {
        X509Certificate x509Certificate = (X509Certificate) certPath.getCertificates().get(i2);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((PKIXCertPathChecker) it.next()).check(x509Certificate, hashSet);
            } catch (CertPathValidatorException e2) {
                throw new CertPathValidatorException(e2.getMessage(), e2.getCause(), certPath, i2);
            }
        }
        if (!hashSet.isEmpty()) {
            throw new ExtCertPathValidatorException("Certificate has unsupported critical extension: " + hashSet, (Throwable) null, certPath, i2);
        }
    }

    public static void k(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        boolean z;
        ASN1Primitive k2 = CertPathValidatorUtilities.k(x509crl, d);
        boolean z2 = true;
        if (k2 == null || !IssuingDistributionPoint.h(k2).c) {
            z = false;
        } else {
            z = true;
        }
        try {
            byte[] e2 = PrincipalUtils.b(x509crl).e();
            GeneralNames generalNames = distributionPoint.f5738a;
            if (generalNames != null) {
                GeneralName[] h2 = generalNames.h();
                boolean z3 = false;
                for (GeneralName generalName : h2) {
                    if (generalName.c == 4) {
                        try {
                            if (Arrays.a(generalName.a.b().e(), e2)) {
                                z3 = true;
                            }
                        } catch (IOException e3) {
                            throw new AnnotatedException("CRL issuer information from distribution point cannot be decoded.", e3);
                        }
                    }
                }
                if (z3 && !z) {
                    throw new AnnotatedException("Distribution point contains cRLIssuer field but CRL is not indirect.", (Exception) null);
                } else if (z3) {
                    z2 = z3;
                } else {
                    throw new AnnotatedException("CRL issuer of CRL does not match CRL issuer of distribution point.", (Exception) null);
                }
            } else if (!PrincipalUtils.b(x509crl).equals(PrincipalUtils.a(obj))) {
                z2 = false;
            }
            if (!z2) {
                throw new AnnotatedException("Cannot find matching CRL issuer for certificate.", (Exception) null);
            }
        } catch (IOException e4) {
            throw new AnnotatedException(C0709Uj.g(e4, new StringBuilder("Exception encoding CRL issuer: ")), e4);
        }
    }

    public static void l(DistributionPoint distributionPoint, Object obj, X509CRL x509crl) throws AnnotatedException {
        GeneralName[] generalNameArr;
        GeneralName[] generalNameArr2;
        try {
            IssuingDistributionPoint h2 = IssuingDistributionPoint.h(CertPathValidatorUtilities.k(x509crl, d));
            if (h2 != null) {
                if (h2.f5748a != null) {
                    DistributionPointName distributionPointName = IssuingDistributionPoint.h(h2).f5748a;
                    ArrayList arrayList = new ArrayList();
                    int i2 = distributionPointName.c;
                    boolean z = false;
                    ASN1Encodable aSN1Encodable = distributionPointName.a;
                    if (i2 == 0) {
                        GeneralName[] h3 = GeneralNames.g(aSN1Encodable).h();
                        for (GeneralName add : h3) {
                            arrayList.add(add);
                        }
                    }
                    if (distributionPointName.c == 1) {
                        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                        try {
                            Enumeration t = ASN1Sequence.q(PrincipalUtils.b(x509crl)).t();
                            while (t.hasMoreElements()) {
                                aSN1EncodableVector.a((ASN1Encodable) t.nextElement());
                            }
                            aSN1EncodableVector.a(aSN1Encodable);
                            arrayList.add(new GeneralName(X500Name.g(new DERSequence(aSN1EncodableVector))));
                        } catch (Exception e2) {
                            throw new AnnotatedException("Could not read CRL issuer.", e2);
                        }
                    }
                    DistributionPointName distributionPointName2 = distributionPoint.a;
                    GeneralNames generalNames = distributionPoint.f5738a;
                    if (distributionPointName2 != null) {
                        int i3 = distributionPointName2.c;
                        ASN1Encodable aSN1Encodable2 = distributionPointName2.a;
                        if (i3 == 0) {
                            generalNameArr = GeneralNames.g(aSN1Encodable2).h();
                        } else {
                            generalNameArr = null;
                        }
                        if (i3 == 1) {
                            if (generalNames != null) {
                                generalNameArr2 = generalNames.h();
                            } else {
                                generalNameArr2 = new GeneralName[1];
                                try {
                                    generalNameArr2[0] = new GeneralName(X500Name.g(PrincipalUtils.a(obj).e()));
                                } catch (Exception e3) {
                                    throw new AnnotatedException("Could not read certificate issuer.", e3);
                                }
                            }
                            generalNameArr = generalNameArr2;
                            for (int i4 = 0; i4 < generalNameArr.length; i4++) {
                                Enumeration t2 = ASN1Sequence.q(generalNameArr[i4].a.b()).t();
                                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                                while (t2.hasMoreElements()) {
                                    aSN1EncodableVector2.a((ASN1Encodable) t2.nextElement());
                                }
                                aSN1EncodableVector2.a(aSN1Encodable2);
                                generalNameArr[i4] = new GeneralName(X500Name.g(new DERSequence(aSN1EncodableVector2)));
                            }
                        }
                        if (generalNameArr != null) {
                            int i5 = 0;
                            while (true) {
                                if (i5 >= generalNameArr.length) {
                                    break;
                                } else if (arrayList.contains(generalNameArr[i5])) {
                                    z = true;
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.", (Exception) null);
                        }
                    } else if (generalNames != null) {
                        GeneralName[] h4 = generalNames.h();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= h4.length) {
                                break;
                            } else if (arrayList.contains(h4[i6])) {
                                z = true;
                                break;
                            } else {
                                i6++;
                            }
                        }
                        if (!z) {
                            throw new AnnotatedException("No match for certificate CRL issuing distribution point name to cRLIssuer CRL distribution point.", (Exception) null);
                        }
                    } else {
                        throw new AnnotatedException("Either the cRLIssuer or the distributionPoint field must be contained in DistributionPoint.", (Exception) null);
                    }
                }
                try {
                    BasicConstraints g2 = BasicConstraints.g(CertPathValidatorUtilities.k((X509Extension) obj, g));
                    if (obj instanceof X509Certificate) {
                        if (h2.f5750a && g2 != null && g2.i()) {
                            throw new AnnotatedException("CA Cert CRL only contains user certificates.", (Exception) null);
                        } else if (h2.b && (g2 == null || !g2.i())) {
                            throw new AnnotatedException("End CRL only contains CA certificates.", (Exception) null);
                        }
                    }
                    if (h2.d) {
                        throw new AnnotatedException("onlyContainsAttributeCerts boolean is asserted.", (Exception) null);
                    }
                } catch (Exception e4) {
                    throw new AnnotatedException("Basic constraints extension could not be decoded.", e4);
                }
            }
        } catch (Exception e5) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e5);
        }
    }

    public static void m(X509CRL x509crl, X509CRL x509crl2, PKIXExtendedParameters pKIXExtendedParameters) throws AnnotatedException {
        boolean z;
        if (x509crl != null) {
            try {
                String str = d;
                IssuingDistributionPoint h2 = IssuingDistributionPoint.h(CertPathValidatorUtilities.k(x509crl2, str));
                if (!pKIXExtendedParameters.f6329b) {
                    return;
                }
                if (PrincipalUtils.b(x509crl).equals(PrincipalUtils.b(x509crl2))) {
                    try {
                        IssuingDistributionPoint h3 = IssuingDistributionPoint.h(CertPathValidatorUtilities.k(x509crl, str));
                        if (h2 != null ? !h2.equals(h3) : h3 != null) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            try {
                                String str2 = k;
                                ASN1Primitive k2 = CertPathValidatorUtilities.k(x509crl2, str2);
                                try {
                                    ASN1Primitive k3 = CertPathValidatorUtilities.k(x509crl, str2);
                                    if (k2 == null) {
                                        throw new AnnotatedException("CRL authority key identifier is null.", (Exception) null);
                                    } else if (k3 == null) {
                                        throw new AnnotatedException("Delta CRL authority key identifier is null.", (Exception) null);
                                    } else if (!k2.equals(k3)) {
                                        throw new AnnotatedException("Delta CRL authority key identifier does not match complete CRL authority key identifier.", (Exception) null);
                                    }
                                } catch (AnnotatedException e2) {
                                    throw new AnnotatedException("Authority key identifier extension could not be extracted from delta CRL.", e2);
                                }
                            } catch (AnnotatedException e3) {
                                throw new AnnotatedException("Authority key identifier extension could not be extracted from complete CRL.", e3);
                            }
                        } else {
                            throw new AnnotatedException("Issuing distribution point extension from delta CRL and complete CRL does not match.", (Exception) null);
                        }
                    } catch (Exception e4) {
                        throw new AnnotatedException("Issuing distribution point extension from delta CRL could not be decoded.", e4);
                    }
                } else {
                    throw new AnnotatedException("Complete CRL issuer does not match delta CRL issuer.", (Exception) null);
                }
            } catch (Exception e5) {
                throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e5);
            }
        }
    }

    public static ReasonsMask n(X509CRL x509crl, DistributionPoint distributionPoint) throws AnnotatedException {
        ReasonsMask reasonsMask;
        ReasonFlags reasonFlags;
        ReasonFlags reasonFlags2;
        try {
            IssuingDistributionPoint h2 = IssuingDistributionPoint.h(CertPathValidatorUtilities.k(x509crl, d));
            if (h2 == null || (reasonFlags = h2.f5749a) == null || (reasonFlags2 = distributionPoint.f5739a) == null) {
                ReasonsMask reasonsMask2 = ReasonsMask.a;
                if ((h2 == null || h2.f5749a == null) && distributionPoint.f5739a == null) {
                    return reasonsMask2;
                }
                ReasonFlags reasonFlags3 = distributionPoint.f5739a;
                if (reasonFlags3 == null) {
                    reasonsMask = reasonsMask2;
                } else {
                    reasonsMask = new ReasonsMask(reasonFlags3);
                }
                if (h2 != null) {
                    reasonsMask2 = new ReasonsMask(h2.f5749a);
                }
                ReasonsMask reasonsMask3 = new ReasonsMask();
                reasonsMask3.f6599a = new ReasonsMask(reasonsMask2.f6599a & reasonsMask.f6599a).f6599a | reasonsMask3.f6599a;
                return reasonsMask3;
            }
            ReasonsMask reasonsMask4 = new ReasonsMask(reasonFlags2);
            ReasonsMask reasonsMask5 = new ReasonsMask(reasonFlags);
            ReasonsMask reasonsMask6 = new ReasonsMask();
            reasonsMask6.f6599a |= new ReasonsMask(reasonsMask4.f6599a & reasonsMask5.f6599a).f6599a;
            return reasonsMask6;
        } catch (Exception e2) {
            throw new AnnotatedException("Issuing distribution point extension could not be decoded.", e2);
        }
    }

    public static HashSet o(X509CRL x509crl, X509Certificate x509Certificate, PublicKey publicKey, PKIXExtendedParameters pKIXExtendedParameters, List list, BCJcaJceHelper bCJcaJceHelper) throws AnnotatedException {
        int i2;
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(PrincipalUtils.b(x509crl).e());
            PKIXCertStoreSelector<? extends Certificate> a2 = new PKIXCertStoreSelector.Builder(x509CertSelector).a();
            try {
                LinkedHashSet a3 = CertPathValidatorUtilities.a(a2, pKIXExtendedParameters.f6323a);
                a3.addAll(CertPathValidatorUtilities.a(a2, pKIXExtendedParameters.a()));
                a3.add(x509Certificate);
                Iterator it = a3.iterator();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (x509Certificate2.equals(x509Certificate)) {
                        arrayList.add(x509Certificate2);
                        arrayList2.add(publicKey);
                    } else {
                        try {
                            PKIXCertPathBuilderSpi pKIXCertPathBuilderSpi = new PKIXCertPathBuilderSpi();
                            X509CertSelector x509CertSelector2 = new X509CertSelector();
                            x509CertSelector2.setCertificate(x509Certificate2);
                            PKIXExtendedParameters.Builder builder = new PKIXExtendedParameters.Builder(pKIXExtendedParameters);
                            builder.f6335a = new PKIXCertStoreSelector.Builder(x509CertSelector2).a();
                            if (list.contains(x509Certificate2)) {
                                builder.f6336a = false;
                            } else {
                                builder.f6336a = true;
                            }
                            List<? extends Certificate> certificates = pKIXCertPathBuilderSpi.engineBuild(new PKIXExtendedBuilderParameters(new PKIXExtendedBuilderParameters.Builder(new PKIXExtendedParameters(builder)))).getCertPath().getCertificates();
                            arrayList.add(x509Certificate2);
                            arrayList2.add(CertPathValidatorUtilities.l(certificates, 0, bCJcaJceHelper));
                        } catch (CertPathBuilderException e2) {
                            throw new AnnotatedException("CertPath for CRL signer failed to validate.", e2);
                        } catch (CertPathValidatorException e3) {
                            throw new AnnotatedException("Public key of issuer certificate of CRL could not be retrieved.", e3);
                        } catch (Exception e4) {
                            throw new AnnotatedException(e4.getMessage(), (Exception) null);
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                AnnotatedException annotatedException = null;
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    boolean[] keyUsage = ((X509Certificate) arrayList.get(i2)).getKeyUsage();
                    if (keyUsage == null || (keyUsage.length >= 7 && keyUsage[6])) {
                        hashSet.add(arrayList2.get(i2));
                    } else {
                        annotatedException = new AnnotatedException("Issuer certificate key usage extension does not permit CRL signing.", (Exception) null);
                    }
                }
                if (hashSet.isEmpty() && annotatedException == null) {
                    throw new AnnotatedException("Cannot find a valid issuer certificate.", (Exception) null);
                } else if (!hashSet.isEmpty() || annotatedException == null) {
                    return hashSet;
                } else {
                    throw annotatedException;
                }
            } catch (AnnotatedException e5) {
                throw new AnnotatedException("Issuer certificate for CRL cannot be searched.", e5);
            }
        } catch (IOException e6) {
            throw new AnnotatedException("Subject criteria for certificate selector to find issuer certificate for CRL could not be set.", e6);
        }
    }

    public static PublicKey p(X509CRL x509crl, Set set) throws AnnotatedException {
        Iterator it = set.iterator();
        Exception e2 = null;
        while (it.hasNext()) {
            PublicKey publicKey = (PublicKey) it.next();
            try {
                x509crl.verify(publicKey);
                return publicKey;
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        throw new AnnotatedException("Cannot verify CRL.", e2);
    }

    public static X509CRL q(HashSet hashSet, PublicKey publicKey) throws AnnotatedException {
        Iterator it = hashSet.iterator();
        Exception e2 = null;
        while (it.hasNext()) {
            X509CRL x509crl = (X509CRL) it.next();
            try {
                x509crl.verify(publicKey);
                return x509crl;
            } catch (Exception e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw new AnnotatedException("Cannot verify delta CRL.", e2);
    }
}
