package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.D2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class ConstraintWidgetContainer extends AD {
    public int B;
    public int C;
    public int D;
    public int E = 0;
    public int F = 0;
    public int G = 257;
    public final D2.a a = new D2.a();

    /* renamed from: a  reason: collision with other field name */
    public D2.b f1393a = null;

    /* renamed from: a  reason: collision with other field name */
    public final D2 f1394a = new D2(this);

    /* renamed from: a  reason: collision with other field name */
    public final M8 f1395a = new M8(this);

    /* renamed from: a  reason: collision with other field name */
    public final ei f1396a = new ei();

    /* renamed from: a  reason: collision with other field name */
    public WeakReference<ConstraintAnchor> f1397a = null;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet<ConstraintWidget> f1398a = new HashSet<>();

    /* renamed from: a  reason: collision with other field name */
    public c[] f1399a = new c[4];
    public WeakReference<ConstraintAnchor> b = null;

    /* renamed from: b  reason: collision with other field name */
    public c[] f1400b = new c[4];
    public WeakReference<ConstraintAnchor> c = null;
    public WeakReference<ConstraintAnchor> d = null;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;

    public static void Y(ConstraintWidget constraintWidget, D2.b bVar, D2.a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        if (bVar != null) {
            if (constraintWidget.w == 8 || (constraintWidget instanceof e) || (constraintWidget instanceof a)) {
                aVar.c = 0;
                aVar.d = 0;
                return;
            }
            ConstraintWidget.a[] aVarArr = constraintWidget.f1358a;
            aVar.f107a = aVarArr[0];
            boolean z5 = true;
            aVar.f109b = aVarArr[1];
            aVar.a = constraintWidget.u();
            aVar.b = constraintWidget.o();
            aVar.f110b = false;
            aVar.f = 0;
            ConstraintWidget.a aVar2 = aVar.f107a;
            ConstraintWidget.a aVar3 = ConstraintWidget.a.MATCH_CONSTRAINT;
            if (aVar2 == aVar3) {
                z = true;
            } else {
                z = false;
            }
            if (aVar.f109b == aVar3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z || constraintWidget.e <= 0.0f) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z2 || constraintWidget.e <= 0.0f) {
                z4 = false;
            } else {
                z4 = true;
            }
            ConstraintWidget.a aVar4 = ConstraintWidget.a.WRAP_CONTENT;
            ConstraintWidget.a aVar5 = ConstraintWidget.a.FIXED;
            if (z && constraintWidget.x(0) && constraintWidget.f1381f == 0 && !z3) {
                aVar.f107a = aVar4;
                if (z2 && constraintWidget.f1384g == 0) {
                    aVar.f107a = aVar5;
                }
                z = false;
            }
            if (z2 && constraintWidget.x(1) && constraintWidget.f1384g == 0 && !z4) {
                aVar.f109b = aVar4;
                if (z && constraintWidget.f1381f == 0) {
                    aVar.f109b = aVar5;
                }
                z2 = false;
            }
            if (constraintWidget.E()) {
                aVar.f107a = aVar5;
                z = false;
            }
            if (constraintWidget.F()) {
                aVar.f109b = aVar5;
                z2 = false;
            }
            int[] iArr = constraintWidget.f1356a;
            if (z3) {
                if (iArr[0] == 4) {
                    aVar.f107a = aVar5;
                } else if (!z2) {
                    if (aVar.f109b == aVar5) {
                        i2 = aVar.b;
                    } else {
                        aVar.f107a = aVar4;
                        ((ConstraintLayout.Measurer) bVar).b(constraintWidget, aVar);
                        i2 = aVar.d;
                    }
                    aVar.f107a = aVar5;
                    aVar.a = (int) (constraintWidget.e * ((float) i2));
                }
            }
            if (z4) {
                if (iArr[1] == 4) {
                    aVar.f109b = aVar5;
                } else if (!z) {
                    if (aVar.f107a == aVar5) {
                        i = aVar.a;
                    } else {
                        aVar.f109b = aVar4;
                        ((ConstraintLayout.Measurer) bVar).b(constraintWidget, aVar);
                        i = aVar.c;
                    }
                    aVar.f109b = aVar5;
                    if (constraintWidget.q == -1) {
                        aVar.b = (int) (((float) i) / constraintWidget.e);
                    } else {
                        aVar.b = (int) (constraintWidget.e * ((float) i));
                    }
                }
            }
            ((ConstraintLayout.Measurer) bVar).b(constraintWidget, aVar);
            constraintWidget.R(aVar.c);
            constraintWidget.O(aVar.d);
            constraintWidget.f1388h = aVar.f108a;
            int i3 = aVar.e;
            constraintWidget.t = i3;
            if (i3 <= 0) {
                z5 = false;
            }
            constraintWidget.f1388h = z5;
            aVar.f = 0;
        }
    }

    public final void G() {
        this.f1396a.s();
        this.C = 0;
        this.D = 0;
        super.G();
    }

    public final void S(boolean z, boolean z2) {
        super.S(z, z2);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.b.get(i).S(z, z2);
        }
    }

    /* JADX WARNING: type inference failed for: r7v8, types: [boolean] */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x0603  */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0659  */
    /* JADX WARNING: Removed duplicated region for block: B:379:0x066f  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x06b0  */
    /* JADX WARNING: Removed duplicated region for block: B:391:0x06b2  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x06bd A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:401:0x06d1  */
    /* JADX WARNING: Removed duplicated region for block: B:402:0x06d3  */
    /* JADX WARNING: Removed duplicated region for block: B:405:0x06dd  */
    /* JADX WARNING: Removed duplicated region for block: B:411:0x06fa  */
    /* JADX WARNING: Removed duplicated region for block: B:474:0x07bc A[Catch:{ Exception -> 0x07d7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:480:0x07d9 A[Catch:{ Exception -> 0x07e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:495:0x0816  */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x085d  */
    /* JADX WARNING: Removed duplicated region for block: B:518:0x0886 A[LOOP:34: B:517:0x0884->B:518:0x0886, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:530:0x08ef  */
    /* JADX WARNING: Removed duplicated region for block: B:533:0x090b  */
    /* JADX WARNING: Removed duplicated region for block: B:534:0x0918  */
    /* JADX WARNING: Removed duplicated region for block: B:536:0x091b  */
    /* JADX WARNING: Removed duplicated region for block: B:551:0x095f  */
    /* JADX WARNING: Removed duplicated region for block: B:552:0x0961  */
    /* JADX WARNING: Removed duplicated region for block: B:556:0x0974  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void U() {
        /*
            r32 = this;
            r1 = r32
            r2 = 0
            r1.r = r2
            r1.s = r2
            r1.m = r2
            r1.n = r2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.b
            int r3 = r0.size()
            int r0 = r32.u()
            int r0 = java.lang.Math.max(r2, r0)
            int r4 = r32.o()
            int r4 = java.lang.Math.max(r2, r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r5 = r1.f1358a
            r6 = 1
            r7 = r5[r6]
            r5 = r5[r2]
            int r8 = r1.B
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.FIXED
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r1.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r1.f1348a
            if (r8 != 0) goto L_0x025e
            int r8 = r1.G
            boolean r8 = androidx.constraintlayout.core.widgets.f.b(r8, r6)
            if (r8 == 0) goto L_0x025e
            D2$b r8 = r1.f1393a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r14 = r1.f1358a
            r15 = r14[r2]
            r14 = r14[r6]
            r32.I()
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.b
            int r6 = r11.size()
        L_0x004d:
            if (r2 >= r6) goto L_0x005b
            java.lang.Object r18 = r11.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r18 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r18
            r18.I()
            int r2 = r2 + 1
            goto L_0x004d
        L_0x005b:
            boolean r2 = r1.l
            if (r15 != r10) goto L_0x006a
            int r15 = r32.u()
            r18 = r4
            r4 = 0
            r1.M(r4, r15)
            goto L_0x0072
        L_0x006a:
            r18 = r4
            r4 = 0
            r13.l(r4)
            r1.r = r4
        L_0x0072:
            r4 = 0
            r15 = 0
            r19 = 0
        L_0x0076:
            r20 = 1056964608(0x3f000000, float:0.5)
            if (r15 >= r6) goto L_0x00e0
            java.lang.Object r21 = r11.get(r15)
            r22 = r13
            r13 = r21
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            r21 = r0
            boolean r0 = r13 instanceof androidx.constraintlayout.core.widgets.e
            if (r0 == 0) goto L_0x00c7
            androidx.constraintlayout.core.widgets.e r13 = (androidx.constraintlayout.core.widgets.e) r13
            int r0 = r13.D
            r23 = r7
            r7 = 1
            if (r0 != r7) goto L_0x00d7
            int r0 = r13.B
            r4 = -1
            if (r0 == r4) goto L_0x009c
            r13.U(r0)
            goto L_0x00c5
        L_0x009c:
            int r0 = r13.C
            if (r0 == r4) goto L_0x00b1
            boolean r0 = r32.E()
            if (r0 == 0) goto L_0x00b1
            int r0 = r32.u()
            int r4 = r13.C
            int r0 = r0 - r4
            r13.U(r0)
            goto L_0x00c5
        L_0x00b1:
            boolean r0 = r32.E()
            if (r0 == 0) goto L_0x00c5
            float r0 = r13.h
            int r4 = r32.u()
            float r4 = (float) r4
            float r0 = r0 * r4
            float r0 = r0 + r20
            int r0 = (int) r0
            r13.U(r0)
        L_0x00c5:
            r4 = 1
            goto L_0x00d7
        L_0x00c7:
            r23 = r7
            boolean r0 = r13 instanceof androidx.constraintlayout.core.widgets.a
            if (r0 == 0) goto L_0x00d7
            androidx.constraintlayout.core.widgets.a r13 = (androidx.constraintlayout.core.widgets.a) r13
            int r0 = r13.W()
            if (r0 != 0) goto L_0x00d7
            r19 = 1
        L_0x00d7:
            int r15 = r15 + 1
            r0 = r21
            r13 = r22
            r7 = r23
            goto L_0x0076
        L_0x00e0:
            r21 = r0
            r23 = r7
            r22 = r13
            if (r4 == 0) goto L_0x0105
            r0 = 0
        L_0x00e9:
            if (r0 >= r6) goto L_0x0105
            java.lang.Object r4 = r11.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r4
            boolean r7 = r4 instanceof androidx.constraintlayout.core.widgets.e
            if (r7 == 0) goto L_0x0101
            androidx.constraintlayout.core.widgets.e r4 = (androidx.constraintlayout.core.widgets.e) r4
            int r7 = r4.D
            r13 = 1
            if (r7 != r13) goto L_0x0101
            r7 = 0
            defpackage.C0165d9.b(r7, r4, r8, r2)
            goto L_0x0102
        L_0x0101:
            r7 = 0
        L_0x0102:
            int r0 = r0 + 1
            goto L_0x00e9
        L_0x0105:
            r7 = 0
            defpackage.C0165d9.b(r7, r1, r8, r2)
            if (r19 == 0) goto L_0x012d
            r0 = 0
        L_0x010c:
            if (r0 >= r6) goto L_0x012d
            java.lang.Object r4 = r11.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r4
            boolean r7 = r4 instanceof androidx.constraintlayout.core.widgets.a
            if (r7 == 0) goto L_0x012a
            androidx.constraintlayout.core.widgets.a r4 = (androidx.constraintlayout.core.widgets.a) r4
            int r7 = r4.W()
            if (r7 != 0) goto L_0x012a
            boolean r7 = r4.V()
            if (r7 == 0) goto L_0x012a
            r7 = 1
            defpackage.C0165d9.b(r7, r4, r8, r2)
        L_0x012a:
            int r0 = r0 + 1
            goto L_0x010c
        L_0x012d:
            if (r14 != r10) goto L_0x0138
            int r0 = r32.o()
            r4 = 0
            r1.N(r4, r0)
            goto L_0x013e
        L_0x0138:
            r4 = 0
            r12.l(r4)
            r1.s = r4
        L_0x013e:
            r0 = 0
            r4 = 0
            r7 = 0
        L_0x0141:
            if (r4 >= r6) goto L_0x0198
            java.lang.Object r13 = r11.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r13
            boolean r14 = r13 instanceof androidx.constraintlayout.core.widgets.e
            if (r14 == 0) goto L_0x0187
            androidx.constraintlayout.core.widgets.e r13 = (androidx.constraintlayout.core.widgets.e) r13
            int r14 = r13.D
            if (r14 != 0) goto L_0x0195
            int r0 = r13.B
            r14 = -1
            if (r0 == r14) goto L_0x015c
            r13.U(r0)
            goto L_0x0185
        L_0x015c:
            int r0 = r13.C
            if (r0 == r14) goto L_0x0171
            boolean r0 = r32.F()
            if (r0 == 0) goto L_0x0171
            int r0 = r32.o()
            int r14 = r13.C
            int r0 = r0 - r14
            r13.U(r0)
            goto L_0x0185
        L_0x0171:
            boolean r0 = r32.F()
            if (r0 == 0) goto L_0x0185
            float r0 = r13.h
            int r14 = r32.o()
            float r14 = (float) r14
            float r0 = r0 * r14
            float r0 = r0 + r20
            int r0 = (int) r0
            r13.U(r0)
        L_0x0185:
            r0 = 1
            goto L_0x0195
        L_0x0187:
            boolean r14 = r13 instanceof androidx.constraintlayout.core.widgets.a
            if (r14 == 0) goto L_0x0195
            androidx.constraintlayout.core.widgets.a r13 = (androidx.constraintlayout.core.widgets.a) r13
            int r13 = r13.W()
            r14 = 1
            if (r13 != r14) goto L_0x0195
            r7 = 1
        L_0x0195:
            int r4 = r4 + 1
            goto L_0x0141
        L_0x0198:
            if (r0 == 0) goto L_0x01b4
            r0 = 0
        L_0x019b:
            if (r0 >= r6) goto L_0x01b4
            java.lang.Object r4 = r11.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r4
            boolean r13 = r4 instanceof androidx.constraintlayout.core.widgets.e
            if (r13 == 0) goto L_0x01b1
            androidx.constraintlayout.core.widgets.e r4 = (androidx.constraintlayout.core.widgets.e) r4
            int r13 = r4.D
            if (r13 != 0) goto L_0x01b1
            r13 = 1
            defpackage.C0165d9.g(r13, r4, r8)
        L_0x01b1:
            int r0 = r0 + 1
            goto L_0x019b
        L_0x01b4:
            r4 = 0
            defpackage.C0165d9.g(r4, r1, r8)
            if (r7 == 0) goto L_0x01dc
            r0 = 0
        L_0x01bb:
            if (r0 >= r6) goto L_0x01dc
            java.lang.Object r4 = r11.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r4
            boolean r7 = r4 instanceof androidx.constraintlayout.core.widgets.a
            if (r7 == 0) goto L_0x01d9
            androidx.constraintlayout.core.widgets.a r4 = (androidx.constraintlayout.core.widgets.a) r4
            int r7 = r4.W()
            r13 = 1
            if (r7 != r13) goto L_0x01d9
            boolean r7 = r4.V()
            if (r7 == 0) goto L_0x01d9
            defpackage.C0165d9.g(r13, r4, r8)
        L_0x01d9:
            int r0 = r0 + 1
            goto L_0x01bb
        L_0x01dc:
            r0 = 0
        L_0x01dd:
            if (r0 >= r6) goto L_0x0215
            java.lang.Object r4 = r11.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r4
            boolean r7 = r4.D()
            if (r7 == 0) goto L_0x0212
            boolean r7 = defpackage.C0165d9.a(r4)
            if (r7 == 0) goto L_0x0212
            D2$a r7 = defpackage.C0165d9.a
            Y(r4, r8, r7)
            boolean r7 = r4 instanceof androidx.constraintlayout.core.widgets.e
            if (r7 == 0) goto L_0x020b
            r7 = r4
            androidx.constraintlayout.core.widgets.e r7 = (androidx.constraintlayout.core.widgets.e) r7
            int r7 = r7.D
            if (r7 != 0) goto L_0x0206
            r7 = 0
            defpackage.C0165d9.g(r7, r4, r8)
            goto L_0x0212
        L_0x0206:
            r7 = 0
            defpackage.C0165d9.b(r7, r4, r8, r2)
            goto L_0x0212
        L_0x020b:
            r7 = 0
            defpackage.C0165d9.b(r7, r4, r8, r2)
            defpackage.C0165d9.g(r7, r4, r8)
        L_0x0212:
            int r0 = r0 + 1
            goto L_0x01dd
        L_0x0215:
            r0 = 0
        L_0x0216:
            if (r0 >= r3) goto L_0x0266
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.b
            java.lang.Object r2 = r2.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            boolean r4 = r2.D()
            if (r4 == 0) goto L_0x025b
            boolean r4 = r2 instanceof androidx.constraintlayout.core.widgets.e
            if (r4 != 0) goto L_0x025b
            boolean r4 = r2 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 != 0) goto L_0x025b
            boolean r4 = r2 instanceof androidx.constraintlayout.core.widgets.h
            if (r4 != 0) goto L_0x025b
            boolean r4 = r2.f1390j
            if (r4 != 0) goto L_0x025b
            r4 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r6 = r2.n(r4)
            r4 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r7 = r2.n(r4)
            if (r6 != r9) goto L_0x024e
            int r6 = r2.f1381f
            if (r6 == r4) goto L_0x024e
            if (r7 != r9) goto L_0x024e
            int r6 = r2.f1384g
            if (r6 == r4) goto L_0x024e
            r4 = 1
            goto L_0x024f
        L_0x024e:
            r4 = 0
        L_0x024f:
            if (r4 != 0) goto L_0x025b
            D2$a r4 = new D2$a
            r4.<init>()
            D2$b r6 = r1.f1393a
            Y(r2, r6, r4)
        L_0x025b:
            int r0 = r0 + 1
            goto L_0x0216
        L_0x025e:
            r21 = r0
            r18 = r4
            r23 = r7
            r22 = r13
        L_0x0266:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            r4 = 2
            ei r6 = r1.f1396a
            if (r3 <= r4) goto L_0x0690
            r8 = r23
            if (r5 == r2) goto L_0x0273
            if (r8 != r2) goto L_0x067f
        L_0x0273:
            int r0 = r1.G
            r11 = 1024(0x400, float:1.435E-42)
            boolean r0 = androidx.constraintlayout.core.widgets.f.b(r0, r11)
            if (r0 == 0) goto L_0x067f
            D2$b r0 = r1.f1393a
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r11 = r1.b
            int r13 = r11.size()
            r14 = 0
        L_0x0286:
            if (r14 >= r13) goto L_0x02bf
            java.lang.Object r15 = r11.get(r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r15
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r4 = r1.f1358a
            r17 = 0
            r7 = r4[r17]
            r16 = 1
            r4 = r4[r16]
            r23 = r12
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r12 = r15.f1358a
            r24 = r3
            r3 = r12[r17]
            r12 = r12[r16]
            boolean r3 = defpackage.C0096He.b(r7, r4, r3, r12)
            if (r3 != 0) goto L_0x02a9
            goto L_0x02ad
        L_0x02a9:
            boolean r3 = r15 instanceof androidx.constraintlayout.core.widgets.d
            if (r3 == 0) goto L_0x02b7
        L_0x02ad:
            r4 = r2
            r26 = r5
            r27 = r8
            r2 = r10
            r0 = 0
            r8 = r6
            goto L_0x0636
        L_0x02b7:
            int r14 = r14 + 1
            r12 = r23
            r3 = r24
            r4 = 2
            goto L_0x0286
        L_0x02bf:
            r24 = r3
            r23 = r12
            r3 = 0
            r4 = 0
            r7 = 0
            r12 = 0
            r14 = 0
            r15 = 0
            r25 = 0
        L_0x02cb:
            if (r3 >= r13) goto L_0x03b4
            java.lang.Object r26 = r11.get(r3)
            r27 = r8
            r8 = r26
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r8
            r26 = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r5 = r1.f1358a
            r28 = r10
            r17 = 0
            r10 = r5[r17]
            r16 = 1
            r5 = r5[r16]
            r29 = r6
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r6 = r8.f1358a
            r30 = r2
            r2 = r6[r17]
            r6 = r6[r16]
            boolean r2 = defpackage.C0096He.b(r10, r5, r2, r6)
            if (r2 != 0) goto L_0x02fa
            D2$a r2 = r1.a
            Y(r8, r0, r2)
        L_0x02fa:
            boolean r2 = r8 instanceof androidx.constraintlayout.core.widgets.e
            if (r2 == 0) goto L_0x031f
            r5 = r8
            androidx.constraintlayout.core.widgets.e r5 = (androidx.constraintlayout.core.widgets.e) r5
            int r6 = r5.D
            if (r6 != 0) goto L_0x0310
            if (r12 != 0) goto L_0x030d
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r12 = r6
        L_0x030d:
            r12.add(r5)
        L_0x0310:
            int r6 = r5.D
            r10 = 1
            if (r6 != r10) goto L_0x031f
            if (r4 != 0) goto L_0x031c
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x031c:
            r4.add(r5)
        L_0x031f:
            boolean r5 = r8 instanceof defpackage.Te
            if (r5 == 0) goto L_0x0364
            boolean r5 = r8 instanceof androidx.constraintlayout.core.widgets.a
            if (r5 == 0) goto L_0x034d
            r5 = r8
            androidx.constraintlayout.core.widgets.a r5 = (androidx.constraintlayout.core.widgets.a) r5
            int r6 = r5.W()
            if (r6 != 0) goto L_0x033b
            if (r7 != 0) goto L_0x0338
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r7 = r6
        L_0x0338:
            r7.add(r5)
        L_0x033b:
            int r6 = r5.W()
            r10 = 1
            if (r6 != r10) goto L_0x0364
            if (r14 != 0) goto L_0x0349
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x0349:
            r14.add(r5)
            goto L_0x0364
        L_0x034d:
            r5 = r8
            Te r5 = (defpackage.Te) r5
            if (r7 != 0) goto L_0x0357
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
        L_0x0357:
            r7.add(r5)
            if (r14 != 0) goto L_0x0361
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
        L_0x0361:
            r14.add(r5)
        L_0x0364:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1339a
            if (r5 != 0) goto L_0x0380
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1339a
            if (r5 != 0) goto L_0x0380
            if (r2 != 0) goto L_0x0380
            boolean r5 = r8 instanceof androidx.constraintlayout.core.widgets.a
            if (r5 != 0) goto L_0x0380
            if (r15 != 0) goto L_0x037d
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
        L_0x037d:
            r15.add(r8)
        L_0x0380:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1339a
            if (r5 != 0) goto L_0x03a6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1376d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1339a
            if (r5 != 0) goto L_0x03a6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1379e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1339a
            if (r5 != 0) goto L_0x03a6
            if (r2 != 0) goto L_0x03a6
            boolean r2 = r8 instanceof androidx.constraintlayout.core.widgets.a
            if (r2 != 0) goto L_0x03a6
            if (r25 != 0) goto L_0x039f
            java.util.ArrayList r25 = new java.util.ArrayList
            r25.<init>()
        L_0x039f:
            r2 = r25
            r2.add(r8)
            r25 = r2
        L_0x03a6:
            int r3 = r3 + 1
            r5 = r26
            r8 = r27
            r10 = r28
            r6 = r29
            r2 = r30
            goto L_0x02cb
        L_0x03b4:
            r30 = r2
            r26 = r5
            r29 = r6
            r27 = r8
            r28 = r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r4 == 0) goto L_0x03db
            java.util.Iterator r2 = r4.iterator()
        L_0x03c9:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03db
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.e r3 = (androidx.constraintlayout.core.widgets.e) r3
            r4 = 0
            r5 = 0
            defpackage.C0096He.a(r3, r5, r0, r4)
            goto L_0x03c9
        L_0x03db:
            r4 = 0
            r5 = 0
            if (r7 == 0) goto L_0x03fc
            java.util.Iterator r2 = r7.iterator()
        L_0x03e3:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x03fc
            java.lang.Object r3 = r2.next()
            Te r3 = (defpackage.Te) r3
            BD r6 = defpackage.C0096He.a(r3, r5, r0, r4)
            r3.U(r5, r6, r0)
            r6.a(r0)
            r4 = 0
            r5 = 0
            goto L_0x03e3
        L_0x03fc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.m(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.f1341a
            if (r2 == 0) goto L_0x041e
            java.util.Iterator r2 = r2.iterator()
        L_0x040a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x041e
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.f1340a
            r4 = 0
            r5 = 0
            defpackage.C0096He.a(r3, r5, r0, r4)
            goto L_0x040a
        L_0x041e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.m(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.f1341a
            if (r2 == 0) goto L_0x0440
            java.util.Iterator r2 = r2.iterator()
        L_0x042c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0440
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.f1340a
            r4 = 0
            r5 = 0
            defpackage.C0096He.a(r3, r5, r0, r4)
            goto L_0x042c
        L_0x0440:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r2 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.m(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r3.f1341a
            if (r3 == 0) goto L_0x0462
            java.util.Iterator r3 = r3.iterator()
        L_0x044e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0462
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f1340a
            r5 = 0
            r6 = 0
            defpackage.C0096He.a(r4, r6, r0, r5)
            goto L_0x044e
        L_0x0462:
            r5 = 0
            r6 = 0
            if (r15 == 0) goto L_0x047a
            java.util.Iterator r3 = r15.iterator()
        L_0x046a:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x047a
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r4
            defpackage.C0096He.a(r4, r6, r0, r5)
            goto L_0x046a
        L_0x047a:
            if (r12 == 0) goto L_0x0491
            java.util.Iterator r3 = r12.iterator()
        L_0x0480:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0491
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.e r4 = (androidx.constraintlayout.core.widgets.e) r4
            r6 = 1
            defpackage.C0096He.a(r4, r6, r0, r5)
            goto L_0x0480
        L_0x0491:
            r6 = 1
            if (r14 == 0) goto L_0x04b1
            java.util.Iterator r3 = r14.iterator()
        L_0x0498:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b1
            java.lang.Object r4 = r3.next()
            Te r4 = (defpackage.Te) r4
            BD r7 = defpackage.C0096He.a(r4, r6, r0, r5)
            r4.U(r6, r7, r0)
            r7.a(r0)
            r5 = 0
            r6 = 1
            goto L_0x0498
        L_0x04b1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.m(r3)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r3.f1341a
            if (r3 == 0) goto L_0x04d3
            java.util.Iterator r3 = r3.iterator()
        L_0x04bf:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04d3
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f1340a
            r5 = 0
            r6 = 1
            defpackage.C0096He.a(r4, r6, r0, r5)
            goto L_0x04bf
        L_0x04d3:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.m(r3)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r3.f1341a
            if (r3 == 0) goto L_0x04f5
            java.util.Iterator r3 = r3.iterator()
        L_0x04e1:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04f5
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f1340a
            r5 = 0
            r6 = 1
            defpackage.C0096He.a(r4, r6, r0, r5)
            goto L_0x04e1
        L_0x04f5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.m(r3)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r3.f1341a
            if (r3 == 0) goto L_0x0517
            java.util.Iterator r3 = r3.iterator()
        L_0x0503:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0517
            java.lang.Object r4 = r3.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f1340a
            r5 = 0
            r6 = 1
            defpackage.C0096He.a(r4, r6, r0, r5)
            goto L_0x0503
        L_0x0517:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.m(r2)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r2 = r2.f1341a
            if (r2 == 0) goto L_0x0537
            java.util.Iterator r2 = r2.iterator()
        L_0x0523:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0537
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.f1340a
            r4 = 0
            r5 = 1
            defpackage.C0096He.a(r3, r5, r0, r4)
            goto L_0x0523
        L_0x0537:
            r4 = 0
            r5 = 1
            if (r25 == 0) goto L_0x054f
            java.util.Iterator r2 = r25.iterator()
        L_0x053f:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x054f
            java.lang.Object r3 = r2.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r3
            defpackage.C0096He.a(r3, r5, r0, r4)
            goto L_0x053f
        L_0x054f:
            r2 = 0
        L_0x0550:
            if (r2 >= r13) goto L_0x05aa
            java.lang.Object r3 = r11.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r3
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r4 = r3.f1358a
            r6 = 0
            r7 = r4[r6]
            if (r7 != r9) goto L_0x0565
            r4 = r4[r5]
            if (r4 != r9) goto L_0x0565
            r4 = 1
            goto L_0x0566
        L_0x0565:
            r4 = 0
        L_0x0566:
            if (r4 == 0) goto L_0x05a6
            int r4 = r3.z
            int r5 = r0.size()
            r6 = 0
        L_0x056f:
            if (r6 >= r5) goto L_0x057f
            java.lang.Object r7 = r0.get(r6)
            BD r7 = (defpackage.BD) r7
            int r8 = r7.a
            if (r4 != r8) goto L_0x057c
            goto L_0x0580
        L_0x057c:
            int r6 = r6 + 1
            goto L_0x056f
        L_0x057f:
            r7 = 0
        L_0x0580:
            int r3 = r3.A
            int r4 = r0.size()
            r5 = 0
        L_0x0587:
            if (r5 >= r4) goto L_0x0597
            java.lang.Object r6 = r0.get(r5)
            BD r6 = (defpackage.BD) r6
            int r8 = r6.a
            if (r3 != r8) goto L_0x0594
            goto L_0x0598
        L_0x0594:
            int r5 = r5 + 1
            goto L_0x0587
        L_0x0597:
            r6 = 0
        L_0x0598:
            if (r7 == 0) goto L_0x05a6
            if (r6 == 0) goto L_0x05a6
            r3 = 0
            r7.c(r3, r6)
            r3 = 2
            r6.b = r3
            r0.remove(r7)
        L_0x05a6:
            int r2 = r2 + 1
            r5 = 1
            goto L_0x0550
        L_0x05aa:
            int r2 = r0.size()
            r3 = 1
            if (r2 > r3) goto L_0x05b9
            r2 = r28
            r8 = r29
            r4 = r30
            goto L_0x0633
        L_0x05b9:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r2 = r1.f1358a
            r3 = 0
            r2 = r2[r3]
            r4 = r30
            if (r2 != r4) goto L_0x05f7
            java.util.Iterator r2 = r0.iterator()
            r5 = r3
            r6 = 0
        L_0x05c8:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x05ea
            java.lang.Object r7 = r2.next()
            BD r7 = (defpackage.BD) r7
            int r8 = r7.b
            r9 = 1
            if (r8 != r9) goto L_0x05dc
            r8 = r29
            goto L_0x05e6
        L_0x05dc:
            r8 = r29
            int r9 = r7.b(r8, r3)
            if (r9 <= r5) goto L_0x05e6
            r6 = r7
            r5 = r9
        L_0x05e6:
            r29 = r8
            r3 = 0
            goto L_0x05c8
        L_0x05ea:
            r8 = r29
            r2 = r28
            if (r6 == 0) goto L_0x05fb
            r1.P(r2)
            r1.R(r5)
            goto L_0x05fc
        L_0x05f7:
            r2 = r28
            r8 = r29
        L_0x05fb:
            r6 = 0
        L_0x05fc:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r3 = r1.f1358a
            r5 = 1
            r3 = r3[r5]
            if (r3 != r4) goto L_0x062d
            java.util.Iterator r0 = r0.iterator()
            r3 = 0
            r7 = 0
        L_0x0609:
            boolean r9 = r0.hasNext()
            if (r9 == 0) goto L_0x0624
            java.lang.Object r9 = r0.next()
            BD r9 = (defpackage.BD) r9
            int r10 = r9.b
            if (r10 != 0) goto L_0x061a
            goto L_0x0622
        L_0x061a:
            int r10 = r9.b(r8, r5)
            if (r10 <= r3) goto L_0x0622
            r7 = r9
            r3 = r10
        L_0x0622:
            r5 = 1
            goto L_0x0609
        L_0x0624:
            if (r7 == 0) goto L_0x062d
            r1.Q(r2)
            r1.O(r3)
            goto L_0x062e
        L_0x062d:
            r7 = 0
        L_0x062e:
            if (r6 != 0) goto L_0x0635
            if (r7 == 0) goto L_0x0633
            goto L_0x0635
        L_0x0633:
            r0 = 0
            goto L_0x0636
        L_0x0635:
            r0 = 1
        L_0x0636:
            if (r0 == 0) goto L_0x0676
            r3 = r26
            if (r3 != r4) goto L_0x0652
            int r0 = r32.u()
            r5 = r21
            if (r5 >= r0) goto L_0x064d
            if (r5 <= 0) goto L_0x064d
            r1.R(r5)
            r6 = 1
            r1.m = r6
            goto L_0x0654
        L_0x064d:
            int r0 = r32.u()
            goto L_0x0655
        L_0x0652:
            r5 = r21
        L_0x0654:
            r0 = r5
        L_0x0655:
            r6 = r27
            if (r6 != r4) goto L_0x066f
            int r5 = r32.o()
            r7 = r18
            if (r7 >= r5) goto L_0x066a
            if (r7 <= 0) goto L_0x066a
            r1.O(r7)
            r5 = 1
            r1.n = r5
            goto L_0x0671
        L_0x066a:
            int r5 = r32.o()
            goto L_0x0672
        L_0x066f:
            r7 = r18
        L_0x0671:
            r5 = r7
        L_0x0672:
            r7 = r5
            r5 = r0
            r0 = 1
            goto L_0x069f
        L_0x0676:
            r7 = r18
            r5 = r21
            r3 = r26
            r6 = r27
            goto L_0x069e
        L_0x067f:
            r4 = r2
            r24 = r3
            r3 = r5
            r2 = r10
            r23 = r12
            r7 = r18
            r5 = r21
            r31 = r8
            r8 = r6
            r6 = r31
            goto L_0x069e
        L_0x0690:
            r4 = r2
            r24 = r3
            r3 = r5
            r8 = r6
            r2 = r10
            r7 = r18
            r5 = r21
            r6 = r23
            r23 = r12
        L_0x069e:
            r0 = 0
        L_0x069f:
            r9 = 64
            boolean r10 = r1.Z(r9)
            if (r10 != 0) goto L_0x06b2
            r10 = 128(0x80, float:1.794E-43)
            boolean r10 = r1.Z(r10)
            if (r10 == 0) goto L_0x06b0
            goto L_0x06b2
        L_0x06b0:
            r10 = 0
            goto L_0x06b3
        L_0x06b2:
            r10 = 1
        L_0x06b3:
            r8.getClass()
            r11 = 0
            r8.f2896b = r11
            int r12 = r1.G
            if (r12 == 0) goto L_0x06c3
            if (r10 == 0) goto L_0x06c3
            r10 = 1
            r8.f2896b = r10
            goto L_0x06c4
        L_0x06c3:
            r10 = 1
        L_0x06c4:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r12 = r1.b
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r13 = r1.f1358a
            r14 = r13[r11]
            if (r14 == r4) goto L_0x06d3
            r13 = r13[r10]
            if (r13 != r4) goto L_0x06d1
            goto L_0x06d3
        L_0x06d1:
            r10 = r11
            goto L_0x06d4
        L_0x06d3:
            r10 = 1
        L_0x06d4:
            r1.E = r11
            r1.F = r11
            r13 = r24
            r11 = 0
        L_0x06db:
            if (r11 >= r13) goto L_0x06f1
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.b
            java.lang.Object r14 = r14.get(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            boolean r15 = r14 instanceof defpackage.AD
            if (r15 == 0) goto L_0x06ee
            AD r14 = (defpackage.AD) r14
            r14.U()
        L_0x06ee:
            int r11 = r11 + 1
            goto L_0x06db
        L_0x06f1:
            boolean r11 = r1.Z(r9)
            r14 = r0
            r0 = 0
            r15 = 1
        L_0x06f8:
            if (r15 == 0) goto L_0x096d
            r16 = 1
            int r9 = r0 + 1
            r8.s()     // Catch:{ Exception -> 0x07f6 }
            r21 = r15
            r15 = 0
            r1.E = r15     // Catch:{ Exception -> 0x07ed }
            r1.F = r15     // Catch:{ Exception -> 0x07ed }
            r1.k(r8)     // Catch:{ Exception -> 0x07ed }
            r0 = 0
        L_0x070c:
            if (r0 >= r13) goto L_0x071c
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r15 = r1.b     // Catch:{ Exception -> 0x07ed }
            java.lang.Object r15 = r15.get(r0)     // Catch:{ Exception -> 0x07ed }
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r15     // Catch:{ Exception -> 0x07ed }
            r15.k(r8)     // Catch:{ Exception -> 0x07ed }
            int r0 = r0 + 1
            goto L_0x070c
        L_0x071c:
            r1.W(r8)     // Catch:{ Exception -> 0x07ed }
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f1397a     // Catch:{ Exception -> 0x07e2 }
            if (r0 == 0) goto L_0x075a
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0752 }
            if (r0 == 0) goto L_0x075a
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.f1397a     // Catch:{ Exception -> 0x0752 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0752 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x0752 }
            r15 = r23
            r23 = r14
            yx r14 = r8.k(r15)     // Catch:{ Exception -> 0x074c }
            yx r0 = r8.k(r0)     // Catch:{ Exception -> 0x074c }
            r25 = r12
            r24 = r15
            r12 = 0
            r15 = 5
            r8.f(r0, r14, r12, r15)     // Catch:{ Exception -> 0x07d7 }
            r12 = 0
            r1.f1397a = r12     // Catch:{ Exception -> 0x074a }
            goto L_0x0760
        L_0x074a:
            r0 = move-exception
            goto L_0x0785
        L_0x074c:
            r0 = move-exception
            r25 = r12
            r24 = r15
            goto L_0x0785
        L_0x0752:
            r0 = move-exception
            r25 = r12
            r24 = r23
            r23 = r14
            goto L_0x0785
        L_0x075a:
            r25 = r12
            r24 = r23
            r23 = r14
        L_0x0760:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.c     // Catch:{ Exception -> 0x07d7 }
            if (r0 == 0) goto L_0x0787
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x07d7 }
            if (r0 == 0) goto L_0x0787
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.c     // Catch:{ Exception -> 0x07d7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x07d7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x07d7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r1.f1376d     // Catch:{ Exception -> 0x07d7 }
            yx r12 = r8.k(r12)     // Catch:{ Exception -> 0x07d7 }
            yx r0 = r8.k(r0)     // Catch:{ Exception -> 0x07d7 }
            r14 = 5
            r15 = 0
            r8.f(r12, r0, r15, r14)     // Catch:{ Exception -> 0x07d7 }
            r12 = 0
            r1.c = r12     // Catch:{ Exception -> 0x074a }
            goto L_0x0787
        L_0x0785:
            r12 = 0
            goto L_0x07ea
        L_0x0787:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.b     // Catch:{ Exception -> 0x07d7 }
            if (r0 == 0) goto L_0x07b2
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x07d7 }
            if (r0 == 0) goto L_0x07b2
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.b     // Catch:{ Exception -> 0x07d7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x07d7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x07d7 }
            r12 = r22
            yx r14 = r8.k(r12)     // Catch:{ Exception -> 0x07ae }
            yx r0 = r8.k(r0)     // Catch:{ Exception -> 0x07ae }
            r22 = r12
            r12 = 0
            r15 = 5
            r8.f(r0, r14, r12, r15)     // Catch:{ Exception -> 0x07d7 }
            r12 = 0
            r1.b = r12     // Catch:{ Exception -> 0x07e0 }
            goto L_0x07b2
        L_0x07ae:
            r0 = move-exception
            r22 = r12
            goto L_0x0785
        L_0x07b2:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.d     // Catch:{ Exception -> 0x07d7 }
            if (r0 == 0) goto L_0x07d9
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x07d7 }
            if (r0 == 0) goto L_0x07d9
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r0 = r1.d     // Catch:{ Exception -> 0x07d7 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x07d7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r0     // Catch:{ Exception -> 0x07d7 }
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r1.f1371c     // Catch:{ Exception -> 0x07d7 }
            yx r12 = r8.k(r12)     // Catch:{ Exception -> 0x07d7 }
            yx r0 = r8.k(r0)     // Catch:{ Exception -> 0x07d7 }
            r14 = 5
            r15 = 0
            r8.f(r12, r0, r15, r14)     // Catch:{ Exception -> 0x07d7 }
            r12 = 0
            r1.d = r12     // Catch:{ Exception -> 0x07e0 }
            goto L_0x07da
        L_0x07d7:
            r0 = move-exception
            goto L_0x0785
        L_0x07d9:
            r12 = 0
        L_0x07da:
            r8.p()     // Catch:{ Exception -> 0x07e0 }
            r21 = 1
            goto L_0x0812
        L_0x07e0:
            r0 = move-exception
            goto L_0x07ea
        L_0x07e2:
            r0 = move-exception
            r25 = r12
            r24 = r23
            r12 = 0
            r23 = r14
        L_0x07ea:
            r21 = 1
            goto L_0x07fc
        L_0x07ed:
            r0 = move-exception
            r25 = r12
        L_0x07f0:
            r24 = r23
            r12 = 0
            r23 = r14
            goto L_0x07fc
        L_0x07f6:
            r0 = move-exception
            r25 = r12
            r21 = r15
            goto L_0x07f0
        L_0x07fc:
            r0.printStackTrace()
            java.io.PrintStream r14 = java.lang.System.out
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r12 = "EXCEPTION : "
            r15.<init>(r12)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            r14.println(r0)
        L_0x0812:
            boolean[] r0 = androidx.constraintlayout.core.widgets.f.a
            if (r21 == 0) goto L_0x085d
            r12 = 2
            r14 = 0
            r0[r12] = r14
            r12 = 64
            boolean r14 = r1.Z(r12)
            r1.T(r8, r14)
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r15 = r1.b
            int r15 = r15.size()
            r12 = 0
            r18 = 0
        L_0x082c:
            if (r12 >= r15) goto L_0x0859
            r26 = r15
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r15 = r1.b
            java.lang.Object r15 = r15.get(r12)
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r15
            r15.T(r8, r14)
            r27 = r14
            int r14 = r15.f1345a
            r28 = r7
            r7 = -1
            if (r14 != r7) goto L_0x084b
            int r14 = r15.f1361b
            if (r14 == r7) goto L_0x0849
            goto L_0x084b
        L_0x0849:
            r14 = 0
            goto L_0x084c
        L_0x084b:
            r14 = 1
        L_0x084c:
            if (r14 == 0) goto L_0x0850
            r18 = 1
        L_0x0850:
            int r12 = r12 + 1
            r15 = r26
            r14 = r27
            r7 = r28
            goto L_0x082c
        L_0x0859:
            r28 = r7
            r7 = -1
            goto L_0x0876
        L_0x085d:
            r28 = r7
            r7 = -1
            r1.T(r8, r11)
            r12 = 0
        L_0x0864:
            if (r12 >= r13) goto L_0x0874
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.b
            java.lang.Object r14 = r14.get(r12)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            r14.T(r8, r11)
            int r12 = r12 + 1
            goto L_0x0864
        L_0x0874:
            r18 = 0
        L_0x0876:
            r12 = 8
            if (r10 == 0) goto L_0x08df
            if (r9 >= r12) goto L_0x08df
            r14 = 2
            boolean r0 = r0[r14]
            if (r0 == 0) goto L_0x08df
            r0 = 0
            r7 = 0
            r15 = 0
        L_0x0884:
            if (r0 >= r13) goto L_0x08ab
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r14 = r1.b
            java.lang.Object r14 = r14.get(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            int r12 = r14.r
            int r27 = r14.u()
            int r12 = r27 + r12
            int r15 = java.lang.Math.max(r15, r12)
            int r12 = r14.s
            int r14 = r14.o()
            int r14 = r14 + r12
            int r7 = java.lang.Math.max(r7, r14)
            int r0 = r0 + 1
            r12 = 8
            r14 = 2
            goto L_0x0884
        L_0x08ab:
            int r0 = r1.u
            int r0 = java.lang.Math.max(r0, r15)
            int r12 = r1.v
            int r7 = java.lang.Math.max(r12, r7)
            if (r3 != r4) goto L_0x08cb
            int r12 = r32.u()
            if (r12 >= r0) goto L_0x08cb
            r1.R(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r12 = 0
            r0[r12] = r4
            r18 = 1
            r23 = 1
        L_0x08cb:
            if (r6 != r4) goto L_0x08df
            int r0 = r32.o()
            if (r0 >= r7) goto L_0x08df
            r1.O(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r7 = 1
            r0[r7] = r4
            r18 = 1
            r23 = 1
        L_0x08df:
            int r0 = r1.u
            int r7 = r32.u()
            int r0 = java.lang.Math.max(r0, r7)
            int r7 = r32.u()
            if (r0 <= r7) goto L_0x08fb
            r1.R(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r7 = 0
            r0[r7] = r2
            r18 = 1
            r23 = 1
        L_0x08fb:
            int r0 = r1.v
            int r7 = r32.o()
            int r0 = java.lang.Math.max(r0, r7)
            int r7 = r32.o()
            if (r0 <= r7) goto L_0x0918
            r1.O(r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r7 = 1
            r0[r7] = r2
            r18 = r7
            r23 = r18
            goto L_0x0919
        L_0x0918:
            r7 = 1
        L_0x0919:
            if (r23 != 0) goto L_0x0956
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r12 = 0
            r0 = r0[r12]
            if (r0 != r4) goto L_0x0937
            if (r5 <= 0) goto L_0x0937
            int r0 = r32.u()
            if (r0 <= r5) goto L_0x0937
            r1.m = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r0[r12] = r2
            r1.R(r5)
            r18 = r7
            r23 = r18
        L_0x0937:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r0 = r0[r7]
            if (r0 != r4) goto L_0x0956
            if (r28 <= 0) goto L_0x0956
            int r0 = r32.o()
            r12 = r28
            if (r0 <= r12) goto L_0x0958
            r1.n = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r0[r7] = r2
            r1.O(r12)
            r0 = 8
            r14 = 1
            r18 = 1
            goto L_0x095d
        L_0x0956:
            r12 = r28
        L_0x0958:
            r7 = r23
            r14 = r7
            r0 = 8
        L_0x095d:
            if (r9 <= r0) goto L_0x0961
            r15 = 0
            goto L_0x0963
        L_0x0961:
            r15 = r18
        L_0x0963:
            r0 = r9
            r7 = r12
            r23 = r24
            r12 = r25
            r9 = 64
            goto L_0x06f8
        L_0x096d:
            r7 = r12
            r23 = r14
            r1.b = r7
            if (r23 == 0) goto L_0x097c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r1.f1358a
            r2 = 0
            r0[r2] = r3
            r2 = 1
            r0[r2] = r6
        L_0x097c:
            y3 r0 = r8.f2891a
            r1.J(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.U():void");
    }

    public final void V(int i, ConstraintWidget constraintWidget) {
        if (i == 0) {
            int i2 = this.E + 1;
            c[] cVarArr = this.f1400b;
            if (i2 >= cVarArr.length) {
                this.f1400b = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
            }
            c[] cVarArr2 = this.f1400b;
            int i3 = this.E;
            cVarArr2[i3] = new c(constraintWidget, 0, this.l);
            this.E = i3 + 1;
        } else if (i == 1) {
            int i4 = this.F + 1;
            c[] cVarArr3 = this.f1399a;
            if (i4 >= cVarArr3.length) {
                this.f1399a = (c[]) Arrays.copyOf(cVarArr3, cVarArr3.length * 2);
            }
            c[] cVarArr4 = this.f1399a;
            int i5 = this.F;
            cVarArr4[i5] = new c(constraintWidget, 1, this.l);
            this.F = i5 + 1;
        }
    }

    public final void W(ei eiVar) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean Z = Z(64);
        e(eiVar, Z);
        int size = this.b.size();
        boolean z5 = false;
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.b.get(i2);
            boolean[] zArr = constraintWidget.f1369b;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof a) {
                z5 = true;
            }
        }
        if (z5) {
            for (int i3 = 0; i3 < size; i3++) {
                ConstraintWidget constraintWidget2 = this.b.get(i3);
                if (constraintWidget2 instanceof a) {
                    a aVar = (a) constraintWidget2;
                    for (int i4 = 0; i4 < aVar.B; i4++) {
                        ConstraintWidget constraintWidget3 = aVar.c[i4];
                        if (aVar.l || constraintWidget3.f()) {
                            int i5 = aVar.C;
                            if (i5 == 0 || i5 == 1) {
                                constraintWidget3.f1369b[0] = true;
                            } else if (i5 == 2 || i5 == 3) {
                                constraintWidget3.f1369b[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet<ConstraintWidget> hashSet = this.f1398a;
        hashSet.clear();
        for (int i6 = 0; i6 < size; i6++) {
            ConstraintWidget constraintWidget4 = this.b.get(i6);
            constraintWidget4.getClass();
            if ((constraintWidget4 instanceof h) || (constraintWidget4 instanceof e)) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                if (constraintWidget4 instanceof h) {
                    hashSet.add(constraintWidget4);
                } else {
                    constraintWidget4.e(eiVar, Z);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator<ConstraintWidget> it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h hVar = (h) it.next();
                int i7 = 0;
                while (true) {
                    if (i7 >= hVar.B) {
                        z3 = false;
                        continue;
                        break;
                    } else if (hashSet.contains(hVar.c[i7])) {
                        z3 = true;
                        continue;
                        break;
                    } else {
                        i7++;
                    }
                }
                if (z3) {
                    hVar.e(eiVar, Z);
                    hashSet.remove(hVar);
                    break;
                }
            }
            if (size2 == hashSet.size()) {
                Iterator<ConstraintWidget> it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    it2.next().e(eiVar, Z);
                }
                hashSet.clear();
            }
        }
        boolean z6 = ei.c;
        ConstraintWidget.a aVar2 = ConstraintWidget.a.WRAP_CONTENT;
        if (z6) {
            HashSet hashSet2 = new HashSet();
            for (int i8 = 0; i8 < size; i8++) {
                ConstraintWidget constraintWidget5 = this.b.get(i8);
                constraintWidget5.getClass();
                if ((constraintWidget5 instanceof h) || (constraintWidget5 instanceof e)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    hashSet2.add(constraintWidget5);
                }
            }
            if (this.f1358a[0] == aVar2) {
                i = 0;
            } else {
                i = 1;
            }
            d(this, eiVar, hashSet2, i, false);
            Iterator it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget6 = (ConstraintWidget) it3.next();
                f.a(this, eiVar, constraintWidget6);
                constraintWidget6.e(eiVar, Z);
            }
        } else {
            for (int i9 = 0; i9 < size; i9++) {
                ConstraintWidget constraintWidget7 = this.b.get(i9);
                if (constraintWidget7 instanceof ConstraintWidgetContainer) {
                    ConstraintWidget.a[] aVarArr = constraintWidget7.f1358a;
                    ConstraintWidget.a aVar3 = aVarArr[0];
                    ConstraintWidget.a aVar4 = aVarArr[1];
                    ConstraintWidget.a aVar5 = ConstraintWidget.a.FIXED;
                    if (aVar3 == aVar2) {
                        constraintWidget7.P(aVar5);
                    }
                    if (aVar4 == aVar2) {
                        constraintWidget7.Q(aVar5);
                    }
                    constraintWidget7.e(eiVar, Z);
                    if (aVar3 == aVar2) {
                        constraintWidget7.P(aVar3);
                    }
                    if (aVar4 == aVar2) {
                        constraintWidget7.Q(aVar4);
                    }
                } else {
                    f.a(this, eiVar, constraintWidget7);
                    if ((constraintWidget7 instanceof h) || (constraintWidget7 instanceof e)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        constraintWidget7.e(eiVar, Z);
                    }
                }
            }
        }
        if (this.E > 0) {
            b.a(this, eiVar, (ArrayList<ConstraintWidget>) null, 0);
        }
        if (this.F > 0) {
            b.a(this, eiVar, (ArrayList<ConstraintWidget>) null, 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean X(int r17, boolean r18) {
        /*
            r16 = this;
            r0 = r17
            r1 = 1
            r2 = r18 & 1
            r3 = r16
            M8 r4 = r3.f1395a
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = r4.f396a
            r6 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r7 = r5.n(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r8 = r5.n(r1)
            int r9 = r5.v()
            int r10 = r5.w()
            java.util.ArrayList<CD> r11 = r4.f397a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.FIXED
            if (r2 == 0) goto L_0x007c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            if (r7 == r13) goto L_0x0028
            if (r8 != r13) goto L_0x007c
        L_0x0028:
            java.util.Iterator r14 = r11.iterator()
        L_0x002c:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0046
            java.lang.Object r15 = r14.next()
            CD r15 = (defpackage.CD) r15
            int r1 = r15.b
            if (r1 != r0) goto L_0x0044
            boolean r1 = r15.k()
            if (r1 != 0) goto L_0x0044
            r2 = r6
            goto L_0x0046
        L_0x0044:
            r1 = 1
            goto L_0x002c
        L_0x0046:
            if (r0 != 0) goto L_0x0062
            if (r2 == 0) goto L_0x007c
            if (r7 != r13) goto L_0x007c
            r5.P(r12)
            int r1 = r4.d(r5, r6)
            r5.R(r1)
            af r1 = r5.f1347a
            c9 r1 = r1.f82a
            int r2 = r5.u()
            r1.d(r2)
            goto L_0x007c
        L_0x0062:
            if (r2 == 0) goto L_0x007c
            if (r8 != r13) goto L_0x007c
            r5.Q(r12)
            r1 = 1
            int r2 = r4.d(r5, r1)
            r5.O(r2)
            hC r1 = r5.f1350a
            c9 r1 = r1.f82a
            int r2 = r5.o()
            r1.d(r2)
        L_0x007c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_PARENT
            if (r0 != 0) goto L_0x00a1
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r2 = r5.f1358a
            r2 = r2[r6]
            if (r2 == r12) goto L_0x008b
            if (r2 != r1) goto L_0x0089
            goto L_0x008b
        L_0x0089:
            r9 = 1
            goto L_0x00ab
        L_0x008b:
            int r1 = r5.u()
            int r1 = r1 + r9
            af r2 = r5.f1347a
            N8 r2 = r2.f85b
            r2.d(r1)
            af r2 = r5.f1347a
            c9 r2 = r2.f82a
            int r1 = r1 - r9
            r2.d(r1)
            r9 = 1
            goto L_0x00c1
        L_0x00a1:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r2 = r5.f1358a
            r9 = 1
            r2 = r2[r9]
            if (r2 == r12) goto L_0x00ad
            if (r2 != r1) goto L_0x00ab
            goto L_0x00ad
        L_0x00ab:
            r1 = r6
            goto L_0x00c2
        L_0x00ad:
            int r1 = r5.o()
            int r1 = r1 + r10
            hC r2 = r5.f1350a
            N8 r2 = r2.f85b
            r2.d(r1)
            hC r2 = r5.f1350a
            c9 r2 = r2.f82a
            int r1 = r1 - r10
            r2.d(r1)
        L_0x00c1:
            r1 = r9
        L_0x00c2:
            r4.g()
            java.util.Iterator r2 = r11.iterator()
        L_0x00c9:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00e7
            java.lang.Object r4 = r2.next()
            CD r4 = (defpackage.CD) r4
            int r10 = r4.b
            if (r10 == r0) goto L_0x00da
            goto L_0x00c9
        L_0x00da:
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r4.f81a
            if (r10 != r5) goto L_0x00e3
            boolean r10 = r4.f84a
            if (r10 != 0) goto L_0x00e3
            goto L_0x00c9
        L_0x00e3:
            r4.e()
            goto L_0x00c9
        L_0x00e7:
            java.util.Iterator r2 = r11.iterator()
        L_0x00eb:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x011d
            java.lang.Object r4 = r2.next()
            CD r4 = (defpackage.CD) r4
            int r10 = r4.b
            if (r10 == r0) goto L_0x00fc
            goto L_0x00eb
        L_0x00fc:
            if (r1 != 0) goto L_0x0103
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r4.f81a
            if (r10 != r5) goto L_0x0103
            goto L_0x00eb
        L_0x0103:
            N8 r10 = r4.f79a
            boolean r10 = r10.f436c
            if (r10 != 0) goto L_0x010a
            goto L_0x011b
        L_0x010a:
            N8 r10 = r4.f85b
            boolean r10 = r10.f436c
            if (r10 != 0) goto L_0x0111
            goto L_0x011b
        L_0x0111:
            boolean r10 = r4 instanceof defpackage.M4
            if (r10 != 0) goto L_0x00eb
            c9 r4 = r4.f82a
            boolean r4 = r4.f436c
            if (r4 != 0) goto L_0x00eb
        L_0x011b:
            r1 = r6
            goto L_0x011e
        L_0x011d:
            r1 = r9
        L_0x011e:
            r5.P(r7)
            r5.Q(r8)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidgetContainer.X(int, boolean):boolean");
    }

    public final boolean Z(int i) {
        if ((this.G & i) == i) {
            return true;
        }
        return false;
    }

    public final void r(StringBuilder sb) {
        sb.append(this.f1352a + ":{\n");
        StringBuilder sb2 = new StringBuilder("  actualWidth:");
        sb2.append(this.o);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("  actualHeight:" + this.p);
        sb.append("\n");
        Iterator<ConstraintWidget> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().r(sb);
            sb.append(",\n");
        }
        sb.append("}");
    }
}
