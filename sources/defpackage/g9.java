package defpackage;

import java.util.concurrent.Executor;

/* renamed from: g9  reason: default package */
/* compiled from: DirectExecutor */
public enum g9 implements Executor {
    ;

    /* access modifiers changed from: public */
    g9() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "DirectExecutor";
    }
}
