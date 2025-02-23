package defpackage;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.sessions.settings.RemoteSettings;
import defpackage.Oq;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;

/* renamed from: aa  reason: default package and case insensitive filesystem */
/* compiled from: EcdsaUsingShaAlgorithm */
public class C0779aa extends A2 {
    public final int a;
    public final String c;

    /* renamed from: aa$a */
    /* compiled from: EcdsaUsingShaAlgorithm */
    public static class a extends C0779aa {
        public a() {
            super(64, "ES256", "SHA256withECDSA", "P-256");
        }
    }

    /* renamed from: aa$b */
    /* compiled from: EcdsaUsingShaAlgorithm */
    public static class b extends C0779aa {
        public b() {
            super(96, "ES384", "SHA384withECDSA", "P-384");
        }
    }

    /* renamed from: aa$c */
    /* compiled from: EcdsaUsingShaAlgorithm */
    public static class c extends C0779aa {
        public c() {
            super(132, "ES512", "SHA512withECDSA", "P-521");
        }
    }

    /* renamed from: aa$d */
    /* compiled from: EcdsaUsingShaAlgorithm */
    public static class d extends C0779aa {
        public final Bi c = C0473Ci.d(d.class);

        public d() {
            super(64, "ES256K", "SHA256withECDSA", "secp256k1");
        }

        public final boolean b() {
            if (super.b()) {
                try {
                    i(j(Oq.a.a().a, new Nq()), new byte[]{2, 6});
                    return true;
                } catch (C0626Og e) {
                    this.c.b(this.f6950a + " is not available due to " + C1354qp.J0(e));
                }
            }
            return false;
        }
    }

    public C0779aa(int i, String str, String str2, String str3) {
        super(str, str2);
        this.c = str3;
        this.a = i;
    }

    public static byte[] n(int i, byte[] bArr) throws IOException {
        int i2;
        if (bArr.length < 8 || bArr[0] != 48) {
            throw new IOException("Invalid format of ECDSA signature");
        }
        byte b2 = bArr[1];
        if (b2 > 0) {
            i2 = 2;
        } else if (b2 == -127) {
            i2 = 3;
        } else {
            throw new IOException("Invalid format of ECDSA signature");
        }
        byte b3 = bArr[i2 + 1];
        int i3 = b3;
        while (i3 > 0 && bArr[((i2 + 2) + b3) - i3] == 0) {
            i3--;
        }
        int i4 = i2 + 2 + b3;
        byte b4 = bArr[i4 + 1];
        int i5 = b4;
        while (i5 > 0 && bArr[((i4 + 2) + b4) - i5] == 0) {
            i5--;
        }
        int max = Math.max(Math.max(i3, i5), i / 2);
        byte b5 = bArr[i2 - 1];
        if ((b5 & UnsignedBytes.MAX_VALUE) == bArr.length - i2 && (b5 & UnsignedBytes.MAX_VALUE) == C1058d.q(b3, 2, 2, b4) && bArr[i2] == 2 && bArr[i4] == 2) {
            int i6 = max * 2;
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4 - i3, bArr2, max - i3, i3);
            System.arraycopy(bArr, ((i4 + 2) + b4) - i5, bArr2, i6 - i5, i5);
            return bArr2;
        }
        throw new IOException("Invalid format of ECDSA signature");
    }

    public final byte[] i(C0480D7 d7, byte[] bArr) throws C0626Og {
        try {
            return n(this.a, super.i(d7, bArr));
        } catch (IOException e) {
            throw new C0626Og("Unable to convert DER encoding to R and S as a concatenated byte array.", e);
        }
    }

    public final void m(PrivateKey privateKey) throws C1259mg {
        if (privateKey instanceof ECKey) {
            String b2 = C1153ha.b(((ECKey) privateKey).getParams().getCurve());
            String str = this.c;
            if (!str.equals(b2)) {
                throw new C1259mg(this.f6950a + RemoteSettings.FORWARD_SLASH_STRING + this.b + " expects a key using " + str + " but was " + b2);
            }
        }
    }
}
