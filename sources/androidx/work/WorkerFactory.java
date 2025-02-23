package androidx.work;

import android.content.Context;

public abstract class WorkerFactory {
    public static final /* synthetic */ int a = 0;

    static {
        zi.e("WorkerFactory");
    }

    public abstract void a();

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        Class<? extends U> cls;
        a();
        ListenableWorker listenableWorker = null;
        try {
            cls = Class.forName(str).asSubclass(ListenableWorker.class);
        } catch (Throwable th) {
            zi.c().b(th);
            cls = null;
        }
        if (cls != null) {
            try {
                listenableWorker = (ListenableWorker) cls.getDeclaredConstructor(new Class[]{Context.class, WorkerParameters.class}).newInstance(new Object[]{context, workerParameters});
            } catch (Throwable th2) {
                zi.c().b(th2);
            }
        }
        if (listenableWorker == null || !listenableWorker.isUsed()) {
            return listenableWorker;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", new Object[]{getClass().getName(), str}));
    }
}
