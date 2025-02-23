package defpackage;

import java.util.concurrent.Executor;

/* renamed from: Pk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Pk implements Executor {
    public final /* synthetic */ int c;

    public /* synthetic */ Pk(int i) {
        this.c = i;
    }

    public final void execute(Runnable runnable) {
        switch (this.c) {
            case 1:
                runnable.run();
                return;
            case 2:
                runnable.run();
                return;
            case 3:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
