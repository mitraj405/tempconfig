package com.momagic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* compiled from: RestClient */
public final class B {

    /* compiled from: RestClient */
    public class a implements Runnable {
        public final /* synthetic */ b a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Map f4000a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ JSONObject f4001a;
        public final /* synthetic */ int c;

        /* renamed from: c  reason: collision with other field name */
        public final /* synthetic */ String f4002c;
        public final /* synthetic */ String d;

        public a(String str, String str2, Map map, JSONObject jSONObject, b bVar, int i) {
            this.f4002c = str;
            this.d = str2;
            this.f4000a = map;
            this.f4001a = jSONObject;
            this.a = bVar;
            this.c = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:118:0x022a  */
        /* JADX WARNING: Removed duplicated region for block: B:154:0x02af A[SYNTHETIC, Splitter:B:154:0x02af] */
        /* JADX WARNING: Removed duplicated region for block: B:168:0x02df  */
        /* JADX WARNING: Removed duplicated region for block: B:173:0x02eb A[LOOP:0: B:1:0x0014->B:173:0x02eb, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0085 A[SYNTHETIC, Splitter:B:21:0x0085] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f0  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0167 A[Catch:{ all -> 0x0151, all -> 0x0159, all -> 0x017b }] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0193 A[SYNTHETIC, Splitter:B:96:0x0193] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r22 = this;
                r1 = r22
                java.lang.String r2 = r1.f4002c
                com.momagic.B$b r3 = r1.a
                int r4 = r1.c
                java.lang.String r5 = "[Log.V]->URL"
                java.lang.String r6 = "->"
                r7 = 0
                r0 = -1
                r9 = r0
                r10 = r7
                r12 = r10
                r11 = 0
                r13 = 0
                r14 = 0
            L_0x0014:
                if (r10 == 0) goto L_0x002f
                r0 = 2000(0x7d0, float:2.803E-42)
                r16 = r9
                long r8 = (long) r0
                java.lang.Thread.sleep(r8)     // Catch:{ InterruptedException -> 0x001f }
                goto L_0x0031
            L_0x001f:
                r0 = move-exception
                r8 = r0
                android.content.Context r0 = com.momagic.C0835h.f4046a
                java.lang.String r8 = r8.toString()
                java.lang.String r9 = "Util"
                java.lang.String r15 = "sleepTime"
                com.momagic.H.r(r0, r8, r9, r15)
                goto L_0x0031
            L_0x002f:
                r16 = r9
            L_0x0031:
                java.lang.String r0 = "https:"
                boolean r0 = r2.contains(r0)     // Catch:{ all -> 0x02a2 }
                if (r0 != 0) goto L_0x006d
                java.lang.String r0 = "http:"
                boolean r0 = r2.contains(r0)     // Catch:{ all -> 0x02a2 }
                if (r0 != 0) goto L_0x006d
                java.lang.String r0 = "impr.izooto.com"
                boolean r0 = r2.contains(r0)     // Catch:{ all -> 0x02a2 }
                if (r0 == 0) goto L_0x004a
                goto L_0x006d
            L_0x004a:
                java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x02a2 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
                r9.<init>()     // Catch:{ all -> 0x02a2 }
                java.lang.String r8 = "https://aevents.izooto.com/app"
                r9.append(r8)     // Catch:{ all -> 0x02a2 }
                r9.append(r2)     // Catch:{ all -> 0x02a2 }
                java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x02a2 }
                r0.<init>(r8)     // Catch:{ all -> 0x02a2 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ all -> 0x02a2 }
                java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ all -> 0x02a2 }
                java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ all -> 0x02a2 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x02a2 }
                goto L_0x007e
            L_0x006d:
                java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x02a2 }
                r0.<init>(r2)     // Catch:{ all -> 0x02a2 }
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ all -> 0x02a2 }
                java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ all -> 0x02a2 }
                java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ all -> 0x02a2 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ all -> 0x02a2 }
            L_0x007e:
                r13 = r0
                java.util.Map r0 = r1.f4000a
                java.lang.String r8 = "UTF-8"
                if (r0 == 0) goto L_0x00d1
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a2 }
                r9.<init>()     // Catch:{ all -> 0x02a2 }
                java.util.Set r11 = r0.entrySet()     // Catch:{ all -> 0x00cb }
                java.util.Iterator r11 = r11.iterator()     // Catch:{ all -> 0x00cb }
            L_0x0092:
                boolean r17 = r11.hasNext()     // Catch:{ all -> 0x00cb }
                if (r17 == 0) goto L_0x00c9
                java.lang.Object r17 = r11.next()     // Catch:{ all -> 0x00cb }
                java.util.Map$Entry r17 = (java.util.Map.Entry) r17     // Catch:{ all -> 0x00cb }
                int r18 = r9.length()     // Catch:{ all -> 0x00cb }
                if (r18 == 0) goto L_0x00a9
                r15 = 38
                r9.append(r15)     // Catch:{ all -> 0x00cb }
            L_0x00a9:
                java.lang.Object r15 = r17.getKey()     // Catch:{ all -> 0x00cb }
                java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x00cb }
                java.lang.String r15 = java.net.URLEncoder.encode(r15, r8)     // Catch:{ all -> 0x00cb }
                r9.append(r15)     // Catch:{ all -> 0x00cb }
                r15 = 61
                r9.append(r15)     // Catch:{ all -> 0x00cb }
                java.lang.Object r15 = r17.getValue()     // Catch:{ all -> 0x00cb }
                java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x00cb }
                java.lang.String r15 = java.net.URLEncoder.encode(r15, r8)     // Catch:{ all -> 0x00cb }
                r9.append(r15)     // Catch:{ all -> 0x00cb }
                goto L_0x0092
            L_0x00c9:
                r11 = r9
                goto L_0x00d1
            L_0x00cb:
                r0 = move-exception
                r19 = r4
            L_0x00ce:
                r7 = 1
                goto L_0x02a8
            L_0x00d1:
                r13.setUseCaches(r7)     // Catch:{ all -> 0x029b }
                r13.setConnectTimeout(r4)     // Catch:{ all -> 0x029b }
                r13.setReadTimeout(r4)     // Catch:{ all -> 0x029b }
                org.json.JSONObject r9 = r1.f4001a
                if (r9 == 0) goto L_0x00e8
                r15 = 1
                r13.setDoInput(r15)     // Catch:{ all -> 0x00e3 }
                goto L_0x00e8
            L_0x00e3:
                r0 = move-exception
                r19 = r4
                r4 = 1
                goto L_0x010e
            L_0x00e8:
                java.lang.String r15 = r1.d
                java.lang.String r7 = "application/x-www-form-urlencoded"
                java.lang.String r1 = "Content-Type"
                if (r15 == 0) goto L_0x0114
                r19 = r4
                java.lang.String r4 = "POST"
                boolean r4 = r15.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0111 }
                if (r4 == 0) goto L_0x0100
                if (r9 != 0) goto L_0x0100
                r13.setRequestProperty(r1, r7)     // Catch:{ all -> 0x0111 }
                goto L_0x0105
            L_0x0100:
                java.lang.String r4 = "application/json; charset=UTF-8"
                r13.setRequestProperty(r1, r4)     // Catch:{ all -> 0x0111 }
            L_0x0105:
                r13.setRequestMethod(r15)     // Catch:{ all -> 0x0111 }
                r4 = 1
                r13.setDoOutput(r4)     // Catch:{ all -> 0x010d }
                goto L_0x0117
            L_0x010d:
                r0 = move-exception
            L_0x010e:
                r7 = r4
                goto L_0x02a9
            L_0x0111:
                r0 = move-exception
                r1 = 0
                goto L_0x017c
            L_0x0114:
                r19 = r4
                r4 = 1
            L_0x0117:
                if (r15 == 0) goto L_0x0164
                if (r11 == 0) goto L_0x0164
                java.lang.String r15 = r11.toString()     // Catch:{ all -> 0x015f }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0111 }
                byte[] r4 = r15.getBytes(r4)     // Catch:{ all -> 0x0111 }
                int r15 = r4.length     // Catch:{ all -> 0x0111 }
                r13.setFixedLengthStreamingMode(r15)     // Catch:{ all -> 0x0111 }
                r13.setRequestProperty(r1, r7)     // Catch:{ all -> 0x0111 }
                java.lang.String r1 = "charset"
                java.lang.String r7 = "utf-8"
                r13.setRequestProperty(r1, r7)     // Catch:{ all -> 0x0111 }
                java.lang.String r1 = "Content-Length"
                java.lang.String r7 = java.lang.Integer.toString(r15)     // Catch:{ all -> 0x0111 }
                r13.setRequestProperty(r1, r7)     // Catch:{ all -> 0x0111 }
                r1 = 0
                r13.setInstanceFollowRedirects(r1)     // Catch:{ all -> 0x017b }
                r13.setUseCaches(r1)     // Catch:{ all -> 0x017b }
                r13.connect()     // Catch:{ all -> 0x017b }
                java.io.OutputStream r7 = r13.getOutputStream()     // Catch:{ all -> 0x017b }
                r7.write(r4)     // Catch:{ all -> 0x0151 }
                r7.close()     // Catch:{ all -> 0x017b }
                goto L_0x0165
            L_0x0151:
                r0 = move-exception
                r4 = r0
                if (r7 == 0) goto L_0x015e
                r7.close()     // Catch:{ all -> 0x0159 }
                goto L_0x015e
            L_0x0159:
                r0 = move-exception
                r7 = r0
                r4.addSuppressed(r7)     // Catch:{ all -> 0x017b }
            L_0x015e:
                throw r4     // Catch:{ all -> 0x017b }
            L_0x015f:
                r0 = move-exception
                r1 = 0
                r9 = r11
                goto L_0x00ce
            L_0x0164:
                r1 = 0
            L_0x0165:
                if (r9 == 0) goto L_0x017f
                java.lang.String r4 = r9.toString()     // Catch:{ all -> 0x017b }
                byte[] r4 = r4.getBytes(r8)     // Catch:{ all -> 0x017b }
                int r7 = r4.length     // Catch:{ all -> 0x017b }
                r13.setFixedLengthStreamingMode(r7)     // Catch:{ all -> 0x017b }
                java.io.OutputStream r7 = r13.getOutputStream()     // Catch:{ all -> 0x017b }
                r7.write(r4)     // Catch:{ all -> 0x017b }
                goto L_0x017f
            L_0x017b:
                r0 = move-exception
            L_0x017c:
                r7 = 1
                goto L_0x02a7
            L_0x017f:
                int r4 = r13.getResponseCode()     // Catch:{ all -> 0x0296 }
                java.lang.String r7 = ""
                java.lang.String r15 = "\\A"
                java.lang.String r1 = ".dat"
                r16 = r7
                java.lang.String r7 = "https://cdn.izooto.com/app/app_"
                r20 = r10
                r10 = 200(0xc8, float:2.8E-43)
                if (r4 != r10) goto L_0x022a
                android.content.Context r10 = com.momagic.C0835h.f4046a     // Catch:{ all -> 0x0226 }
                r21 = r11
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
                r11.<init>()     // Catch:{ all -> 0x0283 }
                r11.append(r6)     // Catch:{ all -> 0x0283 }
                r11.append(r2)     // Catch:{ all -> 0x0283 }
                java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0283 }
                defpackage.C1104f8.b(r10, r11, r5)     // Catch:{ all -> 0x0283 }
                if (r0 == 0) goto L_0x01bf
                android.content.Context r10 = com.momagic.C0835h.f4046a     // Catch:{ all -> 0x0283 }
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
                r11.<init>()     // Catch:{ all -> 0x0283 }
                r11.append(r6)     // Catch:{ all -> 0x0283 }
                r11.append(r0)     // Catch:{ all -> 0x0283 }
                java.lang.String r0 = r11.toString()     // Catch:{ all -> 0x0283 }
                defpackage.C1104f8.b(r10, r0, r5)     // Catch:{ all -> 0x0283 }
            L_0x01bf:
                if (r9 == 0) goto L_0x01d9
                android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ all -> 0x0283 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
                r10.<init>()     // Catch:{ all -> 0x0283 }
                r10.append(r6)     // Catch:{ all -> 0x0283 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0283 }
                r10.append(r9)     // Catch:{ all -> 0x0283 }
                java.lang.String r9 = r10.toString()     // Catch:{ all -> 0x0283 }
                defpackage.C1104f8.b(r0, r9, r5)     // Catch:{ all -> 0x0283 }
            L_0x01d9:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
                r0.<init>()     // Catch:{ all -> 0x0283 }
                r0.append(r7)     // Catch:{ all -> 0x0283 }
                java.lang.String r7 = com.momagic.C0835h.b     // Catch:{ all -> 0x0283 }
                r0.append(r7)     // Catch:{ all -> 0x0283 }
                r0.append(r1)     // Catch:{ all -> 0x0283 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0283 }
                r2.equals(r0)     // Catch:{ all -> 0x0283 }
                java.io.InputStream r0 = r13.getInputStream()     // Catch:{ all -> 0x0283 }
                java.util.Scanner r1 = new java.util.Scanner     // Catch:{ all -> 0x0283 }
                r1.<init>(r0, r8)     // Catch:{ all -> 0x0283 }
                java.util.Scanner r0 = r1.useDelimiter(r15)     // Catch:{ all -> 0x0283 }
                boolean r0 = r0.hasNext()     // Catch:{ all -> 0x0283 }
                if (r0 == 0) goto L_0x0208
                java.lang.String r7 = r1.next()     // Catch:{ all -> 0x0283 }
                goto L_0x020a
            L_0x0208:
                r7 = r16
            L_0x020a:
                r1.close()     // Catch:{ all -> 0x0223 }
                if (r3 == 0) goto L_0x021f
                y1 r0 = defpackage.C1492y1.a()     // Catch:{ all -> 0x0223 }
                java.util.concurrent.ExecutorService r0 = r0.b     // Catch:{ all -> 0x0223 }
                zq r1 = new zq     // Catch:{ all -> 0x0223 }
                r8 = 8
                r1.<init>(r8, r3, r7)     // Catch:{ all -> 0x0223 }
                r0.execute(r1)     // Catch:{ all -> 0x0223 }
            L_0x021f:
                r10 = r20
                goto L_0x028c
            L_0x0223:
                r0 = move-exception
                r14 = r7
                goto L_0x0284
            L_0x0226:
                r0 = move-exception
                r21 = r11
                goto L_0x0284
            L_0x022a:
                r21 = r11
                int r12 = r12 + 1
                r9 = 4
                if (r12 < r9) goto L_0x0289
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0283 }
                r0.<init>()     // Catch:{ all -> 0x0283 }
                r0.append(r7)     // Catch:{ all -> 0x0283 }
                java.lang.String r7 = com.momagic.C0835h.b     // Catch:{ all -> 0x0283 }
                r0.append(r7)     // Catch:{ all -> 0x0283 }
                r0.append(r1)     // Catch:{ all -> 0x0283 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0283 }
                r2.equals(r0)     // Catch:{ all -> 0x0283 }
                java.io.InputStream r0 = r13.getErrorStream()     // Catch:{ all -> 0x0283 }
                if (r0 != 0) goto L_0x0252
                java.io.InputStream r0 = r13.getInputStream()     // Catch:{ all -> 0x0283 }
            L_0x0252:
                if (r0 == 0) goto L_0x026e
                java.util.Scanner r1 = new java.util.Scanner     // Catch:{ all -> 0x0283 }
                r1.<init>(r0, r8)     // Catch:{ all -> 0x0283 }
                java.util.Scanner r0 = r1.useDelimiter(r15)     // Catch:{ all -> 0x0283 }
                boolean r0 = r0.hasNext()     // Catch:{ all -> 0x0283 }
                if (r0 == 0) goto L_0x0269
                java.lang.String r0 = r1.next()     // Catch:{ all -> 0x0283 }
                r14 = r0
                goto L_0x026b
            L_0x0269:
                r14 = r16
            L_0x026b:
                r1.close()     // Catch:{ all -> 0x0283 }
            L_0x026e:
                if (r3 == 0) goto L_0x0289
                y1 r0 = defpackage.C1492y1.a()     // Catch:{ all -> 0x0283 }
                java.util.concurrent.ExecutorService r0 = r0.b     // Catch:{ all -> 0x0283 }
                uB r1 = new uB     // Catch:{ all -> 0x0283 }
                r7 = 0
                r1.<init>((com.momagic.B.b) r3, (int) r4, (java.lang.String) r14, (java.lang.Throwable) r7)     // Catch:{ all -> 0x0283 }
                r7 = 1
                r0.execute(r1)     // Catch:{ all -> 0x0281 }
                goto L_0x028a
            L_0x0281:
                r0 = move-exception
                goto L_0x0285
            L_0x0283:
                r0 = move-exception
            L_0x0284:
                r7 = 1
            L_0x0285:
                r9 = r4
                r11 = r21
                goto L_0x02ab
            L_0x0289:
                r7 = 1
            L_0x028a:
                r10 = r7
                r7 = r14
            L_0x028c:
                r13.disconnect()
                r9 = r4
                r14 = r7
                r11 = r21
                r1 = 4
                r8 = 0
                goto L_0x02e4
            L_0x0296:
                r0 = move-exception
            L_0x0297:
                r21 = r11
                r7 = 1
                goto L_0x029f
            L_0x029b:
                r0 = move-exception
                r19 = r4
                goto L_0x0297
            L_0x029f:
                r11 = r21
                goto L_0x02a7
            L_0x02a2:
                r0 = move-exception
                r19 = r4
                goto L_0x017c
            L_0x02a7:
                r9 = r11
            L_0x02a8:
                r11 = r9
            L_0x02a9:
                r9 = r16
            L_0x02ab:
                int r12 = r12 + r7
                r1 = 4
                if (r12 < r1) goto L_0x02cf
                boolean r1 = r0 instanceof java.net.ConnectException     // Catch:{ all -> 0x02cd }
                if (r1 != 0) goto L_0x02bb
                boolean r1 = r0 instanceof java.net.UnknownHostException     // Catch:{ all -> 0x02cd }
                if (r1 == 0) goto L_0x02b8
                goto L_0x02bb
            L_0x02b8:
                r0.toString()     // Catch:{ all -> 0x02cd }
            L_0x02bb:
                if (r3 == 0) goto L_0x02cf
                y1 r1 = defpackage.C1492y1.a()     // Catch:{ all -> 0x02cd }
                java.util.concurrent.ExecutorService r1 = r1.b     // Catch:{ all -> 0x02cd }
                uB r4 = new uB     // Catch:{ all -> 0x02cd }
                r8 = 0
                r4.<init>((com.momagic.B.b) r3, (int) r9, (java.lang.String) r8, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02cd }
                r1.execute(r4)     // Catch:{ all -> 0x02cd }
                goto L_0x02d0
            L_0x02cd:
                r0 = move-exception
                goto L_0x02f3
            L_0x02cf:
                r8 = 0
            L_0x02d0:
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ all -> 0x02cd }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02cd }
                java.lang.String r4 = "RestClient"
                java.lang.String r10 = "startHTTPConnection"
                com.momagic.H.r(r1, r0, r4, r10)     // Catch:{ all -> 0x02cd }
                if (r13 == 0) goto L_0x02e2
                r13.disconnect()
            L_0x02e2:
                r10 = r7
                r1 = 4
            L_0x02e4:
                if (r12 >= r1) goto L_0x02f2
                r1 = 200(0xc8, float:2.8E-43)
                if (r9 != r1) goto L_0x02eb
                goto L_0x02f2
            L_0x02eb:
                r1 = r22
                r4 = r19
                r7 = 0
                goto L_0x0014
            L_0x02f2:
                return
            L_0x02f3:
                if (r13 == 0) goto L_0x02f8
                r13.disconnect()
            L_0x02f8:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.momagic.B.a.run():void");
        }
    }

    /* compiled from: RestClient */
    public static class b {
        public void a(int i, String str) {
            throw null;
        }

        public void b(String str) {
            throw null;
        }
    }

    public static void a(b bVar, String str) {
        new Thread(new y(bVar, str)).start();
    }

    public static void b(String str, String str2, Map<String, String> map, JSONObject jSONObject, b bVar, int i) {
        Executors.newSingleThreadExecutor().submit(new a(str, str2, map, jSONObject, bVar, i));
    }

    public static void c(String str, HashMap hashMap, JSONObject jSONObject, b bVar) {
        new Thread(new A(str, hashMap, jSONObject, bVar)).start();
    }
}
