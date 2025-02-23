package defpackage;

import defpackage.C0723Ve;
import defpackage.C0764Z9;
import defpackage.C0779aa;
import defpackage.C1080e0;
import defpackage.C1123g0;
import defpackage.C1144h0;
import defpackage.C1186j0;
import defpackage.C1247lu;
import defpackage.C1290nu;
import defpackage.C1393sp;
import java.security.Security;
import java.util.Arrays;

/* renamed from: r0  reason: default package and case insensitive filesystem */
/* compiled from: AlgorithmFactoryFactory */
public final class C1359r0 {
    public static final Bi a = C0473Ci.d(C1359r0.class);

    /* renamed from: a  reason: collision with other field name */
    public static final C1359r0 f6934a = new C1359r0();

    /* renamed from: a  reason: collision with other field name */
    public C1339q0<C0783ah> f6935a;
    public C1339q0<C1387sh> b;
    public C1339q0<X6> c;
    public C1339q0<C1298o6> d;

    public C1359r0() {
        Object[] objArr = {System.getProperty("java.version"), System.getProperty("java.vendor"), System.getProperty("java.home"), Arrays.toString(Security.getProviders())};
        Bi bi = a;
        bi.c("Initializing jose4j (running with Java {} from {} at {} with {} security providers installed)...", objArr);
        long currentTimeMillis = System.currentTimeMillis();
        C1339q0<C0783ah> q0Var = new C1339q0<>(C0783ah.class, "alg");
        this.f6935a = q0Var;
        q0Var.c(new C1323pB());
        this.f6935a.c(new C0723Ve.a());
        this.f6935a.c(new C0723Ve.b());
        this.f6935a.c(new C0723Ve.c());
        this.f6935a.c(new C0798ba());
        this.f6935a.c(new C0779aa.a());
        this.f6935a.c(new C0779aa.b());
        this.f6935a.c(new C0779aa.c());
        this.f6935a.c(new C0779aa.d());
        this.f6935a.c(new C1290nu.d());
        this.f6935a.c(new C1290nu.e());
        this.f6935a.c(new C1290nu.f());
        this.f6935a.c(new C1290nu.a());
        this.f6935a.c(new C1290nu.b());
        this.f6935a.c(new C1290nu.c());
        bi.e(this.f6935a.b(), "JWS signature algorithms: {}");
        C1339q0<C1387sh> q0Var2 = new C1339q0<>(C1387sh.class, "alg");
        this.b = q0Var2;
        q0Var2.c(new C1247lu.a());
        this.b.c(new C1247lu.c());
        this.b.c(new C1247lu.b());
        this.b.c(new C1150h9());
        this.b.c(new C1186j0.a());
        this.b.c(new C1186j0.b());
        this.b.c(new C1186j0.c());
        this.b.c(new C0754Y9());
        this.b.c(new C0764Z9.a());
        this.b.c(new C0764Z9.b());
        this.b.c(new C0764Z9.c());
        this.b.c(new C1393sp.a());
        this.b.c(new C1393sp.b());
        this.b.c(new C1393sp.c());
        this.b.c(new C1144h0.a());
        this.b.c(new C1144h0.b());
        this.b.c(new C1144h0.c());
        bi.e(this.b.b(), "JWE key management algorithms: {}");
        C1339q0<X6> q0Var3 = new C1339q0<>(X6.class, "enc");
        this.c = q0Var3;
        q0Var3.c(new C1080e0.a());
        this.c.c(new C1080e0.b());
        this.c.c(new C1080e0.c());
        this.c.c(new C1123g0.a());
        this.c.c(new C1123g0.b());
        this.c.c(new C1123g0.c());
        bi.e(this.c.b(), "JWE content encryption algorithms: {}");
        C1339q0<C1298o6> q0Var4 = new C1339q0<>(C1298o6.class, "zip");
        this.d = q0Var4;
        q0Var4.c(new C0469C8());
        bi.e(this.d.b(), "JWE compression algorithms: {}");
        bi.e(Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "Initialized jose4j in {}ms");
    }
}
