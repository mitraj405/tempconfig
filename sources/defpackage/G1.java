package defpackage;

import android.os.Looper;

/* renamed from: G1  reason: default package */
/* compiled from: ArchTaskExecutor */
public final class G1 extends v3 {
    public static final F1 a = new F1(0);

    /* renamed from: a  reason: collision with other field name */
    public static volatile G1 f225a;

    /* renamed from: a  reason: collision with other field name */
    public final C0419z8 f226a = new C0419z8();

    public static G1 d() {
        if (f225a != null) {
            return f225a;
        }
        synchronized (G1.class) {
            if (f225a == null) {
                f225a = new G1();
            }
        }
        return f225a;
    }

    public final void e(Runnable runnable) {
        C0419z8 z8Var = this.f226a;
        if (z8Var.a == null) {
            synchronized (z8Var.f3454a) {
                if (z8Var.a == null) {
                    z8Var.a = C0419z8.d(Looper.getMainLooper());
                }
            }
        }
        z8Var.a.post(runnable);
    }
}
