package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.f;
import com.google.common.primitives.Ints;
import com.google.firebase.perf.util.Constants;
import defpackage.d7;
import defpackage.l5;
import java.util.WeakHashMap;

public class SwipeRefreshLayout extends ViewGroup implements C0356um {
    public static final int[] c = {16842766};
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public Qy f2432a;

    /* renamed from: a  reason: collision with other field name */
    public Ry f2433a;

    /* renamed from: a  reason: collision with other field name */
    public Sy f2434a;

    /* renamed from: a  reason: collision with other field name */
    public Ty f2435a;

    /* renamed from: a  reason: collision with other field name */
    public View f2436a;

    /* renamed from: a  reason: collision with other field name */
    public final DecelerateInterpolator f2437a;

    /* renamed from: a  reason: collision with other field name */
    public final NestedScrollingChildHelper f2438a;

    /* renamed from: a  reason: collision with other field name */
    public final NestedScrollingParentHelper f2439a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2440a;

    /* renamed from: a  reason: collision with other field name */
    public final c f2441a;

    /* renamed from: a  reason: collision with other field name */
    public final d f2442a;

    /* renamed from: a  reason: collision with other field name */
    public f f2443a;

    /* renamed from: a  reason: collision with other field name */
    public g5 f2444a;

    /* renamed from: a  reason: collision with other field name */
    public l5 f2445a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f2446a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f2447a;
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public Sy f2448b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2449b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f2450b;

    /* renamed from: c  reason: collision with other field name */
    public float f2451c;

    /* renamed from: c  reason: collision with other field name */
    public final int f2452c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2453c;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public final int f2454d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f2455d;
    public float e;

