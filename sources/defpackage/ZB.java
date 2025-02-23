package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import com.google.firebase.perf.util.Constants;
import defpackage.C0219hp;
import defpackage.v9;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: ZB  reason: default package */
/* compiled from: VectorDrawableCompat */
public final class ZB extends YB {
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with other field name */
    public g f722a;

    /* renamed from: a  reason: collision with other field name */
    public ColorFilter f723a;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f724a;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuffColorFilter f725a;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f726a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f727a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f728a;
    public boolean b;

    /* renamed from: ZB$a */
    /* compiled from: VectorDrawableCompat */
    public static class a extends e {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }
    }

    /* renamed from: ZB$d */
    /* compiled from: VectorDrawableCompat */
    public static abstract class d {
        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* renamed from: ZB$g */
    /* compiled from: VectorDrawableCompat */
    public static class g extends Drawable.ConstantState {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public f f752a;

        /* renamed from: a  reason: collision with other field name */
        public ColorStateList f753a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f754a;

        /* renamed from: a  reason: collision with other field name */
        public Paint f755a;

        /* renamed from: a  reason: collision with other field name */
        public PorterDuff.Mode f756a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f757a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public ColorStateList f758b;

        /* renamed from: b  reason: collision with other field name */
        public PorterDuff.Mode f759b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f760b;
        public boolean c;

        public g(g gVar) {
            this.f753a = null;
            this.f756a = ZB.a;
            if (gVar != null) {
                this.a = gVar.a;
                f fVar = new f(gVar.f752a);
                this.f752a = fVar;
                if (gVar.f752a.f750b != null) {
                    fVar.f750b = new Paint(gVar.f752a.f750b);
                }
                if (gVar.f752a.f743a != null) {
                    this.f752a.f743a = new Paint(gVar.f752a.f743a);
                }
                this.f753a = gVar.f753a;
                this.f756a = gVar.f756a;
                this.f757a = gVar.f757a;
            }
        }

        public int getChangingConfigurations() {
            return this.a;
        }

        public final Drawable newDrawable() {
            return new ZB(this);
        }

        public final Drawable newDrawable(Resources resources) {
            return new ZB(this);
        }

        public g() {
            this.f753a = null;
            this.f756a = ZB.a;
            this.f752a = new f();
        }
    }

    public ZB() {
        this.b = true;
        this.f728a = new float[9];
        this.f724a = new Matrix();
        this.f726a = new Rect();
        this.f722a = new g();
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public final boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable == null) {
            return false;
        }
        v9.a.b(drawable);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        if (r10 == false) goto L_0x00bd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void draw(android.graphics.Canvas r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            android.graphics.drawable.Drawable r2 = r0.a
            if (r2 == 0) goto L_0x000c
            r2.draw(r1)
            return
        L_0x000c:
            android.graphics.Rect r2 = r0.f726a
            r0.copyBounds(r2)
            int r3 = r2.width()
            if (r3 <= 0) goto L_0x017d
            int r3 = r2.height()
            if (r3 > 0) goto L_0x001f
            goto L_0x017d
        L_0x001f:
            android.graphics.ColorFilter r3 = r0.f723a
            if (r3 != 0) goto L_0x0025
            android.graphics.PorterDuffColorFilter r3 = r0.f725a
        L_0x0025:
            android.graphics.Matrix r4 = r0.f724a
            r1.getMatrix(r4)
            float[] r5 = r0.f728a
            r4.getValues(r5)
            r4 = 0
            r6 = r5[r4]
            float r6 = java.lang.Math.abs(r6)
            r7 = 4
            r7 = r5[r7]
            float r7 = java.lang.Math.abs(r7)
            r8 = 1
            r9 = r5[r8]
            float r9 = java.lang.Math.abs(r9)
            r10 = 3
            r5 = r5[r10]
            float r5 = java.lang.Math.abs(r5)
            r10 = 0
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            r11 = 1065353216(0x3f800000, float:1.0)
            if (r9 != 0) goto L_0x0056
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0058
        L_0x0056:
            r6 = r11
            r7 = r6
        L_0x0058:
            int r5 = r2.width()
            float r5 = (float) r5
            float r5 = r5 * r6
            int r5 = (int) r5
            int r6 = r2.height()
            float r6 = (float) r6
            float r6 = r6 * r7
            int r6 = (int) r6
            r7 = 2048(0x800, float:2.87E-42)
            int r5 = java.lang.Math.min(r7, r5)
            int r6 = java.lang.Math.min(r7, r6)
            if (r5 <= 0) goto L_0x017d
            if (r6 > 0) goto L_0x0076
            goto L_0x017d
        L_0x0076:
            int r7 = r19.save()
            int r9 = r2.left
            float r9 = (float) r9
            int r12 = r2.top
            float r12 = (float) r12
            r1.translate(r9, r12)
            boolean r9 = r18.isAutoMirrored()
            if (r9 == 0) goto L_0x0091
            int r9 = defpackage.v9.b.a(r18)
            if (r9 != r8) goto L_0x0091
            r9 = r8
            goto L_0x0092
        L_0x0091:
            r9 = r4
        L_0x0092:
            if (r9 == 0) goto L_0x00a1
            int r9 = r2.width()
            float r9 = (float) r9
            r1.translate(r9, r10)
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.scale(r9, r11)
        L_0x00a1:
            r2.offsetTo(r4, r4)
            ZB$g r9 = r0.f722a
            android.graphics.Bitmap r10 = r9.f754a
            if (r10 == 0) goto L_0x00bd
            int r10 = r10.getWidth()
            if (r5 != r10) goto L_0x00ba
            android.graphics.Bitmap r10 = r9.f754a
            int r10 = r10.getHeight()
            if (r6 != r10) goto L_0x00ba
            r10 = r8
            goto L_0x00bb
        L_0x00ba:
            r10 = r4
        L_0x00bb:
            if (r10 != 0) goto L_0x00c7
        L_0x00bd:
            android.graphics.Bitmap$Config r10 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r5, r6, r10)
            r9.f754a = r10
            r9.c = r8
        L_0x00c7:
            boolean r9 = r0.b
            if (r9 != 0) goto L_0x00e7
            ZB$g r9 = r0.f722a
            android.graphics.Bitmap r10 = r9.f754a
            r10.eraseColor(r4)
            android.graphics.Canvas r15 = new android.graphics.Canvas
            android.graphics.Bitmap r10 = r9.f754a
            r15.<init>(r10)
            ZB$f r12 = r9.f752a
            ZB$c r13 = r12.f741a
            android.graphics.Matrix r14 = defpackage.ZB.f.b
            r16 = r5
            r17 = r6
            r12.a(r13, r14, r15, r16, r17)
            goto L_0x0141
        L_0x00e7:
            ZB$g r9 = r0.f722a
            boolean r10 = r9.c
            if (r10 != 0) goto L_0x010b
            android.content.res.ColorStateList r10 = r9.f758b
            android.content.res.ColorStateList r11 = r9.f753a
            if (r10 != r11) goto L_0x010b
            android.graphics.PorterDuff$Mode r10 = r9.f759b
            android.graphics.PorterDuff$Mode r11 = r9.f756a
            if (r10 != r11) goto L_0x010b
            boolean r10 = r9.f760b
            boolean r11 = r9.f757a
            if (r10 != r11) goto L_0x010b
            int r10 = r9.b
            ZB$f r9 = r9.f752a
            int r9 = r9.getRootAlpha()
            if (r10 != r9) goto L_0x010b
            r9 = r8
            goto L_0x010c
        L_0x010b:
            r9 = r4
        L_0x010c:
            if (r9 != 0) goto L_0x0141
            ZB$g r9 = r0.f722a
            android.graphics.Bitmap r10 = r9.f754a
            r10.eraseColor(r4)
            android.graphics.Canvas r15 = new android.graphics.Canvas
            android.graphics.Bitmap r10 = r9.f754a
            r15.<init>(r10)
            ZB$f r12 = r9.f752a
            ZB$c r13 = r12.f741a
            android.graphics.Matrix r14 = defpackage.ZB.f.b
            r16 = r5
            r17 = r6
            r12.a(r13, r14, r15, r16, r17)
            ZB$g r5 = r0.f722a
            android.content.res.ColorStateList r6 = r5.f753a
            r5.f758b = r6
            android.graphics.PorterDuff$Mode r6 = r5.f756a
            r5.f759b = r6
            ZB$f r6 = r5.f752a
            int r6 = r6.getRootAlpha()
            r5.b = r6
            boolean r6 = r5.f757a
            r5.f760b = r6
            r5.c = r4
        L_0x0141:
            ZB$g r5 = r0.f722a
            ZB$f r6 = r5.f752a
            int r6 = r6.getRootAlpha()
            r9 = 255(0xff, float:3.57E-43)
            if (r6 >= r9) goto L_0x014e
            r4 = r8
        L_0x014e:
            r6 = 0
            if (r4 != 0) goto L_0x0155
            if (r3 != 0) goto L_0x0155
            r3 = r6
            goto L_0x0175
        L_0x0155:
            android.graphics.Paint r4 = r5.f755a
            if (r4 != 0) goto L_0x0163
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r5.f755a = r4
            r4.setFilterBitmap(r8)
        L_0x0163:
            android.graphics.Paint r4 = r5.f755a
            ZB$f r8 = r5.f752a
            int r8 = r8.getRootAlpha()
            r4.setAlpha(r8)
            android.graphics.Paint r4 = r5.f755a
            r4.setColorFilter(r3)
            android.graphics.Paint r3 = r5.f755a
        L_0x0175:
            android.graphics.Bitmap r4 = r5.f754a
            r1.drawBitmap(r4, r6, r2, r3)
            r1.restoreToCount(r7)
        L_0x017d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ZB.draw(android.graphics.Canvas):void");
    }

    public final int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f722a.f752a.getRootAlpha();
    }

    public final int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f722a.getChangingConfigurations();
    }

    public final ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return v9.a.c(drawable);
        }
        return this.f723a;
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            return new h(this.a.getConstantState());
        }
        this.f722a.a = getChangingConfigurations();
        return this.f722a;
    }

    public final int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f722a.f752a.f749b;
    }

    public final int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f722a.f752a.a;
    }

    public final int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public final void invalidateSelf() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public final boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f722a.f757a;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            g gVar = this.f722a;
            if (gVar != null) {
                f fVar = gVar.f752a;
                if (fVar.f747a == null) {
                    fVar.f747a = Boolean.valueOf(fVar.f741a.a());
                }
                if (fVar.f747a.booleanValue() || ((colorStateList = this.f722a.f753a) != null && colorStateList.isStateful())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f727a && super.mutate() == this) {
            this.f722a = new g(this.f722a);
            this.f727a = true;
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        g gVar = this.f722a;
        ColorStateList colorStateList = gVar.f753a;
        if (colorStateList == null || (mode = gVar.f756a) == null) {
            z = false;
        } else {
            this.f725a = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        f fVar = gVar.f752a;
        if (fVar.f747a == null) {
            fVar.f747a = Boolean.valueOf(fVar.f741a.a());
        }
        if (fVar.f747a.booleanValue()) {
            boolean b2 = gVar.f752a.f741a.b(iArr);
            gVar.c |= b2;
            if (b2) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    public final void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public final void setAlpha(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f722a.f752a.getRootAlpha() != i) {
            this.f722a.f752a.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f722a.f757a = z;
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f723a = colorFilter;
        invalidateSelf();
    }

    public final void setTint(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.a(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.a.h(drawable, colorStateList);
            return;
        }
        g gVar = this.f722a;
        if (gVar.f753a != colorStateList) {
            gVar.f753a = colorStateList;
            this.f725a = a(colorStateList, gVar.f756a);
            invalidateSelf();
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.a.i(drawable, mode);
            return;
        }
        g gVar = this.f722a;
        if (gVar.f756a != mode) {
            gVar.f756a = mode;
            this.f725a = a(gVar.f753a, mode);
            invalidateSelf();
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* renamed from: ZB$h */
    /* compiled from: VectorDrawableCompat */
    public static class h extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public h(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public final boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public final Drawable newDrawable() {
            ZB zb = new ZB();
            zb.a = (VectorDrawable) this.a.newDrawable();
            return zb;
        }

        public final Drawable newDrawable(Resources resources) {
            ZB zb = new ZB();
            zb.a = (VectorDrawable) this.a.newDrawable(resources);
            return zb;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            ZB zb = new ZB();
            zb.a = (VectorDrawable) this.a.newDrawable(resources, theme);
            return zb;
        }
    }

    /* renamed from: ZB$e */
    /* compiled from: VectorDrawableCompat */
    public static abstract class e extends d {
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f738a;

        /* renamed from: a  reason: collision with other field name */
        public C0219hp.a[] f739a = null;
        public final int b;

        public e() {
        }

        public C0219hp.a[] getPathData() {
            return this.f739a;
        }

        public String getPathName() {
            return this.f738a;
        }

        public void setPathData(C0219hp.a[] aVarArr) {
            if (!C0219hp.a(this.f739a, aVarArr)) {
                this.f739a = C0219hp.e(aVarArr);
                return;
            }
            C0219hp.a[] aVarArr2 = this.f739a;
            for (int i = 0; i < aVarArr.length; i++) {
                aVarArr2[i].a = aVarArr[i].a;
                int i2 = 0;
                while (true) {
                    float[] fArr = aVarArr[i].f3001a;
                    if (i2 >= fArr.length) {
                        break;
                    }
                    aVarArr2[i].f3001a[i2] = fArr[i2];
                    i2++;
                }
            }
        }

        public e(e eVar) {
            this.f738a = eVar.f738a;
            this.b = eVar.b;
            this.f739a = C0219hp.e(eVar.f739a);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:130:0x03c7  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void inflate(android.content.res.Resources r23, org.xmlpull.v1.XmlPullParser r24, android.util.AttributeSet r25, android.content.res.Resources.Theme r26) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            android.graphics.drawable.Drawable r5 = r0.a
            if (r5 == 0) goto L_0x0012
            defpackage.v9.a.d(r5, r1, r2, r3, r4)
            return
        L_0x0012:
            ZB$g r5 = r0.f722a
            ZB$f r6 = new ZB$f
            r6.<init>()
            r5.f752a = r6
            int[] r6 = defpackage.D0.a
            android.content.res.TypedArray r6 = defpackage.SA.f(r1, r4, r3, r6)
            ZB$g r7 = r0.f722a
            ZB$f r8 = r7.f752a
            java.lang.String r9 = "tintMode"
            r10 = 6
            r11 = -1
            int r9 = defpackage.SA.c(r6, r2, r9, r10, r11)
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SRC_IN
            r13 = 9
            r14 = 5
            r15 = 3
            if (r9 == r15) goto L_0x0049
            if (r9 == r14) goto L_0x004b
            if (r9 == r13) goto L_0x0046
            switch(r9) {
                case 14: goto L_0x0043;
                case 15: goto L_0x0040;
                case 16: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x004b
        L_0x003d:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.ADD
            goto L_0x004b
        L_0x0040:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SCREEN
            goto L_0x004b
        L_0x0043:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L_0x004b
        L_0x0046:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SRC_ATOP
            goto L_0x004b
        L_0x0049:
            android.graphics.PorterDuff$Mode r12 = android.graphics.PorterDuff.Mode.SRC_OVER
        L_0x004b:
            r7.f756a = r12
            java.lang.String r9 = "tint"
            boolean r9 = defpackage.SA.e(r2, r9)
            r12 = 0
            r10 = 1
            r13 = 2
            if (r9 == 0) goto L_0x009a
            android.util.TypedValue r9 = new android.util.TypedValue
            r9.<init>()
            r6.getValue(r10, r9)
            int r11 = r9.type
            if (r11 == r13) goto L_0x0086
            r13 = 28
            if (r11 < r13) goto L_0x0073
            r13 = 31
            if (r11 > r13) goto L_0x0073
            int r9 = r9.data
            android.content.res.ColorStateList r9 = android.content.res.ColorStateList.valueOf(r9)
            goto L_0x009b
        L_0x0073:
            android.content.res.Resources r9 = r6.getResources()
            int r11 = r6.getResourceId(r10, r12)
            java.lang.ThreadLocal<android.util.TypedValue> r13 = defpackage.C0416z5.a
            android.content.res.XmlResourceParser r11 = r9.getXml(r11)     // Catch:{ Exception -> 0x009a }
            android.content.res.ColorStateList r9 = defpackage.C0416z5.a(r9, r11, r4)     // Catch:{ Exception -> 0x009a }
            goto L_0x009b
        L_0x0086:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to resolve attribute at index 1: "
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009a:
            r9 = 0
        L_0x009b:
            if (r9 == 0) goto L_0x009f
            r7.f753a = r9
        L_0x009f:
            boolean r9 = r7.f757a
            java.lang.String r11 = "autoMirrored"
            boolean r11 = defpackage.SA.e(r2, r11)
            if (r11 != 0) goto L_0x00aa
            goto L_0x00ae
        L_0x00aa:
            boolean r9 = r6.getBoolean(r14, r9)
        L_0x00ae:
            r7.f757a = r9
            float r7 = r8.c
            java.lang.String r9 = "viewportWidth"
            r11 = 7
            float r7 = defpackage.SA.b(r6, r2, r9, r11, r7)
            r8.c = r7
            float r7 = r8.d
            java.lang.String r9 = "viewportHeight"
            r13 = 8
            float r7 = defpackage.SA.b(r6, r2, r9, r13, r7)
            r8.d = r7
            float r9 = r8.c
            r18 = 0
            int r9 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r9 <= 0) goto L_0x03c7
            int r7 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r7 <= 0) goto L_0x03ac
            float r7 = r8.a
            float r7 = r6.getDimension(r15, r7)
            r8.a = r7
            float r7 = r8.f749b
            r9 = 2
            float r7 = r6.getDimension(r9, r7)
            r8.f749b = r7
            float r9 = r8.a
            int r9 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r9 <= 0) goto L_0x0391
            int r7 = (r7 > r18 ? 1 : (r7 == r18 ? 0 : -1))
            if (r7 <= 0) goto L_0x0376
            float r7 = r8.getAlpha()
            java.lang.String r9 = "alpha"
            r14 = 4
            float r7 = defpackage.SA.b(r6, r2, r9, r14, r7)
            r8.setAlpha(r7)
            java.lang.String r7 = r6.getString(r12)
            if (r7 == 0) goto L_0x0109
            r8.f748a = r7
            androidx.collection.ArrayMap<java.lang.String, java.lang.Object> r9 = r8.f746a
            r9.put(r7, r8)
        L_0x0109:
            r6.recycle()
            int r6 = r22.getChangingConfigurations()
            r5.a = r6
            r5.c = r10
            ZB$g r6 = r0.f722a
            ZB$f r7 = r6.f752a
            java.util.ArrayDeque r8 = new java.util.ArrayDeque
            r8.<init>()
            ZB$c r9 = r7.f741a
            r8.push(r9)
            int r9 = r24.getEventType()
            int r19 = r24.getDepth()
            int r11 = r19 + 1
            r19 = r10
        L_0x012e:
            if (r9 == r10) goto L_0x0361
            int r14 = r24.getDepth()
            if (r14 >= r11) goto L_0x0138
            if (r9 == r15) goto L_0x0361
        L_0x0138:
            java.lang.String r14 = "group"
            r15 = 2
            if (r9 != r15) goto L_0x0338
            java.lang.String r9 = r24.getName()
            java.lang.Object r15 = r8.peek()
            ZB$c r15 = (defpackage.ZB.c) r15
            java.lang.String r13 = "path"
            boolean r13 = r13.equals(r9)
            java.lang.String r10 = "fillType"
            java.lang.String r12 = "pathData"
            r20 = r11
            androidx.collection.ArrayMap<java.lang.String, java.lang.Object> r11 = r7.f746a
            if (r13 == 0) goto L_0x0251
            ZB$b r9 = new ZB$b
            r9.<init>()
            int[] r13 = defpackage.D0.c
            android.content.res.TypedArray r13 = defpackage.SA.f(r1, r4, r3, r13)
            boolean r12 = defpackage.SA.e(r2, r12)
            if (r12 != 0) goto L_0x016c
            r21 = r7
            goto L_0x022c
        L_0x016c:
            r12 = 0
            java.lang.String r14 = r13.getString(r12)
            if (r14 == 0) goto L_0x0175
            r9.f738a = r14
        L_0x0175:
            r12 = 2
            java.lang.String r14 = r13.getString(r12)
            if (r14 == 0) goto L_0x0182
            hp$a[] r12 = defpackage.C0219hp.c(r14)
            r9.f739a = r12
        L_0x0182:
            java.lang.String r12 = "fillColor"
            r14 = 1
            W5 r12 = defpackage.SA.a(r13, r2, r4, r12, r14)
            r9.f732b = r12
            float r12 = r9.c
            java.lang.String r14 = "fillAlpha"
            r21 = r7
            r7 = 12
            float r7 = defpackage.SA.b(r13, r2, r14, r7, r12)
            r9.c = r7
            java.lang.String r7 = "strokeLineCap"
            r12 = 8
            r14 = -1
            int r7 = defpackage.SA.c(r13, r2, r7, r12, r14)
            android.graphics.Paint$Cap r14 = r9.f730a
            if (r7 == 0) goto L_0x01b3
            r12 = 1
            if (r7 == r12) goto L_0x01b0
            r12 = 2
            if (r7 == r12) goto L_0x01ad
            goto L_0x01b5
        L_0x01ad:
            android.graphics.Paint$Cap r14 = android.graphics.Paint.Cap.SQUARE
            goto L_0x01b5
        L_0x01b0:
            android.graphics.Paint$Cap r14 = android.graphics.Paint.Cap.ROUND
            goto L_0x01b5
        L_0x01b3:
            android.graphics.Paint$Cap r14 = android.graphics.Paint.Cap.BUTT
        L_0x01b5:
            r9.f730a = r14
            java.lang.String r7 = "strokeLineJoin"
            r12 = 9
            r14 = -1
            int r7 = defpackage.SA.c(r13, r2, r7, r12, r14)
            android.graphics.Paint$Join r12 = r9.f731a
            if (r7 == 0) goto L_0x01d1
            r14 = 1
            if (r7 == r14) goto L_0x01ce
            r14 = 2
            if (r7 == r14) goto L_0x01cb
            goto L_0x01d3
        L_0x01cb:
            android.graphics.Paint$Join r12 = android.graphics.Paint.Join.BEVEL
            goto L_0x01d3
        L_0x01ce:
            android.graphics.Paint$Join r12 = android.graphics.Paint.Join.ROUND
            goto L_0x01d3
        L_0x01d1:
            android.graphics.Paint$Join r12 = android.graphics.Paint.Join.MITER
        L_0x01d3:
            r9.f731a = r12
            float r7 = r9.g
            java.lang.String r12 = "strokeMiterLimit"
            r14 = 10
            float r7 = defpackage.SA.b(r13, r2, r12, r14, r7)
            r9.g = r7
            java.lang.String r7 = "strokeColor"
            r12 = 3
            W5 r7 = defpackage.SA.a(r13, r2, r4, r7, r12)
            r9.f729a = r7
            float r7 = r9.b
            java.lang.String r12 = "strokeAlpha"
            r14 = 11
            float r7 = defpackage.SA.b(r13, r2, r12, r14, r7)
            r9.b = r7
            float r7 = r9.a
            java.lang.String r12 = "strokeWidth"
            r14 = 4
            float r7 = defpackage.SA.b(r13, r2, r12, r14, r7)
            r9.a = r7
            float r7 = r9.e
            java.lang.String r12 = "trimPathEnd"
            r14 = 6
            float r7 = defpackage.SA.b(r13, r2, r12, r14, r7)
            r9.e = r7
            float r7 = r9.f
            java.lang.String r12 = "trimPathOffset"
            r14 = 7
            float r7 = defpackage.SA.b(r13, r2, r12, r14, r7)
            r9.f = r7
            float r7 = r9.d
            java.lang.String r12 = "trimPathStart"
            r14 = 5
            float r7 = defpackage.SA.b(r13, r2, r12, r14, r7)
            r9.d = r7
            int r7 = r9.a
            r12 = 13
            int r7 = defpackage.SA.c(r13, r2, r10, r12, r7)
            r9.a = r7
        L_0x022c:
            r13.recycle()
            java.util.ArrayList<ZB$d> r7 = r15.f736a
            r7.add(r9)
            java.lang.String r7 = r9.getPathName()
            if (r7 == 0) goto L_0x0241
            java.lang.String r7 = r9.getPathName()
            r11.put(r7, r9)
        L_0x0241:
            int r7 = r6.a
            int r9 = r9.b
            r7 = r7 | r9
            r6.a = r7
            r10 = 0
            r13 = 7
            r14 = 5
            r16 = -1
            r19 = 0
            goto L_0x0335
        L_0x0251:
            r21 = r7
            r13 = 9
            r16 = -1
            java.lang.String r7 = "clip-path"
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x02ac
            ZB$a r7 = new ZB$a
            r7.<init>()
            boolean r9 = defpackage.SA.e(r2, r12)
            if (r9 != 0) goto L_0x026b
            goto L_0x0291
        L_0x026b:
            int[] r9 = defpackage.D0.d
            android.content.res.TypedArray r9 = defpackage.SA.f(r1, r4, r3, r9)
            r12 = 0
            java.lang.String r14 = r9.getString(r12)
            if (r14 == 0) goto L_0x027a
            r7.f738a = r14
        L_0x027a:
            r14 = 1
            java.lang.String r17 = r9.getString(r14)
            if (r17 == 0) goto L_0x0287
            hp$a[] r14 = defpackage.C0219hp.c(r17)
            r7.f739a = r14
        L_0x0287:
            r14 = 2
            int r10 = defpackage.SA.c(r9, r2, r10, r14, r12)
            r7.a = r10
            r9.recycle()
        L_0x0291:
            java.util.ArrayList<ZB$d> r9 = r15.f736a
            r9.add(r7)
            java.lang.String r9 = r7.getPathName()
            if (r9 == 0) goto L_0x02a3
            java.lang.String r9 = r7.getPathName()
            r11.put(r9, r7)
        L_0x02a3:
            int r9 = r6.a
            int r7 = r7.b
            r7 = r7 | r9
            r6.a = r7
            goto L_0x0332
        L_0x02ac:
            boolean r7 = r14.equals(r9)
            if (r7 == 0) goto L_0x0332
            ZB$c r7 = new ZB$c
            r7.<init>()
            int[] r9 = defpackage.D0.b
            android.content.res.TypedArray r9 = defpackage.SA.f(r1, r4, r3, r9)
            float r10 = r7.a
            java.lang.String r12 = "rotation"
            r14 = 5
            float r10 = defpackage.SA.b(r9, r2, r12, r14, r10)
            r7.a = r10
            float r10 = r7.b
            r12 = 1
            float r10 = r9.getFloat(r12, r10)
            r7.b = r10
            float r10 = r7.c
            r12 = 2
            float r10 = r9.getFloat(r12, r10)
            r7.c = r10
            float r10 = r7.d
            java.lang.String r12 = "scaleX"
            r13 = 3
            float r10 = defpackage.SA.b(r9, r2, r12, r13, r10)
            r7.d = r10
            float r10 = r7.e
            java.lang.String r12 = "scaleY"
            r13 = 4
            float r10 = defpackage.SA.b(r9, r2, r12, r13, r10)
            r7.e = r10
            float r10 = r7.f
            java.lang.String r12 = "translateX"
            r13 = 6
            float r10 = defpackage.SA.b(r9, r2, r12, r13, r10)
            r7.f = r10
            float r10 = r7.g
            java.lang.String r12 = "translateY"
            r13 = 7
            float r10 = defpackage.SA.b(r9, r2, r12, r13, r10)
            r7.g = r10
            r10 = 0
            java.lang.String r12 = r9.getString(r10)
            if (r12 == 0) goto L_0x030f
            r7.f735a = r12
        L_0x030f:
            r7.c()
            r9.recycle()
            java.util.ArrayList<ZB$d> r9 = r15.f736a
            r9.add(r7)
            r8.push(r7)
            java.lang.String r9 = r7.getGroupName()
            if (r9 == 0) goto L_0x032a
            java.lang.String r9 = r7.getGroupName()
            r11.put(r9, r7)
        L_0x032a:
            int r9 = r6.a
            int r7 = r7.f733a
            r7 = r7 | r9
            r6.a = r7
            goto L_0x0335
        L_0x0332:
            r10 = 0
            r13 = 7
            r14 = 5
        L_0x0335:
            r7 = r14
            r11 = 3
            goto L_0x0351
        L_0x0338:
            r21 = r7
            r20 = r11
            r10 = r12
            r7 = 5
            r11 = 3
            r13 = 7
            r16 = -1
            if (r9 != r11) goto L_0x0351
            java.lang.String r9 = r24.getName()
            boolean r9 = r14.equals(r9)
            if (r9 == 0) goto L_0x0351
            r8.pop()
        L_0x0351:
            int r9 = r24.next()
            r12 = r10
            r15 = r11
            r11 = r20
            r7 = r21
            r10 = 1
            r13 = 8
            r14 = 4
            goto L_0x012e
        L_0x0361:
            if (r19 != 0) goto L_0x036e
            android.content.res.ColorStateList r1 = r5.f753a
            android.graphics.PorterDuff$Mode r2 = r5.f756a
            android.graphics.PorterDuffColorFilter r1 = r0.a(r1, r2)
            r0.f725a = r1
            return
        L_0x036e:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r2 = "no path defined"
            r1.<init>(r2)
            throw r1
        L_0x0376:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires height > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0391:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires width > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x03ac:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires viewportHeight > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x03c7:
            org.xmlpull.v1.XmlPullParserException r1 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.getPositionDescription()
            r2.append(r3)
            java.lang.String r3 = "<vector> tag requires viewportWidth > 0"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ZB.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    public ZB(g gVar) {
        this.b = true;
        this.f728a = new float[9];
        this.f724a = new Matrix();
        this.f726a = new Rect();
        this.f722a = gVar;
        this.f725a = a(gVar.f753a, gVar.f756a);
    }

    /* renamed from: ZB$b */
    /* compiled from: VectorDrawableCompat */
    public static class b extends e {
        public float a = 0.0f;

        /* renamed from: a  reason: collision with other field name */
        public W5 f729a;

        /* renamed from: a  reason: collision with other field name */
        public Paint.Cap f730a = Paint.Cap.BUTT;

        /* renamed from: a  reason: collision with other field name */
        public Paint.Join f731a = Paint.Join.MITER;
        public float b = 1.0f;

        /* renamed from: b  reason: collision with other field name */
        public W5 f732b;
        public float c = 1.0f;
        public float d = 0.0f;
        public float e = 1.0f;
        public float f = 0.0f;
        public float g = 4.0f;

        public b() {
        }

        public final boolean a() {
            if (this.f732b.b() || this.f729a.b()) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(int[] r7) {
            /*
                r6 = this;
                W5 r0 = r6.f732b
                boolean r1 = r0.b()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x001c
                android.content.res.ColorStateList r1 = r0.f631a
                int r4 = r1.getDefaultColor()
                int r1 = r1.getColorForState(r7, r4)
                int r4 = r0.a
                if (r1 == r4) goto L_0x001c
                r0.a = r1
                r0 = r2
                goto L_0x001d
            L_0x001c:
                r0 = r3
            L_0x001d:
                W5 r1 = r6.f729a
                boolean r4 = r1.b()
                if (r4 == 0) goto L_0x0036
                android.content.res.ColorStateList r4 = r1.f631a
                int r5 = r4.getDefaultColor()
                int r7 = r4.getColorForState(r7, r5)
                int r4 = r1.a
                if (r7 == r4) goto L_0x0036
                r1.a = r7
                goto L_0x0037
            L_0x0036:
                r2 = r3
            L_0x0037:
                r7 = r2 | r0
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ZB.b.b(int[]):boolean");
        }

        public float getFillAlpha() {
            return this.c;
        }

        public int getFillColor() {
            return this.f732b.a;
        }

        public float getStrokeAlpha() {
            return this.b;
        }

        public int getStrokeColor() {
            return this.f729a.a;
        }

        public float getStrokeWidth() {
            return this.a;
        }

        public float getTrimPathEnd() {
            return this.e;
        }

        public float getTrimPathOffset() {
            return this.f;
        }

        public float getTrimPathStart() {
            return this.d;
        }

        public void setFillAlpha(float f2) {
            this.c = f2;
        }

        public void setFillColor(int i) {
            this.f732b.a = i;
        }

        public void setStrokeAlpha(float f2) {
            this.b = f2;
        }

        public void setStrokeColor(int i) {
            this.f729a.a = i;
        }

        public void setStrokeWidth(float f2) {
            this.a = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.e = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.f = f2;
        }

        public void setTrimPathStart(float f2) {
            this.d = f2;
        }

        public b(b bVar) {
            super(bVar);
            this.f729a = bVar.f729a;
            this.a = bVar.a;
            this.b = bVar.b;
            this.f732b = bVar.f732b;
            this.a = bVar.a;
            this.c = bVar.c;
            this.d = bVar.d;
            this.e = bVar.e;
            this.f = bVar.f;
            this.f730a = bVar.f730a;
            this.f731a = bVar.f731a;
            this.g = bVar.g;
        }
    }

    /* renamed from: ZB$c */
    /* compiled from: VectorDrawableCompat */
    public static class c extends d {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public final int f733a;

        /* renamed from: a  reason: collision with other field name */
        public final Matrix f734a;

        /* renamed from: a  reason: collision with other field name */
        public String f735a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<d> f736a;
        public float b;

        /* renamed from: b  reason: collision with other field name */
        public final Matrix f737b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;

        public c() {
            this.f734a = new Matrix();
            this.f736a = new ArrayList<>();
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 1.0f;
            this.e = 1.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            this.f737b = new Matrix();
            this.f735a = null;
        }

        public final boolean a() {
            int i = 0;
            while (true) {
                ArrayList<d> arrayList = this.f736a;
                if (i >= arrayList.size()) {
                    return false;
                }
                if (arrayList.get(i).a()) {
                    return true;
                }
                i++;
            }
        }

        public final boolean b(int[] iArr) {
            int i = 0;
            boolean z = false;
            while (true) {
                ArrayList<d> arrayList = this.f736a;
                if (i >= arrayList.size()) {
                    return z;
                }
                z |= arrayList.get(i).b(iArr);
                i++;
            }
        }

        public final void c() {
            Matrix matrix = this.f737b;
            matrix.reset();
            matrix.postTranslate(-this.b, -this.c);
            matrix.postScale(this.d, this.e);
            matrix.postRotate(this.a, 0.0f, 0.0f);
            matrix.postTranslate(this.f + this.b, this.g + this.c);
        }

        public String getGroupName() {
            return this.f735a;
        }

        public Matrix getLocalMatrix() {
            return this.f737b;
        }

        public float getPivotX() {
            return this.b;
        }

        public float getPivotY() {
            return this.c;
        }

        public float getRotation() {
            return this.a;
        }

        public float getScaleX() {
            return this.d;
        }

        public float getScaleY() {
            return this.e;
        }

        public float getTranslateX() {
            return this.f;
        }

        public float getTranslateY() {
            return this.g;
        }

        public void setPivotX(float f2) {
            if (f2 != this.b) {
                this.b = f2;
                c();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.c) {
                this.c = f2;
                c();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.a) {
                this.a = f2;
                c();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.d) {
                this.d = f2;
                c();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.e) {
                this.e = f2;
                c();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f) {
                this.f = f2;
                c();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.g) {
                this.g = f2;
                c();
            }
        }

        public c(c cVar, ArrayMap<String, Object> arrayMap) {
            e eVar;
            this.f734a = new Matrix();
            this.f736a = new ArrayList<>();
            this.a = 0.0f;
            this.b = 0.0f;
            this.c = 0.0f;
            this.d = 1.0f;
            this.e = 1.0f;
            this.f = 0.0f;
            this.g = 0.0f;
            Matrix matrix = new Matrix();
            this.f737b = matrix;
            this.f735a = null;
            this.a = cVar.a;
            this.b = cVar.b;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.f = cVar.f;
            this.g = cVar.g;
            String str = cVar.f735a;
            this.f735a = str;
            this.f733a = cVar.f733a;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(cVar.f737b);
            ArrayList<d> arrayList = cVar.f736a;
            for (int i = 0; i < arrayList.size(); i++) {
                d dVar = arrayList.get(i);
                if (dVar instanceof c) {
                    this.f736a.add(new c((c) dVar, arrayMap));
                } else {
                    if (dVar instanceof b) {
                        eVar = new b((b) dVar);
                    } else if (dVar instanceof a) {
                        eVar = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f736a.add(eVar);
                    String str2 = eVar.f738a;
                    if (str2 != null) {
                        arrayMap.put(str2, eVar);
                    }
                }
            }
        }
    }

    /* renamed from: ZB$f */
    /* compiled from: VectorDrawableCompat */
    public static class f {
        public static final Matrix b = new Matrix();
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public int f740a;

        /* renamed from: a  reason: collision with other field name */
        public final c f741a;

        /* renamed from: a  reason: collision with other field name */
        public final Matrix f742a;

        /* renamed from: a  reason: collision with other field name */
        public Paint f743a;

        /* renamed from: a  reason: collision with other field name */
        public final Path f744a;

        /* renamed from: a  reason: collision with other field name */
        public PathMeasure f745a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayMap<String, Object> f746a;

        /* renamed from: a  reason: collision with other field name */
        public Boolean f747a;

        /* renamed from: a  reason: collision with other field name */
        public String f748a;

        /* renamed from: b  reason: collision with other field name */
        public float f749b;

        /* renamed from: b  reason: collision with other field name */
        public Paint f750b;

        /* renamed from: b  reason: collision with other field name */
        public final Path f751b;
        public float c;
        public float d;

        public f() {
            this.f742a = new Matrix();
            this.a = 0.0f;
            this.f749b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.f740a = Constants.MAX_HOST_LENGTH;
            this.f748a = null;
            this.f747a = null;
            this.f746a = new ArrayMap<>();
            this.f741a = new c();
            this.f744a = new Path();
            this.f751b = new Path();
        }

        public final void a(c cVar, Matrix matrix, Canvas canvas, int i, int i2) {
            int i3;
            float f;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            Path.FillType fillType;
            float f2;
            Path.FillType fillType2;
            c cVar2 = cVar;
            Canvas canvas2 = canvas;
            cVar2.f734a.set(matrix);
            Matrix matrix2 = cVar2.f734a;
            matrix2.preConcat(cVar2.f737b);
            canvas.save();
            char c2 = 0;
            int i4 = 0;
            while (true) {
                ArrayList<d> arrayList = cVar2.f736a;
                if (i4 < arrayList.size()) {
                    d dVar = arrayList.get(i4);
                    if (dVar instanceof c) {
                        a((c) dVar, matrix2, canvas, i, i2);
                    } else if (dVar instanceof e) {
                        e eVar = (e) dVar;
                        float f3 = ((float) i) / this.c;
                        float f4 = ((float) i2) / this.d;
                        float min = Math.min(f3, f4);
                        Matrix matrix3 = this.f742a;
                        matrix3.set(matrix2);
                        matrix3.postScale(f3, f4);
                        float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                        matrix2.mapVectors(fArr);
                        float f5 = min;
                        i3 = i4;
                        float hypot = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
                        float f6 = (fArr[0] * fArr[3]) - (fArr[1] * fArr[2]);
                        float max = Math.max((float) Math.hypot((double) fArr[c2], (double) fArr[1]), hypot);
                        if (max > 0.0f) {
                            f = Math.abs(f6) / max;
                        } else {
                            f = 0.0f;
                        }
                        if (f != 0.0f) {
                            Path path = this.f744a;
                            eVar.getClass();
                            path.reset();
                            C0219hp.a[] aVarArr = eVar.f739a;
                            if (aVarArr != null) {
                                C0219hp.a.b(aVarArr, path);
                            }
                            Path path2 = this.f751b;
                            path2.reset();
                            if (eVar instanceof a) {
                                if (eVar.a == 0) {
                                    fillType2 = Path.FillType.WINDING;
                                } else {
                                    fillType2 = Path.FillType.EVEN_ODD;
                                }
                                path2.setFillType(fillType2);
                                path2.addPath(path, matrix3);
                                canvas2.clipPath(path2);
                            } else {
                                b bVar = (b) eVar;
                                float f7 = bVar.d;
                                if (!(f7 == 0.0f && bVar.e == 1.0f)) {
                                    float f8 = bVar.f;
                                    float f9 = (f7 + f8) % 1.0f;
                                    float f10 = (bVar.e + f8) % 1.0f;
                                    if (this.f745a == null) {
                                        this.f745a = new PathMeasure();
                                    }
                                    this.f745a.setPath(path, false);
                                    float length = this.f745a.getLength();
                                    float f11 = f9 * length;
                                    float f12 = f10 * length;
                                    path.reset();
                                    if (f11 > f12) {
                                        this.f745a.getSegment(f11, length, path, true);
                                        f2 = 0.0f;
                                        this.f745a.getSegment(0.0f, f12, path, true);
                                    } else {
                                        f2 = 0.0f;
                                        this.f745a.getSegment(f11, f12, path, true);
                                    }
                                    path.rLineTo(f2, f2);
                                }
                                path2.addPath(path, matrix3);
                                W5 w5 = bVar.f732b;
                                if (w5.f632a != null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (z || w5.a != 0) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    if (this.f750b == null) {
                                        Paint paint = new Paint(1);
                                        this.f750b = paint;
                                        paint.setStyle(Paint.Style.FILL);
                                    }
                                    Paint paint2 = this.f750b;
                                    Shader shader = w5.f632a;
                                    if (shader != null) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (z6) {
                                        shader.setLocalMatrix(matrix3);
                                        paint2.setShader(shader);
                                        paint2.setAlpha(Math.round(bVar.c * 255.0f));
                                    } else {
                                        paint2.setShader((Shader) null);
                                        paint2.setAlpha(Constants.MAX_HOST_LENGTH);
                                        int i5 = w5.a;
                                        float f13 = bVar.c;
                                        PorterDuff.Mode mode = ZB.a;
                                        paint2.setColor((i5 & 16777215) | (((int) (((float) Color.alpha(i5)) * f13)) << 24));
                                    }
                                    paint2.setColorFilter((ColorFilter) null);
                                    if (bVar.a == 0) {
                                        fillType = Path.FillType.WINDING;
                                    } else {
                                        fillType = Path.FillType.EVEN_ODD;
                                    }
                                    path2.setFillType(fillType);
                                    canvas2.drawPath(path2, paint2);
                                }
                                W5 w52 = bVar.f729a;
                                if (w52.f632a != null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3 || w52.a != 0) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                if (z4) {
                                    if (this.f743a == null) {
                                        z5 = true;
                                        Paint paint3 = new Paint(1);
                                        this.f743a = paint3;
                                        paint3.setStyle(Paint.Style.STROKE);
                                    } else {
                                        z5 = true;
                                    }
                                    Paint paint4 = this.f743a;
                                    Paint.Join join = bVar.f731a;
                                    if (join != null) {
                                        paint4.setStrokeJoin(join);
                                    }
                                    Paint.Cap cap = bVar.f730a;
                                    if (cap != null) {
                                        paint4.setStrokeCap(cap);
                                    }
                                    paint4.setStrokeMiter(bVar.g);
                                    Shader shader2 = w52.f632a;
                                    if (shader2 == null) {
                                        z5 = false;
                                    }
                                    if (z5) {
                                        shader2.setLocalMatrix(matrix3);
                                        paint4.setShader(shader2);
                                        paint4.setAlpha(Math.round(bVar.b * 255.0f));
                                    } else {
                                        paint4.setShader((Shader) null);
                                        paint4.setAlpha(Constants.MAX_HOST_LENGTH);
                                        int i6 = w52.a;
                                        float f14 = bVar.b;
                                        PorterDuff.Mode mode2 = ZB.a;
                                        paint4.setColor((i6 & 16777215) | (((int) (((float) Color.alpha(i6)) * f14)) << 24));
                                    }
                                    paint4.setColorFilter((ColorFilter) null);
                                    paint4.setStrokeWidth(bVar.a * f * f5);
                                    canvas2.drawPath(path2, paint4);
                                }
                            }
                        }
                        i4 = i3 + 1;
                        c2 = 0;
                    }
                    int i7 = i;
                    int i8 = i2;
                    i3 = i4;
                    i4 = i3 + 1;
                    c2 = 0;
                } else {
                    canvas.restore();
                    return;
                }
            }
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f740a;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f740a = i;
        }

        public f(f fVar) {
            this.f742a = new Matrix();
            this.a = 0.0f;
            this.f749b = 0.0f;
            this.c = 0.0f;
            this.d = 0.0f;
            this.f740a = Constants.MAX_HOST_LENGTH;
            this.f748a = null;
            this.f747a = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.f746a = arrayMap;
            this.f741a = new c(fVar.f741a, arrayMap);
            this.f744a = new Path(fVar.f744a);
            this.f751b = new Path(fVar.f751b);
            this.a = fVar.a;
            this.f749b = fVar.f749b;
            this.c = fVar.c;
            this.d = fVar.d;
            this.f740a = fVar.f740a;
            this.f748a = fVar.f748a;
            String str = fVar.f748a;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f747a = fVar.f747a;
        }
    }
}
