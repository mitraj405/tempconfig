package defpackage;

import com.google.android.gms.ads.AdRequest;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import javax.crypto.Mac;

/* renamed from: Ve  reason: default package and case insensitive filesystem */
/* compiled from: HmacUsingShaAlgorithm */
public class C0723Ve extends C1379s0 implements C0783ah {
    public final int a;

    /* renamed from: Ve$a */
    /* compiled from: HmacUsingShaAlgorithm */
    public static class a extends C0723Ve {
        public a() {
            super("HS256", "HmacSHA256", 256);
        }
    }

    /* renamed from: Ve$b */
    /* compiled from: HmacUsingShaAlgorithm */
    public static class b extends C0723Ve {
        public b() {
            super("HS384", "HmacSHA384", 384);
        }
    }

    /* renamed from: Ve$c */
    /* compiled from: HmacUsingShaAlgorithm */
    public static class c extends C0723Ve {
        public c() {
            super("HS512", "HmacSHA512", AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public C0723Ve(String str, String str2, int i) {
        this.f6950a = str;
        this.b = str2;
        this.a = i;
    }

    public final boolean b() {
        try {
            Mac.getInstance(this.b);
            return true;
        } catch (NoSuchAlgorithmException unused) {
            return false;
        }
    }

    public final void f(Key key) throws C1259mg {
        int l;
        int i;
        if (key == null) {
            throw new C1259mg("key is null");
        } else if (key.getEncoded() != null && (l = C1354qp.l(key.getEncoded().length)) < (i = this.a)) {
            StringBuilder m = lf.m("A key of the same size as the hash output (i.e. ", i, " bits for ");
            m.append(this.f6950a);
            m.append(") or larger MUST be used with the HMAC SHA algorithms but this key is only ");
            m.append(l);
            m.append(" bits");
            throw new C1259mg(m.toString());
        }
    }

    public final byte[] i(C0480D7 d7, byte[] bArr) throws C0626Og {
        return d7.f3566a.doFinal(bArr);
    }

    public final C0480D7 j(Key key, Nq nq) throws C0626Og {
        nq.a.getClass();
        return new C0480D7((Signature) null, r1.x(this.b, key));
    }
}
