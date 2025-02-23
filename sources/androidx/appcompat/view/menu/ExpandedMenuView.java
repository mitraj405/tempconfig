package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;

public final class ExpandedMenuView extends ListView implements MenuBuilder.a, MenuView, AdapterView.OnItemClickListener {
    public static final int[] a = {16842964, 16843049};

    /* renamed from: a  reason: collision with other field name */
    public MenuBuilder f1001a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public final boolean a(MenuItemImpl menuItemImpl) {
        return this.f1001a.performItemAction(menuItemImpl, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public final void initialize(MenuBuilder menuBuilder) {
        this.f1001a = menuBuilder;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        a((MenuItemImpl) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, a, i, 0));
        if (tintTypedArray.l(0)) {
            setBackgroundDrawable(tintTypedArray.e(0));
        }
        if (tintTypedArray.l(1)) {
            setDivider(tintTypedArray.e(1));
        }
        tintTypedArray.n();
    }
}
