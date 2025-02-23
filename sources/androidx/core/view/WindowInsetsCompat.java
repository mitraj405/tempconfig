package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.view.f;
import defpackage.m9;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.WeakHashMap;

public final class WindowInsetsCompat {
    public static final WindowInsetsCompat a;

    /* renamed from: a  reason: collision with other field name */
    public final k f1818a;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class a {
        public static final Field a;

        /* renamed from: a  reason: collision with other field name */
        public static final boolean f1819a = true;
        public static final Field b;
        public static final Field c;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                e.getMessage();
            }
        }
    }

    public static class d extends c {
        public d() {
        }

        public void c(int i, bg bgVar) {
            this.a.setInsets(m.a(i), bgVar.d());
        }

        public d(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class e {
        public final WindowInsetsCompat a;

        /* renamed from: a  reason: collision with other field name */
        public bg[] f1824a;

        public e() {
            this(new WindowInsetsCompat());
        }

        public final void a() {
            bg[] bgVarArr = this.f1824a;
            if (bgVarArr != null) {
                bg bgVar = bgVarArr[l.a(1)];
                bg bgVar2 = this.f1824a[l.a(2)];
                WindowInsetsCompat windowInsetsCompat = this.a;
                if (bgVar2 == null) {
                    bgVar2 = windowInsetsCompat.a(2);
                }
                if (bgVar == null) {
                    bgVar = windowInsetsCompat.a(1);
                }
                g(bg.a(bgVar, bgVar2));
                bg bgVar3 = this.f1824a[l.a(16)];
                if (bgVar3 != null) {
                    f(bgVar3);
                }
                bg bgVar4 = this.f1824a[l.a(32)];
                if (bgVar4 != null) {
                    d(bgVar4);
                }
                bg bgVar5 = this.f1824a[l.a(64)];
                if (bgVar5 != null) {
                    h(bgVar5);
                }
            }
        }

        public WindowInsetsCompat b() {
            throw null;
        }

        public void c(int i, bg bgVar) {
            if (this.f1824a == null) {
                this.f1824a = new bg[9];
            }
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    this.f1824a[l.a(i2)] = bgVar;
                }
            }
        }

        public void e(bg bgVar) {
            throw null;
        }

        public void g(bg bgVar) {
            throw null;
        }

        public e(WindowInsetsCompat windowInsetsCompat) {
            this.a = windowInsetsCompat;
        }

        public void d(bg bgVar) {
        }

        public void f(bg bgVar) {
        }

        public void h(bg bgVar) {
        }
    }

    public static class f extends k {
        public static Class<?> a = null;

        /* renamed from: a  reason: collision with other field name */
        public static Field f1825a = null;

        /* renamed from: a  reason: collision with other field name */
        public static Method f1826a = null;

        /* renamed from: a  reason: collision with other field name */
        public static boolean f1827a = false;
        public static Field b;

        /* renamed from: a  reason: collision with other field name */
        public final WindowInsets f1828a;

        /* renamed from: a  reason: collision with other field name */
        public bg f1829a = null;

        /* renamed from: a  reason: collision with other field name */
        public bg[] f1830a;

        /* renamed from: b  reason: collision with other field name */
        public bg f1831b;
        public WindowInsetsCompat c;

        public f(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f1828a = windowInsets;
        }

        @SuppressLint({"WrongConstant"})
        private bg r(int i, boolean z) {
            bg bgVar = bg.a;
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    bgVar = bg.a(bgVar, s(i2, z));
                }
            }
            return bgVar;
        }

        private bg t() {
            WindowInsetsCompat windowInsetsCompat = this.c;
            if (windowInsetsCompat != null) {
                return windowInsetsCompat.f1818a.h();
            }
            return bg.a;
        }

        private bg u(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f1827a) {
                    v();
                }
                Method method = f1826a;
                if (!(method == null || a == null || f1825a == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            return null;
                        }
                        Rect rect = (Rect) f1825a.get(b.get(invoke));
                        if (rect != null) {
                            return bg.b(rect.left, rect.top, rect.right, rect.bottom);
                        }
                        return null;
                    } catch (ReflectiveOperationException e) {
                        e.getMessage();
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        @SuppressLint({"PrivateApi"})
        private static void v() {
            try {
                f1826a = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                a = cls;
                f1825a = cls.getDeclaredField("mVisibleInsets");
                b = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f1825a.setAccessible(true);
                b.setAccessible(true);
            } catch (ReflectiveOperationException e) {
                e.getMessage();
            }
            f1827a = true;
        }

        public void d(View view) {
            bg u = u(view);
            if (u == null) {
                u = bg.a;
            }
            w(u);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f1831b, ((f) obj).f1831b);
        }

        public bg f(int i) {
            return r(i, false);
        }

        public final bg j() {
            if (this.f1829a == null) {
                WindowInsets windowInsets = this.f1828a;
                this.f1829a = bg.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
            }
            return this.f1829a;
        }

        public WindowInsetsCompat l(int i, int i2, int i3, int i4) {
            e eVar;
            WindowInsetsCompat i5 = WindowInsetsCompat.i((View) null, this.f1828a);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                eVar = new d(i5);
            } else if (i6 >= 29) {
                eVar = new c(i5);
            } else {
                eVar = new b(i5);
            }
            eVar.g(WindowInsetsCompat.f(j(), i, i2, i3, i4));
            eVar.e(WindowInsetsCompat.f(h(), i, i2, i3, i4));
            return eVar.b();
        }

        public boolean n() {
            return this.f1828a.isRound();
        }

        public void o(bg[] bgVarArr) {
            this.f1830a = bgVarArr;
        }

        public void p(WindowInsetsCompat windowInsetsCompat) {
            this.c = windowInsetsCompat;
        }

        public bg s(int i, boolean z) {
            int i2;
            m9 m9Var;
            int i3;
            int i4;
            int i5;
            int i6 = 0;
            if (i != 1) {
                bg bgVar = null;
                if (i != 2) {
                    bg bgVar2 = bg.a;
                    if (i == 8) {
                        bg[] bgVarArr = this.f1830a;
                        if (bgVarArr != null) {
                            bgVar = bgVarArr[l.a(8)];
                        }
                        if (bgVar != null) {
                            return bgVar;
                        }
                        bg j = j();
                        bg t = t();
                        int i7 = j.d;
                        if (i7 > t.d) {
                            return bg.b(0, 0, 0, i7);
                        }
                        bg bgVar3 = this.f1831b;
                        if (bgVar3 == null || bgVar3.equals(bgVar2) || (i2 = this.f1831b.d) <= t.d) {
                            return bgVar2;
                        }
                        return bg.b(0, 0, 0, i2);
                    } else if (i == 16) {
                        return i();
                    } else {
                        if (i == 32) {
                            return g();
                        }
                        if (i == 64) {
                            return k();
                        }
                        if (i != 128) {
                            return bgVar2;
                        }
                        WindowInsetsCompat windowInsetsCompat = this.c;
                        if (windowInsetsCompat != null) {
                            m9Var = windowInsetsCompat.f1818a.e();
                        } else {
                            m9Var = e();
                        }
                        if (m9Var == null) {
                            return bgVar2;
                        }
                        int i8 = Build.VERSION.SDK_INT;
                        DisplayCutout displayCutout = m9Var.a;
                        if (i8 >= 28) {
                            i3 = m9.a.d(displayCutout);
                        } else {
                            i3 = 0;
                        }
                        if (i8 >= 28) {
                            i4 = m9.a.f(displayCutout);
                        } else {
                            i4 = 0;
                        }
                        if (i8 >= 28) {
                            i5 = m9.a.e(displayCutout);
                        } else {
                            i5 = 0;
                        }
                        if (i8 >= 28) {
                            i6 = m9.a.c(displayCutout);
                        }
                        return bg.b(i3, i4, i5, i6);
                    }
                } else if (z) {
                    bg t2 = t();
                    bg h = h();
                    return bg.b(Math.max(t2.f2741a, h.f2741a), 0, Math.max(t2.c, h.c), Math.max(t2.d, h.d));
                } else {
                    bg j2 = j();
                    WindowInsetsCompat windowInsetsCompat2 = this.c;
                    if (windowInsetsCompat2 != null) {
                        bgVar = windowInsetsCompat2.f1818a.h();
                    }
                    int i9 = j2.d;
                    if (bgVar != null) {
                        i9 = Math.min(i9, bgVar.d);
                    }
                    return bg.b(j2.f2741a, 0, j2.c, i9);
                }
            } else if (z) {
                return bg.b(0, Math.max(t().b, j().b), 0, 0);
            } else {
                return bg.b(0, j().b, 0, 0);
            }
        }

        public void w(bg bgVar) {
            this.f1831b = bgVar;
        }
    }

    public static class g extends f {
        public bg c = null;

        public g(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public WindowInsetsCompat b() {
            return WindowInsetsCompat.i((View) null, this.f1828a.consumeStableInsets());
        }

        public WindowInsetsCompat c() {
            return WindowInsetsCompat.i((View) null, this.f1828a.consumeSystemWindowInsets());
        }

        public final bg h() {
            if (this.c == null) {
                WindowInsets windowInsets = this.f1828a;
                this.c = bg.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
            }
            return this.c;
        }

        public boolean m() {
            return this.f1828a.isConsumed();
        }

        public void q(bg bgVar) {
            this.c = bgVar;
        }
    }

    public static class h extends g {
        public h(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public WindowInsetsCompat a() {
            return WindowInsetsCompat.i((View) null, this.f1828a.consumeDisplayCutout());
        }

        public m9 e() {
            DisplayCutout d = this.f1828a.getDisplayCutout();
            if (d == null) {
                return null;
            }
            return new m9(d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            if (!Objects.equals(this.f1828a, hVar.f1828a) || !Objects.equals(this.f1831b, hVar.f1831b)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f1828a.hashCode();
        }
    }

    public static final class l {
        public static int a(int i) {
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 4) {
                return 2;
            }
            if (i == 8) {
                return 3;
            }
            if (i == 16) {
                return 4;
            }
            if (i == 32) {
                return 5;
            }
            if (i == 64) {
                return 6;
            }
            if (i == 128) {
                return 7;
            }
            if (i == 256) {
                return 8;
            }
            throw new IllegalArgumentException(lf.h("type needs to be >= FIRST and <= LAST, type=", i));
        }
    }

    public static final class m {
        public static int a(int i) {
            int i2;
            int i3 = 0;
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i & i4) != 0) {
                    if (i4 == 1) {
                        i2 = WindowInsets.Type.statusBars();
                    } else if (i4 == 2) {
                        i2 = WindowInsets.Type.navigationBars();
                    } else if (i4 == 4) {
                        i2 = WindowInsets.Type.captionBar();
                    } else if (i4 == 8) {
                        i2 = WindowInsets.Type.ime();
                    } else if (i4 == 16) {
                        i2 = WindowInsets.Type.systemGestures();
                    } else if (i4 == 32) {
                        i2 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i4 == 64) {
                        i2 = WindowInsets.Type.tappableElement();
                    } else if (i4 == 128) {
                        i2 = WindowInsets.Type.displayCutout();
                    }
                    i3 |= i2;
                }
            }
            return i3;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            a = j.d;
        } else {
            a = k.b;
        }
    }

    public WindowInsetsCompat(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f1818a = new j(this, windowInsets);
        } else if (i2 >= 29) {
            this.f1818a = new i(this, windowInsets);
        } else if (i2 >= 28) {
            this.f1818a = new h(this, windowInsets);
        } else {
            this.f1818a = new g(this, windowInsets);
        }
    }

    public static bg f(bg bgVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bgVar.f2741a - i2);
        int max2 = Math.max(0, bgVar.b - i3);
        int max3 = Math.max(0, bgVar.c - i4);
        int max4 = Math.max(0, bgVar.d - i5);
        if (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) {
            return bgVar;
        }
        return bg.b(max, max2, max3, max4);
    }

    public static WindowInsetsCompat i(View view, WindowInsets windowInsets) {
        windowInsets.getClass();
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap<View, GC> weakHashMap = f.f1839a;
            WindowInsetsCompat a2 = f.e.a(view);
            k kVar = windowInsetsCompat.f1818a;
            kVar.p(a2);
            kVar.d(view.getRootView());
        }
        return windowInsetsCompat;
    }

    public final bg a(int i2) {
        return this.f1818a.f(i2);
    }

    @Deprecated
    public final int b() {
        return this.f1818a.j().d;
    }

    @Deprecated
    public final int c() {
        return this.f1818a.j().f2741a;
    }

    @Deprecated
    public final int d() {
        return this.f1818a.j().c;
    }

    @Deprecated
    public final int e() {
        return this.f1818a.j().b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WindowInsetsCompat)) {
            return false;
        }
        return Objects.equals(this.f1818a, ((WindowInsetsCompat) obj).f1818a);
    }

    @Deprecated
    public final WindowInsetsCompat g(int i2, int i3, int i4, int i5) {
        e eVar;
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 30) {
            eVar = new d(this);
        } else if (i6 >= 29) {
            eVar = new c(this);
        } else {
            eVar = new b(this);
        }
        eVar.g(bg.b(i2, i3, i4, i5));
        return eVar.b();
    }

    public final WindowInsets h() {
        k kVar = this.f1818a;
        if (kVar instanceof f) {
            return ((f) kVar).f1828a;
        }
        return null;
    }

    public final int hashCode() {
        k kVar = this.f1818a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    public static class b extends e {
        public static Constructor<WindowInsets> a = null;

        /* renamed from: a  reason: collision with other field name */
        public static Field f1820a = null;

        /* renamed from: a  reason: collision with other field name */
        public static boolean f1821a = false;
        public static boolean b = false;

        /* renamed from: a  reason: collision with other field name */
        public WindowInsets f1822a;

        /* renamed from: a  reason: collision with other field name */
        public bg f1823a;

        public b() {
            this.f1822a = i();
        }

        private static WindowInsets i() {
            Class<WindowInsets> cls = WindowInsets.class;
            if (!f1821a) {
                try {
                    f1820a = cls.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException unused) {
                }
                f1821a = true;
            }
            Field field = f1820a;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException unused2) {
                }
            }
            if (!b) {
                try {
                    a = cls.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException unused3) {
                }
                b = true;
            }
            Constructor<WindowInsets> constructor = a;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException unused4) {
                }
            }
            return null;
        }

        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat i = WindowInsetsCompat.i((View) null, this.f1822a);
            bg[] bgVarArr = this.f1824a;
            k kVar = i.f1818a;
            kVar.o(bgVarArr);
            kVar.q(this.f1823a);
            return i;
        }

        public void e(bg bgVar) {
            this.f1823a = bgVar;
        }

        public void g(bg bgVar) {
            WindowInsets windowInsets = this.f1822a;
            if (windowInsets != null) {
                this.f1822a = windowInsets.replaceSystemWindowInsets(bgVar.f2741a, bgVar.b, bgVar.c, bgVar.d);
            }
        }

        public b(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.f1822a = windowInsetsCompat.h();
        }
    }

    public static class c extends e {
        public final WindowInsets.Builder a;

        public c() {
            this.a = new WindowInsets.Builder();
        }

        public WindowInsetsCompat b() {
            a();
            WindowInsetsCompat i = WindowInsetsCompat.i((View) null, this.a.build());
            i.f1818a.o(this.f1824a);
            return i;
        }

        public void d(bg bgVar) {
            this.a.setMandatorySystemGestureInsets(bgVar.d());
        }

        public void e(bg bgVar) {
            this.a.setStableInsets(bgVar.d());
        }

        public void f(bg bgVar) {
            this.a.setSystemGestureInsets(bgVar.d());
        }

        public void g(bg bgVar) {
            this.a.setSystemWindowInsets(bgVar.d());
        }

        public void h(bg bgVar) {
            this.a.setTappableElementInsets(bgVar.d());
        }

        public c(WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder builder;
            WindowInsets h = windowInsetsCompat.h();
            if (h != null) {
                builder = new WindowInsets.Builder(h);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.a = builder;
        }
    }

    public WindowInsetsCompat() {
        this.f1818a = new k(this);
    }

    public static class i extends h {
        public bg d = null;
        public bg e = null;
        public bg f = null;

        public i(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public bg g() {
            if (this.e == null) {
                this.e = bg.c(this.f1828a.getMandatorySystemGestureInsets());
            }
            return this.e;
        }

        public bg i() {
            if (this.d == null) {
                this.d = bg.c(this.f1828a.getSystemGestureInsets());
            }
            return this.d;
        }

        public bg k() {
            if (this.f == null) {
                this.f = bg.c(this.f1828a.getTappableElementInsets());
            }
            return this.f;
        }

        public WindowInsetsCompat l(int i, int i2, int i3, int i4) {
            return WindowInsetsCompat.i((View) null, this.f1828a.inset(i, i2, i3, i4));
        }

        public void q(bg bgVar) {
        }
    }

    public static class j extends i {
        public static final WindowInsetsCompat d = WindowInsetsCompat.i((View) null, WindowInsets.CONSUMED);

        public j(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        public bg f(int i) {
            return bg.c(this.f1828a.getInsets(m.a(i)));
        }

        public final void d(View view) {
        }
    }

    public static class k {
        public static final WindowInsetsCompat b;
        public final WindowInsetsCompat a;

        static {
            e eVar;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                eVar = new d();
            } else if (i >= 29) {
                eVar = new c();
            } else {
                eVar = new b();
            }
            b = eVar.b().f1818a.a().f1818a.b().f1818a.c();
        }

        public k(WindowInsetsCompat windowInsetsCompat) {
            this.a = windowInsetsCompat;
        }

        public WindowInsetsCompat a() {
            return this.a;
        }

        public WindowInsetsCompat b() {
            return this.a;
        }

        public WindowInsetsCompat c() {
            return this.a;
        }

        public m9 e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            if (n() != kVar.n() || m() != kVar.m() || !Objects.equals(j(), kVar.j()) || !Objects.equals(h(), kVar.h()) || !Objects.equals(e(), kVar.e())) {
                return false;
            }
            return true;
        }

        public bg f(int i) {
            return bg.a;
        }

        public bg g() {
            return j();
        }

        public bg h() {
            return bg.a;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{Boolean.valueOf(n()), Boolean.valueOf(m()), j(), h(), e()});
        }

        public bg i() {
            return j();
        }

        public bg j() {
            return bg.a;
        }

        public bg k() {
            return j();
        }

        public WindowInsetsCompat l(int i, int i2, int i3, int i4) {
            return b;
        }

        public boolean m() {
            return false;
        }

        public boolean n() {
            return false;
        }

        public void d(View view) {
        }

        public void o(bg[] bgVarArr) {
        }

        public void p(WindowInsetsCompat windowInsetsCompat) {
        }

        public void q(bg bgVar) {
        }
    }
}
