package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.recyclerview.widget.RecyclerView;

public final class ViewInfoStore {
    public final LongSparseArray<RecyclerView.ViewHolder> a = new LongSparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    public final SimpleArrayMap<RecyclerView.ViewHolder, a> f2362a = new SimpleArrayMap<>();

    public interface ProcessCallback {
        void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void b(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2);

        void d(RecyclerView.ViewHolder viewHolder);
    }

    public static class a {
        public static final Pp a = new Pp(20);

        /* renamed from: a  reason: collision with other field name */
        public int f2363a;

        /* renamed from: a  reason: collision with other field name */
        public RecyclerView.ItemAnimator.ItemHolderInfo f2364a;
        public RecyclerView.ItemAnimator.ItemHolderInfo b;

        public static a a() {
            a aVar = (a) a.b();
            if (aVar == null) {
                return new a();
            }
            return aVar;
        }
    }

    public final void a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo) {
        SimpleArrayMap<RecyclerView.ViewHolder, a> simpleArrayMap = this.f2362a;
        a orDefault = simpleArrayMap.getOrDefault(viewHolder, null);
        if (orDefault == null) {
            orDefault = a.a();
            simpleArrayMap.put(viewHolder, orDefault);
        }
        orDefault.b = itemHolderInfo;
        orDefault.f2363a |= 8;
    }

    public final RecyclerView.ItemAnimator.ItemHolderInfo b(RecyclerView.ViewHolder viewHolder, int i) {
        a j;
        RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo;
        SimpleArrayMap<RecyclerView.ViewHolder, a> simpleArrayMap = this.f2362a;
        int e = simpleArrayMap.e(viewHolder);
        if (e >= 0 && (j = simpleArrayMap.j(e)) != null) {
            int i2 = j.f2363a;
            if ((i2 & i) != 0) {
                int i3 = i2 & (~i);
                j.f2363a = i3;
                if (i == 4) {
                    itemHolderInfo = j.f2364a;
                } else if (i == 8) {
                    itemHolderInfo = j.b;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    simpleArrayMap.i(e);
                    j.f2363a = 0;
                    j.f2364a = null;
                    j.b = null;
                    a.a.a(j);
                }
                return itemHolderInfo;
            }
        }
        return null;
    }

    public final void c(RecyclerView.ViewHolder viewHolder) {
        a orDefault = this.f2362a.getOrDefault(viewHolder, null);
        if (orDefault != null) {
            orDefault.f2363a &= -2;
        }
    }

    public final void d(RecyclerView.ViewHolder viewHolder) {
        LongSparseArray<RecyclerView.ViewHolder> longSparseArray = this.a;
        int f = longSparseArray.f() - 1;
        while (true) {
            if (f < 0) {
                break;
            } else if (viewHolder == longSparseArray.g(f)) {
                Object[] objArr = longSparseArray.f1326a;
                Object obj = objArr[f];
                Object obj2 = LongSparseArray.a;
                if (obj != obj2) {
                    objArr[f] = obj2;
                    longSparseArray.f1324a = true;
                }
            } else {
                f--;
            }
        }
        a remove = this.f2362a.remove(viewHolder);
        if (remove != null) {
            remove.f2363a = 0;
            remove.f2364a = null;
            remove.b = null;
            a.a.a(remove);
        }
    }
}
