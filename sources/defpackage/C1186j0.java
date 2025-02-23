package defpackage;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* renamed from: j0  reason: default package and case insensitive filesystem */
/* compiled from: AesKeyWrapManagementAlgorithm */
public class C1186j0 extends C1422uE {
    public final int a;

    /* renamed from: j0$a */
    /* compiled from: AesKeyWrapManagementAlgorithm */
    public static class a extends C1186j0 {
        public a() {
            super("A128KW", 16);
        }
    }

    /* renamed from: j0$b */
    /* compiled from: AesKeyWrapManagementAlgorithm */
    public static class b extends C1186j0 {
        public b() {
            super("A192KW", 24);
        }
    }

    /* renamed from: j0$c */
    /* compiled from: AesKeyWrapManagementAlgorithm */
    public static class c extends C1186j0 {
        public c() {
            super("A256KW", 32);
        }
    }

    public C1186j0(String str, int i) {
        super("AESWrap", str);
        this.a = i;
    }

    public final void a(Key key, X6 x6) throws C1259mg {
        C1354qp.M0(key, this.f6950a, this.a);
    }

    public final boolean b() {
        int i = this.a;
        String str = this.b;
        try {
            Cipher.getInstance(str);
            return C1084e5.a(i, str);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            this.b.c("{} for {} is not available ({}).", str, this.f6950a, C1354qp.J0(e));
            return false;
        }
    }
}
