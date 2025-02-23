package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Comparator;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ Comparator b;

    public /* synthetic */ c(Comparator comparator, Comparator comparator2) {
        this.a = comparator;
        this.b = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return RegularImmutableTable.lambda$forCells$0(this.a, this.b, (Table.Cell) obj, (Table.Cell) obj2);
    }
}
