package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: PagerSnapHelper */
public class l extends o {
    public j a;

    /* renamed from: a  reason: collision with other field name */
    public k f2406a;

    /* compiled from: PagerSnapHelper */
    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / ((float) displayMetrics.densityDpi);
        }

        public final int calculateTimeForScrolling(int i) {
            return Math.min(100, super.calculateTimeForScrolling(i));
        }

        public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            l lVar = l.this;
            int[] calculateDistanceToFinalSnap = lVar.calculateDistanceToFinalSnap(lVar.mRecyclerView.getLayoutManager(), view);
            int i = calculateDistanceToFinalSnap[0];
            int i2 = calculateDistanceToFinalSnap[1];
            int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
            if (calculateTimeForDeceleration > 0) {
                action.b(i, i2, this.mDecelerateInterpolator, calculateTimeForDeceleration);
            }
        }
    }

    public static int a(View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.c(view) / 2) + orientationHelper.e(view)) - ((orientationHelper.l() / 2) + orientationHelper.k());
    }

    public static View b(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int l = (orientationHelper.l() / 2) + orientationHelper.k();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs(((orientationHelper.c(childAt) / 2) + orientationHelper.e(childAt)) - l);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    public final OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
        j jVar = this.a;
        if (jVar == null || jVar.f2302a != layoutManager) {
            this.a = new j(layoutManager);
        }
        return this.a;
    }

    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(view, c(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(view, d(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public final RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.a)) {
            return null;
        }
        return new a(this.mRecyclerView.getContext());
    }

    public final OrientationHelper d(RecyclerView.LayoutManager layoutManager) {
        k kVar = this.f2406a;
        if (kVar == null || kVar.f2302a != layoutManager) {
            this.f2406a = new k(layoutManager);
        }
        return this.f2406a;
    }

    @SuppressLint({"UnknownNullness"})
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return b(layoutManager, d(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return b(layoutManager, c(layoutManager));
        }
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public final int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        OrientationHelper orientationHelper;
        boolean z;
        PointF computeScrollVectorForPosition;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollVertically()) {
            orientationHelper = d(layoutManager);
        } else if (layoutManager.canScrollHorizontally()) {
            orientationHelper = c(layoutManager);
        } else {
            orientationHelper = null;
        }
        if (orientationHelper == null) {
            return -1;
        }
        int childCount = layoutManager.getChildCount();
        boolean z2 = false;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int a2 = a(childAt, orientationHelper);
                if (a2 <= 0 && a2 > i4) {
                    view2 = childAt;
                    i4 = a2;
                }
                if (a2 >= 0 && a2 < i3) {
                    view = childAt;
                    i3 = a2;
                }
            }
        }
        int i6 = 1;
        if (!layoutManager.canScrollHorizontally() ? i2 <= 0 : i <= 0) {
            z = false;
        } else {
            z = true;
        }
        if (z && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!z && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (z) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view);
        int itemCount2 = layoutManager.getItemCount();
        if ((layoutManager instanceof RecyclerView.SmoothScroller.a) && (computeScrollVectorForPosition = ((RecyclerView.SmoothScroller.a) layoutManager).computeScrollVectorForPosition(itemCount2 - 1)) != null && (computeScrollVectorForPosition.x < 0.0f || computeScrollVectorForPosition.y < 0.0f)) {
            z2 = true;
        }
        if (z2 == z) {
            i6 = -1;
        }
        int i7 = position + i6;
        if (i7 < 0 || i7 >= itemCount) {
            return -1;
        }
        return i7;
    }
}
