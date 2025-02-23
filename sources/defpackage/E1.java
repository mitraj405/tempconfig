package defpackage;

import java.util.concurrent.Executor;

/* renamed from: E1  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class E1 implements Executor {
    public final /* synthetic */ int c;

    public /* synthetic */ E1(int i) {
        this.c = i;
    }

    public final void execute(Runnable runnable) {
        switch (this.c) {
            case 1:
                runnable.run();
                return;
            case 3:
                runnable.run();
                return;
            case 4:
                runnable.run();
                return;
            case 5:
                runnable.run();
                return;
            default:
                runnable.run();
                return;
        }
    }
}
