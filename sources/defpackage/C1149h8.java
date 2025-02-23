package defpackage;

import kotlin.coroutines.Continuation;

/* renamed from: h8  reason: default package and case insensitive filesystem */
/* compiled from: DebugStrings.kt */
public final class C1149h8 {
    public static C1149h8 a;

    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String b(Continuation continuation) {
        String str;
        if (continuation instanceof C1173i9) {
            return continuation.toString();
        }
        try {
            str = continuation + '@' + a(continuation);
        } catch (Throwable th) {
            str = r1.n(th);
        }
        Throwable a2 = C0698Tt.a(str);
        String str2 = str;
        if (a2 != null) {
            str2 = continuation.getClass().getName() + '@' + a(continuation);
        }
        return (String) str2;
    }
}
