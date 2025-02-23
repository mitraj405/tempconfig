package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0132i;
import androidx.datastore.preferences.protobuf.n;
import java.io.IOException;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.k  reason: case insensitive filesystem */
/* compiled from: ExtensionSchemaLite */
public final class C0134k extends C0133j<n.d> {
    public final void a(Map.Entry entry) {
        ((n.d) entry.getKey()).getClass();
    }

    public final n.e b(C0132i iVar, A a, int i) {
        iVar.getClass();
        return iVar.f1929a.get(new C0132i.a(a, i));
    }

    public final C0135l<n.d> c(Object obj) {
        return ((n.c) obj).extensions;
    }

    public final C0135l<n.d> d(Object obj) {
        n.c cVar = (n.c) obj;
        C0135l<n.d> lVar = cVar.extensions;
        if (lVar.f1932a) {
            cVar.extensions = lVar.clone();
        }
        return cVar.extensions;
    }

    public final boolean e(A a) {
        return a instanceof n.c;
    }

    public final void f(Object obj) {
        C0135l<n.d> lVar = ((n.c) obj).extensions;
        if (!lVar.f1932a) {
            lVar.f1931a.g();
            lVar.f1932a = true;
        }
    }

    public final Object g(Object obj) throws IOException {
        n.e eVar = (n.e) obj;
        throw null;
    }

    public final void h(Object obj) throws IOException {
        n.e eVar = (n.e) obj;
        throw null;
    }

    public final void i(Object obj) throws IOException {
        n.e eVar = (n.e) obj;
        throw null;
    }

    public final void j(Map.Entry entry) throws IOException {
        ((n.d) entry.getKey()).getClass();
        throw null;
    }
}
