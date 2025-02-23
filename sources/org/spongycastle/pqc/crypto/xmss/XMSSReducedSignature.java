package org.spongycastle.pqc.crypto.xmss;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class XMSSReducedSignature implements XMSSStoreableObjectInterface {
    public final List<XMSSNode> a;

    /* renamed from: a  reason: collision with other field name */
    public final WOTSPlusSignature f6797a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSParameters f6798a;

    public static class Builder {
        public List<XMSSNode> a = null;

        /* renamed from: a  reason: collision with other field name */
        public WOTSPlusSignature f6799a = null;

        /* renamed from: a  reason: collision with other field name */
        public final XMSSParameters f6800a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6801a = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.f6800a = xMSSParameters;
        }
    }

    public XMSSReducedSignature(Builder builder) {
        XMSSParameters xMSSParameters = builder.f6800a;
        this.f6798a = xMSSParameters;
        if (xMSSParameters != null) {
            int a2 = xMSSParameters.a();
            WOTSPlusParameters wOTSPlusParameters = xMSSParameters.f6789a.f6760a;
            int i = wOTSPlusParameters.c;
            int i2 = xMSSParameters.a;
            byte[] bArr = builder.f6801a;
            if (bArr != null) {
                if (bArr.length == (i2 * a2) + (i * a2)) {
                    byte[][] bArr2 = new byte[i][];
                    int i3 = 0;
                    for (int i4 = 0; i4 < i; i4++) {
                        bArr2[i4] = XMSSUtil.e(i3, bArr, a2);
                        i3 += a2;
                    }
                    this.f6797a = new WOTSPlusSignature(this.f6798a.f6789a.f6760a, bArr2);
                    ArrayList arrayList = new ArrayList();
                    for (int i5 = 0; i5 < i2; i5++) {
                        arrayList.add(new XMSSNode(i5, XMSSUtil.e(i3, bArr, a2)));
                        i3 += a2;
                    }
                    this.a = arrayList;
                    return;
                }
                throw new IllegalArgumentException("signature has wrong size");
            }
            WOTSPlusSignature wOTSPlusSignature = builder.f6799a;
            if (wOTSPlusSignature != null) {
                this.f6797a = wOTSPlusSignature;
            } else {
                int[] iArr = new int[2];
                iArr[1] = a2;
                iArr[0] = i;
                this.f6797a = new WOTSPlusSignature(wOTSPlusParameters, (byte[][]) Array.newInstance(Byte.TYPE, iArr));
            }
            List<XMSSNode> list = builder.a;
            if (list == null) {
                this.a = new ArrayList();
            } else if (list.size() == i2) {
                this.a = list;
            } else {
                throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public byte[] a() {
        XMSSParameters xMSSParameters = this.f6798a;
        int a2 = xMSSParameters.a();
        byte[] bArr = new byte[((xMSSParameters.a * a2) + (xMSSParameters.f6789a.f6760a.c * a2))];
        byte[][] c = XMSSUtil.c(this.f6797a.a);
        int i = 0;
        int i2 = 0;
        for (byte[] d : c) {
            XMSSUtil.d(bArr, i2, d);
            i2 += a2;
        }
        while (true) {
            List<XMSSNode> list = this.a;
            if (i >= list.size()) {
                return bArr;
            }
            XMSSUtil.d(bArr, i2, list.get(i).b());
            i2 += a2;
            i++;
        }
    }
}
