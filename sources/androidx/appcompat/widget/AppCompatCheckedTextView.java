package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

public class AppCompatCheckedTextView extends CheckedTextView {
    public final AppCompatBackgroundHelper a;

    /* renamed from: a  reason: collision with other field name */
    public AppCompatEmojiTextHelper f1157a;

    /* renamed from: a  reason: collision with other field name */
    public final AppCompatTextHelper f1158a;

    /* renamed from: a  reason: collision with other field name */
    public final h1 f1159a;

    public AppCompatCheckedTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1157a == null) {
            this.f1157a = new AppCompatEmojiTextHelper(this);
        }
        return this.f1157a;
    }

    public final void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.f1158a;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.a();
        }
        h1 h1Var = this.f1159a;
        if (h1Var != null) {
            h1Var.a();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return Nz.e(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        h1 h1Var = this.f1159a;
        if (h1Var != null) {
            return h1Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        h1 h1Var = this.f1159a;
        if (h1Var != null) {
            return h1Var.f2980a;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1158a.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1158a.e();
    }

    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        r1.J(this, editorInfo, onCreateInputConnection);
        return onCreateInputConnection;
    }

    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().d(z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.e();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(i);
        }
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        h1 h1Var = this.f1159a;
        if (h1Var == null) {
            return;
        }
        if (h1Var.c) {
            h1Var.c = false;
            return;
        }
        h1Var.c = true;
        h1Var.a();
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1158a;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1158a;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(Nz.f(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().e(z);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        h1 h1Var = this.f1159a;
        if (h1Var != null) {
            h1Var.a = colorStateList;
            h1Var.f2982a = true;
            h1Var.a();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        h1 h1Var = this.f1159a;
        if (h1Var != null) {
            h1Var.f2980a = mode;
            h1Var.b = true;
            h1Var.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        AppCompatTextHelper appCompatTextHelper = this.f1158a;
        appCompatTextHelper.i(colorStateList);
        appCompatTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        AppCompatTextHelper appCompatTextHelper = this.f1158a;
        appCompatTextHelper.j(mode);
        appCompatTextHelper.b();
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.f1158a;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.g(context, i);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0220hr.checkedTextViewStyle);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0060 A[SYNTHETIC, Splitter:B:12:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[Catch:{ all -> 0x00a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0090 A[Catch:{ all -> 0x00a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatCheckedTextView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            defpackage.Yz.a(r7)
            r6.<init>(r7, r8, r9)
            android.content.Context r7 = r6.getContext()
            defpackage.Oz.a(r7, r6)
            androidx.appcompat.widget.AppCompatTextHelper r7 = new androidx.appcompat.widget.AppCompatTextHelper
            r7.<init>(r6)
            r6.f1158a = r7
            r7.f(r8, r9)
            r7.b()
            androidx.appcompat.widget.AppCompatBackgroundHelper r7 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r7.<init>(r6)
            r6.a = r7
            r7.d(r8, r9)
            h1 r7 = new h1
            r7.<init>(r6)
            r6.f1159a = r7
            android.content.Context r7 = r6.getContext()
            int[] r2 = defpackage.ps.CheckedTextView
            androidx.appcompat.widget.TintTypedArray r7 = androidx.appcompat.widget.TintTypedArray.m(r7, r8, r2, r9)
            android.content.Context r1 = r6.getContext()
            android.content.res.TypedArray r4 = r7.f1265a
            r0 = r6
            r3 = r8
            r5 = r9
            androidx.core.view.f.n(r0, r1, r2, r3, r4, r5)
            int r0 = defpackage.ps.CheckedTextView_checkMarkCompat     // Catch:{ all -> 0x00a8 }
            boolean r1 = r7.l(r0)     // Catch:{ all -> 0x00a8 }
            r2 = 0
            if (r1 == 0) goto L_0x005d
            int r0 = r7.i(r0, r2)     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x005d
            android.content.Context r1 = r6.getContext()     // Catch:{ NotFoundException -> 0x005d }
            android.graphics.drawable.Drawable r0 = defpackage.r1.w(r1, r0)     // Catch:{ NotFoundException -> 0x005d }
            r6.setCheckMarkDrawable((android.graphics.drawable.Drawable) r0)     // Catch:{ NotFoundException -> 0x005d }
            r0 = 1
            goto L_0x005e
        L_0x005d:
            r0 = r2
        L_0x005e:
            if (r0 != 0) goto L_0x0079
            int r0 = defpackage.ps.CheckedTextView_android_checkMark     // Catch:{ all -> 0x00a8 }
            boolean r1 = r7.l(r0)     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0079
            int r0 = r7.i(r0, r2)     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x0079
            android.content.Context r1 = r6.getContext()     // Catch:{ all -> 0x00a8 }
            android.graphics.drawable.Drawable r0 = defpackage.r1.w(r1, r0)     // Catch:{ all -> 0x00a8 }
            r6.setCheckMarkDrawable((android.graphics.drawable.Drawable) r0)     // Catch:{ all -> 0x00a8 }
        L_0x0079:
            int r0 = defpackage.ps.CheckedTextView_checkMarkTint     // Catch:{ all -> 0x00a8 }
            boolean r1 = r7.l(r0)     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x0088
            android.content.res.ColorStateList r0 = r7.b(r0)     // Catch:{ all -> 0x00a8 }
            r6.setCheckMarkTintList(r0)     // Catch:{ all -> 0x00a8 }
        L_0x0088:
            int r0 = defpackage.ps.CheckedTextView_checkMarkTintMode     // Catch:{ all -> 0x00a8 }
            boolean r1 = r7.l(r0)     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x009d
            r1 = -1
            int r0 = r7.h(r0, r1)     // Catch:{ all -> 0x00a8 }
            r1 = 0
            android.graphics.PorterDuff$Mode r0 = defpackage.w9.c(r0, r1)     // Catch:{ all -> 0x00a8 }
            r6.setCheckMarkTintMode(r0)     // Catch:{ all -> 0x00a8 }
        L_0x009d:
            r7.n()
            androidx.appcompat.widget.AppCompatEmojiTextHelper r7 = r6.getEmojiTextViewHelper()
            r7.c(r8, r9)
            return
        L_0x00a8:
            r8 = move-exception
            r7.n()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCheckedTextView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(r1.w(getContext(), i));
    }
}
