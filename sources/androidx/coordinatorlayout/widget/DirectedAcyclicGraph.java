package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;

public final class DirectedAcyclicGraph<T> {
    public final Pp a = new Pp(10);

    /* renamed from: a  reason: collision with other field name */
    public final SimpleArrayMap<T, ArrayList<T>> f1721a = new SimpleArrayMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<T> f1722a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashSet<T> f1723a = new HashSet<>();

    public final void a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (!hashSet.contains(t)) {
                hashSet.add(t);
                ArrayList orDefault = this.f1721a.getOrDefault(t, null);
                if (orDefault != null) {
                    int size = orDefault.size();
                    for (int i = 0; i < size; i++) {
                        a(orDefault.get(i), arrayList, hashSet);
                    }
                }
                hashSet.remove(t);
                arrayList.add(t);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }
}
