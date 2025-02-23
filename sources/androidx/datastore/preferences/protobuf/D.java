package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0135l;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.r;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MessageSetSchema */
public final class D<T> implements kv<T> {
    public final A a;

    /* renamed from: a  reason: collision with other field name */
    public final K<?, ?> f1908a;

    /* renamed from: a  reason: collision with other field name */
    public final C0133j<?> f1909a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1910a;

    public D(K<?, ?> k, C0133j<?> jVar, A a2) {
        this.f1908a = k;
        this.f1910a = jVar.e(a2);
        this.f1909a = jVar;
        this.a = a2;
    }

    public final void a(T t, G g, C0132i iVar) throws IOException {
        K<?, ?> k = this.f1908a;
        L f = k.f(t);
        C0133j<?> jVar = this.f1909a;
        C0135l<?> d = jVar.d(t);
        while (true) {
            try {
                if (g.getFieldNumber() != Integer.MAX_VALUE) {
                    if (!c(g, iVar, jVar, d, k, f)) {
                        break;
                    }
                } else {
                    break;
                }
            } finally {
                k.n(t, f);
            }
        }
    }

    public final void b(Object obj, C0130g gVar) throws IOException {
        Iterator<Map.Entry<?, Object>> k = this.f1909a.c(obj).k();
        while (k.hasNext()) {
            Map.Entry next = k.next();
            C0135l.a aVar = (C0135l.a) next.getKey();
            if (aVar.c() == HD.MESSAGE) {
                aVar.b();
                aVar.e();
                if (next instanceof r.a) {
                    aVar.g();
                    gVar.l(0, ((r.a) next).a.getValue().b());
                } else {
                    aVar.g();
                    gVar.l(0, next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        K<?, ?> k2 = this.f1908a;
        k2.r(k2.g(obj), gVar);
    }

    public final <UT, UB, ET extends C0135l.a<ET>> boolean c(G g, C0132i iVar, C0133j<ET> jVar, C0135l<ET> lVar, K<UT, UB> k, UB ub) throws IOException {
        int tag = g.getTag();
        A a2 = this.a;
        if (tag == 11) {
            n.e eVar = null;
            int i = 0;
            x3 x3Var = null;
            while (g.getFieldNumber() != Integer.MAX_VALUE) {
                int tag2 = g.getTag();
                if (tag2 == 16) {
                    i = g.readUInt32();
                    eVar = jVar.b(iVar, a2, i);
                } else if (tag2 == 26) {
                    if (eVar != null) {
                        jVar.h(eVar);
                    } else {
                        x3Var = g.b();
                    }
                } else if (!g.skipField()) {
                    break;
                }
            }
            if (g.getTag() == 12) {
                if (x3Var != null) {
                    if (eVar != null) {
                        jVar.i(eVar);
                    } else {
                        k.d(ub, i, x3Var);
                    }
                }
                return true;
            }
            throw new q("Protocol message end-group tag did not match expected tag.");
        } else if ((tag & 7) != 2) {
            return g.skipField();
        } else {
            n.e b = jVar.b(iVar, a2, tag >>> 3);
            if (b == null) {
                return k.l(ub, g);
            }
            jVar.h(b);
            return true;
        }
    }

    public final boolean equals(T t, T t2) {
        K<?, ?> k = this.f1908a;
        if (!k.g(t).equals(k.g(t2))) {
            return false;
        }
        if (!this.f1910a) {
            return true;
        }
        C0133j<?> jVar = this.f1909a;
        return jVar.c(t).equals(jVar.c(t2));
    }

    public final int getSerializedSize(T t) {
        J<T, Object> j;
        K<?, ?> k = this.f1908a;
        int i = 0;
        int i2 = k.i(k.g(t)) + 0;
        if (!this.f1910a) {
            return i2;
        }
        C0135l<?> c = this.f1909a.c(t);
        int i3 = 0;
        while (true) {
            j = c.f1931a;
            if (i >= j.d()) {
                break;
            }
            i3 += C0135l.f(j.c(i));
            i++;
        }
        for (Map.Entry<T, Object> f : j.e()) {
            i3 += C0135l.f(f);
        }
        return i2 + i3;
    }

    public final int hashCode(T t) {
        int hashCode = this.f1908a.g(t).hashCode();
        if (this.f1910a) {
            return (hashCode * 53) + this.f1909a.c(t).hashCode();
        }
        return hashCode;
    }

    public final boolean isInitialized(T t) {
        return this.f1909a.c(t).i();
    }

    public final void makeImmutable(T t) {
        this.f1908a.j(t);
        this.f1909a.f(t);
    }

    public final void mergeFrom(T t, T t2) {
        Class<?> cls = H.f1913a;
        K<?, ?> k = this.f1908a;
        k.o(t, k.k(k.g(t), k.g(t2)));
        if (this.f1910a) {
            H.B(this.f1909a, t, t2);
        }
    }

    public final T newInstance() {
        return this.a.b().g();
    }
}
