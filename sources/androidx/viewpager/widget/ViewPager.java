package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.f;
import androidx.customview.view.AbsSavedState;
import com.google.common.primitives.Ints;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.perf.util.Constants;
import com.google.logging.type.LogSeverity;
import defpackage.d7;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.WeakHashMap;

public class ViewPager extends ViewGroup {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f2563a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final l f2564a = new l();

    /* renamed from: a  reason: collision with other field name */
    public static final int[] f2565a = {16842931};

    /* renamed from: a  reason: collision with other field name */
    public float f2566a = -3.4028235E38f;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2567a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public Drawable f2568a;

    /* renamed from: a  reason: collision with other field name */
    public Parcelable f2569a = null;

    /* renamed from: a  reason: collision with other field name */
    public VelocityTracker f2570a;

    /* renamed from: a  reason: collision with other field name */
    public EdgeEffect f2571a;

    /* renamed from: a  reason: collision with other field name */
    public Scroller f2572a;

    /* renamed from: a  reason: collision with other field name */
    public PagerAdapter f2573a;

    /* renamed from: a  reason: collision with other field name */
    public final c f2574a = new c();

    /* renamed from: a  reason: collision with other field name */
    public final f f2575a = new f();

    /* renamed from: a  reason: collision with other field name */
    public i f2576a;

    /* renamed from: a  reason: collision with other field name */
    public j f2577a;

    /* renamed from: a  reason: collision with other field name */
    public k f2578a;

    /* renamed from: a  reason: collision with other field name */
    public ClassLoader f2579a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<f> f2580a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2581a;
    public float b = Float.MAX_VALUE;

    /* renamed from: b  reason: collision with other field name */
    public EdgeEffect f2582b;

    /* renamed from: b  reason: collision with other field name */
    public i f2583b;

    /* renamed from: b  reason: collision with other field name */
    public ArrayList f2584b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2585b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f2586c;

    /* renamed from: c  reason: collision with other field name */
    public ArrayList f2587c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2588c;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f2589d;

    /* renamed from: d  reason: collision with other field name */
    public ArrayList<View> f2590d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f2591d;
    public float e;

    /* renamed from: e  reason: collision with other field name */
    public int f2592e = -1;

    /* renamed from: e  reason: collision with other field name */
    public boolean f2593e;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public int f2594f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f2595f;
    public int g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f2596g = true;
    public int h;

    /* renamed from: h  reason: collision with other field name */
    public boolean f2597h;
    public int i;
    public int j = 1;
    public int k;
    public int l;
    public int m;
    public int n = -1;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v = 0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Parcelable a;

