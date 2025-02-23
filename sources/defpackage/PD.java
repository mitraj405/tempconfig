package defpackage;

import androidx.work.impl.WorkDatabase;
import defpackage.Zt;

/* renamed from: PD  reason: default package */
/* compiled from: WorkDatabase */
public final class PD extends Zt.b {
    public final void a(C0408yd ydVar) {
        ydVar.a();
        try {
            int i = WorkDatabase.a;
            ydVar.c("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + (System.currentTimeMillis() - WorkDatabase.f2652a) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            ydVar.j();
        } finally {
            ydVar.b();
        }
    }
}
