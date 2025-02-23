package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* compiled from: MenuAdapter */
public final class e extends BaseAdapter {
    public final LayoutInflater a;

    /* renamed from: a  reason: collision with other field name */
    public final MenuBuilder f1067a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1068a;
    public final boolean b;
    public int c = -1;
    public final int d;

    public e(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i) {
        this.b = z;
        this.a = layoutInflater;
        this.f1067a = menuBuilder;
        this.d = i;
        b();
    }

    public final void b() {
        MenuBuilder menuBuilder = this.f1067a;
        MenuItemImpl expandedItem = menuBuilder.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<MenuItemImpl> nonActionItems = menuBuilder.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.c = i;
                    return;
                }
            }
        }
        this.c = -1;
    }

    /* renamed from: c */
    public final MenuItemImpl getItem(int i) {
        ArrayList<MenuItemImpl> arrayList;
        boolean z = this.b;
        MenuBuilder menuBuilder = this.f1067a;
        if (z) {
            arrayList = menuBuilder.getNonActionItems();
        } else {
            arrayList = menuBuilder.getVisibleItems();
        }
        int i2 = this.c;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return arrayList.get(i);
    }

    public final int getCount() {
        ArrayList<MenuItemImpl> arrayList;
        boolean z = this.b;
        MenuBuilder menuBuilder = this.f1067a;
        if (z) {
            arrayList = menuBuilder.getNonActionItems();
        } else {
            arrayList = menuBuilder.getVisibleItems();
        }
        if (this.c < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        boolean z;
        if (view == null) {
            view = this.a.inflate(this.d, viewGroup, false);
        }
        int i3 = getItem(i).f1030b;
        int i4 = i - 1;
        if (i4 >= 0) {
            i2 = getItem(i4).f1030b;
        } else {
            i2 = i3;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (!this.f1067a.isGroupDividerEnabled() || i3 == i2) {
            z = false;
        } else {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        MenuView.a aVar = (MenuView.a) view;
        if (this.f1068a) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.initialize(getItem(i), 0);
        return view;
    }

    public final void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
