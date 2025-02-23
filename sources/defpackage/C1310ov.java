package defpackage;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.paytm.pgsdk.sdknative.modal.BaseResponseModal;
import java.io.IOException;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ov  reason: default package and case insensitive filesystem */
/* compiled from: SdkHttpRequest */
public final class C1310ov extends AsyncTask<String, Void, BaseResponseModal> {
    public static final ConcurrentHashMap<a, C1310ov> a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    public final int f6876a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f6877a;

    /* renamed from: a  reason: collision with other field name */
    public final BaseResponseModal f6878a;

    /* renamed from: a  reason: collision with other field name */
    public final b f6879a;

    /* renamed from: a  reason: collision with other field name */
    public final c f6880a;

    /* renamed from: ov$a */
    /* compiled from: SdkHttpRequest */
    public class a {
        public String a;
    }

    /* renamed from: ov$b */
    /* compiled from: SdkHttpRequest */
    public interface b {
        HashMap<String, String> a();

        Object b();

        String getRequestUrl();
    }

    /* renamed from: ov$c */
    /* compiled from: SdkHttpRequest */
    public interface c {
        void onPostResponse(BaseResponseModal baseResponseModal);

        void onPostResponse(String str);

        void postHttpError(BaseResponseModal baseResponseModal);
    }

    public C1310ov(Context context, BaseResponseModal baseResponseModal, c cVar, b bVar, int i) {
        this.f6877a = context;
        this.f6880a = cVar;
        this.f6879a = bVar;
        this.f6878a = baseResponseModal;
        this.f6876a = i;
    }

