package defpackage;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import defpackage.C0282nk;
import defpackage.C0335t2;
import defpackage.C0357up;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: v2  reason: default package and case insensitive filesystem */
/* compiled from: BaseLayer */
public abstract class C0359v2 implements z9, C0335t2.a, C0368vh {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final Ej f3341a;

    /* renamed from: a  reason: collision with other field name */
    public C0093Gc f3342a;

    /* renamed from: a  reason: collision with other field name */
    public final HA f3343a;

    /* renamed from: a  reason: collision with other field name */
    public final Lh f3344a;

    /* renamed from: a  reason: collision with other field name */
    public final Sh f3345a;

    /* renamed from: a  reason: collision with other field name */
    public BlurMaskFilter f3346a;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f3347a = new Matrix();

    /* renamed from: a  reason: collision with other field name */
    public final Path f3348a = new Path();

    /* renamed from: a  reason: collision with other field name */
    public final RectF f3349a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3350a;

    /* renamed from: a  reason: collision with other field name */
    public List<C0359v2> f3351a;

    /* renamed from: a  reason: collision with other field name */
    public final C0344tk f3352a;

    /* renamed from: a  reason: collision with other field name */
    public C0359v2 f3353a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3354a;
    public final Lh b;

    /* renamed from: b  reason: collision with other field name */
    public final Matrix f3355b = new Matrix();

    /* renamed from: b  reason: collision with other field name */
    public final RectF f3356b;

    /* renamed from: b  reason: collision with other field name */
    public C0359v2 f3357b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3358b;
    public final Lh c;

    /* renamed from: c  reason: collision with other field name */
    public final Matrix f3359c;

    /* renamed from: c  reason: collision with other field name */
    public final RectF f3360c;
    public final Lh d;

    /* renamed from: d  reason: collision with other field name */
    public final RectF f3361d;
    public final Lh e;

    /* renamed from: e  reason: collision with other field name */
    public final RectF f3362e;
    public Lh f;

