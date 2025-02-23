package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: SystemAlarmDispatcher */
public final class d implements rb {
    public static final /* synthetic */ int c = 0;
    public final VD a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2678a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f2679a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f2680a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2681a;

    /* renamed from: a  reason: collision with other field name */
    public c f2682a;

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f2683a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f2684a;

    /* renamed from: a  reason: collision with other field name */
    public final nE f2685a = new nE();

    /* renamed from: a  reason: collision with other field name */
    public final wq f2686a;

    /* compiled from: SystemAlarmDispatcher */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            C0029d dVar;
            d dVar2;
            synchronized (d.this.f2684a) {
                d dVar3 = d.this;
                dVar3.f2679a = (Intent) dVar3.f2684a.get(0);
            }
            Intent intent = d.this.f2679a;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = d.this.f2679a.getIntExtra("KEY_START_ID", 0);
                zi c = zi.c();
                int i = d.c;
                String.format("Processing command %s, %s", new Object[]{d.this.f2679a, Integer.valueOf(intExtra)});
                c.a(new Throwable[0]);
                PowerManager.WakeLock a2 = C0286oD.a(d.this.f2678a, String.format("%s (%s)", new Object[]{action, Integer.valueOf(intExtra)}));
                try {
                    zi c2 = zi.c();
                    String.format("Acquiring operation wake lock (%s) %s", new Object[]{action, a2});
                    c2.a(new Throwable[0]);
                    a2.acquire();
                    d dVar4 = d.this;
                    dVar4.f2681a.c(intExtra, dVar4.f2679a, dVar4);
                    zi c3 = zi.c();
                    String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a2});
                    c3.a(new Throwable[0]);
                    a2.release();
                    dVar2 = d.this;
                    dVar = new C0029d(dVar2);
                } catch (Throwable th) {
                    zi c4 = zi.c();
                    int i2 = d.c;
                    String.format("Releasing operation wake lock (%s) %s", new Object[]{action, a2});
                    c4.a(new Throwable[0]);
                    a2.release();
                    d dVar5 = d.this;
                    dVar5.d(new C0029d(dVar5));
                    throw th;
                }
                dVar2.d(dVar);
            }
        }
    }

    /* compiled from: SystemAlarmDispatcher */
    public static class b implements Runnable {
        public final Intent a;

        /* renamed from: a  reason: collision with other field name */
        public final d f2687a;
        public final int c;

        public b(int i, Intent intent, d dVar) {
            this.f2687a = dVar;
            this.a = intent;
            this.c = i;
        }

        public final void run() {
            this.f2687a.a(this.c, this.a);
        }
    }

    /* compiled from: SystemAlarmDispatcher */
    public interface c {
    }

    /* renamed from: androidx.work.impl.background.systemalarm.d$d  reason: collision with other inner class name */
    /* compiled from: SystemAlarmDispatcher */
    public static class C0029d implements Runnable {
        public final d a;

        public C0029d(d dVar) {
            this.a = dVar;
        }

        public final void run() {
            boolean z;
            d dVar = this.a;
            dVar.getClass();
            zi c = zi.c();
            int i = d.c;
            c.a(new Throwable[0]);
            dVar.b();
            synchronized (dVar.f2684a) {
                boolean z2 = true;
                if (dVar.f2679a != null) {
                    zi c2 = zi.c();
                    String.format("Removing command %s", new Object[]{dVar.f2679a});
                    c2.a(new Throwable[0]);
                    if (((Intent) dVar.f2684a.remove(0)).equals(dVar.f2679a)) {
                        dVar.f2679a = null;
                    } else {
                        throw new IllegalStateException("Dequeue-d command is not the first.");
                    }
                }
                C0209gw b = dVar.f2683a.b();
                a aVar = dVar.f2681a;
                synchronized (aVar.f2668a) {
                    if (!aVar.f2669a.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (!z) {
                    if (dVar.f2684a.isEmpty()) {
                        synchronized (b.a) {
                            if (b.f2976a.isEmpty()) {
                                z2 = false;
                            }
                        }
                        if (!z2) {
                            zi.c().a(new Throwable[0]);
                            c cVar = dVar.f2682a;
                            if (cVar != null) {
                                ((SystemAlarmService) cVar).b();
                            }
                        }
                    }
                }
                if (!dVar.f2684a.isEmpty()) {
                    dVar.f();
                }
            }
        }
    }

    static {
        zi.e("SystemAlarmDispatcher");
    }

    public d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f2678a = applicationContext;
        this.f2681a = new a(applicationContext);
        VD e = VD.e(context);
        this.a = e;
        wq wqVar = e.f598a;
        this.f2686a = wqVar;
        this.f2683a = e.f595a;
        wqVar.a(this);
        this.f2684a = new ArrayList();
        this.f2679a = null;
        this.f2680a = new Handler(Looper.getMainLooper());
    }

    public final void a(int i, Intent intent) {
        zi c2 = zi.c();
        boolean z = false;
        String.format("Adding command %s (%s)", new Object[]{intent, Integer.valueOf(i)});
        c2.a(new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            zi.c().f(new Throwable[0]);
            return;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            b();
            synchronized (this.f2684a) {
                Iterator it = this.f2684a.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if ("ACTION_CONSTRAINTS_CHANGED".equals(((Intent) it.next()).getAction())) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z) {
                return;
            }
        }
        intent.putExtra("KEY_START_ID", i);
        synchronized (this.f2684a) {
            boolean z2 = !this.f2684a.isEmpty();
            this.f2684a.add(intent);
            if (!z2) {
                f();
            }
        }
    }

    public final void b() {
        if (this.f2680a.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    public final void c() {
        zi.c().a(new Throwable[0]);
        wq wqVar = this.f2686a;
        synchronized (wqVar.f3398a) {
            wqVar.f3399a.remove(this);
        }
        ScheduledExecutorService scheduledExecutorService = this.f2685a.f3110a;
        if (!scheduledExecutorService.isShutdown()) {
            scheduledExecutorService.shutdownNow();
        }
        this.f2682a = null;
    }

    public final void d(Runnable runnable) {
        this.f2680a.post(runnable);
    }

    public final void e(String str, boolean z) {
        int i = a.c;
        Intent intent = new Intent(this.f2678a, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra("KEY_WORKSPEC_ID", str);
        intent.putExtra("KEY_NEEDS_RESCHEDULE", z);
        d(new b(0, intent, this));
    }

    public final void f() {
        b();
        PowerManager.WakeLock a2 = C0286oD.a(this.f2678a, "ProcessCommand");
        try {
            a2.acquire();
            this.a.f595a.c(new a());
        } finally {
            a2.release();
        }
    }
}
