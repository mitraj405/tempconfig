package defpackage;

import java.util.concurrent.Executor;

/* renamed from: Ok  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Ok implements Executor {
    public final /* synthetic */ int c;

    public /* synthetic */ Ok(int i) {
        this.c = i;
    }

    public final void execute(Runnable runnable) {
        switch (this.c) {
            case 0:
                runnable.run();
                return;
            case 1:
                runnable.run();
                return;
            case 2:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
