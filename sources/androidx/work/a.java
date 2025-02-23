package androidx.work;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Configuration */
public final class a {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final ag f2647a;

    /* renamed from: a  reason: collision with other field name */
    public final ExecutorService f2648a = a(false);

    /* renamed from: a  reason: collision with other field name */
    public final nh f2649a;

    /* renamed from: a  reason: collision with other field name */
    public final pE f2650a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final ExecutorService f2651b = a(true);
    public final int c;

    /* renamed from: androidx.work.a$a  reason: collision with other inner class name */
    /* compiled from: Configuration */
    public static final class C0027a {
    }

    /* compiled from: Configuration */
    public interface b {
        a a();
    }

    public a(C0027a aVar) {
        int i = WorkerFactory.a;
        this.f2650a = new pE();
        this.f2647a = new ag();
        this.f2649a = new nh(1);
        this.a = 4;
        this.b = Integer.MAX_VALUE;
        this.c = 20;
    }

    public static ExecutorService a(boolean z) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new G6(z));
    }
}
