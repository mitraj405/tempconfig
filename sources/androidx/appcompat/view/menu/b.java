package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* compiled from: CascadingMenuPopup */
public final class b extends bl implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int k = Vr.abc_cascading_menu_item_layout;
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f1041a;

    /* renamed from: a  reason: collision with other field name */
    public View f1042a;

    /* renamed from: a  reason: collision with other field name */
    public ViewTreeObserver f1043a;

    /* renamed from: a  reason: collision with other field name */
    public PopupWindow.OnDismissListener f1044a;

    /* renamed from: a  reason: collision with other field name */
    public MenuPresenter.Callback f1045a;

    /* renamed from: a  reason: collision with other field name */
    public final a f1046a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final C0001b f1047a = new C0001b();

    /* renamed from: a  reason: collision with other field name */
    public final c f1048a = new c();

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f1049a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1050a;
    public View b;

    /* renamed from: b  reason: collision with other field name */
    public final ArrayList f1051b = new ArrayList();

    /* renamed from: b  reason: collision with other field name */
    public boolean f1052b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1053c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1054d;
    public final int e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f1055e;
    public int f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f1056f;
    public int g;
    public int h;
    public int i;
    public int j;

    /* compiled from: CascadingMenuPopup */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public final void onGlobalLayout() {
            b bVar = b.this;
            if (bVar.a()) {
                ArrayList arrayList = bVar.f1051b;
                if (arrayList.size() > 0 && !((d) arrayList.get(0)).f1058a.f1214d) {
                    View view = bVar.b;
                    if (view == null || !view.isShown()) {
                        bVar.dismiss();
                        return;
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((d) it.next()).f1058a.show();
                    }
                }
            }
        }
    }

    /* compiled from: CascadingMenuPopup */
    public class c implements Zk {
        public c() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.appcompat.view.menu.b$d} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m(androidx.appcompat.view.menu.MenuBuilder r8, androidx.appcompat.view.menu.MenuItemImpl r9) {
            /*
                r7 = this;
                androidx.appcompat.view.menu.b r0 = androidx.appcompat.view.menu.b.this
                android.os.Handler r1 = r0.f1041a
                r2 = 0
                r1.removeCallbacksAndMessages(r2)
                java.util.ArrayList r1 = r0.f1051b
                int r3 = r1.size()
                r4 = 0
            L_0x000f:
                r5 = -1
                if (r4 >= r3) goto L_0x0020
                java.lang.Object r6 = r1.get(r4)
                androidx.appcompat.view.menu.b$d r6 = (androidx.appcompat.view.menu.b.d) r6
                androidx.appcompat.view.menu.MenuBuilder r6 = r6.f1057a
                if (r8 != r6) goto L_0x001d
                goto L_0x0021
            L_0x001d:
                int r4 = r4 + 1
                goto L_0x000f
            L_0x0020:
                r4 = r5
            L_0x0021:
                if (r4 != r5) goto L_0x0024
                return
            L_0x0024:
                int r4 = r4 + 1
                int r3 = r1.size()
                if (r4 >= r3) goto L_0x0033
                java.lang.Object r1 = r1.get(r4)
                r2 = r1
                androidx.appcompat.view.menu.b$d r2 = (androidx.appcompat.view.menu.b.d) r2
            L_0x0033:
                androidx.appcompat.view.menu.c r1 = new androidx.appcompat.view.menu.c
                r1.<init>(r7, r2, r9, r8)
                long r2 = android.os.SystemClock.uptimeMillis()
                r4 = 200(0xc8, double:9.9E-322)
                long r2 = r2 + r4
                android.os.Handler r9 = r0.f1041a
                r9.postAtTime(r1, r8, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.c.m(androidx.appcompat.view.menu.MenuBuilder, androidx.appcompat.view.menu.MenuItemImpl):void");
        }

        public final void n(MenuBuilder menuBuilder, MenuItem menuItem) {
            b.this.f1041a.removeCallbacksAndMessages(menuBuilder);
        }
    }

    /* compiled from: CascadingMenuPopup */
    public static class d {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final MenuBuilder f1057a;

        /* renamed from: a  reason: collision with other field name */
        public final MenuPopupWindow f1058a;

        public d(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.f1058a = menuPopupWindow;
            this.f1057a = menuBuilder;
            this.a = i;
        }
    }

    public b(Context context, View view, int i2, int i3, boolean z) {
        int i4 = 0;
        this.f = 0;
        this.g = 0;
        this.a = context;
        this.f1042a = view;
        this.d = i2;
        this.e = i3;
        this.f1050a = z;
        this.f1054d = false;
        WeakHashMap<View, GC> weakHashMap = f.f1839a;
        this.h = view.getLayoutDirection() != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(tr.abc_config_prefDialogWidth));
        this.f1041a = new Handler();
    }

    public final boolean a() {
        ArrayList arrayList = this.f1051b;
        if (arrayList.size() <= 0 || !((d) arrayList.get(0)).f1058a.a()) {
            return false;
        }
        return true;
    }

    public final A9 b() {
        ArrayList arrayList = this.f1051b;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((d) arrayList.get(arrayList.size() - 1)).f1058a.f1196a;
    }

    public final void c(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.a);
        if (a()) {
            m(menuBuilder);
        } else {
            this.f1049a.add(menuBuilder);
        }
    }

    public final void dismiss() {
        ArrayList arrayList = this.f1051b;
        int size = arrayList.size();
        if (size > 0) {
            d[] dVarArr = (d[]) arrayList.toArray(new d[size]);
            while (true) {
                size--;
                if (size >= 0) {
                    d dVar = dVarArr[size];
                    if (dVar.f1058a.a()) {
                        dVar.f1058a.dismiss();
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void e(View view) {
        if (this.f1042a != view) {
            this.f1042a = view;
            int i2 = this.f;
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            this.g = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    public final void f(boolean z) {
        this.f1054d = z;
    }

    public final boolean flagActionItems() {
        return false;
    }

    public final void g(int i2) {
        if (this.f != i2) {
            this.f = i2;
            View view = this.f1042a;
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            this.g = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    public final void h(int i2) {
        this.f1052b = true;
        this.i = i2;
    }

    public final void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1044a = onDismissListener;
    }

    public final void j(boolean z) {
        this.f1055e = z;
    }

    public final void k(int i2) {
        this.f1053c = true;
        this.j = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(androidx.appcompat.view.menu.MenuBuilder r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            android.content.Context r2 = r0.a
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r2)
            androidx.appcompat.view.menu.e r4 = new androidx.appcompat.view.menu.e
            boolean r5 = r0.f1050a
            int r6 = k
            r4.<init>(r1, r3, r5, r6)
            boolean r5 = r18.a()
            r6 = 1
            if (r5 != 0) goto L_0x0021
            boolean r5 = r0.f1054d
            if (r5 == 0) goto L_0x0021
            r4.f1068a = r6
            goto L_0x002d
        L_0x0021:
            boolean r5 = r18.a()
            if (r5 == 0) goto L_0x002d
            boolean r5 = defpackage.bl.l(r19)
            r4.f1068a = r5
        L_0x002d:
            int r5 = r0.c
            int r5 = defpackage.bl.d(r4, r2, r5)
            androidx.appcompat.widget.MenuPopupWindow r7 = new androidx.appcompat.widget.MenuPopupWindow
            int r8 = r0.d
            int r9 = r0.e
            r7.<init>(r2, r8, r9)
            androidx.appcompat.view.menu.b$c r2 = r0.f1048a
            r7.a = r2
            r7.f1201a = r0
            android.widget.PopupWindow r2 = r7.f1204a
            r2.setOnDismissListener(r0)
            android.view.View r8 = r0.f1042a
            r7.f1200a = r8
            int r8 = r0.g
            r7.h = r8
            r7.f1214d = r6
            r2.setFocusable(r6)
            r8 = 2
            r2.setInputMethodMode(r8)
            r7.i(r4)
            r7.p(r5)
            int r4 = r0.g
            r7.h = r4
            java.util.ArrayList r4 = r0.f1051b
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x00df
            int r9 = r4.size()
            int r9 = r9 - r6
            java.lang.Object r9 = r4.get(r9)
            androidx.appcompat.view.menu.b$d r9 = (androidx.appcompat.view.menu.b.d) r9
            androidx.appcompat.view.menu.MenuBuilder r12 = r9.f1057a
            int r13 = r12.size()
            r14 = 0
        L_0x007c:
            if (r14 >= r13) goto L_0x0093
            android.view.MenuItem r15 = r12.getItem(r14)
            boolean r16 = r15.hasSubMenu()
            if (r16 == 0) goto L_0x008f
            android.view.SubMenu r8 = r15.getSubMenu()
            if (r1 != r8) goto L_0x008f
            goto L_0x0094
        L_0x008f:
            int r14 = r14 + 1
            r8 = 2
            goto L_0x007c
        L_0x0093:
            r15 = 0
        L_0x0094:
            if (r15 != 0) goto L_0x0098
        L_0x0096:
            r6 = 0
            goto L_0x00e1
        L_0x0098:
            androidx.appcompat.widget.MenuPopupWindow r8 = r9.f1058a
            A9 r8 = r8.f1196a
            android.widget.ListAdapter r12 = r8.getAdapter()
            boolean r13 = r12 instanceof android.widget.HeaderViewListAdapter
            if (r13 == 0) goto L_0x00b1
            android.widget.HeaderViewListAdapter r12 = (android.widget.HeaderViewListAdapter) r12
            int r13 = r12.getHeadersCount()
            android.widget.ListAdapter r12 = r12.getWrappedAdapter()
            androidx.appcompat.view.menu.e r12 = (androidx.appcompat.view.menu.e) r12
            goto L_0x00b4
        L_0x00b1:
            androidx.appcompat.view.menu.e r12 = (androidx.appcompat.view.menu.e) r12
            r13 = 0
        L_0x00b4:
            int r14 = r12.getCount()
            r10 = 0
        L_0x00b9:
            r11 = -1
            if (r10 >= r14) goto L_0x00c7
            androidx.appcompat.view.menu.MenuItemImpl r6 = r12.getItem(r10)
            if (r15 != r6) goto L_0x00c3
            goto L_0x00c8
        L_0x00c3:
            int r10 = r10 + 1
            r6 = 1
            goto L_0x00b9
        L_0x00c7:
            r10 = r11
        L_0x00c8:
            if (r10 != r11) goto L_0x00cb
            goto L_0x0096
        L_0x00cb:
            int r10 = r10 + r13
            int r6 = r8.getFirstVisiblePosition()
            int r10 = r10 - r6
            if (r10 < 0) goto L_0x0096
            int r6 = r8.getChildCount()
            if (r10 < r6) goto L_0x00da
            goto L_0x0096
        L_0x00da:
            android.view.View r6 = r8.getChildAt(r10)
            goto L_0x00e1
        L_0x00df:
            r6 = 0
            r9 = 0
        L_0x00e1:
            if (r6 == 0) goto L_0x0172
            int r8 = android.os.Build.VERSION.SDK_INT
            r10 = 28
            if (r8 > r10) goto L_0x00f9
            java.lang.reflect.Method r8 = androidx.appcompat.widget.MenuPopupWindow.c
            if (r8 == 0) goto L_0x00fd
            r10 = 1
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x00fd }
            java.lang.Boolean r10 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x00fd }
            r12 = 0
            r11[r12] = r10     // Catch:{ Exception -> 0x00fd }
            r8.invoke(r2, r11)     // Catch:{ Exception -> 0x00fd }
            goto L_0x00fd
        L_0x00f9:
            r12 = 0
            androidx.appcompat.widget.MenuPopupWindow.b.a(r2, r12)
        L_0x00fd:
            r8 = 0
            androidx.appcompat.widget.MenuPopupWindow.a.a(r2, r8)
            int r2 = r4.size()
            r8 = 1
            int r2 = r2 - r8
            java.lang.Object r2 = r4.get(r2)
            androidx.appcompat.view.menu.b$d r2 = (androidx.appcompat.view.menu.b.d) r2
            androidx.appcompat.widget.MenuPopupWindow r2 = r2.f1058a
            A9 r2 = r2.f1196a
            r8 = 2
            int[] r8 = new int[r8]
            r2.getLocationOnScreen(r8)
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            android.view.View r11 = r0.b
            r11.getWindowVisibleDisplayFrame(r10)
            int r11 = r0.h
            r12 = 1
            if (r11 != r12) goto L_0x0137
            r17 = 0
            r8 = r8[r17]
            int r2 = r2.getWidth()
            int r2 = r2 + r8
            int r2 = r2 + r5
            int r8 = r10.right
            if (r2 <= r8) goto L_0x013e
            r2 = r17
            goto L_0x013f
        L_0x0137:
            r17 = 0
            r2 = r8[r17]
            int r2 = r2 - r5
            if (r2 >= 0) goto L_0x0141
        L_0x013e:
            r2 = 1
        L_0x013f:
            r8 = 1
            goto L_0x0143
        L_0x0141:
            r2 = 0
            goto L_0x013f
        L_0x0143:
            if (r2 != r8) goto L_0x0147
            r8 = 1
            goto L_0x0148
        L_0x0147:
            r8 = 0
        L_0x0148:
            r0.h = r2
            r7.f1200a = r6
            int r2 = r0.g
            r10 = 5
            r2 = r2 & r10
            if (r2 != r10) goto L_0x015c
            if (r8 == 0) goto L_0x0156
            r2 = 0
            goto L_0x0163
        L_0x0156:
            r2 = 0
            int r5 = r6.getWidth()
            goto L_0x0165
        L_0x015c:
            r2 = 0
            if (r8 == 0) goto L_0x0165
            int r5 = r6.getWidth()
        L_0x0163:
            int r5 = r5 + r2
            goto L_0x0167
        L_0x0165:
            int r5 = 0 - r5
        L_0x0167:
            r7.e = r5
            r5 = 1
            r7.f1213c = r5
            r7.f1212b = r5
            r7.h(r2)
            goto L_0x0190
        L_0x0172:
            boolean r2 = r0.f1052b
            if (r2 == 0) goto L_0x017a
            int r2 = r0.i
            r7.e = r2
        L_0x017a:
            boolean r2 = r0.f1053c
            if (r2 == 0) goto L_0x0183
            int r2 = r0.j
            r7.h(r2)
        L_0x0183:
            android.graphics.Rect r2 = r0.a
            if (r2 == 0) goto L_0x018d
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>(r2)
            goto L_0x018e
        L_0x018d:
            r8 = 0
        L_0x018e:
            r7.f1211b = r8
        L_0x0190:
            androidx.appcompat.view.menu.b$d r2 = new androidx.appcompat.view.menu.b$d
            int r5 = r0.h
            r2.<init>(r7, r1, r5)
            r4.add(r2)
            r7.show()
            A9 r2 = r7.f1196a
            r2.setOnKeyListener(r0)
            if (r9 != 0) goto L_0x01d1
            boolean r4 = r0.f1055e
            if (r4 == 0) goto L_0x01d1
            java.lang.CharSequence r4 = r19.getHeaderTitle()
            if (r4 == 0) goto L_0x01d1
            int r4 = defpackage.Vr.abc_popup_menu_header_item_layout
            r5 = 0
            android.view.View r3 = r3.inflate(r4, r2, r5)
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
            r4 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.setEnabled(r5)
            java.lang.CharSequence r1 = r19.getHeaderTitle()
            r4.setText(r1)
            r1 = 0
            r2.addHeaderView(r3, r1, r5)
            r7.show()
        L_0x01d1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.m(androidx.appcompat.view.menu.MenuBuilder):void");
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int i2;
        ArrayList arrayList = this.f1051b;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (menuBuilder == ((d) arrayList.get(i3)).f1057a) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < arrayList.size()) {
                ((d) arrayList.get(i4)).f1057a.close(false);
            }
            d dVar = (d) arrayList.remove(i3);
            dVar.f1057a.removeMenuPresenter(this);
            boolean z2 = this.f1056f;
            MenuPopupWindow menuPopupWindow = dVar.f1058a;
            if (z2) {
                MenuPopupWindow.a.b(menuPopupWindow.f1204a, (Transition) null);
                menuPopupWindow.f1204a.setAnimationStyle(0);
            }
            menuPopupWindow.dismiss();
            int size2 = arrayList.size();
            if (size2 > 0) {
                this.h = ((d) arrayList.get(size2 - 1)).a;
            } else {
                View view = this.f1042a;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                if (view.getLayoutDirection() == 1) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                this.h = i2;
            }
            if (size2 == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.f1045a;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.f1043a;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f1043a.removeGlobalOnLayoutListener(this.f1046a);
                    }
                    this.f1043a = null;
                }
                this.b.removeOnAttachStateChangeListener(this.f1047a);
                this.f1044a.onDismiss();
            } else if (z) {
                ((d) arrayList.get(0)).f1057a.close(false);
            }
        }
    }

    public final void onDismiss() {
        d dVar;
        ArrayList arrayList = this.f1051b;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = (d) arrayList.get(i2);
            if (!dVar.f1058a.a()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.f1057a.close(false);
        }
    }

    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public final boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        Iterator it = this.f1051b.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (subMenuBuilder == dVar.f1057a) {
                dVar.f1058a.f1196a.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        c(subMenuBuilder);
        MenuPresenter.Callback callback = this.f1045a;
        if (callback != null) {
            callback.a(subMenuBuilder);
        }
        return true;
    }

    public final void setCallback(MenuPresenter.Callback callback) {
        this.f1045a = callback;
    }

    public final void show() {
        boolean z;
        if (!a()) {
            ArrayList arrayList = this.f1049a;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m((MenuBuilder) it.next());
            }
            arrayList.clear();
            View view = this.f1042a;
            this.b = view;
            if (view != null) {
                if (this.f1043a == null) {
                    z = true;
                } else {
                    z = false;
                }
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f1043a = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f1046a);
                }
                this.b.addOnAttachStateChangeListener(this.f1047a);
            }
        }
    }

    public final void updateMenuView(boolean z) {
        Iterator it = this.f1051b.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((d) it.next()).f1058a.f1196a.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((e) adapter).notifyDataSetChanged();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.b$b  reason: collision with other inner class name */
    /* compiled from: CascadingMenuPopup */
    public class C0001b implements View.OnAttachStateChangeListener {
        public C0001b() {
        }

        public final void onViewDetachedFromWindow(View view) {
            b bVar = b.this;
            ViewTreeObserver viewTreeObserver = bVar.f1043a;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    bVar.f1043a = view.getViewTreeObserver();
                }
                bVar.f1043a.removeGlobalOnLayoutListener(bVar.f1046a);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        public final void onViewAttachedToWindow(View view) {
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }
}
