package defpackage;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: G2  reason: default package */
/* compiled from: BatteryNotLowController */
public final class G2 extends P6<Boolean> {
    public G2(Context context, TaskExecutor taskExecutor) {
        super((H2) C0360vA.a(context, taskExecutor).b);
    }

    public final boolean b(C0214hE hEVar) {
        return hEVar.f2988a.c;
    }

    public final boolean c(Object obj) {
        return !((Boolean) obj).booleanValue();
    }
}
