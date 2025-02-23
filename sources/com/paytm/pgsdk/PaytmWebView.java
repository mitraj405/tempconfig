package com.paytm.pgsdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.paytm.easypay.EasypayBrowserFragment;
import com.paytm.pgsdk.sdknative.LoginActivity;
import in.juspay.hyper.constants.LogCategory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

@TargetApi(21)
public class PaytmWebView extends WebView {
    public static final /* synthetic */ int c = 0;
    public final PaytmPGActivity a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f4110a;

    public class a extends WebChromeClient {
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            synchronized (C1354qp.class) {
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }
    }

    public class b extends WebChromeClient {
        public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            synchronized (C1354qp.class) {
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }
    }

    public class c {

        public class a implements Runnable {
            public final /* synthetic */ Bundle a;

            public a(Bundle bundle) {
                this.a = bundle;
            }

            public final void run() {
                try {
                    ((Activity) PaytmWebView.this.getContext()).finish();
                    PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = C1286np.a().f5603a;
                    if (paytmPaymentTransactionCallback == null) {
                        return;
                    }
                    if (!this.a.getString("RESPCODE").equalsIgnoreCase("01") || !PaytmWebView.c(PaytmWebView.this, this.a)) {
                        paytmPaymentTransactionCallback.onTransactionFailure(this.a.getString("RESPMSG"), this.a);
                    } else {
                        paytmPaymentTransactionCallback.onTransactionSuccess(this.a);
                    }
                } catch (Exception e) {
                    C1354qp.i0(e);
                }
            }
        }

        public c() {
        }

        public final synchronized void a(Bundle bundle) {
            try {
                ((Activity) PaytmWebView.this.getContext()).runOnUiThread(new a(bundle));
            } catch (Exception e) {
                C1354qp.i0(e);
            }
            return;
        }

        @JavascriptInterface
        public synchronized void processResponse(String str) {
            try {
                synchronized (C1354qp.class) {
                }
                Bundle b = PaytmWebView.b(PaytmWebView.this, str);
                if (PaytmWebView.c(PaytmWebView.this, b)) {
                    synchronized (C1354qp.class) {
                    }
                    if (C1286np.a().f5602a.mChecksumVerificationURL == null || C1286np.a().f5602a.mChecksumVerificationURL.length() <= 0) {
                        synchronized (C1354qp.class) {
                        }
                        a(b);
                    } else if (PaytmWebView.this.f4110a) {
                        a(b);
                    } else {
                        synchronized (C1354qp.class) {
                        }
                        PaytmWebView.this.postUrl(C1286np.a().f5602a.mChecksumVerificationURL, C1354qp.V(b).getBytes());
                    }
                } else {
                    synchronized (C1354qp.class) {
                    }
                    if (PaytmWebView.this.f4110a) {
                        synchronized (C1354qp.class) {
                        }
                        a(b);
                    } else if (C1286np.a().f5602a.mChecksumVerificationURL == null || C1286np.a().f5602a.mChecksumVerificationURL.length() <= 0) {
                        synchronized (C1354qp.class) {
                        }
                        a(b);
                    } else {
                        synchronized (C1354qp.class) {
                        }
                        PaytmWebView.this.postUrl(C1286np.a().f5602a.mChecksumVerificationURL, C1354qp.V(b).getBytes());
                    }
                }
            } catch (Exception e) {
                C1354qp.i0(e);
            }
            return;
        }
    }

    public class d extends WebViewClient {
        public final EasypayBrowserFragment a;

        /* renamed from: a  reason: collision with other field name */
        public Timer f4113a;

        public class a extends TimerTask {
            public final /* synthetic */ WebView a;
            public final /* synthetic */ String c;

            /* renamed from: com.paytm.pgsdk.PaytmWebView$d$a$a  reason: collision with other inner class name */
            public class C0054a implements Runnable {
                public C0054a() {
                }

