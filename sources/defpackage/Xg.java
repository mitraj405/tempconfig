package defpackage;

import java.security.Key;

/* renamed from: Xg  reason: default package */
/* compiled from: JsonWebEncryption */
public final class Xg extends C0803bh {
    public static final C1315p0 c = new C1315p0(4, "RSA1_5", "PBES2-HS256+A128KW", "PBES2-HS384+A192KW", "PBES2-HS512+A256KW");
    public final String a = "UTF-8";
    public final nh b = new nh(3);

    /* renamed from: b  reason: collision with other field name */
    public final C1315p0 f3834b = C1315p0.a;

    /* renamed from: b  reason: collision with other field name */
    public byte[] f3835b;

    /* renamed from: c  reason: collision with other field name */
    public byte[] f3836c;
    public byte[] d;

    public Xg() {
        this.f3917a = c;
    }

    public final String b() throws C0626Og {
        byte[] bArr;
        C0638Pe pe = this.f3914a;
        String a2 = pe.a("alg");
        if (a2 != null) {
            this.f3917a.a(a2);
            C1359r0 r0Var = C1359r0.f6934a;
            C1387sh a3 = r0Var.b.a(a2);
            String a4 = pe.a("enc");
            if (a4 != null) {
                this.f3834b.a(a4);
                X6 a5 = r0Var.c.a(a4);
                Qp h = a5.h();
                Key key = this.f3915a;
                if (this.f3918a) {
                    a3.a(key, a5);
                }
                ng g = a3.g(key, h, this.f3914a, this.d, this.a);
                this.d = (byte[]) g.a;
                byte[] u = r1.u(a(), "US-ASCII");
                byte[] bArr2 = (byte[]) g.a;
                byte[] bArr3 = this.f3835b;
                if (bArr3 != null) {
                    String a6 = pe.a("zip");
                    if (a6 != null) {
                        bArr = r0Var.d.a(a6).d(bArr3);
                    } else {
                        bArr = bArr3;
                    }
                    int i = h.b;
                    if (bArr2.length == i) {
                        C0344tk c2 = a5.c(bArr, u, bArr2, this.f3914a, this.f3836c, this.a);
                        byte[] bArr4 = (byte[]) c2.a;
                        this.f3836c = bArr4;
                        nh nhVar = this.b;
                        String e = nhVar.e(bArr4);
                        String e2 = nhVar.e((byte[]) c2.b);
                        String e3 = nhVar.e((byte[]) c2.c);
                        return C1354qp.w0(a(), nhVar.e((byte[]) g.b), e, e2, e3);
                    }
                    throw new C1259mg(C1354qp.l(bArr2.length) + " bit content encryption key is not the correct size for the " + a5.e() + " content encryption algorithm (" + C1354qp.l(i) + ").");
                }
                throw new NullPointerException("The plaintext payload for the JWE has not been set.");
            }
            throw new C1240lg("Content encryption header (enc) not set.");
        }
        throw new C1240lg("Encryption key management algorithm header (alg) not set.");
    }
}