    public C0359v2(Ej ej, Sh sh) {
        boolean z = true;
        this.f3344a = new Lh(1);
        this.b = new Lh(PorterDuff.Mode.DST_IN, 0);
        this.c = new Lh(PorterDuff.Mode.DST_OUT, 0);
        Lh lh = new Lh(1);
        this.d = lh;
        this.e = new Lh(PorterDuff.Mode.CLEAR);
        this.f3349a = new RectF();
        this.f3356b = new RectF();
        this.f3360c = new RectF();
        this.f3361d = new RectF();
        this.f3362e = new RectF();
        this.f3359c = new Matrix();
        this.f3350a = new ArrayList();
        this.f3354a = true;
        this.a = 0.0f;
        this.f3341a = ej;
        this.f3345a = sh;
        C0709Uj.j(new StringBuilder(), sh.f527a, "#draw");
        if (sh.g == 3) {
            lh.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            lh.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        P0 p0 = sh.f525a;
        p0.getClass();
        HA ha = new HA(p0);
        this.f3343a = ha;
        ha.b(this);
        List<C0331sk> list = sh.f534b;
        if (list != null && !list.isEmpty()) {
            C0344tk tkVar = new C0344tk((List) list);
            this.f3352a = tkVar;
            for (C0335t2 a2 : (List) tkVar.a) {
                a2.a(this);
            }
            for (C0335t2 t2Var : (List) this.f3352a.b) {
                g(t2Var);
                t2Var.a(this);
            }
        }
        Sh sh2 = this.f3345a;
        if (!sh2.f535c.isEmpty()) {
            C0093Gc gc = new C0093Gc(sh2.f535c);
            this.f3342a = gc;
            gc.f3288a = true;
            gc.a(new C0347u2(this));
            z = ((Float) this.f3342a.f()).floatValue() != 1.0f ? false : z;
            if (z != this.f3354a) {
                this.f3354a = z;
                this.f3341a.invalidateSelf();
            }
            g(this.f3342a);
        } else if (true != this.f3354a) {
            this.f3354a = true;
            this.f3341a.invalidateSelf();
        }
    }

    public void a(RectF rectF, Matrix matrix, boolean z) {
        this.f3349a.set(0.0f, 0.0f, 0.0f, 0.0f);
        j();
        Matrix matrix2 = this.f3359c;
        matrix2.set(matrix);
        if (z) {
            List<C0359v2> list = this.f3351a;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    matrix2.preConcat(this.f3351a.get(size).f3343a.d());
                }
            } else {
                C0359v2 v2Var = this.f3357b;
                if (v2Var != null) {
                    matrix2.preConcat(v2Var.f3343a.d());
                }
            }
        }
        matrix2.preConcat(this.f3343a.d());
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x022c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.graphics.Canvas r20, android.graphics.Matrix r21, int r22) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            boolean r3 = r0.f3354a
            if (r3 == 0) goto L_0x03c1
            Sh r3 = r0.f3345a
            boolean r4 = r3.f530a
            if (r4 == 0) goto L_0x0012
            goto L_0x03c1
        L_0x0012:
            r19.j()
            android.graphics.Matrix r4 = r0.f3347a
            r4.reset()
            r4.set(r2)
            java.util.List<v2> r5 = r0.f3351a
            int r5 = r5.size()
            r6 = 1
            int r5 = r5 - r6
        L_0x0025:
            if (r5 < 0) goto L_0x003b
            java.util.List<v2> r7 = r0.f3351a
            java.lang.Object r7 = r7.get(r5)
            v2 r7 = (defpackage.C0359v2) r7
            HA r7 = r7.f3343a
            android.graphics.Matrix r7 = r7.d()
            r4.preConcat(r7)
            int r5 = r5 + -1
            goto L_0x0025
        L_0x003b:
            defpackage.C1354qp.G()
            HA r5 = r0.f3343a
            t2<java.lang.Integer, java.lang.Integer> r7 = r5.e
            if (r7 != 0) goto L_0x0047
            r7 = 100
            goto L_0x0051
        L_0x0047:
            java.lang.Object r7 = r7.f()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
        L_0x0051:
            r8 = r22
            float r8 = (float) r8
            r9 = 1132396544(0x437f0000, float:255.0)
            float r8 = r8 / r9
            float r7 = (float) r7
            float r8 = r8 * r7
            r7 = 1120403456(0x42c80000, float:100.0)
            float r8 = r8 / r7
            float r8 = r8 * r9
            int r7 = (int) r8
            v2 r8 = r0.f3353a
            r9 = 0
            if (r8 == 0) goto L_0x0065
            r8 = r6
            goto L_0x0066
        L_0x0065:
            r8 = r9
        L_0x0066:
            if (r8 != 0) goto L_0x0082
            boolean r8 = r19.o()
            if (r8 != 0) goto L_0x0082
            android.graphics.Matrix r2 = r5.d()
            r4.preConcat(r2)
            r0.l(r1, r4, r7)
            defpackage.C1354qp.G()
            defpackage.C1354qp.G()
            r19.p()
            return
        L_0x0082:
            android.graphics.RectF r8 = r0.f3349a
            r0.a(r8, r4, r9)
            v2 r10 = r0.f3353a
            if (r10 == 0) goto L_0x008d
            r10 = r6
            goto L_0x008e
        L_0x008d:
            r10 = r9
        L_0x008e:
            r11 = 3
            r12 = 0
            if (r10 != 0) goto L_0x0093
            goto L_0x00ab
        L_0x0093:
            int r3 = r3.g
            if (r3 != r11) goto L_0x0098
            goto L_0x00ab
        L_0x0098:
            android.graphics.RectF r3 = r0.f3361d
            r3.set(r12, r12, r12, r12)
            v2 r10 = r0.f3353a
            r10.a(r3, r2, r6)
            boolean r3 = r8.intersect(r3)
            if (r3 != 0) goto L_0x00ab
            r8.set(r12, r12, r12, r12)
        L_0x00ab:
            android.graphics.Matrix r3 = r5.d()
            r4.preConcat(r3)
            android.graphics.RectF r3 = r0.f3360c
            r3.set(r12, r12, r12, r12)
            boolean r5 = r19.o()
            android.graphics.Path r10 = r0.f3348a
            tk r13 = r0.f3352a
            r14 = 2
            if (r5 != 0) goto L_0x00c5
            r3 = r12
            goto L_0x014a
        L_0x00c5:
            java.lang.Object r5 = r13.c
            java.util.List r5 = (java.util.List) r5
            int r5 = r5.size()
            r15 = r9
        L_0x00ce:
            if (r15 >= r5) goto L_0x013e
            java.lang.Object r12 = r13.c
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r12 = r12.get(r15)
            sk r12 = (defpackage.C0331sk) r12
            java.lang.Object r9 = r13.a
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r9 = r9.get(r15)
            t2 r9 = (defpackage.C0335t2) r9
            java.lang.Object r9 = r9.f()
            android.graphics.Path r9 = (android.graphics.Path) r9
            if (r9 != 0) goto L_0x00ed
            goto L_0x0136
        L_0x00ed:
            r10.set(r9)
            r10.transform(r4)
            int r9 = r12.a
            int r9 = defpackage.xx.V(r9)
            if (r9 == 0) goto L_0x0102
            if (r9 == r6) goto L_0x0149
            if (r9 == r14) goto L_0x0102
            if (r9 == r11) goto L_0x0149
            goto L_0x0107
        L_0x0102:
            boolean r9 = r12.f3278a
            if (r9 == 0) goto L_0x0107
            goto L_0x0149
        L_0x0107:
            android.graphics.RectF r9 = r0.f3362e
            r12 = 0
            r10.computeBounds(r9, r12)
            if (r15 != 0) goto L_0x0113
            r3.set(r9)
            goto L_0x0136
        L_0x0113:
            float r12 = r3.left
            float r11 = r9.left
            float r11 = java.lang.Math.min(r12, r11)
            float r12 = r3.top
            float r14 = r9.top
            float r12 = java.lang.Math.min(r12, r14)
            float r14 = r3.right
            float r6 = r9.right
            float r6 = java.lang.Math.max(r14, r6)
            float r14 = r3.bottom
            float r9 = r9.bottom
            float r9 = java.lang.Math.max(r14, r9)
            r3.set(r11, r12, r6, r9)
        L_0x0136:
            int r15 = r15 + 1
            r6 = 1
            r9 = 0
            r11 = 3
            r12 = 0
            r14 = 2
            goto L_0x00ce
        L_0x013e:
            boolean r3 = r8.intersect(r3)
            if (r3 != 0) goto L_0x0149
            r3 = 0
            r8.set(r3, r3, r3, r3)
            goto L_0x014a
        L_0x0149:
            r3 = 0
        L_0x014a:
            android.graphics.RectF r5 = r0.f3356b
            int r6 = r20.getWidth()
            float r6 = (float) r6
            int r9 = r20.getHeight()
            float r9 = (float) r9
            r5.set(r3, r3, r6, r9)
            android.graphics.Matrix r6 = r0.f3355b
            r1.getMatrix(r6)
            boolean r9 = r6.isIdentity()
            if (r9 != 0) goto L_0x016a
            r6.invert(r6)
            r6.mapRect(r5)
        L_0x016a:
            boolean r5 = r8.intersect(r5)
            if (r5 != 0) goto L_0x0173
            r8.set(r3, r3, r3, r3)
        L_0x0173:
            defpackage.C1354qp.G()
            float r3 = r8.width()
            r5 = 1065353216(0x3f800000, float:1.0)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0385
            float r3 = r8.height()
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0385
            Lh r3 = r0.f3344a
            r5 = 255(0xff, float:3.57E-43)
            r3.setAlpha(r5)
            UB$a r6 = defpackage.UB.f567a
            r1.saveLayer(r8, r3)
            defpackage.C1354qp.G()
            defpackage.C1354qp.G()
            r19.k(r20)
            r0.l(r1, r4, r7)
            defpackage.C1354qp.G()
            boolean r6 = r19.o()
            if (r6 == 0) goto L_0x0354
            Lh r6 = r0.b
            r1.saveLayer(r8, r6)
            defpackage.C1354qp.G()
            int r9 = android.os.Build.VERSION.SDK_INT
            r11 = 28
            if (r9 >= r11) goto L_0x01ba
            r19.k(r20)
        L_0x01ba:
            defpackage.C1354qp.G()
            r9 = 0
        L_0x01be:
            java.lang.Object r11 = r13.c
            java.util.List r11 = (java.util.List) r11
            int r11 = r11.size()
            if (r9 >= r11) goto L_0x034b
            java.lang.Object r11 = r13.c
            r12 = r11
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r12 = r12.get(r9)
            sk r12 = (defpackage.C0331sk) r12
            java.lang.Object r14 = r13.a
            r15 = r14
            java.util.List r15 = (java.util.List) r15
            java.lang.Object r15 = r15.get(r9)
            t2 r15 = (defpackage.C0335t2) r15
            java.lang.Object r5 = r13.b
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r5 = r5.get(r9)
            t2 r5 = (defpackage.C0335t2) r5
            r16 = r13
            int r13 = r12.a
            int r13 = defpackage.xx.V(r13)
            Lh r2 = r0.c
            r17 = 1076048691(0x40233333, float:2.55)
            boolean r12 = r12.f3278a
            if (r13 == 0) goto L_0x02ea
            r18 = r7
            r7 = 1
            if (r13 == r7) goto L_0x0296
            r7 = 2
            if (r13 == r7) goto L_0x0235
            r7 = 3
            if (r13 == r7) goto L_0x0206
            goto L_0x0292
        L_0x0206:
            java.util.List r14 = (java.util.List) r14
            boolean r2 = r14.isEmpty()
            if (r2 == 0) goto L_0x0210
        L_0x020e:
            r2 = 0
            goto L_0x022a
        L_0x0210:
            r2 = 0
        L_0x0211:
            r5 = r11
            java.util.List r5 = (java.util.List) r5
            int r12 = r5.size()
            if (r2 >= r12) goto L_0x0229
            java.lang.Object r5 = r5.get(r2)
            sk r5 = (defpackage.C0331sk) r5
            int r5 = r5.a
            r12 = 4
            if (r5 == r12) goto L_0x0226
            goto L_0x020e
        L_0x0226:
            int r2 = r2 + 1
            goto L_0x0211
        L_0x0229:
            r2 = 1
        L_0x022a:
            if (r2 == 0) goto L_0x0292
            r2 = 255(0xff, float:3.57E-43)
            r3.setAlpha(r2)
            r1.drawRect(r8, r3)
            goto L_0x0292
        L_0x0235:
            r7 = 3
            if (r12 == 0) goto L_0x0267
            UB$a r11 = defpackage.UB.f567a
            r1.saveLayer(r8, r6)
            defpackage.C1354qp.G()
            r1.drawRect(r8, r3)
            java.lang.Object r5 = r5.f()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            float r5 = (float) r5
            float r5 = r5 * r17
            int r5 = (int) r5
            r2.setAlpha(r5)
            java.lang.Object r5 = r15.f()
            android.graphics.Path r5 = (android.graphics.Path) r5
            r10.set(r5)
            r10.transform(r4)
            r1.drawPath(r10, r2)
            r20.restore()
            goto L_0x0292
        L_0x0267:
            UB$a r2 = defpackage.UB.f567a
            r1.saveLayer(r8, r6)
            defpackage.C1354qp.G()
            java.lang.Object r2 = r15.f()
            android.graphics.Path r2 = (android.graphics.Path) r2
            r10.set(r2)
            r10.transform(r4)
            java.lang.Object r2 = r5.f()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            float r2 = (float) r2
            float r2 = r2 * r17
            int r2 = (int) r2
            r3.setAlpha(r2)
            r1.drawPath(r10, r3)
            r20.restore()
        L_0x0292:
            r11 = 255(0xff, float:3.57E-43)
            goto L_0x0340
        L_0x0296:
            r7 = 3
            if (r9 != 0) goto L_0x02a7
            r11 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.setColor(r11)
            r11 = 255(0xff, float:3.57E-43)
            r3.setAlpha(r11)
            r1.drawRect(r8, r3)
            goto L_0x02a9
        L_0x02a7:
            r11 = 255(0xff, float:3.57E-43)
        L_0x02a9:
            if (r12 == 0) goto L_0x02da
            UB$a r12 = defpackage.UB.f567a
            r1.saveLayer(r8, r2)
            defpackage.C1354qp.G()
            r1.drawRect(r8, r3)
            java.lang.Object r5 = r5.f()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            float r5 = (float) r5
            float r5 = r5 * r17
            int r5 = (int) r5
            r2.setAlpha(r5)
            java.lang.Object r5 = r15.f()
            android.graphics.Path r5 = (android.graphics.Path) r5
            r10.set(r5)
            r10.transform(r4)
            r1.drawPath(r10, r2)
            r20.restore()
            goto L_0x0340
        L_0x02da:
            java.lang.Object r5 = r15.f()
            android.graphics.Path r5 = (android.graphics.Path) r5
            r10.set(r5)
            r10.transform(r4)
            r1.drawPath(r10, r2)
            goto L_0x0340
        L_0x02ea:
            r18 = r7
            r7 = 3
            r11 = 255(0xff, float:3.57E-43)
            if (r12 == 0) goto L_0x0320
            UB$a r12 = defpackage.UB.f567a
            r1.saveLayer(r8, r3)
            defpackage.C1354qp.G()
            r1.drawRect(r8, r3)
            java.lang.Object r12 = r15.f()
            android.graphics.Path r12 = (android.graphics.Path) r12
            r10.set(r12)
            r10.transform(r4)
            java.lang.Object r5 = r5.f()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            float r5 = (float) r5
            float r5 = r5 * r17
            int r5 = (int) r5
            r3.setAlpha(r5)
            r1.drawPath(r10, r2)
            r20.restore()
            goto L_0x0340
        L_0x0320:
            java.lang.Object r2 = r15.f()
            android.graphics.Path r2 = (android.graphics.Path) r2
            r10.set(r2)
            r10.transform(r4)
            java.lang.Object r2 = r5.f()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            float r2 = (float) r2
            float r2 = r2 * r17
            int r2 = (int) r2
            r3.setAlpha(r2)
            r1.drawPath(r10, r3)
        L_0x0340:
            int r9 = r9 + 1
            r2 = r21
            r5 = r11
            r13 = r16
            r7 = r18
            goto L_0x01be
        L_0x034b:
            r18 = r7
            r20.restore()
            defpackage.C1354qp.G()
            goto L_0x0356
        L_0x0354:
            r18 = r7
        L_0x0356:
            v2 r2 = r0.f3353a
            if (r2 == 0) goto L_0x035c
            r6 = 1
            goto L_0x035d
        L_0x035c:
            r6 = 0
        L_0x035d:
            if (r6 == 0) goto L_0x037f
            Lh r2 = r0.d
            r1.saveLayer(r8, r2)
            defpackage.C1354qp.G()
            defpackage.C1354qp.G()
            r19.k(r20)
            v2 r2 = r0.f3353a
            r3 = r21
            r4 = r18
            r2.c(r1, r3, r4)
            r20.restore()
            defpackage.C1354qp.G()
            defpackage.C1354qp.G()
        L_0x037f:
            r20.restore()
            defpackage.C1354qp.G()
        L_0x0385:
            boolean r2 = r0.f3358b
            if (r2 == 0) goto L_0x03ba
            Lh r2 = r0.f
            if (r2 == 0) goto L_0x03ba
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE
            r2.setStyle(r3)
            Lh r2 = r0.f
            r3 = -251901(0xfffffffffffc2803, float:NaN)
            r2.setColor(r3)
            Lh r2 = r0.f
            r3 = 1082130432(0x40800000, float:4.0)
            r2.setStrokeWidth(r3)
            Lh r2 = r0.f
            r1.drawRect(r8, r2)
            Lh r2 = r0.f
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.FILL
            r2.setStyle(r3)
            Lh r2 = r0.f
            r3 = 1357638635(0x50ebebeb, float:3.1664855E10)
            r2.setColor(r3)
            Lh r2 = r0.f
            r1.drawRect(r8, r2)
        L_0x03ba:
            defpackage.C1354qp.G()
            r19.p()
            return
        L_0x03c1:
            defpackage.C1354qp.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0359v2.c(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }

    public void e(C0344tk tkVar, Object obj) {
        this.f3343a.c(tkVar, obj);
    }

    public final void f() {
        this.f3341a.invalidateSelf();
    }

    public final void g(C0335t2<?, ?> t2Var) {
        if (t2Var != null) {
            this.f3350a.add(t2Var);
        }
    }

    public final String getName() {
        return this.f3345a.f527a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        C0359v2 v2Var = this.f3353a;
        Sh sh = this.f3345a;
        if (v2Var != null) {
            String str = v2Var.f3345a.f527a;
            uhVar2.getClass();
            uh uhVar3 = new uh(uhVar2);
            uhVar3.f3321a.add(str);
            if (uhVar.a(i, this.f3353a.f3345a.f527a)) {
                C0359v2 v2Var2 = this.f3353a;
                uh uhVar4 = new uh(uhVar3);
                uhVar4.f3322a = v2Var2;
                arrayList.add(uhVar4);
            }
            if (uhVar.d(i, sh.f527a)) {
                this.f3353a.r(uhVar, uhVar.b(i, this.f3353a.f3345a.f527a) + i, arrayList, uhVar3);
            }
        }
        if (uhVar.c(i, sh.f527a)) {
            String str2 = sh.f527a;
            if (!"__container".equals(str2)) {
                uhVar2.getClass();
                uh uhVar5 = new uh(uhVar2);
                uhVar5.f3321a.add(str2);
                if (uhVar.a(i, str2)) {
                    uh uhVar6 = new uh(uhVar5);
                    uhVar6.f3322a = this;
                    arrayList.add(uhVar6);
                }
                uhVar2 = uhVar5;
            }
            if (uhVar.d(i, str2)) {
                r(uhVar, uhVar.b(i, str2) + i, arrayList, uhVar2);
            }
        }
    }

    public final void j() {
        if (this.f3351a == null) {
            if (this.f3357b == null) {
                this.f3351a = Collections.emptyList();
                return;
            }
            this.f3351a = new ArrayList();
            for (C0359v2 v2Var = this.f3357b; v2Var != null; v2Var = v2Var.f3357b) {
                this.f3351a.add(v2Var);
            }
        }
    }

    public final void k(Canvas canvas) {
        RectF rectF = this.f3349a;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.e);
        C1354qp.G();
    }

    public abstract void l(Canvas canvas, Matrix matrix, int i);

    public nh m() {
        return this.f3345a.f529a;
    }

    public B9 n() {
        return this.f3345a.f521a;
    }

    public final boolean o() {
        C0344tk tkVar = this.f3352a;
        if (tkVar == null || ((List) tkVar.a).isEmpty()) {
            return false;
        }
        return true;
    }

    public final void p() {
        C0357up upVar = this.f3341a.f145a.f2905a;
        String str = this.f3345a.f527a;
        if (upVar.f3327a) {
            HashMap hashMap = upVar.f3326a;
            Nk nk = (Nk) hashMap.get(str);
            if (nk == null) {
                nk = new Nk();
                hashMap.put(str, nk);
            }
            int i = nk.a + 1;
            nk.a = i;
            if (i == Integer.MAX_VALUE) {
                nk.a = i / 2;
            }
            if (str.equals("__container")) {
                Iterator it = upVar.a.iterator();
                while (true) {
                    C0282nk.a aVar = (C0282nk.a) it;
                    if (aVar.hasNext()) {
                        ((C0357up.a) aVar.next()).a();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void q(C0335t2<?, ?> t2Var) {
        this.f3350a.remove(t2Var);
    }

    public void s(boolean z) {
        if (z && this.f == null) {
            this.f = new Lh();
        }
        this.f3358b = z;
    }

    public void t(float f2) {
        HA ha = this.f3343a;
        C0335t2<Integer, Integer> t2Var = ha.e;
        if (t2Var != null) {
            t2Var.j(f2);
        }
        C0335t2<?, Float> t2Var2 = ha.f;
        if (t2Var2 != null) {
            t2Var2.j(f2);
        }
        C0335t2<?, Float> t2Var3 = ha.g;
        if (t2Var3 != null) {
            t2Var3.j(f2);
        }
        C0335t2<PointF, PointF> t2Var4 = ha.f246a;
        if (t2Var4 != null) {
            t2Var4.j(f2);
        }
        C0335t2<?, PointF> t2Var5 = ha.f249b;
        if (t2Var5 != null) {
            t2Var5.j(f2);
        }
        C0335t2<bv, bv> t2Var6 = ha.f250c;
        if (t2Var6 != null) {
            t2Var6.j(f2);
        }
        C0335t2<Float, Float> t2Var7 = ha.f251d;
        if (t2Var7 != null) {
            t2Var7.j(f2);
        }
        C0093Gc gc = ha.a;
        if (gc != null) {
            gc.j(f2);
        }
        C0093Gc gc2 = ha.b;
        if (gc2 != null) {
            gc2.j(f2);
        }
        C0344tk tkVar = this.f3352a;
        int i = 0;
        if (tkVar != null) {
            int i2 = 0;
            while (true) {
                Object obj = tkVar.a;
                if (i2 >= ((List) obj).size()) {
                    break;
                }
                ((C0335t2) ((List) obj).get(i2)).j(f2);
                i2++;
            }
        }
        C0093Gc gc3 = this.f3342a;
        if (gc3 != null) {
            gc3.j(f2);
        }
        C0359v2 v2Var = this.f3353a;
        if (v2Var != null) {
            v2Var.t(f2);
        }
        while (true) {
            ArrayList arrayList = this.f3350a;
            if (i < arrayList.size()) {
                ((C0335t2) arrayList.get(i)).j(f2);
                i++;
            } else {
                return;
            }
        }
    }

    public final void d(List<V6> list, List<V6> list2) {
    }

    public void r(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
    }
}
