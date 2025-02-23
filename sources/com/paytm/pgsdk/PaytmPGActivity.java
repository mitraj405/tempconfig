package com.paytm.pgsdk;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.easypay.EasypayBrowserFragment;
import com.paytm.easypay.EasypayLoaderService;
import com.paytm.pgsdk.sdknative.LoginActivity;
import com.paytm.pgsdk.sdknative.PaytmPaymentActivity;
import com.paytm.pgsdk.sdknative.modal.Tokens;
import in.juspay.hypersdk.core.PaymentConstants;

public class PaytmPGActivity extends Activity implements View.OnClickListener {
    public static e a;

    /* renamed from: a  reason: collision with other field name */
    public Intent f4099a;

    /* renamed from: a  reason: collision with other field name */
    public volatile Bundle f4100a;

    /* renamed from: a  reason: collision with other field name */
    public View f4101a;

    /* renamed from: a  reason: collision with other field name */
    public ImageView f4102a;

    /* renamed from: a  reason: collision with other field name */
    public EasypayBrowserFragment f4103a;

    /* renamed from: a  reason: collision with other field name */
    public a f4104a;

    /* renamed from: a  reason: collision with other field name */
    public volatile d f4105a;

    /* renamed from: a  reason: collision with other field name */
    public volatile PaytmWebView f4106a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4107a;
    public Intent b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f4108b;
    public boolean c;

    public class b implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public b(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ AlertDialog a;

        public c(AlertDialog alertDialog) {
            this.a = alertDialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
            PaytmPGActivity.this.onBackPressed();
        }
    }

