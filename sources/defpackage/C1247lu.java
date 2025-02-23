package defpackage;

import defpackage.Yg;
import java.security.Key;
import java.security.PublicKey;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

/* renamed from: lu  reason: default package and case insensitive filesystem */
/* compiled from: RsaKeyManagementAlgorithm */
public class C1247lu extends C1422uE {

    /* renamed from: lu$a */
    /* compiled from: RsaKeyManagementAlgorithm */
    public static class a extends C1247lu {
        public a() {
            super("RSA/ECB/PKCS1Padding", "RSA1_5");
        }
    }

    /* renamed from: lu$b */
    /* compiled from: RsaKeyManagementAlgorithm */
    public static class b extends C1247lu {
        public b() {
            super("RSA/ECB/OAEPWithSHA-256AndMGF1Padding", "RSA-OAEP-256");
            this.a = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        }

        public final boolean b() {
            try {
                Yg a = Yg.a.a();
                g(a.a, new Qp(16, 2, "AES"), (C0638Pe) null, (byte[]) null, new Nq());
                return true;
            } catch (C0626Og e) {
                this.b.b(this.f6950a + " is not available due to " + C1354qp.J0(e));
                return false;
            }
        }
    }

    /* renamed from: lu$c */
    /* compiled from: RsaKeyManagementAlgorithm */
    public static class c extends C1247lu {
        public c() {
            super("RSA/ECB/OAEPWithSHA-1AndMGF1Padding", "RSA-OAEP");
        }
    }

    public C1247lu(String str, String str2) {
        super(str, str2);
    }

    public final void a(Key key, X6 x6) throws C1259mg {
        C1354qp.v((PublicKey) C1354qp.o(key, PublicKey.class));
    }

    public boolean b() {
        try {
            if (C1354qp.M(this.b) != null) {
                return true;
            }
            return false;
        } catch (C0626Og unused) {
        }
    }
}
