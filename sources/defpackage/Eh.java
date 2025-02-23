package defpackage;

import defpackage.Tg;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: Eh  reason: default package */
/* compiled from: KeyframesParser */
public final class Eh {
    public static final Tg.a a = Tg.a.a("k");

    public static ArrayList a(Tg tg, C0181ej ejVar, float f, XB xb, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (tg.r() == 6) {
            ejVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        tg.b();
        while (tg.j()) {
            if (tg.t(a) != 0) {
                tg.v();
            } else if (tg.r() == 1) {
                tg.a();
                if (tg.r() == 7) {
                    arrayList.add(Dh.b(tg, ejVar, f, xb, false, z));
                } else {
                    while (tg.j()) {
                        arrayList.add(Dh.b(tg, ejVar, f, xb, true, z));
                    }
                }
                tg.c();
            } else {
                arrayList.add(Dh.b(tg, ejVar, f, xb, false, z));
            }
        }
        tg.e();
        b(arrayList);
        return arrayList;
    }

    public static void b(ArrayList arrayList) {
        int i;
        T t;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            Bh bh = (Bh) arrayList.get(i2);
            i2++;
            Bh bh2 = (Bh) arrayList.get(i2);
            bh.f64a = Float.valueOf(bh2.a);
            if (bh.f69b == null && (t = bh2.f65a) != null) {
                bh.f69b = t;
                if (bh instanceof fp) {
                    ((fp) bh).d();
                }
            }
        }
        Bh bh3 = (Bh) arrayList.get(i);
        if ((bh3.f65a == null || bh3.f69b == null) && arrayList.size() > 1) {
            arrayList.remove(bh3);
        }
    }
}
