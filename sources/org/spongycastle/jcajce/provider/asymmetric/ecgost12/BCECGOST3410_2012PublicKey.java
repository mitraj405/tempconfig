package org.spongycastle.jcajce.provider.asymmetric.ecgost12;

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
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.spongycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.spongycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
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
import org.spongycastle.jce.ECGOST3410NamedCurveTable;
import org.spongycastle.jce.interfaces.ECPointEncoder;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.spec.ECNamedCurveParameterSpec;
import org.spongycastle.jce.spec.ECNamedCurveSpec;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECPoint;

public class BCECGOST3410_2012PublicKey implements ECPublicKey, org.spongycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    static final long serialVersionUID = 7026240464295649314L;
    public transient ECParameterSpec a;

    /* renamed from: a  reason: collision with other field name */
    public transient GOST3410PublicKeyAlgParameters f6426a;

    /* renamed from: a  reason: collision with other field name */
    public transient ECPublicKeyParameters f6427a;
    public String c;

    public BCECGOST3410_2012PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        this.c = "ECGOST3410-2012";
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.a = params;
        this.f6427a = new ECPublicKeyParameters(EC5Util.c(params, eCPublicKeySpec.getW()), EC5Util.i((ProviderConfiguration) null, eCPublicKeySpec.getParams()));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        e(SubjectPublicKeyInfo.g(ASN1Primitive.k((byte[]) objectInputStream.readObject())));
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

    public final void d(byte[] bArr, int i, int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i3 = 0; i3 != i; i3++) {
            bArr[i2 + i3] = byteArray[(byteArray.length - 1) - i3];
        }
    }

    public final void e(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        int i;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.f5753a.Z0;
        DERBitString dERBitString = subjectPublicKeyInfo.a;
        this.c = "ECGOST3410-2012";
        try {
            byte[] s = ((ASN1OctetString) ASN1Primitive.k(dERBitString.r())).s();
            if (aSN1ObjectIdentifier.equals(RosstandartObjectIdentifiers.f)) {
                i = 128;
            } else {
                i = 64;
            }
            int i2 = i / 2;
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[i2];
            for (int i3 = 0; i3 != i2; i3++) {
                bArr[i3] = s[(i2 - 1) - i3];
            }
            for (int i4 = 0; i4 != i2; i4++) {
                bArr2[i4] = s[(i - 1) - i4];
            }
            GOST3410PublicKeyAlgParameters g = GOST3410PublicKeyAlgParameters.g(subjectPublicKeyInfo.f5753a.a);
            this.f6426a = g;
            ECNamedCurveParameterSpec a2 = ECGOST3410NamedCurveTable.a(ECGOST3410NamedCurves.b(g.Z0));
            ECCurve eCCurve = a2.f6602a;
            EllipticCurve a3 = EC5Util.a(eCCurve);
            this.f6427a = new ECPublicKeyParameters(eCCurve.d(new BigInteger(1, bArr), new BigInteger(1, bArr2), false), ECUtil.e((ProviderConfiguration) null, a2));
            String b = ECGOST3410NamedCurves.b(this.f6426a.Z0);
            ECPoint eCPoint = a2.f6603a;
            eCPoint.b();
            this.a = new ECNamedCurveSpec(b, a3, new java.security.spec.ECPoint(eCPoint.f6621a.t(), eCPoint.e().t()), a2.a, a2.b);
        } catch (IOException unused) {
            throw new IllegalArgumentException("error recovering public key");
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BCECGOST3410_2012PublicKey)) {
            return false;
        }
        BCECGOST3410_2012PublicKey bCECGOST3410_2012PublicKey = (BCECGOST3410_2012PublicKey) obj;
        if (!this.f6427a.a.d(bCECGOST3410_2012PublicKey.f6427a.a) || !c().equals(bCECGOST3410_2012PublicKey.c())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return this.c;
    }

    public final byte[] getEncoded() {
        boolean z;
        int i;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1Encodable aSN1Encodable;
        ECPoint eCPoint = this.f6427a.a;
        eCPoint.b();
        BigInteger t = eCPoint.f6621a.t();
        BigInteger t2 = this.f6427a.a.e().t();
        if (t.bitLength() > 256) {
            z = true;
        } else {
            z = false;
        }
        ASN1Encodable aSN1Encodable2 = this.f6426a;
        if (aSN1Encodable2 == null) {
            ECParameterSpec eCParameterSpec = this.a;
            if (!(eCParameterSpec instanceof ECNamedCurveSpec)) {
                ECCurve b = EC5Util.b(eCParameterSpec.getCurve());
                aSN1Encodable = new X962Parameters(new X9ECParameters(b, EC5Util.d(b, this.a.getGenerator()), this.a.getOrder(), BigInteger.valueOf((long) this.a.getCofactor()), this.a.getCurve().getSeed()));
            } else if (z) {
                aSN1Encodable = new GOST3410PublicKeyAlgParameters((ASN1ObjectIdentifier) ECGOST3410NamedCurves.a.get(((ECNamedCurveSpec) eCParameterSpec).a), RosstandartObjectIdentifiers.f);
            } else {
                aSN1Encodable = new GOST3410PublicKeyAlgParameters((ASN1ObjectIdentifier) ECGOST3410NamedCurves.a.get(((ECNamedCurveSpec) eCParameterSpec).a), RosstandartObjectIdentifiers.e);
            }
            aSN1Encodable2 = aSN1Encodable;
        }
        int i2 = 64;
        if (z) {
            aSN1ObjectIdentifier = RosstandartObjectIdentifiers.f;
            i = 64;
            i2 = 128;
        } else {
            aSN1ObjectIdentifier = RosstandartObjectIdentifiers.e;
            i = 32;
        }
        byte[] bArr = new byte[i2];
        int i3 = i2 / 2;
        d(bArr, i3, 0, t);
        d(bArr, i3, i, t2);
        try {
            return KeyUtil.c(new SubjectPublicKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, aSN1Encodable2), (ASN1Object) new DEROctetString(bArr)));
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
        ECPoint eCPoint = this.f6427a.a;
        eCPoint.b();
        return new java.security.spec.ECPoint(eCPoint.f6621a.t(), this.f6427a.a.e().t());
    }

    public final int hashCode() {
        return this.f6427a.a.hashCode() ^ c().hashCode();
    }

    public final String toString() {
        return ECUtil.l(this.c, this.f6427a.a, c());
    }

    public final ECPoint w() {
        if (this.a == null) {
            return this.f6427a.a.o().c();
        }
        return this.f6427a.a;
    }

    public BCECGOST3410_2012PublicKey(org.spongycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        this.c = "ECGOST3410-2012";
        org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec = eCPublicKeySpec.a;
        ECPoint eCPoint = eCPublicKeySpec.a;
        if (eCParameterSpec != null) {
            EllipticCurve a2 = EC5Util.a(eCParameterSpec.f6602a);
            org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec2 = eCPublicKeySpec.a;
            this.f6427a = new ECPublicKeyParameters(eCPoint, ECUtil.e(providerConfiguration, eCParameterSpec2));
            this.a = EC5Util.e(a2, eCParameterSpec2);
            return;
        }
        ECCurve eCCurve = providerConfiguration.d().f6602a;
        eCPoint.b();
        this.f6427a = new ECPublicKeyParameters(eCCurve.d(eCPoint.f6621a.t(), eCPoint.e().t(), false), EC5Util.i(providerConfiguration, (ECParameterSpec) null));
        this.a = null;
    }

    public BCECGOST3410_2012PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        this.c = "ECGOST3410-2012";
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        this.c = str;
        this.f6427a = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            this.a = b(EC5Util.a(eCCurve), eCDomainParameters);
            return;
        }
        this.a = eCParameterSpec;
    }

    public BCECGOST3410_2012PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.spongycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        this.c = "ECGOST3410-2012";
        ECDomainParameters eCDomainParameters = eCPublicKeyParameters.a;
        this.c = str;
        this.f6427a = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            ECCurve eCCurve = eCDomainParameters.a;
            eCDomainParameters.a();
            this.a = b(EC5Util.a(eCCurve), eCDomainParameters);
            return;
        }
        this.a = EC5Util.e(EC5Util.a(eCParameterSpec.f6602a), eCParameterSpec);
    }

    public BCECGOST3410_2012PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.c = str;
        this.f6427a = eCPublicKeyParameters;
        this.a = null;
    }

    public BCECGOST3410_2012PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.c = "ECGOST3410-2012";
        e(subjectPublicKeyInfo);
    }
}
