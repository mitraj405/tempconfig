package defpackage;

import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: jv  reason: default package */
/* compiled from: Schedulers */
public final class jv {
    public static final /* synthetic */ int a = 0;

    static {
        zi.e("Schedulers");
    }

    /* JADX INFO: finally extract failed */
    public static void a(a aVar, WorkDatabase workDatabase, List<fv> list) {
        if (list != null && list.size() != 0) {
            C0224iE n = workDatabase.n();
            workDatabase.c();
            try {
                C0236jE jEVar = (C0236jE) n;
                ArrayList c = jEVar.c(aVar.c);
                ArrayList b = jEVar.b();
                if (c.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = c.iterator();
                    while (it.hasNext()) {
                        jEVar.k(((C0214hE) it.next()).f2991a, currentTimeMillis);
                    }
                }
                workDatabase.h();
                workDatabase.f();
                if (c.size() > 0) {
                    C0214hE[] hEVarArr = (C0214hE[]) c.toArray(new C0214hE[c.size()]);
                    for (fv next : list) {
                        if (next.b()) {
                            next.d(hEVarArr);
                        }
                    }
                }
                if (b.size() > 0) {
                    C0214hE[] hEVarArr2 = (C0214hE[]) b.toArray(new C0214hE[b.size()]);
                    for (fv next2 : list) {
                        if (!next2.b()) {
                            next2.d(hEVarArr2);
                        }
                    }
                }
            } catch (Throwable th) {
                workDatabase.f();
                throw th;
            }
        }
    }
}
