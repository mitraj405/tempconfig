package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import defpackage.C1310ov;
import java.util.TreeMap;

/* renamed from: he  reason: default package and case insensitive filesystem */
/* compiled from: GenerateCheckSumTask */
public final class C1155he extends AsyncTask<String, Void, String> {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final Context f5475a;

    /* renamed from: a  reason: collision with other field name */
    public final String f5476a;

    /* renamed from: a  reason: collision with other field name */
    public final TreeMap<String, String> f5477a;

    /* renamed from: a  reason: collision with other field name */
    public final C1310ov.c f5478a;

    public C1155he(TreeMap treeMap, String str, Context context, C1310ov.c cVar) {
        this.f5477a = treeMap;
        this.f5475a = context;
        this.f5478a = cVar;
        this.f5476a = str;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static synchronized java.lang.String a(java.util.TreeMap<java.lang.String, java.lang.String> r7) {
        /*
            java.lang.Class<he> r0 = defpackage.C1155he.class
            monitor-enter(r0)
            java.lang.String r1 = "{"
            java.lang.Class<qp> r2 = defpackage.C1354qp.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x006b }
            monitor-exit(r2)     // Catch:{ Exception -> 0x006b }
            java.util.Set r2 = r7.keySet()     // Catch:{ Exception -> 0x006b }
            java.lang.Class<qp> r3 = defpackage.C1354qp.class
            monitor-enter(r3)     // Catch:{ Exception -> 0x006b }
            monitor-exit(r3)     // Catch:{ Exception -> 0x006b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x006b }
        L_0x0015:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x006b }
            if (r3 == 0) goto L_0x0051
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x006b }
            java.lang.Object r4 = r7.get(r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = r3.trim()     // Catch:{ Exception -> 0x006b }
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x006b }
            monitor-exit(r5)     // Catch:{ Exception -> 0x006b }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006b }
            r5.<init>()     // Catch:{ Exception -> 0x006b }
            r5.append(r1)     // Catch:{ Exception -> 0x006b }
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch:{ Exception -> 0x006b }
            r5.append(r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "\":\""
            r5.append(r3)     // Catch:{ Exception -> 0x006b }
            r5.append(r4)     // Catch:{ Exception -> 0x006b }
            java.lang.String r3 = "\","
            r5.append(r3)     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x006b }
            goto L_0x0015
        L_0x0051:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006b }
            r7.<init>()     // Catch:{ Exception -> 0x006b }
            r7.append(r1)     // Catch:{ Exception -> 0x006b }
            java.lang.String r2 = "}"
            r7.append(r2)     // Catch:{ Exception -> 0x006b }
            java.lang.String r1 = r7.toString()     // Catch:{ Exception -> 0x006b }
            java.lang.String r7 = ",}"
            java.lang.String r2 = "}"
            java.lang.String r7 = r1.replace(r7, r2)     // Catch:{ Exception -> 0x006b }
            goto L_0x0070
        L_0x006b:
            java.lang.Class<qp> r7 = defpackage.C1354qp.class
            monitor-enter(r7)     // Catch:{ all -> 0x0072 }
            monitor-exit(r7)     // Catch:{ all -> 0x0072 }
            r7 = r1
        L_0x0070:
            monitor-exit(r0)
            return r7
        L_0x0072:
            r7 = move-exception
            monitor-exit(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1155he.a(java.util.TreeMap):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String b(java.util.TreeMap<java.lang.String, java.lang.String> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.StringBuffer r0 = new java.lang.StringBuffer     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r0.<init>()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.util.Set r1 = r6.keySet()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r2 = 1
        L_0x0013:
            boolean r3 = r1.hasNext()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r1.next()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            if (r2 == 0) goto L_0x0023
            r2 = 0
            goto L_0x0028
        L_0x0023:
            java.lang.String r4 = "&"
            r0.append(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
        L_0x0028:
            r0.append(r3)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.String r4 = "="
            r0.append(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r0.append(r3)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            goto L_0x0013
        L_0x003a:
            java.lang.Class<qp> r6 = defpackage.C1354qp.class
            monitor-enter(r6)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            monitor-exit(r5)
            return r6
        L_0x0044:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0047:
            monitor-exit(r5)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1155he.b(java.util.TreeMap):java.lang.String");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e2 A[SYNTHETIC, Splitter:B:73:0x00e2] */
    public final java.lang.Object doInBackground(java.lang.Object[] r9) {
        /*
            r8 = this;
            java.lang.String[] r9 = (java.lang.String[]) r9
            monitor-enter(r8)
            java.lang.String r9 = ""
            java.lang.String r0 = ""
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x010a }
            r1.<init>()     // Catch:{ all -> 0x010a }
            r2 = 0
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r4 = r8.f5476a     // Catch:{ Exception -> 0x00d6 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x00d6 }
            r3.toString()     // Catch:{ Exception -> 0x00d6 }
            java.lang.Class<qp> r4 = defpackage.C1354qp.class
            monitor-enter(r4)     // Catch:{ Exception -> 0x00d6 }
            monitor-exit(r4)     // Catch:{ Exception -> 0x00d6 }
            java.net.URLConnection r4 = r3.openConnection()     // Catch:{ Exception -> 0x00d6 }
            java.lang.Object r4 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r4)     // Catch:{ Exception -> 0x00d6 }
            java.net.URLConnection r4 = (java.net.URLConnection) r4     // Catch:{ Exception -> 0x00d6 }
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d4 }
            boolean r3 = android.webkit.URLUtil.isHttpsUrl(r3)     // Catch:{ Exception -> 0x00d4 }
            if (r3 == 0) goto L_0x004a
            java.lang.Class<qp> r3 = defpackage.C1354qp.class
            monitor-enter(r3)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r3)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r3 = defpackage.C1354qp.class
            monitor-enter(r3)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r3)     // Catch:{ Exception -> 0x00d4 }
            r3 = r4
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ Exception -> 0x00d4 }
            oz r5 = new oz     // Catch:{ Exception -> 0x00d4 }
            r5.<init>()     // Catch:{ Exception -> 0x00d4 }
            r3.setSSLSocketFactory(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r3 = defpackage.C1354qp.class
            monitor-enter(r3)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r3)     // Catch:{ Exception -> 0x00d4 }
        L_0x004a:
            r3 = 1
            r4.setDoOutput(r3)     // Catch:{ Exception -> 0x00d4 }
            r3 = r4
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r5 = "POST"
            r3.setRequestMethod(r5)     // Catch:{ Exception -> 0x00d4 }
            java.util.TreeMap<java.lang.String, java.lang.String> r3 = r8.f5477a     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = r8.b(r3)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x00d4 }
            if (r3 == 0) goto L_0x00e0
            int r5 = r3.length()     // Catch:{ Exception -> 0x00d4 }
            if (r5 <= 0) goto L_0x00e0
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x00d4 }
            java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ Exception -> 0x00d4 }
            java.io.OutputStream r6 = r4.getOutputStream()     // Catch:{ Exception -> 0x00d4 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r6 = defpackage.C1354qp.class
            monitor-enter(r6)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x00d4 }
            r5.print(r3)     // Catch:{ Exception -> 0x00d4 }
            r5.close()     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r3 = defpackage.C1354qp.class
            monitor-enter(r3)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r3)     // Catch:{ Exception -> 0x00d4 }
            r3 = r4
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ Exception -> 0x00d4 }
            int r3 = r3.getResponseCode()     // Catch:{ Exception -> 0x00d4 }
            r5 = r4
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00d4 }
            r5.getResponseMessage()     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x00d4 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 != r5) goto L_0x00d2
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x00d4 }
            java.util.Scanner r5 = new java.util.Scanner     // Catch:{ Exception -> 0x00d4 }
            java.io.InputStream r6 = r4.getInputStream()     // Catch:{ Exception -> 0x00d4 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r6 = defpackage.C1354qp.class
            monitor-enter(r6)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x00d4 }
        L_0x00ad:
            boolean r6 = r5.hasNextLine()     // Catch:{ Exception -> 0x00d4 }
            if (r6 == 0) goto L_0x00c7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d4 }
            r6.<init>()     // Catch:{ Exception -> 0x00d4 }
            r6.append(r9)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r7 = r5.nextLine()     // Catch:{ Exception -> 0x00d4 }
            r6.append(r7)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r9 = r6.toString()     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00ad
        L_0x00c7:
            java.lang.Class<qp> r6 = defpackage.C1354qp.class
            monitor-enter(r6)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x00d4 }
            r5.close()     // Catch:{ Exception -> 0x00d4 }
            java.lang.Class<qp> r5 = defpackage.C1354qp.class
            monitor-enter(r5)     // Catch:{ Exception -> 0x00d4 }
            monitor-exit(r5)     // Catch:{ Exception -> 0x00d4 }
        L_0x00d2:
            r2 = r3
            goto L_0x00e0
        L_0x00d4:
            r0 = move-exception
            goto L_0x00d8
        L_0x00d6:
            r0 = move-exception
            r4 = 0
        L_0x00d8:
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x010a }
            java.lang.Class<qp> r3 = defpackage.C1354qp.class
            monitor-enter(r3)     // Catch:{ all -> 0x010a }
            monitor-exit(r3)     // Catch:{ all -> 0x010a }
        L_0x00e0:
            if (r4 == 0) goto L_0x00e7
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x00eb }
            r4.disconnect()     // Catch:{ Exception -> 0x00eb }
        L_0x00e7:
            java.lang.Class<qp> r3 = defpackage.C1354qp.class
            monitor-enter(r3)     // Catch:{ Exception -> 0x00eb }
            monitor-exit(r3)     // Catch:{ Exception -> 0x00eb }
        L_0x00eb:
            java.lang.String r3 = "error"
            r1.putOpt(r3, r0)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r0 = "errorCode"
            r1.put(r0, r2)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r0 = "response"
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0100 }
            r2.<init>(r9)     // Catch:{ Exception -> 0x0100 }
            r1.put(r0, r2)     // Catch:{ Exception -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x010a }
        L_0x0104:
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x010a }
            monitor-exit(r8)
            return r9
        L_0x010a:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1155he.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPostExecute(java.lang.Object r2) {
        /*
            r1 = this;
            java.lang.String r2 = (java.lang.String) r2
            monitor-enter(r1)
            ov$c r0 = r1.f5478a     // Catch:{ Exception -> 0x000c, all -> 0x0009 }
            r0.onPostResponse((java.lang.String) r2)     // Catch:{ Exception -> 0x000c, all -> 0x0009 }
            goto L_0x000c
        L_0x0009:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x000c:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1155he.onPostExecute(java.lang.Object):void");
    }
}
