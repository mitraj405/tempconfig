package defpackage;

import defpackage.Tg;

/* renamed from: Q0  reason: default package */
/* compiled from: AnimatableTransformParser */
public final class Q0 {
    public static final Tg.a a = Tg.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");
    public static final Tg.a b = Tg.a.a("k");

    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01b3, code lost:
        if (r0 != false) goto L_0x01b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01e2  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.P0 a(defpackage.Ug r28, defpackage.C0181ej r29) throws java.io.IOException {
        /*
            r0 = r28
            r8 = r29
            int r1 = r28.r()
            r2 = 3
            r10 = 0
            if (r1 != r2) goto L_0x000e
            r11 = 1
            goto L_0x000f
        L_0x000e:
            r11 = r10
        L_0x000f:
            if (r11 == 0) goto L_0x0014
            r28.b()
        L_0x0014:
            r1 = 0
            r6 = 0
            r7 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r21 = 0
            r22 = 0
            r23 = 0
        L_0x0020:
            boolean r2 = r28.j()
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r2 == 0) goto L_0x010b
            Tg$a r2 = a
            int r2 = r0.t(r2)
            switch(r2) {
                case 0: goto L_0x00e0;
                case 1: goto L_0x00d7;
                case 2: goto L_0x00c8;
                case 3: goto L_0x0057;
                case 4: goto L_0x005c;
                case 5: goto L_0x0052;
                case 6: goto L_0x004d;
                case 7: goto L_0x0048;
                case 8: goto L_0x0043;
                case 9: goto L_0x003e;
                default: goto L_0x0032;
            }
        L_0x0032:
            r26 = r6
            r27 = r7
            r5 = 1
            r28.u()
            r28.v()
            goto L_0x0020
        L_0x003e:
            H0 r13 = defpackage.C1354qp.f0(r0, r8, r10)
            goto L_0x0020
        L_0x0043:
            H0 r14 = defpackage.C1354qp.f0(r0, r8, r10)
            goto L_0x0020
        L_0x0048:
            H0 r23 = defpackage.C1354qp.f0(r0, r8, r10)
            goto L_0x0020
        L_0x004d:
            H0 r22 = defpackage.C1354qp.f0(r0, r8, r10)
            goto L_0x0020
        L_0x0052:
            J0 r21 = defpackage.C1354qp.g0(r28, r29)
            goto L_0x0020
        L_0x0057:
            java.lang.String r1 = "Lottie doesn't support 3D layers."
            r8.a(r1)
        L_0x005c:
            H0 r5 = defpackage.C1354qp.f0(r0, r8, r10)
            java.util.List<Bh<V>> r3 = r5.a
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x0096
            Bh r2 = new Bh
            java.lang.Float r16 = java.lang.Float.valueOf(r4)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r17 = 0
            r18 = 0
            float r1 = r8.b
            java.lang.Float r19 = java.lang.Float.valueOf(r1)
            r1 = r2
            r12 = r2
            r2 = r29
            r9 = r3
            r3 = r16
            r16 = r5
            r5 = r17
            r26 = r6
            r6 = r18
            r27 = r7
            r7 = r19
            r1.<init>((defpackage.C0181ej) r2, r3, r4, (android.view.animation.Interpolator) r5, (float) r6, (java.lang.Float) r7)
            r9.add(r12)
            goto L_0x00c2
        L_0x0096:
            r9 = r3
            r16 = r5
            r26 = r6
            r27 = r7
            java.lang.Object r1 = r9.get(r10)
            Bh r1 = (defpackage.Bh) r1
            T r1 = r1.f65a
            if (r1 != 0) goto L_0x00c2
            Bh r12 = new Bh
            java.lang.Float r3 = java.lang.Float.valueOf(r4)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            r5 = 0
            r6 = 0
            float r1 = r8.b
            java.lang.Float r7 = java.lang.Float.valueOf(r1)
            r1 = r12
            r2 = r29
            r1.<init>((defpackage.C0181ej) r2, r3, r4, (android.view.animation.Interpolator) r5, (float) r6, (java.lang.Float) r7)
            r9.set(r10, r12)
        L_0x00c2:
            r1 = r16
            r6 = r26
            r5 = 1
            goto L_0x0107
        L_0x00c8:
            r27 = r7
            I0 r6 = new I0
            cv r2 = defpackage.cv.a
            java.util.ArrayList r2 = defpackage.Eh.a(r0, r8, r3, r2, r10)
            r5 = 1
            r6.<init>(r2, r5)
            goto L_0x0107
        L_0x00d7:
            r26 = r6
            r5 = 1
            R0 r7 = defpackage.K0.b(r28, r29)
            goto L_0x0020
        L_0x00e0:
            r26 = r6
            r27 = r7
            r5 = 1
            r28.b()
        L_0x00e8:
            boolean r2 = r28.j()
            if (r2 == 0) goto L_0x0102
            Tg$a r2 = b
            int r2 = r0.t(r2)
            if (r2 == 0) goto L_0x00fd
            r28.u()
            r28.v()
            goto L_0x00e8
        L_0x00fd:
            nh r15 = defpackage.K0.a(r28, r29)
            goto L_0x00e8
        L_0x0102:
            r28.e()
            r6 = r26
        L_0x0107:
            r7 = r27
            goto L_0x0020
        L_0x010b:
            r26 = r6
            r27 = r7
            r5 = 1
            if (r11 == 0) goto L_0x0115
            r28.e()
        L_0x0115:
            if (r15 == 0) goto L_0x0134
            boolean r0 = r15.a()
            if (r0 == 0) goto L_0x0132
            java.lang.Object r0 = r15.a
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r0.get(r10)
            Bh r0 = (defpackage.Bh) r0
            T r0 = r0.f65a
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            boolean r0 = r0.equals(r4, r4)
            if (r0 == 0) goto L_0x0132
            goto L_0x0134
        L_0x0132:
            r0 = r10
            goto L_0x0135
        L_0x0134:
            r0 = r5
        L_0x0135:
            if (r0 == 0) goto L_0x013c
            r7 = r27
            r17 = 0
            goto L_0x0140
        L_0x013c:
            r17 = r15
            r7 = r27
        L_0x0140:
            if (r7 == 0) goto L_0x0163
            boolean r0 = r7 instanceof defpackage.L0
            if (r0 != 0) goto L_0x0161
            boolean r0 = r7.a()
            if (r0 == 0) goto L_0x0161
            java.util.List r0 = r7.c()
            java.lang.Object r0 = r0.get(r10)
            Bh r0 = (defpackage.Bh) r0
            T r0 = r0.f65a
            android.graphics.PointF r0 = (android.graphics.PointF) r0
            boolean r0 = r0.equals(r4, r4)
            if (r0 == 0) goto L_0x0161
            goto L_0x0163
        L_0x0161:
            r0 = r10
            goto L_0x0164
        L_0x0163:
            r0 = r5
        L_0x0164:
            if (r0 == 0) goto L_0x0169
            r18 = 0
            goto L_0x016b
        L_0x0169:
            r18 = r7
        L_0x016b:
            if (r1 == 0) goto L_0x018a
            boolean r0 = r1.a()
            if (r0 == 0) goto L_0x0188
            java.util.List<Bh<V>> r0 = r1.a
            java.lang.Object r0 = r0.get(r10)
            Bh r0 = (defpackage.Bh) r0
            T r0 = r0.f65a
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0188
            goto L_0x018a
        L_0x0188:
            r0 = r10
            goto L_0x018b
        L_0x018a:
            r0 = r5
        L_0x018b:
            r6 = r26
            if (r0 == 0) goto L_0x0190
            r1 = 0
        L_0x0190:
            if (r6 == 0) goto L_0x01b8
            boolean r0 = r6.a()
            if (r0 == 0) goto L_0x01b6
            java.util.List<Bh<V>> r0 = r6.a
            java.lang.Object r0 = r0.get(r10)
            Bh r0 = (defpackage.Bh) r0
            T r0 = r0.f65a
            bv r0 = (defpackage.bv) r0
            float r2 = r0.a
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x01b2
            float r0 = r0.b
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x01b2
            r0 = r5
            goto L_0x01b3
        L_0x01b2:
            r0 = r10
        L_0x01b3:
            if (r0 == 0) goto L_0x01b6
            goto L_0x01b8
        L_0x01b6:
            r0 = r10
            goto L_0x01b9
        L_0x01b8:
            r0 = r5
        L_0x01b9:
            if (r0 == 0) goto L_0x01be
            r19 = 0
            goto L_0x01c0
        L_0x01be:
            r19 = r6
        L_0x01c0:
            if (r14 == 0) goto L_0x01df
            boolean r0 = r14.a()
            if (r0 == 0) goto L_0x01dd
            java.util.List<Bh<V>> r0 = r14.a
            java.lang.Object r0 = r0.get(r10)
            Bh r0 = (defpackage.Bh) r0
            T r0 = r0.f65a
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x01dd
            goto L_0x01df
        L_0x01dd:
            r0 = r10
            goto L_0x01e0
        L_0x01df:
            r0 = r5
        L_0x01e0:
            if (r0 == 0) goto L_0x01e5
            r24 = 0
            goto L_0x01e7
        L_0x01e5:
            r24 = r14
        L_0x01e7:
            if (r13 == 0) goto L_0x0206
            boolean r0 = r13.a()
            if (r0 == 0) goto L_0x0204
            java.util.List<Bh<V>> r0 = r13.a
            java.lang.Object r0 = r0.get(r10)
            Bh r0 = (defpackage.Bh) r0
            T r0 = r0.f65a
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x0204
            goto L_0x0206
        L_0x0204:
            r9 = r10
            goto L_0x0207
        L_0x0206:
            r9 = r5
        L_0x0207:
            if (r9 == 0) goto L_0x020c
            r25 = 0
            goto L_0x020e
        L_0x020c:
            r25 = r13
        L_0x020e:
            P0 r0 = new P0
            r16 = r0
            r20 = r1
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Q0.a(Ug, ej):P0");
    }
}
