package org.spongycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.crypto.StateAwareMessageSigner;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.spongycastle.pqc.crypto.xmss.XMSSMTSignature;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;
import org.spongycastle.util.Arrays;

public class XMSSMTSigner implements StateAwareMessageSigner {
    public WOTSPlus a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSMTParameters f6784a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSMTPrivateKeyParameters f6785a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSMTPublicKeyParameters f6786a;

    /* renamed from: a  reason: collision with other field name */
    public XMSSParameters f6787a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6788a;
    public XMSSMTPrivateKeyParameters b;

    public final byte[] a(byte[] bArr) {
        long j;
        int i;
        if (this.f6788a) {
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = this.f6785a;
            if (xMSSMTPrivateKeyParameters == null) {
                throw new IllegalStateException("signing key no longer usable");
            } else if (!xMSSMTPrivateKeyParameters.f6771a.a.isEmpty()) {
                XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters2 = this.f6785a;
                BDSStateMap bDSStateMap = xMSSMTPrivateKeyParameters2.f6771a;
                int i2 = this.f6784a.a;
                int i3 = this.f6787a.a;
                long j2 = xMSSMTPrivateKeyParameters2.a;
                if (XMSSUtil.h(i2, j2)) {
                    byte[] b2 = this.a.a.b(XMSSUtil.b(this.f6785a.b), XMSSUtil.j(32, j2));
                    byte[] a2 = this.a.a.a(Arrays.j(b2, XMSSUtil.b(this.f6785a.d), XMSSUtil.j(this.f6784a.a(), j2)), bArr);
                    XMSSMTSignature.Builder builder = new XMSSMTSignature.Builder(this.f6784a);
                    builder.a = j2;
                    builder.f6783a = XMSSUtil.b(b2);
                    XMSSMTSignature xMSSMTSignature = new XMSSMTSignature(builder);
                    long j3 = j2 >> i3;
                    int f = XMSSUtil.f(i3, j2);
                    this.a.f(new byte[this.f6784a.a()], this.f6785a.a());
                    OTSHashAddress.Builder builder2 = (OTSHashAddress.Builder) new OTSHashAddress.Builder().d(j3);
                    builder2.d = f;
                    OTSHashAddress oTSHashAddress = new OTSHashAddress(builder2);
                    boolean z = false;
                    BDS a3 = bDSStateMap.a(0);
                    TreeMap treeMap = bDSStateMap.a;
                    if (a3 == null || f == 0) {
                        treeMap.put(0, new BDS(this.f6787a, this.f6785a.a(), XMSSUtil.b(this.f6785a.f6773a), oTSHashAddress));
                    }
                    WOTSPlusSignature d = d(a2, oTSHashAddress);
                    XMSSReducedSignature.Builder builder3 = new XMSSReducedSignature.Builder(this.f6787a);
                    builder3.f6799a = d;
                    builder3.a = bDSStateMap.a(0).a();
                    XMSSReducedSignature xMSSReducedSignature = new XMSSReducedSignature(builder3);
                    ArrayList arrayList = xMSSMTSignature.f6779a;
                    arrayList.add(xMSSReducedSignature);
                    int i4 = 1;
                    int i5 = 1;
                    while (i5 < this.f6784a.b) {
                        XMSSNode a4 = bDSStateMap.a(i5 - 1).f6754a.clone();
                        int f2 = XMSSUtil.f(i3, j3);
                        long j4 = j3 >> i3;
                        OTSHashAddress.Builder builder4 = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(i5)).d(j4);
                        builder4.d = f2;
                        OTSHashAddress oTSHashAddress2 = new OTSHashAddress(builder4);
                        WOTSPlusSignature d2 = d(a4.b(), oTSHashAddress2);
                        if (bDSStateMap.a(i5) != null) {
                            if (j2 == 0) {
                                i = i3;
                                j = j4;
                            } else {
                                i = i3;
                                j = j4;
                                if (j2 % ((long) Math.pow((double) (i4 << i3), (double) (i5 + 1))) == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            }
                            if (!z) {
                                XMSSReducedSignature.Builder builder5 = new XMSSReducedSignature.Builder(this.f6787a);
                                builder5.f6799a = d2;
                                builder5.a = bDSStateMap.a(i5).a();
                                arrayList.add(new XMSSReducedSignature(builder5));
                                i5++;
                                i3 = i;
                                j3 = j;
                                i4 = 1;
                                z = false;
                            }
                        } else {
                            i = i3;
                            j = j4;
                        }
                        treeMap.put(Integer.valueOf(i5), new BDS(this.f6787a, this.f6785a.a(), XMSSUtil.b(this.f6785a.f6773a), oTSHashAddress2));
                        XMSSReducedSignature.Builder builder52 = new XMSSReducedSignature.Builder(this.f6787a);
                        builder52.f6799a = d2;
                        builder52.a = bDSStateMap.a(i5).a();
                        arrayList.add(new XMSSReducedSignature(builder52));
                        i5++;
                        i3 = i;
                        j3 = j;
                        i4 = 1;
                        z = false;
                    }
                    XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters3 = this.b;
                    if (xMSSMTPrivateKeyParameters3 != null) {
                        BDSStateMap bDSStateMap2 = new BDSStateMap(xMSSMTPrivateKeyParameters3.f6771a, xMSSMTPrivateKeyParameters3.f6772a, xMSSMTPrivateKeyParameters3.a, xMSSMTPrivateKeyParameters3.c, xMSSMTPrivateKeyParameters3.f6773a);
                        XMSSMTPrivateKeyParameters.Builder builder6 = new XMSSMTPrivateKeyParameters.Builder(xMSSMTPrivateKeyParameters3.f6772a);
                        builder6.a = xMSSMTPrivateKeyParameters3.a + 1;
                        builder6.f6776a = XMSSUtil.b(xMSSMTPrivateKeyParameters3.f6773a);
                        builder6.b = XMSSUtil.b(xMSSMTPrivateKeyParameters3.b);
                        builder6.c = XMSSUtil.b(xMSSMTPrivateKeyParameters3.c);
                        builder6.d = XMSSUtil.b(xMSSMTPrivateKeyParameters3.d);
                        builder6.f6774a = bDSStateMap2;
                        XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters4 = new XMSSMTPrivateKeyParameters(builder6);
                        this.f6785a = xMSSMTPrivateKeyParameters4;
                        this.b = xMSSMTPrivateKeyParameters4;
                    } else {
                        this.f6785a = null;
                    }
                    XMSSMTParameters xMSSMTParameters = xMSSMTSignature.f6780a;
                    int a5 = xMSSMTParameters.a();
                    int i6 = xMSSMTParameters.f6770a.f6789a.f6760a.c;
                    int i7 = xMSSMTParameters.a;
                    int ceil = (int) Math.ceil(((double) i7) / 8.0d);
                    int i8 = xMSSMTParameters.b;
                    int i9 = ((i7 / i8) + i6) * a5;
                    byte[] bArr2 = new byte[(ceil + a5 + (i8 * i9))];
                    XMSSUtil.d(bArr2, 0, XMSSUtil.j(ceil, xMSSMTSignature.a));
                    int i10 = ceil + 0;
                    XMSSUtil.d(bArr2, i10, xMSSMTSignature.f6781a);
                    int i11 = i10 + a5;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        XMSSUtil.d(bArr2, i11, ((XMSSReducedSignature) it.next()).a());
                        i11 += i9;
                    }
                    return bArr2;
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
            this.f6788a = true;
            XMSSMTPrivateKeyParameters xMSSMTPrivateKeyParameters = (XMSSMTPrivateKeyParameters) cipherParameters;
            this.f6785a = xMSSMTPrivateKeyParameters;
            this.b = xMSSMTPrivateKeyParameters;
            XMSSMTParameters xMSSMTParameters = xMSSMTPrivateKeyParameters.f6772a;
            this.f6784a = xMSSMTParameters;
            this.f6787a = xMSSMTParameters.f6770a;
        } else {
            this.f6788a = false;
            XMSSMTPublicKeyParameters xMSSMTPublicKeyParameters = (XMSSMTPublicKeyParameters) cipherParameters;
            this.f6786a = xMSSMTPublicKeyParameters;
            XMSSMTParameters xMSSMTParameters2 = xMSSMTPublicKeyParameters.a;
            this.f6784a = xMSSMTParameters2;
            this.f6787a = xMSSMTParameters2.f6770a;
        }
        this.a = new WOTSPlus(new WOTSPlusParameters(this.f6784a.f6770a.f6789a.f6760a.f6763a));
    }

    public final boolean c(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = bArr2;
        if (bArr3 == null) {
            throw new NullPointerException("signature == null");
        } else if (this.f6786a != null) {
            XMSSMTSignature.Builder builder = new XMSSMTSignature.Builder(this.f6784a);
            builder.b = bArr3;
            XMSSMTSignature xMSSMTSignature = new XMSSMTSignature(builder);
            byte[] b2 = XMSSUtil.b(xMSSMTSignature.f6781a);
            byte[] b3 = XMSSUtil.b(this.f6786a.f6777a);
            int a2 = this.f6784a.a();
            long j = xMSSMTSignature.a;
            byte[] a3 = this.a.a.a(Arrays.j(b2, b3, XMSSUtil.j(a2, j)), bArr);
            int i = this.f6787a.a;
            long j2 = j >> i;
            int f = XMSSUtil.f(i, j);
            this.a.f(new byte[this.f6784a.a()], XMSSUtil.b(this.f6786a.b));
            OTSHashAddress.Builder builder2 = (OTSHashAddress.Builder) new OTSHashAddress.Builder().d(j2);
            builder2.d = f;
            OTSHashAddress oTSHashAddress = new OTSHashAddress(builder2);
            ArrayList arrayList = xMSSMTSignature.f6779a;
            XMSSNode a4 = XMSSVerifierUtil.a(this.a, i, a3, (XMSSReducedSignature) arrayList.get(0), oTSHashAddress, f);
            for (int i2 = 1; i2 < this.f6784a.b; i2++) {
                int f2 = XMSSUtil.f(i, j2);
                j2 >>= i;
                OTSHashAddress.Builder builder3 = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(i2)).d(j2);
                builder3.d = f2;
                OTSHashAddress oTSHashAddress2 = new OTSHashAddress(builder3);
                int i3 = i;
                a4 = XMSSVerifierUtil.a(this.a, i3, a4.b(), (XMSSReducedSignature) arrayList.get(i2), oTSHashAddress2, f2);
            }
            return Arrays.l(a4.b(), XMSSUtil.b(this.f6786a.f6777a));
        } else {
            throw new NullPointerException("publicKey == null");
        }
    }

    public final WOTSPlusSignature d(byte[] bArr, OTSHashAddress oTSHashAddress) {
        if (bArr.length == this.f6784a.a()) {
            WOTSPlus wOTSPlus = this.a;
            wOTSPlus.f(wOTSPlus.e(XMSSUtil.b(this.f6785a.f6773a), oTSHashAddress), this.f6785a.a());
            return this.a.g(bArr, oTSHashAddress);
        }
        throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
    }
}