                public final void run() {
                    String str;
                    a aVar = a.this;
                    EasypayBrowserFragment easypayBrowserFragment = d.this.a;
                    WebView webView = aVar.a;
                    easypayBrowserFragment.getClass();
                    ArrayList arrayList = new ArrayList();
                    if (easypayBrowserFragment.f4070a.getBoolean("enableEasyPay", false)) {
                        Iterator<Map<String, String>> it = easypayBrowserFragment.f4076a.iterator();
                        while (it.hasNext()) {
                            Map next = it.next();
                            String str2 = (String) next.get(LogCategory.ACTION);
                            String str3 = aVar.c;
                            if (str3.indexOf((String) next.get("url")) != -1 || ((String) next.get("url")).equals("*")) {
                                String query = Uri.parse(str3).getQuery();
                                if (query == null) {
                                    query = "";
                                }
                                if ((next.get(SearchIntents.EXTRA_QUERY) == null || ((!((String) next.get(SearchIntents.EXTRA_QUERY)).equals("null") || query.equals("")) && (((String) next.get(SearchIntents.EXTRA_QUERY)).equals("null") || query.indexOf((String) next.get(SearchIntents.EXTRA_QUERY)) != -1))) && ((String) easypayBrowserFragment.f4084b.get(0).get(str2)).equals("true")) {
                                    arrayList.add(next);
                                }
                            }
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        Map map = (Map) it2.next();
                        if (map.get(AppMeasurementSdk.ConditionalUserProperty.ACTIVE) == null || !((String) map.get(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)).equals("false")) {
                            String str4 = (String) map.get(FacebookMediationAdapter.KEY_ID);
                            if (!str4.equals("28") && !str4.equals("22") && !str4.equals("33")) {
                                if (!str4.equals("19")) {
                                    String str5 = (String) map.get("selector");
                                    String str6 = (String) map.get("customjs");
                                    if (str6 == null) {
                                        str6 = "customJs=function(){};";
                                    }
                                    map.put("functionStart", "(function(){ try { ".concat(str6));
                                    map.put("functionEnd", "}catch(e){ Android.logError(" + str4 + "); Android.logData(e); } })();");
                                    String str7 = (String) map.get(LogCategory.ACTION);
                                    String str8 = (String) map.get("selectorType");
                                    String str9 = (String) map.get("buttonSelectorName");
                                    if (str8.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                                        str = lf.j("var fields = document.getElementsByName('", str5, "');if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}");
                                    } else {
                                        str = "";
                                    }
                                    if (str8.equals("tagname")) {
                                        str = lf.j("var fields = document.getElementsByTagName('", str5, "');if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}");
                                    }
                                    if (str8.equals(FacebookMediationAdapter.KEY_ID)) {
                                        str = lf.j("var field = document.getElementById('", str5, "'); var fields = field ? [field] : [];if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}");
                                    }
                                    if (str8.equals("custom")) {
                                        str = C1058d.z((String) map.get("customSelector"), "if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}");
                                    }
                                    if (str8.equals(LoginActivity.CERTIFICATE_PASSWORD) || str8.equals("text")) {
                                        str = lf.j("var fields = document.getElementsByName('", str5, "');if(fields.length == 0){Android.showLog('not found - ' + fields.length); throw 'error';}");
                                    }
                                    map.put("fields", str);
                                    if (str7.equals("autofill")) {
                                        easypayBrowserFragment.a = new Y1(easypayBrowserFragment.f4068a, webView, easypayBrowserFragment, map);
                                    }
                                    if (str7.equals("passwordtracker")) {
                                        easypayBrowserFragment.f4067a = new C0760Yo(easypayBrowserFragment.f4068a, webView, easypayBrowserFragment, map, str9);
                                    }
                                    if (str7.equals("proceedhelper")) {
                                        easypayBrowserFragment.f4079a = new C1394sq(easypayBrowserFragment.f4068a, webView, easypayBrowserFragment, map);
                                    }
                                    if (str7.equals("radiohelper")) {
                                        easypayBrowserFragment.f4078a = new C1355qs(easypayBrowserFragment.f4068a, webView, easypayBrowserFragment, map);
                                    }
                                    if (str7.equals("otphelper")) {
                                        easypayBrowserFragment.f4077a = new C1306oo(easypayBrowserFragment.f4068a, webView, easypayBrowserFragment, map);
                                    }
                                    if (str7.equals("customjs")) {
                                        easypayBrowserFragment.f4071a.setVisibility(0);
                                        easypayBrowserFragment.f4080a = new C0360vA(easypayBrowserFragment.f4068a, webView, easypayBrowserFragment, map);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            public a(WebView webView, String str) {
                this.a = webView;
                this.c = str;
            }

            public final void run() {
                PaytmWebView.this.a.runOnUiThread(new C0054a());
            }
        }

        public d(EasypayBrowserFragment easypayBrowserFragment) {
            this.a = easypayBrowserFragment;
        }

        public final synchronized void onPageFinished(WebView webView, String str) {
            try {
                super.onPageFinished(webView, str);
                synchronized (C1354qp.class) {
                }
                PaytmWebView.a(PaytmWebView.this);
                if (!str.equals("https://pguat.paytm.com/paytmchecksum/paytmCheckSumVerify.jsp")) {
                    Timer timer = new Timer();
                    this.f4113a = timer;
                    timer.schedule(new a(webView, str), 500);
                }
                if (str.equalsIgnoreCase(C1286np.a().f5602a.mChecksumVerificationURL)) {
                    synchronized (C1354qp.class) {
                    }
                    PaytmWebView.this.f4110a = true;
                    PaytmWebView.this.loadUrl("javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);");
                } else if (str.endsWith("/CAS/Response")) {
                    synchronized (C1354qp.class) {
                    }
                    PaytmWebView.this.loadUrl("javascript:window.HTMLOUT.processResponse(document.getElementById('response').value);");
                }
            } catch (Exception e) {
                C1354qp.i0(e);
            }
            return;
        }

        public final synchronized void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            synchronized (C1354qp.class) {
            }
            PaytmWebView paytmWebView = PaytmWebView.this;
            int i = PaytmWebView.c;
            synchronized (paytmWebView) {
                try {
                    ((Activity) paytmWebView.getContext()).runOnUiThread(new a());
                } catch (Exception e) {
                    C1354qp.i0(e);
                }
            }
            Timer timer = this.f4113a;
            if (timer != null) {
                timer.cancel();
                this.f4113a = null;
            }
            this.a.d();
            return;
        }

        public final synchronized void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            synchronized (C1354qp.class) {
            }
            synchronized (C1354qp.class) {
            }
            if (i == -6) {
                ((Activity) PaytmWebView.this.getContext()).finish();
                PaytmPaymentTransactionCallback paytmPaymentTransactionCallback = C1286np.a().f5603a;
                if (paytmPaymentTransactionCallback != null) {
                    paytmPaymentTransactionCallback.onErrorLoadingWebPage(i, str, str2);
                }
            }
        }

        public final synchronized void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslError.toString();
            synchronized (C1354qp.class) {
            }
            Objects.toString(sslErrorHandler);
            synchronized (C1354qp.class) {
            }
            if (sslErrorHandler != null) {
                sslErrorHandler.cancel();
            }
        }
    }

    public PaytmWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = (PaytmPGActivity) context;
        new EasypayBrowserFragment();
        setWebChromeClient(new a());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        addJavascriptInterface(new c(), "HTMLOUT");
    }

    public static void a(PaytmWebView paytmWebView) {
        synchronized (paytmWebView) {
            try {
                ((Activity) paytmWebView.getContext()).runOnUiThread(new b());
            } catch (Exception e) {
                C1354qp.i0(e);
            }
        }
        return;
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
    public static android.os.Bundle b(com.paytm.pgsdk.PaytmWebView r5, java.lang.String r6) {
        /*
            monitor-enter(r5)
            java.lang.Class<qp> r0 = defpackage.C1354qp.class
            monitor-enter(r0)     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x003b }
            r0.<init>()     // Catch:{ all -> 0x003b }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0031 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x0031 }
            int r6 = r1.length()     // Catch:{ Exception -> 0x0031 }
            if (r6 <= 0) goto L_0x0039
            java.util.Iterator r6 = r1.keys()     // Catch:{ Exception -> 0x0031 }
        L_0x0019:
            boolean r2 = r6.hasNext()     // Catch:{ Exception -> 0x0031 }
            if (r2 == 0) goto L_0x0039
            java.lang.Object r2 = r6.next()     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0031 }
            java.lang.String r3 = r1.getString(r2)     // Catch:{ Exception -> 0x0031 }
            java.lang.Class<qp> r4 = defpackage.C1354qp.class
            monitor-enter(r4)     // Catch:{ Exception -> 0x0031 }
            monitor-exit(r4)     // Catch:{ Exception -> 0x0031 }
            r0.putString(r2, r3)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0019
        L_0x0031:
            r6 = move-exception
            java.lang.Class<qp> r1 = defpackage.C1354qp.class
            monitor-enter(r1)     // Catch:{ all -> 0x003b }
            monitor-exit(r1)     // Catch:{ all -> 0x003b }
            defpackage.C1354qp.i0(r6)     // Catch:{ all -> 0x003b }
        L_0x0039:
            monitor-exit(r5)
            return r0
        L_0x003b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.pgsdk.PaytmWebView.b(com.paytm.pgsdk.PaytmWebView, java.lang.String):android.os.Bundle");
    }

    public static boolean c(PaytmWebView paytmWebView, Bundle bundle) {
        boolean z;
        synchronized (paytmWebView) {
            if (bundle != null) {
                try {
                    if (bundle.size() > 0 && bundle.containsKey("IS_CHECKSUM_VALID") && bundle.getString("IS_CHECKSUM_VALID").equalsIgnoreCase("Y")) {
                        z = true;
                    }
                } catch (Exception e) {
                    C1354qp.i0(e);
                }
            }
            z = false;
        }
        return z;
    }

    public void setWebViewClient(EasypayBrowserFragment easypayBrowserFragment) {
        setWebViewClient(new d(easypayBrowserFragment));
    }

    public PaytmWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = (PaytmPGActivity) context;
        new EasypayBrowserFragment();
        setWebChromeClient(new b());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        addJavascriptInterface(new c(), "HTMLOUT");
    }

    public PaytmWebView(PaytmPGActivity paytmPGActivity) {
        super(paytmPGActivity);
        this.a = paytmPGActivity;
        setWebViewClient(new d(new EasypayBrowserFragment()));
        setWebChromeClient(new C1372rp());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMixedContentMode(0);
        addJavascriptInterface(new c(), "HTMLOUT");
    }
}
