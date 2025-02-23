package defpackage;

import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;

/* renamed from: lo  reason: default package and case insensitive filesystem */
/* compiled from: OperatorSubscribeOn */
public final class C1244lo<T> implements Observable.OnSubscribe<T> {
    public final Observable<T> a;

    /* renamed from: a  reason: collision with other field name */
    public final Scheduler f5586a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f5587a;

    /* renamed from: lo$a */
    /* compiled from: OperatorSubscribeOn */
    public static final class a<T> extends Subscriber<T> implements C {
        public Thread a;

        /* renamed from: a  reason: collision with other field name */
        public Observable<T> f5588a;

        /* renamed from: a  reason: collision with other field name */
        public final Scheduler.a f5589a;

        /* renamed from: a  reason: collision with other field name */
        public final Subscriber<? super T> f5590a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f5591a;

        /* renamed from: lo$a$a  reason: collision with other inner class name */
        /* compiled from: OperatorSubscribeOn */
        public class C0077a implements Producer {

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ Producer f5592a;

            /* renamed from: lo$a$a$a  reason: collision with other inner class name */
            /* compiled from: OperatorSubscribeOn */
            public class C0078a implements C {
                public final /* synthetic */ long a;

                public C0078a(long j) {
                    this.a = j;
                }

                public final void a() {
                    C0077a.this.f5592a.request(this.a);
                }
            }

            public C0077a(Producer producer) {
                this.f5592a = producer;
            }

            public final void request(long j) {
                a aVar = a.this;
                if (aVar.a == Thread.currentThread() || !aVar.f5591a) {
                    this.f5592a.request(j);
                    return;
                }
                aVar.f5589a.b(new C0078a(j));
            }
        }

        public a(Subscriber<? super T> subscriber, boolean z, Scheduler.a aVar, Observable<T> observable) {
            this.f5590a = subscriber;
            this.f5591a = z;
            this.f5589a = aVar;
            this.f5588a = observable;
        }

        public final void a() {
            Observable<T> observable = this.f5588a;
            this.f5588a = null;
            this.a = Thread.currentThread();
            observable.d(this);
        }

        public final void onCompleted() {
            Scheduler.a aVar = this.f5589a;
            try {
                this.f5590a.onCompleted();
            } finally {
                aVar.unsubscribe();
            }
        }

        public final void onError(Throwable th) {
            Scheduler.a aVar = this.f5589a;
            try {
                this.f5590a.onError(th);
            } finally {
                aVar.unsubscribe();
            }
        }

        public final void onNext(T t) {
            this.f5590a.onNext(t);
        }

        public final void setProducer(Producer producer) {
            this.f5590a.setProducer(new C0077a(producer));
        }
    }

    public C1244lo(Observable<T> observable, Scheduler scheduler, boolean z) {
        this.f5586a = scheduler;
        this.a = observable;
        this.f5587a = z;
    }

    public final void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.a a2 = this.f5586a.a();
        a aVar = new a(subscriber, this.f5587a, a2, this.a);
        subscriber.add(aVar);
        subscriber.add(a2);
        a2.b(aVar);
    }
}
