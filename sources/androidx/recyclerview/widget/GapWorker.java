package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public final class GapWorker implements Runnable {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final ThreadLocal<GapWorker> f2281a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    public long f2282a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<RecyclerView> f2283a = new ArrayList<>();
    public long b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<b> f2284b = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public int[] f2285a;
        public int b;
        public int c;

        public final void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.c * 2;
                int[] iArr = this.f2285a;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f2285a = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.f2285a = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f2285a;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.c++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public final void b(RecyclerView recyclerView, boolean z) {
            this.c = 0;
            int[] iArr = this.f2285a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.g()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.a, this.b, recyclerView.mState, this);
                }
                int i = this.c;
                if (i > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = i;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.o();
                }
            }
        }
    }

    public class a implements Comparator<b> {
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r0 == null) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r0 != false) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int compare(java.lang.Object r7, java.lang.Object r8) {
            /*
                r6 = this;
                androidx.recyclerview.widget.GapWorker$b r7 = (androidx.recyclerview.widget.GapWorker.b) r7
                androidx.recyclerview.widget.GapWorker$b r8 = (androidx.recyclerview.widget.GapWorker.b) r8
                androidx.recyclerview.widget.RecyclerView r0 = r7.f2286a
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L_0x000c
                r3 = r2
                goto L_0x000d
            L_0x000c:
                r3 = r1
            L_0x000d:
                androidx.recyclerview.widget.RecyclerView r4 = r8.f2286a
                if (r4 != 0) goto L_0x0013
                r4 = r2
                goto L_0x0014
            L_0x0013:
                r4 = r1
            L_0x0014:
                r5 = -1
                if (r3 == r4) goto L_0x001d
                if (r0 != 0) goto L_0x001b
            L_0x0019:
                r1 = r2
                goto L_0x0037
            L_0x001b:
                r1 = r5
                goto L_0x0037
            L_0x001d:
                boolean r0 = r7.f2287a
                boolean r3 = r8.f2287a
                if (r0 == r3) goto L_0x0026
                if (r0 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0026:
                int r0 = r8.a
                int r2 = r7.a
                int r0 = r0 - r2
                if (r0 == 0) goto L_0x002f
                r1 = r0
                goto L_0x0037
            L_0x002f:
                int r7 = r7.b
                int r8 = r8.b
                int r7 = r7 - r8
                if (r7 == 0) goto L_0x0037
                r1 = r7
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GapWorker.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    public static class b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public RecyclerView f2286a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2287a;
        public int b;
        public int c;
    }

    public static RecyclerView.ViewHolder c(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int h = recyclerView.mChildHelper.h();
        int i2 = 0;
        while (true) {
            if (i2 >= h) {
                z = false;
                break;
            }
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.g(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.ViewHolder m = recycler.m(j, i);
            if (m != null) {
                if (!m.isBound() || m.isInvalid()) {
                    recycler.a(m, false);
                } else {
                    recycler.j(m.itemView);
                }
            }
            return m;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow()) {
            if (RecyclerView.sDebugAssertionsEnabled && !this.f2283a.contains(recyclerView)) {
                throw new IllegalStateException("attempting to post unregistered view!");
            } else if (this.f2282a == 0) {
                this.f2282a = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
        layoutPrefetchRegistryImpl.a = i;
        layoutPrefetchRegistryImpl.b = i2;
    }

    public final void b(long j) {
        b bVar;
        RecyclerView recyclerView;
        long j2;
        RecyclerView recyclerView2;
        b bVar2;
        boolean z;
        ArrayList<RecyclerView> arrayList = this.f2283a;
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = arrayList.get(i2);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.mPrefetchRegistry.b(recyclerView3, false);
                i += recyclerView3.mPrefetchRegistry.c;
            }
        }
        ArrayList<b> arrayList2 = this.f2284b;
        arrayList2.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView4 = arrayList.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView4.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.b) + Math.abs(layoutPrefetchRegistryImpl.a);
                for (int i5 = 0; i5 < layoutPrefetchRegistryImpl.c * 2; i5 += 2) {
                    if (i3 >= arrayList2.size()) {
                        bVar2 = new b();
                        arrayList2.add(bVar2);
                    } else {
                        bVar2 = arrayList2.get(i3);
                    }
                    int[] iArr = layoutPrefetchRegistryImpl.f2285a;
                    int i6 = iArr[i5 + 1];
                    if (i6 <= abs) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar2.f2287a = z;
                    bVar2.a = abs;
                    bVar2.b = i6;
                    bVar2.f2286a = recyclerView4;
                    bVar2.c = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(arrayList2, a);
        for (int i7 = 0; i7 < arrayList2.size() && (recyclerView = bVar.f2286a) != null; i7++) {
            if ((bVar = arrayList2.get(i7)).f2287a) {
                j2 = Long.MAX_VALUE;
            } else {
                j2 = j;
            }
            RecyclerView.ViewHolder c = c(recyclerView, bVar.c, j2);
            if (!(c == null || c.mNestedRecyclerView == null || !c.isBound() || c.isInvalid() || (recyclerView2 = c.mNestedRecyclerView.get()) == null)) {
                if (recyclerView2.mDataSetHasChangedAfterLayout && recyclerView2.mChildHelper.h() != 0) {
                    recyclerView2.removeAndRecycleViews();
                }
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl2 = recyclerView2.mPrefetchRegistry;
                layoutPrefetchRegistryImpl2.b(recyclerView2, true);
                if (layoutPrefetchRegistryImpl2.c != 0) {
                    try {
                        int i8 = C0337tA.a;
                        Trace.beginSection("RV Nested Prefetch");
                        RecyclerView.State state = recyclerView2.mState;
                        RecyclerView.Adapter adapter = recyclerView2.mAdapter;
                        state.d = 1;
                        state.e = adapter.getItemCount();
                        state.f2324b = false;
                        state.f2325c = false;
                        state.f2326d = false;
                        for (int i9 = 0; i9 < layoutPrefetchRegistryImpl2.c * 2; i9 += 2) {
                            c(recyclerView2, layoutPrefetchRegistryImpl2.f2285a[i9], j);
                        }
                        long j3 = j;
                        Trace.endSection();
                        bVar.f2287a = false;
                        bVar.a = 0;
                        bVar.b = 0;
                        bVar.f2286a = null;
                        bVar.c = 0;
                    } catch (Throwable th) {
                        int i10 = C0337tA.a;
                        Trace.endSection();
                        throw th;
                    }
                }
            }
            long j4 = j;
            bVar.f2287a = false;
            bVar.a = 0;
            bVar.b = 0;
            bVar.f2286a = null;
            bVar.c = 0;
        }
    }

    public final void run() {
        try {
            int i = C0337tA.a;
            Trace.beginSection("RV Prefetch");
            ArrayList<RecyclerView> arrayList = this.f2283a;
            if (arrayList.isEmpty()) {
                this.f2282a = 0;
                Trace.endSection();
                return;
            }
            int size = arrayList.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView recyclerView = arrayList.get(i2);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.f2282a = 0;
                Trace.endSection();
                return;
            }
            b(TimeUnit.MILLISECONDS.toNanos(j) + this.b);
            this.f2282a = 0;
            Trace.endSection();
        } catch (Throwable th) {
            this.f2282a = 0;
            int i3 = C0337tA.a;
            Trace.endSection();
            throw th;
        }
    }
}
