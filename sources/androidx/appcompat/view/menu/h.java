package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuPopupWindow;

/* compiled from: StandardMenuPopup */
public final class h extends bl implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public static final int h = Vr.abc_popup_menu_item_layout;
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public View f1080a;

    /* renamed from: a  reason: collision with other field name */
    public ViewTreeObserver f1081a;

    /* renamed from: a  reason: collision with other field name */
    public PopupWindow.OnDismissListener f1082a;

    /* renamed from: a  reason: collision with other field name */
    public final MenuBuilder f1083a;

    /* renamed from: a  reason: collision with other field name */
    public MenuPresenter.Callback f1084a;

    /* renamed from: a  reason: collision with other field name */
    public final e f1085a;

    /* renamed from: a  reason: collision with other field name */
    public final a f1086a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f1087a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final MenuPopupWindow f1088a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1089a;
    public View b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1090b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f1091c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1092d;
    public final int e;
    public int f;
    public int g = 0;

    /* compiled from: StandardMenuPopup */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public final void onGlobalLayout() {
            h hVar = h.this;
            if (hVar.a() && !hVar.f1088a.f1214d) {
                View view = hVar.b;
                if (view == null || !view.isShown()) {
                    hVar.dismiss();
                } else {
                    hVar.f1088a.show();
                }
            }
        }
    }

    public h(int i, int i2, Context context, View view, MenuBuilder menuBuilder, boolean z) {
        this.a = context;
        this.f1083a = menuBuilder;
        this.f1089a = z;
        this.f1085a = new e(menuBuilder, LayoutInflater.from(context), z, h);
        this.d = i;
        this.e = i2;
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(tr.abc_config_prefDialogWidth));
        this.f1080a = view;
        this.f1088a = new MenuPopupWindow(context, i, i2);
        menuBuilder.addMenuPresenter(this, context);
    }

    public final boolean a() {
        if (this.f1090b || !this.f1088a.a()) {
            return false;
        }
        return true;
    }

    public final A9 b() {
        return this.f1088a.f1196a;
    }

    public final void dismiss() {
        if (a()) {
            this.f1088a.dismiss();
        }
    }

    public final void e(View view) {
        this.f1080a = view;
    }

    public final void f(boolean z) {
        this.f1085a.f1068a = z;
    }

    public final boolean flagActionItems() {
        return false;
    }

    public final void g(int i) {
        this.g = i;
    }

    public final void h(int i) {
        this.f1088a.e = i;
    }

    public final void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f1082a = onDismissListener;
    }

    public final void j(boolean z) {
        this.f1092d = z;
    }

    public final void k(int i) {
        this.f1088a.h(i);
    }

    public final void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.f1083a) {
            dismiss();
            MenuPresenter.Callback callback = this.f1084a;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public final void onDismiss() {
        this.f1090b = true;
        this.f1083a.close();
        ViewTreeObserver viewTreeObserver = this.f1081a;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1081a = this.b.getViewTreeObserver();
            }
            this.f1081a.removeGlobalOnLayoutListener(this.f1086a);
            this.f1081a = null;
        }
        this.b.removeOnAttachStateChangeListener(this.f1087a);
        PopupWindow.OnDismissListener onDismissListener = this.f1082a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L_0x007a
            androidx.appcompat.view.menu.g r0 = new androidx.appcompat.view.menu.g
            android.content.Context r5 = r9.a
            android.view.View r6 = r9.b
            boolean r8 = r9.f1089a
            int r3 = r9.d
            int r4 = r9.e
            r2 = r0
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            androidx.appcompat.view.menu.MenuPresenter$Callback r2 = r9.f1084a
            r0.f1075a = r2
            bl r3 = r0.f1077a
            if (r3 == 0) goto L_0x0023
            r3.setCallback(r2)
        L_0x0023:
            boolean r2 = defpackage.bl.l(r10)
            r0.f1079b = r2
            bl r3 = r0.f1077a
            if (r3 == 0) goto L_0x0030
            r3.f(r2)
        L_0x0030:
            android.widget.PopupWindow$OnDismissListener r2 = r9.f1082a
            r0.f1073a = r2
            r2 = 0
            r9.f1082a = r2
            androidx.appcompat.view.menu.MenuBuilder r2 = r9.f1083a
            r2.close(r1)
            androidx.appcompat.widget.MenuPopupWindow r2 = r9.f1088a
            int r3 = r2.e
            int r2 = r2.g()
            int r4 = r9.g
            android.view.View r5 = r9.f1080a
            java.util.WeakHashMap<android.view.View, GC> r6 = androidx.core.view.f.f1839a
            int r5 = r5.getLayoutDirection()
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L_0x005e
            android.view.View r4 = r9.f1080a
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L_0x005e:
            boolean r4 = r0.b()
            r5 = 1
            if (r4 == 0) goto L_0x0066
            goto L_0x006f
        L_0x0066:
            android.view.View r4 = r0.f1072a
            if (r4 != 0) goto L_0x006c
            r0 = r1
            goto L_0x0070
        L_0x006c:
            r0.d(r3, r2, r5, r5)
        L_0x006f:
            r0 = r5
        L_0x0070:
            if (r0 == 0) goto L_0x007a
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r9.f1084a
            if (r0 == 0) goto L_0x0079
            r0.a(r10)
        L_0x0079:
            return r5
        L_0x007a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.h.onSubMenuSelected(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public final void setCallback(MenuPresenter.Callback callback) {
        this.f1084a = callback;
    }

    public final void show() {
        View view;
        boolean z;
        Rect rect;
        boolean z2 = true;
        if (!a()) {
            if (this.f1090b || (view = this.f1080a) == null) {
                z2 = false;
            } else {
                this.b = view;
                MenuPopupWindow menuPopupWindow = this.f1088a;
                menuPopupWindow.f1204a.setOnDismissListener(this);
                menuPopupWindow.f1201a = this;
                menuPopupWindow.f1214d = true;
                PopupWindow popupWindow = menuPopupWindow.f1204a;
                popupWindow.setFocusable(true);
                View view2 = this.b;
                if (this.f1081a == null) {
                    z = true;
                } else {
                    z = false;
                }
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.f1081a = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f1086a);
                }
                view2.addOnAttachStateChangeListener(this.f1087a);
                menuPopupWindow.f1200a = view2;
                menuPopupWindow.h = this.g;
                boolean z3 = this.f1091c;
                Context context = this.a;
                e eVar = this.f1085a;
                if (!z3) {
                    this.f = bl.d(eVar, context, this.c);
                    this.f1091c = true;
                }
                menuPopupWindow.p(this.f);
                popupWindow.setInputMethodMode(2);
                Rect rect2 = this.a;
                if (rect2 != null) {
                    rect = new Rect(rect2);
                } else {
                    rect = null;
                }
                menuPopupWindow.f1211b = rect;
                menuPopupWindow.show();
                A9 a9 = menuPopupWindow.f1196a;
                a9.setOnKeyListener(this);
                if (this.f1092d) {
                    MenuBuilder menuBuilder = this.f1083a;
                    if (menuBuilder.getHeaderTitle() != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(Vr.abc_popup_menu_header_item_layout, a9, false);
                        TextView textView = (TextView) frameLayout.findViewById(16908310);
                        if (textView != null) {
                            textView.setText(menuBuilder.getHeaderTitle());
                        }
                        frameLayout.setEnabled(false);
                        a9.addHeaderView(frameLayout, (Object) null, false);
                    }
                }
                menuPopupWindow.i(eVar);
                menuPopupWindow.show();
            }
        }
        if (!z2) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public final void updateMenuView(boolean z) {
        this.f1091c = false;
        e eVar = this.f1085a;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    /* compiled from: StandardMenuPopup */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public final void onViewDetachedFromWindow(View view) {
            h hVar = h.this;
            ViewTreeObserver viewTreeObserver = hVar.f1081a;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    hVar.f1081a = view.getViewTreeObserver();
                }
                hVar.f1081a.removeGlobalOnLayoutListener(hVar.f1086a);
            }
            view.removeOnAttachStateChangeListener(this);
        }

        public final void onViewAttachedToWindow(View view) {
        }
    }

    public final void c(MenuBuilder menuBuilder) {
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }
}
