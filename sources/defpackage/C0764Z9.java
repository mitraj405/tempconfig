package defpackage;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: Z9  reason: default package and case insensitive filesystem */
/* compiled from: EcdhKeyAgreementWithAesKeyWrapAlgorithm */
public class C0764Z9 extends C1379s0 implements C1387sh {
    public final Qp a;

    /* renamed from: a  reason: collision with other field name */
    public final C0754Y9 f3878a = new C0754Y9(0);

    /* renamed from: a  reason: collision with other field name */
    public final C1186j0 f3879a;

    /* renamed from: Z9$a */
    /* compiled from: EcdhKeyAgreementWithAesKeyWrapAlgorithm */
    public static class a extends C0764Z9 {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a() {
            /*
                r2 = this;
                j0$a r0 = new j0$a
                r0.<init>()
                r1 = 0
                r0.f6984a = r1
                java.lang.String r1 = "ECDH-ES+A128KW"
                r2.<init>(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0764Z9.a.<init>():void");
        }
    }

    /* renamed from: Z9$b */
    /* compiled from: EcdhKeyAgreementWithAesKeyWrapAlgorithm */
    public static class b extends C0764Z9 {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b() {
            /*
                r2 = this;
                j0$b r0 = new j0$b
                r0.<init>()
                r1 = 0
                r0.f6984a = r1
                java.lang.String r1 = "ECDH-ES+A192KW"
                r2.<init>(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0764Z9.b.<init>():void");
        }
    }

    /* renamed from: Z9$c */
    /* compiled from: EcdhKeyAgreementWithAesKeyWrapAlgorithm */
    public static class c extends C0764Z9 {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c() {
            /*
                r2 = this;
                j0$c r0 = new j0$c
                r0.<init>()
                r1 = 0
                r0.f6984a = r1
                java.lang.String r1 = "ECDH-ES+A256KW"
                r2.<init>(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0764Z9.c.<init>():void");
        }
    }

    public C0764Z9(String str, C1186j0 j0Var) {
        this.f6950a = str;
        this.b = "N/A";
        this.f3879a = j0Var;
        this.a = new Qp(j0Var.a, 2, "AES");
    }

    public final void a(Key key, X6 x6) throws C1259mg {
        this.f3878a.a(key, x6);
    }

    public final boolean b() {
        if (!this.f3878a.b() || !this.f3879a.b()) {
            return false;
        }
        return true;
    }

    public final ng g(Key key, Qp qp, C0638Pe pe, byte[] bArr, Nq nq) throws C0626Og {
        return this.f3879a.g(new SecretKeySpec((byte[]) this.f3878a.g(key, this.a, pe, (byte[]) null, nq).a, (String) this.a.f491a), qp, pe, bArr, nq);
    }
}
