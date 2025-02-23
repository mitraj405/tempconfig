package defpackage;

import kotlin.Unit;
import kotlinx.coroutines.c;
import kotlinx.coroutines.k;

/* renamed from: Ut  reason: default package and case insensitive filesystem */
/* compiled from: JobSupport.kt */
public final class C0713Ut<T> extends C0610Ng {
    public final c<T> a;

    public C0713Ut(k.a aVar) {
        this.a = aVar;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return Unit.a;
    }

    public final void l(Throwable th) {
        Object S = m().S();
        boolean z = S instanceof C0677S5;
        c<T> cVar = this.a;
        if (z) {
            cVar.resumeWith(r1.n(((C0677S5) S).f3789a));
        } else {
            cVar.resumeWith(C1354qp.L0(S));
        }
    }
}
