package defpackage;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: ym  reason: default package and case insensitive filesystem */
/* compiled from: NetworkConnectedController */
public final class C0411ym extends P6<Cm> {
    public C0411ym(Context context, TaskExecutor taskExecutor) {
        super((Dm) C0360vA.a(context, taskExecutor).c);
    }

    public final boolean b(C0214hE hEVar) {
        if (hEVar.f2988a.f539a == Em.CONNECTED) {
            return true;
        }
        return false;
    }

    public final boolean c(Object obj) {
        Cm cm = (Cm) obj;
        if (!cm.a || !cm.b) {
            return true;
        }
        return false;
    }
}
