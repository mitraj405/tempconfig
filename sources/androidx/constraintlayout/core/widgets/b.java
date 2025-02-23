package androidx.constraintlayout.core.widgets;

/* compiled from: Chain */
public final class b {
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0280, code lost:
        if (r2.f1340a == r9) goto L_0x0284;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        if (r5.f1340a == r13) goto L_0x00fe;
     */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x032d  */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0331  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0431 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0492 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x0571  */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x0573  */
    /* JADX WARNING: Removed duplicated region for block: B:328:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:329:0x058b  */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0591  */
    /* JADX WARNING: Removed duplicated region for block: B:376:0x0666  */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:393:0x06bc  */
    /* JADX WARNING: Removed duplicated region for block: B:394:0x06bf  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x06c5  */
    /* JADX WARNING: Removed duplicated region for block: B:398:0x06c8  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x06cc  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x06db  */
    /* JADX WARNING: Removed duplicated region for block: B:406:0x06de  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0104 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:423:0x0297 A[EDGE_INSN: B:423:0x0297->B:175:0x0297 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r36, defpackage.ei r37, java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r38, int r39) {
        /*
            r0 = r36
            r10 = r37
            r11 = r38
            if (r39 != 0) goto L_0x0011
            int r1 = r0.E
            androidx.constraintlayout.core.widgets.c[] r2 = r0.f1400b
            r14 = r1
            r15 = r2
            r16 = 0
            goto L_0x0019
        L_0x0011:
            int r1 = r0.F
            androidx.constraintlayout.core.widgets.c[] r2 = r0.f1399a
            r14 = r1
            r15 = r2
            r16 = 2
        L_0x0019:
            r9 = 0
        L_0x001a:
            if (r9 >= r14) goto L_0x070a
            r1 = r15[r9]
            boolean r2 = r1.f1410e
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r3 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            r8 = 8
            r5 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r1.f1402a
            r17 = 0
            if (r2 != 0) goto L_0x0148
            int r2 = r1.c
            int r6 = r2 * 2
            r13 = r7
            r19 = r13
            r18 = 0
        L_0x0034:
            if (r18 != 0) goto L_0x0110
            int r4 = r1.f1401a
            int r4 = r4 + r5
            r1.f1401a = r4
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r13.f1368b
            r4[r2] = r17
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r13.f1359a
            r4[r2] = r17
            int r4 = r13.w
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r13.f1357a
            if (r4 == r8) goto L_0x00da
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = r13.n(r2)
            r4 = r5[r6]
            r4.e()
            int r4 = r6 + 1
            r22 = r5[r4]
            r22.e()
            r22 = r5[r6]
            r22.e()
            r4 = r5[r4]
            r4.e()
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.f1405b
            if (r4 != 0) goto L_0x0069
            r1.f1405b = r13
        L_0x0069:
            r1.d = r13
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r4 = r13.f1358a
            r4 = r4[r2]
            if (r4 != r3) goto L_0x00da
            int[] r8 = r13.f1356a
            r8 = r8[r2]
            r12 = 3
            if (r8 == 0) goto L_0x007d
            if (r8 == r12) goto L_0x007d
            r12 = 2
            if (r8 != r12) goto L_0x00da
        L_0x007d:
            int r12 = r1.b
            r21 = 1
            int r12 = r12 + 1
            r1.b = r12
            float[] r12 = r13.f1355a
            r12 = r12[r2]
            r20 = 0
            int r24 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r24 <= 0) goto L_0x0097
            r24 = r9
            float r9 = r1.a
            float r9 = r9 + r12
            r1.a = r9
            goto L_0x0099
        L_0x0097:
            r24 = r9
        L_0x0099:
            int r9 = r13.w
            r25 = r14
            r14 = 8
            if (r9 == r14) goto L_0x00aa
            if (r4 != r3) goto L_0x00aa
            if (r8 == 0) goto L_0x00a8
            r4 = 3
            if (r8 != r4) goto L_0x00aa
        L_0x00a8:
            r4 = 1
            goto L_0x00ab
        L_0x00aa:
            r4 = 0
        L_0x00ab:
            if (r4 == 0) goto L_0x00c9
            r4 = 0
            int r8 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x00b6
            r4 = 1
            r1.f1406b = r4
            goto L_0x00b9
        L_0x00b6:
            r4 = 1
            r1.f1408c = r4
        L_0x00b9:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r4 = r1.f1403a
            if (r4 != 0) goto L_0x00c4
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.f1403a = r4
        L_0x00c4:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r4 = r1.f1403a
            r4.add(r13)
        L_0x00c9:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.f
            if (r4 != 0) goto L_0x00cf
            r1.f = r13
        L_0x00cf:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.g
            if (r4 == 0) goto L_0x00d7
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.f1359a
            r4[r2] = r13
        L_0x00d7:
            r1.g = r13
            goto L_0x00de
        L_0x00da:
            r24 = r9
            r25 = r14
        L_0x00de:
            r4 = r19
            if (r4 == r13) goto L_0x00e6
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r4 = r4.f1368b
            r4[r2] = r13
        L_0x00e6:
            int r4 = r6 + 1
            r4 = r5[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1339a
            if (r4 == 0) goto L_0x00fc
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.f1340a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r4.f1357a
            r5 = r5[r6]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1339a
            if (r5 == 0) goto L_0x00fc
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.f1340a
            if (r5 == r13) goto L_0x00fe
        L_0x00fc:
            r4 = r17
        L_0x00fe:
            if (r4 == 0) goto L_0x0101
            goto L_0x0104
        L_0x0101:
            r4 = r13
            r18 = 1
        L_0x0104:
            r19 = r13
            r9 = r24
            r14 = r25
            r5 = 1
            r8 = 8
            r13 = r4
            goto L_0x0034
        L_0x0110:
            r24 = r9
            r25 = r14
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.f1405b
            if (r4 == 0) goto L_0x011f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r4.f1357a
            r4 = r4[r6]
            r4.e()
        L_0x011f:
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r1.d
            if (r4 == 0) goto L_0x012c
            int r6 = r6 + 1
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r4.f1357a
            r4 = r4[r6]
            r4.e()
        L_0x012c:
            r1.f1407c = r13
            if (r2 != 0) goto L_0x0137
            boolean r2 = r1.f1404a
            if (r2 == 0) goto L_0x0137
            r1.e = r13
            goto L_0x0139
        L_0x0137:
            r1.e = r7
        L_0x0139:
            boolean r2 = r1.f1408c
            if (r2 == 0) goto L_0x0143
            boolean r2 = r1.f1406b
            if (r2 == 0) goto L_0x0143
            r2 = 1
            goto L_0x0144
        L_0x0143:
            r2 = 0
        L_0x0144:
            r1.f1409d = r2
            r2 = 1
            goto L_0x014d
        L_0x0148:
            r24 = r9
            r25 = r14
            r2 = r5
        L_0x014d:
            r1.f1410e = r2
            if (r11 == 0) goto L_0x015e
            boolean r2 = r11.contains(r7)
            if (r2 == 0) goto L_0x0158
            goto L_0x015e
        L_0x0158:
            r30 = r15
            r22 = r24
            goto L_0x06fe
        L_0x015e:
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r1.f1407c
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r1.f1405b
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r1.d
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r1.e
            float r4 = r1.a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r5 = r0.f1358a
            r5 = r5[r39]
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            if (r5 != r6) goto L_0x0172
            r5 = 1
            goto L_0x0173
        L_0x0172:
            r5 = 0
        L_0x0173:
            if (r39 != 0) goto L_0x0190
            int r6 = r2.x
            r8 = 1
            if (r6 != 0) goto L_0x017d
            r21 = 1
            goto L_0x017f
        L_0x017d:
            r21 = 0
        L_0x017f:
            if (r6 != r8) goto L_0x0185
            r18 = r8
            r9 = 2
            goto L_0x0188
        L_0x0185:
            r9 = 2
            r18 = 0
        L_0x0188:
            if (r6 != r9) goto L_0x018d
            r6 = r21
            goto L_0x01a6
        L_0x018d:
            r6 = r21
            goto L_0x01b0
        L_0x0190:
            r8 = 1
            r9 = 2
            int r6 = r2.y
            if (r6 != 0) goto L_0x0199
            r18 = r8
            goto L_0x019b
        L_0x0199:
            r18 = 0
        L_0x019b:
            if (r6 != r8) goto L_0x019f
            r8 = 1
            goto L_0x01a0
        L_0x019f:
            r8 = 0
        L_0x01a0:
            if (r6 != r9) goto L_0x01ac
            r6 = r18
            r18 = r8
        L_0x01a6:
            r19 = r18
            r18 = r6
            r6 = 1
            goto L_0x01b5
        L_0x01ac:
            r6 = r18
            r18 = r8
        L_0x01b0:
            r19 = r18
            r18 = r6
            r6 = 0
        L_0x01b5:
            r23 = r4
            r9 = r7
            r8 = 0
        L_0x01b9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r0.f1357a
            if (r8 != 0) goto L_0x0297
            r28 = r8
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r9.f1357a
            r8 = r8[r16]
            if (r6 == 0) goto L_0x01c8
            r27 = 1
            goto L_0x01ca
        L_0x01c8:
            r27 = 4
        L_0x01ca:
            int r29 = r8.e()
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r11 = r9.f1358a
            r11 = r11[r39]
            if (r11 != r3) goto L_0x01de
            int[] r11 = r9.f1356a
            r11 = r11[r39]
            if (r11 != 0) goto L_0x01de
            r30 = r15
            r11 = 1
            goto L_0x01e1
        L_0x01de:
            r30 = r15
            r11 = 0
        L_0x01e1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r8.f1339a
            if (r15 == 0) goto L_0x01ed
            if (r9 == r7) goto L_0x01ed
            int r15 = r15.e()
            int r29 = r15 + r29
        L_0x01ed:
            r15 = r29
            if (r6 == 0) goto L_0x01fa
            if (r9 == r7) goto L_0x01fa
            if (r9 == r13) goto L_0x01fa
            r29 = r2
            r27 = 8
            goto L_0x01fc
        L_0x01fa:
            r29 = r2
        L_0x01fc:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r8.f1339a
            if (r2 == 0) goto L_0x023a
            if (r9 != r13) goto L_0x020f
            r31 = r7
            yx r7 = r8.f1342a
            yx r2 = r2.f1342a
            r32 = r1
            r1 = 6
            r10.f(r7, r2, r15, r1)
            goto L_0x021c
        L_0x020f:
            r32 = r1
            r31 = r7
            yx r1 = r8.f1342a
            yx r2 = r2.f1342a
            r7 = 8
            r10.f(r1, r2, r15, r7)
        L_0x021c:
            if (r11 == 0) goto L_0x0222
            if (r6 != 0) goto L_0x0222
            r27 = 5
        L_0x0222:
            if (r9 != r13) goto L_0x022e
            if (r6 == 0) goto L_0x022e
            boolean[] r1 = r9.f1369b
            boolean r1 = r1[r39]
            if (r1 == 0) goto L_0x022e
            r1 = 5
            goto L_0x0230
        L_0x022e:
            r1 = r27
        L_0x0230:
            yx r2 = r8.f1342a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r8.f1339a
            yx r7 = r7.f1342a
            r10.e(r2, r7, r15, r1)
            goto L_0x023e
        L_0x023a:
            r32 = r1
            r31 = r7
        L_0x023e:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r9.f1357a
            if (r5 == 0) goto L_0x026c
            int r2 = r9.w
            r7 = 8
            if (r2 == r7) goto L_0x025e
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r2 = r9.f1358a
            r2 = r2[r39]
            if (r2 != r3) goto L_0x025e
            int r2 = r16 + 1
            r2 = r1[r2]
            yx r2 = r2.f1342a
            r7 = r1[r16]
            yx r7 = r7.f1342a
            r8 = 5
            r11 = 0
            r10.f(r2, r7, r11, r8)
            goto L_0x025f
        L_0x025e:
            r11 = 0
        L_0x025f:
            r2 = r1[r16]
            yx r2 = r2.f1342a
            r4 = r4[r16]
            yx r4 = r4.f1342a
            r7 = 8
            r10.f(r2, r4, r11, r7)
        L_0x026c:
            int r2 = r16 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1339a
            if (r1 == 0) goto L_0x0282
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.f1340a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r1.f1357a
            r2 = r2[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f1339a
            if (r2 == 0) goto L_0x0282
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r2.f1340a
            if (r2 == r9) goto L_0x0284
        L_0x0282:
            r1 = r17
        L_0x0284:
            if (r1 == 0) goto L_0x028a
            r9 = r1
            r8 = r28
            goto L_0x028b
        L_0x028a:
            r8 = 1
        L_0x028b:
            r11 = r38
            r2 = r29
            r15 = r30
            r7 = r31
            r1 = r32
            goto L_0x01b9
        L_0x0297:
            r32 = r1
            r29 = r2
            r31 = r7
            r30 = r15
            if (r14 == 0) goto L_0x0300
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.f1357a
            int r2 = r16 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.f1339a
            if (r1 == 0) goto L_0x0300
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.f1357a
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r7 = r14.f1358a
            r7 = r7[r39]
            if (r7 != r3) goto L_0x02bd
            int[] r3 = r14.f1356a
            r3 = r3[r39]
            if (r3 != 0) goto L_0x02bd
            r3 = 1
            goto L_0x02be
        L_0x02bd:
            r3 = 0
        L_0x02be:
            if (r3 == 0) goto L_0x02d6
            if (r6 != 0) goto L_0x02d6
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.f1339a
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r3.f1340a
            if (r7 != r0) goto L_0x02d6
            yx r7 = r1.f1342a
            yx r3 = r3.f1342a
            int r8 = r1.e()
            int r8 = -r8
            r9 = 5
            r10.e(r7, r3, r8, r9)
            goto L_0x02ec
        L_0x02d6:
            r9 = 5
            if (r6 == 0) goto L_0x02ec
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.f1339a
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r3.f1340a
            if (r7 != r0) goto L_0x02ec
            yx r7 = r1.f1342a
            yx r3 = r3.f1342a
            int r8 = r1.e()
            int r8 = -r8
            r11 = 4
            r10.e(r7, r3, r8, r11)
        L_0x02ec:
            yx r3 = r1.f1342a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r12.f1357a
            r2 = r7[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.f1339a
            yx r2 = r2.f1342a
            int r1 = r1.e()
            int r1 = -r1
            r7 = 6
            r10.g(r3, r2, r1, r7)
            goto L_0x0301
        L_0x0300:
            r9 = 5
        L_0x0301:
            if (r5 == 0) goto L_0x0318
            int r1 = r16 + 1
            r2 = r4[r1]
            yx r2 = r2.f1342a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r12.f1357a
            r1 = r3[r1]
            yx r3 = r1.f1342a
            int r1 = r1.e()
            r4 = 8
            r10.f(r2, r3, r1, r4)
        L_0x0318:
            r1 = r32
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r1.f1403a
            if (r2 == 0) goto L_0x042f
            int r3 = r2.size()
            r4 = 1
            if (r3 <= r4) goto L_0x042f
            boolean r5 = r1.f1406b
            if (r5 == 0) goto L_0x0331
            boolean r5 = r1.f1409d
            if (r5 != 0) goto L_0x0331
            int r5 = r1.b
            float r5 = (float) r5
            goto L_0x0333
        L_0x0331:
            r5 = r23
        L_0x0333:
            r8 = r17
            r7 = 0
            r11 = 0
        L_0x0337:
            if (r11 >= r3) goto L_0x042f
            java.lang.Object r15 = r2.get(r11)
            androidx.constraintlayout.core.widgets.ConstraintWidget r15 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r15
            float[] r4 = r15.f1355a
            r4 = r4[r39]
            r20 = 0
            int r23 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r9 = r15.f1357a
            if (r23 >= 0) goto L_0x0363
            boolean r4 = r1.f1409d
            if (r4 == 0) goto L_0x035f
            int r4 = r16 + 1
            r4 = r9[r4]
            yx r4 = r4.f1342a
            r9 = r9[r16]
            yx r9 = r9.f1342a
            r0 = 0
            r15 = 4
            r10.e(r4, r9, r0, r15)
            goto L_0x037a
        L_0x035f:
            r0 = 4
            r4 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0364
        L_0x0363:
            r0 = 4
        L_0x0364:
            r20 = 0
            int r23 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r23 != 0) goto L_0x0382
            int r4 = r16 + 1
            r4 = r9[r4]
            yx r4 = r4.f1342a
            r9 = r9[r16]
            yx r9 = r9.f1342a
            r0 = 0
            r15 = 8
            r10.e(r4, r9, r0, r15)
        L_0x037a:
            r32 = r2
            r28 = r3
            r20 = 0
            goto L_0x0423
        L_0x0382:
            r0 = 0
            if (r8 == 0) goto L_0x0415
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r8.f1357a
            r0 = r8[r16]
            yx r0 = r0.f1342a
            int r28 = r16 + 1
            r8 = r8[r28]
            yx r8 = r8.f1342a
            r32 = r2
            r2 = r9[r16]
            yx r2 = r2.f1342a
            r9 = r9[r28]
            yx r9 = r9.f1342a
            r28 = r3
            L1 r3 = r37.l()
            r33 = r15
            r15 = 0
            r3.a = r15
            int r20 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            r15 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r20 == 0) goto L_0x03f6
            int r20 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r20 != 0) goto L_0x03b1
            goto L_0x03f6
        L_0x03b1:
            r20 = 0
            int r34 = (r7 > r20 ? 1 : (r7 == r20 ? 0 : -1))
            if (r34 != 0) goto L_0x03c4
            L1$a r2 = r3.f377a
            r7 = 1065353216(0x3f800000, float:1.0)
            r2.j(r0, r7)
            L1$a r0 = r3.f377a
            r0.j(r8, r15)
            goto L_0x03d4
        L_0x03c4:
            r15 = 1065353216(0x3f800000, float:1.0)
            if (r23 != 0) goto L_0x03d7
            L1$a r0 = r3.f377a
            r0.j(r2, r15)
            L1$a r0 = r3.f377a
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0.j(r9, r2)
        L_0x03d4:
            r23 = r4
            goto L_0x0411
        L_0x03d7:
            float r7 = r7 / r5
            float r23 = r4 / r5
            float r7 = r7 / r23
            r23 = r4
            L1$a r4 = r3.f377a
            r4.j(r0, r15)
            L1$a r0 = r3.f377a
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0.j(r8, r4)
            L1$a r0 = r3.f377a
            r0.j(r9, r7)
            L1$a r0 = r3.f377a
            float r4 = -r7
            r0.j(r2, r4)
            goto L_0x0411
        L_0x03f6:
            r23 = r4
            r4 = r15
            r15 = 1065353216(0x3f800000, float:1.0)
            r20 = 0
            L1$a r7 = r3.f377a
            r7.j(r0, r15)
            L1$a r0 = r3.f377a
            r0.j(r8, r4)
            L1$a r0 = r3.f377a
            r0.j(r9, r15)
            L1$a r0 = r3.f377a
            r0.j(r2, r4)
        L_0x0411:
            r10.c(r3)
            goto L_0x041f
        L_0x0415:
            r32 = r2
            r28 = r3
            r23 = r4
            r33 = r15
            r20 = 0
        L_0x041f:
            r7 = r23
            r8 = r33
        L_0x0423:
            int r11 = r11 + 1
            r3 = r28
            r2 = r32
            r4 = 1
            r9 = 5
            r0 = r36
            goto L_0x0337
        L_0x042f:
            if (r13 == 0) goto L_0x048b
            if (r13 == r14) goto L_0x0435
            if (r6 == 0) goto L_0x048b
        L_0x0435:
            r0 = r31
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.f1357a
            int r2 = r16 + 1
            r1 = r1[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1339a
            if (r0 == 0) goto L_0x0449
            yx r0 = r0.f1342a
            r3 = r0
            goto L_0x044b
        L_0x0449:
            r3 = r17
        L_0x044b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r1.f1339a
            if (r0 == 0) goto L_0x0453
            yx r0 = r0.f1342a
            r6 = r0
            goto L_0x0455
        L_0x0453:
            r6 = r17
        L_0x0455:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.f1357a
            r0 = r0[r16]
            if (r14 == 0) goto L_0x045f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.f1357a
            r1 = r1[r2]
        L_0x045f:
            if (r3 == 0) goto L_0x0486
            if (r6 == 0) goto L_0x0486
            if (r39 != 0) goto L_0x046a
            r2 = r29
            float r2 = r2.f
            goto L_0x046e
        L_0x046a:
            r2 = r29
            float r2 = r2.g
        L_0x046e:
            r5 = r2
            int r4 = r0.e()
            int r8 = r1.e()
            yx r2 = r0.f1342a
            yx r7 = r1.f1342a
            r9 = 7
            r1 = r37
            r11 = r24
            r15 = 2
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x06a1
        L_0x0486:
            r11 = r24
            r15 = 2
            goto L_0x06a1
        L_0x048b:
            r11 = r24
            r0 = r31
            r15 = 2
            if (r18 == 0) goto L_0x057a
            if (r13 == 0) goto L_0x057a
            int r2 = r1.b
            if (r2 <= 0) goto L_0x049f
            int r1 = r1.f1401a
            if (r1 != r2) goto L_0x049f
            r21 = 1
            goto L_0x04a1
        L_0x049f:
            r21 = 0
        L_0x04a1:
            r8 = r13
            r9 = r8
        L_0x04a3:
            if (r9 == 0) goto L_0x06a1
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r9.f1368b
            r1 = r1[r39]
            r7 = r1
        L_0x04aa:
            if (r7 == 0) goto L_0x04b7
            int r1 = r7.w
            r6 = 8
            if (r1 != r6) goto L_0x04b9
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r7.f1368b
            r7 = r1[r39]
            goto L_0x04aa
        L_0x04b7:
            r6 = 8
        L_0x04b9:
            if (r7 != 0) goto L_0x04c5
            if (r9 != r14) goto L_0x04be
            goto L_0x04c5
        L_0x04be:
            r20 = r7
            r22 = r8
            r15 = r9
            goto L_0x056b
        L_0x04c5:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r9.f1357a
            r2 = r1[r16]
            yx r3 = r2.f1342a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r2.f1339a
            if (r4 == 0) goto L_0x04d2
            yx r4 = r4.f1342a
            goto L_0x04d4
        L_0x04d2:
            r4 = r17
        L_0x04d4:
            if (r8 == r9) goto L_0x04df
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r8.f1357a
            int r5 = r16 + 1
            r4 = r4[r5]
            yx r4 = r4.f1342a
            goto L_0x04ee
        L_0x04df:
            if (r9 != r13) goto L_0x04ee
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r0.f1357a
            r4 = r4[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.f1339a
            if (r4 == 0) goto L_0x04ec
            yx r4 = r4.f1342a
            goto L_0x04ee
        L_0x04ec:
            r4 = r17
        L_0x04ee:
            int r2 = r2.e()
            int r5 = r16 + 1
            r20 = r1[r5]
            int r20 = r20.e()
            if (r7 == 0) goto L_0x0503
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r7.f1357a
            r6 = r6[r16]
            yx r15 = r6.f1342a
            goto L_0x0510
        L_0x0503:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r12.f1357a
            r6 = r6[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.f1339a
            if (r6 == 0) goto L_0x050e
            yx r15 = r6.f1342a
            goto L_0x0510
        L_0x050e:
            r15 = r17
        L_0x0510:
            r1 = r1[r5]
            yx r1 = r1.f1342a
            if (r6 == 0) goto L_0x051c
            int r6 = r6.e()
            int r20 = r6 + r20
        L_0x051c:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r8.f1357a
            r6 = r6[r5]
            int r6 = r6.e()
            int r6 = r6 + r2
            if (r3 == 0) goto L_0x04be
            if (r4 == 0) goto L_0x04be
            if (r15 == 0) goto L_0x04be
            if (r1 == 0) goto L_0x04be
            if (r9 != r13) goto L_0x0538
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r13.f1357a
            r2 = r2[r16]
            int r2 = r2.e()
            r6 = r2
        L_0x0538:
            if (r9 != r14) goto L_0x0544
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r14.f1357a
            r2 = r2[r5]
            int r2 = r2.e()
            r20 = r2
        L_0x0544:
            if (r21 == 0) goto L_0x0549
            r23 = 8
            goto L_0x054b
        L_0x0549:
            r23 = 5
        L_0x054b:
            r5 = 1056964608(0x3f000000, float:0.5)
            r24 = r1
            r1 = r37
            r2 = r3
            r3 = r4
            r31 = r0
            r0 = 5
            r4 = r6
            r22 = 8
            r6 = r15
            r15 = r7
            r0 = r31
            r7 = r24
            r22 = r8
            r8 = r20
            r20 = r15
            r15 = r9
            r9 = r23
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x056b:
            int r1 = r15.w
            r9 = 8
            if (r1 == r9) goto L_0x0573
            r8 = r15
            goto L_0x0575
        L_0x0573:
            r8 = r22
        L_0x0575:
            r9 = r20
            r15 = 2
            goto L_0x04a3
        L_0x057a:
            r9 = 8
            if (r19 == 0) goto L_0x06a1
            if (r13 == 0) goto L_0x06a1
            int r2 = r1.b
            if (r2 <= 0) goto L_0x058b
            int r1 = r1.f1401a
            if (r1 != r2) goto L_0x058b
            r21 = 1
            goto L_0x058d
        L_0x058b:
            r21 = 0
        L_0x058d:
            r8 = r13
            r15 = r8
        L_0x058f:
            if (r15 == 0) goto L_0x064c
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r15.f1368b
            r1 = r1[r39]
        L_0x0595:
            if (r1 == 0) goto L_0x05a0
            int r2 = r1.w
            if (r2 != r9) goto L_0x05a0
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r1 = r1.f1368b
            r1 = r1[r39]
            goto L_0x0595
        L_0x05a0:
            if (r15 == r13) goto L_0x0637
            if (r15 == r14) goto L_0x0637
            if (r1 == 0) goto L_0x0637
            if (r1 != r14) goto L_0x05ab
            r7 = r17
            goto L_0x05ac
        L_0x05ab:
            r7 = r1
        L_0x05ac:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r15.f1357a
            r2 = r1[r16]
            yx r3 = r2.f1342a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r8.f1357a
            int r5 = r16 + 1
            r4 = r4[r5]
            yx r4 = r4.f1342a
            int r2 = r2.e()
            r6 = r1[r5]
            int r6 = r6.e()
            if (r7 == 0) goto L_0x05d8
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r7.f1357a
            r1 = r1[r16]
            yx r9 = r1.f1342a
            r20 = r7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r1.f1339a
            if (r7 == 0) goto L_0x05d5
            yx r7 = r7.f1342a
            goto L_0x05ee
        L_0x05d5:
            r7 = r17
            goto L_0x05ee
        L_0x05d8:
            r20 = r7
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r14.f1357a
            r7 = r7[r16]
            if (r7 == 0) goto L_0x05e3
            yx r9 = r7.f1342a
            goto L_0x05e5
        L_0x05e3:
            r9 = r17
        L_0x05e5:
            r1 = r1[r5]
            yx r1 = r1.f1342a
            r35 = r7
            r7 = r1
            r1 = r35
        L_0x05ee:
            if (r1 == 0) goto L_0x05f8
            int r1 = r1.e()
            int r1 = r1 + r6
            r22 = r1
            goto L_0x05fa
        L_0x05f8:
            r22 = r6
        L_0x05fa:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r8.f1357a
            r1 = r1[r5]
            int r1 = r1.e()
            int r5 = r1 + r2
            if (r21 == 0) goto L_0x0609
            r23 = 8
            goto L_0x060b
        L_0x0609:
            r23 = 4
        L_0x060b:
            if (r3 == 0) goto L_0x062c
            if (r4 == 0) goto L_0x062c
            if (r9 == 0) goto L_0x062c
            if (r7 == 0) goto L_0x062c
            r6 = 1056964608(0x3f000000, float:0.5)
            r1 = r37
            r2 = r3
            r3 = r4
            r24 = 4
            r4 = r5
            r5 = r6
            r6 = r9
            r26 = r8
            r8 = r22
            r22 = r11
            r11 = 8
            r9 = r23
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0634
        L_0x062c:
            r26 = r8
            r22 = r11
            r11 = 8
            r24 = 4
        L_0x0634:
            r1 = r20
            goto L_0x063e
        L_0x0637:
            r26 = r8
            r22 = r11
            r24 = 4
            r11 = r9
        L_0x063e:
            int r2 = r15.w
            if (r2 == r11) goto L_0x0644
            r8 = r15
            goto L_0x0646
        L_0x0644:
            r8 = r26
        L_0x0646:
            r15 = r1
            r9 = r11
            r11 = r22
            goto L_0x058f
        L_0x064c:
            r22 = r11
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r13.f1357a
            r1 = r1[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.f1357a
            r0 = r0[r16]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.f1339a
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r14.f1357a
            int r3 = r16 + 1
            r11 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r12.f1357a
            r2 = r2[r3]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r15 = r2.f1339a
            if (r0 == 0) goto L_0x068f
            if (r13 == r14) goto L_0x0675
            yx r2 = r1.f1342a
            yx r0 = r0.f1342a
            int r1 = r1.e()
            r3 = 5
            r10.e(r2, r0, r1, r3)
            goto L_0x068f
        L_0x0675:
            if (r15 == 0) goto L_0x068f
            yx r2 = r1.f1342a
            yx r3 = r0.f1342a
            int r4 = r1.e()
            r5 = 1056964608(0x3f000000, float:0.5)
            yx r6 = r11.f1342a
            yx r7 = r15.f1342a
            int r8 = r11.e()
            r9 = 5
            r1 = r37
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x068f:
            if (r15 == 0) goto L_0x06a3
            if (r13 == r14) goto L_0x06a3
            yx r0 = r11.f1342a
            yx r1 = r15.f1342a
            int r2 = r11.e()
            int r2 = -r2
            r3 = 5
            r10.e(r0, r1, r2, r3)
            goto L_0x06a3
        L_0x06a1:
            r22 = r11
        L_0x06a3:
            if (r18 != 0) goto L_0x06a7
            if (r19 == 0) goto L_0x06fe
        L_0x06a7:
            if (r13 == 0) goto L_0x06fe
            if (r13 == r14) goto L_0x06fe
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r13.f1357a
            r1 = r0[r16]
            if (r14 != 0) goto L_0x06b2
            r14 = r13
        L_0x06b2:
            int r2 = r16 + 1
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r14.f1357a
            r3 = r3[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r1.f1339a
            if (r4 == 0) goto L_0x06bf
            yx r4 = r4.f1342a
            goto L_0x06c1
        L_0x06bf:
            r4 = r17
        L_0x06c1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r3.f1339a
            if (r5 == 0) goto L_0x06c8
            yx r5 = r5.f1342a
            goto L_0x06ca
        L_0x06c8:
            r5 = r17
        L_0x06ca:
            if (r12 == r14) goto L_0x06db
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r12.f1357a
            r5 = r5[r2]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1339a
            if (r5 == 0) goto L_0x06d8
            yx r5 = r5.f1342a
            r17 = r5
        L_0x06d8:
            r6 = r17
            goto L_0x06dc
        L_0x06db:
            r6 = r5
        L_0x06dc:
            if (r13 != r14) goto L_0x06e0
            r3 = r0[r2]
        L_0x06e0:
            if (r4 == 0) goto L_0x06fe
            if (r6 == 0) goto L_0x06fe
            r5 = 1056964608(0x3f000000, float:0.5)
            int r0 = r1.e()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r14.f1357a
            r2 = r7[r2]
            int r8 = r2.e()
            yx r2 = r1.f1342a
            yx r7 = r3.f1342a
            r9 = 5
            r1 = r37
            r3 = r4
            r4 = r0
            r1.b(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x06fe:
            int r9 = r22 + 1
            r0 = r36
            r11 = r38
            r14 = r25
            r15 = r30
            goto L_0x001a
        L_0x070a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.b.a(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, ei, java.util.ArrayList, int):void");
    }
}
