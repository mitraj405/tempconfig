package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: sb  reason: default package */
/* compiled from: ExecutorCompat */
public final class sb implements Executor {
    public final Handler a;

    public sb(Handler handler) {
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        runnable.getClass();
        Handler handler = this.a;
        if (!handler.post(runnable)) {
            throw new RejectedExecutionException(handler + " is shutting down");
        }
    }
}
