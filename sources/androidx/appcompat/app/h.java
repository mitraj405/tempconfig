package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* compiled from: WindowDecorActionBar */
public final class h extends ActionBar implements ActionBarOverlayLayout.d {
    public static final AccelerateInterpolator a = new AccelerateInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public static final DecelerateInterpolator f958a = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public int f959a = 0;

    /* renamed from: a  reason: collision with other field name */
    public HC f960a;

    /* renamed from: a  reason: collision with other field name */
    public final Activity f961a;

    /* renamed from: a  reason: collision with other field name */
    public Context f962a;

    /* renamed from: a  reason: collision with other field name */
    public final View f963a;

    /* renamed from: a  reason: collision with other field name */
    public final a f964a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f965a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final c f966a = new c();

    /* renamed from: a  reason: collision with other field name */
    public d f967a;

    /* renamed from: a  reason: collision with other field name */
    public ActionMode.Callback f968a;

    /* renamed from: a  reason: collision with other field name */
    public ActionBarContainer f969a;

    /* renamed from: a  reason: collision with other field name */
    public ActionBarContextView f970a;

    /* renamed from: a  reason: collision with other field name */
    public ActionBarOverlayLayout f971a;

    /* renamed from: a  reason: collision with other field name */
    public DecorToolbar f972a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<ActionBar.a> f973a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f974a;
    public Context b;

    /* renamed from: b  reason: collision with other field name */
    public d f975b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f976b;
    public boolean c;
    public boolean d = true;
    public boolean e;
    public boolean f;
    public boolean g = true;
    public boolean h;
    public boolean i;

    /* compiled from: WindowDecorActionBar */
    public class a extends C1488xu {
        public a() {
        }

