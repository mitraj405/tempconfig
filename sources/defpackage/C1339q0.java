package defpackage;

import defpackage.C1271n0;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

/* renamed from: q0  reason: default package and case insensitive filesystem */
/* compiled from: AlgorithmFactory */
public final class C1339q0<A extends C1271n0> {
    public final Bi a;

    /* renamed from: a  reason: collision with other field name */
    public final String f6893a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashMap f6894a = new LinkedHashMap();

    public C1339q0(Class cls, String str) {
        this.f6893a = str;
        this.a = C0473Ci.e(C1339q0.class.getName() + "->" + cls.getSimpleName());
    }

    public final A a(String str) throws C1240lg {
        A a2 = (C1271n0) this.f6894a.get(str);
        if (a2 != null) {
            return a2;
        }
        StringBuilder n = lf.n(str, " is an unknown, unsupported or unavailable ");
        n.append(this.f6893a);
        n.append(" algorithm (not one of ");
        n.append(b());
        n.append(").");
        throw new C1240lg(n.toString());
    }

    public final Set<String> b() {
        return Collections.unmodifiableSet(this.f6894a.keySet());
    }

    public final void c(A a2) {
        boolean z;
        Bi bi = this.a;
        String e = a2.e();
        try {
            z = a2.b();
        } catch (Throwable th) {
            bi.b("Unexpected problem checking for availability of " + a2.e() + " algorithm: " + C1354qp.J0(th));
            z = false;
        }
        String str = this.f6893a;
        if (z) {
            this.f6894a.put(e, a2);
            bi.c("{} registered for {} algorithm {}", a2, str, e);
            return;
        }
        bi.a(e, "{} is unavailable so will not be registered for {} algorithms.", str);
    }
}
