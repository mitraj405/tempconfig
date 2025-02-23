package defpackage;

import androidx.work.impl.WorkDatabase;
import defpackage.C0218ho;
import java.util.LinkedList;

/* renamed from: t4  reason: default package */
/* compiled from: CancelWorkRunnable */
public abstract class t4 implements Runnable {
    public final io a = new io();

    public static void a(VD vd, String str) {
        boolean z;
        WorkDatabase workDatabase = vd.f594a;
        C0224iE n = workDatabase.n();
        K8 i = workDatabase.i();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (true) {
            z = false;
            if (linkedList.isEmpty()) {
                break;
            }
            String str2 = (String) linkedList.remove();
            C0236jE jEVar = (C0236jE) n;
            UD f = jEVar.f(str2);
            if (!(f == UD.SUCCEEDED || f == UD.FAILED)) {
                jEVar.n(UD.CANCELLED, str2);
            }
            linkedList.addAll(((L8) i).a(str2));
        }
        wq wqVar = vd.f598a;
        synchronized (wqVar.f3398a) {
            zi c = zi.c();
            int i2 = wq.c;
            String.format("Processor cancelling %s", new Object[]{str});
            c.a(new Throwable[0]);
            wqVar.f3401a.add(str);
            C0326sE sEVar = (C0326sE) wqVar.f3400a.remove(str);
            if (sEVar != null) {
                z = true;
            }
            if (sEVar == null) {
                sEVar = (C0326sE) wqVar.b.remove(str);
            }
            wq.b(str, sEVar);
            if (z) {
                wqVar.g();
            }
        }
        for (fv c2 : vd.f597a) {
            c2.c(str);
        }
    }

    public abstract void b();

    public final void run() {
        io ioVar = this.a;
        try {
            b();
            ioVar.a(C0218ho.f3000a);
        } catch (Throwable th) {
            ioVar.a(new C0218ho.a.C0031a(th));
        }
    }
}
