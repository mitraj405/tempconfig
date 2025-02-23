package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.f;
import java.util.WeakHashMap;

/* compiled from: MenuPopupHelper */
public class g {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1071a;

    /* renamed from: a  reason: collision with other field name */
    public View f1072a;

    /* renamed from: a  reason: collision with other field name */
    public PopupWindow.OnDismissListener f1073a;

    /* renamed from: a  reason: collision with other field name */
    public final MenuBuilder f1074a;

    /* renamed from: a  reason: collision with other field name */
    public MenuPresenter.Callback f1075a;

    /* renamed from: a  reason: collision with other field name */
    public final a f1076a;

    /* renamed from: a  reason: collision with other field name */
    public bl f1077a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1078a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1079b;
    public int c;

    /* compiled from: MenuPopupHelper */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public final void onDismiss() {
            g.this.c();
        }
    }

    /* compiled from: MenuPopupHelper */
    public static class b {
        public static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    public g(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(i, 0, context, view, menuBuilder, z);
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [androidx.appcompat.view.menu.MenuPresenter, bl] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.h] */
    /* JADX WARNING: type inference failed for: r1v10, types: [androidx.appcompat.view.menu.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.bl a() {
        /*
            r14 = this;
            bl r0 = r14.f1077a
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = "window"
            android.content.Context r1 = r14.f1071a
            java.lang.Object r0 = r1.getSystemService(r0)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r2 = new android.graphics.Point
            r2.<init>()
            androidx.appcompat.view.menu.g.b.a(r0, r2)
            int r0 = r2.x
            int r2 = r2.y
            int r0 = java.lang.Math.min(r0, r2)
            android.content.res.Resources r1 = r1.getResources()
            int r2 = defpackage.tr.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 == 0) goto L_0x0044
            androidx.appcompat.view.menu.b r0 = new androidx.appcompat.view.menu.b
            android.content.Context r2 = r14.f1071a
            android.view.View r3 = r14.f1072a
            int r4 = r14.a
            int r5 = r14.b
            boolean r6 = r14.f1078a
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0056
        L_0x0044:
            androidx.appcompat.view.menu.h r0 = new androidx.appcompat.view.menu.h
            android.content.Context r10 = r14.f1071a
            androidx.appcompat.view.menu.MenuBuilder r12 = r14.f1074a
            android.view.View r11 = r14.f1072a
            int r8 = r14.a
            int r9 = r14.b
            boolean r13 = r14.f1078a
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x0056:
            androidx.appcompat.view.menu.MenuBuilder r1 = r14.f1074a
            r0.c(r1)
            androidx.appcompat.view.menu.g$a r1 = r14.f1076a
            r0.i(r1)
            android.view.View r1 = r14.f1072a
            r0.e(r1)
            androidx.appcompat.view.menu.MenuPresenter$Callback r1 = r14.f1075a
            r0.setCallback(r1)
            boolean r1 = r14.f1079b
            r0.f(r1)
            int r1 = r14.c
            r0.g(r1)
            r14.f1077a = r0
        L_0x0076:
            bl r0 = r14.f1077a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.g.a():bl");
    }

    public final boolean b() {
        bl blVar = this.f1077a;
        if (blVar == null || !blVar.a()) {
            return false;
        }
        return true;
    }

    public void c() {
        this.f1077a = null;
        PopupWindow.OnDismissListener onDismissListener = this.f1073a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(int i, int i2, boolean z, boolean z2) {
        bl a2 = a();
        a2.j(z2);
        if (z) {
            int i3 = this.c;
            View view = this.f1072a;
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            if ((Gravity.getAbsoluteGravity(i3, view.getLayoutDirection()) & 7) == 5) {
                i -= this.f1072a.getWidth();
            }
            a2.h(i);
            a2.k(i2);
            int i4 = (int) ((this.f1071a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.a = new Rect(i - i4, i2 - i4, i + i4, i2 + i4);
        }
        a2.show();
    }

    public g(int i, int i2, Context context, View view, MenuBuilder menuBuilder, boolean z) {
        this.c = 8388611;
        this.f1076a = new a();
        this.f1071a = context;
        this.f1074a = menuBuilder;
        this.f1072a = view;
        this.f1078a = z;
        this.a = i;
        this.b = i2;
    }
}
