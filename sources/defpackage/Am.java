package defpackage;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: Am  reason: default package */
/* compiled from: NetworkMeteredController */
public final class Am extends P6<Cm> {
    static {
        zi.e("NetworkMeteredCtrlr");
    }

    public Am(Context context, TaskExecutor taskExecutor) {
        super((Dm) C0360vA.a(context, taskExecutor).c);
    }

    public final boolean b(C0214hE hEVar) {
        if (hEVar.f2988a.f539a == Em.METERED) {
            return true;
        }
        return false;
    }

    public final boolean c(Object obj) {
        Cm cm = (Cm) obj;
        if (!cm.a || !cm.c) {
            return true;
        }
        return false;
    }
}
