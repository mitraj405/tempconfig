package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.appcompat.app.h;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.f;
import java.util.WeakHashMap;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements C0267m8, C0369vm, C0382wm {
    public static final int[] a = {C0220hr.actionBarSize, 16842841};

    /* renamed from: a  reason: collision with other field name */
    public final Rect f1106a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f1107a;

    /* renamed from: a  reason: collision with other field name */
    public ViewPropertyAnimator f1108a;

    /* renamed from: a  reason: collision with other field name */
    public OverScroller f1109a;

    /* renamed from: a  reason: collision with other field name */
    public ActionBarContainer f1110a;

    /* renamed from: a  reason: collision with other field name */
    public final a f1111a;

    /* renamed from: a  reason: collision with other field name */
    public final b f1112a;

    /* renamed from: a  reason: collision with other field name */
    public final c f1113a;

    /* renamed from: a  reason: collision with other field name */
    public d f1114a;

    /* renamed from: a  reason: collision with other field name */
    public ContentFrameLayout f1115a;

    /* renamed from: a  reason: collision with other field name */
    public DecorToolbar f1116a;

    /* renamed from: a  reason: collision with other field name */
    public final NestedScrollingParentHelper f1117a;

    /* renamed from: a  reason: collision with other field name */
    public WindowInsetsCompat f1118a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1119a;
    public final Rect b;

    /* renamed from: b  reason: collision with other field name */
    public WindowInsetsCompat f1120b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1121b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public final Rect f1122c;

    /* renamed from: c  reason: collision with other field name */
    public WindowInsetsCompat f1123c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1124c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public WindowInsetsCompat f1125d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1126d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f1127e;
    public int f;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public final void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1108a = null;
            actionBarOverlayLayout.f1127e = false;
        }

        public final void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.f1108a = null;
            actionBarOverlayLayout.f1127e = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.i();
            actionBarOverlayLayout.f1108a = actionBarOverlayLayout.f1110a.animate().translationY(0.0f).setListener(actionBarOverlayLayout.f1111a);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.i();
            actionBarOverlayLayout.f1108a = actionBarOverlayLayout.f1110a.animate().translationY((float) (-actionBarOverlayLayout.f1110a.getHeight())).setListener(actionBarOverlayLayout.f1111a);
        }
    }

    public interface d {
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public static boolean h(FrameLayout frameLayout, Rect rect, boolean z) {
        boolean z2;
        int i;
        LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
        int i2 = layoutParams.leftMargin;
        int i3 = rect.left;
        if (i2 != i3) {
            layoutParams.leftMargin = i3;
            z2 = true;
        } else {
            z2 = false;
        }
        int i4 = layoutParams.topMargin;
        int i5 = rect.top;
        if (i4 != i5) {
            layoutParams.topMargin = i5;
            z2 = true;
        }
        int i6 = layoutParams.rightMargin;
        int i7 = rect.right;
        if (i6 != i7) {
            layoutParams.rightMargin = i7;
            z2 = true;
        }
        if (!z || layoutParams.bottomMargin == (i = rect.bottom)) {
            return z2;
        }
        layoutParams.bottomMargin = i;
        return true;
    }

    public final boolean a() {
        k();
        return this.f1116a.a();
    }

    public final boolean b() {
        k();
        return this.f1116a.b();
    }

    public final boolean c() {
        k();
        return this.f1116a.c();
    }

    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final boolean d() {
        k();
        return this.f1116a.d();
    }

    public final void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f1107a != null && !this.f1119a) {
            if (this.f1110a.getVisibility() == 0) {
                i = (int) (this.f1110a.getTranslationY() + ((float) this.f1110a.getBottom()) + 0.5f);
            } else {
                i = 0;
            }
            this.f1107a.setBounds(0, i, getWidth(), this.f1107a.getIntrinsicHeight() + i);
            this.f1107a.draw(canvas);
        }
    }

    public final boolean e() {
        k();
        return this.f1116a.e();
    }

    public final void f() {
        k();
        this.f1116a.f();
    }

    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public final void g(int i) {
        k();
        if (i == 2) {
            this.f1116a.r();
        } else if (i == 5) {
            this.f1116a.p();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f1110a;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.f1117a;
        return nestedScrollingParentHelper.b | nestedScrollingParentHelper.a;
    }

    public CharSequence getTitle() {
        k();
        return this.f1116a.getTitle();
    }

    public final void i() {
        removeCallbacks(this.f1112a);
        removeCallbacks(this.f1113a);
        ViewPropertyAnimator viewPropertyAnimator = this.f1108a;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void j(Context context) {
        boolean z;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(a);
        boolean z2 = false;
        this.c = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f1107a = drawable;
        if (drawable == null) {
            z = true;
        } else {
            z = false;
        }
        setWillNotDraw(z);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.f1119a = z2;
        this.f1109a = new OverScroller(context);
    }

    public final void k() {
        DecorToolbar decorToolbar;
        if (this.f1115a == null) {
            this.f1115a = (ContentFrameLayout) findViewById(Gr.action_bar_activity_content);
            this.f1110a = (ActionBarContainer) findViewById(Gr.action_bar_container);
            View findViewById = findViewById(Gr.action_bar);
            if (findViewById instanceof DecorToolbar) {
                decorToolbar = (DecorToolbar) findViewById;
            } else if (findViewById instanceof Toolbar) {
                decorToolbar = ((Toolbar) findViewById).getWrapper();
            } else {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
            }
            this.f1116a = decorToolbar;
        }
    }

    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        WindowInsetsCompat i = WindowInsetsCompat.i(this, windowInsets);
        boolean h = h(this.f1110a, new Rect(i.c(), i.e(), i.d(), i.b()), false);
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        Rect rect = this.f1106a;
        f.d.b(this, i, rect);
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        WindowInsetsCompat.k kVar = i.f1818a;
        WindowInsetsCompat l = kVar.l(i2, i3, i4, i5);
        this.f1118a = l;
        boolean z = true;
        if (!this.f1120b.equals(l)) {
            this.f1120b = this.f1118a;
            h = true;
        }
        Rect rect2 = this.b;
        if (!rect2.equals(rect)) {
            rect2.set(rect);
        } else {
            z = h;
        }
        if (z) {
            requestLayout();
        }
        return kVar.a().f1818a.c().f1818a.b().h();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j(getContext());
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        f.c.c(this);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i();
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.leftMargin + paddingLeft;
                int i7 = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    public final void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        WindowInsetsCompat.e eVar;
        k();
        measureChildWithMargins(this.f1110a, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.f1110a.getLayoutParams();
        int max = Math.max(0, this.f1110a.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.f1110a.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f1110a.getMeasuredState());
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if ((getWindowSystemUiVisibility() & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            i3 = this.c;
            if (this.f1124c && this.f1110a.getTabContainer() != null) {
                i3 += this.c;
            }
        } else {
            i3 = this.f1110a.getVisibility() != 8 ? this.f1110a.getMeasuredHeight() : 0;
        }
        Rect rect = this.f1106a;
        Rect rect2 = this.f1122c;
        rect2.set(rect);
        WindowInsetsCompat windowInsetsCompat = this.f1118a;
        this.f1123c = windowInsetsCompat;
        if (this.f1121b || z) {
            bg b2 = bg.b(windowInsetsCompat.c(), this.f1123c.e() + i3, this.f1123c.d(), this.f1123c.b() + 0);
            WindowInsetsCompat windowInsetsCompat2 = this.f1123c;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30) {
                eVar = new WindowInsetsCompat.d(windowInsetsCompat2);
            } else if (i4 >= 29) {
                eVar = new WindowInsetsCompat.c(windowInsetsCompat2);
            } else {
                eVar = new WindowInsetsCompat.b(windowInsetsCompat2);
            }
            eVar.g(b2);
            this.f1123c = eVar.b();
        } else {
            rect2.top += i3;
            rect2.bottom += 0;
            this.f1123c = windowInsetsCompat.f1818a.l(0, i3, 0, 0);
        }
        h(this.f1115a, rect2, true);
        if (!this.f1125d.equals(this.f1123c)) {
            WindowInsetsCompat windowInsetsCompat3 = this.f1123c;
            this.f1125d = windowInsetsCompat3;
            f.b(this.f1115a, windowInsetsCompat3);
        }
        measureChildWithMargins(this.f1115a, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f1115a.getLayoutParams();
        int max3 = Math.max(max, this.f1115a.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.f1115a.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f1115a.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        boolean z2 = false;
        if (!this.f1126d || !z) {
            return false;
        }
        this.f1109a.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1109a.getFinalY() > this.f1110a.getHeight()) {
            z2 = true;
        }
        if (z2) {
            i();
            this.f1113a.run();
        } else {
            i();
            this.f1112a.run();
        }
        this.f1127e = true;
        return true;
    }

    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(view, i, i2, i3, i4, i5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r1 = (androidx.appcompat.app.h) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onNestedScrollAccepted(android.view.View r1, android.view.View r2, int r3) {
        /*
            r0 = this;
            androidx.core.view.NestedScrollingParentHelper r1 = r0.f1117a
            r1.a = r3
            int r1 = r0.getActionBarHideOffset()
            r0.e = r1
            r0.i()
            androidx.appcompat.widget.ActionBarOverlayLayout$d r1 = r0.f1114a
            if (r1 == 0) goto L_0x001d
            androidx.appcompat.app.h r1 = (androidx.appcompat.app.h) r1
            HC r2 = r1.f960a
            if (r2 == 0) goto L_0x001d
            r2.a()
            r2 = 0
            r1.f960a = r2
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionBarOverlayLayout.onNestedScrollAccepted(android.view.View, android.view.View, int):void");
    }

    public final boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    public final void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Deprecated
    public final void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2;
        super.onWindowSystemUiVisibilityChanged(i);
        k();
        int i2 = this.f ^ i;
        this.f = i;
        if ((i & 4) == 0) {
            z = true;
        } else {
            z = false;
        }
        if ((i & 256) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        d dVar = this.f1114a;
        if (dVar != null) {
            ((h) dVar).d = !z2;
            if (z || !z2) {
                h hVar = (h) dVar;
                if (hVar.e) {
                    hVar.e = false;
                    hVar.i(true);
                }
            } else {
                h hVar2 = (h) dVar;
                if (!hVar2.e) {
                    hVar2.e = true;
                    hVar2.i(true);
                }
            }
        }
        if ((i2 & 256) != 0 && this.f1114a != null) {
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            f.c.c(this);
        }
    }

    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.d = i;
        d dVar = this.f1114a;
        if (dVar != null) {
            ((h) dVar).f959a = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        i();
        this.f1110a.setTranslationY((float) (-Math.max(0, Math.min(i, this.f1110a.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f1114a = dVar;
        if (getWindowToken() != null) {
            ((h) this.f1114a).f959a = this.d;
            int i = this.f;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                f.c.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1124c = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1126d) {
            this.f1126d = z;
            if (!z) {
                i();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        k();
        this.f1116a.j(i);
    }

    public void setLogo(int i) {
        k();
        this.f1116a.k(i);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        k();
        this.f1116a.setMenu(menu, callback);
    }

    public void setMenuPrepared() {
        k();
        this.f1116a.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        boolean z2;
        this.f1121b = z;
        if (!z || getContext().getApplicationInfo().targetSdkVersion >= 19) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f1119a = z2;
    }

    public void setWindowCallback(Window.Callback callback) {
        k();
        this.f1116a.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        k();
        this.f1116a.setWindowTitle(charSequence);
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0;
        this.f1106a = new Rect();
        this.b = new Rect();
        this.f1122c = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.a;
        this.f1118a = windowInsetsCompat;
        this.f1120b = windowInsetsCompat;
        this.f1123c = windowInsetsCompat;
        this.f1125d = windowInsetsCompat;
        this.f1111a = new a();
        this.f1112a = new b();
        this.f1113a = new c();
        j(context);
        this.f1117a = new NestedScrollingParentHelper();
    }

    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    public final void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1110a.getVisibility() != 0) {
            return false;
        }
        return this.f1126d;
    }

    public final void onStopNestedScroll(View view) {
        if (this.f1126d && !this.f1127e) {
            if (this.e <= this.f1110a.getHeight()) {
                i();
                postDelayed(this.f1112a, 600);
                return;
            }
            i();
            postDelayed(this.f1113a, 600);
        }
    }

    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.e + i2;
        this.e = i5;
        setActionBarHideOffset(i5);
    }

    public void setIcon(Drawable drawable) {
        k();
        this.f1116a.q(drawable);
    }

    public final void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }
}
