package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: M4  reason: default package */
/* compiled from: ChainRun */
public final class M4 extends CD {
    public final ArrayList<CD> a = new ArrayList<>();
    public int d;

    public M4(int i, ConstraintWidget constraintWidget) {
        super(constraintWidget);
        Object obj;
        boolean z;
        int i2;
        Object obj2;
        this.b = i;
        ConstraintWidget constraintWidget2 = this.f81a;
        ConstraintWidget q = constraintWidget2.q(i);
        while (q != null) {
            constraintWidget2 = q;
            q = q.q(this.b);
        }
        this.f81a = constraintWidget2;
        int i3 = this.b;
        if (i3 == 0) {
            obj = constraintWidget2.f1347a;
        } else if (i3 == 1) {
            obj = constraintWidget2.f1350a;
        } else {
            obj = null;
        }
        ArrayList<CD> arrayList = this.a;
        arrayList.add(obj);
        ConstraintWidget p = constraintWidget2.p(this.b);
        while (p != null) {
            int i4 = this.b;
            if (i4 == 0) {
                obj2 = p.f1347a;
            } else if (i4 == 1) {
                obj2 = p.f1350a;
            } else {
                obj2 = null;
            }
            arrayList.add(obj2);
            p = p.p(this.b);
        }
        Iterator<CD> it = arrayList.iterator();
        while (it.hasNext()) {
            CD next = it.next();
            int i5 = this.b;
            if (i5 == 0) {
                next.f81a.f1346a = this;
            } else if (i5 == 1) {
                next.f81a.f1362b = this;
            }
        }
        if (this.b != 0 || !((ConstraintWidgetContainer) this.f81a.f1349a).l) {
            z = false;
        } else {
            z = true;
        }
        if (z && arrayList.size() > 1) {
            this.f81a = arrayList.get(arrayList.size() - 1).f81a;
        }
        if (this.b == 0) {
            i2 = this.f81a.x;
        } else {
            i2 = this.f81a.y;
        }
        this.d = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02db  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(defpackage.J8 r28) {
        /*
            r27 = this;
            r0 = r27
            N8 r1 = r0.f79a
            boolean r2 = r1.f436c
            if (r2 == 0) goto L_0x03ef
            N8 r2 = r0.f85b
            boolean r3 = r2.f436c
            if (r3 != 0) goto L_0x0010
            goto L_0x03ef
        L_0x0010:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.f1349a
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r4 == 0) goto L_0x001d
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r3
            boolean r3 = r3.l
            goto L_0x001e
        L_0x001d:
            r3 = 0
        L_0x001e:
            int r4 = r2.c
            int r6 = r1.c
            int r4 = r4 - r6
            java.util.ArrayList<CD> r6 = r0.a
            int r7 = r6.size()
            r8 = 0
        L_0x002a:
            r9 = -1
            r10 = 8
            if (r8 >= r7) goto L_0x003e
            java.lang.Object r11 = r6.get(r8)
            CD r11 = (defpackage.CD) r11
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r11.f81a
            int r11 = r11.w
            if (r11 != r10) goto L_0x003f
            int r8 = r8 + 1
            goto L_0x002a
        L_0x003e:
            r8 = r9
        L_0x003f:
            int r11 = r7 + -1
            r12 = r11
        L_0x0042:
            if (r12 < 0) goto L_0x0054
            java.lang.Object r13 = r6.get(r12)
            CD r13 = (defpackage.CD) r13
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r13.f81a
            int r13 = r13.w
            if (r13 != r10) goto L_0x0053
            int r12 = r12 + -1
            goto L_0x0042
        L_0x0053:
            r9 = r12
        L_0x0054:
            r12 = 0
        L_0x0055:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r14 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            r15 = 2
            if (r12 >= r15) goto L_0x0114
            r13 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x0062:
            if (r15 >= r7) goto L_0x00f8
            java.lang.Object r20 = r6.get(r15)
            r5 = r20
            CD r5 = (defpackage.CD) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r5.f81a
            r21 = r6
            int r6 = r10.w
            r22 = r7
            r7 = 8
            if (r6 != r7) goto L_0x007c
            r25 = r8
            goto L_0x00ec
        L_0x007c:
            int r18 = r18 + 1
            if (r15 <= 0) goto L_0x0087
            if (r15 < r8) goto L_0x0087
            N8 r6 = r5.f79a
            int r6 = r6.b
            int r13 = r13 + r6
        L_0x0087:
            c9 r6 = r5.f82a
            int r7 = r6.c
            r23 = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r7 = r5.f80a
            if (r7 == r14) goto L_0x0093
            r7 = 1
            goto L_0x0094
        L_0x0093:
            r7 = 0
        L_0x0094:
            if (r7 == 0) goto L_0x00b4
            int r6 = r0.b
            r24 = r7
            if (r6 != 0) goto L_0x00a5
            af r7 = r10.f1347a
            c9 r7 = r7.f82a
            boolean r7 = r7.f436c
            if (r7 != 0) goto L_0x00a5
            return
        L_0x00a5:
            r7 = 1
            if (r6 != r7) goto L_0x00b1
            hC r6 = r10.f1350a
            c9 r6 = r6.f82a
            boolean r6 = r6.f436c
            if (r6 != 0) goto L_0x00b1
            return
        L_0x00b1:
            r25 = r8
            goto L_0x00cd
        L_0x00b4:
            r24 = r7
            r25 = r8
            r7 = 1
            int r8 = r5.a
            if (r8 != r7) goto L_0x00c4
            if (r12 != 0) goto L_0x00c4
            int r7 = r6.e
            int r17 = r17 + 1
            goto L_0x00ca
        L_0x00c4:
            boolean r6 = r6.f436c
            if (r6 == 0) goto L_0x00cd
            r7 = r23
        L_0x00ca:
            r24 = 1
            goto L_0x00cf
        L_0x00cd:
            r7 = r23
        L_0x00cf:
            if (r24 != 0) goto L_0x00e1
            int r17 = r17 + 1
            float[] r6 = r10.f1355a
            int r7 = r0.b
            r6 = r6[r7]
            r7 = 0
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x00e2
            float r19 = r19 + r6
            goto L_0x00e2
        L_0x00e1:
            int r13 = r13 + r7
        L_0x00e2:
            if (r15 >= r11) goto L_0x00ec
            if (r15 >= r9) goto L_0x00ec
            N8 r5 = r5.f85b
            int r5 = r5.b
            int r5 = -r5
            int r13 = r13 + r5
        L_0x00ec:
            int r15 = r15 + 1
            r6 = r21
            r7 = r22
            r8 = r25
            r10 = 8
            goto L_0x0062
        L_0x00f8:
            r21 = r6
            r22 = r7
            r25 = r8
            if (r13 < r4) goto L_0x010f
            if (r17 != 0) goto L_0x0103
            goto L_0x010f
        L_0x0103:
            int r12 = r12 + 1
            r6 = r21
            r7 = r22
            r8 = r25
            r10 = 8
            goto L_0x0055
        L_0x010f:
            r5 = r17
            r6 = r18
            goto L_0x011f
        L_0x0114:
            r21 = r6
            r22 = r7
            r25 = r8
            r5 = 0
            r6 = 0
            r13 = 0
            r19 = 0
        L_0x011f:
            int r1 = r1.c
            if (r3 == 0) goto L_0x0125
            int r1 = r2.c
        L_0x0125:
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r13 <= r4) goto L_0x013c
            r7 = 1073741824(0x40000000, float:2.0)
            if (r3 == 0) goto L_0x0135
            int r8 = r13 - r4
            float r8 = (float) r8
            float r8 = r8 / r7
            float r8 = r8 + r2
            int r7 = (int) r8
            int r1 = r1 + r7
            goto L_0x013c
        L_0x0135:
            int r8 = r13 - r4
            float r8 = (float) r8
            float r8 = r8 / r7
            float r8 = r8 + r2
            int r7 = (int) r8
            int r1 = r1 - r7
        L_0x013c:
            if (r5 <= 0) goto L_0x0225
            int r7 = r4 - r13
            float r7 = (float) r7
            float r8 = (float) r5
            float r8 = r7 / r8
            float r8 = r8 + r2
            int r8 = (int) r8
            r10 = r22
            r12 = 0
            r15 = 0
        L_0x014a:
            if (r12 >= r10) goto L_0x01d1
            r2 = r21
            java.lang.Object r18 = r2.get(r12)
            r21 = r8
            r8 = r18
            CD r8 = (defpackage.CD) r8
            r18 = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r8.f81a
            r22 = r1
            int r1 = r13.w
            r23 = r3
            r3 = 8
            if (r1 != r3) goto L_0x0167
            goto L_0x01b9
        L_0x0167:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = r8.f80a
            if (r1 != r14) goto L_0x01b9
            c9 r1 = r8.f82a
            boolean r3 = r1.f436c
            if (r3 != 0) goto L_0x01b9
            r3 = 0
            int r16 = (r19 > r3 ? 1 : (r19 == r3 ? 0 : -1))
            if (r16 <= 0) goto L_0x0186
            float[] r3 = r13.f1355a
            r24 = r14
            int r14 = r0.b
            r3 = r3[r14]
            float r3 = r3 * r7
            float r3 = r3 / r19
            r14 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r14
            int r3 = (int) r3
            goto L_0x018a
        L_0x0186:
            r24 = r14
            r3 = r21
        L_0x018a:
            int r14 = r0.b
            if (r14 != 0) goto L_0x0193
            int r14 = r13.i
            int r13 = r13.h
            goto L_0x0197
        L_0x0193:
            int r14 = r13.k
            int r13 = r13.j
        L_0x0197:
            int r8 = r8.a
            r26 = r7
            r7 = 1
            if (r8 != r7) goto L_0x01a5
            int r7 = r1.e
            int r7 = java.lang.Math.min(r3, r7)
            goto L_0x01a6
        L_0x01a5:
            r7 = r3
        L_0x01a6:
            int r7 = java.lang.Math.max(r13, r7)
            if (r14 <= 0) goto L_0x01b0
            int r7 = java.lang.Math.min(r14, r7)
        L_0x01b0:
            if (r7 == r3) goto L_0x01b5
            int r15 = r15 + 1
            r3 = r7
        L_0x01b5:
            r1.d(r3)
            goto L_0x01bd
        L_0x01b9:
            r26 = r7
            r24 = r14
        L_0x01bd:
            int r12 = r12 + 1
            r13 = r18
            r8 = r21
            r1 = r22
            r3 = r23
            r14 = r24
            r7 = r26
            r21 = r2
            r2 = 1056964608(0x3f000000, float:0.5)
            goto L_0x014a
        L_0x01d1:
            r22 = r1
            r23 = r3
            r18 = r13
            r24 = r14
            r2 = r21
            if (r15 <= 0) goto L_0x0216
            int r5 = r5 - r15
            r1 = 0
            r3 = 0
        L_0x01e0:
            if (r1 >= r10) goto L_0x0212
            java.lang.Object r7 = r2.get(r1)
            CD r7 = (defpackage.CD) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r7.f81a
            int r8 = r8.w
            r12 = 8
            if (r8 != r12) goto L_0x01f3
            r8 = r25
            goto L_0x020d
        L_0x01f3:
            r8 = r25
            if (r1 <= 0) goto L_0x01fe
            if (r1 < r8) goto L_0x01fe
            N8 r12 = r7.f79a
            int r12 = r12.b
            int r3 = r3 + r12
        L_0x01fe:
            c9 r12 = r7.f82a
            int r12 = r12.c
            int r3 = r3 + r12
            if (r1 >= r11) goto L_0x020d
            if (r1 >= r9) goto L_0x020d
            N8 r7 = r7.f85b
            int r7 = r7.b
            int r7 = -r7
            int r3 = r3 + r7
        L_0x020d:
            int r1 = r1 + 1
            r25 = r8
            goto L_0x01e0
        L_0x0212:
            r8 = r25
            r13 = r3
            goto L_0x021a
        L_0x0216:
            r8 = r25
            r13 = r18
        L_0x021a:
            int r1 = r0.d
            r3 = 2
            if (r1 != r3) goto L_0x0234
            if (r15 != 0) goto L_0x0234
            r1 = 0
            r0.d = r1
            goto L_0x0235
        L_0x0225:
            r23 = r3
            r18 = r13
            r24 = r14
            r2 = r21
            r10 = r22
            r8 = r25
            r3 = 2
            r22 = r1
        L_0x0234:
            r1 = 0
        L_0x0235:
            if (r13 <= r4) goto L_0x0239
            r0.d = r3
        L_0x0239:
            if (r6 <= 0) goto L_0x0241
            if (r5 != 0) goto L_0x0241
            if (r8 != r9) goto L_0x0241
            r0.d = r3
        L_0x0241:
            int r3 = r0.d
            r7 = 1
            if (r3 != r7) goto L_0x02db
            if (r6 <= r7) goto L_0x024c
            int r4 = r4 - r13
            int r6 = r6 - r7
            int r4 = r4 / r6
            goto L_0x0253
        L_0x024c:
            if (r6 != r7) goto L_0x0252
            int r4 = r4 - r13
            r3 = 2
            int r4 = r4 / r3
            goto L_0x0253
        L_0x0252:
            r4 = r1
        L_0x0253:
            if (r5 <= 0) goto L_0x0256
            r4 = r1
        L_0x0256:
            r5 = r1
            r1 = r22
        L_0x0259:
            if (r5 >= r10) goto L_0x03ef
            if (r23 == 0) goto L_0x0262
            int r3 = r5 + 1
            int r7 = r10 - r3
            goto L_0x0263
        L_0x0262:
            r7 = r5
        L_0x0263:
            java.lang.Object r3 = r2.get(r7)
            CD r3 = (defpackage.CD) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r3.f81a
            int r6 = r6.w
            N8 r7 = r3.f85b
            N8 r12 = r3.f79a
            r13 = 8
            if (r6 != r13) goto L_0x0280
            r12.d(r1)
            r7.d(r1)
            r28 = r4
            r15 = r24
            goto L_0x02d3
        L_0x0280:
            if (r5 <= 0) goto L_0x0287
            if (r23 == 0) goto L_0x0286
            int r1 = r1 - r4
            goto L_0x0287
        L_0x0286:
            int r1 = r1 + r4
        L_0x0287:
            if (r5 <= 0) goto L_0x0294
            if (r5 < r8) goto L_0x0294
            if (r23 == 0) goto L_0x0291
            int r6 = r12.b
            int r1 = r1 - r6
            goto L_0x0294
        L_0x0291:
            int r6 = r12.b
            int r1 = r1 + r6
        L_0x0294:
            if (r23 == 0) goto L_0x029a
            r7.d(r1)
            goto L_0x029d
        L_0x029a:
            r12.d(r1)
        L_0x029d:
            c9 r6 = r3.f82a
            int r13 = r6.c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r14 = r3.f80a
            r15 = r24
            if (r14 != r15) goto L_0x02b1
            int r14 = r3.a
            r28 = r4
            r4 = 1
            if (r14 != r4) goto L_0x02b3
            int r13 = r6.e
            goto L_0x02b3
        L_0x02b1:
            r28 = r4
        L_0x02b3:
            if (r23 == 0) goto L_0x02b7
            int r1 = r1 - r13
            goto L_0x02b8
        L_0x02b7:
            int r1 = r1 + r13
        L_0x02b8:
            if (r23 == 0) goto L_0x02be
            r12.d(r1)
            goto L_0x02c1
        L_0x02be:
            r7.d(r1)
        L_0x02c1:
            r4 = 1
            r3.f84a = r4
            if (r5 >= r11) goto L_0x02d3
            if (r5 >= r9) goto L_0x02d3
            if (r23 == 0) goto L_0x02cf
            int r3 = r7.b
            int r3 = -r3
            int r1 = r1 - r3
            goto L_0x02d3
        L_0x02cf:
            int r3 = r7.b
            int r3 = -r3
            int r1 = r1 + r3
        L_0x02d3:
            int r5 = r5 + 1
            r4 = r28
            r24 = r15
            goto L_0x0259
        L_0x02db:
            r15 = r24
            if (r3 != 0) goto L_0x035a
            int r4 = r4 - r13
            r3 = 1
            int r6 = r6 + r3
            int r4 = r4 / r6
            if (r5 <= 0) goto L_0x02e6
            r4 = r1
        L_0x02e6:
            r5 = r1
            r1 = r22
        L_0x02e9:
            if (r5 >= r10) goto L_0x03ef
            if (r23 == 0) goto L_0x02f2
            int r3 = r5 + 1
            int r7 = r10 - r3
            goto L_0x02f3
        L_0x02f2:
            r7 = r5
        L_0x02f3:
            java.lang.Object r3 = r2.get(r7)
            CD r3 = (defpackage.CD) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r3.f81a
            int r6 = r6.w
            N8 r7 = r3.f85b
            N8 r12 = r3.f79a
            r13 = 8
            if (r6 != r13) goto L_0x030c
            r12.d(r1)
            r7.d(r1)
            goto L_0x0357
        L_0x030c:
            if (r23 == 0) goto L_0x0310
            int r1 = r1 - r4
            goto L_0x0311
        L_0x0310:
            int r1 = r1 + r4
        L_0x0311:
            if (r5 <= 0) goto L_0x031e
            if (r5 < r8) goto L_0x031e
            if (r23 == 0) goto L_0x031b
            int r6 = r12.b
            int r1 = r1 - r6
            goto L_0x031e
        L_0x031b:
            int r6 = r12.b
            int r1 = r1 + r6
        L_0x031e:
            if (r23 == 0) goto L_0x0324
            r7.d(r1)
            goto L_0x0327
        L_0x0324:
            r12.d(r1)
        L_0x0327:
            c9 r6 = r3.f82a
            int r13 = r6.c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r14 = r3.f80a
            if (r14 != r15) goto L_0x033a
            int r3 = r3.a
            r14 = 1
            if (r3 != r14) goto L_0x033a
            int r3 = r6.e
            int r13 = java.lang.Math.min(r13, r3)
        L_0x033a:
            if (r23 == 0) goto L_0x033e
            int r1 = r1 - r13
            goto L_0x033f
        L_0x033e:
            int r1 = r1 + r13
        L_0x033f:
            if (r23 == 0) goto L_0x0345
            r12.d(r1)
            goto L_0x0348
        L_0x0345:
            r7.d(r1)
        L_0x0348:
            if (r5 >= r11) goto L_0x0357
            if (r5 >= r9) goto L_0x0357
            if (r23 == 0) goto L_0x0353
            int r3 = r7.b
            int r3 = -r3
            int r1 = r1 - r3
            goto L_0x0357
        L_0x0353:
            int r3 = r7.b
            int r3 = -r3
            int r1 = r1 + r3
        L_0x0357:
            int r5 = r5 + 1
            goto L_0x02e9
        L_0x035a:
            r6 = 2
            if (r3 != r6) goto L_0x03ef
            int r3 = r0.b
            if (r3 != 0) goto L_0x0366
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            float r3 = r3.f
            goto L_0x036a
        L_0x0366:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f81a
            float r3 = r3.g
        L_0x036a:
            if (r23 == 0) goto L_0x0370
            r6 = 1065353216(0x3f800000, float:1.0)
            float r3 = r6 - r3
        L_0x0370:
            int r4 = r4 - r13
            float r4 = (float) r4
            float r4 = r4 * r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r4 = r4 + r3
            int r3 = (int) r4
            if (r3 < 0) goto L_0x037b
            if (r5 <= 0) goto L_0x037c
        L_0x037b:
            r3 = r1
        L_0x037c:
            if (r23 == 0) goto L_0x0381
            int r3 = r22 - r3
            goto L_0x0383
        L_0x0381:
            int r3 = r22 + r3
        L_0x0383:
            r5 = r1
        L_0x0384:
            if (r5 >= r10) goto L_0x03ef
            if (r23 == 0) goto L_0x038d
            int r1 = r5 + 1
            int r7 = r10 - r1
            goto L_0x038e
        L_0x038d:
            r7 = r5
        L_0x038e:
            java.lang.Object r1 = r2.get(r7)
            CD r1 = (defpackage.CD) r1
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.f81a
            int r4 = r4.w
            N8 r6 = r1.f85b
            N8 r7 = r1.f79a
            r12 = 8
            if (r4 != r12) goto L_0x03a8
            r7.d(r3)
            r6.d(r3)
            r14 = 1
            goto L_0x03ec
        L_0x03a8:
            if (r5 <= 0) goto L_0x03b5
            if (r5 < r8) goto L_0x03b5
            if (r23 == 0) goto L_0x03b2
            int r4 = r7.b
            int r3 = r3 - r4
            goto L_0x03b5
        L_0x03b2:
            int r4 = r7.b
            int r3 = r3 + r4
        L_0x03b5:
            if (r23 == 0) goto L_0x03bb
            r6.d(r3)
            goto L_0x03be
        L_0x03bb:
            r7.d(r3)
        L_0x03be:
            c9 r4 = r1.f82a
            int r13 = r4.c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r14 = r1.f80a
            if (r14 != r15) goto L_0x03ce
            int r1 = r1.a
            r14 = 1
            if (r1 != r14) goto L_0x03cf
            int r13 = r4.e
            goto L_0x03cf
        L_0x03ce:
            r14 = 1
        L_0x03cf:
            if (r23 == 0) goto L_0x03d3
            int r3 = r3 - r13
            goto L_0x03d4
        L_0x03d3:
            int r3 = r3 + r13
        L_0x03d4:
            if (r23 == 0) goto L_0x03da
            r7.d(r3)
            goto L_0x03dd
        L_0x03da:
            r6.d(r3)
        L_0x03dd:
            if (r5 >= r11) goto L_0x03ec
            if (r5 >= r9) goto L_0x03ec
            if (r23 == 0) goto L_0x03e8
            int r1 = r6.b
            int r1 = -r1
            int r3 = r3 - r1
            goto L_0x03ec
        L_0x03e8:
            int r1 = r6.b
            int r1 = -r1
            int r3 = r3 + r1
        L_0x03ec:
            int r5 = r5 + 1
            goto L_0x0384
        L_0x03ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.M4.a(J8):void");
    }

    public final void d() {
        ArrayList<CD> arrayList = this.a;
        Iterator<CD> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        int size = arrayList.size();
        if (size >= 1) {
            ConstraintWidget constraintWidget = arrayList.get(0).f81a;
            ConstraintWidget constraintWidget2 = arrayList.get(size - 1).f81a;
            int i = this.b;
            N8 n8 = this.f85b;
            N8 n82 = this.f79a;
            if (i == 0) {
                ConstraintAnchor constraintAnchor = constraintWidget.f1348a;
                ConstraintAnchor constraintAnchor2 = constraintWidget2.f1371c;
                N8 i2 = CD.i(constraintAnchor, 0);
                int e = constraintAnchor.e();
                ConstraintWidget m = m();
                if (m != null) {
                    e = m.f1348a.e();
                }
                if (i2 != null) {
                    CD.b(n82, i2, e);
                }
                N8 i3 = CD.i(constraintAnchor2, 0);
                int e2 = constraintAnchor2.e();
                ConstraintWidget n = n();
                if (n != null) {
                    e2 = n.f1371c.e();
                }
                if (i3 != null) {
                    CD.b(n8, i3, -e2);
                }
            } else {
                ConstraintAnchor constraintAnchor3 = constraintWidget.f1363b;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.f1376d;
                N8 i4 = CD.i(constraintAnchor3, 1);
                int e3 = constraintAnchor3.e();
                ConstraintWidget m2 = m();
                if (m2 != null) {
                    e3 = m2.f1363b.e();
                }
                if (i4 != null) {
                    CD.b(n82, i4, e3);
                }
                N8 i5 = CD.i(constraintAnchor4, 1);
                int e4 = constraintAnchor4.e();
                ConstraintWidget n2 = n();
                if (n2 != null) {
                    e4 = n2.f1376d.e();
                }
                if (i5 != null) {
                    CD.b(n8, i5, -e4);
                }
            }
            n82.f429a = this;
            n8.f429a = this;
        }
    }

    public final void e() {
        int i = 0;
        while (true) {
            ArrayList<CD> arrayList = this.a;
            if (i < arrayList.size()) {
                arrayList.get(i).e();
                i++;
            } else {
                return;
            }
        }
    }

    public final void f() {
        this.f83a = null;
        Iterator<CD> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public final long j() {
        ArrayList<CD> arrayList = this.a;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            CD cd = arrayList.get(i);
            j = ((long) cd.f85b.b) + cd.j() + j + ((long) cd.f79a.b);
        }
        return j;
    }

    public final boolean k() {
        ArrayList<CD> arrayList = this.a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!arrayList.get(i).k()) {
                return false;
            }
        }
        return true;
    }

    public final ConstraintWidget m() {
        int i = 0;
        while (true) {
            ArrayList<CD> arrayList = this.a;
            if (i >= arrayList.size()) {
                return null;
            }
            ConstraintWidget constraintWidget = arrayList.get(i).f81a;
            if (constraintWidget.w != 8) {
                return constraintWidget;
            }
            i++;
        }
    }

    public final ConstraintWidget n() {
        ArrayList<CD> arrayList = this.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = arrayList.get(size).f81a;
            if (constraintWidget.w != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ChainRun ");
        if (this.b == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb.append(str);
        Iterator<CD> it = this.a.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }
}
