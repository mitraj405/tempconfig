package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSPublicKeyParameters;

public final class XMSSKeyPairGenerator {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSParameters f6767a;

    public final AsymmetricCipherKeyPair a() {
        XMSSParameters xMSSParameters = this.f6767a;
        SecureRandom secureRandom = this.a;
        int a2 = xMSSParameters.a();
        byte[] bArr = new byte[a2];
        secureRandom.nextBytes(bArr);
        byte[] bArr2 = new byte[a2];
        secureRandom.nextBytes(bArr2);
        byte[] bArr3 = new byte[a2];
        secureRandom.nextBytes(bArr3);
        XMSSPrivateKeyParameters.Builder builder = new XMSSPrivateKeyParameters.Builder(xMSSParameters);
        builder.f6794a = XMSSUtil.b(bArr);
        builder.b = XMSSUtil.b(bArr2);
        builder.c = XMSSUtil.b(bArr3);
        builder.f6792a = new BDS(xMSSParameters, bArr3, bArr, new OTSHashAddress(new OTSHashAddress.Builder()));
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters = new XMSSPrivateKeyParameters(builder);
        BDS bds = xMSSPrivateKeyParameters.a;
        XMSSNode a3 = bds.f6754a.clone();
        XMSSPrivateKeyParameters.Builder builder2 = new XMSSPrivateKeyParameters.Builder(this.f6767a);
        builder2.f6794a = XMSSUtil.b(XMSSUtil.b(xMSSPrivateKeyParameters.f6791a));
        builder2.b = XMSSUtil.b(XMSSUtil.b(xMSSPrivateKeyParameters.b));
        builder2.c = XMSSUtil.b(XMSSUtil.b(xMSSPrivateKeyParameters.c));
        builder2.d = XMSSUtil.b(a3.b());
        builder2.f6792a = bds;
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters2 = new XMSSPrivateKeyParameters(builder2);
        XMSSPublicKeyParameters.Builder builder3 = new XMSSPublicKeyParameters.Builder(this.f6767a);
        builder3.f6796a = XMSSUtil.b(a3.b());
        builder3.b = XMSSUtil.b(XMSSUtil.b(xMSSPrivateKeyParameters2.c));
        return new AsymmetricCipherKeyPair(new XMSSPublicKeyParameters(builder3), xMSSPrivateKeyParameters2);
    }
}
