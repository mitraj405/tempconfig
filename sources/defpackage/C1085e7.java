package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: e7  reason: default package and case insensitive filesystem */
/* compiled from: Scopes.kt */
public final class C1085e7 implements CoroutineScope {
    public final CoroutineContext a;

    public C1085e7(CoroutineContext coroutineContext) {
        this.a = coroutineContext;
    }

    public final CoroutineContext r() {
        return this.a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.a + ')';
    }
}
