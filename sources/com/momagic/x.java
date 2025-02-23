package com.momagic;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.service.notification.StatusBarNotification;
import android.util.Base64;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.momagic.B;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: NotificationEventManager */
public final class x {
    public static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static String f4065a = "0";

    public static int a() {
        int identifier = C0835h.f4046a.getResources().getIdentifier("ic_stat_datb_default", "drawable", C0835h.f4046a.getPackageName());
        if (identifier != 0) {
            return identifier;
        }
        return 17301598;
    }

    public static void b(int i) {
        C1139gq c = C1139gq.c(C0835h.f4046a);
        if (i > 0) {
            try {
                if (c.d("datbcount") >= 1) {
                    c.g(c.d("datbcount") + 1, "datbcount");
                } else {
                    c.g(1, "datbcount");
                }
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "badgeCountUpdate");
                return;
            }
        }
        Dw.a(C0835h.f4046a, c.d("datbcount"));
    }

    public static String c(String str) {
        if (str == null) {
            return str;
        }
        if (str.contains("{~PID~}") || str.contains("{~ADID~}") || str.contains("{~DEVICEID~}") || str.contains("{~UUID~}")) {
            return str.replace("{~PID~}", C1139gq.c(C0835h.f4046a).b()).replace("{~ADID~}", C1139gq.c(C0835h.f4046a).e("add")).replace("{~DEVICEID~}", H.g(C0835h.f4046a).replace("{~UUID~}", H.g(C0835h.f4046a)));
        }
        return str;
    }

    public static int d(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        if (str.contains("#")) {
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException e) {
                if (C0835h.f4046a == null) {
                    return 0;
                }
                H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "getBadgeColor");
                return 0;
            }
        } else if (str.isEmpty()) {
            return 0;
        } else {
            try {
                return Color.parseColor("#".concat(str));
            } catch (Exception e2) {
                Context context = C0835h.f4046a;
                if (context != null) {
                    H.r(context, e2.toString(), "NotificationEventManager", "getBadgeColor");
                }
                H.r(C0835h.f4046a, e2.toString(), "NotificationEventManager", "getBadgeColor");
                return 0;
            }
        }
    }

    public static void e(Context context, int i) {
        if (context != null) {
            try {
                StatusBarNotification[] activeNotifications = ((NotificationManager) context.getSystemService("notification")).getActiveNotifications();
                TreeMap treeMap = new TreeMap();
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (statusBarNotification.getTag() == null) {
                        treeMap.put(Long.valueOf(statusBarNotification.getNotification().when), Integer.valueOf(statusBarNotification.getId()));
                    }
                }
                int size = treeMap.size() - i;
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (size > 0) {
                        size--;
                        ((NotificationManager) context.getSystemService("notification")).cancel(((Integer) entry.getValue()).intValue());
                    } else {
                        return;
                    }
                }
            } catch (Exception e) {
                H.r(context, e.toString(), "NotificationEventManager", "getMaximumNotificationInTray");
            }
        }
    }

    public static String f(String str, JSONObject jSONObject) {
        try {
            if (str.startsWith("~")) {
                return str.replace("~", "");
            }
            if (!str.contains(".")) {
                return jSONObject.optString(str);
            }
            String[] split = str.split("\\.");
            if (split.length != 2) {
                if (split.length != 3) {
                    if (split.length == 4) {
                        if (split[2].contains("[")) {
                            String[] split2 = split[2].split("\\[");
                            return jSONObject.getJSONObject(split[0]).getJSONObject(split[1]).getJSONArray(split2[0]).getJSONObject(Integer.parseInt(split2[1].replace("]", ""))).optString(split[3]);
                        }
                    } else if (split.length != 5) {
                        jSONObject.optString(str);
                    } else if (split[2].contains("[")) {
                        String[] split3 = split[2].split("\\[");
                        return jSONObject.getJSONObject(split[0]).getJSONObject(split[1]).getJSONArray(split3[0]).getJSONObject(Integer.parseInt(split3[1].replace("]", ""))).getJSONObject(split[3]).optString(split[4]);
                    }
                    return "";
                }
            }
            JSONObject jSONObject2 = null;
            for (int i = 0; i < split.length; i++) {
                if (!split[i].contains("[")) {
                    return jSONObject2.optString(split[i]);
                }
                String[] split4 = split[i].split("\\[");
                if (jSONObject2 == null) {
                    jSONObject2 = jSONObject.getJSONArray(split4[0]).getJSONObject(Integer.parseInt(split4[1].replace("]", "")));
                } else {
                    jSONObject2 = jSONObject2.getJSONArray(split4[0]).getJSONObject(Integer.parseInt(split4[1].replace("]", "")));
                }
            }
            return "";
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "getParsedValue");
        }
    }

    public static String g(String str) {
        if (str.contains("&frwd")) {
            str = new String(Base64.decode(str.split("&frwd=")[1].split("&bkey=")[0], 0));
        }
        if (str.contains("tel:")) {
            return str;
        }
        return "NO";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[Catch:{ Exception -> 0x00b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String h(java.lang.String r10, org.json.JSONObject r11) {
        /*
            java.lang.String r0 = "~"
            org.json.JSONTokener r1 = new org.json.JSONTokener     // Catch:{ Exception -> 0x00b5 }
            r1.<init>(r10)     // Catch:{ Exception -> 0x00b5 }
            java.lang.Object r1 = r1.nextValue()     // Catch:{ Exception -> 0x00b5 }
            boolean r2 = r1 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00b5 }
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x0018
            boolean r1 = r1 instanceof org.json.JSONArray     // Catch:{ Exception -> 0x00b5 }
            if (r1 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = r4
            goto L_0x0019
        L_0x0018:
            r1 = r3
        L_0x0019:
            if (r1 == 0) goto L_0x00b4
            boolean r1 = r10.startsWith(r0)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0028
            java.lang.String r10 = r10.replace(r0, r2)     // Catch:{ Exception -> 0x00b5 }
            return r10
        L_0x0028:
            java.lang.String r0 = "."
            boolean r0 = r10.contains(r0)     // Catch:{ Exception -> 0x00b5 }
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = "\\."
            java.lang.String[] r10 = r10.split(r0)     // Catch:{ Exception -> 0x00b5 }
            int r0 = r10.length     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r1 = "]"
            java.lang.String r5 = "\\["
            java.lang.String r6 = "["
            r7 = 2
            if (r0 == r7) goto L_0x007e
            int r0 = r10.length     // Catch:{ Exception -> 0x00b5 }
            r8 = 3
            if (r0 != r8) goto L_0x0045
            goto L_0x007e
        L_0x0045:
            int r0 = r10.length     // Catch:{ Exception -> 0x00b5 }
            r9 = 4
            if (r0 != r9) goto L_0x00c3
            r0 = r10[r7]     // Catch:{ Exception -> 0x00b5 }
            boolean r0 = r0.contains(r6)     // Catch:{ Exception -> 0x00b5 }
            if (r0 == 0) goto L_0x00c3
            r0 = r10[r7]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String[] r0 = r0.split(r5)     // Catch:{ Exception -> 0x00b5 }
            r5 = r10[r4]     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONObject r11 = r11.getJSONObject(r5)     // Catch:{ Exception -> 0x00b5 }
            r5 = r10[r3]     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONObject r11 = r11.getJSONObject(r5)     // Catch:{ Exception -> 0x00b5 }
            r4 = r0[r4]     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONArray r11 = r11.getJSONArray(r4)     // Catch:{ Exception -> 0x00b5 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ Exception -> 0x00b5 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONObject r11 = r11.getJSONObject(r0)     // Catch:{ Exception -> 0x00b5 }
            r10 = r10[r8]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = r11.optString(r10)     // Catch:{ Exception -> 0x00b5 }
            return r10
        L_0x007e:
            int r0 = r10.length     // Catch:{ Exception -> 0x00b5 }
            if (r0 <= 0) goto L_0x00c3
            r0 = r10[r4]     // Catch:{ Exception -> 0x00b5 }
            boolean r6 = r0.contains(r6)     // Catch:{ Exception -> 0x00b5 }
            if (r6 == 0) goto L_0x00a2
            java.lang.String[] r0 = r0.split(r5)     // Catch:{ Exception -> 0x00b5 }
            r4 = r0[r4]     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONArray r11 = r11.getJSONArray(r4)     // Catch:{ Exception -> 0x00b5 }
            r0 = r0[r3]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r0 = r0.replace(r1, r2)     // Catch:{ Exception -> 0x00b5 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONObject r11 = r11.getJSONObject(r0)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00ae
        L_0x00a2:
            r0 = r10[r4]     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONObject r11 = r11.getJSONObject(r0)     // Catch:{ Exception -> 0x00b5 }
            r0 = r10[r3]     // Catch:{ Exception -> 0x00b5 }
            org.json.JSONObject r11 = r11.getJSONObject(r0)     // Catch:{ Exception -> 0x00b5 }
        L_0x00ae:
            r10 = r10[r7]     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r10 = r11.optString(r10)     // Catch:{ Exception -> 0x00b5 }
        L_0x00b4:
            return r10
        L_0x00b5:
            r10 = move-exception
            android.content.Context r11 = com.momagic.C0835h.f4046a
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "NotificationEventManager"
            java.lang.String r1 = "getRcParseValues"
            com.momagic.H.r(r11, r10, r0, r1)
        L_0x00c3:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.x.h(java.lang.String, org.json.JSONObject):java.lang.String");
    }

    public static String i(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        try {
            if (str.startsWith("~")) {
                return str.replace("~", "");
            }
            if (!str.contains(".")) {
                return null;
            }
            String[] split = str.split("\\.");
            if ((split.length != 2 && split.length != 3) || split.length <= 0) {
                return null;
            }
            String str2 = split[0];
            if (str2.contains("[")) {
                String[] split2 = str2.split("\\[");
                jSONObject2 = jSONObject.getJSONArray(split2[0]).getJSONObject(Integer.parseInt(split2[1].replace("]", "")));
            } else {
                jSONObject2 = jSONObject.getJSONObject(split[0]).getJSONObject(split[1]);
            }
            return jSONObject2.optString(split[2]);
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "getRvParseValues");
            return null;
        }
    }

    public static void j(String str, String str2, String str3, String str4) {
        Context context = C0835h.f4046a;
        if (context != null) {
            C1139gq c = C1139gq.c(context);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("pid", c.b());
                hashMap.put("bKey", H.g(C0835h.f4046a));
                hashMap.put("op", "view");
                hashMap.put("fcm_token", c.e("deviceToken"));
                hashMap.put("error", "" + str);
                hashMap.put("payloadData", str2);
                hashMap.put("className", str3);
                hashMap.put("sdk_version", "2.4.0");
                hashMap.put("methodName", str4);
                B.c("https://aerr.izooto.com/aerr", hashMap, (JSONObject) null, new a());
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "handleNotificationError");
            }
        }
    }

    public static void k(String str, String str2, String str3) {
        Context context = C0835h.f4046a;
        if (context != null) {
            try {
                C1139gq c = C1139gq.c(context);
                HashMap hashMap = new HashMap();
                hashMap.put("pid", c.b());
                hashMap.put("cid", str2);
                hashMap.put("bKey", "" + H.g(C0835h.f4046a));
                hashMap.put("rid", "" + str3);
                hashMap.put("ver", "2.4.0");
                hashMap.put("op", "view");
                hashMap.put("push_type", "fcm");
                B.c(str, hashMap, (JSONObject) null, new u());
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "impressionNotification");
            }
        }
    }

    public static void l(int i, String str, String str2, String str3) {
        Context context = C0835h.f4046a;
        if (context != null) {
            try {
                C1139gq c = C1139gq.c(context);
                HashMap hashMap = new HashMap();
                hashMap.put("last_notification_viewed", Boolean.TRUE);
                JSONObject jSONObject = new JSONObject(hashMap);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("pid", c.b());
                hashMap2.put("ver", "2.4.0");
                hashMap2.put("bKey", "" + H.g(C0835h.f4046a));
                hashMap2.put("val", "" + jSONObject.toString());
                hashMap2.put("act", "add");
                hashMap2.put("isid", C0515Ga.AVLBLTY_ONLY);
                hashMap2.put("et", "userp");
                B.c(str, hashMap2, (JSONObject) null, new w(c, i, str2, str, str3));
            } catch (Exception e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "lastViewNotification");
            }
        }
    }

    public static void m(C1203jp jpVar, String str, String str2, String str3) {
        String str4;
        C1203jp jpVar2 = jpVar;
        String str5 = str2;
        Context context = C0835h.f4046a;
        if (context != null) {
            C1139gq c = C1139gq.c(context);
            String c2 = H.c(H.p(), c.e("currentDateViewWeekly"));
            String e = c.e("currentDateViewWeekly");
            String e2 = c.e("currentDateViewDaily");
            String e3 = c.e("currentDateView");
            int i = H.i(jpVar2.l);
            if (i > 0) {
                str4 = lf.i("https://lim", i, ".DATB.com/lim", i);
            } else {
                str4 = "https://lim.izooto.com/lim";
            }
            if (str5.equalsIgnoreCase(C0515Ga.AVLBLTY_ONLY)) {
                if (str3.equalsIgnoreCase(C0515Ga.AVLBLTY_ONLY)) {
                    if (!e2.equalsIgnoreCase(H.p())) {
                        c.h("currentDateViewDaily", H.p());
                        l(-1, str4, jpVar2.f5530d, jpVar2.f5529c);
                    }
                } else if (e.isEmpty() || Integer.parseInt(c2) >= 7) {
                    c.h("currentDateViewWeekly", H.p());
                    l(-1, str4, jpVar2.f5530d, jpVar2.f5529c);
                }
            } else if (str.equalsIgnoreCase(C0515Ga.AVLBLTY_ONLY) && str5.equalsIgnoreCase("0")) {
                String c3 = H.c(H.p(), c.e("currentDateView"));
                if (e3.isEmpty() || Integer.parseInt(c3) >= 7) {
                    c.h("currentDateView", H.p());
                    l(-1, str4, jpVar2.f5530d, jpVar2.f5529c);
                }
            }
        }
    }

    public static Intent n(C1203jp jpVar, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        Intent intent;
        C1203jp jpVar2 = jpVar;
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = jpVar2.f5525a;
        if (str10 == null || str10.isEmpty()) {
            if ((str.contains("{~TOKEN~}") || str.contains("{~DEVICEID~}") || str.contains("{~UUID~}") || str.contains("{~FCMTOKEN~}")) && C1139gq.c(C0835h.f4046a).e("deviceToken") != null) {
                str7 = str.replace("{~TOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken")).replace("{~DEVICEID~}", H.g(C0835h.f4046a)).replace("{~UUID~}", H.g(C0835h.f4046a)).replace("{~FCMTOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken"));
            }
            if ((str2.contains("{~TOKEN~}") || str2.contains("{~DEVICEID~}") || str2.contains("{~UUID~}") || str2.contains("{~FCMTOKEN~}")) && C1139gq.c(C0835h.f4046a).e("deviceToken") != null) {
                str8 = str2.replace("{~TOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken")).replace("{~DEVICEID~}", H.g(C0835h.f4046a)).replace("{~UUID~}", H.g(C0835h.f4046a)).replace("{~FCMTOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken"));
            }
            if ((str3.contains("{~TOKEN~}") || str3.contains("{~DEVICEID~}") || str3.contains("{~UUID~}") || str3.contains("{~FCMTOKEN~}")) && C1139gq.c(C0835h.f4046a).e("deviceToken") != null) {
                str9 = str3.replace("{~TOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken")).replace("{~DEVICEID~}", H.g(C0835h.f4046a)).replace("{~UUID~}", H.g(C0835h.f4046a)).replace("{~FCMTOKEN~}", C1139gq.c(C0835h.f4046a).e("deviceToken"));
            }
        } else {
            byte[] bArr = new byte[0];
            try {
                bArr = jpVar2.f5531e.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "getFinalUrl");
            }
            Uri.parse(jpVar2.f5531e).buildUpon().appendQueryParameter(FacebookMediationAdapter.KEY_ID, jpVar2.f5529c).appendQueryParameter("client", jpVar2.f5528b).appendQueryParameter("rid", jpVar2.f5530d).appendQueryParameter("bkey", C1139gq.c(C0835h.f4046a).e("deviceToken")).appendQueryParameter("frwd", Base64.encodeToString(bArr, 0)).build().toString();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            intent = new Intent(C0835h.f4046a, TargetActivity.class);
        } else {
            intent = new Intent(C0835h.f4046a, NotificationActionReceiver.class);
        }
        intent.putExtra("WEB_URL", str7);
        intent.putExtra("keyNotificationId", i);
        intent.putExtra("keyInApp", jpVar2.c);
        intent.putExtra("cid", jpVar2.f5529c);
        intent.putExtra("rid", jpVar2.f5530d);
        intent.putExtra("btn", i2);
        intent.putExtra("ap", jpVar2.w);
        intent.putExtra("call", str4);
        intent.putExtra("act1ID", jpVar2.u);
        intent.putExtra("act2ID", jpVar2.v);
        intent.putExtra("landingURL", str7);
        intent.putExtra("act1title", jpVar2.m);
        intent.putExtra("act2title", jpVar2.o);
        intent.putExtra("act1URL", str8);
        intent.putExtra("act2URL", str9);
        intent.putExtra("clickIndex", str5);
        intent.putExtra("lastclickIndex", str6);
        intent.putExtra("push_type", jpVar2.K);
        intent.putExtra("cfgfordomain", jpVar2.l);
        intent.putExtra("ti", jpVar2.f5532f);
        return intent;
    }

    public static void o(Context context, C1203jp jpVar) {
        if (context != null) {
            C1139gq c = C1139gq.c(context);
            if (jpVar.j == 2 || c.d("iz_notification_preview") == 907135001) {
                if (C0835h.f4046a != null) {
                    Handler handler = new Handler(Looper.getMainLooper());
                    C1117fn fnVar = new C1117fn(jpVar);
                    String str = jpVar.f5525a;
                    if (str == null || str.isEmpty()) {
                        handler.post(fnVar);
                    } else if (C0835h.f4046a != null) {
                        try {
                            C1492y1.a().f7069a.execute(new E6(jpVar, 1, handler, fnVar));
                        } catch (Exception e) {
                            H.r(C0835h.f4046a, e.toString(), "NotificationExecutorService", "executeNotification");
                        }
                    }
                }
            } else if (jpVar.j == 3 || c.d("iz_notification_preview") == 907135002) {
                Handler handler2 = new Handler(Looper.getMainLooper());
                C0806bn bnVar = new C0806bn(jpVar);
                String str2 = jpVar.f5525a;
                if (str2 == null || str2.isEmpty()) {
                    handler2.post(bnVar);
                } else if (C0835h.f4046a != null) {
                    try {
                        C1492y1.a().f7069a.execute(new E6(jpVar, 1, handler2, bnVar));
                    } catch (Exception e2) {
                        H.r(C0835h.f4046a, e2.toString(), "NotificationExecutorService", "executeNotification");
                    }
                }
            } else {
                Handler handler3 = new Handler(Looper.getMainLooper());
                C0826cn cnVar = new C0826cn(jpVar);
                String str3 = jpVar.f5525a;
                if (str3 == null || str3.isEmpty()) {
                    handler3.post(cnVar);
                } else if (C0835h.f4046a != null) {
                    try {
                        C1492y1.a().f7069a.execute(new E6(jpVar, 1, handler3, cnVar));
                    } catch (Exception e3) {
                        H.r(C0835h.f4046a, e3.toString(), "NotificationExecutorService", "executeNotification");
                    }
                }
            }
        }
    }

    public static void p(C1203jp jpVar, JSONObject jSONObject) {
        try {
            String str = jpVar.f5531e;
            if (str != null) {
                if (!str.isEmpty()) {
                    jpVar.f5531e = f(jpVar.f5531e.replace("~", ""), jSONObject);
                }
            }
            String str2 = jpVar.f5531e;
            if (str2 != "") {
                if (!str2.isEmpty() && !jpVar.f5531e.startsWith("http://") && !jpVar.f5531e.startsWith("https://")) {
                    String str3 = jpVar.f5531e;
                    jpVar.f5531e = "https://" + str3;
                }
            }
            String str4 = jpVar.f5532f;
            if (str4 != null && !str4.isEmpty()) {
                jpVar.f5532f = f(jpVar.f5532f.replace("~", ""), jSONObject);
            }
            String str5 = jpVar.f5534h;
            if (str5 != null && !str5.isEmpty()) {
                jpVar.f5534h = f(jpVar.f5534h.replace("~", ""), jSONObject);
            }
            String str6 = jpVar.f5538l;
            if (str6 != null && !str6.isEmpty()) {
                jpVar.f5538l = f(jpVar.f5538l.replace("~", ""), jSONObject);
            }
            String str7 = jpVar.f5535i;
            if (str7 != null && !str7.isEmpty()) {
                jpVar.f5535i = f(jpVar.f5535i.replace("~", ""), jSONObject);
            }
            String str8 = jpVar.m;
            if (str8 != null && !str8.isEmpty()) {
                jpVar.m = jpVar.m.replace("~", "");
            }
            String replace = f(jpVar.n, jSONObject).replace("~", "");
            jpVar.n = replace;
            if (replace != "" && !replace.isEmpty() && !jpVar.n.startsWith("http://") && !jpVar.n.startsWith("https://")) {
                String str9 = jpVar.n;
                jpVar.n = "https://" + str9;
            }
            r(jpVar, jSONObject);
            q(jpVar, jSONObject);
            jpVar.w = "";
            jpVar.c = 0;
            String str10 = jpVar.f5532f;
            if (str10 == null || str10.equalsIgnoreCase("")) {
                C0828a.e(jpVar, C0828a.f(jpVar));
                return;
            }
            C0828a.f.clear();
            C0828a.d.clear();
            o(C0835h.f4046a, jpVar);
            C0828a.d(jpVar);
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "parseJson");
        }
    }

    public static void q(C1203jp jpVar, JSONObject jSONObject) {
        try {
            String str = jpVar.z;
            if (str != null && !str.isEmpty()) {
                JSONArray jSONArray = new JSONArray(jpVar.z);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String h = h(jSONArray.getString(i), jSONObject);
                    jpVar.z = h;
                    C0828a.e.add(h);
                }
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "parseRcValues");
        }
    }

    public static void r(C1203jp jpVar, JSONObject jSONObject) {
        try {
            String str = jpVar.y;
            if (str != null && !str.isEmpty()) {
                JSONArray jSONArray = new JSONArray(jpVar.y);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String i2 = i(jSONArray.getString(i), jSONObject);
                    jpVar.y = i2;
                    if (!i2.isEmpty()) {
                        B.a(new t(), i2);
                    }
                }
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "parseRvValues");
        }
    }

    /* compiled from: NotificationEventManager */
    public class a extends B.b {
        public final void b(String str) {
        }

        public final void a(int i, String str) {
        }
    }
}
