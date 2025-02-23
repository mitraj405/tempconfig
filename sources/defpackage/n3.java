package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* renamed from: n3  reason: default package */
/* compiled from: BroadcastReceiverConstraintTracker */
public abstract class n3<T> extends R6<T> {
    public final a a = new a();

    /* renamed from: n3$a */
    /* compiled from: BroadcastReceiverConstraintTracker */
    public class a extends BroadcastReceiver {
        public a() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                n3.this.f(intent);
            }
        }
    }

    static {
        zi.e("BrdcstRcvrCnstrntTrckr");
    }

    public n3(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public final void c() {
        zi c = zi.c();
        String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()});
        c.a(new Throwable[0]);
        this.f492a.registerReceiver(this.a, e());
    }

    public final void d() {
        zi c = zi.c();
        String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()});
        c.a(new Throwable[0]);
        this.f492a.unregisterReceiver(this.a);
    }

    public abstract IntentFilter e();

    public abstract void f(Intent intent);
}
