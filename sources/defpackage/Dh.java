package defpackage;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import defpackage.Tg;
import java.lang.ref.WeakReference;

/* renamed from: Dh  reason: default package */
/* compiled from: KeyframeParser */
public final class Dh {
    public static final Tg.a a = Tg.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* renamed from: a  reason: collision with other field name */
    public static final LinearInterpolator f120a = new LinearInterpolator();

    /* renamed from: a  reason: collision with other field name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f121a;
    public static final Tg.a b = Tg.a.a("x", "y");

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: android.view.animation.Interpolator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.animation.Interpolator a(android.graphics.PointF r7, android.graphics.PointF r8) {
        /*
            float r0 = r7.x
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = 1065353216(0x3f800000, float:1.0)
            float r0 = defpackage.C0308ql.b(r0, r1, r2)
            r7.x = r0
            float r0 = r7.y
            r3 = -1027080192(0xffffffffc2c80000, float:-100.0)
            r4 = 1120403456(0x42c80000, float:100.0)
            float r0 = defpackage.C0308ql.b(r0, r3, r4)
            r7.y = r0
            float r0 = r8.x
            float r0 = defpackage.C0308ql.b(r0, r1, r2)
            r8.x = r0
            float r0 = r8.y
            float r0 = defpackage.C0308ql.b(r0, r3, r4)
            r8.y = r0
            float r1 = r7.x
            float r3 = r7.y
            float r4 = r8.x
            UB$a r5 = defpackage.UB.f567a
            r5 = 0
            int r6 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r6 == 0) goto L_0x003b
            r6 = 527(0x20f, float:7.38E-43)
            float r6 = (float) r6
            float r6 = r6 * r1
            int r1 = (int) r6
            goto L_0x003d
        L_0x003b:
            r1 = 17
        L_0x003d:
            int r6 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r6 == 0) goto L_0x0046
            int r1 = r1 * 31
            float r1 = (float) r1
            float r1 = r1 * r3
            int r1 = (int) r1
        L_0x0046:
            int r3 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x004f
            int r1 = r1 * 31
            float r1 = (float) r1
            float r1 = r1 * r4
            int r1 = (int) r1
        L_0x004f:
            int r3 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0058
            int r1 = r1 * 31
            float r1 = (float) r1
            float r1 = r1 * r0
            int r1 = (int) r1
        L_0x0058:
            java.lang.Class<Dh> r0 = defpackage.Dh.class
            monitor-enter(r0)
            androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> r3 = f121a     // Catch:{ all -> 0x00c5 }
            if (r3 != 0) goto L_0x0066
            androidx.collection.SparseArrayCompat r3 = new androidx.collection.SparseArrayCompat     // Catch:{ all -> 0x00c5 }
            r3.<init>()     // Catch:{ all -> 0x00c5 }
            f121a = r3     // Catch:{ all -> 0x00c5 }
        L_0x0066:
            androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> r3 = f121a     // Catch:{ all -> 0x00c5 }
            r4 = 0
            java.lang.Object r3 = r3.c(r1, r4)     // Catch:{ all -> 0x00c5 }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ all -> 0x00c5 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
            if (r3 == 0) goto L_0x0079
            java.lang.Object r0 = r3.get()
            r4 = r0
            android.view.animation.Interpolator r4 = (android.view.animation.Interpolator) r4
        L_0x0079:
            if (r3 == 0) goto L_0x007d
            if (r4 != 0) goto L_0x00c4
        L_0x007d:
            float r0 = r7.x     // Catch:{ IllegalArgumentException -> 0x008a }
            float r3 = r7.y     // Catch:{ IllegalArgumentException -> 0x008a }
            float r4 = r8.x     // Catch:{ IllegalArgumentException -> 0x008a }
            float r6 = r8.y     // Catch:{ IllegalArgumentException -> 0x008a }
            android.view.animation.Interpolator r7 = defpackage.ep.b(r0, r3, r4, r6)     // Catch:{ IllegalArgumentException -> 0x008a }
            goto L_0x00b1
        L_0x008a:
            r0 = move-exception
            java.lang.String r3 = "The Path cannot loop back on itself."
            java.lang.String r0 = r0.getMessage()
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x00ac
            float r0 = r7.x
            float r0 = java.lang.Math.min(r0, r2)
            float r7 = r7.y
            float r2 = r8.x
            float r2 = java.lang.Math.max(r2, r5)
            float r8 = r8.y
            android.view.animation.Interpolator r7 = defpackage.ep.b(r0, r7, r2, r8)
            goto L_0x00b1
        L_0x00ac:
            android.view.animation.LinearInterpolator r7 = new android.view.animation.LinearInterpolator
            r7.<init>()
        L_0x00b1:
            r4 = r7
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00c4 }
            r7.<init>(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00c4 }
            java.lang.Class<Dh> r8 = defpackage.Dh.class
            monitor-enter(r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00c4 }
            androidx.collection.SparseArrayCompat<java.lang.ref.WeakReference<android.view.animation.Interpolator>> r0 = f121a     // Catch:{ all -> 0x00c1 }
            r0.d(r1, r7)     // Catch:{ all -> 0x00c1 }
            monitor-exit(r8)     // Catch:{ all -> 0x00c1 }
            goto L_0x00c4
        L_0x00c1:
            r7 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x00c1 }
            throw r7     // Catch:{ ArrayIndexOutOfBoundsException -> 0x00c4 }
        L_0x00c4:
            return r4
        L_0x00c5:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c5 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Dh.a(android.graphics.PointF, android.graphics.PointF):android.view.animation.Interpolator");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01cc, code lost:
        r10 = r8;
        r3 = r19;
        r15 = r20;
        r8 = r21;
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01d7, code lost:
        r15 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01d9, code lost:
        r9 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01db, code lost:
        r3 = r19;
        r8 = r21;
     */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0217 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> defpackage.Bh<T> b(defpackage.Tg r23, defpackage.C0181ej r24, float r25, defpackage.XB<T> r26, boolean r27, boolean r28) throws java.io.IOException {
        /*
            r0 = r23
            r1 = r25
            r2 = r26
            android.view.animation.LinearInterpolator r3 = f120a
            Tg$a r8 = a
            if (r27 == 0) goto L_0x023b
            if (r28 == 0) goto L_0x023b
            r23.b()
            r5 = 0
            r6 = 0
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x001f:
            boolean r19 = r23.j()
            if (r19 == 0) goto L_0x01e1
            int r19 = r0.t(r8)
            Tg$a r4 = b
            switch(r19) {
                case 0: goto L_0x01bc;
                case 1: goto L_0x01ad;
                case 2: goto L_0x019d;
                case 3: goto L_0x010d;
                case 4: goto L_0x0068;
                case 5: goto L_0x0054;
                case 6: goto L_0x0047;
                case 7: goto L_0x003c;
                default: goto L_0x002e;
            }
        L_0x002e:
            r19 = r3
            r21 = r8
            r22 = r9
            r8 = r10
            r20 = r15
            r23.v()
            goto L_0x01d7
        L_0x003c:
            android.graphics.PointF r4 = defpackage.Wg.b(r0, r1)
            r19 = r3
            r9 = r4
            r21 = r8
            goto L_0x01db
        L_0x0047:
            android.graphics.PointF r4 = defpackage.Wg.b(r0, r1)
            r19 = r3
            r15 = r4
            r21 = r8
            r22 = r9
            goto L_0x01d9
        L_0x0054:
            int r4 = r23.n()
            r11 = 1
            r19 = r3
            r21 = r8
            r22 = r9
            r20 = r15
            if (r4 != r11) goto L_0x0065
            goto L_0x01d7
        L_0x0065:
            r11 = 0
            goto L_0x01d7
        L_0x0068:
            r19 = r3
            int r3 = r23.r()
            r20 = r15
            r15 = 3
            if (r3 != r15) goto L_0x0102
            r23.b()
            r3 = 0
            r6 = 0
            r7 = 0
            r15 = 0
        L_0x007a:
            boolean r21 = r23.j()
            if (r21 == 0) goto L_0x00ec
            r21 = r8
            int r8 = r0.t(r4)
            if (r8 == 0) goto L_0x00bd
            r22 = r9
            r9 = 1
            if (r8 == r9) goto L_0x0092
            r23.v()
        L_0x0090:
            r8 = r10
            goto L_0x00e6
        L_0x0092:
            int r6 = r23.r()
            r8 = 7
            if (r6 != r8) goto L_0x00a0
            double r8 = r23.m()
            float r6 = (float) r8
            r15 = r6
            goto L_0x0090
        L_0x00a0:
            r23.a()
            double r8 = r23.m()
            float r6 = (float) r8
            int r8 = r23.r()
            r9 = 7
            if (r8 != r9) goto L_0x00b6
            r8 = r10
            double r9 = r23.m()
            float r9 = (float) r9
            goto L_0x00b8
        L_0x00b6:
            r8 = r10
            r9 = r6
        L_0x00b8:
            r23.c()
            r15 = r9
            goto L_0x00e6
        L_0x00bd:
            r22 = r9
            r8 = r10
            int r3 = r23.r()
            r7 = 7
            if (r3 != r7) goto L_0x00ce
            double r9 = r23.m()
            float r3 = (float) r9
            r7 = r3
            goto L_0x00e6
        L_0x00ce:
            r23.a()
            double r9 = r23.m()
            float r3 = (float) r9
            int r9 = r23.r()
            if (r9 != r7) goto L_0x00e2
            double r9 = r23.m()
            float r7 = (float) r9
            goto L_0x00e3
        L_0x00e2:
            r7 = r3
        L_0x00e3:
            r23.c()
        L_0x00e6:
            r10 = r8
            r8 = r21
            r9 = r22
            goto L_0x007a
        L_0x00ec:
            r21 = r8
            r22 = r9
            r8 = r10
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r3, r6)
            android.graphics.PointF r3 = new android.graphics.PointF
            r3.<init>(r7, r15)
            r23.e()
            r7 = r3
            r6 = r4
            goto L_0x01d7
        L_0x0102:
            r21 = r8
            r22 = r9
            android.graphics.PointF r3 = defpackage.Wg.b(r0, r1)
            r10 = r3
            goto L_0x01d7
        L_0x010d:
            r19 = r3
            r21 = r8
            r22 = r9
            r8 = r10
            r20 = r15
            int r3 = r23.r()
            r9 = 3
            if (r3 != r9) goto L_0x0197
            r23.b()
            r3 = 0
            r5 = 0
            r9 = 0
            r10 = 0
        L_0x0124:
            boolean r14 = r23.j()
            if (r14 == 0) goto L_0x0187
            int r14 = r0.t(r4)
            if (r14 == 0) goto L_0x015f
            r15 = 1
            if (r14 == r15) goto L_0x0137
            r23.v()
            goto L_0x0124
        L_0x0137:
            int r5 = r23.r()
            r14 = 7
            if (r5 != r14) goto L_0x0145
            double r14 = r23.m()
            float r10 = (float) r14
            r5 = r10
            goto L_0x0124
        L_0x0145:
            r23.a()
            double r14 = r23.m()
            float r5 = (float) r14
            int r10 = r23.r()
            r14 = 7
            if (r10 != r14) goto L_0x015a
            double r14 = r23.m()
            float r10 = (float) r14
            goto L_0x015b
        L_0x015a:
            r10 = r5
        L_0x015b:
            r23.c()
            goto L_0x0124
        L_0x015f:
            int r3 = r23.r()
            r14 = 7
            if (r3 != r14) goto L_0x016d
            double r14 = r23.m()
            float r9 = (float) r14
            r3 = r9
            goto L_0x0124
        L_0x016d:
            r23.a()
            double r14 = r23.m()
            float r3 = (float) r14
            int r9 = r23.r()
            r14 = 7
            if (r9 != r14) goto L_0x0182
            double r14 = r23.m()
            float r9 = (float) r14
            goto L_0x0183
        L_0x0182:
            r9 = r3
        L_0x0183:
            r23.c()
            goto L_0x0124
        L_0x0187:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>(r3, r5)
            android.graphics.PointF r3 = new android.graphics.PointF
            r3.<init>(r9, r10)
            r23.e()
            r14 = r3
            r5 = r4
            goto L_0x01cc
        L_0x0197:
            android.graphics.PointF r3 = defpackage.Wg.b(r0, r1)
            r13 = r3
            goto L_0x01cc
        L_0x019d:
            r19 = r3
            r21 = r8
            r22 = r9
            r8 = r10
            r20 = r15
            java.lang.Object r3 = r2.d(r0, r1)
            r17 = r3
            goto L_0x01d7
        L_0x01ad:
            r19 = r3
            r21 = r8
            r22 = r9
            r8 = r10
            r20 = r15
            java.lang.Object r3 = r2.d(r0, r1)
            r12 = r3
            goto L_0x01d7
        L_0x01bc:
            r19 = r3
            r21 = r8
            r22 = r9
            r8 = r10
            r20 = r15
            double r3 = r23.m()
            float r3 = (float) r3
            r16 = r3
        L_0x01cc:
            r10 = r8
            r3 = r19
            r15 = r20
            r8 = r21
            r9 = r22
            goto L_0x001f
        L_0x01d7:
            r15 = r20
        L_0x01d9:
            r9 = r22
        L_0x01db:
            r3 = r19
            r8 = r21
            goto L_0x001f
        L_0x01e1:
            r19 = r3
            r22 = r9
            r8 = r10
            r20 = r15
            r23.e()
            if (r11 == 0) goto L_0x01f0
            r17 = r12
            goto L_0x020f
        L_0x01f0:
            if (r13 == 0) goto L_0x01f9
            if (r8 == 0) goto L_0x01f9
            android.view.animation.Interpolator r3 = a(r13, r8)
            goto L_0x0211
        L_0x01f9:
            if (r5 == 0) goto L_0x020f
            if (r14 == 0) goto L_0x020f
            if (r6 == 0) goto L_0x020f
            if (r7 == 0) goto L_0x020f
            android.view.animation.Interpolator r0 = a(r5, r6)
            android.view.animation.Interpolator r1 = a(r14, r7)
            r14 = r0
            r15 = r1
            r13 = r17
            r3 = 0
            goto L_0x0215
        L_0x020f:
            r3 = r19
        L_0x0211:
            r13 = r17
            r14 = 0
            r15 = 0
        L_0x0215:
            if (r14 == 0) goto L_0x0224
            if (r15 == 0) goto L_0x0224
            Bh r0 = new Bh
            r10 = r0
            r11 = r24
            r7 = r20
            r10.<init>((defpackage.C0181ej) r11, (java.lang.Object) r12, (java.lang.Object) r13, (android.view.animation.Interpolator) r14, (android.view.animation.Interpolator) r15, (float) r16)
            goto L_0x0234
        L_0x0224:
            r7 = r20
            Bh r0 = new Bh
            r1 = 0
            r10 = r0
            r11 = r24
            r14 = r3
            r15 = r16
            r16 = r1
            r10.<init>((defpackage.C0181ej) r11, r12, r13, (android.view.animation.Interpolator) r14, (float) r15, (java.lang.Float) r16)
        L_0x0234:
            r0.f61a = r7
            r7 = r22
            r0.f67b = r7
            return r0
        L_0x023b:
            r19 = r3
            r21 = r8
            if (r27 == 0) goto L_0x02c6
            r23.b()
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r13 = 0
            r18 = 0
        L_0x024d:
            boolean r6 = r23.j()
            if (r6 == 0) goto L_0x02a0
            r6 = r21
            int r8 = r0.t(r6)
            r9 = 1065353216(0x3f800000, float:1.0)
            switch(r8) {
                case 0: goto L_0x0296;
                case 1: goto L_0x028f;
                case 2: goto L_0x0287;
                case 3: goto L_0x0281;
                case 4: goto L_0x027b;
                case 5: goto L_0x026e;
                case 6: goto L_0x0268;
                case 7: goto L_0x0263;
                default: goto L_0x025e;
            }
        L_0x025e:
            r12 = 1
            r23.v()
            goto L_0x029d
        L_0x0263:
            android.graphics.PointF r5 = defpackage.Wg.b(r0, r1)
            goto L_0x026c
        L_0x0268:
            android.graphics.PointF r4 = defpackage.Wg.b(r0, r1)
        L_0x026c:
            r12 = 1
            goto L_0x029d
        L_0x026e:
            int r8 = r23.n()
            r12 = 1
            r21 = r6
            if (r8 != r12) goto L_0x0279
            r11 = r12
            goto L_0x024d
        L_0x0279:
            r11 = 0
            goto L_0x024d
        L_0x027b:
            r12 = 1
            android.graphics.PointF r3 = defpackage.Wg.b(r0, r9)
            goto L_0x029d
        L_0x0281:
            r12 = 1
            android.graphics.PointF r7 = defpackage.Wg.b(r0, r9)
            goto L_0x029d
        L_0x0287:
            r12 = 1
            java.lang.Object r8 = r2.d(r0, r1)
            r18 = r8
            goto L_0x029d
        L_0x028f:
            r12 = 1
            java.lang.Object r8 = r2.d(r0, r1)
            r10 = r8
            goto L_0x029d
        L_0x0296:
            r12 = 1
            double r8 = r23.m()
            float r8 = (float) r8
            r13 = r8
        L_0x029d:
            r21 = r6
            goto L_0x024d
        L_0x02a0:
            r23.e()
            if (r11 == 0) goto L_0x02a9
            r11 = r10
            r12 = r19
            goto L_0x02b8
        L_0x02a9:
            if (r7 == 0) goto L_0x02b3
            if (r3 == 0) goto L_0x02b3
            android.view.animation.Interpolator r0 = a(r7, r3)
            r3 = r0
            goto L_0x02b5
        L_0x02b3:
            r3 = r19
        L_0x02b5:
            r12 = r3
            r11 = r18
        L_0x02b8:
            Bh r0 = new Bh
            r14 = 0
            r8 = r0
            r9 = r24
            r8.<init>((defpackage.C0181ej) r9, r10, r11, (android.view.animation.Interpolator) r12, (float) r13, (java.lang.Float) r14)
            r0.f61a = r4
            r0.f67b = r5
            return r0
        L_0x02c6:
            java.lang.Object r0 = r2.d(r0, r1)
            Bh r1 = new Bh
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Dh.b(Tg, ej, float, XB, boolean, boolean):Bh");
    }
}
