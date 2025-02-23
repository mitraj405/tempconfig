package org.spongycastle.jce.provider;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.Principal;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.Certificate;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.util.Store;
import org.spongycastle.util.StoreException;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;
import org.spongycastle.x509.X509AttributeCertStoreSelector;
import org.spongycastle.x509.X509AttributeCertificate;
import org.spongycastle.x509.X509CertStoreSelector;

public class PKIXAttrCertPathBuilderSpi extends CertPathBuilderSpi {
    public AnnotatedException a;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0044 A[SYNTHETIC, Splitter:B:23:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0072 A[Catch:{ CertificateParsingException -> 0x00da, AnnotatedException -> 0x00d1, Exception -> 0x0069, Exception -> 0x0060, AnnotatedException -> 0x00e3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.cert.CertPathBuilderResult a(java.security.cert.X509Certificate r7, org.spongycastle.jcajce.PKIXExtendedBuilderParameters r8, java.util.ArrayList r9) {
        /*
            r6 = this;
            java.lang.String r0 = "SC"
            boolean r1 = r9.contains(r7)
            r2 = 0
            if (r1 == 0) goto L_0x000a
            return r2
        L_0x000a:
            org.spongycastle.jcajce.PKIXExtendedParameters r1 = r8.f6319a
            java.util.Set<java.security.cert.X509Certificate> r3 = r8.a
            boolean r3 = r3.contains(r7)
            if (r3 == 0) goto L_0x0015
            return r2
        L_0x0015:
            r3 = -1
            int r4 = r8.c
            if (r4 == r3) goto L_0x0022
            int r5 = r9.size()
            int r5 = r5 + r3
            if (r5 <= r4) goto L_0x0022
            return r2
        L_0x0022:
            r9.add(r7)
            java.lang.String r3 = "X.509"
            java.security.cert.CertificateFactory r3 = java.security.cert.CertificateFactory.getInstance(r3, r0)     // Catch:{ Exception -> 0x00f3 }
            java.lang.String r4 = "RFC3281"
            java.security.cert.CertPathValidator r0 = java.security.cert.CertPathValidator.getInstance(r4, r0)     // Catch:{ Exception -> 0x00f3 }
            java.util.Set<java.security.cert.TrustAnchor> r4 = r1.f6325a     // Catch:{ AnnotatedException -> 0x00e3 }
            java.security.cert.PKIXParameters r5 = r1.a     // Catch:{ AnnotatedException -> 0x00e3 }
            java.lang.String r5 = r5.getSigProvider()     // Catch:{ AnnotatedException -> 0x00e3 }
            java.security.cert.TrustAnchor r4 = org.spongycastle.jce.provider.CertPathValidatorUtilities.c(r7, r4, r5)     // Catch:{ Exception -> 0x0041 }
            if (r4 == 0) goto L_0x0041
            r4 = 1
            goto L_0x0042
        L_0x0041:
            r4 = 0
        L_0x0042:
            if (r4 == 0) goto L_0x0072
            java.security.cert.CertPath r1 = r3.generateCertPath(r9)     // Catch:{ Exception -> 0x0069 }
            java.security.cert.CertPathValidatorResult r8 = r0.validate(r1, r8)     // Catch:{ Exception -> 0x0060 }
            java.security.cert.PKIXCertPathValidatorResult r8 = (java.security.cert.PKIXCertPathValidatorResult) r8     // Catch:{ Exception -> 0x0060 }
            java.security.cert.PKIXCertPathBuilderResult r0 = new java.security.cert.PKIXCertPathBuilderResult     // Catch:{ AnnotatedException -> 0x00e3 }
            java.security.cert.TrustAnchor r3 = r8.getTrustAnchor()     // Catch:{ AnnotatedException -> 0x00e3 }
            java.security.cert.PolicyNode r4 = r8.getPolicyTree()     // Catch:{ AnnotatedException -> 0x00e3 }
            java.security.PublicKey r8 = r8.getPublicKey()     // Catch:{ AnnotatedException -> 0x00e3 }
            r0.<init>(r1, r3, r4, r8)     // Catch:{ AnnotatedException -> 0x00e3 }
            return r0
        L_0x0060:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00e3 }
            java.lang.String r1 = "Certification path could not be validated."
            r0.<init>(r1, r8)     // Catch:{ AnnotatedException -> 0x00e3 }
            throw r0     // Catch:{ AnnotatedException -> 0x00e3 }
        L_0x0069:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00e3 }
            java.lang.String r1 = "Certification path could not be constructed from certificate list."
            r0.<init>(r1, r8)     // Catch:{ AnnotatedException -> 0x00e3 }
            throw r0     // Catch:{ AnnotatedException -> 0x00e3 }
        L_0x0072:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ AnnotatedException -> 0x00e3 }
            r0.<init>()     // Catch:{ AnnotatedException -> 0x00e3 }
            java.util.List<org.spongycastle.jcajce.PKIXCertStore> r3 = r1.f6323a     // Catch:{ AnnotatedException -> 0x00e3 }
            r0.addAll(r3)     // Catch:{ AnnotatedException -> 0x00e3 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x509.Extension.c1     // Catch:{ CertificateParsingException -> 0x00da }
            java.lang.String r3 = r3.c     // Catch:{ CertificateParsingException -> 0x00da }
            byte[] r3 = r7.getExtensionValue(r3)     // Catch:{ CertificateParsingException -> 0x00da }
            java.util.Map<org.spongycastle.asn1.x509.GeneralName, org.spongycastle.jcajce.PKIXCertStore> r4 = r1.f6324a     // Catch:{ CertificateParsingException -> 0x00da }
            java.util.List r3 = org.spongycastle.jce.provider.CertPathValidatorUtilities.d(r3, r4)     // Catch:{ CertificateParsingException -> 0x00da }
            r0.addAll(r3)     // Catch:{ CertificateParsingException -> 0x00da }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ AnnotatedException -> 0x00e3 }
            r3.<init>()     // Catch:{ AnnotatedException -> 0x00e3 }
            java.util.List r1 = r1.a()     // Catch:{ AnnotatedException -> 0x00d1 }
            java.util.LinkedHashSet r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.b(r7, r1, r0)     // Catch:{ AnnotatedException -> 0x00d1 }
            r3.addAll(r0)     // Catch:{ AnnotatedException -> 0x00d1 }
            boolean r0 = r3.isEmpty()     // Catch:{ AnnotatedException -> 0x00e3 }
            if (r0 != 0) goto L_0x00c9
            java.util.Iterator r0 = r3.iterator()     // Catch:{ AnnotatedException -> 0x00e3 }
        L_0x00a7:
            boolean r1 = r0.hasNext()     // Catch:{ AnnotatedException -> 0x00e3 }
            if (r1 == 0) goto L_0x00ed
            if (r2 != 0) goto L_0x00ed
            java.lang.Object r1 = r0.next()     // Catch:{ AnnotatedException -> 0x00e3 }
            java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1     // Catch:{ AnnotatedException -> 0x00e3 }
            javax.security.auth.x500.X500Principal r3 = r1.getIssuerX500Principal()     // Catch:{ AnnotatedException -> 0x00e3 }
            javax.security.auth.x500.X500Principal r4 = r1.getSubjectX500Principal()     // Catch:{ AnnotatedException -> 0x00e3 }
            boolean r3 = r3.equals(r4)     // Catch:{ AnnotatedException -> 0x00e3 }
            if (r3 == 0) goto L_0x00c4
            goto L_0x00a7
        L_0x00c4:
            java.security.cert.CertPathBuilderResult r2 = r6.a(r1, r8, r9)     // Catch:{ AnnotatedException -> 0x00e3 }
            goto L_0x00a7
        L_0x00c9:
            org.spongycastle.jce.provider.AnnotatedException r8 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00e3 }
            java.lang.String r0 = "No issuer certificate for certificate in certification path found."
            r8.<init>(r0, r2)     // Catch:{ AnnotatedException -> 0x00e3 }
            throw r8     // Catch:{ AnnotatedException -> 0x00e3 }
        L_0x00d1:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00e3 }
            java.lang.String r1 = "Cannot find issuer certificate for certificate in certification path."
            r0.<init>(r1, r8)     // Catch:{ AnnotatedException -> 0x00e3 }
            throw r0     // Catch:{ AnnotatedException -> 0x00e3 }
        L_0x00da:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00e3 }
            java.lang.String r1 = "No additional X.509 stores can be added from certificate locations."
            r0.<init>(r1, r8)     // Catch:{ AnnotatedException -> 0x00e3 }
            throw r0     // Catch:{ AnnotatedException -> 0x00e3 }
        L_0x00e3:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException
            java.lang.String r1 = "No valid certification path could be build."
            r0.<init>(r1, r8)
            r6.a = r0
        L_0x00ed:
            if (r2 != 0) goto L_0x00f2
            r9.remove(r7)
        L_0x00f2:
            return r2
        L_0x00f3:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "Exception creating support classes."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi.a(java.security.cert.X509Certificate, org.spongycastle.jcajce.PKIXExtendedBuilderParameters, java.util.ArrayList):java.security.cert.CertPathBuilderResult");
    }

    public final CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters;
        boolean z = certPathParameters instanceof PKIXBuilderParameters;
        if (z || (certPathParameters instanceof ExtendedPKIXBuilderParameters) || (certPathParameters instanceof PKIXExtendedBuilderParameters)) {
            List arrayList = new ArrayList();
            if (z) {
                PKIXExtendedBuilderParameters.Builder builder = new PKIXExtendedBuilderParameters.Builder((PKIXBuilderParameters) certPathParameters);
                if (certPathParameters instanceof ExtendedPKIXParameters) {
                    ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                    builder.f6320a.addAll(Collections.unmodifiableSet(extendedPKIXBuilderParameters.a));
                    int i = extendedPKIXBuilderParameters.d;
                    if (i >= -1) {
                        builder.a = i;
                        arrayList = Collections.unmodifiableList(new ArrayList(extendedPKIXBuilderParameters.a));
                    } else {
                        throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
                    }
                }
                pKIXExtendedBuilderParameters = new PKIXExtendedBuilderParameters(builder);
            } else {
                pKIXExtendedBuilderParameters = (PKIXExtendedBuilderParameters) certPathParameters;
            }
            ArrayList arrayList2 = new ArrayList();
            PKIXExtendedParameters pKIXExtendedParameters = pKIXExtendedBuilderParameters.f6319a;
            PKIXCertStoreSelector pKIXCertStoreSelector = pKIXExtendedParameters.f6326a;
            if (pKIXCertStoreSelector instanceof X509AttributeCertStoreSelector) {
                try {
                    X509AttributeCertStoreSelector x509AttributeCertStoreSelector = (X509AttributeCertStoreSelector) pKIXCertStoreSelector;
                    HashSet hashSet = new HashSet();
                    for (Object next : arrayList) {
                        if (next instanceof Store) {
                            hashSet.addAll(((Store) next).a(x509AttributeCertStoreSelector));
                        }
                    }
                    if (!hashSet.isEmpty()) {
                        Iterator it = hashSet.iterator();
                        CertPathBuilderResult certPathBuilderResult = null;
                        while (it.hasNext() && certPathBuilderResult == null) {
                            X509CertStoreSelector x509CertStoreSelector = new X509CertStoreSelector();
                            Principal[] a2 = ((X509AttributeCertificate) it.next()).a().a();
                            HashSet hashSet2 = new HashSet();
                            int i2 = 0;
                            while (i2 < a2.length) {
                                try {
                                    Principal principal = a2[i2];
                                    if (principal instanceof X500Principal) {
                                        x509CertStoreSelector.setSubject(((X500Principal) principal).getEncoded());
                                    }
                                    PKIXCertStoreSelector<? extends Certificate> a3 = new PKIXCertStoreSelector.Builder(x509CertStoreSelector).a();
                                    hashSet2.addAll(CertPathValidatorUtilities.a(a3, pKIXExtendedParameters.a()));
                                    hashSet2.addAll(CertPathValidatorUtilities.a(a3, pKIXExtendedParameters.f6323a));
                                    i2++;
                                } catch (AnnotatedException e) {
                                    throw new ExtCertPathBuilderException("Public key certificate for attribute certificate cannot be searched.", e);
                                } catch (IOException e2) {
                                    throw new ExtCertPathBuilderException("cannot encode X500Principal.", e2);
                                }
                            }
                            if (!hashSet2.isEmpty()) {
                                Iterator it2 = hashSet2.iterator();
                                while (it2.hasNext() && certPathBuilderResult == null) {
                                    certPathBuilderResult = a((X509Certificate) it2.next(), pKIXExtendedBuilderParameters, arrayList2);
                                }
                            } else {
                                throw new CertPathBuilderException("Public key certificate for attribute certificate cannot be found.");
                            }
                        }
                        if (certPathBuilderResult == null && this.a != null) {
                            throw new ExtCertPathBuilderException("Possible certificate chain could not be validated.", this.a);
                        } else if (certPathBuilderResult != null || this.a != null) {
                            return certPathBuilderResult;
                        } else {
                            throw new CertPathBuilderException("Unable to find certificate chain.");
                        }
                    } else {
                        throw new CertPathBuilderException("No attribute certificate found matching targetContraints.");
                    }
                } catch (StoreException e3) {
                    throw new AnnotatedException("Problem while picking certificates from X.509 store.", e3);
                } catch (AnnotatedException e4) {
                    throw new ExtCertPathBuilderException("Error finding target attribute certificate.", e4);
                }
            } else {
                throw new CertPathBuilderException("TargetConstraints must be an instance of " + X509AttributeCertStoreSelector.class.getName() + " for " + getClass().getName() + " class.");
            }
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + PKIXExtendedBuilderParameters.class.getName() + ".");
        }
    }
}
