package defpackage;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* renamed from: nE  reason: default package */
/* compiled from: WorkTimer */
public final class nE {
    public final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f3109a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public final ScheduledExecutorService f3110a;
    public final HashMap b = new HashMap();

    /* renamed from: nE$a */
    /* compiled from: WorkTimer */
    public class a implements ThreadFactory {
        public int c = 0;

        public final Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.c);
            this.c = this.c + 1;
            return newThread;
        }
    }

    /* renamed from: nE$b */
    /* compiled from: WorkTimer */
    public interface b {
        void b(String str);
    }

    /* renamed from: nE$c */
    /* compiled from: WorkTimer */
    public static class c implements Runnable {
        public final nE a;
        public final String c;

        public c(nE nEVar, String str) {
            this.a = nEVar;
            this.c = str;
        }

        public final void run() {
            synchronized (this.a.a) {
                if (((c) this.a.f3109a.remove(this.c)) != null) {
                    b bVar = (b) this.a.b.remove(this.c);
                    if (bVar != null) {
                        bVar.b(this.c);
                    }
                } else {
                    zi c2 = zi.c();
                    String.format("Timer with %s is already marked as complete.", new Object[]{this.c});
                    c2.a(new Throwable[0]);
                }
            }
        }
    }

    static {
        zi.e("WorkTimer");
    }

    public nE() {
        a aVar = new a();
        this.f3110a = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public final void a(String str, b bVar) {
        synchronized (this.a) {
            zi c2 = zi.c();
            String.format("Starting timer for %s", new Object[]{str});
            c2.a(new Throwable[0]);
            b(str);
            c cVar = new c(this, str);
            this.f3109a.put(str, cVar);
            this.b.put(str, bVar);
            this.f3110a.schedule(cVar, 600000, TimeUnit.MILLISECONDS);
        }
    }

    public final void b(String str) {
        synchronized (this.a) {
            if (((c) this.f3109a.remove(str)) != null) {
                zi c2 = zi.c();
                String.format("Stopping timer for %s", new Object[]{str});
                c2.a(new Throwable[0]);
                this.b.remove(str);
            }
        }
    }
}
