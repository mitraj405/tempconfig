package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.appcompat.view.menu.MenuPresenter;

/* compiled from: BaseMenuPresenter */
public abstract class a implements MenuPresenter {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final LayoutInflater f1037a;

    /* renamed from: a  reason: collision with other field name */
    public MenuBuilder f1038a;

    /* renamed from: a  reason: collision with other field name */
    public MenuPresenter.Callback f1039a;

    /* renamed from: a  reason: collision with other field name */
    public MenuView f1040a;
    public Context b;
    public final int c;
    public final int d;
    public int e;

    public a(Context context, int i, int i2) {
        this.a = context;
        this.f1037a = LayoutInflater.from(context);
        this.c = i;
        this.d = i2;
    }

    public final boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public final int getId() {
        return this.e;
    }

    public final void setCallback(MenuPresenter.Callback callback) {
        this.f1039a = callback;
    }
}
