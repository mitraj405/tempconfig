package butterknife.internal;

import java.util.AbstractList;
import java.util.RandomAccess;

final class ImmutableList<T> extends AbstractList<T> implements RandomAccess {
    private final T[] views;

    public ImmutableList(T[] tArr) {
        this.views = tArr;
    }

    public boolean contains(Object obj) {
        for (T t : this.views) {
            if (t == obj) {
                return true;
            }
        }
        return false;
    }

    public T get(int i) {
        return this.views[i];
    }

    public int size() {
        return this.views.length;
    }
}
