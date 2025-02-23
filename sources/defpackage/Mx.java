package defpackage;

/* renamed from: Mx  reason: default package */
/* compiled from: StackTraceRecovery.kt */
public final class Mx {
    public static final /* synthetic */ int a = 0;

    static {
        Object obj;
        Object obj2;
        Exception exc = new Exception();
        String simpleName = EE.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            obj = C1340q2.class.getCanonicalName();
        } catch (Throwable th) {
            obj = r1.n(th);
        }
        if (C0698Tt.a(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        String str = (String) obj;
        try {
            obj2 = Mx.class.getCanonicalName();
        } catch (Throwable th2) {
            obj2 = r1.n(th2);
        }
        if (C0698Tt.a(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        String str2 = (String) obj2;
    }
}
