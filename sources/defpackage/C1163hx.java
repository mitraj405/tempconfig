package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;

/* renamed from: hx  reason: default package and case insensitive filesystem */
/* compiled from: SingleProducer */
public final class C1163hx<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    public final T a;

    /* renamed from: a  reason: collision with other field name */
    public final Subscriber<? super T> f5480a;

    public C1163hx(Subscriber<? super T> subscriber, T t) {
        this.f5480a = subscriber;
        this.a = t;
    }

    public final void request(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i != 0 && compareAndSet(false, true)) {
            Subscriber<? super T> subscriber = this.f5480a;
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
