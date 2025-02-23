package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;

/* compiled from: Preferences.kt */
public final class MutablePreferences extends Preferences {
    public final Map<Preferences.Key<?>, Object> a;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicBoolean f1892a;

    /* compiled from: Preferences.kt */
    public static final class a extends C0595Mh implements Function1<Map.Entry<Preferences.Key<?>, Object>, CharSequence> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            C1177ig.f(entry, "entry");
            return "  " + ((Preferences.Key) entry.getKey()).a + " = " + entry.getValue();
        }
    }

    public MutablePreferences() {
        this(false, 3);
    }

    public final Map<Preferences.Key<?>, Object> a() {
        Map<Preferences.Key<?>, Object> unmodifiableMap = Collections.unmodifiableMap(this.a);
        C1177ig.e(unmodifiableMap, "unmodifiableMap(preferencesMap)");
        return unmodifiableMap;
    }

    public final <T> T b(Preferences.Key<T> key) {
        C1177ig.f(key, "key");
        return this.a.get(key);
    }

    public final void c() {
        if (!(!this.f1892a.get())) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.".toString());
        }
    }

    public final void d(Preferences.Key<?> key, Object obj) {
        C1177ig.f(key, "key");
        c();
        Map<Preferences.Key<?>, Object> map = this.a;
        if (obj == null) {
            c();
            map.remove(key);
        } else if (obj instanceof Set) {
            Set unmodifiableSet = Collections.unmodifiableSet(C1472x5.c0((Iterable) obj));
            C1177ig.e(unmodifiableSet, "unmodifiableSet(value.toSet())");
            map.put(key, unmodifiableSet);
        } else {
            map.put(key, obj);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof MutablePreferences)) {
            return false;
        }
        return C1177ig.a(this.a, ((MutablePreferences) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return C1472x5.Z(this.a.entrySet(), ",\n", "{\n", "\n}", a.a, 24);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutablePreferences(boolean z, int i) {
        this((Map<Preferences.Key<?>, Object>) (i & 1) != 0 ? new LinkedHashMap() : null, (i & 2) != 0 ? true : z);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> map, boolean z) {
        C1177ig.f(map, "preferencesMap");
        this.a = map;
        this.f1892a = new AtomicBoolean(z);
    }
}
