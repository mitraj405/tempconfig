package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public final class XMSSPublicKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    public final XMSSParameters a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6795a;
    public final byte[] b;

    public static class Builder {
        public final XMSSParameters a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6796a = null;
        public byte[] b = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.a = xMSSParameters;
        }
    }

    public XMSSPublicKeyParameters(Builder builder) {
        super(false);
        XMSSParameters xMSSParameters = builder.a;
        this.a = xMSSParameters;
        if (xMSSParameters != null) {
            int a2 = xMSSParameters.a();
            byte[] bArr = builder.f6796a;
            if (bArr == null) {
                this.f6795a = new byte[a2];
            } else if (bArr.length == a2) {
                this.f6795a = bArr;
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
        XMSSUtil.d(bArr, 0, this.f6795a);
        XMSSUtil.d(bArr, a2 + 0, this.b);
        return bArr;
    }
}
