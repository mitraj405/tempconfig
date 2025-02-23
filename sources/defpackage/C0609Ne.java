package defpackage;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import defpackage.C0698Tt;

/* renamed from: Ne  reason: default package and case insensitive filesystem */
/* compiled from: HandlerDispatcher.kt */
public final class C0609Ne {
    private static volatile Choreographer choreographer;

    static {
        Object obj;
        try {
            obj = new C0580Le(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            obj = r1.n(th);
        }
        if (obj instanceof C0698Tt.a) {
            obj = null;
        }
        C0593Me me = (C0593Me) obj;
    }

    public static final Handler a(Looper looper) {
        Class<Looper> cls = Looper.class;
        Class<Handler> cls2 = Handler.class;
        if (Build.VERSION.SDK_INT >= 28) {
            Object invoke = cls2.getDeclaredMethod("createAsync", new Class[]{cls}).invoke((Object) null, new Object[]{looper});
            C1177ig.d(invoke, "null cannot be cast to non-null type android.os.Handler");
            return (Handler) invoke;
        }
        try {
            return cls2.getDeclaredConstructor(new Class[]{cls, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (NoSuchMethodException unused) {
            return new Handler(looper);
        }
    }
}
