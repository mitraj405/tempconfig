package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.collection.LongSparseArray;
import java.util.HashMap;

/* renamed from: Mz  reason: default package */
/* compiled from: TextLayer */
public final class Mz extends C0359v2 {
    public final Ch a;

    /* renamed from: a  reason: collision with other field name */
    public final Lz f412a;

    /* renamed from: a  reason: collision with other field name */
    public final a f413a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f414a = new b();

    /* renamed from: a  reason: collision with other field name */
    public WB f415a;

    /* renamed from: a  reason: collision with other field name */
    public final LongSparseArray<String> f416a = new LongSparseArray<>();

    /* renamed from: a  reason: collision with other field name */
    public final C0181ej f417a;

    /* renamed from: a  reason: collision with other field name */
    public final StringBuilder f418a = new StringBuilder(2);

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f419a = new HashMap();
    public final Ch b;

    /* renamed from: b  reason: collision with other field name */
    public final Ej f420b;

    /* renamed from: b  reason: collision with other field name */
    public final C0093Gc f421b;

    /* renamed from: b  reason: collision with other field name */
    public WB f422b;
    public final C0093Gc c;

    /* renamed from: c  reason: collision with other field name */
    public WB f423c;
    public WB d;

    /* renamed from: d  reason: collision with other field name */
    public final Matrix f424d = new Matrix();
    public WB e;
    public WB f;

    /* renamed from: f  reason: collision with other field name */
    public final RectF f425f = new RectF();

    /* renamed from: Mz$a */
    /* compiled from: TextLayer */
    public class a extends Paint {
        public a() {
            super(1);
            setStyle(Paint.Style.FILL);
        }
    }

    /* renamed from: Mz$b */
    /* compiled from: TextLayer */
    public class b extends Paint {
        public b() {
            super(1);
            setStyle(Paint.Style.STROKE);
        }
    }

    public Mz(Ej ej, Sh sh) {
        super(ej, sh);
        H0 h0;
        H0 h02;
        G0 g0;
        G0 g02;
        this.f420b = ej;
        this.f417a = sh.f526a;
        Lz lz = new Lz(sh.f523a.a);
        this.f412a = lz;
        lz.a(this);
        g(lz);
        N0 n0 = sh.f524a;
        if (!(n0 == null || (g02 = n0.a) == null)) {
            C0335t2 b2 = g02.b();
            this.a = (Ch) b2;
            b2.a(this);
            g(b2);
        }
        if (!(n0 == null || (g0 = n0.b) == null)) {
            C0335t2 b3 = g0.b();
            this.b = (Ch) b3;
            b3.a(this);
            g(b3);
        }
        if (!(n0 == null || (h02 = n0.f427a) == null)) {
            C0335t2<Float, Float> b4 = h02.b();
            this.f421b = (C0093Gc) b4;
            b4.a(this);
            g(b4);
        }
        if (n0 != null && (h0 = n0.f428b) != null) {
            C0335t2<Float, Float> b5 = h0.b();
            this.c = (C0093Gc) b5;
            b5.a(this);
            g(b5);
        }
    }

