package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: xy  reason: default package and case insensitive filesystem */
/* compiled from: SubMenuWrapperICS */
public final class C0399xy extends cl implements SubMenu {
    public final Ny a;

    public C0399xy(Context context, Ny ny) {
        super(context, ny);
        this.a = ny;
    }

    public final void clearHeader() {
        this.a.clearHeader();
    }

    public final MenuItem getItem() {
        return e(this.a.getItem());
    }

    public final SubMenu setHeaderIcon(int i) {
        this.a.setHeaderIcon(i);
        return this;
    }

    public final SubMenu setHeaderTitle(int i) {
        this.a.setHeaderTitle(i);
        return this;
    }

    public final SubMenu setHeaderView(View view) {
        this.a.setHeaderView(view);
        return this;
    }

    public final SubMenu setIcon(int i) {
        this.a.setIcon(i);
        return this;
    }

    public final SubMenu setHeaderIcon(Drawable drawable) {
        this.a.setHeaderIcon(drawable);
        return this;
    }

    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        this.a.setHeaderTitle(charSequence);
        return this;
    }

    public final SubMenu setIcon(Drawable drawable) {
        this.a.setIcon(drawable);
        return this;
    }
}
