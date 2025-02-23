package defpackage;

/* renamed from: cn  reason: default package and case insensitive filesystem */
/* compiled from: NotificationEventManager */
public final class C0826cn implements Runnable {
    public final /* synthetic */ C1203jp a;

    public C0826cn(C1203jp jpVar) {
        this.a = jpVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0590  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0599  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x05aa A[Catch:{ Exception -> 0x05c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x05b3 A[Catch:{ Exception -> 0x05c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x05c3 A[Catch:{ Exception -> 0x05c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"LaunchActivityFromNotification"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r30 = this;
            java.lang.String r1 = "1"
            java.lang.String r2 = "receivedNotification"
            java.lang.String r3 = "NotificationEventManager"
            r4 = r30
            jp r14 = r4.a
            int r0 = r14.l
            java.lang.String r0 = com.momagic.H.l(r0)
            r15 = 2
            if (r0 == 0) goto L_0x0057
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x0057
            int r5 = r0.length()
            int r5 = r5 - r15
            char r5 = r0.charAt(r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r0.length()
            int r6 = r6 + -3
            char r6 = r0.charAt(r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            com.momagic.x.f4065a = r6
            int r6 = r0.length()
            int r6 = r6 + -7
            char r6 = r0.charAt(r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r7 = r0.length()
            int r7 = r7 + -9
            char r0 = r0.charAt(r7)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r13 = r0
            r16 = r5
            r12 = r6
            goto L_0x005f
        L_0x0057:
            java.lang.String r6 = "0"
            com.momagic.x.f4065a = r6
            r12 = r6
            r13 = r12
            r16 = r13
        L_0x005f:
            int r0 = r14.f
            com.momagic.x.b(r0)
            android.content.Context r0 = com.momagic.C0835h.f4046a
            java.lang.String r5 = "notification"
            java.lang.Object r0 = r0.getSystemService(r5)
            r11 = r0
            android.app.NotificationManager r11 = (android.app.NotificationManager) r11
            android.content.Context r0 = com.momagic.C0835h.f4046a
            java.lang.String r10 = defpackage.Q7.c(r0, r11, r14)
            java.lang.String r0 = r14.f5536j
            int r0 = com.momagic.x.d(r0)
            com.momagic.x.a = r0
            android.graphics.Bitmap r0 = r14.f5524a
            android.graphics.Bitmap r9 = r14.f5527b
            java.lang.String r6 = r14.f5531e
            java.lang.String r7 = r14.n
            java.lang.String r8 = r14.p
            java.lang.String r17 = "NO"
            java.lang.String r18 = com.momagic.x.f4065a
            r19 = 100
            r20 = 0
            r5 = r14
            r15 = r9
            r9 = r17
            r22 = r10
            r10 = r16
            r23 = r11
            r11 = r18
            r4 = r12
            r12 = r19
            r24 = r13
            r13 = r20
            android.content.Intent r5 = com.momagic.x.n(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            int r6 = android.os.Build.VERSION.SDK_INT
            r13 = 31
            r7 = 1140850688(0x44000000, float:512.0)
            if (r6 < r13) goto L_0x00ba
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r8 = java.lang.System.currentTimeMillis()
            int r8 = (int) r8
            android.app.PendingIntent r5 = android.app.PendingIntent.getActivity(r6, r8, r5, r7)
            goto L_0x00c5
        L_0x00ba:
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r8 = java.lang.System.currentTimeMillis()
            int r8 = (int) r8
            android.app.PendingIntent r5 = android.app.PendingIntent.getBroadcast(r6, r8, r5, r7)
        L_0x00c5:
            android.widget.RemoteViews r6 = new android.widget.RemoteViews
            android.content.Context r7 = com.momagic.C0835h.f4046a
            java.lang.String r7 = r7.getPackageName()
            int r8 = defpackage.C0683Sr.remote_view
            r6.<init>(r7, r8)
            android.widget.RemoteViews r7 = new android.widget.RemoteViews
            android.content.Context r8 = com.momagic.C0835h.f4046a
            java.lang.String r8 = r8.getPackageName()
            int r9 = defpackage.C0683Sr.remote_view_expands
            r7.<init>(r8, r9)
            r8 = 46
            r12 = 0
            java.lang.String r11 = ""
            if (r15 != 0) goto L_0x0137
            if (r0 != 0) goto L_0x0137
            java.lang.String r0 = r14.f5534h
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0123
            java.lang.String r0 = r14.f5532f
            int r0 = r0.length()
            if (r0 >= r8) goto L_0x0123
            int r0 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5532f
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r6.setTextViewText(r0, r9)
            int r0 = defpackage.C0487Dr.tv_message
            r6.setViewVisibility(r0, r12)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5534h
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r6.setTextViewText(r0, r9)
            goto L_0x01a0
        L_0x0123:
            int r0 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5532f
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r6.setTextViewText(r0, r9)
            goto L_0x01a0
        L_0x0137:
            int r9 = defpackage.C0487Dr.linear_layout_large_icon
            r6.setViewVisibility(r9, r12)
            if (r0 == 0) goto L_0x0148
            int r9 = defpackage.C0487Dr.iv_large_icon
            android.graphics.Bitmap r0 = com.momagic.H.u(r0)
            r6.setImageViewBitmap(r9, r0)
            goto L_0x0151
        L_0x0148:
            int r0 = defpackage.C0487Dr.iv_large_icon
            android.graphics.Bitmap r9 = com.momagic.H.u(r15)
            r6.setImageViewBitmap(r0, r9)
        L_0x0151:
            java.lang.String r0 = r14.f5534h
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x018d
            java.lang.String r0 = r14.f5532f
            int r0 = r0.length()
            r9 = 40
            if (r0 >= r9) goto L_0x018d
            int r0 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5532f
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r6.setTextViewText(r0, r9)
            int r0 = defpackage.C0487Dr.tv_message
            r6.setViewVisibility(r0, r12)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5534h
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r6.setTextViewText(r0, r9)
            goto L_0x01a0
        L_0x018d:
            int r0 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5532f
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r6.setTextViewText(r0, r9)
        L_0x01a0:
            if (r15 != 0) goto L_0x01d5
            int r0 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            java.lang.String r9 = r14.f5532f
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.setTextViewText(r0, r8)
            java.lang.String r0 = r14.f5534h
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x02bd
            int r0 = defpackage.C0487Dr.tv_message
            r7.setViewVisibility(r0, r12)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            java.lang.String r9 = r14.f5534h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.setTextViewText(r0, r8)
            goto L_0x02bd
        L_0x01d5:
            java.lang.String r0 = r14.m
            boolean r0 = r0.isEmpty()
            r9 = 4
            if (r0 == 0) goto L_0x0274
            java.lang.String r0 = r14.o
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0274
            int r0 = defpackage.C0487Dr.tv_title_with_banner_with_button
            r7.setViewVisibility(r0, r9)
            int r0 = defpackage.C0487Dr.iv_banner
            r7.setViewVisibility(r0, r12)
            r7.setImageViewBitmap(r0, r15)
            java.lang.String r0 = r14.f5534h
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x022e
            java.lang.String r0 = r14.f5532f
            int r0 = r0.length()
            if (r0 >= r8) goto L_0x022e
            int r0 = defpackage.C0487Dr.tv_message_with_banner
            r7.setViewVisibility(r0, r12)
            int r8 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5532f
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r7.setTextViewText(r8, r9)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            java.lang.String r9 = r14.f5534h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.setTextViewText(r0, r8)
            goto L_0x02bd
        L_0x022e:
            java.lang.String r0 = r14.f5534h
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0260
            int r0 = defpackage.C0487Dr.tv_message_with_banner_with_button
            r7.setViewVisibility(r0, r12)
            int r8 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r11)
            java.lang.String r10 = r14.f5532f
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r7.setTextViewText(r8, r9)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            java.lang.String r9 = r14.f5534h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.setTextViewText(r0, r8)
            goto L_0x02bd
        L_0x0260:
            int r0 = defpackage.C0487Dr.tv_title
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            java.lang.String r9 = r14.f5532f
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.setTextViewText(r0, r8)
            goto L_0x02bd
        L_0x0274:
            int r0 = defpackage.C0487Dr.tv_title_with_banner_with_button
            r7.setViewVisibility(r0, r12)
            int r10 = defpackage.C0487Dr.tv_title
            r7.setViewVisibility(r10, r9)
            int r9 = defpackage.C0487Dr.iv_banner
            r7.setViewVisibility(r9, r12)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>(r11)
            java.lang.String r13 = r14.f5532f
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            r7.setTextViewText(r0, r10)
            r7.setImageViewBitmap(r9, r15)
            java.lang.String r0 = r14.f5534h
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x02bd
            java.lang.String r0 = r14.f5532f
            int r0 = r0.length()
            if (r0 >= r8) goto L_0x02bd
            int r0 = defpackage.C0487Dr.tv_message_with_banner_with_button
            r7.setViewVisibility(r0, r12)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            java.lang.String r9 = r14.f5534h
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.setTextViewText(r0, r8)
        L_0x02bd:
            androidx.core.app.NotificationCompat$Builder r15 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r0 = com.momagic.C0835h.f4046a
            r8 = r22
            r15.<init>(r0, r8)
            int r0 = com.momagic.x.a()
            android.app.Notification r9 = r15.f1735a
            r9.icon = r0
            java.lang.String r0 = r14.f5532f
            r15.g(r0)
            java.lang.String r0 = r14.f5534h
            r15.f(r0)
            r15.f1736a = r5
            boolean r0 = com.momagic.H.e(r14)
            r5 = 2
            r15.j(r5, r0)
            Wm r0 = new Wm
            r0.<init>()
            r15.m(r0)
            r15.f1739a = r6
            r15.f1745b = r7
            long r5 = com.momagic.H.n(r14)
            r15.f1733a = r5
            r0 = 16
            r13 = 1
            r15.j(r0, r13)
            java.math.BigInteger r0 = com.momagic.H.f()     // Catch:{ Exception -> 0x0307 }
            if (r0 == 0) goto L_0x0311
            int r0 = r0.intValue()     // Catch:{ Exception -> 0x0307 }
            r15.c = r0     // Catch:{ Exception -> 0x0307 }
            goto L_0x0311
        L_0x0307:
            r0 = move-exception
            android.content.Context r5 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            com.momagic.H.r(r5, r0, r3, r2)
        L_0x0311:
            int r0 = android.os.Build.VERSION.SDK_INT
            int r5 = r14.a
            if (r5 != r13) goto L_0x03ed
            java.lang.String r5 = r14.f5534h
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x039e
            java.lang.String r5 = r14.s
            r15.f1742a = r5
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r6 = com.momagic.C0835h.f4046a
            r5.<init>(r6, r8)
            java.lang.String r6 = r14.f5532f
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "<font color=\""
            r7.<init>(r8)
            android.content.Context r8 = com.momagic.C0835h.f4046a
            int r9 = defpackage.C1288nr.iz_black
            java.lang.Object r10 = defpackage.d7.a
            int r8 = defpackage.d7.b.a(r8, r9)
            r7.append(r8)
            java.lang.String r8 = "\"><b>"
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = "</b></font>"
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            android.text.Spanned r6 = android.text.Html.fromHtml(r6, r12)
            r5.f(r6)
            int r6 = com.momagic.x.a()
            android.app.Notification r7 = r5.f1735a
            r7.icon = r6
            int r6 = com.momagic.x.a
            r5.c = r6
            boolean r6 = com.momagic.H.e(r14)
            r7 = 2
            r5.j(r7, r6)
            Xm r6 = new Xm
            r6.<init>()
            java.lang.String r7 = r14.f5532f
            android.text.Spanned r7 = com.momagic.H.t(r7)
            if (r7 == 0) goto L_0x0382
            java.util.ArrayList<java.lang.CharSequence> r8 = r6.a
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.c(r7)
            r8.add(r7)
        L_0x0382:
            java.lang.String r7 = r14.t
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.c(r7)
            r6.f713a = r7
            r5.m(r6)
            java.lang.String r6 = r14.s
            r5.f1742a = r6
            r5.f1749b = r13
            long r6 = com.momagic.H.n(r14)
            r5.f1733a = r6
            android.app.Notification r5 = r5.b()
            goto L_0x03ee
        L_0x039e:
            java.lang.String r5 = r14.s
            r15.f1742a = r5
            androidx.core.app.NotificationCompat$Builder r5 = new androidx.core.app.NotificationCompat$Builder
            android.content.Context r6 = com.momagic.C0835h.f4046a
            r5.<init>(r6, r8)
            java.lang.String r6 = r14.f5532f
            r5.g(r6)
            java.lang.String r6 = r14.f5534h
            r5.f(r6)
            int r6 = com.momagic.x.a()
            android.app.Notification r7 = r5.f1735a
            r7.icon = r6
            int r6 = com.momagic.x.a
            r5.c = r6
            Xm r6 = new Xm
            r6.<init>()
            java.lang.String r7 = r14.f5534h
            if (r7 == 0) goto L_0x03d1
            java.util.ArrayList<java.lang.CharSequence> r8 = r6.a
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.c(r7)
            r8.add(r7)
        L_0x03d1:
            java.lang.String r7 = r14.t
            java.lang.CharSequence r7 = androidx.core.app.NotificationCompat$Builder.c(r7)
            r6.f713a = r7
            r5.m(r6)
            java.lang.String r6 = r14.s
            r5.f1742a = r6
            r5.f1749b = r13
            long r6 = com.momagic.H.n(r14)
            r5.f1733a = r6
            android.app.Notification r5 = r5.b()
            goto L_0x03ee
        L_0x03ed:
            r5 = 0
        L_0x03ee:
            r10 = r5
            java.lang.String r5 = r14.f5533g
            java.lang.String r6 = "null"
            boolean r5 = r5.contains(r6)
            if (r5 != 0) goto L_0x040b
            java.lang.String r5 = r14.f5533g
            if (r5 == 0) goto L_0x040b
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x040b
            java.lang.String r5 = r14.f5533g
            java.lang.CharSequence r5 = androidx.core.app.NotificationCompat$Builder.c(r5)
            r15.f1750c = r5
        L_0x040b:
            java.lang.String r5 = r14.f5536j
            if (r5 == 0) goto L_0x0419
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0419
            int r5 = com.momagic.x.a
            r15.c = r5
        L_0x0419:
            java.lang.String r5 = r14.f5537k
            if (r5 == 0) goto L_0x042a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x042a
            java.lang.String r5 = r14.f5537k
            int r5 = com.momagic.H.b(r5)
            goto L_0x042f
        L_0x042a:
            long r5 = java.lang.System.currentTimeMillis()
            int r5 = (int) r5
        L_0x042f:
            r9 = r5
            java.lang.String r5 = r14.m
            java.lang.String r7 = "~"
            if (r5 == 0) goto L_0x04ab
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x04ab
            java.lang.String r5 = r14.n
            java.lang.String r18 = com.momagic.x.g(r5)
            java.lang.String r6 = r14.n
            java.lang.String r5 = r14.f5531e
            java.lang.String r8 = r14.p
            java.lang.String r20 = com.momagic.x.f4065a
            r21 = 1
            r22 = r5
            r5 = r14
            r25 = r7
            r7 = r22
            r19 = r9
            r9 = r18
            r26 = r10
            r10 = r16
            r27 = r11
            r11 = r20
            r18 = r4
            r4 = r12
            r12 = r19
            r4 = 31
            r13 = r21
            android.content.Intent r5 = com.momagic.x.n(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r0 < r4) goto L_0x0485
            android.content.Context r6 = com.momagic.C0835h.f4046a
            java.lang.String r6 = com.momagic.H.m(r6)
            r5.setPackage(r6)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            r13 = 201326592(0xc000000, float:9.8607613E-32)
            android.app.PendingIntent r5 = android.app.PendingIntent.getActivity(r6, r7, r5, r13)
            goto L_0x0492
        L_0x0485:
            r13 = 201326592(0xc000000, float:9.8607613E-32)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            android.app.PendingIntent r5 = android.app.PendingIntent.getBroadcast(r6, r7, r5, r13)
        L_0x0492:
            androidx.core.app.a$a r6 = new androidx.core.app.a$a
            int r7 = defpackage.C1485xr.transparent_image
            java.lang.String r8 = r14.m
            r11 = r25
            r12 = r27
            java.lang.String r8 = r8.replace(r11, r12)
            r6.<init>(r7, r8, r5)
            androidx.core.app.a r5 = r6.a()
            r15.a(r5)
            goto L_0x04b7
        L_0x04ab:
            r18 = r4
            r19 = r9
            r26 = r10
            r12 = r11
            r4 = 31
            r13 = 201326592(0xc000000, float:9.8607613E-32)
            r11 = r7
        L_0x04b7:
            java.lang.String r5 = r14.o
            if (r5 == 0) goto L_0x0521
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0521
            java.lang.String r5 = r14.p
            java.lang.String r9 = com.momagic.x.g(r5)
            java.lang.String r6 = r14.p
            java.lang.String r7 = r14.f5531e
            java.lang.String r8 = r14.n
            java.lang.String r21 = com.momagic.x.f4065a
            r22 = 2
            r5 = r14
            r10 = r16
            r28 = r11
            r11 = r21
            r29 = r12
            r12 = r19
            r13 = r22
            android.content.Intent r5 = com.momagic.x.n(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r0 < r4) goto L_0x04fb
            android.content.Context r6 = com.momagic.C0835h.f4046a
            java.lang.String r6 = com.momagic.H.m(r6)
            r5.setPackage(r6)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r7 = java.lang.System.currentTimeMillis()
            int r7 = (int) r7
            r8 = 201326592(0xc000000, float:9.8607613E-32)
            android.app.PendingIntent r5 = android.app.PendingIntent.getActivity(r6, r7, r5, r8)
            goto L_0x0508
        L_0x04fb:
            r8 = 201326592(0xc000000, float:9.8607613E-32)
            android.content.Context r6 = com.momagic.C0835h.f4046a
            long r9 = java.lang.System.currentTimeMillis()
            int r7 = (int) r9
            android.app.PendingIntent r5 = android.app.PendingIntent.getBroadcast(r6, r7, r5, r8)
        L_0x0508:
            androidx.core.app.a$a r6 = new androidx.core.app.a$a
            int r7 = defpackage.C1485xr.transparent_image
            java.lang.String r9 = r14.o
            r11 = r28
            r10 = r29
            java.lang.String r9 = r9.replace(r11, r10)
            r6.<init>(r7, r9, r5)
            androidx.core.app.a r5 = r6.a()
            r15.a(r5)
            goto L_0x0522
        L_0x0521:
            r8 = r13
        L_0x0522:
            android.content.Context r5 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x057f }
            gq r5 = defpackage.C1139gq.c(r5)     // Catch:{ Exception -> 0x057f }
            java.lang.String r6 = r14.M     // Catch:{ Exception -> 0x057f }
            if (r6 == 0) goto L_0x057c
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x057f }
            if (r6 != 0) goto L_0x057c
            java.lang.String r6 = r14.M     // Catch:{ Exception -> 0x057f }
            boolean r6 = r6.equals(r1)     // Catch:{ Exception -> 0x057f }
            if (r6 == 0) goto L_0x057c
            java.lang.String r6 = "type"
            java.lang.String r7 = "p"
            r5.h(r6, r7)     // Catch:{ Exception -> 0x057f }
            r5 = r19
            android.content.Intent r6 = defpackage.C1137gn.k(r14, r5)     // Catch:{ Exception -> 0x057a }
            if (r0 < r4) goto L_0x0559
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x057a }
            java.lang.String r0 = com.momagic.H.m(r0)     // Catch:{ Exception -> 0x057a }
            r6.setPackage(r0)     // Catch:{ Exception -> 0x057a }
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x057a }
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r0, r5, r6, r8)     // Catch:{ Exception -> 0x057a }
            goto L_0x055f
        L_0x0559:
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x057a }
            android.app.PendingIntent r0 = android.app.PendingIntent.getBroadcast(r0, r5, r6, r8)     // Catch:{ Exception -> 0x057a }
        L_0x055f:
            androidx.core.app.a$a r4 = new androidx.core.app.a$a     // Catch:{ Exception -> 0x057a }
            int r6 = defpackage.C1485xr.transparent_image     // Catch:{ Exception -> 0x057a }
            android.content.Context r7 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x057a }
            android.content.res.Resources r7 = r7.getResources()     // Catch:{ Exception -> 0x057a }
            int r8 = defpackage.C0772Zr.iz_cta_dismissed     // Catch:{ Exception -> 0x057a }
            java.lang.String r7 = r7.getString(r8)     // Catch:{ Exception -> 0x057a }
            r4.<init>(r6, r7, r0)     // Catch:{ Exception -> 0x057a }
            androidx.core.app.a r0 = r4.a()     // Catch:{ Exception -> 0x057a }
            r15.a(r0)     // Catch:{ Exception -> 0x057a }
            goto L_0x058b
        L_0x057a:
            r0 = move-exception
            goto L_0x0582
        L_0x057c:
            r5 = r19
            goto L_0x058b
        L_0x057f:
            r0 = move-exception
            r5 = r19
        L_0x0582:
            android.content.Context r4 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            com.momagic.H.r(r4, r0, r3, r2)
        L_0x058b:
            int r0 = r14.a
            r4 = 1
            if (r0 != r4) goto L_0x0599
            r4 = r23
            r6 = r26
            r7 = 0
            r4.notify(r7, r6)
            goto L_0x059b
        L_0x0599:
            r4 = r23
        L_0x059b:
            android.app.Notification r0 = r15.b()
            r4.notify(r5, r0)
            java.lang.String r0 = com.momagic.x.f4065a     // Catch:{ Exception -> 0x05c9 }
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x05c9 }
            if (r0 != 0) goto L_0x05b3
            r6 = r18
            boolean r0 = r6.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x05c9 }
            if (r0 == 0) goto L_0x05bc
            goto L_0x05b5
        L_0x05b3:
            r6 = r18
        L_0x05b5:
            java.lang.String r0 = com.momagic.x.f4065a     // Catch:{ Exception -> 0x05c9 }
            r1 = r24
            com.momagic.x.m(r14, r0, r6, r1)     // Catch:{ Exception -> 0x05c9 }
        L_0x05bc:
            com.momagic.C0835h.i(r14)     // Catch:{ Exception -> 0x05c9 }
            int r0 = r14.i     // Catch:{ Exception -> 0x05c9 }
            if (r0 == 0) goto L_0x05d3
            android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x05c9 }
            com.momagic.x.e(r1, r0)     // Catch:{ Exception -> 0x05c9 }
            goto L_0x05d3
        L_0x05c9:
            r0 = move-exception
            android.content.Context r1 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            com.momagic.H.r(r1, r0, r3, r2)
        L_0x05d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0826cn.run():void");
    }
}
