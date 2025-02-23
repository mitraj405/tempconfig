package defpackage;

import defpackage.C1096ev;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Subscription;
import rx.internal.util.SubscriptionList;

/* renamed from: ab  reason: default package and case insensitive filesystem */
/* compiled from: EventLoopsScheduler */
public final class C0780ab extends Scheduler implements C1162hv {
    public static final int a;

    /* renamed from: a  reason: collision with other field name */
    public static final b f3897a = new b((ThreadFactory) null, 0);

    /* renamed from: a  reason: collision with other field name */
    public static final c f3898a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicReference<b> f3899a;

    /* renamed from: ab$a */
    /* compiled from: EventLoopsScheduler */
    public static final class a extends Scheduler.a {
        public final c a;

        /* renamed from: a  reason: collision with other field name */
        public final SubscriptionList f3900a;
        public final SubscriptionList b;

        /* renamed from: ab$a$a  reason: collision with other inner class name */
        /* compiled from: EventLoopsScheduler */
        public class C0049a implements C {
            public final /* synthetic */ C a;

            public C0049a(C c) {
                this.a = c;
            }

            public final void a() {
                if (!a.this.b.f6949a) {
                    this.a.a();
                }
            }
        }

        public a(c cVar) {
            SubscriptionList subscriptionList = new SubscriptionList();
            this.f3900a = subscriptionList;
            this.b = new SubscriptionList(subscriptionList, new C1210k6());
            this.a = cVar;
        }

        public final Subscription b(C c) {
            if (this.b.f6949a) {
                return C0455Ay.a;
            }
            c cVar = this.a;
            C0049a aVar = new C0049a(c);
            SubscriptionList subscriptionList = this.f3900a;
            cVar.getClass();
            C1096ev evVar = new C1096ev(C1520zu.c(aVar), subscriptionList);
            subscriptionList.a(evVar);
            evVar.f5457a.a(new C1096ev.a(cVar.f3718a.submit(evVar)));
            return evVar;
        }

        public final boolean isUnsubscribed() {
            return this.b.f6949a;
        }

        public final void unsubscribe() {
            this.b.unsubscribe();
        }
    }

    /* renamed from: ab$b */
    /* compiled from: EventLoopsScheduler */
    public static final class b {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public long f3902a;

        /* renamed from: a  reason: collision with other field name */
        public final c[] f3903a;

        public b(ThreadFactory threadFactory, int i) {
            this.a = i;
            this.f3903a = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f3903a[i2] = new c(threadFactory);
            }
        }
    }

    /* renamed from: ab$c */
    /* compiled from: EventLoopsScheduler */
    public static final class c extends Nm {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        a = intValue;
        c cVar = new c(C0533Hu.a);
        f3898a = cVar;
        cVar.unsubscribe();
    }

    public C0780ab(C0533Hu hu) {
        int i;
        boolean z;
        b bVar = f3897a;
        this.f3899a = new AtomicReference<>(bVar);
        b bVar2 = new b(hu, a);
        while (true) {
            AtomicReference<b> atomicReference = this.f3899a;
            if (!atomicReference.compareAndSet(bVar, bVar2)) {
                if (atomicReference.get() != bVar) {
                    z = false;
                    break;
                }
            } else {
                z = true;
                break;
            }
        }
        if (!z) {
            for (c unsubscribe : bVar2.f3903a) {
                unsubscribe.unsubscribe();
            }
        }
    }

    public final Scheduler.a a() {
        c cVar;
        b bVar = this.f3899a.get();
        int i = bVar.a;
        if (i == 0) {
            cVar = f3898a;
        } else {
            long j = bVar.f3902a;
            bVar.f3902a = 1 + j;
            cVar = bVar.f3903a[(int) (j % ((long) i))];
        }
        return new a(cVar);
    }

    public final void shutdown() {
        b bVar;
        int i;
        boolean z;
        do {
            AtomicReference<b> atomicReference = this.f3899a;
            bVar = atomicReference.get();
            b bVar2 = f3897a;
            if (bVar != bVar2) {
                while (true) {
                    if (!atomicReference.compareAndSet(bVar, bVar2)) {
                        if (atomicReference.get() != bVar) {
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
        for (c unsubscribe : bVar.f3903a) {
            unsubscribe.unsubscribe();
        }
    }
}
