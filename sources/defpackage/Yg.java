package defpackage;

import java.io.Serializable;
import java.security.Key;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: Yg  reason: default package */
/* compiled from: JsonWebKey */
public abstract class Yg implements Serializable {
    public Key a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashMap f3862a;

    /* renamed from: a  reason: collision with other field name */
    public final List<String> f3863a;
    public String c;
    public String d;
    public String e;

    /* renamed from: Yg$a */
    /* compiled from: JsonWebKey */
    public static class a {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static defpackage.Yg a() throws defpackage.C0626Og {
            /*
                java.lang.String r0 = "{\"kty\":\"RSA\",\"n\":\"sXchDaQebHnPiGvyDOAT4saGEUetSyo9MKLOoWFsueri23bOdgWp4Dy1WlUzewbgBHod5pcM9H95GQRV3JDXboIRROSBigeC5yjU1hGzHHyXss8UDprecbAYxknTcQkhslANGRUZmdTOQ5qTRsLAt6BTYuyvVRdhS8exSZEy_c4gs_7svlJJQ4H9_NxsiIoLwAEk7-Q3UXERGYw_75IDrGA84-lA_-Ct4eTlXHBIY2EaV7t7LjJaynVJCpkv4LKjTTAumiGUIuQhrNhZLuF_RJLqHpM2kgWFLU7-VTdL1VbC2tejvcI2BlMkEpk1BzBZI0KQB0GaDWFLN-aEAw3vRw\",\"e\":\"AQAB\"}"
                java.util.Map r0 = defpackage.Vg.a(r0)
                java.lang.String r1 = "kty"
                r2 = 1
                java.lang.String r1 = defpackage.Yg.d(r1, r0, r2)
                r1.getClass()
                int r3 = r1.hashCode()
                r4 = 2206(0x89e, float:3.091E-42)
                r5 = 3
                r6 = 2
                if (r3 == r4) goto L_0x004b
                r4 = 78324(0x131f4, float:1.09755E-40)
                if (r3 == r4) goto L_0x0040
                r4 = 81440(0x13e20, float:1.14122E-40)
                if (r3 == r4) goto L_0x0035
                r4 = 109856(0x1ad20, float:1.53941E-40)
                if (r3 == r4) goto L_0x002a
                goto L_0x0053
            L_0x002a:
                java.lang.String r3 = "oct"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x0033
                goto L_0x0053
            L_0x0033:
                r3 = r5
                goto L_0x0056
            L_0x0035:
                java.lang.String r3 = "RSA"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x003e
                goto L_0x0053
            L_0x003e:
                r3 = r6
                goto L_0x0056
            L_0x0040:
                java.lang.String r3 = "OKP"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x0049
                goto L_0x0053
            L_0x0049:
                r3 = r2
                goto L_0x0056
            L_0x004b:
                java.lang.String r3 = "EC"
                boolean r3 = r1.equals(r3)
                if (r3 != 0) goto L_0x0055
            L_0x0053:
                r3 = -1
                goto L_0x0056
            L_0x0055:
                r3 = 0
            L_0x0056:
                if (r3 == 0) goto L_0x007e
                if (r3 == r2) goto L_0x0078
                if (r3 == r6) goto L_0x0072
                if (r3 != r5) goto L_0x0064
                un r1 = new un
                r1.<init>((java.util.Map<java.lang.String, java.lang.Object>) r0)
                goto L_0x0083
            L_0x0064:
                Og r0 = new Og
                java.lang.String r2 = "Unknown key type algorithm: '"
                java.lang.String r3 = "'"
                java.lang.String r1 = defpackage.lf.j(r2, r1, r3)
                r0.<init>(r1)
                throw r0
            L_0x0072:
                ku r1 = new ku
                r1.<init>((java.util.Map) r0)
                goto L_0x0083
            L_0x0078:
                sn r1 = new sn
                r1.<init>((java.util.Map) r0)
                goto L_0x0083
            L_0x007e:
                ga r1 = new ga
                r1.<init>((java.util.Map) r0)
            L_0x0083:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.Yg.a.a():Yg");
        }
    }

    /* renamed from: Yg$b */
    /* compiled from: JsonWebKey */
    public enum b {
        INCLUDE_SYMMETRIC,
        PUBLIC_ONLY
    }

    public Yg(Key key) {
        this.f3862a = new LinkedHashMap();
        this.a = key;
    }

    public static String c(String str, Map map) throws C0626Og {
        String str2;
        Object obj = map.get(str);
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            StringBuilder K = xx.K("'", str, "' parameter was ");
            if (obj instanceof Number) {
                str2 = "Number";
            } else if (obj instanceof Boolean) {
                str2 = "Boolean";
            } else if (obj instanceof List) {
                str2 = "Array";
            } else if (obj instanceof Map) {
                str2 = "Object";
            } else if (obj instanceof String) {
                str2 = "String";
            } else {
                str2 = "unknown";
            }
            throw new C0626Og(C0709Uj.j(K, str2, " type but is required to be a String."));
        }
    }

    public static String d(String str, Map map, boolean z) throws C0626Og {
        String c2 = c(str, map);
        if (c2 != null || !z) {
            return c2;
        }
        throw new C0626Og(lf.j("Missing required '", str, "' parameter."));
    }

    public static void e(String str, Object obj, LinkedHashMap linkedHashMap) {
        if (obj != null) {
            linkedHashMap.put(str, obj);
        }
    }

    public abstract void a(LinkedHashMap linkedHashMap);

    public abstract String b();

    public final void f(String... strArr) {
        for (String remove : strArr) {
            this.f3862a.remove(remove);
        }
    }

    public final LinkedHashMap g() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("kty", b());
        e("kid", this.d, linkedHashMap);
        e("use", this.c, linkedHashMap);
        e("key_ops", this.f3863a, linkedHashMap);
        e("alg", this.e, linkedHashMap);
        a(linkedHashMap);
        linkedHashMap.putAll(this.f3862a);
        return linkedHashMap;
    }

    public final String toString() {
        return getClass().getName() + g();
    }

    public Yg(Map<String, Object> map) throws C0626Og {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f3862a = linkedHashMap;
        linkedHashMap.putAll(map);
        f("kty", "use", "kid", "alg", "key_ops");
        this.c = c("use", map);
        this.d = c("kid", map);
        this.e = c("alg", map);
        if (map.containsKey("key_ops")) {
            this.f3863a = (List) map.get("key_ops");
        }
    }
}
