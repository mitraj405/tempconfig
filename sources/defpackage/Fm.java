package defpackage;

import android.content.Context;
import android.os.Build;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: Fm  reason: default package */
/* compiled from: NetworkUnmeteredController */
public final class Fm extends P6<Cm> {
    public Fm(Context context, TaskExecutor taskExecutor) {
        super((Dm) C0360vA.a(context, taskExecutor).c);
    }

    public final boolean b(C0214hE hEVar) {
        Em em = hEVar.f2988a.f539a;
        if (em == Em.UNMETERED || (Build.VERSION.SDK_INT >= 30 && em == Em.TEMPORARILY_UNMETERED)) {
            return true;
        }
        return false;
    }

    public final boolean c(Object obj) {
        Cm cm = (Cm) obj;
        if (!cm.a || cm.c) {
            return true;
        }
        return false;
    }
}
