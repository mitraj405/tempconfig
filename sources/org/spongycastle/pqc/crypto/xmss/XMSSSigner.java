package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.crypto.StateAwareMessageSigner;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSSignature;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public class XMSSSigner implements StateAwareMessageSigner {
    public KeyedHashFunctions a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSParameters f6802a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSPrivateKeyParameters f6803a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSPublicKeyParameters f6804a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6805a;
    public XMSSPrivateKeyParameters b;

    public final byte[] a(byte[] bArr) {
        XMSSPrivateKeyParameters xMSSPrivateKeyParameters;
        if (this.f6805a) {
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters2 = this.f6803a;
            if (xMSSPrivateKeyParameters2 == null) {
                throw new IllegalStateException("signing key no longer usable");
            } else if (!xMSSPrivateKeyParameters2.a.a().isEmpty()) {
                int i = this.f6803a.a.e;
                long j = (long) i;
                if (XMSSUtil.h(this.f6802a.a, j)) {
                    byte[] b2 = this.a.b(XMSSUtil.b(this.f6803a.b), XMSSUtil.j(32, j));
                    byte[] a2 = this.a.a(Arrays.j(b2, XMSSUtil.b(this.f6803a.d), XMSSUtil.j(this.f6802a.a(), j)), bArr);
                    OTSHashAddress.Builder builder = new OTSHashAddress.Builder();
                    builder.d = i;
                    OTSHashAddress oTSHashAddress = new OTSHashAddress(builder);
                    if (a2.length == this.f6802a.a()) {
                        WOTSPlus wOTSPlus = this.f6802a.f6789a;
                        wOTSPlus.f(wOTSPlus.e(XMSSUtil.b(this.f6803a.f6791a), oTSHashAddress), XMSSUtil.b(this.f6803a.c));
                        WOTSPlusSignature g = this.f6802a.f6789a.g(a2, oTSHashAddress);
                        XMSSSignature.Builder builder2 = new XMSSSignature.Builder(this.f6802a);
                        builder2.a = i;
                        builder2.b = XMSSUtil.b(b2);
                        builder2.f6799a = g;
                        builder2.a = this.f6803a.a.a();
                        XMSSSignature xMSSSignature = new XMSSSignature(builder2);
                        XMSSPrivateKeyParameters xMSSPrivateKeyParameters3 = this.b;
                        if (xMSSPrivateKeyParameters3 != null) {
                            XMSSParameters xMSSParameters = xMSSPrivateKeyParameters3.f6790a;
                            int i2 = xMSSParameters.a;
                            BDS bds = xMSSPrivateKeyParameters3.a;
                            int i3 = bds.e;
                            int i4 = (1 << i2) - 1;
                            byte[] bArr2 = xMSSPrivateKeyParameters3.d;
                            byte[] bArr3 = xMSSPrivateKeyParameters3.b;
                            byte[] bArr4 = xMSSPrivateKeyParameters3.c;
                            byte[] bArr5 = xMSSPrivateKeyParameters3.f6791a;
                            if (i3 < i4) {
                                XMSSPrivateKeyParameters.Builder builder3 = new XMSSPrivateKeyParameters.Builder(xMSSParameters);
                                builder3.f6794a = XMSSUtil.b(bArr5);
                                builder3.b = XMSSUtil.b(bArr3);
                                builder3.c = XMSSUtil.b(bArr4);
                                builder3.d = XMSSUtil.b(bArr2);
                                builder3.f6792a = new BDS(bds, bArr4, bArr5, new OTSHashAddress(new OTSHashAddress.Builder()));
                                xMSSPrivateKeyParameters = new XMSSPrivateKeyParameters(builder3);
                            } else {
                                XMSSPrivateKeyParameters.Builder builder4 = new XMSSPrivateKeyParameters.Builder(xMSSParameters);
                                builder4.f6794a = XMSSUtil.b(bArr5);
                                builder4.b = XMSSUtil.b(bArr3);
                                builder4.c = XMSSUtil.b(bArr4);
                                builder4.d = XMSSUtil.b(bArr2);
                                builder4.f6792a = new BDS(xMSSParameters, bds.e + 1);
                                xMSSPrivateKeyParameters = new XMSSPrivateKeyParameters(builder4);
                            }
                            this.f6803a = xMSSPrivateKeyParameters;
                            this.b = xMSSPrivateKeyParameters;
                        } else {
                            this.f6803a = null;
                        }
                        return xMSSSignature.a();
                    }
                    throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
                }
                throw new IllegalStateException("index out of bounds");
            } else {
                throw new IllegalStateException("not initialized");
            }
        } else {
            throw new IllegalStateException("signer not initialized for signature generation");
        }
    }

    public final void b(boolean z, CipherParameters cipherParameters) {
        if (z) {
            this.f6805a = true;
            XMSSPrivateKeyParameters xMSSPrivateKeyParameters = (XMSSPrivateKeyParameters) cipherParameters;
            this.f6803a = xMSSPrivateKeyParameters;
            this.b = xMSSPrivateKeyParameters;
            XMSSParameters xMSSParameters = xMSSPrivateKeyParameters.f6790a;
            this.f6802a = xMSSParameters;
            this.a = xMSSParameters.f6789a.a;
            return;
        }
        this.f6805a = false;
        XMSSPublicKeyParameters xMSSPublicKeyParameters = (XMSSPublicKeyParameters) cipherParameters;
        this.f6804a = xMSSPublicKeyParameters;
        XMSSParameters xMSSParameters2 = xMSSPublicKeyParameters.a;
        this.f6802a = xMSSParameters2;
        this.a = xMSSParameters2.f6789a.a;
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        XMSSParameters xMSSParameters = this.f6802a;
        XMSSSignature.Builder builder = new XMSSSignature.Builder(xMSSParameters);
        if (bArr2 != null) {
            int a2 = xMSSParameters.a();
            int i = xMSSParameters.f6789a.f6760a.c * a2;
            int i2 = xMSSParameters.a * a2;
            builder.a = Pack.a(0, bArr2);
            builder.b = XMSSUtil.e(4, bArr2, a2);
            builder.f6801a = XMSSUtil.b(XMSSUtil.e(a2 + 4, bArr2, i + i2));
            XMSSSignature xMSSSignature = new XMSSSignature(builder);
            XMSSParameters xMSSParameters2 = this.f6802a;
            xMSSParameters2.f6789a.f(new byte[xMSSParameters2.a()], XMSSUtil.b(this.f6804a.b));
            byte[] b2 = XMSSUtil.b(xMSSSignature.a);
            byte[] b3 = XMSSUtil.b(this.f6804a.f6795a);
            int i3 = xMSSSignature.c;
            long j = (long) i3;
            byte[] a3 = this.a.a(Arrays.j(b2, b3, XMSSUtil.j(this.f6802a.a(), j)), bArr);
            int i4 = this.f6802a.a;
            int f = XMSSUtil.f(i4, j);
            OTSHashAddress.Builder builder2 = new OTSHashAddress.Builder();
            builder2.d = i3;
            return Arrays.l(XMSSVerifierUtil.a(this.f6802a.f6789a, i4, a3, xMSSSignature, new OTSHashAddress(builder2), f).b(), XMSSUtil.b(this.f6804a.f6795a));
        }
        throw new NullPointerException("signature == null");
    }
}
