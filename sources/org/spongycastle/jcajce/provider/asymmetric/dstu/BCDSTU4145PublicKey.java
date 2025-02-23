package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.ua.DSTU4145Params;
import org.spongycastle.asn1.ua.DSTU4145PointEncoder;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;

public class BCDSTU4145PublicKey implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 7026240464295649314L;
    public transient ECParameterSpec a;

    /* renamed from: a  reason: collision with other field name */
    public transient DSTU4145Params f6376a;

    /* renamed from: a  reason: collision with other field name */
    public transient ECPublicKeyParameters f6377a;
    public String c;

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.c = "DSTU4145";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.a = params;
        this.f6377a = new ECPublicKeyParameters(EC5Util.c(params, eCPublicKeySpec.getW()), EC5Util.i((ProviderConfiguration) null, this.a));
    }

    public static void e(byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            byte b = bArr[i];
            bArr[i] = bArr[(bArr.length - 1) - i];
            bArr[(bArr.length - 1) - i] = b;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
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
        return BouncyCastleProvider.f6565a.d();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: org.spongycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: org.spongycastle.jce.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: org.spongycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: org.spongycastle.jce.spec.ECNamedCurveParameterSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            org.spongycastle.asn1.DERBitString r2 = r1.a
            java.lang.String r3 = "DSTU4145"
            r0.c = r3
            byte[] r2 = r2.r()     // Catch:{ IOException -> 0x0186 }
            org.spongycastle.asn1.ASN1Primitive r2 = org.spongycastle.asn1.ASN1Primitive.k(r2)     // Catch:{ IOException -> 0x0186 }
            org.spongycastle.asn1.ASN1OctetString r2 = (org.spongycastle.asn1.ASN1OctetString) r2     // Catch:{ IOException -> 0x0186 }
            byte[] r2 = r2.s()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r1.f5753a
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r1.Z0
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.ua.UAObjectIdentifiers.a
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0027
            e(r2)
        L_0x0027:
            org.spongycastle.asn1.ASN1Encodable r3 = r1.a
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3
            boolean r5 = r3 instanceof org.spongycastle.asn1.ua.DSTU4145Params
            r6 = 0
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0035
            org.spongycastle.asn1.ua.DSTU4145Params r3 = (org.spongycastle.asn1.ua.DSTU4145Params) r3
            goto L_0x0093
        L_0x0035:
            java.lang.String r5 = "object parse error"
            if (r3 == 0) goto L_0x0180
            org.spongycastle.asn1.ASN1Sequence r3 = org.spongycastle.asn1.ASN1Sequence.q(r3)
            org.spongycastle.asn1.ASN1Encodable r9 = r3.s(r6)
            boolean r9 = r9 instanceof org.spongycastle.asn1.ASN1ObjectIdentifier
            if (r9 == 0) goto L_0x0053
            org.spongycastle.asn1.ua.DSTU4145Params r9 = new org.spongycastle.asn1.ua.DSTU4145Params
            org.spongycastle.asn1.ASN1Encodable r10 = r3.s(r6)
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = org.spongycastle.asn1.ASN1ObjectIdentifier.u(r10)
            r9.<init>((org.spongycastle.asn1.ASN1ObjectIdentifier) r10)
            goto L_0x0071
        L_0x0053:
            org.spongycastle.asn1.ua.DSTU4145Params r9 = new org.spongycastle.asn1.ua.DSTU4145Params
            org.spongycastle.asn1.ASN1Encodable r10 = r3.s(r6)
            boolean r11 = r10 instanceof org.spongycastle.asn1.ua.DSTU4145ECBinary
            if (r11 == 0) goto L_0x0060
            org.spongycastle.asn1.ua.DSTU4145ECBinary r10 = (org.spongycastle.asn1.ua.DSTU4145ECBinary) r10
            goto L_0x006e
        L_0x0060:
            if (r10 == 0) goto L_0x006d
            org.spongycastle.asn1.ua.DSTU4145ECBinary r11 = new org.spongycastle.asn1.ua.DSTU4145ECBinary
            org.spongycastle.asn1.ASN1Sequence r10 = org.spongycastle.asn1.ASN1Sequence.q(r10)
            r11.<init>(r10)
            r10 = r11
            goto L_0x006e
        L_0x006d:
            r10 = r8
        L_0x006e:
            r9.<init>((org.spongycastle.asn1.ua.DSTU4145ECBinary) r10)
        L_0x0071:
            int r10 = r3.size()
            r11 = 2
            if (r10 != r11) goto L_0x0092
            org.spongycastle.asn1.ASN1Encodable r3 = r3.s(r7)
            org.spongycastle.asn1.ASN1OctetString r3 = org.spongycastle.asn1.ASN1OctetString.q(r3)
            byte[] r3 = r3.s()
            r9.f5718a = r3
            int r3 = r3.length
            r10 = 64
            if (r3 != r10) goto L_0x008c
            goto L_0x0092
        L_0x008c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r5)
            throw r1
        L_0x0092:
            r3 = r9
        L_0x0093:
            r0.f6376a = r3
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = r3.Z0
            if (r5 == 0) goto L_0x009b
            r9 = r7
            goto L_0x009c
        L_0x009b:
            r9 = r6
        L_0x009c:
            if (r9 == 0) goto L_0x00b7
            org.spongycastle.crypto.params.ECDomainParameters r1 = org.spongycastle.asn1.ua.DSTU4145NamedCurves.a(r5)
            org.spongycastle.jce.spec.ECNamedCurveParameterSpec r3 = new org.spongycastle.jce.spec.ECNamedCurveParameterSpec
            java.lang.String r10 = r5.c
            org.spongycastle.math.ec.ECCurve r11 = r1.a
            org.spongycastle.math.ec.ECPoint r12 = r1.f6230a
            java.math.BigInteger r13 = r1.g
            java.math.BigInteger r14 = r1.h
            byte[] r15 = r1.a()
            r9 = r3
            r9.<init>(r10, r11, r12, r13, r14, r15)
            goto L_0x010f
        L_0x00b7:
            org.spongycastle.asn1.ua.DSTU4145ECBinary r3 = r3.a
            org.spongycastle.asn1.ASN1OctetString r5 = r3.f5713a
            byte[] r5 = r5.s()
            byte[] r5 = org.spongycastle.util.Arrays.c(r5)
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.Z0
            boolean r9 = r1.equals(r4)
            if (r9 == 0) goto L_0x00ce
            e(r5)
        L_0x00ce:
            org.spongycastle.math.ec.ECCurve$F2m r9 = new org.spongycastle.math.ec.ECCurve$F2m
            org.spongycastle.asn1.ua.DSTU4145BinaryField r10 = r3.f5714a
            int r11 = r10.c
            int r12 = r10.d
            int r13 = r10.e
            int r14 = r10.f
            org.spongycastle.asn1.ASN1Integer r10 = r3.f5712a
            java.math.BigInteger r15 = r10.t()
            java.math.BigInteger r10 = new java.math.BigInteger
            r10.<init>(r7, r5)
            r5 = r10
            r10 = r9
            r16 = r5
            r10.<init>((int) r11, (int) r12, (int) r13, (int) r14, (java.math.BigInteger) r15, (java.math.BigInteger) r16)
            org.spongycastle.asn1.ASN1OctetString r5 = r3.f5715b
            byte[] r5 = r5.s()
            byte[] r5 = org.spongycastle.util.Arrays.c(r5)
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00ff
            e(r5)
        L_0x00ff:
            org.spongycastle.jce.spec.ECParameterSpec r1 = new org.spongycastle.jce.spec.ECParameterSpec
            org.spongycastle.math.ec.ECPoint r4 = org.spongycastle.asn1.ua.DSTU4145PointEncoder.a(r9, r5)
            org.spongycastle.asn1.ASN1Integer r3 = r3.b
            java.math.BigInteger r3 = r3.t()
            r1.<init>(r9, r4, r3)
            r3 = r1
        L_0x010f:
            org.spongycastle.math.ec.ECCurve r1 = r3.f6602a
            java.security.spec.EllipticCurve r11 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.a(r1)
            org.spongycastle.asn1.ua.DSTU4145Params r4 = r0.f6376a
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r4.Z0
            if (r4 == 0) goto L_0x011c
            r6 = r7
        L_0x011c:
            org.spongycastle.math.ec.ECPoint r4 = r3.f6603a
            if (r6 == 0) goto L_0x0149
            org.spongycastle.jce.spec.ECNamedCurveSpec r5 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            org.spongycastle.asn1.ua.DSTU4145Params r6 = r0.f6376a
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = r6.Z0
            java.lang.String r10 = r6.c
            java.security.spec.ECPoint r12 = new java.security.spec.ECPoint
            r4.b()
            org.spongycastle.math.ec.ECFieldElement r6 = r4.f6621a
            java.math.BigInteger r6 = r6.t()
            org.spongycastle.math.ec.ECFieldElement r4 = r4.e()
            java.math.BigInteger r4 = r4.t()
            r12.<init>(r6, r4)
            java.math.BigInteger r13 = r3.a
            java.math.BigInteger r14 = r3.b
            r9 = r5
            r9.<init>(r10, r11, r12, r13, r14)
            r0.a = r5
            goto L_0x016e
        L_0x0149:
            java.security.spec.ECParameterSpec r5 = new java.security.spec.ECParameterSpec
            java.security.spec.ECPoint r6 = new java.security.spec.ECPoint
            r4.b()
            org.spongycastle.math.ec.ECFieldElement r7 = r4.f6621a
            java.math.BigInteger r7 = r7.t()
            org.spongycastle.math.ec.ECFieldElement r4 = r4.e()
            java.math.BigInteger r4 = r4.t()
            r6.<init>(r7, r4)
            java.math.BigInteger r4 = r3.b
            int r4 = r4.intValue()
            java.math.BigInteger r3 = r3.a
            r5.<init>(r11, r6, r3, r4)
            r0.a = r5
        L_0x016e:
            org.spongycastle.crypto.params.ECPublicKeyParameters r3 = new org.spongycastle.crypto.params.ECPublicKeyParameters
            org.spongycastle.math.ec.ECPoint r1 = org.spongycastle.asn1.ua.DSTU4145PointEncoder.a(r1, r2)
            java.security.spec.ECParameterSpec r2 = r0.a
            org.spongycastle.crypto.params.ECDomainParameters r2 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.i(r8, r2)
            r3.<init>(r1, r2)
            r0.f6377a = r3
            return
        L_0x0180:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            r1.<init>(r5)
            throw r1
        L_0x0186:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "error recovering public key"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey.d(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        if (!this.f6377a.a.d(bCDSTU4145PublicKey.f6377a.a) || !c().equals(bCDSTU4145PublicKey.c())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        ASN1Encodable aSN1Encodable = this.f6376a;
        if (aSN1Encodable == null) {
            ECParameterSpec eCParameterSpec = this.a;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                aSN1Encodable = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.a).a));
            } else {
                ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
                aSN1Encodable = new X962Parameters(new X9ECParameters(b, EC5Util.d(b, this.a.getGenerator()), this.a.getOrder(), BigInteger.valueOf((long) this.a.getCofactor()), this.a.getCurve().getSeed()));
            }
        }
        ECPoint o = this.f6377a.a.o();
        o.b();
        ECFieldElement eCFieldElement = o.f6621a;
        byte[] e = eCFieldElement.e();
        if (!eCFieldElement.i()) {
            if (DSTU4145PointEncoder.b(o.e().d(eCFieldElement)).h()) {
                int length = e.length - 1;
                e[length] = (byte) (e[length] | 1);
            } else {
                int length2 = e.length - 1;
                e[length2] = (byte) (e[length2] & 254);
            }
        }
        try {
            return KeyUtil.c(new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.b, aSN1Encodable), (ASN1Object) new DEROctetString(e)));
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final ECParameterSpec getParams() {
        return this.a;
    }

    public final java.security.spec.ECPoint getW() {
        ECPoint eCPoint = this.f6377a.a;
        eCPoint.b();
        return new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t());
    }

    public final int hashCode() {
        return this.f6377a.a.hashCode() ^ c().hashCode();
    }

    public final String toString() {
        return ECUtil.l(this.c, this.f6377a.a, c());
    }

    public final ECPoint w() {
        ECPoint eCPoint = this.f6377a.a;
        if (this.a == null) {
            return eCPoint.o().c();
        }
        return eCPoint;
    }

    public BCDSTU4145PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.c = "DSTU4145";
        org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = eCPublicKeySpec.a;
        ECPoint eCPoint = eCPublicKeySpec.a;
        if (eCParameterSpec != null) {
            EllipticCurve a2 = EC5Util.a(eCParameterSpec.f6602a);
            org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec2 = eCPublicKeySpec.a;
            this.f6377a = new ECPublicKeyParameters(eCPoint, ECUtil.e(providerConfiguration, eCParameterSpec2));
            this.a = EC5Util.e(a2, eCParameterSpec2);
            return;
        }
        ECCurve eCCurve = providerConfiguration.d().f6602a;
        eCPoint.b();
        this.f6377a = new ECPublicKeyParameters(eCCurve.d(eCPoint.f6621a.t(), eCPoint.e().t(), false), EC5Util.i(providerConfiguration, (ECParameterSpec) null));
        this.a = null;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.c = "DSTU4145";
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        this.c = str;
        this.f6377a = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            this.a = b(EC5Util.a(eCCurve), eCDomainParameters);
            return;
        }
        this.a = eCParameterSpec;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        this.c = "DSTU4145";
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        this.c = str;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            this.a = b(EC5Util.a(eCCurve), eCDomainParameters);
        } else {
            this.a = EC5Util.e(EC5Util.a(eCParameterSpec.f6602a), eCParameterSpec);
        }
        this.f6377a = eCPublicKeyParameters;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.c = str;
        this.f6377a = eCPublicKeyParameters;
        this.a = null;
    }

    public BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.c = "DSTU4145";
        d(subjectPublicKeyInfo);
    }
}
