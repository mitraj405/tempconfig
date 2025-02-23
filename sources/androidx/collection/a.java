package androidx.collection;

import java.util.Map;

/* compiled from: ArrayMap */
public final class a extends C0282nk<Object, Object> {
    public final /* synthetic */ ArrayMap a;

    public a(ArrayMap arrayMap) {
        this.a = arrayMap;
    }

    public final void a() {
        this.a.clear();
    }

    public final Object b(int i, int i2) {
        return this.a.f1327a[(i << 1) + i2];
    }

    public final Map<Object, Object> c() {
        return this.a;
    }

    public final int d() {
        return this.a.f1328c;
    }

    public final int e(Object obj) {
        return this.a.e(obj);
    }

    public final int f(Object obj) {
        return this.a.g(obj);
    }

    public final void g(Object obj, Object obj2) {
        this.a.put(obj, obj2);
    }

    public final void h(int i) {
        this.a.i(i);
    }

    public final Object i(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.a.f1327a;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }
}
