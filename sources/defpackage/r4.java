package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;

/* renamed from: r4  reason: default package */
/* compiled from: CancelWorkRunnable */
public final class r4 extends t4 {
    public final /* synthetic */ VD a;
    public final /* synthetic */ String c = "offline_ping_sender_work";

    public r4(VD vd) {
        this.a = vd;
    }

    /* JADX INFO: finally extract failed */
    public final void b() {
        VD vd = this.a;
        WorkDatabase workDatabase = vd.f594a;
        workDatabase.c();
        try {
            Iterator it = ((C0236jE) workDatabase.n()).h(this.c).iterator();
            while (it.hasNext()) {
                t4.a(vd, (String) it.next());
            }
            workDatabase.h();
            workDatabase.f();
            jv.a(vd.f593a, vd.f594a, vd.f597a);
        } catch (Throwable th) {
            workDatabase.f();
            throw th;
        }
    }
}
