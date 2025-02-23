package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import androidx.emoji2.text.d;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EmojiCompatInitializer implements Sf<Boolean> {

    public static class a extends d.c {
        public a(Context context) {
            super(new b(context));
            this.a = 1;
        }
    }

    public static class b implements d.g {
        public final Context a;

        public b(Context context) {
            this.a = context.getApplicationContext();
        }

        public final void a(d.h hVar) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new C0322s6("EmojiCompatInitializer"));
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new C0225ia(this, 0, hVar, threadPoolExecutor));
        }
    }

    public static class c implements Runnable {
        public final void run() {
            boolean z;
            try {
                int i = C0337tA.a;
                Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (d.a != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    d.a().c();
                }
                Trace.endSection();
            } catch (Throwable th) {
                int i2 = C0337tA.a;
                Trace.endSection();
                throw th;
            }
        }
    }

    public final List<Class<? extends Sf<?>>> b() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* renamed from: c */
    public final Boolean a(Context context) {
        Object obj;
        a aVar = new a(context);
        if (d.a == null) {
            synchronized (d.f2004a) {
                if (d.a == null) {
                    d.a = new d(aVar);
                }
            }
        }
        z1 c2 = z1.c(context);
        Class<ProcessLifecycleInitializer> cls = ProcessLifecycleInitializer.class;
        c2.getClass();
        synchronized (z1.a) {
            try {
                obj = c2.f3447a.get(cls);
                if (obj == null) {
                    obj = c2.b(cls, new HashSet());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        final Lifecycle lifecycle = ((LifecycleOwner) obj).getLifecycle();
        lifecycle.a(new t8() {
            public final void a(LifecycleOwner lifecycleOwner) {
                Handler handler;
                EmojiCompatInitializer.this.getClass();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler = C0336t6.a(Looper.getMainLooper());
                } else {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.postDelayed(new c(), 500);
                lifecycle.c(this);
            }
        });
        return Boolean.TRUE;
    }
}
