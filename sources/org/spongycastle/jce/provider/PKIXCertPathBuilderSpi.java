package org.spongycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.spongycastle.jcajce.PKIXCertStore;
import org.spongycastle.jcajce.PKIXCertStoreSelector;
import org.spongycastle.jcajce.PKIXExtendedBuilderParameters;
import org.spongycastle.jcajce.PKIXExtendedParameters;
import org.spongycastle.jce.exception.ExtCertPathBuilderException;
import org.spongycastle.x509.ExtendedPKIXBuilderParameters;
import org.spongycastle.x509.ExtendedPKIXParameters;

public class PKIXCertPathBuilderSpi extends CertPathBuilderSpi {
    public AnnotatedException a;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0040 A[SYNTHETIC, Splitter:B:23:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e A[Catch:{ CertificateParsingException -> 0x00c7, AnnotatedException -> 0x00be, Exception -> 0x0065, Exception -> 0x005c, AnnotatedException -> 0x00d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.cert.CertPathBuilderResult a(java.security.cert.X509Certificate r7, org.spongycastle.jcajce.PKIXExtendedBuilderParameters r8, java.util.ArrayList r9) {
        /*
            r6 = this;
            boolean r0 = r9.contains(r7)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            org.spongycastle.jcajce.PKIXExtendedParameters r0 = r8.f6319a
            java.util.Set<java.security.cert.X509Certificate> r2 = r8.a
            boolean r2 = r2.contains(r7)
            if (r2 == 0) goto L_0x0013
            return r1
        L_0x0013:
            r2 = -1
            int r3 = r8.c
            if (r3 == r2) goto L_0x0020
            int r4 = r9.size()
            int r4 = r4 + r2
            if (r4 <= r3) goto L_0x0020
            return r1
        L_0x0020:
            r9.add(r7)
            org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory r2 = new org.spongycastle.jcajce.provider.asymmetric.x509.CertificateFactory     // Catch:{ Exception -> 0x00d9 }
            r2.<init>()     // Catch:{ Exception -> 0x00d9 }
            org.spongycastle.jce.provider.PKIXCertPathValidatorSpi r3 = new org.spongycastle.jce.provider.PKIXCertPathValidatorSpi     // Catch:{ Exception -> 0x00d9 }
            r3.<init>()     // Catch:{ Exception -> 0x00d9 }
            java.util.Set<java.security.cert.TrustAnchor> r4 = r0.f6325a     // Catch:{ AnnotatedException -> 0x00d0 }
            java.security.cert.PKIXParameters r5 = r0.a     // Catch:{ AnnotatedException -> 0x00d0 }
            java.lang.String r5 = r5.getSigProvider()     // Catch:{ AnnotatedException -> 0x00d0 }
            java.security.cert.TrustAnchor r4 = org.spongycastle.jce.provider.CertPathValidatorUtilities.c(r7, r4, r5)     // Catch:{ Exception -> 0x003d }
            if (r4 == 0) goto L_0x003d
            r4 = 1
            goto L_0x003e
        L_0x003d:
            r4 = 0
        L_0x003e:
            if (r4 == 0) goto L_0x006e
            java.security.cert.CertPath r0 = r2.engineGenerateCertPath((java.util.List) r9)     // Catch:{ Exception -> 0x0065 }
            java.security.cert.CertPathValidatorResult r8 = r3.engineValidate(r0, r8)     // Catch:{ Exception -> 0x005c }
            java.security.cert.PKIXCertPathValidatorResult r8 = (java.security.cert.PKIXCertPathValidatorResult) r8     // Catch:{ Exception -> 0x005c }
            java.security.cert.PKIXCertPathBuilderResult r2 = new java.security.cert.PKIXCertPathBuilderResult     // Catch:{ AnnotatedException -> 0x00d0 }
            java.security.cert.TrustAnchor r3 = r8.getTrustAnchor()     // Catch:{ AnnotatedException -> 0x00d0 }
            java.security.cert.PolicyNode r4 = r8.getPolicyTree()     // Catch:{ AnnotatedException -> 0x00d0 }
            java.security.PublicKey r8 = r8.getPublicKey()     // Catch:{ AnnotatedException -> 0x00d0 }
            r2.<init>(r0, r3, r4, r8)     // Catch:{ AnnotatedException -> 0x00d0 }
            return r2
        L_0x005c:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00d0 }
            java.lang.String r2 = "Certification path could not be validated."
            r0.<init>(r2, r8)     // Catch:{ AnnotatedException -> 0x00d0 }
            throw r0     // Catch:{ AnnotatedException -> 0x00d0 }
        L_0x0065:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00d0 }
            java.lang.String r2 = "Certification path could not be constructed from certificate list."
            r0.<init>(r2, r8)     // Catch:{ AnnotatedException -> 0x00d0 }
            throw r0     // Catch:{ AnnotatedException -> 0x00d0 }
        L_0x006e:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ AnnotatedException -> 0x00d0 }
            r2.<init>()     // Catch:{ AnnotatedException -> 0x00d0 }
            java.util.List<org.spongycastle.jcajce.PKIXCertStore> r3 = r0.f6323a     // Catch:{ AnnotatedException -> 0x00d0 }
            r2.addAll(r3)     // Catch:{ AnnotatedException -> 0x00d0 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x509.Extension.c1     // Catch:{ CertificateParsingException -> 0x00c7 }
            java.lang.String r3 = r3.c     // Catch:{ CertificateParsingException -> 0x00c7 }
            byte[] r3 = r7.getExtensionValue(r3)     // Catch:{ CertificateParsingException -> 0x00c7 }
            java.util.Map<org.spongycastle.asn1.x509.GeneralName, org.spongycastle.jcajce.PKIXCertStore> r4 = r0.f6324a     // Catch:{ CertificateParsingException -> 0x00c7 }
            java.util.List r3 = org.spongycastle.jce.provider.CertPathValidatorUtilities.d(r3, r4)     // Catch:{ CertificateParsingException -> 0x00c7 }
            r2.addAll(r3)     // Catch:{ CertificateParsingException -> 0x00c7 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ AnnotatedException -> 0x00d0 }
            r3.<init>()     // Catch:{ AnnotatedException -> 0x00d0 }
            java.util.List r0 = r0.a()     // Catch:{ AnnotatedException -> 0x00be }
            java.util.LinkedHashSet r0 = org.spongycastle.jce.provider.CertPathValidatorUtilities.b(r7, r0, r2)     // Catch:{ AnnotatedException -> 0x00be }
            r3.addAll(r0)     // Catch:{ AnnotatedException -> 0x00be }
            boolean r0 = r3.isEmpty()     // Catch:{ AnnotatedException -> 0x00d0 }
            if (r0 != 0) goto L_0x00b6
            java.util.Iterator r0 = r3.iterator()     // Catch:{ AnnotatedException -> 0x00d0 }
        L_0x00a3:
            boolean r2 = r0.hasNext()     // Catch:{ AnnotatedException -> 0x00d0 }
            if (r2 == 0) goto L_0x00d3
            if (r1 != 0) goto L_0x00d3
            java.lang.Object r2 = r0.next()     // Catch:{ AnnotatedException -> 0x00d0 }
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2     // Catch:{ AnnotatedException -> 0x00d0 }
            java.security.cert.CertPathBuilderResult r1 = r6.a(r2, r8, r9)     // Catch:{ AnnotatedException -> 0x00d0 }
            goto L_0x00a3
        L_0x00b6:
            org.spongycastle.jce.provider.AnnotatedException r8 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00d0 }
            java.lang.String r0 = "No issuer certificate for certificate in certification path found."
            r8.<init>(r0, r1)     // Catch:{ AnnotatedException -> 0x00d0 }
            throw r8     // Catch:{ AnnotatedException -> 0x00d0 }
        L_0x00be:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00d0 }
            java.lang.String r2 = "Cannot find issuer certificate for certificate in certification path."
            r0.<init>(r2, r8)     // Catch:{ AnnotatedException -> 0x00d0 }
            throw r0     // Catch:{ AnnotatedException -> 0x00d0 }
        L_0x00c7:
            r8 = move-exception
            org.spongycastle.jce.provider.AnnotatedException r0 = new org.spongycastle.jce.provider.AnnotatedException     // Catch:{ AnnotatedException -> 0x00d0 }
            java.lang.String r2 = "No additional X.509 stores can be added from certificate locations."
            r0.<init>(r2, r8)     // Catch:{ AnnotatedException -> 0x00d0 }
            throw r0     // Catch:{ AnnotatedException -> 0x00d0 }
        L_0x00d0:
            r8 = move-exception
            r6.a = r8
        L_0x00d3:
            if (r1 != 0) goto L_0x00d8
            r9.remove(r7)
        L_0x00d8:
            return r1
        L_0x00d9:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "Exception creating support classes."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.PKIXCertPathBuilderSpi.a(java.security.cert.X509Certificate, org.spongycastle.jcajce.PKIXExtendedBuilderParameters, java.util.ArrayList):java.security.cert.CertPathBuilderResult");
    }

    public final CertPathBuilderResult engineBuild(CertPathParameters certPathParameters) throws CertPathBuilderException, InvalidAlgorithmParameterException {
        PKIXExtendedBuilderParameters pKIXExtendedBuilderParameters;
        PKIXExtendedBuilderParameters.Builder builder;
        if (certPathParameters instanceof PKIXBuilderParameters) {
            PKIXBuilderParameters pKIXBuilderParameters = (PKIXBuilderParameters) certPathParameters;
            PKIXExtendedParameters.Builder builder2 = new PKIXExtendedParameters.Builder((PKIXParameters) pKIXBuilderParameters);
            if (certPathParameters instanceof ExtendedPKIXParameters) {
                ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) certPathParameters;
                for (PKIXCertStore add : Collections.unmodifiableList(extendedPKIXBuilderParameters.b)) {
                    builder2.f6331a.add(add);
                }
                builder = new PKIXExtendedBuilderParameters.Builder(new PKIXExtendedParameters(builder2));
                builder.f6320a.addAll(Collections.unmodifiableSet(extendedPKIXBuilderParameters.a));
                int i = extendedPKIXBuilderParameters.d;
                if (i >= -1) {
                    builder.a = i;
                } else {
                    throw new InvalidParameterException("The maximum path length parameter can not be less than -1.");
                }
            } else {
                builder = new PKIXExtendedBuilderParameters.Builder(pKIXBuilderParameters);
            }
            pKIXExtendedBuilderParameters = new PKIXExtendedBuilderParameters(builder);
        } else if (certPathParameters instanceof PKIXExtendedBuilderParameters) {
            pKIXExtendedBuilderParameters = (PKIXExtendedBuilderParameters) certPathParameters;
        } else {
            throw new InvalidAlgorithmParameterException("Parameters must be an instance of " + PKIXBuilderParameters.class.getName() + " or " + PKIXExtendedBuilderParameters.class.getName() + ".");
        }
        ArrayList arrayList = new ArrayList();
        PKIXExtendedParameters pKIXExtendedParameters = pKIXExtendedBuilderParameters.f6319a;
        PKIXCertStoreSelector pKIXCertStoreSelector = pKIXExtendedParameters.f6326a;
        try {
            LinkedHashSet a2 = CertPathValidatorUtilities.a(pKIXCertStoreSelector, pKIXExtendedParameters.f6323a);
            a2.addAll(CertPathValidatorUtilities.a(pKIXCertStoreSelector, pKIXExtendedBuilderParameters.f6319a.a()));
            if (!a2.isEmpty()) {
                Iterator it = a2.iterator();
                CertPathBuilderResult certPathBuilderResult = null;
                while (it.hasNext() && certPathBuilderResult == null) {
                    certPathBuilderResult = a((X509Certificate) it.next(), pKIXExtendedBuilderParameters, arrayList);
                }
                if (certPathBuilderResult == null && this.a != null) {
                    throw new CertPathBuilderException(this.a.getMessage(), this.a.getCause());
                } else if (certPathBuilderResult != null || this.a != null) {
                    return certPathBuilderResult;
                } else {
                    throw new CertPathBuilderException("Unable to find certificate chain.");
                }
            } else {
                throw new CertPathBuilderException("No certificate found matching targetContraints.");
            }
        } catch (AnnotatedException e) {
            throw new ExtCertPathBuilderException("Error finding target certificate.", e);
        }
    }
}
