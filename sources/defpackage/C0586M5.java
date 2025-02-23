package defpackage;

import rx.Subscriber;

/* renamed from: M5  reason: default package and case insensitive filesystem */
/* compiled from: Completable */
public final class C0586M5 extends Subscriber<Object> {
    public final /* synthetic */ P5 a;

    public C0586M5(P5 p5) {
        this.a = p5;
    }

    public final void onCompleted() {
        this.a.a();
    }

    public final void onError(Throwable th) {
        this.a.c();
    }

    public final void onNext(Object obj) {
    }
}
