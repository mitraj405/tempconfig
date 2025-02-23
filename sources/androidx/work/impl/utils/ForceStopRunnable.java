package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.work.a;
import defpackage.zi;
import java.util.concurrent.TimeUnit;

public final class ForceStopRunnable implements Runnable {
    public static final long a = TimeUnit.DAYS.toMillis(3650);

    /* renamed from: a  reason: collision with other field name */
    public final VD f2701a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2702a;
    public int c = 0;

    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        static {
            zi.e("ForceStopRunnable$Rcvr");
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                int i = ((zi.a) zi.c()).a;
                ForceStopRunnable.c(context);
            }
        }
    }

    static {
        zi.e("ForceStopRunnable");
    }

    public ForceStopRunnable(Context context, VD vd) {
        this.f2702a = context.getApplicationContext();
        this.f2701a = vd;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void c(Context context) {
        int i;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (s3.b()) {
            i = 167772160;
        } else {
            i = 134217728;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent, i);
        long currentTimeMillis = System.currentTimeMillis() + a;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, broadcast);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r16 = this;
            r1 = r16
            int r0 = defpackage.ez.c
            android.content.Context r0 = r1.f2702a
            java.lang.String r2 = "jobscheduler"
            java.lang.Object r2 = r0.getSystemService(r2)
            android.app.job.JobScheduler r2 = (android.app.job.JobScheduler) r2
            java.util.ArrayList r3 = defpackage.ez.e(r0, r2)
            VD r4 = r1.f2701a
            androidx.work.impl.WorkDatabase r5 = r4.f594a
            az r5 = r5.k()
            bz r5 = (defpackage.bz) r5
            r5.getClass()
            r6 = 0
            java.lang.String r7 = "SELECT DISTINCT work_spec_id FROM SystemIdInfo"
            bu r7 = defpackage.bu.c(r6, r7)
            Zt r5 = r5.a
            r5.b()
            android.database.Cursor r5 = r5.g(r7)
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x023d }
            int r9 = r5.getCount()     // Catch:{ all -> 0x023d }
            r8.<init>(r9)     // Catch:{ all -> 0x023d }
        L_0x0038:
            boolean r9 = r5.moveToNext()     // Catch:{ all -> 0x023d }
            if (r9 == 0) goto L_0x0046
            java.lang.String r9 = r5.getString(r6)     // Catch:{ all -> 0x023d }
            r8.add(r9)     // Catch:{ all -> 0x023d }
            goto L_0x0038
        L_0x0046:
            r5.close()
            r7.release()
            if (r3 == 0) goto L_0x0053
            int r5 = r3.size()
            goto L_0x0054
        L_0x0053:
            r5 = r6
        L_0x0054:
            java.util.HashSet r7 = new java.util.HashSet
            r7.<init>(r5)
            if (r3 == 0) goto L_0x0097
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0097
            java.util.Iterator r3 = r3.iterator()
        L_0x0065:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0097
            java.lang.Object r5 = r3.next()
            android.app.job.JobInfo r5 = (android.app.job.JobInfo) r5
            java.lang.String r9 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r10 = r5.getExtras()
            if (r10 == 0) goto L_0x0084
            boolean r11 = r10.containsKey(r9)     // Catch:{ NullPointerException -> 0x0084 }
            if (r11 == 0) goto L_0x0084
            java.lang.String r9 = r10.getString(r9)     // Catch:{ NullPointerException -> 0x0084 }
            goto L_0x0085
        L_0x0084:
            r9 = 0
        L_0x0085:
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 != 0) goto L_0x008f
            r7.add(r9)
            goto L_0x0065
        L_0x008f:
            int r5 = r5.getId()
            defpackage.ez.a(r2, r5)
            goto L_0x0065
        L_0x0097:
            java.util.Iterator r2 = r8.iterator()
        L_0x009b:
            boolean r3 = r2.hasNext()
            r5 = 1
            if (r3 == 0) goto L_0x00bb
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            boolean r3 = r7.contains(r3)
            if (r3 != 0) goto L_0x009b
            zi r2 = defpackage.zi.c()
            java.lang.Throwable[] r3 = new java.lang.Throwable[r6]
            int r7 = defpackage.ez.c
            r2.a(r3)
            r2 = r5
            goto L_0x00bc
        L_0x00bb:
            r2 = r6
        L_0x00bc:
            r9 = -1
            if (r2 == 0) goto L_0x00ec
            androidx.work.impl.WorkDatabase r3 = r4.f594a
            r3.c()
            iE r7 = r3.n()     // Catch:{ all -> 0x00e7 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00e7 }
        L_0x00cd:
            boolean r11 = r8.hasNext()     // Catch:{ all -> 0x00e7 }
            if (r11 == 0) goto L_0x00e0
            java.lang.Object r11 = r8.next()     // Catch:{ all -> 0x00e7 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x00e7 }
            r12 = r7
            jE r12 = (defpackage.C0236jE) r12     // Catch:{ all -> 0x00e7 }
            r12.k(r11, r9)     // Catch:{ all -> 0x00e7 }
            goto L_0x00cd
        L_0x00e0:
            r3.h()     // Catch:{ all -> 0x00e7 }
            r3.f()
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            r3.f()
            throw r0
        L_0x00ec:
            androidx.work.impl.WorkDatabase r3 = r4.f594a
            iE r7 = r3.n()
            bE r8 = r3.m()
            r3.c()
            jE r7 = (defpackage.C0236jE) r7     // Catch:{ all -> 0x0238 }
            java.util.ArrayList r11 = r7.d()     // Catch:{ all -> 0x0238 }
            boolean r12 = r11.isEmpty()     // Catch:{ all -> 0x0238 }
            r12 = r12 ^ r5
            if (r12 == 0) goto L_0x0128
            java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x0238 }
        L_0x010a:
            boolean r13 = r11.hasNext()     // Catch:{ all -> 0x0238 }
            if (r13 == 0) goto L_0x0128
            java.lang.Object r13 = r11.next()     // Catch:{ all -> 0x0238 }
            hE r13 = (defpackage.C0214hE) r13     // Catch:{ all -> 0x0238 }
            UD r14 = defpackage.UD.ENQUEUED     // Catch:{ all -> 0x0238 }
            java.lang.String[] r15 = new java.lang.String[r5]     // Catch:{ all -> 0x0238 }
            java.lang.String r5 = r13.f2991a     // Catch:{ all -> 0x0238 }
            r15[r6] = r5     // Catch:{ all -> 0x0238 }
            r7.n(r14, r15)     // Catch:{ all -> 0x0238 }
            java.lang.String r5 = r13.f2991a     // Catch:{ all -> 0x0238 }
            r7.k(r5, r9)     // Catch:{ all -> 0x0238 }
            r5 = 1
            goto L_0x010a
        L_0x0128:
            cE r8 = (defpackage.C0157cE) r8     // Catch:{ all -> 0x0238 }
            Zt r5 = r8.a     // Catch:{ all -> 0x0238 }
            r5.b()     // Catch:{ all -> 0x0238 }
            cE$c r7 = r8.f2755a     // Catch:{ all -> 0x0238 }
            Cd r8 = r7.a()     // Catch:{ all -> 0x0238 }
            r5.c()     // Catch:{ all -> 0x0238 }
            r8.j()     // Catch:{ all -> 0x0230 }
            r5.h()     // Catch:{ all -> 0x0230 }
            r5.f()     // Catch:{ all -> 0x0238 }
            r7.c(r8)     // Catch:{ all -> 0x0238 }
            r3.h()     // Catch:{ all -> 0x0238 }
            r3.f()
            if (r12 != 0) goto L_0x0151
            if (r2 == 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r2 = r6
            goto L_0x0152
        L_0x0151:
            r2 = 1
        L_0x0152:
            hq r3 = r4.f596a
            androidx.work.impl.WorkDatabase r3 = r3.a
            Zp r3 = r3.j()
            aq r3 = (defpackage.C0137aq) r3
            java.lang.String r5 = "reschedule_needed"
            java.lang.Long r3 = r3.a(r5)
            if (r3 == 0) goto L_0x0170
            long r7 = r3.longValue()
            r9 = 1
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0170
            r3 = 1
            goto L_0x0171
        L_0x0170:
            r3 = r6
        L_0x0171:
            if (r3 == 0) goto L_0x0198
            zi r0 = defpackage.zi.c()
            java.lang.Throwable[] r2 = new java.lang.Throwable[r6]
            r0.a(r2)
            r4.h()
            hq r0 = r4.f596a
            r0.getClass()
            Yp r2 = new Yp
            r3 = 0
            r2.<init>(r5, r3)
            androidx.work.impl.WorkDatabase r0 = r0.a
            Zp r0 = r0.j()
            aq r0 = (defpackage.C0137aq) r0
            r0.b(r2)
            goto L_0x022f
        L_0x0198:
            boolean r3 = defpackage.s3.b()     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            if (r3 == 0) goto L_0x01a1
            r3 = 570425344(0x22000000, float:1.7347235E-18)
            goto L_0x01a3
        L_0x01a1:
            r3 = 536870912(0x20000000, float:1.0842022E-19)
        L_0x01a3:
            android.content.Intent r5 = new android.content.Intent     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            r5.<init>()     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            android.content.ComponentName r7 = new android.content.ComponentName     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            java.lang.Class<androidx.work.impl.utils.ForceStopRunnable$BroadcastReceiver> r8 = androidx.work.impl.utils.ForceStopRunnable.BroadcastReceiver.class
            r7.<init>(r0, r8)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            r5.setComponent(r7)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            java.lang.String r7 = "ACTION_FORCE_STOP_RESCHEDULE"
            r5.setAction(r7)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            r7 = -1
            android.app.PendingIntent r3 = android.app.PendingIntent.getBroadcast(r0, r7, r5, r3)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            int r5 = android.os.Build.VERSION.SDK_INT     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            r7 = 30
            if (r5 < r7) goto L_0x01f4
            if (r3 == 0) goto L_0x01c7
            r3.cancel()     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
        L_0x01c7:
            java.lang.String r3 = "activity"
            java.lang.Object r0 = r0.getSystemService(r3)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            android.app.ActivityManager r0 = (android.app.ActivityManager) r0     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            java.util.List r0 = r0.getHistoricalProcessExitReasons((java.lang.String) null, 0, 0)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            if (r0 == 0) goto L_0x01fb
            boolean r3 = r0.isEmpty()     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            if (r3 != 0) goto L_0x01fb
            r3 = r6
        L_0x01dc:
            int r5 = r0.size()     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            if (r3 >= r5) goto L_0x01fb
            java.lang.Object r5 = r0.get(r3)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            android.app.ApplicationExitInfo r5 = (android.app.ApplicationExitInfo) r5     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            int r5 = r5.getReason()     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
            r7 = 10
            if (r5 != r7) goto L_0x01f1
            goto L_0x01f9
        L_0x01f1:
            int r3 = r3 + 1
            goto L_0x01dc
        L_0x01f4:
            if (r3 != 0) goto L_0x01fb
            c(r0)     // Catch:{ SecurityException -> 0x01ff, IllegalArgumentException -> 0x01fd }
        L_0x01f9:
            r5 = 1
            goto L_0x020c
        L_0x01fb:
            r5 = r6
            goto L_0x020c
        L_0x01fd:
            r0 = move-exception
            goto L_0x0200
        L_0x01ff:
            r0 = move-exception
        L_0x0200:
            zi r3 = defpackage.zi.c()
            r5 = 1
            java.lang.Throwable[] r7 = new java.lang.Throwable[r5]
            r7[r6] = r0
            r3.f(r7)
        L_0x020c:
            if (r5 == 0) goto L_0x021b
            zi r0 = defpackage.zi.c()
            java.lang.Throwable[] r2 = new java.lang.Throwable[r6]
            r0.a(r2)
            r4.h()
            goto L_0x022f
        L_0x021b:
            if (r2 == 0) goto L_0x022f
            zi r0 = defpackage.zi.c()
            java.lang.Throwable[] r2 = new java.lang.Throwable[r6]
            r0.a(r2)
            androidx.work.a r0 = r4.f593a
            androidx.work.impl.WorkDatabase r2 = r4.f594a
            java.util.List<fv> r3 = r4.f597a
            defpackage.jv.a(r0, r2, r3)
        L_0x022f:
            return
        L_0x0230:
            r0 = move-exception
            r5.f()     // Catch:{ all -> 0x0238 }
            r7.c(r8)     // Catch:{ all -> 0x0238 }
            throw r0     // Catch:{ all -> 0x0238 }
        L_0x0238:
            r0 = move-exception
            r3.f()
            throw r0
        L_0x023d:
            r0 = move-exception
            r5.close()
            r7.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.ForceStopRunnable.a():void");
    }

    public final boolean b() {
        a aVar = this.f2701a.f593a;
        aVar.getClass();
        if (TextUtils.isEmpty((CharSequence) null)) {
            zi.c().a(new Throwable[0]);
            return true;
        }
        boolean a2 = vq.a(this.f2702a, aVar);
        zi c2 = zi.c();
        String.format("Is default app process = %s", new Object[]{Boolean.valueOf(a2)});
        c2.a(new Throwable[0]);
        return a2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|8|9|28|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000c */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x000c A[LOOP:0: B:6:0x000c->B:27:0x000c, LOOP_START, SYNTHETIC, Splitter:B:6:0x000c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            VD r0 = r11.f2701a
            boolean r1 = r11.b()     // Catch:{ all -> 0x0072 }
            if (r1 != 0) goto L_0x000c
            r0.g()
            return
        L_0x000c:
            android.content.Context r1 = r11.f2702a     // Catch:{ all -> 0x0072 }
            defpackage.QD.a(r1)     // Catch:{ all -> 0x0072 }
            zi r1 = defpackage.zi.c()     // Catch:{ all -> 0x0072 }
            r2 = 0
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x0072 }
            r1.a(r3)     // Catch:{ all -> 0x0072 }
            r11.a()     // Catch:{ SQLiteCantOpenDatabaseException -> 0x002c, SQLiteDatabaseCorruptException -> 0x002a, SQLiteDatabaseLockedException -> 0x0028, SQLiteTableLockedException -> 0x0026, SQLiteConstraintException -> 0x0024, SQLiteAccessPermException -> 0x0022 }
            r0.g()
            return
        L_0x0022:
            r1 = move-exception
            goto L_0x002d
        L_0x0024:
            r1 = move-exception
            goto L_0x002d
        L_0x0026:
            r1 = move-exception
            goto L_0x002d
        L_0x0028:
            r1 = move-exception
            goto L_0x002d
        L_0x002a:
            r1 = move-exception
            goto L_0x002d
        L_0x002c:
            r1 = move-exception
        L_0x002d:
            int r3 = r11.c     // Catch:{ all -> 0x0072 }
            r4 = 1
            int r3 = r3 + r4
            r11.c = r3     // Catch:{ all -> 0x0072 }
            r5 = 3
            if (r3 >= r5) goto L_0x005a
            long r5 = (long) r3     // Catch:{ all -> 0x0072 }
            r7 = 300(0x12c, double:1.48E-321)
            long r5 = r5 * r7
            zi r3 = defpackage.zi.c()     // Catch:{ all -> 0x0072 }
            java.lang.String r9 = "Retrying after %s"
            java.lang.Object[] r10 = new java.lang.Object[r4]     // Catch:{ all -> 0x0072 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0072 }
            r10[r2] = r5     // Catch:{ all -> 0x0072 }
            java.lang.String.format(r9, r10)     // Catch:{ all -> 0x0072 }
            java.lang.Throwable[] r4 = new java.lang.Throwable[r4]     // Catch:{ all -> 0x0072 }
            r4[r2] = r1     // Catch:{ all -> 0x0072 }
            r3.a(r4)     // Catch:{ all -> 0x0072 }
            int r1 = r11.c     // Catch:{ all -> 0x0072 }
            long r1 = (long) r1
            long r1 = r1 * r7
            java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x000c }
            goto L_0x000c
        L_0x005a:
            java.lang.String r3 = "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store."
            zi r5 = defpackage.zi.c()     // Catch:{ all -> 0x0072 }
            java.lang.Throwable[] r4 = new java.lang.Throwable[r4]     // Catch:{ all -> 0x0072 }
            r4[r2] = r1     // Catch:{ all -> 0x0072 }
            r5.b(r4)     // Catch:{ all -> 0x0072 }
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0072 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0072 }
            androidx.work.a r1 = r0.f593a     // Catch:{ all -> 0x0072 }
            r1.getClass()     // Catch:{ all -> 0x0072 }
            throw r2     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r1 = move-exception
            r0.g()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.ForceStopRunnable.run():void");
    }
}
