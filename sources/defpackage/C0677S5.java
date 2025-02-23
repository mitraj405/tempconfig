package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: S5  reason: default package and case insensitive filesystem */
/* compiled from: CompletionState.kt */
public class C0677S5 {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(C0677S5.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with other field name */
    public final Throwable f3789a;

    public C0677S5(boolean z, Throwable th) {
        this.f3789a = th;
        this._handled = z ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f3789a + ']';
    }
}
