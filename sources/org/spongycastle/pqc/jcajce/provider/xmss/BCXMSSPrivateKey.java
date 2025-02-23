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
import org.spongycastle.pqc.asn1.XMSSKeyParams;
import org.spongycastle.pqc.asn1.XMSSPrivateKey;
import org.spongycastle.pqc.crypto.xmss.BDS;
import org.spongycastle.pqc.crypto.xmss.XMSSParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
import org.spongycastle.pqc.jcajce.interfaces.XMSSKey;
import org.spongycastle.util.Arrays;

public class BCXMSSPrivateKey implements PrivateKey, XMSSKey {
    public final ASN1ObjectIdentifier Z0;
    public final XMSSPrivateKeyParameters a;

    public BCXMSSPrivateKey(XMSSPrivateKeyParameters xMSSPrivateKeyParameters) {
        this.Z0 = null;
        this.a = xMSSPrivateKeyParameters;
    }

    public final XMSSPrivateKey a() {
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters = this.a;
        byte[] a2 = xMSSPrivateKeyParameters.a();
        XMSSParameters xMSSParameters = xMSSPrivateKeyParameters.f6790a;
        int a3 = xMSSParameters.a();
        int i = xMSSParameters.a;
        int a4 = (int) XMSSUtil.a(a2, 4);
        if (XMSSUtil.h(i, (long) a4)) {
            byte[] e = XMSSUtil.e(4, a2, a3);
            int i2 = a3 + 4;
            byte[] e2 = XMSSUtil.e(i2, a2, a3);
            int i3 = i2 + a3;
            byte[] e3 = XMSSUtil.e(i3, a2, a3);
            int i4 = i3 + a3;
            byte[] e4 = XMSSUtil.e(i4, a2, a3);
            int i5 = i4 + a3;
            return new XMSSPrivateKey(a4, e, e2, e3, e4, XMSSUtil.e(i5, a2, a2.length - i5));
        }
        throw new IllegalArgumentException("index out of bounds");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSPrivateKey)) {
            return false;
        }
        BCXMSSPrivateKey bCXMSSPrivateKey = (BCXMSSPrivateKey) obj;
        if (!this.Z0.equals(bCXMSSPrivateKey.Z0) || !Arrays.a(this.a.a(), bCXMSSPrivateKey.a.a())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "XMSS";
    }

    public final byte[] getEncoded() {
        try {
            return new PrivateKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.l, new XMSSKeyParams(this.a.f6790a.a, new AlgorithmIdentifier(this.Z0))), a()).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "PKCS#8";
    }

    public final int hashCode() {
        return (Arrays.t(this.a.a()) * 37) + this.Z0.hashCode();
    }

    public BCXMSSPrivateKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        XMSSKeyParams xMSSKeyParams;
        ASN1Encodable aSN1Encodable = privateKeyInfo.f5702a.a;
        XMSSPrivateKey xMSSPrivateKey = null;
        if (aSN1Encodable instanceof XMSSKeyParams) {
            xMSSKeyParams = (XMSSKeyParams) aSN1Encodable;
        } else {
            xMSSKeyParams = aSN1Encodable != null ? new XMSSKeyParams(ASN1Sequence.q(aSN1Encodable)) : null;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = xMSSKeyParams.f6655a.Z0;
        this.Z0 = aSN1ObjectIdentifier;
        ASN1Primitive h = privateKeyInfo.h();
        if (h instanceof XMSSPrivateKey) {
            xMSSPrivateKey = (XMSSPrivateKey) h;
        } else if (h != null) {
            xMSSPrivateKey = new XMSSPrivateKey(ASN1Sequence.q(h));
        }
        try {
            XMSSPrivateKeyParameters.Builder builder = new XMSSPrivateKeyParameters.Builder(new XMSSParameters(xMSSKeyParams.c, DigestUtil.a(aSN1ObjectIdentifier)));
            int i = xMSSPrivateKey.c;
            byte[] bArr = xMSSPrivateKey.e;
            builder.a = i;
            builder.f6794a = XMSSUtil.b(Arrays.c(xMSSPrivateKey.a));
            builder.b = XMSSUtil.b(Arrays.c(xMSSPrivateKey.b));
            builder.c = XMSSUtil.b(Arrays.c(xMSSPrivateKey.f6658c));
            builder.d = XMSSUtil.b(Arrays.c(xMSSPrivateKey.d));
            if (Arrays.c(bArr) != null) {
                builder.f6792a = (BDS) new ObjectInputStream(new ByteArrayInputStream(Arrays.c(bArr))).readObject();
            }
            this.a = new XMSSPrivateKeyParameters(builder);
        } catch (ClassNotFoundException e) {
            throw new IOException("ClassNotFoundException processing BDS state: " + e.getMessage());
        }
    }
}
