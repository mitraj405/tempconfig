package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: G6  reason: default package */
/* compiled from: Configuration */
public final class G6 implements ThreadFactory {
    public final AtomicInteger a = new AtomicInteger(0);

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f227a;

    public G6(boolean z) {
        this.f227a = z;
    }

    public final Thread newThread(Runnable runnable) {
        String str;
        if (this.f227a) {
            str = "WM.task-";
        } else {
            str = "androidx.work-";
        }
        StringBuilder J = xx.J(str);
        J.append(this.a.incrementAndGet());
        return new Thread(runnable, J.toString());
    }
}