        public final void onAnimationEnd() {
            View view;
            h hVar = h.this;
            if (hVar.d && (view = hVar.f963a) != null) {
                view.setTranslationY(0.0f);
                hVar.f969a.setTranslationY(0.0f);
            }
            hVar.f969a.setVisibility(8);
            hVar.f969a.setTransitioning(false);
            hVar.f960a = null;
            ActionMode.Callback callback = hVar.f968a;
            if (callback != null) {
                callback.a(hVar.f975b);
                hVar.f975b = null;
                hVar.f968a = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = hVar.f971a;
            if (actionBarOverlayLayout != null) {
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                f.c.c(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class b extends C1488xu {
        public b() {
        }

        public final void onAnimationEnd() {
            h hVar = h.this;
            hVar.f960a = null;
            hVar.f969a.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class c implements JC {
        public c() {
        }
    }

    /* compiled from: WindowDecorActionBar */
    public class d extends ActionMode implements MenuBuilder.Callback {
        public final Context a;

        /* renamed from: a  reason: collision with other field name */
        public ActionMode.Callback f978a;

        /* renamed from: a  reason: collision with other field name */
        public final MenuBuilder f979a;

        /* renamed from: a  reason: collision with other field name */
        public WeakReference<View> f980a;

        public d(Context context, AppCompatDelegateImpl.c cVar) {
            this.a = context;
            this.f978a = cVar;
            MenuBuilder defaultShowAsAction = new MenuBuilder(context).setDefaultShowAsAction(1);
            this.f979a = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public final void a() {
            h hVar = h.this;
            if (hVar.f967a == this) {
                if (!(!hVar.e)) {
                    hVar.f975b = this;
                    hVar.f968a = this.f978a;
                } else {
                    this.f978a.a(this);
                }
                this.f978a = null;
                hVar.a(false);
                ActionBarContextView actionBarContextView = hVar.f970a;
                if (actionBarContextView.a == null) {
                    actionBarContextView.h();
                }
                hVar.f971a.setHideOnContentScrollEnabled(hVar.i);
                hVar.f967a = null;
            }
        }

        public final View b() {
            WeakReference<View> weakReference = this.f980a;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public final MenuBuilder c() {
            return this.f979a;
        }

        public final MenuInflater d() {
            return new Iy(this.a);
        }

        public final CharSequence e() {
            return h.this.f970a.getSubtitle();
        }

        public final CharSequence f() {
            return h.this.f970a.getTitle();
        }

        public final void g() {
            if (h.this.f967a == this) {
                MenuBuilder menuBuilder = this.f979a;
                menuBuilder.stopDispatchingItemsChanged();
                try {
                    this.f978a.c(this, menuBuilder);
                } finally {
                    menuBuilder.startDispatchingItemsChanged();
                }
            }
        }

        public final boolean h() {
            return h.this.f970a.f1105c;
        }

        public final void i(View view) {
            h.this.f970a.setCustomView(view);
            this.f980a = new WeakReference<>(view);
        }

        public final void j(int i) {
            k(h.this.f962a.getResources().getString(i));
        }

        public final void k(CharSequence charSequence) {
            h.this.f970a.setSubtitle(charSequence);
        }

        public final void l(int i) {
            m(h.this.f962a.getResources().getString(i));
        }

        public final void m(CharSequence charSequence) {
            h.this.f970a.setTitle(charSequence);
        }

        public final void n(boolean z) {
            this.f986a = z;
            h.this.f970a.setTitleOptional(z);
        }

        public final boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.f978a;
            if (callback != null) {
                return callback.b(this, menuItem);
            }
            return false;
        }

        public final void onMenuModeChange(MenuBuilder menuBuilder) {
            if (this.f978a != null) {
                g();
                ActionMenuPresenter actionMenuPresenter = h.this.f970a.f3044a;
                if (actionMenuPresenter != null) {
                    actionMenuPresenter.e();
                }
            }
        }
    }

    public h(boolean z, Activity activity) {
        new ArrayList();
        this.f961a = activity;
        View decorView = activity.getWindow().getDecorView();
        e(decorView);
        if (!z) {
            this.f963a = decorView.findViewById(16908290);
        }
    }

    public final void a(boolean z) {
        GC gc;
        GC gc2;
        long j;
        if (z) {
            if (!this.f) {
                this.f = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f971a;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                i(false);
            }
        } else if (this.f) {
            this.f = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f971a;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            i(false);
        }
        ActionBarContainer actionBarContainer = this.f969a;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        if (actionBarContainer.isLaidOut()) {
            if (z) {
                gc = this.f972a.l(4, 100);
                gc2 = this.f970a.e(0, 200);
            } else {
                gc2 = this.f972a.l(0, 200);
                gc = this.f970a.e(8, 100);
            }
            HC hc = new HC();
            ArrayList<GC> arrayList = hc.f255a;
            arrayList.add(gc);
            View view = gc.a.get();
            if (view != null) {
                j = view.animate().getDuration();
            } else {
                j = 0;
            }
            View view2 = gc2.a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j);
            }
            arrayList.add(gc2);
            hc.b();
        } else if (z) {
            this.f972a.setVisibility(4);
            this.f970a.setVisibility(0);
        } else {
            this.f972a.setVisibility(0);
            this.f970a.setVisibility(8);
        }
    }

    public final void b(boolean z) {
        if (z != this.f976b) {
            this.f976b = z;
            ArrayList<ActionBar.a> arrayList = this.f973a;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.get(i2).a();
            }
        }
    }

    public final int c() {
        return this.f972a.s();
    }

    public final Context d() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.f962a.getTheme().resolveAttribute(C0220hr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.b = new ContextThemeWrapper(this.f962a, i2);
            } else {
                this.b = this.f962a;
            }
        }
        return this.b;
    }

    public final void e(View view) {
        DecorToolbar decorToolbar;
        boolean z;
        String str;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(Gr.decor_content_parent);
        this.f971a = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(Gr.action_bar);
        if (findViewById instanceof DecorToolbar) {
            decorToolbar = (DecorToolbar) findViewById;
        } else if (findViewById instanceof Toolbar) {
            decorToolbar = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.f972a = decorToolbar;
        this.f970a = (ActionBarContextView) view.findViewById(Gr.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(Gr.action_bar_container);
        this.f969a = actionBarContainer;
        DecorToolbar decorToolbar2 = this.f972a;
        if (decorToolbar2 == null || this.f970a == null || actionBarContainer == null) {
            throw new IllegalStateException(h.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        this.f962a = decorToolbar2.getContext();
        if ((this.f972a.s() & 4) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f974a = true;
        }
        Context context = this.f962a;
        if (context.getApplicationInfo().targetSdkVersion < 14) {
        }
        this.f972a.g();
        g(context.getResources().getBoolean(C0240jr.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f962a.obtainStyledAttributes((AttributeSet) null, ps.ActionBar, C0220hr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(ps.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f971a;
            if (actionBarOverlayLayout2.f1121b) {
                this.i = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(ps.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f969a;
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            f.d.s(actionBarContainer2, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void f(boolean z) {
        int i2;
        if (!this.f974a) {
            if (z) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            int s = this.f972a.s();
            this.f974a = true;
            this.f972a.t((i2 & 4) | (s & -5));
        }
    }

    public final void g(boolean z) {
        this.c = z;
        if (!z) {
            this.f972a.h();
            this.f969a.setTabContainer((ScrollingTabContainerView) null);
        } else {
            this.f969a.setTabContainer((ScrollingTabContainerView) null);
            this.f972a.h();
        }
        this.f972a.m();
        DecorToolbar decorToolbar = this.f972a;
        boolean z2 = this.c;
        decorToolbar.n(false);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f971a;
        boolean z3 = this.c;
        actionBarOverlayLayout.setHasNonEmbeddedTabs(false);
    }

    public final void h(CharSequence charSequence) {
        this.f972a.setWindowTitle(charSequence);
    }

    public final void i(boolean z) {
        boolean z2;
        boolean z3 = this.e;
        if (!this.f && z3) {
            z2 = false;
        } else {
            z2 = true;
        }
        EC ec = null;
        View view = this.f963a;
        c cVar = this.f966a;
        if (z2) {
            if (!this.g) {
                this.g = true;
                HC hc = this.f960a;
                if (hc != null) {
                    hc.a();
                }
                this.f969a.setVisibility(0);
                int i2 = this.f959a;
                b bVar = this.f965a;
                if (i2 != 0 || (!this.h && !z)) {
                    this.f969a.setAlpha(1.0f);
                    this.f969a.setTranslationY(0.0f);
                    if (this.d && view != null) {
                        view.setTranslationY(0.0f);
                    }
                    bVar.onAnimationEnd();
                } else {
                    this.f969a.setTranslationY(0.0f);
                    float f2 = (float) (-this.f969a.getHeight());
                    if (z) {
                        int[] iArr = {0, 0};
                        this.f969a.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.f969a.setTranslationY(f2);
                    HC hc2 = new HC();
                    GC a2 = f.a(this.f969a);
                    a2.e(0.0f);
                    View view2 = a2.a.get();
                    if (view2 != null) {
                        if (cVar != null) {
                            ec = new EC(cVar, view2);
                        }
                        view2.animate().setUpdateListener(ec);
                    }
                    boolean z4 = hc2.f256a;
                    ArrayList<GC> arrayList = hc2.f255a;
                    if (!z4) {
                        arrayList.add(a2);
                    }
                    if (this.d && view != null) {
                        view.setTranslationY(f2);
                        GC a3 = f.a(view);
                        a3.e(0.0f);
                        if (!hc2.f256a) {
                            arrayList.add(a3);
                        }
                    }
                    DecelerateInterpolator decelerateInterpolator = f958a;
                    boolean z5 = hc2.f256a;
                    if (!z5) {
                        hc2.f254a = decelerateInterpolator;
                    }
                    if (!z5) {
                        hc2.a = 250;
                    }
                    if (!z5) {
                        hc2.f253a = bVar;
                    }
                    this.f960a = hc2;
                    hc2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f971a;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap<View, GC> weakHashMap = f.f1839a;
                    f.c.c(actionBarOverlayLayout);
                }
            }
        } else if (this.g) {
            this.g = false;
            HC hc3 = this.f960a;
            if (hc3 != null) {
                hc3.a();
            }
            int i3 = this.f959a;
            a aVar = this.f964a;
            if (i3 != 0 || (!this.h && !z)) {
                aVar.onAnimationEnd();
                return;
            }
            this.f969a.setAlpha(1.0f);
            this.f969a.setTransitioning(true);
            HC hc4 = new HC();
            float f3 = (float) (-this.f969a.getHeight());
            if (z) {
                int[] iArr2 = {0, 0};
                this.f969a.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            GC a4 = f.a(this.f969a);
            a4.e(f3);
            View view3 = a4.a.get();
            if (view3 != null) {
                if (cVar != null) {
                    ec = new EC(cVar, view3);
                }
                view3.animate().setUpdateListener(ec);
            }
            boolean z6 = hc4.f256a;
            ArrayList<GC> arrayList2 = hc4.f255a;
            if (!z6) {
                arrayList2.add(a4);
            }
            if (this.d && view != null) {
                GC a5 = f.a(view);
                a5.e(f3);
                if (!hc4.f256a) {
                    arrayList2.add(a5);
                }
            }
            AccelerateInterpolator accelerateInterpolator = a;
            boolean z7 = hc4.f256a;
            if (!z7) {
                hc4.f254a = accelerateInterpolator;
            }
            if (!z7) {
                hc4.a = 250;
            }
            if (!z7) {
                hc4.f253a = aVar;
            }
            this.f960a = hc4;
            hc4.b();
        }
    }

    public h(Dialog dialog) {
        new ArrayList();
        e(dialog.getWindow().getDecorView());
    }
}
