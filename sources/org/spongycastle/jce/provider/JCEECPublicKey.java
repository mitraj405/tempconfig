package org.spongycastle.jce.provider;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X962Parameters;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ECPoint;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.util.Strings;

public class JCEECPublicKey implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    public ECParameterSpec a;

    /* renamed from: a  reason: collision with other field name */
    public GOST3410PublicKeyAlgParameters f6578a;

    /* renamed from: a  reason: collision with other field name */
    public ECPoint f6579a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6580a;
    public String c;

    /* JADX WARNING: type inference failed for: r0v13, types: [org.spongycastle.asn1.ASN1Primitive] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void readObject(java.io.ObjectInputStream r15) throws java.io.IOException, java.lang.ClassNotFoundException {
        /*
            r14 = this;
            java.lang.Object r0 = r15.readObject()
            byte[] r0 = (byte[]) r0
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.asn1.ASN1Primitive.k(r0)
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r0 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.g(r0)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r0.f5753a
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.Z0
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers.l
            boolean r1 = r1.equals(r2)
            r2 = 1
            java.lang.String r3 = "error recovering public key"
            r4 = 0
            org.spongycastle.asn1.DERBitString r5 = r0.a
            org.spongycastle.asn1.x509.AlgorithmIdentifier r0 = r0.f5753a
            if (r1 == 0) goto L_0x00b1
            java.lang.String r1 = "ECGOST3410"
            r14.c = r1
            byte[] r1 = r5.r()     // Catch:{ IOException -> 0x00ab }
            org.spongycastle.asn1.ASN1Primitive r1 = org.spongycastle.asn1.ASN1Primitive.k(r1)     // Catch:{ IOException -> 0x00ab }
            org.spongycastle.asn1.ASN1OctetString r1 = (org.spongycastle.asn1.ASN1OctetString) r1     // Catch:{ IOException -> 0x00ab }
            byte[] r1 = r1.s()
            r3 = 32
            byte[] r5 = new byte[r3]
            byte[] r6 = new byte[r3]
            r7 = r4
        L_0x003b:
            if (r7 == r3) goto L_0x0046
            int r8 = 31 - r7
            byte r8 = r1[r8]
            r5[r7] = r8
            int r7 = r7 + 1
            goto L_0x003b
        L_0x0046:
            r7 = r4
        L_0x0047:
            if (r7 == r3) goto L_0x0052
            int r8 = 63 - r7
            byte r8 = r1[r8]
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x0047
        L_0x0052:
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r1 = new org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters
            org.spongycastle.asn1.ASN1Encodable r0 = r0.a
            org.spongycastle.asn1.ASN1Sequence r0 = (org.spongycastle.asn1.ASN1Sequence) r0
            r1.<init>(r0)
            r14.f6578a = r1
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = r1.Z0
            java.lang.String r0 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.b(r0)
            org.spongycastle.jce.spec.ECNamedCurveParameterSpec r0 = org.spongycastle.jce.ECGOST3410NamedCurveTable.a(r0)
            org.spongycastle.math.ec.ECCurve r1 = r0.f6602a
            java.security.spec.EllipticCurve r9 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.a(r1)
            java.math.BigInteger r3 = new java.math.BigInteger
            r3.<init>(r2, r5)
            java.math.BigInteger r5 = new java.math.BigInteger
            r5.<init>(r2, r6)
            org.spongycastle.math.ec.ECPoint r1 = r1.d(r3, r5, r4)
            r14.f6579a = r1
            org.spongycastle.jce.spec.ECNamedCurveSpec r1 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r2 = r14.f6578a
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r2.Z0
            java.lang.String r8 = org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves.b(r2)
            java.security.spec.ECPoint r10 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r2 = r0.f6603a
            r2.b()
            org.spongycastle.math.ec.ECFieldElement r3 = r2.f6621a
            java.math.BigInteger r3 = r3.t()
            org.spongycastle.math.ec.ECFieldElement r2 = r2.e()
            java.math.BigInteger r2 = r2.t()
            r10.<init>(r3, r2)
            java.math.BigInteger r11 = r0.a
            java.math.BigInteger r12 = r0.b
            r7 = r1
            r7.<init>(r8, r9, r10, r11, r12)
            r14.a = r1
            goto L_0x018a
        L_0x00ab:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r3)
            throw r15
        L_0x00b1:
            org.spongycastle.asn1.x9.X962Parameters r1 = new org.spongycastle.asn1.x9.X962Parameters
            org.spongycastle.asn1.ASN1Encodable r0 = r0.a
            org.spongycastle.asn1.ASN1Primitive r0 = (org.spongycastle.asn1.ASN1Primitive) r0
            r1.<init>((org.spongycastle.asn1.ASN1Primitive) r0)
            org.spongycastle.asn1.ASN1Primitive r0 = r1.a
            boolean r1 = r0 instanceof org.spongycastle.asn1.ASN1ObjectIdentifier
            if (r1 == 0) goto L_0x00fb
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r0
            org.spongycastle.asn1.x9.X9ECParameters r1 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.g(r0)
            org.spongycastle.math.ec.ECCurve r6 = r1.f5787a
            java.security.spec.EllipticCurve r9 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.a(r6)
            org.spongycastle.jce.spec.ECNamedCurveSpec r13 = new org.spongycastle.jce.spec.ECNamedCurveSpec
            java.lang.String r8 = org.spongycastle.jcajce.provider.asymmetric.util.ECUtil.d(r0)
            java.security.spec.ECPoint r10 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r0 = r1.g()
            r0.b()
            org.spongycastle.math.ec.ECFieldElement r0 = r0.f6621a
            java.math.BigInteger r0 = r0.t()
            org.spongycastle.math.ec.ECPoint r7 = r1.g()
            org.spongycastle.math.ec.ECFieldElement r7 = r7.e()
            java.math.BigInteger r7 = r7.t()
            r10.<init>(r0, r7)
            java.math.BigInteger r11 = r1.a
            java.math.BigInteger r12 = r1.b
            r7 = r13
            r7.<init>(r8, r9, r10, r11, r12)
            r14.a = r13
            goto L_0x0144
        L_0x00fb:
            boolean r1 = r0 instanceof org.spongycastle.asn1.ASN1Null
            if (r1 == 0) goto L_0x010d
            r0 = 0
            r14.a = r0
            org.spongycastle.jcajce.provider.config.ProviderConfiguration r0 = org.spongycastle.jce.provider.BouncyCastleProvider.f6565a
            org.spongycastle.jce.provider.BouncyCastleProviderConfiguration r0 = (org.spongycastle.jce.provider.BouncyCastleProviderConfiguration) r0
            org.spongycastle.jce.spec.ECParameterSpec r0 = r0.d()
            org.spongycastle.math.ec.ECCurve r6 = r0.f6602a
            goto L_0x0144
        L_0x010d:
            org.spongycastle.asn1.x9.X9ECParameters r0 = org.spongycastle.asn1.x9.X9ECParameters.h(r0)
            org.spongycastle.math.ec.ECCurve r6 = r0.f5787a
            java.security.spec.EllipticCurve r1 = org.spongycastle.jcajce.provider.asymmetric.util.EC5Util.a(r6)
            java.security.spec.ECParameterSpec r7 = new java.security.spec.ECParameterSpec
            java.security.spec.ECPoint r8 = new java.security.spec.ECPoint
            org.spongycastle.math.ec.ECPoint r9 = r0.g()
            r9.b()
            org.spongycastle.math.ec.ECFieldElement r9 = r9.f6621a
            java.math.BigInteger r9 = r9.t()
            org.spongycastle.math.ec.ECPoint r10 = r0.g()
            org.spongycastle.math.ec.ECFieldElement r10 = r10.e()
            java.math.BigInteger r10 = r10.t()
            r8.<init>(r9, r10)
            java.math.BigInteger r9 = r0.b
            int r9 = r9.intValue()
            java.math.BigInteger r0 = r0.a
            r7.<init>(r1, r8, r0, r9)
            r14.a = r7
        L_0x0144:
            byte[] r0 = r5.r()
            org.spongycastle.asn1.DEROctetString r1 = new org.spongycastle.asn1.DEROctetString
            r1.<init>(r0)
            byte r4 = r0[r4]
            r5 = 4
            if (r4 != r5) goto L_0x017f
            byte r2 = r0[r2]
            int r4 = r0.length
            r5 = 2
            int r4 = r4 - r5
            if (r2 != r4) goto L_0x017f
            byte r2 = r0[r5]
            r4 = 3
            if (r2 == r5) goto L_0x0160
            if (r2 != r4) goto L_0x017f
        L_0x0160:
            org.spongycastle.asn1.x9.X9IntegerConverter r2 = new org.spongycastle.asn1.x9.X9IntegerConverter
            r2.<init>()
            int r2 = r6.k()
            int r2 = r2 + 7
            int r2 = r2 / 8
            int r5 = r0.length
            int r5 = r5 - r4
            if (r2 < r5) goto L_0x017f
            org.spongycastle.asn1.ASN1Primitive r0 = org.spongycastle.asn1.ASN1Primitive.k(r0)     // Catch:{ IOException -> 0x0179 }
            r1 = r0
            org.spongycastle.asn1.ASN1OctetString r1 = (org.spongycastle.asn1.ASN1OctetString) r1     // Catch:{ IOException -> 0x0179 }
            goto L_0x017f
        L_0x0179:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            r15.<init>(r3)
            throw r15
        L_0x017f:
            org.spongycastle.asn1.x9.X9ECPoint r0 = new org.spongycastle.asn1.x9.X9ECPoint
            r0.<init>((org.spongycastle.math.ec.ECCurve) r6, (org.spongycastle.asn1.ASN1OctetString) r1)
            org.spongycastle.math.ec.ECPoint r0 = r0.g()
            r14.f6579a = r0
        L_0x018a:
            java.lang.Object r0 = r15.readObject()
            java.lang.String r0 = (java.lang.String) r0
            r14.c = r0
            boolean r15 = r15.readBoolean()
            r14.f6580a = r15
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jce.provider.JCEECPublicKey.readObject(java.io.ObjectInputStream):void");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getEncoded());
        objectOutputStream.writeObject(this.c);
        objectOutputStream.writeBoolean(this.f6580a);
    }

    public final org.spongycastle.jce.spec.ECParameterSpec a() {
        ECParameterSpec eCParameterSpec = this.a;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.f(eCParameterSpec, this.f6580a);
    }

    public final org.spongycastle.jce.spec.ECParameterSpec b() {
        ECParameterSpec eCParameterSpec = this.a;
        if (eCParameterSpec != null) {
            return EC5Util.f(eCParameterSpec, this.f6580a);
        }
        return ((BouncyCastleProviderConfiguration) BouncyCastleProvider.f6565a).d();
    }

    public final void c(byte[] bArr, int i, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < 32) {
            byte[] bArr2 = new byte[32];
            System.arraycopy(byteArray, 0, bArr2, 32 - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i2 = 0; i2 != 32; i2++) {
            bArr[i + i2] = byteArray[(byteArray.length - 1) - i2];
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof JCEECPublicKey)) {
            return false;
        }
        JCEECPublicKey jCEECPublicKey = (JCEECPublicKey) obj;
        if (!this.f6579a.d(jCEECPublicKey.f6579a) || !b().equals(jCEECPublicKey.b())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo;
        X962Parameters x962Parameters;
        ASN1Encodable aSN1Encodable;
        if (this.c.equals("ECGOST3410")) {
            ASN1Encodable aSN1Encodable2 = this.f6578a;
            if (aSN1Encodable2 == null) {
                ECParameterSpec eCParameterSpec = this.a;
                if (eCParameterSpec instanceof ECNamedCurveSpec) {
                    aSN1Encodable = new GOST3410PublicKeyAlgParameters((ASN1ObjectIdentifier) ECGOST3410NamedCurves.a.get(((ECNamedCurveSpec) eCParameterSpec).a), CryptoProObjectIdentifiers.o);
                } else {
                    ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
                    aSN1Encodable = new X962Parameters(new X9ECParameters(b, EC5Util.d(b, this.a.getGenerator()), this.a.getOrder(), BigInteger.valueOf((long) this.a.getCofactor()), this.a.getCurve().getSeed()));
                }
                aSN1Encodable2 = aSN1Encodable;
            }
            ECPoint eCPoint = this.f6579a;
            eCPoint.b();
            BigInteger t = eCPoint.f6621a.t();
            BigInteger t2 = this.f6579a.e().t();
            byte[] bArr = new byte[64];
            c(bArr, 0, t);
            c(bArr, 32, t2);
            try {
                subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(CryptoProObjectIdentifiers.l, aSN1Encodable2), (ASN1Object) new DEROctetString(bArr));
            } catch (IOException unused) {
                return null;
            }
        } else {
            ECParameterSpec eCParameterSpec2 = this.a;
            if (eCParameterSpec2 instanceof ECNamedCurveSpec) {
                ASN1ObjectIdentifier h = ECUtil.h(((ECNamedCurveSpec) eCParameterSpec2).a);
                if (h == null) {
                    h = new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.a).a);
                }
                x962Parameters = new X962Parameters(h);
            } else if (eCParameterSpec2 == null) {
                x962Parameters = new X962Parameters(DERNull.a);
            } else {
                ECCurve b2 = EC5Util.b(eCParameterSpec2.getCurve());
                x962Parameters = new X962Parameters(new X9ECParameters(b2, EC5Util.d(b2, this.a.getGenerator()), this.a.getOrder(), BigInteger.valueOf((long) this.a.getCofactor()), this.a.getCurve().getSeed()));
            }
            ECCurve eCCurve = this.f6579a.f6620a;
            ECPoint w = w();
            w.b();
            subjectPublicKeyInfo = new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.q0, x962Parameters), new X9ECPoint(eCCurve.d(w.f6621a.t(), w().e().t(), this.f6580a)).a.a);
        }
        return KeyUtil.c(subjectPublicKeyInfo);
    }

    public final String getFormat() {
        return "X.509";
    }

    public final ECParameterSpec getParams() {
        return this.a;
    }

    public final java.security.spec.ECPoint getW() {
        ECPoint eCPoint = this.f6579a;
        eCPoint.b();
        return new java.security.spec.ECPoint(eCPoint.f6621a.t(), this.f6579a.e().t());
    }

    public final int hashCode() {
        return this.f6579a.hashCode() ^ b().hashCode();
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("EC Public Key");
        String str = Strings.a;
        stringBuffer.append(str);
        stringBuffer.append("            X: ");
        ECPoint eCPoint = this.f6579a;
        eCPoint.b();
        stringBuffer.append(eCPoint.f6621a.t().toString(16));
        stringBuffer.append(str);
        stringBuffer.append("            Y: ");
        stringBuffer.append(this.f6579a.e().t().toString(16));
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public final ECPoint w() {
        if (this.a == null) {
            return this.f6579a.o().c();
        }
        return this.f6579a;
    }
}
