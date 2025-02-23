package defpackage;

import java.util.TimerTask;

/* renamed from: IE  reason: default package */
public final class IE extends TimerTask {
    public final /* synthetic */ KE a;
    public final /* synthetic */ int c;

    /* renamed from: IE$a */
    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.lang.Throwable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: java.lang.Throwable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: java.lang.Throwable[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: java.net.HttpURLConnection} */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
            r7 = new java.lang.Throwable[0];
            defpackage.C1488xu.e(4, "PoW", "Getting PoW Parameters from Akamai...\"", r7);
            r5 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
            r7 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r7 = (java.net.HttpURLConnection) ((java.net.URLConnection) com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(new java.net.URL(r1.g()).openConnection()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r7.setReadTimeout(10000);
            r7.setConnectTimeout(15000);
            r7.setRequestMethod(com.google.firebase.perf.FirebasePerformance.HttpMethod.GET);
            r7.setUseCaches(false);
            r7.setRequestProperty(com.google.common.net.HttpHeaders.USER_AGENT, defpackage.GE.a());
            r5 = r7.getResponseCode();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
            if (r5 == 200) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
            defpackage.C1488xu.e(6, "PoW", "Failed to get PoW Params, HTTP response code: ".concat(java.lang.String.valueOf(r5)), new java.lang.Throwable[0]);
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
            r5 = new java.io.BufferedReader(new java.io.InputStreamReader(r7.getInputStream()));
            r8 = new java.lang.StringBuffer();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0085, code lost:
            r9 = r5.readLine();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
            if (r9 == null) goto L_0x008f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
            r8.append(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
            r5.close();
            r5 = new org.json.JSONObject(r8.toString());
            r1.c = r5.getInt("mode");
            r1.f339a = r5.getString("nonce");
            r1.f338a = r5.getLong("ttl");
            r1.f341b = r5.getLong("difficulty");
            r1.f344c = r5.getLong("timeout");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c3, code lost:
            if (r0 != 0) goto L_0x00cd;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c5, code lost:
            r5.getLong("n");
            r1.getClass();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00cd, code lost:
            r1.f347d = r5.getLong("s_timeout");
            r1.f342b = r5.getString("checksum");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00dd, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00de, code lost:
            r7.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e2, code lost:
            r5 = e;
            r7 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00e4, code lost:
            r5 = e;
            r7 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e6, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e9, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ea, code lost:
            r11 = r7;
            r7 = null;
            r5 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ef, code lost:
            r7 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            defpackage.C1488xu.e(6, "PoW", "Exception:" + r5.toString(), new java.lang.Throwable[0]);
            r5.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0109, code lost:
            if (r7 != null) goto L_0x010b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x010b, code lost:
            r7 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x010c, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x010d, code lost:
            r11 = r7;
            r7 = null;
            r5 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0110, code lost:
            defpackage.C1488xu.e(6, "PoW", "JSONException:" + r5.toString(), new java.lang.Throwable[0]);
            r7 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0129, code lost:
            if (r7 != null) goto L_0x012b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x012b, code lost:
            r7.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x012e, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x012f, code lost:
            if (r4 != false) goto L_0x014e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0131, code lost:
            r1.c();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0134, code lost:
            if (r0 == 1) goto L_0x0136;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0136, code lost:
            r1.e(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x013b, code lost:
            r3 = r1.b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x013f, code lost:
            if (r3 < 10) goto L_0x0141;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0141, code lost:
            r1.b = r3 + 1;
            r1.b(r0, 5000);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0149, code lost:
            r1.e(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0150, code lost:
            if (r1.c != 0) goto L_0x0152;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0152, code lost:
            r1.f349e = android.os.SystemClock.uptimeMillis();
            r1.f345c = "null" + r1.f349e + r1.f339a;
            r1.f348d = "null;" + r1.f349e + ";" + r1.f339a + ";" + r1.f341b + ";" + r1.f342b;
            r1.f = android.os.SystemClock.uptimeMillis();
            r1.d = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a9, code lost:
            if (r1.f337a == 2) goto L_0x01ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ab, code lost:
            defpackage.C1488xu.e(5, "PoW", "Cancel Get Params", new java.lang.Throwable[0]);
            r1.i();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b9, code lost:
            new java.util.Timer().schedule(new defpackage.JE(r1, r0), 100);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c9, code lost:
            r1.e(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x01cc, code lost:
            if (r0 == 0) goto L_0x01ce;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ce, code lost:
            r1.b(r0, r1.f338a * 1000);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x01d7, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d8, code lost:
            r5 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x01d9, code lost:
            if (r5 != null) goto L_0x01db;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x01db, code lost:
            r5.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x01de, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
            return;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x010b A[Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6, all -> 0x01d7 }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0131  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x014e  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x01db  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r12 = this;
                IE r0 = defpackage.IE.this
                KE r1 = r0.a
                int r0 = r0.c
                java.util.Locale r2 = defpackage.KE.a
                monitor-enter(r1)
                int r2 = r1.f337a     // Catch:{ all -> 0x01df }
                r3 = 2
                if (r2 == 0) goto L_0x0016
                if (r2 != r3) goto L_0x0013
                r1.i()     // Catch:{ all -> 0x01df }
            L_0x0013:
                monitor-exit(r1)     // Catch:{ all -> 0x01df }
                goto L_0x01d6
            L_0x0016:
                r2 = 1
                r1.f337a = r2     // Catch:{ all -> 0x01df }
                monitor-exit(r1)     // Catch:{ all -> 0x01df }
                java.lang.String r4 = "PoW"
                java.lang.String r5 = "Getting PoW Parameters from Akamai...\""
                r6 = 0
                java.lang.Throwable[] r7 = new java.lang.Throwable[r6]
                r8 = 4
                defpackage.C1488xu.e(r8, r4, r5, r7)
                r4 = 6
                r5 = 0
                java.lang.String r7 = r1.g()     // Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6 }
                java.net.URL r8 = new java.net.URL     // Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6 }
                r8.<init>(r7)     // Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6 }
                java.net.URLConnection r7 = r8.openConnection()     // Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6 }
                java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6 }
                java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6 }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ JSONException -> 0x010c, Exception -> 0x00e9, all -> 0x00e6 }
                r5 = 10000(0x2710, float:1.4013E-41)
                r7.setReadTimeout(r5)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r5 = 15000(0x3a98, float:2.102E-41)
                r7.setConnectTimeout(r5)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r5 = "GET"
                r7.setRequestMethod(r5)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r7.setUseCaches(r6)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r5 = "User-Agent"
                java.lang.String r8 = defpackage.GE.a()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r7.setRequestProperty(r5, r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                int r5 = r7.getResponseCode()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r8 = 200(0xc8, float:2.8E-43)
                if (r5 == r8) goto L_0x0072
                java.lang.String r8 = "PoW"
                java.lang.String r9 = "Failed to get PoW Params, HTTP response code: "
                java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r5 = r9.concat(r5)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.Throwable[] r9 = new java.lang.Throwable[r6]     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                defpackage.C1488xu.e(r4, r8, r5, r9)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r4 = r6
                goto L_0x00de
            L_0x0072:
                java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.io.InputStream r9 = r7.getInputStream()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r8.<init>(r9)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r5.<init>(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.StringBuffer r8 = new java.lang.StringBuffer     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r8.<init>()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
            L_0x0085:
                java.lang.String r9 = r5.readLine()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                if (r9 == 0) goto L_0x008f
                r8.append(r9)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                goto L_0x0085
            L_0x008f:
                r5.close()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r5.<init>(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r8 = "mode"
                int r8 = r5.getInt(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.c = r8     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r8 = "nonce"
                java.lang.String r8 = r5.getString(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.f339a = r8     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r8 = "ttl"
                long r8 = r5.getLong(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.f338a = r8     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r8 = "difficulty"
                long r8 = r5.getLong(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.f341b = r8     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r8 = "timeout"
                long r8 = r5.getLong(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.f344c = r8     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                if (r0 != 0) goto L_0x00cd
                java.lang.String r8 = "n"
                r5.getLong(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.getClass()     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
            L_0x00cd:
                java.lang.String r8 = "s_timeout"
                long r8 = r5.getLong(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.f347d = r8     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                java.lang.String r8 = "checksum"
                java.lang.String r5 = r5.getString(r8)     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r1.f342b = r5     // Catch:{ JSONException -> 0x00e4, Exception -> 0x00e2 }
                r4 = r2
            L_0x00de:
                r7.disconnect()
                goto L_0x012f
            L_0x00e2:
                r5 = move-exception
                goto L_0x00ed
            L_0x00e4:
                r5 = move-exception
                goto L_0x0110
            L_0x00e6:
                r0 = move-exception
                goto L_0x01d9
            L_0x00e9:
                r7 = move-exception
                r11 = r7
                r7 = r5
                r5 = r11
            L_0x00ed:
                java.lang.String r8 = "PoW"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d7 }
                java.lang.String r10 = "Exception:"
                r9.<init>(r10)     // Catch:{ all -> 0x01d7 }
                java.lang.String r10 = r5.toString()     // Catch:{ all -> 0x01d7 }
                r9.append(r10)     // Catch:{ all -> 0x01d7 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01d7 }
                java.lang.Throwable[] r10 = new java.lang.Throwable[r6]     // Catch:{ all -> 0x01d7 }
                defpackage.C1488xu.e(r4, r8, r9, r10)     // Catch:{ all -> 0x01d7 }
                r5.printStackTrace()     // Catch:{ all -> 0x01d7 }
                if (r7 == 0) goto L_0x012e
                goto L_0x012b
            L_0x010c:
                r7 = move-exception
                r11 = r7
                r7 = r5
                r5 = r11
            L_0x0110:
                java.lang.String r8 = "PoW"
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d7 }
                java.lang.String r10 = "JSONException:"
                r9.<init>(r10)     // Catch:{ all -> 0x01d7 }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01d7 }
                r9.append(r5)     // Catch:{ all -> 0x01d7 }
                java.lang.String r5 = r9.toString()     // Catch:{ all -> 0x01d7 }
                java.lang.Throwable[] r9 = new java.lang.Throwable[r6]     // Catch:{ all -> 0x01d7 }
                defpackage.C1488xu.e(r4, r8, r5, r9)     // Catch:{ all -> 0x01d7 }
                if (r7 == 0) goto L_0x012e
            L_0x012b:
                r7.disconnect()
            L_0x012e:
                r4 = r6
            L_0x012f:
                if (r4 != 0) goto L_0x014e
                r1.c()
                if (r0 != r2) goto L_0x013b
                r1.e(r6)
                goto L_0x01d6
            L_0x013b:
                int r3 = r1.b
                r4 = 10
                if (r3 >= r4) goto L_0x0149
                int r3 = r3 + r2
                r1.b = r3
                r2 = 5000(0x1388, double:2.4703E-320)
                r1.b(r0, r2)
            L_0x0149:
                r1.e(r6)
                goto L_0x01d6
            L_0x014e:
                int r2 = r1.c
                if (r2 == 0) goto L_0x01c9
                long r4 = android.os.SystemClock.uptimeMillis()
                r1.f349e = r4
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r4 = "null"
                r2.<init>(r4)
                long r4 = r1.f349e
                r2.append(r4)
                java.lang.String r4 = r1.f339a
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.f345c = r2
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r4 = "null;"
                r2.<init>(r4)
                long r4 = r1.f349e
                r2.append(r4)
                java.lang.String r4 = ";"
                r2.append(r4)
                java.lang.String r4 = r1.f339a
                r2.append(r4)
                java.lang.String r4 = ";"
                r2.append(r4)
                long r4 = r1.f341b
                r2.append(r4)
                java.lang.String r4 = ";"
                r2.append(r4)
                java.lang.String r4 = r1.f342b
                r2.append(r4)
                java.lang.String r2 = r2.toString()
                r1.f348d = r2
                long r4 = android.os.SystemClock.uptimeMillis()
                r1.f = r4
                r1.d = r6
                int r2 = r1.f337a
                if (r2 != r3) goto L_0x01b9
                java.lang.String r0 = "PoW"
                java.lang.String r2 = "Cancel Get Params"
                java.lang.Throwable[] r3 = new java.lang.Throwable[r6]
                r4 = 5
                defpackage.C1488xu.e(r4, r0, r2, r3)
                r1.i()
                goto L_0x01d6
            L_0x01b9:
                java.util.Timer r2 = new java.util.Timer
                r2.<init>()
                JE r3 = new JE
                r3.<init>(r1, r0)
                r4 = 100
                r2.schedule(r3, r4)
                goto L_0x01cc
            L_0x01c9:
                r1.e(r6)
            L_0x01cc:
                if (r0 != 0) goto L_0x01d6
                long r2 = r1.f338a
                r4 = 1000(0x3e8, double:4.94E-321)
                long r2 = r2 * r4
                r1.b(r0, r2)
            L_0x01d6:
                return
            L_0x01d7:
                r0 = move-exception
                r5 = r7
            L_0x01d9:
                if (r5 == 0) goto L_0x01de
                r5.disconnect()
            L_0x01de:
                throw r0
            L_0x01df:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x01df }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.IE.a.run():void");
        }
    }

    public IE(KE ke, int i) {
        this.a = ke;
        this.c = i;
    }

    public final void run() {
        new Thread(new a()).start();
    }
}
