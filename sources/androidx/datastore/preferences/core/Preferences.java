package androidx.datastore.preferences.core;

import java.util.Map;

/* compiled from: Preferences.kt */
public abstract class Preferences {

    /* compiled from: Preferences.kt */
    public static final class Key<T> {
        public final String a;

        public Key(String str) {
            this.a = str;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            return C1177ig.a(this.a, ((Key) obj).a);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return this.a;
        }
    }

    /* compiled from: Preferences.kt */
    public static final class a<T> {
    }

    public abstract Map<Key<?>, Object> a();

    public abstract <T> T b(Key<T> key);
}
