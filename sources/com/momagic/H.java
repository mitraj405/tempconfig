package com.momagic;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.Html;
import android.text.Spanned;
import android.util.Base64;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.momagic.B;
import defpackage.d7;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Util */
public final class H {
    public static void A(Context context, String str, String str2) {
        JSONArray jSONArray;
        if (context != null) {
            try {
                C1139gq c = C1139gq.c(context);
                JSONObject jSONObject = new JSONObject();
                if (!c.e("iz_mediation_records").isEmpty()) {
                    jSONArray = new JSONArray(c.e("iz_mediation_records"));
                } else {
                    jSONArray = new JSONArray();
                }
                jSONObject.put("iz_api_name", str);
                jSONObject.put("iz_mediationData", str2.replace("\n", ""));
                jSONArray.put(jSONObject);
                c.h("iz_mediation_records", jSONArray.toString());
            } catch (Exception e) {
                r(context, e.toString(), "Util", "trackMediation_Impression_Click");
            }
        }
    }

    public static String a(String str) {
        if (str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static int b(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 1;
        for (int length = charArray.length; length > 0; length--) {
            if (length == 1) {
                char c = charArray[length - 1];
                if (c == '-') {
                    return i * -1;
                }
                if (c == '+') {
                    return i;
                }
            }
            i += (charArray[length - 1] - '0') * i2;
            i2 *= 10;
        }
        return i;
    }

    public static String c(String str, String str2) {
        if (str2.isEmpty()) {
            return "";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            return Long.toString((simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse(str2).getTime()) / 86400000);
        } catch (Exception e) {
            r(C0835h.f4046a, e.toString(), "Util", "dayDifference");
            return "";
        }
    }

    public static String d(String str) {
        try {
            String[] split = str.split(":");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Base64.decode(split[1], 0));
            SecretKeySpec secretKeySpec = new SecretKeySpec("b07dfa9d56fc64df".getBytes("ISO-8859-1"), "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return new String(instance.doFinal(Base64.decode(split[0], 0)));
        } catch (Exception e) {
            r(C0835h.f4046a, e.toString(), "Util", "decrypt");
            return null;
        }
    }

    public static boolean e(C1203jp jpVar) {
        String str = jpVar.M;
        if (str == null || str.isEmpty() || !jpVar.M.equals(C0515Ga.AVLBLTY_ONLY)) {
            return false;
        }
        return true;
    }

    public static BigInteger f() {
        String str;
        try {
            Context context = C0835h.f4046a;
            if (context == null) {
                return null;
            }
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("izooto_notification_accent_color", "string", context.getPackageName());
            if (identifier != 0) {
                str = resources.getString(identifier);
            } else {
                str = null;
            }
            if (str.charAt(0) != '#') {
                return new BigInteger(str, 16);
            }
            String replace = str.replace("#", "");
            if (replace != null) {
                return new BigInteger(replace, 16);
            }
            return null;
        } catch (Exception e) {
            r(C0835h.f4046a, e.toString(), "Util", "getAccentColor");
        }
    }

    public static String g(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String h(Context context) {
        if (context == null) {
            return "App Version  is not Found";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            r(context, e.toString(), "Util", "getAppVersion");
            return "App Version  is not Found";
        }
    }

    public static int i(int i) {
        String str;
        String str2;
        String str3;
        String l = l(i);
        if (l == null || l.isEmpty()) {
            str3 = "0";
            str = str3;
            str2 = str;
        } else {
            str3 = String.valueOf(l.charAt(l.length() - 4));
            str2 = String.valueOf(l.charAt(l.length() - 5));
            str = String.valueOf(l.charAt(l.length() - 6));
        }
        return Integer.parseInt(str + str2 + str3, 2);
    }

    public static Bitmap j(String str) {
        if (str.isEmpty()) {
            return null;
        }
        String replace = str.trim().replace("///", RemoteSettings.FORWARD_SLASH_STRING).replace("//", RemoteSettings.FORWARD_SLASH_STRING).replace("http:/", "https://").replace("https:/", "https://");
        if (replace.startsWith("http://") || replace.startsWith("https://")) {
            try {
                return BitmapFactory.decodeStream(((URLConnection) FirebasePerfUrlConnection.instrument(new URL(replace).openConnection())).getInputStream());
            } catch (Exception e) {
                r(C0835h.f4046a, e.toString(), "Util", "getBitMap");
                return null;
            }
        } else {
            C1104f8.b(C0835h.f4046a, "Image URL".concat(str), "[Log-> e]->getBitmapFromURL");
            return null;
        }
    }

    public static String k() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.toLowerCase().startsWith(str.toLowerCase())) {
            return a(str2);
        }
        return a(str) + " " + str2;
    }

    public static String l(int i) {
        return String.format("%16s", new Object[]{Integer.toBinaryString(i)}).replace(' ', '0');
    }

    public static String m(Context context) {
        try {
            context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            r(context, e.toString(), "Util", "getPackageName");
        }
        return context.getPackageName();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A[Catch:{ Exception -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002a A[Catch:{ Exception -> 0x002f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long n(defpackage.C1203jp r3) {
        /*
            java.lang.String r0 = "Util"
            java.lang.String r1 = r3.M     // Catch:{ Exception -> 0x0018 }
            if (r1 == 0) goto L_0x0024
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x0018 }
            if (r1 != 0) goto L_0x0024
            java.lang.String r3 = r3.M     // Catch:{ Exception -> 0x0018 }
            java.lang.String r1 = "2"
            boolean r3 = r3.equals(r1)     // Catch:{ Exception -> 0x0018 }
            if (r3 == 0) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x0018:
            r3 = move-exception
            android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x002f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x002f }
            java.lang.String r2 = "verifyRequiredInteraction"
            r(r1, r3, r0, r2)     // Catch:{ Exception -> 0x002f }
        L_0x0024:
            r3 = 0
        L_0x0025:
            if (r3 == 0) goto L_0x002a
            r0 = 20000(0x4e20, double:9.8813E-320)
            goto L_0x003d
        L_0x002a:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x002f }
            goto L_0x003d
        L_0x002f:
            r3 = move-exception
            android.content.Context r1 = com.momagic.C0835h.f4046a
            java.lang.String r3 = r3.toString()
            java.lang.String r2 = "getRequiredInteraction"
            r(r1, r3, r0, r2)
            r0 = 0
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.H.n(jp):long");
    }

    public static Uri o(Context context, String str) {
        boolean z;
        int identifier;
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        if (str == null || str.matches("^[0-9]")) {
            z = false;
        } else {
            z = true;
        }
        if (!z || (identifier = resources.getIdentifier(str, "raw", packageName)) == 0) {
            int identifier2 = resources.getIdentifier("izooto_default_sound", "raw", packageName);
            if (identifier2 == 0) {
                return null;
            }
            return Uri.parse("android.resource://" + packageName + RemoteSettings.FORWARD_SLASH_STRING + identifier2);
        }
        return Uri.parse("android.resource://" + packageName + RemoteSettings.FORWARD_SLASH_STRING + identifier);
    }

    public static String p() {
        return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
    }

    public static String q(String str, String str2) {
        long j;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long parseLong = Long.parseLong(str) + (((long) (Integer.parseInt(str2) * 60)) * 1000);
            if (currentTimeMillis < Long.parseLong(str) || currentTimeMillis > parseLong) {
                j = 0;
            } else {
                j = (parseLong - currentTimeMillis) / 1000;
            }
            if (j >= 1 && j < 3600) {
                return String.valueOf(j);
            }
            C1104f8.b(C0835h.f4046a, "Timer values exceed on maximum seconds or minimum seconds", "getTimerValue");
            return "";
        } catch (Exception e) {
            r(C0835h.f4046a, e.toString(), "Util", "getTimerValue");
            return "";
        }
    }

    public static void r(Context context, String str, String str2, String str3) {
        C1139gq c = C1139gq.c(context);
        if (!c.a(str3)) {
            w(context, str, str2, str3);
            c.f(str3, true);
        }
        C1104f8.b(context, xx.D(str, " ", str3), "[Log.e]-> ".concat(str2));
    }

    public static boolean s(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks.isEmpty()) {
            return false;
        }
        return runningTasks.get(0).topActivity.getPackageName().equalsIgnoreCase(context.getPackageName());
    }

    public static Spanned t(String str) {
        StringBuilder sb = new StringBuilder("<font color=\"");
        Context context = C0835h.f4046a;
        int i = C1288nr.iz_black;
        Object obj = d7.a;
        sb.append(d7.b.a(context, i));
        sb.append("\">");
        sb.append(str);
        sb.append("</font>");
        return Html.fromHtml(sb.toString(), 0);
    }

    public static Bitmap u(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), 10.0f, 10.0f, paint);
        return createBitmap;
    }

    public static boolean v(JSONArray jSONArray, String str) {
        String jSONArray2 = jSONArray.toString();
        return jSONArray2.contains("\"rid\":\"" + str + "\"");
    }

    public static void w(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                C1139gq c = C1139gq.c(context);
                if (!str.isEmpty()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("pid", c.b());
                    hashMap.put("at", "" + c.e("deviceToken"));
                    hashMap.put("bKey", "" + g(context));
                    hashMap.put("exceptionName", str);
                    hashMap.put("methodName", "" + str3);
                    hashMap.put("className", str2);
                    hashMap.put("osVersion", "" + Build.VERSION.RELEASE);
                    hashMap.put("deviceName", "" + k());
                    hashMap.put("SDKVERSION", "2.4.0");
                    B.c("https://aerr.izooto.com/aerr", hashMap, (JSONObject) null, new a());
                }
            } catch (Exception e) {
                r(context, e.toString(), "Util", "setException");
            }
        }
    }

    public static ArrayList x(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = x((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = y((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public static HashMap<String, Object> y(JSONObject jSONObject) throws JSONException {
        HashMap<String, Object> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = x((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = y((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public static void z(Context context, String str, String str2, String str3, String str4, int i) {
        JSONArray jSONArray;
        if (context != null) {
            try {
                C1139gq c = C1139gq.c(context);
                JSONObject jSONObject = new JSONObject();
                if (!c.e(str2).isEmpty()) {
                    jSONArray = new JSONArray(c.e(str2));
                } else {
                    jSONArray = new JSONArray();
                }
                jSONObject.put("pid", c.b());
                jSONObject.put("SDKVERSION", "2.4.0");
                jSONObject.put("bKey", g(context));
                if (!str.isEmpty()) {
                    jSONObject.put("apiURL", str);
                }
                if (!str3.isEmpty()) {
                    jSONObject.put("rid", str3);
                }
                if (str2.equalsIgnoreCase("iZ_Notification_Click_Offline")) {
                    jSONObject.put("notification_op", "click");
                    if (!str4.isEmpty()) {
                        jSONObject.put("cid", str4);
                    }
                    if (i != 0) {
                        jSONObject.put("click", i);
                    }
                }
                jSONArray.put(jSONObject);
                c.h(str2, jSONArray.toString());
            } catch (Exception e) {
                r(context, e.toString(), "Util", "trackClickOffline");
            }
        }
    }

    /* compiled from: Util */
    public class a extends B.b {
        public final void b(String str) {
        }

        public final void a(int i, String str) {
        }
    }
}
