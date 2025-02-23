package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Predicate {
    public final /* synthetic */ Predicate a;

    public /* synthetic */ a(Predicate predicate) {
        this.a = predicate;
    }

    public final boolean apply(Object obj) {
        return this.a.apply(Multisets.immutableEntry(((Map.Entry) obj).getKey(), ((Collection) ((Map.Entry) obj).getValue()).size()));
    }
}
