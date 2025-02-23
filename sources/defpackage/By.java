package defpackage;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: By  reason: default package */
/* compiled from: SubstituteLogger */
public final class By implements Bi {
    public volatile Bi a;

    /* renamed from: a  reason: collision with other field name */
    public C0799bb f3539a;

    /* renamed from: a  reason: collision with other field name */
    public Boolean f3540a;

    /* renamed from: a  reason: collision with other field name */
    public Method f3541a;

    /* renamed from: a  reason: collision with other field name */
    public final Queue<C0490Dy> f3542a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3543a;
    public final String c;

    public By(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z) {
        this.c = str;
        this.f3542a = linkedBlockingQueue;
        this.f3543a = z;
    }

    public final void a(Object obj, String str, Serializable serializable) {
        g().a(obj, str, serializable);
    }

    public final void b(String str) {
        g().b(str);
    }

    public final void c(String str, Object... objArr) {
        g().c(str, objArr);
    }

    public final boolean d() {
        return g().d();
    }

    public final void e(Object obj, String str) {
        g().e(obj, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || By.class != obj.getClass() || !this.c.equals(((By) obj).c)) {
            return false;
        }
        return true;
    }

    public final void f(String str, Throwable th) {
        g().f(str, th);
    }

    public final Bi g() {
        if (this.a != null) {
            return this.a;
        }
        if (this.f3543a) {
            return C1351qm.a;
        }
        if (this.f3539a == null) {
            this.f3539a = new C0799bb(this, this.f3542a);
        }
        return this.f3539a;
    }

    public final String getName() {
        return this.c;
    }

    public final boolean h() {
        Boolean bool = this.f3540a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f3541a = this.a.getClass().getMethod("log", new Class[]{C0485Di.class});
            this.f3540a = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f3540a = Boolean.FALSE;
        }
        return this.f3540a.booleanValue();
    }

    public final int hashCode() {
        return this.c.hashCode();
    }
}
