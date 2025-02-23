package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.c;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.WeakHashMap;

public final class ViewPager2 extends ViewGroup {
    public Qb a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2606a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public Parcelable f2607a;

    /* renamed from: a  reason: collision with other field name */
    public RecyclerView.ItemAnimator f2608a = null;

    /* renamed from: a  reason: collision with other field name */
    public final a f2609a = new a();

    /* renamed from: a  reason: collision with other field name */
    public f f2610a;

    /* renamed from: a  reason: collision with other field name */
    public h f2611a;

    /* renamed from: a  reason: collision with other field name */
    public j f2612a;

    /* renamed from: a  reason: collision with other field name */
    public k f2613a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2614a = new a();

    /* renamed from: a  reason: collision with other field name */
    public b f2615a;

    /* renamed from: a  reason: collision with other field name */
    public c f2616a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2617a = false;
    public final Rect b = new Rect();

    /* renamed from: b  reason: collision with other field name */
    public a f2618b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2619b = false;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2620c = true;
    public int d = -1;
    public int e = -1;

    public class a extends e {
        public a() {
            super(0);
        }

        public final void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f2617a = true;
            viewPager2.f2616a.f2631c = true;
        }
    }

    public class b extends g {
        public b() {
        }

        public final void onPageScrollStateChanged(int i) {
            if (i == 0) {
                ViewPager2.this.d();
            }
        }

        public final void onPageSelected(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.c != i) {
                viewPager2.c = i;
                viewPager2.f2611a.b();
            }
        }
    }

    public class c extends g {
        public c() {
        }

        public final void onPageSelected(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.clearFocus();
            if (viewPager2.hasFocus()) {
                viewPager2.f2613a.requestFocus(2);
            }
        }
    }

    public abstract class d {
    }

    public static abstract class e extends RecyclerView.AdapterDataObserver {
        public e(int i) {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    public class f extends LinearLayoutManager {
        public f(Context context) {
            super(context);
        }

        public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            ViewPager2 viewPager2 = ViewPager2.this;
            int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(state, iArr);
                return;
            }
            int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        public final void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f2611a.getClass();
        }

        public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i2 = 0;
            if (viewPager2.getOrientation() == 1) {
                i = viewPager2.f2610a.getPosition(view);
            } else {
                i = 0;
            }
            if (viewPager2.getOrientation() == 0) {
                i2 = viewPager2.f2610a.getPosition(view);
            }
            accessibilityNodeInfoCompat.l(AccessibilityNodeInfoCompat.e.a(i, 1, i2, 1, false, false));
        }

        public final boolean performAccessibilityAction(RecyclerView.Recycler recycler, RecyclerView.State state, int i, Bundle bundle) {
            ViewPager2.this.f2611a.getClass();
            return super.performAccessibilityAction(recycler, state, i, bundle);
        }

        public final boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    public class h extends d {
        public final a a = new a();

        /* renamed from: a  reason: collision with other field name */
        public final b f2621a = new b();

        /* renamed from: a  reason: collision with other field name */
        public d f2623a;

        public class a implements AccessibilityViewCommand {
            public a() {
            }

            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                int currentItem = ((ViewPager2) view).getCurrentItem() + 1;
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f2620c) {
                    viewPager2.c(currentItem, true);
                }
                return true;
            }
        }

        public class b implements AccessibilityViewCommand {
            public b() {
            }

            public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f2620c) {
                    viewPager2.c(currentItem, true);
                }
                return true;
            }
        }

        public h() {
        }

        public final void a(RecyclerView recyclerView) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            recyclerView.setImportantForAccessibility(2);
            this.f2623a = new d(this);
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.getImportantForAccessibility() == 0) {
                viewPager2.setImportantForAccessibility(1);
            }
        }

        public final void b() {
            int itemCount;
            int i;
            int i2 = 16908360;
            ViewPager2 viewPager2 = ViewPager2.this;
            androidx.core.view.f.l(16908360, viewPager2);
            boolean z = false;
            androidx.core.view.f.i(0, viewPager2);
            androidx.core.view.f.l(16908361, viewPager2);
            androidx.core.view.f.i(0, viewPager2);
            androidx.core.view.f.l(16908358, viewPager2);
            androidx.core.view.f.i(0, viewPager2);
            androidx.core.view.f.l(16908359, viewPager2);
            androidx.core.view.f.i(0, viewPager2);
            if (viewPager2.getAdapter() != null && (itemCount = viewPager2.getAdapter().getItemCount()) != 0 && viewPager2.f2620c) {
                int orientation = viewPager2.getOrientation();
                b bVar = this.f2621a;
                a aVar = this.a;
                if (orientation == 0) {
                    if (viewPager2.f2610a.getLayoutDirection() == 1) {
                        z = true;
                    }
                    if (z) {
                        i = 16908360;
                    } else {
                        i = 16908361;
                    }
                    if (z) {
                        i2 = 16908361;
                    }
                    if (viewPager2.c < itemCount - 1) {
                        androidx.core.view.f.m(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i, (String) null), (String) null, aVar);
                    }
                    if (viewPager2.c > 0) {
                        androidx.core.view.f.m(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i2, (String) null), (String) null, bVar);
                        return;
                    }
                    return;
                }
                if (viewPager2.c < itemCount - 1) {
                    androidx.core.view.f.m(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908359, (String) null), (String) null, aVar);
                }
                if (viewPager2.c > 0) {
                    androidx.core.view.f.m(viewPager2, new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908358, (String) null), (String) null, bVar);
                }
            }
        }
    }

    public interface i {
    }

    public class j extends androidx.recyclerview.widget.l {
        public j() {
        }

        public final View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.a.a.f2632d) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    public class k extends RecyclerView {
        public k(Context context) {
            super(context);
        }

        public final CharSequence getAccessibilityClassName() {
            ViewPager2.this.f2611a.getClass();
            return super.getAccessibilityClassName();
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            ViewPager2 viewPager2 = ViewPager2.this;
            accessibilityEvent.setFromIndex(viewPager2.c);
            accessibilityEvent.setToIndex(viewPager2.c);
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (!ViewPager2.this.f2620c || !super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            if (!ViewPager2.this.f2620c || !super.onTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
    }

    public static class l implements Runnable {
        public final RecyclerView a;
        public final int c;

        public l(k kVar, int i) {
            this.c = i;
            this.a = kVar;
        }

        public final void run() {
            this.a.smoothScrollToPosition(this.c);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    /* JADX INFO: finally extract failed */
    public final void a(Context context, AttributeSet attributeSet) {
        this.f2611a = new h();
        k kVar = new k(context);
        this.f2613a = kVar;
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        kVar.setId(View.generateViewId());
        this.f2613a.setDescendantFocusability(131072);
        f fVar = new f(context);
        this.f2610a = fVar;
        this.f2613a.setLayoutManager(fVar);
        this.f2613a.setScrollingTouchSlop(1);
        int[] iArr = ns.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        androidx.core.view.f.n(this, context, iArr, attributeSet, obtainStyledAttributes, 0);
        try {
            setOrientation(obtainStyledAttributes.getInt(ns.ViewPager2_android_orientation, 0));
            obtainStyledAttributes.recycle();
            this.f2613a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f2613a.addOnChildAttachStateChangeListener(new CC());
            c cVar = new c(this);
            this.f2616a = cVar;
            this.a = new Qb(cVar);
            j jVar = new j();
            this.f2612a = jVar;
            jVar.attachToRecyclerView(this.f2613a);
            this.f2613a.addOnScrollListener(this.f2616a);
            a aVar = new a();
            this.f2618b = aVar;
            this.f2616a.f2626a = aVar;
            b bVar = new b();
            c cVar2 = new c();
            this.f2618b.a.add(bVar);
            this.f2618b.a.add(cVar2);
            this.f2611a.a(this.f2613a);
            this.f2618b.a.add(this.f2614a);
            b bVar2 = new b(this.f2610a);
            this.f2615a = bVar2;
            this.f2618b.a.add(bVar2);
            k kVar2 = this.f2613a;
            attachViewToParent(kVar2, 0, kVar2.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void b() {
        RecyclerView.Adapter adapter;
        if (this.d != -1 && (adapter = getAdapter()) != null) {
            if (this.f2607a != null) {
                if (adapter instanceof Vx) {
                    ((Vx) adapter).b();
                }
                this.f2607a = null;
            }
            int max = Math.max(0, Math.min(this.d, adapter.getItemCount() - 1));
            this.c = max;
            this.d = -1;
            this.f2613a.scrollToPosition(max);
            this.f2611a.b();
        }
    }

    public final void c(int i2, boolean z) {
        boolean z2;
        int i3;
        int i4;
        g gVar;
        boolean z3;
        RecyclerView.Adapter adapter = getAdapter();
        boolean z4 = false;
        if (adapter == null) {
            if (this.d != -1) {
                this.d = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() > 0) {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            int i5 = this.c;
            if (min == i5) {
                if (this.f2616a.b == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    return;
                }
            }
            if (min != i5 || !z) {
                double d2 = (double) i5;
                this.c = min;
                this.f2611a.b();
                c cVar = this.f2616a;
                if (cVar.b == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    cVar.c();
                    c.a aVar = cVar.f2628a;
                    d2 = ((double) aVar.f2633a) + ((double) aVar.a);
                }
                c cVar2 = this.f2616a;
                cVar2.getClass();
                if (z) {
                    i3 = 2;
                } else {
                    i3 = 3;
                }
                cVar2.a = i3;
                cVar2.f2632d = false;
                if (cVar2.d != min) {
                    z4 = true;
                }
                cVar2.d = min;
                cVar2.a(2);
                if (z4 && (gVar = cVar2.f2626a) != null) {
                    gVar.onPageSelected(min);
                }
                if (!z) {
                    this.f2613a.scrollToPosition(min);
                    return;
                }
                double d3 = (double) min;
                if (Math.abs(d3 - d2) > 3.0d) {
                    k kVar = this.f2613a;
                    if (d3 > d2) {
                        i4 = min - 3;
                    } else {
                        i4 = min + 3;
                    }
                    kVar.scrollToPosition(i4);
                    k kVar2 = this.f2613a;
                    kVar2.post(new l(kVar2, min));
                    return;
                }
                this.f2613a.smoothScrollToPosition(min);
            }
        }
    }

    public final boolean canScrollHorizontally(int i2) {
        return this.f2613a.canScrollHorizontally(i2);
    }

    public final boolean canScrollVertically(int i2) {
        return this.f2613a.canScrollVertically(i2);
    }

    public final void d() {
        j jVar = this.f2612a;
        if (jVar != null) {
            View findSnapView = jVar.findSnapView(this.f2610a);
            if (findSnapView != null) {
                int position = this.f2610a.getPosition(findSnapView);
                if (position != this.c && getScrollState() == 0) {
                    this.f2618b.onPageSelected(position);
                }
                this.f2617a = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public final void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).c;
            sparseArray.put(this.f2613a.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        b();
    }

    public CharSequence getAccessibilityClassName() {
        this.f2611a.getClass();
        this.f2611a.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public RecyclerView.Adapter getAdapter() {
        return this.f2613a.getAdapter();
    }

    public int getCurrentItem() {
        return this.c;
    }

    public int getItemDecorationCount() {
        return this.f2613a.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.e;
    }

    public int getOrientation() {
        if (this.f2610a.getOrientation() == 1) {
            return 1;
        }
        return 0;
    }

    public int getPageSize() {
        int i2;
        int i3;
        k kVar = this.f2613a;
        if (getOrientation() == 0) {
            i2 = kVar.getWidth() - kVar.getPaddingLeft();
            i3 = kVar.getPaddingRight();
        } else {
            i2 = kVar.getHeight() - kVar.getPaddingTop();
            i3 = kVar.getPaddingBottom();
        }
        return i2 - i3;
    }

    public int getScrollState() {
        return this.f2616a.b;
    }

    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        int i3;
        int itemCount;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        h hVar = this.f2611a;
        hVar.getClass();
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
        ViewPager2 viewPager2 = ViewPager2.this;
        if (viewPager2.getAdapter() == null) {
            i3 = 0;
            i2 = 0;
        } else if (viewPager2.getOrientation() == 1) {
            i3 = viewPager2.getAdapter().getItemCount();
            i2 = 1;
        } else {
            i2 = viewPager2.getAdapter().getItemCount();
            i3 = 1;
        }
        accessibilityNodeInfoCompat.k(AccessibilityNodeInfoCompat.d.a(i3, i2, 0, false));
        RecyclerView.Adapter adapter = viewPager2.getAdapter();
        if (adapter != null && (itemCount = adapter.getItemCount()) != 0 && viewPager2.f2620c) {
            if (viewPager2.c > 0) {
                accessibilityNodeInfoCompat.a(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
            if (viewPager2.c < itemCount - 1) {
                accessibilityNodeInfoCompat.a(4096);
            }
            accessibilityNodeInfoCompat.n(true);
        }
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f2613a.getMeasuredWidth();
        int measuredHeight = this.f2613a.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.f2606a;
        rect.left = paddingLeft;
        rect.right = (i4 - i2) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i5 - i3) - getPaddingBottom();
        Rect rect2 = this.b;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.f2613a.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.f2617a) {
            d();
        }
    }

    public final void onMeasure(int i2, int i3) {
        measureChild(this.f2613a, i2, i3);
        int measuredWidth = this.f2613a.getMeasuredWidth();
        int measuredHeight = this.f2613a.getMeasuredHeight();
        int measuredState = this.f2613a.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, measuredState), View.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.d = savedState.d;
        this.f2607a = savedState.a;
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.f2613a.getId();
        int i2 = this.d;
        if (i2 == -1) {
            i2 = this.c;
        }
        savedState.d = i2;
        Parcelable parcelable = this.f2607a;
        if (parcelable != null) {
            savedState.a = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f2613a.getAdapter();
            if (adapter instanceof Vx) {
                savedState.a = ((Vx) adapter).a();
            }
        }
        return savedState;
    }

    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    public final boolean performAccessibilityAction(int i2, Bundle bundle) {
        boolean z;
        int i3;
        this.f2611a.getClass();
        boolean z2 = false;
        if (i2 == 8192 || i2 == 4096) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return super.performAccessibilityAction(i2, bundle);
        }
        h hVar = this.f2611a;
        hVar.getClass();
        if (i2 == 8192 || i2 == 4096) {
            z2 = true;
        }
        if (z2) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (i2 == 8192) {
                i3 = viewPager2.getCurrentItem() - 1;
            } else {
                i3 = viewPager2.getCurrentItem() + 1;
            }
            if (viewPager2.f2620c) {
                viewPager2.c(i3, true);
            }
            return true;
        }
        throw new IllegalStateException();
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f2613a.getAdapter();
        h hVar = this.f2611a;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(hVar.f2623a);
        } else {
            hVar.getClass();
        }
        a aVar = this.f2609a;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(aVar);
        }
        this.f2613a.setAdapter(adapter);
        this.c = 0;
        b();
        h hVar2 = this.f2611a;
        hVar2.b();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(hVar2.f2623a);
        }
        if (adapter != null) {
            adapter.registerAdapterDataObserver(aVar);
        }
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.f2611a.b();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 >= 1 || i2 == -1) {
            this.e = i2;
            this.f2613a.requestLayout();
            return;
        }
        throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
    }

    public void setOrientation(int i2) {
        this.f2610a.setOrientation(i2);
        this.f2611a.b();
    }

    public void setPageTransformer(i iVar) {
        if (iVar != null) {
            if (!this.f2619b) {
                this.f2608a = this.f2613a.getItemAnimator();
                this.f2619b = true;
            }
            this.f2613a.setItemAnimator((RecyclerView.ItemAnimator) null);
        } else if (this.f2619b) {
            this.f2613a.setItemAnimator(this.f2608a);
            this.f2608a = null;
            this.f2619b = false;
        }
        this.f2615a.getClass();
        if (iVar != null) {
            this.f2615a.getClass();
            this.f2615a.getClass();
        }
    }

    public void setUserInputEnabled(boolean z) {
        this.f2620c = z;
        this.f2611a.b();
    }

    public void setCurrentItem(int i2, boolean z) {
        if (!this.a.a.f2632d) {
            c(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Parcelable a;
        public int c;
        public int d;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState() {
            throw null;
        }

        @SuppressLint({"ClassVerificationFailure"})
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.a = parcel.readParcelable(classLoader);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeParcelable(this.a, i);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public static abstract class g {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageSelected(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
