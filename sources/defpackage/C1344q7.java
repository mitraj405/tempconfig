package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: q7  reason: default package and case insensitive filesystem */
/* compiled from: CoroutineContext.kt */
public final class C1344q7 extends C0595Mh implements Function2<Boolean, CoroutineContext.b, Boolean> {
    public static final C1344q7 a = new C1344q7();

    public C1344q7() {
        super(2);
    }

    public final Object invoke(Object obj, Object obj2) {
        boolean z;
        CoroutineContext.b bVar = (CoroutineContext.b) obj2;
        if (((Boolean) obj).booleanValue() || (bVar instanceof C1254m7)) {
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
