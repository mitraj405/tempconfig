package defpackage;

import defpackage.C0780ab;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

/* renamed from: Zu  reason: default package */
/* compiled from: ScalarSynchronousObservable */
public final class Zu<T> extends Observable<T> {
    public static final boolean a = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: a  reason: collision with other field name */
    public final T f3885a;

    /* renamed from: Zu$a */
    /* compiled from: ScalarSynchronousObservable */
    public class a implements C0505Fd<C, Subscription> {
        public final /* synthetic */ C0780ab a;

        public a(C0780ab abVar) {
            this.a = abVar;
        }

        public final Object c(Object obj) {
            C0780ab.c cVar;
            C c = (C) obj;
            C0780ab.b bVar = this.a.f3899a.get();
            int i = bVar.a;
            if (i == 0) {
                cVar = C0780ab.f3898a;
            } else {
                long j = bVar.f3902a;
                bVar.f3902a = 1 + j;
                cVar = bVar.f3903a[(int) (j % ((long) i))];
            }
            return cVar.d(c, -1, TimeUnit.NANOSECONDS);
        }
    }

    /* renamed from: Zu$b */
    /* compiled from: ScalarSynchronousObservable */
    public class b implements C0505Fd<C, Subscription> {
        public final /* synthetic */ Scheduler a;

        public b(Scheduler scheduler) {
            this.a = scheduler;
        }

        public final Object c(Object obj) {
            Scheduler.a a2 = this.a.a();
            a2.b(new C0789av((C) obj, a2));
            return a2;
        }
    }

    /* renamed from: Zu$c */
    /* compiled from: ScalarSynchronousObservable */
    public static final class c<T> implements Observable.OnSubscribe<T> {
        public final T a;

        public c(String str) {
            this.a = str;
        }

        public final void call(Object obj) {
            Producer producer;
            Subscriber subscriber = (Subscriber) obj;
            boolean z = Zu.a;
            T t = this.a;
            if (z) {
                producer = new C1163hx(subscriber, t);
            } else {
                producer = new f(subscriber, t);
            }
            subscriber.setProducer(producer);
        }
    }

    /* renamed from: Zu$d */
    /* compiled from: ScalarSynchronousObservable */
    public static final class d<T> implements Observable.OnSubscribe<T> {
        public final C0505Fd<C, Subscription> a;

        /* renamed from: a  reason: collision with other field name */
        public final T f3886a;

        public d(T t, C0505Fd<C, Subscription> fd) {
            this.f3886a = t;
            this.a = fd;
        }

        public final void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.setProducer(new e(subscriber, this.f3886a, this.a));
        }
    }

    /* renamed from: Zu$e */
    /* compiled from: ScalarSynchronousObservable */
    public static final class e<T> extends AtomicBoolean implements Producer, C {
        private static final long serialVersionUID = -2466317989629281651L;
        public final C0505Fd<C, Subscription> a;

        /* renamed from: a  reason: collision with other field name */
        public final T f3887a;

        /* renamed from: a  reason: collision with other field name */
        public final Subscriber<? super T> f3888a;

        public e(Subscriber<? super T> subscriber, T t, C0505Fd<C, Subscription> fd) {
            this.f3888a = subscriber;
            this.f3887a = t;
            this.a = fd;
        }

        public final void a() {
            Subscriber<? super T> subscriber = this.f3888a;
            if (!subscriber.isUnsubscribed()) {
                T t = this.f3887a;
                try {
                    subscriber.onNext(t);
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    C1354qp.E0(th, subscriber, t);
                }
            }
        }

        public final void request(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(C0709Uj.h("n >= 0 required but it was ", j));
            } else if (i != 0 && compareAndSet(false, true)) {
                this.f3888a.add(this.a.c(this));
            }
        }

        public final String toString() {
            return "ScalarAsyncProducer[" + this.f3887a + ", " + get() + "]";
        }
    }

    /* renamed from: Zu$f */
    /* compiled from: ScalarSynchronousObservable */
    public static final class f<T> implements Producer {
        public final T a;

        /* renamed from: a  reason: collision with other field name */
        public final Subscriber<? super T> f3889a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3890a;

        public f(Subscriber<? super T> subscriber, T t) {
            this.f3889a = subscriber;
            this.a = t;
        }

        public final void request(long j) {
            if (!this.f3890a) {
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    throw new IllegalStateException(C0709Uj.h("n >= required but it was ", j));
                } else if (i != 0) {
                    this.f3890a = true;
                    Subscriber<? super T> subscriber = this.f3889a;
                    if (!subscriber.isUnsubscribed()) {
                        T t = this.a;
                        try {
                            subscriber.onNext(t);
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                            }
                        } catch (Throwable th) {
                            C1354qp.E0(th, subscriber, t);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Zu(java.lang.String r3) {
        /*
            r2 = this;
            Zu$c r0 = new Zu$c
            r0.<init>(r3)
            tu r1 = defpackage.C1520zu.f7112a
            if (r1 == 0) goto L_0x000f
            java.lang.Object r0 = r1.c(r0)
            rx.Observable$OnSubscribe r0 = (rx.Observable.OnSubscribe) r0
        L_0x000f:
            r2.<init>(r0)
            r2.f3885a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Zu.<init>(java.lang.String):void");
    }

    public final Observable<T> e(Scheduler scheduler) {
        C0505Fd fd;
        if (scheduler instanceof C0780ab) {
            fd = new a((C0780ab) scheduler);
        } else {
            fd = new b(scheduler);
        }
        Observable.OnSubscribe dVar = new d(this.f3885a, fd);
        C1414tu tuVar = C1520zu.f7112a;
        if (tuVar != null) {
            dVar = (Observable.OnSubscribe) tuVar.c(dVar);
        }
        return new Observable<>(dVar);
    }
}
