package defpackage;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: Bm  reason: default package */
/* compiled from: NetworkNotRoamingController */
public final class Bm extends P6<Cm> {
    static {
        zi.e("NetworkNotRoamingCtrlr");
    }

    public Bm(Context context, TaskExecutor taskExecutor) {
        super((Dm) C0360vA.a(context, taskExecutor).c);
    }

    public final boolean b(C0214hE hEVar) {
        if (hEVar.f2988a.f539a == Em.NOT_ROAMING) {
            return true;
        }
        return false;
    }

    public final boolean c(Object obj) {
        Cm cm = (Cm) obj;
        if (!cm.a || !cm.d) {
            return true;
        }
        return false;
    }
}
