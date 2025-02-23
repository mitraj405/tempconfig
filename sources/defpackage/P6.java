package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: P6  reason: default package */
/* compiled from: ConstraintController */
public abstract class P6<T> implements Q6<T> {
    public a a;

    /* renamed from: a  reason: collision with other field name */
    public final R6<T> f478a;

    /* renamed from: a  reason: collision with other field name */
    public T f479a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f480a = new ArrayList();

    /* renamed from: P6$a */
    /* compiled from: ConstraintController */
    public interface a {
    }

    public P6(R6<T> r6) {
        this.f478a = r6;
    }

    public final void a(T t) {
        this.f479a = t;
        e(this.a, t);
    }

    public abstract boolean b(C0214hE hEVar);

    public abstract boolean c(T t);

    public final void d(Collection collection) {
        this.f480a.clear();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C0214hE hEVar = (C0214hE) it.next();
            if (b(hEVar)) {
                this.f480a.add(hEVar.f2991a);
            }
        }
        if (this.f480a.isEmpty()) {
            R6<T> r6 = this.f478a;
            synchronized (r6.f494a) {
                if (r6.f495a.remove(this) && r6.f495a.isEmpty()) {
                    r6.d();
                }
            }
        } else {
            R6<T> r62 = this.f478a;
            synchronized (r62.f494a) {
                if (r62.f495a.add(this)) {
                    if (r62.f495a.size() == 1) {
                        r62.b = r62.a();
                        zi c = zi.c();
                        int i = R6.a;
                        String.format("%s: initial state = %s", new Object[]{r62.getClass().getSimpleName(), r62.b});
                        c.a(new Throwable[0]);
                        r62.c();
                    }
                    a(r62.b);
                }
            }
        }
        e(this.a, this.f479a);
    }

    public final void e(a aVar, T t) {
        if (!this.f480a.isEmpty() && aVar != null) {
            if (t == null || c(t)) {
                ArrayList arrayList = this.f480a;
                MD md = (MD) aVar;
                synchronized (md.f405a) {
                    LD ld = md.f404a;
                    if (ld != null) {
                        ld.f(arrayList);
                    }
                }
                return;
            }
            ArrayList arrayList2 = this.f480a;
            MD md2 = (MD) aVar;
            synchronized (md2.f405a) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (md2.a(str)) {
                        zi c = zi.c();
                        int i = MD.a;
                        String.format("Constraints met for %s", new Object[]{str});
                        c.a(new Throwable[0]);
                        arrayList3.add(str);
                    }
                }
                LD ld2 = md2.f404a;
                if (ld2 != null) {
                    ld2.a(arrayList3);
                }
            }
        }
    }
}
