package androidx.collection;

import defpackage.C0282nk;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class ArrayMap<K, V> extends SimpleArrayMap<K, V> implements Map<K, V> {
    public a a;

    public ArrayMap() {
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.a == null) {
            this.a = new a(this);
        }
        a aVar = this.a;
        if (aVar.a == null) {
            aVar.a = new C0282nk.b();
        }
        return aVar.a;
    }

    public final Set<K> keySet() {
        if (this.a == null) {
            this.a = new a(this);
        }
        a aVar = this.a;
        if (aVar.f3113a == null) {
            aVar.f3113a = new C0282nk.c();
        }
        return aVar.f3113a;
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        b(map.size() + this.f1328c);
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public final Collection<V> values() {
        if (this.a == null) {
            this.a = new a(this);
        }
        a aVar = this.a;
        if (aVar.f3114a == null) {
            aVar.f3114a = new C0282nk.e();
        }
        return aVar.f3114a;
    }

    public ArrayMap(int i) {
        super(i);
    }

    public ArrayMap(ArrayMap arrayMap) {
        super(arrayMap);
    }
}
