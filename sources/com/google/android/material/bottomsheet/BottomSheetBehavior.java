package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.activity.BackEventCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.f;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.common.primitives.Ints;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements MaterialBackHandler {
    private static final int CORNER_ANIMATION_DURATION = 500;
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int INVALID_POSITION = -1;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    private static final int VIEW_INDEX_BOTTOM_SHEET = 0;
    WeakReference<View> accessibilityDelegateViewRef;
    int activePointerId;
    private ColorStateList backgroundTint;
    MaterialBottomContainerBackHelper bottomContainerBackHelper;
    private final ArrayList<BottomSheetCallback> callbacks = new ArrayList<>();
    private int childHeight;
    int collapsedOffset;
    private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback() {
        private long viewCapturedMillis;

        private boolean releasedLow(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (top > (bottomSheetBehavior.getExpandedOffset() + bottomSheetBehavior.parentHeight) / 2) {
                return true;
            }
            return false;
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return C1354qp.x(i, BottomSheetBehavior.this.getExpandedOffset(), getViewVerticalDragRange(view));
        }

        public int getViewVerticalDragRange(View view) {
            if (BottomSheetBehavior.this.canBeHiddenByDragging()) {
                return BottomSheetBehavior.this.parentHeight;
            }
            return BottomSheetBehavior.this.collapsedOffset;
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1 && BottomSheetBehavior.this.draggable) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
            if (r9 > r7.this$0.halfExpandedOffset) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0090, code lost:
            if (java.lang.Math.abs(r8.getTop() - r7.this$0.getExpandedOffset()) < java.lang.Math.abs(r8.getTop() - r7.this$0.halfExpandedOffset)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cf, code lost:
            if (r7.this$0.shouldSkipHalfExpandedStateWhenDragging() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f1, code lost:
            if (java.lang.Math.abs(r9 - r7.this$0.fitToContentsOffset) < java.lang.Math.abs(r9 - r7.this$0.collapsedOffset)) goto L_0x0010;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x010d, code lost:
            if (r7.this$0.shouldSkipHalfExpandedStateWhenDragging() != false) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0127, code lost:
            if (r7.this$0.shouldSkipHalfExpandedStateWhenDragging() == false) goto L_0x012a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0034, code lost:
            if (r10.shouldExpandOnUpwardDrag(r0, (((float) r9) * 100.0f) / ((float) r10.parentHeight)) != false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onViewReleased(android.view.View r8, float r9, float r10) {
            /*
                r7 = this;
                r0 = 0
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                r2 = 6
                r3 = 3
                r4 = 4
                if (r1 >= 0) goto L_0x003f
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x0013
            L_0x0010:
                r2 = r3
                goto L_0x012a
            L_0x0013:
                int r9 = r8.getTop()
                long r0 = java.lang.System.currentTimeMillis()
                long r5 = r7.viewCapturedMillis
                long r0 = r0 - r5
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.shouldSkipHalfExpandedStateWhenDragging()
                if (r10 == 0) goto L_0x0037
                float r9 = (float) r9
                r10 = 1120403456(0x42c80000, float:100.0)
                float r9 = r9 * r10
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r2 = r10.parentHeight
                float r2 = (float) r2
                float r9 = r9 / r2
                boolean r9 = r10.shouldExpandOnUpwardDrag(r0, r9)
                if (r9 == 0) goto L_0x00ad
                goto L_0x0010
            L_0x0037:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                if (r9 <= r10) goto L_0x0010
                goto L_0x012a
            L_0x003f:
                com.google.android.material.bottomsheet.BottomSheetBehavior r1 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r5 = r1.hideable
                if (r5 == 0) goto L_0x0094
                boolean r1 = r1.shouldHide(r8, r10)
                if (r1 == 0) goto L_0x0094
                float r9 = java.lang.Math.abs(r9)
                float r0 = java.lang.Math.abs(r10)
                int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
                if (r9 >= 0) goto L_0x0062
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r9 = r9.significantVelocityThreshold
                float r9 = (float) r9
                int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
                if (r9 > 0) goto L_0x0068
            L_0x0062:
                boolean r9 = r7.releasedLow(r8)
                if (r9 == 0) goto L_0x006b
            L_0x0068:
                r2 = 5
                goto L_0x012a
            L_0x006b:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x0074
                goto L_0x0010
            L_0x0074:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.getExpandedOffset()
                int r9 = r9 - r10
                int r9 = java.lang.Math.abs(r9)
                int r10 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.halfExpandedOffset
                int r10 = r10 - r0
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x012a
                goto L_0x0010
            L_0x0094:
                int r0 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r0 == 0) goto L_0x00d2
                float r9 = java.lang.Math.abs(r9)
                float r10 = java.lang.Math.abs(r10)
                int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
                if (r9 <= 0) goto L_0x00a5
                goto L_0x00d2
            L_0x00a5:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.fitToContents
                if (r9 == 0) goto L_0x00b0
            L_0x00ad:
                r2 = r4
                goto L_0x012a
            L_0x00b0:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.halfExpandedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ad
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x012a
                goto L_0x00ad
            L_0x00d2:
                int r9 = r8.getTop()
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r10.fitToContents
                if (r10 == 0) goto L_0x00f5
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r10 = r10.fitToContentsOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ad
                goto L_0x0010
            L_0x00f5:
                com.google.android.material.bottomsheet.BottomSheetBehavior r10 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r10.halfExpandedOffset
                if (r9 >= r0) goto L_0x0110
                int r10 = r10.collapsedOffset
                int r10 = r9 - r10
                int r10 = java.lang.Math.abs(r10)
                if (r9 >= r10) goto L_0x0107
                goto L_0x0010
            L_0x0107:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x012a
                goto L_0x00ad
            L_0x0110:
                int r10 = r9 - r0
                int r10 = java.lang.Math.abs(r10)
                com.google.android.material.bottomsheet.BottomSheetBehavior r0 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                int r0 = r0.collapsedOffset
                int r9 = r9 - r0
                int r9 = java.lang.Math.abs(r9)
                if (r10 >= r9) goto L_0x00ad
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r9 = r9.shouldSkipHalfExpandedStateWhenDragging()
                if (r9 == 0) goto L_0x012a
                goto L_0x00ad
            L_0x012a:
                com.google.android.material.bottomsheet.BottomSheetBehavior r9 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                boolean r10 = r9.shouldSkipSmoothAnimation()
                r9.startSettling(r8, r2, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.onViewReleased(android.view.View, float, float):void");
        }

        public boolean tryCaptureView(View view, int i) {
            View view2;
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.state;
            if (i2 == 1 || bottomSheetBehavior.touchingScrollingChild) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.activePointerId == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.nestedScrollingChildRef;
                if (weakReference != null) {
                    view2 = weakReference.get();
                } else {
                    view2 = null;
                }
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.viewCapturedMillis = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.viewRef;
            if (weakReference2 == null || weakReference2.get() != view) {
                return false;
            }
            return true;
        }
    };
    /* access modifiers changed from: private */
    public boolean draggable = true;
    float elevation = -1.0f;
    final SparseIntArray expandHalfwayActionIds = new SparseIntArray();
    private boolean expandedCornersRemoved;
    int expandedOffset;
    /* access modifiers changed from: private */
    public boolean fitToContents = true;
    int fitToContentsOffset;
    /* access modifiers changed from: private */
    public int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio = HIDE_THRESHOLD;
    private float hideFriction = HIDE_FRICTION;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY = -1;
    /* access modifiers changed from: private */
    public int insetBottom;
    /* access modifiers changed from: private */
    public int insetTop;
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState = 4;
    /* access modifiers changed from: private */
    public boolean marginLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginRightSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean marginTopSystemWindowInsets;
    /* access modifiers changed from: private */
    public MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight = -1;
    private int maxWidth = -1;
    private float maximumVelocity;
    private boolean nestedScrolled;
    WeakReference<View> nestedScrollingChildRef;
    /* access modifiers changed from: private */
    public boolean paddingBottomSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingLeftSystemWindowInsets;
    /* access modifiers changed from: private */
    public boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    /* access modifiers changed from: private */
    public int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags = 0;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private boolean shouldRemoveExpandedCorners;
    /* access modifiers changed from: private */
    public int significantVelocityThreshold;
    /* access modifiers changed from: private */
    public boolean skipCollapsed;
    int state = 4;
    private final BottomSheetBehavior<V>.StateSettlingTracker stateSettlingTracker = new StateSettlingTracker();
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings = false;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SaveFlags {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            boolean z = false;
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1 ? true : z;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = bottomSheetBehavior.peekHeight;
            this.fitToContents = bottomSheetBehavior.fitToContents;
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = bottomSheetBehavior.skipCollapsed;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        /* access modifiers changed from: private */
        public boolean isContinueSettlingRunnablePosted;
        /* access modifiers changed from: private */
        public int targetState;

        private StateSettlingTracker() {
            this.continueSettlingRunnable = new Runnable() {
                public void run() {
                    boolean unused = StateSettlingTracker.this.isContinueSettlingRunnablePosted = false;
                    ViewDragHelper viewDragHelper = BottomSheetBehavior.this.viewDragHelper;
                    if (viewDragHelper == null || !viewDragHelper.h()) {
                        StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                        if (bottomSheetBehavior.state == 2) {
                            bottomSheetBehavior.setStateInternal(stateSettlingTracker.targetState);
                            return;
                        }
                        return;
                    }
                    StateSettlingTracker stateSettlingTracker2 = StateSettlingTracker.this;
                    stateSettlingTracker2.continueSettlingToState(stateSettlingTracker2.targetState);
                }
            };
        }

        public void continueSettlingToState(int i) {
            WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
            if (weakReference != null && weakReference.get() != null) {
                this.targetState = i;
                if (!this.isContinueSettlingRunnablePosted) {
                    Runnable runnable = this.continueSettlingRunnable;
                    WeakHashMap<View, GC> weakHashMap = f.f1839a;
                    ((View) BottomSheetBehavior.this.viewRef.get()).postOnAnimation(runnable);
                    this.isContinueSettlingRunnablePosted = true;
                }
            }
        }
    }

    public BottomSheetBehavior() {
    }

    private int addAccessibilityActionForState(View view, int i, int i2) {
        int i3;
        boolean z;
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        String string = view.getResources().getString(i);
        AccessibilityViewCommand createAccessibilityViewCommandForState = createAccessibilityViewCommandForState(i2);
        ArrayList f = f.f(view);
        int i4 = 0;
        while (true) {
            if (i4 >= f.size()) {
                int i5 = -1;
                for (int i6 = 0; i6 < 32 && i5 == -1; i6++) {
                    int i7 = f.f1841a[i6];
                    boolean z2 = true;
                    for (int i8 = 0; i8 < f.size(); i8++) {
                        if (((AccessibilityNodeInfoCompat.AccessibilityActionCompat) f.get(i8)).a() != i7) {
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        i5 = i7;
                    }
                }
                i3 = i5;
            } else if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) f.get(i4)).f1836a).getLabel())) {
                i3 = ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) f.get(i4)).a();
                break;
            } else {
                i4++;
            }
        }
        if (i3 != -1) {
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat((Object) null, i3, string, createAccessibilityViewCommandForState, (Class) null);
            View.AccessibilityDelegate d = f.d(view);
            if (d == null) {
                accessibilityDelegateCompat = null;
            } else if (d instanceof AccessibilityDelegateCompat.a) {
                accessibilityDelegateCompat = ((AccessibilityDelegateCompat.a) d).a;
            } else {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat(d);
            }
            if (accessibilityDelegateCompat == null) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            }
            f.o(view, accessibilityDelegateCompat);
            f.l(accessibilityActionCompat.a(), view);
            f.f(view).add(accessibilityActionCompat);
            f.i(0, view);
        }
        return i3;
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private float calculateCornerInterpolation(float f, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float e = (float) roundedCorner.getRadius();
            if (e > 0.0f && f > 0.0f) {
                return e / f;
            }
        }
        return 0.0f;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) ((1.0f - this.halfExpandedRatio) * ((float) this.parentHeight));
    }

    private float calculateInterpolationWithCornersRemoved() {
        WeakReference<V> weakReference;
        WindowInsets rootWindowInsets;
        if (this.materialShapeDrawable == null || (weakReference = this.viewRef) == null || weakReference.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        View view = (View) this.viewRef.get();
        if (!isAtTopOfScreen() || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(calculateCornerInterpolation(this.materialShapeDrawable.getTopLeftCornerResolvedSize(), rootWindowInsets.getRoundedCorner(0)), calculateCornerInterpolation(this.materialShapeDrawable.getTopRightCornerResolvedSize(), rootWindowInsets.getRoundedCorner(1)));
    }

    private int calculatePeekHeight() {
        int i;
        if (this.peekHeightAuto) {
            return Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom;
        }
        if (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || (i = this.gestureInsetBottom) <= 0) {
            return this.peekHeight + this.insetBottom;
        }
        return Math.max(this.peekHeight, i + this.peekHeightGestureInsetBuffer);
    }

    private float calculateSlideOffsetWithTop(int i) {
        float f;
        float f2;
        int i2 = this.collapsedOffset;
        if (i > i2 || i2 == getExpandedOffset()) {
            int i3 = this.collapsedOffset;
            f = (float) (i3 - i);
            f2 = (float) (this.parentHeight - i3);
        } else {
            int i4 = this.collapsedOffset;
            f = (float) (i4 - i);
            f2 = (float) (i4 - getExpandedOffset());
        }
        return f / f2;
    }

    /* access modifiers changed from: private */
    public boolean canBeHiddenByDragging() {
        if (!isHideable() || !isHideableWhenDragging()) {
            return false;
        }
        return true;
    }

    private void clearAccessibilityAction(View view, int i) {
        if (view != null) {
            f.l(524288, view);
            f.i(0, view);
            f.l(262144, view);
            f.i(0, view);
            f.l(1048576, view);
            f.i(0, view);
            int i2 = this.expandHalfwayActionIds.get(i, -1);
            if (i2 != -1) {
                f.l(i2, view);
                f.i(0, view);
                this.expandHalfwayActionIds.delete(i);
            }
        }
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(final int i) {
        return new AccessibilityViewCommand() {
            public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
                BottomSheetBehavior.this.setState(i);
                return true;
            }
        };
    }

    private void createMaterialShapeDrawableIfNeeded(Context context) {
        if (this.shapeAppearanceModelDefault != null) {
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
            this.materialShapeDrawable = materialShapeDrawable2;
            materialShapeDrawable2.initializeElevationOverlay(context);
            ColorStateList colorStateList = this.backgroundTint;
            if (colorStateList != null) {
                this.materialShapeDrawable.setFillColor(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.materialShapeDrawable.setTint(typedValue.data);
        }
    }

    private void createShapeValueAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{calculateInterpolationWithCornersRemoved(), 1.0f});
        this.interpolatorAnimator = ofFloat;
        ofFloat.setDuration(500);
        this.interpolatorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (BottomSheetBehavior.this.materialShapeDrawable != null) {
                    BottomSheetBehavior.this.materialShapeDrawable.setInterpolation(floatValue);
                }
            }
        });
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).f1713a;
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int getChildMeasureSpec(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), Ints.MAX_POWER_OF_TWO);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    private int getTopOffsetForState(int i) {
        if (i == 3) {
            return getExpandedOffset();
        }
        if (i == 4) {
            return this.collapsedOffset;
        }
        if (i == 5) {
            return this.parentHeight;
        }
        if (i == 6) {
            return this.halfExpandedOffset;
        }
        throw new IllegalArgumentException(lf.h("Invalid state to get top offset: ", i));
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 == null) {
            return 0.0f;
        }
        velocityTracker2.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean isAtTopOfScreen() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        ((View) this.viewRef.get()).getLocationOnScreen(iArr);
        if (iArr[1] == 0) {
            return true;
        }
        return false;
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        if (this.state != 3 || (!this.shouldRemoveExpandedCorners && !isAtTopOfScreen())) {
            return false;
        }
        return true;
    }

    private boolean isLayouting(V v) {
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            if (v.isAttachedToWindow()) {
                return true;
            }
        }
        return false;
    }

    private void replaceAccessibilityActionForState(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i) {
        f.m(view, accessibilityActionCompat, (String) null, createAccessibilityViewCommandForState(i));
    }

    private void reset() {
        this.activePointerId = -1;
        this.initialY = -1;
        VelocityTracker velocityTracker2 = this.velocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        int i = this.saveFlags;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.peekHeight = savedState.peekHeight;
            }
            if (i == -1 || (i & 2) == 2) {
                this.fitToContents = savedState.fitToContents;
            }
            if (i == -1 || (i & 4) == 4) {
                this.hideable = savedState.hideable;
            }
            if (i == -1 || (i & 8) == 8) {
                this.skipCollapsed = savedState.skipCollapsed;
            }
        }
    }

    private void runAfterLayout(V v, Runnable runnable) {
        if (isLayouting(v)) {
            v.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setWindowInsetsListener(View view) {
        final boolean z;
        if (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) {
            z = false;
        } else {
            z = true;
        }
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z) {
            ViewUtils.doOnApplyWindowInsets(view, new ViewUtils.OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
                    boolean z;
                    int i;
                    int i2;
                    int i3;
                    bg a = windowInsetsCompat.a(7);
                    bg a2 = windowInsetsCompat.a(32);
                    int unused = BottomSheetBehavior.this.insetTop = a.b;
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingLeft = view.getPaddingLeft();
                    int paddingRight = view.getPaddingRight();
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets) {
                        int unused2 = BottomSheetBehavior.this.insetBottom = windowInsetsCompat.b();
                        paddingBottom = relativePadding.bottom + BottomSheetBehavior.this.insetBottom;
                    }
                    boolean access$600 = BottomSheetBehavior.this.paddingLeftSystemWindowInsets;
                    int i4 = a.f2741a;
                    if (access$600) {
                        if (isLayoutRtl) {
                            i3 = relativePadding.end;
                        } else {
                            i3 = relativePadding.start;
                        }
                        paddingLeft = i3 + i4;
                    }
                    boolean access$700 = BottomSheetBehavior.this.paddingRightSystemWindowInsets;
                    int i5 = a.c;
                    if (access$700) {
                        if (isLayoutRtl) {
                            i2 = relativePadding.start;
                        } else {
                            i2 = relativePadding.end;
                        }
                        paddingRight = i2 + i5;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    boolean z2 = true;
                    if (!BottomSheetBehavior.this.marginLeftSystemWindowInsets || marginLayoutParams.leftMargin == i4) {
                        z = false;
                    } else {
                        marginLayoutParams.leftMargin = i4;
                        z = true;
                    }
                    if (BottomSheetBehavior.this.marginRightSystemWindowInsets && marginLayoutParams.rightMargin != i5) {
                        marginLayoutParams.rightMargin = i5;
                        z = true;
                    }
                    if (!BottomSheetBehavior.this.marginTopSystemWindowInsets || marginLayoutParams.topMargin == (i = a.b)) {
                        z2 = z;
                    } else {
                        marginLayoutParams.topMargin = i;
                    }
                    if (z2) {
                        view.setLayoutParams(marginLayoutParams);
                    }
                    view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
                    if (z) {
                        int unused3 = BottomSheetBehavior.this.gestureInsetBottom = a2.d;
                    }
                    if (BottomSheetBehavior.this.paddingBottomSystemWindowInsets || z) {
                        BottomSheetBehavior.this.updatePeekHeight(false);
                    }
                    return windowInsetsCompat;
                }
            });
        }
    }

    private boolean shouldHandleDraggingWithHelper() {
        if (this.viewDragHelper == null || (!this.draggable && this.state != 1)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void startSettling(View view, int i, boolean z) {
        boolean z2;
        int topOffsetForState = getTopOffsetForState(i);
        ViewDragHelper viewDragHelper2 = this.viewDragHelper;
        if (viewDragHelper2 == null || (!z ? !viewDragHelper2.u(view, view.getLeft(), topOffsetForState) : !viewDragHelper2.s(view.getLeft(), topOffsetForState))) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            setStateInternal(2);
            updateDrawableForTargetState(i, true);
            this.stateSettlingTracker.continueSettlingToState(i);
            return;
        }
        setStateInternal(i);
    }

    private void updateAccessibilityActions() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            updateAccessibilityActions((View) weakReference.get(), 0);
        }
        WeakReference<View> weakReference2 = this.accessibilityDelegateViewRef;
        if (weakReference2 != null) {
            updateAccessibilityActions(weakReference2.get(), 1);
        }
    }

    private void updateDrawableForTargetState(int i, boolean z) {
        boolean isExpandedAndShouldRemoveCorners;
        ValueAnimator valueAnimator;
        if (i != 2 && this.expandedCornersRemoved != (isExpandedAndShouldRemoveCorners = isExpandedAndShouldRemoveCorners()) && this.materialShapeDrawable != null) {
            this.expandedCornersRemoved = isExpandedAndShouldRemoveCorners;
            float f = 1.0f;
            if (!z || (valueAnimator = this.interpolatorAnimator) == null) {
                ValueAnimator valueAnimator2 = this.interpolatorAnimator;
                if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                    this.interpolatorAnimator.cancel();
                }
                MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
                if (this.expandedCornersRemoved) {
                    f = calculateInterpolationWithCornersRemoved();
                }
                materialShapeDrawable2.setInterpolation(f);
            } else if (valueAnimator.isRunning()) {
                this.interpolatorAnimator.reverse();
            } else {
                float interpolation = this.materialShapeDrawable.getInterpolation();
                if (isExpandedAndShouldRemoveCorners) {
                    f = calculateInterpolationWithCornersRemoved();
                }
                this.interpolatorAnimator.setFloatValues(new float[]{interpolation, f});
                this.interpolatorAnimator.start();
            }
        }
    }

    private void updateImportantForAccessibility(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference != null) {
            ViewParent parent = ((View) weakReference.get()).getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z) {
                    if (this.importantForAccessibilityMap == null) {
                        this.importantForAccessibilityMap = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    V childAt = coordinatorLayout.getChildAt(i);
                    if (childAt != this.viewRef.get()) {
                        if (z) {
                            this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            if (this.updateImportantForAccessibilityOnSiblings) {
                                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                                childAt.setImportantForAccessibility(4);
                            }
                        } else if (this.updateImportantForAccessibilityOnSiblings && (map = this.importantForAccessibilityMap) != null && map.containsKey(childAt)) {
                            int intValue = this.importantForAccessibilityMap.get(childAt).intValue();
                            WeakHashMap<View, GC> weakHashMap2 = f.f1839a;
                            childAt.setImportantForAccessibility(intValue);
                        }
                    }
                }
                if (!z) {
                    this.importantForAccessibilityMap = null;
                } else if (this.updateImportantForAccessibilityOnSiblings) {
                    ((View) this.viewRef.get()).sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void updatePeekHeight(boolean z) {
        View view;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state == 4 && (view = (View) this.viewRef.get()) != null) {
                if (z) {
                    setState(4);
                } else {
                    view.requestLayout();
                }
            }
        }
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (!this.callbacks.contains(bottomSheetCallback)) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public float calculateSlideOffset() {
        WeakReference<V> weakReference = this.viewRef;
        if (weakReference == null || weakReference.get() == null) {
            return -1.0f;
        }
        return calculateSlideOffsetWithTop(((View) this.viewRef.get()).getTop());
    }

    public void cancelBackProgress() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.cancelBackProgress();
        }
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    public void dispatchOnSlide(int i) {
        View view = (View) this.viewRef.get();
        if (view != null && !this.callbacks.isEmpty()) {
            float calculateSlideOffsetWithTop = calculateSlideOffsetWithTop(i);
            for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
                this.callbacks.get(i2).onSlide(view, calculateSlideOffsetWithTop);
            }
        }
    }

    public View findScrollingChild(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if (f.d.p(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    public MaterialBottomContainerBackHelper getBackHelper() {
        return this.bottomContainerBackHelper;
    }

    public int getExpandedOffset() {
        int i;
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        int i2 = this.expandedOffset;
        if (this.paddingTopSystemWindowInsets) {
            i = 0;
        } else {
            i = this.insetTop;
        }
        return Math.max(i2, i);
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public int getSignificantVelocityThreshold() {
        return this.significantVelocityThreshold;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    public void handleBackInvoked() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            BackEventCompat onHandleBackInvoked = materialBottomContainerBackHelper.onHandleBackInvoked();
            int i = 4;
            if (onHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
                if (this.hideable) {
                    i = 5;
                }
                setState(i);
            } else if (this.hideable) {
                this.bottomContainerBackHelper.finishBackProgressNotPersistent(onHandleBackInvoked, new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        BottomSheetBehavior.this.setStateInternal(5);
                        WeakReference<V> weakReference = BottomSheetBehavior.this.viewRef;
                        if (weakReference != null && weakReference.get() != null) {
                            ((View) BottomSheetBehavior.this.viewRef.get()).requestLayout();
                        }
                    }
                });
            } else {
                this.bottomContainerBackHelper.finishBackProgressPersistent(onHandleBackInvoked, (Animator.AnimatorListener) null);
                setState(4);
            }
        }
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean isHideableWhenDragging() {
        return true;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public boolean isShouldRemoveExpandedCorners() {
        return this.shouldRemoveExpandedCorners;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int i;
        ViewDragHelper viewDragHelper2;
        boolean z;
        View view;
        if (!v.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        View view2 = null;
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.initialY = (int) motionEvent.getY();
            if (this.state != 2) {
                WeakReference<View> weakReference = this.nestedScrollingChildRef;
                if (weakReference != null) {
                    view = weakReference.get();
                } else {
                    view = null;
                }
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.initialY)) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.touchingScrollingChild = true;
                }
            }
            if (this.activePointerId != -1 || coordinatorLayout.isPointInChildBounds(v, x, this.initialY)) {
                z = false;
            } else {
                z = true;
            }
            this.ignoreEvents = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.touchingScrollingChild = false;
            this.activePointerId = -1;
            if (this.ignoreEvents) {
                this.ignoreEvents = false;
                return false;
            }
        }
        if (!this.ignoreEvents && (viewDragHelper2 = this.viewDragHelper) != null && viewDragHelper2.t(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.nestedScrollingChildRef;
        if (weakReference2 != null) {
            view2 = weakReference2.get();
        }
        if (actionMasked != 2 || view2 == null || this.ignoreEvents || this.state == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.viewDragHelper == null || (i = this.initialY) == -1 || Math.abs(((float) i) - motionEvent.getY()) <= ((float) this.viewDragHelper.f1886b)) {
            return false;
        }
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v);
            InsetsAnimationCallback insetsAnimationCallback = new InsetsAnimationCallback(v);
            if (Build.VERSION.SDK_INT >= 30) {
                v.setWindowInsetsAnimationCallback(new WindowInsetsAnimationCompat.c.a(insetsAnimationCallback));
            } else {
                PathInterpolator pathInterpolator = WindowInsetsAnimationCompat.b.f1803a;
                Object tag = v.getTag(Jr.tag_on_apply_window_listener);
                WindowInsetsAnimationCompat.b.a aVar = new WindowInsetsAnimationCompat.b.a(v, insetsAnimationCallback);
                v.setTag(Jr.tag_window_insets_animation_callback, aVar);
                if (tag == null) {
                    v.setOnApplyWindowInsetsListener(aVar);
                }
            }
            this.viewRef = new WeakReference<>(v);
            this.bottomContainerBackHelper = new MaterialBottomContainerBackHelper(v);
            MaterialShapeDrawable materialShapeDrawable2 = this.materialShapeDrawable;
            if (materialShapeDrawable2 != null) {
                v.setBackground(materialShapeDrawable2);
                MaterialShapeDrawable materialShapeDrawable3 = this.materialShapeDrawable;
                float f = this.elevation;
                if (f == -1.0f) {
                    f = f.d.i(v);
                }
                materialShapeDrawable3.setElevation(f);
            } else {
                ColorStateList colorStateList = this.backgroundTint;
                if (colorStateList != null) {
                    f.d.q(v, colorStateList);
                }
            }
            updateAccessibilityActions();
            if (v.getImportantForAccessibility() == 0) {
                v.setImportantForAccessibility(1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.childHeight = height;
        int i2 = this.parentHeight;
        int i3 = i2 - height;
        int i4 = this.insetTop;
        if (i3 < i4) {
            if (this.paddingTopSystemWindowInsets) {
                int i5 = this.maxHeight;
                if (i5 != -1) {
                    i2 = Math.min(i2, i5);
                }
                this.childHeight = i2;
            } else {
                int i6 = i2 - i4;
                int i7 = this.maxHeight;
                if (i7 != -1) {
                    i6 = Math.min(i6, i7);
                }
                this.childHeight = i6;
            }
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        int i8 = this.state;
        if (i8 == 3) {
            v.offsetTopAndBottom(getExpandedOffset());
        } else if (i8 == 6) {
            v.offsetTopAndBottom(this.halfExpandedOffset);
        } else if (this.hideable && i8 == 5) {
            v.offsetTopAndBottom(this.parentHeight);
        } else if (i8 == 4) {
            v.offsetTopAndBottom(this.collapsedOffset);
        } else if (i8 == 1 || i8 == 2) {
            v.offsetTopAndBottom(top - v.getTop());
        }
        updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildRef = new WeakReference<>(findScrollingChild(v));
        for (int i9 = 0; i9 < this.callbacks.size(); i9++) {
            this.callbacks.get(i9).onLayout(v);
        }
        return true;
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        v.measure(getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference;
        if (!isNestedScrollingCheckEnabled() || (weakReference = this.nestedScrollingChildRef) == null || view != weakReference.get()) {
            return false;
        }
        if (this.state != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f, f2)) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        View view2;
        if (i3 != 1) {
            WeakReference<View> weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                view2 = weakReference.get();
            } else {
                view2 = null;
            }
            if (!isNestedScrollingCheckEnabled() || view == view2) {
                int top = v.getTop();
                int i4 = top - i2;
                if (i2 > 0) {
                    if (i4 < getExpandedOffset()) {
                        int expandedOffset2 = top - getExpandedOffset();
                        iArr[1] = expandedOffset2;
                        int i5 = -expandedOffset2;
                        WeakHashMap<View, GC> weakHashMap = f.f1839a;
                        v.offsetTopAndBottom(i5);
                        setStateInternal(3);
                    } else if (this.draggable) {
                        iArr[1] = i2;
                        WeakHashMap<View, GC> weakHashMap2 = f.f1839a;
                        v.offsetTopAndBottom(-i2);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                    if (i4 > this.collapsedOffset && !canBeHiddenByDragging()) {
                        int i6 = top - this.collapsedOffset;
                        iArr[1] = i6;
                        int i7 = -i6;
                        WeakHashMap<View, GC> weakHashMap3 = f.f1839a;
                        v.offsetTopAndBottom(i7);
                        setStateInternal(4);
                    } else if (this.draggable) {
                        iArr[1] = i2;
                        WeakHashMap<View, GC> weakHashMap4 = f.f1839a;
                        v.offsetTopAndBottom(-i2);
                        setStateInternal(1);
                    } else {
                        return;
                    }
                }
                dispatchOnSlide(v.getTop());
                this.lastNestedScrollDy = i2;
                this.nestedScrolled = true;
            }
        }
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        restoreOptionalState(savedState);
        int i = savedState.state;
        if (i == 1 || i == 2) {
            this.state = 4;
            this.lastStableState = 4;
            return;
        }
        this.state = i;
        this.lastStableState = i;
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r4.getTop() <= r2.halfExpandedOffset) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0065, code lost:
        if (java.lang.Math.abs(r3 - r2.fitToContentsOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        if (shouldSkipHalfExpandedStateWhenDragging() != false) goto L_0x0092;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008b, code lost:
        if (java.lang.Math.abs(r3 - r1) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a7, code lost:
        if (java.lang.Math.abs(r3 - r2.halfExpandedOffset) < java.lang.Math.abs(r3 - r2.collapsedOffset)) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout r3, V r4, android.view.View r5, int r6) {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.getExpandedOffset()
            r0 = 3
            if (r3 != r6) goto L_0x000f
            r2.setStateInternal(r0)
            return
        L_0x000f:
            boolean r3 = r2.isNestedScrollingCheckEnabled()
            if (r3 == 0) goto L_0x0024
            java.lang.ref.WeakReference<android.view.View> r3 = r2.nestedScrollingChildRef
            if (r3 == 0) goto L_0x0023
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto L_0x0023
            boolean r3 = r2.nestedScrolled
            if (r3 != 0) goto L_0x0024
        L_0x0023:
            return
        L_0x0024:
            int r3 = r2.lastNestedScrollDy
            r5 = 6
            if (r3 <= 0) goto L_0x0039
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L_0x002f
            goto L_0x00aa
        L_0x002f:
            int r3 = r4.getTop()
            int r6 = r2.halfExpandedOffset
            if (r3 <= r6) goto L_0x00aa
            goto L_0x00a9
        L_0x0039:
            boolean r3 = r2.hideable
            if (r3 == 0) goto L_0x0049
            float r3 = r2.getYVelocity()
            boolean r3 = r2.shouldHide(r4, r3)
            if (r3 == 0) goto L_0x0049
            r0 = 5
            goto L_0x00aa
        L_0x0049:
            int r3 = r2.lastNestedScrollDy
            r6 = 4
            if (r3 != 0) goto L_0x008e
            int r3 = r4.getTop()
            boolean r1 = r2.fitToContents
            if (r1 == 0) goto L_0x0068
            int r5 = r2.fitToContentsOffset
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L_0x0092
            goto L_0x00aa
        L_0x0068:
            int r1 = r2.halfExpandedOffset
            if (r3 >= r1) goto L_0x007e
            int r1 = r2.collapsedOffset
            int r1 = r3 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r3 >= r1) goto L_0x0077
            goto L_0x00aa
        L_0x0077:
            boolean r3 = r2.shouldSkipHalfExpandedStateWhenDragging()
            if (r3 == 0) goto L_0x00a9
            goto L_0x0092
        L_0x007e:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
            goto L_0x00a9
        L_0x008e:
            boolean r3 = r2.fitToContents
            if (r3 == 0) goto L_0x0094
        L_0x0092:
            r0 = r6
            goto L_0x00aa
        L_0x0094:
            int r3 = r4.getTop()
            int r0 = r2.halfExpandedOffset
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.collapsedOffset
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L_0x0092
        L_0x00a9:
            r0 = r5
        L_0x00aa:
            r3 = 0
            r2.startSettling(r4, r0, r3)
            r2.nestedScrolled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.onStopNestedScroll(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.m(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents) {
            float abs = Math.abs(((float) this.initialY) - motionEvent.getY());
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            if (abs > ((float) viewDragHelper2.f1886b)) {
                viewDragHelper2.c(motionEvent.getPointerId(motionEvent.getActionIndex()), v);
            }
        }
        return !this.ignoreEvents;
    }

    public void removeBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    public void setAccessibilityDelegateView(View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.accessibilityDelegateViewRef) == null) {
            this.accessibilityDelegateViewRef = new WeakReference<>(view);
            updateAccessibilityActions(view, 1);
            return;
        }
        clearAccessibilityAction(weakReference.get(), 1);
        this.accessibilityDelegateViewRef = null;
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public void setExpandedOffset(int i) {
        if (i >= 0) {
            this.expandedOffset = i;
            updateDrawableForTargetState(this.state, true);
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void setFitToContents(boolean z) {
        int i;
        if (this.fitToContents != z) {
            this.fitToContents = z;
            if (this.viewRef != null) {
                calculateCollapsedOffset();
            }
            if (!this.fitToContents || this.state != 6) {
                i = this.state;
            } else {
                i = 3;
            }
            setStateInternal(i);
            updateDrawableForTargetState(this.state, true);
            updateAccessibilityActions();
        }
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
    }

    public void setHalfExpandedRatio(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideFriction(float f) {
        this.hideFriction = f;
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setHideableInternal(boolean z) {
        this.hideable = z;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public void setPeekHeight(int i) {
        setPeekHeight(i, false);
    }

    public void setSaveFlags(int i) {
        this.saveFlags = i;
    }

    public void setShouldRemoveExpandedCorners(boolean z) {
        if (this.shouldRemoveExpandedCorners != z) {
            this.shouldRemoveExpandedCorners = z;
            updateDrawableForTargetState(getState(), true);
        }
    }

    public void setSignificantVelocityThreshold(int i) {
        this.significantVelocityThreshold = i;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public void setState(int i) {
        String str;
        final int i2;
        if (i == 1 || i == 2) {
            StringBuilder sb = new StringBuilder("STATE_");
            if (i == 1) {
                str = "DRAGGING";
            } else {
                str = "SETTLING";
            }
            throw new IllegalArgumentException(C0709Uj.j(sb, str, " should not be set externally."));
        } else if (this.hideable || i != 5) {
            if (i != 6 || !this.fitToContents || getTopOffsetForState(i) > this.fitToContentsOffset) {
                i2 = i;
            } else {
                i2 = 3;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference == null || weakReference.get() == null) {
                setStateInternal(i);
                return;
            }
            final View view = (View) this.viewRef.get();
            runAfterLayout(view, new Runnable() {
                public void run() {
                    BottomSheetBehavior.this.startSettling(view, i2, false);
                }
            });
        }
    }

    public void setStateInternal(int i) {
        View view;
        if (this.state != i) {
            this.state = i;
            if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
                this.lastStableState = i;
            }
            WeakReference<V> weakReference = this.viewRef;
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (i == 3) {
                    updateImportantForAccessibility(true);
                } else if (i == 6 || i == 5 || i == 4) {
                    updateImportantForAccessibility(false);
                }
                updateDrawableForTargetState(i, true);
                for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
                    this.callbacks.get(i2).onStateChanged(view, i);
                }
                updateAccessibilityActions();
            }
        }
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        this.updateImportantForAccessibilityOnSiblings = z;
    }

    public boolean shouldExpandOnUpwardDrag(long j, float f) {
        return false;
    }

    public boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (!isHideableWhenDragging() || view.getTop() < this.collapsedOffset) {
            return false;
        }
        int calculatePeekHeight = calculatePeekHeight();
        if (Math.abs(((f * this.hideFriction) + ((float) view.getTop())) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight) > HIDE_THRESHOLD) {
            return true;
        }
        return false;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    public void startBackProgress(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.startBackProgress(backEventCompat);
        }
    }

    public void updateBackProgress(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.bottomContainerBackHelper;
        if (materialBottomContainerBackHelper != null) {
            materialBottomContainerBackHelper.updateBackProgress(backEventCompat);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPeekHeight(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = -1
            r1 = 1
            r2 = 0
            if (r4 != r0) goto L_0x000c
            boolean r4 = r3.peekHeightAuto
            if (r4 != 0) goto L_0x0015
            r3.peekHeightAuto = r1
            goto L_0x001f
        L_0x000c:
            boolean r0 = r3.peekHeightAuto
            if (r0 != 0) goto L_0x0017
            int r0 = r3.peekHeight
            if (r0 == r4) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r1 = r2
            goto L_0x001f
        L_0x0017:
            r3.peekHeightAuto = r2
            int r4 = java.lang.Math.max(r2, r4)
            r3.peekHeight = r4
        L_0x001f:
            if (r1 == 0) goto L_0x0024
            r3.updatePeekHeight(r5)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.setPeekHeight(int, boolean):void");
    }

    private void updateAccessibilityActions(View view, int i) {
        if (view != null) {
            clearAccessibilityAction(view, i);
            int i2 = 6;
            if (!this.fitToContents && this.state != 6) {
                this.expandHalfwayActionIds.put(i, addAccessibilityActionForState(view, R.string.bottomsheet_action_expand_halfway, 6));
            }
            if (this.hideable && isHideableWhenDragging() && this.state != 5) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.h, 5);
            }
            int i3 = this.state;
            if (i3 == 3) {
                if (this.fitToContents) {
                    i2 = 4;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.g, i2);
            } else if (i3 == 4) {
                if (this.fitToContents) {
                    i2 = 3;
                }
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f, i2);
            } else if (i3 == 6) {
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.g, 4);
                replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f, 3);
            }
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        int i2 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        if (obtainStyledAttributes.hasValue(i2)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, i2);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
        }
        createMaterialShapeDrawableIfNeeded(context);
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i3 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i3)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(i3, -1));
        }
        int i4 = R.styleable.BottomSheetBehavior_Layout_android_maxHeight;
        if (obtainStyledAttributes.hasValue(i4)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        }
        int i5 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i5);
        if (peekValue == null || (i = peekValue.data) != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(i5, -1));
        } else {
            setPeekHeight(i);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, HIDE_THRESHOLD));
        int i6 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i6);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(i6, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        setSignificantVelocityThreshold(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);

        public void onLayout(View view) {
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }
}
