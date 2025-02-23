package org.spongycastle.pqc.jcajce.provider.xmss;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.asn1.XMSSMTKeyParams;
import org.spongycastle.pqc.asn1.XMSSPublicKey;
import org.spongycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
import org.spongycastle.pqc.jcajce.interfaces.XMSSMTKey;
import org.spongycastle.util.Arrays;

public class BCXMSSMTPublicKey implements PublicKey, XMSSMTKey {
    public final ASN1ObjectIdentifier Z0;
    public final XMSSMTPublicKeyParameters a;

    public BCXMSSMTPublicKey(XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters) {
        this.Z0 = null;
        this.a = xMSSMTPublicKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSMTPublicKey)) {
            return false;
        }
        BCXMSSMTPublicKey bCXMSSMTPublicKey = (BCXMSSMTPublicKey) obj;
        if (!this.Z0.equals(bCXMSSMTPublicKey.Z0) || !Arrays.a(this.a.a(), bCXMSSMTPublicKey.a.a())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "XMSSMT";
    }

    public final byte[] getEncoded() {
        XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = this.a;
        try {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.m;
            XMSSMTParameters xMSSMTParameters = xMSSMTPublicKeyParameters.a;
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, new XMSSMTKeyParams(xMSSMTParameters.a, xMSSMTParameters.b, new AlgorithmIdentifier(this.Z0))), (ASN1Object) new XMSSPublicKey(XMSSUtil.b(xMSSMTPublicKeyParameters.b), XMSSUtil.b(xMSSMTPublicKeyParameters.f6777a))).e();
        } catch (IOException unused) {
            return null;
        }
    }

    public final String getFormat() {
        return "X.509";
    }

    public final int hashCode() {
        return (Arrays.t(this.a.a()) * 37) + this.Z0.hashCode();
    }

    public BCXMSSMTPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSMTKeyParams xMSSMTKeyParams;
        ASN1Encodable aSN1Encodable = subjectPublicKeyInfo.f5753a.a;
        XMSSPublicKey xMSSPublicKey = null;
        if (aSN1Encodable instanceof XMSSMTKeyParams) {
            xMSSMTKeyParams = (XMSSMTKeyParams) aSN1Encodable;
        } else {
            xMSSMTKeyParams = aSN1Encodable != null ? new XMSSMTKeyParams(ASN1Sequence.q(aSN1Encodable)) : null;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = xMSSMTKeyParams.f6656a.Z0;
        this.Z0 = aSN1ObjectIdentifier;
        ASN1Primitive h = subjectPublicKeyInfo.h();
        if (h instanceof XMSSPublicKey) {
            xMSSPublicKey = (XMSSPublicKey) h;
        } else if (h != null) {
            xMSSPublicKey = new XMSSPublicKey(ASN1Sequence.q(h));
        }
        XMSSMTPublicKeyParameters.Builder builder = new XMSSMTPublicKeyParameters.Builder(new XMSSMTParameters(xMSSMTKeyParams.c, xMSSMTKeyParams.d, DigestUtil.a(aSN1ObjectIdentifier)));
        builder.b = XMSSUtil.b(Arrays.c(xMSSPublicKey.a));
        builder.f6778a = XMSSUtil.b(Arrays.c(xMSSPublicKey.b));
        this.a = new XMSSMTPublicKeyParameters(builder);
    }
}
