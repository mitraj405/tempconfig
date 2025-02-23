package defpackage;

import android.os.OutcomeReceiver;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.c;

/* renamed from: j7  reason: default package and case insensitive filesystem */
/* compiled from: OutcomeReceiver.kt */
public final class C0233j7<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver<R, E> {
    public final Continuation<R> a;

    public C0233j7(c cVar) {
        super(false);
        this.a = cVar;
    }

    public final void onError(E e) {
        if (compareAndSet(false, true)) {
            this.a.resumeWith(r1.n(e));
        }
    }

    public final void onResult(R r) {
        if (compareAndSet(false, true)) {
            this.a.resumeWith(r);
        }
    }

    public final String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
