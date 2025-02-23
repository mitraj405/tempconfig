package defpackage;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.work.WorkerParameters;
import androidx.work.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: Fe  reason: default package and case insensitive filesystem */
/* compiled from: GreedyScheduler */
public final class C0092Fe implements fv, LD, rb {
    public final F8 a;

    /* renamed from: a  reason: collision with other field name */
    public final MD f204a;

    /* renamed from: a  reason: collision with other field name */
    public final VD f205a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f206a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f207a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f208a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f209a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    public boolean f210a;

    static {
        zi.e("GreedyScheduler");
    }

    public C0092Fe(Context context, a aVar, WD wd, VD vd) {
        this.f206a = context;
        this.f205a = vd;
        this.f204a = new MD(context, wd, this);
        this.a = new F8(this, aVar.f2649a);
        this.f208a = new Object();
    }

    public final void a(List<String> list) {
        Iterator it = ((ArrayList) list).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zi c = zi.c();
            String.format("Constraints met: Scheduling work ID %s", new Object[]{str});
            c.a(new Throwable[0]);
            VD vd = this.f205a;
            vd.f595a.c(new Ox(vd, str, (WorkerParameters.a) null));
        }
    }

    public final boolean b() {
        return false;
    }

    public final void c(String str) {
        Runnable runnable;
        Boolean bool = this.f207a;
        VD vd = this.f205a;
        if (bool == null) {
            this.f207a = Boolean.valueOf(vq.a(this.f206a, vd.f593a));
        }
        if (!this.f207a.booleanValue()) {
            zi.c().d(new Throwable[0]);
            return;
        }
        if (!this.f210a) {
            vd.f598a.a(this);
            this.f210a = true;
        }
        zi c = zi.c();
        String.format("Cancelling work ID %s", new Object[]{str});
        c.a(new Throwable[0]);
        F8 f8 = this.a;
        if (!(f8 == null || (runnable = (Runnable) f8.f197a.remove(str)) == null)) {
            ((Handler) f8.f198a.a).removeCallbacks(runnable);
        }
        vd.f595a.c(new C0187ey(vd, str, false));
    }

    public final void d(C0214hE... hEVarArr) {
        boolean z;
        if (this.f207a == null) {
            this.f207a = Boolean.valueOf(vq.a(this.f206a, this.f205a.f593a));
        }
        if (!this.f207a.booleanValue()) {
            zi.c().d(new Throwable[0]);
            return;
        }
        if (!this.f210a) {
            this.f205a.f598a.a(this);
            this.f210a = true;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (C0214hE hEVar : hEVarArr) {
            long a2 = hEVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (hEVar.f2989a == UD.ENQUEUED) {
                if (currentTimeMillis < a2) {
                    F8 f8 = this.a;
                    if (f8 != null) {
                        HashMap hashMap = f8.f197a;
                        Runnable runnable = (Runnable) hashMap.remove(hEVar.f2991a);
                        nh nhVar = f8.f198a;
                        if (runnable != null) {
                            ((Handler) nhVar.a).removeCallbacks(runnable);
                        }
                        E8 e8 = new E8(f8, hEVar);
                        hashMap.put(hEVar.f2991a, e8);
                        ((Handler) nhVar.a).postDelayed(e8, hEVar.a() - System.currentTimeMillis());
                    }
                } else if (hEVar.b()) {
                    T6 t6 = hEVar.f2988a;
                    if (t6.f542b) {
                        zi c = zi.c();
                        String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{hEVar});
                        c.a(new Throwable[0]);
                    } else {
                        if (t6.f540a.a.size() > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            zi c2 = zi.c();
                            String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{hEVar});
                            c2.a(new Throwable[0]);
                        } else {
                            hashSet.add(hEVar);
                            hashSet2.add(hEVar.f2991a);
                        }
                    }
                } else {
                    zi c3 = zi.c();
                    String.format("Starting work for %s", new Object[]{hEVar.f2991a});
                    c3.a(new Throwable[0]);
                    VD vd = this.f205a;
                    vd.f595a.c(new Ox(vd, hEVar.f2991a, (WorkerParameters.a) null));
                }
            }
        }
        synchronized (this.f208a) {
            if (!hashSet.isEmpty()) {
                zi c4 = zi.c();
                String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", hashSet2)});
                c4.a(new Throwable[0]);
                this.f209a.addAll(hashSet);
                this.f204a.b(this.f209a);
            }
        }
    }

    public final void e(String str, boolean z) {
        synchronized (this.f208a) {
            Iterator it = this.f209a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                C0214hE hEVar = (C0214hE) it.next();
                if (hEVar.f2991a.equals(str)) {
                    zi c = zi.c();
                    String.format("Stopping tracking for %s", new Object[]{str});
                    c.a(new Throwable[0]);
                    this.f209a.remove(hEVar);
                    this.f204a.b(this.f209a);
                    break;
                }
            }
        }
    }

    public final void f(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            zi c = zi.c();
            String.format("Constraints not met: Cancelling work ID %s", new Object[]{str});
            c.a(new Throwable[0]);
            VD vd = this.f205a;
            vd.f595a.c(new C0187ey(vd, str, false));
        }
    }
}
