package defpackage;

import defpackage.Tg;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: K0  reason: default package */
/* compiled from: AnimatablePathValueParser */
public final class K0 {
    public static final Tg.a a = Tg.a.a("k", "x", "y");

    public static nh a(Ug ug, C0181ej ejVar) throws IOException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        if (ug.r() == 1) {
            ug.a();
            while (ug.j()) {
                if (ug.r() == 3) {
                    z = true;
                } else {
                    z = false;
                }
                arrayList.add(new fp(ejVar, Dh.b(ug, ejVar, UB.c(), C0230ip.a, z, false)));
            }
            ug.c();
            Eh.b(arrayList);
        } else {
            arrayList.add(new Bh(Wg.b(ug, UB.c())));
        }
        return new nh((Object) arrayList);
    }

    public static R0 b(Ug ug, C0181ej ejVar) throws IOException {
        ug.b();
        nh nhVar = null;
        H0 h0 = null;
        boolean z = false;
        H0 h02 = null;
        while (ug.r() != 4) {
            int t = ug.t(a);
            if (t != 0) {
                if (t != 1) {
                    if (t != 2) {
                        ug.u();
                        ug.v();
                    } else if (ug.r() == 6) {
                        ug.v();
                    } else {
                        h0 = C1354qp.f0(ug, ejVar, true);
                    }
                } else if (ug.r() == 6) {
                    ug.v();
                } else {
                    h02 = C1354qp.f0(ug, ejVar, true);
                }
                z = true;
            } else {
                nhVar = a(ug, ejVar);
            }
        }
        ug.e();
        if (z) {
            ejVar.a("Lottie doesn't support expressions.");
        }
        if (nhVar != null) {
            return nhVar;
        }
        return new L0(h02, h0);
    }
}
