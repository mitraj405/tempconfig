package defpackage;

/* renamed from: bn  reason: default package and case insensitive filesystem */
/* compiled from: NotificationEventManager */
public final class C0806bn implements Runnable {
    public final /* synthetic */ C1203jp a;

    public C0806bn(C1203jp jpVar) {
        this.a = jpVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x03c4  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x03cc  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x03e2 A[Catch:{ Exception -> 0x0401 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x03eb A[Catch:{ Exception -> 0x0401 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x03fb A[Catch:{ Exception -> 0x0401 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r31 = this;
            java.lang.String r1 = "receiveAds"
            java.lang.String r2 = "NotificationEventManager"
            java.lang.String r3 = "1"
            r4 = r31
            jp r14 = r4.a
            int r0 = r14.l
            java.lang.String r0 = com.momagic.H.l(r0)
            r15 = 2
            r13 = 1
            if (r0 == 0) goto L_0x0066
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x0066
            int r5 = r0.length()
            int r5 = r5 - r15
            char r5 = r0.charAt(r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r0.length()
            int r6 = r6 - r13
            char r6 = r0.charAt(r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r7 = r0.length()
            int r7 = r7 + -3
            char r7 = r0.charAt(r7)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            com.momagic.x.f4065a = r7
            int r7 = r0.length()
            int r7 = r7 + -7
            char r7 = r0.charAt(r7)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r8 = r0.length()
            int r8 = r8 + -9
            char r0 = r0.charAt(r8)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r12 = r0
            r16 = r5
            r11 = r6
            r10 = r7
            goto L_0x006f
        L_0x0066:
            java.lang.String r6 = "0"
            com.momagic.x.f4065a = r6
            r10 = r6
            r11 = r10
            r12 = r11
            r16 = r12
        L_0x006f:
            int r0 = r14.f
            com.momagic.x.b(r0)
            android.content.Context r0 = com.momagic.C0835h.f4046a
            gq r9 = defpackage.C1139gq.c(r0)
            android.content.Context r0 = com.momagic.C0835h.f4046a
            java.lang.String r5 = "notification"
            java.lang.Object r0 = r0.getSystemService(r5)
            r8 = r0
            android.app.NotificationManager r8 = (android.app.NotificationManager) r8
            android.content.Context r0 = com.momagic.C0835h.f4046a
            java.lang.String r7 = defpackage.Q7.c(r0, r8, r14)
            java.lang.String r0 = r14.f5536j
            int r0 = com.momagic.x.d(r0)
            com.momagic.x.a = r0
            android.graphics.Bitmap r6 = r14.f5524a
            android.graphics.Bitmap r5 = r14.f5527b
            java.lang.String r0 = r14.f5531e
            java.lang.String r13 = r14.n
            java.lang.String r15 = r14.p
            java.lang.String r19 = "NO"
            java.lang.String r20 = com.momagic.x.f4065a
            r21 = 100
            r22 = 0
            r23 = r5
            r5 = r14
            r24 = r6
            r6 = r0
            r25 = r7
            r7 = r13
            r13 = r8
            r8 = r15
            r15 = r9
            r9 = r19
            r26 = r10
            r10 = r16
            r27 = r11
            r11 = r20
            r4 = r12
            r12 = r21
            r19 = r4
            r17 = r13
            r4 = 1
            r13 = r22
            android.content.Intent r0 = com.momagic.x.n(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            int r5 = android.os.Build.VERSION.SDK_INT
            r13 = 31
            r6 = 1140850688(0x44000000, float:512.0)
            if (r5 < r13) goto L_0x00dd
            android.content.Context r5 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            android.app.PendingIntent r0 = android.app.PendingIntent.getActivity(r5, r7, r0, r6)
            goto L_0x00e8
        L_0x00dd:
            android.content.Context r5 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r5, r7, r0, r6)
        L_0x00e8:
            androidx.core.app.NotificationCompat$Builder r12 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r5 = com.momagic.C0835h.f4046a
            r6 = r25
            r12.<init>(r5, r6)
            int r5 = com.momagic.x.a()
            android.app.Notification r7 = r12.f1735a
            r7.icon = r5
            java.lang.String r5 = r14.f5532f
            r12.g(r5)
            java.lang.String r5 = r14.f5534h
            r12.f(r5)
            r12.f1736a = r0
            boolean r0 = com.momagic.H.e(r14)
            r5 = 2
            r12.j(r5, r0)
            long r7 = com.momagic.H.n(r14)
            r12.f1733a = r7
            r0 = 16
            r12.j(r0, r4)
            java.math.BigInteger r0 = com.momagic.H.f()     // Catch:{ Exception -> 0x0125 }
            if (r0 == 0) goto L_0x012f
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0125 }
            r12.c = r0     // Catch:{ Exception -> 0x0125 }
            goto L_0x012f
        L_0x0125:
            r0 = move-exception
            android.content.Context r5 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            com.momagic.H.r(r5, r0, r2, r1)
        L_0x012f:
            int r0 = android.os.Build.VERSION.SDK_INT
            int r5 = r14.a
            if (r5 != r4) goto L_0x018c
            java.lang.String r5 = r14.s
            r12.f1742a = r5
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r7 = com.momagic.C0835h.f4046a
            r5.<init>(r7, r6)
            java.lang.String r6 = r14.f5532f
            r5.g(r6)
            java.lang.String r6 = r14.f5534h
            r5.f(r6)
            int r6 = com.momagic.x.a()
            android.app.Notification r7 = r5.f1735a
            r7.icon = r6
            int r6 = com.momagic.x.a
            r5.c = r6
            boolean r6 = com.momagic.H.e(r14)
            r7 = 2
            r5.j(r7, r6)
            long r6 = com.momagic.H.n(r14)
            r5.f1733a = r6
            Xm r6 = new Xm
            r6.<init>()
            java.lang.String r7 = r14.f5534h
            if (r7 == 0) goto L_0x0176
            java.util.ArrayList<java.lang.CharSequence> r8 = r6.a
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.c(r7)
            r8.add(r7)
        L_0x0176:
            java.lang.String r7 = r14.t
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.c(r7)
            r6.f713a = r7
            r5.m(r6)
            java.lang.String r6 = r14.s
            r5.f1742a = r6
            r5.f1749b = r4
            android.app.Notification r5 = r5.b()
            goto L_0x018d
        L_0x018c:
            r5 = 0
        L_0x018d:
            r11 = r5
            java.lang.String r5 = r14.f5533g
            java.lang.String r6 = "null"
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x01aa
            java.lang.String r5 = r14.f5533g
            if (r5 == 0) goto L_0x01aa
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x01aa
            java.lang.String r5 = r14.f5533g
            java.lang.CharSequence r5 = androidx.core.app.NotificationCompat$Builder.c(r5)
            r12.f1750c = r5
        L_0x01aa:
            java.lang.String r5 = r14.f5536j
            if (r5 == 0) goto L_0x01b8
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x01b8
            int r5 = com.momagic.x.a
            r12.c = r5
        L_0x01b8:
            r5 = r24
            if (r5 == 0) goto L_0x01c8
            androidx.core.graphics.drawable.IconCompat r7 = new androidx.core.graphics.drawable.IconCompat
            r7.<init>(r4)
            r7.f1781a = r5
            r12.f1740a = r7
            r7 = r23
            goto L_0x01d5
        L_0x01c8:
            r7 = r23
            if (r7 == 0) goto L_0x01d5
            androidx.core.graphics.drawable.IconCompat r8 = new androidx.core.graphics.drawable.IconCompat
            r8.<init>(r4)
            r8.f1781a = r7
            r12.f1740a = r8
        L_0x01d5:
            if (r7 == 0) goto L_0x0202
            java.lang.String r8 = r14.f5533g
            boolean r6 = r8.contains(r6)
            if (r6 != 0) goto L_0x0202
            java.lang.String r6 = r14.f5533g
            if (r6 == 0) goto L_0x0202
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0202
            Um r6 = new Um
            r6.<init>()
            r6.i(r7)
            r6.h(r5)
            java.lang.String r5 = r14.f5534h
            java.lang.CharSequence r5 = androidx.core.app.NotificationCompat$Builder.c(r5)
            r6.b = r5
            r6.f714a = r4
            r12.m(r6)
            goto L_0x024d
        L_0x0202:
            if (r7 == 0) goto L_0x0227
            java.lang.String r6 = r14.f5534h
            if (r6 == 0) goto L_0x0227
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x0227
            Um r6 = new Um
            r6.<init>()
            r6.i(r7)
            r6.h(r5)
            java.lang.String r5 = r14.f5534h
            java.lang.CharSequence r5 = androidx.core.app.NotificationCompat$Builder.c(r5)
            r6.b = r5
            r6.f714a = r4
            r12.m(r6)
            goto L_0x024d
        L_0x0227:
            if (r7 == 0) goto L_0x024d
            java.lang.String r6 = r14.f5534h
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x024d
            Um r6 = new Um
            r6.<init>()
            r6.i(r7)
            r6.h(r5)
            java.lang.String r5 = r14.f5534h
            android.text.Spanned r5 = com.momagic.H.t(r5)
            java.lang.CharSequence r5 = androidx.core.app.NotificationCompat$Builder.c(r5)
            r6.b = r5
            r6.f714a = r4
            r12.m(r6)
        L_0x024d:
            java.lang.String r5 = r14.f5537k
            if (r5 == 0) goto L_0x025e
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x025e
            java.lang.String r5 = r14.f5537k
            int r5 = com.momagic.H.b(r5)
            goto L_0x0263
        L_0x025e:
            long r5 = java.lang.System.currentTimeMillis()
            int r5 = (int) r5
        L_0x0263:
            r10 = r5
            java.lang.String r5 = r14.m
            java.lang.String r7 = ""
            java.lang.String r6 = "~"
            if (r5 == 0) goto L_0x02e0
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x02e0
            java.lang.String r5 = r14.n
            java.lang.String r18 = com.momagic.x.g(r5)
            java.lang.String r5 = r14.n
            java.lang.String r8 = r14.f5531e
            java.lang.String r9 = r14.p
            java.lang.String r22 = com.momagic.x.f4065a
            r23 = 1
            r24 = r5
            r5 = r14
            r4 = r6
            r6 = r24
            r28 = r7
            r7 = r8
            r8 = r9
            r9 = r18
            r18 = r10
            r10 = r16
            r29 = r11
            r11 = r22
            r20 = r1
            r1 = r12
            r12 = r18
            r21 = r2
            r2 = r13
            r13 = r23
            android.content.Intent r5 = com.momagic.x.n(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r0 < r2) goto L_0x02bd
            android.content.Context r6 = com.momagic.C0835h.f4046a
            java.lang.String r6 = com.momagic.H.m(r6)
            r5.setPackage(r6)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            r13 = 201326592(0xc000000, float:9.8607613E-32)
            android.app.PendingIntent r5 = android.app.PendingIntent.getActivity(r6, r7, r5, r13)
            goto L_0x02ca
        L_0x02bd:
            r13 = 201326592(0xc000000, float:9.8607613E-32)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            android.app.PendingIntent r5 = android.app.PendingIntent.getBroadcast(r6, r7, r5, r13)
        L_0x02ca:
            androidx.core.app.a$a r6 = new androidx.core.app.a$a
            java.lang.String r7 = r14.m
            r12 = r28
            java.lang.String r7 = r7.replace(r4, r12)
            r11 = 0
            r6.<init>(r11, r7, r5)
            androidx.core.app.a r5 = r6.a()
            r1.a(r5)
            goto L_0x02ef
        L_0x02e0:
            r20 = r1
            r21 = r2
            r4 = r6
            r18 = r10
            r29 = r11
            r1 = r12
            r2 = r13
            r11 = 0
            r13 = 201326592(0xc000000, float:9.8607613E-32)
            r12 = r7
        L_0x02ef:
            java.lang.String r5 = r14.o
            if (r5 == 0) goto L_0x0354
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0354
            java.lang.String r5 = r14.p
            java.lang.String r9 = com.momagic.x.g(r5)
            java.lang.String r6 = r14.p
            java.lang.String r7 = r14.f5531e
            java.lang.String r8 = r14.n
            java.lang.String r22 = com.momagic.x.f4065a
            r23 = 2
            r5 = r14
            r10 = r16
            r11 = r22
            r30 = r12
            r12 = r18
            r13 = r23
            android.content.Intent r5 = com.momagic.x.n(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r0 < r2) goto L_0x0331
            android.content.Context r6 = com.momagic.C0835h.f4046a
            java.lang.String r6 = com.momagic.H.m(r6)
            r5.setPackage(r6)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            r8 = 201326592(0xc000000, float:9.8607613E-32)
            android.app.PendingIntent r5 = android.app.PendingIntent.getActivity(r6, r7, r5, r8)
            goto L_0x033e
        L_0x0331:
            r8 = 201326592(0xc000000, float:9.8607613E-32)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r9 = java.lang.System.currentTimeMillis()
            int r7 = (int) r9
            android.app.PendingIntent r5 = android.app.PendingIntent.getBroadcast(r6, r7, r5, r8)
        L_0x033e:
            androidx.core.app.a$a r6 = new androidx.core.app.a$a
            java.lang.String r7 = r14.o
            r9 = r30
            java.lang.String r4 = r7.replace(r4, r9)
            r7 = 0
            r6.<init>(r7, r4, r5)
            androidx.core.app.a r4 = r6.a()
            r1.a(r4)
            goto L_0x0356
        L_0x0354:
            r7 = r11
            r8 = r13
        L_0x0356:
            java.lang.String r4 = r14.M     // Catch:{ Exception -> 0x03af }
            if (r4 == 0) goto L_0x03a8
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x03af }
            if (r4 != 0) goto L_0x03a8
            java.lang.String r4 = r14.M     // Catch:{ Exception -> 0x03af }
            boolean r4 = r4.equals(r3)     // Catch:{ Exception -> 0x03af }
            if (r4 == 0) goto L_0x03a8
            java.lang.String r4 = "type"
            java.lang.String r5 = "p"
            r15.h(r4, r5)     // Catch:{ Exception -> 0x03af }
            r5 = r18
            android.content.Intent r4 = defpackage.C1137gn.k(r14, r5)     // Catch:{ Exception -> 0x03a6 }
            if (r0 < r2) goto L_0x0387
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03a6 }
            java.lang.String r0 = com.momagic.H.m(r0)     // Catch:{ Exception -> 0x03a6 }
            r4.setPackage(r0)     // Catch:{ Exception -> 0x03a6 }
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03a6 }
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r0, r5, r4, r8)     // Catch:{ Exception -> 0x03a6 }
            goto L_0x038d
        L_0x0387:
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03a6 }
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r0, r5, r4, r8)     // Catch:{ Exception -> 0x03a6 }
        L_0x038d:
            androidx.core.app.a$a r2 = new androidx.core.app.a$a     // Catch:{ Exception -> 0x03a6 }
            android.content.Context r4 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03a6 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Exception -> 0x03a6 }
            int r6 = defpackage.C0772Zr.iz_cta_dismissed     // Catch:{ Exception -> 0x03a6 }
            java.lang.String r4 = r4.getString(r6)     // Catch:{ Exception -> 0x03a6 }
            r2.<init>(r7, r4, r0)     // Catch:{ Exception -> 0x03a6 }
            androidx.core.app.a r0 = r2.a()     // Catch:{ Exception -> 0x03a6 }
            r1.a(r0)     // Catch:{ Exception -> 0x03a6 }
            goto L_0x03aa
        L_0x03a6:
            r0 = move-exception
            goto L_0x03b2
        L_0x03a8:
            r5 = r18
        L_0x03aa:
            r4 = r20
            r6 = r21
            goto L_0x03bf
        L_0x03af:
            r0 = move-exception
            r5 = r18
        L_0x03b2:
            android.content.Context r2 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            r4 = r20
            r6 = r21
            com.momagic.H.r(r2, r0, r6, r4)
        L_0x03bf:
            int r0 = r14.a
            r2 = 1
            if (r0 != r2) goto L_0x03cc
            r2 = r17
            r8 = r29
            r2.notify(r7, r8)
            goto L_0x03ce
        L_0x03cc:
            r2 = r17
        L_0x03ce:
            android.app.Notification r0 = r1.b()
            r2.notify(r5, r0)
            r1 = r27
            r1.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0401 }
            java.lang.String r0 = com.momagic.x.f4065a     // Catch:{ Exception -> 0x0401 }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0401 }
            if (r0 != 0) goto L_0x03eb
            r7 = r26
            boolean r0 = r7.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0401 }
            if (r0 == 0) goto L_0x03f4
            goto L_0x03ed
        L_0x03eb:
            r7 = r26
        L_0x03ed:
            java.lang.String r0 = com.momagic.x.f4065a     // Catch:{ Exception -> 0x0401 }
            r1 = r19
            com.momagic.x.m(r14, r0, r7, r1)     // Catch:{ Exception -> 0x0401 }
        L_0x03f4:
            com.momagic.C0835h.i(r14)     // Catch:{ Exception -> 0x0401 }
            int r0 = r14.i     // Catch:{ Exception -> 0x0401 }
            if (r0 == 0) goto L_0x040b
            android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x0401 }
            com.momagic.x.e(r1, r0)     // Catch:{ Exception -> 0x0401 }
            goto L_0x040b
        L_0x0401:
            r0 = move-exception
            android.content.Context r1 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            com.momagic.H.r(r1, r0, r6, r4)
        L_0x040b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0806bn.run():void");
    }
}
