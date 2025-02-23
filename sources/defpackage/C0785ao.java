package defpackage;

import java.util.NoSuchElementException;
import rx.Subscriber;

/* renamed from: ao  reason: default package and case insensitive filesystem */
/* compiled from: OnSubscribeSingle */
public final class C0785ao extends Subscriber<Object> {
    public final /* synthetic */ C1182ix a;

    /* renamed from: a  reason: collision with other field name */
    public Object f3904a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3905a;
    public boolean b;

    public C0785ao(C1182ix ixVar) {
        this.a = ixVar;
    }

    public final void onCompleted() {
        if (!this.f3905a) {
            boolean z = this.b;
            C1182ix ixVar = this.a;
            if (z) {
                ixVar.b(this.f3904a);
            } else {
                ixVar.a(new NoSuchElementException("Observable emitted no items"));
            }
        }
    }

    public final void onError(Throwable th) {
        this.a.a(th);
        unsubscribe();
    }

    public final void onNext(Object obj) {
        if (this.b) {
            this.f3905a = true;
            this.a.a(new IllegalArgumentException("Observable emitted too many elements"));
            unsubscribe();
            return;
        }
        this.b = true;
        this.f3904a = obj;
    }

    public final void onStart() {
        request(2);
    }
}
