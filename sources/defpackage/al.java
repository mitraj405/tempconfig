package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.SubMenuBuilder;
import defpackage.G;
import java.lang.reflect.Method;

/* renamed from: al  reason: default package */
/* compiled from: MenuItemWrapperICS */
public final class al extends C0386x2 implements MenuItem {
    public final Jy a;

    /* renamed from: a  reason: collision with other field name */
    public Method f800a;

    /* renamed from: al$a */
    /* compiled from: MenuItemWrapperICS */
    public class a extends G {

        /* renamed from: a  reason: collision with other field name */
        public final ActionProvider f801a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f801a = actionProvider;
        }

        public final boolean a() {
            return this.f801a.hasSubMenu();
        }

        public final View c() {
            return this.f801a.onCreateActionView();
        }

        public final boolean e() {
            return this.f801a.onPerformDefaultAction();
        }

        public final void f(SubMenuBuilder subMenuBuilder) {
            this.f801a.onPrepareSubMenu(al.this.f(subMenuBuilder));
        }
    }

    /* renamed from: al$b */
    /* compiled from: MenuItemWrapperICS */
    public class b extends a implements ActionProvider.VisibilityListener {
        public G.b a;

        public b(al alVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        public final boolean b() {
            return this.f801a.isVisible();
        }

        public final View d(MenuItem menuItem) {
            return this.f801a.onCreateActionView(menuItem);
        }

        public final boolean g() {
            return this.f801a.overridesItemVisibility();
        }

        public final void h(MenuItemImpl.a aVar) {
            this.a = aVar;
            this.f801a.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            G.b bVar = this.a;
            if (bVar != null) {
                MenuItemImpl menuItemImpl = MenuItemImpl.this;
                menuItemImpl.f1026a.onItemVisibleChanged(menuItemImpl);
            }
        }
    }

    /* renamed from: al$c */
    /* compiled from: MenuItemWrapperICS */
    public static class c extends FrameLayout implements t5 {
        public final CollapsibleActionView a;

        public c(View view) {
            super(view.getContext());
            this.a = (CollapsibleActionView) view;
            addView(view);
        }

        public final void onActionViewCollapsed() {
            this.a.onActionViewCollapsed();
        }

        public final void onActionViewExpanded() {
            this.a.onActionViewExpanded();
        }
    }

    /* renamed from: al$d */
    /* compiled from: MenuItemWrapperICS */
    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with other field name */
        public final MenuItem.OnActionExpandListener f802a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f802a = onActionExpandListener;
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f802a.onMenuItemActionCollapse(al.this.e(menuItem));
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f802a.onMenuItemActionExpand(al.this.e(menuItem));
        }
    }

    /* renamed from: al$e */
    /* compiled from: MenuItemWrapperICS */
    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with other field name */
        public final MenuItem.OnMenuItemClickListener f803a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f803a = onMenuItemClickListener;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            return this.f803a.onMenuItemClick(al.this.e(menuItem));
        }
    }

    public al(Context context, Jy jy) {
        super(context);
        if (jy != null) {
            this.a = jy;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public final boolean collapseActionView() {
        return this.a.collapseActionView();
    }

    public final boolean expandActionView() {
        return this.a.expandActionView();
    }

    public final ActionProvider getActionProvider() {
        G b2 = this.a.b();
        if (b2 instanceof a) {
            return ((a) b2).f801a;
        }
        return null;
    }

    public final View getActionView() {
        View actionView = this.a.getActionView();
        if (actionView instanceof c) {
            return (View) ((c) actionView).a;
        }
        return actionView;
    }

    public final int getAlphabeticModifiers() {
        return this.a.getAlphabeticModifiers();
    }

    public final char getAlphabeticShortcut() {
        return this.a.getAlphabeticShortcut();
    }

    public final CharSequence getContentDescription() {
        return this.a.getContentDescription();
    }

    public final int getGroupId() {
        return this.a.getGroupId();
    }

    public final Drawable getIcon() {
        return this.a.getIcon();
    }

    public final ColorStateList getIconTintList() {
        return this.a.getIconTintList();
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.a.getIconTintMode();
    }

    public final Intent getIntent() {
        return this.a.getIntent();
    }

    public final int getItemId() {
        return this.a.getItemId();
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.a.getMenuInfo();
    }

    public final int getNumericModifiers() {
        return this.a.getNumericModifiers();
    }

    public final char getNumericShortcut() {
        return this.a.getNumericShortcut();
    }

    public final int getOrder() {
        return this.a.getOrder();
    }

    public final SubMenu getSubMenu() {
        return f(this.a.getSubMenu());
    }

    public final CharSequence getTitle() {
        return this.a.getTitle();
    }

    public final CharSequence getTitleCondensed() {
        return this.a.getTitleCondensed();
    }

    public final CharSequence getTooltipText() {
        return this.a.getTooltipText();
    }

    public final boolean hasSubMenu() {
        return this.a.hasSubMenu();
    }

    public final boolean isActionViewExpanded() {
        return this.a.isActionViewExpanded();
    }

    public final boolean isCheckable() {
        return this.a.isCheckable();
    }

    public final boolean isChecked() {
        return this.a.isChecked();
    }

    public final boolean isEnabled() {
        return this.a.isEnabled();
    }

    public final boolean isVisible() {
        return this.a.isVisible();
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, this.a, actionProvider);
        if (actionProvider == null) {
            bVar = null;
        }
        this.a.c(bVar);
        return this;
    }

    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.a.setActionView(view);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        this.a.setAlphabeticShortcut(c2);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.a.setCheckable(z);
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        this.a.setChecked(z);
        return this;
    }

    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.a.d(charSequence);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        this.a.setEnabled(z);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.a.setIcon(drawable);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.a.setIconTintList(colorStateList);
        return this;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.a.setIconTintMode(mode);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.a.setIntent(intent);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2) {
        this.a.setNumericShortcut(c2);
        return this;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        d dVar;
        if (onActionExpandListener != null) {
            dVar = new d(onActionExpandListener);
        } else {
            dVar = null;
        }
        this.a.setOnActionExpandListener(dVar);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        e eVar;
        if (onMenuItemClickListener != null) {
            eVar = new e(onMenuItemClickListener);
        } else {
            eVar = null;
        }
        this.a.setOnMenuItemClickListener(eVar);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.a.setShortcut(c2, c3);
        return this;
    }

    public final void setShowAsAction(int i) {
        this.a.setShowAsAction(i);
    }

    public final MenuItem setShowAsActionFlags(int i) {
        this.a.setShowAsActionFlags(i);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.a.setTitle(charSequence);
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.a.setTitleCondensed(charSequence);
        return this;
    }

    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.a.a(charSequence);
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        return this.a.setVisible(z);
    }

    public final MenuItem setAlphabeticShortcut(char c2, int i) {
        this.a.setAlphabeticShortcut(c2, i);
        return this;
    }

    public final MenuItem setIcon(int i) {
        this.a.setIcon(i);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2, int i) {
        this.a.setNumericShortcut(c2, i);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.a.setShortcut(c2, c3, i, i2);
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.a.setTitle(i);
        return this;
    }

    public final MenuItem setActionView(int i) {
        Jy jy = this.a;
        jy.setActionView(i);
        View actionView = jy.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            jy.setActionView((View) new c(actionView));
        }
        return this;
    }
}
