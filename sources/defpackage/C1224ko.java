package defpackage;

import java.util.AbstractQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/* renamed from: ko  reason: default package and case insensitive filesystem */
/* compiled from: OperatorObserveOn */
public final class C1224ko<T> implements Observable.a<T, T> {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Scheduler f5550a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5551a = false;

    /* renamed from: ko$a */
    /* compiled from: OperatorObserveOn */
    public static final class a<T> extends Subscriber<T> implements C {
        public long a;

        /* renamed from: a  reason: collision with other field name */
        public Throwable f5552a;

        /* renamed from: a  reason: collision with other field name */
        public final AbstractQueue f5553a;

        /* renamed from: a  reason: collision with other field name */
        public final AtomicLong f5554a = new AtomicLong();

        /* renamed from: a  reason: collision with other field name */
        public final Scheduler.a f5555a;

        /* renamed from: a  reason: collision with other field name */
        public final Subscriber<? super T> f5556a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f5557a;
        public final AtomicLong b = new AtomicLong();

        /* renamed from: b  reason: collision with other field name */
        public volatile boolean f5558b;
        public final int c;

        public a(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z, int i) {
            boolean z2;
            this.f5556a = subscriber;
            this.f5555a = scheduler.a();
            this.f5557a = z;
            i = i <= 0 ? C0523Gu.c : i;
            this.c = i - (i >> 2);
            if (C1255mB.a == null || C1255mB.f5595a) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                this.f5553a = new Hx(i);
            } else {
                this.f5553a = new C0585Lx(i);
            }
            request((long) i);
        }

        public final void a() {
            int i;
            boolean z;
            long j;
            long j2;
            long j3 = this.a;
            AbstractQueue abstractQueue = this.f5553a;
            Subscriber<? super T> subscriber = this.f5556a;
            long j4 = 1;
            do {
                long j5 = this.f5554a.get();
                while (true) {
                    i = (j5 > j3 ? 1 : (j5 == j3 ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z2 = this.f5558b;
                    Object poll = abstractQueue.poll();
                    if (poll == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!b(z2, z, subscriber, abstractQueue)) {
                        if (z) {
                            break;
                        }
                        if (poll == C1075dn.a) {
                            poll = null;
                        }
                        subscriber.onNext(poll);
                        j3++;
                        if (j3 == ((long) this.c)) {
                            AtomicLong atomicLong = this.f5554a;
                            do {
                                j = atomicLong.get();
                                j2 = Long.MAX_VALUE;
                                if (j == Long.MAX_VALUE) {
                                    break;
                                }
                                j2 = j - j3;
                                if (j2 < 0) {
                                    throw new IllegalStateException(C0709Uj.h("More produced than requested: ", j2));
                                }
                            } while (!atomicLong.compareAndSet(j, j2));
                            j5 = j2;
                            request(j3);
                            j3 = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (i != 0 || !b(this.f5558b, abstractQueue.isEmpty(), subscriber, abstractQueue)) {
                    this.a = j3;
                    j4 = this.b.addAndGet(-j4);
                } else {
                    return;
                }
            } while (j4 != 0);
        }

        public final boolean b(boolean z, boolean z2, Subscriber subscriber, AbstractQueue abstractQueue) {
            if (subscriber.isUnsubscribed()) {
                abstractQueue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                boolean z3 = this.f5557a;
                Scheduler.a aVar = this.f5555a;
                if (!z3) {
                    Throwable th = this.f5552a;
                    if (th != null) {
                        abstractQueue.clear();
                        try {
                            subscriber.onError(th);
                            return true;
                        } finally {
                            aVar.unsubscribe();
                        }
                    } else if (!z2) {
                        return false;
                    } else {
                        try {
                            subscriber.onCompleted();
                            return true;
                        } finally {
                            aVar.unsubscribe();
                        }
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.f5552a;
                    if (th2 != null) {
                        try {
                            subscriber.onError(th2);
                        } catch (Throwable th3) {
                            aVar.unsubscribe();
                            throw th3;
                        }
                    } else {
                        subscriber.onCompleted();
                    }
                    aVar.unsubscribe();
                    return false;
                }
            }
        }

        public final void c() {
            if (this.b.getAndIncrement() == 0) {
                this.f5555a.b(this);
            }
        }

        public final void onCompleted() {
            if (!isUnsubscribed() && !this.f5558b) {
                this.f5558b = true;
                c();
            }
        }

        public final void onError(Throwable th) {
            if (isUnsubscribed() || this.f5558b) {
                C1520zu.a(th);
                return;
            }
            this.f5552a = th;
            this.f5558b = true;
            c();
        }

        public final void onNext(T t) {
            if (!isUnsubscribed() && !this.f5558b) {
                AbstractQueue abstractQueue = this.f5553a;
                if (t == null) {
                    t = C1075dn.a;
                }
                if (!abstractQueue.offer(t)) {
                    onError(new C1369rl());
                } else {
                    c();
                }
            }
        }
    }

    public C1224ko(C0758Yi yi, int i) {
        this.f5550a = yi;
        this.a = i <= 0 ? C0523Gu.c : i;
    }

    public final Object c(Object obj) {
        a aVar = new a(this.f5550a, (Subscriber) obj, this.f5551a, this.a);
        C1202jo joVar = new C1202jo(aVar);
        Subscriber<? super T> subscriber = aVar.f5556a;
        subscriber.setProducer(joVar);
        subscriber.add(aVar.f5555a);
        subscriber.add(aVar);
        return aVar;
    }
}
