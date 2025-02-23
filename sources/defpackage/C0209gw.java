package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* renamed from: gw  reason: default package and case insensitive filesystem */
/* compiled from: SerialExecutor */
public final class C0209gw implements Executor {
    public final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public volatile Runnable f2975a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayDeque<a> f2976a = new ArrayDeque<>();

    /* renamed from: a  reason: collision with other field name */
    public final Executor f2977a;

    /* renamed from: gw$a */
    /* compiled from: SerialExecutor */
    public static class a implements Runnable {
        public final C0209gw a;

        /* renamed from: a  reason: collision with other field name */
        public final Runnable f2978a;

        public a(C0209gw gwVar, Runnable runnable) {
            this.a = gwVar;
            this.f2978a = runnable;
        }

        public final void run() {
            C0209gw gwVar = this.a;
            try {
                this.f2978a.run();
            } finally {
                gwVar.a();
            }
        }
    }

    public C0209gw(ExecutorService executorService) {
        this.f2977a = executorService;
    }

    public final void a() {
        synchronized (this.a) {
            Runnable poll = this.f2976a.poll();
            this.f2975a = poll;
            if (poll != null) {
                this.f2977a.execute(this.f2975a);
            }
        }
    }

    public final void execute(Runnable runnable) {
        synchronized (this.a) {
            this.f2976a.add(new a(this, runnable));
            if (this.f2975a == null) {
                a();
            }
        }
    }
}
