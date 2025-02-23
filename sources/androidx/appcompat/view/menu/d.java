package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

/* compiled from: ListMenuPresenter */
public final class d implements MenuPresenter, AdapterView.OnItemClickListener {
    public Context a;

    /* renamed from: a  reason: collision with other field name */
    public LayoutInflater f1062a;

    /* renamed from: a  reason: collision with other field name */
    public ExpandedMenuView f1063a;

    /* renamed from: a  reason: collision with other field name */
    public MenuBuilder f1064a;

    /* renamed from: a  reason: collision with other field name */
    public MenuPresenter.Callback f1065a;

    /* renamed from: a  reason: collision with other field name */
    public a f1066a;
    public final int c;

    /* compiled from: ListMenuPresenter */
    public class a extends BaseAdapter {
        public int c = -1;

        public a() {
            b();
        }

        public final void b() {
            d dVar = d.this;
            MenuItemImpl expandedItem = dVar.f1064a.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<MenuItemImpl> nonActionItems = dVar.f1064a.getNonActionItems();
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
            d dVar = d.this;
            ArrayList<MenuItemImpl> nonActionItems = dVar.f1064a.getNonActionItems();
            dVar.getClass();
            int i2 = i + 0;
            int i3 = this.c;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        public final int getCount() {
            d dVar = d.this;
            int size = dVar.f1064a.getNonActionItems().size();
            dVar.getClass();
            int i = size + 0;
            if (this.c < 0) {
                return i;
            }
            return i - 1;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                d dVar = d.this;
                view = dVar.f1062a.inflate(dVar.c, viewGroup, false);
            }
            ((MenuView.a) view).initialize(getItem(i), 0);
            return view;
        }

        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public d(Context context, int i) {
        this.c = i;
        this.a = context;
        this.f1062a = LayoutInflater.from(context);
    }

    public final boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public final boolean flagActionItems() {
        return false;
    }

    public final int getId() {
        return 0;
    }

    public final void initForMenu(Context context, MenuBuilder menuBuilder) {
        if (this.a != null) {
            this.a = context;
            if (this.f1062a == null) {
                this.f1062a = LayoutInflater.from(context);
            }
        }
        this.f1064a = menuBuilder;
        a aVar = this.f1066a;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f1065a;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1064a.performItemAction(this.f1066a.getItem(i), this, 0);
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1063a.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public final Parcelable onSaveInstanceState() {
        if (this.f1063a == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f1063a;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        f fVar = new f(subMenuBuilder);
        AlertDialog.Builder builder = new AlertDialog.Builder(subMenuBuilder.getContext());
        d dVar = new d(builder.getContext(), Vr.abc_list_menu_item_layout);
        fVar.f1070a = dVar;
        dVar.f1065a = fVar;
        subMenuBuilder.addMenuPresenter(dVar);
        d dVar2 = fVar.f1070a;
        if (dVar2.f1066a == null) {
            dVar2.f1066a = new a();
        }
        builder.setAdapter(dVar2.f1066a, fVar);
        View headerView = subMenuBuilder.getHeaderView();
        if (headerView != null) {
            builder.setCustomTitle(headerView);
        } else {
            builder.setIcon(subMenuBuilder.getHeaderIcon()).setTitle(subMenuBuilder.getHeaderTitle());
        }
        builder.setOnKeyListener(fVar);
        AlertDialog create = builder.create();
        fVar.a = create;
        create.setOnDismissListener(fVar);
        WindowManager.LayoutParams attributes = fVar.a.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        fVar.a.show();
        MenuPresenter.Callback callback = this.f1065a;
        if (callback == null) {
            return true;
        }
        callback.a(subMenuBuilder);
        return true;
    }

    public final void setCallback(MenuPresenter.Callback callback) {
        this.f1065a = callback;
    }

    public final void updateMenuView(boolean z) {
        a aVar = this.f1066a;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }
}
