package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import java.util.HashMap;

public class SystemJobService extends JobService implements rb {
    public VD a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f2688a = new HashMap();

    static {
        zi.e("SystemJobService");
    }

    public final void e(String str, boolean z) {
        JobParameters jobParameters;
        zi c = zi.c();
        String.format("%s executed on JobScheduler", new Object[]{str});
        c.a(new Throwable[0]);
        synchronized (this.f2688a) {
            jobParameters = (JobParameters) this.f2688a.remove(str);
        }
        if (jobParameters != null) {
            jobFinished(jobParameters, z);
        }
    }

    public final void onCreate() {
        super.onCreate();
        try {
            VD e = VD.e(getApplicationContext());
            this.a = e;
            e.f598a.a(this);
        } catch (IllegalStateException unused) {
            if (Application.class.equals(getApplication().getClass())) {
                zi.c().f(new Throwable[0]);
                return;
            }
            throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        VD vd = this.a;
        if (vd != null) {
            wq wqVar = vd.f598a;
            synchronized (wqVar.f3398a) {
                wqVar.f3399a.remove(this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006e, code lost:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = new androidx.work.WorkerParameters.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0079, code lost:
        if (r8.getTriggeredContentUris() == null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007b, code lost:
        r3.b = java.util.Arrays.asList(r8.getTriggeredContentUris());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        if (r8.getTriggeredContentAuthorities() == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008b, code lost:
        r3.f2646a = java.util.Arrays.asList(r8.getTriggeredContentAuthorities());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        if (r2 < 28) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0099, code lost:
        r3.a = r8.getNetwork();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        r8 = r7.a;
        r8.f595a.c(new defpackage.Ox(r8, r0, r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onStartJob(android.app.job.JobParameters r8) {
        /*
            r7 = this;
            VD r0 = r7.a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0013
            zi r0 = defpackage.zi.c()
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r0.a(r3)
            r7.jobFinished(r8, r1)
            return r2
        L_0x0013:
            java.lang.String r0 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r3 = r8.getExtras()     // Catch:{ NullPointerException -> 0x0026 }
            if (r3 == 0) goto L_0x0026
            boolean r4 = r3.containsKey(r0)     // Catch:{ NullPointerException -> 0x0026 }
            if (r4 == 0) goto L_0x0026
            java.lang.String r0 = r3.getString(r0)     // Catch:{ NullPointerException -> 0x0026 }
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0037
            zi r8 = defpackage.zi.c()
            java.lang.Throwable[] r0 = new java.lang.Throwable[r2]
            r8.b(r0)
            return r2
        L_0x0037:
            java.util.HashMap r3 = r7.f2688a
            monitor-enter(r3)
            java.util.HashMap r4 = r7.f2688a     // Catch:{ all -> 0x00ac }
            boolean r4 = r4.containsKey(r0)     // Catch:{ all -> 0x00ac }
            if (r4 == 0) goto L_0x0056
            zi r8 = defpackage.zi.c()     // Catch:{ all -> 0x00ac }
            java.lang.String r4 = "Job is already being executed by SystemJobService: %s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00ac }
            r1[r2] = r0     // Catch:{ all -> 0x00ac }
            java.lang.String.format(r4, r1)     // Catch:{ all -> 0x00ac }
            java.lang.Throwable[] r0 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00ac }
            r8.a(r0)     // Catch:{ all -> 0x00ac }
            monitor-exit(r3)     // Catch:{ all -> 0x00ac }
            return r2
        L_0x0056:
            zi r4 = defpackage.zi.c()     // Catch:{ all -> 0x00ac }
            java.lang.String r5 = "onStartJob for %s"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ all -> 0x00ac }
            r6[r2] = r0     // Catch:{ all -> 0x00ac }
            java.lang.String.format(r5, r6)     // Catch:{ all -> 0x00ac }
            java.lang.Throwable[] r2 = new java.lang.Throwable[r2]     // Catch:{ all -> 0x00ac }
            r4.a(r2)     // Catch:{ all -> 0x00ac }
            java.util.HashMap r2 = r7.f2688a     // Catch:{ all -> 0x00ac }
            r2.put(r0, r8)     // Catch:{ all -> 0x00ac }
            monitor-exit(r3)     // Catch:{ all -> 0x00ac }
            int r2 = android.os.Build.VERSION.SDK_INT
            androidx.work.WorkerParameters$a r3 = new androidx.work.WorkerParameters$a
            r3.<init>()
            android.net.Uri[] r4 = r8.getTriggeredContentUris()
            if (r4 == 0) goto L_0x0085
            android.net.Uri[] r4 = r8.getTriggeredContentUris()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.b = r4
        L_0x0085:
            java.lang.String[] r4 = r8.getTriggeredContentAuthorities()
            if (r4 == 0) goto L_0x0095
            java.lang.String[] r4 = r8.getTriggeredContentAuthorities()
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.f2646a = r4
        L_0x0095:
            r4 = 28
            if (r2 < r4) goto L_0x009f
            android.net.Network r8 = r8.getNetwork()
            r3.a = r8
        L_0x009f:
            VD r8 = r7.a
            androidx.work.impl.utils.taskexecutor.TaskExecutor r2 = r8.f595a
            Ox r4 = new Ox
            r4.<init>(r8, r0, r3)
            r2.c(r4)
            return r1
        L_0x00ac:
            r8 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ac }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStartJob(android.app.job.JobParameters):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onStopJob(android.app.job.JobParameters r6) {
        /*
            r5 = this;
            VD r0 = r5.a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0010
            zi r6 = defpackage.zi.c()
            java.lang.Throwable[] r0 = new java.lang.Throwable[r2]
            r6.a(r0)
            return r1
        L_0x0010:
            java.lang.String r0 = "EXTRA_WORK_SPEC_ID"
            android.os.PersistableBundle r6 = r6.getExtras()     // Catch:{ NullPointerException -> 0x0023 }
            if (r6 == 0) goto L_0x0023
            boolean r3 = r6.containsKey(r0)     // Catch:{ NullPointerException -> 0x0023 }
            if (r3 == 0) goto L_0x0023
            java.lang.String r6 = r6.getString(r0)     // Catch:{ NullPointerException -> 0x0023 }
            goto L_0x0024
        L_0x0023:
            r6 = 0
        L_0x0024:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x0034
            zi r6 = defpackage.zi.c()
            java.lang.Throwable[] r0 = new java.lang.Throwable[r2]
            r6.b(r0)
            return r2
        L_0x0034:
            zi r0 = defpackage.zi.c()
            java.lang.String r3 = "onStopJob for %s"
            java.lang.Object[] r4 = new java.lang.Object[r1]
            r4[r2] = r6
            java.lang.String.format(r3, r4)
            java.lang.Throwable[] r3 = new java.lang.Throwable[r2]
            r0.a(r3)
            java.util.HashMap r0 = r5.f2688a
            monitor-enter(r0)
            java.util.HashMap r3 = r5.f2688a     // Catch:{ all -> 0x006e }
            r3.remove(r6)     // Catch:{ all -> 0x006e }
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            VD r0 = r5.a
            androidx.work.impl.utils.taskexecutor.TaskExecutor r3 = r0.f595a
            ey r4 = new ey
            r4.<init>(r0, r6, r2)
            r3.c(r4)
            VD r0 = r5.a
            wq r0 = r0.f598a
            java.lang.Object r2 = r0.f3398a
            monitor-enter(r2)
            java.util.HashSet r0 = r0.f3401a     // Catch:{ all -> 0x006b }
            boolean r6 = r0.contains(r6)     // Catch:{ all -> 0x006b }
            monitor-exit(r2)     // Catch:{ all -> 0x006b }
            r6 = r6 ^ r1
            return r6
        L_0x006b:
            r6 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x006b }
            throw r6
        L_0x006e:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006e }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobService.onStopJob(android.app.job.JobParameters):boolean");
    }
}
