package defpackage;

import android.content.Context;
import android.database.Cursor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.C0157cE;
import defpackage.C0236jE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: sE  reason: default package and case insensitive filesystem */
/* compiled from: WorkerWrapper */
public final class C0326sE implements Runnable {
    public static final /* synthetic */ int c = 0;
    public final K8 a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3252a;

    /* renamed from: a  reason: collision with other field name */
    public ListenableWorker.Result f3253a = new ListenableWorker.Result.a();

    /* renamed from: a  reason: collision with other field name */
    public ListenableWorker f3254a;

    /* renamed from: a  reason: collision with other field name */
    public final WorkerParameters.a f3255a;

    /* renamed from: a  reason: collision with other field name */
    public final androidx.work.a f3256a;

    /* renamed from: a  reason: collision with other field name */
    public final WorkDatabase f3257a;

    /* renamed from: a  reason: collision with other field name */
    public final SettableFuture<Boolean> f3258a = new SettableFuture<>();

    /* renamed from: a  reason: collision with other field name */
    public final TaskExecutor f3259a;

    /* renamed from: a  reason: collision with other field name */
    public ListenableFuture<ListenableWorker.Result> f3260a = null;

    /* renamed from: a  reason: collision with other field name */
    public C0214hE f3261a;

    /* renamed from: a  reason: collision with other field name */
    public final C0216hd f3262a;

    /* renamed from: a  reason: collision with other field name */
    public final C0224iE f3263a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList f3264a;

    /* renamed from: a  reason: collision with other field name */
    public final List<fv> f3265a;

    /* renamed from: a  reason: collision with other field name */
    public final C0256lE f3266a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f3267a;

    /* renamed from: c  reason: collision with other field name */
    public final String f3268c;
    public String d;

    /* renamed from: sE$a */
    /* compiled from: WorkerWrapper */
    public static class a {
        public final Context a;

        /* renamed from: a  reason: collision with other field name */
        public WorkerParameters.a f3269a = new WorkerParameters.a();

        /* renamed from: a  reason: collision with other field name */
        public final androidx.work.a f3270a;

        /* renamed from: a  reason: collision with other field name */
        public final WorkDatabase f3271a;

        /* renamed from: a  reason: collision with other field name */
        public final TaskExecutor f3272a;

        /* renamed from: a  reason: collision with other field name */
        public final C0216hd f3273a;

        /* renamed from: a  reason: collision with other field name */
        public final String f3274a;

        /* renamed from: a  reason: collision with other field name */
        public List<fv> f3275a;

        public a(Context context, androidx.work.a aVar, TaskExecutor taskExecutor, C0216hd hdVar, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.f3272a = taskExecutor;
            this.f3273a = hdVar;
            this.f3270a = aVar;
            this.f3271a = workDatabase;
            this.f3274a = str;
        }
    }

    static {
        zi.e("WorkerWrapper");
    }

    public C0326sE(a aVar) {
        this.f3252a = aVar.a;
        this.f3259a = aVar.f3272a;
        this.f3262a = aVar.f3273a;
        this.f3268c = aVar.f3274a;
        this.f3265a = aVar.f3275a;
        this.f3255a = aVar.f3269a;
        this.f3254a = null;
        this.f3256a = aVar.f3270a;
        WorkDatabase workDatabase = aVar.f3271a;
        this.f3257a = workDatabase;
        this.f3263a = workDatabase.n();
        this.a = workDatabase.i();
        this.f3266a = workDatabase.o();
    }

