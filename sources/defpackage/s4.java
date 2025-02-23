package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;

/* renamed from: s4  reason: default package */
/* compiled from: CancelWorkRunnable */
public final class s4 extends t4 {
    public final /* synthetic */ VD a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3246a = false;
    public final /* synthetic */ String c;

    public s4(VD vd, String str) {
        this.a = vd;
        this.c = str;
    }

    /* JADX INFO: finally extract failed */
    public final void b() {
        VD vd = this.a;
        WorkDatabase workDatabase = vd.f594a;
        workDatabase.c();
        try {
            Iterator it = ((C0236jE) workDatabase.n()).g(this.c).iterator();
            while (it.hasNext()) {
                t4.a(vd, (String) it.next());
            }
            workDatabase.h();
            workDatabase.f();
            if (this.f3246a) {
                jv.a(vd.f593a, vd.f594a, vd.f597a);
            }
        } catch (Throwable th) {
            workDatabase.f();
            throw th;
        }
    }
}
