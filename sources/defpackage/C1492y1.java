package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: y1  reason: default package and case insensitive filesystem */
/* compiled from: AppExecutors */
public final class C1492y1 {
    public static volatile C1492y1 a;

    /* renamed from: a  reason: collision with other field name */
    public final Executor f7068a;

    /* renamed from: a  reason: collision with other field name */
    public final ExecutorService f7069a;
    public final ExecutorService b;

    /* renamed from: y1$a */
    /* compiled from: AppExecutors */
    public static class a implements Executor {
        public final Handler a = new Handler(Looper.getMainLooper());

        public final void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    public C1492y1(ExecutorService executorService, ExecutorService executorService2, a aVar) {
        this.f7069a = executorService;
        this.b = executorService2;
        this.f7068a = aVar;
    }

    public static C1492y1 a() {
        if (a == null) {
            synchronized (C1492y1.class) {
                if (a == null) {
                    a = new C1492y1(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3), new a());
                }
            }
        }
        return a;
    }
}
