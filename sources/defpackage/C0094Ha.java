package defpackage;

/* renamed from: Ha  reason: default package and case insensitive filesystem */
/* compiled from: EntityInsertionAdapter */
public abstract class C0094Ha<T> extends Cw {
    public C0094Ha(Zt zt) {
        super(zt);
    }

    public abstract void d(C0085Cd cd, T t);

    public final void e(T t) {
        C0085Cd a = a();
        try {
            d(a, t);
            a.a.executeInsert();
        } finally {
            c(a);
        }
    }
}
