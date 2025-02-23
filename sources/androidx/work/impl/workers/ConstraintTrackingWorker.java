package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConstraintTrackingWorker extends ListenableWorker implements LD {
    public static final /* synthetic */ int c = 0;
    public ListenableWorker a;

    /* renamed from: a  reason: collision with other field name */
    public final WorkerParameters f2703a;

    /* renamed from: a  reason: collision with other field name */
    public final SettableFuture<ListenableWorker.Result> f2704a = new SettableFuture<>();

    /* renamed from: a  reason: collision with other field name */
    public final Object f2705a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f2706a = false;

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            ConstraintTrackingWorker constraintTrackingWorker = ConstraintTrackingWorker.this;
            String b = constraintTrackingWorker.getInputData().b("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
            if (TextUtils.isEmpty(b)) {
                zi c = zi.c();
                int i = ConstraintTrackingWorker.c;
                c.b(new Throwable[0]);
                constraintTrackingWorker.f2704a.h(new ListenableWorker.Result.a());
                return;
            }
            ListenableWorker b2 = constraintTrackingWorker.getWorkerFactory().b(constraintTrackingWorker.getApplicationContext(), b, constraintTrackingWorker.f2703a);
            constraintTrackingWorker.a = b2;
            if (b2 == null) {
                zi c2 = zi.c();
                int i2 = ConstraintTrackingWorker.c;
                c2.a(new Throwable[0]);
                constraintTrackingWorker.f2704a.h(new ListenableWorker.Result.a());
                return;
            }
            C0214hE i3 = ((C0236jE) VD.e(constraintTrackingWorker.getApplicationContext()).f594a.n()).i(constraintTrackingWorker.getId().toString());
            if (i3 == null) {
                constraintTrackingWorker.f2704a.h(new ListenableWorker.Result.a());
                return;
            }
            MD md = new MD(constraintTrackingWorker.getApplicationContext(), constraintTrackingWorker.getTaskExecutor(), constraintTrackingWorker);
            md.b(Collections.singletonList(i3));
            if (md.a(constraintTrackingWorker.getId().toString())) {
                zi c3 = zi.c();
                int i4 = ConstraintTrackingWorker.c;
                String.format("Constraints met for delegate %s", new Object[]{b});
                c3.a(new Throwable[0]);
                try {
                    ListenableFuture<ListenableWorker.Result> startWork = constraintTrackingWorker.a.startWork();
                    startWork.addListener(new S6(constraintTrackingWorker, startWork), constraintTrackingWorker.getBackgroundExecutor());
                } catch (Throwable th) {
                    zi c4 = zi.c();
                    int i5 = ConstraintTrackingWorker.c;
                    String.format("Delegated worker %s threw exception in startWork.", new Object[]{b});
                    c4.a(th);
                    synchronized (constraintTrackingWorker.f2705a) {
                        if (constraintTrackingWorker.f2706a) {
                            zi.c().a(new Throwable[0]);
                            constraintTrackingWorker.f2704a.h(new ListenableWorker.Result.b());
                        } else {
                            constraintTrackingWorker.f2704a.h(new ListenableWorker.Result.a());
                        }
                    }
                }
            } else {
                zi c5 = zi.c();
                int i6 = ConstraintTrackingWorker.c;
                String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{b});
                c5.a(new Throwable[0]);
                constraintTrackingWorker.f2704a.h(new ListenableWorker.Result.b());
            }
        }
    }

    static {
        zi.e("ConstraintTrkngWrkr");
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.f2703a = workerParameters;
    }

    public final void f(ArrayList arrayList) {
        zi c2 = zi.c();
        String.format("Constraints changed for %s", new Object[]{arrayList});
        c2.a(new Throwable[0]);
        synchronized (this.f2705a) {
            this.f2706a = true;
        }
    }

    public final TaskExecutor getTaskExecutor() {
        return VD.e(getApplicationContext()).f595a;
    }

    public final boolean isRunInForeground() {
        ListenableWorker listenableWorker = this.a;
        if (listenableWorker == null || !listenableWorker.isRunInForeground()) {
            return false;
        }
        return true;
    }

    public final void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.a;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            this.a.stop();
        }
    }

    public final ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new a());
        return this.f2704a;
    }

    public final void a(List<String> list) {
    }
}
