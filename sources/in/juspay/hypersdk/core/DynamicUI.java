package in.juspay.hypersdk.core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.util.Base64;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JsCallback;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.mystique.Callback;
import in.juspay.hypersdk.mystique.DUIWebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;

final class DynamicUI implements JsCallback {
    private Activity activity;
    private final AndroidInterface androidInterface;
    private Context appContext;
    private final String baseContent;
    private final BridgeComponents bridgeComponents;
    private WebView browser;
    private final Callback callback;
    private FrameLayout container;
    private HashMap<String, ViewGroup> fragments;
    private final HashMap<String, Object> globalState = new HashMap<>();
    private final InflateView inflateView;
    private boolean isInitiated = false;
    final Map<String, Object> jsInterfaces;
    private final DuiLogger mLogger;
    private final Renderer renderer;
    private final Map<String, Object> screenMap;
    private final HashMap<String, JSONArray> storedFunctions;
    private Exception webViewCrashException = null;
    private final AtomicReference<WebViewState> webViewState;

    /* renamed from: in.juspay.hypersdk.core.DynamicUI$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersdk$core$WebViewState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                in.juspay.hypersdk.core.WebViewState[] r0 = in.juspay.hypersdk.core.WebViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$in$juspay$hypersdk$core$WebViewState = r0
                in.juspay.hypersdk.core.WebViewState r1 = in.juspay.hypersdk.core.WebViewState.Broken     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$core$WebViewState     // Catch:{ NoSuchFieldError -> 0x001d }
                in.juspay.hypersdk.core.WebViewState r1 = in.juspay.hypersdk.core.WebViewState.Null     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$core$WebViewState     // Catch:{ NoSuchFieldError -> 0x0028 }
                in.juspay.hypersdk.core.WebViewState r1 = in.juspay.hypersdk.core.WebViewState.Created     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$core$WebViewState     // Catch:{ NoSuchFieldError -> 0x0033 }
                in.juspay.hypersdk.core.WebViewState r1 = in.juspay.hypersdk.core.WebViewState.Active     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DynamicUI.AnonymousClass2.<clinit>():void");
        }
    }

    public DynamicUI(Context context, DuiLogger duiLogger, Callback callback2, BridgeComponents bridgeComponents2, String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        this.jsInterfaces = hashMap;
        this.mLogger = duiLogger;
        this.callback = callback2;
        this.bridgeComponents = bridgeComponents2;
        this.webViewState = new AtomicReference<>(WebViewState.Null);
        this.storedFunctions = new HashMap<>();
        if (context instanceof Activity) {
            this.activity = (Activity) context;
        }
        this.appContext = context.getApplicationContext();
        this.screenMap = new HashMap();
        this.fragments = new HashMap<>();
        AndroidInterface androidInterface2 = new AndroidInterface(this);
        this.androidInterface = androidInterface2;
        this.renderer = new Renderer(this);
        this.inflateView = new InflateJSON(this);
        this.baseContent = str == null ? "<html>\n<head>\n    <title>Hyper OS</title>\n</head>\n<body>\n</body>\n<script type=\"text/javascript\">\nwindow.bootLoad = function(){\n    window.DUIGatekeeper = JBridge;\n    var headID = document.getElementsByTagName(\"head\")[0];\n    var newScript = document.createElement('script');\n    newScript.type = 'text/javascript';\n    newScript.id = 'boot_loader';\n    var bundleLoadStart = Date.now();\n    var logViaTracker = function() {\n       var bundleLoadEnd = Date.now();\n       window.__osStart = Date.now();\n       var loadLatency = bundleLoadEnd - bundleLoadStart;\n       var obj = {};\n       obj[\"os_bundle_load\"] = {\"bundle_load_start\":bundleLoadStart,\"bundle_load_end\":bundleLoadEnd,\"bundle_load_latency\":loadLatency};\n       window.__osBundleLoadLogLine = obj;\n    }\n    window.onerror = function (message, src, lno, cno, err) {\n       console.log('ERROR WHILE LOADING SCRIPT');\n       const errorObj = {};\n       errorObj.message = typeof message === 'string' ? message : '';\n       errorObj.source = typeof src === 'string' ? src : '';\n       errorObj.lineNo = typeof lno === 'number' ? lno : -1;\n       errorObj.columnNo = typeof cno === 'number' ? cno : -1;\n       if (typeof err === 'object') {\n           errorObj.stackTrace = typeof err.stack === 'string' ? err.stack : '';\n       }\n       window.scriptError = errorObj;\n       var args = JSON.stringify({ app: \"in.juspay.hyperos\", serializedError: JSON.stringify(errorObj)});\n       JBridge.runInJuspayBrowser(\"onScriptError\", args, \"\");\n    };\n    var loadBundle = function () {\n       newScript.innerHTML = JBridge.loadFileInDUI('v1-boot_loader.jsa');\n       headID.appendChild(newScript);\n       logViaTracker();\n    }\n    loadBundle();\n    setTimeout(function () {\n       if (typeof window.onMerchantEvent !== 'function') {\n           loadBundle();\n           var retryObj = {'retry_tried': 'true'};\n           try {\n               window.Analytics._trackLifeCycle('hypersdk')('info')('bundle_load_retry')(retryObj)();\n           } catch (e) {}\n       }\n    }, 1000);\n}\nJBridge.runInJuspayBrowser(\"onHtmlReady\", \"{}\", \"\");\n </script>\n</html>" : str;
        hashMap.put("Android", androidInterface2);
        hashMap.putAll(map);
        ExecutorManager.runOnMainThread(new t(this, 0));
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    public void createWebView() {
        try {
            this.webViewState.set(WebViewState.Created);
            this.browser = new WebView(this.appContext);
            setupWebView();
            this.browser.getSettings().setJavaScriptEnabled(true);
            for (Map.Entry next : this.jsInterfaces.entrySet()) {
                this.browser.addJavascriptInterface(next.getValue(), (String) next.getKey());
            }
            loadBaseHtml();
            this.callback.webViewLoaded((Exception) null);
        } catch (Exception e) {
            this.webViewState.set(WebViewState.Broken);
            this.webViewCrashException = e;
            this.callback.webViewLoaded(e);
        }
    }

    private String getStringStackTrace(Object obj) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : ((Exception) obj).getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addJavascriptInterface$1(Object obj, String str) {
        WebView webView = this.browser;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
        }
        this.jsInterfaces.put(str, obj);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addJsToWebView$0(String str) {
        StringBuilder sb;
        Callback callback2;
        try {
            WebView webView = this.browser;
            if (webView != null) {
                webView.evaluateJavascript(str, (ValueCallback) null);
            } else {
                logError("browser null, call start first");
            }
        } catch (OutOfMemoryError e) {
            e = e;
            logError("OutOfMemoryError :" + getStringStackTrace(e));
            callback2 = this.callback;
            sb = new StringBuilder("");
            sb.append(getStringStackTrace(e));
            callback2.onError("addJsToWebView", sb.toString());
        } catch (Exception e2) {
            e = e2;
            logError("Exception :" + getStringStackTrace(e));
            callback2 = this.callback;
            sb = new StringBuilder("");
            sb.append(getStringStackTrace(e));
            callback2.onError("addJsToWebView", sb.toString());
        }
    }

    private void loadBaseHtml() {
        ExecutorManager.runOnMainThread(new u(this, 0));
    }

    /* access modifiers changed from: private */
    public void loadData() {
        WebView webView = this.browser;
        if (webView != null) {
            webView.loadDataWithBaseURL((String) null, this.baseContent, "text/html", "utf-8", (String) null);
        }
    }

