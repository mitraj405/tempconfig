package org.spongycastle.jce.provider;

import java.security.PublicKey;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.x509.DistributionPoint;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.x509.X509AttributeCertificate;

class RFC3281CertPathUtilities {
    public static final String a = Extension.v1.c;
    public static final String b = Extension.u1.c;
    public static final String c = Extension.k1.c;
    public static final String d = Extension.s1.c;

    public static void a(DistributionPoint distributionPoint, X509AttributeCertificate x509AttributeCertificate, PKIXExtendedParameters pKIXExtendedParameters, Date date, CertStatus certStatus, ReasonsMask reasonsMask, List list, BCJcaJceHelper bCJcaJceHelper) throws AnnotatedException {
        Iterator it;
        boolean z;
        X509CRL x509crl;
        DistributionPoint distributionPoint2 = distributionPoint;
        X509AttributeCertificate x509AttributeCertificate2 = x509AttributeCertificate;
        PKIXExtendedParameters pKIXExtendedParameters2 = pKIXExtendedParameters;
        Date date2 = date;
        CertStatus certStatus2 = certStatus;
        ReasonsMask reasonsMask2 = reasonsMask;
        if (x509AttributeCertificate2.getExtensionValue(X509Extensions.b1.c) == null) {
            Date date3 = new Date(System.currentTimeMillis());
            if (date.getTime() <= date3.getTime()) {
                Iterator it2 = CertPathValidatorUtilities.i(distributionPoint, x509AttributeCertificate, pKIXExtendedParameters).iterator();
                boolean z2 = false;
                AnnotatedException e = null;
                while (it2.hasNext() && certStatus2.a == 11 && !reasonsMask.a()) {
                    try {
                        X509CRL x509crl2 = (X509CRL) it2.next();
                        ReasonsMask n = RFC3280CertPathUtilities.n(x509crl2, distributionPoint2);
                        int i = n.f6599a;
                        if ((i | (reasonsMask2.f6599a ^ i)) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            continue;
                        } else {
                            ReasonsMask reasonsMask3 = n;
                            X509CRL x509crl3 = x509crl2;
                            it = it2;
                            try {
                                PublicKey p = RFC3280CertPathUtilities.p(x509crl3, RFC3280CertPathUtilities.o(x509crl2, (X509Certificate) null, (PublicKey) null, pKIXExtendedParameters, list, bCJcaJceHelper));
                                boolean z3 = pKIXExtendedParameters2.f6329b;
                                if (z3) {
                                    x509crl = RFC3280CertPathUtilities.q(CertPathValidatorUtilities.j(date3, x509crl3, pKIXExtendedParameters.a(), pKIXExtendedParameters2.b), p);
                                } else {
                                    x509crl = null;
                                }
                                if (pKIXExtendedParameters2.c != 1) {
                                    if (x509AttributeCertificate.getNotAfter().getTime() < x509crl3.getThisUpdate().getTime()) {
                                        throw new AnnotatedException("No valid CRL for current time found.", (Exception) null);
                                    }
                                }
                                RFC3280CertPathUtilities.k(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.l(distributionPoint2, x509AttributeCertificate2, x509crl3);
                                RFC3280CertPathUtilities.m(x509crl, x509crl3, pKIXExtendedParameters2);
                                if (z3 && x509crl != null) {
                                    CertPathValidatorUtilities.h(date2, x509crl, x509AttributeCertificate2, certStatus2);
                                }
                                if (certStatus2.a == 11) {
                                    CertPathValidatorUtilities.h(date2, x509crl3, x509AttributeCertificate2, certStatus2);
                                }
                                if (certStatus2.a == 8) {
                                    certStatus2.a = 11;
                                }
                                reasonsMask2.f6599a |= reasonsMask3.f6599a;
                                z2 = true;
                            } catch (AnnotatedException e2) {
                                e = e2;
                            }
                            it2 = it;
                        }
                    } catch (AnnotatedException e3) {
                        e = e3;
                        it = it2;
                    }
                }
                if (!z2) {
                    throw e;
                }
                return;
            }
            throw new AnnotatedException("Validation time is in future.", (Exception) null);
        }
    }
}
