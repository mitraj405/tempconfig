package com.momagic;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.momagic.B;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class NotificationActionReceiver extends BroadcastReceiver {
    public static String o;
    public static String p;
    public static String q;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public String f4018a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public String f4019b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4020c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k = "0";
    public String l = "0";
    public String m;
    public final String n = "15";

    public class a extends B.b {
        public final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Context f4021a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1139gq f4022a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ String f4023a;
        public final /* synthetic */ int b;

        /* renamed from: b  reason: collision with other field name */
        public final /* synthetic */ String f4024b;
        public final /* synthetic */ String c;

        public a(int i, int i2, Context context, C1139gq gqVar, String str, String str2, String str3) {
            this.f4022a = gqVar;
            this.a = i;
            this.f4023a = str;
            this.f4021a = context;
            this.f4024b = str2;
            this.c = str3;
            this.b = i2;
        }

        public final void a(int i, String str) {
            C1139gq gqVar = this.f4022a;
            try {
                if (gqVar.e("iZ_Notification_Click_Offline").isEmpty()) {
                    H.z(this.f4021a, this.f4024b, "iZ_Notification_Click_Offline", this.f4023a, this.c, this.b);
                } else if (!H.v(new JSONArray(gqVar.e("iZ_Notification_Click_Offline")), this.f4023a)) {
                    H.z(this.f4021a, this.f4024b, "iZ_Notification_Click_Offline", this.f4023a, this.c, this.b);
                }
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationActionReceiver", "notificationClickAPI->onFailure");
            }
        }

        public final void b(String str) {
            int i;
            C1139gq gqVar = this.f4022a;
            try {
                if (!gqVar.e("iZ_Notification_Click_Offline").isEmpty() && (i = this.a) >= 0) {
                    new JSONArray(gqVar.e("iZ_Notification_Click_Offline")).remove(i);
                    gqVar.h("iZ_Notification_Click_Offline", (String) null);
                }
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationActionReceiver", "notificationClickAPI");
            }
        }
    }

    public class b extends B.b {
        public final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Context f4025a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1139gq f4026a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ String f4027a;
        public final /* synthetic */ int b;

        /* renamed from: b  reason: collision with other field name */
        public final /* synthetic */ String f4028b;
        public final /* synthetic */ String c;

        public b(int i, int i2, Context context, C1139gq gqVar, String str, String str2, String str3) {
            this.f4026a = gqVar;
            this.f4027a = str;
            this.f4025a = context;
            this.f4028b = str2;
            this.c = str3;
            this.a = i;
            this.b = i2;
        }

        public final void a(int i, String str) {
            C1139gq gqVar = this.f4026a;
            try {
                if (gqVar.e("iZ_Notification_Click_Offline").isEmpty()) {
                    H.z(this.f4025a, this.f4028b, "iZ_Notification_Click_Offline", this.f4027a, this.c, this.a);
                } else if (!H.v(new JSONArray(gqVar.e("iZ_Notification_Click_Offline")), this.f4027a)) {
                    H.z(this.f4025a, this.f4028b, "iZ_Notification_Click_Offline", this.f4027a, this.c, this.a);
                }
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationActionReceiver", "notificationClickAPI");
            }
        }

        public final void b(String str) {
            int i;
            C1139gq gqVar = this.f4026a;
            try {
                if (!gqVar.e("iZ_Notification_Click_Offline").isEmpty() && (i = this.b) >= 0) {
                    JSONArray jSONArray = new JSONArray(gqVar.e("iZ_Notification_Click_Offline"));
                    jSONArray.remove(i);
                    gqVar.h("iZ_Notification_Click_Offline", jSONArray.toString());
                }
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationActionReceiver", "notificationClickAPI");
            }
        }
    }

    public static void a(int i2, String str) {
        try {
            if (!str.isEmpty()) {
                C1104f8.b(C0835h.f4046a, str, "mediationClick");
                B.c("https://med.dtblt.com/medc", (HashMap) null, new JSONObject(str), new q(i2, str));
            }
        } catch (Exception e2) {
            H.r(C0835h.f4046a, e2.toString(), "NotificationActionReceiver", "callMediationClicks");
        }
    }

    public static void c(int i2, Context context, String str, String str2) {
        if (context != null) {
            try {
                C1139gq c2 = C1139gq.c(context);
                c2.h("currentDateClick", H.p());
                HashMap hashMap = new HashMap();
                hashMap.put("last_notification_clicked", Boolean.TRUE);
                JSONObject jSONObject = new JSONObject(hashMap);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("pid", c2.b());
                hashMap2.put("ver", "2.4.0");
                hashMap2.put("bKey", "" + H.g(context));
                hashMap2.put("val", "" + jSONObject.toString());
                hashMap2.put("act", "add");
                hashMap2.put("isid", C0515Ga.AVLBLTY_ONLY);
                hashMap2.put("et", "userp");
                B.c(str, hashMap2, (JSONObject) null, new p(i2, context, c2, str2, str));
            } catch (Exception e2) {
                H.r(context, e2.toString(), "NotificationActionReceiver", "lastClickAPI");
            }
        }
    }

    public static void d(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                if (!H.s(context)) {
                    String str = (String) packageManager.getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0));
                    Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName());
                    launchIntentForPackage.setFlags(268468224);
                    context.startActivity(launchIntentForPackage);
                    return;
                }
            } catch (Exception e2) {
                H.r(context, e2.toString(), "NotificationActionReceiver", "launch App");
                return;
            }
        }
        String str2 = (String) packageManager.getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0));
        Intent launchIntentForPackage2 = packageManager.getLaunchIntentForPackage(context.getPackageName());
        launchIntentForPackage2.setFlags(268468224);
        context.startActivity(launchIntentForPackage2);
    }

    public static void e(Context context, String str, String str2, String str3, int i2, int i3, String str4) {
        Context context2 = context;
        int i4 = i2;
        if (context2 != null) {
            try {
                C1139gq c2 = C1139gq.c(context);
                HashMap hashMap = new HashMap();
                hashMap.put("pid", c2.b());
                hashMap.put("ver", "2.4.0");
                hashMap.put("cid", str2);
                hashMap.put("bKey", "" + H.g(context));
                hashMap.put("rid", "" + str3);
                hashMap.put("push_type", str4);
                hashMap.put("op", "click");
                hashMap.put("ln", p);
                hashMap.put("ap", o);
                hashMap.put("ti", q);
                if (i4 != 0) {
                    hashMap.put("btn", "" + i4);
                }
                C1104f8.b(C0835h.f4046a, hashMap.toString(), "clickData");
                B.c(str, hashMap, (JSONObject) null, new a(i3, i2, context, c2, str3, str, str2));
                b bVar = r1;
                b bVar2 = new b(i2, i3, context, c2, str3, str, str2);
                B.c("https://irctc.truenotify.in/momagicflow/appclk", hashMap, (JSONObject) null, bVar);
            } catch (Exception e2) {
                H.r(context2, e2.toString(), "NotificationActionReceiver", "notificationClickAPI");
            }
        }
    }

    public final void b(Context context, Intent intent) {
        Context context2;
        String str = "keyNotificationId";
        String str2 = "ti";
        String str3 = "cfgfordomain";
        String str4 = "push_type";
        String str5 = "lastclickIndex";
        String str6 = "clickIndex";
        if (context != null) {
            try {
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    if (extras.containsKey("WEB_URL")) {
                        this.f4018a = extras.getString("WEB_URL");
                    }
                    if (extras.containsKey("keyInApp")) {
                        this.a = extras.getInt("keyInApp");
                    }
                    if (extras.containsKey("rid")) {
                        this.f4019b = extras.getString("rid");
                    }
                    if (extras.containsKey("cid")) {
                        this.f4020c = extras.getString("cid");
                    }
                    if (extras.containsKey("btn")) {
                        this.b = extras.getInt("btn");
                    }
                    if (extras.containsKey("ap")) {
                        o = extras.getString("ap");
                    }
                    if (extras.containsKey("call")) {
                        this.d = extras.getString("call");
                    }
                    if (extras.containsKey("act1ID")) {
                        this.e = extras.getString("act1ID");
                    }
                    if (extras.containsKey("act2ID")) {
                        this.f = extras.getString("act2ID");
                    }
                    if (extras.containsKey("landingURL")) {
                        p = extras.getString("landingURL");
                    }
                    if (extras.containsKey("act1URL")) {
                        this.h = extras.getString("act1URL");
                    }
                    if (extras.containsKey("act2URL")) {
                        this.g = extras.getString("act2URL");
                    }
                    if (extras.containsKey("act1title")) {
                        this.i = extras.getString("act1title");
                    }
                    if (extras.containsKey("act2title")) {
                        this.j = extras.getString("act2title");
                    }
                    String str7 = str6;
                    if (extras.containsKey(str7)) {
                        this.k = extras.getString(str7);
                    }
                    String str8 = str5;
                    if (extras.containsKey(str8)) {
                        this.l = extras.getString(str8);
                    }
                    String str9 = str4;
                    if (extras.containsKey(str9)) {
                        this.m = extras.getString(str9);
                    }
                    String str10 = str3;
                    if (extras.containsKey(str10)) {
                        this.c = extras.getInt(str10);
                    }
                    String str11 = str2;
                    if (extras.containsKey(str11)) {
                        q = extras.getString(str11);
                    }
                    String str12 = str;
                    if (extras.containsKey(str12)) {
                        Bundle bundle = extras;
                        context2 = context;
                        try {
                            ((NotificationManager) context2.getSystemService("notification")).cancel(bundle.getInt(str12));
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                context2 = context;
                H.r(context2, e.toString(), "NotificationActionReceiver", "getBundleData");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:113:0x01c8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00e1 A[Catch:{ Exception -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f8 A[Catch:{ Exception -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0103 A[Catch:{ Exception -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013a A[Catch:{ Exception -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x024f  */
    @android.annotation.SuppressLint({"MissingPermission"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onReceive(android.content.Context r21, android.content.Intent r22) {
        /*
            r20 = this;
            r1 = r20
            r9 = r21
            java.lang.String r0 = "currentDateClickDaily"
            java.lang.String r10 = "https://"
            java.lang.String r11 = "onReceive"
            java.lang.String r12 = "NotificationActionReceiver"
            java.lang.String r13 = "currentDateClick"
            java.lang.String r14 = "currentDateClickWeekly"
            java.lang.String r15 = "1"
            java.lang.String r8 = "https://lci"
            java.lang.String r2 = "https://clk"
            if (r9 == 0) goto L_0x0306
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = r1.n
            r3.<init>(r4)
            r9.sendBroadcast(r3)
            r20.b(r21, r22)
            java.lang.String r3 = r1.f4018a
            gq r4 = defpackage.C1139gq.c(r21)
            java.lang.String r5 = "deviceToken"
            java.lang.String r4 = r4.e(r5)
            java.lang.String r5 = "{BROWSERKEYID}"
            r3.replace(r5, r4)
            r20.b(r21, r22)
            gq r7 = defpackage.C1139gq.c(r21)     // Catch:{ Exception -> 0x017b }
            java.lang.String r3 = r1.k     // Catch:{ Exception -> 0x017b }
            boolean r3 = r3.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x017b }
            if (r3 == 0) goto L_0x0170
            int r3 = r1.c     // Catch:{ Exception -> 0x017b }
            int r6 = com.momagic.H.i(r3)     // Catch:{ Exception -> 0x017b }
            if (r6 <= 0) goto L_0x0062
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017b }
            r3.<init>(r2)     // Catch:{ Exception -> 0x017b }
            r3.append(r6)     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = ".izooto.com/clk"
            r3.append(r2)     // Catch:{ Exception -> 0x017b }
            r3.append(r6)     // Catch:{ Exception -> 0x017b }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x017b }
            goto L_0x0064
        L_0x0062:
            java.lang.String r2 = "https://clk.izooto.com/clk"
        L_0x0064:
            r3 = r2
            java.lang.String r4 = r1.f4020c     // Catch:{ Exception -> 0x017b }
            java.lang.String r5 = r1.f4019b     // Catch:{ Exception -> 0x017b }
            int r2 = r1.b     // Catch:{ Exception -> 0x017b }
            r16 = -1
            r22 = r7
            java.lang.String r7 = r1.m     // Catch:{ Exception -> 0x017b }
            r17 = r2
            r2 = r21
            r18 = r10
            r10 = r6
            r6 = r17
            r19 = r7
            r17 = r11
            r11 = r22
            r7 = r16
            r16 = r12
            r12 = r8
            r8 = r19
            e(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x016e }
            int r2 = r1.c     // Catch:{ Exception -> 0x016e }
            java.lang.String r2 = com.momagic.H.l(r2)     // Catch:{ Exception -> 0x016e }
            java.lang.String r3 = "0"
            if (r2 == 0) goto L_0x00b7
            boolean r4 = r2.isEmpty()     // Catch:{ Exception -> 0x016e }
            if (r4 != 0) goto L_0x00b7
            int r4 = r2.length()     // Catch:{ Exception -> 0x016e }
            int r4 = r4 + -8
            char r4 = r2.charAt(r4)     // Catch:{ Exception -> 0x016e }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x016e }
            int r5 = r2.length()     // Catch:{ Exception -> 0x016e }
            int r5 = r5 + -10
            char r2 = r2.charAt(r5)     // Catch:{ Exception -> 0x016e }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x016e }
            goto L_0x00b9
        L_0x00b7:
            r2 = r3
            r4 = r2
        L_0x00b9:
            java.lang.String r5 = r1.l     // Catch:{ Exception -> 0x016e }
            boolean r5 = r5.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x016e }
            if (r5 != 0) goto L_0x00c7
            boolean r5 = r4.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x016e }
            if (r5 == 0) goto L_0x0176
        L_0x00c7:
            java.lang.String r5 = com.momagic.H.p()     // Catch:{ Exception -> 0x016e }
            java.lang.String r6 = r11.e(r14)     // Catch:{ Exception -> 0x016e }
            java.lang.String r5 = com.momagic.H.c(r5, r6)     // Catch:{ Exception -> 0x016e }
            java.lang.String r6 = r11.e(r14)     // Catch:{ Exception -> 0x016e }
            java.lang.String r7 = r11.e(r0)     // Catch:{ Exception -> 0x016e }
            java.lang.String r8 = r11.e(r13)     // Catch:{ Exception -> 0x016e }
            if (r10 <= 0) goto L_0x00f8
            r22 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016e }
            r8.<init>(r12)     // Catch:{ Exception -> 0x016e }
            r8.append(r10)     // Catch:{ Exception -> 0x016e }
            java.lang.String r12 = ".izooto.com/lci"
            r8.append(r12)     // Catch:{ Exception -> 0x016e }
            r8.append(r10)     // Catch:{ Exception -> 0x016e }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x016e }
            goto L_0x00fc
        L_0x00f8:
            r22 = r8
            java.lang.String r8 = "https://lci.izooto.com/lci"
        L_0x00fc:
            boolean r10 = r4.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x016e }
            r12 = -1
            if (r10 == 0) goto L_0x013a
            boolean r2 = r2.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x016e }
            if (r2 == 0) goto L_0x0120
            java.lang.String r2 = com.momagic.H.p()     // Catch:{ Exception -> 0x016e }
            boolean r2 = r7.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x016e }
            if (r2 != 0) goto L_0x0176
            java.lang.String r2 = com.momagic.H.p()     // Catch:{ Exception -> 0x016e }
            r11.h(r0, r2)     // Catch:{ Exception -> 0x016e }
            java.lang.String r0 = r1.f4019b     // Catch:{ Exception -> 0x016e }
            c(r12, r9, r8, r0)     // Catch:{ Exception -> 0x016e }
            goto L_0x0176
        L_0x0120:
            boolean r0 = r6.isEmpty()     // Catch:{ Exception -> 0x016e }
            if (r0 != 0) goto L_0x012d
            int r0 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x016e }
            r2 = 7
            if (r0 < r2) goto L_0x0176
        L_0x012d:
            java.lang.String r0 = com.momagic.H.p()     // Catch:{ Exception -> 0x016e }
            r11.h(r14, r0)     // Catch:{ Exception -> 0x016e }
            java.lang.String r0 = r1.f4019b     // Catch:{ Exception -> 0x016e }
            c(r12, r9, r8, r0)     // Catch:{ Exception -> 0x016e }
            goto L_0x0176
        L_0x013a:
            java.lang.String r0 = r1.l     // Catch:{ Exception -> 0x016e }
            boolean r0 = r0.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0176
            boolean r0 = r4.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x016e }
            if (r0 == 0) goto L_0x0176
            java.lang.String r0 = com.momagic.H.p()     // Catch:{ Exception -> 0x016e }
            java.lang.String r2 = r11.e(r13)     // Catch:{ Exception -> 0x016e }
            java.lang.String r0 = com.momagic.H.c(r0, r2)     // Catch:{ Exception -> 0x016e }
            boolean r2 = r22.isEmpty()     // Catch:{ Exception -> 0x016e }
            if (r2 != 0) goto L_0x0161
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x016e }
            r2 = 7
            if (r0 < r2) goto L_0x0176
        L_0x0161:
            java.lang.String r0 = com.momagic.H.p()     // Catch:{ Exception -> 0x016e }
            r11.h(r13, r0)     // Catch:{ Exception -> 0x016e }
            java.lang.String r0 = r1.f4019b     // Catch:{ Exception -> 0x016e }
            c(r12, r9, r8, r0)     // Catch:{ Exception -> 0x016e }
            goto L_0x0176
        L_0x016e:
            r0 = move-exception
            goto L_0x0182
        L_0x0170:
            r18 = r10
            r17 = r11
            r16 = r12
        L_0x0176:
            r4 = r16
            r3 = r17
            goto L_0x018f
        L_0x017b:
            r0 = move-exception
            r18 = r10
            r17 = r11
            r16 = r12
        L_0x0182:
            android.content.Context r2 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            r4 = r16
            r3 = r17
            com.momagic.H.r(r2, r0, r4, r3)
        L_0x018f:
            gq r0 = defpackage.C1139gq.c(r21)
            java.lang.String r2 = "Mediation"
            boolean r2 = r0.a(r2)
            r5 = 0
            if (r2 == 0) goto L_0x01cb
            java.util.ArrayList r2 = com.momagic.C0828a.e
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x01cb
            r2 = r5
        L_0x01a5:
            java.util.ArrayList r6 = com.momagic.C0828a.e
            int r7 = r6.size()
            if (r2 >= r7) goto L_0x01cb
            int r7 = r6.size()
            if (r2 != r7) goto L_0x01b4
            goto L_0x01cb
        L_0x01b4:
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x01c8
            com.momagic.r r7 = new com.momagic.r
            r7.<init>()
            com.momagic.B.a(r7, r6)
        L_0x01c8:
            int r2 = r2 + 1
            goto L_0x01a5
        L_0x01cb:
            java.lang.String r2 = "MEDIATIONCLICKDATA"
            java.lang.String r6 = r0.e(r2)
            java.lang.String r7 = ""
            if (r6 == r7) goto L_0x01dc
            java.lang.String r0 = r0.e(r2)
            a(r5, r0)
        L_0x01dc:
            java.lang.String r0 = o
            boolean r0 = r0.equalsIgnoreCase(r7)
            if (r0 == 0) goto L_0x01ee
            java.lang.String r0 = o
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01ee
            o = r15
        L_0x01ee:
            java.lang.String r0 = o
            boolean r0 = r0.equalsIgnoreCase(r15)
            if (r0 != 0) goto L_0x024f
            int r0 = r1.a
            if (r0 < 0) goto L_0x024f
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = "button1ID"
            java.lang.String r3 = r1.e
            r0.put(r2, r3)
            java.lang.String r2 = "button1Title"
            java.lang.String r3 = r1.i
            r0.put(r2, r3)
            java.lang.String r2 = "button1URL"
            java.lang.String r3 = r1.h
            r0.put(r2, r3)
            java.lang.String r2 = "additionalData"
            java.lang.String r3 = o
            r0.put(r2, r3)
            java.lang.String r2 = "landingURL"
            java.lang.String r3 = p
            r0.put(r2, r3)
            java.lang.String r2 = "button2ID"
            java.lang.String r3 = r1.f
            r0.put(r2, r3)
            java.lang.String r2 = "button2Title"
            java.lang.String r3 = r1.j
            r0.put(r2, r3)
            java.lang.String r2 = "button2URL"
            java.lang.String r3 = r1.g
            r0.put(r2, r3)
            int r2 = r1.b
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "actionType"
            r0.put(r3, r2)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r0)
            r2.toString()
            com.momagic.C0835h.h()
            goto L_0x0306
        L_0x024f:
            int r0 = r1.a
            r2 = 1
            java.lang.String r5 = "NO"
            if (r0 != r2) goto L_0x0284
            java.lang.String r0 = r1.d
            boolean r0 = r0.equalsIgnoreCase(r5)
            if (r0 == 0) goto L_0x0284
            java.lang.String r0 = p
            if (r0 == r7) goto L_0x0284
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0284
            android.content.Context r0 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r1.f4018a
            int r2 = com.momagic.DATBWebViewActivity.c
            android.content.Intent r2 = new android.content.Intent
            java.lang.Class<com.momagic.DATBWebViewActivity> r3 = com.momagic.DATBWebViewActivity.class
            r2.<init>(r9, r3)
            java.lang.String r3 = "WEB_URL"
            r2.putExtra(r3, r0)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r0)
            r9.startActivity(r2)
            goto L_0x0306
        L_0x0284:
            java.lang.String r0 = r1.d     // Catch:{ Exception -> 0x02fc }
            boolean r0 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x02fc }
            r2 = 268468224(0x10008000, float:2.5342157E-29)
            if (r0 == 0) goto L_0x02e8
            java.lang.String r0 = r1.f4018a     // Catch:{ Exception -> 0x02fc }
            if (r0 == 0) goto L_0x02e2
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x02fc }
            if (r0 != 0) goto L_0x02e2
            java.lang.String r0 = r1.f4018a     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "http://"
            boolean r0 = r0.startsWith(r5)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "android.intent.action.VIEW"
            if (r0 != 0) goto L_0x02d0
            java.lang.String r0 = r1.f4018a     // Catch:{ Exception -> 0x02fc }
            r6 = r18
            boolean r0 = r0.startsWith(r6)     // Catch:{ Exception -> 0x02fc }
            if (r0 != 0) goto L_0x02d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02fc }
            r0.<init>()     // Catch:{ Exception -> 0x02fc }
            r0.append(r6)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = r1.f4018a     // Catch:{ Exception -> 0x02fc }
            r0.append(r6)     // Catch:{ Exception -> 0x02fc }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02fc }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x02fc }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x02fc }
            r6.<init>(r5, r0)     // Catch:{ Exception -> 0x02fc }
            r6.setFlags(r2)     // Catch:{ Exception -> 0x02fc }
            r9.startActivity(r6)     // Catch:{ Exception -> 0x02fc }
            goto L_0x0306
        L_0x02d0:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x02fc }
            java.lang.String r6 = r1.f4018a     // Catch:{ Exception -> 0x02fc }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x02fc }
            r0.<init>(r5, r6)     // Catch:{ Exception -> 0x02fc }
            r0.setFlags(r2)     // Catch:{ Exception -> 0x02fc }
            r9.startActivity(r0)     // Catch:{ Exception -> 0x02fc }
            goto L_0x0306
        L_0x02e2:
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x02fc }
            d(r0)     // Catch:{ Exception -> 0x02fc }
            goto L_0x0306
        L_0x02e8:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x02fc }
            java.lang.String r5 = "android.intent.action.DIAL"
            java.lang.String r6 = r1.d     // Catch:{ Exception -> 0x02fc }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ Exception -> 0x02fc }
            r0.<init>(r5, r6)     // Catch:{ Exception -> 0x02fc }
            r0.setFlags(r2)     // Catch:{ Exception -> 0x02fc }
            r9.startActivity(r0)     // Catch:{ Exception -> 0x02fc }
            goto L_0x0306
        L_0x02fc:
            r0 = move-exception
            android.content.Context r2 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            com.momagic.H.r(r2, r0, r4, r3)
        L_0x0306:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.NotificationActionReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
