package defpackage;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.internal.util.SubscriptionList;

/* renamed from: ev  reason: default package and case insensitive filesystem */
/* compiled from: ScheduledAction */
public final class C1096ev extends AtomicReference<Thread> implements Runnable, Subscription {
    private static final long serialVersionUID = -3962399486978279857L;
    public final C a;

    /* renamed from: a  reason: collision with other field name */
    public final SubscriptionList f5457a;

    /* renamed from: ev$a */
    /* compiled from: ScheduledAction */
    public final class a implements Subscription {

        /* renamed from: a  reason: collision with other field name */
        public final Future<?> f5458a;

        public a(Future<?> future) {
            this.f5458a = future;
        }

        public final boolean isUnsubscribed() {
            return this.f5458a.isCancelled();
        }

        public final void unsubscribe() {
            Object obj = C1096ev.this.get();
            Thread currentThread = Thread.currentThread();
            Future<?> future = this.f5458a;
            if (obj != currentThread) {
                future.cancel(true);
            } else {
                future.cancel(false);
            }
        }
    }

    /* renamed from: ev$b */
    /* compiled from: ScheduledAction */
    public static final class b extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        public final C1096ev a;

        /* renamed from: a  reason: collision with other field name */
        public final SubscriptionList f5459a;

        public b(C1096ev evVar, SubscriptionList subscriptionList) {
            this.a = evVar;
            this.f5459a = subscriptionList;
        }

        public final boolean isUnsubscribed() {
            return this.a.f5457a.f6949a;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
            if (r2 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            r1.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void unsubscribe() {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                boolean r0 = r4.compareAndSet(r0, r1)
                if (r0 == 0) goto L_0x002a
                rx.internal.util.SubscriptionList r0 = r4.f5459a
                ev r1 = r4.a
                boolean r2 = r0.f6949a
                if (r2 != 0) goto L_0x002a
                monitor-enter(r0)
                java.util.LinkedList r2 = r0.a     // Catch:{ all -> 0x0027 }
                boolean r3 = r0.f6949a     // Catch:{ all -> 0x0027 }
                if (r3 != 0) goto L_0x0025
                if (r2 != 0) goto L_0x001a
                goto L_0x0025
            L_0x001a:
                boolean r2 = r2.remove(r1)     // Catch:{ all -> 0x0027 }
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                if (r2 == 0) goto L_0x002a
                r1.unsubscribe()
                goto L_0x002a
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                goto L_0x002a
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                throw r1
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C1096ev.b.unsubscribe():void");
        }
    }

    /* renamed from: ev$c */
    /* compiled from: ScheduledAction */
    public static final class c extends AtomicBoolean implements Subscription {
        private static final long serialVersionUID = 247232374289553518L;
        public final C1096ev a;

        /* renamed from: a  reason: collision with other field name */
        public final C1210k6 f5460a;

        public c(C1096ev evVar, C1210k6 k6Var) {
            this.a = evVar;
            this.f5460a = k6Var;
        }

        public final boolean isUnsubscribed() {
            return this.a.f5457a.f6949a;
        }

        public final void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f5460a.b(this.a);
            }
        }
    }

    public C1096ev(C c2) {
        this.a = c2;
        this.f5457a = new SubscriptionList();
    }

    public final boolean isUnsubscribed() {
        return this.f5457a.f6949a;
    }

    public final void run() {
        try {
            lazySet(Thread.currentThread());
            this.a.a();
        } catch (Qn e) {
            IllegalStateException illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e);
            C1520zu.a(illegalStateException);
            Thread currentThread = Thread.currentThread();
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
        } catch (Throwable th) {
            unsubscribe();
            throw th;
        }
        unsubscribe();
    }

    public final void unsubscribe() {
        if (!this.f5457a.f6949a) {
            this.f5457a.unsubscribe();
        }
    }

    public C1096ev(C c2, SubscriptionList subscriptionList) {
        this.a = c2;
        this.f5457a = new SubscriptionList(new b(this, subscriptionList));
    }
}
