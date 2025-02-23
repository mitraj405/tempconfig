package defpackage;

import java.util.concurrent.Executor;

/* renamed from: e9  reason: default package */
/* compiled from: DirectExecutor */
public enum e9 implements Executor {
    ;

    /* access modifiers changed from: public */
    e9() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "DirectExecutor";
    }
}
