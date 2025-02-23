package defpackage;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: Oq  reason: default package */
/* compiled from: PublicJsonWebKey */
public abstract class Oq extends Yg {
    public PrivateKey a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3741a;
    public final String f;
    public final String g;
    public final String h;
    public final String i;

    /* renamed from: Oq$a */
    /* compiled from: PublicJsonWebKey */
    public static class a {
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static defpackage.Oq a() throws defpackage.C0626Og {
            /*
                java.lang.String r0 = "{\"kty\":\"EC\",\"x\":\"gi0g9DzM2SvjVV7iD_upIU0urmZRjpoIc4Efu8563y8\",\"y\":\"Y5K6GofrdlWNLlfT8-AEyJyVZ3yJJcGgkGroHQCAhmk\",\"crv\":\"secp256k1\",\"d\":\"Vd99BKh6pxt3mXSDJzHuVrCq52xBXAKVahbuFb6dqBc\"}"
                java.util.Map r0 = defpackage.Vg.a(r0)
                java.lang.String r1 = "kty"
                r2 = 1
                java.lang.String r1 = defpackage.Yg.d(r1, r0, r2)
                r1.getClass()
                int r3 = r1.hashCode()
                r4 = 2206(0x89e, float:3.091E-42)
                r5 = 2
                if (r3 == r4) goto L_0x003a
                r4 = 78324(0x131f4, float:1.09755E-40)
                if (r3 == r4) goto L_0x002f
                r4 = 81440(0x13e20, float:1.14122E-40)
                if (r3 == r4) goto L_0x0024
                goto L_0x0042
            L_0x0024:
                java.lang.String r3 = "RSA"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x002d
                goto L_0x0042
            L_0x002d:
                r3 = r5
                goto L_0x0045
            L_0x002f:
                java.lang.String r3 = "OKP"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x0038
                goto L_0x0042
            L_0x0038:
                r3 = r2
                goto L_0x0045
            L_0x003a:
                java.lang.String r3 = "EC"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x0044
            L_0x0042:
                r3 = -1
                goto L_0x0045
            L_0x0044:
                r3 = 0
            L_0x0045:
                if (r3 == 0) goto L_0x0065
                if (r3 == r2) goto L_0x005f
                if (r3 != r5) goto L_0x0051
                ku r1 = new ku
                r1.<init>((java.util.Map) r0)
                goto L_0x006a
            L_0x0051:
                Og r0 = new Og
                java.lang.String r2 = "Unknown key type (for public keys): '"
                java.lang.String r3 = "'"
                java.lang.String r1 = defpackage.lf.j(r2, r1, r3)
                r0.<init>(r1)
                throw r0
            L_0x005f:
                sn r1 = new sn
                r1.<init>((java.util.Map) r0)
                goto L_0x006a
            L_0x0065:
                ga r1 = new ga
                r1.<init>((java.util.Map) r0)
            L_0x006a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.Oq.a.a():Oq");
        }

        public static Oq b(PublicKey publicKey) throws C0626Og {
            Object obj;
            if (RSAPublicKey.class.isInstance(publicKey)) {
                obj = new C1227ku((RSAPublicKey) publicKey);
            } else if (ECPublicKey.class.isInstance(publicKey)) {
                obj = new C1131ga((ECPublicKey) publicKey);
            } else if (PublicKey.class.isInstance(publicKey)) {
                if (C1391sn.a.contains(publicKey.getAlgorithm())) {
                    obj = new C1391sn(publicKey);
                } else {
                    throw new C0626Og("Unsupported or unknown public key (alg=" + publicKey.getAlgorithm() + ") " + publicKey);
                }
            } else if (!PrivateKey.class.isInstance(publicKey)) {
                obj = new C1428un(publicKey);
            } else {
                throw new C0626Og("A JsonWebKey instance needs to be created from a public or symmetric key.");
            }
            return (Oq) obj;
        }
    }

    public Oq(PublicKey publicKey) {
        super((Key) publicKey);
    }

    public static BigInteger k(String str, Map map, boolean z) throws C0626Og {
        return r1.s(new nh(3).d(Yg.d(str, map, z)));
    }

    public static void l(LinkedHashMap linkedHashMap, String str, BigInteger bigInteger) {
        linkedHashMap.put(str, new nh(3).e(r1.S(bigInteger)));
    }

    public static void m(LinkedHashMap linkedHashMap, String str, BigInteger bigInteger, int i2) {
        nh nhVar = new nh(3);
        byte[] S = r1.S(bigInteger);
        if (i2 > S.length) {
            S = C1354qp.A(new byte[(i2 - S.length)], S);
        }
        linkedHashMap.put(str, nhVar.e(S));
    }

    public final void a(LinkedHashMap linkedHashMap) {
        j(linkedHashMap);
        ArrayList arrayList = this.f3741a;
        if (arrayList != null) {
            new C1457wE();
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    arrayList2.add(new C1295o2(C1295o2.c, 0, false).d(((X509Certificate) it.next()).getEncoded()));
                } catch (CertificateEncodingException e) {
                    throw new IllegalStateException("Unexpected problem getting encoded certificate.", e);
                }
            }
            linkedHashMap.put("x5c", arrayList2);
        }
        Yg.e("x5t", this.g, linkedHashMap);
        Yg.e("x5t#S256", this.h, linkedHashMap);
        Yg.e("x5u", this.i, linkedHashMap);
    }

    public final void i() {
        X509Certificate x509Certificate;
        ArrayList arrayList = this.f3741a;
        boolean z = false;
        if (arrayList == null || arrayList.isEmpty()) {
            x509Certificate = null;
        } else {
            x509Certificate = (X509Certificate) arrayList.get(0);
        }
        if (x509Certificate != null && !x509Certificate.getPublicKey().equals((PublicKey) this.a)) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("The key in the first certificate MUST match the bare public key represented by other members of the JWK. Public key = " + ((PublicKey) this.a) + " cert = " + x509Certificate);
        }
    }

    public abstract void j(LinkedHashMap linkedHashMap);

    public Oq(Map map) throws C0626Og {
        super((Map<String, Object>) map);
        this.f = null;
        if (map.containsKey("x5c")) {
            List<String> list = (List) map.get("x5c");
            this.f3741a = new ArrayList(list.size());
            C1457wE wEVar = new C1457wE();
            for (String str : list) {
                try {
                    this.f3741a.add((X509Certificate) wEVar.a.generateCertificate(new ByteArrayInputStream(new C1295o2(C1295o2.c, 0, false).b(str))));
                } catch (CertificateException e) {
                    throw new C0626Og("Unable to convert " + str + " value to X509Certificate: " + e, e);
                }
            }
        }
        this.g = Yg.c("x5t", map);
        this.h = Yg.c("x5t#S256", map);
        this.i = Yg.c("x5u", map);
        f("x5c", "x5t#S256", "x5t", "x5u");
    }
}
