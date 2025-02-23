package defpackage;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* renamed from: q4  reason: default package */
/* compiled from: CancelWorkRunnable */
public final class q4 extends t4 {
    public final /* synthetic */ VD a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ UUID f3177a;

    public q4(VD vd, UUID uuid) {
        this.a = vd;
        this.f3177a = uuid;
    }

    /* JADX INFO: finally extract failed */
    public final void b() {
        VD vd = this.a;
        WorkDatabase workDatabase = vd.f594a;
        workDatabase.c();
        try {
            t4.a(vd, this.f3177a.toString());
            workDatabase.h();
            workDatabase.f();
            jv.a(vd.f593a, vd.f594a, vd.f597a);
        } catch (Throwable th) {
            workDatabase.f();
            throw th;
        }
    }
}
