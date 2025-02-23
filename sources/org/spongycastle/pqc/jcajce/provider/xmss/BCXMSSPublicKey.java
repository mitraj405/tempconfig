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
import org.spongycastle.pqc.asn1.XMSSKeyParams;
import org.spongycastle.pqc.asn1.XMSSPublicKey;
import org.spongycastle.pqc.crypto.xmss.XMSSParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSUtil;
import org.spongycastle.pqc.jcajce.interfaces.XMSSKey;
import org.spongycastle.util.Arrays;

public class BCXMSSPublicKey implements PublicKey, XMSSKey {
    public final ASN1ObjectIdentifier Z0;
    public final XMSSPublicKeyParameters a;

    public BCXMSSPublicKey(XMSSPublicKeyParameters xMSSPublicKeyParameters) {
        this.Z0 = null;
        this.a = xMSSPublicKeyParameters;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCXMSSPublicKey)) {
            return false;
        }
        BCXMSSPublicKey bCXMSSPublicKey = (BCXMSSPublicKey) obj;
        if (!this.Z0.equals(bCXMSSPublicKey.Z0) || !Arrays.a(this.a.a(), bCXMSSPublicKey.a.a())) {
            return false;
        }
        return true;
    }

    public final String getAlgorithm() {
        return "XMSS";
    }

    public final byte[] getEncoded() {
        XMSSPublicKeyParameters xMSSPublicKeyParameters = this.a;
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.l, new XMSSKeyParams(xMSSPublicKeyParameters.a.a, new AlgorithmIdentifier(this.Z0))), (ASN1Object) new XMSSPublicKey(XMSSUtil.b(xMSSPublicKeyParameters.b), XMSSUtil.b(xMSSPublicKeyParameters.f6795a))).e();
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

    public BCXMSSPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        XMSSKeyParams xMSSKeyParams;
        ASN1Encodable aSN1Encodable = subjectPublicKeyInfo.f5753a.a;
        XMSSPublicKey xMSSPublicKey = null;
        if (aSN1Encodable instanceof XMSSKeyParams) {
            xMSSKeyParams = (XMSSKeyParams) aSN1Encodable;
        } else {
            xMSSKeyParams = aSN1Encodable != null ? new XMSSKeyParams(ASN1Sequence.q(aSN1Encodable)) : null;
        }
        ASN1ObjectIdentifier aSN1ObjectIdentifier = xMSSKeyParams.f6655a.Z0;
        this.Z0 = aSN1ObjectIdentifier;
        ASN1Primitive h = subjectPublicKeyInfo.h();
        if (h instanceof XMSSPublicKey) {
            xMSSPublicKey = (XMSSPublicKey) h;
        } else if (h != null) {
            xMSSPublicKey = new XMSSPublicKey(ASN1Sequence.q(h));
        }
        XMSSPublicKeyParameters.Builder builder = new XMSSPublicKeyParameters.Builder(new XMSSParameters(xMSSKeyParams.c, DigestUtil.a(aSN1ObjectIdentifier)));
        builder.b = XMSSUtil.b(Arrays.c(xMSSPublicKey.a));
        builder.f6796a = XMSSUtil.b(Arrays.c(xMSSPublicKey.b));
        this.a = new XMSSPublicKeyParameters(builder);
    }
}