    public final void a(ListenableWorker.Result result) {
        if (result instanceof ListenableWorker.Result.c) {
            zi c2 = zi.c();
            String.format("Worker result SUCCESS for %s", new Object[]{this.d});
            c2.d(new Throwable[0]);
            if (this.f3261a.c()) {
                e();
                return;
            }
            K8 k8 = this.a;
            String str = this.f3268c;
            C0224iE iEVar = this.f3263a;
            WorkDatabase workDatabase = this.f3257a;
            workDatabase.c();
            try {
                ((C0236jE) iEVar).n(UD.SUCCEEDED, str);
                ((C0236jE) iEVar).l(str, ((ListenableWorker.Result.c) this.f3253a).a);
                long currentTimeMillis = System.currentTimeMillis();
                Iterator it = ((L8) k8).a(str).iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    if (((C0236jE) iEVar).f(str2) == UD.BLOCKED && ((L8) k8).b(str2)) {
                        zi c3 = zi.c();
                        String.format("Setting status to enqueued for %s", new Object[]{str2});
                        c3.d(new Throwable[0]);
                        ((C0236jE) iEVar).n(UD.ENQUEUED, str2);
                        ((C0236jE) iEVar).m(str2, currentTimeMillis);
                    }
                }
                workDatabase.h();
            } finally {
                workDatabase.f();
                f(false);
            }
        } else if (result instanceof ListenableWorker.Result.b) {
            zi c4 = zi.c();
            String.format("Worker result RETRY for %s", new Object[]{this.d});
            c4.d(new Throwable[0]);
            d();
        } else {
            zi c5 = zi.c();
            String.format("Worker result FAILURE for %s", new Object[]{this.d});
            c5.d(new Throwable[0]);
            if (this.f3261a.c()) {
                e();
            } else {
                h();
            }
        }
    }

    public final void b(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            C0236jE jEVar = (C0236jE) this.f3263a;
            if (jEVar.f(str2) != UD.CANCELLED) {
                jEVar.n(UD.FAILED, str2);
            }
            linkedList.addAll(((L8) this.a).a(str2));
        }
    }

    /* JADX INFO: finally extract failed */
    public final void c() {
        Zt zt;
        C0157cE.b bVar;
        C0085Cd a2;
        boolean i = i();
        String str = this.f3268c;
        WorkDatabase workDatabase = this.f3257a;
        if (!i) {
            workDatabase.c();
            try {
                UD f = ((C0236jE) this.f3263a).f(str);
                C0157cE cEVar = (C0157cE) workDatabase.m();
                zt = cEVar.a;
                zt.b();
                bVar = cEVar.f2754a;
                a2 = bVar.a();
                if (str == null) {
                    a2.e(1);
                } else {
                    a2.h(1, str);
                }
                zt.c();
                a2.j();
                zt.h();
                zt.f();
                bVar.c(a2);
                if (f == null) {
                    f(false);
                } else if (f == UD.RUNNING) {
                    a(this.f3253a);
                } else if (!f.a()) {
                    d();
                }
                workDatabase.h();
                workDatabase.f();
            } catch (Throwable th) {
                workDatabase.f();
                throw th;
            }
        }
        List<fv> list = this.f3265a;
        if (list != null) {
            for (fv c2 : list) {
                c2.c(str);
            }
            jv.a(this.f3256a, workDatabase, list);
        }
    }

    public final void d() {
        String str = this.f3268c;
        C0224iE iEVar = this.f3263a;
        WorkDatabase workDatabase = this.f3257a;
        workDatabase.c();
        try {
            ((C0236jE) iEVar).n(UD.ENQUEUED, str);
            ((C0236jE) iEVar).m(str, System.currentTimeMillis());
            ((C0236jE) iEVar).k(str, -1);
            workDatabase.h();
        } finally {
            workDatabase.f();
            f(true);
        }
    }

    public final void e() {
        Zt zt;
        C0236jE.f fVar;
        C0085Cd a2;
        String str = this.f3268c;
        C0224iE iEVar = this.f3263a;
        WorkDatabase workDatabase = this.f3257a;
        workDatabase.c();
        try {
            ((C0236jE) iEVar).m(str, System.currentTimeMillis());
            ((C0236jE) iEVar).n(UD.ENQUEUED, str);
            C0236jE jEVar = (C0236jE) iEVar;
            zt = jEVar.a;
            zt.b();
            fVar = jEVar.f3030a;
            a2 = fVar.a();
            if (str == null) {
                a2.e(1);
            } else {
                a2.h(1, str);
            }
            zt.c();
            a2.j();
            zt.h();
            zt.f();
            fVar.c(a2);
            ((C0236jE) iEVar).k(str, -1);
            workDatabase.h();
            workDatabase.f();
            f(false);
        } catch (Throwable th) {
            workDatabase.f();
            f(false);
            throw th;
        }
    }

    public final void f(boolean z) {
        bu c2;
        Cursor g;
        boolean z2;
        ListenableWorker listenableWorker;
        this.f3257a.c();
        try {
            C0236jE jEVar = (C0236jE) this.f3257a.n();
            jEVar.getClass();
            c2 = bu.c(0, "SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1");
            Zt zt = jEVar.a;
            zt.b();
            g = zt.g(c2);
            if (!g.moveToFirst() || g.getInt(0) == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            g.close();
            c2.release();
            if (!z2) {
                wo.a(this.f3252a, RescheduleReceiver.class, false);
            }
            if (z) {
                ((C0236jE) this.f3263a).n(UD.ENQUEUED, this.f3268c);
                ((C0236jE) this.f3263a).k(this.f3268c, -1);
            }
            if (!(this.f3261a == null || (listenableWorker = this.f3254a) == null || !listenableWorker.isRunInForeground())) {
                C0216hd hdVar = this.f3262a;
                String str = this.f3268c;
                wq wqVar = (wq) hdVar;
                synchronized (wqVar.f3398a) {
                    wqVar.f3400a.remove(str);
                    wqVar.g();
                }
            }
            this.f3257a.h();
            this.f3257a.f();
            this.f3258a.h(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.f3257a.f();
            throw th;
        }
    }

    public final void g() {
        String str = this.f3268c;
        UD f = ((C0236jE) this.f3263a).f(str);
        if (f == UD.RUNNING) {
            zi c2 = zi.c();
            String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{str});
            c2.a(new Throwable[0]);
            f(true);
            return;
        }
        zi c3 = zi.c();
        String.format("Status for %s is %s; not doing any work", new Object[]{str, f});
        c3.a(new Throwable[0]);
        f(false);
    }

    public final void h() {
        String str = this.f3268c;
        WorkDatabase workDatabase = this.f3257a;
        workDatabase.c();
        try {
            b(str);
            ((C0236jE) this.f3263a).l(str, ((ListenableWorker.Result.a) this.f3253a).a);
            workDatabase.h();
        } finally {
            workDatabase.f();
            f(false);
        }
    }

    public final boolean i() {
        if (!this.f3267a) {
            return false;
        }
        zi c2 = zi.c();
        String.format("Work interrupted for %s", new Object[]{this.d});
        c2.a(new Throwable[0]);
        UD f = ((C0236jE) this.f3263a).f(this.f3268c);
        if (f == null) {
            f(false);
        } else {
            f(!f.a());
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ab, code lost:
        if (r0 != false) goto L_0x00ad;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r22 = this;
            r1 = r22
            lE r0 = r1.f3266a
            mE r0 = (defpackage.mE) r0
            java.lang.String r2 = r1.f3268c
            java.util.ArrayList r0 = r0.a(r2)
            r1.f3264a = r0
            java.lang.String r3 = "Work [ id="
            java.lang.String r4 = ", tags={ "
            java.lang.StringBuilder r3 = defpackage.xx.K(r3, r2, r4)
            java.util.Iterator r0 = r0.iterator()
            r4 = 1
            r5 = r4
        L_0x001c:
            boolean r6 = r0.hasNext()
            r7 = 0
            if (r6 == 0) goto L_0x0036
            java.lang.Object r6 = r0.next()
            java.lang.String r6 = (java.lang.String) r6
            if (r5 == 0) goto L_0x002d
            r5 = r7
            goto L_0x0032
        L_0x002d:
            java.lang.String r7 = ", "
            r3.append(r7)
        L_0x0032:
            r3.append(r6)
            goto L_0x001c
        L_0x0036:
            java.lang.String r0 = " } ]"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.d = r0
            iE r3 = r1.f3263a
            boolean r0 = r22.i()
            if (r0 == 0) goto L_0x004b
            goto L_0x02bd
        L_0x004b:
            androidx.work.impl.WorkDatabase r5 = r1.f3257a
            r5.c()
            r0 = r3
            jE r0 = (defpackage.C0236jE) r0     // Catch:{ all -> 0x02cb }
            hE r0 = r0.i(r2)     // Catch:{ all -> 0x02cb }
            r1.f3261a = r0     // Catch:{ all -> 0x02cb }
            if (r0 != 0) goto L_0x0075
            zi r0 = defpackage.zi.c()     // Catch:{ all -> 0x02cb }
            java.lang.String r3 = "Didn't find WorkSpec for id %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x02cb }
            r4[r7] = r2     // Catch:{ all -> 0x02cb }
            java.lang.String.format(r3, r4)     // Catch:{ all -> 0x02cb }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r7]     // Catch:{ all -> 0x02cb }
            r0.b(r2)     // Catch:{ all -> 0x02cb }
            r1.f(r7)     // Catch:{ all -> 0x02cb }
            r5.h()     // Catch:{ all -> 0x02cb }
            goto L_0x00e4
        L_0x0075:
            UD r6 = r0.f2989a     // Catch:{ all -> 0x02cb }
            UD r8 = defpackage.UD.ENQUEUED
            if (r6 == r8) goto L_0x0098
            r22.g()     // Catch:{ all -> 0x02cb }
            r5.h()     // Catch:{ all -> 0x02cb }
            zi r0 = defpackage.zi.c()     // Catch:{ all -> 0x02cb }
            java.lang.String r2 = "%s is not in ENQUEUED state. Nothing more to do."
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x02cb }
            hE r4 = r1.f3261a     // Catch:{ all -> 0x02cb }
            java.lang.String r4 = r4.f2995b     // Catch:{ all -> 0x02cb }
            r3[r7] = r4     // Catch:{ all -> 0x02cb }
            java.lang.String.format(r2, r3)     // Catch:{ all -> 0x02cb }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r7]     // Catch:{ all -> 0x02cb }
            r0.a(r2)     // Catch:{ all -> 0x02cb }
            goto L_0x00e4
        L_0x0098:
            boolean r0 = r0.c()     // Catch:{ all -> 0x02cb }
            if (r0 != 0) goto L_0x00ad
            hE r0 = r1.f3261a     // Catch:{ all -> 0x02cb }
            UD r6 = r0.f2989a     // Catch:{ all -> 0x02cb }
            if (r6 != r8) goto L_0x00aa
            int r0 = r0.a     // Catch:{ all -> 0x02cb }
            if (r0 <= 0) goto L_0x00aa
            r0 = r4
            goto L_0x00ab
        L_0x00aa:
            r0 = r7
        L_0x00ab:
            if (r0 == 0) goto L_0x00e9
        L_0x00ad:
            long r9 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02cb }
            hE r0 = r1.f3261a     // Catch:{ all -> 0x02cb }
            long r11 = r0.e     // Catch:{ all -> 0x02cb }
            r13 = 0
            int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r6 != 0) goto L_0x00bd
            r6 = r4
            goto L_0x00be
        L_0x00bd:
            r6 = r7
        L_0x00be:
            if (r6 != 0) goto L_0x00e9
            long r11 = r0.a()     // Catch:{ all -> 0x02cb }
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x00e9
            zi r0 = defpackage.zi.c()     // Catch:{ all -> 0x02cb }
            java.lang.String r2 = "Delaying execution for %s because it is being executed before schedule."
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ all -> 0x02cb }
            hE r6 = r1.f3261a     // Catch:{ all -> 0x02cb }
            java.lang.String r6 = r6.f2995b     // Catch:{ all -> 0x02cb }
            r3[r7] = r6     // Catch:{ all -> 0x02cb }
            java.lang.String.format(r2, r3)     // Catch:{ all -> 0x02cb }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r7]     // Catch:{ all -> 0x02cb }
            r0.a(r2)     // Catch:{ all -> 0x02cb }
            r1.f(r4)     // Catch:{ all -> 0x02cb }
            r5.h()     // Catch:{ all -> 0x02cb }
        L_0x00e4:
            r5.f()
            goto L_0x02bd
        L_0x00e9:
            r5.h()     // Catch:{ all -> 0x02cb }
            r5.f()
            hE r0 = r1.f3261a
            boolean r0 = r0.c()
            androidx.work.a r6 = r1.f3256a
            if (r0 == 0) goto L_0x0100
            hE r0 = r1.f3261a
            androidx.work.Data r0 = r0.f2990a
        L_0x00fd:
            r11 = r0
            goto L_0x0196
        L_0x0100:
            ag r0 = r6.f2647a
            hE r9 = r1.f3261a
            java.lang.String r9 = r9.f2997c
            r0.getClass()
            int r0 = defpackage.Zf.a
            java.lang.Class r0 = java.lang.Class.forName(r9)     // Catch:{ Exception -> 0x0116 }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x0116 }
            Zf r0 = (defpackage.Zf) r0     // Catch:{ Exception -> 0x0116 }
            goto L_0x0125
        L_0x0116:
            r0 = move-exception
            zi r9 = defpackage.zi.c()
            java.lang.Throwable[] r10 = new java.lang.Throwable[r4]
            r10[r7] = r0
            int r0 = defpackage.Zf.a
            r9.b(r10)
            r0 = 0
        L_0x0125:
            if (r0 != 0) goto L_0x0142
            zi r0 = defpackage.zi.c()
            java.lang.Object[] r2 = new java.lang.Object[r4]
            hE r3 = r1.f3261a
            java.lang.String r3 = r3.f2997c
            r2[r7] = r3
            java.lang.String r3 = "Could not create Input Merger %s"
            java.lang.String.format(r3, r2)
            java.lang.Throwable[] r2 = new java.lang.Throwable[r7]
            r0.b(r2)
            r22.h()
            goto L_0x02bd
        L_0x0142:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            hE r10 = r1.f3261a
            androidx.work.Data r10 = r10.f2990a
            r9.add(r10)
            r10 = r3
            jE r10 = (defpackage.C0236jE) r10
            r10.getClass()
            java.lang.String r11 = "SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)"
            bu r11 = defpackage.bu.c(r4, r11)
            if (r2 != 0) goto L_0x0160
            r11.h(r4)
            goto L_0x0163
        L_0x0160:
            r11.j(r4, r2)
        L_0x0163:
            Zt r4 = r10.a
            r4.b()
            android.database.Cursor r4 = r4.g(r11)
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x02c3 }
            int r12 = r4.getCount()     // Catch:{ all -> 0x02c3 }
            r10.<init>(r12)     // Catch:{ all -> 0x02c3 }
        L_0x0175:
            boolean r12 = r4.moveToNext()     // Catch:{ all -> 0x02c3 }
            if (r12 == 0) goto L_0x0187
            byte[] r12 = r4.getBlob(r7)     // Catch:{ all -> 0x02c3 }
            androidx.work.Data r12 = androidx.work.Data.a(r12)     // Catch:{ all -> 0x02c3 }
            r10.add(r12)     // Catch:{ all -> 0x02c3 }
            goto L_0x0175
        L_0x0187:
            r4.close()
            r11.release()
            r9.addAll(r10)
            androidx.work.Data r0 = r0.a(r9)
            goto L_0x00fd
        L_0x0196:
            androidx.work.WorkerParameters r0 = new androidx.work.WorkerParameters
            java.util.UUID r10 = java.util.UUID.fromString(r2)
            java.util.ArrayList r12 = r1.f3264a
            androidx.work.WorkerParameters$a r13 = r1.f3255a
            hE r4 = r1.f3261a
            int r14 = r4.a
            java.util.concurrent.ExecutorService r15 = r6.f2648a
            androidx.work.impl.utils.taskexecutor.TaskExecutor r4 = r1.f3259a
            pE r6 = r6.f2650a
            eE r7 = new eE
            androidx.work.impl.utils.taskexecutor.TaskExecutor r9 = r1.f3259a
            r7.<init>(r5, r9)
            r20 = r8
            TD r8 = new TD
            r21 = r2
            hd r2 = r1.f3262a
            r8.<init>(r5, r2, r9)
            r2 = r9
            r9 = r0
            r16 = r4
            r17 = r6
            r18 = r7
            r19 = r8
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            androidx.work.ListenableWorker r4 = r1.f3254a
            if (r4 != 0) goto L_0x01d9
            hE r4 = r1.f3261a
            java.lang.String r4 = r4.f2995b
            android.content.Context r7 = r1.f3252a
            androidx.work.ListenableWorker r4 = r6.b(r7, r4, r0)
            r1.f3254a = r4
        L_0x01d9:
            androidx.work.ListenableWorker r4 = r1.f3254a
            if (r4 != 0) goto L_0x01fa
            zi r0 = defpackage.zi.c()
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            hE r3 = r1.f3261a
            java.lang.String r3 = r3.f2995b
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "Could not create Worker %s"
            java.lang.String.format(r3, r2)
            java.lang.Throwable[] r2 = new java.lang.Throwable[r4]
            r0.b(r2)
            r22.h()
            goto L_0x02bd
        L_0x01fa:
            r6 = 0
            boolean r4 = r4.isUsed()
            if (r4 == 0) goto L_0x021d
            zi r0 = defpackage.zi.c()
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            hE r3 = r1.f3261a
            java.lang.String r3 = r3.f2995b
            r2[r6] = r3
            java.lang.String r3 = "Received an already-used Worker %s; WorkerFactory should return new instances"
            java.lang.String.format(r3, r2)
            java.lang.Throwable[] r2 = new java.lang.Throwable[r6]
            r0.b(r2)
            r22.h()
            goto L_0x02bd
        L_0x021d:
            androidx.work.ListenableWorker r4 = r1.f3254a
            r4.setUsed()
            r5.c()
            r4 = r3
            jE r4 = (defpackage.C0236jE) r4     // Catch:{ all -> 0x02be }
            r6 = r21
            UD r4 = r4.f(r6)     // Catch:{ all -> 0x02be }
            r7 = r20
            if (r4 != r7) goto L_0x0271
            UD r4 = defpackage.UD.RUNNING     // Catch:{ all -> 0x02be }
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ all -> 0x02be }
            r8 = 0
            r7[r8] = r6     // Catch:{ all -> 0x02be }
            r8 = r3
            jE r8 = (defpackage.C0236jE) r8     // Catch:{ all -> 0x02be }
            r8.n(r4, r7)     // Catch:{ all -> 0x02be }
            jE r3 = (defpackage.C0236jE) r3     // Catch:{ all -> 0x02be }
            Zt r4 = r3.a     // Catch:{ all -> 0x02be }
            r4.b()     // Catch:{ all -> 0x02be }
            jE$e r3 = r3.f3029a     // Catch:{ all -> 0x02be }
            Cd r7 = r3.a()     // Catch:{ all -> 0x02be }
            if (r6 != 0) goto L_0x0254
            r6 = 1
            r7.e(r6)     // Catch:{ all -> 0x02be }
            goto L_0x0259
        L_0x0254:
            r8 = 1
            r7.h(r8, r6)     // Catch:{ all -> 0x02be }
            r6 = r8
        L_0x0259:
            r4.c()     // Catch:{ all -> 0x02be }
            r7.j()     // Catch:{ all -> 0x0269 }
            r4.h()     // Catch:{ all -> 0x0269 }
            r4.f()     // Catch:{ all -> 0x02be }
            r3.c(r7)     // Catch:{ all -> 0x02be }
            goto L_0x0272
        L_0x0269:
            r0 = move-exception
            r4.f()     // Catch:{ all -> 0x02be }
            r3.c(r7)     // Catch:{ all -> 0x02be }
            throw r0     // Catch:{ all -> 0x02be }
        L_0x0271:
            r6 = 0
        L_0x0272:
            r5.h()     // Catch:{ all -> 0x02be }
            r5.f()
            if (r6 == 0) goto L_0x02ba
            boolean r3 = r22.i()
            if (r3 == 0) goto L_0x0281
            goto L_0x02bd
        L_0x0281:
            androidx.work.impl.utils.futures.SettableFuture r3 = new androidx.work.impl.utils.futures.SettableFuture
            r3.<init>()
            RD r10 = new RD
            android.content.Context r5 = r1.f3252a
            hE r6 = r1.f3261a
            androidx.work.ListenableWorker r7 = r1.f3254a
            id r8 = r0.f2642a
            androidx.work.impl.utils.taskexecutor.TaskExecutor r9 = r1.f3259a
            r4 = r10
            r4.<init>(r5, r6, r7, r8, r9)
            WD$a r0 = r2.a()
            r0.execute(r10)
            qE r0 = new qE
            androidx.work.impl.utils.futures.SettableFuture<java.lang.Void> r4 = r10.f498a
            r0.<init>(r1, r4, r3)
            WD$a r5 = r2.a()
            r4.addListener(r0, r5)
            java.lang.String r0 = r1.d
            rE r4 = new rE
            r4.<init>(r1, r3, r0)
            gw r0 = r2.b()
            r3.addListener(r4, r0)
            goto L_0x02bd
        L_0x02ba:
            r22.g()
        L_0x02bd:
            return
        L_0x02be:
            r0 = move-exception
            r5.f()
            throw r0
        L_0x02c3:
            r0 = move-exception
            r4.close()
            r11.release()
            throw r0
        L_0x02cb:
            r0 = move-exception
            r5.f()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0326sE.run():void");
    }
}
