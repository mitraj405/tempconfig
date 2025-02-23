package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import java.util.HashMap;

@Deprecated
public abstract class JobIntentService extends Service {
    public a a;

    /* renamed from: a  reason: collision with other field name */
    public b f1729a;

    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x004f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object doInBackground(java.lang.Object[] r5) {
            /*
                r4 = this;
                java.lang.Void[] r5 = (java.lang.Void[]) r5
            L_0x0002:
                androidx.core.app.JobIntentService r5 = androidx.core.app.JobIntentService.this
                androidx.core.app.JobIntentService$b r5 = r5.f1729a
                r5.getClass()
                java.lang.Object r0 = r5.f1731a
                monitor-enter(r0)
                android.app.job.JobParameters r1 = r5.a     // Catch:{ all -> 0x0050 }
                r2 = 0
                if (r1 != 0) goto L_0x0013
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                goto L_0x002d
            L_0x0013:
                android.app.job.JobWorkItem r1 = r1.dequeueWork()     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                if (r1 == 0) goto L_0x002d
                android.content.Intent r0 = r1.getIntent()
                androidx.core.app.JobIntentService r3 = r5.f1730a
                java.lang.ClassLoader r3 = r3.getClassLoader()
                r0.setExtrasClassLoader(r3)
                androidx.core.app.JobIntentService$b$a r0 = new androidx.core.app.JobIntentService$b$a
                r0.<init>(r1)
                goto L_0x002e
            L_0x002d:
                r0 = r2
            L_0x002e:
                if (r0 == 0) goto L_0x004f
                androidx.core.app.JobIntentService r5 = androidx.core.app.JobIntentService.this
                android.app.job.JobWorkItem r1 = r0.a
                r1.getIntent()
                r5.a()
                androidx.core.app.JobIntentService$b r5 = androidx.core.app.JobIntentService.b.this
                java.lang.Object r5 = r5.f1731a
                monitor-enter(r5)
                androidx.core.app.JobIntentService$b r1 = androidx.core.app.JobIntentService.b.this     // Catch:{ all -> 0x004c }
                android.app.job.JobParameters r1 = r1.a     // Catch:{ all -> 0x004c }
                if (r1 == 0) goto L_0x004a
                android.app.job.JobWorkItem r0 = r0.a     // Catch:{ all -> 0x004c }
                r1.completeWork(r0)     // Catch:{ all -> 0x004c }
            L_0x004a:
                monitor-exit(r5)     // Catch:{ all -> 0x004c }
                goto L_0x0002
            L_0x004c:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x004c }
                throw r0
            L_0x004f:
                return r2
            L_0x0050:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.a.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        public final void onCancelled(Object obj) {
            Void voidR = (Void) obj;
            JobIntentService.this.getClass();
        }

        public final void onPostExecute(Object obj) {
            Void voidR = (Void) obj;
            JobIntentService.this.getClass();
        }
    }

    public static final class b extends JobServiceEngine {
        public JobParameters a;

        /* renamed from: a  reason: collision with other field name */
        public final JobIntentService f1730a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f1731a = new Object();

        public final class a {
            public final JobWorkItem a;

            public a(JobWorkItem jobWorkItem) {
                this.a = jobWorkItem;
            }
        }

        public b(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f1730a = jobIntentService;
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            this.a = jobParameters;
            JobIntentService jobIntentService = this.f1730a;
            if (jobIntentService.a != null) {
                return true;
            }
            a aVar = new a();
            jobIntentService.a = aVar;
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            a aVar = this.f1730a.a;
            if (aVar != null) {
                aVar.cancel(false);
            }
            synchronized (this.f1731a) {
                this.a = null;
            }
            return true;
        }
    }

    static {
        new HashMap();
    }

    public abstract void a();

    public final IBinder onBind(Intent intent) {
        b bVar = this.f1729a;
        if (bVar != null) {
            return bVar.getBinder();
        }
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        this.f1729a = new b(this);
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
