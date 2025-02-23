package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import defpackage.v9;

public final class AppCompatCompoundButtonHelper {
    public ColorStateList a = null;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuff.Mode f1160a = null;

    /* renamed from: a  reason: collision with other field name */
    public final CompoundButton f1161a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1162a = false;
    public boolean b = false;
    public boolean c;

    public AppCompatCompoundButtonHelper(CompoundButton compoundButton) {
        this.f1161a = compoundButton;
    }

    public final void a() {
        CompoundButton compoundButton = this.f1161a;
        Drawable a2 = n6.a(compoundButton);
        if (a2 == null) {
            return;
        }
        if (this.f1162a || this.b) {
            Drawable mutate = a2.mutate();
            if (this.f1162a) {
                v9.a.h(mutate, this.a);
            }
            if (this.b) {
                v9.a.i(mutate, this.f1160a);
            }
            if (mutate.isStateful()) {
                mutate.setState(compoundButton.getDrawableState());
            }
            compoundButton.setButtonDrawable(mutate);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037 A[SYNTHETIC, Splitter:B:12:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067 A[Catch:{ all -> 0x0078 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.util.AttributeSet r9, int r10) {
        /*
            r8 = this;
            android.widget.CompoundButton r6 = r8.f1161a
            android.content.Context r0 = r6.getContext()
            int[] r2 = defpackage.ps.CompoundButton
            androidx.appcompat.widget.TintTypedArray r7 = androidx.appcompat.widget.TintTypedArray.m(r0, r9, r2, r10)
            android.content.Context r1 = r6.getContext()
            android.content.res.TypedArray r4 = r7.f1265a
            r0 = r6
            r3 = r9
            r5 = r10
            androidx.core.view.f.n(r0, r1, r2, r3, r4, r5)
            int r9 = defpackage.ps.CompoundButton_buttonCompat     // Catch:{ all -> 0x0078 }
            boolean r10 = r7.l(r9)     // Catch:{ all -> 0x0078 }
            r0 = 0
            if (r10 == 0) goto L_0x0034
            int r9 = r7.i(r9, r0)     // Catch:{ all -> 0x0078 }
            if (r9 == 0) goto L_0x0034
            android.content.Context r10 = r6.getContext()     // Catch:{ NotFoundException -> 0x0034 }
            android.graphics.drawable.Drawable r9 = defpackage.r1.w(r10, r9)     // Catch:{ NotFoundException -> 0x0034 }
            r6.setButtonDrawable(r9)     // Catch:{ NotFoundException -> 0x0034 }
            r9 = 1
            goto L_0x0035
        L_0x0034:
            r9 = r0
        L_0x0035:
            if (r9 != 0) goto L_0x0050
            int r9 = defpackage.ps.CompoundButton_android_button     // Catch:{ all -> 0x0078 }
            boolean r10 = r7.l(r9)     // Catch:{ all -> 0x0078 }
            if (r10 == 0) goto L_0x0050
            int r9 = r7.i(r9, r0)     // Catch:{ all -> 0x0078 }
            if (r9 == 0) goto L_0x0050
            android.content.Context r10 = r6.getContext()     // Catch:{ all -> 0x0078 }
            android.graphics.drawable.Drawable r9 = defpackage.r1.w(r10, r9)     // Catch:{ all -> 0x0078 }
            r6.setButtonDrawable(r9)     // Catch:{ all -> 0x0078 }
        L_0x0050:
            int r9 = defpackage.ps.CompoundButton_buttonTint     // Catch:{ all -> 0x0078 }
            boolean r10 = r7.l(r9)     // Catch:{ all -> 0x0078 }
            if (r10 == 0) goto L_0x005f
            android.content.res.ColorStateList r9 = r7.b(r9)     // Catch:{ all -> 0x0078 }
            defpackage.m6.c(r6, r9)     // Catch:{ all -> 0x0078 }
        L_0x005f:
            int r9 = defpackage.ps.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0078 }
            boolean r10 = r7.l(r9)     // Catch:{ all -> 0x0078 }
            if (r10 == 0) goto L_0x0074
            r10 = -1
            int r9 = r7.h(r9, r10)     // Catch:{ all -> 0x0078 }
            r10 = 0
            android.graphics.PorterDuff$Mode r9 = defpackage.w9.c(r9, r10)     // Catch:{ all -> 0x0078 }
            defpackage.m6.d(r6, r9)     // Catch:{ all -> 0x0078 }
        L_0x0074:
            r7.n()
            return
        L_0x0078:
            r9 = move-exception
            r7.n()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.b(android.util.AttributeSet, int):void");
    }
}
