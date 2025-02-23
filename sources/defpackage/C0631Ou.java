package defpackage;

import java.util.Arrays;
import rx.Subscriber;

/* renamed from: Ou  reason: default package and case insensitive filesystem */
/* compiled from: SafeSubscriber */
public final class C0631Ou<T> extends Subscriber<T> {
    public final Subscriber<? super T> a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3742a;

    public C0631Ou(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.a = subscriber;
    }

    public final void onCompleted() {
        if (!this.f3742a) {
            this.f3742a = true;
            try {
                this.a.onCompleted();
                try {
                    unsubscribe();
                } catch (Throwable th) {
                    C1520zu.a(th);
                    throw new C1345qB(th.getMessage(), th);
                }
            } catch (Throwable th2) {
                try {
                    unsubscribe();
                    throw th2;
                } catch (Throwable th3) {
                    C1520zu.a(th3);
                    throw new C1345qB(th3.getMessage(), th3);
                }
            }
        }
    }

    public final void onError(Throwable th) {
        C1354qp.D0(th);
        if (!this.f3742a) {
            this.f3742a = true;
            Cu.f3555a.b().getClass();
            try {
                this.a.onError(th);
                try {
                    unsubscribe();
                } catch (Throwable th2) {
                    C1520zu.a(th2);
                    throw new Pn(th2);
                }
            } catch (Qn e) {
                unsubscribe();
                throw e;
            } catch (Throwable th3) {
                C1520zu.a(th3);
                throw new Qn(new C1190j6(Arrays.asList(new Throwable[]{th, th3})));
            }
        }
    }

    public final void onNext(T t) {
        try {
            if (!this.f3742a) {
                this.a.onNext(t);
            }
        } catch (Throwable th) {
            C1354qp.D0(th);
            onError(th);
        }
    }
}
