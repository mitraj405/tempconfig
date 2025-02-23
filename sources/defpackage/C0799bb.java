package defpackage;

import java.io.Serializable;
import java.util.Queue;

/* renamed from: bb  reason: default package and case insensitive filesystem */
/* compiled from: EventRecodingLogger */
public final class C0799bb implements Bi {
    public final By a;

    /* renamed from: a  reason: collision with other field name */
    public final Queue<C0490Dy> f3913a;
    public final String c;

    public C0799bb(By by, Queue<C0490Dy> queue) {
        this.a = by;
        this.c = by.c;
        this.f3913a = queue;
    }

    public final void a(Object obj, String str, Serializable serializable) {
        h(obj, serializable);
    }

    public final void b(String str) {
        g((Object[]) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r3, java.lang.Object... r4) {
        /*
            r2 = this;
            int r3 = r4.length
            if (r3 != 0) goto L_0x0004
            goto L_0x0010
        L_0x0004:
            int r3 = r4.length
            int r3 = r3 + -1
            r3 = r4[r3]
            boolean r0 = r3 instanceof java.lang.Throwable
            if (r0 == 0) goto L_0x0010
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            goto L_0x0011
        L_0x0010:
            r3 = 0
        L_0x0011:
            if (r3 == 0) goto L_0x002d
            int r3 = r4.length
            if (r3 == 0) goto L_0x0025
            int r3 = r4.length
            int r3 = r3 + -1
            java.lang.Object[] r0 = new java.lang.Object[r3]
            if (r3 <= 0) goto L_0x0021
            r1 = 0
            java.lang.System.arraycopy(r4, r1, r0, r1, r3)
        L_0x0021:
            r2.g(r0)
            goto L_0x0030
        L_0x0025:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "non-sensical empty or null argument array"
            r3.<init>(r4)
            throw r3
        L_0x002d:
            r2.g(r4)
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0799bb.c(java.lang.String, java.lang.Object[]):void");
    }

    public final boolean d() {
        return true;
    }

    public final void e(Object obj, String str) {
        g(new Object[]{obj});
    }

    public final void f(String str, Throwable th) {
        g((Object[]) null);
    }

    public final void g(Object[] objArr) {
        C0490Dy dy = new C0490Dy();
        System.currentTimeMillis();
        dy.a = this.a;
        Thread.currentThread().getName();
        dy.f3570a = objArr;
        this.f3913a.add(dy);
    }

    public final String getName() {
        return this.c;
    }

    public final void h(Object obj, Serializable serializable) {
        if (serializable instanceof Throwable) {
            Throwable th = (Throwable) serializable;
            g(new Object[]{obj});
            return;
        }
        g(new Object[]{obj, serializable});
    }
}
