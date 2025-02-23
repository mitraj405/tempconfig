package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.b;
import androidx.appcompat.view.menu.e;

/* renamed from: bl  reason: default package */
/* compiled from: MenuPopup */
public abstract class bl implements Fw, MenuPresenter, AdapterView.OnItemClickListener {
    public Rect a;

    public static int d(e eVar, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = eVar.getCount();
        int i2 = 0;
        int i3 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = eVar.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = eVar.getView(i4, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean l(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = menuBuilder.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void c(MenuBuilder menuBuilder);

    public final boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public abstract void e(View view);

    public final boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public abstract void f(boolean z);

    public abstract void g(int i);

    public final int getId() {
        return 0;
    }

    public abstract void h(int i);

    public abstract void i(PopupWindow.OnDismissListener onDismissListener);

    public abstract void j(boolean z);

    public abstract void k(int i);

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e eVar;
        int i2;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            eVar = (e) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            eVar = (e) listAdapter;
        }
        MenuBuilder menuBuilder = eVar.f1067a;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i);
        if (!(this instanceof b)) {
            i2 = 0;
        } else {
            i2 = 4;
        }
        menuBuilder.performItemAction(menuItem, this, i2);
    }

    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
    }
}
