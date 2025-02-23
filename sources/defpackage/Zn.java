package defpackage;

import rx.Observable;
import rx.Subscriber;

/* renamed from: Zn  reason: default package */
/* compiled from: OnSubscribeLift */
public final class Zn<T, R> implements Observable.OnSubscribe<R> {
    public final Observable.OnSubscribe<T> a;

    /* renamed from: a  reason: collision with other field name */
    public final Observable.a<? extends R, ? super T> f3884a;

    public Zn(Observable.OnSubscribe onSubscribe, C1224ko koVar) {
        this.a = onSubscribe;
        this.f3884a = koVar;
    }

    public final void call(Object obj) {
        Subscriber subscriber;
        Subscriber subscriber2 = (Subscriber) obj;
        try {
            Observable.a<? extends R, ? super T> aVar = this.f3884a;
            C1503yu yuVar = C1520zu.f7117a;
            if (yuVar != null) {
                aVar = (Observable.a) yuVar.c(aVar);
            }
            subscriber = (Subscriber) aVar.c(subscriber2);
            subscriber.onStart();
            this.a.call(subscriber);
        } catch (Throwable th) {
            C1354qp.D0(th);
            subscriber2.onError(th);
        }
    }
}
