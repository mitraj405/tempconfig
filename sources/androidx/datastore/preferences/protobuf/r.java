package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: LazyField */
public final class r extends s {

    /* compiled from: LazyField */
    public static class a<K> implements Map.Entry<K, Object> {
        public final Map.Entry<K, r> a;

        public a() {
            throw null;
        }

        public a(Map.Entry entry) {
            this.a = entry;
        }

        public final K getKey() {
            return this.a.getKey();
        }

        public final Object getValue() {
            r value = this.a.getValue();
            if (value == null) {
                return null;
            }
            return value.a((A) null);
        }

        public final Object setValue(Object obj) {
            if (obj instanceof A) {
                r value = this.a.getValue();
                A a2 = value.a;
                value.f1936a = null;
                value.a = (A) obj;
                return a2;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: LazyField */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {
        public final Iterator<Map.Entry<K, Object>> a;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.a = it;
        }

        public final boolean hasNext() {
            return this.a.hasNext();
        }

        public final Object next() {
            Map.Entry next = this.a.next();
            if (next.getValue() instanceof r) {
                return new a(next);
            }
            return next;
        }

        public final void remove() {
            this.a.remove();
        }
    }

    public final boolean equals(Object obj) {
        return a((A) null).equals(obj);
    }

    public final int hashCode() {
        return a((A) null).hashCode();
    }

    public final String toString() {
        return a((A) null).toString();
    }
}