    public class d extends AsyncTask<String, Void, String> {
        public d() {
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
        /* JADX WARNING: Removed duplicated region for block: B:65:0x00d4 A[SYNTHETIC, Splitter:B:65:0x00d4] */
        public final java.lang.Object doInBackground(java.lang.Object[] r5) {
            /*
                r4 = this;
                java.lang.String[] r5 = (java.lang.String[]) r5
                monitor-enter(r4)
                java.lang.String r0 = ""
                java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00c8 }
                r2 = 0
                r5 = r5[r2]     // Catch:{ Exception -> 0x00c8 }
                r1.<init>(r5)     // Catch:{ Exception -> 0x00c8 }
                r1.toString()     // Catch:{ Exception -> 0x00c8 }
                java.lang.Class<qp> r5 = defpackage.C1354qp.class
                monitor-enter(r5)     // Catch:{ Exception -> 0x00c8 }
                monitor-exit(r5)     // Catch:{ Exception -> 0x00c8 }
                java.net.URLConnection r5 = r1.openConnection()     // Catch:{ Exception -> 0x00c8 }
                java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ Exception -> 0x00c8 }
                java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ Exception -> 0x00c8 }
                java.lang.Class<qp> r2 = defpackage.C1354qp.class
                monitor-enter(r2)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r2)     // Catch:{ Exception -> 0x00c6 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00c6 }
                boolean r1 = android.webkit.URLUtil.isHttpsUrl(r1)     // Catch:{ Exception -> 0x00c6 }
                if (r1 == 0) goto L_0x0043
                java.lang.Class<qp> r1 = defpackage.C1354qp.class
                monitor-enter(r1)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r1)     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r1 = defpackage.C1354qp.class
                monitor-enter(r1)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r1)     // Catch:{ Exception -> 0x00c6 }
                r1 = r5
                javax.net.ssl.HttpsURLConnection r1 = (javax.net.ssl.HttpsURLConnection) r1     // Catch:{ Exception -> 0x00c6 }
                oz r2 = new oz     // Catch:{ Exception -> 0x00c6 }
                r2.<init>()     // Catch:{ Exception -> 0x00c6 }
                r1.setSSLSocketFactory(r2)     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r1 = defpackage.C1354qp.class
                monitor-enter(r1)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r1)     // Catch:{ Exception -> 0x00c6 }
            L_0x0043:
                r1 = 1
                r5.setDoOutput(r1)     // Catch:{ Exception -> 0x00c6 }
                r1 = r5
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00c6 }
                java.lang.String r2 = "POST"
                r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00c6 }
                com.paytm.pgsdk.PaytmPGActivity r1 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x00c6 }
                android.os.Bundle r1 = r1.f4100a     // Catch:{ Exception -> 0x00c6 }
                java.lang.String r1 = defpackage.C1354qp.U(r1)     // Catch:{ Exception -> 0x00c6 }
                if (r1 == 0) goto L_0x00d2
                int r2 = r1.length()     // Catch:{ Exception -> 0x00c6 }
                if (r2 <= 0) goto L_0x00d2
                java.lang.Class<qp> r2 = defpackage.C1354qp.class
                monitor-enter(r2)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r2)     // Catch:{ Exception -> 0x00c6 }
                java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ Exception -> 0x00c6 }
                java.io.OutputStream r3 = r5.getOutputStream()     // Catch:{ Exception -> 0x00c6 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r3 = defpackage.C1354qp.class
                monitor-enter(r3)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r3)     // Catch:{ Exception -> 0x00c6 }
                r2.print(r1)     // Catch:{ Exception -> 0x00c6 }
                r2.close()     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r1 = defpackage.C1354qp.class
                monitor-enter(r1)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r1)     // Catch:{ Exception -> 0x00c6 }
                r1 = r5
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00c6 }
                int r1 = r1.getResponseCode()     // Catch:{ Exception -> 0x00c6 }
                r2 = r5
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00c6 }
                r2.getResponseMessage()     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r2 = defpackage.C1354qp.class
                monitor-enter(r2)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r2)     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r2 = defpackage.C1354qp.class
                monitor-enter(r2)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r2)     // Catch:{ Exception -> 0x00c6 }
                r2 = 200(0xc8, float:2.8E-43)
                if (r1 != r2) goto L_0x00d2
                java.lang.Class<qp> r1 = defpackage.C1354qp.class
                monitor-enter(r1)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r1)     // Catch:{ Exception -> 0x00c6 }
                java.util.Scanner r1 = new java.util.Scanner     // Catch:{ Exception -> 0x00c6 }
                java.io.InputStream r2 = r5.getInputStream()     // Catch:{ Exception -> 0x00c6 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r2 = defpackage.C1354qp.class
                monitor-enter(r2)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r2)     // Catch:{ Exception -> 0x00c6 }
            L_0x00a4:
                boolean r2 = r1.hasNextLine()     // Catch:{ Exception -> 0x00c6 }
                if (r2 == 0) goto L_0x00be
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c6 }
                r2.<init>()     // Catch:{ Exception -> 0x00c6 }
                r2.append(r0)     // Catch:{ Exception -> 0x00c6 }
                java.lang.String r3 = r1.nextLine()     // Catch:{ Exception -> 0x00c6 }
                r2.append(r3)     // Catch:{ Exception -> 0x00c6 }
                java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x00c6 }
                goto L_0x00a4
            L_0x00be:
                r1.close()     // Catch:{ Exception -> 0x00c6 }
                java.lang.Class<qp> r1 = defpackage.C1354qp.class
                monitor-enter(r1)     // Catch:{ Exception -> 0x00c6 }
                monitor-exit(r1)     // Catch:{ Exception -> 0x00c6 }
                goto L_0x00d2
            L_0x00c6:
                r1 = move-exception
                goto L_0x00cb
            L_0x00c8:
                r5 = move-exception
                r1 = r5
                r5 = 0
            L_0x00cb:
                java.lang.Class<qp> r2 = defpackage.C1354qp.class
                monitor-enter(r2)     // Catch:{ all -> 0x00e4 }
                monitor-exit(r2)     // Catch:{ all -> 0x00e4 }
                defpackage.C1354qp.i0(r1)     // Catch:{ all -> 0x00e4 }
            L_0x00d2:
                if (r5 == 0) goto L_0x00d9
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x00de }
                r5.disconnect()     // Catch:{ Exception -> 0x00de }
            L_0x00d9:
                java.lang.Class<qp> r5 = defpackage.C1354qp.class
                monitor-enter(r5)     // Catch:{ Exception -> 0x00de }
                monitor-exit(r5)     // Catch:{ Exception -> 0x00de }
                goto L_0x00e2
            L_0x00de:
                r5 = move-exception
                defpackage.C1354qp.i0(r5)     // Catch:{ all -> 0x00e4 }
            L_0x00e2:
                monitor-exit(r4)
                return r0
            L_0x00e4:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaytmPGActivity.d.doInBackground(java.lang.Object[]):java.lang.Object");
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
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public final void onPostExecute(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.String r4 = (java.lang.String) r4
                monitor-enter(r3)
                if (r4 == 0) goto L_0x0092
                java.lang.String r0 = ""
                boolean r0 = r4.equalsIgnoreCase(r0)     // Catch:{ Exception -> 0x0035 }
                if (r0 != 0) goto L_0x0092
                java.lang.Class<qp> r0 = defpackage.C1354qp.class
                monitor-enter(r0)     // Catch:{ Exception -> 0x0035 }
                monitor-exit(r0)     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r0 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                boolean r4 = r0.d(r4)     // Catch:{ Exception -> 0x0035 }
                if (r4 == 0) goto L_0x007f
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                r4.getClass()     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmWebView r4 = r4.f4106a     // Catch:{ Exception -> 0x0035 }
                if (r4 != 0) goto L_0x0037
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmWebView r0 = new com.paytm.pgsdk.PaytmWebView     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r1 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                android.os.Bundle r2 = r1.f4100a     // Catch:{ Exception -> 0x0035 }
                r0.<init>(r1)     // Catch:{ Exception -> 0x0035 }
                r4.f4106a = r0     // Catch:{ Exception -> 0x0035 }
                goto L_0x0037
            L_0x0032:
                r4 = move-exception
                goto L_0x00c0
            L_0x0035:
                r4 = move-exception
                goto L_0x00a5
            L_0x0037:
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmWebView r4 = r4.f4106a     // Catch:{ Exception -> 0x0035 }
                r0 = 0
                r4.setVisibility(r0)     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmWebView r4 = r4.f4106a     // Catch:{ Exception -> 0x0035 }
                android.webkit.WebSettings r4 = r4.getSettings()     // Catch:{ Exception -> 0x0035 }
                r0 = 1
                r4.setDomStorageEnabled(r0)     // Catch:{ Exception -> 0x0035 }
                android.webkit.WebView.setWebContentsDebuggingEnabled(r0)     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmWebView r4 = r4.f4106a     // Catch:{ Exception -> 0x0035 }
                np r0 = defpackage.C1286np.a()     // Catch:{ Exception -> 0x0035 }
                java.lang.String r0 = r0.b     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r1 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                android.os.Bundle r1 = r1.f4100a     // Catch:{ Exception -> 0x0035 }
                java.lang.String r1 = defpackage.C1354qp.V(r1)     // Catch:{ Exception -> 0x0035 }
                byte[] r1 = r1.getBytes()     // Catch:{ Exception -> 0x0035 }
                r4.postUrl(r0, r1)     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmWebView r4 = r4.f4106a     // Catch:{ Exception -> 0x0035 }
                r0 = 130(0x82, float:1.82E-43)
                r4.requestFocus(r0)     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                monitor-enter(r4)     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPGActivity$a r0 = r4.f4104a     // Catch:{ all -> 0x007c }
                if (r0 == 0) goto L_0x007a
                r0.start()     // Catch:{ all -> 0x007c }
            L_0x007a:
                monitor-exit(r4)     // Catch:{ Exception -> 0x0035 }
                goto L_0x00be
            L_0x007c:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ Exception -> 0x0035 }
                throw r0     // Catch:{ Exception -> 0x0035 }
            L_0x007f:
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                r4.finish()     // Catch:{ Exception -> 0x0035 }
                np r4 = defpackage.C1286np.a()     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPaymentTransactionCallback r4 = r4.f5603a     // Catch:{ Exception -> 0x0035 }
                if (r4 == 0) goto L_0x00be
                java.lang.String r0 = "Client authentication failed. Please try again later."
                r4.clientAuthenticationFailed(r0)     // Catch:{ Exception -> 0x0035 }
                goto L_0x00be
            L_0x0092:
                com.paytm.pgsdk.PaytmPGActivity r4 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ Exception -> 0x0035 }
                r4.finish()     // Catch:{ Exception -> 0x0035 }
                np r4 = defpackage.C1286np.a()     // Catch:{ Exception -> 0x0035 }
                com.paytm.pgsdk.PaytmPaymentTransactionCallback r4 = r4.f5603a     // Catch:{ Exception -> 0x0035 }
                if (r4 == 0) goto L_0x00be
                java.lang.String r0 = "Client authentication failed due to server error. Please try again later."
                r4.clientAuthenticationFailed(r0)     // Catch:{ Exception -> 0x0035 }
                goto L_0x00be
            L_0x00a5:
                com.paytm.pgsdk.PaytmPGActivity r0 = com.paytm.pgsdk.PaytmPGActivity.this     // Catch:{ all -> 0x0032 }
                r0.finish()     // Catch:{ all -> 0x0032 }
                np r0 = defpackage.C1286np.a()     // Catch:{ all -> 0x0032 }
                com.paytm.pgsdk.PaytmPaymentTransactionCallback r0 = r0.f5603a     // Catch:{ all -> 0x0032 }
                if (r0 == 0) goto L_0x00b7
                java.lang.String r1 = "Some UI error occured in WebView of Payment Gateway Activity"
                r0.someUIErrorOccurred(r1)     // Catch:{ all -> 0x0032 }
            L_0x00b7:
                java.lang.Class<qp> r0 = defpackage.C1354qp.class
                monitor-enter(r0)     // Catch:{ all -> 0x0032 }
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                defpackage.C1354qp.i0(r4)     // Catch:{ all -> 0x0032 }
            L_0x00be:
                monitor-exit(r3)
                return
            L_0x00c0:
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaytmPGActivity.d.onPostExecute(java.lang.Object):void");
        }
    }

    public class e extends AlertDialog {
        public e(Context context) {
            super(context);
        }

        public final void show() {
            super.show();
            setContentView(C0697Tr.progress_dialog);
        }
    }

    public final void a(String str) {
        this.f4100a.putString("REQUEST_TYPE", "PAYTM_EXPRESS");
        this.f4100a.putString("PAYMENT_DETAILS", str);
        this.f4100a.putString("AUTH_MODE", "3D");
        this.f4100a.putString("PAYMENT_TYPE_ID", "DC");
        Intent intent = this.b;
        if (intent != null) {
            if (intent.getExtras().containsKey("IS_SAVED_CARD")) {
                this.f4100a.putString("IS_SAVED_CARD", C0515Ga.AVLBLTY_ONLY);
                this.f4100a.putString("SSO_TOKEN", Tokens.getValidateResponse().TokenDetails.TXN_TOKEN);
                this.f4100a.putString("PAYTM_TOKEN", Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
            }
            if (this.b.getExtras().containsKey("STORE_CARD")) {
                this.f4100a.putString("STORE_CARD", C0515Ga.AVLBLTY_ONLY);
                this.f4100a.putString("SSO_TOKEN", Tokens.getValidateResponse().TokenDetails.TXN_TOKEN);
                this.f4100a.putString("PAYTM_TOKEN", Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
            }
        }
        this.f4105a = new d();
        if (C1286np.a() != null) {
            this.f4105a.execute(new String[]{C1286np.a().f5604a});
        }
    }

    public final void b(String str) {
        this.f4100a.putString("REQUEST_TYPE", "PAYTM_EXPRESS");
        this.f4100a.putString("BANK_CODE", str);
        this.f4100a.putString("AUTH_MODE", "USRPWD");
        this.f4100a.putString("PAYMENT_TYPE_ID", "NB");
        this.f4100a.remove("transaction_amount");
        this.f4105a = new d();
        if (C1286np.a() != null) {
            this.f4105a.execute(new String[]{C1286np.a().f5604a});
        }
    }

    public final synchronized void c() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(C0697Tr.alert_back_dialog, (ViewGroup) null);
        builder.setView(inflate);
        AlertDialog create = builder.create();
        ((TextView) inflate.findViewById(C0501Er.bttn_no)).setOnClickListener(new b(create));
        ((TextView) inflate.findViewById(C0501Er.bttn_yes)).setOnClickListener(new c(create));
        create.show();
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
    public final synchronized boolean d(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x005a }
            monitor-exit(r1)     // Catch:{ Exception -> 0x005a }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x005a }
            r1.<init>(r6)     // Catch:{ Exception -> 0x005a }
            java.util.Iterator r6 = r1.keys()     // Catch:{ Exception -> 0x005a }
            java.lang.Class<qp> r2 = defpackage.C1354qp.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x005a }
            monitor-exit(r2)     // Catch:{ Exception -> 0x005a }
            java.lang.Class<qp> r2 = defpackage.C1354qp.class
            monitor-enter(r2)     // Catch:{ Exception -> 0x005a }
            monitor-exit(r2)     // Catch:{ Exception -> 0x005a }
        L_0x0017:
            boolean r2 = r6.hasNext()     // Catch:{ Exception -> 0x005a }
            if (r2 == 0) goto L_0x0062
            java.lang.Object r2 = r6.next()     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x005a }
            java.lang.String r3 = r1.getString(r2)     // Catch:{ Exception -> 0x005a }
            java.lang.String r2 = r2.trim()     // Catch:{ Exception -> 0x005a }
            java.lang.Class<qp> r4 = defpackage.C1354qp.class
            monitor-enter(r4)     // Catch:{ Exception -> 0x005a }
            monitor-exit(r4)     // Catch:{ Exception -> 0x005a }
            java.lang.String r4 = "CHECKSUMHASH"
            boolean r4 = r2.equals(r4)     // Catch:{ Exception -> 0x005a }
            if (r4 == 0) goto L_0x003d
            android.os.Bundle r4 = r5.f4100a     // Catch:{ Exception -> 0x005a }
            r4.putString(r2, r3)     // Catch:{ Exception -> 0x005a }
            goto L_0x0046
        L_0x003d:
            boolean r4 = r5.f4108b     // Catch:{ Exception -> 0x005a }
            if (r4 == 0) goto L_0x0046
            android.os.Bundle r4 = r5.f4100a     // Catch:{ Exception -> 0x005a }
            r4.putString(r2, r3)     // Catch:{ Exception -> 0x005a }
        L_0x0046:
            java.lang.String r4 = "payt_STATUS"
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x005a }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "1"
            boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x005a }
            if (r2 == 0) goto L_0x0017
            r0 = 1
            goto L_0x0017
        L_0x0058:
            r6 = move-exception
            goto L_0x0064
        L_0x005a:
            r6 = move-exception
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ all -> 0x0058 }
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            defpackage.C1354qp.i0(r6)     // Catch:{ all -> 0x0058 }
        L_0x0062:
            monitor-exit(r5)
            return r0
        L_0x0064:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaytmPGActivity.d(java.lang.String):boolean");
    }

    public final synchronized boolean e() {
        try {
            if (getIntent() != null) {
                this.f4107a = getIntent().getBooleanExtra("HIDE_HEADER", false);
                this.c = getIntent().getBooleanExtra("HIDE_ARROW", false);
                this.f4108b = getIntent().getBooleanExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", false);
            }
            setContentView(C0697Tr.payment_gateway_web_view);
            ImageView imageView = (ImageView) findViewById(C0501Er.header_back_button);
            this.f4102a = imageView;
            int i = C1073dl.a;
            if (i > 0) {
                imageView.setImageResource(i);
            }
            this.f4102a.setOnClickListener(this);
            this.f4101a = findViewById(C0501Er.tool_bar);
            Intent intent = new Intent(this, EasypayLoaderService.class);
            this.f4099a = intent;
            intent.putExtra("enableEasyPay", C1354qp.f6916a);
            startService(this.f4099a);
            e eVar = new e(this);
            a = eVar;
            eVar.getWindow().setGravity(17);
            synchronized (C1354qp.class) {
            }
            synchronized (C1354qp.class) {
            }
            this.f4103a = (EasypayBrowserFragment) getFragmentManager().findFragmentById(C0501Er.easypayBrowserFragment);
            if (this.c) {
                this.f4102a.setVisibility(8);
            } else {
                this.f4102a.setVisibility(0);
            }
            if (this.f4107a) {
                this.f4101a.setVisibility(8);
            } else {
                ActionBar actionBar = getActionBar();
                if (actionBar != null) {
                    actionBar.hide();
                }
            }
            synchronized (C1354qp.class) {
            }
        } catch (Exception e2) {
            synchronized (C1354qp.class) {
                C1354qp.i0(e2);
                return false;
            }
        }
        return true;
    }

    public final void f() {
        Intent intent = new Intent(this, PaytmPaymentActivity.class);
        intent.putExtra("cust_id", this.f4100a.getString("CUST_ID"));
        intent.putExtra("MID", this.f4100a.getString("MID"));
        intent.putExtra(PaymentConstants.AMOUNT, this.f4100a.getString("TXN_AMOUNT"));
        intent.putExtra(LoginActivity.MOBILE_KEY, this.f4100a.getString("MSISDN"));
        intent.putExtra("channel_id", this.f4100a.getString("CHANNEL_ID"));
        intent.putExtra("industry", this.f4100a.getString("INDUSTRY_TYPE_ID"));
        startActivityForResult(intent, 123);
    }

    public final synchronized void g() {
        synchronized (C1354qp.class) {
        }
        if (!(getIntent() == null || getIntent().getBundleExtra("Parameters") == null)) {
            this.f4100a = getIntent().getBundleExtra("Parameters");
            if (this.f4100a != null && this.f4100a.size() > 0) {
                synchronized (C1354qp.class) {
                }
                f();
            }
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        super.onActivityResult(i, i2, intent);
        if (i4 == -1 && i3 == 123 && intent2 != null) {
            String stringExtra = intent2.getStringExtra("flow");
            if (stringExtra.equalsIgnoreCase("CARD")) {
                a(intent2.getStringExtra("token"));
            } else if (stringExtra.equalsIgnoreCase("NB")) {
                b(intent2.getStringExtra("bank_code"));
            } else if (stringExtra.equalsIgnoreCase("cancel")) {
                onBackPressed();
            }
        } else {
            String str = "bank_code";
            if (i4 == -2 && i3 == 123 && intent2 != null) {
                this.b = intent2;
                try {
                    this.f4100a.putString("REQUEST_TYPE", "PAYTM_EXPRESS");
                    this.f4100a.putString("PAYMENT_DETAILS", "");
                    this.f4100a.putString("AUTH_MODE", "USRPWD");
                    this.f4100a.putString("PAYMENT_TYPE_ID", "PPI");
                    this.f4100a.putString("SSO_TOKEN", Tokens.getValidateResponse().TokenDetails.TXN_TOKEN);
                    this.f4100a.putString("PAYTM_TOKEN", Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
                    this.f4105a = new d();
                    if (C1286np.a() != null) {
                        this.f4105a.execute(new String[]{C1286np.a().f5604a});
                    }
                } catch (Exception unused) {
                }
            } else if (i4 == -3 && i3 == 123 && intent2 != null) {
                this.b = intent2;
                String stringExtra2 = intent2.getStringExtra("token");
                if (!this.b.getExtras().containsKey("flow")) {
                    return;
                }
                if (this.b.getExtras().getString("flow").equalsIgnoreCase("addPay")) {
                    String str2 = "PAYTM_TOKEN";
                    this.f4100a.putString("addMoney", C0515Ga.AVLBLTY_ONLY);
                    if (this.b.getExtras().getString("type").equalsIgnoreCase("CC")) {
                        this.f4100a.putString("PAYMENT_DETAILS", stringExtra2);
                        this.f4100a.putString("PAYMENT_TYPE_ID", "CC");
                        this.f4100a.putString("AUTH_MODE", "3D");
                        if (this.b.getExtras().containsKey("IS_SAVED_CARD")) {
                            this.f4100a.putString("IS_SAVED_CARD", C0515Ga.AVLBLTY_ONLY);
                        }
                        if (this.b.getExtras().containsKey("STORE_CARD")) {
                            this.f4100a.putString("STORE_CARD", C0515Ga.AVLBLTY_ONLY);
                        }
                    } else if (this.b.getExtras().getString("type").equalsIgnoreCase("NB")) {
                        this.f4100a.putString("BANK_CODE", this.b.getStringExtra(str));
                        this.f4100a.putString("PAYMENT_TYPE_ID", "NB");
                        this.f4100a.putString("AUTH_MODE", "USRPWD");
                    } else {
                        this.b.getExtras().getString("type").equalsIgnoreCase("savedcard");
                    }
                    this.f4100a.putString("REQUEST_TYPE", "PAYTM_EXPRESS");
                    this.f4100a.putString("SSO_TOKEN", Tokens.getValidateResponse().TokenDetails.TXN_TOKEN);
                    this.f4100a.putString(str2, Tokens.getValidateResponse().TokenDetails.PAYTM_TOKEN);
                    this.f4105a = new d();
                    if (C1286np.a() != null) {
                        this.f4105a.execute(new String[]{C1286np.a().f5604a});
                        return;
                    }
                    return;
                }
                String str3 = str;
                if (this.b.getExtras().getString("type").equalsIgnoreCase("CC")) {
                    a(stringExtra2);
                } else if (this.b.getExtras().getString("type").equalsIgnoreCase("NB")) {
                    b(this.b.getExtras().getString(str3));
                } else {
                    this.b.getExtras().getString("type").equalsIgnoreCase("savedcard");
                }
            }
        }
    }

    public final void onBackPressed() {
        try {
            C1286np.a().f5603a.onBackPressedCancelTransaction();
        } catch (Exception unused) {
        }
        a aVar = this.f4104a;
        if (aVar != null) {
            aVar.cancel();
        }
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view.getId() == C0501Er.header_back_button) {
            synchronized (C1354qp.class) {
            }
            c();
        }
    }

    public final synchronized void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (e()) {
            g();
        } else {
            finish();
            PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = C1286np.a().f5603a;
            if (paytmPaymentTransactionCallback != null) {
                paytmPaymentTransactionCallback.someUIErrorOccurred("Some error occured while initializing UI of Payment Gateway Activity");
            }
        }
        long j = (long) 480000;
        this.f4104a = new a(j, j);
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
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
    public final synchronized void onDestroy() {
        /*
            r3 = this;
            monitor-enter(r3)
            super.onDestroy()     // Catch:{ all -> 0x0044 }
            r0 = 0
            com.paytm.pgsdk.PaytmPGActivity$d r1 = r3.f4105a     // Catch:{ Exception -> 0x0021 }
            if (r1 == 0) goto L_0x000f
            com.paytm.pgsdk.PaytmPGActivity$d r1 = r3.f4105a     // Catch:{ Exception -> 0x0021 }
            r2 = 1
            r1.cancel(r2)     // Catch:{ Exception -> 0x0021 }
        L_0x000f:
            com.paytm.pgsdk.PaytmPGActivity$e r1 = a     // Catch:{ Exception -> 0x0021 }
            r1.dismiss()     // Catch:{ Exception -> 0x0021 }
            np r1 = defpackage.C1286np.a()     // Catch:{ Exception -> 0x0021 }
            r1.c()     // Catch:{ Exception -> 0x0021 }
        L_0x001b:
            com.paytm.pgsdk.sdknative.modal.Tokens.setValidateResponse(r0)     // Catch:{ all -> 0x0044 }
            goto L_0x0031
        L_0x001f:
            r1 = move-exception
            goto L_0x003d
        L_0x0021:
            r1 = move-exception
            np r2 = defpackage.C1286np.a()     // Catch:{ all -> 0x001f }
            r2.c()     // Catch:{ all -> 0x001f }
            java.lang.Class<qp> r2 = defpackage.C1354qp.class
            monitor-enter(r2)     // Catch:{ all -> 0x001f }
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            defpackage.C1354qp.i0(r1)     // Catch:{ all -> 0x001f }
            goto L_0x001b
        L_0x0031:
            defpackage.C1310ov.c()     // Catch:{ all -> 0x0044 }
            com.paytm.pgsdk.PaytmPGActivity$a r0 = r3.f4104a     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x003b
            r0.cancel()     // Catch:{ all -> 0x0044 }
        L_0x003b:
            monitor-exit(r3)
            return
        L_0x003d:
            com.paytm.pgsdk.sdknative.modal.Tokens.setValidateResponse(r0)     // Catch:{ all -> 0x0044 }
            defpackage.C1310ov.c()     // Catch:{ all -> 0x0044 }
            throw r1     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaytmPGActivity.onDestroy():void");
    }

    public final synchronized boolean onKeyDown(int i, KeyEvent keyEvent) {
        synchronized (C1354qp.class) {
        }
        if (i == 4) {
            synchronized (C1354qp.class) {
            }
            c();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        EasypayBrowserFragment easypayBrowserFragment = this.f4103a;
        easypayBrowserFragment.f4069a.putString("merchant_mid", "");
        easypayBrowserFragment.f4069a.commit();
        this.f4106a = easypayBrowserFragment.f4075a;
    }

    public final void onResume() {
        super.onResume();
    }

    public final void onStop() {
        super.onStop();
        a aVar = this.f4104a;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        public final void onFinish() {
            if (!PaytmPGActivity.this.isFinishing()) {
                C1286np.a().f5603a.onPaytmTransactionTimeout("PAYTM TRANSACTION TIMEOUT", 112);
                PaytmPGActivity.this.finish();
            }
        }

        public final void onTick(long j) {
        }
    }
}
