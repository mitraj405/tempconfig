package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Flow */
public final class d extends h {
    public int K = -1;
    public int L = -1;
    public int M = -1;
    public int N = -1;
    public int O = -1;
    public int P = -1;
    public int Q = 0;
    public int R = 0;
    public int S = 2;
    public int T = 2;
    public int U = 0;
    public int V = -1;
    public int W = 0;
    public int X = 0;
    public final ArrayList<a> b = new ArrayList<>();
    public int[] c = null;
    public ConstraintWidget[] d = null;
    public ConstraintWidget[] e = null;
    public ConstraintWidget[] f;
    public float h = 0.5f;
    public float i = 0.5f;
    public float j = 0.5f;
    public float k = 0.5f;
    public float l = 0.5f;
    public float m = 0.5f;

    /* compiled from: Flow */
    public class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public ConstraintAnchor f1411a;

        /* renamed from: a  reason: collision with other field name */
        public ConstraintWidget f1412a = null;
        public int b = 0;

        /* renamed from: b  reason: collision with other field name */
        public ConstraintAnchor f1414b;
        public int c = 0;

        /* renamed from: c  reason: collision with other field name */
        public ConstraintAnchor f1415c;
        public int d = 0;

        /* renamed from: d  reason: collision with other field name */
        public ConstraintAnchor f1416d;
        public int e = 0;
        public int f = 0;
        public int g = 0;
        public int h = 0;
        public int i = 0;
        public int j = 0;
        public int k = 0;
        public int l = 0;

        public a(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.a = i2;
            this.f1411a = constraintAnchor;
            this.f1414b = constraintAnchor2;
            this.f1415c = constraintAnchor3;
            this.f1416d = constraintAnchor4;
            this.c = d.this.G;
            this.d = d.this.C;
            this.e = d.this.H;
            this.f = d.this.D;
            this.l = i3;
        }

