package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.f;

public final class ToolbarWidgetWrapper implements DecorToolbar {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f1269a;

    /* renamed from: a  reason: collision with other field name */
    public View f1270a;

    /* renamed from: a  reason: collision with other field name */
    public Window.Callback f1271a;

    /* renamed from: a  reason: collision with other field name */
    public ActionMenuPresenter f1272a;

    /* renamed from: a  reason: collision with other field name */
    public ScrollingTabContainerView f1273a;

    /* renamed from: a  reason: collision with other field name */
    public final Toolbar f1274a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f1275a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1276a;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public Drawable f1277b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f1278b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1279b;
    public Drawable c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f1280c;
    public Drawable d;

    public class a extends C1488xu {
        public final /* synthetic */ int a;
        public boolean b = false;

        public a(int i) {
            this.a = i;
        }

        public final void a() {
            ToolbarWidgetWrapper.this.f1274a.setVisibility(0);
        }

        public final void onAnimationCancel() {
            this.b = true;
        }

        public final void onAnimationEnd() {
            if (!this.b) {
                ToolbarWidgetWrapper.this.f1274a.setVisibility(this.a);
            }
        }
    }

    public ToolbarWidgetWrapper(Toolbar toolbar) {
        boolean z;
        Drawable drawable;
        int i = bs.abc_action_bar_up_description;
        this.f1274a = toolbar;
        this.f1275a = toolbar.getTitle();
        this.f1278b = toolbar.getSubtitle();
        if (this.f1275a != null) {
            z = true;
        } else {
            z = false;
        }
        this.f1276a = z;
        this.c = toolbar.getNavigationIcon();
        String str = null;
        TintTypedArray m = TintTypedArray.m(toolbar.getContext(), (AttributeSet) null, ps.ActionBar, C0220hr.actionBarStyle);
        this.d = m.e(ps.ActionBar_homeAsUpIndicator);
        CharSequence k = m.k(ps.ActionBar_title);
        if (!TextUtils.isEmpty(k)) {
            this.f1276a = true;
            this.f1275a = k;
            if ((this.a & 8) != 0) {
                toolbar.setTitle(k);
                if (this.f1276a) {
                    f.p(toolbar.getRootView(), k);
                }
            }
        }
        CharSequence k2 = m.k(ps.ActionBar_subtitle);
        if (!TextUtils.isEmpty(k2)) {
            this.f1278b = k2;
            if ((this.a & 8) != 0) {
                toolbar.setSubtitle(k2);
            }
        }
        Drawable e = m.e(ps.ActionBar_logo);
        if (e != null) {
            this.f1277b = e;
            u();
        }
        Drawable e2 = m.e(ps.ActionBar_icon);
        if (e2 != null) {
            q(e2);
        }
        if (this.c == null && (drawable = this.d) != null) {
            this.c = drawable;
            if ((this.a & 4) != 0) {
                toolbar.setNavigationIcon(drawable);
            } else {
                toolbar.setNavigationIcon((Drawable) null);
            }
        }
        t(m.h(ps.ActionBar_displayOptions, 0));
        int i2 = m.i(ps.ActionBar_customNavigationLayout, 0);
        if (i2 != 0) {
            View inflate = LayoutInflater.from(toolbar.getContext()).inflate(i2, toolbar, false);
            View view = this.f1270a;
            if (!(view == null || (this.a & 16) == 0)) {
                toolbar.removeView(view);
            }
            this.f1270a = inflate;
            if (!(inflate == null || (this.a & 16) == 0)) {
                toolbar.addView(inflate);
            }
            t(this.a | 16);
        }
        int layoutDimension = m.f1265a.getLayoutDimension(ps.ActionBar_height, 0);
        if (layoutDimension > 0) {
            ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
            layoutParams.height = layoutDimension;
            toolbar.setLayoutParams(layoutParams);
        }
        int c2 = m.c(ps.ActionBar_contentInsetStart, -1);
        int c3 = m.c(ps.ActionBar_contentInsetEnd, -1);
        if (c2 >= 0 || c3 >= 0) {
            toolbar.setContentInsetsRelative(Math.max(c2, 0), Math.max(c3, 0));
        }
        int i3 = m.i(ps.ActionBar_titleTextStyle, 0);
        if (i3 != 0) {
            toolbar.setTitleTextAppearance(toolbar.getContext(), i3);
        }
        int i4 = m.i(ps.ActionBar_subtitleTextStyle, 0);
        if (i4 != 0) {
            toolbar.setSubtitleTextAppearance(toolbar.getContext(), i4);
        }
        int i5 = m.i(ps.ActionBar_popupTheme, 0);
        if (i5 != 0) {
            toolbar.setPopupTheme(i5);
        }
        m.n();
        if (i != this.b) {
            this.b = i;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i6 = this.b;
                str = i6 != 0 ? getContext().getString(i6) : str;
                this.f1280c = str;
                if ((this.a & 4) != 0) {
                    if (TextUtils.isEmpty(str)) {
                        toolbar.setNavigationContentDescription(this.b);
                    } else {
                        toolbar.setNavigationContentDescription(this.f1280c);
                    }
                }
            }
        }
        this.f1280c = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new iA(this));
    }

    public final boolean a() {
        return this.f1274a.isOverflowMenuShowing();
    }

    public final boolean b() {
        return this.f1274a.isOverflowMenuShowPending();
    }

    public final boolean c() {
        return this.f1274a.hideOverflowMenu();
    }

    public final boolean d() {
        return this.f1274a.canShowOverflowMenu();
    }

    public final boolean e() {
        return this.f1274a.showOverflowMenu();
    }

    public final void f() {
        this.f1274a.dismissPopupMenus();
    }

    public final Context getContext() {
        return this.f1274a.getContext();
    }

    public final CharSequence getTitle() {
        return this.f1274a.getTitle();
    }

    public final void h() {
        Toolbar toolbar;
        ScrollingTabContainerView scrollingTabContainerView = this.f1273a;
        if (scrollingTabContainerView != null && scrollingTabContainerView.getParent() == (toolbar = this.f1274a)) {
            toolbar.removeView(this.f1273a);
        }
        this.f1273a = null;
    }

    public final void i() {
        this.f1274a.collapseActionView();
    }

    public final void j(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = r1.w(getContext(), i);
        } else {
            drawable = null;
        }
        q(drawable);
    }

    public final void k(int i) {
        Drawable drawable;
        if (i != 0) {
            drawable = r1.w(getContext(), i);
        } else {
            drawable = null;
        }
        this.f1277b = drawable;
        u();
    }

    public final GC l(int i, long j) {
        float f;
        GC a2 = f.a(this.f1274a);
        if (i == 0) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        a2.a(f);
        a2.c(j);
        a2.d(new a(i));
        return a2;
    }

    public final void n(boolean z) {
        this.f1274a.setCollapsible(z);
    }

    public final boolean o() {
        return this.f1274a.hasExpandedActionView();
    }

    public final void q(Drawable drawable) {
        this.f1269a = drawable;
        u();
    }

    public final int s() {
        return this.a;
    }

    public final void setMenu(Menu menu, MenuPresenter.Callback callback) {
        ActionMenuPresenter actionMenuPresenter = this.f1272a;
        Toolbar toolbar = this.f1274a;
        if (actionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(toolbar.getContext());
            this.f1272a = actionMenuPresenter2;
            actionMenuPresenter2.e = Gr.action_menu_presenter;
        }
        ActionMenuPresenter actionMenuPresenter3 = this.f1272a;
        actionMenuPresenter3.f1039a = callback;
        toolbar.setMenu((MenuBuilder) menu, actionMenuPresenter3);
    }

    public final void setMenuPrepared() {
        this.f1279b = true;
    }

    public final void setVisibility(int i) {
        this.f1274a.setVisibility(i);
    }

    public final void setWindowCallback(Window.Callback callback) {
        this.f1271a = callback;
    }

    public final void setWindowTitle(CharSequence charSequence) {
        if (!this.f1276a) {
            this.f1275a = charSequence;
            if ((this.a & 8) != 0) {
                Toolbar toolbar = this.f1274a;
                toolbar.setTitle(charSequence);
                if (this.f1276a) {
                    f.p(toolbar.getRootView(), charSequence);
                }
            }
        }
    }

    public final void t(int i) {
        View view;
        int i2 = this.a ^ i;
        this.a = i;
        if (i2 != 0) {
            int i3 = i2 & 4;
            Toolbar toolbar = this.f1274a;
            if (i3 != 0) {
                if (!((i & 4) == 0 || (i & 4) == 0)) {
                    if (TextUtils.isEmpty(this.f1280c)) {
                        toolbar.setNavigationContentDescription(this.b);
                    } else {
                        toolbar.setNavigationContentDescription(this.f1280c);
                    }
                }
                if ((this.a & 4) != 0) {
                    Drawable drawable = this.c;
                    if (drawable == null) {
                        drawable = this.d;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                u();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.f1275a);
                    toolbar.setSubtitle(this.f1278b);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && (view = this.f1270a) != null) {
                if ((i & 16) != 0) {
                    toolbar.addView(view);
                } else {
                    toolbar.removeView(view);
                }
            }
        }
    }

    public final void u() {
        Drawable drawable;
        int i = this.a;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f1277b;
            if (drawable == null) {
                drawable = this.f1269a;
            }
        } else {
            drawable = this.f1269a;
        }
        this.f1274a.setLogo(drawable);
    }

    public final void g() {
    }

    public final void m() {
    }

    public final void p() {
    }

    public final void r() {
    }
}
