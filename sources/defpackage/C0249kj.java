package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: kj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0249kj implements Hj {
    public final /* synthetic */ String a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AtomicBoolean f3054a;

    public /* synthetic */ C0249kj(String str, AtomicBoolean atomicBoolean) {
        this.a = str;
        this.f3054a = atomicBoolean;
    }

    public final void onResult(Object obj) {
        Throwable th = (Throwable) obj;
        C0281nj.a.remove(this.a);
        this.f3054a.set(true);
    }
}
