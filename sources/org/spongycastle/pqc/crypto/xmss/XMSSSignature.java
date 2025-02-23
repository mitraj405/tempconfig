package org.spongycastle.pqc.crypto.xmss;

import java.util.List;
import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;
import org.spongycastle.util.Pack;

public final class XMSSSignature extends XMSSReducedSignature {
    public final byte[] a;
    public final int c;

    public static class Builder extends XMSSReducedSignature.Builder {
        public int a = 0;
        public byte[] b = null;

        public Builder(XMSSParameters xMSSParameters) {
            super(xMSSParameters);
        }
    }

    public XMSSSignature(Builder builder) {
        super(builder);
        this.c = builder.a;
        int a2 = this.f6798a.a();
        byte[] bArr = builder.b;
        if (bArr == null) {
            this.a = new byte[a2];
        } else if (bArr.length == a2) {
            this.a = bArr;
        } else {
            throw new IllegalArgumentException("size of random needs to be equal to size of digest");
        }
    }

    public final byte[] a() {
        XMSSParameters xMSSParameters = this.f6798a;
        int a2 = xMSSParameters.a();
        int i = a2 + 4;
        byte[] bArr = new byte[((xMSSParameters.f6789a.f6760a.c * a2) + i + (xMSSParameters.a * a2))];
        int i2 = 0;
        Pack.c(this.c, bArr, 0);
        XMSSUtil.d(bArr, 4, this.a);
        byte[][] c2 = XMSSUtil.c(this.f6797a.a);
        for (byte[] d : c2) {
            XMSSUtil.d(bArr, i, d);
            i += a2;
        }
        while (true) {
            List<XMSSNode> list = this.a;
            if (i2 >= list.size()) {
                return bArr;
            }
            XMSSUtil.d(bArr, i, list.get(i2).b());
            i += a2;
            i2++;
        }
    }
}
