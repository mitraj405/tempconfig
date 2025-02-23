package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import defpackage.G;
import defpackage.v9;

public final class MenuItemImpl implements Jy {
    public char a;

    /* renamed from: a  reason: collision with other field name */
    public final int f1016a;

    /* renamed from: a  reason: collision with other field name */
    public G f1017a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f1018a;

    /* renamed from: a  reason: collision with other field name */
    public ColorStateList f1019a = null;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuff.Mode f1020a = null;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f1021a;

    /* renamed from: a  reason: collision with other field name */
    public ContextMenu.ContextMenuInfo f1022a;

    /* renamed from: a  reason: collision with other field name */
    public MenuItem.OnActionExpandListener f1023a;

    /* renamed from: a  reason: collision with other field name */
    public MenuItem.OnMenuItemClickListener f1024a;

    /* renamed from: a  reason: collision with other field name */
    public View f1025a;

    /* renamed from: a  reason: collision with other field name */
    public final MenuBuilder f1026a;

    /* renamed from: a  reason: collision with other field name */
    public SubMenuBuilder f1027a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f1028a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1029a = false;
    public char b;

    /* renamed from: b  reason: collision with other field name */
    public final int f1030b;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f1031b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1032b = false;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f1033c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1034c = false;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public CharSequence f1035d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1036d = false;
    public int e = 4096;
    public int f = 4096;
    public int g = 0;
    public int h = 16;
    public int i;

    public class a implements G.b {
        public a() {
        }
    }

    public MenuItemImpl(MenuBuilder menuBuilder, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.f1026a = menuBuilder;
        this.f1016a = i3;
        this.f1030b = i2;
        this.c = i4;
        this.d = i5;
        this.f1028a = charSequence;
        this.i = i6;
    }

