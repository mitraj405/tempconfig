package defpackage;

import defpackage.Nq;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;

/* renamed from: e0  reason: default package and case insensitive filesystem */
/* compiled from: AesCbcHmacSha2ContentEncryptionAlgorithm */
public class C1080e0 extends C1379s0 implements X6 {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Qp f5450a;
    public final String c;

    /* renamed from: e0$a */
    /* compiled from: AesCbcHmacSha2ContentEncryptionAlgorithm */
    public static class a extends C1080e0 {
        public a() {
            super("A128CBC-HS256", 32, "HmacSHA256", 16);
        }
    }

    /* renamed from: e0$b */
    /* compiled from: AesCbcHmacSha2ContentEncryptionAlgorithm */
    public static class b extends C1080e0 {
        public b() {
            super("A192CBC-HS384", 48, "HmacSHA384", 24);
        }
    }

    /* renamed from: e0$c */
    /* compiled from: AesCbcHmacSha2ContentEncryptionAlgorithm */
    public static class c extends C1080e0 {
        public c() {
            super("A256CBC-HS512", 64, "HmacSHA512", 32);
        }
    }

    public C1080e0(String str, int i, String str2, int i2) {
        this.f6950a = str;
        this.f5450a = new Qp(i, 2, "AES");
        this.c = str2;
        this.a = i2;
        this.b = "AES/CBC/PKCS5Padding";
    }

    public final boolean b() {
        return C1084e5.a(this.f5450a.b / 2, this.b);
    }

    public final C0344tk c(byte[] bArr, byte[] bArr2, byte[] bArr3, C0638Pe pe, byte[] bArr4, Nq nq) throws C0626Og {
        boolean z;
        Nq.a aVar;
        boolean z2;
        nq.getClass();
        if (bArr4 == null) {
            bArr4 = C1354qp.k0(16);
        }
        C1167i0 i0Var = new C1167i0(C1354qp.z0(bArr3, 0, bArr3.length / 2), 1);
        int length = bArr3.length / 2;
        C1167i0 i0Var2 = new C1167i0(C1354qp.z0(bArr3, length, length), 0);
        if (pe == null || !"dir".equals(pe.a("alg"))) {
            z = false;
        } else {
            z = true;
        }
        Nq.a aVar2 = nq.a;
        Nq.a aVar3 = nq.b;
        if (z) {
            aVar = aVar2;
        } else {
            aVar = aVar3;
        }
        aVar.getClass();
        Cipher M = C1354qp.M(this.b);
        try {
            M.init(1, i0Var2, new IvParameterSpec(bArr4));
            try {
                byte[] doFinal = M.doFinal(bArr);
                if (pe == null || !"dir".equals(pe.a("alg"))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    aVar2 = aVar3;
                }
                aVar2.getClass();
                Mac x = r1.x(this.c, i0Var);
                long l = (long) C1354qp.l(bArr2.length);
                ByteBuffer allocate = ByteBuffer.allocate(8);
                allocate.putLong(l);
                return new C0344tk(bArr4, doFinal, C1354qp.z0(x.doFinal(C1354qp.A(bArr2, bArr4, doFinal, allocate.array())), 0, this.a));
            } catch (BadPaddingException | IllegalBlockSizeException e) {
                throw new C0626Og(e.toString(), e);
            }
        } catch (InvalidKeyException e2) {
            throw new C0626Og("Invalid key for " + this.b, e2);
        } catch (InvalidAlgorithmParameterException e3) {
            throw new C0626Og(e3.toString(), e3);
        }
    }

    public final Qp h() {
        return this.f5450a;
    }
}
