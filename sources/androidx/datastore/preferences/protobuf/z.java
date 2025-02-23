package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;
import java.util.Map;

/* compiled from: MapFieldSchemaLite */
public final class z implements y {
    public final x a(Object obj) {
        return (x) obj;
    }

    public final x b(Object obj) {
        return (x) obj;
    }

    public final x c() {
        return x.a.c();
    }

    public final x d(Object obj, Object obj2) {
        x xVar = (x) obj;
        x xVar2 = (x) obj2;
        if (!xVar2.isEmpty()) {
            if (!xVar.f1941a) {
                xVar = xVar.c();
            }
            xVar.b();
            if (!xVar2.isEmpty()) {
                xVar.putAll(xVar2);
            }
        }
        return xVar;
    }

    public final w.a<?, ?> e(Object obj) {
        return ((w) obj).a;
    }

    public final int getSerializedSize(int i, Object obj, Object obj2) {
        x xVar = (x) obj;
        w wVar = (w) obj2;
        int i2 = 0;
        if (!xVar.isEmpty()) {
            for (Map.Entry entry : xVar.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                wVar.getClass();
                int v = s5.v(i);
                int a = w.a(wVar.a, key, value);
                i2 += s5.x(a) + a + v;
            }
        }
        return i2;
    }

    public final boolean isImmutable(Object obj) {
        return !((x) obj).f1941a;
    }

    public final Object toImmutable(Object obj) {
        ((x) obj).f1941a = false;
        return obj;
    }
}
