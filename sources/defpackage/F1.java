package defpackage;

import java.util.concurrent.Executor;

/* renamed from: F1  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class F1 implements Executor {
    public final /* synthetic */ int c;

    public /* synthetic */ F1(int i) {
        this.c = i;
    }

    public final void execute(Runnable runnable) {
        switch (this.c) {
            case 0:
                G1.d().f226a.f3455a.execute(runnable);
                return;
            case 2:
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
