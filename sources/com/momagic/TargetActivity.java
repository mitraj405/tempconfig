package com.momagic;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import org.json.JSONObject;

public class TargetActivity extends AppCompatActivity {
    public static String p = null;
    public static String q = null;
    public static String r = "";
    public static String s;
    public TargetActivity a;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public String f4029c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public String f4030d;
    public int e;

    /* renamed from: e  reason: collision with other field name */
    public String f4031e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m = "0";
    public String n = "0";
    public String o;

    public static void m(Context context, String str, String str2) {
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
                B.c(str, hashMap2, (JSONObject) null, new E(context, c2, str2, str));
            } catch (Exception e2) {
                H.r(context, e2.toString(), "lastClickAPI", "NotificationActionReceiver");
            }
        }
    }

    public static void n(Context context) {
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
            } catch (PackageManager.NameNotFoundException e2) {
                H.r(context, e2.toString(), "NotificationActionReceiver", "launch App");
                return;
            }
        }
        String str2 = (String) packageManager.getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0));
        Intent launchIntentForPackage2 = packageManager.getLaunchIntentForPackage(context.getPackageName());
        launchIntentForPackage2.setFlags(268468224);
        context.startActivity(launchIntentForPackage2);
    }

    public static void o(Context context, String str, String str2, String str3, int i2, String str4) {
        Context context2 = context;
        int i3 = i2;
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
                hashMap.put("ln", q);
                hashMap.put("ap", p);
                hashMap.put("ti", s);
                if (i3 != 0) {
                    hashMap.put("btn", "" + i3);
                }
                C1104f8.b(C0835h.f4046a, hashMap.toString(), "clickData");
                B.c(str, hashMap, (JSONObject) null, new C(i2, context, c2, str3, str, str2));
                B.c("https://irctc.truenotify.in/momagicflow/appclk", hashMap, (JSONObject) null, new D(i2, context, c2, str3, str, str2));
            } catch (Exception e2) {
                H.r(context2, e2.toString(), "notificationClickAPI", "NotificationActionReceiver");
            }
        }
    }

    public final void l(Context context, Intent intent) {
        String str = "keyNotificationId";
        String str2 = "ti";
        String str3 = "cfgfordomain";
        String str4 = "push_type";
        String str5 = "lastclickIndex";
        String str6 = "clickIndex";
        Bundle extras = intent.getExtras();
        if (extras != null) {
            try {
                if (extras.containsKey("WEB_URL")) {
                    this.f4029c = extras.getString("WEB_URL");
                }
                if (extras.containsKey("keyInApp")) {
                    this.c = extras.getInt("keyInApp");
                }
                if (extras.containsKey("rid")) {
                    this.f4030d = extras.getString("rid");
                }
                if (extras.containsKey("cid")) {
                    this.f4031e = extras.getString("cid");
                }
                if (extras.containsKey("btn")) {
                    this.d = extras.getInt("btn");
                }
                if (extras.containsKey("ap")) {
                    p = extras.getString("ap");
                }
                if (extras.containsKey("call")) {
                    this.f = extras.getString("call");
                }
                if (extras.containsKey("act1ID")) {
                    this.g = extras.getString("act1ID");
                }
                if (extras.containsKey("act2ID")) {
                    this.h = extras.getString("act2ID");
                }
                if (extras.containsKey("landingURL")) {
                    q = extras.getString("landingURL");
                }
                if (extras.containsKey("act1URL")) {
                    this.j = extras.getString("act1URL");
                }
                if (extras.containsKey("act2URL")) {
                    this.i = extras.getString("act2URL");
                }
                if (extras.containsKey("act1title")) {
                    this.k = extras.getString("act1title");
                }
                if (extras.containsKey("act2title")) {
                    this.l = extras.getString("act2title");
                }
                String str7 = str6;
                if (extras.containsKey(str7)) {
                    this.m = extras.getString(str7);
                }
                String str8 = str5;
                if (extras.containsKey(str8)) {
                    this.n = extras.getString(str8);
                }
                String str9 = str4;
                if (extras.containsKey(str9)) {
                    this.o = extras.getString(str9);
                }
                String str10 = str3;
                if (extras.containsKey(str10)) {
                    this.e = extras.getInt(str10);
                }
                String str11 = str2;
                if (extras.containsKey(str11)) {
                    s = extras.getString(str11);
                }
                String str12 = str;
                if (extras.containsKey(str12)) {
                    ((NotificationManager) context.getSystemService("notification")).cancel(extras.getInt(str12));
                }
            } catch (Exception e2) {
                H.r(C0835h.f4046a, e2.toString(), "TargetActivity", "getBundleData");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01b8 A[EDGE_INSN: B:107:0x01b8->B:63:0x01b8 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00f2 A[Catch:{ Exception -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fd A[Catch:{ Exception -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0137 A[Catch:{ Exception -> 0x016c }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01be A[SYNTHETIC, Splitter:B:65:0x01be] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0256  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r0 = "currentDateClickDaily"
            java.lang.String r2 = "https://"
            java.lang.String r3 = "currentDateClick"
            java.lang.String r4 = "currentDateClickWeekly"
            java.lang.String r5 = "TargetActivity"
            java.lang.String r6 = "1"
            java.lang.String r7 = "https://lci"
            java.lang.String r8 = "https://clk"
            super.onCreate(r19)
            r1.a = r1
            android.content.Intent r9 = r18.getIntent()
            r1.l(r1, r9)
            android.content.Intent r10 = new android.content.Intent
            java.lang.String r11 = "15"
            r10.<init>(r11)
            com.momagic.TargetActivity r11 = r1.a
            r11.sendBroadcast(r10)
            com.momagic.TargetActivity r10 = r1.a
            r1.l(r10, r9)
            java.lang.String r10 = r1.f4029c
            com.momagic.TargetActivity r11 = r1.a
            gq r11 = defpackage.C1139gq.c(r11)
            java.lang.String r12 = "deviceToken"
            java.lang.String r11 = r11.e(r12)
            java.lang.String r12 = "{BROWSERKEYID}"
            r10.replace(r12, r11)
            com.momagic.TargetActivity r10 = r1.a
            r1.l(r10, r9)
            com.momagic.TargetActivity r9 = r1.a     // Catch:{ Exception -> 0x0171 }
            gq r9 = defpackage.C1139gq.c(r9)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r10 = r1.m     // Catch:{ Exception -> 0x0171 }
            boolean r10 = r10.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0171 }
            if (r10 == 0) goto L_0x016e
            int r10 = r1.e     // Catch:{ Exception -> 0x0171 }
            int r10 = com.momagic.H.i(r10)     // Catch:{ Exception -> 0x0171 }
            if (r10 <= 0) goto L_0x0072
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0171 }
            r11.<init>(r8)     // Catch:{ Exception -> 0x0171 }
            r11.append(r10)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r8 = ".izooto.com/clk"
            r11.append(r8)     // Catch:{ Exception -> 0x0171 }
            r11.append(r10)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r8 = r11.toString()     // Catch:{ Exception -> 0x0171 }
            goto L_0x0074
        L_0x0072:
            java.lang.String r8 = "https://clk.izooto.com/clk"
        L_0x0074:
            r12 = r8
            com.momagic.TargetActivity r11 = r1.a     // Catch:{ Exception -> 0x0171 }
            java.lang.String r13 = r1.f4031e     // Catch:{ Exception -> 0x0171 }
            java.lang.String r14 = r1.f4030d     // Catch:{ Exception -> 0x0171 }
            int r15 = r1.d     // Catch:{ Exception -> 0x0171 }
            java.lang.String r8 = r1.o     // Catch:{ Exception -> 0x0171 }
            r16 = r8
            o(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0171 }
            int r8 = r1.e     // Catch:{ Exception -> 0x0171 }
            java.lang.String r8 = com.momagic.H.l(r8)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r11 = "0"
            if (r8 == 0) goto L_0x00b1
            boolean r12 = r8.isEmpty()     // Catch:{ Exception -> 0x0171 }
            if (r12 != 0) goto L_0x00b1
            int r12 = r8.length()     // Catch:{ Exception -> 0x0171 }
            int r12 = r12 + -8
            char r12 = r8.charAt(r12)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0171 }
            int r13 = r8.length()     // Catch:{ Exception -> 0x0171 }
            int r13 = r13 + -10
            char r8 = r8.charAt(r13)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ Exception -> 0x0171 }
            goto L_0x00b3
        L_0x00b1:
            r8 = r11
            r12 = r8
        L_0x00b3:
            java.lang.String r13 = r1.n     // Catch:{ Exception -> 0x0171 }
            boolean r13 = r13.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0171 }
            if (r13 != 0) goto L_0x00c1
            boolean r13 = r12.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x0171 }
            if (r13 == 0) goto L_0x016e
        L_0x00c1:
            java.lang.String r13 = com.momagic.H.p()     // Catch:{ Exception -> 0x0171 }
            java.lang.String r14 = r9.e(r4)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r13 = com.momagic.H.c(r13, r14)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r14 = r9.e(r4)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r15 = r9.e(r0)     // Catch:{ Exception -> 0x0171 }
            java.lang.String r16 = r9.e(r3)     // Catch:{ Exception -> 0x0171 }
            if (r10 <= 0) goto L_0x00f2
            r17 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x016c }
            r2.<init>(r7)     // Catch:{ Exception -> 0x016c }
            r2.append(r10)     // Catch:{ Exception -> 0x016c }
            java.lang.String r7 = ".izooto.com/lci"
            r2.append(r7)     // Catch:{ Exception -> 0x016c }
            r2.append(r10)     // Catch:{ Exception -> 0x016c }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x016c }
            goto L_0x00f6
        L_0x00f2:
            r17 = r2
            java.lang.String r2 = "https://lci.izooto.com/lci"
        L_0x00f6:
            boolean r7 = r12.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x016c }
            r10 = 7
            if (r7 == 0) goto L_0x0137
            boolean r3 = r8.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x016c }
            if (r3 == 0) goto L_0x011c
            java.lang.String r3 = com.momagic.H.p()     // Catch:{ Exception -> 0x016c }
            boolean r3 = r15.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x016c }
            if (r3 != 0) goto L_0x017f
            java.lang.String r3 = com.momagic.H.p()     // Catch:{ Exception -> 0x016c }
            r9.h(r0, r3)     // Catch:{ Exception -> 0x016c }
            com.momagic.TargetActivity r0 = r1.a     // Catch:{ Exception -> 0x016c }
            java.lang.String r3 = r1.f4030d     // Catch:{ Exception -> 0x016c }
            m(r0, r2, r3)     // Catch:{ Exception -> 0x016c }
            goto L_0x017f
        L_0x011c:
            boolean r0 = r14.isEmpty()     // Catch:{ Exception -> 0x016c }
            if (r0 != 0) goto L_0x0128
            int r0 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x016c }
            if (r0 < r10) goto L_0x017f
        L_0x0128:
            java.lang.String r0 = com.momagic.H.p()     // Catch:{ Exception -> 0x016c }
            r9.h(r4, r0)     // Catch:{ Exception -> 0x016c }
            com.momagic.TargetActivity r0 = r1.a     // Catch:{ Exception -> 0x016c }
            java.lang.String r3 = r1.f4030d     // Catch:{ Exception -> 0x016c }
            m(r0, r2, r3)     // Catch:{ Exception -> 0x016c }
            goto L_0x017f
        L_0x0137:
            java.lang.String r0 = r1.n     // Catch:{ Exception -> 0x016c }
            boolean r0 = r0.equalsIgnoreCase(r6)     // Catch:{ Exception -> 0x016c }
            if (r0 == 0) goto L_0x017f
            boolean r0 = r12.equalsIgnoreCase(r11)     // Catch:{ Exception -> 0x016c }
            if (r0 == 0) goto L_0x017f
            java.lang.String r0 = com.momagic.H.p()     // Catch:{ Exception -> 0x016c }
            java.lang.String r4 = r9.e(r3)     // Catch:{ Exception -> 0x016c }
            java.lang.String r0 = com.momagic.H.c(r0, r4)     // Catch:{ Exception -> 0x016c }
            boolean r4 = r16.isEmpty()     // Catch:{ Exception -> 0x016c }
            if (r4 != 0) goto L_0x015d
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x016c }
            if (r0 < r10) goto L_0x017f
        L_0x015d:
            java.lang.String r0 = com.momagic.H.p()     // Catch:{ Exception -> 0x016c }
            r9.h(r3, r0)     // Catch:{ Exception -> 0x016c }
            com.momagic.TargetActivity r0 = r1.a     // Catch:{ Exception -> 0x016c }
            java.lang.String r3 = r1.f4030d     // Catch:{ Exception -> 0x016c }
            m(r0, r2, r3)     // Catch:{ Exception -> 0x016c }
            goto L_0x017f
        L_0x016c:
            r0 = move-exception
            goto L_0x0174
        L_0x016e:
            r17 = r2
            goto L_0x017f
        L_0x0171:
            r0 = move-exception
            r17 = r2
        L_0x0174:
            android.content.Context r2 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            java.lang.String r3 = "onCreate"
            com.momagic.H.r(r2, r0, r5, r3)
        L_0x017f:
            android.content.Context r0 = com.momagic.C0835h.f4046a
            gq r0 = defpackage.C1139gq.c(r0)
            java.lang.String r2 = "Mediation"
            boolean r0 = r0.a(r2)
            if (r0 == 0) goto L_0x01b8
            java.util.ArrayList r0 = com.momagic.C0828a.e
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x01b8
            r0 = 0
        L_0x0196:
            java.util.ArrayList r2 = com.momagic.C0828a.e
            int r3 = r2.size()
            if (r0 >= r3) goto L_0x01b8
            r2.size()
            java.lang.Object r2 = r2.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x01b5
            com.momagic.F r3 = new com.momagic.F
            r3.<init>()
            com.momagic.B.a(r3, r2)
        L_0x01b5:
            int r0 = r0 + 1
            goto L_0x0196
        L_0x01b8:
            java.lang.String r0 = r
            java.lang.String r2 = ""
            if (r0 == r2) goto L_0x01e8
            boolean r3 = r0.isEmpty()     // Catch:{ Exception -> 0x01dc }
            if (r3 != 0) goto L_0x01e8
            android.content.Context r3 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x01dc }
            java.lang.String r4 = "mediationClick"
            defpackage.C1104f8.b(r3, r0, r4)     // Catch:{ Exception -> 0x01dc }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x01dc }
            r3.<init>(r0)     // Catch:{ Exception -> 0x01dc }
            java.lang.String r4 = "https://med.dtblt.com/medc"
            com.momagic.G r7 = new com.momagic.G     // Catch:{ Exception -> 0x01dc }
            r7.<init>(r0)     // Catch:{ Exception -> 0x01dc }
            r0 = 0
            com.momagic.B.c(r4, r0, r3, r7)     // Catch:{ Exception -> 0x01dc }
            goto L_0x01e8
        L_0x01dc:
            r0 = move-exception
            android.content.Context r3 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "callMediationClicks"
            com.momagic.H.r(r3, r0, r5, r4)
        L_0x01e8:
            java.lang.String r0 = p
            boolean r0 = r0.equalsIgnoreCase(r2)
            if (r0 == 0) goto L_0x01f2
            p = r6
        L_0x01f2:
            java.lang.String r0 = p
            boolean r0 = r0.equalsIgnoreCase(r6)
            if (r0 != 0) goto L_0x0256
            int r0 = r1.c
            if (r0 < 0) goto L_0x0256
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.String r2 = "button1ID"
            java.lang.String r3 = r1.g
            r0.put(r2, r3)
            java.lang.String r2 = "button1Title"
            java.lang.String r3 = r1.k
            r0.put(r2, r3)
            java.lang.String r2 = "button1URL"
            java.lang.String r3 = r1.j
            r0.put(r2, r3)
            java.lang.String r2 = "additionalData"
            java.lang.String r3 = p
            r0.put(r2, r3)
            java.lang.String r2 = "landingURL"
            java.lang.String r3 = q
            r0.put(r2, r3)
            java.lang.String r2 = "button2ID"
            java.lang.String r3 = r1.h
            r0.put(r2, r3)
            java.lang.String r2 = "button2Title"
            java.lang.String r3 = r1.l
            r0.put(r2, r3)
            java.lang.String r2 = "button2URL"
            java.lang.String r3 = r1.i
            r0.put(r2, r3)
            int r2 = r1.d
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "actionType"
            r0.put(r3, r2)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>(r0)
            r2.toString()
            com.momagic.C0835h.h()
            r18.finish()
            goto L_0x0332
        L_0x0256:
            int r0 = r1.c
            r2 = 1
            java.lang.String r3 = "NO"
            if (r0 != r2) goto L_0x028e
            java.lang.String r0 = r1.f
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L_0x028e
            java.lang.String r0 = q
            if (r0 == 0) goto L_0x028e
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x028e
            android.content.Context r0 = com.momagic.C0835h.f4046a
            com.momagic.TargetActivity r0 = r1.a
            java.lang.String r2 = r1.f4029c
            android.content.Intent r3 = new android.content.Intent
            java.lang.Class<com.momagic.DATBWebViewActivity> r4 = com.momagic.DATBWebViewActivity.class
            r3.<init>(r0, r4)
            java.lang.String r4 = "WEB_URL"
            r3.putExtra(r4, r2)
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r3.addFlags(r2)
            r0.startActivity(r3)
            r18.finish()
            goto L_0x0332
        L_0x028e:
            java.lang.String r0 = r1.f     // Catch:{ Exception -> 0x0318 }
            boolean r0 = r0.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x0318 }
            r2 = 268468224(0x10008000, float:2.5342157E-29)
            if (r0 == 0) goto L_0x02ff
            java.lang.String r0 = r1.f4029c     // Catch:{ Exception -> 0x0318 }
            if (r0 == 0) goto L_0x02f6
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0318 }
            if (r0 != 0) goto L_0x02f6
            java.lang.String r0 = r1.f4029c     // Catch:{ Exception -> 0x0318 }
            java.lang.String r3 = "http://"
            boolean r0 = r0.startsWith(r3)     // Catch:{ Exception -> 0x0318 }
            java.lang.String r3 = "android.intent.action.VIEW"
            if (r0 != 0) goto L_0x02df
            java.lang.String r0 = r1.f4029c     // Catch:{ Exception -> 0x0318 }
            r4 = r17
            boolean r0 = r0.startsWith(r4)     // Catch:{ Exception -> 0x0318 }
            if (r0 != 0) goto L_0x02df
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0318 }
            r0.<init>()     // Catch:{ Exception -> 0x0318 }
            r0.append(r4)     // Catch:{ Exception -> 0x0318 }
            java.lang.String r4 = r1.f4029c     // Catch:{ Exception -> 0x0318 }
            r0.append(r4)     // Catch:{ Exception -> 0x0318 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0318 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ Exception -> 0x0318 }
            android.net.Uri r0 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x0318 }
            r4.<init>(r3, r0)     // Catch:{ Exception -> 0x0318 }
            r4.setFlags(r2)     // Catch:{ Exception -> 0x0318 }
            com.momagic.TargetActivity r0 = r1.a     // Catch:{ Exception -> 0x0318 }
            r0.startActivity(r4)     // Catch:{ Exception -> 0x0318 }
            r18.finish()     // Catch:{ Exception -> 0x0318 }
            goto L_0x0332
        L_0x02df:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0318 }
            java.lang.String r4 = r1.f4029c     // Catch:{ Exception -> 0x0318 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0318 }
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0318 }
            r0.setFlags(r2)     // Catch:{ Exception -> 0x0318 }
            com.momagic.TargetActivity r2 = r1.a     // Catch:{ Exception -> 0x0318 }
            r2.startActivity(r0)     // Catch:{ Exception -> 0x0318 }
            r18.finish()     // Catch:{ Exception -> 0x0318 }
            goto L_0x0332
        L_0x02f6:
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x0318 }
            n(r0)     // Catch:{ Exception -> 0x0318 }
            r18.finish()     // Catch:{ Exception -> 0x0318 }
            goto L_0x0332
        L_0x02ff:
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0318 }
            java.lang.String r3 = "android.intent.action.DIAL"
            java.lang.String r4 = r1.f     // Catch:{ Exception -> 0x0318 }
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0318 }
            r0.<init>(r3, r4)     // Catch:{ Exception -> 0x0318 }
            r0.setFlags(r2)     // Catch:{ Exception -> 0x0318 }
            com.momagic.TargetActivity r2 = r1.a     // Catch:{ Exception -> 0x0318 }
            r2.startActivity(r0)     // Catch:{ Exception -> 0x0318 }
            r18.finish()     // Catch:{ Exception -> 0x0318 }
            goto L_0x0332
        L_0x0318:
            r0 = move-exception
            android.content.Context r2 = com.momagic.C0835h.f4046a
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "OnCreate"
            r3.<init>(r4)
            java.lang.String r4 = r1.f4029c
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.momagic.H.r(r2, r0, r5, r3)
        L_0x0332:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.TargetActivity.onCreate(android.os.Bundle):void");
    }
}
