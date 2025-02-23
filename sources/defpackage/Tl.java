package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* renamed from: Tl  reason: default package */
/* compiled from: MotionConstrainedPoint */
public final class Tl implements Comparable<Tl> {
    public float a = 1.0f;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashMap<String, O6> f558a = new LinkedHashMap<>();
    public float b = 0.0f;
    public float c = 0.0f;

    /* renamed from: c  reason: collision with other field name */
    public int f559c = 0;
    public float d = 0.0f;

    /* renamed from: d  reason: collision with other field name */
    public int f560d;
    public float e = 0.0f;
    public float f = 1.0f;
    public float g = 1.0f;
    public float h = Float.NaN;
    public float i = Float.NaN;
    public float j = 0.0f;
    public float k = 0.0f;
    public float l = 0.0f;
    public float m = Float.NaN;
    public float n = Float.NaN;

    public static boolean h(float f2, float f3) {
        if (Float.isNaN(f2) || Float.isNaN(f3)) {
            if (Float.isNaN(f2) != Float.isNaN(f3)) {
                return true;
            }
            return false;
        } else if (Math.abs(f2 - f3) > 1.0E-6f) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.HashMap<java.lang.String, defpackage.MC> r8, int r9) {
        /*
            r7 = this;
            java.util.Set r0 = r8.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01ef
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r8.get(r1)
            MC r2 = (defpackage.MC) r2
            r1.getClass()
            int r3 = r1.hashCode()
            r4 = 1
            switch(r3) {
                case -1249320806: goto L_0x00c8;
                case -1249320805: goto L_0x00bd;
                case -1225497657: goto L_0x00b2;
                case -1225497656: goto L_0x00a7;
                case -1225497655: goto L_0x009c;
                case -1001078227: goto L_0x0091;
                case -908189618: goto L_0x0086;
                case -908189617: goto L_0x007b;
                case -760884510: goto L_0x006d;
                case -760884509: goto L_0x005f;
                case -40300674: goto L_0x0051;
                case -4379043: goto L_0x0043;
                case 37232917: goto L_0x0035;
                case 92909918: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x00d3
        L_0x0027:
            java.lang.String r3 = "alpha"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0031
            goto L_0x00d3
        L_0x0031:
            r3 = 13
            goto L_0x00d4
        L_0x0035:
            java.lang.String r3 = "transitionPathRotate"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x003f
            goto L_0x00d3
        L_0x003f:
            r3 = 12
            goto L_0x00d4
        L_0x0043:
            java.lang.String r3 = "elevation"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x004d
            goto L_0x00d3
        L_0x004d:
            r3 = 11
            goto L_0x00d4
        L_0x0051:
            java.lang.String r3 = "rotation"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005b
            goto L_0x00d3
        L_0x005b:
            r3 = 10
            goto L_0x00d4
        L_0x005f:
            java.lang.String r3 = "transformPivotY"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0069
            goto L_0x00d3
        L_0x0069:
            r3 = 9
            goto L_0x00d4
        L_0x006d:
            java.lang.String r3 = "transformPivotX"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0077
            goto L_0x00d3
        L_0x0077:
            r3 = 8
            goto L_0x00d4
        L_0x007b:
            java.lang.String r3 = "scaleY"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0084
            goto L_0x00d3
        L_0x0084:
            r3 = 7
            goto L_0x00d4
        L_0x0086:
            java.lang.String r3 = "scaleX"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x008f
            goto L_0x00d3
        L_0x008f:
            r3 = 6
            goto L_0x00d4
        L_0x0091:
            java.lang.String r3 = "progress"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x009a
            goto L_0x00d3
        L_0x009a:
            r3 = 5
            goto L_0x00d4
        L_0x009c:
            java.lang.String r3 = "translationZ"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00a5
            goto L_0x00d3
        L_0x00a5:
            r3 = 4
            goto L_0x00d4
        L_0x00a7:
            java.lang.String r3 = "translationY"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00b0
            goto L_0x00d3
        L_0x00b0:
            r3 = 3
            goto L_0x00d4
        L_0x00b2:
            java.lang.String r3 = "translationX"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00bb
            goto L_0x00d3
        L_0x00bb:
            r3 = 2
            goto L_0x00d4
        L_0x00bd:
            java.lang.String r3 = "rotationY"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00c6
            goto L_0x00d3
        L_0x00c6:
            r3 = r4
            goto L_0x00d4
        L_0x00c8:
            java.lang.String r3 = "rotationX"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00d1
            goto L_0x00d3
        L_0x00d1:
            r3 = 0
            goto L_0x00d4
        L_0x00d3:
            r3 = -1
        L_0x00d4:
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            switch(r3) {
                case 0: goto L_0x01d0;
                case 1: goto L_0x01c0;
                case 2: goto L_0x01b0;
                case 3: goto L_0x01a0;
                case 4: goto L_0x0190;
                case 5: goto L_0x0180;
                case 6: goto L_0x0170;
                case 7: goto L_0x0160;
                case 8: goto L_0x0150;
                case 9: goto L_0x0140;
                case 10: goto L_0x0130;
                case 11: goto L_0x0120;
                case 12: goto L_0x0110;
                case 13: goto L_0x0100;
                default: goto L_0x00da;
            }
        L_0x00da:
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            if (r3 == 0) goto L_0x0008
            java.lang.String r3 = ","
            java.lang.String[] r1 = r1.split(r3)
            r1 = r1[r4]
            java.util.LinkedHashMap<java.lang.String, O6> r3 = r7.f558a
            boolean r4 = r3.containsKey(r1)
            if (r4 == 0) goto L_0x0008
            java.lang.Object r1 = r3.get(r1)
            O6 r1 = (defpackage.O6) r1
            boolean r3 = r2 instanceof defpackage.MC.b
            if (r3 == 0) goto L_0x01e7
            MC$b r2 = (defpackage.MC.b) r2
            goto L_0x01e0
        L_0x0100:
            float r1 = r7.a
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            float r5 = r7.a
        L_0x010b:
            r2.b(r5, r9)
            goto L_0x0008
        L_0x0110:
            float r1 = r7.m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0119
            goto L_0x011b
        L_0x0119:
            float r6 = r7.m
        L_0x011b:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x0120:
            float r1 = r7.b
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0129
            goto L_0x012b
        L_0x0129:
            float r6 = r7.b
        L_0x012b:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x0130:
            float r1 = r7.c
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            float r6 = r7.c
        L_0x013b:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x0140:
            float r1 = r7.i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            float r6 = r7.i
        L_0x014b:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x0150:
            float r1 = r7.h
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            float r6 = r7.h
        L_0x015b:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x0160:
            float r1 = r7.g
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            float r5 = r7.g
        L_0x016b:
            r2.b(r5, r9)
            goto L_0x0008
        L_0x0170:
            float r1 = r7.f
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0179
            goto L_0x017b
        L_0x0179:
            float r5 = r7.f
        L_0x017b:
            r2.b(r5, r9)
            goto L_0x0008
        L_0x0180:
            float r1 = r7.n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0189
            goto L_0x018b
        L_0x0189:
            float r6 = r7.n
        L_0x018b:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x0190:
            float r1 = r7.l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x0199
            goto L_0x019b
        L_0x0199:
            float r6 = r7.l
        L_0x019b:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x01a0:
            float r1 = r7.k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01a9
            goto L_0x01ab
        L_0x01a9:
            float r6 = r7.k
        L_0x01ab:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x01b0:
            float r1 = r7.j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01b9
            goto L_0x01bb
        L_0x01b9:
            float r6 = r7.j
        L_0x01bb:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x01c0:
            float r1 = r7.e
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01c9
            goto L_0x01cb
        L_0x01c9:
            float r6 = r7.e
        L_0x01cb:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x01d0:
            float r1 = r7.d
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 == 0) goto L_0x01d9
            goto L_0x01db
        L_0x01d9:
            float r6 = r7.d
        L_0x01db:
            r2.b(r6, r9)
            goto L_0x0008
        L_0x01e0:
            android.util.SparseArray<O6> r2 = r2.a
            r2.append(r9, r1)
            goto L_0x0008
        L_0x01e7:
            r1.a()
            java.util.Objects.toString(r2)
            goto L_0x0008
        L_0x01ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Tl.a(java.util.HashMap, int):void");
    }

    public final int compareTo(Object obj) {
        ((Tl) obj).getClass();
        return Float.compare(0.0f, 0.0f);
    }

    public final void f(View view) {
        float f2;
        this.f560d = view.getVisibility();
        if (view.getVisibility() != 0) {
            f2 = 0.0f;
        } else {
            f2 = view.getAlpha();
        }
        this.a = f2;
        this.b = view.getElevation();
        this.c = view.getRotation();
        this.d = view.getRotationX();
        this.e = view.getRotationY();
        this.f = view.getScaleX();
        this.g = view.getScaleY();
        this.h = view.getPivotX();
        this.i = view.getPivotY();
        this.j = view.getTranslationX();
        this.k = view.getTranslationY();
        this.l = view.getTranslationZ();
    }

    public final void i(Rect rect, ConstraintSet constraintSet, int i2, int i3) {
        float f2;
        rect.width();
        rect.height();
        ConstraintSet.a h2 = constraintSet.h(i3);
        ConstraintSet.d dVar = h2.f1667a;
        int i4 = dVar.f1706b;
        this.f559c = i4;
        int i5 = dVar.f1704a;
        this.f560d = i5;
        if (i5 == 0 || i4 != 0) {
            f2 = dVar.a;
        } else {
            f2 = 0.0f;
        }
        this.a = f2;
        ConstraintSet.e eVar = h2.f1668a;
        boolean z = eVar.f1710b;
        this.b = eVar.k;
        this.c = eVar.f1707a;
        this.d = eVar.b;
        this.e = eVar.c;
        this.f = eVar.d;
        this.g = eVar.e;
        this.h = eVar.f;
        this.i = eVar.g;
        this.j = eVar.h;
        this.k = eVar.i;
        this.l = eVar.j;
        ConstraintSet.c cVar = h2.f1666a;
        T9.c(cVar.f1699a);
        this.m = cVar.b;
        this.n = h2.f1667a.b;
        Iterator<String> it = h2.f1670a.keySet().iterator();
        while (true) {
            boolean z2 = true;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            O6 o6 = h2.f1670a.get(next);
            int V = xx.V(o6.f463a);
            if (V == 4 || V == 5 || V == 7) {
                z2 = false;
            }
            if (z2) {
                this.f558a.put(next, o6);
            }
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return;
                    }
                }
            }
            float f3 = this.c + 90.0f;
            this.c = f3;
            if (f3 > 180.0f) {
                this.c = f3 - 360.0f;
                return;
            }
            return;
        }
        this.c -= 90.0f;
    }
}
