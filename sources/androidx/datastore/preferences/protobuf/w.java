package androidx.datastore.preferences.protobuf;

import defpackage.GD;
import java.io.IOException;

/* compiled from: MapEntryLite */
public final class w<K, V> {
    public final a<K, V> a;

    /* renamed from: a  reason: collision with other field name */
    public final K f1938a = "";
    public final V b;

    /* compiled from: MapEntryLite */
    public static class a<K, V> {
        public final GD a;

        /* renamed from: a  reason: collision with other field name */
        public final K f1939a = "";
        public final GD b;

        /* renamed from: b  reason: collision with other field name */
        public final V f1940b;

        public a(GD.a aVar, GD.c cVar, C0262lq lqVar) {
            this.a = aVar;
            this.b = cVar;
            this.f1940b = lqVar;
        }
    }

    public w(GD.a aVar, GD.c cVar, C0262lq lqVar) {
        this.a = new a<>(aVar, cVar, lqVar);
        this.b = lqVar;
    }

    public static <K, V> int a(a<K, V> aVar, K k, V v) {
        return C0135l.b(aVar.b, 2, v) + C0135l.b(aVar.a, 1, k);
    }

    public static <K, V> void b(s5 s5Var, a<K, V> aVar, K k, V v) throws IOException {
        C0135l.o(s5Var, aVar.a, 1, k);
        C0135l.o(s5Var, aVar.b, 2, v);
    }
}
