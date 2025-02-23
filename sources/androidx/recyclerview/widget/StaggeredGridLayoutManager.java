package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.a {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2333a;

    /* renamed from: a  reason: collision with other field name */
    public OrientationHelper f2334a;

    /* renamed from: a  reason: collision with other field name */
    public final LazySpanLookup f2335a;

    /* renamed from: a  reason: collision with other field name */
    public SavedState f2336a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2337a;

    /* renamed from: a  reason: collision with other field name */
    public final b f2338a;

    /* renamed from: a  reason: collision with other field name */
    public final h f2339a;

    /* renamed from: a  reason: collision with other field name */
    public BitSet f2340a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2341a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f2342a;

    /* renamed from: a  reason: collision with other field name */
    public c[] f2343a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public OrientationHelper f2344b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2345b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2346c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f2347d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public final boolean f2348e;
    public final int f;

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public c a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public List<LazySpanLookup.FullSpanItem> a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2351a;

        /* renamed from: a  reason: collision with other field name */
        public int[] f2352a;
        public boolean b;

        /* renamed from: b  reason: collision with other field name */
        public int[] f2353b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f2354c;
        public int d;
        public int e;
        public int f;

        public class a implements Parcelable.Creator<SavedState> {
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            if (this.e > 0) {
                parcel.writeIntArray(this.f2352a);
            }
            parcel.writeInt(this.f);
            if (this.f > 0) {
                parcel.writeIntArray(this.f2353b);
            }
            parcel.writeInt(this.f2351a ? 1 : 0);
            parcel.writeInt(this.b ? 1 : 0);
            parcel.writeInt(this.f2354c ? 1 : 0);
            parcel.writeList(this.a);
        }

        public SavedState(Parcel parcel) {
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            int readInt = parcel.readInt();
            this.e = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f2352a = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f2353b = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z = false;
            this.f2351a = parcel.readInt() == 1;
            this.b = parcel.readInt() == 1;
            this.f2354c = parcel.readInt() == 1 ? true : z;
            this.a = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.e = savedState.e;
            this.c = savedState.c;
            this.d = savedState.d;
            this.f2352a = savedState.f2352a;
            this.f = savedState.f;
            this.f2353b = savedState.f2353b;
            this.f2351a = savedState.f2351a;
            this.b = savedState.b;
            this.f2354c = savedState.f2354c;
            this.a = savedState.a;
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            StaggeredGridLayoutManager.this.b();
        }
    }

    public class b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2356a;

        /* renamed from: a  reason: collision with other field name */
        public int[] f2357a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f2358b;
        public boolean c;

        public b() {
            a();
        }

        public final void a() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.f2356a = false;
            this.f2358b = false;
            this.c = false;
            int[] iArr = this.f2357a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    public class c {
        public int a = Integer.MIN_VALUE;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<View> f2360a = new ArrayList<>();
        public int b = Integer.MIN_VALUE;
        public int c = 0;
        public final int d;

        public c(int i) {
            this.d = i;
        }

        public static LayoutParams h(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        public final void a() {
            ArrayList<View> arrayList = this.f2360a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams h = h(view);
            this.b = StaggeredGridLayoutManager.this.f2334a.b(view);
            h.getClass();
        }

        public final void b() {
            this.f2360a.clear();
            this.a = Integer.MIN_VALUE;
            this.b = Integer.MIN_VALUE;
            this.c = 0;
        }

        public final int c() {
            boolean z = StaggeredGridLayoutManager.this.f2341a;
            ArrayList<View> arrayList = this.f2360a;
            if (z) {
                return e(arrayList.size() - 1, -1);
            }
            return e(0, arrayList.size());
        }

        public final int d() {
            boolean z = StaggeredGridLayoutManager.this.f2341a;
            ArrayList<View> arrayList = this.f2360a;
            if (z) {
                return e(0, arrayList.size());
            }
            return e(arrayList.size() - 1, -1);
        }

        public final int e(int i, int i2) {
            int i3;
            boolean z;
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            int k = staggeredGridLayoutManager.f2334a.k();
            int g = staggeredGridLayoutManager.f2334a.g();
            if (i2 > i) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            while (i != i2) {
                View view = this.f2360a.get(i);
                int e = staggeredGridLayoutManager.f2334a.e(view);
                int b2 = staggeredGridLayoutManager.f2334a.b(view);
                boolean z2 = false;
                if (e <= g) {
                    z = true;
                } else {
                    z = false;
                }
                if (b2 >= k) {
                    z2 = true;
                }
                if (z && z2 && (e < k || b2 > g)) {
                    return staggeredGridLayoutManager.getPosition(view);
                }
                i += i3;
            }
            return -1;
        }

        public final int f(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f2360a.size() == 0) {
                return i;
            }
            a();
            return this.b;
        }

        public final View g(int i, int i2) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
            ArrayList<View> arrayList = this.f2360a;
            View view = null;
            if (i2 != -1) {
                int size = arrayList.size() - 1;
                while (size >= 0) {
                    View view2 = arrayList.get(size);
                    if ((staggeredGridLayoutManager.f2341a && staggeredGridLayoutManager.getPosition(view2) >= i) || ((!staggeredGridLayoutManager.f2341a && staggeredGridLayoutManager.getPosition(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = arrayList.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = arrayList.get(i3);
                    if ((staggeredGridLayoutManager.f2341a && staggeredGridLayoutManager.getPosition(view3) <= i) || ((!staggeredGridLayoutManager.f2341a && staggeredGridLayoutManager.getPosition(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public final int i(int i) {
            int i2 = this.a;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            ArrayList<View> arrayList = this.f2360a;
            if (arrayList.size() == 0) {
                return i;
            }
            View view = arrayList.get(0);
            LayoutParams h = h(view);
            this.a = StaggeredGridLayoutManager.this.f2334a.e(view);
            h.getClass();
            return this.a;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2341a = false;
        this.f2345b = false;
        this.d = -1;
        this.e = Integer.MIN_VALUE;
        LazySpanLookup lazySpanLookup = new LazySpanLookup();
        this.f2335a = lazySpanLookup;
        this.f = 2;
        this.f2333a = new Rect();
        this.f2338a = new b();
        this.f2348e = true;
        this.f2337a = new a();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.a;
        if (i3 == 0 || i3 == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i3 != this.b) {
                this.b = i3;
                OrientationHelper orientationHelper = this.f2334a;
                this.f2334a = this.f2344b;
                this.f2344b = orientationHelper;
                requestLayout();
            }
            int i4 = properties.b;
            assertNotInLayoutOrScroll((String) null);
            if (i4 != this.a) {
                lazySpanLookup.a();
                requestLayout();
                this.a = i4;
                this.f2340a = new BitSet(this.a);
                this.f2343a = new c[this.a];
                for (int i5 = 0; i5 < this.a; i5++) {
                    this.f2343a[i5] = new c(i5);
                }
                requestLayout();
            }
            boolean z = properties.f2306a;
            assertNotInLayoutOrScroll((String) null);
            SavedState savedState = this.f2336a;
            if (!(savedState == null || savedState.f2351a == z)) {
                savedState.f2351a = z;
            }
            this.f2341a = z;
            requestLayout();
            this.f2339a = new h();
            this.f2334a = OrientationHelper.a(this, this.b);
            this.f2344b = OrientationHelper.a(this, 1 - this.b);
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public static int x(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
        }
        return i;
    }

    public final int a(int i) {
        boolean z;
        if (getChildCount() != 0) {
            if (i < h()) {
                z = true;
            } else {
                z = false;
            }
            if (z != this.f2345b) {
                return -1;
            }
            return 1;
        } else if (this.f2345b) {
            return 1;
        } else {
            return -1;
        }
    }

    public final void assertNotInLayoutOrScroll(String str) {
        if (this.f2336a == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public final boolean b() {
        int i;
        if (!(getChildCount() == 0 || this.f == 0 || !isAttachedToWindow())) {
            if (this.f2345b) {
                i = i();
                h();
            } else {
                i = h();
                i();
            }
            if (i == 0 && m() != null) {
                this.f2335a.a();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return false;
    }

    public final int c(RecyclerView.Recycler recycler, h hVar, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        c cVar;
        boolean z;
        int i7;
        int i8;
        int i9;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        RecyclerView.Recycler recycler2 = recycler;
        h hVar2 = hVar;
        int i15 = 0;
        int i16 = 1;
        this.f2340a.set(0, this.a, true);
        h hVar3 = this.f2339a;
        if (!hVar3.f2405c) {
            if (hVar2.d == 1) {
                i14 = hVar2.f + hVar2.a;
            } else {
                i14 = hVar2.e - hVar2.a;
            }
            i = i14;
        } else if (hVar2.d == 1) {
            i = Integer.MAX_VALUE;
        } else {
            i = Integer.MIN_VALUE;
        }
        int i17 = hVar2.d;
        for (int i18 = 0; i18 < this.a; i18++) {
            if (!this.f2343a[i18].f2360a.isEmpty()) {
                w(this.f2343a[i18], i17, i);
            }
        }
        if (this.f2345b) {
            i2 = this.f2334a.g();
        } else {
            i2 = this.f2334a.k();
        }
        int i19 = i2;
        boolean z2 = false;
        while (true) {
            int i20 = hVar2.b;
            if (i20 < 0 || i20 >= state.b()) {
                i3 = i15;
            } else {
                i3 = i16;
            }
            int i21 = -1;
            if (i3 == 0 || (!hVar3.f2405c && this.f2340a.isEmpty())) {
                RecyclerView.Recycler recycler3 = recycler2;
                int i22 = i15;
            } else {
                View d2 = recycler2.d(hVar2.b);
                hVar2.b += hVar2.c;
                LayoutParams layoutParams = (LayoutParams) d2.getLayoutParams();
                int a2 = layoutParams.a();
                LazySpanLookup lazySpanLookup = this.f2335a;
                int[] iArr = lazySpanLookup.f2349a;
                if (iArr == null || a2 >= iArr.length) {
                    i5 = -1;
                } else {
                    i5 = iArr[a2];
                }
                if (i5 == -1) {
                    i6 = i16;
                } else {
                    i6 = i15;
                }
                if (i6 != 0) {
                    if (p(hVar2.d)) {
                        i12 = this.a - i16;
                        i13 = -1;
                    } else {
                        i21 = this.a;
                        i12 = i15;
                        i13 = i16;
                    }
                    c cVar2 = null;
                    if (hVar2.d == i16) {
                        int k = this.f2334a.k();
                        int i23 = Integer.MAX_VALUE;
                        while (i12 != i21) {
                            c cVar3 = this.f2343a[i12];
                            int f2 = cVar3.f(k);
                            if (f2 < i23) {
                                i23 = f2;
                                cVar2 = cVar3;
                            }
                            i12 += i13;
                            RecyclerView.Recycler recycler4 = recycler;
                        }
                    } else {
                        int g = this.f2334a.g();
                        int i24 = Integer.MIN_VALUE;
                        while (i12 != i21) {
                            c cVar4 = this.f2343a[i12];
                            int i25 = cVar4.i(g);
                            if (i25 > i24) {
                                cVar2 = cVar4;
                                i24 = i25;
                            }
                            i12 += i13;
                        }
                    }
                    cVar = cVar2;
                    lazySpanLookup.b(a2);
                    lazySpanLookup.f2349a[a2] = cVar.d;
                } else {
                    cVar = this.f2343a[i5];
                }
                c cVar5 = cVar;
                layoutParams.a = cVar5;
                if (hVar2.d == 1) {
                    addView(d2);
                    z = false;
                } else {
                    z = false;
                    addView(d2, 0);
                }
                if (this.b == 1) {
                    n(d2, RecyclerView.LayoutManager.getChildMeasureSpec(this.c, getWidthMode(), z ? 1 : 0, layoutParams.width, z), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), layoutParams.height, true), z);
                } else {
                    n(d2, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), layoutParams.width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.c, getHeightMode(), 0, layoutParams.height, false), false);
                }
                if (hVar2.d == 1) {
                    int f3 = cVar5.f(i19);
                    i8 = f3;
                    i7 = this.f2334a.c(d2) + f3;
                } else {
                    int i26 = cVar5.i(i19);
                    i7 = i26;
                    i8 = i26 - this.f2334a.c(d2);
                }
                if (hVar2.d == 1) {
                    c cVar6 = layoutParams.a;
                    cVar6.getClass();
                    LayoutParams layoutParams2 = (LayoutParams) d2.getLayoutParams();
                    layoutParams2.a = cVar6;
                    ArrayList<View> arrayList = cVar6.f2360a;
                    arrayList.add(d2);
                    cVar6.b = Integer.MIN_VALUE;
                    if (arrayList.size() == 1) {
                        cVar6.a = Integer.MIN_VALUE;
                    }
                    if (layoutParams2.c() || layoutParams2.b()) {
                        cVar6.c = StaggeredGridLayoutManager.this.f2334a.c(d2) + cVar6.c;
                    }
                } else {
                    c cVar7 = layoutParams.a;
                    cVar7.getClass();
                    LayoutParams layoutParams3 = (LayoutParams) d2.getLayoutParams();
                    layoutParams3.a = cVar7;
                    ArrayList<View> arrayList2 = cVar7.f2360a;
                    arrayList2.add(0, d2);
                    cVar7.a = Integer.MIN_VALUE;
                    if (arrayList2.size() == 1) {
                        cVar7.b = Integer.MIN_VALUE;
                    }
                    if (layoutParams3.c() || layoutParams3.b()) {
                        cVar7.c = StaggeredGridLayoutManager.this.f2334a.c(d2) + cVar7.c;
                    }
                }
                if (!isLayoutRTL() || this.b != 1) {
                    i9 = this.f2344b.k() + (cVar5.d * this.c);
                    i10 = this.f2344b.c(d2) + i9;
                } else {
                    i10 = this.f2344b.g() - (((this.a - 1) - cVar5.d) * this.c);
                    i9 = i10 - this.f2344b.c(d2);
                }
                int i27 = i10;
                int i28 = i9;
                if (this.b == 1) {
                    view = d2;
                    layoutDecoratedWithMargins(d2, i28, i8, i27, i7);
                } else {
                    view = d2;
                    layoutDecoratedWithMargins(view, i8, i28, i7, i27);
                }
                w(cVar5, hVar3.d, i);
                RecyclerView.Recycler recycler5 = recycler;
                r(recycler5, hVar3);
                if (!hVar3.f2404b || !view.hasFocusable()) {
                    i11 = 0;
                } else {
                    i11 = 0;
                    this.f2340a.set(cVar5.d, false);
                }
                recycler2 = recycler5;
                i15 = i11;
                z2 = true;
                i16 = 1;
            }
        }
        RecyclerView.Recycler recycler32 = recycler2;
        int i222 = i15;
        if (!z2) {
            r(recycler32, hVar3);
        }
        if (hVar3.d == -1) {
            i4 = this.f2334a.k() - k(this.f2334a.k());
        } else {
            i4 = j(this.f2334a.g()) - this.f2334a.g();
        }
        if (i4 > 0) {
            return Math.min(hVar2.a, i4);
        }
        return i222;
    }

    public final boolean canScrollHorizontally() {
        if (this.b == 0) {
            return true;
        }
        return false;
    }

    public final boolean canScrollVertically() {
        if (this.b == 1) {
            return true;
        }
        return false;
    }

    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        h hVar;
        boolean z;
        int i3;
        int i4;
        if (this.b != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            q(i, state);
            int[] iArr = this.f2342a;
            if (iArr == null || iArr.length < this.a) {
                this.f2342a = new int[this.a];
            }
            int i5 = 0;
            int i6 = 0;
            while (true) {
                int i7 = this.a;
                hVar = this.f2339a;
                if (i5 >= i7) {
                    break;
                }
                if (hVar.c == -1) {
                    i4 = hVar.e;
                    i3 = this.f2343a[i5].i(i4);
                } else {
                    i4 = this.f2343a[i5].f(hVar.f);
                    i3 = hVar.f;
                }
                int i8 = i4 - i3;
                if (i8 >= 0) {
                    this.f2342a[i6] = i8;
                    i6++;
                }
                i5++;
            }
            Arrays.sort(this.f2342a, 0, i6);
            int i9 = 0;
            while (i9 < i6) {
                int i10 = hVar.b;
                if (i10 < 0 || i10 >= state.b()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    layoutPrefetchRegistry.a(hVar.b, this.f2342a[i9]);
                    hVar.b += hVar.c;
                    i9++;
                } else {
                    return;
                }
            }
        }
    }

    public final int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.f2334a;
        boolean z = this.f2348e;
        return m.a(state, orientationHelper, e(!z), d(!z), this, this.f2348e);
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.f2334a;
        boolean z = this.f2348e;
        return m.b(state, orientationHelper, e(!z), d(!z), this, this.f2348e, this.f2345b);
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        OrientationHelper orientationHelper = this.f2334a;
        boolean z = this.f2348e;
        return m.c(state, orientationHelper, e(!z), d(!z), this, this.f2348e);
    }

    public final PointF computeScrollVectorForPosition(int i) {
        int a2 = a(i);
        PointF pointF = new PointF();
        if (a2 == 0) {
            return null;
        }
        if (this.b == 0) {
            pointF.x = (float) a2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) a2;
        }
        return pointF;
    }

    public final int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public final int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final View d(boolean z) {
        int k = this.f2334a.k();
        int g = this.f2334a.g();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int e2 = this.f2334a.e(childAt);
            int b2 = this.f2334a.b(childAt);
            if (b2 > k && e2 < g) {
                if (b2 <= g || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final View e(boolean z) {
        int k = this.f2334a.k();
        int g = this.f2334a.g();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int e2 = this.f2334a.e(childAt);
            if (this.f2334a.b(childAt) > k && e2 < g) {
                if (e2 >= k || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public final void f(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int g;
        int j = j(Integer.MIN_VALUE);
        if (j != Integer.MIN_VALUE && (g = this.f2334a.g() - j) > 0) {
            int i = g - (-scrollBy(-g, recycler, state));
            if (z && i > 0) {
                this.f2334a.o(i);
            }
        }
    }

    public final void g(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int k;
        int k2 = k(Integer.MAX_VALUE);
        if (k2 != Integer.MAX_VALUE && (k = k2 - this.f2334a.k()) > 0) {
            int scrollBy = k - scrollBy(k, recycler, state);
            if (z && scrollBy > 0) {
                this.f2334a.o(-scrollBy);
            }
        }
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.b == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final int h() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public final int i() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public final boolean isAutoMeasureEnabled() {
        if (this.f != 0) {
            return true;
        }
        return false;
    }

    public final boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final int j(int i) {
        int f2 = this.f2343a[0].f(i);
        for (int i2 = 1; i2 < this.a; i2++) {
            int f3 = this.f2343a[i2].f(i);
            if (f3 > f2) {
                f2 = f3;
            }
        }
        return f2;
    }

    public final int k(int i) {
        int i2 = this.f2343a[0].i(i);
        for (int i3 = 1; i3 < this.a; i3++) {
            int i4 = this.f2343a[i3].i(i);
            if (i4 < i2) {
                i2 = i4;
            }
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(int r8, int r9, int r10) {
        /*
            r7 = this;
            boolean r0 = r7.f2345b
            if (r0 == 0) goto L_0x0009
            int r0 = r7.i()
            goto L_0x000d
        L_0x0009:
            int r0 = r7.h()
        L_0x000d:
            r1 = 8
            if (r10 != r1) goto L_0x001a
            if (r8 >= r9) goto L_0x0016
            int r2 = r9 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r8 + 1
            r3 = r9
            goto L_0x001d
        L_0x001a:
            int r2 = r8 + r9
        L_0x001c:
            r3 = r8
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r7.f2335a
            r4.c(r3)
            r5 = 1
            if (r10 == r5) goto L_0x0036
            r6 = 2
            if (r10 == r6) goto L_0x0032
            if (r10 == r1) goto L_0x002b
            goto L_0x0039
        L_0x002b:
            r4.e(r8, r5)
            r4.d(r9, r5)
            goto L_0x0039
        L_0x0032:
            r4.e(r8, r9)
            goto L_0x0039
        L_0x0036:
            r4.d(r8, r9)
        L_0x0039:
            if (r2 > r0) goto L_0x003c
            return
        L_0x003c:
            boolean r8 = r7.f2345b
            if (r8 == 0) goto L_0x0045
            int r8 = r7.h()
            goto L_0x0049
        L_0x0045:
            int r8 = r7.i()
        L_0x0049:
            if (r3 > r8) goto L_0x004e
            r7.requestLayout()
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.l(int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        if (r10 == r11) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e3, code lost:
        if (r10 == r11) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e7, code lost:
        r10 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00af A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View m() {
        /*
            r13 = this;
            int r0 = r13.getChildCount()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r13.a
            r2.<init>(r3)
            int r3 = r13.a
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r13.b
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r13.isLayoutRTL()
            if (r3 == 0) goto L_0x0020
            r3 = r1
            goto L_0x0021
        L_0x0020:
            r3 = r5
        L_0x0021:
            boolean r6 = r13.f2345b
            if (r6 == 0) goto L_0x0027
            r6 = r5
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = r1
        L_0x002e:
            if (r0 == r6) goto L_0x0106
            android.view.View r7 = r13.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.a
            int r9 = r9.d
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x00b7
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.a
            boolean r10 = r13.f2345b
            r11 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r10 == 0) goto L_0x0073
            int r10 = r9.b
            if (r10 == r11) goto L_0x0051
            goto L_0x0056
        L_0x0051:
            r9.a()
            int r10 = r9.b
        L_0x0056:
            androidx.recyclerview.widget.OrientationHelper r11 = r13.f2334a
            int r11 = r11.g()
            if (r10 >= r11) goto L_0x00ac
            java.util.ArrayList<android.view.View> r9 = r9.f2360a
            int r10 = r9.size()
            int r10 = r10 - r1
            java.lang.Object r9 = r9.get(r10)
            android.view.View r9 = (android.view.View) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = androidx.recyclerview.widget.StaggeredGridLayoutManager.c.h(r9)
            r9.getClass()
            goto L_0x00aa
        L_0x0073:
            int r10 = r9.a
            if (r10 == r11) goto L_0x0078
            goto L_0x0093
        L_0x0078:
            java.util.ArrayList<android.view.View> r10 = r9.f2360a
            java.lang.Object r10 = r10.get(r4)
            android.view.View r10 = (android.view.View) r10
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r11 = androidx.recyclerview.widget.StaggeredGridLayoutManager.c.h(r10)
            androidx.recyclerview.widget.StaggeredGridLayoutManager r12 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.OrientationHelper r12 = r12.f2334a
            int r10 = r12.e(r10)
            r9.a = r10
            r11.getClass()
            int r10 = r9.a
        L_0x0093:
            androidx.recyclerview.widget.OrientationHelper r11 = r13.f2334a
            int r11 = r11.k()
            if (r10 <= r11) goto L_0x00ac
            java.util.ArrayList<android.view.View> r9 = r9.f2360a
            java.lang.Object r9 = r9.get(r4)
            android.view.View r9 = (android.view.View) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = androidx.recyclerview.widget.StaggeredGridLayoutManager.c.h(r9)
            r9.getClass()
        L_0x00aa:
            r9 = r1
            goto L_0x00ad
        L_0x00ac:
            r9 = r4
        L_0x00ad:
            if (r9 == 0) goto L_0x00b0
            return r7
        L_0x00b0:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r8.a
            int r9 = r9.d
            r2.clear(r9)
        L_0x00b7:
            int r0 = r0 + r5
            if (r0 == r6) goto L_0x002e
            android.view.View r9 = r13.getChildAt(r0)
            boolean r10 = r13.f2345b
            if (r10 == 0) goto L_0x00d4
            androidx.recyclerview.widget.OrientationHelper r10 = r13.f2334a
            int r10 = r10.b(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r13.f2334a
            int r11 = r11.b(r9)
            if (r10 >= r11) goto L_0x00d1
            return r7
        L_0x00d1:
            if (r10 != r11) goto L_0x00e7
            goto L_0x00e5
        L_0x00d4:
            androidx.recyclerview.widget.OrientationHelper r10 = r13.f2334a
            int r10 = r10.e(r7)
            androidx.recyclerview.widget.OrientationHelper r11 = r13.f2334a
            int r11 = r11.e(r9)
            if (r10 <= r11) goto L_0x00e3
            return r7
        L_0x00e3:
            if (r10 != r11) goto L_0x00e7
        L_0x00e5:
            r10 = r1
            goto L_0x00e8
        L_0x00e7:
            r10 = r4
        L_0x00e8:
            if (r10 == 0) goto L_0x002e
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = r8.a
            int r8 = r8.d
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = r9.a
            int r9 = r9.d
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00fd
            r8 = r1
            goto L_0x00fe
        L_0x00fd:
            r8 = r4
        L_0x00fe:
            if (r3 >= 0) goto L_0x0102
            r9 = r1
            goto L_0x0103
        L_0x0102:
            r9 = r4
        L_0x0103:
            if (r8 == r9) goto L_0x002e
            return r7
        L_0x0106:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m():android.view.View");
    }

    public final void n(View view, int i, int i2, boolean z) {
        Rect rect = this.f2333a;
        calculateItemDecorationsForChild(view, rect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int x = x(i, layoutParams.leftMargin + rect.left, layoutParams.rightMargin + rect.right);
        int x2 = x(i2, layoutParams.topMargin + rect.top, layoutParams.bottomMargin + rect.bottom);
        if (shouldMeasureChild(view, x, x2, layoutParams)) {
            view.measure(x, x2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0404, code lost:
        if (b() != false) goto L_0x0408;
     */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void o(androidx.recyclerview.widget.RecyclerView.Recycler r17, androidx.recyclerview.widget.RecyclerView.State r18, boolean r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r3 = r0.f2336a
            r4 = -1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r5 = r0.f2338a
            if (r3 != 0) goto L_0x0011
            int r3 = r0.d
            if (r3 == r4) goto L_0x001e
        L_0x0011:
            int r3 = r18.b()
            if (r3 != 0) goto L_0x001e
            r16.removeAndRecycleAllViews(r17)
            r5.a()
            return
        L_0x001e:
            boolean r3 = r5.c
            r6 = 0
            r7 = 1
            if (r3 == 0) goto L_0x002f
            int r3 = r0.d
            if (r3 != r4) goto L_0x002f
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r3 = r0.f2336a
            if (r3 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r3 = r6
            goto L_0x0030
        L_0x002f:
            r3 = r7
        L_0x0030:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r8 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r0.f2335a
            r10 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == 0) goto L_0x020b
            r5.a()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r11 = r0.f2336a
            if (r11 == 0) goto L_0x00c2
            int r12 = r11.e
            r13 = 0
            if (r12 <= 0) goto L_0x0087
            int r14 = r0.a
            if (r12 != r14) goto L_0x0079
            r11 = r6
        L_0x0049:
            int r12 = r0.a
            if (r11 >= r12) goto L_0x0087
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r12 = r0.f2343a
            r12 = r12[r11]
            r12.b()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r12 = r0.f2336a
            int[] r14 = r12.f2352a
            r14 = r14[r11]
            if (r14 == r10) goto L_0x006e
            boolean r12 = r12.b
            if (r12 == 0) goto L_0x0067
            androidx.recyclerview.widget.OrientationHelper r12 = r0.f2334a
            int r12 = r12.g()
            goto L_0x006d
        L_0x0067:
            androidx.recyclerview.widget.OrientationHelper r12 = r0.f2334a
            int r12 = r12.k()
        L_0x006d:
            int r14 = r14 + r12
        L_0x006e:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r12 = r0.f2343a
            r12 = r12[r11]
            r12.a = r14
            r12.b = r14
            int r11 = r11 + 1
            goto L_0x0049
        L_0x0079:
            r11.f2352a = r13
            r11.e = r6
            r11.f = r6
            r11.f2353b = r13
            r11.a = r13
            int r12 = r11.d
            r11.c = r12
        L_0x0087:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r11 = r0.f2336a
            boolean r12 = r11.f2354c
            r0.f2347d = r12
            boolean r11 = r11.f2351a
            r0.assertNotInLayoutOrScroll(r13)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r12 = r0.f2336a
            if (r12 == 0) goto L_0x009c
            boolean r13 = r12.f2351a
            if (r13 == r11) goto L_0x009c
            r12.f2351a = r11
        L_0x009c:
            r0.f2341a = r11
            r16.requestLayout()
            r16.resolveShouldLayoutReverse()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r11 = r0.f2336a
            int r12 = r11.c
            if (r12 == r4) goto L_0x00b1
            r0.d = r12
            boolean r12 = r11.b
            r5.f2356a = r12
            goto L_0x00b5
        L_0x00b1:
            boolean r12 = r0.f2345b
            r5.f2356a = r12
        L_0x00b5:
            int r12 = r11.f
            if (r12 <= r7) goto L_0x00c9
            int[] r12 = r11.f2353b
            r9.f2349a = r12
            java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r11 = r11.a
            r9.a = r11
            goto L_0x00c9
        L_0x00c2:
            r16.resolveShouldLayoutReverse()
            boolean r11 = r0.f2345b
            r5.f2356a = r11
        L_0x00c9:
            boolean r11 = r2.f2324b
            if (r11 != 0) goto L_0x01c8
            int r11 = r0.d
            if (r11 != r4) goto L_0x00d3
            goto L_0x01c8
        L_0x00d3:
            if (r11 < 0) goto L_0x01c4
            int r12 = r18.b()
            if (r11 < r12) goto L_0x00dd
            goto L_0x01c4
        L_0x00dd:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r11 = r0.f2336a
            if (r11 == 0) goto L_0x00f2
            int r12 = r11.c
            if (r12 == r4) goto L_0x00f2
            int r11 = r11.e
            if (r11 >= r7) goto L_0x00ea
            goto L_0x00f2
        L_0x00ea:
            r5.b = r10
            int r11 = r0.d
            r5.a = r11
            goto L_0x01c2
        L_0x00f2:
            int r11 = r0.d
            android.view.View r11 = r0.findViewByPosition(r11)
            if (r11 == 0) goto L_0x0184
            boolean r12 = r0.f2345b
            if (r12 == 0) goto L_0x0103
            int r12 = r16.i()
            goto L_0x0107
        L_0x0103:
            int r12 = r16.h()
        L_0x0107:
            r5.a = r12
            int r12 = r0.e
            if (r12 == r10) goto L_0x0139
            boolean r12 = r5.f2356a
            if (r12 == 0) goto L_0x0125
            androidx.recyclerview.widget.OrientationHelper r12 = r0.f2334a
            int r12 = r12.g()
            int r13 = r0.e
            int r12 = r12 - r13
            androidx.recyclerview.widget.OrientationHelper r13 = r0.f2334a
            int r11 = r13.b(r11)
            int r12 = r12 - r11
            r5.b = r12
            goto L_0x01c2
        L_0x0125:
            androidx.recyclerview.widget.OrientationHelper r12 = r0.f2334a
            int r12 = r12.k()
            int r13 = r0.e
            int r12 = r12 + r13
            androidx.recyclerview.widget.OrientationHelper r13 = r0.f2334a
            int r11 = r13.e(r11)
            int r12 = r12 - r11
            r5.b = r12
            goto L_0x01c2
        L_0x0139:
            androidx.recyclerview.widget.OrientationHelper r12 = r0.f2334a
            int r12 = r12.c(r11)
            androidx.recyclerview.widget.OrientationHelper r13 = r0.f2334a
            int r13 = r13.l()
            if (r12 <= r13) goto L_0x015c
            boolean r11 = r5.f2356a
            if (r11 == 0) goto L_0x0152
            androidx.recyclerview.widget.OrientationHelper r11 = r0.f2334a
            int r11 = r11.g()
            goto L_0x0158
        L_0x0152:
            androidx.recyclerview.widget.OrientationHelper r11 = r0.f2334a
            int r11 = r11.k()
        L_0x0158:
            r5.b = r11
            goto L_0x01c2
        L_0x015c:
            androidx.recyclerview.widget.OrientationHelper r12 = r0.f2334a
            int r12 = r12.e(r11)
            androidx.recyclerview.widget.OrientationHelper r13 = r0.f2334a
            int r13 = r13.k()
            int r12 = r12 - r13
            if (r12 >= 0) goto L_0x016f
            int r11 = -r12
            r5.b = r11
            goto L_0x01c2
        L_0x016f:
            androidx.recyclerview.widget.OrientationHelper r12 = r0.f2334a
            int r12 = r12.g()
            androidx.recyclerview.widget.OrientationHelper r13 = r0.f2334a
            int r11 = r13.b(r11)
            int r12 = r12 - r11
            if (r12 >= 0) goto L_0x0181
            r5.b = r12
            goto L_0x01c2
        L_0x0181:
            r5.b = r10
            goto L_0x01c2
        L_0x0184:
            int r11 = r0.d
            r5.a = r11
            int r12 = r0.e
            if (r12 != r10) goto L_0x01a9
            int r11 = r0.a(r11)
            if (r11 != r7) goto L_0x0194
            r11 = r7
            goto L_0x0195
        L_0x0194:
            r11 = r6
        L_0x0195:
            r5.f2356a = r11
            if (r11 == 0) goto L_0x01a0
            androidx.recyclerview.widget.OrientationHelper r11 = r8.f2334a
            int r11 = r11.g()
            goto L_0x01a6
        L_0x01a0:
            androidx.recyclerview.widget.OrientationHelper r11 = r8.f2334a
            int r11 = r11.k()
        L_0x01a6:
            r5.b = r11
            goto L_0x01c0
        L_0x01a9:
            boolean r11 = r5.f2356a
            if (r11 == 0) goto L_0x01b7
            androidx.recyclerview.widget.OrientationHelper r11 = r8.f2334a
            int r11 = r11.g()
            int r11 = r11 - r12
            r5.b = r11
            goto L_0x01c0
        L_0x01b7:
            androidx.recyclerview.widget.OrientationHelper r11 = r8.f2334a
            int r11 = r11.k()
            int r11 = r11 + r12
            r5.b = r11
        L_0x01c0:
            r5.f2358b = r7
        L_0x01c2:
            r11 = r7
            goto L_0x01c9
        L_0x01c4:
            r0.d = r4
            r0.e = r10
        L_0x01c8:
            r11 = r6
        L_0x01c9:
            if (r11 == 0) goto L_0x01cc
            goto L_0x0209
        L_0x01cc:
            boolean r11 = r0.f2346c
            if (r11 == 0) goto L_0x01e8
            int r11 = r18.b()
            int r12 = r16.getChildCount()
        L_0x01d8:
            int r12 = r12 + r4
            if (r12 < 0) goto L_0x0204
            android.view.View r13 = r0.getChildAt(r12)
            int r13 = r0.getPosition(r13)
            if (r13 < 0) goto L_0x01d8
            if (r13 >= r11) goto L_0x01d8
            goto L_0x0205
        L_0x01e8:
            int r11 = r18.b()
            int r12 = r16.getChildCount()
            r13 = r6
        L_0x01f1:
            if (r13 >= r12) goto L_0x0204
            android.view.View r14 = r0.getChildAt(r13)
            int r14 = r0.getPosition(r14)
            if (r14 < 0) goto L_0x0201
            if (r14 >= r11) goto L_0x0201
            r13 = r14
            goto L_0x0205
        L_0x0201:
            int r13 = r13 + 1
            goto L_0x01f1
        L_0x0204:
            r13 = r6
        L_0x0205:
            r5.a = r13
            r5.b = r10
        L_0x0209:
            r5.c = r7
        L_0x020b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r11 = r0.f2336a
            if (r11 != 0) goto L_0x0226
            int r11 = r0.d
            if (r11 != r4) goto L_0x0226
            boolean r11 = r5.f2356a
            boolean r12 = r0.f2346c
            if (r11 != r12) goto L_0x0221
            boolean r11 = r16.isLayoutRTL()
            boolean r12 = r0.f2347d
            if (r11 == r12) goto L_0x0226
        L_0x0221:
            r9.a()
            r5.f2358b = r7
        L_0x0226:
            int r9 = r16.getChildCount()
            if (r9 <= 0) goto L_0x02d1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r9 = r0.f2336a
            if (r9 == 0) goto L_0x0234
            int r9 = r9.e
            if (r9 >= r7) goto L_0x02d1
        L_0x0234:
            boolean r9 = r5.f2358b
            if (r9 == 0) goto L_0x0253
            r3 = r6
        L_0x0239:
            int r8 = r0.a
            if (r3 >= r8) goto L_0x02d1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r8 = r0.f2343a
            r8 = r8[r3]
            r8.b()
            int r8 = r5.b
            if (r8 == r10) goto L_0x0250
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r9 = r0.f2343a
            r9 = r9[r3]
            r9.a = r8
            r9.b = r8
        L_0x0250:
            int r3 = r3 + 1
            goto L_0x0239
        L_0x0253:
            if (r3 != 0) goto L_0x0271
            int[] r3 = r5.f2357a
            if (r3 != 0) goto L_0x025a
            goto L_0x0271
        L_0x025a:
            r3 = r6
        L_0x025b:
            int r8 = r0.a
            if (r3 >= r8) goto L_0x02d1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r8 = r0.f2343a
            r8 = r8[r3]
            r8.b()
            int[] r9 = r5.f2357a
            r9 = r9[r3]
            r8.a = r9
            r8.b = r9
            int r3 = r3 + 1
            goto L_0x025b
        L_0x0271:
            r3 = r6
        L_0x0272:
            int r9 = r0.a
            if (r3 >= r9) goto L_0x02b0
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r9 = r0.f2343a
            r9 = r9[r3]
            boolean r11 = r0.f2345b
            int r12 = r5.b
            if (r11 == 0) goto L_0x0285
            int r13 = r9.f(r10)
            goto L_0x0289
        L_0x0285:
            int r13 = r9.i(r10)
        L_0x0289:
            r9.b()
            if (r13 != r10) goto L_0x028f
            goto L_0x02ad
        L_0x028f:
            androidx.recyclerview.widget.StaggeredGridLayoutManager r14 = androidx.recyclerview.widget.StaggeredGridLayoutManager.this
            if (r11 == 0) goto L_0x029b
            androidx.recyclerview.widget.OrientationHelper r15 = r14.f2334a
            int r15 = r15.g()
            if (r13 < r15) goto L_0x02ad
        L_0x029b:
            if (r11 != 0) goto L_0x02a6
            androidx.recyclerview.widget.OrientationHelper r11 = r14.f2334a
            int r11 = r11.k()
            if (r13 <= r11) goto L_0x02a6
            goto L_0x02ad
        L_0x02a6:
            if (r12 == r10) goto L_0x02a9
            int r13 = r13 + r12
        L_0x02a9:
            r9.b = r13
            r9.a = r13
        L_0x02ad:
            int r3 = r3 + 1
            goto L_0x0272
        L_0x02b0:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r3 = r0.f2343a
            int r9 = r3.length
            int[] r11 = r5.f2357a
            if (r11 == 0) goto L_0x02ba
            int r11 = r11.length
            if (r11 >= r9) goto L_0x02c1
        L_0x02ba:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r8 = r8.f2343a
            int r8 = r8.length
            int[] r8 = new int[r8]
            r5.f2357a = r8
        L_0x02c1:
            r8 = r6
        L_0x02c2:
            if (r8 >= r9) goto L_0x02d1
            int[] r11 = r5.f2357a
            r12 = r3[r8]
            int r12 = r12.i(r10)
            r11[r8] = r12
            int r8 = r8 + 1
            goto L_0x02c2
        L_0x02d1:
            r16.detachAndScrapAttachedViews(r17)
            androidx.recyclerview.widget.h r3 = r0.f2339a
            r3.f2403a = r6
            androidx.recyclerview.widget.OrientationHelper r8 = r0.f2344b
            int r8 = r8.l()
            int r9 = r0.a
            int r9 = r8 / r9
            r0.c = r9
            androidx.recyclerview.widget.OrientationHelper r9 = r0.f2344b
            int r9 = r9.i()
            android.view.View.MeasureSpec.makeMeasureSpec(r8, r9)
            int r8 = r5.a
            r0.v(r8, r2)
            boolean r8 = r5.f2356a
            if (r8 == 0) goto L_0x030a
            r0.u(r4)
            r0.c(r1, r3, r2)
            r0.u(r7)
            int r4 = r5.a
            int r8 = r3.c
            int r4 = r4 + r8
            r3.b = r4
            r0.c(r1, r3, r2)
            goto L_0x031d
        L_0x030a:
            r0.u(r7)
            r0.c(r1, r3, r2)
            r0.u(r4)
            int r4 = r5.a
            int r8 = r3.c
            int r4 = r4 + r8
            r3.b = r4
            r0.c(r1, r3, r2)
        L_0x031d:
            androidx.recyclerview.widget.OrientationHelper r3 = r0.f2344b
            int r3 = r3.i()
            r4 = 1073741824(0x40000000, float:2.0)
            if (r3 != r4) goto L_0x0329
            goto L_0x03c9
        L_0x0329:
            int r3 = r16.getChildCount()
            r4 = 0
            r8 = r6
        L_0x032f:
            if (r8 >= r3) goto L_0x0351
            android.view.View r9 = r0.getChildAt(r8)
            androidx.recyclerview.widget.OrientationHelper r11 = r0.f2344b
            int r11 = r11.c(r9)
            float r11 = (float) r11
            int r12 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r12 >= 0) goto L_0x0341
            goto L_0x034e
        L_0x0341:
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            r9.getClass()
            float r4 = java.lang.Math.max(r4, r11)
        L_0x034e:
            int r8 = r8 + 1
            goto L_0x032f
        L_0x0351:
            int r8 = r0.c
            int r9 = r0.a
            float r9 = (float) r9
            float r4 = r4 * r9
            int r4 = java.lang.Math.round(r4)
            androidx.recyclerview.widget.OrientationHelper r9 = r0.f2344b
            int r9 = r9.i()
            if (r9 != r10) goto L_0x036d
            androidx.recyclerview.widget.OrientationHelper r9 = r0.f2344b
            int r9 = r9.l()
            int r4 = java.lang.Math.min(r4, r9)
        L_0x036d:
            int r9 = r0.a
            int r9 = r4 / r9
            r0.c = r9
            androidx.recyclerview.widget.OrientationHelper r9 = r0.f2344b
            int r9 = r9.i()
            android.view.View.MeasureSpec.makeMeasureSpec(r4, r9)
            int r4 = r0.c
            if (r4 != r8) goto L_0x0381
            goto L_0x03c9
        L_0x0381:
            r4 = r6
        L_0x0382:
            if (r4 >= r3) goto L_0x03c9
            android.view.View r9 = r0.getChildAt(r4)
            android.view.ViewGroup$LayoutParams r10 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r10 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r10
            r10.getClass()
            boolean r11 = r16.isLayoutRTL()
            if (r11 == 0) goto L_0x03b1
            int r11 = r0.b
            if (r11 != r7) goto L_0x03b1
            int r11 = r0.a
            int r12 = r11 + -1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r10 = r10.a
            int r10 = r10.d
            int r12 = r12 - r10
            int r12 = -r12
            int r13 = r0.c
            int r12 = r12 * r13
            int r11 = r11 - r7
            int r11 = r11 - r10
            int r10 = -r11
            int r10 = r10 * r8
            int r12 = r12 - r10
            r9.offsetLeftAndRight(r12)
            goto L_0x03c6
        L_0x03b1:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r10 = r10.a
            int r10 = r10.d
            int r11 = r0.c
            int r11 = r11 * r10
            int r10 = r10 * r8
            int r12 = r0.b
            if (r12 != r7) goto L_0x03c2
            int r11 = r11 - r10
            r9.offsetLeftAndRight(r11)
            goto L_0x03c6
        L_0x03c2:
            int r11 = r11 - r10
            r9.offsetTopAndBottom(r11)
        L_0x03c6:
            int r4 = r4 + 1
            goto L_0x0382
        L_0x03c9:
            int r3 = r16.getChildCount()
            if (r3 <= 0) goto L_0x03e0
            boolean r3 = r0.f2345b
            if (r3 == 0) goto L_0x03da
            r0.f(r1, r2, r7)
            r0.g(r1, r2, r6)
            goto L_0x03e0
        L_0x03da:
            r0.g(r1, r2, r7)
            r0.f(r1, r2, r6)
        L_0x03e0:
            if (r19 == 0) goto L_0x0407
            boolean r3 = r2.f2324b
            if (r3 != 0) goto L_0x0407
            int r3 = r0.f
            if (r3 == 0) goto L_0x03f8
            int r3 = r16.getChildCount()
            if (r3 <= 0) goto L_0x03f8
            android.view.View r3 = r16.m()
            if (r3 == 0) goto L_0x03f8
            r3 = r7
            goto L_0x03f9
        L_0x03f8:
            r3 = r6
        L_0x03f9:
            if (r3 == 0) goto L_0x0407
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r3 = r0.f2337a
            r0.removeCallbacks(r3)
            boolean r3 = r16.b()
            if (r3 == 0) goto L_0x0407
            goto L_0x0408
        L_0x0407:
            r7 = r6
        L_0x0408:
            boolean r3 = r2.f2324b
            if (r3 == 0) goto L_0x040f
            r5.a()
        L_0x040f:
            boolean r3 = r5.f2356a
            r0.f2346c = r3
            boolean r3 = r16.isLayoutRTL()
            r0.f2347d = r3
            if (r7 == 0) goto L_0x0421
            r5.a()
            r0.o(r1, r2, r6)
        L_0x0421:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.o(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, boolean):void");
    }

    public final void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            c cVar = this.f2343a[i2];
            int i3 = cVar.a;
            if (i3 != Integer.MIN_VALUE) {
                cVar.a = i3 + i;
            }
            int i4 = cVar.b;
            if (i4 != Integer.MIN_VALUE) {
                cVar.b = i4 + i;
            }
        }
    }

    public final void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.a; i2++) {
            c cVar = this.f2343a[i2];
            int i3 = cVar.a;
            if (i3 != Integer.MIN_VALUE) {
                cVar.a = i3 + i;
            }
            int i4 = cVar.b;
            if (i4 != Integer.MIN_VALUE) {
                cVar.b = i4 + i;
            }
        }
    }

    public final void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f2335a.a();
        for (int i = 0; i < this.a; i++) {
            this.f2343a[i].b();
        }
    }

    public final void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        removeCallbacks(this.f2337a);
        for (int i = 0; i < this.a; i++) {
            this.f2343a[i].b();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003b, code lost:
        if (r8.b == 1) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0041, code lost:
        if (r8.b == 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004d, code lost:
        if (isLayoutRTL() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
        if (isLayoutRTL() == false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x005e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onFocusSearchFailed(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.Recycler r11, androidx.recyclerview.widget.RecyclerView.State r12) {
        /*
            r8 = this;
            int r0 = r8.getChildCount()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.view.View r9 = r8.findContainingItemView(r9)
            if (r9 != 0) goto L_0x000f
            return r1
        L_0x000f:
            r8.resolveShouldLayoutReverse()
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            if (r10 == r3) goto L_0x0050
            r4 = 2
            if (r10 == r4) goto L_0x0044
            r4 = 17
            if (r10 == r4) goto L_0x003f
            r4 = 33
            if (r10 == r4) goto L_0x0039
            r4 = 66
            if (r10 == r4) goto L_0x0034
            r4 = 130(0x82, float:1.82E-43)
            if (r10 == r4) goto L_0x002c
            goto L_0x0032
        L_0x002c:
            int r10 = r8.b
            if (r10 != r3) goto L_0x0032
        L_0x0030:
            r10 = r3
            goto L_0x005c
        L_0x0032:
            r10 = r0
            goto L_0x005c
        L_0x0034:
            int r10 = r8.b
            if (r10 != 0) goto L_0x0032
            goto L_0x0030
        L_0x0039:
            int r10 = r8.b
            if (r10 != r3) goto L_0x0032
        L_0x003d:
            r10 = r2
            goto L_0x005c
        L_0x003f:
            int r10 = r8.b
            if (r10 != 0) goto L_0x0032
        L_0x0043:
            goto L_0x003d
        L_0x0044:
            int r10 = r8.b
            if (r10 != r3) goto L_0x0049
            goto L_0x0030
        L_0x0049:
            boolean r10 = r8.isLayoutRTL()
            if (r10 == 0) goto L_0x0030
            goto L_0x0054
        L_0x0050:
            int r10 = r8.b
            if (r10 != r3) goto L_0x0055
        L_0x0054:
            goto L_0x0043
        L_0x0055:
            boolean r10 = r8.isLayoutRTL()
            if (r10 == 0) goto L_0x003d
            goto L_0x0030
        L_0x005c:
            if (r10 != r0) goto L_0x005f
            return r1
        L_0x005f:
            android.view.ViewGroup$LayoutParams r0 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r0
            r0.getClass()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r0 = r0.a
            if (r10 != r3) goto L_0x0071
            int r4 = r8.i()
            goto L_0x0075
        L_0x0071:
            int r4 = r8.h()
        L_0x0075:
            r8.v(r4, r12)
            r8.u(r10)
            androidx.recyclerview.widget.h r5 = r8.f2339a
            int r6 = r5.c
            int r6 = r6 + r4
            r5.b = r6
            androidx.recyclerview.widget.OrientationHelper r6 = r8.f2334a
            int r6 = r6.l()
            float r6 = (float) r6
            r7 = 1051372203(0x3eaaaaab, float:0.33333334)
            float r6 = r6 * r7
            int r6 = (int) r6
            r5.a = r6
            r5.f2404b = r3
            r6 = 0
            r5.f2403a = r6
            r8.c(r11, r5, r12)
            boolean r11 = r8.f2345b
            r8.f2346c = r11
            android.view.View r11 = r0.g(r4, r10)
            if (r11 == 0) goto L_0x00a5
            if (r11 == r9) goto L_0x00a5
            return r11
        L_0x00a5:
            boolean r11 = r8.p(r10)
            if (r11 == 0) goto L_0x00c0
            int r11 = r8.a
            int r11 = r11 - r3
        L_0x00ae:
            if (r11 < 0) goto L_0x00d5
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r12 = r8.f2343a
            r12 = r12[r11]
            android.view.View r12 = r12.g(r4, r10)
            if (r12 == 0) goto L_0x00bd
            if (r12 == r9) goto L_0x00bd
            return r12
        L_0x00bd:
            int r11 = r11 + -1
            goto L_0x00ae
        L_0x00c0:
            r11 = r6
        L_0x00c1:
            int r12 = r8.a
            if (r11 >= r12) goto L_0x00d5
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r12 = r8.f2343a
            r12 = r12[r11]
            android.view.View r12 = r12.g(r4, r10)
            if (r12 == 0) goto L_0x00d2
            if (r12 == r9) goto L_0x00d2
            return r12
        L_0x00d2:
            int r11 = r11 + 1
            goto L_0x00c1
        L_0x00d5:
            boolean r11 = r8.f2341a
            r11 = r11 ^ r3
            if (r10 != r2) goto L_0x00dc
            r12 = r3
            goto L_0x00dd
        L_0x00dc:
            r12 = r6
        L_0x00dd:
            if (r11 != r12) goto L_0x00e1
            r11 = r3
            goto L_0x00e2
        L_0x00e1:
            r11 = r6
        L_0x00e2:
            if (r11 == 0) goto L_0x00e9
            int r12 = r0.c()
            goto L_0x00ed
        L_0x00e9:
            int r12 = r0.d()
        L_0x00ed:
            android.view.View r12 = r8.findViewByPosition(r12)
            if (r12 == 0) goto L_0x00f6
            if (r12 == r9) goto L_0x00f6
            return r12
        L_0x00f6:
            boolean r10 = r8.p(r10)
            if (r10 == 0) goto L_0x0125
            int r10 = r8.a
            int r10 = r10 - r3
        L_0x00ff:
            if (r10 < 0) goto L_0x0148
            int r12 = r0.d
            if (r10 != r12) goto L_0x0106
            goto L_0x0122
        L_0x0106:
            if (r11 == 0) goto L_0x0111
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r12 = r8.f2343a
            r12 = r12[r10]
            int r12 = r12.c()
            goto L_0x0119
        L_0x0111:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r12 = r8.f2343a
            r12 = r12[r10]
            int r12 = r12.d()
        L_0x0119:
            android.view.View r12 = r8.findViewByPosition(r12)
            if (r12 == 0) goto L_0x0122
            if (r12 == r9) goto L_0x0122
            return r12
        L_0x0122:
            int r10 = r10 + -1
            goto L_0x00ff
        L_0x0125:
            int r10 = r8.a
            if (r6 >= r10) goto L_0x0148
            if (r11 == 0) goto L_0x0134
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r10 = r8.f2343a
            r10 = r10[r6]
            int r10 = r10.c()
            goto L_0x013c
        L_0x0134:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c[] r10 = r8.f2343a
            r10 = r10[r6]
            int r10 = r10.d()
        L_0x013c:
            android.view.View r10 = r8.findViewByPosition(r10)
            if (r10 == 0) goto L_0x0145
            if (r10 == r9) goto L_0x0145
            return r10
        L_0x0145:
            int r6 = r6 + 1
            goto L_0x0125
        L_0x0148:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View e2 = e(false);
            View d2 = d(false);
            if (e2 != null && d2 != null) {
                int position = getPosition(e2);
                int position2 = getPosition(d2);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        l(i, i2, 1);
    }

    public final void onItemsChanged(RecyclerView recyclerView) {
        this.f2335a.a();
        requestLayout();
    }

    public final void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        l(i, i2, 8);
    }

    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        l(i, i2, 2);
    }

    public final void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        l(i, i2, 4);
    }

    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        o(recycler, state, true);
    }

    public final void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.d = -1;
        this.e = Integer.MIN_VALUE;
        this.f2336a = null;
        this.f2338a.a();
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f2336a = savedState;
            if (this.d != -1) {
                savedState.f2352a = null;
                savedState.e = 0;
                savedState.c = -1;
                savedState.d = -1;
                savedState.f2352a = null;
                savedState.e = 0;
                savedState.f = 0;
                savedState.f2353b = null;
                savedState.a = null;
            }
            requestLayout();
        }
    }

    public final Parcelable onSaveInstanceState() {
        int i;
        View view;
        int i2;
        int i3;
        int[] iArr;
        SavedState savedState = this.f2336a;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.f2351a = this.f2341a;
        savedState2.b = this.f2346c;
        savedState2.f2354c = this.f2347d;
        LazySpanLookup lazySpanLookup = this.f2335a;
        if (lazySpanLookup == null || (iArr = lazySpanLookup.f2349a) == null) {
            savedState2.f = 0;
        } else {
            savedState2.f2353b = iArr;
            savedState2.f = iArr.length;
            savedState2.a = lazySpanLookup.a;
        }
        int i4 = -1;
        if (getChildCount() > 0) {
            if (this.f2346c) {
                i = i();
            } else {
                i = h();
            }
            savedState2.c = i;
            if (this.f2345b) {
                view = d(true);
            } else {
                view = e(true);
            }
            if (view != null) {
                i4 = getPosition(view);
            }
            savedState2.d = i4;
            int i5 = this.a;
            savedState2.e = i5;
            savedState2.f2352a = new int[i5];
            for (int i6 = 0; i6 < this.a; i6++) {
                if (this.f2346c) {
                    i2 = this.f2343a[i6].f(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f2334a.g();
                    } else {
                        savedState2.f2352a[i6] = i2;
                    }
                } else {
                    i2 = this.f2343a[i6].i(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f2334a.k();
                    } else {
                        savedState2.f2352a[i6] = i2;
                    }
                }
                i2 -= i3;
                savedState2.f2352a[i6] = i2;
            }
        } else {
            savedState2.c = -1;
            savedState2.d = -1;
            savedState2.e = 0;
        }
        return savedState2;
    }

    public final void onScrollStateChanged(int i) {
        if (i == 0) {
            b();
        }
    }

    public final boolean p(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.b == 0) {
            if (i == -1) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3 != this.f2345b) {
                return true;
            }
            return false;
        }
        if (i == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z == this.f2345b) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 == isLayoutRTL()) {
            return true;
        }
        return false;
    }

    public final void q(int i, RecyclerView.State state) {
        int i2;
        int i3;
        if (i > 0) {
            i3 = i();
            i2 = 1;
        } else {
            i3 = h();
            i2 = -1;
        }
        h hVar = this.f2339a;
        hVar.f2403a = true;
        v(i3, state);
        u(i2);
        hVar.b = i3 + hVar.c;
        hVar.a = Math.abs(i);
    }

    public final void r(RecyclerView.Recycler recycler, h hVar) {
        int i;
        int i2;
        if (hVar.f2403a && !hVar.f2405c) {
            if (hVar.a != 0) {
                int i3 = 1;
                if (hVar.d == -1) {
                    int i4 = hVar.e;
                    int i5 = this.f2343a[0].i(i4);
                    while (i3 < this.a) {
                        int i6 = this.f2343a[i3].i(i4);
                        if (i6 > i5) {
                            i5 = i6;
                        }
                        i3++;
                    }
                    int i7 = i4 - i5;
                    if (i7 < 0) {
                        i2 = hVar.f;
                    } else {
                        i2 = hVar.f - Math.min(i7, hVar.a);
                    }
                    s(recycler, i2);
                    return;
                }
                int i8 = hVar.f;
                int f2 = this.f2343a[0].f(i8);
                while (i3 < this.a) {
                    int f3 = this.f2343a[i3].f(i8);
                    if (f3 < f2) {
                        f2 = f3;
                    }
                    i3++;
                }
                int i9 = f2 - hVar.f;
                if (i9 < 0) {
                    i = hVar.e;
                } else {
                    i = Math.min(i9, hVar.a) + hVar.e;
                }
                t(recycler, i);
            } else if (hVar.d == -1) {
                s(recycler, hVar.f);
            } else {
                t(recycler, hVar.e);
            }
        }
    }

    public final void resolveShouldLayoutReverse() {
        if (this.b == 1 || !isLayoutRTL()) {
            this.f2345b = this.f2341a;
        } else {
            this.f2345b = !this.f2341a;
        }
    }

    public final void s(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.f2334a.e(childAt) >= i && this.f2334a.n(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.getClass();
                if (layoutParams.a.f2360a.size() != 1) {
                    c cVar = layoutParams.a;
                    ArrayList<View> arrayList = cVar.f2360a;
                    int size = arrayList.size();
                    View remove = arrayList.remove(size - 1);
                    LayoutParams h = c.h(remove);
                    h.a = null;
                    if (h.c() || h.b()) {
                        cVar.c -= StaggeredGridLayoutManager.this.f2334a.c(remove);
                    }
                    if (size == 1) {
                        cVar.a = Integer.MIN_VALUE;
                    }
                    cVar.b = Integer.MIN_VALUE;
                    removeAndRecycleView(childAt, recycler);
                    childCount--;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        q(i, state);
        h hVar = this.f2339a;
        int c2 = c(recycler, hVar, state);
        if (hVar.a >= c2) {
            if (i < 0) {
                i = -c2;
            } else {
                i = c2;
            }
        }
        this.f2334a.o(-i);
        this.f2346c = this.f2345b;
        hVar.a = 0;
        r(recycler, hVar);
        return i;
    }

    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    public final void scrollToPosition(int i) {
        SavedState savedState = this.f2336a;
        if (!(savedState == null || savedState.c == i)) {
            savedState.f2352a = null;
            savedState.e = 0;
            savedState.c = -1;
            savedState.d = -1;
        }
        this.d = i;
        this.e = Integer.MIN_VALUE;
        requestLayout();
    }

    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return scrollBy(i, recycler, state);
    }

    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.b == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            i3 = RecyclerView.LayoutManager.chooseSize(i, (this.c * this.a) + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            i4 = RecyclerView.LayoutManager.chooseSize(i2, (this.c * this.a) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public final boolean supportsPredictiveItemAnimations() {
        if (this.f2336a == null) {
            return true;
        }
        return false;
    }

    public final void t(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f2334a.b(childAt) <= i && this.f2334a.m(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.getClass();
                if (layoutParams.a.f2360a.size() != 1) {
                    c cVar = layoutParams.a;
                    ArrayList<View> arrayList = cVar.f2360a;
                    View remove = arrayList.remove(0);
                    LayoutParams h = c.h(remove);
                    h.a = null;
                    if (arrayList.size() == 0) {
                        cVar.b = Integer.MIN_VALUE;
                    }
                    if (h.c() || h.b()) {
                        cVar.c -= StaggeredGridLayoutManager.this.f2334a.c(remove);
                    }
                    cVar.a = Integer.MIN_VALUE;
                    removeAndRecycleView(childAt, recycler);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void u(int i) {
        boolean z;
        h hVar = this.f2339a;
        hVar.d = i;
        boolean z2 = this.f2345b;
        int i2 = 1;
        if (i == -1) {
            z = true;
        } else {
            z = false;
        }
        if (z2 != z) {
            i2 = -1;
        }
        hVar.c = i2;
    }

    public final void v(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int i4;
        boolean z;
        h hVar = this.f2339a;
        boolean z2 = false;
        hVar.a = 0;
        hVar.b = i;
        if (!isSmoothScrolling() || (i4 = state.a) == -1) {
            i3 = 0;
            i2 = 0;
        } else {
            boolean z3 = this.f2345b;
            if (i4 < i) {
                z = true;
            } else {
                z = false;
            }
            if (z3 == z) {
                i3 = this.f2334a.l();
                i2 = 0;
            } else {
                i2 = this.f2334a.l();
                i3 = 0;
            }
        }
        if (getClipToPadding()) {
            hVar.e = this.f2334a.k() - i2;
            hVar.f = this.f2334a.g() + i3;
        } else {
            hVar.f = this.f2334a.f() + i3;
            hVar.e = -i2;
        }
        hVar.f2404b = false;
        hVar.f2403a = true;
        if (this.f2334a.i() == 0 && this.f2334a.f() == 0) {
            z2 = true;
        }
        hVar.f2405c = z2;
    }

    public final void w(c cVar, int i, int i2) {
        int i3 = cVar.c;
        int i4 = cVar.d;
        if (i == -1) {
            int i5 = cVar.a;
            if (i5 == Integer.MIN_VALUE) {
                View view = cVar.f2360a.get(0);
                LayoutParams h = c.h(view);
                cVar.a = StaggeredGridLayoutManager.this.f2334a.e(view);
                h.getClass();
                i5 = cVar.a;
            }
            if (i5 + i3 <= i2) {
                this.f2340a.set(i4, false);
                return;
            }
            return;
        }
        int i6 = cVar.b;
        if (i6 == Integer.MIN_VALUE) {
            cVar.a();
            i6 = cVar.b;
        }
        if (i6 - i3 >= i2) {
            this.f2340a.set(i4, false);
        }
    }

    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LazySpanLookup {
        public List<FullSpanItem> a;

        /* renamed from: a  reason: collision with other field name */
        public int[] f2349a;

        public final void a() {
            int[] iArr = this.f2349a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.a = null;
        }

        public final void b(int i) {
            int[] iArr = this.f2349a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i, 10) + 1)];
                this.f2349a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f2349a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f2349a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int c(int r6) {
            /*
                r5 = this;
                int[] r0 = r5.f2349a
                r1 = -1
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                int r0 = r0.length
                if (r6 < r0) goto L_0x000a
                return r1
            L_0x000a:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.a
                if (r0 != 0) goto L_0x000f
                goto L_0x005e
            L_0x000f:
                r2 = 0
                if (r0 != 0) goto L_0x0013
                goto L_0x002b
            L_0x0013:
                int r0 = r0.size()
                int r0 = r0 + r1
            L_0x0018:
                if (r0 < 0) goto L_0x002b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r5.a
                java.lang.Object r3 = r3.get(r0)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r3
                int r4 = r3.c
                if (r4 != r6) goto L_0x0028
                r2 = r3
                goto L_0x002b
            L_0x0028:
                int r0 = r0 + -1
                goto L_0x0018
            L_0x002b:
                if (r2 == 0) goto L_0x0032
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.a
                r0.remove(r2)
            L_0x0032:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.a
                int r0 = r0.size()
                r2 = 0
            L_0x0039:
                if (r2 >= r0) goto L_0x004b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r5.a
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r3
                int r3 = r3.c
                if (r3 < r6) goto L_0x0048
                goto L_0x004c
            L_0x0048:
                int r2 = r2 + 1
                goto L_0x0039
            L_0x004b:
                r2 = r1
            L_0x004c:
                if (r2 == r1) goto L_0x005e
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r5.a
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r5.a
                r3.remove(r2)
                int r0 = r0.c
                goto L_0x005f
            L_0x005e:
                r0 = r1
            L_0x005f:
                if (r0 != r1) goto L_0x006b
                int[] r0 = r5.f2349a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r6, r2, r1)
                int[] r6 = r5.f2349a
                int r6 = r6.length
                return r6
            L_0x006b:
                int r0 = r0 + 1
                int[] r2 = r5.f2349a
                int r2 = r2.length
                int r0 = java.lang.Math.min(r0, r2)
                int[] r2 = r5.f2349a
                java.util.Arrays.fill(r2, r6, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.c(int):int");
        }

        public final void d(int i, int i2) {
            int[] iArr = this.f2349a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                b(i3);
                int[] iArr2 = this.f2349a;
                System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
                Arrays.fill(this.f2349a, i, i3, -1);
                List<FullSpanItem> list = this.a;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.a.get(size);
                        int i4 = fullSpanItem.c;
                        if (i4 >= i) {
                            fullSpanItem.c = i4 + i2;
                        }
                    }
                }
            }
        }

        public final void e(int i, int i2) {
            int[] iArr = this.f2349a;
            if (iArr != null && i < iArr.length) {
                int i3 = i + i2;
                b(i3);
                int[] iArr2 = this.f2349a;
                System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
                int[] iArr3 = this.f2349a;
                Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
                List<FullSpanItem> list = this.a;
                if (list != null) {
                    for (int size = list.size() - 1; size >= 0; size--) {
                        FullSpanItem fullSpanItem = this.a.get(size);
                        int i4 = fullSpanItem.c;
                        if (i4 >= i) {
                            if (i4 < i3) {
                                this.a.remove(size);
                            } else {
                                fullSpanItem.c = i4 - i2;
                            }
                        }
                    }
                }
            }
        }

        @SuppressLint({"BanParcelableUsage"})
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new a();
            public boolean a;

            /* renamed from: a  reason: collision with other field name */
            public int[] f2350a;
            public int c;
            public int d;

            public class a implements Parcelable.Creator<FullSpanItem> {
                public final Object createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public final Object[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.c = parcel.readInt();
                this.d = parcel.readInt();
                this.a = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f2350a = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            public final int describeContents() {
                return 0;
            }

            public final String toString() {
                return "FullSpanItem{mPosition=" + this.c + ", mGapDir=" + this.d + ", mHasUnwantedGapAfter=" + this.a + ", mGapPerSpan=" + Arrays.toString(this.f2350a) + '}';
            }

            public final void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.c);
                parcel.writeInt(this.d);
                parcel.writeInt(this.a ? 1 : 0);
                int[] iArr = this.f2350a;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f2350a);
            }

            public FullSpanItem() {
            }
        }
    }
}
