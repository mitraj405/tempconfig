package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.view.f;
import defpackage.Et;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.WeakHashMap;

public final class AppCompatTextHelper {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Zz f1184a;

    /* renamed from: a  reason: collision with other field name */
    public Typeface f1185a;

    /* renamed from: a  reason: collision with other field name */
    public final TextView f1186a;

    /* renamed from: a  reason: collision with other field name */
    public final u1 f1187a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1188a;
    public int b = -1;

    /* renamed from: b  reason: collision with other field name */
    public Zz f1189b;
    public Zz c;
    public Zz d;
    public Zz e;
    public Zz f;
    public Zz g;

    public static class b {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    public static class c {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    public static class d {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        public static void c(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    public static class e {
        public static Typeface a(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.f1186a = textView;
        this.f1187a = new u1(textView);
    }

    public static Zz c(Context context, o1 o1Var, int i) {
        ColorStateList h;
        synchronized (o1Var) {
            h = o1Var.f3135a.h(context, i);
        }
        if (h == null) {
            return null;
        }
        Zz zz = new Zz();
        zz.b = true;
        zz.a = h;
        return zz;
    }

    public static void h(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        int i;
        int i2;
        boolean z;
        int i3;
        CharSequence charSequence;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i4 >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            text.getClass();
            if (i4 >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            int i5 = editorInfo.initialSelStart;
            int i6 = editorInfo.initialSelEnd;
            if (i5 > i6) {
                i = i6 + 0;
            } else {
                i = i5 + 0;
            }
            if (i5 > i6) {
                i2 = i5 - 0;
            } else {
                i2 = i6 + 0;
            }
            int length = text.length();
            if (i < 0 || i2 > length) {
                C0179ea.a(editorInfo, (CharSequence) null, 0, 0);
                return;
            }
            int i7 = editorInfo.inputType & 4095;
            if (i7 == 129 || i7 == 225 || i7 == 18) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                C0179ea.a(editorInfo, (CharSequence) null, 0, 0);
            } else if (length <= 2048) {
                C0179ea.a(editorInfo, text, i, i2);
            } else {
                int i8 = i2 - i;
                if (i8 > 1024) {
                    i3 = 0;
                } else {
                    i3 = i8;
                }
                int i9 = 2048 - i3;
                int min = Math.min(text.length() - i2, i9 - Math.min(i, (int) (((double) i9) * 0.8d)));
                int min2 = Math.min(i, i9 - min);
                int i10 = i - min2;
                if (Character.isLowSurrogate(text.charAt(i10))) {
                    i10++;
                    min2--;
                }
                if (Character.isHighSurrogate(text.charAt((i2 + min) - 1))) {
                    min--;
                }
                int i11 = min2 + i3 + min;
                if (i3 != i8) {
                    charSequence = TextUtils.concat(new CharSequence[]{text.subSequence(i10, i10 + min2), text.subSequence(i2, min + i2)});
                } else {
                    charSequence = text.subSequence(i10, i11 + i10);
                }
                int i12 = min2 + 0;
                C0179ea.a(editorInfo, charSequence, i12, i3 + i12);
            }
        }
    }

    public final void a(Drawable drawable, Zz zz) {
        if (drawable != null && zz != null) {
            o1.e(drawable, zz, this.f1186a.getDrawableState());
        }
    }

    public final void b() {
        Zz zz = this.f1184a;
        TextView textView = this.f1186a;
        if (!(zz == null && this.f1189b == null && this.c == null && this.d == null)) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f1184a);
            a(compoundDrawables[1], this.f1189b);
            a(compoundDrawables[2], this.c);
            a(compoundDrawables[3], this.d);
        }
        if (this.e != null || this.f != null) {
            Drawable[] a2 = b.a(textView);
            a(a2[0], this.e);
            a(a2[2], this.f);
        }
    }

