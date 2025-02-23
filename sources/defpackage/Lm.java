package defpackage;

import java.util.concurrent.ThreadFactory;
import rx.Scheduler;

/* renamed from: Lm  reason: default package */
/* compiled from: NewThreadScheduler */
public final class Lm extends Scheduler {
    public final ThreadFactory a;

    public Lm(C0533Hu hu) {
        this.a = hu;
    }

    public final Scheduler.a a() {
        return new Nm(this.a);
    }
}
