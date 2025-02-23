package org.spongycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionStore<T> implements Store<T>, Iterable<T> {
    public final Collection<T> a(Selector<T> selector) {
        if (selector == null) {
            return new ArrayList((Collection) null);
        }
        new ArrayList();
        throw null;
    }

    public final Iterator<T> iterator() {
        return ((ArrayList) a((Selector) null)).iterator();
    }
}
