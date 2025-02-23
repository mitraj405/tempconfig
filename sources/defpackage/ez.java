package defpackage;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.work.impl.background.systemjob.SystemJobService;
import defpackage.C0141b7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* renamed from: ez  reason: default package */
/* compiled from: SystemJobScheduler */
public final class ez implements fv {
    public static final /* synthetic */ int c = 0;
    public final VD a;

    /* renamed from: a  reason: collision with other field name */
    public final JobScheduler f2920a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2921a;

    /* renamed from: a  reason: collision with other field name */
    public final dz f2922a;

    static {
        zi.e("SystemJobScheduler");
    }

    public ez(Context context, VD vd) {
        dz dzVar = new dz(context);
        this.f2921a = context;
        this.a = vd;
        this.f2920a = (JobScheduler) context.getSystemService("jobscheduler");
        this.f2922a = dzVar;
    }

    public static void a(JobScheduler jobScheduler, int i) {
        try {
            jobScheduler.cancel(i);
        } catch (Throwable th) {
            zi c2 = zi.c();
            String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(i)});
            c2.b(th);
        }
    }

    public static ArrayList e(Context context, JobScheduler jobScheduler) {
        List<JobInfo> list;
        try {
            list = jobScheduler.getAllPendingJobs();
        } catch (Throwable th) {
            zi.c().b(th);
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        ComponentName componentName = new ComponentName(context, SystemJobService.class);
        for (JobInfo next : list) {
            if (componentName.equals(next.getService())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public final boolean b() {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0016 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.f2921a
            android.app.job.JobScheduler r1 = r8.f2920a
            java.util.ArrayList r0 = e(r0, r1)
            r2 = 0
            if (r0 != 0) goto L_0x000c
            goto L_0x0049
        L_0x000c:
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 2
            r3.<init>(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0048
            java.lang.Object r4 = r0.next()
            android.app.job.JobInfo r4 = (android.app.job.JobInfo) r4
            java.lang.String r5 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r6 = r4.getExtras()
            if (r6 == 0) goto L_0x0035
            boolean r7 = r6.containsKey(r5)     // Catch:{ NullPointerException -> 0x0035 }
            if (r7 == 0) goto L_0x0035
            java.lang.String r5 = r6.getString(r5)     // Catch:{ NullPointerException -> 0x0035 }
            goto L_0x0036
        L_0x0035:
            r5 = r2
        L_0x0036:
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x0016
            int r4 = r4.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.add(r4)
            goto L_0x0016
        L_0x0048:
            r2 = r3
        L_0x0049:
            if (r2 == 0) goto L_0x0076
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x0076
            java.util.Iterator r0 = r2.iterator()
        L_0x0055:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0069
            java.lang.Object r2 = r0.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            a(r1, r2)
            goto L_0x0055
        L_0x0069:
            VD r0 = r8.a
            androidx.work.impl.WorkDatabase r0 = r0.f594a
            az r0 = r0.k()
            bz r0 = (defpackage.bz) r0
            r0.b(r9)
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ez.c(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dd, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(defpackage.C0214hE... r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            VD r2 = r1.a
            androidx.work.impl.WorkDatabase r3 = r2.f594a
            int r4 = r0.length
            r5 = 0
            r6 = r5
        L_0x000b:
            if (r6 >= r4) goto L_0x00f9
            r7 = r0[r6]
            r3.c()
            iE r8 = r3.n()     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = r7.f2991a     // Catch:{ all -> 0x00f4 }
            jE r8 = (defpackage.C0236jE) r8     // Catch:{ all -> 0x00f4 }
            hE r8 = r8.i(r9)     // Catch:{ all -> 0x00f4 }
            if (r8 != 0) goto L_0x0030
            zi r7 = defpackage.zi.c()     // Catch:{ all -> 0x00f4 }
            java.lang.Throwable[] r8 = new java.lang.Throwable[r5]     // Catch:{ all -> 0x00f4 }
            r7.f(r8)     // Catch:{ all -> 0x00f4 }
            r3.h()     // Catch:{ all -> 0x00f4 }
        L_0x002c:
            r16 = r6
            goto L_0x00e4
        L_0x0030:
            UD r8 = r8.f2989a     // Catch:{ all -> 0x00f4 }
            UD r9 = defpackage.UD.ENQUEUED     // Catch:{ all -> 0x00f4 }
            if (r8 == r9) goto L_0x0043
            zi r7 = defpackage.zi.c()     // Catch:{ all -> 0x00f4 }
            java.lang.Throwable[] r8 = new java.lang.Throwable[r5]     // Catch:{ all -> 0x00f4 }
            r7.f(r8)     // Catch:{ all -> 0x00f4 }
            r3.h()     // Catch:{ all -> 0x00f4 }
            goto L_0x002c
        L_0x0043:
            az r8 = r3.k()     // Catch:{ all -> 0x00f4 }
            java.lang.String r9 = r7.f2991a     // Catch:{ all -> 0x00f4 }
            bz r8 = (defpackage.bz) r8     // Catch:{ all -> 0x00f4 }
            Zy r8 = r8.a(r9)     // Catch:{ all -> 0x00f4 }
            if (r8 == 0) goto L_0x0056
            int r9 = r8.a     // Catch:{ all -> 0x00f4 }
            r16 = r6
            goto L_0x00b4
        L_0x0056:
            androidx.work.a r9 = r2.f593a     // Catch:{ all -> 0x00f4 }
            r9.getClass()     // Catch:{ all -> 0x00f4 }
            androidx.work.a r9 = r2.f593a     // Catch:{ all -> 0x00f4 }
            int r9 = r9.b     // Catch:{ all -> 0x00f4 }
            java.lang.Class<rf> r10 = defpackage.rf.class
            monitor-enter(r10)     // Catch:{ all -> 0x00f4 }
            java.lang.String r11 = "next_job_scheduler_id"
            r3.c()     // Catch:{ all -> 0x00f1 }
            Zp r12 = r3.j()     // Catch:{ all -> 0x00ec }
            aq r12 = (defpackage.C0137aq) r12     // Catch:{ all -> 0x00ec }
            java.lang.Long r12 = r12.a(r11)     // Catch:{ all -> 0x00ec }
            if (r12 == 0) goto L_0x0078
            int r12 = r12.intValue()     // Catch:{ all -> 0x00ec }
            goto L_0x0079
        L_0x0078:
            r12 = r5
        L_0x0079:
            r13 = 2147483647(0x7fffffff, float:NaN)
            if (r12 != r13) goto L_0x0080
            r13 = r5
            goto L_0x0082
        L_0x0080:
            int r13 = r12 + 1
        L_0x0082:
            Zp r14 = r3.j()     // Catch:{ all -> 0x00ec }
            Yp r15 = new Yp     // Catch:{ all -> 0x00ec }
            r16 = r6
            long r5 = (long) r13     // Catch:{ all -> 0x00ec }
            r15.<init>(r11, r5)     // Catch:{ all -> 0x00ec }
            aq r14 = (defpackage.C0137aq) r14     // Catch:{ all -> 0x00ec }
            r14.b(r15)     // Catch:{ all -> 0x00ec }
            r3.h()     // Catch:{ all -> 0x00ec }
            r3.f()     // Catch:{ all -> 0x00f1 }
            if (r12 < 0) goto L_0x00a0
            if (r12 <= r9) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r9 = r12
            goto L_0x00b3
        L_0x00a0:
            java.lang.String r5 = "next_job_scheduler_id"
            Zp r6 = r3.j()     // Catch:{ all -> 0x00f1 }
            Yp r9 = new Yp     // Catch:{ all -> 0x00f1 }
            r11 = 1
            long r11 = (long) r11     // Catch:{ all -> 0x00f1 }
            r9.<init>(r5, r11)     // Catch:{ all -> 0x00f1 }
            aq r6 = (defpackage.C0137aq) r6     // Catch:{ all -> 0x00f1 }
            r6.b(r9)     // Catch:{ all -> 0x00f1 }
            r9 = 0
        L_0x00b3:
            monitor-exit(r10)     // Catch:{ all -> 0x00f1 }
        L_0x00b4:
            if (r8 != 0) goto L_0x00de
            Zy r5 = new Zy     // Catch:{ all -> 0x00f4 }
            java.lang.String r6 = r7.f2991a     // Catch:{ all -> 0x00f4 }
            r5.<init>(r6, r9)     // Catch:{ all -> 0x00f4 }
            androidx.work.impl.WorkDatabase r6 = r2.f594a     // Catch:{ all -> 0x00f4 }
            az r6 = r6.k()     // Catch:{ all -> 0x00f4 }
            bz r6 = (defpackage.bz) r6     // Catch:{ all -> 0x00f4 }
            Zt r8 = r6.a     // Catch:{ all -> 0x00f4 }
            r8.b()     // Catch:{ all -> 0x00f4 }
            r8.c()     // Catch:{ all -> 0x00f4 }
            bz$a r6 = r6.f2750a     // Catch:{ all -> 0x00d9 }
            r6.e(r5)     // Catch:{ all -> 0x00d9 }
            r8.h()     // Catch:{ all -> 0x00d9 }
            r8.f()     // Catch:{ all -> 0x00f4 }
            goto L_0x00de
        L_0x00d9:
            r0 = move-exception
            r8.f()     // Catch:{ all -> 0x00f4 }
            throw r0     // Catch:{ all -> 0x00f4 }
        L_0x00de:
            r1.f(r7, r9)     // Catch:{ all -> 0x00f4 }
            r3.h()     // Catch:{ all -> 0x00f4 }
        L_0x00e4:
            r3.f()
            int r6 = r16 + 1
            r5 = 0
            goto L_0x000b
        L_0x00ec:
            r0 = move-exception
            r3.f()     // Catch:{ all -> 0x00f1 }
            throw r0     // Catch:{ all -> 0x00f1 }
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00f1 }
            throw r0     // Catch:{ all -> 0x00f4 }
        L_0x00f4:
            r0 = move-exception
            r3.f()
            throw r0
        L_0x00f9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ez.d(hE[]):void");
    }

    public final void f(C0214hE hEVar, int i) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        C0214hE hEVar2 = hEVar;
        JobScheduler jobScheduler = this.f2920a;
        dz dzVar = this.f2922a;
        dzVar.getClass();
        T6 t6 = hEVar2.f2988a;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("EXTRA_WORK_SPEC_ID", hEVar2.f2991a);
        persistableBundle.putBoolean("EXTRA_IS_PERIODIC", hEVar.c());
        JobInfo.Builder extras = new JobInfo.Builder(i, dzVar.f2879a).setRequiresCharging(t6.f541a).setRequiresDeviceIdle(t6.f542b).setExtras(persistableBundle);
        Em em = t6.f539a;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 30 || em != Em.TEMPORARILY_UNMETERED) {
            int ordinal = em.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        i4 = 2;
                    } else if (ordinal != 3) {
                        i4 = 4;
                        if (ordinal != 4) {
                            zi c2 = zi.c();
                            String.format("API version too low. Cannot convert network type value %s", new Object[]{em});
                            int i6 = dz.a;
                            c2.a(new Throwable[0]);
                        }
                    } else {
                        i4 = 3;
                    }
                }
                i4 = 1;
            } else {
                i4 = 0;
            }
            extras.setRequiredNetworkType(i4);
        } else {
            extras.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
        if (!t6.f542b) {
            if (hEVar2.b == 2) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            extras.setBackoffCriteria(hEVar2.d, i3);
        }
        long max = Math.max(hEVar.a() - System.currentTimeMillis(), 0);
        if (i5 <= 28) {
            extras.setMinimumLatency(max);
        } else if (max > 0) {
            extras.setMinimumLatency(max);
        } else if (!hEVar2.f2992a) {
            extras.setImportantWhileForeground(true);
        }
        if (t6.f540a.a.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Iterator it = t6.f540a.a.iterator();
            while (it.hasNext()) {
                C0141b7.a aVar = (C0141b7.a) it.next();
                extras.addTriggerContentUri(new JobInfo.TriggerContentUri(aVar.a, aVar.f2730a ? 1 : 0));
            }
            extras.setTriggerContentUpdateDelay(t6.f538a);
            extras.setTriggerContentMaxDelay(t6.b);
        }
        extras.setPersisted(false);
        extras.setRequiresBatteryNotLow(t6.c);
        extras.setRequiresStorageNotLow(t6.d);
        if (hEVar2.a > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (s3.b() && hEVar2.f2992a && !z2) {
            extras.setExpedited(true);
        }
        JobInfo build = extras.build();
        zi c3 = zi.c();
        String.format("Scheduling work ID %s Job ID %s", new Object[]{hEVar2.f2991a, Integer.valueOf(i)});
        c3.a(new Throwable[0]);
        try {
            if (jobScheduler.schedule(build) == 0) {
                zi c4 = zi.c();
                String.format("Unable to schedule work ID %s", new Object[]{hEVar2.f2991a});
                c4.f(new Throwable[0]);
                if (hEVar2.f2992a && hEVar2.c == 1) {
                    hEVar2.f2992a = false;
                    String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{hEVar2.f2991a});
                    zi.c().a(new Throwable[0]);
                    f(hEVar, i);
                }
            }
        } catch (IllegalStateException e) {
            ArrayList e2 = e(this.f2921a, jobScheduler);
            if (e2 != null) {
                i2 = e2.size();
            } else {
                i2 = 0;
            }
            Locale locale = Locale.getDefault();
            VD vd = this.a;
            String format = String.format(locale, "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(i2), Integer.valueOf(((C0236jE) vd.f594a.n()).e().size()), Integer.valueOf(vd.f593a.c)});
            zi.c().b(new Throwable[0]);
            throw new IllegalStateException(format, e);
        } catch (Throwable th) {
            zi c5 = zi.c();
            String.format("Unable to schedule %s", new Object[]{hEVar2});
            c5.b(th);
        }
    }
}
