package defpackage;

import android.content.Context;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import defpackage.P6;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: MD  reason: default package */
/* compiled from: WorkConstraintsTracker */
public final class MD implements P6.a {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final LD f404a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f405a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final P6<?>[] f406a;

    static {
        zi.e("WorkConstraintsTracker");
    }

    public MD(Context context, TaskExecutor taskExecutor, LD ld) {
        Context applicationContext = context.getApplicationContext();
        this.f404a = ld;
        this.f406a = new P6[]{new E2(applicationContext, taskExecutor), new G2(applicationContext, taskExecutor), new C0198fy(applicationContext, taskExecutor), new C0411ym(applicationContext, taskExecutor), new Fm(applicationContext, taskExecutor), new Bm(applicationContext, taskExecutor), new Am(applicationContext, taskExecutor)};
    }

    public final boolean a(String str) {
        boolean z;
        synchronized (this.f405a) {
            for (P6<?> p6 : this.f406a) {
                T t = p6.f479a;
                if (t == null || !p6.c(t) || !p6.f480a.contains(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    zi c = zi.c();
                    String.format("Work %s constrained by %s", new Object[]{str, p6.getClass().getSimpleName()});
                    c.a(new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public final void b(Collection collection) {
        synchronized (this.f405a) {
            for (P6<?> p6 : this.f406a) {
                if (p6.a != null) {
                    p6.a = null;
                    p6.e((P6.a) null, p6.f479a);
                }
            }
            for (P6<?> d : this.f406a) {
                d.d(collection);
            }
            for (P6<?> p62 : this.f406a) {
                if (p62.a != this) {
                    p62.a = this;
                    p62.e(this, p62.f479a);
                }
            }
        }
    }

    public final void c() {
        synchronized (this.f405a) {
            for (P6<?> p6 : this.f406a) {
                ArrayList arrayList = p6.f480a;
                if (!arrayList.isEmpty()) {
                    arrayList.clear();
                    R6<T> r6 = p6.f478a;
                    synchronized (r6.f494a) {
                        if (r6.f495a.remove(p6) && r6.f495a.isEmpty()) {
                            r6.d();
                        }
                    }
                }
            }
        }
    }
}
