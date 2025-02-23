package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: rg  reason: default package and case insensitive filesystem */
/* compiled from: JobSupport.kt */
public final class C1366rg extends Lg {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(C1366rg.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<Throwable, Unit> f6946a;

    public C1366rg(Function1<? super Throwable, Unit> function1) {
        this.f6946a = function1;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        l((Throwable) obj);
        return Unit.a;
    }

    public final void l(Throwable th) {
        if (a.compareAndSet(this, 0, 1)) {
            this.f6946a.invoke(th);
        }
    }
}
