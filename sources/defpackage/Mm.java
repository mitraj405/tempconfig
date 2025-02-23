package defpackage;

import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* renamed from: Mm  reason: default package */
/* compiled from: NewThreadWorker */
public final class Mm implements Runnable {
    public final void run() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = Nm.f3715a.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            C1354qp.D0(th);
            C1520zu.a(th);
        }
    }
}