    private void logError(String str) {
        this.mLogger.e("DynamicUI", str);
    }

    private void setupWebView() {
        WebChromeClient webChromeClient;
        WebView webView;
        if (this.browser != null) {
            if (this.appContext.getResources().getBoolean(R.bool.godel_debuggable)) {
                webView = this.browser;
                webChromeClient = new WebChromeClient();
            } else {
                webView = this.browser;
                webChromeClient = new WebChromeClient() {
                    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                        return true;
                    }
                };
            }
            webView.setWebChromeClient(webChromeClient);
            this.browser.setWebViewClient(new DUIWebViewClient());
        }
    }

    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        ExecutorManager.runOnMainThread(new r((Object) this, 0, obj, (Object) str));
    }

    public void addJsToWebView(String str) {
        ExecutorManager.runOnMainThread(new m(1, this, str));
    }

    public String addToContainerList(ViewGroup viewGroup) {
        String uuid = UUID.randomUUID().toString();
        this.fragments.put(uuid, viewGroup);
        return uuid;
    }

    public void addToScreenMap(String str, Object obj) {
        this.screenMap.put(str, obj);
    }

    public String encodeUtfAndWrapDecode(String str, String str2) {
        try {
            return String.format("decodeURIComponent('%s')", new Object[]{URLEncoder.encode(str, "UTF-8").replace("+", "%20")});
        } catch (UnsupportedEncodingException unused) {
            JuspayLogger.e(str2, "Failed to encode using URLEncoder");
            return String.format("atob('%s')", new Object[]{Base64.encodeToString(str.getBytes(), 2)});
        }
    }

    public Activity getActivity() {
        return this.activity;
    }

    @Keep
    public HashMap<String, JSONArray> getAllFunctions() {
        return this.storedFunctions;
    }

    @Keep
    public HashMap<String, Object> getAllGlobalState() {
        return this.globalState;
    }

    public AndroidInterface getAndroidInterface() {
        return this.androidInterface;
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public BridgeComponents getBridgeComponents() {
        return this.bridgeComponents;
    }

    public ViewGroup getContainer(String str) {
        if (str == null) {
            return this.container;
        }
        return this.fragments.get(str);
    }

    public Callback getErrorCallback() {
        return this.callback;
    }

    public JSONArray getFunction(String str) {
        return this.storedFunctions.get(str);
    }

    public Object getGlobalState(String str) {
        return this.globalState.get(str);
    }

    public InflateView getInflateView() {
        return this.inflateView;
    }

    public DuiLogger getLogger() {
        return this.mLogger;
    }

    public Renderer getRenderer() {
        return this.renderer;
    }

    public String getState() {
        return this.androidInterface.getState();
    }

    public Object getViewFromScreenName(String str) {
        if (this.screenMap.containsKey(str)) {
            return this.screenMap.get(str);
        }
        return null;
    }

    public Exception getWebViewCrashException() {
        return this.webViewCrashException;
    }

    public boolean initiate() {
        this.isInitiated = true;
        int i = AnonymousClass2.$SwitchMap$in$juspay$hypersdk$core$WebViewState[this.webViewState.get().ordinal()];
        if (i == 2) {
            ExecutorManager.runOnMainThread(new s(this, 0));
        } else if (i != 3) {
            if (i != 4) {
                return false;
            }
            addJsToWebView("window.bootLoad()");
            return true;
        }
        return true;
    }

    @Keep
    public void putFunction(String str, JSONArray jSONArray) {
        this.storedFunctions.put(str, jSONArray);
    }

    public void resetActivity() {
        this.activity = null;
        getInflateView().resetState();
    }

    public void setActivity(Activity activity2) {
        if (this.activity != activity2) {
            this.fragments = new HashMap<>();
            getInflateView().resetState();
        }
        this.activity = activity2;
        this.appContext = activity2.getApplicationContext();
    }

    public void setContainer(FrameLayout frameLayout) {
        this.container = frameLayout;
        if (frameLayout != null && frameLayout.isHardwareAccelerated()) {
            this.container.setLayerType(2, (Paint) null);
        }
    }

    public void setGlobalState(String str, Object obj) {
        this.globalState.put(str, obj);
    }

    public void setState(String str) {
        this.androidInterface.setState(str);
    }

    public void setWebViewActive() {
        if (this.isInitiated) {
            addJsToWebView("window.bootLoad()");
        }
        this.webViewState.set(WebViewState.Active);
    }

    public void terminate() {
        if (this.browser != null) {
            this.isInitiated = false;
            this.webViewState.set(WebViewState.Null);
            this.browser.loadDataWithBaseURL("http://juspay.in", "<html></html>", "text/html", "utf-8", (String) null);
            this.browser.stopLoading();
            this.browser.destroy();
            this.browser = null;
            return;
        }
        logError("Browser is not present");
    }
}
