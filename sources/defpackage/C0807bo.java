package defpackage;

import rx.Observable;
import rx.c;

/* renamed from: bo  reason: default package and case insensitive filesystem */
/* compiled from: OnSubscribeSingle */
public final class C0807bo<T> implements c.a<T> {
    public final Observable<T> a;

    public C0807bo(Observable<T> observable) {
        this.a = observable;
    }

    public final void call(Object obj) {
        C1182ix ixVar = (C1182ix) obj;
        C0785ao aoVar = new C0785ao(ixVar);
        ixVar.a.a(aoVar);
        this.a.d(aoVar);
    }
}