    public static void a(URLConnection uRLConnection, HashMap hashMap) {
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            uRLConnection.addRequestProperty(entry.getKey().toString(), entry.getValue().toString());
            it.remove();
        }
    }

    public static BaseResponseModal b(Gson gson, BaseResponseModal baseResponseModal, StringBuilder sb, URLConnection uRLConnection, int i) throws IOException {
        Scanner scanner = new Scanner(uRLConnection.getInputStream());
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        synchronized (C1354qp.class) {
        }
        scanner.close();
        if (TextUtils.isEmpty(sb.toString())) {
            return baseResponseModal;
        }
        BaseResponseModal baseResponseModal2 = (BaseResponseModal) gson.fromJson(sb.toString(), baseResponseModal.getClass());
        baseResponseModal2.errorCode = i;
        return baseResponseModal2;
    }

    public static void c() {
        ConcurrentHashMap<a, C1310ov> concurrentHashMap = a;
        if (concurrentHashMap != null) {
            try {
                for (a aVar : concurrentHashMap.keySet()) {
                    concurrentHashMap.get(aVar).cancel(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(String str) {
        C1310ov ovVar = a.get(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.net.URLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v38, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: javax.net.ssl.HttpsURLConnection} */
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
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:175:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public final java.lang.Object doInBackground(java.lang.Object[] r10) {
        /*
            r9 = this;
            java.lang.String[] r10 = (java.lang.String[]) r10
            android.content.Context r10 = r9.f6877a
            r0 = 1
            java.lang.String r1 = "connectivity"
            java.lang.Object r10 = r10.getSystemService(r1)     // Catch:{ Exception -> 0x001b }
            android.net.ConnectivityManager r10 = (android.net.ConnectivityManager) r10     // Catch:{ Exception -> 0x001b }
            android.net.NetworkInfo r10 = r10.getActiveNetworkInfo()     // Catch:{ Exception -> 0x001b }
            if (r10 == 0) goto L_0x001b
            boolean r10 = r10.isConnected()     // Catch:{ Exception -> 0x001b }
            if (r10 == 0) goto L_0x001b
            r10 = r0
            goto L_0x001c
        L_0x001b:
            r10 = 0
        L_0x001c:
            r1 = 0
            if (r10 == 0) goto L_0x0260
            int r10 = r9.f6876a
            r2 = 200(0xc8, float:2.8E-43)
            if (r10 != r0) goto L_0x0186
            ov$b r10 = r9.f6879a
            if (r10 != 0) goto L_0x002b
            goto L_0x0260
        L_0x002b:
            com.google.gson.Gson r10 = new com.google.gson.Gson
            r10.<init>()
            com.paytm.pgsdk.sdknative.modal.BaseResponseModal r3 = r9.f6878a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x013a, all -> 0x0137 }
            ov$b r6 = r9.f6879a     // Catch:{ Exception -> 0x013a, all -> 0x0137 }
            java.lang.String r6 = r6.getRequestUrl()     // Catch:{ Exception -> 0x013a, all -> 0x0137 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x013a, all -> 0x0137 }
            android.content.Context r6 = r9.f6877a     // Catch:{ Exception -> 0x0135 }
            if (r6 == 0) goto L_0x006c
            ov$a r7 = new ov$a     // Catch:{ Exception -> 0x0135 }
            r7.<init>()     // Catch:{ Exception -> 0x0135 }
            java.lang.Class r6 = r6.getClass()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ Exception -> 0x0135 }
            r7.a = r6     // Catch:{ Exception -> 0x0135 }
            java.lang.String r6 = r5.toString()     // Catch:{ Exception -> 0x0135 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0135 }
            if (r6 != 0) goto L_0x006c
            java.lang.String r6 = r7.a     // Catch:{ Exception -> 0x0135 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0135 }
            if (r6 != 0) goto L_0x006c
            java.util.concurrent.ConcurrentHashMap<ov$a, ov> r6 = a     // Catch:{ Exception -> 0x0135 }
            r6.put(r7, r9)     // Catch:{ Exception -> 0x0135 }
        L_0x006c:
            r5.toString()     // Catch:{ Exception -> 0x0135 }
            java.lang.Class<qp> r6 = defpackage.C1354qp.class
            monitor-enter(r6)     // Catch:{ Exception -> 0x0135 }
            monitor-exit(r6)     // Catch:{ Exception -> 0x0135 }
            java.net.URLConnection r6 = r5.openConnection()     // Catch:{ Exception -> 0x0135 }
            java.lang.Object r6 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r6)     // Catch:{ Exception -> 0x0135 }
            java.net.URLConnection r6 = (java.net.URLConnection) r6     // Catch:{ Exception -> 0x0135 }
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.String r1 = r5.toString()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            boolean r1 = android.webkit.URLUtil.isHttpsUrl(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            if (r1 == 0) goto L_0x00a2
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r1 = r6
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            oz r7 = new oz     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r7.<init>()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r1.setSSLSocketFactory(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
        L_0x00a2:
            r6.setDoOutput(r0)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r1 = r6
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.String r7 = "POST"
            r1.setRequestMethod(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            ov$b r1 = r9.f6879a     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.util.HashMap r1 = r1.a()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            if (r1 == 0) goto L_0x00ca
            ov$b r1 = r9.f6879a     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.util.HashMap r1 = r1.a()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            if (r1 <= 0) goto L_0x00ca
            ov$b r1 = r9.f6879a     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.util.HashMap r1 = r1.a()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            a(r6, r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
        L_0x00ca:
            ov$b r1 = r9.f6879a     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Object r1 = r1.b()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Class<qp> r7 = defpackage.C1354qp.class
            monitor-enter(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            if (r1 == 0) goto L_0x0123
            int r7 = r1.length()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            if (r7 <= 0) goto L_0x0123
            java.lang.Class<qp> r7 = defpackage.C1354qp.class
            monitor-enter(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.io.PrintWriter r7 = new java.io.PrintWriter     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.io.OutputStream r8 = r6.getOutputStream()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Class<qp> r8 = defpackage.C1354qp.class
            monitor-enter(r8)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r8)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r7.print(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r7.close()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r1 = r6
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            int r1 = r1.getResponseCode()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r7 = r6
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r7.getResponseMessage()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Class<qp> r7 = defpackage.C1354qp.class
            monitor-enter(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.Class<qp> r7 = defpackage.C1354qp.class
            monitor-enter(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            monitor-exit(r7)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            if (r1 != r2) goto L_0x0123
            com.paytm.pgsdk.sdknative.modal.BaseResponseModal r3 = b(r10, r3, r4, r6, r1)     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            boolean r10 = r3 instanceof com.paytm.pgsdk.sdknative.modal.ResponseConvinenceFee     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            if (r10 == 0) goto L_0x0123
            r10 = r3
            com.paytm.pgsdk.sdknative.modal.ResponseConvinenceFee r10 = (com.paytm.pgsdk.sdknative.modal.ResponseConvinenceFee) r10     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0130, all -> 0x012d }
            r10.jsonObject = r1     // Catch:{ Exception -> 0x0130, all -> 0x012d }
        L_0x0123:
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6
            r6.disconnect()
            java.lang.Class<qp> r10 = defpackage.C1354qp.class
            monitor-enter(r10)
            monitor-exit(r10)
            goto L_0x0167
        L_0x012d:
            r10 = move-exception
            r1 = r6
            goto L_0x0171
        L_0x0130:
            r10 = move-exception
            r1 = r6
            goto L_0x013c
        L_0x0133:
            r10 = move-exception
            goto L_0x0171
        L_0x0135:
            r10 = move-exception
            goto L_0x013c
        L_0x0137:
            r10 = move-exception
            r5 = r1
            goto L_0x0171
        L_0x013a:
            r10 = move-exception
            r5 = r1
        L_0x013c:
            boolean r2 = r10 instanceof java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0133 }
            if (r2 == 0) goto L_0x014d
            android.content.Context r2 = r9.f6877a     // Catch:{ all -> 0x0133 }
            if (r2 == 0) goto L_0x014d
            java.lang.String r4 = "Unable to connect to Paytm. Please check with merchant."
            android.widget.Toast r0 = android.widget.Toast.makeText(r2, r4, r0)     // Catch:{ all -> 0x0133 }
            r0.show()     // Catch:{ all -> 0x0133 }
        L_0x014d:
            r10.printStackTrace()     // Catch:{ all -> 0x0133 }
            ov$c r0 = r9.f6880a     // Catch:{ all -> 0x0133 }
            if (r0 == 0) goto L_0x015a
            java.lang.String r10 = r10.getMessage()     // Catch:{ all -> 0x0133 }
            r3.error = r10     // Catch:{ all -> 0x0133 }
        L_0x015a:
            if (r1 == 0) goto L_0x0161
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            r1.disconnect()
        L_0x0161:
            java.lang.Class<qp> r10 = defpackage.C1354qp.class
            monitor-enter(r10)
            monitor-exit(r10)
            if (r5 == 0) goto L_0x016e
        L_0x0167:
            java.lang.String r10 = r5.toString()
            d(r10)
        L_0x016e:
            r1 = r3
            goto L_0x0260
        L_0x0171:
            if (r1 == 0) goto L_0x0178
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
            r1.disconnect()
        L_0x0178:
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)
            monitor-exit(r0)
            if (r5 == 0) goto L_0x0185
            java.lang.String r0 = r5.toString()
            d(r0)
        L_0x0185:
            throw r10
        L_0x0186:
            r3 = 2
            if (r10 != r3) goto L_0x0260
            ov$b r10 = r9.f6879a
            java.lang.String r10 = r10.getRequestUrl()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            com.paytm.pgsdk.sdknative.modal.BaseResponseModal r5 = r9.f6878a
            java.net.URL r6 = new java.net.URL     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            r6.<init>(r10)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            java.net.URLConnection r7 = r6.openConnection()     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x021d, all -> 0x021b }
            java.lang.String r1 = r6.toString()     // Catch:{ Exception -> 0x0219 }
            boolean r1 = android.webkit.URLUtil.isHttpsUrl(r1)     // Catch:{ Exception -> 0x0219 }
            if (r1 == 0) goto L_0x01cd
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0219 }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0219 }
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0219 }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0219 }
            r1 = r7
            javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ Exception -> 0x0219 }
            oz r6 = new oz     // Catch:{ Exception -> 0x0219 }
            r6.<init>()     // Catch:{ Exception -> 0x0219 }
            r1.setSSLSocketFactory(r6)     // Catch:{ Exception -> 0x0219 }
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x0219 }
            monitor-exit(r1)     // Catch:{ Exception -> 0x0219 }
        L_0x01cd:
            ov$b r1 = r9.f6879a     // Catch:{ Exception -> 0x0219 }
            java.util.HashMap r1 = r1.a()     // Catch:{ Exception -> 0x0219 }
            if (r1 == 0) goto L_0x01ea
            ov$b r1 = r9.f6879a     // Catch:{ Exception -> 0x0219 }
            java.util.HashMap r1 = r1.a()     // Catch:{ Exception -> 0x0219 }
            int r1 = r1.size()     // Catch:{ Exception -> 0x0219 }
            if (r1 <= 0) goto L_0x01ea
            ov$b r1 = r9.f6879a     // Catch:{ Exception -> 0x0219 }
            java.util.HashMap r1 = r1.a()     // Catch:{ Exception -> 0x0219 }
            a(r7, r1)     // Catch:{ Exception -> 0x0219 }
        L_0x01ea:
            java.lang.String r1 = "GET"
            r7.setRequestMethod(r1)     // Catch:{ Exception -> 0x0219 }
            int r1 = r7.getResponseCode()     // Catch:{ Exception -> 0x0219 }
            if (r1 != r2) goto L_0x020f
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0219 }
            java.io.InputStream r6 = r7.getInputStream()     // Catch:{ Exception -> 0x0219 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0219 }
            com.paytm.pgsdk.sdknative.modal.BaseResponseModal r5 = b(r4, r5, r3, r7, r1)     // Catch:{ Exception -> 0x0219 }
            boolean r1 = r5 instanceof com.paytm.pgsdk.sdknative.modal.ResponseConvinenceFee     // Catch:{ Exception -> 0x0219 }
            if (r1 == 0) goto L_0x020f
            r1 = r5
            com.paytm.pgsdk.sdknative.modal.ResponseConvinenceFee r1 = (com.paytm.pgsdk.sdknative.modal.ResponseConvinenceFee) r1     // Catch:{ Exception -> 0x0219 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0219 }
            r1.jsonObject = r2     // Catch:{ Exception -> 0x0219 }
        L_0x020f:
            r7.disconnect()
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)
            monitor-exit(r0)
            if (r10 == 0) goto L_0x024d
            goto L_0x024a
        L_0x0219:
            r1 = move-exception
            goto L_0x0220
        L_0x021b:
            r0 = move-exception
            goto L_0x0251
        L_0x021d:
            r2 = move-exception
            r7 = r1
            r1 = r2
        L_0x0220:
            boolean r2 = r1 instanceof java.util.concurrent.TimeoutException     // Catch:{ all -> 0x024f }
            if (r2 == 0) goto L_0x0232
            android.content.Context r2 = r9.f6877a     // Catch:{ all -> 0x024f }
            if (r2 == 0) goto L_0x0232
            java.lang.String r3 = "Unable to connect to Paytm. Please check with merchant."
            android.widget.Toast r0 = android.widget.Toast.makeText(r2, r3, r0)     // Catch:{ all -> 0x024f }
            r0.show()     // Catch:{ all -> 0x024f }
        L_0x0232:
            r1.printStackTrace()     // Catch:{ all -> 0x024f }
            ov$c r0 = r9.f6880a     // Catch:{ all -> 0x024f }
            if (r0 == 0) goto L_0x023f
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x024f }
            r5.error = r0     // Catch:{ all -> 0x024f }
        L_0x023f:
            if (r7 == 0) goto L_0x0244
            r7.disconnect()
        L_0x0244:
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)
            monitor-exit(r0)
            if (r10 == 0) goto L_0x024d
        L_0x024a:
            d(r10)
        L_0x024d:
            r1 = r5
            goto L_0x0260
        L_0x024f:
            r0 = move-exception
            r1 = r7
        L_0x0251:
            if (r1 == 0) goto L_0x0256
            r1.disconnect()
        L_0x0256:
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)
            monitor-exit(r1)
            if (r10 == 0) goto L_0x025f
            d(r10)
        L_0x025f:
            throw r0
        L_0x0260:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1310ov.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public final void onPostExecute(Object obj) {
        BaseResponseModal baseResponseModal = (BaseResponseModal) obj;
        super.onPostExecute(baseResponseModal);
        c cVar = this.f6880a;
        if (cVar == null || baseResponseModal == null || baseResponseModal.errorCode != 200) {
            cVar.postHttpError(baseResponseModal);
        } else {
            cVar.onPostResponse(baseResponseModal);
        }
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
