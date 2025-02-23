package rx;

import rx.b;

/* compiled from: Completable */
public final class a implements b.a {
    public final /* synthetic */ Observable a;

    public a(Observable observable) {
        this.a = observable;
    }

    public final void call(Object obj) {
        P5 p5 = (P5) obj;
        C0586M5 m5 = new C0586M5(p5);
        p5.b();
        this.a.d(m5);
    }
}
