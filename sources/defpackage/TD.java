package defpackage;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: TD  reason: default package */
/* compiled from: WorkForegroundUpdater */
public final class TD implements C0227id {
    public final TaskExecutor a;

    /* renamed from: a  reason: collision with other field name */
    public final C0216hd f549a;

    /* renamed from: a  reason: collision with other field name */
    public final C0224iE f550a;

    static {
        zi.e("WMFgUpdater");
    }

    public TD(WorkDatabase workDatabase, C0216hd hdVar, TaskExecutor taskExecutor) {
        this.f549a = hdVar;
        this.a = taskExecutor;
        this.f550a = workDatabase.n();
    }
}
