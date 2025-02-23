package defpackage;

/* renamed from: le  reason: default package and case insensitive filesystem */
/* compiled from: GenrateECKey */
public final class C1239le {
    public static C1239le a;

    /* renamed from: a  reason: collision with other field name */
    public final String f5585a = null;
    public final String b = C0535I5.f3620a;

    static {
        C1354qp.R(C1239le.class);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C1239le(rx.Subscriber r7) {
        /*
            r6 = this;
            r6.<init>()
            r0 = 0
            r6.f5585a = r0
            java.lang.String r1 = defpackage.C0535I5.f3620a
            r6.b = r1
            le r1 = a
            if (r1 == 0) goto L_0x0010
            a = r0
        L_0x0010:
            r0 r1 = defpackage.C1359r0.f6934a
            q0<X6> r1 = r1.c
            java.util.LinkedHashMap r1 = r1.f6894a
            java.lang.String r2 = "A128GCM"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            java.lang.String r2 = "A128CBC-HS256"
        L_0x0021:
            r6.f5585a = r2
            b1 r1 = defpackage.C0793b1.a
            kn r1 = r1.f3912a
            if (r1 == 0) goto L_0x009f
            kw r2 = defpackage.C1228kw.a()     // Catch:{ Exception -> 0x0040 }
            java.security.spec.ECParameterSpec r3 = defpackage.C1153ha.a     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = "SC"
            java.security.SecureRandom r5 = new java.security.SecureRandom     // Catch:{ Exception -> 0x0040 }
            r5.<init>()     // Catch:{ Exception -> 0x0040 }
            ga r3 = defpackage.C0733W9.a(r3, r4, r5)     // Catch:{ Exception -> 0x0040 }
            java.lang.String r4 = "deviceyek"
            r3.d = r4     // Catch:{ Exception -> 0x0040 }
            r2.f5570a = r3     // Catch:{ Exception -> 0x0040 }
        L_0x0040:
            boolean r2 = defpackage.C0535I5.f3625a
            r3 = 2
            if (r2 == 0) goto L_0x0047
            r2 = r3
            goto L_0x0048
        L_0x0047:
            r2 = 1
        L_0x0048:
            kw r4 = defpackage.C1228kw.a()     // Catch:{ Exception -> 0x0057 }
            ga r5 = r4.f5570a     // Catch:{ Exception -> 0x0058 }
            java.security.Key r5 = r5.a     // Catch:{ Exception -> 0x0058 }
            java.security.PublicKey r5 = (java.security.PublicKey) r5     // Catch:{ Exception -> 0x0058 }
            byte[] r0 = r5.getEncoded()     // Catch:{ Exception -> 0x0058 }
            goto L_0x0064
        L_0x0057:
            r4 = r0
        L_0x0058:
            if (r4 != 0) goto L_0x005b
            goto L_0x0064
        L_0x005b:
            ga r4 = r4.f5570a
            if (r4 != 0) goto L_0x0060
            goto L_0x0064
        L_0x0060:
            java.security.Key r4 = r4.a
            java.security.PublicKey r4 = (java.security.PublicKey) r4
        L_0x0064:
            if (r0 != 0) goto L_0x0069
            java.lang.String r0 = ""
            goto L_0x006d
        L_0x0069:
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r3)
        L_0x006d:
            java.lang.Object r1 = defpackage.C0657Qt.c(r1)
            Om r1 = (defpackage.Om) r1
            java.lang.String r3 = defpackage.C0657Qt.f()
            java.lang.String r4 = "agreeOnKey"
            java.lang.String r3 = defpackage.C1058d.z(r3, r4)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r4 = r6.b
            rx.Observable r0 = r1.m0(r3, r0, r2, r4)
            Lm r1 = defpackage.C1181iv.a()
            rx.Observable r0 = r0.c(r1)
            Yi r1 = defpackage.E0.a()
            rx.Observable r0 = r0.a(r1)
            ke r1 = new ke
            r1.<init>(r6, r7)
            r0.b(r1)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1239le.<init>(rx.Subscriber):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00bb, code lost:
        if (r3.equals(r6) != false) goto L_0x00bd;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ef A[Catch:{ IOException -> 0x0120, Exception -> 0x0127 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f2 A[ADDED_TO_REGION, Catch:{ IOException -> 0x0120, Exception -> 0x0127 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r9 = this;
            java.lang.String r0 = "alg"
            java.lang.String r1 = "kid"
            kw r2 = defpackage.C1228kw.a()     // Catch:{ Exception -> 0x0127 }
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0127 }
            r3.<init>()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r4 = cris.org.in.ima.IrctcImaApplication.c     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = "iss"
            r3.put(r5, r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = "MAPPS"
            java.lang.String r6 = "aud"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x0127 }
            r5 = 1101004800(0x41a00000, float:20.0)
            jn r5 = defpackage.C1157hh.a(r5)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r6 = "exp"
            long r7 = r5.a     // Catch:{ Exception -> 0x0127 }
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0127 }
            r3.put(r6, r5)     // Catch:{ Exception -> 0x0127 }
            r5 = 16
            byte[] r5 = defpackage.C1354qp.k0(r5)     // Catch:{ Exception -> 0x0127 }
            nh r6 = new nh     // Catch:{ Exception -> 0x0127 }
            r7 = 3
            r6.<init>((int) r7)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = r6.e(r5)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r6 = "jti"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x0127 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0127 }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            java.lang.String r7 = "iat"
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ Exception -> 0x0127 }
            r3.put(r7, r5)     // Catch:{ Exception -> 0x0127 }
            r5 = -1054867456(0xffffffffc1200000, float:-10.0)
            jn r5 = defpackage.C1157hh.a(r5)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r6 = "nbf"
            long r7 = r5.a     // Catch:{ Exception -> 0x0127 }
            java.lang.Long r5 = java.lang.Long.valueOf(r7)     // Catch:{ Exception -> 0x0127 }
            r3.put(r6, r5)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = "オケクキカ#"
            java.lang.String r6 = "sub"
            r3.put(r6, r5)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = r2.f5571a     // Catch:{ Exception -> 0x0127 }
            cris.org.in.ima.NativeClass r6 = new cris.org.in.ima.NativeClass     // Catch:{ Exception -> 0x0127 }
            r6.<init>()     // Catch:{ Exception -> 0x0127 }
            java.lang.String r7 = r6.getClaim1()     // Catch:{ Exception -> 0x0127 }
            r3.put(r7, r5)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = r6.getClaim2()     // Catch:{ Exception -> 0x0127 }
            r3.put(r5, r4)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r5 = r6.getClaim3()     // Catch:{ Exception -> 0x0127 }
            int r4 = r4.length()     // Catch:{ Exception -> 0x0127 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x0127 }
            r3.put(r5, r4)     // Catch:{ Exception -> 0x0127 }
            Zg r4 = new Zg     // Catch:{ Exception -> 0x0127 }
            r4.<init>()     // Catch:{ Exception -> 0x0127 }
            Pe r5 = r4.f3914a     // Catch:{ Exception -> 0x0127 }
            java.io.StringWriter r6 = new java.io.StringWriter     // Catch:{ Exception -> 0x0127 }
            r6.<init>()     // Catch:{ Exception -> 0x0127 }
            defpackage.C1354qp.O0(r3, r6)     // Catch:{ IOException -> 0x0120 }
            java.lang.String r3 = r6.toString()     // Catch:{ IOException -> 0x0120 }
            java.lang.String r6 = r4.a     // Catch:{ Exception -> 0x0127 }
            byte[] r3 = defpackage.r1.u(r3, r6)     // Catch:{ Exception -> 0x0127 }
            r4.b = r3     // Catch:{ Exception -> 0x0127 }
            ga r3 = r2.f5570a     // Catch:{ Exception -> 0x0127 }
            java.security.PrivateKey r3 = r3.a     // Catch:{ Exception -> 0x0127 }
            java.security.Key r6 = r4.f3915a     // Catch:{ Exception -> 0x0127 }
            r7 = 1
            r8 = 0
            if (r3 != 0) goto L_0x00b5
            if (r6 != 0) goto L_0x00bf
            goto L_0x00bd
        L_0x00b5:
            if (r6 == 0) goto L_0x00bf
            boolean r6 = r3.equals(r6)     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x00bf
        L_0x00bd:
            r6 = r7
            goto L_0x00c0
        L_0x00bf:
            r6 = r8
        L_0x00c0:
            r4.f3915a = r3     // Catch:{ Exception -> 0x0127 }
            ga r3 = r2.f5570a     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = r3.d     // Catch:{ Exception -> 0x0127 }
            r5.b(r3, r1)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = "ES384"
            r5.b(r3, r0)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r3 = r4.c()     // Catch:{ Exception -> 0x0127 }
            Xg r4 = new Xg     // Catch:{ Exception -> 0x0127 }
            r4.<init>()     // Catch:{ Exception -> 0x0127 }
            Pe r5 = r4.f3914a     // Catch:{ Exception -> 0x0127 }
            java.lang.String r6 = "ECDH-ES+A128KW"
            r5.b(r6, r0)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = r9.f5585a     // Catch:{ Exception -> 0x0127 }
            java.lang.String r6 = "enc"
            r5.b(r0, r6)     // Catch:{ Exception -> 0x0127 }
            ga r0 = r2.b     // Catch:{ Exception -> 0x0127 }
            java.security.Key r0 = r0.a     // Catch:{ Exception -> 0x0127 }
            java.security.PublicKey r0 = (java.security.PublicKey) r0     // Catch:{ Exception -> 0x0127 }
            java.security.Key r6 = r4.f3915a     // Catch:{ Exception -> 0x0127 }
            if (r0 != 0) goto L_0x00f2
            if (r6 != 0) goto L_0x00fb
            goto L_0x00fc
        L_0x00f2:
            if (r6 == 0) goto L_0x00fb
            boolean r6 = r0.equals(r6)     // Catch:{ Exception -> 0x0127 }
            if (r6 == 0) goto L_0x00fb
            goto L_0x00fc
        L_0x00fb:
            r7 = r8
        L_0x00fc:
            r4.f3915a = r0     // Catch:{ Exception -> 0x0127 }
            ga r0 = r2.b     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = r0.d     // Catch:{ Exception -> 0x0127 }
            r5.b(r0, r1)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = "JWT"
            java.lang.String r1 = "cty"
            r5.b(r0, r1)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = r4.a     // Catch:{ Exception -> 0x0127 }
            byte[] r0 = defpackage.r1.u(r3, r0)     // Catch:{ Exception -> 0x0127 }
            r4.f3835b = r0     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = "zip"
            java.lang.String r1 = "DEF"
            r5.b(r1, r0)     // Catch:{ Exception -> 0x0127 }
            java.lang.String r0 = r4.b()     // Catch:{ Exception -> 0x0127 }
            goto L_0x0128
        L_0x0120:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0127 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0127 }
            throw r1     // Catch:{ Exception -> 0x0127 }
        L_0x0127:
            r0 = 0
        L_0x0128:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1239le.a():java.lang.String");
    }
}
