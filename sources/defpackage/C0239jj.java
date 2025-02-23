package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: jj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0239jj implements Hj {
    public final /* synthetic */ String a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AtomicBoolean f3042a;

    public /* synthetic */ C0239jj(String str, AtomicBoolean atomicBoolean) {
        this.a = str;
        this.f3042a = atomicBoolean;
    }

    public final void onResult(Object obj) {
        C0181ej ejVar = (C0181ej) obj;
        C0281nj.a.remove(this.a);
        this.f3042a.set(true);
    }
}
