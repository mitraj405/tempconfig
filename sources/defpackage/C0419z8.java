package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: z8  reason: default package and case insensitive filesystem */
/* compiled from: DefaultTaskExecutor */
public final class C0419z8 extends v3 {
    public volatile Handler a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3454a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final ExecutorService f3455a = Executors.newFixedThreadPool(4, new a());

    /* renamed from: z8$a */
    /* compiled from: DefaultTaskExecutor */
    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(0);

        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.a.getAndIncrement());
            return thread;
        }
    }

    public static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Handler.createAsync(looper);
        }
        Class<Handler> cls = Handler.class;
        try {
            return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }
}