        /* renamed from: a  reason: collision with other field name */
        public final ClassLoader f2601a;
        public int c;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            return lf.k(sb, this.c, "}");
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeParcelable(this.a, i);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.c = parcel.readInt();
            this.a = parcel.readParcelable(classLoader);
            this.f2601a = classLoader;
        }
    }

    public static class a implements Comparator<f> {
        public final int compare(Object obj, Object obj2) {
            return ((f) obj).f2603a - ((f) obj2).f2603a;
        }
    }

    public static class b implements Interpolator {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            ViewPager viewPager = ViewPager.this;
            viewPager.setScrollState(0);
            viewPager.q();
        }
    }

    public class d implements OnApplyWindowInsetsListener {
        public final Rect a = new Rect();

        public d() {
        }

        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsetsCompat j = androidx.core.view.f.j(view, windowInsetsCompat);
            if (j.f1818a.m()) {
                return j;
            }
            int c = j.c();
            Rect rect = this.a;
            rect.left = c;
            rect.top = j.e();
            rect.right = j.d();
            rect.bottom = j.b();
            ViewPager viewPager = ViewPager.this;
            int childCount = viewPager.getChildCount();
            for (int i = 0; i < childCount; i++) {
                WindowInsetsCompat b = androidx.core.view.f.b(viewPager.getChildAt(i), j);
                rect.left = Math.min(b.c(), rect.left);
                rect.top = Math.min(b.e(), rect.top);
                rect.right = Math.min(b.d(), rect.right);
                rect.bottom = Math.min(b.b(), rect.bottom);
            }
            return j.g(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface e {
    }

    public static class f {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public int f2603a;

        /* renamed from: a  reason: collision with other field name */
        public Object f2604a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2605a;
        public float b;
    }

    public class g extends AccessibilityDelegateCompat {
        public g() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
            if (r0.getCount() > 1) goto L_0x001b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onInitializeAccessibilityEvent(android.view.View r3, android.view.accessibility.AccessibilityEvent r4) {
            /*
                r2 = this;
                super.onInitializeAccessibilityEvent(r3, r4)
                java.lang.Class<androidx.viewpager.widget.ViewPager> r3 = androidx.viewpager.widget.ViewPager.class
                java.lang.String r3 = r3.getName()
                r4.setClassName(r3)
                androidx.viewpager.widget.ViewPager r3 = androidx.viewpager.widget.ViewPager.this
                androidx.viewpager.widget.PagerAdapter r0 = r3.f2573a
                if (r0 == 0) goto L_0x001a
                int r0 = r0.getCount()
                r1 = 1
                if (r0 <= r1) goto L_0x001a
                goto L_0x001b
            L_0x001a:
                r1 = 0
            L_0x001b:
                r4.setScrollable(r1)
                int r0 = r4.getEventType()
                r1 = 4096(0x1000, float:5.74E-42)
                if (r0 != r1) goto L_0x003b
                androidx.viewpager.widget.PagerAdapter r0 = r3.f2573a
                if (r0 == 0) goto L_0x003b
                int r0 = r0.getCount()
                r4.setItemCount(r0)
                int r0 = r3.f2589d
                r4.setFromIndex(r0)
                int r3 = r3.f2589d
                r4.setToIndex(r3)
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.g.onInitializeAccessibilityEvent(android.view.View, android.view.accessibility.AccessibilityEvent):void");
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            boolean z;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.j(ViewPager.class.getName());
            ViewPager viewPager = ViewPager.this;
            PagerAdapter pagerAdapter = viewPager.f2573a;
            if (pagerAdapter == null || pagerAdapter.getCount() <= 1) {
                z = false;
            } else {
                z = true;
            }
            accessibilityNodeInfoCompat.n(z);
            if (viewPager.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.a(4096);
            }
            if (viewPager.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.a(UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            ViewPager viewPager = ViewPager.this;
            if (i != 4096) {
                if (i != 8192 || !viewPager.canScrollHorizontally(-1)) {
                    return false;
                }
                viewPager.setCurrentItem(viewPager.f2589d - 1);
                return true;
            } else if (!viewPager.canScrollHorizontally(1)) {
                return false;
            } else {
                viewPager.setCurrentItem(viewPager.f2589d + 1);
                return true;
            }
        }
    }

    public interface h {
        void onAdapterChanged(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface i {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public interface j {
    }

    public class k extends DataSetObserver {
        public k() {
        }

        public final void onChanged() {
            ViewPager.this.e();
        }

        public final void onInvalidated() {
            ViewPager.this.e();
        }
    }

    public static class l implements Comparator<View> {
        public final int compare(Object obj, Object obj2) {
            LayoutParams layoutParams = (LayoutParams) ((View) obj).getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) ((View) obj2).getLayoutParams();
            boolean z = layoutParams.f2599a;
            if (z == layoutParams2.f2599a) {
                return layoutParams.b - layoutParams2.b;
            }
            if (z) {
                return 1;
            }
            return -1;
        }
    }

    public ViewPager(Context context) {
        super(context);
        k();
    }

    public static boolean c(int i2, int i3, int i4, View view, boolean z) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && c(i2, i6 - childAt.getLeft(), i5 - childAt.getTop(), childAt, true)) {
                    return true;
                }
            }
        }
        if (!z || !view.canScrollHorizontally(-i2)) {
            return false;
        }
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f2588c != z) {
            this.f2588c = z;
        }
    }

    public final f a(int i2, int i3) {
        f fVar = new f();
        fVar.f2603a = i2;
        fVar.f2604a = this.f2573a.instantiateItem((ViewGroup) this, i2);
        fVar.a = this.f2573a.getPageWidth(i2);
        ArrayList<f> arrayList = this.f2580a;
        if (i3 < 0 || i3 >= arrayList.size()) {
            arrayList.add(fVar);
        } else {
            arrayList.add(i3, fVar);
        }
        return fVar;
    }

    public final void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        f h2;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f2603a == this.f2589d) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if ((i3 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) {
            arrayList.add(this);
        }
    }

    public final void addTouchables(ArrayList<View> arrayList) {
        f h2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f2603a == this.f2589d) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        boolean z;
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z2 = layoutParams2.f2599a;
        if (view.getClass().getAnnotation(e.class) != null) {
            z = true;
        } else {
            z = false;
        }
        boolean z3 = z2 | z;
        layoutParams2.f2599a = z3;
        if (!this.f2585b) {
            super.addView(view, i2, layoutParams);
        } else if (!z3) {
            layoutParams2.f2600b = true;
            addViewInLayout(view, i2, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(int r8) {
        /*
            r7 = this;
            android.view.View r0 = r7.findFocus()
            r1 = 1
            r2 = 0
            if (r0 != r7) goto L_0x0009
            goto L_0x002f
        L_0x0009:
            if (r0 == 0) goto L_0x0030
            android.view.ViewParent r3 = r0.getParent()
        L_0x000f:
            boolean r4 = r3 instanceof android.view.ViewGroup
            if (r4 == 0) goto L_0x001c
            if (r3 != r7) goto L_0x0017
            r3 = r1
            goto L_0x001d
        L_0x0017:
            android.view.ViewParent r3 = r3.getParent()
            goto L_0x000f
        L_0x001c:
            r3 = r2
        L_0x001d:
            if (r3 != 0) goto L_0x0030
            android.view.ViewParent r0 = r0.getParent()
        L_0x0023:
            boolean r3 = r0 instanceof android.view.ViewGroup
            if (r3 == 0) goto L_0x002f
            r0.getClass()
            android.view.ViewParent r0 = r0.getParent()
            goto L_0x0023
        L_0x002f:
            r0 = 0
        L_0x0030:
            android.view.FocusFinder r3 = android.view.FocusFinder.getInstance()
            android.view.View r3 = r3.findNextFocus(r7, r0, r8)
            r4 = 66
            r5 = 17
            if (r3 == 0) goto L_0x007f
            if (r3 == r0) goto L_0x007f
            android.graphics.Rect r6 = r7.f2567a
            if (r8 != r5) goto L_0x0063
            android.graphics.Rect r4 = r7.g(r6, r3)
            int r4 = r4.left
            android.graphics.Rect r5 = r7.g(r6, r0)
            int r5 = r5.left
            if (r0 == 0) goto L_0x005d
            if (r4 < r5) goto L_0x005d
            int r0 = r7.f2589d
            if (r0 <= 0) goto L_0x0097
            int r0 = r0 - r1
            r7.setCurrentItem(r0, r1)
            goto L_0x0098
        L_0x005d:
            boolean r0 = r3.requestFocus()
        L_0x0061:
            r2 = r0
            goto L_0x0099
        L_0x0063:
            if (r8 != r4) goto L_0x0099
            android.graphics.Rect r1 = r7.g(r6, r3)
            int r1 = r1.left
            android.graphics.Rect r2 = r7.g(r6, r0)
            int r2 = r2.left
            if (r0 == 0) goto L_0x007a
            if (r1 > r2) goto L_0x007a
            boolean r0 = r7.n()
            goto L_0x0061
        L_0x007a:
            boolean r0 = r3.requestFocus()
            goto L_0x0061
        L_0x007f:
            if (r8 == r5) goto L_0x008e
            if (r8 != r1) goto L_0x0084
            goto L_0x008e
        L_0x0084:
            if (r8 == r4) goto L_0x0089
            r0 = 2
            if (r8 != r0) goto L_0x0099
        L_0x0089:
            boolean r2 = r7.n()
            goto L_0x0099
        L_0x008e:
            int r0 = r7.f2589d
            if (r0 <= 0) goto L_0x0097
            int r0 = r0 - r1
            r7.setCurrentItem(r0, r1)
            goto L_0x0098
        L_0x0097:
            r1 = r2
        L_0x0098:
            r2 = r1
        L_0x0099:
            if (r2 == 0) goto L_0x00a2
            int r8 = android.view.SoundEffectConstants.getContantForFocusDirection(r8)
            r7.playSoundEffect(r8)
        L_0x00a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.b(int):boolean");
    }

    public final boolean canScrollHorizontally(int i2) {
        if (this.f2573a == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i2 < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.f2566a))) {
                return true;
            }
            return false;
        } else if (i2 <= 0 || scrollX >= ((int) (((float) clientWidth) * this.b))) {
            return false;
        } else {
            return true;
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public final void computeScroll() {
        this.f2581a = true;
        if (this.f2572a.isFinished() || !this.f2572a.computeScrollOffset()) {
            d(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f2572a.getCurrX();
        int currY = this.f2572a.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!o(currX)) {
                this.f2572a.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        postInvalidateOnAnimation();
    }

    public final void d(boolean z) {
        boolean z2;
        if (this.v == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f2572a.isFinished()) {
                this.f2572a.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f2572a.getCurrX();
                int currY = this.f2572a.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        o(currX);
                    }
                }
            }
        }
        this.f2591d = false;
        int i2 = 0;
        while (true) {
            ArrayList<f> arrayList = this.f2580a;
            if (i2 >= arrayList.size()) {
                break;
            }
            f fVar = arrayList.get(i2);
            if (fVar.f2605a) {
                fVar.f2605a = false;
                z2 = true;
            }
            i2++;
        }
        if (z2) {
            c cVar = this.f2574a;
            if (z) {
                WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                postOnAnimation(cVar);
                return;
            }
            cVar.run();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L_0x0064
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L_0x005f
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L_0x0048
            r3 = 22
            if (r0 == r3) goto L_0x0036
            r3 = 61
            if (r0 == r3) goto L_0x0020
            goto L_0x005f
        L_0x0020:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L_0x002b
            boolean r6 = r5.b(r4)
            goto L_0x0060
        L_0x002b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L_0x005f
            boolean r6 = r5.b(r1)
            goto L_0x0060
        L_0x0036:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L_0x0041
            boolean r6 = r5.n()
            goto L_0x0060
        L_0x0041:
            r6 = 66
            boolean r6 = r5.b(r6)
            goto L_0x0060
        L_0x0048:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L_0x0058
            int r6 = r5.f2589d
            if (r6 <= 0) goto L_0x005f
            int r6 = r6 - r1
            r5.setCurrentItem(r6, r1)
            r6 = r1
            goto L_0x0060
        L_0x0058:
            r6 = 17
            boolean r6 = r5.b(r6)
            goto L_0x0060
        L_0x005f:
            r6 = r2
        L_0x0060:
            if (r6 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r1 = r2
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        f h2;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f2603a == this.f2589d && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    public final void draw(Canvas canvas) {
        PagerAdapter pagerAdapter;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean z = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (pagerAdapter = this.f2573a) != null && pagerAdapter.getCount() > 1)) {
            if (!this.f2571a.isFinished()) {
                int save = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) (getPaddingTop() + (-height)), this.f2566a * ((float) width));
                this.f2571a.setSize(height, width);
                z = false | this.f2571a.draw(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.f2582b.isFinished()) {
                int save2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.b + 1.0f)) * ((float) width2));
                this.f2582b.setSize(height2, width2);
                z |= this.f2582b.draw(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.f2571a.finish();
            this.f2582b.finish();
        }
        if (z) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            postInvalidateOnAnimation();
        }
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2568a;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public final void e() {
        boolean z;
        int count = this.f2573a.getCount();
        this.f2586c = count;
        ArrayList<f> arrayList = this.f2580a;
        if (arrayList.size() >= (this.j * 2) + 1 || arrayList.size() >= count) {
            z = false;
        } else {
            z = true;
        }
        int i2 = this.f2589d;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < arrayList.size()) {
            f fVar = arrayList.get(i3);
            int itemPosition = this.f2573a.getItemPosition(fVar.f2604a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    arrayList.remove(i3);
                    i3--;
                    if (!z2) {
                        this.f2573a.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.f2573a.destroyItem((ViewGroup) this, fVar.f2603a, fVar.f2604a);
                    int i4 = this.f2589d;
                    if (i4 == fVar.f2603a) {
                        i2 = Math.max(0, Math.min(i4, -1 + count));
                    }
                } else {
                    int i5 = fVar.f2603a;
                    if (i5 != itemPosition) {
                        if (i5 == this.f2589d) {
                            i2 = itemPosition;
                        }
                        fVar.f2603a = itemPosition;
                    }
                }
                z = true;
            }
            i3++;
        }
        if (z2) {
            this.f2573a.finishUpdate((ViewGroup) this);
        }
        Collections.sort(arrayList, a);
        if (z) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i6).getLayoutParams();
                if (!layoutParams.f2599a) {
                    layoutParams.a = 0.0f;
                }
            }
            v(i2, 0, false, true);
            requestLayout();
        }
    }

    public final void f(int i2) {
        i iVar = this.f2576a;
        if (iVar != null) {
            iVar.onPageSelected(i2);
        }
        ArrayList arrayList = this.f2584b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar2 = (i) this.f2584b.get(i3);
                if (iVar2 != null) {
                    iVar2.onPageSelected(i2);
                }
            }
        }
        i iVar3 = this.f2583b;
        if (iVar3 != null) {
            iVar3.onPageSelected(i2);
        }
    }

    public final Rect g(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public PagerAdapter getAdapter() {
        return this.f2573a;
    }

    public final int getChildDrawingOrder(int i2, int i3) {
        if (this.u == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) this.f2590d.get(i3).getLayoutParams()).c;
    }

    public int getCurrentItem() {
        return this.f2589d;
    }

    public int getOffscreenPageLimit() {
        return this.j;
    }

    public int getPageMargin() {
        return this.f2594f;
    }

    public final f h(View view) {
        int i2 = 0;
        while (true) {
            ArrayList<f> arrayList = this.f2580a;
            if (i2 >= arrayList.size()) {
                return null;
            }
            f fVar = arrayList.get(i2);
            if (this.f2573a.isViewFromObject(view, fVar.f2604a)) {
                return fVar;
            }
            i2++;
        }
    }

    public final f i() {
        float f2;
        float f3;
        f fVar;
        int i2;
        int clientWidth = getClientWidth();
        float f4 = 0.0f;
        if (clientWidth > 0) {
            f2 = ((float) getScrollX()) / ((float) clientWidth);
        } else {
            f2 = 0.0f;
        }
        if (clientWidth > 0) {
            f3 = ((float) this.f2594f) / ((float) clientWidth);
        } else {
            f3 = 0.0f;
        }
        int i3 = 0;
        boolean z = true;
        f fVar2 = null;
        int i4 = -1;
        float f5 = 0.0f;
        while (true) {
            ArrayList<f> arrayList = this.f2580a;
            if (i3 >= arrayList.size()) {
                return fVar2;
            }
            f fVar3 = arrayList.get(i3);
            if (z || fVar3.f2603a == (i2 = i4 + 1)) {
                fVar = fVar3;
            } else {
                f fVar4 = this.f2575a;
                fVar4.b = f4 + f5 + f3;
                fVar4.f2603a = i2;
                fVar4.a = this.f2573a.getPageWidth(i2);
                i3--;
                fVar = fVar4;
            }
            f4 = fVar.b;
            float f6 = fVar.a + f4 + f3;
            if (!z && f2 < f4) {
                return fVar2;
            }
            if (f2 < f6 || i3 == arrayList.size() - 1) {
                return fVar;
            }
            int i5 = fVar.f2603a;
            float f7 = fVar.a;
            i3++;
            z = false;
            f fVar5 = fVar;
            i4 = i5;
            f5 = f7;
            fVar2 = fVar5;
        }
        return fVar;
    }

    public final f j(int i2) {
        int i3 = 0;
        while (true) {
            ArrayList<f> arrayList = this.f2580a;
            if (i3 >= arrayList.size()) {
                return null;
            }
            f fVar = arrayList.get(i3);
            if (fVar.f2603a == i2) {
                return fVar;
            }
            i3++;
        }
    }

    public final void k() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f2572a = new Scroller(context, f2563a);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.m = viewConfiguration.getScaledPagingTouchSlop();
        this.o = (int) (400.0f * f2);
        this.p = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2571a = new EdgeEffect(context);
        this.f2582b = new EdgeEffect(context);
        this.q = (int) (25.0f * f2);
        this.r = (int) (2.0f * f2);
        this.k = (int) (f2 * 16.0f);
        androidx.core.view.f.o(this, new g());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        f.d.u(this, new d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.s
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L_0x006b
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L_0x001b:
            if (r7 >= r6) goto L_0x006b
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f2599a
            if (r10 != 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            int r9 = r9.f2598a
            r9 = r9 & 7
            if (r9 == r2) goto L_0x004d
            r10 = 3
            if (r9 == r10) goto L_0x0047
            r10 = 5
            if (r9 == r10) goto L_0x003a
            r9 = r3
            goto L_0x005c
        L_0x003a:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L_0x0059
        L_0x0047:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L_0x005c
        L_0x004d:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L_0x0059:
            r11 = r9
            r9 = r3
            r3 = r11
        L_0x005c:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L_0x0067
            r8.offsetLeftAndRight(r3)
        L_0x0067:
            r3 = r9
        L_0x0068:
            int r7 = r7 + 1
            goto L_0x001b
        L_0x006b:
            androidx.viewpager.widget.ViewPager$i r0 = r12.f2576a
            if (r0 == 0) goto L_0x0072
            r0.onPageScrolled(r13, r14, r15)
        L_0x0072:
            java.util.ArrayList r0 = r12.f2584b
            if (r0 == 0) goto L_0x008d
            int r0 = r0.size()
            r3 = r1
        L_0x007b:
            if (r3 >= r0) goto L_0x008d
            java.util.ArrayList r4 = r12.f2584b
            java.lang.Object r4 = r4.get(r3)
            androidx.viewpager.widget.ViewPager$i r4 = (androidx.viewpager.widget.ViewPager.i) r4
            if (r4 == 0) goto L_0x008a
            r4.onPageScrolled(r13, r14, r15)
        L_0x008a:
            int r3 = r3 + 1
            goto L_0x007b
        L_0x008d:
            androidx.viewpager.widget.ViewPager$i r0 = r12.f2583b
            if (r0 == 0) goto L_0x0094
            r0.onPageScrolled(r13, r14, r15)
        L_0x0094:
            androidx.viewpager.widget.ViewPager$j r13 = r12.f2577a
            if (r13 == 0) goto L_0x0114
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L_0x00a0:
            if (r1 >= r14) goto L_0x0114
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f2599a
            if (r0 == 0) goto L_0x00b1
            goto L_0x0111
        L_0x00b1:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$j r3 = r12.f2577a
            com.paytm.pgsdk.sdknative.PaytmSavedCardActivity$q r3 = (com.paytm.pgsdk.sdknative.PaytmSavedCardActivity.q) r3
            r3.getClass()
            int r4 = r15.getWidth()
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r6 = 0
            if (r5 >= 0) goto L_0x00d3
            r15.setAlpha(r6)
            goto L_0x010c
        L_0x00d3:
            int r5 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r5 > 0) goto L_0x00e6
            r15.setAlpha(r7)
            r15.setTranslationX(r6)
            r15.setScaleX(r7)
            r15.setScaleY(r7)
            goto L_0x010c
        L_0x00e6:
            int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r5 > 0) goto L_0x0109
            float r5 = r7 - r0
            r15.setAlpha(r5)
            float r4 = (float) r4
            float r5 = -r0
            float r4 = r4 * r5
            r15.setTranslationX(r4)
            float r4 = java.lang.Math.abs(r0)
            float r7 = r7 - r4
            r4 = 1041865112(0x3e199998, float:0.14999998)
            float r7 = r7 * r4
            r4 = 1062836634(0x3f59999a, float:0.85)
            float r7 = r7 + r4
            r15.setScaleX(r7)
            r15.setScaleY(r7)
            goto L_0x010c
        L_0x0109:
            r15.setAlpha(r6)
        L_0x010c:
            com.paytm.pgsdk.sdknative.PaytmSavedCardActivity r3 = com.paytm.pgsdk.sdknative.PaytmSavedCardActivity.this
            r3.zoomOutPagerAnimation(r15, r0)
        L_0x0111:
            int r1 = r1 + 1
            goto L_0x00a0
        L_0x0114:
            r12.f2597h = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.l(int, float, int):void");
    }

    public final void m(MotionEvent motionEvent) {
        int i2;
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.n) {
            if (actionIndex == 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            this.c = motionEvent.getX(i2);
            this.n = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.f2570a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public final boolean n() {
        PagerAdapter pagerAdapter = this.f2573a;
        if (pagerAdapter == null || this.f2589d >= pagerAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.f2589d + 1, true);
        return true;
    }

    public final boolean o(int i2) {
        if (this.f2580a.size() != 0) {
            f i3 = i();
            int clientWidth = getClientWidth();
            int i4 = this.f2594f;
            int i5 = clientWidth + i4;
            float f2 = (float) clientWidth;
            int i6 = i3.f2603a;
            float f3 = ((((float) i2) / f2) - i3.b) / (i3.a + (((float) i4) / f2));
            this.f2597h = false;
            l(i6, f3, (int) (((float) i5) * f3));
            if (this.f2597h) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f2596g) {
            return false;
        } else {
            this.f2597h = false;
            l(0, 0.0f, 0);
            if (this.f2597h) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2596g = true;
    }

    public final void onDetachedFromWindow() {
        removeCallbacks(this.f2574a);
        Scroller scroller = this.f2572a;
        if (scroller != null && !scroller.isFinished()) {
            this.f2572a.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDraw(android.graphics.Canvas r19) {
        /*
            r18 = this;
            r0 = r18
            super.onDraw(r19)
            int r1 = r0.f2594f
            if (r1 <= 0) goto L_0x00a7
            android.graphics.drawable.Drawable r1 = r0.f2568a
            if (r1 == 0) goto L_0x00a7
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r1 = r0.f2580a
            int r2 = r1.size()
            if (r2 <= 0) goto L_0x00a7
            androidx.viewpager.widget.PagerAdapter r2 = r0.f2573a
            if (r2 == 0) goto L_0x00a7
            int r2 = r18.getScrollX()
            int r3 = r18.getWidth()
            int r4 = r0.f2594f
            float r4 = (float) r4
            float r5 = (float) r3
            float r4 = r4 / r5
            r6 = 0
            java.lang.Object r7 = r1.get(r6)
            androidx.viewpager.widget.ViewPager$f r7 = (androidx.viewpager.widget.ViewPager.f) r7
            float r8 = r7.b
            int r9 = r1.size()
            int r10 = r7.f2603a
            int r11 = r9 + -1
            java.lang.Object r11 = r1.get(r11)
            androidx.viewpager.widget.ViewPager$f r11 = (androidx.viewpager.widget.ViewPager.f) r11
            int r11 = r11.f2603a
        L_0x003f:
            if (r10 >= r11) goto L_0x00a7
        L_0x0041:
            int r12 = r7.f2603a
            if (r10 <= r12) goto L_0x0050
            if (r6 >= r9) goto L_0x0050
            int r6 = r6 + 1
            java.lang.Object r7 = r1.get(r6)
            androidx.viewpager.widget.ViewPager$f r7 = (androidx.viewpager.widget.ViewPager.f) r7
            goto L_0x0041
        L_0x0050:
            if (r10 != r12) goto L_0x005c
            float r8 = r7.b
            float r12 = r7.a
            float r13 = r8 + r12
            float r13 = r13 * r5
            float r8 = r8 + r12
            float r8 = r8 + r4
            goto L_0x0068
        L_0x005c:
            androidx.viewpager.widget.PagerAdapter r12 = r0.f2573a
            float r12 = r12.getPageWidth(r10)
            float r13 = r8 + r12
            float r13 = r13 * r5
            float r12 = r12 + r4
            float r12 = r12 + r8
            r8 = r12
        L_0x0068:
            int r12 = r0.f2594f
            float r12 = (float) r12
            float r12 = r12 + r13
            float r14 = (float) r2
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x0092
            android.graphics.drawable.Drawable r12 = r0.f2568a
            int r14 = java.lang.Math.round(r13)
            int r15 = r0.g
            r16 = r1
            int r1 = r0.f2594f
            float r1 = (float) r1
            float r1 = r1 + r13
            int r1 = java.lang.Math.round(r1)
            r17 = r4
            int r4 = r0.h
            r12.setBounds(r14, r15, r1, r4)
            android.graphics.drawable.Drawable r1 = r0.f2568a
            r4 = r19
            r1.draw(r4)
            goto L_0x0098
        L_0x0092:
            r16 = r1
            r17 = r4
            r4 = r19
        L_0x0098:
            int r1 = r2 + r3
            float r1 = (float) r1
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00a0
            goto L_0x00a7
        L_0x00a0:
            int r10 = r10 + 1
            r1 = r16
            r4 = r17
            goto L_0x003f
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onDraw(android.graphics.Canvas):void");
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        float f2;
        boolean z;
        int action = motionEvent.getAction() & Constants.MAX_HOST_LENGTH;
        if (action == 3 || action == 1) {
            t();
            return false;
        }
        if (action != 0) {
            if (this.f2593e) {
                return true;
            }
            if (this.f2595f) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.e = x;
            this.c = x;
            float y = motionEvent.getY();
            this.f = y;
            this.d = y;
            this.n = motionEvent.getPointerId(0);
            this.f2595f = false;
            this.f2581a = true;
            this.f2572a.computeScrollOffset();
            if (this.v != 2 || Math.abs(this.f2572a.getFinalX() - this.f2572a.getCurrX()) <= this.r) {
                d(false);
                this.f2593e = false;
            } else {
                this.f2572a.abortAnimation();
                this.f2591d = false;
                q();
                this.f2593e = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.n;
            if (i2 != -1) {
                int findPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(findPointerIndex);
                float f3 = x2 - this.c;
                float abs = Math.abs(f3);
                float y2 = motionEvent.getY(findPointerIndex);
                float abs2 = Math.abs(y2 - this.f);
                int i3 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                if (i3 != 0) {
                    float f4 = this.c;
                    if ((f4 >= ((float) this.l) || i3 <= 0) && (f4 <= ((float) (getWidth() - this.l)) || f3 >= 0.0f)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z && c((int) f3, (int) x2, (int) y2, this, false)) {
                        this.c = x2;
                        this.d = y2;
                        this.f2595f = true;
                        return false;
                    }
                }
                float f5 = (float) this.m;
                if (abs > f5 && abs * 0.5f > abs2) {
                    this.f2593e = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f6 = this.e;
                    float f7 = (float) this.m;
                    if (i3 > 0) {
                        f2 = f6 + f7;
                    } else {
                        f2 = f6 - f7;
                    }
                    this.c = f2;
                    this.d = y2;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > f5) {
                    this.f2595f = true;
                }
                if (this.f2593e && p(x2)) {
                    WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            m(motionEvent);
        }
        if (this.f2570a == null) {
            this.f2570a = VelocityTracker.obtain();
        }
        this.f2570a.addMovement(motionEvent);
        return this.f2593e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            int r1 = r18.getChildCount()
            int r2 = r22 - r20
            int r3 = r23 - r21
            int r4 = r18.getPaddingLeft()
            int r5 = r18.getPaddingTop()
            int r6 = r18.getPaddingRight()
            int r7 = r18.getPaddingBottom()
            int r8 = r18.getScrollX()
            r10 = 0
            r11 = 0
        L_0x0020:
            r12 = 8
            if (r10 >= r1) goto L_0x00b6
            android.view.View r13 = r0.getChildAt(r10)
            int r14 = r13.getVisibility()
            if (r14 == r12) goto L_0x00b2
            android.view.ViewGroup$LayoutParams r12 = r13.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r12 = (androidx.viewpager.widget.ViewPager.LayoutParams) r12
            boolean r14 = r12.f2599a
            if (r14 == 0) goto L_0x00b2
            int r12 = r12.f2598a
            r14 = r12 & 7
            r12 = r12 & 112(0x70, float:1.57E-43)
            r15 = 1
            if (r14 == r15) goto L_0x005c
            r15 = 3
            if (r14 == r15) goto L_0x0056
            r15 = 5
            if (r14 == r15) goto L_0x0049
            r14 = r4
            goto L_0x006d
        L_0x0049:
            int r14 = r2 - r6
            int r15 = r13.getMeasuredWidth()
            int r14 = r14 - r15
            int r15 = r13.getMeasuredWidth()
            int r6 = r6 + r15
            goto L_0x0068
        L_0x0056:
            int r14 = r13.getMeasuredWidth()
            int r14 = r14 + r4
            goto L_0x006d
        L_0x005c:
            int r14 = r13.getMeasuredWidth()
            int r14 = r2 - r14
            int r14 = r14 / 2
            int r14 = java.lang.Math.max(r14, r4)
        L_0x0068:
            r17 = r14
            r14 = r4
            r4 = r17
        L_0x006d:
            r15 = 16
            if (r12 == r15) goto L_0x008e
            r15 = 48
            if (r12 == r15) goto L_0x0088
            r15 = 80
            if (r12 == r15) goto L_0x007b
            r12 = r5
            goto L_0x009f
        L_0x007b:
            int r12 = r3 - r7
            int r15 = r13.getMeasuredHeight()
            int r12 = r12 - r15
            int r15 = r13.getMeasuredHeight()
            int r7 = r7 + r15
            goto L_0x009a
        L_0x0088:
            int r12 = r13.getMeasuredHeight()
            int r12 = r12 + r5
            goto L_0x009f
        L_0x008e:
            int r12 = r13.getMeasuredHeight()
            int r12 = r3 - r12
            int r12 = r12 / 2
            int r12 = java.lang.Math.max(r12, r5)
        L_0x009a:
            r17 = r12
            r12 = r5
            r5 = r17
        L_0x009f:
            int r4 = r4 + r8
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r4
            int r16 = r13.getMeasuredHeight()
            int r9 = r16 + r5
            r13.layout(r4, r5, r15, r9)
            int r11 = r11 + 1
            r5 = r12
            r4 = r14
        L_0x00b2:
            int r10 = r10 + 1
            goto L_0x0020
        L_0x00b6:
            int r2 = r2 - r4
            int r2 = r2 - r6
            r6 = 0
        L_0x00b9:
            if (r6 >= r1) goto L_0x0106
            android.view.View r8 = r0.getChildAt(r6)
            int r9 = r8.getVisibility()
            if (r9 == r12) goto L_0x0103
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f2599a
            if (r10 != 0) goto L_0x0103
            androidx.viewpager.widget.ViewPager$f r10 = r0.h(r8)
            if (r10 == 0) goto L_0x0103
            float r13 = (float) r2
            float r10 = r10.b
            float r10 = r10 * r13
            int r10 = (int) r10
            int r10 = r10 + r4
            boolean r14 = r9.f2600b
            if (r14 == 0) goto L_0x00f6
            r14 = 0
            r9.f2600b = r14
            float r9 = r9.a
            float r13 = r13 * r9
            int r9 = (int) r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r13)
            int r14 = r3 - r5
            int r14 = r14 - r7
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r8.measure(r9, r13)
        L_0x00f6:
            int r9 = r8.getMeasuredWidth()
            int r9 = r9 + r10
            int r13 = r8.getMeasuredHeight()
            int r13 = r13 + r5
            r8.layout(r10, r5, r9, r13)
        L_0x0103:
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x0106:
            r0.g = r5
            int r3 = r3 - r7
            r0.h = r3
            r0.s = r11
            boolean r1 = r0.f2596g
            if (r1 == 0) goto L_0x0118
            int r1 = r0.f2589d
            r2 = 0
            r0.u(r1, r2, r2, r2)
            goto L_0x0119
        L_0x0118:
            r2 = 0
        L_0x0119:
            r0.f2596g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    public final void onMeasure(int i2, int i3) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        boolean z;
        int i4;
        setMeasuredDimension(View.getDefaultSize(0, i2), View.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        this.l = Math.min(measuredWidth / 10, this.k);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            boolean z2 = true;
            int i6 = Ints.MAX_POWER_OF_TWO;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            if (!(childAt.getVisibility() == 8 || (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) == null || !layoutParams2.f2599a)) {
                int i7 = layoutParams2.f2598a;
                int i8 = i7 & 7;
                int i9 = i7 & 112;
                if (i9 == 48 || i9 == 80) {
                    z = true;
                } else {
                    z = false;
                }
                if (!(i8 == 3 || i8 == 5)) {
                    z2 = false;
                }
                int i10 = Integer.MIN_VALUE;
                if (z) {
                    i4 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else if (z2) {
                    i4 = 1073741824;
                } else {
                    i4 = Integer.MIN_VALUE;
                }
                int i11 = layoutParams2.width;
                if (i11 != -2) {
                    if (i11 == -1) {
                        i11 = paddingLeft;
                    }
                    i10 = 1073741824;
                } else {
                    i11 = paddingLeft;
                }
                int i12 = layoutParams2.height;
                if (i12 == -2) {
                    i12 = measuredHeight;
                    i6 = i4;
                } else if (i12 == -1) {
                    i12 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i11, i10), View.MeasureSpec.makeMeasureSpec(i12, i6));
                if (z) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i5++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, Ints.MAX_POWER_OF_TWO);
        this.i = View.MeasureSpec.makeMeasureSpec(measuredHeight, Ints.MAX_POWER_OF_TWO);
        this.f2585b = true;
        q();
        this.f2585b = false;
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) == null || !layoutParams.f2599a)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (((float) paddingLeft) * layoutParams.a), Ints.MAX_POWER_OF_TWO), this.i);
            }
        }
    }

    public final boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        int i5;
        f h2;
        int childCount = getChildCount();
        if ((i2 & 2) != 0) {
            i4 = childCount;
            i5 = 0;
            i3 = 1;
        } else {
            i5 = childCount - 1;
            i4 = -1;
            i3 = -1;
        }
        while (i5 != i4) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 0 && (h2 = h(childAt)) != null && h2.f2603a == this.f2589d && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i5 += i3;
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
        PagerAdapter pagerAdapter = this.f2573a;
        ClassLoader classLoader = savedState.f2601a;
        if (pagerAdapter != null) {
            pagerAdapter.restoreState(savedState.a, classLoader);
            v(savedState.c, 0, false, true);
            return;
        }
        this.f2592e = savedState.c;
        this.f2569a = savedState.a;
        this.f2579a = classLoader;
    }

    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.c = this.f2589d;
        PagerAdapter pagerAdapter = this.f2573a;
        if (pagerAdapter != null) {
            savedState.a = pagerAdapter.saveState();
        }
        return savedState;
    }

    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.f2594f;
            s(i2, i4, i6, i6);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        PagerAdapter pagerAdapter;
        float f2;
        float f3;
        boolean z = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (pagerAdapter = this.f2573a) == null || pagerAdapter.getCount() == 0) {
            return false;
        }
        if (this.f2570a == null) {
            this.f2570a = VelocityTracker.obtain();
        }
        this.f2570a.addMovement(motionEvent);
        int action = motionEvent.getAction() & Constants.MAX_HOST_LENGTH;
        if (action == 0) {
            this.f2572a.abortAnimation();
            this.f2591d = false;
            q();
            float x = motionEvent.getX();
            this.e = x;
            this.c = x;
            float y = motionEvent.getY();
            this.f = y;
            this.d = y;
            this.n = motionEvent.getPointerId(0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.f2593e) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.n);
                    if (findPointerIndex == -1) {
                        z = t();
                    } else {
                        float x2 = motionEvent.getX(findPointerIndex);
                        float abs = Math.abs(x2 - this.c);
                        float y2 = motionEvent.getY(findPointerIndex);
                        float abs2 = Math.abs(y2 - this.d);
                        if (abs > ((float) this.m) && abs > abs2) {
                            this.f2593e = true;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                            float f4 = this.e;
                            if (x2 - f4 > 0.0f) {
                                f3 = f4 + ((float) this.m);
                            } else {
                                f3 = f4 - ((float) this.m);
                            }
                            this.c = f3;
                            this.d = y2;
                            setScrollState(1);
                            setScrollingCacheEnabled(true);
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
                if (this.f2593e) {
                    z = false | p(motionEvent.getX(motionEvent.findPointerIndex(this.n)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    this.c = motionEvent.getX(actionIndex);
                    this.n = motionEvent.getPointerId(actionIndex);
                } else if (action == 6) {
                    m(motionEvent);
                    this.c = motionEvent.getX(motionEvent.findPointerIndex(this.n));
                }
            } else if (this.f2593e) {
                u(this.f2589d, 0, true, false);
                z = t();
            }
        } else if (this.f2593e) {
            VelocityTracker velocityTracker = this.f2570a;
            velocityTracker.computeCurrentVelocity(1000, (float) this.p);
            int xVelocity = (int) velocityTracker.getXVelocity(this.n);
            this.f2591d = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            f i2 = i();
            float f5 = (float) clientWidth;
            float f6 = ((float) this.f2594f) / f5;
            int i3 = i2.f2603a;
            float f7 = ((((float) scrollX) / f5) - i2.b) / (i2.a + f6);
            if (Math.abs((int) (motionEvent.getX(motionEvent.findPointerIndex(this.n)) - this.e)) <= this.q || Math.abs(xVelocity) <= this.o) {
                if (i3 >= this.f2589d) {
                    f2 = 0.4f;
                } else {
                    f2 = 0.6f;
                }
                i3 += (int) (f7 + f2);
            } else if (xVelocity <= 0) {
                i3++;
            }
            ArrayList<f> arrayList = this.f2580a;
            if (arrayList.size() > 0) {
                i3 = Math.max(arrayList.get(0).f2603a, Math.min(i3, arrayList.get(arrayList.size() - 1).f2603a));
            }
            v(i3, xVelocity, true, true);
            z = t();
        }
        if (z) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            postInvalidateOnAnimation();
        }
        return true;
    }

    public final boolean p(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.c - f2;
        this.c = f2;
        float scrollX = ((float) getScrollX()) + f3;
        float clientWidth = (float) getClientWidth();
        float f4 = this.f2566a * clientWidth;
        float f5 = this.b * clientWidth;
        ArrayList<f> arrayList = this.f2580a;
        boolean z3 = false;
        f fVar = arrayList.get(0);
        f fVar2 = arrayList.get(arrayList.size() - 1);
        if (fVar.f2603a != 0) {
            f4 = fVar.b * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (fVar2.f2603a != this.f2573a.getCount() - 1) {
            f5 = fVar2.b * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.f2571a.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.f2582b.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.c = (scrollX - ((float) i2)) + this.c;
        scrollTo(i2, getScrollY());
        o(i2);
        return z3;
    }

    public final void q() {
        r(this.f2589d);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        if (r10 == r11) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        r9 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void r(int r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r0.f2589d
            if (r2 == r1) goto L_0x000f
            androidx.viewpager.widget.ViewPager$f r2 = r0.j(r2)
            r0.f2589d = r1
            goto L_0x0010
        L_0x000f:
            r2 = 0
        L_0x0010:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f2573a
            if (r1 != 0) goto L_0x0018
            r17.w()
            return
        L_0x0018:
            boolean r1 = r0.f2591d
            if (r1 == 0) goto L_0x0020
            r17.w()
            return
        L_0x0020:
            android.os.IBinder r1 = r17.getWindowToken()
            if (r1 != 0) goto L_0x0027
            return
        L_0x0027:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f2573a
            r1.startUpdate((android.view.ViewGroup) r0)
            int r1 = r0.j
            int r4 = r0.f2589d
            int r4 = r4 - r1
            r5 = 0
            int r4 = java.lang.Math.max(r5, r4)
            androidx.viewpager.widget.PagerAdapter r6 = r0.f2573a
            int r6 = r6.getCount()
            int r7 = r6 + -1
            int r8 = r0.f2589d
            int r8 = r8 + r1
            int r1 = java.lang.Math.min(r7, r8)
            int r7 = r0.f2586c
            if (r6 != r7) goto L_0x0320
            r7 = r5
        L_0x004a:
            java.util.ArrayList<androidx.viewpager.widget.ViewPager$f> r8 = r0.f2580a
            int r9 = r8.size()
            if (r7 >= r9) goto L_0x0064
            java.lang.Object r9 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$f r9 = (androidx.viewpager.widget.ViewPager.f) r9
            int r10 = r9.f2603a
            int r11 = r0.f2589d
            if (r10 < r11) goto L_0x0061
            if (r10 != r11) goto L_0x0064
            goto L_0x0065
        L_0x0061:
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0064:
            r9 = 0
        L_0x0065:
            if (r9 != 0) goto L_0x006f
            if (r6 <= 0) goto L_0x006f
            int r9 = r0.f2589d
            androidx.viewpager.widget.ViewPager$f r9 = r0.a(r9, r7)
        L_0x006f:
            if (r9 == 0) goto L_0x0298
            int r11 = r7 + -1
            if (r11 < 0) goto L_0x007c
            java.lang.Object r12 = r8.get(r11)
            androidx.viewpager.widget.ViewPager$f r12 = (androidx.viewpager.widget.ViewPager.f) r12
            goto L_0x007d
        L_0x007c:
            r12 = 0
        L_0x007d:
            int r13 = r17.getClientWidth()
            r14 = 1073741824(0x40000000, float:2.0)
            if (r13 > 0) goto L_0x0087
            r3 = 0
            goto L_0x0093
        L_0x0087:
            float r15 = r9.a
            float r15 = r14 - r15
            int r3 = r17.getPaddingLeft()
            float r3 = (float) r3
            float r5 = (float) r13
            float r3 = r3 / r5
            float r3 = r3 + r15
        L_0x0093:
            int r5 = r0.f2589d
            int r5 = r5 + -1
            r15 = 0
        L_0x0098:
            if (r5 < 0) goto L_0x00ef
            int r16 = (r15 > r3 ? 1 : (r15 == r3 ? 0 : -1))
            if (r16 < 0) goto L_0x00c2
            if (r5 >= r4) goto L_0x00c2
            if (r12 != 0) goto L_0x00a3
            goto L_0x00ef
        L_0x00a3:
            int r10 = r12.f2603a
            if (r5 != r10) goto L_0x00ec
            boolean r10 = r12.f2605a
            if (r10 != 0) goto L_0x00ec
            r8.remove(r11)
            androidx.viewpager.widget.PagerAdapter r10 = r0.f2573a
            java.lang.Object r12 = r12.f2604a
            r10.destroyItem((android.view.ViewGroup) r0, (int) r5, (java.lang.Object) r12)
            int r11 = r11 + -1
            int r7 = r7 + -1
            if (r11 < 0) goto L_0x00ea
            java.lang.Object r10 = r8.get(r11)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
            goto L_0x00eb
        L_0x00c2:
            if (r12 == 0) goto L_0x00d6
            int r10 = r12.f2603a
            if (r5 != r10) goto L_0x00d6
            float r10 = r12.a
            float r15 = r15 + r10
            int r11 = r11 + -1
            if (r11 < 0) goto L_0x00ea
            java.lang.Object r10 = r8.get(r11)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
            goto L_0x00eb
        L_0x00d6:
            int r10 = r11 + 1
            androidx.viewpager.widget.ViewPager$f r10 = r0.a(r5, r10)
            float r10 = r10.a
            float r15 = r15 + r10
            int r7 = r7 + 1
            if (r11 < 0) goto L_0x00ea
            java.lang.Object r10 = r8.get(r11)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
            goto L_0x00eb
        L_0x00ea:
            r10 = 0
        L_0x00eb:
            r12 = r10
        L_0x00ec:
            int r5 = r5 + -1
            goto L_0x0098
        L_0x00ef:
            float r3 = r9.a
            int r4 = r7 + 1
            int r5 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r5 >= 0) goto L_0x0172
            int r5 = r8.size()
            if (r4 >= r5) goto L_0x0104
            java.lang.Object r5 = r8.get(r4)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x0105
        L_0x0104:
            r5 = 0
        L_0x0105:
            if (r13 > 0) goto L_0x0109
            r10 = 0
            goto L_0x0111
        L_0x0109:
            int r10 = r17.getPaddingRight()
            float r10 = (float) r10
            float r11 = (float) r13
            float r10 = r10 / r11
            float r10 = r10 + r14
        L_0x0111:
            int r11 = r0.f2589d
            int r11 = r11 + 1
            r12 = r4
        L_0x0116:
            if (r11 >= r6) goto L_0x0172
            int r13 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r13 < 0) goto L_0x0142
            if (r11 <= r1) goto L_0x0142
            if (r5 != 0) goto L_0x0121
            goto L_0x0172
        L_0x0121:
            int r13 = r5.f2603a
            if (r11 != r13) goto L_0x016f
            boolean r13 = r5.f2605a
            if (r13 != 0) goto L_0x016f
            r8.remove(r12)
            androidx.viewpager.widget.PagerAdapter r13 = r0.f2573a
            java.lang.Object r5 = r5.f2604a
            r13.destroyItem((android.view.ViewGroup) r0, (int) r11, (java.lang.Object) r5)
            int r5 = r8.size()
            if (r12 >= r5) goto L_0x0140
            java.lang.Object r5 = r8.get(r12)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x016f
        L_0x0140:
            r5 = 0
            goto L_0x016f
        L_0x0142:
            if (r5 == 0) goto L_0x015a
            int r13 = r5.f2603a
            if (r11 != r13) goto L_0x015a
            float r5 = r5.a
            float r3 = r3 + r5
            int r12 = r12 + 1
            int r5 = r8.size()
            if (r12 >= r5) goto L_0x0140
            java.lang.Object r5 = r8.get(r12)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            goto L_0x016f
        L_0x015a:
            androidx.viewpager.widget.ViewPager$f r5 = r0.a(r11, r12)
            int r12 = r12 + 1
            float r5 = r5.a
            float r3 = r3 + r5
            int r5 = r8.size()
            if (r12 >= r5) goto L_0x0140
            java.lang.Object r5 = r8.get(r12)
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
        L_0x016f:
            int r11 = r11 + 1
            goto L_0x0116
        L_0x0172:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f2573a
            int r1 = r1.getCount()
            int r3 = r17.getClientWidth()
            if (r3 <= 0) goto L_0x0184
            int r5 = r0.f2594f
            float r5 = (float) r5
            float r3 = (float) r3
            float r5 = r5 / r3
            goto L_0x0185
        L_0x0184:
            r5 = 0
        L_0x0185:
            if (r2 == 0) goto L_0x0210
            int r3 = r2.f2603a
            int r6 = r9.f2603a
            if (r3 >= r6) goto L_0x01d3
            float r6 = r2.b
            float r2 = r2.a
            float r6 = r6 + r2
            float r6 = r6 + r5
            int r3 = r3 + 1
            r2 = 0
        L_0x0196:
            int r10 = r9.f2603a
            if (r3 > r10) goto L_0x0210
            int r10 = r8.size()
            if (r2 >= r10) goto L_0x0210
            java.lang.Object r10 = r8.get(r2)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
        L_0x01a6:
            int r11 = r10.f2603a
            if (r3 <= r11) goto L_0x01bb
            int r11 = r8.size()
            int r11 = r11 + -1
            if (r2 >= r11) goto L_0x01bb
            int r2 = r2 + 1
            java.lang.Object r10 = r8.get(r2)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
            goto L_0x01a6
        L_0x01bb:
            int r11 = r10.f2603a
            if (r3 >= r11) goto L_0x01ca
            androidx.viewpager.widget.PagerAdapter r11 = r0.f2573a
            float r11 = r11.getPageWidth(r3)
            float r11 = r11 + r5
            float r6 = r6 + r11
            int r3 = r3 + 1
            goto L_0x01bb
        L_0x01ca:
            r10.b = r6
            float r10 = r10.a
            float r10 = r10 + r5
            float r6 = r6 + r10
            int r3 = r3 + 1
            goto L_0x0196
        L_0x01d3:
            if (r3 <= r6) goto L_0x0210
            int r6 = r8.size()
            int r6 = r6 + -1
            float r2 = r2.b
        L_0x01dd:
            int r3 = r3 + -1
            int r10 = r9.f2603a
            if (r3 < r10) goto L_0x0210
            if (r6 < 0) goto L_0x0210
            java.lang.Object r10 = r8.get(r6)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
        L_0x01eb:
            int r11 = r10.f2603a
            if (r3 >= r11) goto L_0x01fa
            if (r6 <= 0) goto L_0x01fa
            int r6 = r6 + -1
            java.lang.Object r10 = r8.get(r6)
            androidx.viewpager.widget.ViewPager$f r10 = (androidx.viewpager.widget.ViewPager.f) r10
            goto L_0x01eb
        L_0x01fa:
            int r11 = r10.f2603a
            if (r3 <= r11) goto L_0x0209
            androidx.viewpager.widget.PagerAdapter r11 = r0.f2573a
            float r11 = r11.getPageWidth(r3)
            float r11 = r11 + r5
            float r2 = r2 - r11
            int r3 = r3 + -1
            goto L_0x01fa
        L_0x0209:
            float r11 = r10.a
            float r11 = r11 + r5
            float r2 = r2 - r11
            r10.b = r2
            goto L_0x01dd
        L_0x0210:
            int r2 = r8.size()
            float r3 = r9.b
            int r6 = r9.f2603a
            int r10 = r6 + -1
            if (r6 != 0) goto L_0x021e
            r11 = r3
            goto L_0x0221
        L_0x021e:
            r11 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x0221:
            r0.f2566a = r11
            int r1 = r1 + -1
            r11 = 1065353216(0x3f800000, float:1.0)
            if (r6 != r1) goto L_0x022e
            float r6 = r9.a
            float r6 = r6 + r3
            float r6 = r6 - r11
            goto L_0x0231
        L_0x022e:
            r6 = 2139095039(0x7f7fffff, float:3.4028235E38)
        L_0x0231:
            r0.b = r6
            int r7 = r7 + -1
        L_0x0235:
            if (r7 < 0) goto L_0x025c
            java.lang.Object r6 = r8.get(r7)
            androidx.viewpager.widget.ViewPager$f r6 = (androidx.viewpager.widget.ViewPager.f) r6
        L_0x023d:
            int r12 = r6.f2603a
            if (r10 <= r12) goto L_0x024d
            androidx.viewpager.widget.PagerAdapter r12 = r0.f2573a
            int r13 = r10 + -1
            float r10 = r12.getPageWidth(r10)
            float r10 = r10 + r5
            float r3 = r3 - r10
            r10 = r13
            goto L_0x023d
        L_0x024d:
            float r13 = r6.a
            float r13 = r13 + r5
            float r3 = r3 - r13
            r6.b = r3
            if (r12 != 0) goto L_0x0257
            r0.f2566a = r3
        L_0x0257:
            int r7 = r7 + -1
            int r10 = r10 + -1
            goto L_0x0235
        L_0x025c:
            float r3 = r9.b
            float r6 = r9.a
            float r3 = r3 + r6
            float r3 = r3 + r5
            int r6 = r9.f2603a
        L_0x0264:
            int r6 = r6 + 1
            if (r4 >= r2) goto L_0x028f
            java.lang.Object r7 = r8.get(r4)
            androidx.viewpager.widget.ViewPager$f r7 = (androidx.viewpager.widget.ViewPager.f) r7
        L_0x026e:
            int r10 = r7.f2603a
            if (r6 >= r10) goto L_0x027e
            androidx.viewpager.widget.PagerAdapter r10 = r0.f2573a
            int r12 = r6 + 1
            float r6 = r10.getPageWidth(r6)
            float r6 = r6 + r5
            float r3 = r3 + r6
            r6 = r12
            goto L_0x026e
        L_0x027e:
            if (r10 != r1) goto L_0x0286
            float r10 = r7.a
            float r10 = r10 + r3
            float r10 = r10 - r11
            r0.b = r10
        L_0x0286:
            r7.b = r3
            float r7 = r7.a
            float r7 = r7 + r5
            float r3 = r3 + r7
            int r4 = r4 + 1
            goto L_0x0264
        L_0x028f:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f2573a
            int r2 = r0.f2589d
            java.lang.Object r3 = r9.f2604a
            r1.setPrimaryItem((android.view.ViewGroup) r0, (int) r2, (java.lang.Object) r3)
        L_0x0298:
            androidx.viewpager.widget.PagerAdapter r1 = r0.f2573a
            r1.finishUpdate((android.view.ViewGroup) r0)
            int r1 = r17.getChildCount()
            r2 = 0
        L_0x02a2:
            if (r2 >= r1) goto L_0x02ce
            android.view.View r3 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r4 = (androidx.viewpager.widget.ViewPager.LayoutParams) r4
            r4.c = r2
            boolean r5 = r4.f2599a
            if (r5 != 0) goto L_0x02ca
            float r5 = r4.a
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x02cb
            androidx.viewpager.widget.ViewPager$f r3 = r0.h(r3)
            if (r3 == 0) goto L_0x02cb
            float r5 = r3.a
            r4.a = r5
            int r3 = r3.f2603a
            r4.b = r3
            goto L_0x02cb
        L_0x02ca:
            r6 = 0
        L_0x02cb:
            int r2 = r2 + 1
            goto L_0x02a2
        L_0x02ce:
            r17.w()
            boolean r1 = r17.hasFocus()
            if (r1 == 0) goto L_0x031f
            android.view.View r1 = r17.findFocus()
            if (r1 == 0) goto L_0x02f4
        L_0x02dd:
            android.view.ViewParent r2 = r1.getParent()
            if (r2 == r0) goto L_0x02ee
            if (r2 == 0) goto L_0x02f4
            boolean r1 = r2 instanceof android.view.View
            if (r1 != 0) goto L_0x02ea
            goto L_0x02f4
        L_0x02ea:
            r1 = r2
            android.view.View r1 = (android.view.View) r1
            goto L_0x02dd
        L_0x02ee:
            androidx.viewpager.widget.ViewPager$f r1 = r0.h(r1)
            r3 = r1
            goto L_0x02f5
        L_0x02f4:
            r3 = 0
        L_0x02f5:
            if (r3 == 0) goto L_0x02fd
            int r1 = r3.f2603a
            int r2 = r0.f2589d
            if (r1 == r2) goto L_0x031f
        L_0x02fd:
            r5 = 0
        L_0x02fe:
            int r1 = r17.getChildCount()
            if (r5 >= r1) goto L_0x031f
            android.view.View r1 = r0.getChildAt(r5)
            androidx.viewpager.widget.ViewPager$f r2 = r0.h(r1)
            if (r2 == 0) goto L_0x031c
            int r2 = r2.f2603a
            int r3 = r0.f2589d
            if (r2 != r3) goto L_0x031c
            r2 = 2
            boolean r1 = r1.requestFocus(r2)
            if (r1 == 0) goto L_0x031c
            goto L_0x031f
        L_0x031c:
            int r5 = r5 + 1
            goto L_0x02fe
        L_0x031f:
            return
        L_0x0320:
            android.content.res.Resources r1 = r17.getResources()     // Catch:{ NotFoundException -> 0x032d }
            int r2 = r17.getId()     // Catch:{ NotFoundException -> 0x032d }
            java.lang.String r1 = r1.getResourceName(r2)     // Catch:{ NotFoundException -> 0x032d }
            goto L_0x0335
        L_0x032d:
            int r1 = r17.getId()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0335:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
            r3.<init>(r4)
            int r4 = r0.f2586c
            r3.append(r4)
            java.lang.String r4 = ", found: "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " Pager id: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = " Pager class: "
            r3.append(r1)
            java.lang.Class r1 = r17.getClass()
            r3.append(r1)
            java.lang.String r1 = " Problematic adapter: "
            r3.append(r1)
            androidx.viewpager.widget.PagerAdapter r1 = r0.f2573a
            java.lang.Class r1 = r1.getClass()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.r(int):void");
    }

    public final void removeView(View view) {
        if (this.f2585b) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public final void s(int i2, int i3, int i4, int i5) {
        float f2;
        if (i3 <= 0 || this.f2580a.isEmpty()) {
            f j2 = j(this.f2589d);
            if (j2 != null) {
                f2 = Math.min(j2.b, this.b);
            } else {
                f2 = 0.0f;
            }
            int paddingLeft = (int) (f2 * ((float) ((i2 - getPaddingLeft()) - getPaddingRight())));
            if (paddingLeft != getScrollX()) {
                d(false);
                scrollTo(paddingLeft, getScrollY());
            }
        } else if (!this.f2572a.isFinished()) {
            this.f2572a.setFinalX(getCurrentItem() * getClientWidth());
        } else {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i3 - getPaddingLeft()) - getPaddingRight()) + i5))) * ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        ArrayList<f> arrayList;
        PagerAdapter pagerAdapter2 = this.f2573a;
        if (pagerAdapter2 != null) {
            pagerAdapter2.setViewPagerObserver((DataSetObserver) null);
            this.f2573a.startUpdate((ViewGroup) this);
            int i2 = 0;
            while (true) {
                arrayList = this.f2580a;
                if (i2 >= arrayList.size()) {
                    break;
                }
                f fVar = arrayList.get(i2);
                this.f2573a.destroyItem((ViewGroup) this, fVar.f2603a, fVar.f2604a);
                i2++;
            }
            this.f2573a.finishUpdate((ViewGroup) this);
            arrayList.clear();
            int i3 = 0;
            while (i3 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i3).getLayoutParams()).f2599a) {
                    removeViewAt(i3);
                    i3--;
                }
                i3++;
            }
            this.f2589d = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter3 = this.f2573a;
        this.f2573a = pagerAdapter;
        this.f2586c = 0;
        if (pagerAdapter != null) {
            if (this.f2578a == null) {
                this.f2578a = new k();
            }
            this.f2573a.setViewPagerObserver(this.f2578a);
            this.f2591d = false;
            boolean z = this.f2596g;
            this.f2596g = true;
            this.f2586c = this.f2573a.getCount();
            if (this.f2592e >= 0) {
                this.f2573a.restoreState(this.f2569a, this.f2579a);
                v(this.f2592e, 0, false, true);
                this.f2592e = -1;
                this.f2569a = null;
                this.f2579a = null;
            } else if (!z) {
                q();
            } else {
                requestLayout();
            }
        }
        ArrayList arrayList2 = this.f2587c;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            int size = this.f2587c.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((h) this.f2587c.get(i4)).onAdapterChanged(this, pagerAdapter3, pagerAdapter);
            }
        }
    }

    public void setCurrentItem(int i2) {
        this.f2591d = false;
        v(i2, 0, !this.f2596g, false);
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            i2 = 1;
        }
        if (i2 != this.j) {
            this.j = i2;
            q();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(i iVar) {
        this.f2576a = iVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.f2594f;
        this.f2594f = i2;
        int width = getWidth();
        s(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f2568a = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, j jVar) {
        setPageTransformer(z, jVar, 2);
    }

    public void setScrollState(int i2) {
        boolean z;
        int i3;
        if (this.v != i2) {
            this.v = i2;
            if (this.f2577a != null) {
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    if (z) {
                        i3 = this.t;
                    } else {
                        i3 = 0;
                    }
                    getChildAt(i4).setLayerType(i3, (Paint) null);
                }
            }
            i iVar = this.f2576a;
            if (iVar != null) {
                iVar.onPageScrollStateChanged(i2);
            }
            ArrayList arrayList = this.f2584b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    i iVar2 = (i) this.f2584b.get(i5);
                    if (iVar2 != null) {
                        iVar2.onPageScrollStateChanged(i2);
                    }
                }
            }
            i iVar3 = this.f2583b;
            if (iVar3 != null) {
                iVar3.onPageScrollStateChanged(i2);
            }
        }
    }

    public final boolean t() {
        this.n = -1;
        this.f2593e = false;
        this.f2595f = false;
        VelocityTracker velocityTracker = this.f2570a;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2570a = null;
        }
        this.f2571a.onRelease();
        this.f2582b.onRelease();
        if (this.f2571a.isFinished() || this.f2582b.isFinished()) {
            return true;
        }
        return false;
    }

    public final void u(int i2, int i3, boolean z, boolean z2) {
        int i4;
        boolean z3;
        int i5;
        int i6;
        f j2 = j(i2);
        if (j2 != null) {
            i4 = (int) (Math.max(this.f2566a, Math.min(j2.b, this.b)) * ((float) getClientWidth()));
        } else {
            i4 = 0;
        }
        if (z) {
            if (getChildCount() == 0) {
                setScrollingCacheEnabled(false);
            } else {
                Scroller scroller = this.f2572a;
                if (scroller == null || scroller.isFinished()) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    if (this.f2581a) {
                        i5 = this.f2572a.getCurrX();
                    } else {
                        i5 = this.f2572a.getStartX();
                    }
                    this.f2572a.abortAnimation();
                    setScrollingCacheEnabled(false);
                } else {
                    i5 = getScrollX();
                }
                int i7 = i5;
                int scrollY = getScrollY();
                int i8 = i4 - i7;
                int i9 = 0 - scrollY;
                if (i8 == 0 && i9 == 0) {
                    d(false);
                    q();
                    setScrollState(0);
                } else {
                    setScrollingCacheEnabled(true);
                    setScrollState(2);
                    int clientWidth = getClientWidth();
                    int i10 = clientWidth / 2;
                    float f2 = (float) clientWidth;
                    float f3 = (float) i10;
                    float sin = (((float) Math.sin((double) ((Math.min(1.0f, (((float) Math.abs(i8)) * 1.0f) / f2) - 0.5f) * 0.47123894f))) * f3) + f3;
                    int abs = Math.abs(i3);
                    if (abs > 0) {
                        i6 = Math.round(Math.abs(sin / ((float) abs)) * 1000.0f) * 4;
                    } else {
                        i6 = (int) (((((float) Math.abs(i8)) / ((this.f2573a.getPageWidth(this.f2589d) * f2) + ((float) this.f2594f))) + 1.0f) * 100.0f);
                    }
                    int min = Math.min(i6, LogSeverity.CRITICAL_VALUE);
                    this.f2581a = false;
                    this.f2572a.startScroll(i7, scrollY, i8, i9, min);
                    WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                    postInvalidateOnAnimation();
                }
            }
            if (z2) {
                f(i2);
                return;
            }
            return;
        }
        if (z2) {
            f(i2);
        }
        d(false);
        scrollTo(i4, 0);
        o(i4);
    }

    public final void v(int i2, int i3, boolean z, boolean z2) {
        PagerAdapter pagerAdapter = this.f2573a;
        boolean z3 = false;
        if (pagerAdapter == null || pagerAdapter.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        ArrayList<f> arrayList = this.f2580a;
        if (z2 || this.f2589d != i2 || arrayList.size() == 0) {
            if (i2 < 0) {
                i2 = 0;
            } else if (i2 >= this.f2573a.getCount()) {
                i2 = this.f2573a.getCount() - 1;
            }
            int i4 = this.j;
            int i5 = this.f2589d;
            if (i2 > i5 + i4 || i2 < i5 - i4) {
                for (int i6 = 0; i6 < arrayList.size(); i6++) {
                    arrayList.get(i6).f2605a = true;
                }
            }
            if (this.f2589d != i2) {
                z3 = true;
            }
            if (this.f2596g) {
                this.f2589d = i2;
                if (z3) {
                    f(i2);
                }
                requestLayout();
                return;
            }
            r(i2);
            u(i2, i3, z, z3);
            return;
        }
        setScrollingCacheEnabled(false);
    }

    public final boolean verifyDrawable(Drawable drawable) {
        if (super.verifyDrawable(drawable) || drawable == this.f2568a) {
            return true;
        }
        return false;
    }

    public final void w() {
        if (this.u != 0) {
            ArrayList<View> arrayList = this.f2590d;
            if (arrayList == null) {
                this.f2590d = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.f2590d.add(getChildAt(i2));
            }
            Collections.sort(this.f2590d, f2564a);
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        public float a = 0.0f;

        /* renamed from: a  reason: collision with other field name */
        public final int f2598a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2599a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f2600b;
        public int c;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f2565a);
            this.f2598a = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setPageTransformer(boolean z, j jVar, int i2) {
        int i3 = 1;
        boolean z2 = jVar != null;
        boolean z3 = z2 != (this.f2577a != null);
        this.f2577a = jVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i3 = 2;
            }
            this.u = i3;
            this.t = i2;
        } else {
            this.u = 0;
        }
        if (z3) {
            q();
        }
    }

    public void setCurrentItem(int i2, boolean z) {
        this.f2591d = false;
        v(i2, 0, z, false);
    }

    public void setPageMarginDrawable(int i2) {
        Context context = getContext();
        Object obj = d7.a;
        setPageMarginDrawable(d7.a.b(context, i2));
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k();
    }
}
