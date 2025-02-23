package org.spongycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPublicKeyParameters;

public final class XMSSMTKeyPairGenerator {
    public SecureRandom a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSMTParameters f6768a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSParameters f6769a;

    public final AsymmetricCipherKeyPair a() {
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = new XMSSMTPrivateKeyParameters(new XMSSMTPrivateKeyParameters.Builder(this.f6768a));
        int a2 = this.f6768a.a();
        byte[] bArr = new byte[a2];
        this.a.nextBytes(bArr);
        byte[] bArr2 = new byte[a2];
        this.a.nextBytes(bArr2);
        byte[] bArr3 = new byte[a2];
        this.a.nextBytes(bArr3);
        XMSSMTPrivateKeyParameters.Builder builder = new XMSSMTPrivateKeyParameters.Builder(this.f6768a);
        builder.f6776a = XMSSUtil.b(bArr);
        builder.b = XMSSUtil.b(bArr2);
        builder.c = XMSSUtil.b(bArr3);
        builder.f6774a = xMSSMTPrivateKeyParameters.f6771a;
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters2 = new XMSSMTPrivateKeyParameters(builder);
        this.f6769a.f6789a.f(new byte[this.f6768a.a()], xMSSMTPrivateKeyParameters2.a());
        int i = this.f6768a.b - 1;
        OTSHashAddress.Builder builder2 = (OTSHashAddress.Builder) new OTSHashAddress.Builder().c(i);
        builder2.getClass();
        OTSHashAddress oTSHashAddress = new OTSHashAddress(builder2);
        XMSSParameters xMSSParameters = this.f6769a;
        byte[] a3 = xMSSMTPrivateKeyParameters2.a();
        byte[] bArr4 = xMSSMTPrivateKeyParameters2.f6773a;
        BDS bds = new BDS(xMSSParameters, a3, XMSSUtil.b(bArr4), oTSHashAddress);
        XMSSNode a4 = bds.f6754a.clone();
        Integer valueOf = Integer.valueOf(i);
        BDSStateMap bDSStateMap = xMSSMTPrivateKeyParameters2.f6771a;
        bDSStateMap.a.put(valueOf, bds);
        XMSSMTPrivateKeyParameters.Builder builder3 = new XMSSMTPrivateKeyParameters.Builder(this.f6768a);
        builder3.f6776a = XMSSUtil.b(XMSSUtil.b(bArr4));
        builder3.b = XMSSUtil.b(XMSSUtil.b(xMSSMTPrivateKeyParameters2.b));
        builder3.c = XMSSUtil.b(xMSSMTPrivateKeyParameters2.a());
        builder3.d = XMSSUtil.b(a4.b());
        builder3.f6774a = bDSStateMap;
        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters3 = new XMSSMTPrivateKeyParameters(builder3);
        XMSSMTPublicKeyParameters.Builder builder4 = new XMSSMTPublicKeyParameters.Builder(this.f6768a);
        builder4.f6778a = XMSSUtil.b(a4.b());
        builder4.b = XMSSUtil.b(xMSSMTPrivateKeyParameters3.a());
        return new AsymmetricCipherKeyPair(new XMSSMTPublicKeyParameters(builder4), xMSSMTPrivateKeyParameters3);
    }
}
