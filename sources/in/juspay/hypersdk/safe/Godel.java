package in.juspay.hypersdk.safe;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewManager;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.widget.FrameLayout;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.core.AcsInterface;
import in.juspay.hypersdk.core.DuiInterface;
import in.juspay.hypersdk.core.GodelJsInterface;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.JuspayWebViewConfigurationCallback;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PaymentUtils;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.SequenceInputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Godel {
    private static final String GODEL = "Godel";
    private static final String LOG_TAG = "PaymentUtils";
    private static final long ON_EXCEPTION_GODEL_OFF_STICKINESS = 86400000;
    private final AcsInterface acsInterface;
    private final List<String> allowedDeeplinkPackages = new ArrayList();
    private final JSONObject bundleParameters;
    private JSONObject config;
    private final Context context;
    private final DuiInterface duiInterface;
    public boolean isRupaySupportedAdded = false;
    private final JuspayServices juspayServices;
    private final JuspayWebChromeClient juspayWebChromeClient;
    private final JuspayWebView juspayWebView;
    private final JuspayWebViewClient juspayWebViewClient;
    private final JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback;
    private final PaymentSessionInfo paymentSessionInfo;
    private final JSONObject processPayload;
    private final SdkTracker sdkTracker;

    public Godel(JuspayServices juspayServices2) {
        Context context2 = juspayServices2.getContext();
        this.context = context2;
        this.juspayServices = juspayServices2;
        Activity activity = juspayServices2.getActivity();
        JuspayWebView juspayWebView2 = new JuspayWebView(activity != null ? activity : context2);
        this.juspayWebView = juspayWebView2;
        this.juspayWebViewClient = new JuspayWebViewClient(this, juspayWebView2);
        this.juspayWebChromeClient = new JuspayWebChromeClient(this);
        this.acsInterface = new AcsInterface(juspayServices2);
        this.juspayWebViewConfigurationCallback = juspayServices2.getWebViewConfigurationCallback();
        this.sdkTracker = juspayServices2.getSdkTracker();
        this.duiInterface = juspayServices2.getJBridge();
        this.paymentSessionInfo = juspayServices2.getPaymentSessionInfo();
        this.bundleParameters = juspayServices2.getSessionInfo().getBundleParams();
        this.processPayload = juspayServices2.getLastProcessPayload();
        this.config = new JSONObject();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[Catch:{ Exception -> 0x00ae }, LOOP:0: B:24:0x0089->B:26:0x008f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7 A[Catch:{ Exception -> 0x00ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.webkit.WebResourceResponse addAcsToJSFile(android.webkit.WebResourceRequest r9, java.lang.String r10, java.lang.String r11, org.json.JSONObject r12, org.json.JSONObject r13) {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "POST"
            boolean r1 = r10.equals(r1)     // Catch:{ Exception -> 0x00ae }
            if (r1 == 0) goto L_0x0013
            javax.net.ssl.HttpsURLConnection r9 = r8.getPostRequestConnection(r13, r12, r9)     // Catch:{ Exception -> 0x00ae }
            java.io.InputStream r10 = r8.getDataAcsFromPostRequest(r9, r11)     // Catch:{ Exception -> 0x00ae }
            r7 = r10
            goto L_0x003a
        L_0x0013:
            java.lang.String r11 = "GET"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x00ae }
            if (r10 == 0) goto L_0x00ae
            java.net.URL r10 = new java.net.URL     // Catch:{ Exception -> 0x00ae }
            android.net.Uri r11 = r9.getUrl()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x00ae }
            r10.<init>(r11)     // Catch:{ Exception -> 0x00ae }
            java.net.URLConnection r10 = r10.openConnection()     // Catch:{ Exception -> 0x00ae }
            java.lang.Object r10 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r10)     // Catch:{ Exception -> 0x00ae }
            java.net.URLConnection r10 = (java.net.URLConnection) r10     // Catch:{ Exception -> 0x00ae }
            javax.net.ssl.HttpsURLConnection r10 = (javax.net.ssl.HttpsURLConnection) r10     // Catch:{ Exception -> 0x00ae }
            java.io.InputStream r9 = r8.getDataFromGetRequest(r10, r9)     // Catch:{ Exception -> 0x00ae }
            r7 = r9
            r9 = r10
        L_0x003a:
            if (r9 != 0) goto L_0x003d
            return r0
        L_0x003d:
            java.lang.String r10 = r9.getContentType()     // Catch:{ Exception -> 0x00ae }
            r11 = -1
            r12 = 59
            if (r10 == 0) goto L_0x0057
            int r13 = r10.indexOf(r12)     // Catch:{ Exception -> 0x00ae }
            if (r13 <= r11) goto L_0x0057
            int r13 = r10.indexOf(r12)     // Catch:{ Exception -> 0x00ae }
            r1 = 0
            java.lang.String r13 = r10.substring(r1, r13)     // Catch:{ Exception -> 0x00ae }
            r2 = r13
            goto L_0x0058
        L_0x0057:
            r2 = r10
        L_0x0058:
            if (r10 == 0) goto L_0x0077
            int r12 = r10.indexOf(r12)     // Catch:{ Exception -> 0x00ae }
            if (r12 <= r11) goto L_0x0077
            java.lang.String r11 = "charset=([\\w-_]+)"
            java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r11)     // Catch:{ Exception -> 0x00ae }
            java.util.regex.Matcher r10 = r11.matcher(r10)     // Catch:{ Exception -> 0x00ae }
            boolean r11 = r10.find()     // Catch:{ Exception -> 0x00ae }
            if (r11 == 0) goto L_0x0077
            r11 = 1
            java.lang.String r10 = r10.group(r11)     // Catch:{ Exception -> 0x00ae }
            r3 = r10
            goto L_0x0078
        L_0x0077:
            r3 = r0
        L_0x0078:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ Exception -> 0x00ae }
            r6.<init>()     // Catch:{ Exception -> 0x00ae }
            java.util.Map r10 = r9.getHeaderFields()     // Catch:{ Exception -> 0x00ae }
            java.util.Set r10 = r10.keySet()     // Catch:{ Exception -> 0x00ae }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x00ae }
        L_0x0089:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x00ae }
            if (r11 == 0) goto L_0x009d
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x00ae }
            java.lang.String r12 = r9.getHeaderField(r11)     // Catch:{ Exception -> 0x00ae }
            r6.put(r11, r12)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0089
        L_0x009d:
            int r4 = r9.getResponseCode()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r5 = r9.getResponseMessage()     // Catch:{ Exception -> 0x00ae }
            if (r7 == 0) goto L_0x00ae
            android.webkit.WebResourceResponse r9 = new android.webkit.WebResourceResponse     // Catch:{ Exception -> 0x00ae }
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00ae }
            return r9
        L_0x00ae:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.safe.Godel.addAcsToJSFile(android.webkit.WebResourceRequest, java.lang.String, java.lang.String, org.json.JSONObject, org.json.JSONObject):android.webkit.WebResourceResponse");
    }

    private String getAcsScript() {
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        StringBuilder n = lf.n("window.juspayContext = {}; juspayContext['web_lab_rules'] = " + getWebLabRules(), ", ");
        n.append(fileProviderService.readFromFile(this.juspayServices.getContext(), PaymentConstants.ACS));
        return n.toString();
    }

    private String getConnectionData(Reader reader, int i) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[i];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private InputStream getDataAcsFromPostRequest(HttpsURLConnection httpsURLConnection, String str) {
        try {
            if (".html".matches(str)) {
                return handleHtmlFile(httpsURLConnection);
            }
            if (!".js".matches(str)) {
                if (!".jsp".matches(str)) {
                    return null;
                }
            }
            return handleJsFile(httpsURLConnection);
        } catch (Exception unused) {
            return null;
        }
    }

    private InputStream getDataFromGetRequest(HttpsURLConnection httpsURLConnection, WebResourceRequest webResourceRequest) {
        try {
            for (String next : webResourceRequest.getRequestHeaders().keySet()) {
                httpsURLConnection.setRequestProperty(next, webResourceRequest.getRequestHeaders().get(next));
            }
            httpsURLConnection.setDoOutput(false);
            return new SequenceInputStream(new ByteArrayInputStream(String.format("window.addEventListener('load', function() { if(!window.GK) { %s } });", new Object[]{getAcsScript()}).getBytes(StandardCharsets.UTF_8)), httpsURLConnection.getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }

    private List<Pattern> getExcludeUrlsPatternList() {
        Exception exc;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        SdkTracker sdkTracker2;
        JSONException jSONException;
        LinkedList linkedList = null;
        try {
            LinkedList linkedList2 = new LinkedList();
            try {
                JSONArray jSONArray = this.config.getJSONArray("exclude_url_patterns");
                if (!isNotNull(jSONArray)) {
                    return linkedList2;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList2.add(Pattern.compile(jSONArray.get(i).toString()));
                }
                return linkedList2;
            } catch (JSONException e) {
                jSONException = e;
                linkedList = linkedList2;
                sdkTracker2 = this.sdkTracker;
                str5 = LOG_TAG;
                str4 = LogCategory.ACTION;
                str3 = LogSubCategory.Action.SYSTEM;
                str2 = Labels.System.UTIL;
                str = "Json Exception while fetching excludeUrlPatterns from config";
                sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
                return linkedList;
            } catch (Exception e2) {
                exc = e2;
                linkedList = linkedList2;
                sdkTracker2 = this.sdkTracker;
                str5 = LOG_TAG;
                str4 = LogCategory.ACTION;
                str3 = LogSubCategory.Action.SYSTEM;
                str2 = Labels.System.UTIL;
                str = "Exception while compiling patterns in excludeUrlPatterns from config";
                sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
                return linkedList;
            }
        } catch (JSONException e3) {
            jSONException = e3;
            sdkTracker2 = this.sdkTracker;
            str5 = LOG_TAG;
            str4 = LogCategory.ACTION;
            str3 = LogSubCategory.Action.SYSTEM;
            str2 = Labels.System.UTIL;
            str = "Json Exception while fetching excludeUrlPatterns from config";
            sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
            return linkedList;
        } catch (Exception e4) {
            exc = e4;
            sdkTracker2 = this.sdkTracker;
            str5 = LOG_TAG;
            str4 = LogCategory.ACTION;
            str3 = LogSubCategory.Action.SYSTEM;
            str2 = Labels.System.UTIL;
            str = "Exception while compiling patterns in excludeUrlPatterns from config";
            sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
            return linkedList;
        }
    }

    private HttpsURLConnection getPostRequestConnection(JSONObject jSONObject, JSONObject jSONObject2, WebResourceRequest webResourceRequest) {
        try {
            String sessionAttribute = this.juspayServices.getJBridge().getSessionAttribute("iframe_form_data", "wait_for_me");
            JSONObject jSONObject3 = this.config.getJSONObject("waiting_time_postparams");
            int optInt = jSONObject3.optInt("total_time", 1000);
            int optInt2 = jSONObject3.optInt("interval", 50);
            while (sessionAttribute.equals("wait_for_me") && optInt > 0) {
                TimeUnit.MILLISECONDS.sleep((long) optInt2);
                sessionAttribute = this.juspayServices.getJBridge().getSessionAttribute("iframe_form_data", "wait_for_me");
                optInt -= optInt2;
            }
            if (sessionAttribute.equals("wait_for_me")) {
                return null;
            }
            this.juspayServices.getJBridge().setSessionAttribute("iframe_form_data", "wait_for_me");
            HashMap<String, String> map = toMap(sessionAttribute);
            NetUtils netUtils = new NetUtils(jSONObject.optInt("connection_timeout", 10000), jSONObject.optInt("read_timeout", 10000));
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject2.getString(next));
            }
            return netUtils.postUrl(new URL(webResourceRequest.getUrl().toString()), (Map<String, String>) hashMap, (Map<String, String>) map, new JSONObject());
        } catch (Exception unused) {
            return null;
        }
    }

    private List<String> getRupaySpecificDomains() {
        Exception exc;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        SdkTracker sdkTracker2;
        JSONException jSONException;
        ArrayList arrayList = null;
        try {
            JSONArray jSONArray = this.config.getJSONArray("rupay_specific_domains");
            JuspayServices juspayServices2 = this.juspayServices;
            String str6 = LOG_TAG;
            juspayServices2.sdkDebug(str6, "printing urlArray" + jSONArray);
            if (!isNotNull(jSONArray)) {
                return null;
            }
            int length = jSONArray.length();
            ArrayList arrayList2 = new ArrayList(length);
            int i = 0;
            while (i < length) {
                try {
                    arrayList2.add(jSONArray.get(i).toString());
                    i++;
                } catch (JSONException e) {
                    jSONException = e;
                    arrayList = arrayList2;
                    sdkTracker2 = this.sdkTracker;
                    str5 = LOG_TAG;
                    str4 = LogCategory.ACTION;
                    str3 = LogSubCategory.Action.SYSTEM;
                    str2 = Labels.System.UTIL;
                    str = "Json Exception while fetching Rupay Urls from config";
                    sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
                    return arrayList;
                } catch (Exception e2) {
                    exc = e2;
                    arrayList = arrayList2;
                    sdkTracker2 = this.sdkTracker;
                    str5 = LOG_TAG;
                    str4 = LogCategory.ACTION;
                    str3 = LogSubCategory.Action.SYSTEM;
                    str2 = Labels.System.UTIL;
                    str = "Exception while getting rupay urls from config";
                    sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
                    return arrayList;
                }
            }
            return arrayList2;
        } catch (JSONException e3) {
            jSONException = e3;
            sdkTracker2 = this.sdkTracker;
            str5 = LOG_TAG;
            str4 = LogCategory.ACTION;
            str3 = LogSubCategory.Action.SYSTEM;
            str2 = Labels.System.UTIL;
            str = "Json Exception while fetching Rupay Urls from config";
            sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
            return arrayList;
        } catch (Exception e4) {
            exc = e4;
            sdkTracker2 = this.sdkTracker;
            str5 = LOG_TAG;
            str4 = LogCategory.ACTION;
            str3 = LogSubCategory.Action.SYSTEM;
            str2 = Labels.System.UTIL;
            str = "Exception while getting rupay urls from config";
            sdkTracker2.trackAndLogException(str5, str4, str3, str2, str, exc);
            return arrayList;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[Catch:{ Exception -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081 A[RETURN] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0086=Splitter:B:36:0x0086, B:27:0x006a=Splitter:B:27:0x006a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.InputStream handleHtmlFile(javax.net.ssl.HttpsURLConnection r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "<script>{ %s } </script></body>"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0087 }
            java.lang.String r3 = r7.getAcsScript()     // Catch:{ Exception -> 0x0087 }
            r4 = 0
            r2[r4] = r3     // Catch:{ Exception -> 0x0087 }
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r8.getContentEncoding()     // Catch:{ Exception -> 0x0087 }
            r3 = 8000(0x1f40, float:1.121E-41)
            if (r2 == 0) goto L_0x0048
            java.lang.String r4 = "gzip"
            boolean r4 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0087 }
            if (r4 == 0) goto L_0x0048
            java.util.zip.GZIPInputStream r2 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x0087 }
            java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0087 }
            r2.<init>(r8)     // Catch:{ Exception -> 0x0087 }
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0087 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0087 }
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0087 }
            r4.<init>(r2, r5)     // Catch:{ Exception -> 0x0087 }
            r8.<init>(r4, r3)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r2 = r7.getConnectionData(r8, r3)     // Catch:{ all -> 0x003e }
            goto L_0x006a
        L_0x003e:
            r1 = move-exception
            r8.close()     // Catch:{ all -> 0x0043 }
            goto L_0x0086
        L_0x0043:
            r8 = move-exception
            r1.addSuppressed(r8)     // Catch:{ Exception -> 0x0087 }
            goto L_0x0086
        L_0x0048:
            if (r2 == 0) goto L_0x0055
            java.lang.String r4 = ""
            boolean r2 = r2.equals(r4)     // Catch:{ Exception -> 0x0087 }
            if (r2 == 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r2 = r0
            goto L_0x006d
        L_0x0055:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0087 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0087 }
            java.io.InputStream r8 = r8.getInputStream()     // Catch:{ Exception -> 0x0087 }
            r4.<init>(r8)     // Catch:{ Exception -> 0x0087 }
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0087 }
            java.lang.String r8 = r7.getConnectionData(r2, r3)     // Catch:{ all -> 0x0082 }
            r6 = r2
            r2 = r8
            r8 = r6
        L_0x006a:
            r8.close()     // Catch:{ Exception -> 0x0087 }
        L_0x006d:
            if (r2 == 0) goto L_0x0081
            java.lang.String r8 = "</body>"
            java.lang.String r8 = r2.replace(r8, r1)     // Catch:{ Exception -> 0x0087 }
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0087 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0087 }
            byte[] r8 = r8.getBytes(r2)     // Catch:{ Exception -> 0x0087 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0087 }
            return r1
        L_0x0081:
            return r0
        L_0x0082:
            r1 = move-exception
            r2.close()     // Catch:{ all -> 0x0043 }
        L_0x0086:
            throw r1     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.safe.Godel.handleHtmlFile(javax.net.ssl.HttpsURLConnection):java.io.InputStream");
    }

    private InputStream handleJsFile(HttpsURLConnection httpsURLConnection) {
        if (httpsURLConnection == null) {
            return null;
        }
        try {
            return new SequenceInputStream(new ByteArrayInputStream(String.format("window.addEventListener('load', function() { if(!window.GK) { %s } });", new Object[]{getAcsScript()}).getBytes(StandardCharsets.UTF_8)), httpsURLConnection.getInputStream());
        } catch (Exception unused) {
            return null;
        }
    }

    private void initializeJuspayWebView(Context context2) {
        this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "started", context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.juspayWebView.setId(R.id.juspay_browser_view);
        this.juspayWebView.setLayoutParams(layoutParams);
        this.juspayWebView.setHorizontalScrollBarEnabled(false);
        this.juspayWebView.setVerticalScrollBarEnabled(false);
        this.juspayWebView.addJavascriptInterface(this.acsInterface, "ACSGatekeeper");
        FileProviderService fileProviderService = this.juspayServices.getFileProviderService();
        this.paymentSessionInfo.setPaymentDetails(this.bundleParameters);
        fileProviderService.addToFileCacheWhiteList("acs.jsa");
        prepareWebView();
    }

    private boolean isAcsToBeAddedToResource(URL url) {
        List<String> rupaySpecificDomains = getRupaySpecificDomains();
        if (rupaySpecificDomains == null) {
            return false;
        }
        for (String contains : rupaySpecificDomains) {
            if (url.toString().toLowerCase().contains(contains) && url.getPath().toLowerCase().endsWith(".js") && !url.getPath().toLowerCase().endsWith(".jsp")) {
                return true;
            }
        }
        return false;
    }

    private boolean isClientWhitelistedForWebViewAccess(String str) {
        JSONArray optJSONArray = Utils.optJSONArray(Utils.optJSONObject(Utils.optJSONObject(this.juspayServices.getSdkConfigService().getSdkConfig(), "godelConfig"), "webViewAccess"), "whitelistedClientIds");
        int i = 0;
        while (i < optJSONArray.length()) {
            try {
                if (str.contains(optJSONArray.getString(i))) {
                    return true;
                }
                i++;
            } catch (JSONException e) {
                this.sdkTracker.trackAndLogException(GODEL, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.GODEL_WEBVIEW_WHITELIST, "Failed to read whitelisted config", e);
            }
        }
        return false;
    }

    private static boolean isNotNull(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray == JSONObject.NULL) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBrowserReady$0(Activity activity, String str, String str2, String str3) {
        addWebView(activity, str);
        loadPage(str2, str3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onBrowserReady$1(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        addWebView(activity, str);
        this.juspayWebView.loadDataWithBaseURL(str2, str3, str4, str5, str6);
    }

    private boolean shouldDisableGodel(Context context2) {
        long j;
        if (context2 == null || !KeyValueStore.contains(this.juspayServices, "GODEL_EXCEPTION_OFF")) {
            return false;
        }
        long optLong = getConfig().optLong("ON_EXCEPTION_GODEL_OFF_STICKINESS", ON_EXCEPTION_GODEL_OFF_STICKINESS);
        try {
            j = System.currentTimeMillis() - Long.parseLong(KeyValueStore.read(this.juspayServices, "GODEL_EXCEPTION_OFF", String.valueOf(System.currentTimeMillis())));
        } catch (NumberFormatException e) {
            long currentTimeMillis = System.currentTimeMillis();
            this.sdkTracker.trackAndLogException(GODEL, LogCategory.ACTION, LogSubCategory.Action.USER, Labels.User.SHOULD_DISABLE_GODEL, "Failed while parsing number", e);
            j = currentTimeMillis;
        }
        this.sdkTracker.trackAction(LogSubCategory.Action.USER, "info", Labels.User.SHOULD_DISABLE_GODEL, "exception_info", KeyValueStore.read(this.juspayServices, "EXCEPTION_INFO", (String) null));
        if (j <= optLong) {
            return true;
        }
        KeyValueStore.remove(this.juspayServices, "GODEL_EXCEPTION_OFF");
        KeyValueStore.remove(this.juspayServices, "EXCEPTION_OFF");
        return false;
    }

    private WebResourceResponse shouldExcludeResource(String str) {
        String str2;
        Pattern compile = Pattern.compile(".*\\.(gif|jpg|jpeg|png)([;?].*)?$");
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_4444);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        List<Pattern> excludeUrlsPatternList = getExcludeUrlsPatternList();
        if (excludeUrlsPatternList == null) {
            excludeUrlsPatternList = new ArrayList<>();
        }
        for (Pattern matcher : excludeUrlsPatternList) {
            if (matcher.matcher(str).matches()) {
                if (compile.matcher(str).matches()) {
                    str2 = "text/html";
                } else {
                    byteArray = "[blocked]".getBytes();
                    str2 = "text/plain";
                }
                return new WebResourceResponse(str2, "utf-8", new ByteArrayInputStream(byteArray));
            }
        }
        return null;
    }

    private HashMap<String, String> toMap(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            JuspayLogger.d(LOG_TAG, "Not a json string. Passing as such");
            return null;
        }
    }

    private void turnOffGodelIfNeeded() {
        if (shouldDisableGodel(this.context)) {
            this.paymentSessionInfo.setGodelDisabled(PaymentConstants.GodelOffReasons.ON_GODEL_EXCEPTION);
        }
        if (!PaymentUtils.hasTelephonyService(this.juspayServices)) {
            this.juspayServices.sdkDebug(GODEL, "No telephony service found.. disabling JB");
            this.paymentSessionInfo.setGodelDisabled(PaymentConstants.GodelOffReasons.TELEPHONY_NOT_FOUND);
        }
        PaymentUtils.switchOffGodelIfLowOnMemory(this, this.juspayServices, this.paymentSessionInfo);
    }

    /* JADX WARNING: type inference failed for: r8v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addWebView(android.app.Activity r8, java.lang.String r9) {
        /*
            r7 = this;
            android.content.Context r0 = r7.context
            r7.initializeJuspayWebView(r0)
            in.juspay.hypersdk.core.JuspayServices r0 = r7.juspayServices
            android.widget.FrameLayout r0 = r0.getContainer()
            if (r0 == 0) goto L_0x001e
            in.juspay.hypersdk.core.JuspayServices r0 = r7.juspayServices
            android.widget.FrameLayout r0 = r0.getContainer()
            int r1 = java.lang.Integer.parseInt(r9)
            android.view.View r0 = r0.findViewById(r1)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 != 0) goto L_0x002f
            if (r8 == 0) goto L_0x002f
            int r9 = java.lang.Integer.parseInt(r9)
            android.view.View r8 = r8.findViewById(r9)
            r0 = r8
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            goto L_0x003e
        L_0x002f:
            in.juspay.hypersdk.core.SdkTracker r1 = r7.sdkTracker
            java.lang.String r2 = "system"
            java.lang.String r3 = "error"
            java.lang.String r4 = "add_web_view"
            java.lang.String r5 = "missing"
            java.lang.String r6 = "activity"
            r1.trackAction(r2, r3, r4, r5, r6)
        L_0x003e:
            if (r0 != 0) goto L_0x0050
            in.juspay.hypersdk.core.SdkTracker r1 = r7.sdkTracker
            java.lang.String r2 = "system"
            java.lang.String r3 = "error"
            java.lang.String r4 = "add_web_view"
            java.lang.String r5 = "missing"
            java.lang.String r6 = "view"
            r1.trackAction(r2, r3, r4, r5, r6)
            return
        L_0x0050:
            in.juspay.hypersdk.safe.JuspayWebView r8 = r7.juspayWebView
            android.view.ViewParent r8 = r8.getParent()
            if (r8 != r0) goto L_0x0068
            in.juspay.hypersdk.core.SdkTracker r1 = r7.sdkTracker
            java.lang.String r2 = "system"
            java.lang.String r3 = "warning"
            java.lang.String r4 = "add_web_view"
            java.lang.String r5 = "parent"
            java.lang.String r6 = "parent view is same as before"
            r1.trackAction(r2, r3, r4, r5, r6)
            return
        L_0x0068:
            r7.turnOffGodelIfNeeded()
            in.juspay.hypersdk.safe.JuspayWebView r8 = r7.juspayWebView
            android.view.ViewParent r8 = r8.getParent()
            if (r8 == 0) goto L_0x009d
            in.juspay.hypersdk.core.SdkTracker r1 = r7.sdkTracker
            java.lang.String r2 = "system"
            java.lang.String r3 = "warning"
            java.lang.String r4 = "add_web_view"
            java.lang.String r5 = "parent"
            java.lang.String r6 = "already present"
            r1.trackAction(r2, r3, r4, r5, r6)
            boolean r9 = r8 instanceof android.view.ViewGroup
            if (r9 != 0) goto L_0x0096
            in.juspay.hypersdk.core.SdkTracker r1 = r7.sdkTracker
            java.lang.String r2 = "system"
            java.lang.String r3 = "error"
            java.lang.String r4 = "add_web_view"
            java.lang.String r5 = "parent"
            java.lang.String r6 = "not a ViewGroup"
            r1.trackAction(r2, r3, r4, r5, r6)
            return
        L_0x0096:
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            in.juspay.hypersdk.safe.JuspayWebView r9 = r7.juspayWebView
            r8.removeView(r9)
        L_0x009d:
            in.juspay.hypersdk.safe.JuspayWebView r8 = r7.juspayWebView
            r9 = 0
            r0.addView(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.safe.Godel.addWebView(android.app.Activity, java.lang.String):void");
    }

    public void exit() {
        ExecutorManager.runOnMainThread(new C0088Dd(this, 10));
    }

    public AcsInterface getAcsInterface() {
        return this.acsInterface;
    }

    public List<String> getAllowedDeeplinkPackages() {
        return this.allowedDeeplinkPackages;
    }

    public JSONObject getConfig() {
        return this.config;
    }

    public Context getContext() {
        return this.context;
    }

    public DuiInterface getDuiInterface() {
        return this.duiInterface;
    }

    public JuspayServices getJuspayServices() {
        return this.juspayServices;
    }

    public JuspayWebView getJuspayWebView() {
        return this.juspayWebView;
    }

    public PaymentSessionInfo getPaymentSessionInfo() {
        return this.paymentSessionInfo;
    }

    public JSONObject getWebLabRules() {
        try {
            return this.config.getJSONObject("weblab");
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.UTIL, "Unable to find weblab key in config", e);
            return null;
        }
    }

    public boolean isDuiLoaded() {
        return true;
    }

    public void loadPage() {
        String str;
        String str2;
        if (!this.bundleParameters.has("url")) {
            str2 = this.bundleParameters.optString("url");
            str = this.bundleParameters.optString(PaymentConstants.POST_DATA);
        } else {
            str2 = "file:///android_assets/juspay/acs_blank.html";
            str = null;
        }
        loadPage(str2, str);
    }

    public void onBrowserReady(Activity activity, String str, String str2, String str3) {
        ExecutorManager.runOnMainThread(new C1504yv(this, activity, str3, str, str2));
    }

    public void onDuiReady() {
        this.paymentSessionInfo.setGodelManager(this);
        this.juspayServices.getJBridge().attach(PaymentConstants.NETWORK_STATUS, "{}", "");
        setupAllowedDeeplinkPackages();
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.ON_DUI_READY, "class", "HyperFragment");
    }

    public void onDuiReleased() {
        this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.ON_DUI_RELEASED, "exit_sdk", JSONObject.NULL);
        exit();
        this.paymentSessionInfo.setGodelManager((Godel) null);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void prepareWebView() {
        this.juspayWebView.getSettings().setJavaScriptEnabled(true);
        this.juspayWebView.getSettings().setDomStorageEnabled(true);
        JSONObject jSONObject = null;
        try {
            jSONObject = this.bundleParameters.getJSONObject(PaymentConstants.PAYLOAD);
            if (jSONObject.optBoolean("godel_receive_merchant_messages")) {
                this.juspayWebView.addJavascriptInterface(new GodelJsInterface(this.juspayServices), "GodelInterface");
            }
        } catch (JSONException e) {
            this.sdkTracker.trackAndLogException(GODEL, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.INITIALISE_JUSPAY_WEBVIEW, "Initiate payload is missing", e);
        }
        this.juspayWebView.setDefaultWebViewClient(this.juspayWebViewClient);
        this.juspayWebView.setDefaultWebChromeClient(this.juspayWebChromeClient);
        this.juspayWebView.getSettings().setAllowFileAccess(true);
        this.juspayWebView.getSettings().setCacheMode(-1);
        this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "enabling_third_party_cookies", Boolean.TRUE);
        CookieManager.getInstance().setAcceptThirdPartyCookies(this.juspayWebView, true);
        if (!this.juspayServices.getJBridge().execute(PaymentConstants.NETWORK_STATUS, "", "{}", "").equals(String.valueOf(true))) {
            this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "no_network", "Setting web view to load from cache if there is no network");
            this.juspayWebView.getSettings().setCacheMode(1);
        }
        if (this.bundleParameters.has("clearCookies") && this.bundleParameters.optBoolean("clearCookies")) {
            this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "clearing", "cookies");
            PaymentUtils.clearCookies(this.juspayServices);
        }
        if (jSONObject != null) {
            String optString = jSONObject.optString(PaymentConstants.CLIENT_ID_CAMEL, "");
            if (this.juspayWebViewConfigurationCallback != null && isClientWhitelistedForWebViewAccess(optString)) {
                this.juspayWebViewConfigurationCallback.configureJuspayWebView(this.juspayWebView);
                this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.GODEL_WEBVIEW_WHITELIST, "configured", "JuspayWebView");
                return;
            }
            return;
        }
        this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "error", Labels.System.INITIALISE_JUSPAY_WEBVIEW, "missing", "JuspayWebView");
    }

    public void resetWebView() {
        JuspayWebView juspayWebView2 = this.juspayWebView;
        juspayWebView2.setDefaultWebChromeClient(juspayWebView2.getWebChromeClient());
        JuspayWebView juspayWebView3 = this.juspayWebView;
        juspayWebView3.setDefaultWebViewClient(juspayWebView3.getWebViewClient());
        this.juspayWebView.stopLoading();
        this.juspayWebView.removeJavascriptInterface("ACSGatekeeper");
        this.juspayWebView.clearHistory();
        this.juspayWebView.destroy();
        if (this.juspayWebView.getParent() != null) {
            ((ViewManager) this.juspayWebView.getParent()).removeView(this.juspayWebView);
        }
    }

    public void setConfig(JSONObject jSONObject) {
        this.config = jSONObject;
    }

    public void setIsRupaySupportedAdded(boolean z) {
        this.isRupaySupportedAdded = z;
    }

    public void setupAllowedDeeplinkPackages() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.processPayload;
        if (jSONObject2 != null) {
            jSONObject = jSONObject2.optJSONObject(PaymentConstants.PAYLOAD);
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("allowedDeepLinkPackages");
            this.allowedDeeplinkPackages.clear();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (optString != null) {
                        this.allowedDeeplinkPackages.add(optString);
                    }
                }
            }
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        JSONArray optJSONArray;
        try {
            int i = 0;
            if (this.juspayServices.getSessionInfo().get("inject_acs_into_iframes", "false").equals("true") && webResourceRequest.getMethod().equals(FirebasePerformance.HttpMethod.GET)) {
                JSONArray optJSONArray2 = this.config.optJSONArray("bank_js_urls_v2");
                if (optJSONArray2 == null) {
                    JSONArray optJSONArray3 = this.config.optJSONArray("bank_js_urls");
                    if (optJSONArray3 != null) {
                        while (i < optJSONArray3.length()) {
                            if (Pattern.compile(optJSONArray3.getString(i)).matcher(webResourceRequest.getUrl().toString()).find()) {
                                return addAcsToJSFile(webResourceRequest, FirebasePerformance.HttpMethod.GET, ".*\\.jsp?$", new JSONObject(), new JSONObject());
                            }
                            i++;
                        }
                    }
                } else {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONArray jSONArray = optJSONArray2.getJSONArray(i2);
                        if (Pattern.compile(jSONArray.getString(0)).matcher(webResourceRequest.getUrl().toString()).find()) {
                            return addAcsToJSFile(webResourceRequest, FirebasePerformance.HttpMethod.GET, jSONArray.getString(1), new JSONObject(), new JSONObject());
                        }
                    }
                }
                return null;
            } else if (!webResourceRequest.getMethod().equals(FirebasePerformance.HttpMethod.POST) || (optJSONArray = this.config.optJSONArray("post_urls")) == null) {
                return null;
            } else {
                while (i < optJSONArray.length()) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    if (Pattern.compile(jSONObject.getString("url")).matcher(webResourceRequest.getUrl().toString()).find()) {
                        return addAcsToJSFile(webResourceRequest, FirebasePerformance.HttpMethod.POST, jSONObject.getString("file_type"), jSONObject.getJSONObject("headers"), jSONObject.getJSONObject("timeout"));
                    }
                    i++;
                }
                return null;
            }
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.UTIL, "Exception while adding ACS to js file", e);
            return null;
        }
    }

    public void loadPage(String str, String str2) {
        try {
            this.bundleParameters.put("url", str);
            this.bundleParameters.put(PaymentConstants.POST_DATA, str2);
        } catch (JSONException e) {
            this.sdkTracker.trackAndLogException(GODEL, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.System.LOAD_PAGE, "Failed to write to JSON bundle parameters", e);
        }
        if (str2 != null) {
            this.juspayWebView.postUrl(str, str2.getBytes());
        } else {
            this.juspayWebView.loadUrl(str);
        }
    }

    public void onBrowserReady(Activity activity, String str, String str2, String str3, String str4, String str5, String str6) {
        ExecutorManager.runOnMainThread(new C1404te(this, activity, str6, str, str2, str3, str4, str5));
    }

    public WebResourceResponse shouldInterceptRequest(String str) {
        SequenceInputStream sequenceInputStream;
        try {
            JuspayServices juspayServices2 = this.juspayServices;
            String str2 = LOG_TAG;
            juspayServices2.sdkDebug(str2, String.format("Intercepted URL: %s", new Object[]{str}));
            if (!URLUtil.isValidUrl(str) || !isAcsToBeAddedToResource(new URL(str)) || this.isRupaySupportedAdded) {
                WebResourceResponse shouldExcludeResource = shouldExcludeResource(str);
                if (shouldExcludeResource == null) {
                    return null;
                }
                this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.UTIL, "url_excluded", str);
                return shouldExcludeResource;
            }
            URL url = new URL(str);
            this.juspayServices.sdkDebug(str2, String.format("Intercepted URL and modified: %s", new Object[]{str}));
            setIsRupaySupportedAdded(true);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(getAcsScript().getBytes(StandardCharsets.UTF_8));
            try {
                sequenceInputStream = new SequenceInputStream(byteArrayInputStream, FirebasePerfUrlConnection.openStream(url));
                WebResourceResponse webResourceResponse = new WebResourceResponse("text/javascript", "utf-8", sequenceInputStream);
                sequenceInputStream.close();
                byteArrayInputStream.close();
                return webResourceResponse;
            } catch (Throwable th) {
                byteArrayInputStream.close();
                throw th;
            }
            throw th;
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.UTIL, "Error while Caching Files", e);
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
    }
}
