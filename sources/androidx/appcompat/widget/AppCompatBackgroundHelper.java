package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.core.view.f;
import java.util.WeakHashMap;

public final class AppCompatBackgroundHelper {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public Zz f1154a;

    /* renamed from: a  reason: collision with other field name */
    public final View f1155a;

    /* renamed from: a  reason: collision with other field name */
    public final o1 f1156a;
    public Zz b;
    public Zz c;

    public AppCompatBackgroundHelper(View view) {
        this.f1155a = view;
        this.f1156a = o1.a();
    }

    public final void a() {
        boolean z;
        View view = this.f1155a;
        Drawable background = view.getBackground();
        if (background != null) {
            boolean z2 = false;
            if (this.f1154a != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (this.c == null) {
                    this.c = new Zz();
                }
                Zz zz = this.c;
                zz.a = null;
                zz.b = false;
                zz.f786a = null;
                zz.f787a = false;
                WeakHashMap<View, GC> weakHashMap = f.f1839a;
                ColorStateList g = f.d.g(view);
                if (g != null) {
                    zz.b = true;
                    zz.a = g;
                }
                PorterDuff.Mode h = f.d.h(view);
                if (h != null) {
                    zz.f787a = true;
                    zz.f786a = h;
                }
                if (zz.b || zz.f787a) {
                    o1.e(background, zz, view.getDrawableState());
                    z2 = true;
                }
                if (z2) {
                    return;
                }
            }
            Zz zz2 = this.b;
            if (zz2 != null) {
                o1.e(background, zz2, view.getDrawableState());
                return;
            }
            Zz zz3 = this.f1154a;
            if (zz3 != null) {
                o1.e(background, zz3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        Zz zz = this.b;
        if (zz != null) {
            return zz.a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        Zz zz = this.b;
        if (zz != null) {
            return zz.f786a;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0069, code lost:
        r1.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        throw r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            android.view.View r0 = r8.f1155a
            android.content.Context r1 = r0.getContext()
            int[] r4 = defpackage.ps.ViewBackgroundHelper
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.m(r1, r9, r4, r10)
            android.view.View r2 = r8.f1155a
            android.content.Context r3 = r2.getContext()
            android.content.res.TypedArray r6 = r1.f1265a
            r5 = r9
            r7 = r10
            androidx.core.view.f.n(r2, r3, r4, r5, r6, r7)
            int r9 = defpackage.ps.ViewBackgroundHelper_android_background     // Catch:{ all -> 0x0068 }
            boolean r10 = r1.l(r9)     // Catch:{ all -> 0x0068 }
            r2 = -1
            if (r10 == 0) goto L_0x0041
            int r9 = r1.i(r9, r2)     // Catch:{ all -> 0x0068 }
            r8.a = r9     // Catch:{ all -> 0x0068 }
            o1 r9 = r8.f1156a     // Catch:{ all -> 0x0068 }
            android.content.Context r10 = r0.getContext()     // Catch:{ all -> 0x0068 }
            int r3 = r8.a     // Catch:{ all -> 0x0068 }
            monitor-enter(r9)     // Catch:{ all -> 0x0068 }
            Dt r4 = r9.f3135a     // Catch:{ all -> 0x003e }
            android.content.res.ColorStateList r10 = r4.h(r10, r3)     // Catch:{ all -> 0x003e }
            monitor-exit(r9)     // Catch:{ all -> 0x0068 }
            if (r10 == 0) goto L_0x0041
            r8.g(r10)     // Catch:{ all -> 0x0068 }
            goto L_0x0041
        L_0x003e:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0068 }
            throw r10     // Catch:{ all -> 0x0068 }
        L_0x0041:
            int r9 = defpackage.ps.ViewBackgroundHelper_backgroundTint     // Catch:{ all -> 0x0068 }
            boolean r10 = r1.l(r9)     // Catch:{ all -> 0x0068 }
            if (r10 == 0) goto L_0x0050
            android.content.res.ColorStateList r9 = r1.b(r9)     // Catch:{ all -> 0x0068 }
            androidx.core.view.f.d.q(r0, r9)     // Catch:{ all -> 0x0068 }
        L_0x0050:
            int r9 = defpackage.ps.ViewBackgroundHelper_backgroundTintMode     // Catch:{ all -> 0x0068 }
            boolean r10 = r1.l(r9)     // Catch:{ all -> 0x0068 }
            if (r10 == 0) goto L_0x0064
            int r9 = r1.h(r9, r2)     // Catch:{ all -> 0x0068 }
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = defpackage.w9.c(r9, r10)     // Catch:{ all -> 0x0068 }
            androidx.core.view.f.d.r(r0, r9)     // Catch:{ all -> 0x0068 }
        L_0x0064:
            r1.n()
            return
        L_0x0068:
            r9 = move-exception
            r1.n()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatBackgroundHelper.d(android.util.AttributeSet, int):void");
    }

    public final void e() {
        this.a = -1;
        g((ColorStateList) null);
        a();
    }

    public final void f(int i) {
        ColorStateList colorStateList;
        this.a = i;
        o1 o1Var = this.f1156a;
        if (o1Var != null) {
            Context context = this.f1155a.getContext();
            synchronized (o1Var) {
                colorStateList = o1Var.f3135a.h(context, i);
            }
        } else {
            colorStateList = null;
        }
        g(colorStateList);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1154a == null) {
                this.f1154a = new Zz();
            }
            Zz zz = this.f1154a;
            zz.a = colorStateList;
            zz.b = true;
        } else {
            this.f1154a = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new Zz();
        }
        Zz zz = this.b;
        zz.a = colorStateList;
        zz.b = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new Zz();
        }
        Zz zz = this.b;
        zz.f786a = mode;
        zz.f787a = true;
        a();
    }
}
