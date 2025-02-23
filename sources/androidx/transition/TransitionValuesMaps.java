package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

public final class TransitionValuesMaps {
    public final SparseArray<View> a = new SparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    public final ArrayMap<View, TransitionValues> f2518a = new ArrayMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final LongSparseArray<View> f2519a = new LongSparseArray<>();
    public final ArrayMap<String, View> b = new ArrayMap<>();
}
