package org.spongycastle.pqc.crypto.xmss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.util.Arrays;

public final class XMSSMTPrivateKeyParameters extends AsymmetricKeyParameter implements XMSSStoreableObjectInterface {
    public final long a;

    /* renamed from: a  reason: collision with other field name */
    public final BDSStateMap f6771a;

    /* renamed from: a  reason: collision with other field name */
    public final XMSSMTParameters f6772a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6773a;
    public final byte[] b;
    public final byte[] c;
    public final byte[] d;

    public static class Builder {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public BDSStateMap f6774a = null;

        /* renamed from: a  reason: collision with other field name */
        public final XMSSMTParameters f6775a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6776a = null;
        public byte[] b = null;
        public byte[] c = null;
        public byte[] d = null;

        public Builder(XMSSMTParameters xMSSMTParameters) {
            this.f6775a = xMSSMTParameters;
        }
    }

    public XMSSMTPrivateKeyParameters(Builder builder) {
        super(true);
        XMSSMTParameters xMSSMTParameters = builder.f6775a;
        this.f6772a = xMSSMTParameters;
        if (xMSSMTParameters != null) {
            int a2 = xMSSMTParameters.a();
            long j = builder.a;
            this.a = j;
            byte[] bArr = builder.f6776a;
            if (bArr == null) {
                this.f6773a = new byte[a2];
            } else if (bArr.length == a2) {
                this.f6773a = bArr;
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
            BDSStateMap bDSStateMap = builder.f6774a;
            if (bDSStateMap != null) {
                this.f6771a = bDSStateMap;
            } else if (!XMSSUtil.h(xMSSMTParameters.a, j) || bArr3 == null || bArr == null) {
                this.f6771a = new BDSStateMap();
            } else {
                this.f6771a = new BDSStateMap(xMSSMTParameters, builder.a, bArr3, bArr);
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public final byte[] a() {
        return XMSSUtil.b(this.c);
    }

    public final byte[] b() {
        XMSSMTParameters xMSSMTParameters = this.f6772a;
        int a2 = xMSSMTParameters.a();
        int i = (xMSSMTParameters.a + 7) / 8;
        byte[] bArr = new byte[(i + a2 + a2 + a2 + a2)];
        XMSSUtil.d(bArr, 0, XMSSUtil.j(i, this.a));
        int i2 = i + 0;
        XMSSUtil.d(bArr, i2, this.f6773a);
        int i3 = i2 + a2;
        XMSSUtil.d(bArr, i3, this.b);
        int i4 = i3 + a2;
        XMSSUtil.d(bArr, i4, this.c);
        XMSSUtil.d(bArr, i4 + a2, this.d);
        try {
            BDSStateMap bDSStateMap = this.f6771a;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(bDSStateMap);
            objectOutputStream.flush();
            return Arrays.i(bArr, byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("error serializing bds state");
        }
    }
}
