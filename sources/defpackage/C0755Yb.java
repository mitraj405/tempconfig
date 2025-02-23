package defpackage;

import android.app.Activity;
import android.os.AsyncTask;
import org.json.JSONObject;

/* renamed from: Yb  reason: default package and case insensitive filesystem */
/* compiled from: FetchBankListAsynctask */
public final class C0755Yb extends AsyncTask<String, Void, JSONObject> {
    public final Ln a;

    /* renamed from: a  reason: collision with other field name */
    public final Activity f3860a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3861a;
    public String b = "";

    public C0755Yb(Activity activity, String str) {
        this.f3861a = str;
        this.f3860a = activity;
        try {
            this.a = (Ln) activity;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b0, code lost:
        if (r1 != null) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object doInBackground(java.lang.Object[] r5) {
        /*
            r4 = this;
            java.lang.String[] r5 = (java.lang.String[]) r5
            r5 = 0
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r1.<init>()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r2 = defpackage.C1488xu.i()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r3 = "/HANDLER_INTERNAL/BANK_LIST?"
            java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r1.append(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r2 = r4.f3861a     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r1.append(r2)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.net.URLConnection r1 = r0.openConnection()     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00ab, all -> 0x00a9 }
            r2 = 1
            r1.setDoOutput(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00a7 }
            boolean r0 = android.webkit.URLUtil.isHttpsUrl(r0)     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x0059
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x00a7 }
            r0 = r1
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x00a7 }
            oz r2 = new oz     // Catch:{ Exception -> 0x00a7 }
            r2.<init>()     // Catch:{ Exception -> 0x00a7 }
            r0.setSSLSocketFactory(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x00a7 }
        L_0x0059:
            int r0 = r1.getResponseCode()     // Catch:{ Exception -> 0x00a7 }
            r1.getResponseMessage()     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<qp> r2 = defpackage.C1354qp.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<qp> r2 = defpackage.C1354qp.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r2)     // Catch:{ Exception -> 0x00a7 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L_0x00b2
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x00a7 }
            java.util.Scanner r0 = new java.util.Scanner     // Catch:{ Exception -> 0x00a7 }
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x00a7 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<qp> r2 = defpackage.C1354qp.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r2)     // Catch:{ Exception -> 0x00a7 }
        L_0x007d:
            boolean r2 = r0.hasNextLine()     // Catch:{ Exception -> 0x00a7 }
            if (r2 == 0) goto L_0x009b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r2.<init>()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = r4.b     // Catch:{ Exception -> 0x00a7 }
            r2.append(r3)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = r0.nextLine()     // Catch:{ Exception -> 0x00a7 }
            r2.append(r3)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00a7 }
            r4.b = r2     // Catch:{ Exception -> 0x00a7 }
            goto L_0x007d
        L_0x009b:
            r0.close()     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ Exception -> 0x00a7 }
            monitor-exit(r0)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00b2
        L_0x00a7:
            r0 = move-exception
            goto L_0x00ad
        L_0x00a9:
            r0 = move-exception
            goto L_0x00b9
        L_0x00ab:
            r0 = move-exception
            r1 = r5
        L_0x00ad:
            r0.printStackTrace()     // Catch:{ all -> 0x00b6 }
            if (r1 == 0) goto L_0x00b5
        L_0x00b2:
            r1.disconnect()
        L_0x00b5:
            return r5
        L_0x00b6:
            r5 = move-exception
            r0 = r5
            r5 = r1
        L_0x00b9:
            if (r5 == 0) goto L_0x00be
            r5.disconnect()
        L_0x00be:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0755Yb.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    public final void onPostExecute(Object obj) {
        super.onPostExecute((JSONObject) obj);
        this.a.OnBankListFetchResponse(this.b);
    }

    public final void onPreExecute() {
        super.onPreExecute();
    }
}
