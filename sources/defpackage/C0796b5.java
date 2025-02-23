package defpackage;

import kotlin.Unit;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.k;

/* renamed from: b5  reason: default package and case insensitive filesystem */
/* compiled from: JobSupport.kt */
public final class C0796b5 extends Lg implements C0778a5 {
    public final C0815c5 a;

    public C0796b5(k kVar) {
        this.a = kVar;
    }

    public final Job a() {
        return m();
    }

    public final boolean f(Throwable th) {
        return m().F(th);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return Unit.a;
    }

    public final void l(Throwable th) {
        this.a.t(m());
    }
}
