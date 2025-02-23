package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.j;

/* renamed from: gv  reason: default package and case insensitive filesystem */
/* compiled from: Dispatcher.kt */
public class C1141gv extends j {
    public final C1420u7 a;

    public C1141gv(int i, int i2, String str, long j) {
        this.a = new C1420u7(i, i2, str, j);
    }

    public final void h(CoroutineContext coroutineContext, Runnable runnable) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = C1420u7.f6972a;
        this.a.b(runnable, C1524zz.f7122a, false);
    }
}
