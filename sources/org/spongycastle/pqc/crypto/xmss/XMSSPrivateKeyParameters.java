package org.spongycastle.pqc.crypto.xmss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.xmss.OTSHashAddress;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Pack;

public final class XMSSPrivateKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    public final BDS a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSParameters f6790a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6791a;
    public final byte[] b;
    public final byte[] c;
    public final byte[] d;

    public static class Builder {
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public BDS f6792a = null;

        /* renamed from: a  reason: collision with other field name */
        public final XMSSParameters f6793a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6794a = null;
        public byte[] b = null;
        public byte[] c = null;
        public byte[] d = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.f6793a = xMSSParameters;
        }
    }

    public XMSSPrivateKeyParameters(Builder builder) {
        super(true);
        XMSSParameters xMSSParameters = builder.f6793a;
        this.f6790a = xMSSParameters;
        if (xMSSParameters != null) {
            int a2 = xMSSParameters.a();
            byte[] bArr = builder.f6794a;
            if (bArr == null) {
                this.f6791a = new byte[a2];
            } else if (bArr.length == a2) {
                this.f6791a = bArr;
            } else {
                throw new IllegalArgumentException("size of secretKeySeed needs to be equal size of digest");
            }
            byte[] bArr2 = builder.b;
            if (bArr2 == null) {
                this.b = new byte[a2];
            } else if (bArr2.length == a2) {
                this.b = bArr2;
            } else {
                throw new IllegalArgumentException("size of secretKeyPRF needs to be equal size of digest");
            }
            byte[] bArr3 = builder.c;
            if (bArr3 == null) {
                this.c = new byte[a2];
            } else if (bArr3.length == a2) {
                this.c = bArr3;
            } else {
                throw new IllegalArgumentException("size of publicSeed needs to be equal size of digest");
            }
            byte[] bArr4 = builder.d;
            if (bArr4 == null) {
                this.d = new byte[a2];
            } else if (bArr4.length == a2) {
                this.d = bArr4;
            } else {
                throw new IllegalArgumentException("size of root needs to be equal size of digest");
            }
            BDS bds = builder.f6792a;
            if (bds != null) {
                this.a = bds;
                return;
            }
            int i = builder.a;
            if (i >= (1 << xMSSParameters.a) - 2 || bArr3 == null || bArr == null) {
                this.a = new BDS(xMSSParameters, i);
            } else {
                this.a = new BDS(xMSSParameters, bArr3, bArr, new OTSHashAddress(new OTSHashAddress.Builder()), builder.a);
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public final byte[] a() {
        int a2 = this.f6790a.a();
        int i = a2 + 4;
        int i2 = i + a2;
        int i3 = i2 + a2;
        byte[] bArr = new byte[(a2 + i3)];
        BDS bds = this.a;
        Pack.c(bds.e, bArr, 0);
        XMSSUtil.d(bArr, 4, this.f6791a);
        XMSSUtil.d(bArr, i, this.b);
        XMSSUtil.d(bArr, i2, this.c);
        XMSSUtil.d(bArr, i3, this.d);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(bds);
            objectOutputStream.flush();
            return Arrays.i(bArr, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(C0709Uj.g(e, new StringBuilder("error serializing bds state: ")));
        }
    }
}
