package defpackage;

import defpackage.C1096ev;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;

/* renamed from: z3  reason: default package and case insensitive filesystem */
/* compiled from: CachedThreadScheduler */
public final class C1509z3 extends Scheduler implements C1162hv {
    public static final long a = ((long) Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue());

    /* renamed from: a  reason: collision with other field name */
    public static final TimeUnit f7079a = TimeUnit.SECONDS;

    /* renamed from: a  reason: collision with other field name */
    public static final a f7080a;

    /* renamed from: a  reason: collision with other field name */
    public static final c f7081a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicReference<a> f7082a;

    /* renamed from: z3$a */
    /* compiled from: CachedThreadScheduler */
    public static final class a {
        public final long a;

        /* renamed from: a  reason: collision with other field name */
        public final ConcurrentLinkedQueue<c> f7083a;

        /* renamed from: a  reason: collision with other field name */
        public final ScheduledExecutorService f7084a;

        /* renamed from: a  reason: collision with other field name */
        public final ScheduledFuture f7085a;

        /* renamed from: a  reason: collision with other field name */
        public final ThreadFactory f7086a;

        /* renamed from: a  reason: collision with other field name */
        public final C1210k6 f7087a;

        /* renamed from: z3$a$a  reason: collision with other inner class name */
        /* compiled from: CachedThreadScheduler */
        public class C0079a implements ThreadFactory {
            public final /* synthetic */ ThreadFactory a;

            public C0079a(ThreadFactory threadFactory) {
                this.a = threadFactory;
            }

            public final Thread newThread(Runnable runnable) {
                Thread newThread = this.a.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* renamed from: z3$a$b */
        /* compiled from: CachedThreadScheduler */
        public class b implements Runnable {
            public b() {
            }

            public final void run() {
                a aVar = a.this;
                ConcurrentLinkedQueue<c> concurrentLinkedQueue = aVar.f7083a;
                if (!concurrentLinkedQueue.isEmpty()) {
                    long nanoTime = System.nanoTime();
                    Iterator<c> it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        c next = it.next();
                        if (next.a > nanoTime) {
                            return;
                        }
                        if (concurrentLinkedQueue.remove(next)) {
                            aVar.f7087a.b(next);
                        }
                    }
                }
            }
        }

        public a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            long j2;
            ScheduledFuture<?> scheduledFuture;
            ScheduledExecutorService scheduledExecutorService;
            this.f7086a = threadFactory;
            if (timeUnit != null) {
                j2 = timeUnit.toNanos(j);
            } else {
                j2 = 0;
            }
            long j3 = j2;
            this.a = j3;
            this.f7083a = new ConcurrentLinkedQueue<>();
            this.f7087a = new C1210k6();
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new C0079a(threadFactory));
                Nm.e(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new b(), j3, j3, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.f7084a = scheduledExecutorService;
            this.f7085a = scheduledFuture;
        }

        public final void a() {
            C1210k6 k6Var = this.f7087a;
            try {
                ScheduledFuture scheduledFuture = this.f7085a;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f7084a;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                k6Var.unsubscribe();
            }
        }
    }

    /* renamed from: z3$b */
    /* compiled from: CachedThreadScheduler */
    public static final class b extends Scheduler.a implements C {
        public final AtomicBoolean a;

        /* renamed from: a  reason: collision with other field name */
        public final C1210k6 f7088a = new C1210k6();

        /* renamed from: a  reason: collision with other field name */
        public final a f7089a;

        /* renamed from: a  reason: collision with other field name */
        public final c f7090a;

        public b(a aVar) {
            c cVar;
            c cVar2;
            this.f7089a = aVar;
            this.a = new AtomicBoolean();
            if (aVar.f7087a.f5543a) {
                cVar = C1509z3.f7081a;
            } else {
                while (true) {
                    if (aVar.f7083a.isEmpty()) {
                        cVar2 = new c(aVar.f7086a);
                        aVar.f7087a.a(cVar2);
                        break;
                    }
                    cVar2 = aVar.f7083a.poll();
                    if (cVar2 != null) {
                        break;
                    }
                }
                cVar = cVar2;
            }
            this.f7090a = cVar;
        }

        public final void a() {
            a aVar = this.f7089a;
            aVar.getClass();
            long nanoTime = System.nanoTime() + aVar.a;
            c cVar = this.f7090a;
            cVar.a = nanoTime;
            aVar.f7083a.offer(cVar);
        }

        public final Subscription b(C c) {
            if (this.f7088a.f5543a) {
                return C0455Ay.a;
            }
            C1096ev d = this.f7090a.d(new A3(this, c), 0, (TimeUnit) null);
            this.f7088a.a(d);
            d.f5457a.a(new C1096ev.c(d, this.f7088a));
            return d;
        }

        public final boolean isUnsubscribed() {
            return this.f7088a.f5543a;
        }

        public final void unsubscribe() {
            if (this.a.compareAndSet(false, true)) {
                this.f7090a.b(this);
            }
            this.f7088a.unsubscribe();
        }
    }

    /* renamed from: z3$c */
    /* compiled from: CachedThreadScheduler */
    public static final class c extends Nm {
        public long a = 0;

        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(C0533Hu.a);
        f7081a = cVar;
        cVar.unsubscribe();
        a aVar = new a((ThreadFactory) null, 0, (TimeUnit) null);
        f7080a = aVar;
        aVar.a();
    }

    public C1509z3(C0533Hu hu) {
        boolean z;
        a aVar = f7080a;
        this.f7082a = new AtomicReference<>(aVar);
        a aVar2 = new a(hu, a, f7079a);
        while (true) {
            AtomicReference<a> atomicReference = this.f7082a;
            if (!atomicReference.compareAndSet(aVar, aVar2)) {
                if (atomicReference.get() != aVar) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (!z) {
            aVar2.a();
        }
    }

    public final Scheduler.a a() {
        return new b(this.f7082a.get());
    }

    public final void shutdown() {
        a aVar;
        boolean z;
        do {
            AtomicReference<a> atomicReference = this.f7082a;
            aVar = atomicReference.get();
            a aVar2 = f7080a;
            if (aVar != aVar2) {
                while (true) {
                    if (!atomicReference.compareAndSet(aVar, aVar2)) {
                        if (atomicReference.get() != aVar) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z);
        aVar.a();
    }
}
