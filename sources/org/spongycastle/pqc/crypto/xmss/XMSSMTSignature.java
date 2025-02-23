package org.spongycastle.pqc.crypto.xmss;

import java.util.ArrayList;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;

public final class XMSSMTSignature implements XMSSStoreableObjectInterface {
    public final long a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f6779a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSMTParameters f6780a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6781a;

    public static class Builder {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public final XMSSMTParameters f6782a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6783a = null;
        public byte[] b = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.f6782a = xMSSMTParameters;
        }
    }

    public XMSSMTSignature(Builder builder) {
        XMSSMTParameters xMSSMTParameters = builder.f6782a;
        this.f6780a = xMSSMTParameters;
        if (xMSSMTParameters != null) {
            int a2 = xMSSMTParameters.a();
            byte[] bArr = builder.b;
            if (bArr != null) {
                int i = xMSSMTParameters.f6770a.f6789a.f6760a.c;
                int i2 = xMSSMTParameters.a;
                int ceil = (int) Math.ceil(((double) i2) / 8.0d);
                int i3 = xMSSMTParameters.b;
                int i4 = ((i2 / i3) + i) * a2;
                if (bArr.length == ceil + a2 + (i3 * i4)) {
                    long a3 = XMSSUtil.a(bArr, ceil);
                    this.a = a3;
                    if (XMSSUtil.h(i2, a3)) {
                        int i5 = ceil + 0;
                        this.f6781a = XMSSUtil.e(i5, bArr, a2);
                        this.f6779a = new ArrayList();
                        for (int i6 = i5 + a2; i6 < bArr.length; i6 += i4) {
                            XMSSReducedSignature.Builder builder2 = new XMSSReducedSignature.Builder(this.f6780a.f6770a);
                            builder2.f6801a = XMSSUtil.b(XMSSUtil.e(i6, bArr, i4));
                            this.f6779a.add(new XMSSReducedSignature(builder2));
                        }
                        return;
                    }
                    throw new IllegalArgumentException("index out of bounds");
                }
                throw new IllegalArgumentException("signature has wrong size");
            }
            this.a = builder.a;
            byte[] bArr2 = builder.f6783a;
            if (bArr2 == null) {
                this.f6781a = new byte[a2];
            } else if (bArr2.length == a2) {
                this.f6781a = bArr2;
            } else {
                throw new IllegalArgumentException("size of random needs to be equal to size of digest");
            }
            this.f6779a = new ArrayList();
            return;
        }
        throw new NullPointerException("params == null");
    }
}
