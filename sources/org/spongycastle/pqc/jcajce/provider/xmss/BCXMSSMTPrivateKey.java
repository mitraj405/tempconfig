package org.spongycastle.pqc.jcajce.provider.xmss;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.XMSSMTKeyParams;
import org.spongycastle.pqc.asn1.XMSSMTPrivateKey;
import org.spongycastle.pqc.asn1.XMSSPrivateKey;
import org.spongycastle.pqc.crypto.xmss.BDSStateMap;
import org.spongycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
import org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey;
import org.spongycastle.util.Arrays;

public class BCXMSSMTPrivateKey implements PrivateKey, XMSSMTKey {
    public final ASN1ObjectIdentifier Z0;
    public final XMSSMTPrivateKeyParameters a;

    public BCXMSSMTPrivateKey(XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters) {
        this.Z0 = null;
        this.a = xMSSMTPrivateKeyParameters;
    }

    public final XMSSMTPrivateKey a() {
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.a;
        byte[] b = xMSSMTPrivateKeyParameters.b();
        XMSSMTParameters xMSSMTParameters = xMSSMTPrivateKeyParameters.f6772a;
        int a2 = xMSSMTParameters.a();
        int i = xMSSMTParameters.a;
        int i2 = (i + 7) / 8;
        int a3 = (int) XMSSUtil.a(b, i2);
        if (XMSSUtil.h(i, (long) a3)) {
            int i3 = i2 + 0;
            byte[] e = XMSSUtil.e(i3, b, a2);
            int i4 = i3 + a2;
            byte[] e2 = XMSSUtil.e(i4, b, a2);
            int i5 = i4 + a2;
            byte[] e3 = XMSSUtil.e(i5, b, a2);
            int i6 = i5 + a2;
            byte[] e4 = XMSSUtil.e(i6, b, a2);
            int i7 = i6 + a2;
            return new XMSSMTPrivateKey(a3, e, e2, e3, e4, XMSSUtil.e(i7, b, b.length - i7));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPrivateKey)) {
            return false;
        }
        BCXMSSMTPrivateKey bCXMSSMTPrivateKey = (BCXMSSMTPrivateKey) obj;
        if (!this.Z0.equals(bCXMSSMTPrivateKey.Z0) || !Arrays.a(this.a.b(), bCXMSSMTPrivateKey.a.b())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "XMSSMT";
    }

    public final byte[] getEncoded() {
        try {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.m;
            XMSSMTParameters xMSSMTParameters = this.a.f6772a;
            return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, new XMSSMTKeyParams(xMSSMTParameters.a, xMSSMTParameters.b, new AlgorithmIdentifier(this.Z0))), a()).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return (Arrays.t(this.a.b()) * 37) + this.Z0.hashCode();
    }

    public BCXMSSMTPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        XMSSMTKeyParams xMSSMTKeyParams;
        ASN1Encodable aSN1Encodable = privateKeyInfo.f5702a.a;
        XMSSPrivateKey xMSSPrivateKey = null;
        if (aSN1Encodable instanceof XMSSMTKeyParams) {
            xMSSMTKeyParams = (XMSSMTKeyParams) aSN1Encodable;
        } else {
            xMSSMTKeyParams = aSN1Encodable != null ? new XMSSMTKeyParams(ASN1Sequence.q(aSN1Encodable)) : null;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = xMSSMTKeyParams.f6656a.Z0;
        this.Z0 = aSN1ObjectIdentifier;
        ASN1Primitive h = privateKeyInfo.h();
        if (h instanceof XMSSPrivateKey) {
            xMSSPrivateKey = (XMSSPrivateKey) h;
        } else if (h != null) {
            xMSSPrivateKey = new XMSSPrivateKey(ASN1Sequence.q(h));
        }
        try {
            XMSSMTPrivateKeyParameters.Builder builder = new XMSSMTPrivateKeyParameters.Builder(new XMSSMTParameters(xMSSMTKeyParams.c, xMSSMTKeyParams.d, DigestUtil.a(aSN1ObjectIdentifier)));
            int i = xMSSPrivateKey.c;
            byte[] bArr = xMSSPrivateKey.e;
            builder.a = (long) i;
            builder.f6776a = XMSSUtil.b(Arrays.c(xMSSPrivateKey.a));
            builder.b = XMSSUtil.b(Arrays.c(xMSSPrivateKey.b));
            builder.c = XMSSUtil.b(Arrays.c(xMSSPrivateKey.f6658c));
            builder.d = XMSSUtil.b(Arrays.c(xMSSPrivateKey.d));
            if (Arrays.c(bArr) != null) {
                builder.f6774a = (BDSStateMap) new ObjectInputStream(new ByteArrayInputStream(Arrays.c(bArr))).readObject();
            }
            this.a = new XMSSMTPrivateKeyParameters(builder);
        } catch (ClassNotFoundException e) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
        }
    }
}
