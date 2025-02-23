package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import defpackage.d7;
import defpackage.v9;

/* renamed from: F  reason: default package */
/* compiled from: ActionMenuItem */
public final class F implements Jy {
    public char a;

    /* renamed from: a  reason: collision with other field name */
    public int f175a = 4096;

    /* renamed from: a  reason: collision with other field name */
    public final Context f176a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f177a;

    /* renamed from: a  reason: collision with other field name */
    public ColorStateList f178a = null;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuff.Mode f179a = null;

    /* renamed from: a  reason: collision with other field name */
    public Drawable f180a;

    /* renamed from: a  reason: collision with other field name */
    public CharSequence f181a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f182a = false;
    public char b;

    /* renamed from: b  reason: collision with other field name */
    public int f183b = 4096;

    /* renamed from: b  reason: collision with other field name */
    public CharSequence f184b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f185b = false;
    public int c = 16;

    /* renamed from: c  reason: collision with other field name */
    public CharSequence f186c;
    public CharSequence d;

    public F(Context context, CharSequence charSequence) {
        this.f176a = context;
        this.f181a = charSequence;
    }

    public final Jy a(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    public final G b() {
        return null;
    }

    public final Jy c(G g) {
        throw new UnsupportedOperationException();
    }

    public final boolean collapseActionView() {
        return false;
    }

    public final Jy d(CharSequence charSequence) {
        this.f186c = charSequence;
        return this;
    }

    public final void e() {
        Drawable drawable = this.f180a;
        if (drawable == null) {
            return;
        }
        if (this.f182a || this.f185b) {
            this.f180a = drawable;
            Drawable mutate = drawable.mutate();
            this.f180a = mutate;
            if (this.f182a) {
                v9.a.h(mutate, this.f178a);
            }
            if (this.f185b) {
                v9.a.i(this.f180a, this.f179a);
            }
        }
    }

    public final boolean expandActionView() {
        return false;
    }

    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public final View getActionView() {
        return null;
    }

    public final int getAlphabeticModifiers() {
        return this.f183b;
    }

    public final char getAlphabeticShortcut() {
        return this.b;
    }

    public final CharSequence getContentDescription() {
        return this.f186c;
    }

    public final int getGroupId() {
        return 0;
    }

    public final Drawable getIcon() {
        return this.f180a;
    }

    public final ColorStateList getIconTintList() {
        return this.f178a;
    }

    public final PorterDuff.Mode getIconTintMode() {
        return this.f179a;
    }

    public final Intent getIntent() {
        return this.f177a;
    }

    public final int getItemId() {
        return 16908332;
    }

    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    public final int getNumericModifiers() {
        return this.f175a;
    }

    public final char getNumericShortcut() {
        return this.a;
    }

    public final int getOrder() {
        return 0;
    }

    public final SubMenu getSubMenu() {
        return null;
    }

    public final CharSequence getTitle() {
        return this.f181a;
    }

    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f184b;
        if (charSequence != null) {
            return charSequence;
        }
        return this.f181a;
    }

    public final CharSequence getTooltipText() {
        return this.d;
    }

    public final boolean hasSubMenu() {
        return false;
    }

    public final boolean isActionViewExpanded() {
        return false;
    }

    public final boolean isCheckable() {
        if ((this.c & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isChecked() {
        if ((this.c & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isEnabled() {
        if ((this.c & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isVisible() {
        if ((this.c & 8) == 0) {
            return true;
        }
        return false;
    }

    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setAlphabeticShortcut(char c2) {
        this.b = Character.toLowerCase(c2);
        return this;
    }

    public final MenuItem setCheckable(boolean z) {
        this.c = z | (this.c & true) ? 1 : 0;
        return this;
    }

    public final MenuItem setChecked(boolean z) {
        int i;
        int i2 = this.c & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.c = i | i2;
        return this;
    }

    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f186c = charSequence;
        return this;
    }

    public final MenuItem setEnabled(boolean z) {
        int i;
        int i2 = this.c & -17;
        if (z) {
            i = 16;
        } else {
            i = 0;
        }
        this.c = i | i2;
        return this;
    }

    public final MenuItem setIcon(Drawable drawable) {
        this.f180a = drawable;
        e();
        return this;
    }

    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f178a = colorStateList;
        this.f182a = true;
        e();
        return this;
    }

    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f179a = mode;
        this.f185b = true;
        e();
        return this;
    }

    public final MenuItem setIntent(Intent intent) {
        this.f177a = intent;
        return this;
    }

    public final MenuItem setNumericShortcut(char c2) {
        this.a = c2;
        return this;
    }

    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setShortcut(char c2, char c3) {
        this.a = c2;
        this.b = Character.toLowerCase(c3);
        return this;
    }

    public final MenuItem setTitle(CharSequence charSequence) {
        this.f181a = charSequence;
        return this;
    }

    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f184b = charSequence;
        return this;
    }

    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    public final MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.c & 8;
        if (z) {
            i = 0;
        }
        this.c = i2 | i;
        return this;
    }

    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    public final MenuItem setAlphabeticShortcut(char c2, int i) {
        this.b = Character.toLowerCase(c2);
        this.f183b = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setNumericShortcut(char c2, int i) {
        this.a = c2;
        this.f175a = KeyEvent.normalizeMetaState(i);
        return this;
    }

    public final MenuItem setTitle(int i) {
        this.f181a = this.f176a.getResources().getString(i);
        return this;
    }

    public final MenuItem setIcon(int i) {
        Object obj = d7.a;
        this.f180a = d7.a.b(this.f176a, i);
        e();
        return this;
    }

    public final MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.a = c2;
        this.f175a = KeyEvent.normalizeMetaState(i);
        this.b = Character.toLowerCase(c3);
        this.f183b = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public final void setShowAsAction(int i) {
    }

    public final MenuItem setShowAsActionFlags(int i) {
        return this;
    }
}
