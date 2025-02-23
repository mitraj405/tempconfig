package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ConstraintWidget {
    public int A;
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public int f1345a = -1;

    /* renamed from: a  reason: collision with other field name */
    public M4 f1346a;

    /* renamed from: a  reason: collision with other field name */
    public af f1347a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintAnchor f1348a;

    /* renamed from: a  reason: collision with other field name */
    public ConstraintWidget f1349a;

    /* renamed from: a  reason: collision with other field name */
    public C0213hC f1350a = null;

    /* renamed from: a  reason: collision with other field name */
    public Object f1351a;

    /* renamed from: a  reason: collision with other field name */
    public String f1352a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<ConstraintAnchor> f1353a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1354a = false;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f1355a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f1356a;

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintAnchor[] f1357a;

    /* renamed from: a  reason: collision with other field name */
    public a[] f1358a;

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintWidget[] f1359a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean[] f1360a = {true, true};
    public float b;

    /* renamed from: b  reason: collision with other field name */
    public int f1361b = -1;

    /* renamed from: b  reason: collision with other field name */
    public M4 f1362b;

    /* renamed from: b  reason: collision with other field name */
    public final ConstraintAnchor f1363b;

    /* renamed from: b  reason: collision with other field name */
    public ConstraintWidget f1364b;

    /* renamed from: b  reason: collision with other field name */
    public String f1365b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1366b = true;

    /* renamed from: b  reason: collision with other field name */
    public int[] f1367b;

    /* renamed from: b  reason: collision with other field name */
    public final ConstraintWidget[] f1368b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean[] f1369b;
    public float c;

    /* renamed from: c  reason: collision with other field name */
    public int f1370c;

    /* renamed from: c  reason: collision with other field name */
    public final ConstraintAnchor f1371c;

    /* renamed from: c  reason: collision with other field name */
    public ConstraintWidget f1372c;

    /* renamed from: c  reason: collision with other field name */
    public String f1373c;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f1374c = true;
    public float d;

    /* renamed from: d  reason: collision with other field name */
    public int f1375d;

    /* renamed from: d  reason: collision with other field name */
    public final ConstraintAnchor f1376d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f1377d;
    public float e;

    /* renamed from: e  reason: collision with other field name */
    public int f1378e;

    /* renamed from: e  reason: collision with other field name */
    public final ConstraintAnchor f1379e;

    /* renamed from: e  reason: collision with other field name */
    public boolean f1380e;
    public float f;

    /* renamed from: f  reason: collision with other field name */
    public int f1381f;

    /* renamed from: f  reason: collision with other field name */
    public final ConstraintAnchor f1382f;

    /* renamed from: f  reason: collision with other field name */
    public boolean f1383f;
    public float g;

    /* renamed from: g  reason: collision with other field name */
    public int f1384g;

    /* renamed from: g  reason: collision with other field name */
    public final ConstraintAnchor f1385g;

    /* renamed from: g  reason: collision with other field name */
    public boolean f1386g;
    public int h;

    /* renamed from: h  reason: collision with other field name */
    public final ConstraintAnchor f1387h;

    /* renamed from: h  reason: collision with other field name */
    public boolean f1388h;
    public int i;

    /* renamed from: i  reason: collision with other field name */
    public boolean f1389i;
    public int j;

    /* renamed from: j  reason: collision with other field name */
    public boolean f1390j;
    public int k;

    /* renamed from: k  reason: collision with other field name */
    public boolean f1391k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    public enum a {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        new HashMap();
        this.f1377d = false;
        this.f1380e = false;
        this.f1383f = false;
        this.f1386g = false;
        this.f1370c = -1;
        this.f1375d = -1;
        this.f1378e = 0;
        this.f1381f = 0;
        this.f1384g = 0;
        this.f1356a = new int[2];
        this.h = 0;
        this.i = 0;
        this.a = 1.0f;
        this.j = 0;
        this.k = 0;
        this.b = 1.0f;
        this.l = -1;
        this.c = 1.0f;
        this.f1367b = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.d = 0.0f;
        this.f1388h = false;
        this.f1390j = false;
        this.m = 0;
        this.n = 0;
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.f1348a = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.f1363b = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.f1371c = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.f1376d = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.f1379e = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.f1382f = constraintAnchor6;
        ConstraintAnchor constraintAnchor7 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.f1385g = constraintAnchor7;
        ConstraintAnchor constraintAnchor8 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.f1387h = constraintAnchor8;
        this.f1357a = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor8};
        ArrayList<ConstraintAnchor> arrayList = new ArrayList<>();
        this.f1353a = arrayList;
        this.f1369b = new boolean[2];
        a aVar = a.FIXED;
        this.f1358a = new a[]{aVar, aVar};
        this.f1349a = null;
        this.o = 0;
        this.p = 0;
        this.e = 0.0f;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.f = 0.5f;
        this.g = 0.5f;
        this.w = 0;
        this.f1391k = false;
        this.f1365b = null;
        this.f1373c = null;
        this.x = 0;
        this.y = 0;
        this.f1355a = new float[]{-1.0f, -1.0f};
        this.f1359a = new ConstraintWidget[]{null, null};
        this.f1368b = new ConstraintWidget[]{null, null};
        this.f1364b = null;
        this.f1372c = null;
        this.z = -1;
        this.A = -1;
        arrayList.add(constraintAnchor);
        arrayList.add(constraintAnchor2);
        arrayList.add(constraintAnchor3);
        arrayList.add(constraintAnchor4);
        arrayList.add(constraintAnchor6);
        arrayList.add(constraintAnchor7);
        arrayList.add(constraintAnchor8);
        arrayList.add(constraintAnchor5);
    }

    public static void K(String str, int i2, int i3, StringBuilder sb) {
        if (i2 != i3) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(i2);
            sb.append(",\n");
        }
    }

    public static void L(StringBuilder sb, String str, float f2, float f3) {
        if (f2 != f3) {
            sb.append(str);
            sb.append(" :   ");
            sb.append(f2);
            sb.append(",\n");
        }
    }

    public static void s(StringBuilder sb, String str, int i2, int i3, int i4, int i5, int i6, float f2) {
        sb.append(str);
        sb.append(" :  {\n");
        K("      size", i2, 0, sb);
        K("      min", i3, 0, sb);
        K("      max", i4, Integer.MAX_VALUE, sb);
        K("      matchMin", i5, 0, sb);
        K("      matchDef", i6, 0, sb);
        L(sb, "      matchPercent", f2, 1.0f);
        sb.append("    },\n");
    }

    public static void t(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f1339a != null) {
            sb.append("    ");
            sb.append(str);
            sb.append(" : [ '");
            sb.append(constraintAnchor.f1339a);
            sb.append("'");
            if (!(constraintAnchor.c == Integer.MIN_VALUE && constraintAnchor.b == 0)) {
                sb.append(",");
                sb.append(constraintAnchor.b);
                if (constraintAnchor.c != Integer.MIN_VALUE) {
                    sb.append(",");
                    sb.append(constraintAnchor.c);
                    sb.append(",");
                }
            }
            sb.append(" ] ,\n");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r4 = r0[r4 + 1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean A(int r4) {
        /*
            r3 = this;
            int r4 = r4 * 2
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r3.f1357a
            r1 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f1339a
            if (r2 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f1339a
            if (r2 == r1) goto L_0x001b
            r1 = 1
            int r4 = r4 + r1
            r4 = r0[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r4.f1339a
            if (r0 == 0) goto L_0x001b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1339a
            if (r0 != r4) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.A(int):boolean");
    }

    public final boolean B() {
        ConstraintAnchor constraintAnchor = this.f1348a;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1339a;
        if (constraintAnchor2 != null && constraintAnchor2.f1339a == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.f1371c;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1339a;
        if (constraintAnchor4 == null || constraintAnchor4.f1339a != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public final boolean C() {
        ConstraintAnchor constraintAnchor = this.f1363b;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1339a;
        if (constraintAnchor2 != null && constraintAnchor2.f1339a == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.f1376d;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1339a;
        if (constraintAnchor4 == null || constraintAnchor4.f1339a != constraintAnchor3) {
            return false;
        }
        return true;
    }

    public final boolean D() {
        if (!this.f1366b || this.w == 8) {
            return false;
        }
        return true;
    }

    public boolean E() {
        if (this.f1377d || (this.f1348a.f1343a && this.f1371c.f1343a)) {
            return true;
        }
        return false;
    }

    public boolean F() {
        if (this.f1380e || (this.f1363b.f1343a && this.f1376d.f1343a)) {
            return true;
        }
        return false;
    }

    public void G() {
        this.f1348a.j();
        this.f1363b.j();
        this.f1371c.j();
        this.f1376d.j();
        this.f1379e.j();
        this.f1382f.j();
        this.f1385g.j();
        this.f1387h.j();
        this.f1349a = null;
        this.d = 0.0f;
        this.o = 0;
        this.p = 0;
        this.e = 0.0f;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.f = 0.5f;
        this.g = 0.5f;
        a[] aVarArr = this.f1358a;
        a aVar = a.FIXED;
        aVarArr[0] = aVar;
        aVarArr[1] = aVar;
        this.f1351a = null;
        this.w = 0;
        this.f1373c = null;
        this.x = 0;
        this.y = 0;
        float[] fArr = this.f1355a;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.f1370c = -1;
        this.f1375d = -1;
        int[] iArr = this.f1367b;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.f1381f = 0;
        this.f1384g = 0;
        this.a = 1.0f;
        this.b = 1.0f;
        this.i = Integer.MAX_VALUE;
        this.k = Integer.MAX_VALUE;
        this.h = 0;
        this.j = 0;
        this.l = -1;
        this.c = 1.0f;
        boolean[] zArr = this.f1360a;
        zArr[0] = true;
        zArr[1] = true;
        this.f1390j = false;
        boolean[] zArr2 = this.f1369b;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1366b = true;
        int[] iArr2 = this.f1356a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f1345a = -1;
        this.f1361b = -1;
    }

    public final void H() {
        ConstraintWidget constraintWidget = this.f1349a;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            ((ConstraintWidgetContainer) constraintWidget).getClass();
        }
        ArrayList<ConstraintAnchor> arrayList = this.f1353a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.get(i2).j();
        }
    }

    public final void I() {
        this.f1377d = false;
        this.f1380e = false;
        this.f1383f = false;
        this.f1386g = false;
        ArrayList<ConstraintAnchor> arrayList = this.f1353a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = arrayList.get(i2);
            constraintAnchor.f1343a = false;
            constraintAnchor.a = 0;
        }
    }

    public void J(y3 y3Var) {
        this.f1348a.k();
        this.f1363b.k();
        this.f1371c.k();
        this.f1376d.k();
        this.f1379e.k();
        this.f1387h.k();
        this.f1382f.k();
        this.f1385g.k();
    }

    public final void M(int i2, int i3) {
        if (!this.f1377d) {
            this.f1348a.l(i2);
            this.f1371c.l(i3);
            this.r = i2;
            this.o = i3 - i2;
            this.f1377d = true;
        }
    }

    public final void N(int i2, int i3) {
        if (!this.f1380e) {
            this.f1363b.l(i2);
            this.f1376d.l(i3);
            this.s = i2;
            this.p = i3 - i2;
            if (this.f1388h) {
                this.f1379e.l(i2 + this.t);
            }
            this.f1380e = true;
        }
    }

    public final void O(int i2) {
        this.p = i2;
        int i3 = this.v;
        if (i2 < i3) {
            this.p = i3;
        }
    }

    public final void P(a aVar) {
        this.f1358a[0] = aVar;
    }

    public final void Q(a aVar) {
        this.f1358a[1] = aVar;
    }

    public final void R(int i2) {
        this.o = i2;
        int i3 = this.u;
        if (i2 < i3) {
            this.o = i3;
        }
    }

    public void S(boolean z2, boolean z3) {
        int i2;
        int i3;
        af afVar = this.f1347a;
        boolean z4 = z2 & afVar.f84a;
        C0213hC hCVar = this.f1350a;
        boolean z5 = z3 & hCVar.f84a;
        int i4 = afVar.f79a.c;
        int i5 = hCVar.f79a.c;
        int i6 = afVar.f85b.c;
        int i7 = hCVar.f85b.c;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i7 = 0;
            i4 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (z4) {
            this.r = i4;
        }
        if (z5) {
            this.s = i5;
        }
        if (this.w == 8) {
            this.o = 0;
            this.p = 0;
            return;
        }
        a aVar = a.FIXED;
        if (z4) {
            if (this.f1358a[0] == aVar && i9 < (i3 = this.o)) {
                i9 = i3;
            }
            this.o = i9;
            int i11 = this.u;
            if (i9 < i11) {
                this.o = i11;
            }
        }
        if (z5) {
            if (this.f1358a[1] == aVar && i10 < (i2 = this.p)) {
                i10 = i2;
            }
            this.p = i10;
            int i12 = this.v;
            if (i10 < i12) {
                this.p = i12;
            }
        }
    }

    public void T(ei eiVar, boolean z2) {
        int i2;
        int i3;
        C0213hC hCVar;
        af afVar;
        eiVar.getClass();
        int n2 = ei.n(this.f1348a);
        int n3 = ei.n(this.f1363b);
        int n4 = ei.n(this.f1371c);
        int n5 = ei.n(this.f1376d);
        if (z2 && (afVar = this.f1347a) != null) {
            N8 n8 = afVar.f79a;
            if (n8.f436c) {
                N8 n82 = afVar.f85b;
                if (n82.f436c) {
                    n2 = n8.c;
                    n4 = n82.c;
                }
            }
        }
        if (z2 && (hCVar = this.f1350a) != null) {
            N8 n83 = hCVar.f79a;
            if (n83.f436c) {
                N8 n84 = hCVar.f85b;
                if (n84.f436c) {
                    n3 = n83.c;
                    n5 = n84.c;
                }
            }
        }
        int i4 = n5 - n3;
        if (n4 - n2 < 0 || i4 < 0 || n2 == Integer.MIN_VALUE || n2 == Integer.MAX_VALUE || n3 == Integer.MIN_VALUE || n3 == Integer.MAX_VALUE || n4 == Integer.MIN_VALUE || n4 == Integer.MAX_VALUE || n5 == Integer.MIN_VALUE || n5 == Integer.MAX_VALUE) {
            n2 = 0;
            n3 = 0;
            n4 = 0;
            n5 = 0;
        }
        int i5 = n4 - n2;
        int i6 = n5 - n3;
        this.r = n2;
        this.s = n3;
        if (this.w == 8) {
            this.o = 0;
            this.p = 0;
            return;
        }
        a[] aVarArr = this.f1358a;
        a aVar = aVarArr[0];
        a aVar2 = a.FIXED;
        if (aVar == aVar2 && i5 < (i3 = this.o)) {
            i5 = i3;
        }
        if (aVarArr[1] == aVar2 && i6 < (i2 = this.p)) {
            i6 = i2;
        }
        this.o = i5;
        this.p = i6;
        int i7 = this.v;
        if (i6 < i7) {
            this.p = i7;
        }
        int i8 = this.u;
        if (i5 < i8) {
            this.o = i8;
        }
        int i9 = this.i;
        a aVar3 = a.MATCH_CONSTRAINT;
        if (i9 > 0 && aVar == aVar3) {
            this.o = Math.min(this.o, i9);
        }
        int i10 = this.k;
        if (i10 > 0 && this.f1358a[1] == aVar3) {
            this.p = Math.min(this.p, i10);
        }
        int i11 = this.o;
        if (i5 != i11) {
            this.f1345a = i11;
        }
        int i12 = this.p;
        if (i6 != i12) {
            this.f1361b = i12;
        }
    }

    public final void d(ConstraintWidgetContainer constraintWidgetContainer, ei eiVar, HashSet<ConstraintWidget> hashSet, int i2, boolean z2) {
        if (z2) {
            if (hashSet.contains(this)) {
                f.a(constraintWidgetContainer, eiVar, this);
                hashSet.remove(this);
                e(eiVar, constraintWidgetContainer.Z(64));
            } else {
                return;
            }
        }
        if (i2 == 0) {
            HashSet<ConstraintAnchor> hashSet2 = this.f1348a.f1341a;
            if (hashSet2 != null) {
                Iterator<ConstraintAnchor> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().f1340a.d(constraintWidgetContainer, eiVar, hashSet, i2, true);
                }
            }
            HashSet<ConstraintAnchor> hashSet3 = this.f1371c.f1341a;
            if (hashSet3 != null) {
                Iterator<ConstraintAnchor> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().f1340a.d(constraintWidgetContainer, eiVar, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> hashSet4 = this.f1363b.f1341a;
        if (hashSet4 != null) {
            Iterator<ConstraintAnchor> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().f1340a.d(constraintWidgetContainer, eiVar, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet5 = this.f1376d.f1341a;
        if (hashSet5 != null) {
            Iterator<ConstraintAnchor> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().f1340a.d(constraintWidgetContainer, eiVar, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet6 = this.f1379e.f1341a;
        if (hashSet6 != null) {
            Iterator<ConstraintAnchor> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().f1340a.d(constraintWidgetContainer, eiVar, hashSet, i2, true);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: int} */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e3, code lost:
        if (r0.d() > r3.b.get().d()) goto L_0x00e8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0268  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x02e6  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x02fb  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x030c  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x030f  */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x033c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:283:0x043d  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x0460  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x047e  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0480  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0485  */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x04b4  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x04ff  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x05c2  */
    /* JADX WARNING: Removed duplicated region for block: B:365:0x0624  */
    /* JADX WARNING: Removed duplicated region for block: B:369:0x0638  */
    /* JADX WARNING: Removed duplicated region for block: B:370:0x063a  */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0641  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x06ca  */
    /* JADX WARNING: Removed duplicated region for block: B:408:0x06cd  */
    /* JADX WARNING: Removed duplicated region for block: B:410:0x070e  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0714  */
    /* JADX WARNING: Removed duplicated region for block: B:416:0x0773  */
    /* JADX WARNING: Removed duplicated region for block: B:419:0x077d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0127  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(defpackage.ei r65, boolean r66) {
        /*
            r64 = this;
            r15 = r64
            r14 = r65
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r15.f1348a
            yx r13 = r14.k(r0)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r15.f1371c
            yx r12 = r14.k(r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.f1363b
            yx r11 = r14.k(r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r15.f1376d
            yx r9 = r14.k(r10)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r15.f1379e
            yx r7 = r14.k(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            r5 = 0
            if (r3 == 0) goto L_0x0050
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r3 = r3.f1358a
            r4 = r3[r5]
            if (r4 != r6) goto L_0x0031
            r4 = 1
            goto L_0x0032
        L_0x0031:
            r4 = r5
        L_0x0032:
            r5 = 1
            r3 = r3[r5]
            if (r3 != r6) goto L_0x003a
            r20 = r5
            goto L_0x003c
        L_0x003a:
            r20 = 0
        L_0x003c:
            int r3 = r15.f1378e
            if (r3 == r5) goto L_0x004b
            r5 = 2
            if (r3 == r5) goto L_0x0052
            r5 = 3
            if (r3 == r5) goto L_0x0050
            r29 = r4
            r28 = r20
            goto L_0x0056
        L_0x004b:
            r29 = r4
            r28 = 0
            goto L_0x0056
        L_0x0050:
            r20 = 0
        L_0x0052:
            r28 = r20
            r29 = 0
        L_0x0056:
            int r3 = r15.w
            r5 = 8
            boolean[] r4 = r15.f1369b
            if (r3 != r5) goto L_0x009c
            boolean r3 = r15.f1391k
            if (r3 != 0) goto L_0x009c
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r15.f1353a
            int r5 = r3.size()
            r21 = r6
            r6 = 0
        L_0x006b:
            if (r6 >= r5) goto L_0x008e
            java.lang.Object r22 = r3.get(r6)
            r23 = r3
            r3 = r22
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r3
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r3.f1341a
            if (r3 != 0) goto L_0x007c
            goto L_0x0084
        L_0x007c:
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0084
            r3 = 1
            goto L_0x0085
        L_0x0084:
            r3 = 0
        L_0x0085:
            if (r3 == 0) goto L_0x0089
            r3 = 1
            goto L_0x008f
        L_0x0089:
            int r6 = r6 + 1
            r3 = r23
            goto L_0x006b
        L_0x008e:
            r3 = 0
        L_0x008f:
            if (r3 != 0) goto L_0x009e
            r3 = 0
            boolean r5 = r4[r3]
            if (r5 != 0) goto L_0x009e
            r3 = 1
            boolean r5 = r4[r3]
            if (r5 != 0) goto L_0x009e
            return
        L_0x009c:
            r21 = r6
        L_0x009e:
            boolean r3 = r15.f1377d
            if (r3 != 0) goto L_0x00ac
            boolean r5 = r15.f1380e
            if (r5 == 0) goto L_0x00a7
            goto L_0x00ac
        L_0x00a7:
            r23 = r4
            r6 = 5
            goto L_0x01b8
        L_0x00ac:
            boolean r5 = r15.f1374c
            if (r3 == 0) goto L_0x0121
            int r3 = r15.r
            r14.d(r13, r3)
            int r3 = r15.r
            int r6 = r15.o
            int r3 = r3 + r6
            r14.d(r12, r3)
            if (r29 == 0) goto L_0x0121
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r15.f1349a
            if (r3 == 0) goto L_0x0121
            if (r5 == 0) goto L_0x0113
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r3
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r6 = r3.b
            if (r6 == 0) goto L_0x00e6
            java.lang.Object r6 = r6.get()
            if (r6 == 0) goto L_0x00e6
            int r6 = r0.d()
            r23 = r4
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r4 = r3.b
            java.lang.Object r4 = r4.get()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r4
            int r4 = r4.d()
            if (r6 <= r4) goto L_0x00ef
            goto L_0x00e8
        L_0x00e6:
            r23 = r4
        L_0x00e8:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r0)
            r3.b = r4
        L_0x00ef:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r4 = r3.d
            if (r4 == 0) goto L_0x010b
            java.lang.Object r4 = r4.get()
            if (r4 == 0) goto L_0x010b
            int r4 = r1.d()
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r6 = r3.d
            java.lang.Object r6 = r6.get()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r6
            int r6 = r6.d()
            if (r4 <= r6) goto L_0x0123
        L_0x010b:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r1)
            r3.d = r4
            goto L_0x0123
        L_0x0113:
            r23 = r4
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1371c
            yx r3 = r14.k(r3)
            r4 = 5
            r6 = 0
            r14.f(r3, r12, r6, r4)
            goto L_0x0123
        L_0x0121:
            r23 = r4
        L_0x0123:
            boolean r3 = r15.f1380e
            if (r3 == 0) goto L_0x01a9
            int r3 = r15.s
            r14.d(r11, r3)
            int r3 = r15.s
            int r4 = r15.p
            int r3 = r3 + r4
            r14.d(r9, r3)
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r3 = r8.f1341a
            if (r3 != 0) goto L_0x0139
            goto L_0x0141
        L_0x0139:
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0141
            r3 = 1
            goto L_0x0142
        L_0x0141:
            r3 = 0
        L_0x0142:
            if (r3 == 0) goto L_0x014c
            int r3 = r15.s
            int r4 = r15.t
            int r3 = r3 + r4
            r14.d(r7, r3)
        L_0x014c:
            if (r28 == 0) goto L_0x01a9
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r15.f1349a
            if (r3 == 0) goto L_0x01a9
            if (r5 == 0) goto L_0x019d
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r3
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r4 = r3.f1397a
            if (r4 == 0) goto L_0x0172
            java.lang.Object r4 = r4.get()
            if (r4 == 0) goto L_0x0172
            int r4 = r2.d()
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r5 = r3.f1397a
            java.lang.Object r5 = r5.get()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            int r5 = r5.d()
            if (r4 <= r5) goto L_0x0179
        L_0x0172:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r2)
            r3.f1397a = r4
        L_0x0179:
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r4 = r3.c
            if (r4 == 0) goto L_0x0195
            java.lang.Object r4 = r4.get()
            if (r4 == 0) goto L_0x0195
            int r4 = r10.d()
            java.lang.ref.WeakReference<androidx.constraintlayout.core.widgets.ConstraintAnchor> r5 = r3.c
            java.lang.Object r5 = r5.get()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = (androidx.constraintlayout.core.widgets.ConstraintAnchor) r5
            int r5 = r5.d()
            if (r4 <= r5) goto L_0x01a9
        L_0x0195:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r10)
            r3.c = r4
            goto L_0x01a9
        L_0x019d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1376d
            yx r3 = r14.k(r3)
            r4 = 0
            r6 = 5
            r14.f(r3, r9, r4, r6)
            goto L_0x01ab
        L_0x01a9:
            r4 = 0
            r6 = 5
        L_0x01ab:
            boolean r3 = r15.f1377d
            if (r3 == 0) goto L_0x01b8
            boolean r3 = r15.f1380e
            if (r3 == 0) goto L_0x01b8
            r15.f1377d = r4
            r15.f1380e = r4
            return
        L_0x01b8:
            androidx.constraintlayout.core.Metrics r3 = defpackage.ei.a
            r4 = 1
            r22 = r7
            if (r3 == 0) goto L_0x01c5
            long r6 = r3.h
            long r6 = r6 + r4
            r3.h = r6
        L_0x01c5:
            boolean[] r7 = r15.f1360a
            if (r66 == 0) goto L_0x0263
            af r6 = r15.f1347a
            if (r6 == 0) goto L_0x0263
            hC r4 = r15.f1350a
            if (r4 == 0) goto L_0x0263
            N8 r5 = r6.f79a
            r30 = r8
            boolean r8 = r5.f436c
            if (r8 == 0) goto L_0x0260
            N8 r6 = r6.f85b
            boolean r6 = r6.f436c
            if (r6 == 0) goto L_0x0260
            N8 r6 = r4.f79a
            boolean r6 = r6.f436c
            if (r6 == 0) goto L_0x0260
            N8 r4 = r4.f85b
            boolean r4 = r4.f436c
            if (r4 == 0) goto L_0x0260
            if (r3 == 0) goto L_0x01f5
            long r0 = r3.d
            r16 = 1
            long r0 = r0 + r16
            r3.d = r0
        L_0x01f5:
            int r0 = r5.c
            r14.d(r13, r0)
            af r0 = r15.f1347a
            N8 r0 = r0.f85b
            int r0 = r0.c
            r14.d(r12, r0)
            hC r0 = r15.f1350a
            N8 r0 = r0.f79a
            int r0 = r0.c
            r14.d(r11, r0)
            hC r0 = r15.f1350a
            N8 r0 = r0.f85b
            int r0 = r0.c
            r14.d(r9, r0)
            hC r0 = r15.f1350a
            N8 r0 = r0.c
            int r0 = r0.c
            r8 = r22
            r14.d(r8, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            if (r0 == 0) goto L_0x025a
            if (r29 == 0) goto L_0x023e
            r0 = 0
            boolean r1 = r7[r0]
            if (r1 == 0) goto L_0x023e
            boolean r1 = r64.B()
            if (r1 != 0) goto L_0x023e
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1371c
            yx r1 = r14.k(r1)
            r2 = 8
            r14.f(r1, r12, r0, r2)
        L_0x023e:
            if (r28 == 0) goto L_0x025a
            r0 = 1
            boolean r0 = r7[r0]
            if (r0 == 0) goto L_0x025a
            boolean r0 = r64.C()
            if (r0 != 0) goto L_0x025a
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1376d
            yx r0 = r14.k(r0)
            r1 = 8
            r2 = 0
            r14.f(r0, r9, r2, r1)
            goto L_0x025b
        L_0x025a:
            r2 = 0
        L_0x025b:
            r15.f1377d = r2
            r15.f1380e = r2
            return
        L_0x0260:
            r8 = r22
            goto L_0x0266
        L_0x0263:
            r30 = r8
            goto L_0x0260
        L_0x0266:
            if (r3 == 0) goto L_0x0270
            long r4 = r3.e
            r24 = 1
            long r4 = r4 + r24
            r3.e = r4
        L_0x0270:
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r15.f1349a
            if (r3 == 0) goto L_0x02e6
            r3 = 0
            boolean r4 = r15.A(r3)
            if (r4 == 0) goto L_0x0284
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r4 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r4
            r4.V(r3, r15)
            r3 = 1
            goto L_0x0288
        L_0x0284:
            boolean r3 = r64.B()
        L_0x0288:
            r4 = 1
            boolean r5 = r15.A(r4)
            if (r5 == 0) goto L_0x0298
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r5 = (androidx.constraintlayout.core.widgets.ConstraintWidgetContainer) r5
            r5.V(r4, r15)
            r4 = 1
            goto L_0x029c
        L_0x0298:
            boolean r4 = r64.C()
        L_0x029c:
            if (r3 != 0) goto L_0x02be
            if (r29 == 0) goto L_0x02be
            int r5 = r15.w
            r6 = 8
            if (r5 == r6) goto L_0x02be
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r0.f1339a
            if (r5 != 0) goto L_0x02be
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r1.f1339a
            if (r5 != 0) goto L_0x02be
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1371c
            yx r5 = r14.k(r5)
            r22 = r3
            r3 = 0
            r6 = 1
            r14.f(r5, r12, r3, r6)
            goto L_0x02c0
        L_0x02be:
            r22 = r3
        L_0x02c0:
            if (r4 != 0) goto L_0x02e1
            if (r28 == 0) goto L_0x02e1
            int r3 = r15.w
            r5 = 8
            if (r3 == r5) goto L_0x02e1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1339a
            if (r3 != 0) goto L_0x02e1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r10.f1339a
            if (r3 != 0) goto L_0x02e1
            if (r30 != 0) goto L_0x02e1
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1376d
            yx r3 = r14.k(r3)
            r5 = 1
            r6 = 0
            r14.f(r3, r9, r6, r5)
        L_0x02e1:
            r31 = r4
            r32 = r22
            goto L_0x02ea
        L_0x02e6:
            r31 = 0
            r32 = 0
        L_0x02ea:
            int r3 = r15.o
            int r4 = r15.u
            if (r3 >= r4) goto L_0x02f1
            goto L_0x02f2
        L_0x02f1:
            r4 = r3
        L_0x02f2:
            int r5 = r15.p
            int r6 = r15.v
            r22 = r4
            if (r5 >= r6) goto L_0x02fb
            goto L_0x02fc
        L_0x02fb:
            r6 = r5
        L_0x02fc:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r4 = r15.f1358a
            r24 = r6
            r19 = 0
            r6 = r4[r19]
            r33 = r11
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            r18 = 1
            if (r6 == r11) goto L_0x030f
            r25 = 1
            goto L_0x0311
        L_0x030f:
            r25 = 0
        L_0x0311:
            r4 = r4[r18]
            r34 = r8
            if (r4 == r11) goto L_0x031a
            r26 = 1
            goto L_0x031c
        L_0x031a:
            r26 = 0
        L_0x031c:
            int r8 = r15.q
            r15.l = r8
            r35 = r9
            float r9 = r15.e
            r15.c = r9
            r36 = r7
            int r7 = r15.f1381f
            r37 = r12
            int r12 = r15.f1384g
            r38 = 0
            int r38 = (r9 > r38 ? 1 : (r9 == r38 ? 0 : -1))
            r39 = r13
            if (r38 <= 0) goto L_0x043d
            int r13 = r15.w
            r14 = 8
            if (r13 == r14) goto L_0x043d
            if (r6 != r11) goto L_0x0341
            if (r7 != 0) goto L_0x0341
            r7 = 3
        L_0x0341:
            if (r4 != r11) goto L_0x0346
            if (r12 != 0) goto L_0x0346
            r12 = 3
        L_0x0346:
            if (r6 != r11) goto L_0x03f8
            if (r4 != r11) goto L_0x03f8
            r13 = 3
            if (r7 != r13) goto L_0x03f8
            if (r12 != r13) goto L_0x03f8
            r13 = -1
            if (r8 != r13) goto L_0x0369
            if (r25 == 0) goto L_0x035a
            if (r26 != 0) goto L_0x035a
            r3 = 0
            r15.l = r3
            goto L_0x0369
        L_0x035a:
            if (r25 != 0) goto L_0x0369
            if (r26 == 0) goto L_0x0369
            r3 = 1
            r15.l = r3
            if (r8 != r13) goto L_0x0369
            r3 = 1065353216(0x3f800000, float:1.0)
            float r13 = r3 / r9
            r15.c = r13
        L_0x0369:
            int r3 = r15.l
            if (r3 != 0) goto L_0x037d
            boolean r3 = r2.h()
            if (r3 == 0) goto L_0x0379
            boolean r3 = r10.h()
            if (r3 != 0) goto L_0x037d
        L_0x0379:
            r3 = 1
            r15.l = r3
            goto L_0x0391
        L_0x037d:
            r3 = 1
            int r4 = r15.l
            if (r4 != r3) goto L_0x0391
            boolean r3 = r0.h()
            if (r3 == 0) goto L_0x038e
            boolean r3 = r1.h()
            if (r3 != 0) goto L_0x0391
        L_0x038e:
            r3 = 0
            r15.l = r3
        L_0x0391:
            int r3 = r15.l
            r4 = -1
            if (r3 != r4) goto L_0x03d5
            boolean r3 = r2.h()
            if (r3 == 0) goto L_0x03ae
            boolean r3 = r10.h()
            if (r3 == 0) goto L_0x03ae
            boolean r3 = r0.h()
            if (r3 == 0) goto L_0x03ae
            boolean r3 = r1.h()
            if (r3 != 0) goto L_0x03d5
        L_0x03ae:
            boolean r2 = r2.h()
            if (r2 == 0) goto L_0x03be
            boolean r2 = r10.h()
            if (r2 == 0) goto L_0x03be
            r2 = 0
            r15.l = r2
            goto L_0x03d5
        L_0x03be:
            boolean r0 = r0.h()
            if (r0 == 0) goto L_0x03d5
            boolean r0 = r1.h()
            if (r0 == 0) goto L_0x03d5
            float r0 = r15.c
            r1 = 1065353216(0x3f800000, float:1.0)
            float r13 = r1 / r0
            r15.c = r13
            r0 = 1
            r15.l = r0
        L_0x03d5:
            int r0 = r15.l
            r1 = -1
            if (r0 != r1) goto L_0x042e
            int r0 = r15.h
            if (r0 <= 0) goto L_0x03e6
            int r1 = r15.j
            if (r1 != 0) goto L_0x03e6
            r1 = 0
            r15.l = r1
            goto L_0x042e
        L_0x03e6:
            if (r0 != 0) goto L_0x042e
            int r0 = r15.j
            if (r0 <= 0) goto L_0x042e
            float r0 = r15.c
            r1 = 1065353216(0x3f800000, float:1.0)
            float r13 = r1 / r0
            r15.c = r13
            r0 = 1
            r15.l = r0
            goto L_0x042e
        L_0x03f8:
            r0 = 4
            r1 = 3
            if (r6 != r11) goto L_0x040f
            if (r7 != r1) goto L_0x040f
            r2 = 0
            r15.l = r2
            float r1 = (float) r5
            float r9 = r9 * r1
            int r1 = (int) r9
            if (r4 == r11) goto L_0x040b
            r7 = r0
            r4 = r1
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0441
        L_0x040b:
            r4 = r1
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0432
        L_0x040f:
            if (r4 != r11) goto L_0x042e
            if (r12 != r1) goto L_0x042e
            r1 = 1
            r15.l = r1
            r1 = -1
            r13 = 1065353216(0x3f800000, float:1.0)
            if (r8 != r1) goto L_0x041f
            float r1 = r13 / r9
            r15.c = r1
        L_0x041f:
            float r1 = r15.c
            float r2 = (float) r3
            float r1 = r1 * r2
            int r1 = (int) r1
            if (r6 == r11) goto L_0x042a
            r6 = r1
            r4 = r22
            goto L_0x0444
        L_0x042a:
            r6 = r1
            r4 = r22
            goto L_0x0434
        L_0x042e:
            r13 = 1065353216(0x3f800000, float:1.0)
            r4 = r22
        L_0x0432:
            r6 = r24
        L_0x0434:
            r41 = r6
            r43 = r7
            r42 = r12
            r40 = 1
            goto L_0x044c
        L_0x043d:
            r13 = 1065353216(0x3f800000, float:1.0)
            r4 = r22
        L_0x0441:
            r0 = r12
            r6 = r24
        L_0x0444:
            r42 = r0
            r41 = r6
            r43 = r7
            r40 = 0
        L_0x044c:
            int[] r0 = r15.f1356a
            r1 = 0
            r0[r1] = r43
            r1 = 1
            r0[r1] = r42
            if (r40 == 0) goto L_0x0460
            int r0 = r15.l
            r1 = -1
            if (r0 == 0) goto L_0x045d
            if (r0 != r1) goto L_0x0461
        L_0x045d:
            r22 = 1
            goto L_0x0463
        L_0x0460:
            r1 = -1
        L_0x0461:
            r22 = 0
        L_0x0463:
            if (r40 == 0) goto L_0x046f
            int r0 = r15.l
            r2 = 1
            if (r0 == r2) goto L_0x046c
            if (r0 != r1) goto L_0x046f
        L_0x046c:
            r38 = 1
            goto L_0x0471
        L_0x046f:
            r38 = 0
        L_0x0471:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r15.f1358a
            r1 = 0
            r0 = r0[r1]
            r6 = r21
            if (r0 != r6) goto L_0x0480
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x0480
            r9 = 1
            goto L_0x0481
        L_0x0480:
            r9 = 0
        L_0x0481:
            if (r9 == 0) goto L_0x0485
            r14 = 0
            goto L_0x0486
        L_0x0485:
            r14 = r4
        L_0x0486:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r15.f1387h
            boolean r0 = r12.h()
            r1 = 1
            r44 = r0 ^ 1
            r0 = 0
            boolean r21 = r23[r0]
            boolean r45 = r23[r1]
            int r0 = r15.f1370c
            r46 = 0
            r5 = 2
            if (r0 == r5) goto L_0x05aa
            boolean r0 = r15.f1377d
            if (r0 != 0) goto L_0x05aa
            if (r66 == 0) goto L_0x0503
            af r0 = r15.f1347a
            if (r0 == 0) goto L_0x0503
            N8 r1 = r0.f79a
            boolean r2 = r1.f436c
            if (r2 == 0) goto L_0x0503
            N8 r0 = r0.f85b
            boolean r0 = r0.f436c
            if (r0 != 0) goto L_0x04b2
            goto L_0x0503
        L_0x04b2:
            if (r66 == 0) goto L_0x04ff
            int r0 = r1.c
            r8 = r65
            r7 = r39
            r8.d(r7, r0)
            af r0 = r15.f1347a
            N8 r0 = r0.f85b
            int r0 = r0.c
            r4 = r37
            r8.d(r4, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            if (r0 == 0) goto L_0x04e7
            if (r29 == 0) goto L_0x04e7
            r0 = 0
            boolean r1 = r36[r0]
            if (r1 == 0) goto L_0x04e7
            boolean r1 = r64.B()
            if (r1 != 0) goto L_0x04e7
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r15.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1371c
            yx r1 = r8.k(r1)
            r3 = 8
            r8.f(r1, r4, r0, r3)
            goto L_0x04e9
        L_0x04e7:
            r3 = 8
        L_0x04e9:
            r60 = r4
            r53 = r6
            r61 = r7
            r57 = r10
            r59 = r11
            r55 = r30
            r58 = r33
            r54 = r34
            r56 = r35
            r34 = r36
            goto L_0x05be
        L_0x04ff:
            r8 = r65
            goto L_0x05aa
        L_0x0503:
            r8 = r65
            r4 = r37
            r7 = r39
            r3 = 8
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            if (r0 == 0) goto L_0x0518
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1371c
            yx r0 = r8.k(r0)
            r16 = r0
            goto L_0x051a
        L_0x0518:
            r16 = r46
        L_0x051a:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            if (r0 == 0) goto L_0x0527
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1348a
            yx r0 = r8.k(r0)
            r17 = r0
            goto L_0x0529
        L_0x0527:
            r17 = r46
        L_0x0529:
            r19 = 0
            boolean r20 = r36[r19]
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r15.f1358a
            r23 = r0[r19]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r15.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r15.f1371c
            int r13 = r15.r
            r39 = r2
            int r2 = r15.u
            int[] r3 = r15.f1367b
            r48 = r3[r19]
            float r3 = r15.f
            r18 = 1
            r0 = r0[r18]
            if (r0 != r11) goto L_0x054a
            r49 = r18
            goto L_0x054c
        L_0x054a:
            r49 = r19
        L_0x054c:
            int r0 = r15.h
            r24 = r0
            int r0 = r15.i
            r25 = r0
            float r0 = r15.a
            r26 = r0
            r0 = 1
            r50 = r2
            r2 = r0
            r0 = r64
            r51 = r1
            r1 = r65
            r47 = r3
            r52 = 8
            r3 = r29
            r18 = r4
            r4 = r28
            r5 = r20
            r53 = r6
            r6 = r17
            r17 = r7
            r54 = r34
            r34 = r36
            r7 = r16
            r55 = r30
            r8 = r23
            r56 = r35
            r57 = r10
            r10 = r51
            r59 = r11
            r58 = r33
            r11 = r39
            r30 = r12
            r60 = r18
            r12 = r13
            r61 = r17
            r13 = r14
            r14 = r50
            r15 = r48
            r16 = r47
            r17 = r22
            r18 = r49
            r19 = r32
            r20 = r31
            r22 = r43
            r23 = r42
            r27 = r44
            r0.g(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x05c0
        L_0x05aa:
            r53 = r6
            r57 = r10
            r59 = r11
            r55 = r30
            r58 = r33
            r54 = r34
            r56 = r35
            r34 = r36
            r60 = r37
            r61 = r39
        L_0x05be:
            r30 = r12
        L_0x05c0:
            if (r66 == 0) goto L_0x0624
            r15 = r64
            hC r0 = r15.f1350a
            if (r0 == 0) goto L_0x0617
            N8 r1 = r0.f79a
            boolean r2 = r1.f436c
            if (r2 == 0) goto L_0x0617
            N8 r0 = r0.f85b
            boolean r0 = r0.f436c
            if (r0 == 0) goto L_0x0617
            int r0 = r1.c
            r14 = r65
            r13 = r58
            r14.d(r13, r0)
            hC r0 = r15.f1350a
            N8 r0 = r0.f85b
            int r0 = r0.c
            r12 = r56
            r14.d(r12, r0)
            hC r0 = r15.f1350a
            N8 r0 = r0.c
            int r0 = r0.c
            r1 = r54
            r14.d(r1, r0)
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            if (r0 == 0) goto L_0x0611
            if (r31 != 0) goto L_0x0611
            if (r28 == 0) goto L_0x0611
            r11 = 1
            boolean r2 = r34[r11]
            if (r2 == 0) goto L_0x060d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1376d
            yx r0 = r14.k(r0)
            r2 = 8
            r10 = 0
            r14.f(r0, r12, r10, r2)
            goto L_0x0615
        L_0x060d:
            r2 = 8
            r10 = 0
            goto L_0x0615
        L_0x0611:
            r2 = 8
            r10 = 0
            r11 = 1
        L_0x0615:
            r4 = r10
            goto L_0x0633
        L_0x0617:
            r14 = r65
            r1 = r54
            r12 = r56
            r13 = r58
            r2 = 8
            r10 = 0
            r11 = 1
            goto L_0x0632
        L_0x0624:
            r2 = 8
            r10 = 0
            r11 = 1
            r15 = r64
            r14 = r65
            r1 = r54
            r12 = r56
            r13 = r58
        L_0x0632:
            r4 = r11
        L_0x0633:
            int r0 = r15.f1375d
            r3 = 2
            if (r0 != r3) goto L_0x063a
            r5 = r10
            goto L_0x063b
        L_0x063a:
            r5 = r4
        L_0x063b:
            if (r5 == 0) goto L_0x070e
            boolean r0 = r15.f1380e
            if (r0 != 0) goto L_0x070e
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r15.f1358a
            r0 = r0[r11]
            r3 = r53
            if (r0 != r3) goto L_0x064f
            boolean r0 = r15 instanceof androidx.constraintlayout.core.widgets.ConstraintWidgetContainer
            if (r0 == 0) goto L_0x064f
            r9 = r11
            goto L_0x0650
        L_0x064f:
            r9 = r10
        L_0x0650:
            if (r9 == 0) goto L_0x0654
            r41 = r10
        L_0x0654:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            if (r0 == 0) goto L_0x0660
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1376d
            yx r0 = r14.k(r0)
            r7 = r0
            goto L_0x0662
        L_0x0660:
            r7 = r46
        L_0x0662:
            androidx.constraintlayout.core.widgets.ConstraintWidget r0 = r15.f1349a
            if (r0 == 0) goto L_0x066e
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1363b
            yx r0 = r14.k(r0)
            r6 = r0
            goto L_0x0670
        L_0x066e:
            r6 = r46
        L_0x0670:
            int r0 = r15.t
            if (r0 > 0) goto L_0x0678
            int r3 = r15.w
            if (r3 != r2) goto L_0x06ac
        L_0x0678:
            r3 = r55
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r3.f1339a
            if (r4 == 0) goto L_0x069d
            r14.e(r1, r13, r0, r2)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f1339a
            yx r0 = r14.k(r0)
            int r3 = r3.e()
            r14.e(r1, r0, r3, r2)
            if (r28 == 0) goto L_0x069a
            r0 = r57
            yx r0 = r14.k(r0)
            r1 = 5
            r14.f(r7, r0, r10, r1)
        L_0x069a:
            r27 = r10
            goto L_0x06ae
        L_0x069d:
            int r4 = r15.w
            if (r4 != r2) goto L_0x06a9
            int r0 = r3.e()
            r14.e(r1, r13, r0, r2)
            goto L_0x06ac
        L_0x06a9:
            r14.e(r1, r13, r0, r2)
        L_0x06ac:
            r27 = r44
        L_0x06ae:
            boolean r5 = r34[r11]
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r15.f1358a
            r8 = r0[r11]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r15.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r15.f1376d
            int r1 = r15.s
            int r2 = r15.v
            int[] r10 = r15.f1367b
            r16 = r10[r11]
            float r10 = r15.g
            r17 = 0
            r0 = r0[r17]
            r11 = r59
            if (r0 != r11) goto L_0x06cd
            r18 = 1
            goto L_0x06cf
        L_0x06cd:
            r18 = r17
        L_0x06cf:
            int r0 = r15.j
            r24 = r0
            int r0 = r15.k
            r25 = r0
            float r0 = r15.b
            r26 = r0
            r0 = 0
            r19 = r2
            r2 = r0
            r0 = r64
            r20 = r1
            r1 = r65
            r11 = r3
            r3 = r28
            r21 = r4
            r4 = r29
            r17 = r10
            r10 = r21
            r62 = r12
            r12 = r20
            r63 = r13
            r13 = r41
            r14 = r19
            r15 = r16
            r16 = r17
            r17 = r38
            r19 = r31
            r20 = r32
            r21 = r45
            r22 = r42
            r23 = r43
            r0.g(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0712
        L_0x070e:
            r62 = r12
            r63 = r13
        L_0x0712:
            if (r40 == 0) goto L_0x0773
            r0 = r64
            int r1 = r0.l
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3 = 1
            if (r1 != r3) goto L_0x0748
            float r1 = r0.c
            L1 r3 = r65.l()
            L1$a r4 = r3.f377a
            r5 = r62
            r4.j(r5, r2)
            L1$a r2 = r3.f377a
            r4 = r63
            r6 = 1065353216(0x3f800000, float:1.0)
            r2.j(r4, r6)
            L1$a r2 = r3.f377a
            r7 = r60
            r2.j(r7, r1)
            L1$a r2 = r3.f377a
            float r1 = -r1
            r8 = r61
            r2.j(r8, r1)
            r1 = r65
            r1.c(r3)
            goto L_0x0777
        L_0x0748:
            r1 = r65
            r7 = r60
            r8 = r61
            r5 = r62
            r4 = r63
            r6 = 1065353216(0x3f800000, float:1.0)
            float r3 = r0.c
            L1 r9 = r65.l()
            L1$a r10 = r9.f377a
            r10.j(r7, r2)
            L1$a r2 = r9.f377a
            r2.j(r8, r6)
            L1$a r2 = r9.f377a
            r2.j(r5, r3)
            L1$a r2 = r9.f377a
            float r3 = -r3
            r2.j(r4, r3)
            r1.c(r9)
            goto L_0x0777
        L_0x0773:
            r0 = r64
            r1 = r65
        L_0x0777:
            boolean r2 = r30.h()
            if (r2 == 0) goto L_0x0833
            r2 = r30
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1339a
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r3.f1340a
            float r4 = r0.d
            r5 = 1119092736(0x42b40000, float:90.0)
            float r4 = r4 + r5
            double r4 = (double) r4
            double r4 = java.lang.Math.toRadians(r4)
            float r4 = (float) r4
            int r2 = r2.e()
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r0.m(r5)
            yx r6 = r1.k(r6)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r7 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r0.m(r7)
            yx r8 = r1.k(r8)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r0.m(r9)
            yx r10 = r1.k(r10)
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.m(r11)
            yx r12 = r1.k(r12)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r3.m(r5)
            yx r5 = r1.k(r5)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r3.m(r7)
            yx r7 = r1.k(r7)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r9 = r3.m(r9)
            yx r9 = r1.k(r9)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.m(r11)
            yx r3 = r1.k(r3)
            L1 r11 = r65.l()
            double r13 = (double) r4
            double r15 = java.lang.Math.sin(r13)
            r4 = r9
            r66 = r10
            double r9 = (double) r2
            r17 = r4
            r2 = r5
            double r4 = r15 * r9
            float r4 = (float) r4
            L1$a r5 = r11.f377a
            r15 = 1056964608(0x3f000000, float:0.5)
            r5.j(r7, r15)
            L1$a r5 = r11.f377a
            r5.j(r3, r15)
            L1$a r3 = r11.f377a
            r5 = -1090519040(0xffffffffbf000000, float:-0.5)
            r3.j(r8, r5)
            L1$a r3 = r11.f377a
            r3.j(r12, r5)
            float r3 = -r4
            r11.a = r3
            r1.c(r11)
            L1 r3 = r65.l()
            double r7 = java.lang.Math.cos(r13)
            double r7 = r7 * r9
            float r4 = (float) r7
            L1$a r7 = r3.f377a
            r7.j(r2, r15)
            L1$a r2 = r3.f377a
            r7 = r17
            r2.j(r7, r15)
            L1$a r2 = r3.f377a
            r2.j(r6, r5)
            L1$a r2 = r3.f377a
            r6 = r66
            r2.j(r6, r5)
            float r2 = -r4
            r3.a = r2
            r1.c(r3)
        L_0x0833:
            r1 = 0
            r0.f1377d = r1
            r0.f1380e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.e(ei, boolean):void");
    }

    public boolean f() {
        if (this.w != 8) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02ce  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0373 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x03e5  */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0425 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x043f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:297:0x048c  */
    /* JADX WARNING: Removed duplicated region for block: B:310:0x04ac  */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x04b3  */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x04c7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:327:0x04ec A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:353:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:357:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(defpackage.ei r31, boolean r32, boolean r33, boolean r34, boolean r35, defpackage.C0415yx r36, defpackage.C0415yx r37, androidx.constraintlayout.core.widgets.ConstraintWidget.a r38, boolean r39, androidx.constraintlayout.core.widgets.ConstraintAnchor r40, androidx.constraintlayout.core.widgets.ConstraintAnchor r41, int r42, int r43, int r44, int r45, float r46, boolean r47, boolean r48, boolean r49, boolean r50, boolean r51, int r52, int r53, int r54, int r55, float r56, boolean r57) {
        /*
            r30 = this;
            r0 = r30
            r10 = r31
            r11 = r36
            r12 = r37
            r13 = r40
            r14 = r41
            r15 = r44
            r1 = r45
            r2 = r53
            r3 = r54
            r4 = r55
            r5 = r56
            yx r9 = r10.k(r13)
            yx r8 = r10.k(r14)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r13.f1339a
            yx r7 = r10.k(r6)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r14.f1339a
            yx r6 = r10.k(r6)
            boolean r16 = r40.h()
            boolean r17 = r41.h()
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r0.f1387h
            boolean r12 = r12.h()
            if (r17 == 0) goto L_0x003f
            int r18 = r16 + 1
            goto L_0x0041
        L_0x003f:
            r18 = r16
        L_0x0041:
            if (r12 == 0) goto L_0x0045
            int r18 = r18 + 1
        L_0x0045:
            r2 = r18
            if (r47 == 0) goto L_0x004b
            r14 = 3
            goto L_0x004d
        L_0x004b:
            r14 = r52
        L_0x004d:
            int r11 = r38.ordinal()
            r19 = r6
            r6 = 1
            if (r11 == 0) goto L_0x0061
            if (r11 == r6) goto L_0x0061
            r6 = 2
            if (r11 == r6) goto L_0x005c
            goto L_0x0061
        L_0x005c:
            r6 = 4
            if (r14 == r6) goto L_0x0062
            r11 = 1
            goto L_0x0063
        L_0x0061:
            r6 = 4
        L_0x0062:
            r11 = 0
        L_0x0063:
            int r6 = r0.f1345a
            r5 = -1
            if (r6 == r5) goto L_0x006f
            if (r32 == 0) goto L_0x006f
            r0.f1345a = r5
            r43 = r6
            r11 = 0
        L_0x006f:
            int r6 = r0.f1361b
            if (r6 == r5) goto L_0x0079
            if (r32 != 0) goto L_0x0079
            r0.f1361b = r5
            r11 = 0
            goto L_0x007b
        L_0x0079:
            r6 = r43
        L_0x007b:
            int r5 = r0.w
            r43 = r11
            r11 = 8
            if (r5 != r11) goto L_0x0086
            r5 = 0
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r5 = r43
        L_0x0088:
            if (r57 == 0) goto L_0x00ab
            if (r16 != 0) goto L_0x0096
            if (r17 != 0) goto L_0x0096
            if (r12 != 0) goto L_0x0096
            r11 = r42
            r10.d(r9, r11)
            goto L_0x00a6
        L_0x0096:
            if (r16 == 0) goto L_0x00a6
            if (r17 != 0) goto L_0x00a6
            int r11 = r40.e()
            r22 = r12
            r12 = 8
            r10.e(r9, r7, r11, r12)
            goto L_0x00ae
        L_0x00a6:
            r22 = r12
            r12 = 8
            goto L_0x00ae
        L_0x00ab:
            r22 = r12
            r12 = r11
        L_0x00ae:
            if (r5 != 0) goto L_0x00cf
            if (r39 == 0) goto L_0x00c8
            r11 = 3
            r12 = 0
            r10.e(r8, r9, r12, r11)
            r6 = 8
            if (r15 <= 0) goto L_0x00be
            r10.f(r8, r9, r15, r6)
        L_0x00be:
            r11 = 2147483647(0x7fffffff, float:NaN)
            if (r1 >= r11) goto L_0x013f
            r10.g(r8, r9, r1, r6)
            goto L_0x013f
        L_0x00c8:
            r1 = r12
            r12 = 0
            r10.e(r8, r9, r6, r1)
            goto L_0x013f
        L_0x00cf:
            r1 = 2
            r12 = 0
            if (r2 == r1) goto L_0x00f2
            if (r47 != 0) goto L_0x00f2
            r1 = 1
            if (r14 == r1) goto L_0x00da
            if (r14 != 0) goto L_0x00f2
        L_0x00da:
            int r1 = java.lang.Math.max(r3, r6)
            if (r4 <= 0) goto L_0x00e4
            int r1 = java.lang.Math.min(r4, r1)
        L_0x00e4:
            r5 = 8
            r10.e(r8, r9, r1, r5)
            r11 = r35
            r23 = r2
            r24 = r12
            r12 = r3
            goto L_0x01b1
        L_0x00f2:
            r1 = -2
            if (r3 != r1) goto L_0x00f6
            r3 = r6
        L_0x00f6:
            if (r4 != r1) goto L_0x00f9
            r4 = r6
        L_0x00f9:
            if (r6 <= 0) goto L_0x00ff
            r1 = 1
            if (r14 == r1) goto L_0x00ff
            r6 = r12
        L_0x00ff:
            if (r3 <= 0) goto L_0x010a
            r1 = 8
            r10.f(r8, r9, r3, r1)
            int r6 = java.lang.Math.max(r6, r3)
        L_0x010a:
            if (r4 <= 0) goto L_0x0123
            if (r33 == 0) goto L_0x0113
            r1 = 1
            if (r14 != r1) goto L_0x0113
            r1 = r12
            goto L_0x0114
        L_0x0113:
            r1 = 1
        L_0x0114:
            if (r1 == 0) goto L_0x011c
            r1 = 8
            r10.g(r8, r9, r4, r1)
            goto L_0x011e
        L_0x011c:
            r1 = 8
        L_0x011e:
            int r6 = java.lang.Math.min(r6, r4)
            goto L_0x0125
        L_0x0123:
            r1 = 8
        L_0x0125:
            r11 = 1
            if (r14 != r11) goto L_0x0147
            if (r33 == 0) goto L_0x012e
            r10.e(r8, r9, r6, r1)
            goto L_0x013f
        L_0x012e:
            if (r49 == 0) goto L_0x0138
            r11 = 5
            r10.e(r8, r9, r6, r11)
            r10.g(r8, r9, r6, r1)
            goto L_0x013f
        L_0x0138:
            r11 = 5
            r10.e(r8, r9, r6, r11)
            r10.g(r8, r9, r6, r1)
        L_0x013f:
            r11 = r35
            r23 = r2
        L_0x0143:
            r12 = r3
            r24 = r5
            goto L_0x01b1
        L_0x0147:
            r1 = 2
            if (r14 != r1) goto L_0x01ac
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r1 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = r13.f1338a
            if (r11 == r1) goto L_0x016e
            if (r11 != r6) goto L_0x0155
            goto L_0x016e
        L_0x0155:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r0.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r6 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.m(r6)
            yx r1 = r10.k(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r0.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r11 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.m(r11)
            yx r6 = r10.k(r6)
            goto L_0x0182
        L_0x016e:
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r0.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r11.m(r1)
            yx r1 = r10.k(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r0.f1349a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r11.m(r6)
            yx r6 = r10.k(r6)
        L_0x0182:
            L1 r11 = r31.l()
            L1$a r12 = r11.f377a
            r23 = r2
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12.j(r8, r2)
            L1$a r2 = r11.f377a
            r12 = 1065353216(0x3f800000, float:1.0)
            r2.j(r9, r12)
            L1$a r2 = r11.f377a
            r12 = r56
            r2.j(r6, r12)
            L1$a r2 = r11.f377a
            float r6 = -r12
            r2.j(r1, r6)
            r10.c(r11)
            if (r33 == 0) goto L_0x01a9
            r5 = 0
        L_0x01a9:
            r1 = r35
            goto L_0x01af
        L_0x01ac:
            r23 = r2
            r1 = 1
        L_0x01af:
            r11 = r1
            goto L_0x0143
        L_0x01b1:
            if (r57 == 0) goto L_0x04dd
            if (r49 == 0) goto L_0x01c4
            r2 = r36
            r4 = r37
            r3 = r8
            r13 = r9
            r35 = r11
            r1 = r23
            r5 = 2
            r29 = 1
            goto L_0x04ea
        L_0x01c4:
            if (r16 != 0) goto L_0x01d3
            if (r17 != 0) goto L_0x01d3
            if (r22 != 0) goto L_0x01d3
            r14 = r41
            r3 = r8
            r35 = r11
            r1 = r19
            goto L_0x04c1
        L_0x01d3:
            if (r16 == 0) goto L_0x01f1
            if (r17 != 0) goto L_0x01f1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r13.f1339a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f1340a
            if (r33 == 0) goto L_0x01e4
            boolean r1 = r1 instanceof androidx.constraintlayout.core.widgets.a
            if (r1 == 0) goto L_0x01e4
            r1 = 8
            goto L_0x01e5
        L_0x01e4:
            r1 = 5
        L_0x01e5:
            r14 = r41
            r3 = r8
            r35 = r11
            r11 = r1
            r1 = r19
            r19 = r33
            goto L_0x04c5
        L_0x01f1:
            if (r16 != 0) goto L_0x0213
            if (r17 == 0) goto L_0x0213
            int r1 = r41.e()
            int r1 = -r1
            r6 = r19
            r2 = 8
            r10.e(r8, r6, r1, r2)
            if (r33 == 0) goto L_0x04bb
            r5 = r36
            r1 = 5
            r2 = 0
            r10.f(r9, r5, r2, r1)
            r14 = r41
            r2 = r1
            r1 = r6
            r3 = r8
            r35 = r11
            goto L_0x04c2
        L_0x0213:
            r5 = r36
            r6 = r19
            if (r16 == 0) goto L_0x04bb
            if (r17 == 0) goto L_0x04bb
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r13.f1339a
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r1.f1340a
            r2 = r41
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r2.f1339a
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f1340a
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r0.f1349a
            r16 = 6
            if (r24 == 0) goto L_0x031b
            if (r14 != 0) goto L_0x027e
            if (r4 != 0) goto L_0x0256
            if (r12 != 0) goto L_0x0256
            boolean r4 = r7.b
            if (r4 == 0) goto L_0x024b
            boolean r4 = r6.b
            if (r4 == 0) goto L_0x024b
            int r1 = r40.e()
            r3 = 8
            r10.e(r9, r7, r1, r3)
            int r1 = r41.e()
            int r1 = -r1
            r10.e(r8, r6, r1, r3)
            return
        L_0x024b:
            r32 = 8
            r17 = 8
            r19 = 0
            r21 = 1
            r22 = 0
            goto L_0x0260
        L_0x0256:
            r32 = 5
            r17 = 5
            r19 = 1
            r21 = 0
            r22 = 1
        L_0x0260:
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 != 0) goto L_0x0271
            boolean r4 = r1 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 == 0) goto L_0x0269
            goto L_0x0271
        L_0x0269:
            r20 = r32
            r23 = r16
            r4 = r17
            r15 = 1
            goto L_0x0278
        L_0x0271:
            r23 = r16
            r4 = r17
            r15 = 1
            r20 = 4
        L_0x0278:
            r17 = r14
        L_0x027a:
            r14 = r37
            goto L_0x0371
        L_0x027e:
            r15 = 2
            if (r14 != r15) goto L_0x0299
            boolean r4 = r3 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 != 0) goto L_0x0294
            boolean r4 = r1 instanceof androidx.constraintlayout.core.widgets.a
            if (r4 == 0) goto L_0x028a
            goto L_0x0294
        L_0x028a:
            r17 = r14
            r4 = 5
            r15 = 1
            r19 = 5
            r14 = r37
            goto L_0x0363
        L_0x0294:
            r17 = r14
            r15 = 1
            goto L_0x035e
        L_0x0299:
            r15 = 1
            if (r14 != r15) goto L_0x02a4
            r17 = r14
            r4 = 8
            r14 = r37
            goto L_0x0361
        L_0x02a4:
            r15 = 3
            if (r14 != r15) goto L_0x030e
            int r15 = r0.l
            r17 = r14
            r14 = -1
            if (r15 != r14) goto L_0x02bd
            if (r50 == 0) goto L_0x02b6
            if (r33 == 0) goto L_0x02b4
            r4 = 5
            goto L_0x02b8
        L_0x02b4:
            r4 = 4
            goto L_0x02b8
        L_0x02b6:
            r4 = 8
        L_0x02b8:
            r14 = r4
            r4 = 8
            r15 = 1
            goto L_0x02e6
        L_0x02bd:
            if (r47 == 0) goto L_0x02e0
            r14 = r53
            r15 = 2
            if (r14 == r15) goto L_0x02ca
            r15 = 1
            if (r14 != r15) goto L_0x02c8
            goto L_0x02cb
        L_0x02c8:
            r4 = 0
            goto L_0x02cc
        L_0x02ca:
            r15 = 1
        L_0x02cb:
            r4 = r15
        L_0x02cc:
            if (r4 != 0) goto L_0x02d2
            r4 = 5
            r14 = 8
            goto L_0x02d4
        L_0x02d2:
            r4 = 4
            r14 = 5
        L_0x02d4:
            r20 = r4
            r4 = r14
            r19 = r15
            r21 = r19
            r22 = r21
            r23 = r16
            goto L_0x027a
        L_0x02e0:
            r15 = 1
            if (r4 <= 0) goto L_0x02ea
            r14 = r16
            r4 = 5
        L_0x02e6:
            r19 = r14
            r14 = 5
            goto L_0x0300
        L_0x02ea:
            if (r4 != 0) goto L_0x02fc
            if (r12 != 0) goto L_0x02fc
            if (r50 != 0) goto L_0x02f6
            r19 = r16
            r4 = 5
            r14 = 8
            goto L_0x0300
        L_0x02f6:
            if (r3 == r13) goto L_0x02fc
            if (r1 == r13) goto L_0x02fc
            r4 = 4
            goto L_0x02fd
        L_0x02fc:
            r4 = 5
        L_0x02fd:
            r19 = r16
            r14 = 4
        L_0x0300:
            r20 = r14
            r21 = r15
            r22 = r21
            r23 = r19
            r14 = r37
            r19 = r22
            goto L_0x0371
        L_0x030e:
            r17 = r14
            r15 = 1
            r14 = r37
            r4 = 5
            r19 = 4
            r20 = 0
            r21 = 0
            goto L_0x0367
        L_0x031b:
            r17 = r14
            r15 = 1
            boolean r4 = r7.b
            if (r4 == 0) goto L_0x035e
            boolean r4 = r6.b
            if (r4 == 0) goto L_0x035e
            int r1 = r40.e()
            int r3 = r41.e()
            r4 = 8
            r47 = r31
            r48 = r9
            r49 = r7
            r50 = r1
            r51 = r46
            r52 = r6
            r53 = r8
            r54 = r3
            r55 = r4
            r47.b(r48, r49, r50, r51, r52, r53, r54, r55)
            if (r33 == 0) goto L_0x035d
            if (r11 == 0) goto L_0x035d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r2.f1339a
            if (r1 == 0) goto L_0x0354
            int r5 = r41.e()
            r14 = r37
            goto L_0x0357
        L_0x0354:
            r14 = r37
            r5 = 0
        L_0x0357:
            if (r6 == r14) goto L_0x035d
            r1 = 5
            r10.f(r14, r8, r5, r1)
        L_0x035d:
            return
        L_0x035e:
            r14 = r37
            r4 = 5
        L_0x0361:
            r19 = 4
        L_0x0363:
            r20 = r15
            r21 = r20
        L_0x0367:
            r23 = r16
            r22 = r20
            r20 = r19
            r19 = r21
            r21 = 0
        L_0x0371:
            if (r22 == 0) goto L_0x037c
            if (r7 != r6) goto L_0x037c
            if (r3 == r13) goto L_0x037c
            r22 = 0
            r25 = 0
            goto L_0x037e
        L_0x037c:
            r25 = r15
        L_0x037e:
            if (r19 == 0) goto L_0x03c8
            if (r24 != 0) goto L_0x0393
            if (r48 != 0) goto L_0x0393
            if (r50 != 0) goto L_0x0393
            if (r7 != r5) goto L_0x0393
            if (r6 != r14) goto L_0x0393
            r19 = 0
            r23 = 8
            r25 = 0
            r26 = 8
            goto L_0x0399
        L_0x0393:
            r19 = r33
            r26 = r23
            r23 = r4
        L_0x0399:
            int r4 = r40.e()
            int r27 = r41.e()
            r15 = r1
            r14 = 3
            r1 = r31
            r14 = r2
            r2 = r9
            r35 = r11
            r11 = r3
            r3 = r7
            r38 = r12
            r12 = r5
            r5 = r46
            r32 = r6
            r28 = 4
            r29 = 1
            r12 = r7
            r7 = r8
            r39 = r13
            r13 = r8
            r8 = r27
            r27 = r13
            r13 = r9
            r9 = r26
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)
            r4 = r23
            goto L_0x03dd
        L_0x03c8:
            r14 = r2
            r32 = r6
            r27 = r8
            r35 = r11
            r38 = r12
            r39 = r13
            r29 = r15
            r28 = 4
            r15 = r1
            r11 = r3
            r12 = r7
            r13 = r9
            r19 = r33
        L_0x03dd:
            r6 = r25
            int r1 = r0.w
            r2 = 8
            if (r1 != r2) goto L_0x03f9
            java.util.HashSet<androidx.constraintlayout.core.widgets.ConstraintAnchor> r1 = r14.f1341a
            if (r1 != 0) goto L_0x03eb
            r5 = 0
            goto L_0x03f6
        L_0x03eb:
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x03f4
            r1 = r29
            goto L_0x03f5
        L_0x03f4:
            r1 = 0
        L_0x03f5:
            r5 = r1
        L_0x03f6:
            if (r5 != 0) goto L_0x03f9
            return
        L_0x03f9:
            if (r22 == 0) goto L_0x041f
            r1 = r32
            if (r19 == 0) goto L_0x040d
            if (r12 == r1) goto L_0x040d
            if (r24 != 0) goto L_0x040d
            boolean r2 = r11 instanceof androidx.constraintlayout.core.widgets.a
            if (r2 != 0) goto L_0x040b
            boolean r2 = r15 instanceof androidx.constraintlayout.core.widgets.a
            if (r2 == 0) goto L_0x040d
        L_0x040b:
            r4 = r16
        L_0x040d:
            int r2 = r40.e()
            r10.f(r13, r12, r2, r4)
            int r2 = r41.e()
            int r2 = -r2
            r3 = r27
            r10.g(r3, r1, r2, r4)
            goto L_0x0423
        L_0x041f:
            r1 = r32
            r3 = r27
        L_0x0423:
            if (r19 == 0) goto L_0x0439
            if (r51 == 0) goto L_0x0439
            boolean r2 = r11 instanceof androidx.constraintlayout.core.widgets.a
            if (r2 != 0) goto L_0x0439
            boolean r2 = r15 instanceof androidx.constraintlayout.core.widgets.a
            if (r2 != 0) goto L_0x0439
            r2 = r39
            if (r15 == r2) goto L_0x043b
            r4 = r16
            r5 = r4
            r6 = r29
            goto L_0x043d
        L_0x0439:
            r2 = r39
        L_0x043b:
            r5 = r20
        L_0x043d:
            if (r6 == 0) goto L_0x048a
            if (r21 == 0) goto L_0x046a
            if (r50 == 0) goto L_0x0445
            if (r34 == 0) goto L_0x046a
        L_0x0445:
            if (r11 == r2) goto L_0x044c
            if (r15 != r2) goto L_0x044a
            goto L_0x044c
        L_0x044a:
            r16 = r5
        L_0x044c:
            boolean r6 = r11 instanceof androidx.constraintlayout.core.widgets.e
            if (r6 != 0) goto L_0x0454
            boolean r6 = r15 instanceof androidx.constraintlayout.core.widgets.e
            if (r6 == 0) goto L_0x0456
        L_0x0454:
            r16 = 5
        L_0x0456:
            boolean r6 = r11 instanceof androidx.constraintlayout.core.widgets.a
            if (r6 != 0) goto L_0x045e
            boolean r6 = r15 instanceof androidx.constraintlayout.core.widgets.a
            if (r6 == 0) goto L_0x0460
        L_0x045e:
            r16 = 5
        L_0x0460:
            if (r50 == 0) goto L_0x0464
            r6 = 5
            goto L_0x0466
        L_0x0464:
            r6 = r16
        L_0x0466:
            int r5 = java.lang.Math.max(r6, r5)
        L_0x046a:
            r6 = r5
            if (r19 == 0) goto L_0x047b
            int r6 = java.lang.Math.min(r4, r6)
            if (r47 == 0) goto L_0x047b
            if (r50 != 0) goto L_0x047b
            if (r11 == r2) goto L_0x0479
            if (r15 != r2) goto L_0x047b
        L_0x0479:
            r6 = r28
        L_0x047b:
            int r2 = r40.e()
            r10.e(r13, r12, r2, r6)
            int r2 = r41.e()
            int r2 = -r2
            r10.e(r3, r1, r2, r6)
        L_0x048a:
            if (r19 == 0) goto L_0x049d
            r2 = r36
            r4 = r12
            if (r2 != r4) goto L_0x0496
            int r5 = r40.e()
            goto L_0x0497
        L_0x0496:
            r5 = 0
        L_0x0497:
            if (r4 == r2) goto L_0x049d
            r4 = 5
            r10.f(r13, r2, r5, r4)
        L_0x049d:
            if (r19 == 0) goto L_0x04b9
            if (r24 == 0) goto L_0x04b9
            if (r44 != 0) goto L_0x04b9
            if (r38 != 0) goto L_0x04b9
            if (r24 == 0) goto L_0x04b3
            r2 = r17
            r4 = 3
            if (r2 != r4) goto L_0x04b3
            r2 = 8
            r4 = 0
            r10.f(r3, r13, r4, r2)
            goto L_0x04b9
        L_0x04b3:
            r4 = 0
            r2 = 5
            r10.f(r3, r13, r4, r2)
            goto L_0x04c4
        L_0x04b9:
            r2 = 5
            goto L_0x04c4
        L_0x04bb:
            r14 = r41
            r1 = r6
            r3 = r8
            r35 = r11
        L_0x04c1:
            r2 = 5
        L_0x04c2:
            r19 = r33
        L_0x04c4:
            r11 = r2
        L_0x04c5:
            if (r19 == 0) goto L_0x04dc
            if (r35 == 0) goto L_0x04dc
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r14.f1339a
            if (r2 == 0) goto L_0x04d4
            int r5 = r41.e()
            r4 = r37
            goto L_0x04d7
        L_0x04d4:
            r4 = r37
            r5 = 0
        L_0x04d7:
            if (r1 == r4) goto L_0x04dc
            r10.f(r4, r3, r5, r11)
        L_0x04dc:
            return
        L_0x04dd:
            r2 = r36
            r4 = r37
            r3 = r8
            r13 = r9
            r35 = r11
            r1 = r23
            r29 = 1
            r5 = 2
        L_0x04ea:
            if (r1 >= r5) goto L_0x052b
            if (r33 == 0) goto L_0x052b
            if (r35 == 0) goto L_0x052b
            r1 = 8
            r5 = 0
            r10.f(r13, r2, r5, r1)
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f1379e
            if (r32 != 0) goto L_0x0501
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.f1339a
            if (r2 != 0) goto L_0x04ff
            goto L_0x0501
        L_0x04ff:
            r6 = 0
            goto L_0x0503
        L_0x0501:
            r6 = r29
        L_0x0503:
            if (r32 != 0) goto L_0x0523
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1339a
            if (r1 == 0) goto L_0x0523
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f1340a
            float r2 = r1.e
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0522
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r1 = r1.f1358a
            r2 = 0
            r5 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            if (r5 != r2) goto L_0x0522
            r1 = r1[r29]
            if (r1 != r2) goto L_0x0522
            r6 = r29
            goto L_0x0523
        L_0x0522:
            r6 = 0
        L_0x0523:
            if (r6 == 0) goto L_0x052b
            r1 = 8
            r2 = 0
            r10.f(r4, r3, r2, r1)
        L_0x052b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(ei, boolean, boolean, boolean, boolean, yx, yx, androidx.constraintlayout.core.widgets.ConstraintWidget$a, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void h(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2) {
        boolean z2;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.CENTER;
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.CENTER_Y;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER_X;
        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.LEFT;
        ConstraintAnchor.Type type7 = ConstraintAnchor.Type.TOP;
        ConstraintAnchor.Type type8 = ConstraintAnchor.Type.RIGHT;
        ConstraintAnchor.Type type9 = ConstraintAnchor.Type.BOTTOM;
        if (type == type3) {
            if (type2 == type3) {
                ConstraintAnchor m2 = m(type6);
                ConstraintAnchor m3 = m(type8);
                ConstraintAnchor m4 = m(type7);
                ConstraintAnchor m5 = m(type9);
                boolean z3 = true;
                if ((m2 == null || !m2.h()) && (m3 == null || !m3.h())) {
                    h(type6, constraintWidget, type6, 0);
                    h(type8, constraintWidget, type8, 0);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((m4 == null || !m4.h()) && (m5 == null || !m5.h())) {
                    h(type7, constraintWidget, type7, 0);
                    h(type9, constraintWidget, type9, 0);
                } else {
                    z3 = false;
                }
                if (z2 && z3) {
                    m(type3).a(constraintWidget.m(type3), 0);
                } else if (z2) {
                    m(type5).a(constraintWidget.m(type5), 0);
                } else if (z3) {
                    m(type4).a(constraintWidget.m(type4), 0);
                }
            } else if (type2 == type6 || type2 == type8) {
                h(type6, constraintWidget, type2, 0);
                h(type8, constraintWidget, type2, 0);
                m(type3).a(constraintWidget.m(type2), 0);
            } else if (type2 == type7 || type2 == type9) {
                h(type7, constraintWidget, type2, 0);
                h(type9, constraintWidget, type2, 0);
                m(type3).a(constraintWidget.m(type2), 0);
            }
        } else if (type == type5 && (type2 == type6 || type2 == type8)) {
            ConstraintAnchor m6 = m(type6);
            ConstraintAnchor m7 = constraintWidget.m(type2);
            ConstraintAnchor m8 = m(type8);
            m6.a(m7, 0);
            m8.a(m7, 0);
            m(type5).a(m7, 0);
        } else if (type == type4 && (type2 == type7 || type2 == type9)) {
            ConstraintAnchor m9 = constraintWidget.m(type2);
            m(type7).a(m9, 0);
            m(type9).a(m9, 0);
            m(type4).a(m9, 0);
        } else if (type == type5 && type2 == type5) {
            m(type6).a(constraintWidget.m(type6), 0);
            m(type8).a(constraintWidget.m(type8), 0);
            m(type5).a(constraintWidget.m(type2), 0);
        } else if (type == type4 && type2 == type4) {
            m(type7).a(constraintWidget.m(type7), 0);
            m(type9).a(constraintWidget.m(type9), 0);
            m(type4).a(constraintWidget.m(type2), 0);
        } else {
            ConstraintAnchor m10 = m(type);
            ConstraintAnchor m11 = constraintWidget.m(type2);
            if (m10.i(m11)) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.BASELINE;
                if (type == type10) {
                    ConstraintAnchor m12 = m(type7);
                    ConstraintAnchor m13 = m(type9);
                    if (m12 != null) {
                        m12.j();
                    }
                    if (m13 != null) {
                        m13.j();
                    }
                } else if (type == type7 || type == type9) {
                    ConstraintAnchor m14 = m(type10);
                    if (m14 != null) {
                        m14.j();
                    }
                    ConstraintAnchor m15 = m(type3);
                    if (m15.f1339a != m11) {
                        m15.j();
                    }
                    ConstraintAnchor f2 = m(type).f();
                    ConstraintAnchor m16 = m(type4);
                    if (m16.h()) {
                        f2.j();
                        m16.j();
                    }
                } else if (type == type6 || type == type8) {
                    ConstraintAnchor m17 = m(type3);
                    if (m17.f1339a != m11) {
                        m17.j();
                    }
                    ConstraintAnchor f3 = m(type).f();
                    ConstraintAnchor m18 = m(type5);
                    if (m18.h()) {
                        f3.j();
                        m18.j();
                    }
                }
                m10.a(m11, i2);
            }
        }
    }

    public final void i(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        if (constraintAnchor.f1340a == this) {
            h(constraintAnchor.f1338a, constraintAnchor2.f1340a, constraintAnchor2.f1338a, i2);
        }
    }

    public void j(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        this.f1370c = constraintWidget.f1370c;
        this.f1375d = constraintWidget.f1375d;
        this.f1381f = constraintWidget.f1381f;
        this.f1384g = constraintWidget.f1384g;
        int[] iArr = constraintWidget.f1356a;
        int i2 = iArr[0];
        int[] iArr2 = this.f1356a;
        iArr2[0] = i2;
        iArr2[1] = iArr[1];
        this.h = constraintWidget.h;
        this.i = constraintWidget.i;
        this.j = constraintWidget.j;
        this.k = constraintWidget.k;
        this.b = constraintWidget.b;
        this.l = constraintWidget.l;
        this.c = constraintWidget.c;
        int[] iArr3 = constraintWidget.f1367b;
        this.f1367b = Arrays.copyOf(iArr3, iArr3.length);
        this.d = constraintWidget.d;
        this.f1388h = constraintWidget.f1388h;
        this.f1389i = constraintWidget.f1389i;
        this.f1348a.j();
        this.f1363b.j();
        this.f1371c.j();
        this.f1376d.j();
        this.f1379e.j();
        this.f1382f.j();
        this.f1385g.j();
        this.f1387h.j();
        this.f1358a = (a[]) Arrays.copyOf(this.f1358a, 2);
        ConstraintWidget constraintWidget4 = null;
        if (this.f1349a == null) {
            constraintWidget2 = null;
        } else {
            constraintWidget2 = hashMap.get(constraintWidget.f1349a);
        }
        this.f1349a = constraintWidget2;
        this.o = constraintWidget.o;
        this.p = constraintWidget.p;
        this.e = constraintWidget.e;
        this.q = constraintWidget.q;
        this.r = constraintWidget.r;
        this.s = constraintWidget.s;
        this.t = constraintWidget.t;
        this.u = constraintWidget.u;
        this.v = constraintWidget.v;
        this.f = constraintWidget.f;
        this.g = constraintWidget.g;
        this.f1351a = constraintWidget.f1351a;
        this.w = constraintWidget.w;
        this.f1391k = constraintWidget.f1391k;
        this.f1365b = constraintWidget.f1365b;
        this.f1373c = constraintWidget.f1373c;
        this.x = constraintWidget.x;
        this.y = constraintWidget.y;
        float[] fArr = constraintWidget.f1355a;
        float f2 = fArr[0];
        float[] fArr2 = this.f1355a;
        fArr2[0] = f2;
        fArr2[1] = fArr[1];
        ConstraintWidget[] constraintWidgetArr = constraintWidget.f1359a;
        ConstraintWidget constraintWidget5 = constraintWidgetArr[0];
        ConstraintWidget[] constraintWidgetArr2 = this.f1359a;
        constraintWidgetArr2[0] = constraintWidget5;
        constraintWidgetArr2[1] = constraintWidgetArr[1];
        ConstraintWidget[] constraintWidgetArr3 = constraintWidget.f1368b;
        ConstraintWidget constraintWidget6 = constraintWidgetArr3[0];
        ConstraintWidget[] constraintWidgetArr4 = this.f1368b;
        constraintWidgetArr4[0] = constraintWidget6;
        constraintWidgetArr4[1] = constraintWidgetArr3[1];
        ConstraintWidget constraintWidget7 = constraintWidget.f1364b;
        if (constraintWidget7 == null) {
            constraintWidget3 = null;
        } else {
            constraintWidget3 = hashMap.get(constraintWidget7);
        }
        this.f1364b = constraintWidget3;
        ConstraintWidget constraintWidget8 = constraintWidget.f1372c;
        if (constraintWidget8 != null) {
            constraintWidget4 = hashMap.get(constraintWidget8);
        }
        this.f1372c = constraintWidget4;
    }

    public final void k(ei eiVar) {
        eiVar.k(this.f1348a);
        eiVar.k(this.f1363b);
        eiVar.k(this.f1371c);
        eiVar.k(this.f1376d);
        if (this.t > 0) {
            eiVar.k(this.f1379e);
        }
    }

    public final void l() {
        if (this.f1347a == null) {
            this.f1347a = new af(this);
        }
        if (this.f1350a == null) {
            this.f1350a = new C0213hC(this);
        }
    }

    public ConstraintAnchor m(ConstraintAnchor.Type type) {
        switch (type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.f1348a;
            case 2:
                return this.f1363b;
            case 3:
                return this.f1371c;
            case 4:
                return this.f1376d;
            case 5:
                return this.f1379e;
            case 6:
                return this.f1387h;
            case 7:
                return this.f1382f;
            case 8:
                return this.f1385g;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final a n(int i2) {
        if (i2 == 0) {
            return this.f1358a[0];
        }
        if (i2 == 1) {
            return this.f1358a[1];
        }
        return null;
    }

    public final int o() {
        if (this.w == 8) {
            return 0;
        }
        return this.p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.f1376d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.constraintlayout.core.widgets.ConstraintWidget p(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f1339a
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f1339a
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f1340a
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1376d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f1339a
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f1339a
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f1340a
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.p(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = r2.f1363b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.constraintlayout.core.widgets.ConstraintWidget q(int r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x000f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f1339a
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f1339a
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f1340a
            return r3
        L_0x000f:
            r0 = 1
            if (r3 != r0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r3.f1339a
            if (r0 == 0) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r0.f1339a
            if (r1 != r3) goto L_0x001f
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r0.f1340a
            return r3
        L_0x001f:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.q(int):androidx.constraintlayout.core.widgets.ConstraintWidget");
    }

    public void r(StringBuilder sb) {
        sb.append("  " + this.f1352a + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.o);
        sb.append(sb2.toString());
        sb.append("\n");
        sb.append("    actualHeight:" + this.p);
        sb.append("\n");
        sb.append("    actualLeft:" + this.r);
        sb.append("\n");
        sb.append("    actualTop:" + this.s);
        sb.append("\n");
        t(sb, "left", this.f1348a);
        t(sb, "top", this.f1363b);
        t(sb, "right", this.f1371c);
        t(sb, "bottom", this.f1376d);
        t(sb, "baseline", this.f1379e);
        t(sb, "centerX", this.f1382f);
        t(sb, "centerY", this.f1385g);
        int i2 = this.o;
        int i3 = this.u;
        int i4 = this.f1367b[0];
        int i5 = this.h;
        int i6 = this.f1381f;
        float f2 = this.a;
        float[] fArr = this.f1355a;
        float f3 = fArr[0];
        s(sb, "    width", i2, i3, i4, i5, i6, f2);
        int i7 = this.p;
        int i8 = this.v;
        int i9 = this.f1367b[1];
        int i10 = this.j;
        int i11 = this.f1384g;
        float f4 = this.b;
        float f5 = fArr[1];
        s(sb, "    height", i7, i8, i9, i10, i11, f4);
        float f6 = this.e;
        int i12 = this.q;
        if (f6 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f6);
            sb.append(",");
            sb.append(i12);
            sb.append("");
            sb.append("],\n");
        }
        L(sb, "    horizontalBias", this.f, 0.5f);
        L(sb, "    verticalBias", this.g, 0.5f);
        K("    horizontalChainStyle", this.x, 0, sb);
        K("    verticalChainStyle", this.y, 0, sb);
        sb.append("  }");
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.f1373c != null) {
            str = C0709Uj.j(new StringBuilder("type: "), this.f1373c, " ");
        } else {
            str = str2;
        }
        sb.append(str);
        if (this.f1365b != null) {
            str2 = C0709Uj.j(new StringBuilder("id: "), this.f1365b, " ");
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.r);
        sb.append(", ");
        sb.append(this.s);
        sb.append(") - (");
        sb.append(this.o);
        sb.append(" x ");
        return lf.k(sb, this.p, ")");
    }

    public final int u() {
        if (this.w == 8) {
            return 0;
        }
        return this.o;
    }

    public final int v() {
        ConstraintWidget constraintWidget = this.f1349a;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.r;
        }
        return ((ConstraintWidgetContainer) constraintWidget).C + this.r;
    }

    public final int w() {
        ConstraintWidget constraintWidget = this.f1349a;
        if (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) {
            return this.s;
        }
        return ((ConstraintWidgetContainer) constraintWidget).D + this.s;
    }

    public final boolean x(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if (i2 == 0) {
            if (this.f1348a.f1339a != null) {
                i6 = 1;
            } else {
                i6 = 0;
            }
            if (this.f1371c.f1339a != null) {
                i7 = 1;
            } else {
                i7 = 0;
            }
            if (i6 + i7 < 2) {
                return true;
            }
            return false;
        }
        if (this.f1363b.f1339a != null) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.f1376d.f1339a != null) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        int i8 = i3 + i4;
        if (this.f1379e.f1339a != null) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        if (i8 + i5 < 2) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r2 = r5.f1376d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r2 = r5.f1371c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean y(int r6, int r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 != 0) goto L_0x0032
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r5.f1348a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r6.f1339a
            if (r2 == 0) goto L_0x0060
            boolean r2 = r2.f1343a
            if (r2 == 0) goto L_0x0060
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r5.f1371c
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1339a
            if (r3 == 0) goto L_0x0060
            boolean r4 = r3.f1343a
            if (r4 == 0) goto L_0x0060
            int r3 = r3.d()
            int r2 = r2.e()
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r6.f1339a
            int r2 = r2.d()
            int r6 = r6.e()
            int r6 = r6 + r2
            int r3 = r3 - r6
            if (r3 < r7) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r0 = r1
        L_0x0031:
            return r0
        L_0x0032:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r5.f1363b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r6.f1339a
            if (r2 == 0) goto L_0x0060
            boolean r2 = r2.f1343a
            if (r2 == 0) goto L_0x0060
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r5.f1376d
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r2.f1339a
            if (r3 == 0) goto L_0x0060
            boolean r4 = r3.f1343a
            if (r4 == 0) goto L_0x0060
            int r3 = r3.d()
            int r2 = r2.e()
            int r3 = r3 - r2
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r6.f1339a
            int r2 = r2.d()
            int r6 = r6.e()
            int r6 = r6 + r2
            int r3 = r3 - r6
            if (r3 < r7) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r0 = r1
        L_0x005f:
            return r0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.y(int, int):boolean");
    }

    public final void z(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        m(type).b(constraintWidget.m(type2), i2, i3, true);
    }
}
