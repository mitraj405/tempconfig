package defpackage;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: sp  reason: default package and case insensitive filesystem */
/* compiled from: Pbes2HmacShaWithAesKeyWrapAlgorithm */
public class C1393sp extends C1379s0 implements C1387sh {
    public static final byte[] a = {0};

    /* renamed from: a  reason: collision with other field name */
    public final int f6954a = 12;

    /* renamed from: a  reason: collision with other field name */
    public final long f6955a = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;

    /* renamed from: a  reason: collision with other field name */
    public final Qp f6956a;

    /* renamed from: a  reason: collision with other field name */
    public final C0739Wo f6957a;

    /* renamed from: a  reason: collision with other field name */
    public final C1186j0 f6958a;

    /* renamed from: sp$a */
    /* compiled from: Pbes2HmacShaWithAesKeyWrapAlgorithm */
    public static class a extends C1393sp {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a() {
            /*
                r3 = this;
                j0$a r0 = new j0$a
                r0.<init>()
                r1 = 0
                r0.f6984a = r1
                java.lang.String r1 = "PBES2-HS256+A128KW"
                java.lang.String r2 = "HmacSHA256"
                r3.<init>(r1, r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C1393sp.a.<init>():void");
        }
    }

    /* renamed from: sp$b */
    /* compiled from: Pbes2HmacShaWithAesKeyWrapAlgorithm */
    public static class b extends C1393sp {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b() {
            /*
                r3 = this;
                j0$b r0 = new j0$b
                r0.<init>()
                r1 = 0
                r0.f6984a = r1
                java.lang.String r1 = "PBES2-HS384+A192KW"
                java.lang.String r2 = "HmacSHA384"
                r3.<init>(r1, r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C1393sp.b.<init>():void");
        }
    }

    /* renamed from: sp$c */
    /* compiled from: Pbes2HmacShaWithAesKeyWrapAlgorithm */
    public static class c extends C1393sp {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public c() {
            /*
                r3 = this;
                j0$c r0 = new j0$c
                r0.<init>()
                r1 = 0
                r0.f6984a = r1
                java.lang.String r1 = "PBES2-HS512+A256KW"
                java.lang.String r2 = "HmacSHA512"
                r3.<init>(r1, r2, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C1393sp.c.<init>():void");
        }
    }

    public C1393sp(String str, String str2, C1186j0 j0Var) {
        this.f6950a = str;
        this.b = "n/a";
        this.f6957a = new C0739Wo(str2);
        this.f6958a = j0Var;
        this.f6956a = new Qp(j0Var.a, 2, "AES");
    }

    public final void a(Key key, X6 x6) throws C1259mg {
        if (key == null) {
            throw new C1259mg("The key must not be null.");
        }
    }

    public final boolean b() {
        return this.f6958a.b();
    }

    public final ng g(Key key, Qp qp, C0638Pe pe, byte[] bArr, Nq nq) throws C0626Og {
        Long l;
        byte[] bArr2;
        C0638Pe pe2 = pe;
        Object obj = pe2.f3754a.get("p2c");
        if (obj != null) {
            l = Long.valueOf(((Number) obj).longValue());
        } else {
            l = null;
        }
        if (l == null) {
            l = Long.valueOf(this.f6955a);
            pe2.b(l, "p2c");
        }
        if (l.longValue() >= 1000) {
            String a2 = pe2.a("p2s");
            nh nhVar = new nh(3);
            if (a2 == null) {
                nq.getClass();
                bArr2 = C1354qp.k0(this.f6954a);
                pe2.b(nhVar.e(bArr2), "p2s");
            } else {
                bArr2 = nhVar.d(a2);
            }
            if (bArr2.length >= 8) {
                int i = 0;
                int i2 = 2;
                byte[] A = C1354qp.A(r1.v(this.f6950a), a, bArr2);
                Qp qp2 = this.f6956a;
                int i3 = qp2.b;
                nq.a.getClass();
                byte[] encoded = key.getEncoded();
                int intValue = l.intValue();
                C0739Wo wo = this.f6957a;
                wo.getClass();
                Mac x = r1.x(wo.a, new C1167i0(encoded, 1));
                int macLength = x.getMacLength();
                if (((long) i3) <= 4294967295L) {
                    int ceil = (int) Math.ceil(((double) i3) / ((double) macLength));
                    int i4 = ceil - 1;
                    int i5 = i3 - (macLength * i4);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int i6 = 1;
                    int i7 = 0;
                    while (i < ceil) {
                        int i8 = i + 1;
                        int i9 = i6;
                        byte[] bArr3 = null;
                        int i10 = ceil;
                        byte[] bArr4 = null;
                        while (i6 <= intValue) {
                            if (i6 == i9) {
                                byte[][] bArr5 = new byte[i2][];
                                bArr5[i7] = A;
                                bArr5[1] = C1354qp.L(i8);
                                bArr3 = x.doFinal(C1354qp.A(bArr5));
                                bArr4 = bArr3;
                                i9 = 1;
                            } else {
                                byte[] doFinal = x.doFinal(bArr4);
                                while (i7 < doFinal.length) {
                                    bArr3[i7] = (byte) (doFinal[i7] ^ bArr3[i7]);
                                    i7++;
                                }
                                bArr4 = doFinal;
                            }
                            i6++;
                            i2 = 2;
                            i7 = 0;
                        }
                        i7 = 0;
                        if (i == i4) {
                            bArr3 = C1354qp.z0(bArr3, 0, i5);
                        }
                        byteArrayOutputStream.write(bArr3, 0, bArr3.length);
                        i2 = 2;
                        Nq nq2 = nq;
                        i6 = i9;
                        i = i8;
                        ceil = i10;
                        C0638Pe pe3 = pe;
                    }
                    return this.f6958a.g(new SecretKeySpec(byteArrayOutputStream.toByteArray(), (String) qp2.f491a), qp, pe, bArr, nq);
                }
                throw new V5(lf.h("derived key too long ", i3));
            }
            throw new C0626Og("A p2s salt input value containing 8 or more octets MUST be used.");
        }
        throw new C0626Og("iteration count (p2c=" + l + ") cannot be less than 1000 (and should probably be considerably more)");
    }
}
