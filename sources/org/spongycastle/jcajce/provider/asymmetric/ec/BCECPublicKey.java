package org.spongycastle.jcajce.provider.asymmetric.ec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class BCECPublicKey implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 2422789860422731812L;
    public transient ECParameterSpec a;

    /* renamed from: a  reason: collision with other field name */
    public transient ECPublicKeyParameters f6388a;

    /* renamed from: a  reason: collision with other field name */
    public transient ProviderConfiguration f6389a;
    public final String c = "EC";

    public BCECPublicKey(String str, ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.c = str;
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.a = params;
        this.f6388a = new ECPublicKeyParameters(EC5Util.c(params, eCPublicKeySpec.getW()), EC5Util.i(providerConfiguration, eCPublicKeySpec.getParams()));
        this.f6389a = providerConfiguration;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6389a = BouncyCastleProvider.f6565a;
        d(SubjectPublicKeyInfo.g(ASN1Primitive.k((byte[]) objectInputStream.readObject())));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.a;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.f(eCParameterSpec, false);
    }

    public final ECParameterSpec b(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        ECPoint eCPoint = eCDomainParameters.f6230a;
        eCPoint.b();
        return new ECParameterSpec(ellipticCurve, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), eCDomainParameters.g, eCDomainParameters.h.intValue());
    }

    public final org.spongycastle.jce.spec.ECParameterSpec c() {
        ECParameterSpec eCParameterSpec = this.a;
        if (eCParameterSpec != null) {
            return EC5Util.f(eCParameterSpec, false);
        }
        return this.f6389a.d();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: org.spongycastle.asn1.x9.X9ECParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: org.spongycastle.crypto.params.ECDomainParameters} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: org.spongycastle.crypto.params.ECDomainParameters} */
    /* JADX WARNING: type inference failed for: r8v0 */
    /* JADX WARNING: type inference failed for: r11v6, types: [org.spongycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r11) {
        /*
            r10 = this;
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r11.f5753a
            org.spongycastle.asn1.ASN1Encodable r0 = r0.a
            org.spongycastle.asn1.x9.X962Parameters r0 = org.spongycastle.asn1.x9.X962Parameters.g(r0)
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r1 = r10.f6389a
            org.spongycastle.math.ec.ECCurve r1 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.h(r1, r0)
            java.security.spec.ECParameterSpec r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.g(r0, r1)
            r10.a = r2
            org.spongycastle.asn1.DERBitString r11 = r11.a
            byte[] r11 = r11.r()
            org.spongycastle.asn1.DEROctetString r2 = new org.spongycastle.asn1.DEROctetString
            r2.<init>(r11)
            r3 = 0
            byte r3 = r11[r3]
            r4 = 4
            if (r3 != r4) goto L_0x0055
            r3 = 1
            byte r3 = r11[r3]
            int r4 = r11.length
            r5 = 2
            int r4 = r4 - r5
            if (r3 != r4) goto L_0x0055
            byte r3 = r11[r5]
            r4 = 3
            if (r3 == r5) goto L_0x0034
            if (r3 != r4) goto L_0x0055
        L_0x0034:
            org.spongycastle.asn1.x9.X9IntegerConverter r3 = new org.spongycastle.asn1.x9.X9IntegerConverter
            r3.<init>()
            int r3 = r1.k()
            int r3 = r3 + 7
            int r3 = r3 / 8
            int r5 = r11.length
            int r5 = r5 - r4
            if (r3 < r5) goto L_0x0055
            org.spongycastle.asn1.ASN1Primitive r11 = org.spongycastle.asn1.ASN1Primitive.k(r11)     // Catch:{ IOException -> 0x004d }
            r2 = r11
            org.spongycastle.asn1.ASN1OctetString r2 = (org.spongycastle.asn1.ASN1OctetString) r2     // Catch:{ IOException -> 0x004d }
            goto L_0x0055
        L_0x004d:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r11.<init>(r0)
            throw r11
        L_0x0055:
            org.spongycastle.asn1.x9.X9ECPoint r11 = new org.spongycastle.asn1.x9.X9ECPoint
            r11.<init>((org.spongycastle.math.ec.ECCurve) r1, (org.spongycastle.asn1.ASN1OctetString) r2)
            org.spongycastle.crypto.params.ECPublicKeyParameters r1 = new org.spongycastle.crypto.params.ECPublicKeyParameters
            org.spongycastle.math.ec.ECPoint r11 = r11.g()
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r2 = r10.f6389a
            org.spongycastle.asn1.ASN1Primitive r0 = r0.a
            boolean r3 = r0 instanceof org.spongycastle.asn1.ASN1ObjectIdentifier
            if (r3 == 0) goto L_0x0090
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.ASN1ObjectIdentifier.u(r0)
            org.spongycastle.asn1.x9.X9ECParameters r3 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.g(r0)
            if (r3 != 0) goto L_0x007d
            java.util.Map r2 = r2.c()
            java.lang.Object r0 = r2.get(r0)
            r3 = r0
            org.spongycastle.asn1.x9.X9ECParameters r3 = (org.spongycastle.asn1.x9.X9ECParameters) r3
        L_0x007d:
            org.spongycastle.crypto.params.ECNamedDomainParameters r0 = new org.spongycastle.crypto.params.ECNamedDomainParameters
            org.spongycastle.math.ec.ECCurve r5 = r3.f5787a
            org.spongycastle.math.ec.ECPoint r6 = r3.g()
            java.math.BigInteger r7 = r3.a
            java.math.BigInteger r8 = r3.b
            byte[] r9 = r3.f5788a
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            goto L_0x00c0
        L_0x0090:
            boolean r3 = r0 instanceof org.spongycastle.asn1.ASN1Null
            if (r3 == 0) goto L_0x00a9
            org.spongycastle.jce.spec.ECParameterSpec r0 = r2.d()
            org.spongycastle.crypto.params.ECDomainParameters r8 = new org.spongycastle.crypto.params.ECDomainParameters
            org.spongycastle.math.ec.ECCurve r3 = r0.f6602a
            org.spongycastle.math.ec.ECPoint r4 = r0.f6603a
            java.math.BigInteger r5 = r0.a
            java.math.BigInteger r6 = r0.b
            byte[] r7 = r0.f6604a
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x00bf
        L_0x00a9:
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.x9.X9ECParameters.h(r0)
            org.spongycastle.crypto.params.ECDomainParameters r8 = new org.spongycastle.crypto.params.ECDomainParameters
            org.spongycastle.math.ec.ECCurve r3 = r0.f5787a
            org.spongycastle.math.ec.ECPoint r4 = r0.g()
            java.math.BigInteger r5 = r0.a
            java.math.BigInteger r6 = r0.b
            byte[] r7 = r0.f5788a
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x00bf:
            r0 = r8
        L_0x00c0:
            r1.<init>(r11, r0)
            r10.f6388a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.ec.BCECPublicKey.d(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCECPublicKey)) {
            return false;
        }
        BCECPublicKey bCECPublicKey = (BCECPublicKey) obj;
        if (!this.f6388a.a.d(bCECPublicKey.f6388a.a) || !c().equals(bCECPublicKey.c())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        return KeyUtil.c(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.q0, ECUtils.b(this.a)), ASN1OctetString.q(new X9ECPoint(this.f6388a.a).a).s()));
    }

    public final String getFormat() {
        return "X.509";
    }

    public final ECParameterSpec getParams() {
        return this.a;
    }

    public final java.security.spec.ECPoint getW() {
        ECPoint eCPoint = this.f6388a.a;
        eCPoint.b();
        return new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t());
    }

    public final int hashCode() {
        return this.f6388a.a.hashCode() ^ c().hashCode();
    }

    public final String toString() {
        return ECUtil.l("EC", this.f6388a.a, c());
    }

    public final ECPoint w() {
        ECPoint eCPoint = this.f6388a.a;
        if (this.a == null) {
            return eCPoint.o().c();
        }
        return eCPoint;
    }

    public BCECPublicKey(String str, org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.c = str;
        org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = eCPublicKeySpec.a;
        ECPoint eCPoint = eCPublicKeySpec.a;
        if (eCParameterSpec != null) {
            EllipticCurve a2 = EC5Util.a(eCParameterSpec.f6602a);
            org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec2 = eCPublicKeySpec.a;
            this.f6388a = new ECPublicKeyParameters(eCPoint, ECUtil.e(providerConfiguration, eCParameterSpec2));
            this.a = EC5Util.e(a2, eCParameterSpec2);
        } else {
            ECCurve eCCurve = providerConfiguration.d().f6602a;
            eCPoint.b();
            this.f6388a = new ECPublicKeyParameters(eCCurve.d(eCPoint.f6621a.t(), eCPoint.e().t(), false), EC5Util.i(providerConfiguration, (ECParameterSpec) null));
            this.a = null;
        }
        this.f6389a = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        this.c = str;
        this.f6388a = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            this.a = b(EC5Util.a(eCCurve), eCDomainParameters);
        } else {
            this.a = eCParameterSpec;
        }
        this.f6389a = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec, ProviderConfiguration providerConfiguration) {
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        this.c = str;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            this.a = b(EC5Util.a(eCCurve), eCDomainParameters);
        } else {
            this.a = EC5Util.e(EC5Util.a(eCParameterSpec.f6602a), eCParameterSpec);
        }
        this.f6388a = eCPublicKeyParameters;
        this.f6389a = providerConfiguration;
    }

    public BCECPublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ProviderConfiguration providerConfiguration) {
        this.c = str;
        this.f6388a = eCPublicKeyParameters;
        this.a = null;
        this.f6389a = providerConfiguration;
    }

    public BCECPublicKey(ECPublicKey eCPublicKey, ProviderConfiguration providerConfiguration) {
        this.c = eCPublicKey.getAlgorithm();
        ECParameterSpec params = eCPublicKey.getParams();
        this.a = params;
        this.f6388a = new ECPublicKeyParameters(EC5Util.c(params, eCPublicKey.getW()), EC5Util.i(providerConfiguration, eCPublicKey.getParams()));
    }

    public BCECPublicKey(String str, SubjectPublicKeyInfo subjectPublicKeyInfo, ProviderConfiguration providerConfiguration) {
        this.c = str;
        this.f6389a = providerConfiguration;
        d(subjectPublicKeyInfo);
    }
}
