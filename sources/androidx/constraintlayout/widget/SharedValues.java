package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

public final class SharedValues {
    public final HashMap<Integer, HashSet<WeakReference<a>>> a = new HashMap<>();

    public interface a {
    }

    public SharedValues() {
        new SparseIntArray();
    }

    public final void a(int i, a aVar) {
        HashMap<Integer, HashSet<WeakReference<a>>> hashMap = this.a;
        HashSet hashSet = hashMap.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet();
            hashMap.put(Integer.valueOf(i), hashSet);
        }
        hashSet.add(new WeakReference(aVar));
    }
}
