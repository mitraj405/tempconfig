package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.ads.internal.api.BuildConfigApi;
import in.juspay.hyper.constants.LogSubCategory;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DexLoadErrorReporter {
    public static final double SAMPLING = 0.1d;
    public static final AtomicBoolean a = new AtomicBoolean();

    public class a extends Thread {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String c;

        public a(Context context, String str) {
            this.a = context;
            this.c = str;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(16:1|2|3|4|5|6|7|8|9|10|(3:11|12|(1:14)(1:42))|15|16|17|18|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0133 */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x014a A[SYNTHETIC, Splitter:B:32:0x014a] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x014f A[SYNTHETIC, Splitter:B:36:0x014f] */
        /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r22 = this;
                r0 = r22
                java.lang.String r1 = "data"
                android.content.Context r2 = r0.a
                java.lang.String r3 = "0"
                java.lang.String r4 = "attempt"
                java.lang.String r5 = "UTF-8"
                java.lang.String r6 = "payload="
                java.lang.String r7 = ""
                super.run()
                java.net.URL r9 = new java.net.URL     // Catch:{ all -> 0x0143 }
                java.lang.String r10 = "https://www.facebook.com/adnw_logging/"
                r9.<init>(r10)     // Catch:{ all -> 0x0143 }
                java.net.URLConnection r9 = r9.openConnection()     // Catch:{ all -> 0x0143 }
                java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ all -> 0x0143 }
                java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ all -> 0x0143 }
                java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ all -> 0x0143 }
                java.lang.String r10 = "POST"
                r9.setRequestMethod(r10)     // Catch:{ all -> 0x013d }
                java.lang.String r10 = "Content-Type"
                java.lang.String r11 = "application/x-www-form-urlencoded;charset=UTF-8"
                r9.setRequestProperty(r10, r11)     // Catch:{ all -> 0x013d }
                java.lang.String r10 = "Accept"
                java.lang.String r11 = "application/json"
                r9.setRequestProperty(r10, r11)     // Catch:{ all -> 0x013d }
                java.lang.String r10 = "Accept-Charset"
                r9.setRequestProperty(r10, r5)     // Catch:{ all -> 0x013d }
                java.lang.String r10 = "user-agent"
                java.lang.String r11 = "[FBAN/AudienceNetworkForAndroid;FBSN/Android]"
                r9.setRequestProperty(r10, r11)     // Catch:{ all -> 0x013d }
                r10 = 1
                r9.setDoOutput(r10)     // Catch:{ all -> 0x013d }
                r9.setDoInput(r10)     // Catch:{ all -> 0x013d }
                r9.connect()     // Catch:{ all -> 0x013d }
                java.util.UUID r10 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x013d }
                java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x013d }
                org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x013d }
                r11.<init>()     // Catch:{ all -> 0x013d }
                r11.put(r4, r3)     // Catch:{ all -> 0x013d }
                com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.a(r2, r11, r10)     // Catch:{ all -> 0x013d }
                org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ all -> 0x013d }
                r12.<init>()     // Catch:{ all -> 0x013d }
                java.lang.String r13 = "subtype"
                java.lang.String r14 = "generic"
                r12.put(r13, r14)     // Catch:{ all -> 0x013d }
                java.lang.String r13 = "subtype_code"
                java.lang.String r14 = "1320"
                r12.put(r13, r14)     // Catch:{ all -> 0x013d }
                java.lang.String r13 = "caught_exception"
                java.lang.String r14 = "1"
                r12.put(r13, r14)     // Catch:{ all -> 0x013d }
                java.lang.String r13 = "stacktrace"
                java.lang.String r14 = r0.c     // Catch:{ all -> 0x013d }
                r12.put(r13, r14)     // Catch:{ all -> 0x013d }
                org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ all -> 0x013d }
                r13.<init>()     // Catch:{ all -> 0x013d }
                java.lang.String r14 = "id"
                java.util.UUID r15 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x013d }
                java.lang.String r15 = r15.toString()     // Catch:{ all -> 0x013d }
                r13.put(r14, r15)     // Catch:{ all -> 0x013d }
                java.lang.String r14 = "type"
                java.lang.String r15 = "debug"
                r13.put(r14, r15)     // Catch:{ all -> 0x013d }
                java.lang.String r14 = "session_time"
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x013d }
                r15.<init>(r7)     // Catch:{ all -> 0x013d }
                long r16 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x013d }
                r18 = 1000(0x3e8, double:4.94E-321)
                r21 = r9
                long r8 = r16 / r18
                r15.append(r8)     // Catch:{ all -> 0x013f }
                java.lang.String r8 = r15.toString()     // Catch:{ all -> 0x013f }
                r13.put(r14, r8)     // Catch:{ all -> 0x013f }
                java.lang.String r8 = "time"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x013f }
                r9.<init>(r7)     // Catch:{ all -> 0x013f }
                long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x013f }
                long r14 = r14 / r18
                r9.append(r14)     // Catch:{ all -> 0x013f }
                java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x013f }
                r13.put(r8, r7)     // Catch:{ all -> 0x013f }
                java.lang.String r7 = "session_id"
                r13.put(r7, r10)     // Catch:{ all -> 0x013f }
                r13.put(r1, r12)     // Catch:{ all -> 0x013f }
                r13.put(r4, r3)     // Catch:{ all -> 0x013f }
                com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.a(r2, r12, r10)     // Catch:{ all -> 0x013f }
                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ all -> 0x013f }
                r2.<init>()     // Catch:{ all -> 0x013f }
                r2.put(r13)     // Catch:{ all -> 0x013f }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x013f }
                r3.<init>()     // Catch:{ all -> 0x013f }
                r3.put(r1, r11)     // Catch:{ all -> 0x013f }
                java.lang.String r1 = "events"
                r3.put(r1, r2)     // Catch:{ all -> 0x013f }
                java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x013f }
                java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ all -> 0x013f }
                java.io.OutputStream r3 = r21.getOutputStream()     // Catch:{ all -> 0x013f }
                r2.<init>(r3)     // Catch:{ all -> 0x013f }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x013b }
                r3.<init>(r6)     // Catch:{ all -> 0x013b }
                java.lang.String r1 = java.net.URLEncoder.encode(r1, r5)     // Catch:{ all -> 0x013b }
                r3.append(r1)     // Catch:{ all -> 0x013b }
                java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x013b }
                r2.writeBytes(r1)     // Catch:{ all -> 0x013b }
                r2.flush()     // Catch:{ all -> 0x013b }
                r1 = 16384(0x4000, float:2.2959E-41)
                byte[] r1 = new byte[r1]     // Catch:{ all -> 0x013b }
                java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x013b }
                r3.<init>()     // Catch:{ all -> 0x013b }
                java.io.InputStream r8 = r21.getInputStream()     // Catch:{ all -> 0x013b }
            L_0x0121:
                int r4 = r8.read(r1)     // Catch:{ all -> 0x0137 }
                r5 = -1
                if (r4 == r5) goto L_0x012d
                r5 = 0
                r3.write(r1, r5, r4)     // Catch:{ all -> 0x0137 }
                goto L_0x0121
            L_0x012d:
                r3.flush()     // Catch:{ all -> 0x0137 }
                r2.close()     // Catch:{ Exception -> 0x0133 }
            L_0x0133:
                r8.close()     // Catch:{ Exception -> 0x0154 }
                goto L_0x0154
            L_0x0137:
                r20 = r8
                r8 = r2
                goto L_0x0148
            L_0x013b:
                r8 = r2
                goto L_0x0140
            L_0x013d:
                r21 = r9
            L_0x013f:
                r8 = 0
            L_0x0140:
                r20 = 0
                goto L_0x0148
            L_0x0143:
                r8 = 0
                r20 = 0
                r21 = 0
            L_0x0148:
                if (r8 == 0) goto L_0x014d
                r8.close()     // Catch:{ Exception -> 0x014d }
            L_0x014d:
                if (r20 == 0) goto L_0x0152
                r20.close()     // Catch:{ Exception -> 0x0152 }
            L_0x0152:
                if (r21 == 0) goto L_0x0157
            L_0x0154:
                r21.disconnect()
            L_0x0157:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dynamicloading.DexLoadErrorReporter.a.run():void");
        }
    }

    public static void a(Context context, JSONObject jSONObject, String str) throws JSONException, PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        jSONObject.put("APPBUILD", context.getPackageManager().getPackageInfo(packageName, 0).versionCode);
        jSONObject.put("APPNAME", context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(packageName, 0)));
        jSONObject.put("APPVERS", context.getPackageManager().getPackageInfo(packageName, 0).versionName);
        jSONObject.put("OSVERS", Build.VERSION.RELEASE);
        jSONObject.put("SDK", LogSubCategory.LifeCycle.ANDROID);
        jSONObject.put("SESSION_ID", str);
        jSONObject.put("MODEL", Build.MODEL);
        jSONObject.put("BUNDLE", packageName);
        jSONObject.put("SDK_VERSION", BuildConfigApi.getVersionName(context));
        jSONObject.put("OS", "Android");
    }

    @SuppressLint({"CatchGeneralException"})
    public static void reportDexLoadingIssue(Context context, String str, double d) {
        AtomicBoolean atomicBoolean = a;
        if (!atomicBoolean.get() && Math.random() < d) {
            atomicBoolean.set(true);
            new a(context, str).start();
        }
    }
}
