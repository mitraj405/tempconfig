package rx;

public class Observable<T> {
    public final OnSubscribe<T> a;

    public interface OnSubscribe<T> extends D<Subscriber<? super T>> {
    }

    public interface a<R, T> extends C0505Fd<Subscriber<? super R>, Subscriber<? super T>> {
    }

    public Observable(OnSubscribe<T> onSubscribe) {
        this.a = onSubscribe;
    }

    public final Observable a(C0758Yi yi) {
        int i = C0523Gu.c;
        if (this instanceof Zu) {
            return ((Zu) this).e(yi);
        }
        OnSubscribe zn = new Zn(this.a, new C1224ko(yi, i));
        C1414tu tuVar = C1520zu.f7112a;
        if (tuVar != null) {
            zn = (OnSubscribe) tuVar.c(zn);
        }
        return new Observable(zn);
    }

    public final void b(Subscriber subscriber) {
        if (subscriber != null) {
            OnSubscribe<T> onSubscribe = this.a;
            if (onSubscribe != null) {
                subscriber.onStart();
                if (!(subscriber instanceof C0631Ou)) {
                    subscriber = new C0631Ou(subscriber);
                }
                try {
                    if (C1520zu.f7115a != null) {
                        Cu.f3555a.c().getClass();
                        onSubscribe = onSubscribe;
                    }
                    onSubscribe.call(subscriber);
                    C1488xu xuVar = C1520zu.f7116a;
                    if (xuVar != null) {
                        xuVar.c(subscriber);
                    }
                } catch (Throwable th) {
                    C1354qp.D0(th);
                    Pn pn = new Pn("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
                    C1520zu.b(pn);
                    throw pn;
                }
            } else {
                throw new IllegalStateException("onSubscribe function can not be null.");
            }
        } else {
            throw new IllegalArgumentException("subscriber can not be null");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: rx.Observable$OnSubscribe} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final rx.Observable<T> c(rx.Scheduler r3) {
        /*
            r2 = this;
            rx.Observable$OnSubscribe<T> r0 = r2.a
            boolean r0 = r0 instanceof defpackage.Yn
            r0 = r0 ^ 1
            boolean r1 = r2 instanceof defpackage.Zu
            if (r1 == 0) goto L_0x0012
            r0 = r2
            Zu r0 = (defpackage.Zu) r0
            rx.Observable r3 = r0.e(r3)
            goto L_0x0027
        L_0x0012:
            lo r1 = new lo
            r1.<init>(r2, r3, r0)
            rx.Observable r3 = new rx.Observable
            tu r0 = defpackage.C1520zu.f7112a
            if (r0 == 0) goto L_0x0024
            java.lang.Object r0 = r0.c(r1)
            r1 = r0
            rx.Observable$OnSubscribe r1 = (rx.Observable.OnSubscribe) r1
        L_0x0024:
            r3.<init>(r1)
        L_0x0027:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.Observable.c(rx.Scheduler):rx.Observable");
    }

    public final void d(Subscriber subscriber) {
        try {
            subscriber.onStart();
            OnSubscribe<T> onSubscribe = this.a;
            if (C1520zu.f7115a != null) {
                Cu.f3555a.c().getClass();
                onSubscribe = onSubscribe;
            }
            onSubscribe.call(subscriber);
            C1488xu xuVar = C1520zu.f7116a;
            if (xuVar != null) {
                xuVar.c(subscriber);
            }
        } catch (Throwable th) {
            C1354qp.D0(th);
            Pn pn = new Pn("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th);
            C1520zu.b(pn);
            throw pn;
        }
    }
}