    public final ColorStateList d() {
        Zz zz = this.g;
        if (zz != null) {
            return zz.a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        Zz zz = this.g;
        if (zz != null) {
            return zz.f786a;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(android.util.AttributeSet r21, int r22) {
        /*
            r20 = this;
            r0 = r20
            r7 = r21
            r8 = r22
            android.widget.TextView r9 = r0.f1186a
            android.content.Context r10 = r9.getContext()
            o1 r11 = defpackage.o1.a()
            int[] r3 = defpackage.ps.AppCompatTextHelper
            androidx.appcompat.widget.TintTypedArray r12 = androidx.appcompat.widget.TintTypedArray.m(r10, r7, r3, r8)
            android.content.Context r2 = r9.getContext()
            android.content.res.TypedArray r5 = r12.f1265a
            r1 = r9
            r4 = r21
            r6 = r22
            androidx.core.view.f.n(r1, r2, r3, r4, r5, r6)
            int r1 = defpackage.ps.AppCompatTextHelper_android_textAppearance
            r13 = -1
            int r1 = r12.i(r1, r13)
            int r2 = defpackage.ps.AppCompatTextHelper_android_drawableLeft
            boolean r3 = r12.l(r2)
            r14 = 0
            if (r3 == 0) goto L_0x003e
            int r2 = r12.i(r2, r14)
            Zz r2 = c(r10, r11, r2)
            r0.f1184a = r2
        L_0x003e:
            int r2 = defpackage.ps.AppCompatTextHelper_android_drawableTop
            boolean r3 = r12.l(r2)
            if (r3 == 0) goto L_0x0050
            int r2 = r12.i(r2, r14)
            Zz r2 = c(r10, r11, r2)
            r0.f1189b = r2
        L_0x0050:
            int r2 = defpackage.ps.AppCompatTextHelper_android_drawableRight
            boolean r3 = r12.l(r2)
            if (r3 == 0) goto L_0x0062
            int r2 = r12.i(r2, r14)
            Zz r2 = c(r10, r11, r2)
            r0.c = r2
        L_0x0062:
            int r2 = defpackage.ps.AppCompatTextHelper_android_drawableBottom
            boolean r3 = r12.l(r2)
            if (r3 == 0) goto L_0x0074
            int r2 = r12.i(r2, r14)
            Zz r2 = c(r10, r11, r2)
            r0.d = r2
        L_0x0074:
            int r2 = android.os.Build.VERSION.SDK_INT
            int r3 = defpackage.ps.AppCompatTextHelper_android_drawableStart
            boolean r4 = r12.l(r3)
            if (r4 == 0) goto L_0x0088
            int r3 = r12.i(r3, r14)
            Zz r3 = c(r10, r11, r3)
            r0.e = r3
        L_0x0088:
            int r3 = defpackage.ps.AppCompatTextHelper_android_drawableEnd
            boolean r4 = r12.l(r3)
            if (r4 == 0) goto L_0x009a
            int r3 = r12.i(r3, r14)
            Zz r3 = c(r10, r11, r3)
            r0.f = r3
        L_0x009a:
            r12.n()
            android.text.method.TransformationMethod r3 = r9.getTransformationMethod()
            boolean r3 = r3 instanceof android.text.method.PasswordTransformationMethod
            if (r1 == r13) goto L_0x00e5
            int[] r4 = defpackage.ps.TextAppearance
            androidx.appcompat.widget.TintTypedArray r5 = new androidx.appcompat.widget.TintTypedArray
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r1, r4)
            r5.<init>(r10, r1)
            if (r3 != 0) goto L_0x00c0
            int r1 = defpackage.ps.TextAppearance_textAllCaps
            boolean r4 = r5.l(r1)
            if (r4 == 0) goto L_0x00c0
            boolean r1 = r5.a(r1, r14)
            r4 = 1
            goto L_0x00c2
        L_0x00c0:
            r1 = r14
            r4 = r1
        L_0x00c2:
            r0.k(r10, r5)
            int r6 = defpackage.ps.TextAppearance_textLocale
            boolean r16 = r5.l(r6)
            if (r16 == 0) goto L_0x00d2
            java.lang.String r6 = r5.j(r6)
            goto L_0x00d3
        L_0x00d2:
            r6 = 0
        L_0x00d3:
            int r15 = defpackage.ps.TextAppearance_fontVariationSettings
            boolean r17 = r5.l(r15)
            if (r17 == 0) goto L_0x00e0
            java.lang.String r15 = r5.j(r15)
            goto L_0x00e1
        L_0x00e0:
            r15 = 0
        L_0x00e1:
            r5.n()
            goto L_0x00e9
        L_0x00e5:
            r1 = r14
            r4 = r1
            r6 = 0
            r15 = 0
        L_0x00e9:
            int[] r5 = defpackage.ps.TextAppearance
            androidx.appcompat.widget.TintTypedArray r12 = new androidx.appcompat.widget.TintTypedArray
            android.content.res.TypedArray r5 = r10.obtainStyledAttributes(r7, r5, r8, r14)
            r12.<init>(r10, r5)
            if (r3 != 0) goto L_0x0103
            int r5 = defpackage.ps.TextAppearance_textAllCaps
            boolean r18 = r12.l(r5)
            if (r18 == 0) goto L_0x0103
            boolean r1 = r12.a(r5, r14)
            r4 = 1
        L_0x0103:
            int r5 = defpackage.ps.TextAppearance_textLocale
            boolean r18 = r12.l(r5)
            if (r18 == 0) goto L_0x010f
            java.lang.String r6 = r12.j(r5)
        L_0x010f:
            int r5 = defpackage.ps.TextAppearance_fontVariationSettings
            boolean r18 = r12.l(r5)
            if (r18 == 0) goto L_0x011b
            java.lang.String r15 = r12.j(r5)
        L_0x011b:
            r5 = 28
            if (r2 < r5) goto L_0x0131
            int r2 = defpackage.ps.TextAppearance_android_textSize
            boolean r5 = r12.l(r2)
            if (r5 == 0) goto L_0x0131
            int r2 = r12.d(r2, r13)
            if (r2 != 0) goto L_0x0131
            r2 = 0
            r9.setTextSize(r14, r2)
        L_0x0131:
            r0.k(r10, r12)
            r12.n()
            if (r3 != 0) goto L_0x013e
            if (r4 == 0) goto L_0x013e
            r9.setAllCaps(r1)
        L_0x013e:
            android.graphics.Typeface r1 = r0.f1185a
            if (r1 == 0) goto L_0x014f
            int r2 = r0.b
            if (r2 != r13) goto L_0x014c
            int r2 = r0.a
            r9.setTypeface(r1, r2)
            goto L_0x014f
        L_0x014c:
            r9.setTypeface(r1)
        L_0x014f:
            if (r15 == 0) goto L_0x0154
            androidx.appcompat.widget.AppCompatTextHelper.d.d(r9, r15)
        L_0x0154:
            if (r6 == 0) goto L_0x015d
            android.os.LocaleList r1 = androidx.appcompat.widget.AppCompatTextHelper.c.a(r6)
            androidx.appcompat.widget.AppCompatTextHelper.c.b(r9, r1)
        L_0x015d:
            int[] r3 = defpackage.ps.AppCompatTextView
            u1 r12 = r0.f1187a
            android.content.Context r15 = r12.f3310a
            android.content.res.TypedArray r6 = r15.obtainStyledAttributes(r7, r3, r8, r14)
            android.widget.TextView r1 = r12.f3311a
            android.content.Context r2 = r1.getContext()
            r4 = r21
            r5 = r6
            r13 = r6
            r6 = r22
            androidx.core.view.f.n(r1, r2, r3, r4, r5, r6)
            int r1 = defpackage.ps.AppCompatTextView_autoSizeTextType
            boolean r2 = r13.hasValue(r1)
            if (r2 == 0) goto L_0x0184
            int r1 = r13.getInt(r1, r14)
            r12.f3309a = r1
        L_0x0184:
            int r1 = defpackage.ps.AppCompatTextView_autoSizeStepGranularity
            boolean r2 = r13.hasValue(r1)
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == 0) goto L_0x0193
            float r1 = r13.getDimension(r1, r3)
            goto L_0x0194
        L_0x0193:
            r1 = r3
        L_0x0194:
            int r2 = defpackage.ps.AppCompatTextView_autoSizeMinTextSize
            boolean r4 = r13.hasValue(r2)
            if (r4 == 0) goto L_0x01a1
            float r2 = r13.getDimension(r2, r3)
            goto L_0x01a2
        L_0x01a1:
            r2 = r3
        L_0x01a2:
            int r4 = defpackage.ps.AppCompatTextView_autoSizeMaxTextSize
            boolean r5 = r13.hasValue(r4)
            if (r5 == 0) goto L_0x01af
            float r4 = r13.getDimension(r4, r3)
            goto L_0x01b0
        L_0x01af:
            r4 = r3
        L_0x01b0:
            int r5 = defpackage.ps.AppCompatTextView_autoSizePresetSizes
            boolean r6 = r13.hasValue(r5)
            if (r6 == 0) goto L_0x01e8
            int r5 = r13.getResourceId(r5, r14)
            if (r5 <= 0) goto L_0x01e8
            android.content.res.Resources r6 = r13.getResources()
            android.content.res.TypedArray r5 = r6.obtainTypedArray(r5)
            int r6 = r5.length()
            int[] r8 = new int[r6]
            if (r6 <= 0) goto L_0x01e5
        L_0x01ce:
            if (r14 >= r6) goto L_0x01dc
            r3 = -1
            int r19 = r5.getDimensionPixelSize(r14, r3)
            r8[r14] = r19
            int r14 = r14 + 1
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x01ce
        L_0x01dc:
            int[] r3 = defpackage.u1.a(r8)
            r12.f3313a = r3
            r12.c()
        L_0x01e5:
            r5.recycle()
        L_0x01e8:
            r13.recycle()
            boolean r3 = r12.d()
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 2
            if (r3 == 0) goto L_0x0227
            int r3 = r12.f3309a
            r8 = 1
            if (r3 != r8) goto L_0x022a
            boolean r3 = r12.f3314b
            if (r3 != 0) goto L_0x0223
            android.content.res.Resources r3 = r15.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r13 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r13 != 0) goto L_0x0211
            r2 = 1094713344(0x41400000, float:12.0)
            float r2 = android.util.TypedValue.applyDimension(r6, r2, r3)
        L_0x0211:
            int r13 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r13 != 0) goto L_0x021b
            r4 = 1121976320(0x42e00000, float:112.0)
            float r4 = android.util.TypedValue.applyDimension(r6, r4, r3)
        L_0x021b:
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x0220
            r1 = r5
        L_0x0220:
            r12.e(r2, r4, r1)
        L_0x0223:
            r12.b()
            goto L_0x022a
        L_0x0227:
            r1 = 0
            r12.f3309a = r1
        L_0x022a:
            java.lang.reflect.Method r1 = defpackage.UC.a
            int r1 = r12.f3309a
            if (r1 == 0) goto L_0x025b
            int[] r1 = r12.f3313a
            int r2 = r1.length
            if (r2 <= 0) goto L_0x025b
            int r2 = androidx.appcompat.widget.AppCompatTextHelper.d.a(r9)
            float r2 = (float) r2
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0257
            float r1 = r12.b
            int r1 = java.lang.Math.round(r1)
            float r2 = r12.c
            int r2 = java.lang.Math.round(r2)
            float r3 = r12.a
            int r3 = java.lang.Math.round(r3)
            r4 = 0
            androidx.appcompat.widget.AppCompatTextHelper.d.b(r9, r1, r2, r3, r4)
            goto L_0x025b
        L_0x0257:
            r4 = 0
            androidx.appcompat.widget.AppCompatTextHelper.d.c(r9, r1, r4)
        L_0x025b:
            int[] r1 = defpackage.ps.AppCompatTextView
            androidx.appcompat.widget.TintTypedArray r2 = new androidx.appcompat.widget.TintTypedArray
            android.content.res.TypedArray r1 = r10.obtainStyledAttributes(r7, r1)
            r2.<init>(r10, r1)
            int r1 = defpackage.ps.AppCompatTextView_drawableLeftCompat
            r3 = -1
            int r1 = r2.i(r1, r3)
            if (r1 == r3) goto L_0x0274
            android.graphics.drawable.Drawable r1 = r11.b(r10, r1)
            goto L_0x0275
        L_0x0274:
            r1 = 0
        L_0x0275:
            int r4 = defpackage.ps.AppCompatTextView_drawableTopCompat
            int r4 = r2.i(r4, r3)
            if (r4 == r3) goto L_0x0282
            android.graphics.drawable.Drawable r4 = r11.b(r10, r4)
            goto L_0x0283
        L_0x0282:
            r4 = 0
        L_0x0283:
            int r7 = defpackage.ps.AppCompatTextView_drawableRightCompat
            int r7 = r2.i(r7, r3)
            if (r7 == r3) goto L_0x0290
            android.graphics.drawable.Drawable r7 = r11.b(r10, r7)
            goto L_0x0291
        L_0x0290:
            r7 = 0
        L_0x0291:
            int r8 = defpackage.ps.AppCompatTextView_drawableBottomCompat
            int r8 = r2.i(r8, r3)
            if (r8 == r3) goto L_0x029e
            android.graphics.drawable.Drawable r8 = r11.b(r10, r8)
            goto L_0x029f
        L_0x029e:
            r8 = 0
        L_0x029f:
            int r12 = defpackage.ps.AppCompatTextView_drawableStartCompat
            int r12 = r2.i(r12, r3)
            if (r12 == r3) goto L_0x02ac
            android.graphics.drawable.Drawable r12 = r11.b(r10, r12)
            goto L_0x02ad
        L_0x02ac:
            r12 = 0
        L_0x02ad:
            int r13 = defpackage.ps.AppCompatTextView_drawableEndCompat
            int r13 = r2.i(r13, r3)
            if (r13 == r3) goto L_0x02ba
            android.graphics.drawable.Drawable r3 = r11.b(r10, r13)
            goto L_0x02bb
        L_0x02ba:
            r3 = 0
        L_0x02bb:
            r10 = 3
            if (r12 != 0) goto L_0x0305
            if (r3 == 0) goto L_0x02c1
            goto L_0x0305
        L_0x02c1:
            if (r1 != 0) goto L_0x02c9
            if (r4 != 0) goto L_0x02c9
            if (r7 != 0) goto L_0x02c9
            if (r8 == 0) goto L_0x0322
        L_0x02c9:
            android.graphics.drawable.Drawable[] r3 = androidx.appcompat.widget.AppCompatTextHelper.b.a(r9)
            r11 = 0
            r12 = r3[r11]
            if (r12 != 0) goto L_0x02f4
            r13 = r3[r6]
            if (r13 == 0) goto L_0x02d7
            goto L_0x02f4
        L_0x02d7:
            android.graphics.drawable.Drawable[] r3 = r9.getCompoundDrawables()
            if (r1 == 0) goto L_0x02de
            goto L_0x02e0
        L_0x02de:
            r1 = r3[r11]
        L_0x02e0:
            if (r4 == 0) goto L_0x02e3
            goto L_0x02e6
        L_0x02e3:
            r4 = 1
            r4 = r3[r4]
        L_0x02e6:
            if (r7 == 0) goto L_0x02e9
            goto L_0x02eb
        L_0x02e9:
            r7 = r3[r6]
        L_0x02eb:
            if (r8 == 0) goto L_0x02ee
            goto L_0x02f0
        L_0x02ee:
            r8 = r3[r10]
        L_0x02f0:
            r9.setCompoundDrawablesWithIntrinsicBounds(r1, r4, r7, r8)
            goto L_0x0322
        L_0x02f4:
            if (r4 == 0) goto L_0x02f7
            goto L_0x02fa
        L_0x02f7:
            r1 = 1
            r4 = r3[r1]
        L_0x02fa:
            r1 = r3[r6]
            if (r8 == 0) goto L_0x02ff
            goto L_0x0301
        L_0x02ff:
            r8 = r3[r10]
        L_0x0301:
            androidx.appcompat.widget.AppCompatTextHelper.b.b(r9, r12, r4, r1, r8)
            goto L_0x0322
        L_0x0305:
            android.graphics.drawable.Drawable[] r1 = androidx.appcompat.widget.AppCompatTextHelper.b.a(r9)
            if (r12 == 0) goto L_0x030c
            goto L_0x030f
        L_0x030c:
            r7 = 0
            r12 = r1[r7]
        L_0x030f:
            if (r4 == 0) goto L_0x0312
            goto L_0x0315
        L_0x0312:
            r4 = 1
            r4 = r1[r4]
        L_0x0315:
            if (r3 == 0) goto L_0x0318
            goto L_0x031a
        L_0x0318:
            r3 = r1[r6]
        L_0x031a:
            if (r8 == 0) goto L_0x031d
            goto L_0x031f
        L_0x031d:
            r8 = r1[r10]
        L_0x031f:
            androidx.appcompat.widget.AppCompatTextHelper.b.b(r9, r12, r4, r3, r8)
        L_0x0322:
            int r1 = defpackage.ps.AppCompatTextView_drawableTint
            boolean r3 = r2.l(r1)
            if (r3 == 0) goto L_0x0331
            android.content.res.ColorStateList r1 = r2.b(r1)
            defpackage.Nz.a.f(r9, r1)
        L_0x0331:
            int r1 = defpackage.ps.AppCompatTextView_drawableTintMode
            boolean r3 = r2.l(r1)
            if (r3 == 0) goto L_0x0347
            r3 = -1
            int r1 = r2.h(r1, r3)
            r4 = 0
            android.graphics.PorterDuff$Mode r1 = defpackage.w9.c(r1, r4)
            defpackage.Nz.a.g(r9, r1)
            goto L_0x0348
        L_0x0347:
            r3 = -1
        L_0x0348:
            int r1 = defpackage.ps.AppCompatTextView_firstBaselineToTopHeight
            int r1 = r2.d(r1, r3)
            int r4 = defpackage.ps.AppCompatTextView_lastBaselineToBottomHeight
            int r4 = r2.d(r4, r3)
            int r6 = defpackage.ps.AppCompatTextView_lineHeight
            int r6 = r2.d(r6, r3)
            r2.n()
            if (r1 == r3) goto L_0x0362
            defpackage.Nz.b(r9, r1)
        L_0x0362:
            if (r4 == r3) goto L_0x0367
            defpackage.Nz.c(r9, r4)
        L_0x0367:
            if (r6 == r3) goto L_0x037c
            defpackage.C1354qp.r(r6)
            android.text.TextPaint r1 = r9.getPaint()
            r2 = 0
            int r1 = r1.getFontMetricsInt(r2)
            if (r6 == r1) goto L_0x037c
            int r6 = r6 - r1
            float r1 = (float) r6
            r9.setLineSpacing(r1, r5)
        L_0x037c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatTextHelper.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i) {
        String j;
        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(i, ps.TextAppearance));
        int i2 = ps.TextAppearance_textAllCaps;
        boolean l = tintTypedArray.l(i2);
        TextView textView = this.f1186a;
        if (l) {
            textView.setAllCaps(tintTypedArray.a(i2, false));
        }
        int i3 = ps.TextAppearance_android_textSize;
        if (tintTypedArray.l(i3) && tintTypedArray.d(i3, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        k(context, tintTypedArray);
        int i4 = ps.TextAppearance_fontVariationSettings;
        if (tintTypedArray.l(i4) && (j = tintTypedArray.j(i4)) != null) {
            d.d(textView, j);
        }
        tintTypedArray.n();
        Typeface typeface = this.f1185a;
        if (typeface != null) {
            textView.setTypeface(typeface, this.a);
        }
    }

    public final void i(ColorStateList colorStateList) {
        boolean z;
        if (this.g == null) {
            this.g = new Zz();
        }
        Zz zz = this.g;
        zz.a = colorStateList;
        if (colorStateList != null) {
            z = true;
        } else {
            z = false;
        }
        zz.b = z;
        this.f1184a = zz;
        this.f1189b = zz;
        this.c = zz;
        this.d = zz;
        this.e = zz;
        this.f = zz;
    }

    public final void j(PorterDuff.Mode mode) {
        boolean z;
        if (this.g == null) {
            this.g = new Zz();
        }
        Zz zz = this.g;
        zz.f786a = mode;
        if (mode != null) {
            z = true;
        } else {
            z = false;
        }
        zz.f787a = z;
        this.f1184a = zz;
        this.f1189b = zz;
        this.c = zz;
        this.d = zz;
        this.e = zz;
        this.f = zz;
    }

    public final void k(Context context, TintTypedArray tintTypedArray) {
        String j;
        boolean z;
        boolean z2;
        this.a = tintTypedArray.h(ps.TextAppearance_android_textStyle, this.a);
        int i = Build.VERSION.SDK_INT;
        boolean z3 = false;
        if (i >= 28) {
            int h = tintTypedArray.h(ps.TextAppearance_android_textFontWeight, -1);
            this.b = h;
            if (h != -1) {
                this.a = (this.a & 2) | 0;
            }
        }
        int i2 = ps.TextAppearance_android_fontFamily;
        if (tintTypedArray.l(i2) || tintTypedArray.l(ps.TextAppearance_fontFamily)) {
            this.f1185a = null;
            int i3 = ps.TextAppearance_fontFamily;
            if (tintTypedArray.l(i3)) {
                i2 = i3;
            }
            int i4 = this.b;
            int i5 = this.a;
            if (!context.isRestricted()) {
                try {
                    Typeface g2 = tintTypedArray.g(i2, this.a, new a(i4, i5, new WeakReference(this.f1186a)));
                    if (g2 != null) {
                        if (i < 28 || this.b == -1) {
                            this.f1185a = g2;
                        } else {
                            Typeface create = Typeface.create(g2, 0);
                            int i6 = this.b;
                            if ((this.a & 2) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            this.f1185a = e.a(create, i6, z2);
                        }
                    }
                    if (this.f1185a == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.f1188a = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1185a == null && (j = tintTypedArray.j(i2)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.b == -1) {
                    this.f1185a = Typeface.create(j, this.a);
                    return;
                }
                Typeface create2 = Typeface.create(j, 0);
                int i7 = this.b;
                if ((this.a & 2) != 0) {
                    z3 = true;
                }
                this.f1185a = e.a(create2, i7, z3);
                return;
            }
            return;
        }
        int i8 = ps.TextAppearance_android_typeface;
        if (tintTypedArray.l(i8)) {
            this.f1188a = false;
            int h2 = tintTypedArray.h(i8, 1);
            if (h2 == 1) {
                this.f1185a = Typeface.SANS_SERIF;
            } else if (h2 == 2) {
                this.f1185a = Typeface.SERIF;
            } else if (h2 == 3) {
                this.f1185a = Typeface.MONOSPACE;
            }
        }
    }

    public class a extends Et.e {
        public final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ WeakReference f1191a;
        public final /* synthetic */ int b;

        public a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.f1191a = weakReference;
        }

        public final void onFontRetrieved(Typeface typeface) {
            int i;
            boolean z;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                if ((this.b & 2) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                typeface = e.a(typeface, i, z);
            }
            AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
            if (appCompatTextHelper.f1188a) {
                appCompatTextHelper.f1185a = typeface;
                TextView textView = (TextView) this.f1191a.get();
                if (textView != null) {
                    WeakHashMap<View, GC> weakHashMap = f.f1839a;
                    if (textView.isAttachedToWindow()) {
                        textView.post(new t1(textView, typeface, appCompatTextHelper.a));
                    } else {
                        textView.setTypeface(typeface, appCompatTextHelper.a);
                    }
                }
            }
        }

        public final void onFontRetrievalFailed(int i) {
        }
    }
}
