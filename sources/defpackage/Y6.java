package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import defpackage.C0335t2;
import defpackage.UB;
import java.util.ArrayList;
import java.util.List;

/* renamed from: Y6  reason: default package */
/* compiled from: ContentGroup */
public final class Y6 implements z9, dp, C0335t2.a, C0368vh {
    public final Ej a;

    /* renamed from: a  reason: collision with other field name */
    public final HA f700a;

    /* renamed from: a  reason: collision with other field name */
    public final Lh f701a;

    /* renamed from: a  reason: collision with other field name */
    public final Matrix f702a;

    /* renamed from: a  reason: collision with other field name */
    public final Path f703a;

    /* renamed from: a  reason: collision with other field name */
    public final RectF f704a;

    /* renamed from: a  reason: collision with other field name */
    public final String f705a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList f706a;

    /* renamed from: a  reason: collision with other field name */
    public final List<V6> f707a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f708a;
    public final RectF b;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Y6(defpackage.Ej r8, defpackage.C0359v2 r9, defpackage.qw r10) {
        /*
            r7 = this;
            java.lang.String r3 = r10.a
            boolean r4 = r10.f3206a
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.List<Z6> r10 = r10.f3205a
            int r0 = r10.size()
            r5.<init>(r0)
            r0 = 0
            r1 = r0
        L_0x0011:
            int r2 = r10.size()
            if (r1 >= r2) goto L_0x0029
            java.lang.Object r2 = r10.get(r1)
            Z6 r2 = (defpackage.Z6) r2
            V6 r2 = r2.a(r8, r9)
            if (r2 == 0) goto L_0x0026
            r5.add(r2)
        L_0x0026:
            int r1 = r1 + 1
            goto L_0x0011
        L_0x0029:
            int r1 = r10.size()
            if (r0 >= r1) goto L_0x0040
            java.lang.Object r1 = r10.get(r0)
            Z6 r1 = (defpackage.Z6) r1
            boolean r2 = r1 instanceof defpackage.P0
            if (r2 == 0) goto L_0x003d
            P0 r1 = (defpackage.P0) r1
            r6 = r1
            goto L_0x0042
        L_0x003d:
            int r0 = r0 + 1
            goto L_0x0029
        L_0x0040:
            r10 = 0
            r6 = r10
        L_0x0042:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Y6.<init>(Ej, v2, qw):void");
    }

    public final void a(RectF rectF, Matrix matrix, boolean z) {
        Matrix matrix2 = this.f702a;
        matrix2.set(matrix);
        HA ha = this.f700a;
        if (ha != null) {
            matrix2.preConcat(ha.d());
        }
        RectF rectF2 = this.b;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        List<V6> list = this.f707a;
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                V6 v6 = list.get(size);
                if (v6 instanceof z9) {
                    ((z9) v6).a(rectF2, matrix2, z);
                    rectF.union(rectF2);
                }
            } else {
                return;
            }
        }
    }

    public final Path b() {
        Matrix matrix = this.f702a;
        matrix.reset();
        HA ha = this.f700a;
        if (ha != null) {
            matrix.set(ha.d());
        }
        Path path = this.f703a;
        path.reset();
        if (this.f708a) {
            return path;
        }
        List<V6> list = this.f707a;
        for (int size = list.size() - 1; size >= 0; size--) {
            V6 v6 = list.get(size);
            if (v6 instanceof dp) {
                path.addPath(((dp) v6).b(), matrix);
            }
        }
        return path;
    }

    public final void c(Canvas canvas, Matrix matrix, int i) {
        boolean z;
        int i2;
        if (!this.f708a) {
            Matrix matrix2 = this.f702a;
            matrix2.set(matrix);
            HA ha = this.f700a;
            if (ha != null) {
                matrix2.preConcat(ha.d());
                C0335t2<Integer, Integer> t2Var = ha.e;
                if (t2Var == null) {
                    i2 = 100;
                } else {
                    i2 = t2Var.f().intValue();
                }
                i = (int) ((((((float) i2) / 100.0f) * ((float) i)) / 255.0f) * 255.0f);
            }
            boolean z2 = this.a.i;
            boolean z3 = false;
            List<V6> list = this.f707a;
            if (z2) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 < list.size()) {
                        if ((list.get(i3) instanceof z9) && (i4 = i4 + 1) >= 2) {
                            z = true;
                            break;
                        }
                        i3++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z && i != 255) {
                    z3 = true;
                }
            }
            if (z3) {
                RectF rectF = this.f704a;
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
                a(rectF, matrix2, true);
                Lh lh = this.f701a;
                lh.setAlpha(i);
                UB.a aVar = UB.f567a;
                canvas.saveLayer(rectF, lh);
                C1354qp.G();
            }
            if (z3) {
                i = 255;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                V6 v6 = list.get(size);
                if (v6 instanceof z9) {
                    ((z9) v6).c(canvas, matrix2, i);
                }
            }
            if (z3) {
                canvas.restore();
            }
        }
    }

    public final void d(List<V6> list, List<V6> list2) {
        int size = list.size();
        List<V6> list3 = this.f707a;
        ArrayList arrayList = new ArrayList(list3.size() + size);
        arrayList.addAll(list);
        for (int size2 = list3.size() - 1; size2 >= 0; size2--) {
            V6 v6 = list3.get(size2);
            v6.d(arrayList, list3.subList(0, size2));
            arrayList.add(v6);
        }
    }

    public final void e(C0344tk tkVar, Object obj) {
        HA ha = this.f700a;
        if (ha != null) {
            ha.c(tkVar, obj);
        }
    }

    public final void f() {
        this.a.invalidateSelf();
    }

    public final List<dp> g() {
        if (this.f706a == null) {
            this.f706a = new ArrayList();
            int i = 0;
            while (true) {
                List<V6> list = this.f707a;
                if (i >= list.size()) {
                    break;
                }
                V6 v6 = list.get(i);
                if (v6 instanceof dp) {
                    this.f706a.add((dp) v6);
                }
                i++;
            }
        }
        return this.f706a;
    }

    public final String getName() {
        return this.f705a;
    }

    public final void i(uh uhVar, int i, ArrayList arrayList, uh uhVar2) {
        String str = this.f705a;
        if (uhVar.c(i, str) || "__container".equals(str)) {
            if (!"__container".equals(str)) {
                uhVar2.getClass();
                uh uhVar3 = new uh(uhVar2);
                uhVar3.f3321a.add(str);
                if (uhVar.a(i, str)) {
                    uh uhVar4 = new uh(uhVar3);
                    uhVar4.f3322a = this;
                    arrayList.add(uhVar4);
                }
                uhVar2 = uhVar3;
            }
            if (uhVar.d(i, str)) {
                int b2 = uhVar.b(i, str) + i;
                int i2 = 0;
                while (true) {
                    List<V6> list = this.f707a;
                    if (i2 < list.size()) {
                        V6 v6 = list.get(i2);
                        if (v6 instanceof C0368vh) {
                            ((C0368vh) v6).i(uhVar, b2, arrayList, uhVar2);
                        }
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public Y6(Ej ej, C0359v2 v2Var, String str, boolean z, ArrayList arrayList, P0 p0) {
        this.f701a = new Lh();
        this.f704a = new RectF();
        this.f702a = new Matrix();
        this.f703a = new Path();
        this.b = new RectF();
        this.f705a = str;
        this.a = ej;
        this.f708a = z;
        this.f707a = arrayList;
        if (p0 != null) {
            HA ha = new HA(p0);
            this.f700a = ha;
            ha.a(v2Var);
            ha.b(this);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            V6 v6 = (V6) arrayList.get(size);
            if (v6 instanceof C0090Ee) {
                arrayList2.add((C0090Ee) v6);
            }
        }
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 >= 0) {
                ((C0090Ee) arrayList2.get(size2)).g(arrayList.listIterator(arrayList.size()));
            } else {
                return;
            }
        }
    }
}
