package defpackage;

import defpackage.C0600Mw;
import defpackage.Nq;

/* renamed from: g0  reason: default package and case insensitive filesystem */
/* compiled from: AesGcmContentEncryptionAlgorithm */
public class C1123g0 extends C1379s0 implements X6 {
    public final C0600Mw a = new C0600Mw();

    /* renamed from: a  reason: collision with other field name */
    public final Qp f5467a;

    /* renamed from: g0$a */
    /* compiled from: AesGcmContentEncryptionAlgorithm */
    public static class a extends C1123g0 {
        public a() {
            super("A128GCM", 128);
        }
    }

    /* renamed from: g0$b */
    /* compiled from: AesGcmContentEncryptionAlgorithm */
    public static class b extends C1123g0 {
        public b() {
            super("A192GCM", 192);
        }
    }

    /* renamed from: g0$c */
    /* compiled from: AesGcmContentEncryptionAlgorithm */
    public static class c extends C1123g0 {
        public c() {
            super("A256GCM", 256);
        }
    }

    public C1123g0(String str, int i) {
        this.f6950a = str;
        this.b = "AES/GCM/NoPadding";
        this.f5467a = new Qp(i / 8, 2, "AES");
    }

    public final boolean b() {
        return this.a.b(this.a, this.f5467a.b, this.f6950a);
    }

    public final C0344tk c(byte[] bArr, byte[] bArr2, byte[] bArr3, C0638Pe pe, byte[] bArr4, Nq nq) throws C0626Og {
        boolean z;
        Nq.a aVar;
        nq.getClass();
        if (bArr4 == null) {
            bArr4 = C1354qp.k0(12);
        }
        if (pe == null || !"dir".equals(pe.a("alg"))) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            aVar = nq.a;
        } else {
            aVar = nq.b;
        }
        aVar.getClass();
        C0600Mw.a a2 = this.a.a(new C1167i0(bArr3, 0), bArr4, bArr, bArr2);
        return new C0344tk(bArr4, a2.a, a2.b);
    }

    public final Qp h() {
        return this.f5467a;
    }
}
