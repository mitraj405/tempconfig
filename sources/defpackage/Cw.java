package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: Cw  reason: default package */
/* compiled from: SharedSQLiteStatement */
public abstract class Cw {
    public volatile C0085Cd a;

    /* renamed from: a  reason: collision with other field name */
    public final Zt f96a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicBoolean f97a = new AtomicBoolean(false);

    public Cw(Zt zt) {
        this.f96a = zt;
    }

    public final C0085Cd a() {
        this.f96a.a();
        if (this.f97a.compareAndSet(false, true)) {
            if (this.a == null) {
                String b = b();
                Zt zt = this.f96a;
                zt.a();
                zt.b();
                this.a = new C0085Cd(((C0408yd) zt.f768a.f()).f3431a.compileStatement(b));
            }
            return this.a;
        }
        String b2 = b();
        Zt zt2 = this.f96a;
        zt2.a();
        zt2.b();
        return new C0085Cd(((C0408yd) zt2.f768a.f()).f3431a.compileStatement(b2));
    }

    public abstract String b();

    public final void c(C0085Cd cd) {
        if (cd == this.a) {
            this.f97a.set(false);
        }
    }
}
