package androidx.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.f;
import com.google.common.primitives.Ints;
import defpackage.C0168da;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class NestedScrollView extends FrameLayout implements C0382wm, C0356um {
    public static final a a = new a();
    public static final float c = ((float) (Math.log(0.78d) / Math.log(0.9d)));

    /* renamed from: c  reason: collision with other field name */
    public static final int[] f1852c = {16843130};

    /* renamed from: a  reason: collision with other field name */
    public final float f1853a;

    /* renamed from: a  reason: collision with other field name */
    public long f1854a;

    /* renamed from: a  reason: collision with other field name */
    public final C0114a9 f1855a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1856a;

    /* renamed from: a  reason: collision with other field name */
    public VelocityTracker f1857a;

    /* renamed from: a  reason: collision with other field name */
    public View f1858a;

    /* renamed from: a  reason: collision with other field name */
    public final EdgeEffect f1859a;

    /* renamed from: a  reason: collision with other field name */
    public OverScroller f1860a;

    /* renamed from: a  reason: collision with other field name */
    public final NestedScrollingChildHelper f1861a;

    /* renamed from: a  reason: collision with other field name */
    public final NestedScrollingParentHelper f1862a;

    /* renamed from: a  reason: collision with other field name */
    public SavedState f1863a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1864a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f1865a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public final EdgeEffect f1866b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1867b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f1868b;

    /* renamed from: c  reason: collision with other field name */
    public int f1869c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1870c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1871d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f1872e;
    public int f;
    public int g;
    public int h;
    public int i;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int c;

        public class a implements Parcelable.Creator<SavedState> {
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("HorizontalScrollView.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" scrollPosition=");
            return lf.k(sb, this.c, "}");
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.c = parcel.readInt();
        }
    }

    public static class a extends AccessibilityDelegateCompat {
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            boolean z;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            if (nestedScrollView.getScrollRange() > 0) {
                z = true;
            } else {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.j(ScrollView.class.getName());
            if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                accessibilityNodeInfoCompat.n(true);
                if (nestedScrollView.getScrollY() > 0) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.e);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.i);
                }
                if (nestedScrollView.getScrollY() < scrollRange) {
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.d);
                    accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.j);
                }
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i != 4096) {
                if (i == 8192 || i == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.p(0 - nestedScrollView.getScrollX(), max - nestedScrollView.getScrollY(), true);
                    return true;
                } else if (i != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.p(0 - nestedScrollView.getScrollX(), min - nestedScrollView.getScrollY(), true);
            return true;
        }
    }

    public static class b {
        public static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    public class c implements C0142b9 {
        public c() {
        }
    }

    public interface d {
    }

    public NestedScrollView(Context context) {
        this(context, (AttributeSet) null);
    }

    public static boolean g(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup) || !g((View) parent, view2)) {
            return false;
        }
        return true;
    }

    public final boolean a(int i2) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i2);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !h(findNextFocus, maxScrollAmount, getHeight())) {
            if (i2 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i2 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getHeight() + getScrollY()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i2 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            n(maxScrollAmount, 0, 1, true);
        } else {
            Rect rect = this.f1856a;
            findNextFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findNextFocus, rect);
            n(b(rect), 0, 1, true);
            findNextFocus.requestFocus(i2);
        }
        if (findFocus != null && findFocus.isFocused() && (!h(findFocus, 0, getHeight()))) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    public final void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final int b(Rect rect) {
        int i2;
        int i3;
        int i4;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        if (rect.bottom < childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin) {
            i2 = i5 - verticalFadingEdgeLength;
        } else {
            i2 = i5;
        }
        int i6 = rect.bottom;
        if (i6 > i2 && rect.top > scrollY) {
            if (rect.height() > height) {
                i4 = rect.top - scrollY;
            } else {
                i4 = rect.bottom - i2;
            }
            return Math.min(i4 + 0, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        } else if (rect.top >= scrollY || i6 >= i2) {
            return 0;
        } else {
            if (rect.height() > height) {
                i3 = 0 - (i2 - rect.bottom);
            } else {
                i3 = 0 - (scrollY - rect.top);
            }
            return Math.max(i3, -getScrollY());
        }
    }

    public final boolean c(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return this.f1861a.c(i2, i3, iArr, iArr2, i4);
    }

    public final int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    public final int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public final int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void computeScroll() {
        /*
            r15 = this;
            android.widget.OverScroller r0 = r15.f1860a
            boolean r0 = r0.isFinished()
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            android.widget.OverScroller r0 = r15.f1860a
            r0.computeScrollOffset()
            android.widget.OverScroller r0 = r15.f1860a
            int r0 = r0.getCurrY()
            int r1 = r15.i
            int r1 = r0 - r1
            int r2 = r15.getHeight()
            android.widget.EdgeEffect r3 = r15.f1866b
            android.widget.EdgeEffect r4 = r15.f1859a
            r5 = 1056964608(0x3f000000, float:0.5)
            r6 = 0
            r7 = 1082130432(0x40800000, float:4.0)
            if (r1 <= 0) goto L_0x0046
            float r8 = defpackage.C0168da.a(r4)
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0046
            int r6 = -r1
            float r6 = (float) r6
            float r6 = r6 * r7
            float r8 = (float) r2
            float r6 = r6 / r8
            int r2 = -r2
            float r2 = (float) r2
            float r2 = r2 / r7
            float r5 = defpackage.C0168da.b(r4, r6, r5)
            float r5 = r5 * r2
            int r2 = java.lang.Math.round(r5)
            if (r2 == r1) goto L_0x0063
            r4.finish()
            goto L_0x0063
        L_0x0046:
            if (r1 >= 0) goto L_0x0064
            float r8 = defpackage.C0168da.a(r3)
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0064
            float r6 = (float) r1
            float r6 = r6 * r7
            float r2 = (float) r2
            float r6 = r6 / r2
            float r2 = r2 / r7
            float r5 = defpackage.C0168da.b(r3, r6, r5)
            float r5 = r5 * r2
            int r2 = java.lang.Math.round(r5)
            if (r2 == r1) goto L_0x0063
            r3.finish()
        L_0x0063:
            int r1 = r1 - r2
        L_0x0064:
            r15.i = r0
            int[] r0 = r15.f1868b
            r2 = 1
            r13 = 0
            r0[r2] = r13
            r6 = 0
            r9 = 0
            r10 = 1
            r5 = r15
            r7 = r1
            r8 = r0
            r5.c(r6, r7, r8, r9, r10)
            r5 = r0[r2]
            int r1 = r1 - r5
            int r14 = r15.getScrollRange()
            if (r1 == 0) goto L_0x00a1
            int r5 = r15.getScrollY()
            int r6 = r15.getScrollX()
            r15.k(r1, r6, r5, r14)
            int r6 = r15.getScrollY()
            int r7 = r6 - r5
            int r1 = r1 - r7
            r0[r2] = r13
            int[] r10 = r15.f1865a
            r11 = 1
            r6 = 0
            r8 = 0
            androidx.core.view.NestedScrollingChildHelper r5 = r15.f1861a
            r9 = r1
            r12 = r0
            r5.e(r6, r7, r8, r9, r10, r11, r12)
            r0 = r0[r2]
            int r1 = r1 - r0
        L_0x00a1:
            if (r1 == 0) goto L_0x00db
            int r0 = r15.getOverScrollMode()
            if (r0 == 0) goto L_0x00ad
            if (r0 != r2) goto L_0x00ae
            if (r14 <= 0) goto L_0x00ae
        L_0x00ad:
            r13 = r2
        L_0x00ae:
            if (r13 == 0) goto L_0x00d3
            if (r1 >= 0) goto L_0x00c3
            boolean r0 = r4.isFinished()
            if (r0 == 0) goto L_0x00d3
            android.widget.OverScroller r0 = r15.f1860a
            float r0 = r0.getCurrVelocity()
            int r0 = (int) r0
            r4.onAbsorb(r0)
            goto L_0x00d3
        L_0x00c3:
            boolean r0 = r3.isFinished()
            if (r0 == 0) goto L_0x00d3
            android.widget.OverScroller r0 = r15.f1860a
            float r0 = r0.getCurrVelocity()
            int r0 = (int) r0
            r3.onAbsorb(r0)
        L_0x00d3:
            android.widget.OverScroller r0 = r15.f1860a
            r0.abortAnimation()
            r15.s(r2)
        L_0x00db:
            android.widget.OverScroller r0 = r15.f1860a
            boolean r0 = r0.isFinished()
            if (r0 != 0) goto L_0x00e7
            r15.postInvalidateOnAnimation()
            goto L_0x00ea
        L_0x00e7:
            r15.s(r2)
        L_0x00ea:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.computeScroll():void");
    }

    public final int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public final int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public final int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > max) {
            return bottom + (scrollY - max);
        }
        return bottom;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean d(android.view.KeyEvent r6) {
        /*
            r5 = this;
            android.graphics.Rect r0 = r5.f1856a
            r0.setEmpty()
            int r0 = r5.getChildCount()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0033
            android.view.View r0 = r5.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            android.widget.FrameLayout$LayoutParams r3 = (android.widget.FrameLayout.LayoutParams) r3
            int r0 = r0.getHeight()
            int r4 = r3.topMargin
            int r0 = r0 + r4
            int r3 = r3.bottomMargin
            int r0 = r0 + r3
            int r3 = r5.getHeight()
            int r4 = r5.getPaddingTop()
            int r3 = r3 - r4
            int r4 = r5.getPaddingBottom()
            int r3 = r3 - r4
            if (r0 <= r3) goto L_0x0033
            r0 = r1
            goto L_0x0034
        L_0x0033:
            r0 = r2
        L_0x0034:
            r3 = 130(0x82, float:1.82E-43)
            if (r0 != 0) goto L_0x0062
            boolean r0 = r5.isFocused()
            if (r0 == 0) goto L_0x0061
            int r6 = r6.getKeyCode()
            r0 = 4
            if (r6 == r0) goto L_0x0061
            android.view.View r6 = r5.findFocus()
            if (r6 != r5) goto L_0x004c
            r6 = 0
        L_0x004c:
            android.view.FocusFinder r0 = android.view.FocusFinder.getInstance()
            android.view.View r6 = r0.findNextFocus(r5, r6, r3)
            if (r6 == 0) goto L_0x005f
            if (r6 == r5) goto L_0x005f
            boolean r6 = r6.requestFocus(r3)
            if (r6 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r1 = r2
        L_0x0060:
            return r1
        L_0x0061:
            return r2
        L_0x0062:
            int r0 = r6.getAction()
            if (r0 != 0) goto L_0x00c7
            int r0 = r6.getKeyCode()
            r1 = 19
            r4 = 33
            if (r0 == r1) goto L_0x00b8
            r1 = 20
            if (r0 == r1) goto L_0x00a8
            r1 = 62
            if (r0 == r1) goto L_0x009d
            r6 = 92
            if (r0 == r6) goto L_0x0098
            r6 = 93
            if (r0 == r6) goto L_0x0093
            r6 = 122(0x7a, float:1.71E-43)
            if (r0 == r6) goto L_0x008f
            r6 = 123(0x7b, float:1.72E-43)
            if (r0 == r6) goto L_0x008b
            goto L_0x00c7
        L_0x008b:
            r5.l(r3)
            goto L_0x00c7
        L_0x008f:
            r5.l(r4)
            goto L_0x00c7
        L_0x0093:
            boolean r2 = r5.f(r3)
            goto L_0x00c7
        L_0x0098:
            boolean r2 = r5.f(r4)
            goto L_0x00c7
        L_0x009d:
            boolean r6 = r6.isShiftPressed()
            if (r6 == 0) goto L_0x00a4
            r3 = r4
        L_0x00a4:
            r5.l(r3)
            goto L_0x00c7
        L_0x00a8:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto L_0x00b3
            boolean r2 = r5.f(r3)
            goto L_0x00c7
        L_0x00b3:
            boolean r2 = r5.a(r3)
            goto L_0x00c7
        L_0x00b8:
            boolean r6 = r6.isAltPressed()
            if (r6 == 0) goto L_0x00c3
            boolean r2 = r5.f(r4)
            goto L_0x00c7
        L_0x00c3:
            boolean r2 = r5.a(r4)
        L_0x00c7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.d(android.view.KeyEvent):boolean");
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent) || d(keyEvent)) {
            return true;
        }
        return false;
    }

    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f1861a.a(f2, f3, z);
    }

    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f1861a.b(f2, f3);
    }

    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return c(i2, i3, iArr, iArr2, 0);
    }

    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f1861a.e(i2, i3, i4, i5, iArr, 0, (int[]) null);
    }

    public final void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        int scrollY = getScrollY();
        EdgeEffect edgeEffect = this.f1859a;
        int i3 = 0;
        if (!edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingRight() + getPaddingLeft();
                i2 = getPaddingLeft() + 0;
            } else {
                i2 = 0;
            }
            if (b.a(this)) {
                height -= getPaddingBottom() + getPaddingTop();
                min += getPaddingTop();
            }
            canvas.translate((float) i2, (float) min);
            edgeEffect.setSize(width, height);
            if (edgeEffect.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect2 = this.f1866b;
        if (!edgeEffect2.isFinished()) {
            int save2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int max = Math.max(getScrollRange(), scrollY) + height2;
            if (b.a(this)) {
                width2 -= getPaddingRight() + getPaddingLeft();
                i3 = 0 + getPaddingLeft();
            }
            if (b.a(this)) {
                height2 -= getPaddingBottom() + getPaddingTop();
                max -= getPaddingBottom();
            }
            canvas.translate((float) (i3 - width2), (float) max);
            canvas.rotate(180.0f, (float) width2, 0.0f);
            edgeEffect2.setSize(width2, height2);
            if (edgeEffect2.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save2);
        }
    }

    public final void e(int i2) {
        if (getChildCount() > 0) {
            this.f1860a.fling(getScrollX(), getScrollY(), 0, i2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            q(2, 1);
            this.i = getScrollY();
            postInvalidateOnAnimation();
        }
    }

    public final boolean f(int i2) {
        boolean z;
        int childCount;
        if (i2 == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        Rect rect = this.f1856a;
        rect.top = 0;
        rect.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            rect.bottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            rect.top = rect.bottom - height;
        }
        return m(i2, rect.top, rect.bottom);
    }

    public float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (((float) getHeight()) * 0.5f);
    }

    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.f1862a;
        return nestedScrollingParentHelper.b | nestedScrollingParentHelper.a;
    }

    public int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    public float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public float getVerticalScrollFactorCompat() {
        if (this.b == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.b = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.b;
    }

    public final boolean h(View view, int i2, int i3) {
        Rect rect = this.f1856a;
        view.getDrawingRect(rect);
        offsetDescendantRectToMyCoords(view, rect);
        if (rect.bottom + i2 < getScrollY() || rect.top - i2 > getScrollY() + i3) {
            return false;
        }
        return true;
    }

    public final boolean hasNestedScrollingParent() {
        return this.f1861a.g(0);
    }

    public final void i(int i2, int i3, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i2);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f1861a.d(scrollY2, i2 - scrollY2, i3, iArr);
    }

    public final boolean isNestedScrollingEnabled() {
        return this.f1861a.f1800a;
    }

    public final void j(MotionEvent motionEvent) {
        int i2;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.g) {
            if (actionIndex == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.f1869c = (int) motionEvent.getY(i2);
            this.g = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f1857a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean k(int i2, int i3, int i4, int i5) {
        boolean z;
        boolean z2;
        int overScrollMode = getOverScrollMode();
        computeHorizontalScrollRange();
        computeHorizontalScrollExtent();
        computeVerticalScrollRange();
        computeVerticalScrollExtent();
        int i6 = i3 + 0;
        int i7 = i4 + i2;
        int i8 = i5 + 0;
        if (i6 <= 0 && i6 >= 0) {
            z = false;
        } else {
            i6 = 0;
            z = true;
        }
        if (i7 > i8) {
            i7 = i8;
        } else if (i7 < 0) {
            i7 = 0;
        } else {
            z2 = false;
            if (z2 && !this.f1861a.g(1)) {
                this.f1860a.springBack(i6, i7, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i6, i7, z, z2);
            if (z && !z2) {
                return false;
            }
        }
        z2 = true;
        this.f1860a.springBack(i6, i7, 0, 0, 0, getScrollRange());
        onOverScrolled(i6, i7, z, z2);
        return z ? true : true;
    }

    public final void l(int i2) {
        boolean z;
        if (i2 == 130) {
            z = true;
        } else {
            z = false;
        }
        int height = getHeight();
        Rect rect = this.f1856a;
        if (z) {
            rect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int paddingBottom = getPaddingBottom() + childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
                if (rect.top + height > paddingBottom) {
                    rect.top = paddingBottom - height;
                }
            }
        } else {
            int scrollY = getScrollY() - height;
            rect.top = scrollY;
            if (scrollY < 0) {
                rect.top = 0;
            }
        }
        int i3 = rect.top;
        int i4 = height + i3;
        rect.bottom = i4;
        m(i2, i3, i4);
    }

    public final boolean m(int i2, int i3, int i4) {
        boolean z;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        int height = getHeight();
        int scrollY = getScrollY();
        int i9 = height + scrollY;
        if (i6 == 33) {
            z = true;
        } else {
            z = false;
        }
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z5 = false;
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = focusables.get(i10);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i7 < bottom && top < i8) {
                if (i7 >= top || bottom >= i8) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (view == null) {
                    view = view2;
                    z5 = z3;
                } else {
                    if ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) {
                        z4 = false;
                    } else {
                        z4 = true;
                    }
                    if (z5) {
                        if (z3) {
                            if (!z4) {
                            }
                        }
                    } else if (z3) {
                        view = view2;
                        z5 = true;
                    } else if (!z4) {
                    }
                    view = view2;
                }
            }
        }
        if (view == null) {
            view = this;
        }
        if (i7 < scrollY || i8 > i9) {
            if (z) {
                i5 = i7 - scrollY;
            } else {
                i5 = i8 - i9;
            }
            n(i5, 0, 1, true);
            z2 = true;
        } else {
            z2 = false;
        }
        if (view != findFocus()) {
            view.requestFocus(i6);
        }
        return z2;
    }

    public final void measureChild(View view, int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft(), layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    public final void measureChildWithMargins(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public final int n(int i2, int i3, int i4, boolean z) {
        int i5;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        VelocityTracker velocityTracker;
        int i7 = i3;
        int i8 = i4;
        if (i8 == 1) {
            q(2, i8);
        }
        boolean c2 = c(0, i2, this.f1868b, this.f1865a, i4);
        int[] iArr = this.f1868b;
        int[] iArr2 = this.f1865a;
        if (c2) {
            i6 = i2 - iArr[1];
            i5 = iArr2[1] + 0;
        } else {
            i6 = i2;
            i5 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || z) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!k(i6, 0, scrollY, scrollRange) || this.f1861a.g(i8)) {
            z4 = false;
        } else {
            z4 = true;
        }
        int scrollY2 = getScrollY() - scrollY;
        iArr[1] = 0;
        int i9 = scrollRange;
        this.f1861a.e(0, scrollY2, 0, i6 - scrollY2, this.f1865a, i4, iArr);
        int i10 = i5 + iArr2[1];
        int i11 = i6 - iArr[1];
        int i12 = scrollY + i11;
        EdgeEffect edgeEffect = this.f1866b;
        EdgeEffect edgeEffect2 = this.f1859a;
        if (i12 < 0) {
            if (z3) {
                C0168da.b(edgeEffect2, ((float) (-i11)) / ((float) getHeight()), ((float) i7) / ((float) getWidth()));
                if (!edgeEffect.isFinished()) {
                    edgeEffect.onRelease();
                }
            }
        } else if (i12 > i9 && z3) {
            C0168da.b(edgeEffect, ((float) i11) / ((float) getHeight()), 1.0f - (((float) i7) / ((float) getWidth())));
            if (!edgeEffect2.isFinished()) {
                edgeEffect2.onRelease();
            }
        }
        if (!edgeEffect2.isFinished() || !edgeEffect.isFinished()) {
            postInvalidateOnAnimation();
            z5 = false;
        } else {
            z5 = z4;
        }
        int i13 = i4;
        if (z5 && i13 == 0 && (velocityTracker = this.f1857a) != null) {
            velocityTracker.clear();
        }
        if (i13 == 1) {
            s(i13);
            edgeEffect2.onRelease();
            edgeEffect.onRelease();
        }
        return i10;
    }

    public final boolean o(EdgeEffect edgeEffect, int i2) {
        if (i2 > 0) {
            return true;
        }
        float a2 = C0168da.a(edgeEffect) * ((float) getHeight());
        float f2 = this.f1853a * 0.015f;
        double log = Math.log((double) ((((float) Math.abs(-i2)) * 0.35f) / f2));
        double d2 = (double) c;
        if (((float) (Math.exp((d2 / (d2 - 1.0d)) * log) * ((double) f2))) < a2) {
            return true;
        }
        return false;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1867b = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e3, code lost:
        if (r5 >= 0) goto L_0x00bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0135, code lost:
        if (r4 >= 0) goto L_0x0101;
     */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02c5  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r29) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            int r2 = r29.getAction()
            r3 = 8
            if (r2 != r3) goto L_0x0370
            boolean r2 = r0.f1870c
            if (r2 != 0) goto L_0x0370
            int r2 = r29.getSource()
            r3 = 2
            r2 = r2 & r3
            r5 = 1
            if (r2 != r3) goto L_0x001b
            r2 = r5
            goto L_0x001c
        L_0x001b:
            r2 = 0
        L_0x001c:
            r6 = 4194304(0x400000, float:5.877472E-39)
            r7 = 26
            r8 = 0
            if (r2 == 0) goto L_0x002f
            r2 = 9
            float r9 = r1.getAxisValue(r2)
            float r10 = r29.getX()
            int r10 = (int) r10
            goto L_0x004a
        L_0x002f:
            int r2 = r29.getSource()
            r2 = r2 & r6
            if (r2 != r6) goto L_0x0038
            r2 = r5
            goto L_0x0039
        L_0x0038:
            r2 = 0
        L_0x0039:
            if (r2 == 0) goto L_0x0047
            float r9 = r1.getAxisValue(r7)
            int r2 = r28.getWidth()
            int r10 = r2 / 2
            r2 = r7
            goto L_0x004a
        L_0x0047:
            r9 = r8
            r2 = 0
            r10 = 0
        L_0x004a:
            int r11 = (r9 > r8 ? 1 : (r9 == r8 ? 0 : -1))
            if (r11 == 0) goto L_0x0370
            float r11 = r28.getVerticalScrollFactorCompat()
            float r11 = r11 * r9
            int r9 = (int) r11
            int r11 = r29.getSource()
            r12 = 8194(0x2002, float:1.1482E-41)
            r11 = r11 & r12
            if (r11 != r12) goto L_0x005f
            r11 = r5
            goto L_0x0060
        L_0x005f:
            r11 = 0
        L_0x0060:
            int r9 = -r9
            r0.n(r9, r10, r5, r11)
            if (r2 == 0) goto L_0x036e
            a9 r9 = r0.f1855a
            r9.getClass()
            int r10 = r29.getSource()
            int r11 = r29.getDeviceId()
            int r12 = r9.b
            r14 = 34
            int[] r3 = r9.f795a
            if (r12 != r10) goto L_0x0087
            int r12 = r9.c
            if (r12 != r11) goto L_0x0087
            int r12 = r9.f789a
            if (r12 == r2) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            r4 = 0
            goto L_0x0150
        L_0x0087:
            a9$b r12 = r9.f791a
            Z8 r12 = (defpackage.Z8) r12
            r12.getClass()
            android.content.Context r12 = r9.f792a
            android.view.ViewConfiguration r8 = android.view.ViewConfiguration.get(r12)
            int r13 = r29.getDeviceId()
            int r5 = r29.getSource()
            int r15 = android.os.Build.VERSION.SDK_INT
            java.lang.String r4 = "android"
            java.lang.String r7 = "dimen"
            if (r15 < r14) goto L_0x00a9
            int r5 = defpackage.C0294pC.b(r8, r13, r2, r5)
            goto L_0x00bd
        L_0x00a9:
            android.view.InputDevice r13 = android.view.InputDevice.getDevice(r13)
            if (r13 == 0) goto L_0x00b7
            android.view.InputDevice$MotionRange r13 = r13.getMotionRange(r2, r5)
            if (r13 == 0) goto L_0x00b7
            r13 = 1
            goto L_0x00b8
        L_0x00b7:
            r13 = 0
        L_0x00b8:
            if (r13 != 0) goto L_0x00bf
        L_0x00ba:
            r5 = 2147483647(0x7fffffff, float:NaN)
        L_0x00bd:
            r6 = 0
            goto L_0x00ef
        L_0x00bf:
            android.content.res.Resources r13 = r12.getResources()
            if (r5 != r6) goto L_0x00d0
            r5 = 26
            if (r2 != r5) goto L_0x00d0
            java.lang.String r5 = "config_viewMinRotaryEncoderFlingVelocity"
            int r5 = r13.getIdentifier(r5, r7, r4)
            goto L_0x00d1
        L_0x00d0:
            r5 = -1
        L_0x00d1:
            java.util.Objects.requireNonNull(r8)
            lC r6 = new lC
            r14 = 0
            r6.<init>(r8, r14)
            r14 = -1
            if (r5 == r14) goto L_0x00e6
            if (r5 == 0) goto L_0x00ba
            int r5 = r13.getDimensionPixelSize(r5)
            if (r5 >= 0) goto L_0x00bd
            goto L_0x00ba
        L_0x00e6:
            java.lang.Integer r5 = r6.a()
            int r5 = r5.intValue()
            goto L_0x00bd
        L_0x00ef:
            r3[r6] = r5
            int r5 = r29.getDeviceId()
            int r6 = r29.getSource()
            r13 = 34
            if (r15 < r13) goto L_0x0103
            int r4 = defpackage.C0294pC.a(r8, r5, r2, r6)
        L_0x0101:
            r5 = 1
            goto L_0x0147
        L_0x0103:
            android.view.InputDevice r5 = android.view.InputDevice.getDevice(r5)
            if (r5 == 0) goto L_0x0111
            android.view.InputDevice$MotionRange r5 = r5.getMotionRange(r2, r6)
            if (r5 == 0) goto L_0x0111
            r5 = 1
            goto L_0x0112
        L_0x0111:
            r5 = 0
        L_0x0112:
            if (r5 != 0) goto L_0x0115
            goto L_0x0137
        L_0x0115:
            android.content.res.Resources r5 = r12.getResources()
            r12 = 4194304(0x400000, float:5.877472E-39)
            if (r6 != r12) goto L_0x0128
            r6 = 26
            if (r2 != r6) goto L_0x0128
            java.lang.String r6 = "config_viewMaxRotaryEncoderFlingVelocity"
            int r4 = r5.getIdentifier(r6, r7, r4)
            goto L_0x0129
        L_0x0128:
            r4 = -1
        L_0x0129:
            java.util.Objects.requireNonNull(r8)
            r6 = -1
            if (r4 == r6) goto L_0x013a
            if (r4 == 0) goto L_0x0137
            int r4 = r5.getDimensionPixelSize(r4)
            if (r4 >= 0) goto L_0x0101
        L_0x0137:
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0101
        L_0x013a:
            int r4 = r8.getScaledMaximumFlingVelocity()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            int r4 = r4.intValue()
            goto L_0x0101
        L_0x0147:
            r3[r5] = r4
            r9.b = r10
            r9.c = r11
            r9.f789a = r2
            r4 = 1
        L_0x0150:
            r5 = 0
            r6 = r3[r5]
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r6 != r5) goto L_0x0164
            android.view.VelocityTracker r1 = r9.f793a
            if (r1 == 0) goto L_0x036c
            r1.recycle()
            r1 = 0
            r9.f793a = r1
            goto L_0x036c
        L_0x0164:
            android.view.VelocityTracker r5 = r9.f793a
            if (r5 != 0) goto L_0x016e
            android.view.VelocityTracker r5 = android.view.VelocityTracker.obtain()
            r9.f793a = r5
        L_0x016e:
            android.view.VelocityTracker r5 = r9.f793a
            a9$a r6 = r9.f790a
            d r6 = (defpackage.C1058d) r6
            r6.getClass()
            java.util.Map<android.view.VelocityTracker, dC> r6 = defpackage.C0156cC.a
            r5.addMovement(r1)
            int r6 = android.os.Build.VERSION.SDK_INT
            r7 = 20
            r8 = 34
            if (r6 < r8) goto L_0x0185
            goto L_0x01de
        L_0x0185:
            int r6 = r29.getSource()
            r8 = 4194304(0x400000, float:5.877472E-39)
            if (r6 != r8) goto L_0x01de
            java.util.Map<android.view.VelocityTracker, dC> r6 = defpackage.C0156cC.a
            boolean r8 = r6.containsKey(r5)
            if (r8 != 0) goto L_0x019d
            dC r8 = new dC
            r8.<init>()
            r6.put(r5, r8)
        L_0x019d:
            java.lang.Object r6 = r6.get(r5)
            dC r6 = (defpackage.C0166dC) r6
            r6.getClass()
            long r10 = r29.getEventTime()
            int r8 = r6.f2863a
            long[] r12 = r6.f2865a
            if (r8 == 0) goto L_0x01c2
            int r8 = r6.b
            r13 = r12[r8]
            long r13 = r10 - r13
            r22 = 40
            int r8 = (r13 > r22 ? 1 : (r13 == r22 ? 0 : -1))
            if (r8 <= 0) goto L_0x01c2
            r8 = 0
            r6.f2863a = r8
            r8 = 0
            r6.a = r8
        L_0x01c2:
            int r8 = r6.b
            r13 = 1
            int r8 = r8 + r13
            int r8 = r8 % r7
            r6.b = r8
            int r14 = r6.f2863a
            if (r14 == r7) goto L_0x01d0
            int r14 = r14 + r13
            r6.f2863a = r14
        L_0x01d0:
            r13 = 26
            float r1 = r1.getAxisValue(r13)
            float[] r13 = r6.f2864a
            r13[r8] = r1
            int r1 = r6.b
            r12[r1] = r10
        L_0x01de:
            r1 = 1000(0x3e8, float:1.401E-42)
            r6 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r5.computeCurrentVelocity(r1, r6)
            java.util.Map<android.view.VelocityTracker, dC> r8 = defpackage.C0156cC.a
            java.lang.Object r8 = r8.get(r5)
            dC r8 = (defpackage.C0166dC) r8
            if (r8 == 0) goto L_0x02de
            int r10 = r8.f2863a
            r11 = 2
            if (r10 >= r11) goto L_0x01f6
            goto L_0x0229
        L_0x01f6:
            int r11 = r8.b
            int r12 = r11 + 20
            r13 = 1
            int r10 = r10 - r13
            int r12 = r12 - r10
            int r12 = r12 % r7
            long[] r10 = r8.f2865a
            r13 = r10[r11]
        L_0x0202:
            r22 = r10[r12]
            long r24 = r13 - r22
            r26 = 100
            int r11 = (r24 > r26 ? 1 : (r24 == r26 ? 0 : -1))
            if (r11 <= 0) goto L_0x0216
            int r11 = r8.f2863a
            r15 = -1
            int r11 = r11 + r15
            r8.f2863a = r11
            int r12 = r12 + 1
            int r12 = r12 % r7
            goto L_0x0202
        L_0x0216:
            int r11 = r8.f2863a
            r13 = 2
            if (r11 >= r13) goto L_0x021c
            goto L_0x0229
        L_0x021c:
            float[] r14 = r8.f2864a
            if (r11 != r13) goto L_0x023b
            r11 = 1
            int r12 = r12 + r11
            int r12 = r12 % r7
            r15 = r10[r12]
            int r7 = (r22 > r15 ? 1 : (r22 == r15 ? 0 : -1))
            if (r7 != 0) goto L_0x022f
        L_0x0229:
            r25 = r2
            r2 = r1
            r1 = 0
            goto L_0x02b5
        L_0x022f:
            r7 = r14[r12]
            long r10 = r15 - r22
            float r10 = (float) r10
            float r7 = r7 / r10
            r25 = r2
            r2 = r1
            r1 = r7
            goto L_0x02b5
        L_0x023b:
            r11 = 0
            r13 = 0
            r15 = 0
        L_0x023e:
            int r6 = r8.f2863a
            r16 = -1
            int r6 = r6 + -1
            r18 = 1073741824(0x40000000, float:2.0)
            r20 = -1082130432(0xffffffffbf800000, float:-1.0)
            r21 = 1065353216(0x3f800000, float:1.0)
            if (r13 >= r6) goto L_0x029b
            int r6 = r13 + r12
            int r22 = r6 % 20
            r22 = r10[r22]
            r19 = 1
            int r6 = r6 + 1
            int r6 = r6 % r7
            r24 = r10[r6]
            int r24 = (r24 > r22 ? 1 : (r24 == r22 ? 0 : -1))
            if (r24 != 0) goto L_0x0260
            r25 = r2
            goto L_0x0292
        L_0x0260:
            int r15 = r15 + 1
            r17 = 0
            int r24 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r24 >= 0) goto L_0x0269
            goto L_0x026b
        L_0x0269:
            r20 = r21
        L_0x026b:
            float r21 = java.lang.Math.abs(r11)
            float r7 = r21 * r18
            r25 = r2
            double r1 = (double) r7
            double r1 = java.lang.Math.sqrt(r1)
            float r1 = (float) r1
            float r20 = r20 * r1
            r1 = r14[r6]
            r6 = r10[r6]
            long r6 = r6 - r22
            float r2 = (float) r6
            float r1 = r1 / r2
            float r2 = r1 - r20
            float r1 = java.lang.Math.abs(r1)
            float r1 = r1 * r2
            float r1 = r1 + r11
            r2 = 1
            if (r15 != r2) goto L_0x0291
            r2 = 1056964608(0x3f000000, float:0.5)
            float r1 = r1 * r2
        L_0x0291:
            r11 = r1
        L_0x0292:
            int r13 = r13 + 1
            r2 = r25
            r1 = 1000(0x3e8, float:1.401E-42)
            r7 = 20
            goto L_0x023e
        L_0x029b:
            r25 = r2
            r1 = 0
            int r2 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r2 >= 0) goto L_0x02a3
            goto L_0x02a5
        L_0x02a3:
            r20 = r21
        L_0x02a5:
            float r1 = java.lang.Math.abs(r11)
            float r1 = r1 * r18
            double r1 = (double) r1
            double r1 = java.lang.Math.sqrt(r1)
            float r1 = (float) r1
            float r1 = r1 * r20
            r2 = 1000(0x3e8, float:1.401E-42)
        L_0x02b5:
            float r2 = (float) r2
            float r1 = r1 * r2
            r8.a = r1
            r2 = 2139095039(0x7f7fffff, float:3.4028235E38)
            float r6 = java.lang.Math.abs(r2)
            float r6 = -r6
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x02cd
            float r1 = java.lang.Math.abs(r2)
            float r1 = -r1
            r8.a = r1
            goto L_0x02e0
        L_0x02cd:
            float r1 = r8.a
            float r6 = java.lang.Math.abs(r2)
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x02e0
            float r1 = java.lang.Math.abs(r2)
            r8.a = r1
            goto L_0x02e0
        L_0x02de:
            r25 = r2
        L_0x02e0:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            if (r1 < r2) goto L_0x02ed
            r2 = r25
            float r1 = defpackage.C0156cC.a.a(r5, r2)
            goto L_0x0311
        L_0x02ed:
            r2 = r25
            if (r2 != 0) goto L_0x02f6
            float r1 = r5.getXVelocity()
            goto L_0x0311
        L_0x02f6:
            r1 = 1
            if (r2 != r1) goto L_0x02fe
            float r1 = r5.getYVelocity()
            goto L_0x0311
        L_0x02fe:
            java.util.Map<android.view.VelocityTracker, dC> r1 = defpackage.C0156cC.a
            java.lang.Object r1 = r1.get(r5)
            dC r1 = (defpackage.C0166dC) r1
            if (r1 == 0) goto L_0x0310
            r5 = 26
            if (r2 == r5) goto L_0x030d
            goto L_0x0310
        L_0x030d:
            float r1 = r1.a
            goto L_0x0311
        L_0x0310:
            r1 = 0
        L_0x0311:
            b9 r2 = r9.f794a
            androidx.core.widget.NestedScrollView$c r2 = (androidx.core.widget.NestedScrollView.c) r2
            androidx.core.widget.NestedScrollView r5 = androidx.core.widget.NestedScrollView.this
            float r5 = r5.getVerticalScrollFactorCompat()
            float r5 = -r5
            float r1 = r1 * r5
            float r5 = java.lang.Math.signum(r1)
            androidx.core.widget.NestedScrollView r2 = androidx.core.widget.NestedScrollView.this
            if (r4 != 0) goto L_0x0334
            float r4 = r9.a
            float r4 = java.lang.Math.signum(r4)
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0339
            r4 = 0
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0339
        L_0x0334:
            android.widget.OverScroller r4 = r2.f1860a
            r4.abortAnimation()
        L_0x0339:
            float r4 = java.lang.Math.abs(r1)
            r5 = 0
            r6 = r3[r5]
            float r5 = (float) r6
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0346
            goto L_0x036c
        L_0x0346:
            r4 = 1
            r3 = r3[r4]
            int r4 = -r3
            float r4 = (float) r4
            float r3 = (float) r3
            float r1 = java.lang.Math.min(r1, r3)
            float r1 = java.lang.Math.max(r4, r1)
            r3 = 0
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 != 0) goto L_0x035b
            r4 = 0
            goto L_0x0365
        L_0x035b:
            android.widget.OverScroller r4 = r2.f1860a
            r4.abortAnimation()
            int r4 = (int) r1
            r2.e(r4)
            r4 = 1
        L_0x0365:
            if (r4 == 0) goto L_0x0369
            r8 = r1
            goto L_0x036a
        L_0x0369:
            r8 = r3
        L_0x036a:
            r9.a = r8
        L_0x036c:
            r1 = 1
            goto L_0x036f
        L_0x036e:
            r1 = r5
        L_0x036f:
            return r1
        L_0x0370:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getAction()
            r1 = 1
            r2 = 2
            if (r0 != r2) goto L_0x000d
            boolean r3 = r12.f1870c
            if (r3 == 0) goto L_0x000d
            return r1
        L_0x000d:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r3 = 0
            r4 = 0
            if (r0 == 0) goto L_0x0097
            r5 = -1
            if (r0 == r1) goto L_0x006b
            if (r0 == r2) goto L_0x0025
            r1 = 3
            if (r0 == r1) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0020
            goto L_0x011f
        L_0x0020:
            r12.j(r13)
            goto L_0x011f
        L_0x0025:
            int r0 = r12.g
            if (r0 != r5) goto L_0x002b
            goto L_0x011f
        L_0x002b:
            int r0 = r13.findPointerIndex(r0)
            if (r0 != r5) goto L_0x0033
            goto L_0x011f
        L_0x0033:
            float r0 = r13.getY(r0)
            int r0 = (int) r0
            int r3 = r12.f1869c
            int r3 = r0 - r3
            int r3 = java.lang.Math.abs(r3)
            int r5 = r12.d
            if (r3 <= r5) goto L_0x011f
            int r3 = r12.getNestedScrollAxes()
            r2 = r2 & r3
            if (r2 != 0) goto L_0x011f
            r12.f1870c = r1
            r12.f1869c = r0
            android.view.VelocityTracker r0 = r12.f1857a
            if (r0 != 0) goto L_0x0059
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r12.f1857a = r0
        L_0x0059:
            android.view.VelocityTracker r0 = r12.f1857a
            r0.addMovement(r13)
            r12.h = r4
            android.view.ViewParent r13 = r12.getParent()
            if (r13 == 0) goto L_0x011f
            r13.requestDisallowInterceptTouchEvent(r1)
            goto L_0x011f
        L_0x006b:
            r12.f1870c = r4
            r12.g = r5
            android.view.VelocityTracker r13 = r12.f1857a
            if (r13 == 0) goto L_0x0078
            r13.recycle()
            r12.f1857a = r3
        L_0x0078:
            android.widget.OverScroller r5 = r12.f1860a
            int r6 = r12.getScrollX()
            int r7 = r12.getScrollY()
            r8 = 0
            r9 = 0
            r10 = 0
            int r11 = r12.getScrollRange()
            boolean r13 = r5.springBack(r6, r7, r8, r9, r10, r11)
            if (r13 == 0) goto L_0x0092
            r12.postInvalidateOnAnimation()
        L_0x0092:
            r12.s(r4)
            goto L_0x011f
        L_0x0097:
            float r0 = r13.getY()
            int r0 = (int) r0
            float r5 = r13.getX()
            int r5 = (int) r5
            int r6 = r12.getChildCount()
            if (r6 <= 0) goto L_0x00cb
            int r6 = r12.getScrollY()
            android.view.View r7 = r12.getChildAt(r4)
            int r8 = r7.getTop()
            int r8 = r8 - r6
            if (r0 < r8) goto L_0x00cb
            int r8 = r7.getBottom()
            int r8 = r8 - r6
            if (r0 >= r8) goto L_0x00cb
            int r6 = r7.getLeft()
            if (r5 < r6) goto L_0x00cb
            int r6 = r7.getRight()
            if (r5 >= r6) goto L_0x00cb
            r5 = r1
            goto L_0x00cc
        L_0x00cb:
            r5 = r4
        L_0x00cc:
            if (r5 != 0) goto L_0x00ea
            boolean r13 = r12.r(r13)
            if (r13 != 0) goto L_0x00de
            android.widget.OverScroller r13 = r12.f1860a
            boolean r13 = r13.isFinished()
            if (r13 != 0) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r1 = r4
        L_0x00de:
            r12.f1870c = r1
            android.view.VelocityTracker r13 = r12.f1857a
            if (r13 == 0) goto L_0x011f
            r13.recycle()
            r12.f1857a = r3
            goto L_0x011f
        L_0x00ea:
            r12.f1869c = r0
            int r0 = r13.getPointerId(r4)
            r12.g = r0
            android.view.VelocityTracker r0 = r12.f1857a
            if (r0 != 0) goto L_0x00fd
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r12.f1857a = r0
            goto L_0x0100
        L_0x00fd:
            r0.clear()
        L_0x0100:
            android.view.VelocityTracker r0 = r12.f1857a
            r0.addMovement(r13)
            android.widget.OverScroller r0 = r12.f1860a
            r0.computeScrollOffset()
            boolean r13 = r12.r(r13)
            if (r13 != 0) goto L_0x011a
            android.widget.OverScroller r13 = r12.f1860a
            boolean r13 = r13.isFinished()
            if (r13 != 0) goto L_0x0119
            goto L_0x011a
        L_0x0119:
            r1 = r4
        L_0x011a:
            r12.f1870c = r1
            r12.q(r2, r4)
        L_0x011f:
            boolean r13 = r12.f1870c
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        super.onLayout(z, i2, i3, i4, i5);
        int i7 = 0;
        this.f1864a = false;
        View view = this.f1858a;
        if (view != null && g(view, this)) {
            View view2 = this.f1858a;
            Rect rect = this.f1856a;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int b2 = b(rect);
            if (b2 != 0) {
                scrollBy(0, b2);
            }
        }
        this.f1858a = null;
        if (!this.f1867b) {
            if (this.f1863a != null) {
                scrollTo(getScrollX(), this.f1863a.c);
                this.f1863a = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i6 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            } else {
                i6 = 0;
            }
            int paddingTop = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            if (paddingTop < i6 && scrollY >= 0) {
                i7 = paddingTop + scrollY > i6 ? i6 - paddingTop : scrollY;
            }
            if (i7 != scrollY) {
                scrollTo(getScrollX(), i7);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1867b = true;
    }

    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1871d && View.MeasureSpec.getMode(i3) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, Ints.MAX_POWER_OF_TWO));
            }
        }
    }

    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        if (z) {
            return false;
        }
        dispatchNestedFling(0.0f, f3, true);
        e((int) f3);
        return true;
    }

    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr, int i4) {
        c(i2, i3, iArr, (int[]) null, i4);
    }

    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        i(i5, i6, iArr);
    }

    public final void onNestedScrollAccepted(View view, View view2, int i2, int i3) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.f1862a;
        if (i3 == 1) {
            nestedScrollingParentHelper.b = i2;
        } else {
            nestedScrollingParentHelper.a = i2;
        }
        q(2, i3);
    }

    public final void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        super.scrollTo(i2, i3);
    }

    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        View view;
        if (i2 == 2) {
            i2 = 130;
        } else if (i2 == 1) {
            i2 = 33;
        }
        if (rect == null) {
            view = FocusFinder.getInstance().findNextFocus(this, (View) null, i2);
        } else {
            view = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i2);
        }
        if (view != null && !(true ^ h(view, 0, getHeight()))) {
            return view.requestFocus(i2, rect);
        }
        return false;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f1863a = savedState;
        requestLayout();
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = getScrollY();
        return savedState;
    }

    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
    }

    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && h(findFocus, 0, i5)) {
            Rect rect = this.f1856a;
            findFocus.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(findFocus, rect);
            int b2 = b(rect);
            if (b2 == 0) {
                return;
            }
            if (this.f1872e) {
                p(0, b2, false);
            } else {
                scrollBy(0, b2);
            }
        }
    }

    public final boolean onStartNestedScroll(View view, View view2, int i2, int i3) {
        return (i2 & 2) != 0;
    }

    public final void onStopNestedScroll(View view, int i2) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.f1862a;
        if (i2 == 1) {
            nestedScrollingParentHelper.b = 0;
        } else {
            nestedScrollingParentHelper.a = 0;
        }
        s(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            android.view.VelocityTracker r2 = r0.f1857a
            if (r2 != 0) goto L_0x000e
            android.view.VelocityTracker r2 = android.view.VelocityTracker.obtain()
            r0.f1857a = r2
        L_0x000e:
            int r2 = r20.getActionMasked()
            r3 = 0
            if (r2 != 0) goto L_0x0017
            r0.h = r3
        L_0x0017:
            android.view.MotionEvent r4 = android.view.MotionEvent.obtain(r20)
            int r5 = r0.h
            float r5 = (float) r5
            r6 = 0
            r4.offsetLocation(r6, r5)
            r5 = 1
            r7 = 2
            if (r2 == 0) goto L_0x01cb
            r8 = 0
            r9 = -1
            android.widget.EdgeEffect r10 = r0.f1859a
            android.widget.EdgeEffect r11 = r0.f1866b
            if (r2 == r5) goto L_0x013e
            if (r2 == r7) goto L_0x009e
            r6 = 3
            if (r2 == r6) goto L_0x0060
            r3 = 5
            if (r2 == r3) goto L_0x004d
            r3 = 6
            if (r2 == r3) goto L_0x003b
            goto L_0x01ff
        L_0x003b:
            r19.j(r20)
            int r2 = r0.g
            int r2 = r1.findPointerIndex(r2)
            float r1 = r1.getY(r2)
            int r1 = (int) r1
            r0.f1869c = r1
            goto L_0x01ff
        L_0x004d:
            int r2 = r20.getActionIndex()
            float r3 = r1.getY(r2)
            int r3 = (int) r3
            r0.f1869c = r3
            int r1 = r1.getPointerId(r2)
            r0.g = r1
            goto L_0x01ff
        L_0x0060:
            boolean r1 = r0.f1870c
            if (r1 == 0) goto L_0x0086
            int r1 = r19.getChildCount()
            if (r1 <= 0) goto L_0x0086
            android.widget.OverScroller r12 = r0.f1860a
            int r13 = r19.getScrollX()
            int r14 = r19.getScrollY()
            r15 = 0
            r16 = 0
            r17 = 0
            int r18 = r19.getScrollRange()
            boolean r1 = r12.springBack(r13, r14, r15, r16, r17, r18)
            if (r1 == 0) goto L_0x0086
            r19.postInvalidateOnAnimation()
        L_0x0086:
            r0.g = r9
            r0.f1870c = r3
            android.view.VelocityTracker r1 = r0.f1857a
            if (r1 == 0) goto L_0x0093
            r1.recycle()
            r0.f1857a = r8
        L_0x0093:
            r0.s(r3)
            r10.onRelease()
            r11.onRelease()
            goto L_0x01ff
        L_0x009e:
            int r2 = r0.g
            int r2 = r1.findPointerIndex(r2)
            if (r2 != r9) goto L_0x00a8
            goto L_0x01ff
        L_0x00a8:
            float r7 = r1.getY(r2)
            int r7 = (int) r7
            int r8 = r0.f1869c
            int r8 = r8 - r7
            float r9 = r1.getX(r2)
            int r12 = r19.getWidth()
            float r12 = (float) r12
            float r9 = r9 / r12
            float r12 = (float) r8
            int r13 = r19.getHeight()
            float r13 = (float) r13
            float r12 = r12 / r13
            float r13 = defpackage.C0168da.a(r10)
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 == 0) goto L_0x00dc
            float r11 = -r12
            float r9 = defpackage.C0168da.b(r10, r11, r9)
            float r9 = -r9
            float r11 = defpackage.C0168da.a(r10)
            int r6 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x00da
            r10.onRelease()
        L_0x00da:
            r6 = r9
            goto L_0x00f7
        L_0x00dc:
            float r10 = defpackage.C0168da.a(r11)
            int r10 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r10 == 0) goto L_0x00f7
            r10 = 1065353216(0x3f800000, float:1.0)
            float r10 = r10 - r9
            float r9 = defpackage.C0168da.b(r11, r12, r10)
            float r10 = defpackage.C0168da.a(r11)
            int r6 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x00da
            r11.onRelease()
            goto L_0x00da
        L_0x00f7:
            int r9 = r19.getHeight()
            float r9 = (float) r9
            float r6 = r6 * r9
            int r6 = java.lang.Math.round(r6)
            if (r6 == 0) goto L_0x0106
            r19.invalidate()
        L_0x0106:
            int r8 = r8 - r6
            boolean r6 = r0.f1870c
            if (r6 != 0) goto L_0x0127
            int r6 = java.lang.Math.abs(r8)
            int r9 = r0.d
            if (r6 <= r9) goto L_0x0127
            android.view.ViewParent r6 = r19.getParent()
            if (r6 == 0) goto L_0x011c
            r6.requestDisallowInterceptTouchEvent(r5)
        L_0x011c:
            r0.f1870c = r5
            if (r8 <= 0) goto L_0x0124
            int r6 = r0.d
            int r8 = r8 - r6
            goto L_0x0127
        L_0x0124:
            int r6 = r0.d
            int r8 = r8 + r6
        L_0x0127:
            boolean r6 = r0.f1870c
            if (r6 == 0) goto L_0x01ff
            float r1 = r1.getX(r2)
            int r1 = (int) r1
            int r1 = r0.n(r8, r1, r3, r3)
            int r7 = r7 - r1
            r0.f1869c = r7
            int r2 = r0.h
            int r2 = r2 + r1
            r0.h = r2
            goto L_0x01ff
        L_0x013e:
            android.view.VelocityTracker r1 = r0.f1857a
            int r2 = r0.f
            float r2 = (float) r2
            r7 = 1000(0x3e8, float:1.401E-42)
            r1.computeCurrentVelocity(r7, r2)
            int r2 = r0.g
            float r1 = r1.getYVelocity(r2)
            int r1 = (int) r1
            int r2 = java.lang.Math.abs(r1)
            int r7 = r0.e
            if (r2 < r7) goto L_0x0198
            float r2 = defpackage.C0168da.a(r10)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x016e
            boolean r2 = r0.o(r10, r1)
            if (r2 == 0) goto L_0x0169
            r10.onAbsorb(r1)
            goto L_0x0184
        L_0x0169:
            int r2 = -r1
            r0.e(r2)
            goto L_0x0184
        L_0x016e:
            float r2 = defpackage.C0168da.a(r11)
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0186
            int r2 = -r1
            boolean r7 = r0.o(r11, r2)
            if (r7 == 0) goto L_0x0181
            r11.onAbsorb(r2)
            goto L_0x0184
        L_0x0181:
            r0.e(r2)
        L_0x0184:
            r2 = r5
            goto L_0x0187
        L_0x0186:
            r2 = r3
        L_0x0187:
            if (r2 != 0) goto L_0x01b4
            int r1 = -r1
            float r2 = (float) r1
            boolean r7 = r0.dispatchNestedPreFling(r6, r2)
            if (r7 != 0) goto L_0x01b4
            r0.dispatchNestedFling(r6, r2, r5)
            r0.e(r1)
            goto L_0x01b4
        L_0x0198:
            android.widget.OverScroller r12 = r0.f1860a
            int r13 = r19.getScrollX()
            int r14 = r19.getScrollY()
            r15 = 0
            r16 = 0
            r17 = 0
            int r18 = r19.getScrollRange()
            boolean r1 = r12.springBack(r13, r14, r15, r16, r17, r18)
            if (r1 == 0) goto L_0x01b4
            r19.postInvalidateOnAnimation()
        L_0x01b4:
            r0.g = r9
            r0.f1870c = r3
            android.view.VelocityTracker r1 = r0.f1857a
            if (r1 == 0) goto L_0x01c1
            r1.recycle()
            r0.f1857a = r8
        L_0x01c1:
            r0.s(r3)
            r10.onRelease()
            r11.onRelease()
            goto L_0x01ff
        L_0x01cb:
            int r2 = r19.getChildCount()
            if (r2 != 0) goto L_0x01d2
            return r3
        L_0x01d2:
            boolean r2 = r0.f1870c
            if (r2 == 0) goto L_0x01df
            android.view.ViewParent r2 = r19.getParent()
            if (r2 == 0) goto L_0x01df
            r2.requestDisallowInterceptTouchEvent(r5)
        L_0x01df:
            android.widget.OverScroller r2 = r0.f1860a
            boolean r2 = r2.isFinished()
            if (r2 != 0) goto L_0x01ef
            android.widget.OverScroller r2 = r0.f1860a
            r2.abortAnimation()
            r0.s(r5)
        L_0x01ef:
            float r2 = r20.getY()
            int r2 = (int) r2
            int r1 = r1.getPointerId(r3)
            r0.f1869c = r2
            r0.g = r1
            r0.q(r7, r3)
        L_0x01ff:
            android.view.VelocityTracker r1 = r0.f1857a
            if (r1 == 0) goto L_0x0206
            r1.addMovement(r4)
        L_0x0206:
            r4.recycle()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(int i2, int i3, boolean z) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1854a > 250) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int scrollY = getScrollY();
                OverScroller overScroller = this.f1860a;
                int scrollX = getScrollX();
                overScroller.startScroll(scrollX, scrollY, 0, Math.max(0, Math.min(i3 + scrollY, Math.max(0, height - height2))) - scrollY, 250);
                if (z) {
                    q(2, 1);
                } else {
                    s(1);
                }
                this.i = getScrollY();
                postInvalidateOnAnimation();
            } else {
                if (!this.f1860a.isFinished()) {
                    this.f1860a.abortAnimation();
                    s(1);
                }
                scrollBy(i2, i3);
            }
            this.f1854a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final boolean q(int i2, int i3) {
        return this.f1861a.h(i2, i3);
    }

    public final boolean r(MotionEvent motionEvent) {
        boolean z;
        EdgeEffect edgeEffect = this.f1859a;
        if (C0168da.a(edgeEffect) != 0.0f) {
            C0168da.b(edgeEffect, 0.0f, motionEvent.getX() / ((float) getWidth()));
            z = true;
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.f1866b;
        if (C0168da.a(edgeEffect2) == 0.0f) {
            return z;
        }
        C0168da.b(edgeEffect2, 0.0f, 1.0f - (motionEvent.getX() / ((float) getWidth())));
        return true;
    }

    public final void requestChildFocus(View view, View view2) {
        if (!this.f1864a) {
            Rect rect = this.f1856a;
            view2.getDrawingRect(rect);
            offsetDescendantRectToMyCoords(view2, rect);
            int b2 = b(rect);
            if (b2 != 0) {
                scrollBy(0, b2);
            }
        } else {
            this.f1858a = view2;
        }
        super.requestChildFocus(view, view2);
    }

    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        boolean z2;
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        int b2 = b(rect);
        if (b2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (z) {
                scrollBy(0, b2);
            } else {
                p(0, b2, false);
            }
        }
        return z2;
    }

    public final void requestDisallowInterceptTouchEvent(boolean z) {
        VelocityTracker velocityTracker;
        if (z && (velocityTracker = this.f1857a) != null) {
            velocityTracker.recycle();
            this.f1857a = null;
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public final void requestLayout() {
        this.f1864a = true;
        super.requestLayout();
    }

    public final void s(int i2) {
        this.f1861a.i(i2);
    }

    public final void scrollTo(int i2, int i3) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (width >= width2 || i2 < 0) {
                i2 = 0;
            } else if (width + i2 > width2) {
                i2 = width2 - width;
            }
            if (height >= height2 || i3 < 0) {
                i3 = 0;
            } else if (height + i3 > height2) {
                i3 = height2 - height;
            }
            if (i2 != getScrollX() || i3 != getScrollY()) {
                super.scrollTo(i2, i3);
            }
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1871d) {
            this.f1871d = z;
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.f1861a;
        if (nestedScrollingChildHelper.f1800a) {
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            f.d.z(nestedScrollingChildHelper.a);
        }
        nestedScrollingChildHelper.f1800a = z;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1872e = z;
    }

    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    public final boolean startNestedScroll(int i2) {
        return q(i2, 0);
    }

    public final void stopNestedScroll() {
        s(0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, dr.nestedScrollViewStyle);
    }

    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        onNestedPreScroll(view, i2, i3, iArr, 0);
    }

    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5, int i6) {
        i(i5, i6, (int[]) null);
    }

    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return onStartNestedScroll(view, view2, i2, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        EdgeEffect edgeEffect;
        EdgeEffect edgeEffect2;
        this.f1856a = new Rect();
        this.f1864a = true;
        this.f1867b = false;
        this.f1858a = null;
        this.f1870c = false;
        this.f1872e = true;
        this.g = -1;
        this.f1865a = new int[2];
        this.f1868b = new int[2];
        this.f1855a = new C0114a9(getContext(), new c());
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            edgeEffect = C0168da.b.a(context, attributeSet);
        } else {
            edgeEffect = new EdgeEffect(context);
        }
        this.f1859a = edgeEffect;
        if (i3 >= 31) {
            edgeEffect2 = C0168da.b.a(context, attributeSet);
        } else {
            edgeEffect2 = new EdgeEffect(context);
        }
        this.f1866b = edgeEffect2;
        this.f1853a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        this.f1860a = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.d = viewConfiguration.getScaledTouchSlop();
        this.e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f = viewConfiguration.getScaledMaximumFlingVelocity();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1852c, i2, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1862a = new NestedScrollingParentHelper();
        this.f1861a = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        f.o(this, a);
    }

    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        i(i5, 0, (int[]) null);
    }

    public final void addView(View view, int i2) {
        if (getChildCount() <= 0) {
            super.addView(view, i2);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        onNestedScrollAccepted(view, view2, i2, 0);
    }

    public final void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i2, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public void setOnScrollChangeListener(d dVar) {
    }
}
