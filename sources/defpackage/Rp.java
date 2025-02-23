package defpackage;

/* renamed from: Rp  reason: default package */
/* compiled from: Pools.kt */
public final class Rp<T> extends Pp<T> {
    public final Object a = new Object();

    public Rp(int i) {
        super(i);
    }

    public final boolean a(T t) {
        boolean a2;
        C1177ig.f(t, "instance");
        synchronized (this.a) {
            a2 = super.a(t);
        }
        return a2;
    }

    public final T b() {
        T b;
        synchronized (this.a) {
            b = super.b();
        }
        return b;
    }
}
