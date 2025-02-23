package com.google.common.collect;

import java.util.Comparator;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Comparator {
    public final /* synthetic */ Comparator a;

    public /* synthetic */ b(Comparator comparator) {
        this.a = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.a.compare(((PeekingIterator) obj).peek(), ((PeekingIterator) obj2).peek());
    }
}
