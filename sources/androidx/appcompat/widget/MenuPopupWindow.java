package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.e;
import java.lang.reflect.Method;

public final class MenuPopupWindow extends ListPopupWindow implements Zk {
    public static final Method c;
    public Zk a;

    public static class MenuDropDownListView extends A9 {
        public Zk a;

        /* renamed from: a  reason: collision with other field name */
        public MenuItemImpl f1215a;
        public final int h;
        public final int i;

        public static class a {
            public static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            if (1 == a.a(context.getResources().getConfiguration())) {
                this.h = 21;
                this.i = 22;
                return;
            }
            this.h = 22;
            this.i = 21;
        }

        public final boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            e eVar;
            MenuItemImpl menuItemImpl;
            int pointToPosition;
            int i3;
            if (this.a != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    eVar = (e) headerViewListAdapter.getWrappedAdapter();
                } else {
                    eVar = (e) adapter;
                    i2 = 0;
                }
                if (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i3 = pointToPosition - i2) < 0 || i3 >= eVar.getCount()) {
                    menuItemImpl = null;
                } else {
                    menuItemImpl = eVar.getItem(i3);
                }
                MenuItemImpl menuItemImpl2 = this.f1215a;
                if (menuItemImpl2 != menuItemImpl) {
                    MenuBuilder menuBuilder = eVar.f1067a;
                    if (menuItemImpl2 != null) {
                        this.a.n(menuBuilder, menuItemImpl2);
                    }
                    this.f1215a = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.a.m(menuBuilder, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
            e eVar;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.h) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.i) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    eVar = (e) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    eVar = (e) adapter;
                }
                eVar.f1067a.close(false);
                return true;
            }
        }

        public void setHoverListener(Zk zk) {
            this.a = zk;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public static class a {
        public static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        public static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    public static class b {
        public static void a(PopupWindow popupWindow, boolean z) {
            popupWindow.setTouchModal(z);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                c = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public MenuPopupWindow(Context context, int i, int i2) {
        super(context, (AttributeSet) null, i, i2);
    }

    public final void m(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        Zk zk = this.a;
        if (zk != null) {
            zk.m(menuBuilder, menuItemImpl);
        }
    }

    public final void n(MenuBuilder menuBuilder, MenuItem menuItem) {
        Zk zk = this.a;
        if (zk != null) {
            zk.n(menuBuilder, menuItem);
        }
    }

    public final A9 o(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
