package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.pkcs.DHParameter;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.jcajce.provider.asymmetric.util.KeyUtil;

public class BCDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    public final BigInteger a;

    /* renamed from: a  reason: collision with other field name */
    public transient DHParameterSpec f6343a;

    /* renamed from: a  reason: collision with other field name */
    public transient SubjectPublicKeyInfo f6344a;

    /* renamed from: a  reason: collision with other field name */
    public final transient DHPublicKeyParameters f6345a;

    public BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        BigInteger y = dHPublicKeySpec.getY();
        this.a = y;
        this.f6343a = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
        this.f6345a = new DHPublicKeyParameters(y, new DHParameters(dHPublicKeySpec.getP(), dHPublicKeySpec.getG()));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f6343a = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f6344a = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f6343a.getP());
        objectOutputStream.writeObject(this.f6343a.getG());
        objectOutputStream.writeInt(this.f6343a.getL());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        if (!getY().equals(dHPublicKey.getY()) || !getParams().getG().equals(dHPublicKey.getParams().getG()) || !getParams().getP().equals(dHPublicKey.getParams().getP()) || getParams().getL() != dHPublicKey.getParams().getL()) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "DH";
    }

    public final byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.f6344a;
        if (subjectPublicKeyInfo != null) {
            return KeyUtil.c(subjectPublicKeyInfo);
        }
        return KeyUtil.b(new AlgorithmIdentifier(PKCSObjectIdentifiers.p, new DHParameter(this.f6343a.getL(), this.f6343a.getP(), this.f6343a.getG()).b()), new ASN1Integer(this.a));
    }

    public final String getFormat() {
        return "X.509";
    }

    public final DHParameterSpec getParams() {
        return this.f6343a;
    }

    public final BigInteger getY() {
        return this.a;
    }

    public final int hashCode() {
        return ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode()) ^ getParams().getL();
    }

    public BCDHPublicKey(DHPublicKey dHPublicKey) {
        BigInteger y = dHPublicKey.getY();
        this.a = y;
        this.f6343a = dHPublicKey.getParams();
        this.f6345a = new DHPublicKeyParameters(y, new DHParameters(this.f6343a.getP(), this.f6343a.getG()));
    }

    public BCDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.a = dHPublicKeyParameters.a;
        DHParameters dHParameters = dHPublicKeyParameters.a;
        this.f6343a = new DHParameterSpec(dHParameters.b, dHParameters.a, dHParameters.d);
        this.f6345a = dHPublicKeyParameters;
    }

    public BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.a = bigInteger;
        this.f6343a = dHParameterSpec;
        this.f6345a = new DHPublicKeyParameters(bigInteger, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0059, code lost:
        if (org.spongycastle.asn1.ASN1Integer.q(r1.s(2)).t().compareTo(java.math.BigInteger.valueOf((long) org.spongycastle.asn1.ASN1Integer.q(r1.s(0)).t().bitLength())) > 0) goto L_0x005d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0061  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BCDHPublicKey(org.spongycastle.asn1.x509.SubjectPublicKeyInfo r8) {
        /*
            r7 = this;
            r7.<init>()
            r7.f6344a = r8
            org.spongycastle.asn1.ASN1Primitive r0 = r8.h()     // Catch:{ IOException -> 0x0135 }
            org.spongycastle.asn1.ASN1Integer r0 = (org.spongycastle.asn1.ASN1Integer) r0     // Catch:{ IOException -> 0x0135 }
            java.math.BigInteger r0 = r0.t()
            r7.a = r0
            org.spongycastle.asn1.x509.AlgorithmIdentifier r8 = r8.f5753a
            org.spongycastle.asn1.ASN1Encodable r1 = r8.a
            org.spongycastle.asn1.ASN1Sequence r1 = org.spongycastle.asn1.ASN1Sequence.q(r1)
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.p
            org.spongycastle.asn1.ASN1ObjectIdentifier r8 = r8.Z0
            boolean r2 = r8.equals(r2)
            if (r2 != 0) goto L_0x00eb
            int r2 = r1.size()
            r3 = 2
            if (r2 != r3) goto L_0x002b
            goto L_0x005c
        L_0x002b:
            int r2 = r1.size()
            r4 = 3
            r5 = 0
            if (r2 <= r4) goto L_0x0034
            goto L_0x005d
        L_0x0034:
            org.spongycastle.asn1.ASN1Encodable r2 = r1.s(r3)
            org.spongycastle.asn1.ASN1Integer r2 = org.spongycastle.asn1.ASN1Integer.q(r2)
            org.spongycastle.asn1.ASN1Encodable r3 = r1.s(r5)
            org.spongycastle.asn1.ASN1Integer r3 = org.spongycastle.asn1.ASN1Integer.q(r3)
            java.math.BigInteger r2 = r2.t()
            java.math.BigInteger r3 = r3.t()
            int r3 = r3.bitLength()
            long r3 = (long) r3
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r3)
            int r2 = r2.compareTo(r3)
            if (r2 <= 0) goto L_0x005c
            goto L_0x005d
        L_0x005c:
            r5 = 1
        L_0x005d:
            if (r5 == 0) goto L_0x0061
            goto L_0x00eb
        L_0x0061:
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.x9.X9ObjectIdentifiers.Y0
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x00d7
            org.spongycastle.asn1.x9.DomainParameters r8 = org.spongycastle.asn1.x9.DomainParameters.g(r1)
            javax.crypto.spec.DHParameterSpec r1 = new javax.crypto.spec.DHParameterSpec
            org.spongycastle.asn1.ASN1Integer r2 = r8.a
            java.math.BigInteger r2 = r2.s()
            org.spongycastle.asn1.ASN1Integer r3 = r8.b
            java.math.BigInteger r4 = r3.s()
            r1.<init>(r2, r4)
            r7.f6343a = r1
            org.spongycastle.asn1.ASN1Integer r1 = r8.d
            org.spongycastle.asn1.ASN1Integer r2 = r8.c
            org.spongycastle.asn1.ASN1Integer r4 = r8.a
            org.spongycastle.asn1.x9.ValidationParams r8 = r8.f5782a
            if (r8 == 0) goto L_0x00b8
            org.spongycastle.crypto.params.DHPublicKeyParameters r5 = new org.spongycastle.crypto.params.DHPublicKeyParameters
            org.spongycastle.crypto.params.DHParameters r6 = new org.spongycastle.crypto.params.DHParameters
            java.math.BigInteger r4 = r4.s()
            java.math.BigInteger r3 = r3.s()
            java.math.BigInteger r2 = r2.s()
            if (r1 != 0) goto L_0x009d
            goto L_0x00a0
        L_0x009d:
            r1.s()
        L_0x00a0:
            org.spongycastle.asn1.DERBitString r1 = r8.f5783a
            r1.r()
            org.spongycastle.asn1.ASN1Integer r8 = r8.a
            java.math.BigInteger r8 = r8.s()
            r8.intValue()
            r6.<init>(r4, r3, r2)
            r5.<init>(r0, r6)
            r7.f6345a = r5
            goto L_0x0134
        L_0x00b8:
            org.spongycastle.crypto.params.DHPublicKeyParameters r8 = new org.spongycastle.crypto.params.DHPublicKeyParameters
            org.spongycastle.crypto.params.DHParameters r5 = new org.spongycastle.crypto.params.DHParameters
            java.math.BigInteger r4 = r4.s()
            java.math.BigInteger r3 = r3.s()
            java.math.BigInteger r2 = r2.s()
            if (r1 != 0) goto L_0x00cb
            goto L_0x00ce
        L_0x00cb:
            r1.s()
        L_0x00ce:
            r5.<init>(r4, r3, r2)
            r8.<init>(r0, r5)
            r7.f6345a = r8
            goto L_0x0134
        L_0x00d7:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "unknown algorithm type: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L_0x00eb:
            org.spongycastle.asn1.pkcs.DHParameter r8 = org.spongycastle.asn1.pkcs.DHParameter.h(r1)
            java.math.BigInteger r1 = r8.i()
            if (r1 == 0) goto L_0x010d
            javax.crypto.spec.DHParameterSpec r1 = new javax.crypto.spec.DHParameterSpec
            java.math.BigInteger r2 = r8.k()
            java.math.BigInteger r3 = r8.g()
            java.math.BigInteger r8 = r8.i()
            int r8 = r8.intValue()
            r1.<init>(r2, r3, r8)
            r7.f6343a = r1
            goto L_0x011c
        L_0x010d:
            javax.crypto.spec.DHParameterSpec r1 = new javax.crypto.spec.DHParameterSpec
            java.math.BigInteger r2 = r8.k()
            java.math.BigInteger r8 = r8.g()
            r1.<init>(r2, r8)
            r7.f6343a = r1
        L_0x011c:
            org.spongycastle.crypto.params.DHPublicKeyParameters r8 = new org.spongycastle.crypto.params.DHPublicKeyParameters
            org.spongycastle.crypto.params.DHParameters r1 = new org.spongycastle.crypto.params.DHParameters
            javax.crypto.spec.DHParameterSpec r2 = r7.f6343a
            java.math.BigInteger r2 = r2.getP()
            javax.crypto.spec.DHParameterSpec r3 = r7.f6343a
            java.math.BigInteger r3 = r3.getG()
            r1.<init>(r2, r3)
            r8.<init>(r0, r1)
            r7.f6345a = r8
        L_0x0134:
            return
        L_0x0135:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "invalid info structure in DH public key"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.asymmetric.dh.BCDHPublicKey.<init>(org.spongycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }
}
