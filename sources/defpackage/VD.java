package defpackage;

import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.text.TextUtils;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import defpackage.C0236jE;
import defpackage.Ly;
import defpackage.Zt;
import defpackage.zi;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: VD  reason: default package */
/* compiled from: WorkManagerImpl */
public final class VD extends v3 {
    public static VD a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f590a = new Object();
    public static VD b = null;

    /* renamed from: a  reason: collision with other field name */
    public BroadcastReceiver.PendingResult f591a;

    /* renamed from: a  reason: collision with other field name */
    public Context f592a;

    /* renamed from: a  reason: collision with other field name */
    public a f593a;

    /* renamed from: a  reason: collision with other field name */
    public WorkDatabase f594a;

    /* renamed from: a  reason: collision with other field name */
    public TaskExecutor f595a;

    /* renamed from: a  reason: collision with other field name */
    public hq f596a;

    /* renamed from: a  reason: collision with other field name */
    public List<fv> f597a;

    /* renamed from: a  reason: collision with other field name */
    public wq f598a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f599a;

    static {
        zi.e("WorkManagerImpl");
    }

    /* JADX INFO: finally extract failed */
    public VD(Context context, a aVar, WD wd) {
        Zt.a aVar2;
        int i;
        String str;
        boolean z;
        Executor executor;
        a aVar3 = aVar;
        WD wd2 = wd;
        boolean z2 = context.getResources().getBoolean(C0231ir.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        C0209gw gwVar = wd2.f634a;
        int i2 = WorkDatabase.a;
        if (z2) {
            aVar2 = new Zt.a(applicationContext, (String) null);
            aVar2.f782a = true;
        } else {
            String[] strArr = QD.a;
            aVar2 = new Zt.a(applicationContext, "androidx.work.workdb");
            aVar2.a = new OD(applicationContext);
        }
        aVar2.f781a = gwVar;
        PD pd = new PD();
        if (aVar2.f779a == null) {
            aVar2.f779a = new ArrayList<>();
        }
        aVar2.f779a.add(pd);
        aVar2.a(androidx.work.impl.a.a);
        aVar2.a(new a.h(applicationContext, 2, 3));
        aVar2.a(androidx.work.impl.a.f2659a);
        aVar2.a(androidx.work.impl.a.f2660a);
        aVar2.a(new a.h(applicationContext, 5, 6));
        aVar2.a(androidx.work.impl.a.f2661a);
        aVar2.a(androidx.work.impl.a.f2662a);
        aVar2.a(androidx.work.impl.a.f2663a);
        aVar2.a(new a.i(applicationContext));
        aVar2.a(new a.h(applicationContext, 10, 11));
        aVar2.a(androidx.work.impl.a.f2664a);
        aVar2.f783b = false;
        aVar2.c = true;
        Context context2 = aVar2.f776a;
        if (context2 != null) {
            Class<T> cls = aVar2.f777a;
            if (cls != null) {
                Executor executor2 = aVar2.f781a;
                if (executor2 == null && aVar2.b == null) {
                    F1 f1 = G1.a;
                    aVar2.b = f1;
                    aVar2.f781a = f1;
                } else if (executor2 != null && aVar2.b == null) {
                    aVar2.b = executor2;
                } else if (executor2 == null && (executor = aVar2.b) != null) {
                    aVar2.f781a = executor;
                }
                if (aVar2.a == null) {
                    aVar2.a = new C0082Ad();
                }
                String str2 = aVar2.f778a;
                Ly.c cVar = aVar2.a;
                Zt.c cVar2 = aVar2.f775a;
                ArrayList<Zt.b> arrayList = aVar2.f779a;
                boolean z3 = aVar2.f782a;
                ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
                if (activityManager == null || activityManager.isLowRamDevice()) {
                    i = 2;
                } else {
                    i = 3;
                }
                Executor executor3 = aVar2.f781a;
                boolean z4 = z3;
                b8 b8Var = new b8(context2, str2, cVar, cVar2, arrayList, z4, i, executor3, aVar2.b, aVar2.f783b, aVar2.c);
                String name = cls.getPackage().getName();
                String canonicalName = cls.getCanonicalName();
                canonicalName = !name.isEmpty() ? canonicalName.substring(name.length() + 1) : canonicalName;
                String str3 = canonicalName.replace('.', '_') + "_Impl";
                try {
                    if (name.isEmpty()) {
                        str = str3;
                    } else {
                        str = name + "." + str3;
                    }
                    Zt zt = (Zt) Class.forName(str).newInstance();
                    Ly e = zt.e(b8Var);
                    zt.f768a = e;
                    if (e instanceof Iu) {
                        ((Iu) e).a = b8Var;
                    }
                    if (i == 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    e.setWriteAheadLoggingEnabled(z);
                    zt.f770a = arrayList;
                    zt.f771a = executor3;
                    new ArrayDeque();
                    zt.f774a = z4;
                    zt.b = z;
                    WorkDatabase workDatabase = (WorkDatabase) zt;
                    Context applicationContext2 = context.getApplicationContext();
                    zi.a aVar4 = new zi.a(aVar3.a);
                    synchronized (zi.class) {
                        try {
                            zi.a = aVar4;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    int i3 = jv.a;
                    ez ezVar = new ez(applicationContext2, this);
                    wo.a(applicationContext2, SystemJobService.class, true);
                    zi.c().a(new Throwable[0]);
                    List<fv> asList = Arrays.asList(new fv[]{ezVar, new C0092Fe(applicationContext2, aVar3, wd2, this)});
                    wq wqVar = new wq(context, aVar, wd, workDatabase, asList);
                    Context applicationContext3 = context.getApplicationContext();
                    this.f592a = applicationContext3;
                    this.f593a = aVar3;
                    this.f595a = wd2;
                    this.f594a = workDatabase;
                    this.f597a = asList;
                    this.f598a = wqVar;
                    this.f596a = new hq(workDatabase);
                    this.f599a = false;
                    if (!applicationContext3.isDeviceProtectedStorage()) {
                        this.f595a.c(new ForceStopRunnable(applicationContext3, this));
                        return;
                    }
                    throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
                } catch (ClassNotFoundException unused) {
                    throw new RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str3 + " does not exist");
                } catch (IllegalAccessException unused2) {
                    throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
                } catch (InstantiationException unused3) {
                    throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
                }
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        } else {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static defpackage.VD e(android.content.Context r2) {
        /*
            java.lang.Object r0 = f590a
            monitor-enter(r0)
            monitor-enter(r0)     // Catch:{ all -> 0x0035 }
            VD r1 = a     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            goto L_0x000d
        L_0x000a:
            VD r1 = b     // Catch:{ all -> 0x0030 }
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
        L_0x000d:
            if (r1 != 0) goto L_0x002e
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0035 }
            boolean r1 = r2 instanceof androidx.work.a.b     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0026
            r1 = r2
            androidx.work.a$b r1 = (androidx.work.a.b) r1     // Catch:{ all -> 0x0035 }
            androidx.work.a r1 = r1.a()     // Catch:{ all -> 0x0035 }
            f(r2, r1)     // Catch:{ all -> 0x0035 }
            VD r1 = e(r2)     // Catch:{ all -> 0x0035 }
            goto L_0x002e
        L_0x0026:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0035 }
            java.lang.String r1 = "WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider."
            r2.<init>(r1)     // Catch:{ all -> 0x0035 }
            throw r2     // Catch:{ all -> 0x0035 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r1
        L_0x0030:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r2     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r2
        L_0x0035:
            r2 = move-exception
            goto L_0x0033
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.VD.e(android.content.Context):VD");
    }

    public static void f(Context context, androidx.work.a aVar) {
        synchronized (f590a) {
            VD vd = a;
            if (vd != null) {
                if (b != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            }
            if (vd == null) {
                Context applicationContext = context.getApplicationContext();
                if (b == null) {
                    b = new VD(applicationContext, aVar, new WD(aVar.f2651b));
                }
                a = b;
            }
        }
    }

    public final io d(List list) {
        if (!list.isEmpty()) {
            ND nd = new ND(this, list);
            if (!nd.f446a) {
                Fa fa = new Fa(nd);
                this.f595a.c(fa);
                nd.f442a = fa.f203a;
            } else {
                zi c = zi.c();
                String.format("Already enqueued work ids (%s)", new Object[]{TextUtils.join(", ", nd.f444a)});
                c.f(new Throwable[0]);
            }
            return nd.f442a;
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public final void g() {
        synchronized (f590a) {
            this.f599a = true;
            BroadcastReceiver.PendingResult pendingResult = this.f591a;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f591a = null;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void h() {
        ArrayList e;
        Context context = this.f592a;
        int i = ez.c;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (!(jobScheduler == null || (e = ez.e(context, jobScheduler)) == null || e.isEmpty())) {
            Iterator it = e.iterator();
            while (it.hasNext()) {
                ez.a(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        C0236jE jEVar = (C0236jE) this.f594a.n();
        Zt zt = jEVar.a;
        zt.b();
        C0236jE.h hVar = jEVar.f3032a;
        C0085Cd a2 = hVar.a();
        zt.c();
        try {
            a2.j();
            zt.h();
            zt.f();
            hVar.c(a2);
            jv.a(this.f593a, this.f594a, this.f597a);
        } catch (Throwable th) {
            zt.f();
            hVar.c(a2);
            throw th;
        }
    }
}
