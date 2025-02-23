package defpackage;

import androidx.work.ListenableWorker;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.ListenableFuture;

/* renamed from: S6  reason: default package */
/* compiled from: ConstraintTrackingWorker */
public final class S6 implements Runnable {
    public final /* synthetic */ ConstraintTrackingWorker a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ListenableFuture f505a;

    public S6(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        this.a = constraintTrackingWorker;
        this.f505a = listenableFuture;
    }

    public final void run() {
        synchronized (this.a.f2705a) {
            if (this.a.f2706a) {
                ConstraintTrackingWorker constraintTrackingWorker = this.a;
                constraintTrackingWorker.getClass();
                constraintTrackingWorker.f2704a.h(new ListenableWorker.Result.b());
            } else {
                this.a.f2704a.j(this.f505a);
            }
        }
    }
}
