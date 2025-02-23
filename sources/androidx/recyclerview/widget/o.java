package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SnapHelper */
public abstract class o extends RecyclerView.OnFlingListener {
    static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    RecyclerView mRecyclerView;
    private final RecyclerView.OnScrollListener mScrollListener = new a();

    /* compiled from: SnapHelper */
    public class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with other field name */
        public boolean f2407a = false;

        public a() {
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f2407a) {
                this.f2407a = false;
                o.this.snapToTargetExistingView();
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f2407a = true;
            }
        }
    }

    /* compiled from: SnapHelper */
    public class b extends LinearSmoothScroller {
        public b(Context context) {
            super(context);
        }

        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return o.MILLISECONDS_PER_INCH / ((float) displayMetrics.densityDpi);
        }

        public final void onTargetFound(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
            o oVar = o.this;
            RecyclerView recyclerView = oVar.mRecyclerView;
            if (recyclerView != null) {
                int[] calculateDistanceToFinalSnap = oVar.calculateDistanceToFinalSnap(recyclerView.getLayoutManager(), view);
                int i = calculateDistanceToFinalSnap[0];
                int i2 = calculateDistanceToFinalSnap[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
                if (calculateTimeForDeceleration > 0) {
                    action.b(i, i2, this.mDecelerateInterpolator, calculateTimeForDeceleration);
                }
            }
        }
    }

    private void destroyCallbacks() {
        this.mRecyclerView.removeOnScrollListener(this.mScrollListener);
        this.mRecyclerView.setOnFlingListener((RecyclerView.OnFlingListener) null);
    }

    private void setupCallbacks() throws IllegalStateException {
        if (this.mRecyclerView.getOnFlingListener() == null) {
            this.mRecyclerView.addOnScrollListener(this.mScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean snapFromFling(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        RecyclerView.SmoothScroller createScroller;
        int findTargetSnapPosition;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.a) || (createScroller = createScroller(layoutManager)) == null || (findTargetSnapPosition = findTargetSnapPosition(layoutManager, i, i2)) == -1) {
            return false;
        }
        createScroller.setTargetPosition(findTargetSnapPosition);
        layoutManager.startSmoothScroll(createScroller);
        return true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                destroyCallbacks();
            }
            this.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                setupCallbacks();
                this.mGravityScroller = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
                snapToTargetExistingView();
            }
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view);

    @SuppressLint({"UnknownNullness"})
    public int[] calculateScrollDistance(int i, int i2) {
        this.mGravityScroller.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.mGravityScroller.getFinalX(), this.mGravityScroller.getFinalY()};
    }

    public RecyclerView.SmoothScroller createScroller(RecyclerView.LayoutManager layoutManager) {
        return createSnapScroller(layoutManager);
    }

    @Deprecated
    public LinearSmoothScroller createSnapScroller(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.a)) {
            return null;
        }
        return new b(this.mRecyclerView.getContext());
    }

    @SuppressLint({"UnknownNullness"})
    public abstract View findSnapView(RecyclerView.LayoutManager layoutManager);

    @SuppressLint({"UnknownNullness"})
    public abstract int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2);

    public boolean onFling(int i, int i2) {
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if ((Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && snapFromFling(layoutManager, i, i2)) {
            return true;
        }
        return false;
    }

    public void snapToTargetExistingView() {
        RecyclerView.LayoutManager layoutManager;
        View findSnapView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (findSnapView = findSnapView(layoutManager)) != null) {
            int[] calculateDistanceToFinalSnap = calculateDistanceToFinalSnap(layoutManager, findSnapView);
            int i = calculateDistanceToFinalSnap[0];
            if (i != 0 || calculateDistanceToFinalSnap[1] != 0) {
                this.mRecyclerView.smoothScrollBy(i, calculateDistanceToFinalSnap[1]);
            }
        }
    }
}
