package androidx.slidingpanelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.f;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import defpackage.d7;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class SlidingPaneLayout extends ViewGroup {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2415a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f2416a;

    /* renamed from: a  reason: collision with other field name */
    public View f2417a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewDragHelper f2418a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f2419a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2420a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public Drawable f2421b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2422b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f2423c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2424c;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f2425d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f2426d;
    public final int e;
    public int f;
    public int g;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean a;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel, (ClassLoader) null);
            this.a = parcel.readInt() != 0;
        }
    }

    public class a extends AccessibilityDelegateCompat {
        public final Rect a = new Rect();

        public a() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f1832a);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(obtain);
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat2);
            Rect rect = this.a;
            accessibilityNodeInfoCompat2.f(rect);
            accessibilityNodeInfoCompat.i(rect);
            obtain.getBoundsInScreen(rect);
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f1832a;
            accessibilityNodeInfo.setBoundsInScreen(rect);
            accessibilityNodeInfo.setVisibleToUser(obtain.isVisibleToUser());
            accessibilityNodeInfo.setPackageName(obtain.getPackageName());
            accessibilityNodeInfoCompat.j(obtain.getClassName());
            accessibilityNodeInfoCompat.m(obtain.getContentDescription());
            accessibilityNodeInfo.setEnabled(obtain.isEnabled());
            accessibilityNodeInfo.setClickable(obtain.isClickable());
            accessibilityNodeInfo.setFocusable(obtain.isFocusable());
            accessibilityNodeInfo.setFocused(obtain.isFocused());
            accessibilityNodeInfo.setAccessibilityFocused(obtain.isAccessibilityFocused());
            accessibilityNodeInfo.setSelected(obtain.isSelected());
            accessibilityNodeInfo.setLongClickable(obtain.isLongClickable());
            accessibilityNodeInfoCompat.a(obtain.getActions());
            accessibilityNodeInfo.setMovementGranularities(obtain.getMovementGranularities());
            accessibilityNodeInfoCompat.j(SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.b = -1;
            accessibilityNodeInfo.setSource(view);
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            ViewParent parentForAccessibility = view.getParentForAccessibility();
            if (parentForAccessibility instanceof View) {
                accessibilityNodeInfoCompat.a = -1;
                accessibilityNodeInfo.setParent((View) parentForAccessibility);
            }
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            int childCount = slidingPaneLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = slidingPaneLayout.getChildAt(i);
                if (!slidingPaneLayout.b(childAt) && childAt.getVisibility() == 0) {
                    childAt.setImportantForAccessibility(1);
                    accessibilityNodeInfo.addChild(childAt);
                }
            }
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (!SlidingPaneLayout.this.b(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public class b implements Runnable {
        public final View a;

        public b(View view) {
            this.a = view;
        }

        public final void run() {
            View view = this.a;
            ViewParent parent = view.getParent();
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (parent == slidingPaneLayout) {
                view.setLayerType(0, (Paint) null);
                slidingPaneLayout.getClass();
                Paint paint = ((LayoutParams) view.getLayoutParams()).f2428a;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                view.setLayerPaint(paint);
            }
            slidingPaneLayout.f2419a.remove(this);
        }
    }

    public class c extends ViewDragHelper.Callback {
        public c() {
        }

        public final int clampViewPositionHorizontal(View view, int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.f2417a.getLayoutParams();
            if (slidingPaneLayout.c()) {
                int width = slidingPaneLayout.getWidth() - (slidingPaneLayout.f2417a.getWidth() + (slidingPaneLayout.getPaddingRight() + layoutParams.rightMargin));
                return Math.max(Math.min(i, width), width - slidingPaneLayout.f);
            }
            int paddingLeft = slidingPaneLayout.getPaddingLeft() + layoutParams.leftMargin;
            return Math.min(Math.max(i, paddingLeft), slidingPaneLayout.f + paddingLeft);
        }

        public final int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public final int getViewHorizontalDragRange(View view) {
            return SlidingPaneLayout.this.f;
        }

        public final void onEdgeDragStarted(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.f2418a.c(i2, slidingPaneLayout.f2417a);
        }

        public final void onViewCaptured(View view, int i) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            int childCount = slidingPaneLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = slidingPaneLayout.getChildAt(i2);
                if (childAt.getVisibility() == 4) {
                    childAt.setVisibility(0);
                }
            }
        }

        public final void onViewDragStateChanged(int i) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f2418a.f1876a != 0) {
                return;
            }
            if (slidingPaneLayout.a == 0.0f) {
                slidingPaneLayout.f(slidingPaneLayout.f2417a);
                View view = slidingPaneLayout.f2417a;
                slidingPaneLayout.sendAccessibilityEvent(32);
                slidingPaneLayout.f2424c = false;
                return;
            }
            View view2 = slidingPaneLayout.f2417a;
            slidingPaneLayout.sendAccessibilityEvent(32);
            slidingPaneLayout.f2424c = true;
        }

        public final void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f2417a == null) {
                slidingPaneLayout.a = 0.0f;
            } else {
                boolean c = slidingPaneLayout.c();
                LayoutParams layoutParams = (LayoutParams) slidingPaneLayout.f2417a.getLayoutParams();
                int width = slidingPaneLayout.f2417a.getWidth();
                if (c) {
                    i = (slidingPaneLayout.getWidth() - i) - width;
                }
                if (c) {
                    i5 = slidingPaneLayout.getPaddingRight();
                } else {
                    i5 = slidingPaneLayout.getPaddingLeft();
                }
                if (c) {
                    i6 = layoutParams.rightMargin;
                } else {
                    i6 = layoutParams.leftMargin;
                }
                float f = ((float) (i - (i5 + i6))) / ((float) slidingPaneLayout.f);
                slidingPaneLayout.a = f;
                if (slidingPaneLayout.g != 0) {
                    slidingPaneLayout.d(f);
                }
                if (layoutParams.b) {
                    View view2 = slidingPaneLayout.f2417a;
                    slidingPaneLayout.a(slidingPaneLayout.f2423c, slidingPaneLayout.a, view2);
                }
            }
            slidingPaneLayout.invalidate();
        }

        public final void onViewReleased(View view, float f, float f2) {
            int i;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.c()) {
                int paddingRight = slidingPaneLayout.getPaddingRight() + layoutParams.rightMargin;
                if (f < 0.0f || (f == 0.0f && slidingPaneLayout.a > 0.5f)) {
                    paddingRight += slidingPaneLayout.f;
                }
                i = (slidingPaneLayout.getWidth() - paddingRight) - slidingPaneLayout.f2417a.getWidth();
            } else {
                i = layoutParams.leftMargin + slidingPaneLayout.getPaddingLeft();
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 > 0 || (i2 == 0 && slidingPaneLayout.a > 0.5f)) {
                    i += slidingPaneLayout.f;
                }
            }
            slidingPaneLayout.f2418a.s(i, view.getTop());
            slidingPaneLayout.invalidate();
        }

        public final boolean tryCaptureView(View view, int i) {
            if (SlidingPaneLayout.this.f2422b) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f2429a;
        }
    }

    public interface d {
    }

    public SlidingPaneLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void a(int i, float f2, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > 0.0f && i != 0) {
            int i2 = (i & 16777215) | (((int) (((float) ((-16777216 & i) >>> 24)) * f2)) << 24);
            if (layoutParams.f2428a == null) {
                layoutParams.f2428a = new Paint();
            }
            layoutParams.f2428a.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f2428a);
            }
            Paint paint = ((LayoutParams) view.getLayoutParams()).f2428a;
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            view.setLayerPaint(paint);
        } else if (view.getLayerType() != 0) {
            Paint paint2 = layoutParams.f2428a;
            if (paint2 != null) {
                paint2.setColorFilter((ColorFilter) null);
            }
            b bVar = new b(view);
            this.f2419a.add(bVar);
            WeakHashMap<View, GC> weakHashMap2 = f.f1839a;
            postOnAnimation(bVar);
        }
    }

    public final boolean b(View view) {
        if (view == null) {
            return false;
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!this.f2420a || !layoutParams.b || this.a <= 0.0f) {
            return false;
        }
        return true;
    }

    public final boolean c() {
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public final void computeScroll() {
        ViewDragHelper viewDragHelper = this.f2418a;
        if (!viewDragHelper.h()) {
            return;
        }
        if (!this.f2420a) {
            viewDragHelper.a();
            return;
        }
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        postInvalidateOnAnimation();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.c()
            android.view.View r1 = r9.f2417a
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.b
            r3 = 0
            if (r2 == 0) goto L_0x001c
            if (r0 == 0) goto L_0x0016
            int r1 = r1.rightMargin
            goto L_0x0018
        L_0x0016:
            int r1 = r1.leftMargin
        L_0x0018:
            if (r1 > 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = r3
        L_0x001d:
            int r2 = r9.getChildCount()
        L_0x0021:
            if (r3 >= r2) goto L_0x0057
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.f2417a
            if (r4 != r5) goto L_0x002c
            goto L_0x0054
        L_0x002c:
            float r5 = r9.b
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.g
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.b = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L_0x0042
            int r5 = -r5
        L_0x0042:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L_0x0054
            float r5 = r9.b
            if (r0 == 0) goto L_0x004d
            float r5 = r5 - r6
            goto L_0x004f
        L_0x004d:
            float r5 = r6 - r5
        L_0x004f:
            int r6 = r9.f2425d
            r9.a(r6, r5, r4)
        L_0x0054:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.d(float):void");
    }

    public final void draw(Canvas canvas) {
        Drawable drawable;
        View view;
        int i;
        int i2;
        super.draw(canvas);
        if (c()) {
            drawable = this.f2421b;
        } else {
            drawable = this.f2416a;
        }
        if (getChildCount() > 1) {
            view = getChildAt(1);
        } else {
            view = null;
        }
        if (view != null && drawable != null) {
            int top = view.getTop();
            int bottom = view.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (c()) {
                i2 = view.getRight();
                i = intrinsicWidth + i2;
            } else {
                int left = view.getLeft();
                int i3 = left - intrinsicWidth;
                i = left;
                i2 = i3;
            }
            drawable.setBounds(i2, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    public final boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (this.f2420a && !layoutParams.f2429a && this.f2417a != null) {
            Rect rect = this.f2415a;
            canvas.getClipBounds(rect);
            if (c()) {
                rect.left = Math.max(rect.left, this.f2417a.getRight());
            } else {
                rect.right = Math.min(rect.right, this.f2417a.getLeft());
            }
            canvas.clipRect(rect);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    public final boolean e(float f2) {
        int i;
        if (!this.f2420a) {
            return false;
        }
        boolean c2 = c();
        LayoutParams layoutParams = (LayoutParams) this.f2417a.getLayoutParams();
        if (c2) {
            i = (int) (((float) getWidth()) - (((f2 * ((float) this.f)) + ((float) (getPaddingRight() + layoutParams.rightMargin))) + ((float) this.f2417a.getWidth())));
        } else {
            i = (int) ((f2 * ((float) this.f)) + ((float) (getPaddingLeft() + layoutParams.leftMargin)));
        }
        View view = this.f2417a;
        if (!this.f2418a.u(view, i, view.getTop())) {
            return false;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        postInvalidateOnAnimation();
        return true;
    }

    public final void f(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View childAt;
        boolean z;
        int i7;
        int i8;
        int i9;
        View view2 = view;
        boolean c2 = c();
        if (c2) {
            i = getWidth() - getPaddingRight();
        } else {
            i = getPaddingLeft();
        }
        if (c2) {
            i2 = getPaddingLeft();
        } else {
            i2 = getWidth() - getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !view.isOpaque()) {
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        } else {
            i6 = view.getLeft();
            i5 = view.getRight();
            i4 = view.getTop();
            i3 = view.getBottom();
        }
        int childCount = getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 < childCount && (childAt = getChildAt(i10)) != view2) {
                if (childAt.getVisibility() == 8) {
                    z = c2;
                } else {
                    if (c2) {
                        i7 = i2;
                    } else {
                        i7 = i;
                    }
                    int max = Math.max(i7, childAt.getLeft());
                    int max2 = Math.max(paddingTop, childAt.getTop());
                    z = c2;
                    if (c2) {
                        i8 = i;
                    } else {
                        i8 = i2;
                    }
                    int min = Math.min(i8, childAt.getRight());
                    int min2 = Math.min(height, childAt.getBottom());
                    if (max < i6 || max2 < i4 || min > i5 || min2 > i3) {
                        i9 = 0;
                    } else {
                        i9 = 4;
                    }
                    childAt.setVisibility(i9);
                }
                i10++;
                view2 = view;
                c2 = z;
            } else {
                return;
            }
        }
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.f2425d;
    }

    public int getParallaxDistance() {
        return this.g;
    }

    public int getSliderFadeColor() {
        return this.f2423c;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2426d = true;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2426d = true;
        ArrayList<b> arrayList = this.f2419a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.get(i).run();
        }
        arrayList.clear();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        boolean z2 = this.f2420a;
        ViewDragHelper viewDragHelper = this.f2418a;
        if (!z2 && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            viewDragHelper.getClass();
            this.f2424c = !ViewDragHelper.l(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f2420a || (this.f2422b && actionMasked != 0)) {
            viewDragHelper.b();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked == 3 || actionMasked == 1) {
            viewDragHelper.b();
            return false;
        } else {
            if (actionMasked == 0) {
                this.f2422b = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.c = x;
                this.d = y;
                viewDragHelper.getClass();
                if (ViewDragHelper.l(this.f2417a, (int) x, (int) y) && b(this.f2417a)) {
                    z = true;
                    if (viewDragHelper.t(motionEvent) && !z) {
                        return false;
                    }
                }
            } else if (actionMasked == 2) {
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float abs = Math.abs(x2 - this.c);
                float abs2 = Math.abs(y2 - this.d);
                if (abs > ((float) viewDragHelper.f1886b) && abs2 > abs) {
                    viewDragHelper.b();
                    this.f2422b = true;
                    return false;
                }
            }
            z = false;
            return viewDragHelper.t(motionEvent) ? true : true;
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        float f2;
        boolean c2 = c();
        ViewDragHelper viewDragHelper = this.f2418a;
        if (c2) {
            viewDragHelper.g = 2;
        } else {
            viewDragHelper.g = 1;
        }
        int i13 = i3 - i;
        if (c2) {
            i5 = getPaddingRight();
        } else {
            i5 = getPaddingLeft();
        }
        if (c2) {
            i6 = getPaddingLeft();
        } else {
            i6 = getPaddingRight();
        }
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f2426d) {
            if (!this.f2420a || !this.f2424c) {
                f2 = 0.0f;
            } else {
                f2 = 1.0f;
            }
            this.a = f2;
        }
        int i14 = i5;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f2429a) {
                    int i16 = i13 - i6;
                    int min = (Math.min(i5, i16 - this.e) - i14) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f = min;
                    if (c2) {
                        i12 = layoutParams.rightMargin;
                    } else {
                        i12 = layoutParams.leftMargin;
                    }
                    if ((measuredWidth / 2) + i14 + i12 + min > i16) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    layoutParams.b = z2;
                    int i17 = (int) (((float) min) * this.a);
                    i8 = i12 + i17 + i14;
                    this.a = ((float) i17) / ((float) min);
                    i7 = 0;
                } else if (!this.f2420a || (i11 = this.g) == 0) {
                    i8 = i5;
                    i7 = 0;
                } else {
                    i7 = (int) ((1.0f - this.a) * ((float) i11));
                    i8 = i5;
                }
                if (c2) {
                    i9 = (i13 - i8) + i7;
                    i10 = i9 - measuredWidth;
                } else {
                    i10 = i8 - i7;
                    i9 = i10 + measuredWidth;
                }
                childAt.layout(i10, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i14 = i8;
                i5 = childAt.getWidth() + i5;
            }
        }
        if (this.f2426d) {
            if (this.f2420a) {
                if (this.g != 0) {
                    d(this.a);
                }
                if (((LayoutParams) this.f2417a.getLayoutParams()).b) {
                    View view = this.f2417a;
                    a(this.f2423c, this.a, view);
                }
            } else {
                for (int i18 = 0; i18 < childCount; i18++) {
                    a(this.f2423c, 0.0f, getChildAt(i18));
                }
            }
            f(this.f2417a);
        }
        this.f2426d = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            int r1 = android.view.View.MeasureSpec.getMode(r21)
            int r2 = android.view.View.MeasureSpec.getSize(r21)
            int r3 = android.view.View.MeasureSpec.getMode(r22)
            int r4 = android.view.View.MeasureSpec.getSize(r22)
            r5 = 300(0x12c, float:4.2E-43)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            if (r1 == r7) goto L_0x002f
            boolean r8 = r20.isInEditMode()
            if (r8 == 0) goto L_0x0027
            if (r1 != r6) goto L_0x0023
            goto L_0x0044
        L_0x0023:
            if (r1 != 0) goto L_0x0044
            r2 = r5
            goto L_0x0044
        L_0x0027:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Width must have an exact value or MATCH_PARENT"
            r1.<init>(r2)
            throw r1
        L_0x002f:
            if (r3 != 0) goto L_0x0044
            boolean r1 = r20.isInEditMode()
            if (r1 == 0) goto L_0x003c
            if (r3 != 0) goto L_0x0044
            r4 = r5
            r3 = r6
            goto L_0x0044
        L_0x003c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Height must not be UNSPECIFIED"
            r1.<init>(r2)
            throw r1
        L_0x0044:
            r1 = 0
            if (r3 == r6) goto L_0x0057
            if (r3 == r7) goto L_0x004c
            r4 = r1
        L_0x004a:
            r5 = r4
            goto L_0x0063
        L_0x004c:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            goto L_0x004a
        L_0x0057:
            int r5 = r20.getPaddingTop()
            int r4 = r4 - r5
            int r5 = r20.getPaddingBottom()
            int r4 = r4 - r5
            r5 = r4
            r4 = r1
        L_0x0063:
            int r8 = r20.getPaddingLeft()
            int r8 = r2 - r8
            int r9 = r20.getPaddingRight()
            int r8 = r8 - r9
            int r9 = r20.getChildCount()
            r10 = 0
            r0.f2417a = r10
            r11 = r1
            r12 = r11
            r14 = r8
            r13 = 0
        L_0x0079:
            r15 = 8
            r16 = 1
            if (r11 >= r9) goto L_0x0118
            android.view.View r6 = r0.getChildAt(r11)
            android.view.ViewGroup$LayoutParams r17 = r6.getLayoutParams()
            r7 = r17
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x0095
            r7.b = r1
            goto L_0x010f
        L_0x0095:
            float r10 = r7.f2427a
            r15 = 0
            int r18 = (r10 > r15 ? 1 : (r10 == r15 ? 0 : -1))
            if (r18 <= 0) goto L_0x00a3
            float r13 = r13 + r10
            int r10 = r7.width
            if (r10 != 0) goto L_0x00a3
            goto L_0x010f
        L_0x00a3:
            int r10 = r7.leftMargin
            int r15 = r7.rightMargin
            int r10 = r10 + r15
            int r15 = r7.width
            r1 = -2
            if (r15 != r1) goto L_0x00bb
            int r10 = r8 - r10
            r15 = -2147483648(0xffffffff80000000, float:-0.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
            r22 = r13
            r13 = r15
            r1 = -1
        L_0x00b9:
            r15 = r10
            goto L_0x00d1
        L_0x00bb:
            r22 = r13
            r1 = -1
            r13 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r15 != r1) goto L_0x00cb
            int r10 = r8 - r10
            r15 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r15)
            goto L_0x00b9
        L_0x00cb:
            r10 = 1073741824(0x40000000, float:2.0)
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
        L_0x00d1:
            int r10 = r7.height
            r1 = -2
            if (r10 != r1) goto L_0x00db
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r13)
            goto L_0x00ec
        L_0x00db:
            r1 = -1
            if (r10 != r1) goto L_0x00e5
            r1 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
            goto L_0x00eb
        L_0x00e5:
            r1 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r1)
        L_0x00eb:
            r1 = r10
        L_0x00ec:
            r6.measure(r15, r1)
            int r1 = r6.getMeasuredWidth()
            int r10 = r6.getMeasuredHeight()
            if (r3 != r13) goto L_0x00ff
            if (r10 <= r4) goto L_0x00ff
            int r4 = java.lang.Math.min(r10, r5)
        L_0x00ff:
            int r14 = r14 - r1
            if (r14 >= 0) goto L_0x0105
            r1 = r16
            goto L_0x0106
        L_0x0105:
            r1 = 0
        L_0x0106:
            r7.f2429a = r1
            r12 = r12 | r1
            if (r1 == 0) goto L_0x010d
            r0.f2417a = r6
        L_0x010d:
            r13 = r22
        L_0x010f:
            int r11 = r11 + 1
            r1 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 1073741824(0x40000000, float:2.0)
            goto L_0x0079
        L_0x0118:
            if (r12 != 0) goto L_0x011f
            r1 = 0
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0204
        L_0x011f:
            int r1 = r0.e
            int r1 = r8 - r1
            r3 = 0
        L_0x0124:
            if (r3 >= r9) goto L_0x0204
            android.view.View r6 = r0.getChildAt(r3)
            int r7 = r6.getVisibility()
            if (r7 != r15) goto L_0x0137
        L_0x0130:
            r19 = r9
        L_0x0132:
            r7 = 0
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x01fc
        L_0x0137:
            android.view.ViewGroup$LayoutParams r7 = r6.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r7 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r7
            int r10 = r6.getVisibility()
            if (r10 != r15) goto L_0x0144
            goto L_0x0130
        L_0x0144:
            int r10 = r7.width
            float r11 = r7.f2427a
            if (r10 != 0) goto L_0x0152
            r10 = 0
            int r19 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r19 <= 0) goto L_0x0152
            r10 = r16
            goto L_0x0153
        L_0x0152:
            r10 = 0
        L_0x0153:
            if (r10 == 0) goto L_0x0157
            r15 = 0
            goto L_0x015d
        L_0x0157:
            int r19 = r6.getMeasuredWidth()
            r15 = r19
        L_0x015d:
            r19 = r9
            if (r12 == 0) goto L_0x01a3
            android.view.View r9 = r0.f2417a
            if (r6 == r9) goto L_0x01a3
            int r9 = r7.width
            if (r9 >= 0) goto L_0x0132
            if (r15 > r1) goto L_0x0170
            r9 = 0
            int r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0132
        L_0x0170:
            if (r10 == 0) goto L_0x0191
            int r7 = r7.height
            r9 = -2
            if (r7 != r9) goto L_0x0180
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9)
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x019b
        L_0x0180:
            r9 = -1
            if (r7 != r9) goto L_0x018a
            r9 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9)
            goto L_0x019b
        L_0x018a:
            r9 = 1073741824(0x40000000, float:2.0)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            goto L_0x019b
        L_0x0191:
            r9 = 1073741824(0x40000000, float:2.0)
            int r7 = r6.getMeasuredHeight()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
        L_0x019b:
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r9)
            r6.measure(r10, r7)
            goto L_0x0132
        L_0x01a3:
            r9 = 0
            int r10 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r10 <= 0) goto L_0x0132
            int r10 = r7.width
            if (r10 != 0) goto L_0x01cb
            int r10 = r7.height
            r9 = -2
            if (r10 != r9) goto L_0x01ba
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9)
            r9 = 1073741824(0x40000000, float:2.0)
            goto L_0x01d5
        L_0x01ba:
            r9 = -1
            if (r10 != r9) goto L_0x01c4
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r9)
            goto L_0x01d5
        L_0x01c4:
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r9)
            goto L_0x01d5
        L_0x01cb:
            r9 = 1073741824(0x40000000, float:2.0)
            int r10 = r6.getMeasuredHeight()
            int r10 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r9)
        L_0x01d5:
            if (r12 == 0) goto L_0x01e9
            int r11 = r7.leftMargin
            int r7 = r7.rightMargin
            int r11 = r11 + r7
            int r7 = r8 - r11
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r9)
            if (r15 == r7) goto L_0x0132
            r6.measure(r11, r10)
            goto L_0x0132
        L_0x01e9:
            r7 = 0
            int r9 = java.lang.Math.max(r7, r14)
            float r9 = (float) r9
            float r11 = r11 * r9
            float r11 = r11 / r13
            int r9 = (int) r11
            int r15 = r15 + r9
            r9 = 1073741824(0x40000000, float:2.0)
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r9)
            r6.measure(r11, r10)
        L_0x01fc:
            int r3 = r3 + 1
            r9 = r19
            r15 = 8
            goto L_0x0124
        L_0x0204:
            int r1 = r20.getPaddingTop()
            int r1 = r1 + r4
            int r3 = r20.getPaddingBottom()
            int r3 = r3 + r1
            r0.setMeasuredDimension(r2, r3)
            r0.f2420a = r12
            androidx.customview.widget.ViewDragHelper r1 = r0.f2418a
            int r2 = r1.f1876a
            if (r2 == 0) goto L_0x021e
            if (r12 != 0) goto L_0x021e
            r1.a()
        L_0x021e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.a) {
            if (this.f2426d || e(1.0f)) {
                this.f2424c = true;
            }
        } else if (this.f2426d || e(0.0f)) {
            this.f2424c = false;
        }
        this.f2424c = savedState.a;
    }

    public final Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean z2 = this.f2420a;
        if (!z2) {
            z = this.f2424c;
        } else if (!z2 || this.a == 1.0f) {
            z = true;
        } else {
            z = false;
        }
        savedState.a = z;
        return savedState;
    }

    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f2426d = true;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f2420a) {
            return super.onTouchEvent(motionEvent);
        }
        ViewDragHelper viewDragHelper = this.f2418a;
        viewDragHelper.m(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.c = x;
            this.d = y;
        } else if (actionMasked == 1 && b(this.f2417a)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.c;
            float f3 = y2 - this.d;
            int i = viewDragHelper.f1886b;
            if ((f3 * f3) + (f2 * f2) < ((float) (i * i)) && ViewDragHelper.l(this.f2417a, (int) x2, (int) y2) && (this.f2426d || e(0.0f))) {
                this.f2424c = false;
            }
        }
        return true;
    }

    public final void requestChildFocus(View view, View view2) {
        boolean z;
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f2420a) {
            if (view == this.f2417a) {
                z = true;
            } else {
                z = false;
            }
            this.f2424c = z;
        }
    }

    public void setCoveredFadeColor(int i) {
        this.f2425d = i;
    }

    public void setParallaxDistance(int i) {
        this.g = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f2416a = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f2421b = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        Context context = getContext();
        Object obj = d7.a;
        setShadowDrawableLeft(d7.a.b(context, i));
    }

    public void setShadowResourceRight(int i) {
        Context context = getContext();
        Object obj = d7.a;
        setShadowDrawableRight(d7.a.b(context, i));
    }

    public void setSliderFadeColor(int i) {
        this.f2423c = i;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public static final int[] a = {16843137};

        /* renamed from: a  reason: collision with other field name */
        public final float f2427a = 0.0f;

        /* renamed from: a  reason: collision with other field name */
        public Paint f2428a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2429a;
        public boolean b;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a);
            this.f2427a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2423c = -858993460;
        this.f2426d = true;
        this.f2415a = new Rect();
        this.f2419a = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.e = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        f.o(this, new a());
        setImportantForAccessibility(1);
        ViewDragHelper i2 = ViewDragHelper.i(this, 0.5f, new c());
        this.f2418a = i2;
        i2.b = f2 * 400.0f;
    }

    public void setPanelSlideListener(d dVar) {
    }
}