    /* renamed from: e  reason: collision with other field name */
    public int f2456e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f2457e;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f2458f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    public class c extends Animation {
        public c() {
        }

        public final void applyTransformation(float f, Transformation transformation) {
            int i;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f2458f) {
                i = swipeRefreshLayout.j - Math.abs(swipeRefreshLayout.i);
            } else {
                i = swipeRefreshLayout.j;
            }
            int i2 = swipeRefreshLayout.h;
            swipeRefreshLayout.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (i - i2)) * f))) - swipeRefreshLayout.f2444a.getTop());
            l5 l5Var = swipeRefreshLayout.f2445a;
            float f2 = 1.0f - f;
            l5.a aVar = l5Var.f3060a;
            if (f2 != aVar.h) {
                aVar.h = f2;
            }
            l5Var.invalidateSelf();
        }
    }

    public class d extends Animation {
        public d() {
        }

        public final void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.e(f);
        }
    }

    public interface e {
    }

    public interface f {
        void a();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setColorViewAlpha(int i2) {
        this.f2444a.getBackground().setAlpha(i2);
        this.f2445a.setAlpha(i2);
    }

    public final boolean a() {
        View view = this.f2436a;
        if (view instanceof ListView) {
            return ((ListView) view).canScrollList(-1);
        }
        return view.canScrollVertically(-1);
    }

    public final void b() {
        if (this.f2436a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.f2444a)) {
                    this.f2436a = childAt;
                    return;
                }
            }
        }
    }

    public final void c(float f2) {
        b bVar;
        if (f2 > this.a) {
            g(true, true);
            return;
        }
        this.f2446a = false;
        l5 l5Var = this.f2445a;
        l5.a aVar = l5Var.f3060a;
        aVar.a = 0.0f;
        aVar.b = 0.0f;
        l5Var.invalidateSelf();
        boolean z = this.f2455d;
        if (!z) {
            bVar = new b();
        } else {
            bVar = null;
        }
        int i2 = this.f2456e;
        if (z) {
            this.h = i2;
            this.e = this.f2444a.getScaleX();
            Ty ty = new Ty(this);
            this.f2435a = ty;
            ty.setDuration(150);
            if (bVar != null) {
                this.f2444a.a = bVar;
            }
            this.f2444a.clearAnimation();
            this.f2444a.startAnimation(this.f2435a);
        } else {
            this.h = i2;
            d dVar = this.f2442a;
            dVar.reset();
            dVar.setDuration(200);
            dVar.setInterpolator(this.f2437a);
            if (bVar != null) {
                this.f2444a.a = bVar;
            }
            this.f2444a.clearAnimation();
            this.f2444a.startAnimation(dVar);
        }
        l5 l5Var2 = this.f2445a;
        l5.a aVar2 = l5Var2.f3060a;
        if (aVar2.f3066a) {
            aVar2.f3066a = false;
        }
        l5Var2.invalidateSelf();
    }

    public final void d(float f2) {
        l5 l5Var = this.f2445a;
        l5.a aVar = l5Var.f3060a;
        boolean z = true;
        if (!aVar.f3066a) {
            aVar.f3066a = true;
        }
        l5Var.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f2 / this.a));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f2) - this.a;
        int i2 = this.k;
        if (i2 <= 0) {
            if (this.f2458f) {
                i2 = this.j - this.i;
            } else {
                i2 = this.j;
            }
        }
        float f3 = (float) i2;
        double max2 = (double) (Math.max(0.0f, Math.min(abs, f3 * 2.0f) / f3) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i3 = this.i + ((int) ((f3 * min) + (f3 * pow * 2.0f)));
        if (this.f2444a.getVisibility() != 0) {
            this.f2444a.setVisibility(0);
        }
        if (!this.f2455d) {
            this.f2444a.setScaleX(1.0f);
            this.f2444a.setScaleY(1.0f);
        }
        if (this.f2455d) {
            setAnimationProgress(Math.min(1.0f, f2 / this.a));
        }
        if (f2 < this.a) {
            if (this.f2445a.f3060a.f3072d > 76) {
                Sy sy = this.f2434a;
                if (sy == null || !sy.hasStarted() || sy.hasEnded()) {
                    z = false;
                }
                if (!z) {
                    Sy sy2 = new Sy(this, this.f2445a.f3060a.f3072d, 76);
                    sy2.setDuration(300);
                    g5 g5Var = this.f2444a;
                    g5Var.a = null;
                    g5Var.clearAnimation();
                    this.f2444a.startAnimation(sy2);
                    this.f2434a = sy2;
                }
            }
        } else if (this.f2445a.f3060a.f3072d < 255) {
            Sy sy3 = this.f2448b;
            if (sy3 == null || !sy3.hasStarted() || sy3.hasEnded()) {
                z = false;
            }
            if (!z) {
                Sy sy4 = new Sy(this, this.f2445a.f3060a.f3072d, Constants.MAX_HOST_LENGTH);
                sy4.setDuration(300);
                g5 g5Var2 = this.f2444a;
                g5Var2.a = null;
                g5Var2.clearAnimation();
                this.f2444a.startAnimation(sy4);
                this.f2448b = sy4;
            }
        }
        l5 l5Var2 = this.f2445a;
        float min2 = Math.min(0.8f, max * 0.8f);
        l5.a aVar2 = l5Var2.f3060a;
        aVar2.a = 0.0f;
        aVar2.b = min2;
        l5Var2.invalidateSelf();
        l5 l5Var3 = this.f2445a;
        float min3 = Math.min(1.0f, max);
        l5.a aVar3 = l5Var3.f3060a;
        if (min3 != aVar3.h) {
            aVar3.h = min3;
        }
        l5Var3.invalidateSelf();
        l5 l5Var4 = this.f2445a;
        l5Var4.f3060a.c = ((pow * 2.0f) + ((max * 0.4f) - 16.0f)) * 0.5f;
        l5Var4.invalidateSelf();
        setTargetOffsetTopAndBottom(i3 - this.f2456e);
    }

    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f2438a.a(f2, f3, z);
    }

    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f2438a.b(f2, f3);
    }

    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f2438a.c(i2, i3, iArr, iArr2, 0);
    }

    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f2438a.e(i2, i3, i4, i5, iArr, 0, (int[]) null);
    }

    public final void e(float f2) {
        int i2 = this.h;
        setTargetOffsetTopAndBottom((i2 + ((int) (((float) (this.i - i2)) * f2))) - this.f2444a.getTop());
    }

    public final void f() {
        this.f2444a.clearAnimation();
        this.f2445a.stop();
        this.f2444a.setVisibility(8);
        setColorViewAlpha(Constants.MAX_HOST_LENGTH);
        if (this.f2455d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.i - this.f2456e);
        }
        this.f2456e = this.f2444a.getTop();
    }

    public final void g(boolean z, boolean z2) {
        if (this.f2446a != z) {
            this.f2457e = z2;
            b();
            this.f2446a = z;
            a aVar = this.f2440a;
            if (z) {
                this.h = this.f2456e;
                c cVar = this.f2441a;
                cVar.reset();
                cVar.setDuration(200);
                cVar.setInterpolator(this.f2437a);
                if (aVar != null) {
                    this.f2444a.a = aVar;
                }
                this.f2444a.clearAnimation();
                this.f2444a.startAnimation(cVar);
                return;
            }
            Ry ry = new Ry(this);
            this.f2433a = ry;
            ry.setDuration(150);
            g5 g5Var = this.f2444a;
            g5Var.a = aVar;
            g5Var.clearAnimation();
            this.f2444a.startAnimation(this.f2433a);
        }
    }

    public final int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.g;
        if (i4 < 0) {
            return i3;
        }
        if (i3 == i2 - 1) {
            return i4;
        }
        if (i3 >= i4) {
            return i3 + 1;
        }
        return i3;
    }

    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.f2439a;
        return nestedScrollingParentHelper.b | nestedScrollingParentHelper.a;
    }

    public int getProgressCircleDiameter() {
        return this.l;
    }

    public int getProgressViewEndOffset() {
        return this.j;
    }

    public int getProgressViewStartOffset() {
        return this.i;
    }

    public final void h(float f2) {
        float f3 = this.d;
        int i2 = this.f2452c;
        if (f2 - f3 > ((float) i2) && !this.f2453c) {
            this.f2451c = f3 + ((float) i2);
            this.f2453c = true;
            this.f2445a.setAlpha(76);
        }
    }

    public final boolean hasNestedScrollingParent() {
        return this.f2438a.g(0);
    }

    public final boolean isNestedScrollingEnabled() {
        return this.f2438a.f1800a;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        b();
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 0;
        if (!isEnabled() || a() || this.f2446a || this.f2449b) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i3 = this.f;
                    if (i3 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i3)) < 0) {
                        return false;
                    }
                    h(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.f) {
                            if (actionIndex == 0) {
                                i2 = 1;
                            }
                            this.f = motionEvent.getPointerId(i2);
                        }
                    }
                }
            }
            this.f2453c = false;
            this.f = -1;
        } else {
            setTargetOffsetTopAndBottom(this.i - this.f2444a.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.f = pointerId;
            this.f2453c = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.d = motionEvent.getY(findPointerIndex2);
        }
        return this.f2453c;
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f2436a == null) {
                b();
            }
            View view = this.f2436a;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f2444a.getMeasuredWidth();
                int measuredHeight2 = this.f2444a.getMeasuredHeight();
                int i6 = measuredWidth / 2;
                int i7 = measuredWidth2 / 2;
                int i8 = this.f2456e;
                this.f2444a.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
            }
        }
    }

    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f2436a == null) {
            b();
        }
        View view = this.f2436a;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), Ints.MAX_POWER_OF_TWO));
            this.f2444a.measure(View.MeasureSpec.makeMeasureSpec(this.l, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(this.l, Ints.MAX_POWER_OF_TWO));
            this.g = -1;
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                if (getChildAt(i4) == this.f2444a) {
                    this.g = i4;
                    return;
                }
            }
        }
    }

    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.b;
            if (f2 > 0.0f) {
                float f3 = (float) i3;
                if (f3 > f2) {
                    iArr[1] = i3 - ((int) f2);
                    this.b = 0.0f;
                } else {
                    this.b = f2 - f3;
                    iArr[1] = i3;
                }
                d(this.b);
            }
        }
        if (this.f2458f && i3 > 0 && this.b == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.f2444a.setVisibility(8);
        }
        int[] iArr2 = this.f2447a;
        if (dispatchNestedPreScroll(i2 - iArr[0], i3 - iArr[1], iArr2, (int[]) null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        dispatchNestedScroll(i2, i3, i4, i5, this.f2450b);
        int i6 = i5 + this.f2450b[1];
        if (i6 < 0 && !a()) {
            float abs = this.b + ((float) Math.abs(i6));
            this.b = abs;
            d(abs);
        }
    }

    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f2439a.a = i2;
        startNestedScroll(i2 & 2);
        this.b = 0.0f;
        this.f2449b = true;
    }

    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        if (!isEnabled() || this.f2446a || (i2 & 2) == 0) {
            return false;
        }
        return true;
    }

    public final void onStopNestedScroll(View view) {
        this.f2439a.a = 0;
        this.f2449b = false;
        float f2 = this.b;
        if (f2 > 0.0f) {
            c(f2);
            this.b = 0.0f;
        }
        stopNestedScroll();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int i2 = 0;
        if (!isEnabled() || a() || this.f2446a || this.f2449b) {
            return false;
        }
        if (actionMasked == 0) {
            this.f = motionEvent.getPointerId(0);
            this.f2453c = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f);
            if (findPointerIndex < 0) {
                return false;
            }
            if (this.f2453c) {
                this.f2453c = false;
                c((motionEvent.getY(findPointerIndex) - this.f2451c) * 0.5f);
            }
            this.f = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.f);
            if (findPointerIndex2 < 0) {
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            h(y);
            if (this.f2453c) {
                float f2 = (y - this.f2451c) * 0.5f;
                if (f2 <= 0.0f) {
                    return false;
                }
                d(f2);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    return false;
                }
                this.f = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                int actionIndex2 = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(actionIndex2) == this.f) {
                    if (actionIndex2 == 0) {
                        i2 = 1;
                    }
                    this.f = motionEvent.getPointerId(i2);
                }
            }
        }
        return true;
    }

    public final void requestDisallowInterceptTouchEvent(boolean z) {
        View view = this.f2436a;
        if (view != null) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            if (!f.d.p(view)) {
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void setAnimationProgress(float f2) {
        this.f2444a.setScaleX(f2);
        this.f2444a.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        b();
        l5 l5Var = this.f2445a;
        l5.a aVar = l5Var.f3060a;
        aVar.f3067a = iArr;
        aVar.a(0);
        aVar.a(0);
        l5Var.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            Object obj = d7.a;
            iArr2[i2] = d7.b.a(context, i3);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.a = (float) i2;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            f();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.f2438a;
        if (nestedScrollingChildHelper.f1800a) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            f.d.z(nestedScrollingChildHelper.a);
        }
        nestedScrollingChildHelper.f1800a = z;
    }

    public void setOnRefreshListener(f fVar) {
        this.f2443a = fVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(int i2) {
        this.f2444a.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(int i2) {
        Context context = getContext();
        Object obj = d7.a;
        setProgressBackgroundColorSchemeColor(d7.b.a(context, i2));
    }

    public void setProgressViewEndTarget(boolean z, int i2) {
        this.j = i2;
        this.f2455d = z;
        this.f2444a.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i2, int i3) {
        this.f2455d = z;
        this.i = i2;
        this.j = i3;
        this.f2458f = true;
        f();
        this.f2446a = false;
    }

    public void setRefreshing(boolean z) {
        int i2;
        if (!z || this.f2446a == z) {
            g(z, false);
            return;
        }
        this.f2446a = z;
        if (!this.f2458f) {
            i2 = this.j + this.i;
        } else {
            i2 = this.j;
        }
        setTargetOffsetTopAndBottom(i2 - this.f2456e);
        this.f2457e = false;
        this.f2444a.setVisibility(0);
        this.f2445a.setAlpha(Constants.MAX_HOST_LENGTH);
        Qy qy = new Qy(this);
        this.f2432a = qy;
        qy.setDuration((long) this.f2454d);
        a aVar = this.f2440a;
        if (aVar != null) {
            this.f2444a.a = aVar;
        }
        this.f2444a.clearAnimation();
        this.f2444a.startAnimation(this.f2432a);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.l = (int) (displayMetrics.density * 56.0f);
            } else {
                this.l = (int) (displayMetrics.density * 40.0f);
            }
            this.f2444a.setImageDrawable((Drawable) null);
            this.f2445a.c(i2);
            this.f2444a.setImageDrawable(this.f2445a);
        }
    }

    public void setSlingshotDistance(int i2) {
        this.k = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        this.f2444a.bringToFront();
        g5 g5Var = this.f2444a;
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        g5Var.offsetTopAndBottom(i2);
        this.f2456e = this.f2444a.getTop();
    }

    public final boolean startNestedScroll(int i2) {
        return this.f2438a.h(i2, 0);
    }

    public final void stopNestedScroll() {
        this.f2438a.i(0);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2446a = false;
        this.a = -1.0f;
        this.f2447a = new int[2];
        this.f2450b = new int[2];
        this.f = -1;
        this.g = -1;
        this.f2440a = new a();
        this.f2441a = new c();
        this.f2442a = new d();
        this.f2452c = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f2454d = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f2437a = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.l = (int) (displayMetrics.density * 40.0f);
        this.f2444a = new g5(getContext());
        l5 l5Var = new l5(getContext());
        this.f2445a = l5Var;
        l5Var.c(1);
        this.f2444a.setImageDrawable(this.f2445a);
        this.f2444a.setVisibility(8);
        addView(this.f2444a);
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.j = i2;
        this.a = (float) i2;
        this.f2439a = new NestedScrollingParentHelper();
        this.f2438a = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.l;
        this.f2456e = i3;
        this.i = i3;
        e(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    public class a implements Animation.AnimationListener {
        public a() {
        }

        public final void onAnimationEnd(Animation animation) {
            f fVar;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.f2446a) {
                swipeRefreshLayout.f2445a.setAlpha(Constants.MAX_HOST_LENGTH);
                swipeRefreshLayout.f2445a.start();
                if (swipeRefreshLayout.f2457e && (fVar = swipeRefreshLayout.f2443a) != null) {
                    fVar.a();
                }
                swipeRefreshLayout.f2456e = swipeRefreshLayout.f2444a.getTop();
                return;
            }
            swipeRefreshLayout.f();
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    public class b implements Animation.AnimationListener {
        public b() {
        }

        public final void onAnimationEnd(Animation animation) {
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.f2455d) {
                Ry ry = new Ry(swipeRefreshLayout);
                swipeRefreshLayout.f2433a = ry;
                ry.setDuration(150);
                g5 g5Var = swipeRefreshLayout.f2444a;
                g5Var.a = null;
                g5Var.clearAnimation();
                swipeRefreshLayout.f2444a.startAnimation(swipeRefreshLayout.f2433a);
            }
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    public void setOnChildScrollUpCallback(e eVar) {
    }
}
