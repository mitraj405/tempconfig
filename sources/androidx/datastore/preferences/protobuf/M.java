package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: UnknownFieldSetLiteSchema */
public final class M extends K<L, L> {
    public final void a(Object obj, int i, int i2) {
        ((L) obj).b((i << 3) | 5, Integer.valueOf(i2));
    }

    public final void b(Object obj, int i, long j) {
        ((L) obj).b((i << 3) | 1, Long.valueOf(j));
    }

    public final void c(Object obj, int i, Object obj2) {
        ((L) obj).b((i << 3) | 3, (L) obj2);
    }

    public final void d(Object obj, int i, x3 x3Var) {
        ((L) obj).b((i << 3) | 2, x3Var);
    }

    public final void e(Object obj, int i, long j) {
        ((L) obj).b((i << 3) | 0, Long.valueOf(j));
    }

    public final L f(Object obj) {
        n nVar = (n) obj;
        L l = nVar.unknownFields;
        if (l != L.a) {
            return l;
        }
        L l2 = new L();
        nVar.unknownFields = l2;
        return l2;
    }

    public final L g(Object obj) {
        return ((n) obj).unknownFields;
    }

    public final int h(Object obj) {
        return ((L) obj).a();
    }

    public final int i(Object obj) {
        L l = (L) obj;
        int i = l.b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < l.f1922a; i3++) {
            i2 += s5.e(3, (x3) l.f1925a[i3]) + s5.w(2, l.f1924a[i3] >>> 3) + (s5.v(1) * 2);
        }
        l.b = i2;
        return i2;
    }

    public final void j(Object obj) {
        ((n) obj).unknownFields.f1923a = false;
    }

    public final L k(Object obj, Object obj2) {
        L l = (L) obj;
        L l2 = (L) obj2;
        if (l2.equals(L.a)) {
            return l;
        }
        int i = l.f1922a + l2.f1922a;
        int[] copyOf = Arrays.copyOf(l.f1924a, i);
        System.arraycopy(l2.f1924a, 0, copyOf, l.f1922a, l2.f1922a);
        Object[] copyOf2 = Arrays.copyOf(l.f1925a, i);
        System.arraycopy(l2.f1925a, 0, copyOf2, l.f1922a, l2.f1922a);
        return new L(i, copyOf, copyOf2, true);
    }

    public final L m() {
        return new L();
    }

    public final void n(Object obj, Object obj2) {
        ((n) obj).unknownFields = (L) obj2;
    }

    public final void o(Object obj, Object obj2) {
        ((n) obj).unknownFields = (L) obj2;
    }

    public final L q(Object obj) {
        L l = (L) obj;
        l.f1923a = false;
        return l;
    }

    public final void r(Object obj, C0130g gVar) throws IOException {
        L l = (L) obj;
        l.getClass();
        gVar.getClass();
        for (int i = 0; i < l.f1922a; i++) {
            gVar.l(l.f1924a[i] >>> 3, l.f1925a[i]);
        }
    }

    public final void s(Object obj, C0130g gVar) throws IOException {
        ((L) obj).c(gVar);
    }

    public final void p() {
    }
}
