package org.spongycastle.x509;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.Holder;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.util.Selector;

public class AttributeCertificateHolder implements CertSelector, Selector {
    public final Holder a;

    public AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.a = Holder.g(aSN1Sequence);
    }

    public static Principal[] b(GeneralNames generalNames) {
        GeneralName[] h = generalNames.h();
        ArrayList arrayList = new ArrayList(h.length);
        for (int i = 0; i != h.length; i++) {
            if (h[i].c == 4) {
                try {
                    arrayList.add(new X500Principal(h[i].a.b().e()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        Object[] array = arrayList.toArray(new Object[arrayList.size()]);
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 != array.length; i2++) {
            Object obj = array[i2];
            if (obj instanceof Principal) {
                arrayList2.add(obj);
            }
        }
        return (Principal[]) arrayList2.toArray(new Principal[arrayList2.size()]);
    }

    public static boolean c(X509Principal x509Principal, GeneralNames generalNames) {
        GeneralName[] h = generalNames.h();
        for (int i = 0; i != h.length; i++) {
            GeneralName generalName = h[i];
            if (generalName.c == 4) {
                try {
                    if (new X509Principal(generalName.a.b().e()).equals(x509Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    public final Principal[] a() {
        GeneralNames generalNames = this.a.a;
        if (generalNames != null) {
            return b(generalNames);
        }
        return null;
    }

    public final Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.a.b());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder)) {
            return false;
        }
        return this.a.equals(((AttributeCertificateHolder) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: org.spongycastle.asn1.x509.TBSCertificateStructure} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean match(java.security.cert.Certificate r8) {
        /*
            r7 = this;
            org.spongycastle.asn1.x509.Holder r0 = r7.a
            boolean r1 = r8 instanceof java.security.cert.X509Certificate
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            r1 = r8
            java.security.cert.X509Certificate r1 = (java.security.cert.X509Certificate) r1
            org.spongycastle.asn1.x509.IssuerSerial r3 = r0.f5744a     // Catch:{ CertificateEncodingException -> 0x00e2 }
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x005f
            org.spongycastle.asn1.ASN1Integer r8 = r3.a     // Catch:{ CertificateEncodingException -> 0x00e2 }
            java.math.BigInteger r8 = r8.t()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            java.math.BigInteger r3 = r1.getSerialNumber()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            boolean r8 = r8.equals(r3)     // Catch:{ CertificateEncodingException -> 0x00e2 }
            if (r8 == 0) goto L_0x005e
            byte[] r8 = r1.getTBSCertificate()     // Catch:{ IOException -> 0x0053 }
            org.spongycastle.asn1.ASN1Primitive r8 = org.spongycastle.asn1.ASN1Primitive.k(r8)     // Catch:{ IOException -> 0x0053 }
            boolean r1 = r8 instanceof org.spongycastle.asn1.x509.TBSCertificateStructure     // Catch:{ IOException -> 0x0053 }
            if (r1 == 0) goto L_0x0031
            r4 = r8
            org.spongycastle.asn1.x509.TBSCertificateStructure r4 = (org.spongycastle.asn1.x509.TBSCertificateStructure) r4     // Catch:{ IOException -> 0x0053 }
            goto L_0x003c
        L_0x0031:
            if (r8 == 0) goto L_0x003c
            org.spongycastle.asn1.x509.TBSCertificateStructure r4 = new org.spongycastle.asn1.x509.TBSCertificateStructure     // Catch:{ IOException -> 0x0053 }
            org.spongycastle.asn1.ASN1Sequence r8 = org.spongycastle.asn1.ASN1Sequence.q(r8)     // Catch:{ IOException -> 0x0053 }
            r4.<init>(r8)     // Catch:{ IOException -> 0x0053 }
        L_0x003c:
            org.spongycastle.jce.X509Principal r8 = new org.spongycastle.jce.X509Principal     // Catch:{ IOException -> 0x0053 }
            org.spongycastle.asn1.x500.X500Name r1 = r4.f5770a     // Catch:{ IOException -> 0x0053 }
            org.spongycastle.asn1.x509.X509Name r1 = org.spongycastle.asn1.x509.X509Name.i(r1)     // Catch:{ IOException -> 0x0053 }
            r8.<init>((org.spongycastle.asn1.x509.X509Name) r1)     // Catch:{ IOException -> 0x0053 }
            org.spongycastle.asn1.x509.IssuerSerial r0 = r0.f5744a     // Catch:{ CertificateEncodingException -> 0x00e2 }
            org.spongycastle.asn1.x509.GeneralNames r0 = r0.f5747a     // Catch:{ CertificateEncodingException -> 0x00e2 }
            boolean r8 = c(r8, r0)     // Catch:{ CertificateEncodingException -> 0x00e2 }
            if (r8 == 0) goto L_0x005e
            r2 = r5
            goto L_0x005e
        L_0x0053:
            r8 = move-exception
            java.security.cert.CertificateEncodingException r0 = new java.security.cert.CertificateEncodingException     // Catch:{ CertificateEncodingException -> 0x00e2 }
            java.lang.String r8 = r8.toString()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            r0.<init>(r8)     // Catch:{ CertificateEncodingException -> 0x00e2 }
            throw r0     // Catch:{ CertificateEncodingException -> 0x00e2 }
        L_0x005e:
            return r2
        L_0x005f:
            org.spongycastle.asn1.x509.GeneralNames r3 = r0.a
            if (r3 == 0) goto L_0x009d
            byte[] r1 = r1.getTBSCertificate()     // Catch:{ IOException -> 0x0092 }
            org.spongycastle.asn1.ASN1Primitive r1 = org.spongycastle.asn1.ASN1Primitive.k(r1)     // Catch:{ IOException -> 0x0092 }
            boolean r6 = r1 instanceof org.spongycastle.asn1.x509.TBSCertificateStructure     // Catch:{ IOException -> 0x0092 }
            if (r6 == 0) goto L_0x0072
            org.spongycastle.asn1.x509.TBSCertificateStructure r1 = (org.spongycastle.asn1.x509.TBSCertificateStructure) r1     // Catch:{ IOException -> 0x0092 }
            goto L_0x0080
        L_0x0072:
            if (r1 == 0) goto L_0x007f
            org.spongycastle.asn1.x509.TBSCertificateStructure r6 = new org.spongycastle.asn1.x509.TBSCertificateStructure     // Catch:{ IOException -> 0x0092 }
            org.spongycastle.asn1.ASN1Sequence r1 = org.spongycastle.asn1.ASN1Sequence.q(r1)     // Catch:{ IOException -> 0x0092 }
            r6.<init>(r1)     // Catch:{ IOException -> 0x0092 }
            r1 = r6
            goto L_0x0080
        L_0x007f:
            r1 = r4
        L_0x0080:
            org.spongycastle.jce.X509Principal r6 = new org.spongycastle.jce.X509Principal     // Catch:{ IOException -> 0x0092 }
            org.spongycastle.asn1.x500.X500Name r1 = r1.b     // Catch:{ IOException -> 0x0092 }
            org.spongycastle.asn1.x509.X509Name r1 = org.spongycastle.asn1.x509.X509Name.i(r1)     // Catch:{ IOException -> 0x0092 }
            r6.<init>((org.spongycastle.asn1.x509.X509Name) r1)     // Catch:{ IOException -> 0x0092 }
            boolean r1 = c(r6, r3)     // Catch:{ CertificateEncodingException -> 0x00e2 }
            if (r1 == 0) goto L_0x009d
            return r5
        L_0x0092:
            r8 = move-exception
            java.security.cert.CertificateEncodingException r0 = new java.security.cert.CertificateEncodingException     // Catch:{ CertificateEncodingException -> 0x00e2 }
            java.lang.String r8 = r8.toString()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            r0.<init>(r8)     // Catch:{ CertificateEncodingException -> 0x00e2 }
            throw r0     // Catch:{ CertificateEncodingException -> 0x00e2 }
        L_0x009d:
            org.spongycastle.asn1.x509.ObjectDigestInfo r0 = r0.f5745a
            if (r0 == 0) goto L_0x00e2
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r0.f5752a     // Catch:{  }
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.Z0     // Catch:{  }
            java.lang.String r1 = r1.c     // Catch:{  }
            java.lang.String r3 = "SC"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r1, r3)     // Catch:{  }
            if (r0 == 0) goto L_0x00ba
            org.spongycastle.asn1.ASN1Enumerated r3 = r0.a     // Catch:{ CertificateEncodingException -> 0x00e2 }
            java.math.BigInteger r3 = r3.r()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            int r3 = r3.intValue()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            goto L_0x00bb
        L_0x00ba:
            r3 = -1
        L_0x00bb:
            if (r3 == 0) goto L_0x00c8
            if (r3 == r5) goto L_0x00c0
            goto L_0x00d3
        L_0x00c0:
            byte[] r8 = r8.getEncoded()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            r1.update(r8)     // Catch:{ CertificateEncodingException -> 0x00e2 }
            goto L_0x00d3
        L_0x00c8:
            java.security.PublicKey r8 = r8.getPublicKey()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            byte[] r8 = r8.getEncoded()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            r1.update(r8)     // Catch:{ CertificateEncodingException -> 0x00e2 }
        L_0x00d3:
            byte[] r8 = r1.digest()     // Catch:{ CertificateEncodingException -> 0x00e2 }
            if (r0 == 0) goto L_0x00df
            org.spongycastle.asn1.DERBitString r0 = r0.f5751a     // Catch:{ CertificateEncodingException -> 0x00e2 }
            byte[] r4 = r0.r()     // Catch:{ CertificateEncodingException -> 0x00e2 }
        L_0x00df:
            org.spongycastle.util.Arrays.a(r8, r4)     // Catch:{ CertificateEncodingException -> 0x00e2 }
        L_0x00e2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.x509.AttributeCertificateHolder.match(java.security.cert.Certificate):boolean");
    }
}