        public final void a(ConstraintWidget constraintWidget) {
            int i2 = this.a;
            ConstraintWidget.a aVar = ConstraintWidget.a.MATCH_CONSTRAINT;
            int i3 = 0;
            d dVar = d.this;
            if (i2 == 0) {
                int Y = dVar.Y(this.l, constraintWidget);
                if (constraintWidget.f1358a[0] == aVar) {
                    this.k++;
                    Y = 0;
                }
                int i4 = dVar.Q;
                if (constraintWidget.w != 8) {
                    i3 = i4;
                }
                this.g = Y + i3 + this.g;
                int X = dVar.X(this.l, constraintWidget);
                if (this.f1412a == null || this.b < X) {
                    this.f1412a = constraintWidget;
                    this.b = X;
                    this.h = X;
                }
            } else {
                int Y2 = dVar.Y(this.l, constraintWidget);
                int X2 = dVar.X(this.l, constraintWidget);
                if (constraintWidget.f1358a[1] == aVar) {
                    this.k++;
                    X2 = 0;
                }
                int i5 = dVar.R;
                if (constraintWidget.w != 8) {
                    i3 = i5;
                }
                this.h = X2 + i3 + this.h;
                if (this.f1412a == null || this.b < Y2) {
                    this.f1412a = constraintWidget;
                    this.b = Y2;
                    this.g = Y2;
                }
            }
            this.j++;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0026  */
        /* JADX WARNING: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(int r21, boolean r22, boolean r23) {
            /*
                r20 = this;
                r0 = r20
                int r1 = r0.j
                r2 = 0
                r3 = r2
            L_0x0006:
                androidx.constraintlayout.core.widgets.d r4 = androidx.constraintlayout.core.widgets.d.this
                if (r3 >= r1) goto L_0x001e
                int r5 = r0.i
                int r5 = r5 + r3
                int r6 = r4.X
                if (r5 < r6) goto L_0x0012
                goto L_0x001e
            L_0x0012:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.f
                r4 = r4[r5]
                if (r4 == 0) goto L_0x001b
                r4.H()
            L_0x001b:
                int r3 = r3 + 1
                goto L_0x0006
            L_0x001e:
                if (r1 == 0) goto L_0x02d1
                androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f1412a
                if (r3 != 0) goto L_0x0026
                goto L_0x02d1
            L_0x0026:
                if (r23 == 0) goto L_0x002c
                if (r21 != 0) goto L_0x002c
                r5 = 1
                goto L_0x002d
            L_0x002c:
                r5 = r2
            L_0x002d:
                r6 = -1
                r7 = r2
                r8 = r6
                r9 = r8
            L_0x0031:
                if (r7 >= r1) goto L_0x0053
                if (r22 == 0) goto L_0x0039
                int r10 = r1 + -1
                int r10 = r10 - r7
                goto L_0x003a
            L_0x0039:
                r10 = r7
            L_0x003a:
                int r11 = r0.i
                int r11 = r11 + r10
                int r10 = r4.X
                if (r11 < r10) goto L_0x0042
                goto L_0x0053
            L_0x0042:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r10 = r4.f
                r10 = r10[r11]
                if (r10 == 0) goto L_0x0050
                int r10 = r10.w
                if (r10 != 0) goto L_0x0050
                if (r8 != r6) goto L_0x004f
                r8 = r7
            L_0x004f:
                r9 = r7
            L_0x0050:
                int r7 = r7 + 1
                goto L_0x0031
            L_0x0053:
                int r7 = r0.a
                if (r7 != 0) goto L_0x01ae
                androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r0.f1412a
                int r11 = r4.L
                r7.y = r11
                int r11 = r0.d
                if (r21 <= 0) goto L_0x0064
                int r12 = r4.R
                int r11 = r11 + r12
            L_0x0064:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f1414b
                androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r7.f1363b
                r13.a(r12, r11)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r7.f1376d
                if (r23 == 0) goto L_0x0076
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f1416d
                int r14 = r0.f
                r11.a(r12, r14)
            L_0x0076:
                if (r21 <= 0) goto L_0x0081
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f1414b
                androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r12.f1340a
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r12.f1376d
                r12.a(r13, r2)
            L_0x0081:
                int r12 = r4.T
                r14 = 3
                if (r12 != r14) goto L_0x00a8
                boolean r12 = r7.f1388h
                if (r12 != 0) goto L_0x00a8
                r12 = r2
            L_0x008b:
                if (r12 >= r1) goto L_0x00a8
                if (r22 == 0) goto L_0x0093
                int r15 = r1 + -1
                int r15 = r15 - r12
                goto L_0x0094
            L_0x0093:
                r15 = r12
            L_0x0094:
                int r10 = r0.i
                int r10 = r10 + r15
                int r15 = r4.X
                if (r10 < r15) goto L_0x009c
                goto L_0x00a8
            L_0x009c:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r15 = r4.f
                r10 = r15[r10]
                boolean r15 = r10.f1388h
                if (r15 == 0) goto L_0x00a5
                goto L_0x00a9
            L_0x00a5:
                int r12 = r12 + 1
                goto L_0x008b
            L_0x00a8:
                r10 = r7
            L_0x00a9:
                r15 = r2
                r12 = 0
            L_0x00ab:
                if (r15 >= r1) goto L_0x02d1
                if (r22 == 0) goto L_0x00b4
                int r16 = r1 + -1
                int r16 = r16 - r15
                goto L_0x00b6
            L_0x00b4:
                r16 = r15
            L_0x00b6:
                int r14 = r0.i
                int r14 = r14 + r16
                int r3 = r4.X
                if (r14 < r3) goto L_0x00c0
                goto L_0x02d1
            L_0x00c0:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r4.f
                r3 = r3[r14]
                if (r3 != 0) goto L_0x00cb
                r17 = r1
                r2 = 3
                goto L_0x01a5
            L_0x00cb:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r3.f1348a
                if (r15 != 0) goto L_0x00d6
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f1411a
                int r6 = r0.c
                r3.i(r14, r2, r6)
            L_0x00d6:
                if (r16 != 0) goto L_0x0122
                int r2 = r4.K
                r6 = 1065353216(0x3f800000, float:1.0)
                if (r22 == 0) goto L_0x00e5
                r16 = r2
                float r2 = r4.h
                float r2 = r6 - r2
                goto L_0x00e9
            L_0x00e5:
                r16 = r2
                float r2 = r4.h
            L_0x00e9:
                int r6 = r0.i
                if (r6 != 0) goto L_0x0105
                int r6 = r4.M
                r18 = r2
                r2 = -1
                if (r6 == r2) goto L_0x0107
                if (r22 == 0) goto L_0x00fd
                float r2 = r4.j
                r16 = 1065353216(0x3f800000, float:1.0)
                float r2 = r16 - r2
                goto L_0x00ff
            L_0x00fd:
                float r2 = r4.j
            L_0x00ff:
                r19 = r6
                r6 = r2
                r2 = r19
                goto L_0x011e
            L_0x0105:
                r18 = r2
            L_0x0107:
                if (r23 == 0) goto L_0x011a
                int r2 = r4.O
                r6 = -1
                if (r2 == r6) goto L_0x011a
                if (r22 == 0) goto L_0x0117
                float r6 = r4.l
                r16 = 1065353216(0x3f800000, float:1.0)
                float r6 = r16 - r6
                goto L_0x011e
            L_0x0117:
                float r6 = r4.l
                goto L_0x011e
            L_0x011a:
                r2 = r16
                r6 = r18
            L_0x011e:
                r3.x = r2
                r3.f = r6
            L_0x0122:
                int r2 = r1 + -1
                if (r15 != r2) goto L_0x0132
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f1415c
                int r6 = r0.e
                r17 = r1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r3.f1371c
                r3.i(r1, r2, r6)
                goto L_0x0134
            L_0x0132:
                r17 = r1
            L_0x0134:
                if (r12 == 0) goto L_0x015c
                int r1 = r4.Q
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r12.f1371c
                r14.a(r2, r1)
                if (r15 != r8) goto L_0x0149
                int r1 = r0.c
                boolean r6 = r14.h()
                if (r6 == 0) goto L_0x0149
                r14.c = r1
            L_0x0149:
                r1 = 0
                r2.a(r14, r1)
                r1 = 1
                int r6 = r9 + 1
                if (r15 != r6) goto L_0x015c
                int r1 = r0.e
                boolean r6 = r2.h()
                if (r6 == 0) goto L_0x015c
                r2.c = r1
            L_0x015c:
                if (r3 == r7) goto L_0x01a3
                int r1 = r4.T
                r2 = 3
                if (r1 != r2) goto L_0x0176
                boolean r6 = r10.f1388h
                if (r6 == 0) goto L_0x0176
                if (r3 == r10) goto L_0x0176
                boolean r6 = r3.f1388h
                if (r6 == 0) goto L_0x0176
                androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r3.f1379e
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r10.f1379e
                r12 = 0
                r1.a(r6, r12)
                goto L_0x01a1
            L_0x0176:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.f1363b
                if (r1 == 0) goto L_0x019d
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r3.f1376d
                r14 = 1
                if (r1 == r14) goto L_0x0198
                if (r5 == 0) goto L_0x0190
                androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f1414b
                int r14 = r0.d
                r6.a(r1, r14)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f1416d
                int r6 = r0.f
                r12.a(r1, r6)
                goto L_0x01a1
            L_0x0190:
                r1 = 0
                r6.a(r13, r1)
                r12.a(r11, r1)
                goto L_0x01a1
            L_0x0198:
                r1 = 0
                r12.a(r11, r1)
                goto L_0x01a1
            L_0x019d:
                r1 = 0
                r6.a(r13, r1)
            L_0x01a1:
                r12 = r3
                goto L_0x01a5
            L_0x01a3:
                r2 = 3
                goto L_0x01a1
            L_0x01a5:
                int r15 = r15 + 1
                r14 = r2
                r1 = r17
                r2 = 0
                r6 = -1
                goto L_0x00ab
            L_0x01ae:
                r17 = r1
                androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f1412a
                int r2 = r4.K
                r1.x = r2
                int r2 = r0.c
                if (r21 <= 0) goto L_0x01bd
                int r3 = r4.Q
                int r2 = r2 + r3
            L_0x01bd:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.f1371c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r1.f1348a
                if (r22 == 0) goto L_0x01de
                androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r0.f1415c
                r3.a(r7, r2)
                if (r23 == 0) goto L_0x01d1
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f1411a
                int r7 = r0.e
                r6.a(r2, r7)
            L_0x01d1:
                if (r21 <= 0) goto L_0x01f8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f1415c
                androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.f1340a
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f1348a
                r7 = 0
                r2.a(r3, r7)
                goto L_0x01f8
            L_0x01de:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r0.f1411a
                r6.a(r7, r2)
                if (r23 == 0) goto L_0x01ec
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f1415c
                int r7 = r0.e
                r3.a(r2, r7)
            L_0x01ec:
                if (r21 <= 0) goto L_0x01f8
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r0.f1411a
                androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.f1340a
                androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f1371c
                r7 = 0
                r2.a(r6, r7)
            L_0x01f8:
                r7 = r17
                r2 = 0
                r10 = 0
            L_0x01fc:
                if (r2 >= r7) goto L_0x02d1
                int r11 = r0.i
                int r11 = r11 + r2
                int r12 = r4.X
                if (r11 < r12) goto L_0x0207
                goto L_0x02d1
            L_0x0207:
                androidx.constraintlayout.core.widgets.ConstraintWidget[] r12 = r4.f
                r11 = r12[r11]
                if (r11 != 0) goto L_0x0210
                r11 = r10
                goto L_0x02ca
            L_0x0210:
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r11.f1363b
                if (r2 != 0) goto L_0x0240
                androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r0.f1414b
                int r14 = r0.d
                r11.i(r12, r13, r14)
                int r13 = r4.L
                float r14 = r4.i
                int r15 = r0.i
                if (r15 != 0) goto L_0x022d
                int r15 = r4.N
                r16 = r13
                r13 = -1
                if (r15 == r13) goto L_0x0230
                float r14 = r4.k
                goto L_0x023b
            L_0x022d:
                r16 = r13
                r13 = -1
            L_0x0230:
                if (r23 == 0) goto L_0x0239
                int r15 = r4.P
                if (r15 == r13) goto L_0x0239
                float r14 = r4.m
                goto L_0x023b
            L_0x0239:
                r15 = r16
            L_0x023b:
                r11.y = r15
                r11.g = r14
                goto L_0x0241
            L_0x0240:
                r13 = -1
            L_0x0241:
                int r14 = r7 + -1
                if (r2 != r14) goto L_0x024e
                androidx.constraintlayout.core.widgets.ConstraintAnchor r14 = r0.f1416d
                int r15 = r0.f
                androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.f1376d
                r11.i(r13, r14, r15)
            L_0x024e:
                if (r10 == 0) goto L_0x0276
                int r13 = r4.R
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r10.f1376d
                r12.a(r10, r13)
                if (r2 != r8) goto L_0x0263
                int r13 = r0.d
                boolean r14 = r12.h()
                if (r14 == 0) goto L_0x0263
                r12.c = r13
            L_0x0263:
                r13 = 0
                r10.a(r12, r13)
                r12 = 1
                int r13 = r9 + 1
                if (r2 != r13) goto L_0x0276
                int r12 = r0.f
                boolean r13 = r10.h()
                if (r13 == 0) goto L_0x0276
                r10.c = r12
            L_0x0276:
                if (r11 == r1) goto L_0x02ca
                r10 = 2
                androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r11.f1371c
                androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r11.f1348a
                if (r22 == 0) goto L_0x029b
                int r14 = r4.S
                if (r14 == 0) goto L_0x0296
                r15 = 1
                if (r14 == r15) goto L_0x0291
                if (r14 == r10) goto L_0x0289
                goto L_0x02ca
            L_0x0289:
                r10 = 0
                r13.a(r6, r10)
                r12.a(r3, r10)
                goto L_0x02cb
            L_0x0291:
                r10 = 0
                r13.a(r6, r10)
                goto L_0x02cb
            L_0x0296:
                r10 = 0
                r12.a(r3, r10)
                goto L_0x02cb
            L_0x029b:
                int r14 = r4.S
                if (r14 == 0) goto L_0x02c4
                r15 = 1
                if (r14 == r15) goto L_0x02bf
                if (r14 == r10) goto L_0x02a5
                goto L_0x02b5
            L_0x02a5:
                if (r5 == 0) goto L_0x02b7
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f1411a
                int r14 = r0.c
                r13.a(r10, r14)
                androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.f1415c
                int r13 = r0.e
                r12.a(r10, r13)
            L_0x02b5:
                r10 = 0
                goto L_0x02cc
            L_0x02b7:
                r10 = 0
                r13.a(r6, r10)
                r12.a(r3, r10)
                goto L_0x02cc
            L_0x02bf:
                r10 = 0
                r12.a(r3, r10)
                goto L_0x02cc
            L_0x02c4:
                r10 = 0
                r15 = 1
                r13.a(r6, r10)
                goto L_0x02cc
            L_0x02ca:
                r10 = 0
            L_0x02cb:
                r15 = 1
            L_0x02cc:
                int r2 = r2 + 1
                r10 = r11
                goto L_0x01fc
            L_0x02d1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.a.b(int, boolean, boolean):void");
        }

        public final int c() {
            if (this.a == 1) {
                return this.h - d.this.R;
            }
            return this.h;
        }

        public final int d() {
            if (this.a == 0) {
                return this.g - d.this.Q;
            }
            return this.g;
        }

        public final void e(int i2) {
            int i3 = this.k;
            if (i3 != 0) {
                int i4 = this.j;
                int i5 = i2 / i3;
                for (int i6 = 0; i6 < i4; i6++) {
                    int i7 = this.i;
                    int i8 = i7 + i6;
                    d dVar = d.this;
                    if (i8 >= dVar.X) {
                        break;
                    }
                    ConstraintWidget constraintWidget = dVar.f[i7 + i6];
                    int i9 = this.a;
                    ConstraintWidget.a aVar = ConstraintWidget.a.FIXED;
                    ConstraintWidget.a aVar2 = ConstraintWidget.a.MATCH_CONSTRAINT;
                    if (i9 == 0) {
                        if (constraintWidget != null) {
                            ConstraintWidget.a[] aVarArr = constraintWidget.f1358a;
                            if (aVarArr[0] == aVar2 && constraintWidget.f1381f == 0) {
                                dVar.W(constraintWidget, aVar, i5, aVarArr[1], constraintWidget.o());
                            }
                        }
                    } else if (constraintWidget != null) {
                        ConstraintWidget.a[] aVarArr2 = constraintWidget.f1358a;
                        if (aVarArr2[1] == aVar2 && constraintWidget.f1384g == 0) {
                            dVar.W(constraintWidget, aVarArr2[0], constraintWidget.u(), aVar, i5);
                        }
                    }
                }
                this.g = 0;
                this.h = 0;
                this.f1412a = null;
                this.b = 0;
                int i10 = this.j;
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = this.i + i11;
                    d dVar2 = d.this;
                    if (i12 < dVar2.X) {
                        ConstraintWidget constraintWidget2 = dVar2.f[i12];
                        if (this.a == 0) {
                            int u = constraintWidget2.u();
                            int i13 = dVar2.Q;
                            if (constraintWidget2.w == 8) {
                                i13 = 0;
                            }
                            this.g = u + i13 + this.g;
                            int X = dVar2.X(this.l, constraintWidget2);
                            if (this.f1412a == null || this.b < X) {
                                this.f1412a = constraintWidget2;
                                this.b = X;
                                this.h = X;
                            }
                        } else {
                            int Y = dVar2.Y(this.l, constraintWidget2);
                            int X2 = dVar2.X(this.l, constraintWidget2);
                            int i14 = dVar2.R;
                            if (constraintWidget2.w == 8) {
                                i14 = 0;
                            }
                            this.h = X2 + i14 + this.h;
                            if (this.f1412a == null || this.b < Y) {
                                this.f1412a = constraintWidget2;
                                this.b = Y;
                                this.g = Y;
                            }
                        }
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        }

        public final void f(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.a = i2;
            this.f1411a = constraintAnchor;
            this.f1414b = constraintAnchor2;
            this.f1415c = constraintAnchor3;
            this.f1416d = constraintAnchor4;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.l = i7;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v0, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v1, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v2, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r27v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v30, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v5, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r33v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v6, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r35v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r31v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v7, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v8, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v45, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v46, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r32v10, resolved type: java.lang.Object[]} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0418  */
    /* JADX WARNING: Removed duplicated region for block: B:442:0x0528 A[SYNTHETIC] */
    public final void V(int r38, int r39, int r40, int r41) {
        /*
            r37 = this;
            r8 = r37
            int r0 = r8.B
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r10 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            r11 = 0
            r12 = 1
            if (r0 <= 0) goto L_0x0086
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r8.f1349a
            if (r0 == 0) goto L_0x0015
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r0
            D2$b r0 = r0.f1393a
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 != 0) goto L_0x001b
            r0 = r11
            goto L_0x007d
        L_0x001b:
            r2 = r11
        L_0x001c:
            int r3 = r8.B
            if (r2 >= r3) goto L_0x007c
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r8.c
            r3 = r3[r2]
            if (r3 != 0) goto L_0x0027
            goto L_0x0079
        L_0x0027:
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.e
            if (r4 == 0) goto L_0x002c
            goto L_0x0079
        L_0x002c:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = r3.n(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r5 = r3.n(r12)
            if (r4 != r10) goto L_0x0042
            int r6 = r3.f1381f
            if (r6 == r12) goto L_0x0042
            if (r5 != r10) goto L_0x0042
            int r6 = r3.f1384g
            if (r6 == r12) goto L_0x0042
            r6 = r12
            goto L_0x0043
        L_0x0042:
            r6 = r11
        L_0x0043:
            if (r6 == 0) goto L_0x0046
            goto L_0x0079
        L_0x0046:
            if (r4 != r10) goto L_0x0049
            r4 = r9
        L_0x0049:
            if (r5 != r10) goto L_0x004c
            r5 = r9
        L_0x004c:
            D2$a r6 = r8.a
            r6.f107a = r4
            r6.f109b = r5
            int r4 = r3.u()
            r6.a = r4
            int r4 = r3.o()
            r6.b = r4
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r4 = (androidx.constraintlayout.widget.ConstraintLayout.Measurer) r4
            r4.b(r3, r6)
            int r4 = r6.c
            r3.R(r4)
            int r4 = r6.d
            r3.O(r4)
            int r4 = r6.e
            r3.t = r4
            if (r4 <= 0) goto L_0x0076
            r4 = r12
            goto L_0x0077
        L_0x0076:
            r4 = r11
        L_0x0077:
            r3.f1388h = r4
        L_0x0079:
            int r2 = r2 + 1
            goto L_0x001c
        L_0x007c:
            r0 = r12
        L_0x007d:
            if (r0 != 0) goto L_0x0086
            r8.I = r11
            r8.J = r11
            r8.l = r11
            return
        L_0x0086:
            int r13 = r8.G
            int r14 = r8.H
            int r15 = r8.C
            int r7 = r8.D
            r0 = 2
            int[] r6 = new int[r0]
            int r2 = r39 - r13
            int r2 = r2 - r14
            int r3 = r8.W
            if (r3 != r12) goto L_0x009b
            int r2 = r41 - r15
            int r2 = r2 - r7
        L_0x009b:
            r5 = r2
            r2 = -1
            if (r3 != 0) goto L_0x00ac
            int r3 = r8.K
            if (r3 != r2) goto L_0x00a5
            r8.K = r11
        L_0x00a5:
            int r3 = r8.L
            if (r3 != r2) goto L_0x00b8
            r8.L = r11
            goto L_0x00b8
        L_0x00ac:
            int r3 = r8.K
            if (r3 != r2) goto L_0x00b2
            r8.K = r11
        L_0x00b2:
            int r3 = r8.L
            if (r3 != r2) goto L_0x00b8
            r8.L = r11
        L_0x00b8:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = r8.c
            r3 = r11
            r4 = r3
        L_0x00bc:
            int r1 = r8.B
            r11 = 8
            if (r3 >= r1) goto L_0x00d0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r8.c
            r1 = r1[r3]
            int r1 = r1.w
            if (r1 != r11) goto L_0x00cc
            int r4 = r4 + 1
        L_0x00cc:
            int r3 = r3 + 1
            r11 = 0
            goto L_0x00bc
        L_0x00d0:
            if (r4 <= 0) goto L_0x00eb
            int r1 = r1 - r4
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r1]
            r1 = 0
            r3 = 0
        L_0x00d7:
            int r4 = r8.B
            if (r3 >= r4) goto L_0x00eb
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r8.c
            r4 = r4[r3]
            int r0 = r4.w
            if (r0 == r11) goto L_0x00e7
            r2[r1] = r4
            int r1 = r1 + 1
        L_0x00e7:
            int r3 = r3 + 1
            r0 = 2
            goto L_0x00d7
        L_0x00eb:
            r11 = r1
            r4 = r2
            r8.f = r4
            r8.X = r11
            int r0 = r8.U
            java.util.ArrayList<androidx.constraintlayout.core.widgets.d$a> r3 = r8.b
            if (r0 == 0) goto L_0x076d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r8.f1348a
            r27 = r13
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r8.f1371c
            r28 = r13
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r8.f1376d
            if (r0 == r12) goto L_0x0540
            r12 = 2
            if (r0 == r12) goto L_0x037f
            r12 = 3
            if (r0 == r12) goto L_0x010c
            goto L_0x0110
        L_0x010c:
            int r12 = r8.W
            if (r11 != 0) goto L_0x011a
        L_0x0110:
            r32 = r6
            r33 = r7
            r31 = r14
            r35 = r15
            goto L_0x077f
        L_0x011a:
            r3.clear()
            androidx.constraintlayout.core.widgets.d$a r0 = new androidx.constraintlayout.core.widgets.d$a
            r18 = r3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.f1348a
            r19 = r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.f1363b
            r20 = r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1371c
            r21 = r6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.f1376d
            r16 = r0
            r17 = r1
            r1 = r37
            r22 = r2
            r2 = r12
            r29 = r13
            r13 = r18
            r30 = r19
            r31 = r20
            r32 = r21
            r33 = r7
            r7 = r31
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r13.add(r0)
            if (r12 != 0) goto L_0x01f1
            r1 = 0
            r2 = 0
            r3 = 0
            r7 = 0
        L_0x0152:
            if (r7 >= r11) goto L_0x01e5
            r4 = 1
            int r6 = r1 + 1
            r5 = r30[r7]
            r4 = r31
            int r16 = r8.Y(r4, r5)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r1 = r5.f1358a
            r18 = 0
            r1 = r1[r18]
            if (r1 != r10) goto L_0x0169
            int r2 = r2 + 1
        L_0x0169:
            r18 = r2
            if (r3 == r4) goto L_0x0174
            int r1 = r8.Q
            int r1 = r1 + r3
            int r1 = r1 + r16
            if (r1 <= r4) goto L_0x017a
        L_0x0174:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f1412a
            if (r1 == 0) goto L_0x017a
            r1 = 1
            goto L_0x017b
        L_0x017a:
            r1 = 0
        L_0x017b:
            if (r1 != 0) goto L_0x0186
            if (r7 <= 0) goto L_0x0186
            int r2 = r8.V
            if (r2 <= 0) goto L_0x0186
            if (r6 <= r2) goto L_0x0186
            r1 = 1
        L_0x0186:
            if (r1 == 0) goto L_0x01bf
            androidx.constraintlayout.core.widgets.d$a r3 = new androidx.constraintlayout.core.widgets.d$a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r8.f1371c
            r19 = r6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.f1376d
            r20 = r0
            r0 = r3
            r21 = r1
            r1 = r37
            r23 = r2
            r2 = r12
            r31 = r14
            r14 = r3
            r3 = r23
            r34 = r4
            r4 = r21
            r35 = r15
            r15 = r5
            r5 = r20
            r20 = r9
            r9 = r7
            r7 = r34
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r14.i = r9
            r13.add(r14)
            r0 = r14
            r3 = r16
            r1 = r19
            goto L_0x01d4
        L_0x01bf:
            r34 = r4
            r20 = r9
            r31 = r14
            r35 = r15
            r15 = r5
            r9 = r7
            if (r9 <= 0) goto L_0x01d1
            int r1 = r8.Q
            int r1 = r1 + r16
            int r16 = r1 + r3
        L_0x01d1:
            r3 = r16
            r1 = 0
        L_0x01d4:
            r0.a(r15)
            int r7 = r9 + 1
            r2 = r18
            r9 = r20
            r14 = r31
            r31 = r34
            r15 = r35
            goto L_0x0152
        L_0x01e5:
            r20 = r9
            r35 = r15
            r34 = r31
            r31 = r14
            r15 = r34
            goto L_0x0266
        L_0x01f1:
            r20 = r9
            r35 = r15
            r34 = r31
            r31 = r14
            r1 = 0
            r2 = 0
            r9 = 0
        L_0x01fc:
            if (r9 >= r11) goto L_0x0263
            r14 = r30[r9]
            r15 = r34
            int r16 = r8.X(r15, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r3 = r14.f1358a
            r4 = 1
            r3 = r3[r4]
            if (r3 != r10) goto L_0x020f
            int r1 = r1 + 1
        L_0x020f:
            r18 = r1
            if (r2 == r15) goto L_0x021a
            int r1 = r8.R
            int r1 = r1 + r2
            int r1 = r1 + r16
            if (r1 <= r15) goto L_0x0220
        L_0x021a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f1412a
            if (r1 == 0) goto L_0x0220
            r1 = 1
            goto L_0x0221
        L_0x0220:
            r1 = 0
        L_0x0221:
            if (r1 != 0) goto L_0x022c
            if (r9 <= 0) goto L_0x022c
            int r3 = r8.V
            if (r3 <= 0) goto L_0x022c
            if (r3 >= 0) goto L_0x022c
            r1 = 1
        L_0x022c:
            if (r1 == 0) goto L_0x024a
            androidx.constraintlayout.core.widgets.d$a r7 = new androidx.constraintlayout.core.widgets.d$a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.f1376d
            r0 = r7
            r1 = r37
            r2 = r12
            r19 = r10
            r10 = r7
            r7 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r10.i = r9
            r13.add(r10)
            r0 = r10
            goto L_0x0255
        L_0x024a:
            r19 = r10
            if (r9 <= 0) goto L_0x0255
            int r1 = r8.R
            int r1 = r1 + r16
            int r1 = r1 + r2
            r2 = r1
            goto L_0x0257
        L_0x0255:
            r2 = r16
        L_0x0257:
            r0.a(r14)
            int r9 = r9 + 1
            r34 = r15
            r1 = r18
            r10 = r19
            goto L_0x01fc
        L_0x0263:
            r15 = r34
            r2 = r1
        L_0x0266:
            int r0 = r13.size()
            int r1 = r8.G
            int r3 = r8.C
            int r4 = r8.H
            int r5 = r8.D
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r6 = r8.f1358a
            r7 = 0
            r9 = r6[r7]
            r10 = r20
            if (r9 == r10) goto L_0x0283
            r7 = 1
            r6 = r6[r7]
            if (r6 != r10) goto L_0x0281
            goto L_0x0283
        L_0x0281:
            r6 = 0
            goto L_0x0284
        L_0x0283:
            r6 = 1
        L_0x0284:
            if (r2 <= 0) goto L_0x02a9
            if (r6 == 0) goto L_0x02a9
            r2 = 0
        L_0x0289:
            if (r2 >= r0) goto L_0x02a9
            java.lang.Object r6 = r13.get(r2)
            androidx.constraintlayout.core.widgets.d$a r6 = (androidx.constraintlayout.core.widgets.d.a) r6
            if (r12 != 0) goto L_0x029d
            int r7 = r6.d()
            int r7 = r15 - r7
            r6.e(r7)
            goto L_0x02a6
        L_0x029d:
            int r7 = r6.c()
            int r7 = r15 - r7
            r6.e(r7)
        L_0x02a6:
            int r2 = r2 + 1
            goto L_0x0289
        L_0x02a9:
            r6 = r3
            r2 = r22
            r14 = r28
            r11 = r29
            r7 = 0
            r9 = 0
            r10 = 0
            r3 = r1
            r1 = r17
        L_0x02b6:
            if (r7 >= r0) goto L_0x0377
            java.lang.Object r16 = r13.get(r7)
            r30 = r5
            r5 = r16
            androidx.constraintlayout.core.widgets.d$a r5 = (androidx.constraintlayout.core.widgets.d.a) r5
            if (r12 != 0) goto L_0x031b
            int r11 = r0 + -1
            if (r7 >= r11) goto L_0x02d9
            int r11 = r7 + 1
            java.lang.Object r11 = r13.get(r11)
            androidx.constraintlayout.core.widgets.d$a r11 = (androidx.constraintlayout.core.widgets.d.a) r11
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r11.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r11 = r11.f1363b
            r34 = r13
            r30 = 0
            goto L_0x02e1
        L_0x02d9:
            int r11 = r8.D
            r30 = r11
            r34 = r13
            r11 = r29
        L_0x02e1:
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r5.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f1376d
            r16 = r5
            r17 = r12
            r18 = r1
            r19 = r2
            r20 = r14
            r21 = r11
            r22 = r3
            r23 = r6
            r24 = r4
            r25 = r30
            r26 = r15
            r16.f(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r2 = r5.d()
            int r2 = java.lang.Math.max(r9, r2)
            int r5 = r5.c()
            int r5 = r5 + r10
            if (r7 <= 0) goto L_0x0310
            int r6 = r8.R
            int r5 = r5 + r6
        L_0x0310:
            r9 = r2
            r10 = r5
            r2 = r13
            r5 = r30
            r13 = r34
            r6 = 0
            r34 = r0
            goto L_0x0371
        L_0x031b:
            r34 = r13
            int r4 = r0 + -1
            if (r7 >= r4) goto L_0x0334
            int r4 = r7 + 1
            r13 = r34
            java.lang.Object r4 = r13.get(r4)
            androidx.constraintlayout.core.widgets.d$a r4 = (androidx.constraintlayout.core.widgets.d.a) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1348a
            r34 = r0
            r14 = r4
            r4 = 0
            goto L_0x033c
        L_0x0334:
            r13 = r34
            int r4 = r8.H
            r34 = r0
            r14 = r28
        L_0x033c:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r5.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1371c
            r16 = r5
            r17 = r12
            r18 = r1
            r19 = r2
            r20 = r14
            r21 = r11
            r22 = r3
            r23 = r6
            r24 = r4
            r25 = r30
            r26 = r15
            r16.f(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r1 = r5.d()
            int r1 = r1 + r9
            int r3 = r5.c()
            int r3 = java.lang.Math.max(r10, r3)
            if (r7 <= 0) goto L_0x036b
            int r5 = r8.Q
            int r1 = r1 + r5
        L_0x036b:
            r9 = r1
            r10 = r3
            r5 = r30
            r3 = 0
            r1 = r0
        L_0x0371:
            int r7 = r7 + 1
            r0 = r34
            goto L_0x02b6
        L_0x0377:
            r0 = 0
            r32[r0] = r9
            r0 = 1
            r32[r0] = r10
            goto L_0x077f
        L_0x037f:
            r30 = r4
            r32 = r6
            r33 = r7
            r31 = r14
            r35 = r15
            r15 = r5
            int r0 = r8.W
            if (r0 != 0) goto L_0x03b3
            int r1 = r8.V
            if (r1 > 0) goto L_0x03b0
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0395:
            if (r1 >= r11) goto L_0x03af
            if (r1 <= 0) goto L_0x039c
            int r4 = r8.Q
            int r2 = r2 + r4
        L_0x039c:
            r4 = r30[r1]
            if (r4 != 0) goto L_0x03a1
            goto L_0x03ac
        L_0x03a1:
            int r4 = r8.Y(r15, r4)
            int r4 = r4 + r2
            if (r4 <= r15) goto L_0x03a9
            goto L_0x03af
        L_0x03a9:
            int r3 = r3 + 1
            r2 = r4
        L_0x03ac:
            int r1 = r1 + 1
            goto L_0x0395
        L_0x03af:
            r1 = r3
        L_0x03b0:
            r2 = r1
            r1 = 0
            goto L_0x03d6
        L_0x03b3:
            int r1 = r8.V
            if (r1 > 0) goto L_0x03d5
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x03ba:
            if (r1 >= r11) goto L_0x03d4
            if (r1 <= 0) goto L_0x03c1
            int r4 = r8.R
            int r2 = r2 + r4
        L_0x03c1:
            r4 = r30[r1]
            if (r4 != 0) goto L_0x03c6
            goto L_0x03d1
        L_0x03c6:
            int r4 = r8.X(r15, r4)
            int r4 = r4 + r2
            if (r4 <= r15) goto L_0x03ce
            goto L_0x03d4
        L_0x03ce:
            int r3 = r3 + 1
            r2 = r4
        L_0x03d1:
            int r1 = r1 + 1
            goto L_0x03ba
        L_0x03d4:
            r1 = r3
        L_0x03d5:
            r2 = 0
        L_0x03d6:
            int[] r3 = r8.c
            if (r3 != 0) goto L_0x03df
            r3 = 2
            int[] r3 = new int[r3]
            r8.c = r3
        L_0x03df:
            if (r1 != 0) goto L_0x03e4
            r3 = 1
            if (r0 == r3) goto L_0x03e8
        L_0x03e4:
            if (r2 != 0) goto L_0x03ff
            if (r0 != 0) goto L_0x03ff
        L_0x03e8:
            r3 = r40
            r4 = r41
            r5 = r0
            r6 = r1
            r7 = r2
            r12 = r8
            r17 = r12
            r13 = r27
            r14 = r31
            r9 = r32
            r0 = 1
            r1 = r38
            r2 = r39
            goto L_0x051c
        L_0x03ff:
            r3 = r41
            r4 = r0
            r5 = r1
            r6 = r2
            r12 = r8
            r17 = r12
            r13 = r27
            r7 = r30
            r14 = r31
            r9 = r32
            r10 = 0
            r0 = r38
            r1 = r39
            r2 = r40
        L_0x0416:
            if (r10 != 0) goto L_0x0528
            if (r4 != 0) goto L_0x0429
            float r5 = (float) r11
            r38 = r0
            float r0 = (float) r6
            float r5 = r5 / r0
            r39 = r1
            double r0 = (double) r5
            double r0 = java.lang.Math.ceil(r0)
            int r0 = (int) r0
            r5 = r0
            goto L_0x0437
        L_0x0429:
            r38 = r0
            r39 = r1
            float r0 = (float) r11
            float r1 = (float) r5
            float r0 = r0 / r1
            double r0 = (double) r0
            double r0 = java.lang.Math.ceil(r0)
            int r0 = (int) r0
            r6 = r0
        L_0x0437:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r12.e
            if (r0 == 0) goto L_0x0444
            int r1 = r0.length
            if (r1 >= r6) goto L_0x043f
            goto L_0x0444
        L_0x043f:
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            goto L_0x0449
        L_0x0444:
            r1 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r6]
            r12.e = r0
        L_0x0449:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r12.d
            if (r0 == 0) goto L_0x0456
            int r1 = r0.length
            if (r1 >= r5) goto L_0x0451
            goto L_0x0456
        L_0x0451:
            r1 = 0
            java.util.Arrays.fill(r0, r1)
            goto L_0x045a
        L_0x0456:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = new androidx.constraintlayout.core.widgets.ConstraintWidget[r5]
            r12.d = r0
        L_0x045a:
            r0 = 0
        L_0x045b:
            if (r0 >= r6) goto L_0x04b8
            r1 = 0
        L_0x045e:
            if (r1 >= r5) goto L_0x04af
            int r18 = r1 * r6
            int r18 = r18 + r0
            r40 = r2
            r2 = 1
            if (r4 != r2) goto L_0x046d
            int r2 = r0 * r5
            int r18 = r2 + r1
        L_0x046d:
            r41 = r3
            r2 = r18
            int r3 = r7.length
            if (r2 < r3) goto L_0x0477
        L_0x0474:
            r18 = r7
            goto L_0x04a6
        L_0x0477:
            r2 = r7[r2]
            if (r2 != 0) goto L_0x047c
            goto L_0x0474
        L_0x047c:
            int r3 = r12.Y(r15, r2)
            r18 = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r12.e
            r7 = r7[r0]
            if (r7 == 0) goto L_0x048e
            int r7 = r7.u()
            if (r7 >= r3) goto L_0x0492
        L_0x048e:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r12.e
            r3[r0] = r2
        L_0x0492:
            int r3 = r12.X(r15, r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r7 = r12.d
            r7 = r7[r1]
            if (r7 == 0) goto L_0x04a2
            int r7 = r7.o()
            if (r7 >= r3) goto L_0x04a6
        L_0x04a2:
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r12.d
            r3[r1] = r2
        L_0x04a6:
            int r1 = r1 + 1
            r2 = r40
            r3 = r41
            r7 = r18
            goto L_0x045e
        L_0x04af:
            r40 = r2
            r41 = r3
            r18 = r7
            int r0 = r0 + 1
            goto L_0x045b
        L_0x04b8:
            r40 = r2
            r41 = r3
            r18 = r7
            r0 = 0
            r1 = 0
        L_0x04c0:
            if (r0 >= r6) goto L_0x04d6
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r2 = r12.e
            r2 = r2[r0]
            if (r2 == 0) goto L_0x04d3
            if (r0 <= 0) goto L_0x04cd
            int r3 = r12.Q
            int r1 = r1 + r3
        L_0x04cd:
            int r2 = r12.Y(r15, r2)
            int r2 = r2 + r1
            r1 = r2
        L_0x04d3:
            int r0 = r0 + 1
            goto L_0x04c0
        L_0x04d6:
            r0 = 0
            r2 = 0
        L_0x04d8:
            if (r0 >= r5) goto L_0x04ee
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r3 = r12.d
            r3 = r3[r0]
            if (r3 == 0) goto L_0x04eb
            if (r0 <= 0) goto L_0x04e5
            int r7 = r12.R
            int r2 = r2 + r7
        L_0x04e5:
            int r3 = r12.X(r15, r3)
            int r3 = r3 + r2
            r2 = r3
        L_0x04eb:
            int r0 = r0 + 1
            goto L_0x04d8
        L_0x04ee:
            r0 = 0
            r9[r0] = r1
            r0 = 1
            r9[r0] = r2
            if (r4 != 0) goto L_0x04fd
            if (r1 <= r15) goto L_0x050f
            if (r6 <= r0) goto L_0x050f
            int r6 = r6 + -1
            goto L_0x0503
        L_0x04fd:
            if (r2 <= r15) goto L_0x050f
            if (r5 <= r0) goto L_0x050f
            int r5 = r5 + -1
        L_0x0503:
            r0 = r38
            r1 = r39
            r2 = r40
            r3 = r41
            r7 = r18
            goto L_0x0416
        L_0x050f:
            r1 = r38
            r2 = r39
            r3 = r40
            r7 = r6
            r30 = r18
            r6 = r5
            r5 = r4
            r4 = r41
        L_0x051c:
            r10 = r0
            r0 = r1
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r30
            goto L_0x0416
        L_0x0528:
            r38 = r0
            r39 = r1
            r40 = r2
            r41 = r3
            r0 = 1
            int[] r1 = r12.c
            r2 = 0
            r1[r2] = r6
            r1[r0] = r5
            r0 = r38
            r1 = r39
            r2 = r40
            goto L_0x078d
        L_0x0540:
            r17 = r1
            r22 = r2
            r30 = r4
            r32 = r6
            r33 = r7
            r19 = r10
            r29 = r13
            r31 = r14
            r35 = r15
            r13 = r3
            r15 = r5
            r10 = r9
            int r9 = r8.W
            if (r11 != 0) goto L_0x055b
            goto L_0x077f
        L_0x055b:
            r13.clear()
            androidx.constraintlayout.core.widgets.d$a r12 = new androidx.constraintlayout.core.widgets.d$a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.f1376d
            r0 = r12
            r1 = r37
            r2 = r9
            r7 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r13.add(r12)
            if (r9 != 0) goto L_0x05f3
            r0 = 0
            r1 = 0
            r14 = 0
        L_0x0578:
            if (r14 >= r11) goto L_0x05ed
            r7 = r30[r14]
            int r16 = r8.Y(r15, r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r2 = r7.f1358a
            r3 = 0
            r2 = r2[r3]
            r6 = r19
            if (r2 != r6) goto L_0x058b
            int r0 = r0 + 1
        L_0x058b:
            r18 = r0
            if (r1 == r15) goto L_0x0596
            int r0 = r8.Q
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r15) goto L_0x059c
        L_0x0596:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r12.f1412a
            if (r0 == 0) goto L_0x059c
            r0 = 1
            goto L_0x059d
        L_0x059c:
            r0 = 0
        L_0x059d:
            if (r0 != 0) goto L_0x05aa
            if (r14 <= 0) goto L_0x05aa
            int r2 = r8.V
            if (r2 <= 0) goto L_0x05aa
            int r2 = r14 % r2
            if (r2 != 0) goto L_0x05aa
            r0 = 1
        L_0x05aa:
            if (r0 == 0) goto L_0x05ce
            androidx.constraintlayout.core.widgets.d$a r12 = new androidx.constraintlayout.core.widgets.d$a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.f1376d
            r0 = r12
            r1 = r37
            r19 = r2
            r2 = r9
            r20 = r10
            r10 = r6
            r6 = r19
            r34 = r9
            r9 = r7
            r7 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r12.i = r14
            r13.add(r12)
            goto L_0x05dd
        L_0x05ce:
            r34 = r9
            r20 = r10
            r10 = r6
            r9 = r7
            if (r14 <= 0) goto L_0x05dd
            int r0 = r8.Q
            int r0 = r0 + r16
            int r0 = r0 + r1
            r1 = r0
            goto L_0x05df
        L_0x05dd:
            r1 = r16
        L_0x05df:
            r12.a(r9)
            int r14 = r14 + 1
            r19 = r10
            r0 = r18
            r10 = r20
            r9 = r34
            goto L_0x0578
        L_0x05ed:
            r34 = r9
            r20 = r10
            goto L_0x065a
        L_0x05f3:
            r34 = r9
            r20 = r10
            r10 = r19
            r0 = 0
            r1 = 0
            r9 = 0
        L_0x05fc:
            if (r9 >= r11) goto L_0x065a
            r14 = r30[r9]
            int r16 = r8.X(r15, r14)
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r2 = r14.f1358a
            r3 = 1
            r2 = r2[r3]
            if (r2 != r10) goto L_0x060d
            int r0 = r0 + 1
        L_0x060d:
            r18 = r0
            if (r1 == r15) goto L_0x0618
            int r0 = r8.R
            int r0 = r0 + r1
            int r0 = r0 + r16
            if (r0 <= r15) goto L_0x061e
        L_0x0618:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r12.f1412a
            if (r0 == 0) goto L_0x061e
            r0 = 1
            goto L_0x061f
        L_0x061e:
            r0 = 0
        L_0x061f:
            if (r0 != 0) goto L_0x062c
            if (r9 <= 0) goto L_0x062c
            int r2 = r8.V
            if (r2 <= 0) goto L_0x062c
            int r2 = r9 % r2
            if (r2 != 0) goto L_0x062c
            r0 = 1
        L_0x062c:
            if (r0 == 0) goto L_0x0647
            androidx.constraintlayout.core.widgets.d$a r12 = new androidx.constraintlayout.core.widgets.d$a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.f1376d
            r0 = r12
            r1 = r37
            r2 = r34
            r7 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r12.i = r9
            r13.add(r12)
            goto L_0x0650
        L_0x0647:
            if (r9 <= 0) goto L_0x0650
            int r0 = r8.R
            int r0 = r0 + r16
            int r0 = r0 + r1
            r1 = r0
            goto L_0x0652
        L_0x0650:
            r1 = r16
        L_0x0652:
            r12.a(r14)
            int r9 = r9 + 1
            r0 = r18
            goto L_0x05fc
        L_0x065a:
            int r1 = r13.size()
            int r2 = r8.G
            int r3 = r8.C
            int r4 = r8.H
            int r5 = r8.D
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r6 = r8.f1358a
            r7 = 0
            r9 = r6[r7]
            r7 = r20
            if (r9 == r7) goto L_0x0677
            r9 = 1
            r6 = r6[r9]
            if (r6 != r7) goto L_0x0675
            goto L_0x0677
        L_0x0675:
            r6 = 0
            goto L_0x0678
        L_0x0677:
            r6 = 1
        L_0x0678:
            if (r0 <= 0) goto L_0x069d
            if (r6 == 0) goto L_0x069d
            r0 = 0
        L_0x067d:
            if (r0 >= r1) goto L_0x069d
            java.lang.Object r6 = r13.get(r0)
            androidx.constraintlayout.core.widgets.d$a r6 = (androidx.constraintlayout.core.widgets.d.a) r6
            if (r34 != 0) goto L_0x0691
            int r7 = r6.d()
            int r7 = r15 - r7
            r6.e(r7)
            goto L_0x069a
        L_0x0691:
            int r7 = r6.c()
            int r7 = r15 - r7
            r6.e(r7)
        L_0x069a:
            int r0 = r0 + 1
            goto L_0x067d
        L_0x069d:
            r6 = r3
            r0 = r17
            r12 = r28
            r11 = r29
            r7 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            r2 = r22
        L_0x06aa:
            if (r7 >= r1) goto L_0x0766
            java.lang.Object r14 = r13.get(r7)
            androidx.constraintlayout.core.widgets.d$a r14 = (androidx.constraintlayout.core.widgets.d.a) r14
            if (r34 != 0) goto L_0x0708
            int r5 = r1 + -1
            if (r7 >= r5) goto L_0x06c9
            int r5 = r7 + 1
            java.lang.Object r5 = r13.get(r5)
            androidx.constraintlayout.core.widgets.d$a r5 = (androidx.constraintlayout.core.widgets.d.a) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1363b
            r11 = r5
            r36 = r13
            r5 = 0
            goto L_0x06cf
        L_0x06c9:
            int r5 = r8.D
            r36 = r13
            r11 = r29
        L_0x06cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r14.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r13.f1376d
            r16 = r14
            r17 = r34
            r18 = r0
            r19 = r2
            r20 = r12
            r21 = r11
            r22 = r3
            r23 = r6
            r24 = r4
            r25 = r5
            r26 = r15
            r16.f(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r2 = r14.d()
            int r2 = java.lang.Math.max(r9, r2)
            int r6 = r14.c()
            int r6 = r6 + r10
            if (r7 <= 0) goto L_0x06fe
            int r9 = r8.R
            int r6 = r6 + r9
        L_0x06fe:
            r30 = r1
            r9 = r2
            r10 = r6
            r1 = r12
            r2 = r13
            r12 = r36
            r6 = 0
            goto L_0x075e
        L_0x0708:
            r36 = r13
            int r4 = r1 + -1
            if (r7 >= r4) goto L_0x0720
            int r4 = r7 + 1
            r12 = r36
            java.lang.Object r4 = r12.get(r4)
            androidx.constraintlayout.core.widgets.d$a r4 = (androidx.constraintlayout.core.widgets.d.a) r4
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1348a
            r30 = r1
            r13 = 0
            goto L_0x0729
        L_0x0720:
            r12 = r36
            int r4 = r8.H
            r30 = r1
            r13 = r4
            r4 = r28
        L_0x0729:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r14.f1412a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1371c
            r16 = r14
            r17 = r34
            r18 = r0
            r19 = r2
            r20 = r4
            r21 = r11
            r22 = r3
            r23 = r6
            r24 = r13
            r25 = r5
            r26 = r15
            r16.f(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            int r0 = r14.d()
            int r0 = r0 + r9
            int r3 = r14.c()
            int r3 = java.lang.Math.max(r10, r3)
            if (r7 <= 0) goto L_0x0758
            int r9 = r8.Q
            int r0 = r0 + r9
        L_0x0758:
            r9 = r0
            r0 = r1
            r10 = r3
            r1 = r4
            r4 = r13
            r3 = 0
        L_0x075e:
            int r7 = r7 + 1
            r13 = r12
            r12 = r1
            r1 = r30
            goto L_0x06aa
        L_0x0766:
            r0 = 0
            r32[r0] = r9
            r0 = 1
            r32[r0] = r10
            goto L_0x077f
        L_0x076d:
            r12 = r3
            r30 = r4
            r32 = r6
            r33 = r7
            r27 = r13
            r31 = r14
            r35 = r15
            r15 = r5
            int r2 = r8.W
            if (r11 != 0) goto L_0x079d
        L_0x077f:
            r0 = r38
            r1 = r39
            r2 = r40
            r3 = r41
            r17 = r8
            r13 = r27
            r14 = r31
        L_0x078d:
            r6 = r32
            r7 = r33
            r15 = r35
            r4 = r3
            r5 = r17
            r18 = 0
            r3 = r2
            r2 = r1
            r1 = 1
            goto L_0x0825
        L_0x079d:
            int r0 = r12.size()
            if (r0 != 0) goto L_0x07b8
            androidx.constraintlayout.core.widgets.d$a r9 = new androidx.constraintlayout.core.widgets.d$a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r8.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r8.f1376d
            r0 = r9
            r1 = r37
            r7 = r15
            r0.<init>(r2, r3, r4, r5, r6, r7)
            r12.add(r9)
            goto L_0x07f8
        L_0x07b8:
            r0 = 0
            java.lang.Object r1 = r12.get(r0)
            r9 = r1
            androidx.constraintlayout.core.widgets.d$a r9 = (androidx.constraintlayout.core.widgets.d.a) r9
            r9.b = r0
            r1 = 0
            r9.f1412a = r1
            r9.g = r0
            r9.h = r0
            r9.i = r0
            r9.j = r0
            r9.k = r0
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r8.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r8.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r8.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r8.f1376d
            int r5 = r8.G
            int r6 = r8.C
            int r7 = r8.H
            int r10 = r8.D
            r16 = r9
            r17 = r2
            r18 = r0
            r19 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r10
            r26 = r15
            r16.f(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
        L_0x07f8:
            r0 = 0
        L_0x07f9:
            if (r0 >= r11) goto L_0x0803
            r1 = r30[r0]
            r9.a(r1)
            int r0 = r0 + 1
            goto L_0x07f9
        L_0x0803:
            int r0 = r9.d()
            r18 = 0
            r32[r18] = r0
            int r0 = r9.c()
            r1 = 1
            r32[r1] = r0
            r0 = r38
            r2 = r39
            r3 = r40
            r4 = r41
            r5 = r8
            r13 = r27
            r14 = r31
            r6 = r32
            r7 = r33
            r15 = r35
        L_0x0825:
            r9 = r6[r18]
            int r9 = r9 + r13
            int r9 = r9 + r14
            r6 = r6[r1]
            int r6 = r6 + r15
            int r6 = r6 + r7
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = 1073741824(0x40000000, float:2.0)
            if (r0 != r10) goto L_0x0835
            r0 = r2
            goto L_0x0842
        L_0x0835:
            if (r0 != r7) goto L_0x083c
            int r0 = java.lang.Math.min(r9, r2)
            goto L_0x0842
        L_0x083c:
            if (r0 != 0) goto L_0x0840
            r0 = r9
            goto L_0x0842
        L_0x0840:
            r0 = r18
        L_0x0842:
            if (r3 != r10) goto L_0x0846
            r2 = r4
            goto L_0x0853
        L_0x0846:
            if (r3 != r7) goto L_0x084d
            int r2 = java.lang.Math.min(r6, r4)
            goto L_0x0853
        L_0x084d:
            if (r3 != 0) goto L_0x0851
            r2 = r6
            goto L_0x0853
        L_0x0851:
            r2 = r18
        L_0x0853:
            r5.I = r0
            r5.J = r2
            r5.R(r0)
            r5.O(r2)
            int r0 = r5.B
            if (r0 <= 0) goto L_0x0863
            r11 = r1
            goto L_0x0865
        L_0x0863:
            r11 = r18
        L_0x0865:
            r5.l = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.V(int, int, int, int):void");
    }

    public final int X(int i2, ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.f1358a[1] == ConstraintWidget.a.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.f1384g;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.b * ((float) i2));
                if (i4 != constraintWidget.o()) {
                    constraintWidget.f1366b = true;
                    W(constraintWidget, constraintWidget.f1358a[0], constraintWidget.u(), ConstraintWidget.a.FIXED, i4);
                }
                return i4;
            } else if (i3 == 1) {
                return constraintWidget.o();
            } else {
                if (i3 == 3) {
                    return (int) ((((float) constraintWidget.u()) * constraintWidget.e) + 0.5f);
                }
            }
        }
        return constraintWidget.o();
    }

    public final int Y(int i2, ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.f1358a[0] == ConstraintWidget.a.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.f1381f;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.a * ((float) i2));
                if (i4 != constraintWidget.u()) {
                    constraintWidget.f1366b = true;
                    W(constraintWidget, ConstraintWidget.a.FIXED, i4, constraintWidget.f1358a[1], constraintWidget.o());
                }
                return i4;
            } else if (i3 == 1) {
                return constraintWidget.u();
            } else {
                if (i3 == 3) {
                    return (int) ((((float) constraintWidget.o()) * constraintWidget.e) + 0.5f);
                }
            }
        }
        return constraintWidget.u();
    }

    public final void e(ei eiVar, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        float f2;
        int i2;
        boolean z4;
        super.e(eiVar, z);
        ConstraintWidget constraintWidget2 = this.f1349a;
        if (constraintWidget2 == null || !((ConstraintWidgetContainer) constraintWidget2).l) {
            z2 = false;
        } else {
            z2 = true;
        }
        int i3 = this.U;
        ArrayList<a> arrayList = this.b;
        if (i3 != 0) {
            if (i3 == 1) {
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    a aVar = arrayList.get(i4);
                    if (i4 == size - 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    aVar.b(i4, z2, z3);
                }
            } else if (i3 != 2) {
                if (i3 == 3) {
                    int size2 = arrayList.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        a aVar2 = arrayList.get(i5);
                        if (i5 == size2 - 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        aVar2.b(i5, z2, z4);
                    }
                }
            } else if (!(this.c == null || this.e == null || this.d == null)) {
                for (int i6 = 0; i6 < this.X; i6++) {
                    this.f[i6].H();
                }
                int[] iArr = this.c;
                int i7 = iArr[0];
                int i8 = iArr[1];
                float f3 = this.h;
                ConstraintWidget constraintWidget3 = null;
                int i9 = 0;
                while (i9 < i7) {
                    if (z2) {
                        i2 = (i7 - i9) - 1;
                        f2 = 1.0f - this.h;
                    } else {
                        f2 = f3;
                        i2 = i9;
                    }
                    ConstraintWidget constraintWidget4 = this.e[i2];
                    if (!(constraintWidget4 == null || constraintWidget4.w == 8)) {
                        ConstraintAnchor constraintAnchor = constraintWidget4.f1348a;
                        if (i9 == 0) {
                            constraintWidget4.i(constraintAnchor, this.f1348a, this.G);
                            constraintWidget4.x = this.K;
                            constraintWidget4.f = f2;
                        }
                        if (i9 == i7 - 1) {
                            constraintWidget4.i(constraintWidget4.f1371c, this.f1371c, this.H);
                        }
                        if (i9 > 0 && constraintWidget3 != null) {
                            int i10 = this.Q;
                            ConstraintAnchor constraintAnchor2 = constraintWidget3.f1371c;
                            constraintWidget4.i(constraintAnchor, constraintAnchor2, i10);
                            constraintWidget3.i(constraintAnchor2, constraintAnchor, 0);
                        }
                        constraintWidget3 = constraintWidget4;
                    }
                    i9++;
                    f3 = f2;
                }
                for (int i11 = 0; i11 < i8; i11++) {
                    ConstraintWidget constraintWidget5 = this.d[i11];
                    if (!(constraintWidget5 == null || constraintWidget5.w == 8)) {
                        ConstraintAnchor constraintAnchor3 = constraintWidget5.f1363b;
                        if (i11 == 0) {
                            constraintWidget5.i(constraintAnchor3, this.f1363b, this.C);
                            constraintWidget5.y = this.L;
                            constraintWidget5.g = this.i;
                        }
                        if (i11 == i8 - 1) {
                            constraintWidget5.i(constraintWidget5.f1376d, this.f1376d, this.D);
                        }
                        if (i11 > 0 && constraintWidget3 != null) {
                            int i12 = this.R;
                            ConstraintAnchor constraintAnchor4 = constraintWidget3.f1376d;
                            constraintWidget5.i(constraintAnchor3, constraintAnchor4, i12);
                            constraintWidget3.i(constraintAnchor4, constraintAnchor3, 0);
                        }
                        constraintWidget3 = constraintWidget5;
                    }
                }
                for (int i13 = 0; i13 < i7; i13++) {
                    for (int i14 = 0; i14 < i8; i14++) {
                        int i15 = (i14 * i7) + i13;
                        if (this.W == 1) {
                            i15 = (i13 * i8) + i14;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.f;
                        if (!(i15 >= constraintWidgetArr.length || (constraintWidget = constraintWidgetArr[i15]) == null || constraintWidget.w == 8)) {
                            ConstraintWidget constraintWidget6 = this.e[i13];
                            ConstraintWidget constraintWidget7 = this.d[i14];
                            if (constraintWidget != constraintWidget6) {
                                constraintWidget.i(constraintWidget.f1348a, constraintWidget6.f1348a, 0);
                                constraintWidget.i(constraintWidget.f1371c, constraintWidget6.f1371c, 0);
                            }
                            if (constraintWidget != constraintWidget7) {
                                constraintWidget.i(constraintWidget.f1363b, constraintWidget7.f1363b, 0);
                                constraintWidget.i(constraintWidget.f1376d, constraintWidget7.f1376d, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            arrayList.get(0).b(0, z2, true);
        }
        this.l = false;
    }

    public final void j(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.j(constraintWidget, hashMap);
        d dVar = (d) constraintWidget;
        this.K = dVar.K;
        this.L = dVar.L;
        this.M = dVar.M;
        this.N = dVar.N;
        this.O = dVar.O;
        this.P = dVar.P;
        this.h = dVar.h;
        this.i = dVar.i;
        this.j = dVar.j;
        this.k = dVar.k;
        this.l = dVar.l;
        this.m = dVar.m;
        this.Q = dVar.Q;
        this.R = dVar.R;
        this.S = dVar.S;
        this.T = dVar.T;
        this.U = dVar.U;
        this.V = dVar.V;
        this.W = dVar.W;
    }
}
