package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.j;

/* renamed from: tb  reason: default package and case insensitive filesystem */
/* compiled from: Executors.kt */
public final class C1403tb extends C0595Mh implements Function1<CoroutineContext.b, j> {
    public static final C1403tb a = new C1403tb();

    public C1403tb() {
        super(1);
    }

    public final Object invoke(Object obj) {
        CoroutineContext.b bVar = (CoroutineContext.b) obj;
        if (bVar instanceof j) {
            return (j) bVar;
        }
        return null;
    }
}
