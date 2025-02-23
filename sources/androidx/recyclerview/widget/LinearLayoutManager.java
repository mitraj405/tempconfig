package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.a {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class AnchorInfo {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public OrientationHelper f2294a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2295a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f2296b;

        public AnchorInfo() {
            d();
        }

        public final void a() {
            int i;
            if (this.f2295a) {
                i = this.f2294a.g();
            } else {
                i = this.f2294a.k();
            }
            this.b = i;
        }

        public final void b(int i, View view) {
            int i2;
            if (this.f2295a) {
                int b2 = this.f2294a.b(view);
                OrientationHelper orientationHelper = this.f2294a;
                if (Integer.MIN_VALUE == orientationHelper.a) {
                    i2 = 0;
                } else {
                    i2 = orientationHelper.l() - orientationHelper.a;
                }
                this.b = i2 + b2;
            } else {
                this.b = this.f2294a.e(view);
            }
            this.a = i;
        }

        public final void c(int i, View view) {
            int i2;
            OrientationHelper orientationHelper = this.f2294a;
            if (Integer.MIN_VALUE == orientationHelper.a) {
                i2 = 0;
            } else {
                i2 = orientationHelper.l() - orientationHelper.a;
            }
            if (i2 >= 0) {
                b(i, view);
                return;
            }
            this.a = i;
            if (this.f2295a) {
                int g = (this.f2294a.g() - i2) - this.f2294a.b(view);
                this.b = this.f2294a.g() - g;
                if (g > 0) {
                    int c = this.b - this.f2294a.c(view);
                    int k = this.f2294a.k();
                    int min = c - (Math.min(this.f2294a.e(view) - k, 0) + k);
                    if (min < 0) {
                        this.b = Math.min(g, -min) + this.b;
                        return;
                    }
                    return;
                }
                return;
            }
            int e = this.f2294a.e(view);
            int k2 = e - this.f2294a.k();
            this.b = e;
            if (k2 > 0) {
                int g2 = (this.f2294a.g() - Math.min(0, (this.f2294a.g() - i2) - this.f2294a.b(view))) - (this.f2294a.c(view) + e);
                if (g2 < 0) {
                    this.b -= Math.min(k2, -g2);
                }
            }
        }

        public final void d() {
            this.a = -1;
            this.b = Integer.MIN_VALUE;
            this.f2295a = false;
            this.f2296b = false;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mCoordinate=" + this.b + ", mLayoutFromEnd=" + this.f2295a + ", mValid=" + this.f2296b + '}';
        }
    }

    public static class LayoutChunkResult {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2297a;
        public boolean b;
        public boolean c;
    }

    public static class LayoutState {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public List<RecyclerView.ViewHolder> f2298a = null;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2299a = true;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f2300b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g = 0;
        public int h = 0;
        public int i;

        public final void a(View view) {
            int a2;
            int size = this.f2298a.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.f2298a.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.c() && (a2 = (layoutParams.a() - this.c) * this.d) >= 0 && a2 < i2) {
                    view2 = view3;
                    if (a2 == 0) {
                        break;
                    }
                    i2 = a2;
                }
            }
            if (view2 == null) {
                this.c = -1;
            } else {
                this.c = ((RecyclerView.LayoutParams) view2.getLayoutParams()).a();
            }
        }

        public final View b(RecyclerView.Recycler recycler) {
            List<RecyclerView.ViewHolder> list = this.f2298a;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    View view = this.f2298a.get(i2).itemView;
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    if (!layoutParams.c() && this.c == layoutParams.a()) {
                        a(view);
                        return view;
                    }
                }
                return null;
            }
            View d2 = recycler.d(this.c);
            this.c += this.d;
            return d2;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean a;
        public int c;
        public int d;

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
            parcel.writeInt(this.a ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.a = parcel.readInt() != 1 ? false : true;
        }

        @SuppressLint({"UnknownNullness"})
        public SavedState(SavedState savedState) {
            this.c = savedState.c;
            this.d = savedState.d;
            this.a = savedState.a;
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return m.a(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return m.b(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true);
        return m.c(state, orientationHelper, findFirstVisibleChildClosestToStart, findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild();
        }
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild();
        }
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int g;
        int g2 = this.mOrientationHelper.g() - i;
        if (g2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-g2, recycler, state);
        int i3 = i + i2;
        if (!z || (g = this.mOrientationHelper.g() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.o(g);
        return g + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int k;
        int k2 = i - this.mOrientationHelper.k();
        if (k2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(k2, recycler, state);
        int i3 = i + i2;
        if (!z || (k = i3 - this.mOrientationHelper.k()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.o(-k);
        return i2 - k;
    }

    private View getChildClosestToEnd() {
        int i;
        if (this.mShouldReverseLayout) {
            i = 0;
        } else {
            i = getChildCount() - 1;
        }
        return getChildAt(i);
    }

    private View getChildClosestToStart() {
        int i;
        if (this.mShouldReverseLayout) {
            i = getChildCount() - 1;
        } else {
            i = 0;
        }
        return getChildAt(i);
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        boolean z;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        if (state2.f2328f && getChildCount() != 0 && !state2.f2324b && supportsPredictiveItemAnimations()) {
            List<RecyclerView.ViewHolder> list = recycler2.f2318a;
            int size = list.size();
            int position = getPosition(getChildAt(0));
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.ViewHolder viewHolder = list.get(i5);
                if (!viewHolder.isRemoved()) {
                    boolean z2 = true;
                    if (viewHolder.getLayoutPosition() < position) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z != this.mShouldReverseLayout) {
                        z2 = true;
                    }
                    if (z2) {
                        i3 += this.mOrientationHelper.c(viewHolder.itemView);
                    } else {
                        i4 += this.mOrientationHelper.c(viewHolder.itemView);
                    }
                }
            }
            this.mLayoutState.f2298a = list;
            if (i3 > 0) {
                updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                LayoutState layoutState = this.mLayoutState;
                layoutState.g = i3;
                layoutState.b = 0;
                layoutState.a((View) null);
                fill(recycler2, this.mLayoutState, state2, false);
            }
            if (i4 > 0) {
                updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                LayoutState layoutState2 = this.mLayoutState;
                layoutState2.g = i4;
                layoutState2.b = 0;
                layoutState2.a((View) null);
                fill(recycler2, this.mLayoutState, state2, false);
            }
            this.mLayoutState.f2298a = null;
        }
    }

    private void logChildren() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            getPosition(childAt);
            this.mOrientationHelper.e(childAt);
        }
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.f2299a && !layoutState.f2300b) {
            int i = layoutState.f;
            int i2 = layoutState.h;
            if (layoutState.e == -1) {
                recycleViewsFromEnd(recycler, i, i2);
            } else {
                recycleViewsFromStart(recycler, i, i2);
            }
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler recycler, int i, int i2) {
        int childCount = getChildCount();
        if (i >= 0) {
            int f = (this.mOrientationHelper.f() - i) + i2;
            if (this.mShouldReverseLayout) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = getChildAt(i3);
                    if (this.mOrientationHelper.e(childAt) < f || this.mOrientationHelper.n(childAt) < f) {
                        recycleChildren(recycler, 0, i3);
                        return;
                    }
                }
                return;
            }
            int i4 = childCount - 1;
            for (int i5 = i4; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (this.mOrientationHelper.e(childAt2) < f || this.mOrientationHelper.n(childAt2) < f) {
                    recycleChildren(recycler, i4, i5);
                    return;
                }
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.Recycler recycler, int i, int i2) {
        if (i >= 0) {
            int i3 = i - i2;
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                int i4 = childCount - 1;
                for (int i5 = i4; i5 >= 0; i5--) {
                    View childAt = getChildAt(i5);
                    if (this.mOrientationHelper.b(childAt) > i3 || this.mOrientationHelper.m(childAt) > i3) {
                        recycleChildren(recycler, i4, i5);
                        return;
                    }
                }
                return;
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt2 = getChildAt(i6);
                if (this.mOrientationHelper.b(childAt2) > i3 || this.mOrientationHelper.m(childAt2) > i3) {
                    recycleChildren(recycler, 0, i6);
                    return;
                }
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        View findReferenceChild;
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            anchorInfo.getClass();
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) focusedChild.getLayoutParams();
            if (layoutParams.c() || layoutParams.a() < 0 || layoutParams.a() >= state.b()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                anchorInfo.c(getPosition(focusedChild), focusedChild);
                return true;
            }
        }
        boolean z4 = this.mLastStackFromEnd;
        boolean z5 = this.mStackFromEnd;
        if (z4 != z5 || (findReferenceChild = findReferenceChild(recycler, state, anchorInfo.f2295a, z5)) == null) {
            return false;
        }
        anchorInfo.b(getPosition(findReferenceChild), findReferenceChild);
        if (!state.f2324b && supportsPredictiveItemAnimations()) {
            int e = this.mOrientationHelper.e(findReferenceChild);
            int b = this.mOrientationHelper.b(findReferenceChild);
            int k = this.mOrientationHelper.k();
            int g = this.mOrientationHelper.g();
            if (b > k || e >= k) {
                z = false;
            } else {
                z = true;
            }
            if (e >= g && b > g) {
                z3 = true;
            }
            if (z || z3) {
                if (anchorInfo.f2295a) {
                    k = g;
                }
                anchorInfo.b = k;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        boolean z;
        int i2;
        boolean z2;
        boolean z3 = false;
        if (!state.f2324b && (i = this.mPendingScrollPosition) != -1) {
            if (i < 0 || i >= state.b()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
            } else {
                int i3 = this.mPendingScrollPosition;
                anchorInfo.a = i3;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null) {
                    if (savedState.c >= 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        boolean z4 = savedState.a;
                        anchorInfo.f2295a = z4;
                        if (z4) {
                            anchorInfo.b = this.mOrientationHelper.g() - this.mPendingSavedState.d;
                        } else {
                            anchorInfo.b = this.mOrientationHelper.k() + this.mPendingSavedState.d;
                        }
                        return true;
                    }
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(i3);
                    if (findViewByPosition == null) {
                        if (getChildCount() > 0) {
                            if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z == this.mShouldReverseLayout) {
                                z3 = true;
                            }
                            anchorInfo.f2295a = z3;
                        }
                        anchorInfo.a();
                    } else if (this.mOrientationHelper.c(findViewByPosition) > this.mOrientationHelper.l()) {
                        anchorInfo.a();
                        return true;
                    } else if (this.mOrientationHelper.e(findViewByPosition) - this.mOrientationHelper.k() < 0) {
                        anchorInfo.b = this.mOrientationHelper.k();
                        anchorInfo.f2295a = false;
                        return true;
                    } else if (this.mOrientationHelper.g() - this.mOrientationHelper.b(findViewByPosition) < 0) {
                        anchorInfo.b = this.mOrientationHelper.g();
                        anchorInfo.f2295a = true;
                        return true;
                    } else {
                        if (anchorInfo.f2295a) {
                            int b = this.mOrientationHelper.b(findViewByPosition);
                            OrientationHelper orientationHelper = this.mOrientationHelper;
                            if (Integer.MIN_VALUE != orientationHelper.a) {
                                z3 = orientationHelper.l() - orientationHelper.a;
                            }
                            i2 = (z3 ? 1 : 0) + b;
                        } else {
                            i2 = this.mOrientationHelper.e(findViewByPosition);
                        }
                        anchorInfo.b = i2;
                    }
                    return true;
                }
                boolean z5 = this.mShouldReverseLayout;
                anchorInfo.f2295a = z5;
                if (z5) {
                    anchorInfo.b = this.mOrientationHelper.g() - this.mPendingScrollPositionOffset;
                } else {
                    anchorInfo.b = this.mOrientationHelper.k() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo) {
        int i;
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(recycler, state, anchorInfo)) {
            anchorInfo.a();
            if (this.mStackFromEnd) {
                i = state.b() - 1;
            } else {
                i = 0;
            }
            anchorInfo.a = i;
        }
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.State state) {
        int i3;
        int i4;
        this.mLayoutState.f2300b = resolveIsInfinite();
        this.mLayoutState.e = i;
        int[] iArr = this.mReusableIntPair;
        boolean z2 = false;
        iArr[0] = 0;
        int i5 = 1;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        if (i == 1) {
            z2 = true;
        }
        LayoutState layoutState = this.mLayoutState;
        if (z2) {
            i3 = max2;
        } else {
            i3 = max;
        }
        layoutState.g = i3;
        if (!z2) {
            max = max2;
        }
        layoutState.h = max;
        if (z2) {
            layoutState.g = this.mOrientationHelper.h() + i3;
            View childClosestToEnd = getChildClosestToEnd();
            LayoutState layoutState2 = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                i5 = -1;
            }
            layoutState2.d = i5;
            int position = getPosition(childClosestToEnd);
            LayoutState layoutState3 = this.mLayoutState;
            layoutState2.c = position + layoutState3.d;
            layoutState3.a = this.mOrientationHelper.b(childClosestToEnd);
            i4 = this.mOrientationHelper.b(childClosestToEnd) - this.mOrientationHelper.g();
        } else {
            View childClosestToStart = getChildClosestToStart();
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.g = this.mOrientationHelper.k() + layoutState4.g;
            LayoutState layoutState5 = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                i5 = -1;
            }
            layoutState5.d = i5;
            int position2 = getPosition(childClosestToStart);
            LayoutState layoutState6 = this.mLayoutState;
            layoutState5.c = position2 + layoutState6.d;
            layoutState6.a = this.mOrientationHelper.e(childClosestToStart);
            i4 = (-this.mOrientationHelper.e(childClosestToStart)) + this.mOrientationHelper.k();
        }
        LayoutState layoutState7 = this.mLayoutState;
        layoutState7.b = i2;
        if (z) {
            layoutState7.b = i2 - i4;
        }
        layoutState7.f = i4;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.a, anchorInfo.b);
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.a, anchorInfo.b);
    }

    @SuppressLint({"UnknownNullness"})
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.e == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    public boolean canScrollHorizontally() {
        if (this.mOrientation == 0) {
            return true;
        }
        return false;
    }

    public boolean canScrollVertically() {
        if (this.mOrientation == 1) {
            return true;
        }
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.State state, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i3;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            ensureLayoutState();
            if (i > 0) {
                i3 = 1;
            } else {
                i3 = -1;
            }
            updateLayoutState(i3, Math.abs(i), true, state);
            collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
    @android.annotation.SuppressLint({"UnknownNullness"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void collectInitialPrefetchPositions(int r7, androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry r8) {
        /*
            r6 = this;
            androidx.recyclerview.widget.LinearLayoutManager$SavedState r0 = r6.mPendingSavedState
            r1 = 1
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L_0x0013
            int r4 = r0.c
            if (r4 < 0) goto L_0x000d
            r5 = r1
            goto L_0x000e
        L_0x000d:
            r5 = r3
        L_0x000e:
            if (r5 == 0) goto L_0x0013
            boolean r0 = r0.a
            goto L_0x0022
        L_0x0013:
            r6.resolveShouldLayoutReverse()
            boolean r0 = r6.mShouldReverseLayout
            int r4 = r6.mPendingScrollPosition
            if (r4 != r2) goto L_0x0022
            if (r0 == 0) goto L_0x0021
            int r4 = r7 + -1
            goto L_0x0022
        L_0x0021:
            r4 = r3
        L_0x0022:
            if (r0 == 0) goto L_0x0025
            r1 = r2
        L_0x0025:
            r0 = r3
        L_0x0026:
            int r2 = r6.mInitialPrefetchItemCount
            if (r0 >= r2) goto L_0x0035
            if (r4 < 0) goto L_0x0035
            if (r4 >= r7) goto L_0x0035
            r8.a(r4, r3)
            int r4 = r4 + r1
            int r0 = r0 + 1
            goto L_0x0026
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.collectInitialPrefetchPositions(int, androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry):void");
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = layoutState.c;
        if (i >= 0 && i < state.b()) {
            layoutPrefetchRegistry.a(i, Math.max(0, layoutState.f));
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @SuppressLint({"UnknownNullness"})
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        boolean z = false;
        int i2 = 1;
        if (i < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.mShouldReverseLayout) {
            i2 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i2, 0.0f);
        }
        return new PointF(0.0f, (float) i2);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @SuppressLint({"UnknownNullness"})
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int convertFocusDirectionToLayoutDirection(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 17) {
                    if (i != 33) {
                        if (i != 66) {
                            if (i != 130) {
                                return Integer.MIN_VALUE;
                            }
                            if (this.mOrientation == 1) {
                                return 1;
                            }
                            return Integer.MIN_VALUE;
                        } else if (this.mOrientation == 0) {
                            return 1;
                        } else {
                            return Integer.MIN_VALUE;
                        }
                    } else if (this.mOrientation == 1) {
                        return -1;
                    } else {
                        return Integer.MIN_VALUE;
                    }
                } else if (this.mOrientation == 0) {
                    return -1;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else if (this.mOrientation != 1 && isLayoutRTL()) {
                return -1;
            } else {
                return 1;
            }
        } else if (this.mOrientation != 1 && isLayoutRTL()) {
            return 1;
        } else {
            return -1;
        }
    }

    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.Recycler recycler, LayoutState layoutState, RecyclerView.State state, boolean z) {
        boolean z2;
        int i = layoutState.b;
        int i2 = layoutState.f;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                layoutState.f = i2 + i;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i3 = layoutState.b + layoutState.g;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if (!layoutState.f2300b && i3 <= 0) {
                break;
            }
            int i4 = layoutState.c;
            if (i4 < 0 || i4 >= state.b()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                break;
            }
            layoutChunkResult.a = 0;
            layoutChunkResult.f2297a = false;
            layoutChunkResult.b = false;
            layoutChunkResult.c = false;
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.f2297a) {
                int i5 = layoutState.a;
                int i6 = layoutChunkResult.a;
                layoutState.a = (layoutState.e * i6) + i5;
                if (!layoutChunkResult.b || layoutState.f2298a != null || !state.f2324b) {
                    layoutState.b -= i6;
                    i3 -= i6;
                }
                int i7 = layoutState.f;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + i6;
                    layoutState.f = i8;
                    int i9 = layoutState.b;
                    if (i9 < 0) {
                        layoutState.f = i8 + i9;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z && layoutChunkResult.c) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.b;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        char c;
        int i3;
        int i4;
        ensureLayoutState();
        if (i2 > i) {
            c = 1;
        } else if (i2 < i) {
            c = 65535;
        } else {
            c = 0;
        }
        if (c == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.e(getChildAt(i)) < this.mOrientationHelper.k()) {
            i4 = 16644;
            i3 = 16388;
        } else {
            i4 = 4161;
            i3 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i, i2, i4, i3);
        }
        return this.mVerticalBoundCheck.a(i, i2, i4, i3);
    }

    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        int i3;
        ensureLayoutState();
        int i4 = 320;
        if (z) {
            i3 = 24579;
        } else {
            i3 = 320;
        }
        if (!z2) {
            i4 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.a(i, i2, i3, i4);
    }

    public View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        ensureLayoutState();
        int childCount = getChildCount();
        if (z2) {
            i3 = getChildCount() - 1;
            i2 = -1;
            i = -1;
        } else {
            i2 = childCount;
            i3 = 0;
            i = 1;
        }
        int b = state.b();
        int k = this.mOrientationHelper.k();
        int g = this.mOrientationHelper.g();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i3 != i2) {
            View childAt = getChildAt(i3);
            int position = getPosition(childAt);
            int e = this.mOrientationHelper.e(childAt);
            int b2 = this.mOrientationHelper.b(childAt);
            if (position >= 0 && position < b) {
                if (!((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (b2 > k || e >= k) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (e < g || b2 <= g) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (!z3 && !z4) {
                        return childAt;
                    }
                    if (z) {
                        if (!z4) {
                            if (view != null) {
                            }
                            view = childAt;
                        }
                    } else if (!z3) {
                        if (view != null) {
                        }
                        view = childAt;
                    }
                    view2 = childAt;
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            i3 += i;
        }
        if (view != null) {
            return view;
        }
        if (view2 != null) {
            return view2;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @SuppressLint({"UnknownNullness"})
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.State state) {
        boolean z;
        if (state.a != -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.mOrientationHelper.l();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        boolean z2;
        View b = layoutState.b(recycler);
        if (b == null) {
            layoutChunkResult.f2297a = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) b.getLayoutParams();
        if (layoutState.f2298a == null) {
            boolean z3 = this.mShouldReverseLayout;
            if (layoutState.e == -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3 == z2) {
                addView(b);
            } else {
                addView(b, 0);
            }
        } else {
            boolean z4 = this.mShouldReverseLayout;
            if (layoutState.e == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z4 == z) {
                addDisappearingView(b);
            } else {
                addDisappearingView(b, 0);
            }
        }
        measureChildWithMargins(b, 0, 0);
        layoutChunkResult.a = this.mOrientationHelper.c(b);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                i5 = getWidth() - getPaddingRight();
                i4 = i5 - this.mOrientationHelper.d(b);
            } else {
                i4 = getPaddingLeft();
                i5 = this.mOrientationHelper.d(b) + i4;
            }
            if (layoutState.e == -1) {
                int i6 = layoutState.a;
                i = i6;
                i2 = i5;
                i3 = i6 - layoutChunkResult.a;
            } else {
                int i7 = layoutState.a;
                i3 = i7;
                i2 = i5;
                i = layoutChunkResult.a + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int d = this.mOrientationHelper.d(b) + paddingTop;
            if (layoutState.e == -1) {
                int i8 = layoutState.a;
                i2 = i8;
                i3 = paddingTop;
                i = d;
                i4 = i8 - layoutChunkResult.a;
            } else {
                int i9 = layoutState.a;
                i3 = paddingTop;
                i2 = layoutChunkResult.a + i9;
                i = d;
                i4 = i9;
            }
        }
        layoutDecoratedWithMargins(b, i4, i3, i2, i);
        if (layoutParams.c() || layoutParams.b()) {
            layoutChunkResult.b = true;
        }
        layoutChunkResult.c = b.hasFocusable();
    }

    @SuppressLint({"UnknownNullness"})
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.f2317a.clear();
            recycler.h();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int convertFocusDirectionToLayoutDirection;
        View view2;
        View view3;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (((float) this.mOrientationHelper.l()) * MAX_SCROLL_FACTOR), false, state);
        LayoutState layoutState = this.mLayoutState;
        layoutState.f = Integer.MIN_VALUE;
        layoutState.f2299a = false;
        fill(recycler, layoutState, state, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            view2 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            view3 = getChildClosestToStart();
        } else {
            view3 = getChildClosestToEnd();
        }
        if (!view3.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return view3;
    }

    @SuppressLint({"UnknownNullness"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View findViewByPosition;
        int i8;
        int i9;
        boolean z;
        int i10 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.b() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            int i11 = savedState.c;
            if (i11 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.mPendingScrollPosition = i11;
            }
        }
        ensureLayoutState();
        this.mLayoutState.f2299a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        if (!anchorInfo.f2296b || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            anchorInfo.d();
            AnchorInfo anchorInfo2 = this.mAnchorInfo;
            anchorInfo2.f2295a = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recycler, state, anchorInfo2);
            this.mAnchorInfo.f2296b = true;
        } else if (focusedChild != null && (this.mOrientationHelper.e(focusedChild) >= this.mOrientationHelper.g() || this.mOrientationHelper.b(focusedChild) <= this.mOrientationHelper.k())) {
            this.mAnchorInfo.c(getPosition(focusedChild), focusedChild);
        }
        LayoutState layoutState = this.mLayoutState;
        if (layoutState.i >= 0) {
            i = 1;
        } else {
            i = -1;
        }
        layoutState.e = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(state, iArr);
        int k = this.mOrientationHelper.k() + Math.max(0, this.mReusableIntPair[0]);
        int h = this.mOrientationHelper.h() + Math.max(0, this.mReusableIntPair[1]);
        if (!(!state.f2324b || (i7 = this.mPendingScrollPosition) == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE || (findViewByPosition = findViewByPosition(i7)) == null)) {
            if (this.mShouldReverseLayout) {
                i8 = this.mOrientationHelper.g() - this.mOrientationHelper.b(findViewByPosition);
                i9 = this.mPendingScrollPositionOffset;
            } else {
                i9 = this.mOrientationHelper.e(findViewByPosition) - this.mOrientationHelper.k();
                i8 = this.mPendingScrollPositionOffset;
            }
            int i12 = i8 - i9;
            if (i12 > 0) {
                k += i12;
            } else {
                h -= i12;
            }
        }
        AnchorInfo anchorInfo3 = this.mAnchorInfo;
        if (!anchorInfo3.f2295a ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i10 = 1;
        }
        onAnchorReady(recycler, state, anchorInfo3, i10);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.f2300b = resolveIsInfinite();
        this.mLayoutState.getClass();
        this.mLayoutState.h = 0;
        AnchorInfo anchorInfo4 = this.mAnchorInfo;
        if (anchorInfo4.f2295a) {
            updateLayoutStateToFillStart(anchorInfo4);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.g = k;
            fill(recycler, layoutState2, state, false);
            LayoutState layoutState3 = this.mLayoutState;
            i3 = layoutState3.a;
            int i13 = layoutState3.c;
            int i14 = layoutState3.b;
            if (i14 > 0) {
                h += i14;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LayoutState layoutState4 = this.mLayoutState;
            layoutState4.g = h;
            layoutState4.c += layoutState4.d;
            fill(recycler, layoutState4, state, false);
            LayoutState layoutState5 = this.mLayoutState;
            i2 = layoutState5.a;
            int i15 = layoutState5.b;
            if (i15 > 0) {
                updateLayoutStateToFillStart(i13, i3);
                LayoutState layoutState6 = this.mLayoutState;
                layoutState6.g = i15;
                fill(recycler, layoutState6, state, false);
                i3 = this.mLayoutState.a;
            }
        } else {
            updateLayoutStateToFillEnd(anchorInfo4);
            LayoutState layoutState7 = this.mLayoutState;
            layoutState7.g = h;
            fill(recycler, layoutState7, state, false);
            LayoutState layoutState8 = this.mLayoutState;
            int i16 = layoutState8.a;
            int i17 = layoutState8.c;
            int i18 = layoutState8.b;
            if (i18 > 0) {
                k += i18;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LayoutState layoutState9 = this.mLayoutState;
            layoutState9.g = k;
            layoutState9.c += layoutState9.d;
            fill(recycler, layoutState9, state, false);
            LayoutState layoutState10 = this.mLayoutState;
            int i19 = layoutState10.a;
            int i20 = layoutState10.b;
            if (i20 > 0) {
                updateLayoutStateToFillEnd(i17, i16);
                LayoutState layoutState11 = this.mLayoutState;
                layoutState11.g = i20;
                fill(recycler, layoutState11, state, false);
                i2 = this.mLayoutState.a;
            } else {
                i2 = i16;
            }
            i3 = i19;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap = fixLayoutEndGap(i2, recycler, state, true);
                i5 = i3 + fixLayoutEndGap;
                i4 = i2 + fixLayoutEndGap;
                i6 = fixLayoutStartGap(i5, recycler, state, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i3, recycler, state, true);
                i5 = i3 + fixLayoutStartGap;
                i4 = i2 + fixLayoutStartGap;
                i6 = fixLayoutEndGap(i4, recycler, state, false);
            }
            i3 = i5 + i6;
            i2 = i4 + i6;
        }
        layoutForPredictiveAnimations(recycler, state, i3, i2);
        if (!state.f2324b) {
            OrientationHelper orientationHelper = this.mOrientationHelper;
            orientationHelper.a = orientationHelper.l();
        } else {
            this.mAnchorInfo.d();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @SuppressLint({"UnknownNullness"})
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.d();
    }

    @SuppressLint({"UnknownNullness"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mPendingSavedState = savedState;
            if (this.mPendingScrollPosition != -1) {
                savedState.c = -1;
            }
            requestLayout();
        }
    }

    @SuppressLint({"UnknownNullness"})
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.a = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.d = this.mOrientationHelper.g() - this.mOrientationHelper.b(childClosestToEnd);
                savedState2.c = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.c = getPosition(childClosestToStart);
                savedState2.d = this.mOrientationHelper.e(childClosestToStart) - this.mOrientationHelper.k();
            }
        } else {
            savedState2.c = -1;
        }
        return savedState2;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        boolean z;
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        if (position < position2) {
            z = true;
        } else {
            z = true;
        }
        if (this.mShouldReverseLayout) {
            if (z) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.g() - (this.mOrientationHelper.c(view) + this.mOrientationHelper.e(view2)));
                return;
            }
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g() - this.mOrientationHelper.b(view2));
        } else if (z) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.e(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.b(view2) - this.mOrientationHelper.c(view));
        }
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.i() == 0 && this.mOrientationHelper.f() == 0) {
            return true;
        }
        return false;
    }

    public int scrollBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f2299a = true;
        if (i > 0) {
            i2 = 1;
        } else {
            i2 = -1;
        }
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, state);
        LayoutState layoutState = this.mLayoutState;
        int fill = fill(recycler, layoutState, state, false) + layoutState.f;
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.o(-i);
        this.mLayoutState.i = i;
        return i;
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.c = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.c = -1;
        }
        requestLayout();
    }

    @SuppressLint({"UnknownNullness"})
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll((String) null);
            if (i != this.mOrientation || this.mOrientationHelper == null) {
                OrientationHelper a = OrientationHelper.a(this, i);
                this.mOrientationHelper = a;
                this.mAnchorInfo.f2294a = a;
                this.mOrientation = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException(lf.h("invalid orientation:", i));
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll((String) null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public boolean shouldMeasureTwice() {
        if (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) {
            return false;
        }
        return true;
    }

    @SuppressLint({"UnknownNullness"})
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd) {
            return true;
        }
        return false;
    }

    public void validateChildOrder() {
        getChildCount();
        boolean z = true;
        if (getChildCount() >= 1) {
            int position = getPosition(getChildAt(0));
            int e = this.mOrientationHelper.e(getChildAt(0));
            if (this.mShouldReverseLayout) {
                int i = 1;
                while (i < getChildCount()) {
                    View childAt = getChildAt(i);
                    int position2 = getPosition(childAt);
                    int e2 = this.mOrientationHelper.e(childAt);
                    if (position2 < position) {
                        logChildren();
                        StringBuilder sb = new StringBuilder("detected invalid position. loc invalid? ");
                        if (e2 >= e) {
                            z = false;
                        }
                        sb.append(z);
                        throw new RuntimeException(sb.toString());
                    } else if (e2 <= e) {
                        i++;
                    } else {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    }
                }
                return;
            }
            int i2 = 1;
            while (i2 < getChildCount()) {
                View childAt2 = getChildAt(i2);
                int position3 = getPosition(childAt2);
                int e3 = this.mOrientationHelper.e(childAt2);
                if (position3 < position) {
                    logChildren();
                    StringBuilder sb2 = new StringBuilder("detected invalid position. loc invalid? ");
                    if (e3 >= e) {
                        z = false;
                    }
                    sb2.append(z);
                    throw new RuntimeException(sb2.toString());
                } else if (e3 >= e) {
                    i2++;
                } else {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
        }
    }

    public LinearLayoutManager(@SuppressLint({"UnknownNullness"}) Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.b = this.mOrientationHelper.g() - i2;
        LayoutState layoutState = this.mLayoutState;
        layoutState.d = this.mShouldReverseLayout ? -1 : 1;
        layoutState.c = i;
        layoutState.e = 1;
        layoutState.a = i2;
        layoutState.f = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.b = i2 - this.mOrientationHelper.k();
        LayoutState layoutState = this.mLayoutState;
        layoutState.c = i;
        layoutState.d = this.mShouldReverseLayout ? 1 : -1;
        layoutState.e = -1;
        layoutState.a = i2;
        layoutState.f = Integer.MIN_VALUE;
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.a);
        setReverseLayout(properties.f2306a);
        setStackFromEnd(properties.f2307b);
    }

    public void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, AnchorInfo anchorInfo, int i) {
    }
}
