package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public final class XMSSMTPublicKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    public final XMSSMTParameters a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6777a;
    public final byte[] b;

    public static class Builder {
        public final XMSSMTParameters a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6778a = null;
        public byte[] b = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.a = xMSSMTParameters;
        }
    }

    public XMSSMTPublicKeyParameters(Builder builder) {
        super(false);
        XMSSMTParameters xMSSMTParameters = builder.a;
        this.a = xMSSMTParameters;
        if (xMSSMTParameters != null) {
            int a2 = xMSSMTParameters.a();
            byte[] bArr = builder.f6778a;
            if (bArr == null) {
                this.f6777a = new byte[a2];
            } else if (bArr.length == a2) {
                this.f6777a = bArr;
            } else {
                throw new IllegalArgumentException("length of root must be equal to length of digest");
            }
            byte[] bArr2 = builder.b;
            if (bArr2 == null) {
                this.b = new byte[a2];
            } else if (bArr2.length == a2) {
                this.b = bArr2;
            } else {
                throw new IllegalArgumentException("length of publicSeed must be equal to length of digest");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public final byte[] a() {
        int a2 = this.a.a();
        byte[] bArr = new byte[(a2 + a2)];
        XMSSUtil.d(bArr, 0, this.f6777a);
        XMSSUtil.d(bArr, a2 + 0, this.b);
        return bArr;
    }
}
