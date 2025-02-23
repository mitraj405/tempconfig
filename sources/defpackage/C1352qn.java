package defpackage;

import com.momagic.C0835h;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: qn  reason: default package and case insensitive filesystem */
/* compiled from: OSTaskManager */
public final class C1352qn {
    public static final HashSet<String> a = new HashSet<>(Arrays.asList(new String[]{"addUserProperty()", "addEvent()", "setSubscription()", "setFirebaseAnalytics()", "addTag()", "removeTag()", "setCustomTemplate()", "setSubscriberID()"}));

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentLinkedQueue<Runnable> f6905a = new ConcurrentLinkedQueue<>();

    /* renamed from: a  reason: collision with other field name */
    public ExecutorService f6906a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicLong f6907a = new AtomicLong();

    /* renamed from: qn$a */
    /* compiled from: OSTaskManager */
    public static class a implements Runnable {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public final Runnable f6908a;

        /* renamed from: a  reason: collision with other field name */
        public final C1352qn f6909a;

        public a(C1352qn qnVar, Runnable runnable) {
            this.f6909a = qnVar;
            this.f6908a = runnable;
        }

        public final void run() {
            this.f6908a.run();
            long j = this.a;
            C1352qn qnVar = this.f6909a;
            if (qnVar.f6907a.get() == j) {
                qnVar.f6906a.shutdown();
            }
        }

        public final String toString() {
            return "PendingTaskRunnable{innerTask=" + this.f6908a + ", taskId=" + this.a + '}';
        }
    }

    public static boolean b(String str) {
        if (C0835h.b != null || !a.contains(str)) {
            return false;
        }
        return true;
    }

    public final void a(Runnable runnable) {
        a aVar = new a(this, runnable);
        aVar.a = this.f6907a.incrementAndGet();
        ExecutorService executorService = this.f6906a;
        if (executorService == null) {
            this.f6905a.add(aVar);
        } else if (!executorService.isShutdown()) {
            try {
                this.f6906a.submit(aVar);
            } catch (RejectedExecutionException e) {
                aVar.run();
                e.printStackTrace();
            }
        }
    }
}
