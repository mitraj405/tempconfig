package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.ForegroundInfo;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundService;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.C0326sE;
import defpackage.d7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* renamed from: wq  reason: default package */
/* compiled from: Processor */
public final class wq implements rb, C0216hd {
    public static final /* synthetic */ int c = 0;
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public PowerManager.WakeLock f3394a;

    /* renamed from: a  reason: collision with other field name */
    public final androidx.work.a f3395a;

    /* renamed from: a  reason: collision with other field name */
    public final WorkDatabase f3396a;

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f3397a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3398a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3399a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f3400a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f3401a;

    /* renamed from: a  reason: collision with other field name */
    public final List<fv> f3402a;
    public final HashMap b = new HashMap();

    /* renamed from: wq$a */
    /* compiled from: Processor */
    public static class a implements Runnable {
        public final ListenableFuture<Boolean> a;

        /* renamed from: a  reason: collision with other field name */
        public final rb f3403a;
        public final String c;

        public a(rb rbVar, String str, SettableFuture settableFuture) {
            this.f3403a = rbVar;
            this.c = str;
            this.a = settableFuture;
        }

        public final void run() {
            boolean z;
            try {
                z = this.a.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f3403a.e(this.c, z);
        }
    }

    static {
        zi.e("Processor");
    }

    public wq(Context context, androidx.work.a aVar, WD wd, WorkDatabase workDatabase, List list) {
        this.a = context;
        this.f3395a = aVar;
        this.f3397a = wd;
        this.f3396a = workDatabase;
        this.f3402a = list;
        this.f3401a = new HashSet();
        this.f3399a = new ArrayList();
        this.f3394a = null;
        this.f3398a = new Object();
    }

    public static boolean b(String str, C0326sE sEVar) {
        boolean z;
        if (sEVar != null) {
            sEVar.f3267a = true;
            sEVar.i();
            ListenableFuture<ListenableWorker.Result> listenableFuture = sEVar.f3260a;
            if (listenableFuture != null) {
                z = listenableFuture.isDone();
                sEVar.f3260a.cancel(true);
            } else {
                z = false;
            }
            ListenableWorker listenableWorker = sEVar.f3254a;
            if (listenableWorker == null || z) {
                String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{sEVar.f3261a});
                zi c2 = zi.c();
                int i = C0326sE.c;
                c2.a(new Throwable[0]);
            } else {
                listenableWorker.stop();
            }
            zi c3 = zi.c();
            String.format("WorkerWrapper interrupted for %s", new Object[]{str});
            c3.a(new Throwable[0]);
            return true;
        }
        zi c4 = zi.c();
        String.format("WorkerWrapper could not be found for %s", new Object[]{str});
        c4.a(new Throwable[0]);
        return false;
    }

    public final void a(rb rbVar) {
        synchronized (this.f3398a) {
            this.f3399a.add(rbVar);
        }
    }

    public final boolean c(String str) {
        boolean z;
        synchronized (this.f3398a) {
            if (!this.b.containsKey(str)) {
                if (!this.f3400a.containsKey(str)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public final void d(String str, ForegroundInfo foregroundInfo) {
        synchronized (this.f3398a) {
            zi c2 = zi.c();
            String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str});
            c2.d(new Throwable[0]);
            C0326sE sEVar = (C0326sE) this.b.remove(str);
            if (sEVar != null) {
                if (this.f3394a == null) {
                    PowerManager.WakeLock a2 = C0286oD.a(this.a, "ProcessorForegroundLck");
                    this.f3394a = a2;
                    a2.acquire();
                }
                this.f3400a.put(str, sEVar);
                Intent c3 = androidx.work.impl.foreground.a.c(this.a, str, foregroundInfo);
                Context context = this.a;
                Object obj = d7.a;
                d7.d.b(context, c3);
            }
        }
    }

    public final void e(String str, boolean z) {
        synchronized (this.f3398a) {
            this.b.remove(str);
            zi c2 = zi.c();
            String.format("%s %s executed; reschedule = %s", new Object[]{wq.class.getSimpleName(), str, Boolean.valueOf(z)});
            c2.a(new Throwable[0]);
            Iterator it = this.f3399a.iterator();
            while (it.hasNext()) {
                ((rb) it.next()).e(str, z);
            }
        }
    }

    public final boolean f(String str, WorkerParameters.a aVar) {
        synchronized (this.f3398a) {
            if (c(str)) {
                zi c2 = zi.c();
                String.format("Work %s is already enqueued for processing", new Object[]{str});
                c2.a(new Throwable[0]);
                return false;
            }
            C0326sE.a aVar2 = new C0326sE.a(this.a, this.f3395a, this.f3397a, this, this.f3396a, str);
            aVar2.f3275a = this.f3402a;
            if (aVar != null) {
                aVar2.f3269a = aVar;
            }
            C0326sE sEVar = new C0326sE(aVar2);
            SettableFuture<Boolean> settableFuture = sEVar.f3258a;
            settableFuture.addListener(new a(this, str, settableFuture), this.f3397a.a());
            this.b.put(str, sEVar);
            this.f3397a.b().execute(sEVar);
            zi c3 = zi.c();
            String.format("%s: processing %s", new Object[]{wq.class.getSimpleName(), str});
            c3.a(new Throwable[0]);
            return true;
        }
    }

    public final void g() {
        synchronized (this.f3398a) {
            if (!(!this.f3400a.isEmpty())) {
                Context context = this.a;
                int i = androidx.work.impl.foreground.a.c;
                Intent intent = new Intent(context, SystemForegroundService.class);
                intent.setAction("ACTION_STOP_FOREGROUND");
                try {
                    this.a.startService(intent);
                } catch (Throwable th) {
                    zi.c().b(th);
                }
                PowerManager.WakeLock wakeLock = this.f3394a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f3394a = null;
                }
            }
        }
    }

    public final boolean h(String str) {
        boolean b2;
        synchronized (this.f3398a) {
            zi c2 = zi.c();
            String.format("Processor stopping foreground work %s", new Object[]{str});
            c2.a(new Throwable[0]);
            b2 = b(str, (C0326sE) this.f3400a.remove(str));
        }
        return b2;
    }

    public final boolean i(String str) {
        boolean b2;
        synchronized (this.f3398a) {
            zi c2 = zi.c();
            String.format("Processor stopping background work %s", new Object[]{str});
            c2.a(new Throwable[0]);
            b2 = b(str, (C0326sE) this.b.remove(str));
        }
        return b2;
    }
}
