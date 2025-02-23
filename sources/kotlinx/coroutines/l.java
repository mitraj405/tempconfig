package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* compiled from: Unconfined.kt */
public final class l extends CoroutineDispatcher {
    public static final /* synthetic */ int c = 0;

    static {
        new l();
    }

    public final void h(CoroutineContext coroutineContext, Runnable runnable) {
        if (((m) coroutineContext.b(m.a)) == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    public final String toString() {
        return "Dispatchers.Unconfined";
    }
}
