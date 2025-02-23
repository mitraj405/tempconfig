package defpackage;

import java.lang.reflect.Method;

/* renamed from: P  reason: default package */
/* compiled from: ActivityRecreator */
public final class P implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;

    public P(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final void run() {
        try {
            Method method = Q.f484a;
            Object obj = this.b;
            Object obj2 = this.a;
            if (method != null) {
                method.invoke(obj2, new Object[]{obj, Boolean.FALSE, "AppCompat recreation"});
                return;
            }
            Q.f485b.invoke(obj2, new Object[]{obj, Boolean.FALSE});
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable unused) {
        }
    }
}