    public static void e(String str, int i2, int i3, StringBuilder sb) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    public final Jy a(CharSequence charSequence) {
        this.f1035d = charSequence;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final G b() {
        return this.f1017a;
    }

    public final Jy c(G g2) {
        G g3 = this.f1017a;
        if (g3 != null) {
            g3.getClass();
            g3.a = null;
        }
        this.f1025a = null;
        this.f1017a = g2;
        this.f1026a.onItemsChanged(true);
        G g4 = this.f1017a;
        if (g4 != null) {
            g4.h(new a());
        }
        return this;
    }

    public final boolean collapseActionView() {
        if ((this.i & 8) == 0) {
            return false;
        }
        if (this.f1025a == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1023a;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1026a.collapseItemActionView(this);
        }
        return false;
    }

    public final Jy d(CharSequence charSequence) {
        this.f1033c = charSequence;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final boolean expandActionView() {
        if (!g()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f1023a;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1026a.expandItemActionView(this);
        }
        return false;
    }

    public final Drawable f(Drawable drawable) {
        if (drawable != null && this.f1034c && (this.f1029a || this.f1032b)) {
            drawable = drawable.mutate();
            if (this.f1029a) {
                v9.a.h(drawable, this.f1019a);
            }
            if (this.f1032b) {
                v9.a.i(drawable, this.f1020a);
            }
            this.f1034c = false;
        }
        return drawable;
    }

    public final boolean g() {
        G g2;
        if ((this.i & 8) == 0) {
            return false;
        }
        if (this.f1025a == null && (g2 = this.f1017a) != null) {
            this.f1025a = g2.d(this);
        }
        if (this.f1025a != null) {
            return true;
        }
        return false;
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public final View getActionView() {
        View view = this.f1025a;
        if (view != null) {
            return view;
        }
        G g2 = this.f1017a;
        if (g2 == null) {
            return null;
        }
        View d2 = g2.d(this);
        this.f1025a = d2;
        return d2;
    }

    public final int getAlphabeticModifiers() {
        return this.f;
    }

    public final char getAlphabeticShortcut() {
        return this.b;
    }

    public final CharSequence getContentDescription() {
        return this.f1033c;
    }

    public final int getGroupId() {
        return this.f1030b;
    }

    public final Drawable getIcon() {
        Drawable drawable = this.f1021a;
        if (drawable != null) {
            return f(drawable);
        }
        if (this.g == 0) {
            return null;
        }
        Drawable w = r1.w(this.f1026a.getContext(), this.g);
        this.g = 0;
        this.f1021a = w;
        return f(w);
    }

    public final ColorStateList getIconTintList() {
        return this.f1019a;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.f1020a;
    }

    public final Intent getIntent() {
        return this.f1018a;
    }

    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.f1016a;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1022a;
    }

    public final int getNumericModifiers() {
        return this.e;
    }

    public final char getNumericShortcut() {
        return this.a;
    }

    public final int getOrder() {
        return this.c;
    }

    public final SubMenu getSubMenu() {
        return this.f1027a;
    }

    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.f1028a;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1031b;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f1028a;
    }

    public final CharSequence getTooltipText() {
        return this.f1035d;
    }

    public final void h(boolean z) {
        int i2;
        int i3 = this.h & -5;
        if (z) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        this.h = i2 | i3;
    }

    public final boolean hasSubMenu() {
        if (this.f1027a != null) {
            return true;
        }
        return false;
    }

    public final void i(boolean z) {
        if (z) {
            this.h |= 32;
        } else {
            this.h &= -33;
        }
    }

    public final boolean isActionViewExpanded() {
        return this.f1036d;
    }

    public final boolean isCheckable() {
        if ((this.h & 1) == 1) {
            return true;
        }
        return false;
    }

    public final boolean isChecked() {
        if ((this.h & 2) == 2) {
            return true;
        }
        return false;
    }

    public final boolean isEnabled() {
        if ((this.h & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isVisible() {
        G g2 = this.f1017a;
        if (g2 == null || !g2.g()) {
            if ((this.h & 8) == 0) {
                return true;
            }
            return false;
        } else if ((this.h & 8) != 0 || !this.f1017a.b()) {
            return false;
        } else {
            return true;
        }
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public final MenuItem setActionView(View view) {
        int i2;
        this.f1025a = view;
        this.f1017a = null;
        if (view != null && view.getId() == -1 && (i2 = this.f1016a) > 0) {
            view.setId(i2);
        }
        this.f1026a.onItemActionRequestChanged(this);
        return this;
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.b == c2) {
            return this;
        }
        this.b = Character.toLowerCase(c2);
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        int i2 = this.h;
        boolean z2 = z | (i2 & true);
        this.h = z2 ? 1 : 0;
        if (i2 != z2) {
            this.f1026a.onItemsChanged(false);
        }
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        int i2;
        int i3 = this.h;
        int i4 = i3 & 4;
        MenuBuilder menuBuilder = this.f1026a;
        if (i4 != 0) {
            menuBuilder.setExclusiveItemChecked(this);
        } else {
            int i5 = i3 & -3;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            int i6 = i2 | i5;
            this.h = i6;
            if (i3 != i6) {
                menuBuilder.onItemsChanged(false);
            }
        }
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        d(charSequence);
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.h |= 16;
        } else {
            this.h &= -17;
        }
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.g = 0;
        this.f1021a = drawable;
        this.f1034c = true;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1019a = colorStateList;
        this.f1029a = true;
        this.f1034c = true;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1020a = mode;
        this.f1032b = true;
        this.f1034c = true;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f1018a = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c2) {
        if (this.a == c2) {
            return this;
        }
        this.a = c2;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1023a = onActionExpandListener;
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1024a = onMenuItemClickListener;
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.a = c2;
        this.b = Character.toLowerCase(c3);
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.i = i2;
            this.f1026a.onItemActionRequestChanged(this);
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    public final MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f1028a = charSequence;
        this.f1026a.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.f1027a;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1031b = charSequence;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        a(charSequence);
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        int i2;
        int i3 = this.h;
        int i4 = i3 & -9;
        boolean z2 = false;
        if (z) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        int i5 = i2 | i4;
        this.h = i5;
        if (i3 != i5) {
            z2 = true;
        }
        if (z2) {
            this.f1026a.onItemVisibleChanged(this);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f1028a;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.b == c2 && this.f == i2) {
            return this;
        }
        this.b = Character.toLowerCase(c2);
        this.f = KeyEvent.normalizeMetaState(i2);
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2, int i2) {
        if (this.a == c2 && this.e == i2) {
            return this;
        }
        this.a = c2;
        this.e = KeyEvent.normalizeMetaState(i2);
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.a = c2;
        this.e = KeyEvent.normalizeMetaState(i2);
        this.b = Character.toLowerCase(c3);
        this.f = KeyEvent.normalizeMetaState(i3);
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setIcon(int i2) {
        this.f1021a = null;
        this.g = i2;
        this.f1034c = true;
        this.f1026a.onItemsChanged(false);
        return this;
    }

    public final MenuItem setTitle(int i2) {
        setTitle((CharSequence) this.f1026a.getContext().getString(i2));
        return this;
    }

    public final MenuItem setActionView(int i2) {
        int i3;
        MenuBuilder menuBuilder = this.f1026a;
        Context context = menuBuilder.getContext();
        View inflate = LayoutInflater.from(context).inflate(i2, new LinearLayout(context), false);
        this.f1025a = inflate;
        this.f1017a = null;
        if (inflate != null && inflate.getId() == -1 && (i3 = this.f1016a) > 0) {
            inflate.setId(i3);
        }
        menuBuilder.onItemActionRequestChanged(this);
        return this;
    }
}
