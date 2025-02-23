package defpackage;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: eE  reason: default package and case insensitive filesystem */
/* compiled from: WorkProgressUpdater */
public final class C0178eE implements Dq {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final WorkDatabase f2881a;

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f2882a;

    static {
        zi.e("WorkProgressUpdater");
    }

    public C0178eE(WorkDatabase workDatabase, TaskExecutor taskExecutor) {
        this.f2881a = workDatabase;
        this.f2882a = taskExecutor;
    }
}