    public static void u(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
            }
        }
    }

    public static void v(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() != 0) {
            if (paint.getStyle() != Paint.Style.STROKE || paint.getStrokeWidth() != 0.0f) {
                canvas.drawPath(path, paint);
            }
        }
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        super.a(rectF, matrix, z);
        C0181ej ejVar = this.f417a;
        rectF.set(0.0f, 0.0f, (float) ejVar.f2899a.width(), (float) ejVar.f2899a.height());
    }

    public final void e(C0344tk tkVar, Object obj) {
        super.e(tkVar, obj);
        if (obj == Kj.f356a) {
            WB wb = this.f415a;
            if (wb != null) {
                q(wb);
            }
            if (tkVar == null) {
                this.f415a = null;
                return;
            }
            WB wb2 = new WB(tkVar, null);
            this.f415a = wb2;
            wb2.a(this);
            g(this.f415a);
        } else if (obj == Kj.f360b) {
            WB wb3 = this.f422b;
            if (wb3 != null) {
                q(wb3);
            }
            if (tkVar == null) {
                this.f422b = null;
                return;
            }
            WB wb4 = new WB(tkVar, null);
            this.f422b = wb4;
            wb4.a(this);
            g(this.f422b);
        } else if (obj == Kj.h) {
            WB wb5 = this.f423c;
            if (wb5 != null) {
                q(wb5);
            }
            if (tkVar == null) {
                this.f423c = null;
                return;
            }
            WB wb6 = new WB(tkVar, null);
            this.f423c = wb6;
            wb6.a(this);
            g(this.f423c);
        } else if (obj == Kj.i) {
            WB wb7 = this.d;
            if (wb7 != null) {
                q(wb7);
            }
            if (tkVar == null) {
                this.d = null;
                return;
            }
            WB wb8 = new WB(tkVar, null);
            this.d = wb8;
            wb8.a(this);
            g(this.d);
        } else if (obj == Kj.u) {
            WB wb9 = this.e;
            if (wb9 != null) {
                q(wb9);
            }
            if (tkVar == null) {
                this.e = null;
                return;
            }
            WB wb10 = new WB(tkVar, null);
            this.e = wb10;
            wb10.a(this);
            g(this.e);
        } else if (obj == Kj.f353a) {
            WB wb11 = this.f;
            if (wb11 != null) {
                q(wb11);
            }
            if (tkVar == null) {
                this.f = null;
                return;
            }
            WB wb12 = new WB(tkVar, null);
            this.f = wb12;
            wb12.a(this);
            g(this.f);
        } else if (obj == Kj.f357a) {
            Lz lz = this.f412a;
            lz.getClass();
            lz.k(new Kz(new Fj(), tkVar, new q9()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x040c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(android.graphics.Canvas r30, android.graphics.Matrix r31, int r32) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r30.save()
            Ej r2 = r0.f420b
            ej r3 = r2.f145a
            androidx.collection.SparseArrayCompat<Tc> r3 = r3.f2901a
            int r3 = r3.e()
            if (r3 <= 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 != 0) goto L_0x001b
            r30.concat(r31)
        L_0x001b:
            Lz r3 = r0.f412a
            java.lang.Object r3 = r3.f()
            q9 r3 = (defpackage.q9) r3
            ej r6 = r0.f417a
            java.util.Map<java.lang.String, Qc> r7 = r6.f2909c
            java.lang.String r8 = r3.f3182b
            java.lang.Object r7 = r7.get(r8)
            Qc r7 = (defpackage.C0099Qc) r7
            if (r7 != 0) goto L_0x0035
            r30.restore()
            return
        L_0x0035:
            WB r8 = r0.f415a
            Mz$a r9 = r0.f413a
            if (r8 == 0) goto L_0x0049
            java.lang.Object r8 = r8.f()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r9.setColor(r8)
            goto L_0x0060
        L_0x0049:
            Ch r8 = r0.a
            if (r8 == 0) goto L_0x005b
            java.lang.Object r8 = r8.f()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r9.setColor(r8)
            goto L_0x0060
        L_0x005b:
            int r8 = r3.f3183c
            r9.setColor(r8)
        L_0x0060:
            WB r8 = r0.f422b
            Mz$b r10 = r0.f414a
            if (r8 == 0) goto L_0x0074
            java.lang.Object r8 = r8.f()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r10.setColor(r8)
            goto L_0x008b
        L_0x0074:
            Ch r8 = r0.b
            if (r8 == 0) goto L_0x0086
            java.lang.Object r8 = r8.f()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            r10.setColor(r8)
            goto L_0x008b
        L_0x0086:
            int r8 = r3.f3184d
            r10.setColor(r8)
        L_0x008b:
            HA r8 = r0.f3343a
            t2<java.lang.Integer, java.lang.Integer> r8 = r8.e
            r11 = 100
            if (r8 != 0) goto L_0x0095
            r8 = r11
            goto L_0x009f
        L_0x0095:
            java.lang.Object r8 = r8.f()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
        L_0x009f:
            int r8 = r8 * 255
            int r8 = r8 / r11
            r9.setAlpha(r8)
            r10.setAlpha(r8)
            WB r8 = r0.f423c
            if (r8 == 0) goto L_0x00ba
            java.lang.Object r8 = r8.f()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            r10.setStrokeWidth(r8)
            goto L_0x00db
        L_0x00ba:
            Gc r8 = r0.f421b
            if (r8 == 0) goto L_0x00cc
            java.lang.Object r8 = r8.f()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            r10.setStrokeWidth(r8)
            goto L_0x00db
        L_0x00cc:
            float r8 = defpackage.UB.d(r31)
            float r11 = r3.d
            float r12 = defpackage.UB.c()
            float r12 = r12 * r11
            float r12 = r12 * r8
            r10.setStrokeWidth(r12)
        L_0x00db:
            ej r8 = r2.f145a
            androidx.collection.SparseArrayCompat<Tc> r8 = r8.f2901a
            int r8 = r8.e()
            if (r8 <= 0) goto L_0x00e7
            r8 = 1
            goto L_0x00e8
        L_0x00e7:
            r8 = 0
        L_0x00e8:
            java.lang.String r12 = "\n"
            java.lang.String r13 = "\r"
            java.lang.String r14 = "\r\n"
            r16 = 1073741824(0x40000000, float:2.0)
            r17 = 1120403456(0x42c80000, float:100.0)
            Gc r11 = r0.c
            java.lang.String r15 = r7.b
            java.lang.String r7 = r7.a
            if (r8 == 0) goto L_0x02f9
            WB r8 = r0.e
            if (r8 == 0) goto L_0x0109
            java.lang.Object r8 = r8.f()
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            goto L_0x010b
        L_0x0109:
            float r8 = r3.a
        L_0x010b:
            float r8 = r8 / r17
            float r4 = defpackage.UB.d(r31)
            java.lang.String r5 = r3.f3179a
            r18 = r11
            float r11 = r3.b
            float r17 = defpackage.UB.c()
            float r17 = r17 * r11
            java.lang.String r5 = r5.replaceAll(r14, r13)
            java.lang.String r5 = r5.replaceAll(r12, r13)
            java.lang.String[] r5 = r5.split(r13)
            java.util.List r5 = java.util.Arrays.asList(r5)
            int r11 = r5.size()
            r12 = 0
        L_0x0132:
            if (r12 >= r11) goto L_0x0527
            java.lang.Object r13 = r5.get(r12)
            java.lang.String r13 = (java.lang.String) r13
            r19 = r5
            r20 = r10
            r5 = 0
            r14 = 0
        L_0x0140:
            int r10 = r13.length()
            if (r14 >= r10) goto L_0x0185
            char r10 = r13.charAt(r14)
            int r10 = defpackage.C0101Tc.a(r10, r7, r15)
            r21 = r9
            androidx.collection.SparseArrayCompat<Tc> r9 = r6.f2901a
            r22 = r2
            r2 = 0
            java.lang.Object r9 = r9.c(r10, r2)
            Tc r9 = (defpackage.C0101Tc) r9
            r2 = r6
            if (r9 != 0) goto L_0x0164
            r24 = r8
            r10 = r12
            r23 = r13
            goto L_0x0178
        L_0x0164:
            double r5 = (double) r5
            r10 = r12
            r23 = r13
            double r12 = (double) r8
            r24 = r8
            double r8 = r9.f551a
            double r8 = r8 * r12
            float r12 = defpackage.UB.c()
            double r12 = (double) r12
            double r8 = r8 * r12
            double r12 = (double) r4
            double r8 = r8 * r12
            double r8 = r8 + r5
            float r5 = (float) r8
        L_0x0178:
            int r14 = r14 + 1
            r6 = r2
            r12 = r10
            r9 = r21
            r2 = r22
            r13 = r23
            r8 = r24
            goto L_0x0140
        L_0x0185:
            r22 = r2
            r2 = r6
            r24 = r8
            r21 = r9
            r10 = r12
            r23 = r13
            r30.save()
            int r6 = r3.f3178a
            if (r6 == 0) goto L_0x02f7
            int r6 = r6 + -1
            r8 = 1
            if (r6 == r8) goto L_0x01a7
            r8 = 2
            if (r6 == r8) goto L_0x019f
            goto L_0x01ac
        L_0x019f:
            float r5 = -r5
            float r5 = r5 / r16
            r6 = 0
            r1.translate(r5, r6)
            goto L_0x01ac
        L_0x01a7:
            r6 = 0
            float r5 = -r5
            r1.translate(r5, r6)
        L_0x01ac:
            int r5 = r11 + -1
            float r5 = (float) r5
            float r5 = r5 * r17
            float r5 = r5 / r16
            float r6 = (float) r10
            float r6 = r6 * r17
            float r6 = r6 - r5
            r5 = 0
            r1.translate(r5, r6)
            r5 = 0
        L_0x01bc:
            int r6 = r23.length()
            if (r5 >= r6) goto L_0x02d8
            r13 = r23
            char r6 = r13.charAt(r5)
            int r6 = defpackage.C0101Tc.a(r6, r7, r15)
            androidx.collection.SparseArrayCompat<Tc> r8 = r2.f2901a
            r9 = 0
            java.lang.Object r6 = r8.c(r6, r9)
            Tc r6 = (defpackage.C0101Tc) r6
            if (r6 != 0) goto L_0x01e5
            r23 = r2
            r25 = r11
            r26 = r13
            r11 = r21
            r12 = r22
            r8 = r24
            goto L_0x02c8
        L_0x01e5:
            java.util.HashMap r8 = r0.f419a
            boolean r9 = r8.containsKey(r6)
            if (r9 == 0) goto L_0x01fa
            java.lang.Object r8 = r8.get(r6)
            java.util.List r8 = (java.util.List) r8
            r23 = r2
            r25 = r11
            r12 = r22
            goto L_0x0233
        L_0x01fa:
            java.util.List<qw> r9 = r6.f553a
            int r12 = r9.size()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>(r12)
            r23 = r2
            r2 = 0
        L_0x0208:
            if (r2 >= r12) goto L_0x022b
            java.lang.Object r25 = r9.get(r2)
            r26 = r9
            r9 = r25
            qw r9 = (defpackage.qw) r9
            r25 = r11
            Y6 r11 = new Y6
            r27 = r12
            r12 = r22
            r11.<init>(r12, r0, r9)
            r14.add(r11)
            int r2 = r2 + 1
            r11 = r25
            r9 = r26
            r12 = r27
            goto L_0x0208
        L_0x022b:
            r25 = r11
            r12 = r22
            r8.put(r6, r14)
            r8 = r14
        L_0x0233:
            r2 = 0
        L_0x0234:
            int r9 = r8.size()
            if (r2 >= r9) goto L_0x0290
            java.lang.Object r9 = r8.get(r2)
            Y6 r9 = (defpackage.Y6) r9
            android.graphics.Path r9 = r9.b()
            android.graphics.RectF r11 = r0.f425f
            r14 = 0
            r9.computeBounds(r11, r14)
            android.graphics.Matrix r11 = r0.f424d
            r14 = r31
            r11.set(r14)
            r22 = r8
            float r8 = r3.c
            float r8 = -r8
            float r26 = defpackage.UB.c()
            float r8 = r8 * r26
            r26 = r13
            r13 = 0
            r11.preTranslate(r13, r8)
            r8 = r24
            r11.preScale(r8, r8)
            r9.transform(r11)
            boolean r11 = r3.f3180a
            if (r11 == 0) goto L_0x0279
            r11 = r21
            v(r9, r11, r1)
            r13 = r20
            v(r9, r13, r1)
            goto L_0x0283
        L_0x0279:
            r13 = r20
            r11 = r21
            v(r9, r13, r1)
            v(r9, r11, r1)
        L_0x0283:
            int r2 = r2 + 1
            r24 = r8
            r21 = r11
            r20 = r13
            r8 = r22
            r13 = r26
            goto L_0x0234
        L_0x0290:
            r26 = r13
            r11 = r21
            r8 = r24
            double r13 = r6.f551a
            float r2 = (float) r13
            float r2 = r2 * r8
            float r6 = defpackage.UB.c()
            float r6 = r6 * r2
            float r6 = r6 * r4
            int r2 = r3.f3181b
            float r2 = (float) r2
            r9 = 1092616192(0x41200000, float:10.0)
            float r2 = r2 / r9
            WB r9 = r0.d
            if (r9 == 0) goto L_0x02b5
            java.lang.Object r9 = r9.f()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            goto L_0x02c1
        L_0x02b5:
            if (r18 == 0) goto L_0x02c2
            java.lang.Object r9 = r18.f()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
        L_0x02c1:
            float r2 = r2 + r9
        L_0x02c2:
            float r2 = r2 * r4
            float r2 = r2 + r6
            r6 = 0
            r1.translate(r2, r6)
        L_0x02c8:
            int r5 = r5 + 1
            r24 = r8
            r21 = r11
            r22 = r12
            r2 = r23
            r11 = r25
            r23 = r26
            goto L_0x01bc
        L_0x02d8:
            r23 = r2
            r25 = r11
            r11 = r21
            r12 = r22
            r8 = r24
            r30.restore()
            int r2 = r10 + 1
            r9 = r11
            r5 = r19
            r10 = r20
            r6 = r23
            r11 = r25
            r28 = r12
            r12 = r2
            r2 = r28
            goto L_0x0132
        L_0x02f7:
            r2 = 0
            throw r2
        L_0x02f9:
            r4 = r10
            r18 = r11
            r11 = r9
            r28 = r12
            r12 = r2
            r2 = r28
            WB r5 = r0.f
            if (r5 == 0) goto L_0x0310
            java.lang.Object r5 = r5.f()
            android.graphics.Typeface r5 = (android.graphics.Typeface) r5
            if (r5 == 0) goto L_0x0310
            goto L_0x0394
        L_0x0310:
            android.graphics.drawable.Drawable$Callback r5 = r12.getCallback()
            if (r5 != 0) goto L_0x0318
            r5 = 0
            goto L_0x0329
        L_0x0318:
            Sc r5 = r12.f139a
            if (r5 != 0) goto L_0x0327
            Sc r5 = new Sc
            android.graphics.drawable.Drawable$Callback r6 = r12.getCallback()
            r5.<init>(r6)
            r12.f139a = r5
        L_0x0327:
            Sc r5 = r12.f139a
        L_0x0329:
            if (r5 == 0) goto L_0x038f
            em<java.lang.String> r6 = r5.f516a
            r6.a = r7
            r6.b = r15
            java.util.HashMap r8 = r5.f518a
            java.lang.Object r9 = r8.get(r6)
            android.graphics.Typeface r9 = (android.graphics.Typeface) r9
            if (r9 == 0) goto L_0x033d
            r5 = r9
            goto L_0x0390
        L_0x033d:
            java.util.HashMap r9 = r5.b
            java.lang.Object r10 = r9.get(r7)
            android.graphics.Typeface r10 = (android.graphics.Typeface) r10
            if (r10 == 0) goto L_0x0348
            goto L_0x0364
        L_0x0348:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "fonts/"
            r10.<init>(r12)
            r10.append(r7)
            java.lang.String r12 = r5.f517a
            r10.append(r12)
            java.lang.String r10 = r10.toString()
            android.content.res.AssetManager r5 = r5.a
            android.graphics.Typeface r10 = android.graphics.Typeface.createFromAsset(r5, r10)
            r9.put(r7, r10)
        L_0x0364:
            java.lang.String r5 = "Italic"
            boolean r5 = r15.contains(r5)
            java.lang.String r7 = "Bold"
            boolean r7 = r15.contains(r7)
            if (r5 == 0) goto L_0x0376
            if (r7 == 0) goto L_0x0376
            r5 = 3
            goto L_0x037f
        L_0x0376:
            if (r5 == 0) goto L_0x037a
            r5 = 2
            goto L_0x037f
        L_0x037a:
            if (r7 == 0) goto L_0x037e
            r5 = 1
            goto L_0x037f
        L_0x037e:
            r5 = 0
        L_0x037f:
            int r7 = r10.getStyle()
            if (r7 != r5) goto L_0x0387
            r5 = r10
            goto L_0x038b
        L_0x0387:
            android.graphics.Typeface r5 = android.graphics.Typeface.create(r10, r5)
        L_0x038b:
            r8.put(r6, r5)
            goto L_0x0390
        L_0x038f:
            r5 = 0
        L_0x0390:
            if (r5 == 0) goto L_0x0393
            goto L_0x0394
        L_0x0393:
            r5 = 0
        L_0x0394:
            if (r5 != 0) goto L_0x0398
            goto L_0x0527
        L_0x0398:
            java.lang.String r6 = r3.f3179a
            r11.setTypeface(r5)
            WB r5 = r0.e
            if (r5 == 0) goto L_0x03ac
            java.lang.Object r5 = r5.f()
            java.lang.Float r5 = (java.lang.Float) r5
            float r5 = r5.floatValue()
            goto L_0x03ae
        L_0x03ac:
            float r5 = r3.a
        L_0x03ae:
            float r7 = defpackage.UB.c()
            float r7 = r7 * r5
            r11.setTextSize(r7)
            android.graphics.Typeface r7 = r11.getTypeface()
            r4.setTypeface(r7)
            float r7 = r11.getTextSize()
            r4.setTextSize(r7)
            float r7 = r3.b
            float r8 = defpackage.UB.c()
            float r8 = r8 * r7
            int r7 = r3.f3181b
            float r7 = (float) r7
            r9 = 1092616192(0x41200000, float:10.0)
            float r7 = r7 / r9
            WB r9 = r0.d
            if (r9 == 0) goto L_0x03e0
            java.lang.Object r9 = r9.f()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
            goto L_0x03ec
        L_0x03e0:
            if (r18 == 0) goto L_0x03ed
            java.lang.Object r9 = r18.f()
            java.lang.Float r9 = (java.lang.Float) r9
            float r9 = r9.floatValue()
        L_0x03ec:
            float r7 = r7 + r9
        L_0x03ed:
            float r9 = defpackage.UB.c()
            float r9 = r9 * r7
            float r9 = r9 * r5
            float r9 = r9 / r17
            java.lang.String r5 = r6.replaceAll(r14, r13)
            java.lang.String r2 = r5.replaceAll(r2, r13)
            java.lang.String[] r2 = r2.split(r13)
            java.util.List r2 = java.util.Arrays.asList(r2)
            int r5 = r2.size()
            r14 = 0
        L_0x040a:
            if (r14 >= r5) goto L_0x0527
            java.lang.Object r6 = r2.get(r14)
            java.lang.String r6 = (java.lang.String) r6
            float r7 = r4.measureText(r6)
            int r10 = r6.length()
            r12 = 1
            int r10 = r10 - r12
            float r10 = (float) r10
            float r10 = r10 * r9
            float r10 = r10 + r7
            r30.save()
            int r7 = r3.f3178a
            if (r7 == 0) goto L_0x0525
            int r7 = r7 + -1
            if (r7 == r12) goto L_0x0436
            r13 = 2
            if (r7 == r13) goto L_0x042e
            goto L_0x043c
        L_0x042e:
            float r7 = -r10
            float r7 = r7 / r16
            r15 = 0
            r1.translate(r7, r15)
            goto L_0x043c
        L_0x0436:
            r13 = 2
            r15 = 0
            float r7 = -r10
            r1.translate(r7, r15)
        L_0x043c:
            int r7 = r5 + -1
            float r7 = (float) r7
            float r7 = r7 * r8
            float r7 = r7 / r16
            float r10 = (float) r14
            float r10 = r10 * r8
            float r10 = r10 - r7
            r7 = 0
            r1.translate(r7, r10)
            r7 = 0
        L_0x044a:
            int r10 = r6.length()
            if (r7 >= r10) goto L_0x0515
            int r10 = r6.codePointAt(r7)
            int r15 = java.lang.Character.charCount(r10)
            int r15 = r15 + r7
        L_0x0459:
            int r12 = r6.length()
            if (r15 >= r12) goto L_0x04a7
            int r12 = r6.codePointAt(r15)
            int r13 = java.lang.Character.getType(r12)
            r31 = r2
            r2 = 16
            if (r13 == r2) goto L_0x0497
            int r2 = java.lang.Character.getType(r12)
            r13 = 27
            if (r2 == r13) goto L_0x0497
            int r2 = java.lang.Character.getType(r12)
            r13 = 6
            if (r2 == r13) goto L_0x0497
            int r2 = java.lang.Character.getType(r12)
            r13 = 28
            if (r2 == r13) goto L_0x0497
            int r2 = java.lang.Character.getType(r12)
            r13 = 8
            if (r2 == r13) goto L_0x0497
            int r2 = java.lang.Character.getType(r12)
            r13 = 19
            if (r2 != r13) goto L_0x0495
            goto L_0x0497
        L_0x0495:
            r2 = 0
            goto L_0x0498
        L_0x0497:
            r2 = 1
        L_0x0498:
            if (r2 != 0) goto L_0x049b
            goto L_0x04a9
        L_0x049b:
            int r2 = java.lang.Character.charCount(r12)
            int r15 = r15 + r2
            int r10 = r10 * 31
            int r10 = r10 + r12
            r2 = r31
            r13 = 2
            goto L_0x0459
        L_0x04a7:
            r31 = r2
        L_0x04a9:
            long r12 = (long) r10
            androidx.collection.LongSparseArray<java.lang.String> r2 = r0.f416a
            boolean r10 = r2.f1324a
            if (r10 == 0) goto L_0x04b3
            r2.c()
        L_0x04b3:
            long[] r10 = r2.f1325a
            r32 = r5
            int r5 = r2.c
            int r5 = defpackage.C1354qp.k(r5, r12, r10)
            if (r5 < 0) goto L_0x04c1
            r5 = 1
            goto L_0x04c2
        L_0x04c1:
            r5 = 0
        L_0x04c2:
            if (r5 == 0) goto L_0x04cc
            r5 = 0
            java.lang.Object r2 = r2.d(r12, r5)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x04ec
        L_0x04cc:
            java.lang.StringBuilder r5 = r0.f418a
            r10 = 0
            r5.setLength(r10)
            r10 = r7
        L_0x04d3:
            if (r10 >= r15) goto L_0x04e4
            int r0 = r6.codePointAt(r10)
            r5.appendCodePoint(r0)
            int r0 = java.lang.Character.charCount(r0)
            int r10 = r10 + r0
            r0 = r29
            goto L_0x04d3
        L_0x04e4:
            java.lang.String r0 = r5.toString()
            r2.e(r12, r0)
            r2 = r0
        L_0x04ec:
            int r0 = r2.length()
            int r7 = r7 + r0
            boolean r0 = r3.f3180a
            if (r0 == 0) goto L_0x04fc
            u(r2, r11, r1)
            u(r2, r4, r1)
            goto L_0x0502
        L_0x04fc:
            u(r2, r4, r1)
            u(r2, r11, r1)
        L_0x0502:
            float r0 = r11.measureText(r2)
            float r0 = r0 + r9
            r2 = 0
            r1.translate(r0, r2)
            r12 = 1
            r13 = 2
            r0 = r29
            r2 = r31
            r5 = r32
            goto L_0x044a
        L_0x0515:
            r31 = r2
            r32 = r5
            r2 = 0
            r30.restore()
            int r14 = r14 + 1
            r0 = r29
            r2 = r31
            goto L_0x040a
        L_0x0525:
            r0 = 0
            throw r0
        L_0x0527:
            r30.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Mz.l(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }
}
