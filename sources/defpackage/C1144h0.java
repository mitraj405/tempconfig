package defpackage;

import defpackage.C0600Mw;
import java.security.Key;

/* renamed from: h0  reason: default package and case insensitive filesystem */
/* compiled from: AesGcmKeyEncryptionAlgorithm */
public class C1144h0 extends C1379s0 implements C1387sh {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final C0600Mw f5473a = new C0600Mw();

    /* renamed from: h0$a */
    /* compiled from: AesGcmKeyEncryptionAlgorithm */
    public static class a extends C1144h0 {
        public a() {
            super("A128GCMKW", 16);
        }
    }

    /* renamed from: h0$b */
    /* compiled from: AesGcmKeyEncryptionAlgorithm */
    public static class b extends C1144h0 {
        public b() {
            super("A192GCMKW", 24);
        }
    }

    /* renamed from: h0$c */
    /* compiled from: AesGcmKeyEncryptionAlgorithm */
    public static class c extends C1144h0 {
        public c() {
            super("A256GCMKW", 32);
        }
    }

    public C1144h0(String str, int i) {
        this.f6950a = str;
        this.b = "AES/GCM/NoPadding";
        this.a = i;
    }

    public final void a(Key key, X6 x6) throws C1259mg {
        C1354qp.M0(key, this.f6950a, this.a);
    }

    public final boolean b() {
        String str = this.f6950a;
        return this.f5473a.b(this.a, this.a, str);
    }

    public final ng g(Key key, Qp qp, C0638Pe pe, byte[] bArr, Nq nq) throws C0626Og {
        byte[] bArr2;
        nq.getClass();
        if (bArr == null) {
            bArr = C1354qp.k0(qp.b);
        }
        nh nhVar = new nh(3);
        String a2 = pe.a("iv");
        if (a2 == null) {
            bArr2 = C1354qp.k0(12);
            pe.b(nhVar.e(bArr2), "iv");
        } else {
            bArr2 = nhVar.d(a2);
        }
        nq.a.getClass();
        C0600Mw.a a3 = this.f5473a.a(key, bArr2, bArr, (byte[]) null);
        byte[] bArr3 = a3.a;
        pe.b(nhVar.e(a3.b), "tag");
        return new ng(bArr, bArr3);
    }
}
