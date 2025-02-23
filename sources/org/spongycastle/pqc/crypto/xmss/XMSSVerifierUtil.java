package org.spongycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import java.util.List;
import org.spongycastle.pqc.crypto.xmss.HashTreeAddress;
import org.spongycastle.pqc.crypto.xmss.LTreeAddress;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;

class XMSSVerifierUtil {
    public static XMSSNode a(WOTSPlus wOTSPlus, int i, byte[] bArr, XMSSReducedSignature xMSSReducedSignature, OTSHashAddress oTSHashAddress, int i2) {
        char c;
        WOTSPlus wOTSPlus2 = wOTSPlus;
        byte[] bArr2 = bArr;
        XMSSReducedSignature xMSSReducedSignature2 = xMSSReducedSignature;
        OTSHashAddress oTSHashAddress2 = oTSHashAddress;
        if (bArr2.length != wOTSPlus2.f6760a.a) {
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        } else if (xMSSReducedSignature2 != null) {
            LTreeAddress.Builder builder = new LTreeAddress.Builder();
            int i3 = oTSHashAddress2.a;
            long j = oTSHashAddress2.f6765a;
            LTreeAddress.Builder builder2 = (LTreeAddress.Builder) ((LTreeAddress.Builder) builder.c(i3)).d(j);
            int i4 = oTSHashAddress2.d;
            builder2.d = i4;
            LTreeAddress lTreeAddress = new LTreeAddress(builder2);
            HashTreeAddress.Builder builder3 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(i3)).d(j);
            builder3.e = i4;
            HashTreeAddress hashTreeAddress = new HashTreeAddress(builder3);
            int length = bArr2.length;
            WOTSPlusParameters wOTSPlusParameters = wOTSPlus2.f6760a;
            if (length == wOTSPlusParameters.a) {
                WOTSPlusSignature wOTSPlusSignature = xMSSReducedSignature2.f6797a;
                if (wOTSPlusSignature != null) {
                    int i5 = wOTSPlusParameters.b;
                    int i6 = wOTSPlusParameters.d;
                    ArrayList b = WOTSPlus.b(i5, bArr2, i6);
                    int i7 = 0;
                    for (int i8 = 0; i8 < i6; i8++) {
                        i7 += (i5 - 1) - ((Integer) b.get(i8)).intValue();
                    }
                    int i9 = XMSSUtil.i(i5);
                    int i10 = wOTSPlusParameters.e;
                    b.addAll(WOTSPlus.b(i5, XMSSUtil.j((int) Math.ceil(((double) (XMSSUtil.i(i5) * i10)) / 8.0d), (long) (i7 << (8 - ((i9 * i10) % 8)))), i10));
                    int i11 = wOTSPlusParameters.c;
                    byte[][] bArr3 = new byte[i11][];
                    int i12 = 0;
                    while (i12 < i11) {
                        OTSHashAddress.Builder builder4 = (OTSHashAddress.Builder) ((OTSHashAddress.Builder) new OTSHashAddress.Builder().c(oTSHashAddress2.a)).d(oTSHashAddress2.f6765a);
                        builder4.d = oTSHashAddress2.d;
                        builder4.e = i12;
                        builder4.f = oTSHashAddress2.f;
                        OTSHashAddress.Builder builder5 = (OTSHashAddress.Builder) builder4.b(oTSHashAddress2.c);
                        builder5.getClass();
                        OTSHashAddress oTSHashAddress3 = new OTSHashAddress(builder5);
                        bArr3[i12] = wOTSPlus2.a(XMSSUtil.c(wOTSPlusSignature.a)[i12], ((Integer) b.get(i12)).intValue(), (i5 - 1) - ((Integer) b.get(i12)).intValue(), oTSHashAddress3);
                        i12++;
                        oTSHashAddress2 = oTSHashAddress3;
                    }
                    XMSSNode[] xMSSNodeArr = new XMSSNode[2];
                    xMSSNodeArr[0] = XMSSNodeUtil.a(wOTSPlus2, new WOTSPlusPublicKeyParameters(wOTSPlusParameters, bArr3), lTreeAddress);
                    int i13 = i;
                    for (int i14 = 0; i14 < i13; i14++) {
                        HashTreeAddress.Builder builder6 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(hashTreeAddress.a)).d(hashTreeAddress.f6765a);
                        builder6.d = i14;
                        builder6.e = hashTreeAddress.e;
                        HashTreeAddress.Builder builder7 = (HashTreeAddress.Builder) builder6.b(hashTreeAddress.c);
                        builder7.getClass();
                        HashTreeAddress hashTreeAddress2 = new HashTreeAddress(builder7);
                        int i15 = ((Math.floor((double) (i2 / (1 << i14))) % 2.0d) > 0.0d ? 1 : ((Math.floor((double) (i2 / (1 << i14))) % 2.0d) == 0.0d ? 0 : -1));
                        List<XMSSNode> list = xMSSReducedSignature2.a;
                        int i16 = hashTreeAddress2.a;
                        int i17 = hashTreeAddress2.c;
                        int i18 = hashTreeAddress2.e;
                        int i19 = hashTreeAddress2.d;
                        long j2 = hashTreeAddress2.f6765a;
                        if (i15 == 0) {
                            HashTreeAddress.Builder builder8 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(i16)).d(j2);
                            builder8.d = i19;
                            builder8.e = i18 / 2;
                            HashTreeAddress.Builder builder9 = (HashTreeAddress.Builder) builder8.b(i17);
                            builder9.getClass();
                            hashTreeAddress = new HashTreeAddress(builder9);
                            XMSSNode b2 = XMSSNodeUtil.b(wOTSPlus2, xMSSNodeArr[0], list.get(i14), hashTreeAddress);
                            c = 1;
                            xMSSNodeArr[1] = b2;
                            xMSSNodeArr[1] = new XMSSNode(b2.c + 1, b2.b());
                        } else {
                            HashTreeAddress.Builder builder10 = (HashTreeAddress.Builder) ((HashTreeAddress.Builder) new HashTreeAddress.Builder().c(i16)).d(j2);
                            builder10.d = i19;
                            builder10.e = (i18 - 1) / 2;
                            HashTreeAddress.Builder builder11 = (HashTreeAddress.Builder) builder10.b(i17);
                            builder11.getClass();
                            hashTreeAddress = new HashTreeAddress(builder11);
                            XMSSNode b3 = XMSSNodeUtil.b(wOTSPlus2, list.get(i14), xMSSNodeArr[0], hashTreeAddress);
                            c = 1;
                            xMSSNodeArr[1] = b3;
                            xMSSNodeArr[1] = new XMSSNode(b3.c + 1, b3.b());
                        }
                        xMSSNodeArr[0] = xMSSNodeArr[c];
                    }
                    return xMSSNodeArr[0];
                }
                throw new NullPointerException("signature == null");
            }
            throw new IllegalArgumentException("size of messageDigest needs to be equal to size of digest");
        } else {
            throw new NullPointerException("signature == null");
        }
    }
}
