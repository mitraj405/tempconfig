package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.f;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import defpackage.d7;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public class DrawerLayout extends ViewGroup {
    public static final int[] a = {16843828};
    public static final int[] b = {16842931};
    public static final boolean e = true;
    public static final boolean f = true;
    public static final boolean g;

    /* renamed from: a  reason: collision with other field name */
    public float f1942a;

    /* renamed from: a  reason: collision with other field name */
    public Matrix f1943a;

    /* renamed from: a  reason: collision with other field name */
    public final Paint f1944a;

    /* renamed from: a  reason: collision with other field name */
    public Rect f1945a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f1946a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewDragHelper f1947a;

    /* renamed from: a  reason: collision with other field name */
    public DrawerListener f1948a;

    /* renamed from: a  reason: collision with other field name */
    public final a f1949a;

    /* renamed from: a  reason: collision with other field name */
    public final d f1950a;

    /* renamed from: a  reason: collision with other field name */
    public final f f1951a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f1952a;

    /* renamed from: a  reason: collision with other field name */
    public Object f1953a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList f1954a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1955a;

    /* renamed from: b  reason: collision with other field name */
    public float f1956b;

    /* renamed from: b  reason: collision with other field name */
    public Drawable f1957b;

    /* renamed from: b  reason: collision with other field name */
    public final ViewDragHelper f1958b;

    /* renamed from: b  reason: collision with other field name */
    public final f f1959b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f1960b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList<View> f1961b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1962b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public final int f1963c;

    /* renamed from: c  reason: collision with other field name */
    public Drawable f1964c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1965c;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f1966d;

    /* renamed from: d  reason: collision with other field name */
    public Drawable f1967d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1968d;

    /* renamed from: e  reason: collision with other field name */
    public int f1969e;

    /* renamed from: e  reason: collision with other field name */
    public Drawable f1970e;

    /* renamed from: f  reason: collision with other field name */
    public int f1971f;

    /* renamed from: f  reason: collision with other field name */
    public Drawable f1972f;

    /* renamed from: g  reason: collision with other field name */
    public int f1973g;

    /* renamed from: g  reason: collision with other field name */
    public Drawable f1974g;
    public int h;
    public int i;

    public interface DrawerListener {
        void onDrawerClosed(View view);

        void onDrawerOpened(View view);

        void onDrawerSlide(View view, float f);

        void onDrawerStateChanged(int i);
    }

    public class a implements AccessibilityViewCommand {
        public a() {
        }

        public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            if (!DrawerLayout.k(view) || drawerLayout.g(view) == 2) {
                return false;
            }
            drawerLayout.b(view, true);
            return true;
        }
    }

    public class b implements View.OnApplyWindowInsetsListener {
        public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            boolean z;
            DrawerLayout drawerLayout = (DrawerLayout) view;
            if (windowInsets.getSystemWindowInsetTop() > 0) {
                z = true;
            } else {
                z = false;
            }
            drawerLayout.setChildInsets(windowInsets, z);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    public class c extends AccessibilityDelegateCompat {
        public final Rect a = new Rect();

        public c() {
        }

        public final boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence charSequence;
            if (accessibilityEvent.getEventType() != 32) {
                return super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            DrawerLayout drawerLayout = DrawerLayout.this;
            View f = drawerLayout.f();
            if (f == null) {
                return true;
            }
            int h = drawerLayout.h(f);
            drawerLayout.getClass();
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            int absoluteGravity = Gravity.getAbsoluteGravity(h, drawerLayout.getLayoutDirection());
            if (absoluteGravity == 3) {
                charSequence = drawerLayout.f1952a;
            } else if (absoluteGravity == 5) {
                charSequence = drawerLayout.f1960b;
            } else {
                charSequence = null;
            }
            if (charSequence == null) {
                return true;
            }
            text.add(charSequence);
            return true;
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.e) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.f1832a);
                super.onInitializeAccessibilityNodeInfo(view, new AccessibilityNodeInfoCompat(obtain));
                accessibilityNodeInfoCompat.b = -1;
                AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.f1832a;
                accessibilityNodeInfo.setSource(view);
                WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                ViewParent parentForAccessibility = view.getParentForAccessibility();
                if (parentForAccessibility instanceof View) {
                    accessibilityNodeInfoCompat.a = -1;
                    accessibilityNodeInfo.setParent((View) parentForAccessibility);
                }
                Rect rect = this.a;
                obtain.getBoundsInScreen(rect);
                accessibilityNodeInfo.setBoundsInScreen(rect);
                accessibilityNodeInfo.setVisibleToUser(obtain.isVisibleToUser());
                accessibilityNodeInfo.setPackageName(obtain.getPackageName());
                accessibilityNodeInfoCompat.j(obtain.getClassName());
                accessibilityNodeInfoCompat.m(obtain.getContentDescription());
                accessibilityNodeInfo.setEnabled(obtain.isEnabled());
                accessibilityNodeInfo.setFocused(obtain.isFocused());
                accessibilityNodeInfo.setAccessibilityFocused(obtain.isAccessibilityFocused());
                accessibilityNodeInfo.setSelected(obtain.isSelected());
                accessibilityNodeInfoCompat.a(obtain.getActions());
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (DrawerLayout.i(childAt)) {
                        accessibilityNodeInfo.addChild(childAt);
                    }
                }
            }
            accessibilityNodeInfoCompat.j("androidx.drawerlayout.widget.DrawerLayout");
            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCompat.f1832a;
            accessibilityNodeInfo2.setFocusable(false);
            accessibilityNodeInfo2.setFocused(false);
            accessibilityNodeInfoCompat.h(AccessibilityNodeInfoCompat.AccessibilityActionCompat.a);
            accessibilityNodeInfoCompat.h(AccessibilityNodeInfoCompat.AccessibilityActionCompat.b);
        }

        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.e || DrawerLayout.i(view)) {
                return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    public static final class d extends AccessibilityDelegateCompat {
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.i(view)) {
                accessibilityNodeInfoCompat.a = -1;
                accessibilityNodeInfoCompat.f1832a.setParent((View) null);
            }
        }
    }

    public class f extends ViewDragHelper.Callback {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public ViewDragHelper f1978a;

        /* renamed from: a  reason: collision with other field name */
        public final a f1979a = new a();

        public class a implements Runnable {
            public a() {
            }

            public final void run() {
                boolean z;
                int i;
                View view;
                int i2;
                f fVar = f.this;
                int i3 = fVar.f1978a.e;
                int i4 = fVar.a;
                int i5 = 3;
                if (i4 == 3) {
                    z = true;
                } else {
                    z = false;
                }
                DrawerLayout drawerLayout = DrawerLayout.this;
                if (z) {
                    view = drawerLayout.d(3);
                    if (view != null) {
                        i2 = -view.getWidth();
                    } else {
                        i2 = 0;
                    }
                    i = i2 + i3;
                } else {
                    view = drawerLayout.d(5);
                    i = drawerLayout.getWidth() - i3;
                }
                if (view == null) {
                    return;
                }
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && drawerLayout.g(view) == 0) {
                    fVar.f1978a.u(view, i, view.getTop());
                    ((LayoutParams) view.getLayoutParams()).f1976a = true;
                    drawerLayout.invalidate();
                    if (i4 == 3) {
                        i5 = 5;
                    }
                    View d = drawerLayout.d(i5);
                    if (d != null) {
                        drawerLayout.b(d, true);
                    }
                    if (!drawerLayout.f1965c) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        int childCount = drawerLayout.getChildCount();
                        for (int i6 = 0; i6 < childCount; i6++) {
                            drawerLayout.getChildAt(i6).dispatchTouchEvent(obtain);
                        }
                        obtain.recycle();
                        drawerLayout.f1965c = true;
                    }
                }
            }
        }

        public f(int i) {
            this.a = i;
        }

        public final int clampViewPositionHorizontal(View view, int i, int i2) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            if (drawerLayout.a(3, view)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = drawerLayout.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        public final int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public final int getViewHorizontalDragRange(View view) {
            DrawerLayout.this.getClass();
            if (DrawerLayout.l(view)) {
                return view.getWidth();
            }
            return 0;
        }

        public final void onEdgeDragStarted(int i, int i2) {
            View view;
            int i3 = i & 1;
            DrawerLayout drawerLayout = DrawerLayout.this;
            if (i3 == 1) {
                view = drawerLayout.d(3);
            } else {
                view = drawerLayout.d(5);
            }
            if (view != null && drawerLayout.g(view) == 0) {
                this.f1978a.c(i2, view);
            }
        }

        public final boolean onEdgeLock(int i) {
            return false;
        }

        public final void onEdgeTouched(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f1979a, 160);
        }

        public final void onViewCaptured(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f1976a = false;
            int i2 = 3;
            if (this.a == 3) {
                i2 = 5;
            }
            DrawerLayout drawerLayout = DrawerLayout.this;
            View d = drawerLayout.d(i2);
            if (d != null) {
                drawerLayout.b(d, true);
            }
        }

        public final void onViewDragStateChanged(int i) {
            DrawerLayout.this.r(i, this.f1978a.f1878a);
        }

        public final void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float f;
            int i5;
            int width = view.getWidth();
            DrawerLayout drawerLayout = DrawerLayout.this;
            if (drawerLayout.a(3, view)) {
                f = (float) (i + width);
            } else {
                f = (float) (drawerLayout.getWidth() - i);
            }
            float f2 = f / ((float) width);
            drawerLayout.o(f2, view);
            if (f2 == 0.0f) {
                i5 = 4;
            } else {
                i5 = 0;
            }
            view.setVisibility(i5);
            drawerLayout.invalidate();
        }

        public final void onViewReleased(View view, float f, float f2) {
            int i;
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            float f3 = ((LayoutParams) view.getLayoutParams()).a;
            int width = view.getWidth();
            if (drawerLayout.a(3, view)) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 > 0 || (i2 == 0 && f3 > 0.5f)) {
                    i = 0;
                } else {
                    i = -width;
                }
            } else {
                int width2 = drawerLayout.getWidth();
                if (f < 0.0f || (f == 0.0f && f3 > 0.5f)) {
                    width2 -= width;
                }
                i = width2;
            }
            this.f1978a.s(i, view.getTop());
            drawerLayout.invalidate();
        }

        public final boolean tryCaptureView(View view, int i) {
            DrawerLayout drawerLayout = DrawerLayout.this;
            drawerLayout.getClass();
            if (!DrawerLayout.l(view) || !drawerLayout.a(this.a, view) || drawerLayout.g(view) != 0) {
                return false;
            }
            return true;
        }
    }

    static {
        boolean z = true;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29) {
            z = false;
        }
        g = z;
    }

    public DrawerLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public static boolean i(View view) {
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        if (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) {
            return false;
        }
        return true;
    }

    public static boolean j(View view) {
        if (((LayoutParams) view.getLayoutParams()).f1975a == 0) {
            return true;
        }
        return false;
    }

    public static boolean k(View view) {
        if (!l(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        } else if ((((LayoutParams) view.getLayoutParams()).b & 1) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean l(View view) {
        int i2 = ((LayoutParams) view.getLayoutParams()).f1975a;
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        if ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) {
            return false;
        }
        return true;
    }

    public final boolean a(int i2, View view) {
        if ((h(view) & i2) == i2) {
            return true;
        }
        return false;
    }

    public final void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        ArrayList<View> arrayList2;
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            int i4 = 0;
            boolean z = false;
            while (true) {
                arrayList2 = this.f1961b;
                if (i4 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i4);
                if (!l(childAt)) {
                    arrayList2.add(childAt);
                } else if (k(childAt)) {
                    childAt.addFocusables(arrayList, i2, i3);
                    z = true;
                }
                i4++;
            }
            if (!z) {
                int size = arrayList2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    View view = arrayList2.get(i5);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i2, i3);
                    }
                }
            }
            arrayList2.clear();
        }
    }

    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        if (e() != null || l(view)) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            view.setImportantForAccessibility(4);
        } else {
            WeakHashMap<View, GC> weakHashMap2 = androidx.core.view.f.f1839a;
            view.setImportantForAccessibility(1);
        }
        if (!e) {
            androidx.core.view.f.o(view, this.f1950a);
        }
    }

    public final void b(View view, boolean z) {
        if (l(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f1962b) {
                layoutParams.a = 0.0f;
                layoutParams.b = 0;
            } else if (z) {
                layoutParams.b |= 4;
                if (a(3, view)) {
                    this.f1947a.u(view, -view.getWidth(), view.getTop());
                } else {
                    this.f1958b.u(view, getWidth(), view.getTop());
                }
            } else {
                float f2 = ((LayoutParams) view.getLayoutParams()).a;
                float width = (float) view.getWidth();
                int i2 = ((int) (width * 0.0f)) - ((int) (f2 * width));
                if (!a(3, view)) {
                    i2 = -i2;
                }
                view.offsetLeftAndRight(i2);
                o(0.0f, view);
                r(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void c(boolean z) {
        boolean z2;
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (l(childAt) && (!z || layoutParams.f1976a)) {
                int width = childAt.getWidth();
                if (a(3, childAt)) {
                    z2 = this.f1947a.u(childAt, -width, childAt.getTop());
                } else {
                    z2 = this.f1958b.u(childAt, getWidth(), childAt.getTop());
                }
                z3 |= z2;
                layoutParams.f1976a = false;
            }
        }
        f fVar = this.f1951a;
        DrawerLayout.this.removeCallbacks(fVar.f1979a);
        f fVar2 = this.f1959b;
        DrawerLayout.this.removeCallbacks(fVar2.f1979a);
        if (z3) {
            invalidate();
        }
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (!(layoutParams instanceof LayoutParams) || !super.checkLayoutParams(layoutParams)) {
            return false;
        }
        return true;
    }

    public final void computeScroll() {
        int childCount = getChildCount();
        float f2 = 0.0f;
        for (int i2 = 0; i2 < childCount; i2++) {
            f2 = Math.max(f2, ((LayoutParams) getChildAt(i2).getLayoutParams()).a);
        }
        this.f1956b = f2;
        boolean h2 = this.f1947a.h();
        boolean h3 = this.f1958b.h();
        if (h2 || h3) {
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            postInvalidateOnAnimation();
        }
    }

    public final View d(int i2) {
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if ((h(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean z;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f1956b <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            View childAt = getChildAt(i2);
            if (this.f1945a == null) {
                this.f1945a = new Rect();
            }
            childAt.getHitRect(this.f1945a);
            if (this.f1945a.contains((int) x, (int) y) && !j(childAt)) {
                if (!childAt.getMatrix().isIdentity()) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation((float) (getScrollX() - childAt.getLeft()), (float) (getScrollY() - childAt.getTop()));
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.f1943a == null) {
                            this.f1943a = new Matrix();
                        }
                        matrix.invert(this.f1943a);
                        obtain.transform(this.f1943a);
                    }
                    z = childAt.dispatchGenericMotionEvent(obtain);
                    obtain.recycle();
                } else {
                    float scrollX = (float) (getScrollX() - childAt.getLeft());
                    float scrollY = (float) (getScrollY() - childAt.getTop());
                    motionEvent.offsetLocation(scrollX, scrollY);
                    z = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        Canvas canvas2 = canvas;
        View view2 = view;
        int height = getHeight();
        boolean j2 = j(view);
        int width = getWidth();
        int save = canvas.save();
        int i2 = 0;
        if (j2) {
            int childCount = getChildCount();
            int i3 = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt != view2 && childAt.getVisibility() == 0) {
                    Drawable background = childAt.getBackground();
                    if (background == null || background.getOpacity() != -1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z && l(childAt) && childAt.getHeight() >= height) {
                        if (a(3, childAt)) {
                            int right = childAt.getRight();
                            if (right > i3) {
                                i3 = right;
                            }
                        } else {
                            int left = childAt.getLeft();
                            if (left < width) {
                                width = left;
                            }
                        }
                    }
                }
            }
            canvas2.clipRect(i3, 0, width, getHeight());
            i2 = i3;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas2.restoreToCount(save);
        float f2 = this.f1956b;
        if (f2 > 0.0f && j2) {
            int i5 = this.f1966d;
            Paint paint = this.f1944a;
            paint.setColor((i5 & 16777215) | (((int) (((float) ((-16777216 & i5) >>> 24)) * f2)) << 24));
            canvas.drawRect((float) i2, 0.0f, (float) width, (float) getHeight(), paint);
        } else if (this.f1957b != null && a(3, view2)) {
            int intrinsicWidth = this.f1957b.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(((float) right2) / ((float) this.f1947a.e), 1.0f));
            this.f1957b.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f1957b.setAlpha((int) (max * 255.0f));
            this.f1957b.draw(canvas2);
        } else if (this.f1964c != null && a(5, view2)) {
            int intrinsicWidth2 = this.f1964c.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min(((float) (getWidth() - left2)) / ((float) this.f1958b.e), 1.0f));
            this.f1964c.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f1964c.setAlpha((int) (max2 * 255.0f));
            this.f1964c.draw(canvas2);
        }
        return drawChild;
    }

    public final View e() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((((LayoutParams) childAt.getLayoutParams()).b & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View f() {
        boolean z;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (l(childAt)) {
                if (l(childAt)) {
                    if (((LayoutParams) childAt.getLayoutParams()).a > 0.0f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public final int g(View view) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (l(view)) {
            int i6 = ((LayoutParams) view.getLayoutParams()).f1975a;
            WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
            int layoutDirection = getLayoutDirection();
            if (i6 == 3) {
                int i7 = this.f1971f;
                if (i7 != 3) {
                    return i7;
                }
                if (layoutDirection == 0) {
                    i2 = this.h;
                } else {
                    i2 = this.i;
                }
                if (i2 != 3) {
                    return i2;
                }
            } else if (i6 == 5) {
                int i8 = this.f1973g;
                if (i8 != 3) {
                    return i8;
                }
                if (layoutDirection == 0) {
                    i3 = this.i;
                } else {
                    i3 = this.h;
                }
                if (i3 != 3) {
                    return i3;
                }
            } else if (i6 == 8388611) {
                int i9 = this.h;
                if (i9 != 3) {
                    return i9;
                }
                if (layoutDirection == 0) {
                    i4 = this.f1971f;
                } else {
                    i4 = this.f1973g;
                }
                if (i4 != 3) {
                    return i4;
                }
            } else if (i6 == 8388613) {
                int i10 = this.i;
                if (i10 != 3) {
                    return i10;
                }
                if (layoutDirection == 0) {
                    i5 = this.f1973g;
                } else {
                    i5 = this.f1971f;
                }
                if (i5 != 3) {
                    return i5;
                }
            }
            return 0;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        if (f) {
            return this.f1942a;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f1946a;
    }

    public final int h(View view) {
        int i2 = ((LayoutParams) view.getLayoutParams()).f1975a;
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        return Gravity.getAbsoluteGravity(i2, getLayoutDirection());
    }

    public final void m(View view) {
        if (l(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.f1962b) {
                layoutParams.a = 1.0f;
                layoutParams.b = 1;
                q(view, true);
                p(view);
            } else {
                layoutParams.b |= 2;
                if (a(3, view)) {
                    this.f1947a.u(view, 0, view.getTop());
                } else {
                    this.f1958b.u(view, getWidth() - view.getWidth(), view.getTop());
                }
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r3 = this;
            boolean r0 = f
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.util.WeakHashMap<android.view.View, GC> r0 = androidx.core.view.f.f1839a
            int r0 = r3.getLayoutDirection()
            if (r0 != 0) goto L_0x001d
            android.graphics.drawable.Drawable r1 = r3.f1967d
            if (r1 == 0) goto L_0x002d
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L_0x001a
            defpackage.v9.b.b(r1, r0)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r3.f1967d
            goto L_0x002f
        L_0x001d:
            android.graphics.drawable.Drawable r1 = r3.f1970e
            if (r1 == 0) goto L_0x002d
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L_0x002a
            defpackage.v9.b.b(r1, r0)
        L_0x002a:
            android.graphics.drawable.Drawable r0 = r3.f1970e
            goto L_0x002f
        L_0x002d:
            android.graphics.drawable.Drawable r0 = r3.f1972f
        L_0x002f:
            r3.f1957b = r0
            int r0 = r3.getLayoutDirection()
            if (r0 != 0) goto L_0x0047
            android.graphics.drawable.Drawable r1 = r3.f1970e
            if (r1 == 0) goto L_0x0057
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L_0x0044
            defpackage.v9.b.b(r1, r0)
        L_0x0044:
            android.graphics.drawable.Drawable r0 = r3.f1970e
            goto L_0x0059
        L_0x0047:
            android.graphics.drawable.Drawable r1 = r3.f1967d
            if (r1 == 0) goto L_0x0057
            boolean r2 = r1.isAutoMirrored()
            if (r2 == 0) goto L_0x0054
            defpackage.v9.b.b(r1, r0)
        L_0x0054:
            android.graphics.drawable.Drawable r0 = r3.f1967d
            goto L_0x0059
        L_0x0057:
            android.graphics.drawable.Drawable r0 = r3.f1974g
        L_0x0059:
            r3.f1964c = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.n():void");
    }

    public final void o(float f2, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 != layoutParams.a) {
            layoutParams.a = f2;
            ArrayList arrayList = this.f1954a;
            if (arrayList != null) {
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        ((DrawerListener) this.f1954a.get(size)).onDrawerSlide(view, f2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1962b = true;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1962b = true;
    }

    public final void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        if (this.f1968d && this.f1946a != null) {
            Object obj = this.f1953a;
            if (obj != null) {
                i2 = ((WindowInsets) obj).getSystemWindowInsetTop();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                this.f1946a.setBounds(0, 0, getWidth(), i2);
                this.f1946a.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
        if (r0 != 3) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055 A[LOOP:0: B:8:0x0022->B:20:0x0055, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0053 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r9) {
        /*
            r8 = this;
            int r0 = r9.getActionMasked()
            androidx.customview.widget.ViewDragHelper r1 = r8.f1947a
            boolean r2 = r1.t(r9)
            androidx.customview.widget.ViewDragHelper r3 = r8.f1958b
            boolean r3 = r3.t(r9)
            r2 = r2 | r3
            r3 = 1
            r4 = 0
            if (r0 == 0) goto L_0x0075
            if (r0 == r3) goto L_0x006e
            r9 = 2
            if (r0 == r9) goto L_0x001e
            r9 = 3
            if (r0 == r9) goto L_0x006e
            goto L_0x0073
        L_0x001e:
            float[] r9 = r1.f1884a
            int r9 = r9.length
            r0 = r4
        L_0x0022:
            if (r0 >= r9) goto L_0x0058
            int r5 = r1.d
            int r6 = r3 << r0
            r5 = r5 & r6
            if (r5 == 0) goto L_0x002d
            r5 = r3
            goto L_0x002e
        L_0x002d:
            r5 = r4
        L_0x002e:
            if (r5 != 0) goto L_0x0031
            goto L_0x0050
        L_0x0031:
            float[] r5 = r1.f1889c
            r5 = r5[r0]
            float[] r6 = r1.f1884a
            r6 = r6[r0]
            float r5 = r5 - r6
            float[] r6 = r1.f1891d
            r6 = r6[r0]
            float[] r7 = r1.f1887b
            r7 = r7[r0]
            float r6 = r6 - r7
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r5 = r1.f1886b
            int r5 = r5 * r5
            float r5 = (float) r5
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0050
            r5 = r3
            goto L_0x0051
        L_0x0050:
            r5 = r4
        L_0x0051:
            if (r5 == 0) goto L_0x0055
            r9 = r3
            goto L_0x0059
        L_0x0055:
            int r0 = r0 + 1
            goto L_0x0022
        L_0x0058:
            r9 = r4
        L_0x0059:
            if (r9 == 0) goto L_0x0073
            androidx.drawerlayout.widget.DrawerLayout$f r9 = r8.f1951a
            androidx.drawerlayout.widget.DrawerLayout$f$a r0 = r9.f1979a
            androidx.drawerlayout.widget.DrawerLayout r9 = androidx.drawerlayout.widget.DrawerLayout.this
            r9.removeCallbacks(r0)
            androidx.drawerlayout.widget.DrawerLayout$f r9 = r8.f1959b
            androidx.drawerlayout.widget.DrawerLayout$f$a r0 = r9.f1979a
            androidx.drawerlayout.widget.DrawerLayout r9 = androidx.drawerlayout.widget.DrawerLayout.this
            r9.removeCallbacks(r0)
            goto L_0x0073
        L_0x006e:
            r8.c(r3)
            r8.f1965c = r4
        L_0x0073:
            r9 = r4
            goto L_0x009b
        L_0x0075:
            float r0 = r9.getX()
            float r9 = r9.getY()
            r8.c = r0
            r8.d = r9
            float r5 = r8.f1956b
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0098
            int r0 = (int) r0
            int r9 = (int) r9
            android.view.View r9 = r1.j(r0, r9)
            if (r9 == 0) goto L_0x0098
            boolean r9 = j(r9)
            if (r9 == 0) goto L_0x0098
            r9 = r3
            goto L_0x0099
        L_0x0098:
            r9 = r4
        L_0x0099:
            r8.f1965c = r4
        L_0x009b:
            if (r2 != 0) goto L_0x00c2
            if (r9 != 0) goto L_0x00c2
            int r9 = r8.getChildCount()
            r0 = r4
        L_0x00a4:
            if (r0 >= r9) goto L_0x00b9
            android.view.View r1 = r8.getChildAt(r0)
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r1 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r1
            boolean r1 = r1.f1976a
            if (r1 == 0) goto L_0x00b6
            r9 = r3
            goto L_0x00ba
        L_0x00b6:
            int r0 = r0 + 1
            goto L_0x00a4
        L_0x00b9:
            r9 = r4
        L_0x00ba:
            if (r9 != 0) goto L_0x00c2
            boolean r9 = r8.f1965c
            if (r9 == 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r3 = r4
        L_0x00c2:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z;
        if (i2 == 4) {
            if (f() != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                keyEvent.startTracking();
                return true;
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            return super.onKeyUp(i2, keyEvent);
        }
        View f2 = f();
        if (f2 != null && g(f2) == 0) {
            c(false);
        }
        if (f2 != null) {
            return true;
        }
        return false;
    }

    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        WindowInsets rootWindowInsets;
        float f2;
        int i6;
        boolean z2;
        int i7;
        boolean z3 = true;
        this.f1955a = true;
        int i8 = i4 - i2;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (j(childAt)) {
                    int i10 = layoutParams.leftMargin;
                    childAt.layout(i10, layoutParams.topMargin, childAt.getMeasuredWidth() + i10, childAt.getMeasuredHeight() + layoutParams.topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(3, childAt)) {
                        float f3 = (float) measuredWidth;
                        i6 = (-measuredWidth) + ((int) (layoutParams.a * f3));
                        f2 = ((float) (measuredWidth + i6)) / f3;
                    } else {
                        float f4 = (float) measuredWidth;
                        int i11 = i8 - ((int) (layoutParams.a * f4));
                        f2 = ((float) (i8 - i11)) / f4;
                        i6 = i11;
                    }
                    if (f2 != layoutParams.a) {
                        z2 = z3;
                    } else {
                        z2 = false;
                    }
                    int i12 = layoutParams.f1975a & 112;
                    if (i12 == 16) {
                        int i13 = i5 - i3;
                        int i14 = (i13 - measuredHeight) / 2;
                        int i15 = layoutParams.topMargin;
                        if (i14 < i15) {
                            i14 = i15;
                        } else {
                            int i16 = i14 + measuredHeight;
                            int i17 = i13 - layoutParams.bottomMargin;
                            if (i16 > i17) {
                                i14 = i17 - measuredHeight;
                            }
                        }
                        childAt.layout(i6, i14, measuredWidth + i6, measuredHeight + i14);
                    } else if (i12 != 80) {
                        int i18 = layoutParams.topMargin;
                        childAt.layout(i6, i18, measuredWidth + i6, measuredHeight + i18);
                    } else {
                        int i19 = i5 - i3;
                        childAt.layout(i6, (i19 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i6, i19 - layoutParams.bottomMargin);
                    }
                    if (z2) {
                        o(f2, childAt);
                    }
                    if (layoutParams.a > 0.0f) {
                        i7 = 0;
                    } else {
                        i7 = 4;
                    }
                    if (childAt.getVisibility() != i7) {
                        childAt.setVisibility(i7);
                    }
                }
            }
            i9++;
            z3 = true;
        }
        if (g && (rootWindowInsets = getRootWindowInsets()) != null) {
            bg i20 = WindowInsetsCompat.i((View) null, rootWindowInsets).f1818a.i();
            ViewDragHelper viewDragHelper = this.f1947a;
            viewDragHelper.e = Math.max(viewDragHelper.f, i20.f2741a);
            ViewDragHelper viewDragHelper2 = this.f1958b;
            viewDragHelper2.e = Math.max(viewDragHelper2.f, i20.c);
        }
        this.f1955a = false;
        this.f1962b = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    @android.annotation.SuppressLint({"WrongConstant"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            int r1 = android.view.View.MeasureSpec.getMode(r17)
            int r2 = android.view.View.MeasureSpec.getMode(r18)
            int r3 = android.view.View.MeasureSpec.getSize(r17)
            int r4 = android.view.View.MeasureSpec.getSize(r18)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r1 != r5) goto L_0x0018
            if (r2 == r5) goto L_0x0026
        L_0x0018:
            boolean r5 = r16.isInEditMode()
            if (r5 == 0) goto L_0x01a1
            r5 = 300(0x12c, float:4.2E-43)
            if (r1 != 0) goto L_0x0023
            r3 = r5
        L_0x0023:
            if (r2 != 0) goto L_0x0026
            r4 = r5
        L_0x0026:
            r0.setMeasuredDimension(r3, r4)
            java.lang.Object r1 = r0.f1953a
            r2 = 0
            if (r1 == 0) goto L_0x0038
            java.util.WeakHashMap<android.view.View, GC> r1 = androidx.core.view.f.f1839a
            boolean r1 = r16.getFitsSystemWindows()
            if (r1 == 0) goto L_0x0038
            r1 = 1
            goto L_0x0039
        L_0x0038:
            r1 = r2
        L_0x0039:
            java.util.WeakHashMap<android.view.View, GC> r5 = androidx.core.view.f.f1839a
            int r5 = r16.getLayoutDirection()
            int r6 = r16.getChildCount()
            r7 = r2
            r8 = r7
            r9 = r8
        L_0x0046:
            if (r7 >= r6) goto L_0x01a0
            android.view.View r10 = r0.getChildAt(r7)
            int r11 = r10.getVisibility()
            r12 = 8
            if (r11 != r12) goto L_0x0056
            goto L_0x00fd
        L_0x0056:
            android.view.ViewGroup$LayoutParams r11 = r10.getLayoutParams()
            androidx.drawerlayout.widget.DrawerLayout$LayoutParams r11 = (androidx.drawerlayout.widget.DrawerLayout.LayoutParams) r11
            r12 = 3
            if (r1 == 0) goto L_0x00dc
            int r13 = r11.f1975a
            int r13 = android.view.Gravity.getAbsoluteGravity(r13, r5)
            boolean r14 = r10.getFitsSystemWindows()
            if (r14 == 0) goto L_0x0099
            java.lang.Object r14 = r0.f1953a
            android.view.WindowInsets r14 = (android.view.WindowInsets) r14
            if (r13 != r12) goto L_0x0082
            int r12 = r14.getSystemWindowInsetLeft()
            int r13 = r14.getSystemWindowInsetTop()
            int r15 = r14.getSystemWindowInsetBottom()
            android.view.WindowInsets r14 = r14.replaceSystemWindowInsets(r12, r13, r2, r15)
            goto L_0x0095
        L_0x0082:
            r12 = 5
            if (r13 != r12) goto L_0x0095
            int r12 = r14.getSystemWindowInsetTop()
            int r13 = r14.getSystemWindowInsetRight()
            int r15 = r14.getSystemWindowInsetBottom()
            android.view.WindowInsets r14 = r14.replaceSystemWindowInsets(r2, r12, r13, r15)
        L_0x0095:
            r10.dispatchApplyWindowInsets(r14)
            goto L_0x00dc
        L_0x0099:
            java.lang.Object r12 = r0.f1953a
            android.view.WindowInsets r12 = (android.view.WindowInsets) r12
            r14 = 3
            if (r13 != r14) goto L_0x00b1
            int r13 = r12.getSystemWindowInsetLeft()
            int r14 = r12.getSystemWindowInsetTop()
            int r15 = r12.getSystemWindowInsetBottom()
            android.view.WindowInsets r12 = r12.replaceSystemWindowInsets(r13, r14, r2, r15)
            goto L_0x00c4
        L_0x00b1:
            r14 = 5
            if (r13 != r14) goto L_0x00c4
            int r13 = r12.getSystemWindowInsetTop()
            int r14 = r12.getSystemWindowInsetRight()
            int r15 = r12.getSystemWindowInsetBottom()
            android.view.WindowInsets r12 = r12.replaceSystemWindowInsets(r2, r13, r14, r15)
        L_0x00c4:
            int r13 = r12.getSystemWindowInsetLeft()
            r11.leftMargin = r13
            int r13 = r12.getSystemWindowInsetTop()
            r11.topMargin = r13
            int r13 = r12.getSystemWindowInsetRight()
            r11.rightMargin = r13
            int r12 = r12.getSystemWindowInsetBottom()
            r11.bottomMargin = r12
        L_0x00dc:
            boolean r12 = j(r10)
            if (r12 == 0) goto L_0x0103
            int r12 = r11.leftMargin
            int r12 = r3 - r12
            int r13 = r11.rightMargin
            int r12 = r12 - r13
            r13 = 1073741824(0x40000000, float:2.0)
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r13)
            int r14 = r11.topMargin
            int r14 = r4 - r14
            int r11 = r11.bottomMargin
            int r14 = r14 - r11
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r13)
            r10.measure(r12, r11)
        L_0x00fd:
            r14 = r17
            r15 = r18
            goto L_0x017b
        L_0x0103:
            boolean r12 = l(r10)
            if (r12 == 0) goto L_0x017f
            boolean r12 = f
            if (r12 == 0) goto L_0x011a
            float r12 = androidx.core.view.f.d.i(r10)
            float r13 = r0.f1942a
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 == 0) goto L_0x011a
            androidx.core.view.f.d.s(r10, r13)
        L_0x011a:
            int r12 = r0.h(r10)
            r12 = r12 & 7
            r13 = 3
            if (r12 != r13) goto L_0x0125
            r13 = 1
            goto L_0x0126
        L_0x0125:
            r13 = r2
        L_0x0126:
            if (r13 == 0) goto L_0x012a
            if (r8 != 0) goto L_0x012f
        L_0x012a:
            if (r13 != 0) goto L_0x0156
            if (r9 != 0) goto L_0x012f
            goto L_0x0156
        L_0x012f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Child drawer has absolute gravity "
            r2.<init>(r3)
            r3 = r12 & 3
            r4 = 3
            if (r3 == r4) goto L_0x014a
            r3 = r12 & 5
            r4 = 5
            if (r3 != r4) goto L_0x0145
            java.lang.String r3 = "RIGHT"
            goto L_0x014c
        L_0x0145:
            java.lang.String r3 = java.lang.Integer.toHexString(r12)
            goto L_0x014c
        L_0x014a:
            java.lang.String r3 = "LEFT"
        L_0x014c:
            java.lang.String r4 = " but this DrawerLayout already has a drawer view along that edge"
            java.lang.String r2 = defpackage.C0709Uj.j(r2, r3, r4)
            r1.<init>(r2)
            throw r1
        L_0x0156:
            if (r13 == 0) goto L_0x015a
            r8 = 1
            goto L_0x015b
        L_0x015a:
            r9 = 1
        L_0x015b:
            int r12 = r11.leftMargin
            int r13 = r0.f1963c
            int r13 = r13 + r12
            int r12 = r11.rightMargin
            int r13 = r13 + r12
            int r12 = r11.width
            r14 = r17
            int r12 = android.view.ViewGroup.getChildMeasureSpec(r14, r13, r12)
            int r13 = r11.topMargin
            int r15 = r11.bottomMargin
            int r13 = r13 + r15
            int r11 = r11.height
            r15 = r18
            int r11 = android.view.ViewGroup.getChildMeasureSpec(r15, r13, r11)
            r10.measure(r12, r11)
        L_0x017b:
            int r7 = r7 + 1
            goto L_0x0046
        L_0x017f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Child "
            r2.<init>(r3)
            r2.append(r10)
            java.lang.String r3 = " at index "
            r2.append(r3)
            r2.append(r7)
            java.lang.String r3 = " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01a0:
            return
        L_0x01a1:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "DrawerLayout must be measured with MeasureSpec.EXACTLY."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onMeasure(int, int):void");
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        View d2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int i2 = savedState.c;
        if (!(i2 == 0 || (d2 = d(i2)) == null)) {
            m(d2);
        }
        int i3 = savedState.d;
        if (i3 != 3) {
            setDrawerLockMode(i3, 3);
        }
        int i4 = savedState.e;
        if (i4 != 3) {
            setDrawerLockMode(i4, 5);
        }
        int i5 = savedState.f;
        if (i5 != 3) {
            setDrawerLockMode(i5, 8388611);
        }
        int i6 = savedState.g;
        if (i6 != 3) {
            setDrawerLockMode(i6, 8388613);
        }
    }

    public final void onRtlPropertiesChanged(int i2) {
        n();
    }

    public final Parcelable onSaveInstanceState() {
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            int i3 = layoutParams.b;
            boolean z2 = true;
            if (i3 == 1) {
                z = true;
            } else {
                z = false;
            }
            if (i3 != 2) {
                z2 = false;
            }
            if (z || z2) {
                savedState.c = layoutParams.f1975a;
            } else {
                i2++;
            }
        }
        savedState.d = this.f1971f;
        savedState.e = this.f1973g;
        savedState.f = this.h;
        savedState.g = this.i;
        return savedState;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0052, code lost:
        if (g(r7) != 2) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            androidx.customview.widget.ViewDragHelper r0 = r6.f1947a
            r0.m(r7)
            androidx.customview.widget.ViewDragHelper r1 = r6.f1958b
            r1.m(r7)
            int r1 = r7.getAction()
            r1 = r1 & 255(0xff, float:3.57E-43)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0059
            if (r1 == r3) goto L_0x0020
            r7 = 3
            if (r1 == r7) goto L_0x001a
            goto L_0x0067
        L_0x001a:
            r6.c(r3)
            r6.f1965c = r2
            goto L_0x0067
        L_0x0020:
            float r1 = r7.getX()
            float r7 = r7.getY()
            int r4 = (int) r1
            int r5 = (int) r7
            android.view.View r4 = r0.j(r4, r5)
            if (r4 == 0) goto L_0x0054
            boolean r4 = j(r4)
            if (r4 == 0) goto L_0x0054
            float r4 = r6.c
            float r1 = r1 - r4
            float r4 = r6.d
            float r7 = r7 - r4
            int r0 = r0.f1886b
            float r1 = r1 * r1
            float r7 = r7 * r7
            float r7 = r7 + r1
            int r0 = r0 * r0
            float r0 = (float) r0
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L_0x0054
            android.view.View r7 = r6.e()
            if (r7 == 0) goto L_0x0054
            int r7 = r6.g(r7)
            r0 = 2
            if (r7 != r0) goto L_0x0055
        L_0x0054:
            r2 = r3
        L_0x0055:
            r6.c(r2)
            goto L_0x0067
        L_0x0059:
            float r0 = r7.getX()
            float r7 = r7.getY()
            r6.c = r0
            r6.d = r7
            r6.f1965c = r2
        L_0x0067:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.drawerlayout.widget.DrawerLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p(View view) {
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.h;
        androidx.core.view.f.l(accessibilityActionCompat.a(), view);
        androidx.core.view.f.i(0, view);
        if (k(view) && g(view) != 2) {
            androidx.core.view.f.m(view, accessibilityActionCompat, (String) null, this.f1949a);
        }
    }

    public final void q(View view, boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((z || l(childAt)) && (!z || childAt != view)) {
                WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                childAt.setImportantForAccessibility(4);
            } else {
                WeakHashMap<View, GC> weakHashMap2 = androidx.core.view.f.f1839a;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    public final void r(int i2, View view) {
        int i3;
        View rootView;
        int i4 = this.f1947a.f1876a;
        int i5 = this.f1958b.f1876a;
        if (i4 == 1 || i5 == 1) {
            i3 = 1;
        } else {
            i3 = 2;
            if (!(i4 == 2 || i5 == 2)) {
                i3 = 0;
            }
        }
        if (view != null && i2 == 0) {
            float f2 = ((LayoutParams) view.getLayoutParams()).a;
            if (f2 == 0.0f) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if ((layoutParams.b & 1) == 1) {
                    layoutParams.b = 0;
                    ArrayList arrayList = this.f1954a;
                    if (arrayList != null) {
                        for (int size = arrayList.size() - 1; size >= 0; size--) {
                            ((DrawerListener) this.f1954a.get(size)).onDrawerClosed(view);
                        }
                    }
                    q(view, false);
                    p(view);
                    if (hasWindowFocus() && (rootView = getRootView()) != null) {
                        rootView.sendAccessibilityEvent(32);
                    }
                }
            } else if (f2 == 1.0f) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                if ((layoutParams2.b & 1) == 0) {
                    layoutParams2.b = 1;
                    ArrayList arrayList2 = this.f1954a;
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ((DrawerListener) this.f1954a.get(size2)).onDrawerOpened(view);
                        }
                    }
                    q(view, true);
                    p(view);
                    if (hasWindowFocus()) {
                        sendAccessibilityEvent(32);
                    }
                }
            }
        }
        if (i3 != this.f1969e) {
            this.f1969e = i3;
            ArrayList arrayList3 = this.f1954a;
            if (arrayList3 != null) {
                for (int size3 = arrayList3.size() - 1; size3 >= 0; size3--) {
                    ((DrawerListener) this.f1954a.get(size3)).onDrawerStateChanged(i3);
                }
            }
        }
    }

    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            c(true);
        }
    }

    public final void requestLayout() {
        if (!this.f1955a) {
            super.requestLayout();
        }
    }

    public void setChildInsets(Object obj, boolean z) {
        boolean z2;
        this.f1953a = obj;
        this.f1968d = z;
        if (z || getBackground() != null) {
            z2 = false;
        } else {
            z2 = true;
        }
        setWillNotDraw(z2);
        requestLayout();
    }

    public void setDrawerElevation(float f2) {
        this.f1942a = f2;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (l(childAt)) {
                float f3 = this.f1942a;
                WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
                f.d.s(childAt, f3);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        ArrayList arrayList;
        DrawerListener drawerListener2 = this.f1948a;
        if (!(drawerListener2 == null || (arrayList = this.f1954a) == null)) {
            arrayList.remove(drawerListener2);
        }
        if (drawerListener != null) {
            if (this.f1954a == null) {
                this.f1954a = new ArrayList();
            }
            this.f1954a.add(drawerListener);
        }
        this.f1948a = drawerListener;
    }

    public void setDrawerLockMode(int i2) {
        setDrawerLockMode(i2, 3);
        setDrawerLockMode(i2, 5);
    }

    public void setDrawerShadow(Drawable drawable, int i2) {
        if (!f) {
            if ((i2 & 8388611) == 8388611) {
                this.f1967d = drawable;
            } else if ((i2 & 8388613) == 8388613) {
                this.f1970e = drawable;
            } else if ((i2 & 3) == 3) {
                this.f1972f = drawable;
            } else if ((i2 & 5) == 5) {
                this.f1974g = drawable;
            } else {
                return;
            }
            n();
            invalidate();
        }
    }

    public void setDrawerTitle(int i2, CharSequence charSequence) {
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        if (absoluteGravity == 3) {
            this.f1952a = charSequence;
        } else if (absoluteGravity == 5) {
            this.f1960b = charSequence;
        }
    }

    public void setScrimColor(int i2) {
        this.f1966d = i2;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f1946a = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i2) {
        this.f1946a = new ColorDrawable(i2);
        invalidate();
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, er.drawerLayoutStyle);
    }

    /* JADX INFO: finally extract failed */
    public DrawerLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1950a = new d();
        this.f1966d = -1728053248;
        this.f1944a = new Paint();
        this.f1962b = true;
        this.f1971f = 3;
        this.f1973g = 3;
        this.h = 3;
        this.i = 3;
        this.f1967d = null;
        this.f1970e = null;
        this.f1972f = null;
        this.f1974g = null;
        this.f1949a = new a();
        setDescendantFocusability(262144);
        float f2 = getResources().getDisplayMetrics().density;
        this.f1963c = (int) ((64.0f * f2) + 0.5f);
        float f3 = f2 * 400.0f;
        f fVar = new f(3);
        this.f1951a = fVar;
        f fVar2 = new f(5);
        this.f1959b = fVar2;
        ViewDragHelper i3 = ViewDragHelper.i(this, 1.0f, fVar);
        this.f1947a = i3;
        i3.g = 1;
        i3.b = f3;
        fVar.f1978a = i3;
        ViewDragHelper i4 = ViewDragHelper.i(this, 1.0f, fVar2);
        this.f1958b = i4;
        i4.g = 2;
        i4.b = f3;
        fVar2.f1978a = i4;
        setFocusableInTouchMode(true);
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        setImportantForAccessibility(1);
        androidx.core.view.f.o(this, new c());
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new b());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
            try {
                this.f1946a = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, ks.DrawerLayout, i2, 0);
        try {
            int i5 = ks.DrawerLayout_elevation;
            if (obtainStyledAttributes2.hasValue(i5)) {
                this.f1942a = obtainStyledAttributes2.getDimension(i5, 0.0f);
            } else {
                this.f1942a = getResources().getDimension(C0320rr.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.f1961b = new ArrayList<>();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public void setDrawerLockMode(int i2, int i3) {
        View d2;
        WeakHashMap<View, GC> weakHashMap = androidx.core.view.f.f1839a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i3, getLayoutDirection());
        if (i3 == 3) {
            this.f1971f = i2;
        } else if (i3 == 5) {
            this.f1973g = i2;
        } else if (i3 == 8388611) {
            this.h = i2;
        } else if (i3 == 8388613) {
            this.i = i2;
        }
        if (i2 != 0) {
            (absoluteGravity == 3 ? this.f1947a : this.f1958b).b();
        }
        if (i2 == 1) {
            View d3 = d(absoluteGravity);
            if (d3 != null) {
                b(d3, true);
            }
        } else if (i2 == 2 && (d2 = d(absoluteGravity)) != null) {
            m(d2);
        }
    }

    public void setStatusBarBackground(int i2) {
        Drawable drawable;
        if (i2 != 0) {
            Context context = getContext();
            Object obj = d7.a;
            drawable = d7.a.b(context, i2);
        } else {
            drawable = null;
        }
        this.f1946a = drawable;
        invalidate();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public final int f1975a = 0;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1976a;
        public int b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.b);
            this.f1975a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1975a = layoutParams.f1975a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int c = 0;
        public int d;
        public int e;
        public int f;
        public int g;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
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

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.g = parcel.readInt();
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeInt(this.g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void setDrawerShadow(int i2, int i3) {
        Context context = getContext();
        Object obj = d7.a;
        setDrawerShadow(d7.a.b(context, i2), i3);
    }

    public void setDrawerLockMode(int i2, View view) {
        if (l(view)) {
            setDrawerLockMode(i2, ((LayoutParams) view.getLayoutParams()).f1975a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public static abstract class e implements DrawerListener {
        public void onDrawerClosed(View view) {
        }

        public void onDrawerOpened(View view) {
        }

        public void onDrawerStateChanged(int i) {
        }

        public void onDrawerSlide(View view, float f) {
        }
    }
}
