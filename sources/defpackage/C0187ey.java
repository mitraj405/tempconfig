package defpackage;

import androidx.work.impl.WorkDatabase;

/* renamed from: ey  reason: default package and case insensitive filesystem */
/* compiled from: StopWorkRunnable */
public final class C0187ey implements Runnable {
    public final VD a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2919a;
    public final String c;

    static {
        zi.e("StopWorkRunnable");
    }

    public C0187ey(VD vd, String str, boolean z) {
        this.a = vd;
        this.c = str;
        this.f2919a = z;
    }

    public final void run() {
        boolean containsKey;
        boolean z;
        VD vd = this.a;
        WorkDatabase workDatabase = vd.f594a;
        wq wqVar = vd.f598a;
        C0224iE n = workDatabase.n();
        workDatabase.c();
        try {
            String str = this.c;
            synchronized (wqVar.f3398a) {
                containsKey = wqVar.f3400a.containsKey(str);
            }
            if (this.f2919a) {
                z = this.a.f598a.h(this.c);
            } else {
                if (!containsKey) {
                    C0236jE jEVar = (C0236jE) n;
                    if (jEVar.f(this.c) == UD.RUNNING) {
                        jEVar.n(UD.ENQUEUED, this.c);
                    }
                }
                z = this.a.f598a.i(this.c);
            }
            zi c2 = zi.c();
            String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.c, Boolean.valueOf(z)});
            c2.a(new Throwable[0]);
            workDatabase.h();
            workDatabase.f();
        } catch (Throwable th) {
            workDatabase.f();
            throw th;
        }
    }
}
