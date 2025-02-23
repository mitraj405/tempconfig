package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.cyberfend.cyfsecurity.CCADialogActivity;
import defpackage.FE;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: HE  reason: default package */
public final class HE extends KE {
    public static final HE a = new HE();

    /* renamed from: a  reason: collision with other field name */
    public FE.a f260a;
    public String f;
    public String g = "";

    /* renamed from: HE$a */
    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v26, resolved type: java.net.HttpURLConnection} */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x017d, code lost:
            if (r5 == null) goto L_0x0182;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0140 A[Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129, all -> 0x01af }] */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0155 A[Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129, all -> 0x01af }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x016a A[Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129, all -> 0x01af }] */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x0187  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01b3  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r12 = this;
                HE r0 = defpackage.HE.this
                java.lang.String r1 = r0.f350e
                java.lang.String r2 = "payload"
                java.lang.String r3 = "HE"
                r4 = 3
                r0.e(r4)
                java.lang.String r5 = "null/_sec/cp_challenge/verify"
                r6 = 6
                r7 = 0
                r8 = 0
                java.net.URL r9 = new java.net.URL     // Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129 }
                r9.<init>(r5)     // Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129 }
                java.net.URLConnection r5 = r9.openConnection()     // Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129 }
                java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129 }
                java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ MalformedURLException -> 0x016b, ProtocolException -> 0x0156, IOException -> 0x0141, JSONException -> 0x012c, all -> 0x0129 }
                r9 = 10000(0x2710, float:1.4013E-41)
                r5.setReadTimeout(r9)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r9 = 15000(0x3a98, float:2.102E-41)
                r5.setConnectTimeout(r9)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r9 = "POST"
                r5.setRequestMethod(r9)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r5.setUseCaches(r8)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r9 = "Content-Type"
                java.lang.String r10 = "application/json"
                r5.setRequestProperty(r9, r10)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r9 = "User-Agent"
                java.lang.String r10 = defpackage.GE.a()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r5.setRequestProperty(r9, r10)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r9.<init>()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r10 = "pow_response"
                r9.put(r10, r1)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r1 = "context"
                java.lang.String r10 = r0.f     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r9.put(r1, r10)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r9.toString()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.io.OutputStream r10 = r5.getOutputStream()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r1.<init>(r10)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r9 = r9.toString()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r10 = "UTF-8"
                byte[] r9 = r9.getBytes(r10)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r1.write(r9)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r1.flush()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r1.close()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                int r1 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r9 = 200(0xc8, float:2.8E-43)
                if (r1 != r9) goto L_0x0116
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.io.InputStream r10 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r9.<init>(r10)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r1.<init>(r9)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r9.<init>()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
            L_0x008f:
                java.lang.String r10 = r1.readLine()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                if (r10 == 0) goto L_0x0099
                r9.append(r10)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                goto L_0x008f
            L_0x0099:
                r1.close()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r9 = r9.toString()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r1.<init>(r9)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                java.lang.String r9 = "success"
                boolean r9 = r1.getBoolean(r9)     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                int r10 = r0.f337a     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                if (r10 == r4) goto L_0x00c1
                java.lang.String r1 = "Cancel Verify"
                java.lang.Throwable[] r2 = new java.lang.Throwable[r8]     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r10 = 5
                defpackage.C1488xu.e(r10, r3, r1, r2)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                FE$a r1 = r0.f260a     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                FE r1 = defpackage.FE.this     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                FE r2 = defpackage.FE.a     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r1.getClass()     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                goto L_0x0109
            L_0x00c1:
                if (r9 == 0) goto L_0x00d5
                java.lang.String r2 = "token"
                r1.getString(r2)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r0.getClass()     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                java.lang.System.currentTimeMillis()     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                long r1 = r0.f338a     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r0.getClass()     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r8 = r9
                goto L_0x011c
            L_0x00d5:
                boolean r10 = r1.has(r2)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                if (r10 == 0) goto L_0x011c
                java.lang.String r1 = r1.getString(r2)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r0.g = r1     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                FE$a r1 = r0.f260a     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                FE r1 = defpackage.FE.this     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r2 = 0
                r1.f200a = r2     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                com.cyberfend.cyfsecurity.CCADialogActivity$a r1 = r1.f201a     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r1.getClass()     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                int r10 = com.cyberfend.cyfsecurity.CCADialogActivity.c     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                android.os.Handler r10 = new android.os.Handler     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                android.os.Looper r11 = android.os.Looper.getMainLooper()     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r10.<init>(r11)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                com.cyberfend.cyfsecurity.a r11 = new com.cyberfend.cyfsecurity.a     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r11.<init>(r1, r2)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r10.post(r11)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r0.e(r8)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
                r1 = 100
                r10 = 1
                r0.b(r10, r1)     // Catch:{ MalformedURLException -> 0x0114, ProtocolException -> 0x0112, IOException -> 0x0110, JSONException -> 0x010e }
            L_0x0109:
                r5.disconnect()
                goto L_0x01ac
            L_0x010e:
                r1 = move-exception
                goto L_0x012f
            L_0x0110:
                r1 = move-exception
                goto L_0x0144
            L_0x0112:
                r1 = move-exception
                goto L_0x0159
            L_0x0114:
                r1 = move-exception
                goto L_0x016e
            L_0x0116:
                r5.getResponseMessage()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
                r0.getClass()     // Catch:{ MalformedURLException -> 0x0127, ProtocolException -> 0x0125, IOException -> 0x0123, JSONException -> 0x0121 }
            L_0x011c:
                r5.disconnect()
                goto L_0x0183
            L_0x0121:
                r1 = move-exception
                goto L_0x012e
            L_0x0123:
                r1 = move-exception
                goto L_0x0143
            L_0x0125:
                r1 = move-exception
                goto L_0x0158
            L_0x0127:
                r1 = move-exception
                goto L_0x016d
            L_0x0129:
                r0 = move-exception
                goto L_0x01b1
            L_0x012c:
                r1 = move-exception
                r5 = r7
            L_0x012e:
                r9 = r8
            L_0x012f:
                java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x01af }
                java.lang.Throwable[] r8 = new java.lang.Throwable[r8]     // Catch:{ all -> 0x01af }
                defpackage.C1488xu.e(r6, r3, r2, r8)     // Catch:{ all -> 0x01af }
                r0.getClass()     // Catch:{ all -> 0x01af }
                r1.printStackTrace()     // Catch:{ all -> 0x01af }
                if (r5 == 0) goto L_0x0182
                goto L_0x017f
            L_0x0141:
                r1 = move-exception
                r5 = r7
            L_0x0143:
                r9 = r8
            L_0x0144:
                java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x01af }
                java.lang.Throwable[] r8 = new java.lang.Throwable[r8]     // Catch:{ all -> 0x01af }
                defpackage.C1488xu.e(r6, r3, r2, r8)     // Catch:{ all -> 0x01af }
                r0.getClass()     // Catch:{ all -> 0x01af }
                r1.printStackTrace()     // Catch:{ all -> 0x01af }
                if (r5 == 0) goto L_0x0182
                goto L_0x017f
            L_0x0156:
                r1 = move-exception
                r5 = r7
            L_0x0158:
                r9 = r8
            L_0x0159:
                java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x01af }
                java.lang.Throwable[] r8 = new java.lang.Throwable[r8]     // Catch:{ all -> 0x01af }
                defpackage.C1488xu.e(r6, r3, r2, r8)     // Catch:{ all -> 0x01af }
                r0.getClass()     // Catch:{ all -> 0x01af }
                r1.printStackTrace()     // Catch:{ all -> 0x01af }
                if (r5 == 0) goto L_0x0182
                goto L_0x017f
            L_0x016b:
                r1 = move-exception
                r5 = r7
            L_0x016d:
                r9 = r8
            L_0x016e:
                java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x01af }
                java.lang.Throwable[] r8 = new java.lang.Throwable[r8]     // Catch:{ all -> 0x01af }
                defpackage.C1488xu.e(r6, r3, r2, r8)     // Catch:{ all -> 0x01af }
                r0.getClass()     // Catch:{ all -> 0x01af }
                r1.printStackTrace()     // Catch:{ all -> 0x01af }
                if (r5 == 0) goto L_0x0182
            L_0x017f:
                r5.disconnect()
            L_0x0182:
                r8 = r9
            L_0x0183:
                int r1 = r0.f337a
                if (r1 != r4) goto L_0x01a3
                if (r8 == 0) goto L_0x0196
                FE$a r0 = r0.f260a
                r0.getClass()
                FE r1 = defpackage.FE.a
                FE r0 = defpackage.FE.this
                r0.getClass()
                throw r7
            L_0x0196:
                FE$a r0 = r0.f260a
                r0.getClass()
                FE r1 = defpackage.FE.a
                FE r0 = defpackage.FE.this
                r0.getClass()
                throw r7
            L_0x01a3:
                FE$a r0 = r0.f260a
                FE r0 = defpackage.FE.this
                FE r1 = defpackage.FE.a
                r0.getClass()
            L_0x01ac:
                HE r0 = defpackage.HE.a
                return
            L_0x01af:
                r0 = move-exception
                r7 = r5
            L_0x01b1:
                if (r7 == 0) goto L_0x01b6
                r7.disconnect()
            L_0x01b6:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.HE.a.run():void");
        }
    }

    public HE() {
        System.currentTimeMillis();
    }

    public final void a(int i) {
        float f2 = ((float) i) / 10.0f;
        FE fe = FE.this;
        fe.f200a = f2;
        CCADialogActivity.a aVar = fe.f201a;
        aVar.getClass();
        int i2 = CCADialogActivity.c;
        new Handler(Looper.getMainLooper()).post(new com.cyberfend.cyfsecurity.a(aVar, f2));
    }

    public final void c() {
        C1488xu.e(6, "HE", "Error: ".concat("Get Params error"), new Throwable[0]);
        FE fe = FE.this;
        FE fe2 = FE.a;
        fe.getClass();
        FE.a aVar = this.f260a;
        aVar.getClass();
        FE.this.getClass();
        throw null;
    }

    public final String g() {
        StringBuilder sb = new StringBuilder("null/_bm/get_params?type=sdk-cca");
        try {
            String str = this.f;
            if (str != null) {
                if (!str.equals("")) {
                    sb.append("&context=");
                    sb.append(URLEncoder.encode(this.f, "UTF-8"));
                }
            }
            String str2 = this.g;
            if (str2 != null && !str2.equals("")) {
                sb.append("&payload=");
                sb.append(URLEncoder.encode(this.g, "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.g = "";
        return sb.toString();
    }

    public final void h() {
        new Thread(new a()).start();
    }

    public final void i() {
        FE fe = FE.this;
        FE fe2 = FE.a;
        fe.getClass();
        FE.a aVar = this.f260a;
        aVar.getClass();
        FE.this.getClass();
        throw null;
    }
}
