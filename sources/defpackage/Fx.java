package defpackage;

import android.graphics.PointF;
import defpackage.C0335t2;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: Fx  reason: default package */
/* compiled from: SplitDimensionPathKeyframeAnimation */
public final class Fx extends C0335t2<PointF, PointF> {
    public final PointF a = new PointF();

    /* renamed from: a  reason: collision with other field name */
    public final C0335t2<Float, Float> f221a;
    public final PointF b = new PointF();

    /* renamed from: b  reason: collision with other field name */
    public final C0335t2<Float, Float> f222b;

    /* renamed from: b  reason: collision with other field name */
    public C0344tk f223b;
    public C0344tk c;

    public Fx(C0093Gc gc, C0093Gc gc2) {
        super(Collections.emptyList());
        this.f221a = gc;
        this.f222b = gc2;
        j(this.a);
    }

    public final Object f() {
        return l(0.0f);
    }

    public final /* bridge */ /* synthetic */ Object g(Bh bh, float f) {
        return l(f);
    }

    public final void j(float f) {
        C0335t2<Float, Float> t2Var = this.f221a;
        t2Var.j(f);
        C0335t2<Float, Float> t2Var2 = this.f222b;
        t2Var2.j(f);
        this.a.set(t2Var.f().floatValue(), t2Var2.f().floatValue());
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3285a;
            if (i < arrayList.size()) {
                ((C0335t2.a) arrayList.get(i)).f();
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Float} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.PointF l(float r13) {
        /*
            r12 = this;
            tk r0 = r12.f223b
            r1 = 0
            if (r0 == 0) goto L_0x0033
            t2<java.lang.Float, java.lang.Float> r0 = r12.f221a
            Bh r2 = r0.b()
            if (r2 == 0) goto L_0x0033
            float r10 = r0.d()
            java.lang.Float r0 = r2.f64a
            tk r3 = r12.f223b
            float r4 = r2.a
            if (r0 != 0) goto L_0x001b
            r5 = r4
            goto L_0x0020
        L_0x001b:
            float r0 = r0.floatValue()
            r5 = r0
        L_0x0020:
            T r0 = r2.f65a
            r6 = r0
            java.lang.Float r6 = (java.lang.Float) r6
            T r0 = r2.f69b
            r7 = r0
            java.lang.Float r7 = (java.lang.Float) r7
            r8 = r13
            r9 = r13
            java.lang.Object r0 = r3.b(r4, r5, r6, r7, r8, r9, r10)
            java.lang.Float r0 = (java.lang.Float) r0
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            tk r2 = r12.c
            if (r2 == 0) goto L_0x0066
            t2<java.lang.Float, java.lang.Float> r2 = r12.f222b
            Bh r3 = r2.b()
            if (r3 == 0) goto L_0x0066
            float r11 = r2.d()
            java.lang.Float r1 = r3.f64a
            tk r4 = r12.c
            float r5 = r3.a
            if (r1 != 0) goto L_0x004e
            r6 = r5
            goto L_0x0053
        L_0x004e:
            float r1 = r1.floatValue()
            r6 = r1
        L_0x0053:
            T r1 = r3.f65a
            r7 = r1
            java.lang.Float r7 = (java.lang.Float) r7
            T r1 = r3.f69b
            r8 = r1
            java.lang.Float r8 = (java.lang.Float) r8
            r9 = r13
            r10 = r13
            java.lang.Object r13 = r4.b(r5, r6, r7, r8, r9, r10, r11)
            r1 = r13
            java.lang.Float r1 = (java.lang.Float) r1
        L_0x0066:
            android.graphics.PointF r13 = r12.a
            android.graphics.PointF r2 = r12.b
            r3 = 0
            if (r0 != 0) goto L_0x0073
            float r0 = r13.x
            r2.set(r0, r3)
            goto L_0x007a
        L_0x0073:
            float r0 = r0.floatValue()
            r2.set(r0, r3)
        L_0x007a:
            if (r1 != 0) goto L_0x0084
            float r0 = r2.x
            float r13 = r13.y
            r2.set(r0, r13)
            goto L_0x008d
        L_0x0084:
            float r13 = r2.x
            float r0 = r1.floatValue()
            r2.set(r13, r0)
        L_0x008d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Fx.l(float):android.graphics.PointF");
    }
}
