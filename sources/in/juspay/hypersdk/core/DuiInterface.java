package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.zxing.client.android.Intents;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.CallbackInvoker;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.ResultAwaitingDuiHook;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.safe.Godel;
import in.juspay.hypersdk.safe.JuspayWebView;
import in.juspay.hypersdk.services.RemoteAssetService;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersmshandler.JuspayDuiHook;
import in.juspay.hypersmshandler.OnResultHook;
import in.juspay.hypersmshandler.SmsEventInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DuiInterface extends HyperJsInterface implements CallbackInvoker {
    private static final String LOG_TAG = "DuiInterface";
    protected Activity activity;
    protected Map<String, String> callBackMapper;
    private ViewGroup container;
    /* access modifiers changed from: private */
    public final Context context;
    private Godel godelManager;
    private int lastFocusedEditView = -1;
    protected Map<String, Object> listenerMap;
    private final ArrayList<Integer> merchantViewIds = new ArrayList<>();
    private final RemoteAssetService remoteAssetService;
    private final SdkTracker sdkTracker;
    protected final SessionInfo sessionInfo;

    /* renamed from: in.juspay.hypersdk.core.DuiInterface$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                in.juspay.hypersmshandler.SmsEventInterface$RetrieverEvents[] r0 = in.juspay.hypersmshandler.SmsEventInterface.RetrieverEvents.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents = r0
                in.juspay.hypersmshandler.SmsEventInterface$RetrieverEvents r1 = in.juspay.hypersmshandler.SmsEventInterface.RetrieverEvents.ON_ATTACH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents     // Catch:{ NoSuchFieldError -> 0x001d }
                in.juspay.hypersmshandler.SmsEventInterface$RetrieverEvents r1 = in.juspay.hypersmshandler.SmsEventInterface.RetrieverEvents.ON_EXECUTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents     // Catch:{ NoSuchFieldError -> 0x0028 }
                in.juspay.hypersmshandler.SmsEventInterface$RetrieverEvents r1 = in.juspay.hypersmshandler.SmsEventInterface.RetrieverEvents.ON_RECEIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.AnonymousClass3.<clinit>():void");
        }
    }

    public DuiInterface(JuspayServices juspayServices) {
        super(juspayServices);
        this.context = juspayServices.getContext();
        this.sdkTracker = juspayServices.getSdkTracker();
        this.sessionInfo = juspayServices.getSessionInfo();
        this.remoteAssetService = juspayServices.getRemoteAssetService();
        this.listenerMap = new HashMap();
        this.callBackMapper = new HashMap();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$attachMerchantView$1(int i, String str) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        try {
            Activity activity2 = this.activity;
            if (activity2 != null) {
                viewGroup = (ViewGroup) activity2.findViewById(i);
            } else {
                viewGroup = null;
            }
            if (viewGroup == null && (viewGroup2 = this.container) != null) {
                viewGroup = (ViewGroup) viewGroup2.findViewById(i);
            }
            HyperPaymentsCallback hyperCallback = this.juspayServices.getHyperCallback();
            if (viewGroup != null && hyperCallback != null) {
                this.merchantViewIds.add(Integer.valueOf(i));
                View merchantView = hyperCallback.getMerchantView(viewGroup, MerchantViewType.valueOf(str));
                if (merchantView != null) {
                    viewGroup.addView(merchantView);
                }
            }
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Error while attaching merchant view", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$clearMerchantViews$0(Activity activity2) {
        Iterator<Integer> it = this.merchantViewIds.iterator();
        while (it.hasNext()) {
            View findViewById = activity2.findViewById(it.next().intValue());
            if (findViewById instanceof ViewGroup) {
                ((ViewGroup) findViewById).removeAllViews();
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadUrl$6(String str, JuspayWebView juspayWebView, String str2) {
        if (str != null) {
            juspayWebView.postUrl(str2, str.getBytes());
        } else {
            juspayWebView.loadUrl(str2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onDuiReady$2() {
        if (this.godelManager == null) {
            Godel godel = new Godel(this.juspayServices);
            this.godelManager = godel;
            godel.setupAllowedDeeplinkPackages();
            this.godelManager.onDuiReady();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestKeyboardHide$9() {
        String str;
        String str2;
        SdkTracker sdkTracker2;
        try {
            Activity activity2 = this.activity;
            if (activity2 != null) {
                View currentFocus = activity2.getCurrentFocus();
                if (currentFocus == null) {
                    currentFocus = this.activity.getWindow().getDecorView();
                }
                InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
                if (inputMethodManager == null || currentFocus.getRootView() == null) {
                    sdkTracker2 = this.sdkTracker;
                    str2 = "error";
                    str = "failed";
                } else {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getRootView().getWindowToken(), 0);
                    sdkTracker2 = this.sdkTracker;
                    str2 = "info";
                    str = FirebaseAnalytics.Param.SUCCESS;
                }
                sdkTracker2.trackAction(LogSubCategory.Action.SYSTEM, str2, Labels.System.KEYBOARD, "hidden", str);
            }
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.KEYBOARD, "Hide Keyboard Exception", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestKeyboardShow$7(String str) {
        View view;
        try {
            if (this.activity != null) {
                int parseInt = Integer.parseInt(str);
                InputMethodManager inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method");
                View findViewById = this.activity.findViewById(parseInt);
                int i = this.lastFocusedEditView;
                if (i != -1) {
                    view = this.activity.findViewById(i);
                } else {
                    view = null;
                }
                if (!(inputMethodManager == null || findViewById == null)) {
                    if (!(view == null || this.lastFocusedEditView == parseInt)) {
                        view.clearFocus();
                    }
                    findViewById.requestFocus();
                    inputMethodManager.showSoftInput(findViewById, 1);
                }
                if (parseInt != this.lastFocusedEditView) {
                    this.lastFocusedEditView = Integer.parseInt(str);
                }
            }
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.KEYBOARD, "Show Keyboard Exception", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$runInJuspayBrowser$3(String str, SdkTracker sdkTracker2) {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            try {
                View findViewById = activity2.findViewById(Integer.parseInt(str));
                if (this.juspayServices.getHyperCallback() != null) {
                    this.juspayServices.getHyperCallback().onStartWaitingDialogCreated(findViewById);
                }
            } catch (Exception e) {
                sdkTracker2.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "Exception while trying to find a view", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$runInJuspayBrowser$4(String str, final String str2, final SdkTracker sdkTracker2) {
        try {
            if (this.juspayServices.getHyperCallback() != null) {
                this.juspayServices.getHyperCallback().onEvent(new JSONObject(str), new JuspayResponseHandler() {
                    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|5|6|7|11) */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onError(java.lang.String r8) {
                        /*
                            r7 = this;
                            java.lang.String r0 = "payload"
                            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0026 }
                            r1.<init>()     // Catch:{ Exception -> 0x0026 }
                            java.lang.String r2 = "status"
                            java.lang.String r3 = "onError"
                            r1.put(r2, r3)     // Catch:{ Exception -> 0x0026 }
                            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0017 }
                            r2.<init>(r8)     // Catch:{ Exception -> 0x0017 }
                            r1.put(r0, r2)     // Catch:{ Exception -> 0x0017 }
                            goto L_0x001a
                        L_0x0017:
                            r1.put(r0, r8)     // Catch:{ Exception -> 0x0026 }
                        L_0x001a:
                            in.juspay.hypersdk.core.DuiInterface r8 = in.juspay.hypersdk.core.DuiInterface.this     // Catch:{ Exception -> 0x0026 }
                            java.lang.String r0 = r9     // Catch:{ Exception -> 0x0026 }
                            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0026 }
                            r8.invokeCallbackInDUIWebview(r0, r1)     // Catch:{ Exception -> 0x0026 }
                            goto L_0x0037
                        L_0x0026:
                            r8 = move-exception
                            r6 = r8
                            in.juspay.hypersdk.core.SdkTracker r0 = r10
                            java.lang.String r1 = "DuiInterface"
                            java.lang.String r2 = "lifecycle"
                            java.lang.String r3 = "hypersdk"
                            java.lang.String r4 = "run_in_juspay_browser"
                            java.lang.String r5 = "Exception while manipulating JSON"
                            r0.trackAndLogException(r1, r2, r3, r4, r5, r6)
                        L_0x0037:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.AnonymousClass2.onError(java.lang.String):void");
                    }

                    public void onResponse(Bundle bundle) {
                        onResponse(Utils.toJSON(bundle).toString());
                    }

                    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|3|4|5|6|7|11) */
                    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void onResponse(java.lang.String r7) {
                        /*
                            r6 = this;
                            java.lang.String r0 = "payload"
                            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0026 }
                            r1.<init>()     // Catch:{ Exception -> 0x0026 }
                            java.lang.String r2 = "status"
                            java.lang.String r3 = "onResponse"
                            r1.put(r2, r3)     // Catch:{ Exception -> 0x0026 }
                            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0017 }
                            r2.<init>(r7)     // Catch:{ Exception -> 0x0017 }
                            r1.put(r0, r2)     // Catch:{ Exception -> 0x0017 }
                            goto L_0x001a
                        L_0x0017:
                            r1.put(r0, r7)     // Catch:{ Exception -> 0x0026 }
                        L_0x001a:
                            in.juspay.hypersdk.core.DuiInterface r7 = in.juspay.hypersdk.core.DuiInterface.this     // Catch:{ Exception -> 0x0026 }
                            java.lang.String r0 = r9     // Catch:{ Exception -> 0x0026 }
                            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0026 }
                            r7.invokeCallbackInDUIWebview(r0, r1)     // Catch:{ Exception -> 0x0026 }
                            goto L_0x0035
                        L_0x0026:
                            r7 = move-exception
                            r5 = r7
                            in.juspay.hypersdk.core.SdkTracker r0 = r10
                            java.lang.String r1 = "lifecycle"
                            java.lang.String r2 = "hypersdk"
                            java.lang.String r3 = "run_in_juspay_browser"
                            java.lang.String r4 = "Exception while manipulating JSON"
                            r0.trackException(r1, r2, r3, r4, r5)
                        L_0x0035:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.AnonymousClass2.onResponse(java.lang.String):void");
                    }

                    public void run() {
                    }
                });
            }
        } catch (Exception e) {
            sdkTracker2.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.RUN_IN_JUSPAY_BROWSER, "Exception in onEvent handler", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$runInJuspayWebView$5(String str, JuspayWebView juspayWebView) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -2056769213:
                if (str.equals("requestPhoneKeyboardShow")) {
                    c = 0;
                    break;
                }
                break;
            case -1576267742:
                if (str.equals("requestNumericKeyboardShow")) {
                    c = 1;
                    break;
                }
                break;
            case -1326530834:
                if (str.equals("requestPasswordKeyboardShow")) {
                    c = 2;
                    break;
                }
                break;
            case -1241591313:
                if (str.equals("goBack")) {
                    c = 3;
                    break;
                }
                break;
            case -934641255:
                if (str.equals("reload")) {
                    c = 4;
                    break;
                }
                break;
            case -318289731:
                if (str.equals("goForward")) {
                    c = 5;
                    break;
                }
                break;
            case 1275285273:
                if (str.equals("loadFirstPage")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                juspayWebView.requestPhoneKeyboardShow();
                return;
            case 1:
                juspayWebView.requestNumericKeyboardShow();
                return;
            case 2:
                juspayWebView.requestPasswordKeyboardShow();
                return;
            case 3:
                juspayWebView.goBack();
                return;
            case 4:
                PaymentUtils.refreshPage(juspayWebView);
                return;
            case 5:
                juspayWebView.goForward();
                return;
            case 6:
                Godel godel = this.godelManager;
                if (godel != null) {
                    godel.loadPage();
                    return;
                }
                return;
            default:
                this.juspayServices.getSdkTracker().trackAction(LogSubCategory.Action.SYSTEM, "error", Labels.System.RUN_IN_JUSPAY_WEBVIEW, "missing", str);
                return;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$suppressKeyboard$8() {
        Activity activity2 = this.activity;
        if (activity2 != null) {
            activity2.getWindow().setSoftInputMode(3);
        }
    }

    private void trackWebViewEvent(String str) {
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", str, "message", "Received event from web view.");
    }

    @JavascriptInterface
    public void addDataToSharedPrefs(String str, String str2) {
        KeyValueStore.write(this.juspayServices, str, str2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void attach(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            java.lang.String r11 = "Unknown Hook: "
            boolean r0 = r9.isHookSupported(r10)
            java.lang.String r1 = "DuiInterface"
            if (r0 != 0) goto L_0x001c
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Unsupported hook: "
            r11.<init>(r12)
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            in.juspay.hyper.core.JuspayLogger.e(r1, r10)
            return
        L_0x001c:
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ Exception -> 0x00fa }
            r3 = 0
            r2[r3] = r10     // Catch:{ Exception -> 0x00fa }
            r9.detach(r2)     // Catch:{ Exception -> 0x00fa }
            int r2 = r10.hashCode()     // Catch:{ Exception -> 0x00fa }
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            java.lang.String r8 = "SMS_RETRIEVER"
            switch(r2) {
                case -1102737597: goto L_0x0062;
                case -1031869708: goto L_0x0059;
                case -901079619: goto L_0x004f;
                case -74735600: goto L_0x0047;
                case 1205336831: goto L_0x003d;
                case 2031367170: goto L_0x0033;
                default: goto L_0x0032;
            }
        L_0x0032:
            goto L_0x006c
        L_0x0033:
            java.lang.String r2 = "SEND_SMS"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x00fa }
            if (r2 == 0) goto L_0x006c
            r3 = r6
            goto L_0x006d
        L_0x003d:
            java.lang.String r2 = "DELIVER_SMS"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x00fa }
            if (r2 == 0) goto L_0x006c
            r3 = r5
            goto L_0x006d
        L_0x0047:
            boolean r2 = r10.equals(r8)     // Catch:{ Exception -> 0x00fa }
            if (r2 == 0) goto L_0x006c
            r3 = r4
            goto L_0x006d
        L_0x004f:
            java.lang.String r2 = "SMS_RECEIVE"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x00fa }
            if (r2 == 0) goto L_0x006c
            r3 = r0
            goto L_0x006d
        L_0x0059:
            java.lang.String r2 = "SMS_CONSENT"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x00fa }
            if (r2 == 0) goto L_0x006c
            goto L_0x006d
        L_0x0062:
            java.lang.String r2 = "NETWORK_STATUS"
            boolean r2 = r10.equals(r2)     // Catch:{ Exception -> 0x00fa }
            if (r2 == 0) goto L_0x006c
            r3 = r7
            goto L_0x006d
        L_0x006c:
            r3 = -1
        L_0x006d:
            if (r3 == 0) goto L_0x00b7
            if (r3 == r0) goto L_0x00ac
            if (r3 == r7) goto L_0x00a5
            if (r3 == r6) goto L_0x009a
            if (r3 == r5) goto L_0x008f
            if (r3 == r4) goto L_0x0084
            in.juspay.hypersdk.core.JuspayServices r0 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            java.lang.String r11 = r11.concat(r10)     // Catch:{ Exception -> 0x00fa }
            r0.sdkDebug(r1, r11)     // Catch:{ Exception -> 0x00fa }
            r11 = 0
            goto L_0x00c1
        L_0x0084:
            in.juspay.hypersdk.core.JuspayServices r11 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.SmsServices r11 = r11.getSmsServices()     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.JuspayDuiHook r11 = r11.createSmsRetriever()     // Catch:{ Exception -> 0x00fa }
            goto L_0x00c1
        L_0x008f:
            in.juspay.hypersdk.core.JuspayServices r11 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.SmsServices r11 = r11.getSmsServices()     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.JuspayDuiHook r11 = r11.createDeliveredSMSReceiver()     // Catch:{ Exception -> 0x00fa }
            goto L_0x00c1
        L_0x009a:
            in.juspay.hypersdk.core.JuspayServices r11 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.SmsServices r11 = r11.getSmsServices()     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.JuspayDuiHook r11 = r11.createSendSMSReceiver()     // Catch:{ Exception -> 0x00fa }
            goto L_0x00c1
        L_0x00a5:
            in.juspay.hypersdk.core.JuspayServices r11 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersdk.core.ConnectivityReceiver r11 = in.juspay.hypersdk.core.PaymentUtils.getConnectivityReceiver(r11)     // Catch:{ Exception -> 0x00fa }
            goto L_0x00c1
        L_0x00ac:
            in.juspay.hypersdk.core.JuspayServices r11 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.SmsServices r11 = r11.getSmsServices()     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.JuspayDuiHook r11 = r11.createSMSReceiver()     // Catch:{ Exception -> 0x00fa }
            goto L_0x00c1
        L_0x00b7:
            in.juspay.hypersdk.core.JuspayServices r11 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.SmsServices r11 = r11.getSmsServices()     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.JuspayDuiHook r11 = r11.createSmsReceiverForConsent()     // Catch:{ Exception -> 0x00fa }
        L_0x00c1:
            if (r11 == 0) goto L_0x00f2
            android.app.Activity r0 = r9.activity     // Catch:{ Exception -> 0x00fa }
            if (r0 == 0) goto L_0x00f2
            java.util.Map<java.lang.String, java.lang.Object> r0 = r9.listenerMap     // Catch:{ Exception -> 0x00fa }
            r0.put(r10, r11)     // Catch:{ Exception -> 0x00fa }
            boolean r0 = r8.equals(r10)     // Catch:{ Exception -> 0x00fa }
            if (r0 == 0) goto L_0x00e9
            java.util.Map<java.lang.String, java.lang.String> r0 = r9.callBackMapper     // Catch:{ Exception -> 0x00fa }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00fa }
            r1.<init>()     // Catch:{ Exception -> 0x00fa }
            r1.append(r10)     // Catch:{ Exception -> 0x00fa }
            in.juspay.hypersmshandler.SmsEventInterface$RetrieverEvents r10 = in.juspay.hypersmshandler.SmsEventInterface.RetrieverEvents.ON_ATTACH     // Catch:{ Exception -> 0x00fa }
            r1.append(r10)     // Catch:{ Exception -> 0x00fa }
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x00fa }
        L_0x00e5:
            r0.put(r10, r12)     // Catch:{ Exception -> 0x00fa }
            goto L_0x00ec
        L_0x00e9:
            java.util.Map<java.lang.String, java.lang.String> r0 = r9.callBackMapper     // Catch:{ Exception -> 0x00fa }
            goto L_0x00e5
        L_0x00ec:
            android.app.Activity r10 = r9.activity     // Catch:{ Exception -> 0x00fa }
            r11.attach(r10)     // Catch:{ Exception -> 0x00fa }
            goto L_0x010b
        L_0x00f2:
            in.juspay.hypersdk.core.JuspayServices r10 = r9.juspayServices     // Catch:{ Exception -> 0x00fa }
            java.lang.String r11 = "Nothing to attach"
            r10.sdkDebug(r1, r11)     // Catch:{ Exception -> 0x00fa }
            goto L_0x010b
        L_0x00fa:
            r10 = move-exception
            r6 = r10
            in.juspay.hypersdk.core.SdkTracker r0 = r9.sdkTracker
            java.lang.String r1 = "DuiInterface"
            java.lang.String r2 = "action"
            java.lang.String r3 = "system"
            java.lang.String r4 = "jbridge"
            java.lang.String r5 = "Error while retrieving arguments"
            r0.trackAndLogException(r1, r2, r3, r4, r5, r6)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.attach(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public void attachMerchantView(int i, String str) {
        if (this.juspayServices.getHyperCallback() != null) {
            ExecutorManager.runOnMainThread(new Q8(this, i, 1, str));
        }
    }

    @JavascriptInterface
    public String checkPermission(String[] strArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : strArr) {
                jSONObject.put(str.replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, str));
            }
        } catch (JSONException e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.READ_SMS_PERMISSION, "Error while inserting in json", e);
        }
        return jSONObject.toString();
    }

    @JavascriptInterface
    public String checkReadSMSPermission() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("android.permission.READ_SMS".replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, "android.permission.READ_SMS"));
            jSONObject.put("android.permission.RECEIVE_SMS".replace("android.permission.", ""), Utils.checkIfGranted(this.juspayServices, "android.permission.RECEIVE_SMS"));
        } catch (JSONException e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.READ_SMS_PERMISSION, "Error while inserting in json", e);
        }
        return jSONObject.toString();
    }

    public void clearMerchantViews(Activity activity2) {
        if (activity2 != null) {
            ExecutorManager.runOnMainThread(new A1(6, this, activity2));
        }
    }

    @JavascriptInterface
    public void closeBrowser(String str) {
        reset();
    }

    @JavascriptInterface
    public void detach(String[] strArr) {
        JuspayDuiHook juspayDuiHook;
        for (String str : strArr) {
            if (this.listenerMap.containsKey(str) && this.activity != null) {
                if ((this.listenerMap.get(str) instanceof JuspayDuiHook) && (juspayDuiHook = (JuspayDuiHook) this.listenerMap.get(str)) != null) {
                    juspayDuiHook.detach(this.activity);
                }
                this.listenerMap.remove(str);
            }
        }
    }

    @JavascriptInterface
    public void doHandShake(String str, String str2) {
        try {
            SdkTracker sdkTracker2 = this.sdkTracker;
            sdkTracker2.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.JBRIDGE, "dui_interface_do_handshake", "Doing handshake with following parameters: " + str);
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
            String string2 = jSONObject.getString("className");
            int i = jSONObject.getInt("code");
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(PaymentConstants.PAYLOAD));
            Bundle bundle = new Bundle();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle.putString(next, jSONObject2.getString(next));
            }
            MPINUtil.communicate(string, string2, i, bundle, this.juspayServices, str2);
        } catch (Exception e) {
            MPINUtil.reportBindFailure(-1, this.juspayServices, str2);
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception at doHandShake", e);
        }
    }

    @JavascriptInterface
    public String execute(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (!this.listenerMap.containsKey(str) || this.activity == null) {
                return "";
            }
            JuspayDuiHook juspayDuiHook = (JuspayDuiHook) this.listenerMap.get(str);
            if (juspayDuiHook == null) {
                return "__failed";
            }
            if (PaymentConstants.SMS_RETRIEVER.equals(str)) {
                if ("getOtp".equals(str2)) {
                    Map<String, String> map = this.callBackMapper;
                    map.put(PaymentConstants.SMS_RETRIEVER + SmsEventInterface.RetrieverEvents.ON_RECEIVE, str4);
                } else if ("cancel".equals(str2)) {
                    Map<String, String> map2 = this.callBackMapper;
                    map2.put(PaymentConstants.SMS_RETRIEVER + SmsEventInterface.RetrieverEvents.ON_RECEIVE, (Object) null);
                }
            }
            return juspayDuiHook.execute(this.activity, str2, jSONObject);
        } catch (JSONException e) {
            JSONException jSONException = e;
            SdkTracker sdkTracker2 = this.sdkTracker;
            sdkTracker2.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Error while executing " + str2 + " with args " + str3, jSONException);
            return "";
        }
    }

    @JavascriptInterface
    public String fetchFromInbox(String str) {
        return this.juspayServices.getSmsServices().fetchSms(str, "inbox", (String) null);
    }

    @JavascriptInterface
    public void fetchSMS(String str, String str2, String str3, String str4) {
        invokeCallbackInDUIWebview(str4, this.juspayServices.getSmsServices().fetchSms(str, str2, str3));
    }

    @JavascriptInterface
    public String findViewType(String str) {
        View view;
        Activity activity2;
        try {
            if (this.juspayServices.getContainer() != null) {
                view = this.juspayServices.getContainer().findViewById(Integer.parseInt(str));
            } else {
                view = null;
            }
            if (view == null && (activity2 = this.activity) != null) {
                view = activity2.findViewById(Integer.parseInt(str));
            }
            if (view != null) {
                return view.getClass().getName();
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    @JavascriptInterface
    public String getClipboardItems() {
        return "[]";
    }

    @JavascriptInterface
    public String getConfigVariables() {
        try {
            return PaymentUtils.getConfigVariableDeclarations(this.juspayServices.getContext(), this.juspayServices.getSessionInfo());
        } catch (JSONException e) {
            JuspayLogger.e(LOG_TAG, "", e);
            return "var clientId = null;var juspayDeviceId = null;var juspayAndroidId = null;var godelRemotesVersion = null;var godelVersion = null;var buildVersion = null;var os_version = null;";
        }
    }

    @JavascriptInterface
    public String getDataFromSharedPrefs(String str, String str2) {
        return KeyValueStore.read(this.juspayServices, str, str2);
    }

    @JavascriptInterface
    public String getIndexBundleHash(String str) {
        String replace = str.replace(".zip", ".jsa");
        try {
            return this.remoteAssetService.getMetadata(replace.substring(replace.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1).replace(".zip", ".jsa")).getString(PaymentConstants.ATTR_HASH_IN_DISK);
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "exception during IndexBundleHash", e);
            return null;
        }
    }

    @JavascriptInterface
    public String getKeysInSharedPrefs() {
        try {
            JSONArray jSONArray = new JSONArray();
            for (String put : KeyValueStore.getAll(this.juspayServices).keySet()) {
                jSONArray.put(put);
            }
            return jSONArray.toString();
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.SHARED_PREF, "Exception while getting all keys from shared prefs", e);
            return "[]";
        }
    }

    @JavascriptInterface
    public String getNetworkType() {
        return this.sessionInfo.getNetworkInfo();
    }

    @JavascriptInterface
    public String getPackageInfo(String str) {
        try {
            PackageInfo packageInfo = this.juspayServices.getContext().getPackageManager().getPackageInfo(str, 0);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, packageInfo.packageName);
            jSONObject.put("versionName", packageInfo.versionName);
            jSONObject.put("versionCode", packageInfo.versionCode);
            return jSONObject.toString();
        } catch (Exception e) {
            this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.DEBUG, Labels.System.JBRIDGE, "Exception at getPackageInfo", e);
            return "{}";
        }
    }

    @JavascriptInterface
    public String getPaymentDetails() {
        return this.juspayServices.getPaymentSessionInfo().getPaymentDetails().toString();
    }

    @JavascriptInterface
    public float getPixels() {
        return this.context.getResources().getDisplayMetrics().density;
    }

    @JavascriptInterface
    public int getResourceIdentifier(String str, String str2) {
        try {
            return this.context.getResources().getIdentifier(str, str2, this.context.getPackageName());
        } catch (Exception unused) {
            return 0;
        }
    }

    @JavascriptInterface
    public String getSessionAttribute(String str) {
        return getSessionAttribute(str, "");
    }

    @JavascriptInterface
    public String getSessionDetails() {
        return this.juspayServices.getPaymentSessionInfo().getSessionDetails().toString();
    }

    @JavascriptInterface
    public String getSessionInfo() {
        this.juspayServices.getPaymentSessionInfo().createSessionDataMap();
        return this.sessionInfo.getSessionData().toString();
    }

    public SmsEventInterface getSmsEventInterface() {
        return new SmsEventInterface() {
            public void onActivityResultEvent(String str) {
                DuiInterface duiInterface = DuiInterface.this;
                duiInterface.invokeCallbackInDUIWebview(duiInterface.callBackMapper.get(PaymentConstants.SMS_CONSENT), str);
            }

            public void onSentReceiverEvent(int i) {
                StringBuilder sb;
                String str;
                if (DuiInterface.this.callBackMapper.get(PaymentConstants.SEND_SMS) != null) {
                    String str2 = "window.callUICallback(\"" + DuiInterface.this.callBackMapper.get(PaymentConstants.SEND_SMS);
                    if (i == -1) {
                        Toast.makeText(DuiInterface.this.context, "SMS SENT", 0).show();
                        sb = new StringBuilder();
                        sb.append(str2);
                        str = "\", \"SUCCESS\")";
                    } else if (i == 1) {
                        Toast.makeText(DuiInterface.this.context, "SMS GENERIC FAILURE", 0).show();
                        sb = new StringBuilder();
                        sb.append(str2);
                        str = "\", \"Generic failure\", \"837\")";
                    } else if (i == 2) {
                        Toast.makeText(DuiInterface.this.context, "SMS RADIO OFF", 0).show();
                        sb = new StringBuilder();
                        sb.append(str2);
                        str = "\", \"Radio off\", \"840\")";
                    } else if (i == 3) {
                        Toast.makeText(DuiInterface.this.context, "SMS NULL PDU", 0).show();
                        sb = new StringBuilder();
                        sb.append(str2);
                        str = "\", \"Null PDU\", \"839\")";
                    } else if (i != 4) {
                        sb = xx.J(str2);
                        str = "\", \"Unable to Send SMS\", \"837\")";
                    } else {
                        Toast.makeText(DuiInterface.this.context, "SMS NO SERVICE", 0).show();
                        sb = new StringBuilder();
                        sb.append(str2);
                        str = "\", \"No service\", \"838\")";
                    }
                    sb.append(str);
                    DuiInterface.this.invokeFnInDUIWebview(sb.toString());
                }
            }

            public void onSmsConsentEvent(Intent intent, int i, Bundle bundle) {
                DuiInterface.this.juspayServices.startActivityForResult(intent, i, bundle);
                DuiInterface.this.invokeFnInDUIWebview("onSMSConsentShown", "{ }");
            }

            public void onSmsReceiverEvent(String str) {
                DuiInterface duiInterface = DuiInterface.this;
                duiInterface.invokeCallbackInDUIWebview(duiInterface.callBackMapper.get(PaymentConstants.SMS_RECEIVE), str);
            }

            public void onSmsRetrieverEvent(SmsEventInterface.RetrieverEvents retrieverEvents, String str) {
                DuiInterface duiInterface;
                StringBuilder sb;
                SmsEventInterface.RetrieverEvents retrieverEvents2;
                Map<String, String> map;
                int i = AnonymousClass3.$SwitchMap$in$juspay$hypersmshandler$SmsEventInterface$RetrieverEvents[retrieverEvents.ordinal()];
                if (i == 1) {
                    duiInterface = DuiInterface.this;
                    map = duiInterface.callBackMapper;
                    sb = new StringBuilder(PaymentConstants.SMS_RETRIEVER);
                    retrieverEvents2 = SmsEventInterface.RetrieverEvents.ON_ATTACH;
                } else if (i == 2) {
                    duiInterface = DuiInterface.this;
                    map = duiInterface.callBackMapper;
                    sb = new StringBuilder(PaymentConstants.SMS_RETRIEVER);
                    retrieverEvents2 = SmsEventInterface.RetrieverEvents.ON_RECEIVE;
                } else if (i == 3) {
                    DuiInterface duiInterface2 = DuiInterface.this;
                    Map<String, String> map2 = duiInterface2.callBackMapper;
                    StringBuilder sb2 = new StringBuilder(PaymentConstants.SMS_RETRIEVER);
                    SmsEventInterface.RetrieverEvents retrieverEvents3 = SmsEventInterface.RetrieverEvents.ON_RECEIVE;
                    sb2.append(retrieverEvents3);
                    duiInterface2.invokeCallbackInDUIWebview(map2.get(sb2.toString()), str);
                    if (!Intents.Scan.TIMEOUT.equals(str)) {
                        Map<String, String> map3 = DuiInterface.this.callBackMapper;
                        map3.put(PaymentConstants.SMS_RETRIEVER + retrieverEvents3, (Object) null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
                sb.append(retrieverEvents2);
                duiInterface.invokeCallbackInDUIWebview(map.get(sb.toString()), str);
            }
        };
    }

    @JavascriptInterface
    public void invokeCallbackInACSWebview(String str, String str2) {
        if (this.godelManager != null) {
            this.godelManager.getJuspayWebView().addJsToWebView(String.format("window.__PROXY_FN['%s'](atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)}));
        }
    }

    @JavascriptInterface
    public void invokeCallbackInDUIWebview(String str, String str2) {
        this.juspayServices.getDynamicUI().addJsToWebView(String.format("window.callUICallback('%s',atob('%s'));", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)}));
    }

    @JavascriptInterface
    public void invokeCustomFnInDUIWebview(String str) {
        this.juspayServices.getDynamicUI().addJsToWebView(str);
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str) {
        invokeCustomFnInDUIWebview(str);
    }

    @JavascriptInterface
    public void invokeInACSWebview(String str, String str2) {
        if (this.godelManager != null) {
            this.godelManager.getJuspayWebView().addJsToWebView(String.format("javascript:window.onAcsFunctionCalled('%s',atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)}));
        }
    }

    @JavascriptInterface
    public String isAppInstalled(String str) {
        try {
            this.juspayServices.getContext().getPackageManager().getPackageInfo(str, 128);
            return "true";
        } catch (PackageManager.NameNotFoundException unused) {
            return "false";
        }
    }

    @JavascriptInterface
    public String isDeviceSecure() {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) this.context.getSystemService("keyguard");
            if (keyguardManager == null) {
                return "UNKNOWN";
            }
            if (keyguardManager.isDeviceSecure()) {
                return "SECURE";
            }
            return "NOT_SECURE";
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while checking KeyguardManager.isDeviceSecure()", e);
            return "UNKNOWN";
        }
    }

    @JavascriptInterface
    public boolean isHookSupported(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1102737597:
                if (str.equals(PaymentConstants.NETWORK_STATUS)) {
                    c = 0;
                    break;
                }
                break;
            case -1031869708:
                if (str.equals(PaymentConstants.SMS_CONSENT)) {
                    c = 1;
                    break;
                }
                break;
            case -901079619:
                if (str.equals(PaymentConstants.SMS_RECEIVE)) {
                    c = 2;
                    break;
                }
                break;
            case -74735600:
                if (str.equals(PaymentConstants.SMS_RETRIEVER)) {
                    c = 3;
                    break;
                }
                break;
            case 1205336831:
                if (str.equals(PaymentConstants.DELIVER_SMS)) {
                    c = 4;
                    break;
                }
                break;
            case 2031367170:
                if (str.equals(PaymentConstants.SEND_SMS)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    @JavascriptInterface
    public boolean isOnline() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Activity activity2 = this.activity;
        if (activity2 != null) {
            connectivityManager = (ConnectivityManager) activity2.getSystemService("connectivity");
        } else {
            connectivityManager = null;
        }
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    @JavascriptInterface
    public void loadUrl(String str, String str2) {
        Godel godel = this.godelManager;
        if (godel != null && str != null) {
            ExecutorManager.runOnMainThread(new b(str2, godel.getJuspayWebView(), str));
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        String str;
        StringBuilder sb;
        SdkTracker sdkTracker2;
        String name;
        String str2;
        for (Object next : this.listenerMap.values()) {
            if ((next instanceof ResultAwaitingDuiHook) && ((ResultAwaitingDuiHook) next).onActivityResult(i, i2, intent)) {
                sdkTracker2 = this.sdkTracker;
                name = next.getClass().getName();
                str2 = "Result consumed by ResultAwaitingDuiHook ";
            } else if ((next instanceof OnResultHook) && ((OnResultHook) next).onActivityResult(i, i2, intent)) {
                sdkTracker2 = this.sdkTracker;
                name = next.getClass().getName();
                str2 = "Result consumed by OnResultHook ";
            }
            sdkTracker2.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, str2.concat(name));
            return;
        }
        if (intent != null) {
            JSONObject json = Utils.toJSON(intent.getExtras());
            String encodeToString = Base64.encodeToString(json.toString().getBytes(), 2);
            SdkTracker sdkTracker3 = this.sdkTracker;
            sdkTracker3.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, "Passing data to micro-app. Data is " + json);
            sb = C1058d.C("window.onActivityResult('", i, "', '", i2, "', atob('");
            sb.append(encodeToString);
            str = "'))";
        } else {
            this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.JBRIDGE, Labels.Android.ON_ACTIVITY_RESULT, "Got empty data in onActivityResult. Passing callback to micro-app.");
            StringBuilder sb2 = new StringBuilder("window.onActivityResult('");
            sb2.append(i);
            sb2.append("', '");
            sb2.append(i2);
            str = "', '{}')";
            sb = sb2;
        }
        sb.append(str);
        invokeFnInDUIWebview(sb.toString());
    }

    @JavascriptInterface
    public void onDuiReady() {
        ExecutorManager.runOnMainThread(new s(this, 1));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        try {
            Object obj = this.listenerMap.get(PaymentConstants.REQUEST_PERMISSION_PREFIX + i);
            if (obj instanceof String) {
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    String replace = strArr[i2].replace("android.permission.", "");
                    if (iArr[i2] == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    jSONObject.put(replace, z);
                }
                invokeCallbackInDUIWebview((String) obj, jSONObject.toString());
            } else if (obj instanceof Handler.Callback) {
                Message obtain = Message.obtain();
                obtain.obj = iArr;
                ((Handler.Callback) obj).handleMessage(obtain);
            } else {
                JuspayLogger.e(LOG_TAG, "callback instance not understandable");
            }
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.ON_REQUEST_PERMISSION_RESULT, "Error while inserting in json", e);
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2) {
        if (URLUtil.isValidUrl(str2)) {
            onWebViewReady(str, str2, (String) null);
        } else {
            this.sdkTracker.trackAction(LogSubCategory.Action.SYSTEM, "error", Labels.System.ON_WEBVIEW_READY, "valid_url", Boolean.FALSE);
        }
    }

    @JavascriptInterface
    public void onWebViewReleased() {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.onDuiReleased();
            this.godelManager = null;
        }
    }

    @JavascriptInterface
    public void openAppWithExplicitIntent(String str, String str2, String str3, int i, int i2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, str3);
            Intent intent = new Intent();
            if (i2 >= 0) {
                intent.setFlags(i2);
            }
            intent.putExtras(bundle);
            intent.setComponent(new ComponentName(str, str2));
            this.juspayServices.startActivityForResult(intent, Math.max(i, -1), (Bundle) null);
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "on method openAppWithExplicitIntent: ", e);
        }
    }

    @JavascriptInterface
    public void refreshPage() {
        Godel godel = this.godelManager;
        if (godel != null) {
            PaymentUtils.refreshPage(godel.getJuspayWebView());
        }
    }

    @JavascriptInterface
    public void requestKeyboardHide() {
        ExecutorManager.runOnMainThread(new u(this, 1));
    }

    @JavascriptInterface
    public void requestKeyboardShow() {
        Godel godel = this.godelManager;
        if (godel != null) {
            JuspayWebView juspayWebView = godel.getJuspayWebView();
            InputMethodManager inputMethodManager = (InputMethodManager) this.context.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(juspayWebView, 1);
            }
        }
    }

    public void requestPermission(String[] strArr, String str, Handler.Callback callback) {
        this.juspayServices.requestPermission(strArr, Integer.parseInt(str));
        Map<String, Object> map = this.listenerMap;
        map.put(PaymentConstants.REQUEST_PERMISSION_PREFIX + str, callback);
    }

    @JavascriptInterface
    public void requestSMSPermission(String str) {
        requestPermission(new String[]{"android.permission.READ_SMS", "android.permission.RECEIVE_SMS"}, String.valueOf(7), str);
    }

    public void reset() {
        try {
            ArrayList arrayList = new ArrayList();
            for (String next : this.listenerMap.keySet()) {
                if (this.listenerMap.get(next) instanceof JuspayDuiHook) {
                    arrayList.add(next);
                }
            }
            detach((String[]) arrayList.toArray(new String[0]));
            Godel godel = this.godelManager;
            if (godel != null) {
                godel.onDuiReleased();
                this.godelManager = null;
            }
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Exception while removing Dui Hooks", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x010c, code lost:
        in.juspay.hyper.core.ExecutorManager.runOnMainThread(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x017e, code lost:
        updateLoaded(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        return;
     */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runInJuspayBrowser(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            in.juspay.hypersdk.core.JuspayServices r0 = r8.juspayServices
            in.juspay.hypersdk.core.SdkTracker r0 = r0.getSdkTracker()
            r9.getClass()
            int r1 = r9.hashCode()
            r2 = 2
            r3 = 1
            r4 = 0
            r5 = -1
            switch(r1) {
                case -1895485031: goto L_0x004c;
                case -1881018714: goto L_0x0041;
                case -1349867671: goto L_0x0036;
                case -1349761029: goto L_0x002b;
                case -245602922: goto L_0x0020;
                case 137650334: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0056
        L_0x0015:
            java.lang.String r1 = "onScriptError"
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x001e
            goto L_0x0056
        L_0x001e:
            r5 = 5
            goto L_0x0056
        L_0x0020:
            java.lang.String r1 = "onStartWaitingDialogCreated"
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x0029
            goto L_0x0056
        L_0x0029:
            r5 = 4
            goto L_0x0056
        L_0x002b:
            java.lang.String r1 = "onEvent"
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x0034
            goto L_0x0056
        L_0x0034:
            r5 = 3
            goto L_0x0056
        L_0x0036:
            java.lang.String r1 = "onError"
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x003f
            goto L_0x0056
        L_0x003f:
            r5 = r2
            goto L_0x0056
        L_0x0041:
            java.lang.String r1 = "onBundleLoaded"
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x004a
            goto L_0x0056
        L_0x004a:
            r5 = r3
            goto L_0x0056
        L_0x004c:
            java.lang.String r1 = "onHtmlReady"
            boolean r1 = r9.equals(r1)
            if (r1 != 0) goto L_0x0055
            goto L_0x0056
        L_0x0055:
            r5 = r4
        L_0x0056:
            java.lang.String r1 = ""
            switch(r5) {
                case 0: goto L_0x0182;
                case 1: goto L_0x017c;
                case 2: goto L_0x0179;
                case 3: goto L_0x00ae;
                case 4: goto L_0x00a8;
                case 5: goto L_0x006a;
                default: goto L_0x005b;
            }
        L_0x005b:
            java.lang.String r2 = "system"
            java.lang.String r3 = "error"
            java.lang.String r4 = "run_in_juspay_browser"
            java.lang.String r5 = "missing"
            r1 = r0
            r6 = r9
            r1.trackAction(r2, r3, r4, r5, r6)
            goto L_0x0190
        L_0x006a:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0095 }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x0095 }
            java.lang.String r10 = "app"
            java.lang.String r10 = r9.optString(r10, r1)     // Catch:{ JSONException -> 0x0095 }
            java.lang.String r11 = "serializedError"
            java.lang.String r9 = r9.optString(r11, r1)     // Catch:{ JSONException -> 0x0095 }
            java.lang.String r11 = "Failed to load script for app: '%s', due to error: %s"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ JSONException -> 0x0095 }
            r1[r4] = r10     // Catch:{ JSONException -> 0x0095 }
            r1[r3] = r9     // Catch:{ JSONException -> 0x0095 }
            java.lang.String r6 = java.lang.String.format(r11, r1)     // Catch:{ JSONException -> 0x0095 }
            java.lang.String r2 = "hypersdk"
            java.lang.String r3 = "error"
            java.lang.String r4 = "on_script_error"
            java.lang.String r5 = "message"
            r1 = r0
            r1.trackLifecycle(r2, r3, r4, r5, r6)     // Catch:{ JSONException -> 0x0095 }
            goto L_0x0190
        L_0x0095:
            r9 = move-exception
            java.lang.String r10 = "DuiInterface"
            java.lang.String r11 = "lifecycle"
            java.lang.String r1 = "hypersdk"
            java.lang.String r2 = "run_in_juspay_browser"
            java.lang.String r3 = "error while dealing with json onEvent"
            r7 = r9
            r4 = r1
            r5 = r2
            r6 = r3
            r2 = r10
            r3 = r11
            goto L_0x0174
        L_0x00a8:
            in.juspay.hypersdk.core.r r9 = new in.juspay.hypersdk.core.r
            r9.<init>((in.juspay.hypersdk.core.JsInterface) r8, (java.lang.String) r10, (java.lang.Object) r0, (int) r3)
            goto L_0x010c
        L_0x00ae:
            in.juspay.hypersdk.core.JuspayServices r9 = r8.juspayServices
            boolean r9 = r9.isPrefetch()
            java.lang.String r5 = "onJOSReady"
            java.lang.String r6 = "event"
            if (r9 != 0) goto L_0x0111
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00f7 }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x00f7 }
            java.lang.String r2 = r9.optString(r6, r1)     // Catch:{ JSONException -> 0x00f7 }
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x00f7 }
            if (r2 == 0) goto L_0x00e3
            java.lang.String r9 = "on_jos_ready"
            r8.trackWebViewEvent(r9)     // Catch:{ JSONException -> 0x00f7 }
            in.juspay.hypersdk.core.JuspayServices r9 = r8.juspayServices     // Catch:{ JSONException -> 0x00f7 }
            org.json.JSONObject r9 = r9.getBundleParameters()     // Catch:{ JSONException -> 0x00f7 }
            if (r9 == 0) goto L_0x0190
            in.juspay.hypersdk.core.JuspayServices r9 = r8.juspayServices     // Catch:{ JSONException -> 0x00f7 }
            java.lang.String r1 = "initiate"
            org.json.JSONObject r2 = r9.getBundleParameters()     // Catch:{ JSONException -> 0x00f7 }
            r9.onMerchantEvent(r1, r2)     // Catch:{ JSONException -> 0x00f7 }
            goto L_0x0190
        L_0x00e3:
            java.lang.String r2 = "action"
            java.lang.String r9 = r9.optString(r2, r1)     // Catch:{ JSONException -> 0x00f7 }
            java.lang.String r1 = "DUI_READY"
            boolean r9 = r9.equals(r1)     // Catch:{ JSONException -> 0x00f7 }
            if (r9 == 0) goto L_0x0107
            java.lang.String r9 = "dui_ready"
            r8.trackWebViewEvent(r9)     // Catch:{ JSONException -> 0x00f7 }
            goto L_0x0107
        L_0x00f7:
            r9 = move-exception
            r7 = r9
            java.lang.String r2 = "DuiInterface"
            java.lang.String r3 = "lifecycle"
            java.lang.String r4 = "hypersdk"
            java.lang.String r5 = "run_in_juspay_browser"
            java.lang.String r6 = "error while dealing with json onEvent"
            r1 = r0
            r1.trackAndLogException(r2, r3, r4, r5, r6, r7)
        L_0x0107:
            in.juspay.hypersdk.core.p r9 = new in.juspay.hypersdk.core.p
            r9.<init>((in.juspay.hypersdk.core.DuiInterface) r8, (java.lang.String) r10, (java.lang.String) r11, (in.juspay.hypersdk.core.SdkTracker) r0)
        L_0x010c:
            in.juspay.hyper.core.ExecutorManager.runOnMainThread(r9)
            goto L_0x0190
        L_0x0111:
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x015f }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x015f }
            java.lang.String r11 = r9.optString(r6)     // Catch:{ JSONException -> 0x015f }
            java.lang.String r1 = "prefetch_result"
            boolean r11 = java.util.Objects.equals(r11, r1)     // Catch:{ JSONException -> 0x015f }
            if (r11 == 0) goto L_0x012f
            in.juspay.hypersdk.core.JuspayServices r11 = r8.juspayServices     // Catch:{ JSONException -> 0x015f }
            java.util.Objects.requireNonNull(r11)     // Catch:{ JSONException -> 0x015f }
            E9 r1 = new E9     // Catch:{ JSONException -> 0x015f }
            r1.<init>(r11, r4)     // Catch:{ JSONException -> 0x015f }
            in.juspay.hyper.core.ExecutorManager.runOnMainThread(r1)     // Catch:{ JSONException -> 0x015f }
        L_0x012f:
            java.lang.String r9 = r9.getString(r6)     // Catch:{ JSONException -> 0x015f }
            boolean r9 = r9.equals(r5)     // Catch:{ JSONException -> 0x015f }
            if (r9 == 0) goto L_0x0190
            in.juspay.hypersdk.core.JuspayServices r9 = r8.juspayServices     // Catch:{ JSONException -> 0x015f }
            org.json.JSONObject r9 = r9.getBundleParameters()     // Catch:{ JSONException -> 0x015f }
            if (r9 == 0) goto L_0x0190
            java.lang.String r11 = "window.onMerchantEvent('%s',atob('%s'));"
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ JSONException -> 0x015f }
            java.lang.String r5 = "prefetch"
            r1[r4] = r5     // Catch:{ JSONException -> 0x015f }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x015f }
            byte[] r9 = r9.getBytes()     // Catch:{ JSONException -> 0x015f }
            java.lang.String r9 = android.util.Base64.encodeToString(r9, r2)     // Catch:{ JSONException -> 0x015f }
            r1[r3] = r9     // Catch:{ JSONException -> 0x015f }
            java.lang.String r9 = java.lang.String.format(r11, r1)     // Catch:{ JSONException -> 0x015f }
            r8.invokeCustomFnInDUIWebview(r9)     // Catch:{ JSONException -> 0x015f }
            goto L_0x0190
        L_0x015f:
            r9 = move-exception
            java.lang.String r11 = "error while dealing with json onEvent "
            java.lang.String r10 = defpackage.C0709Uj.i(r11, r10)
            java.lang.String r11 = "DuiInterface"
            java.lang.String r1 = "lifecycle"
            java.lang.String r2 = "hypersdk"
            java.lang.String r3 = "run_in_juspay_browser"
            r7 = r9
            r6 = r10
            r4 = r2
            r5 = r3
            r2 = r11
            r3 = r1
        L_0x0174:
            r1 = r0
            r1.trackAndLogException(r2, r3, r4, r5, r6, r7)
            goto L_0x0190
        L_0x0179:
            java.lang.String r9 = "not_loaded"
            goto L_0x017e
        L_0x017c:
            java.lang.String r9 = "loaded"
        L_0x017e:
            r8.updateLoaded(r10, r9)
            goto L_0x0190
        L_0x0182:
            java.lang.String r9 = "on_html_ready"
            r8.trackWebViewEvent(r9)
            in.juspay.hypersdk.core.JuspayServices r9 = r8.juspayServices
            in.juspay.hypersdk.core.DynamicUI r9 = r9.getDynamicUI()
            r9.setWebViewActive()
        L_0x0190:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.DuiInterface.runInJuspayBrowser(java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JavascriptInterface
    public void runInJuspayWebView(String str) {
        Godel godel = this.godelManager;
        if (godel != null) {
            ExecutorManager.runOnMainThread(new r((JsInterface) this, str, (Object) godel.getJuspayWebView(), 2));
        }
    }

    public void setActivity(Activity activity2) {
        this.activity = activity2;
    }

    @JavascriptInterface
    public void setCardBrand(String str) {
        this.juspayServices.getPaymentSessionInfo().setPaymentDetails("card_brand", str);
    }

    @JavascriptInterface
    public void setConfig(String str) {
        if (this.godelManager != null) {
            try {
                this.godelManager.setConfig(new JSONObject(str));
            } catch (JSONException e) {
                this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, "Error while capturing config json", e);
            }
        }
    }

    public void setContainer(ViewGroup viewGroup) {
        this.container = viewGroup;
    }

    @JavascriptInterface
    public void setIsRupaySupportedAdded(boolean z) {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.setIsRupaySupportedAdded(z);
        }
    }

    @JavascriptInterface
    public void setSessionDetails(String str, String str2) {
        this.juspayServices.getPaymentSessionInfo().addToSessionDetails(str, str2);
    }

    @JavascriptInterface
    public String shouldShowRequestPermissionRationale(String str) {
        try {
            Activity activity2 = this.activity;
            if (activity2 != null) {
                return String.valueOf(activity2.shouldShowRequestPermissionRationale(str));
            }
            return null;
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.PERMISSION, "Exception while checking shouldShowRequestPermissionRationale", e);
            return null;
        }
    }

    @JavascriptInterface
    public void storeCookies() {
        CookieSyncManager.getInstance().sync();
    }

    @JavascriptInterface
    public void suppressKeyboard() {
        ExecutorManager.runOnMainThread(new t(this, 1));
    }

    @JavascriptInterface
    public void updateLoaded(String str, String str2) {
        Exception exc;
        SdkTracker sdkTracker2 = this.juspayServices.getSdkTracker();
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("fileName")) {
                str3 = jSONObject.getString("fileName");
            }
            String str4 = str3;
            try {
                JSONObject jSONObject2 = new JSONObject(getDataFromSharedPrefs(PaymentConstants.JP_HASH_AND_STATUS, "{}"));
                JSONObject jSONObject3 = new JSONObject();
                if (jSONObject2.has(str4)) {
                    jSONObject3 = jSONObject2.getJSONObject(str4);
                } else {
                    sdkTracker2.trackAction(LogSubCategory.Action.SYSTEM, LogLevel.CRITICAL, Labels.HyperSdk.AUTO_FALLBACK, "loaded", "hash doesn't have a filename");
                }
                jSONObject3.put("status", str2);
                jSONObject2.put(str4, jSONObject3);
                addDataToSharedPrefs(PaymentConstants.JP_HASH_AND_STATUS, jSONObject2.toString());
                JuspayLogger.d(LOG_TAG, "udpateLoaded: ");
            } catch (Exception e) {
                str3 = str4;
                exc = e;
                sdkTracker2.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.AUTO_FALLBACK, C0709Uj.i("Exception while updating the loaded status for file ", str3), exc);
            }
        } catch (Exception e2) {
            exc = e2;
            sdkTracker2.trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.AUTO_FALLBACK, C0709Uj.i("Exception while updating the loaded status for file ", str3), exc);
        }
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str, String str2) {
        this.juspayServices.getDynamicUI().addJsToWebView(String.format("window[\"onEvent'\"]('%s',atob('%s'))", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2)}));
    }

    @JavascriptInterface
    public void invokeInACSWebview(String str, String str2, String str3) {
        if (this.godelManager != null) {
            this.godelManager.getJuspayWebView().addJsToWebView(String.format("javascript:window.onAcsFunctionCalled('%s',atob('%s'),'%s')", new Object[]{str, Base64.encodeToString(str2.getBytes(), 2), str3}));
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2, String str3) {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.onBrowserReady(this.activity, str2, str3, str);
        }
    }

    @JavascriptInterface
    public void requestKeyboardShow(String str) {
        ExecutorManager.runOnMainThread(new Ft(5, this, str));
    }

    @JavascriptInterface
    public void requestPermission(String[] strArr, String str, String str2) {
        this.juspayServices.requestPermission(strArr, Integer.parseInt(str));
        Map<String, Object> map = this.listenerMap;
        map.put(PaymentConstants.REQUEST_PERMISSION_PREFIX + str, str2);
    }

    @JavascriptInterface
    public void runInJuspayWebView(String str, String str2) {
    }

    @JavascriptInterface
    public void invokeFnInDUIWebview(String str, String str2, String str3) {
        Godel godel = this.godelManager;
        if (godel != null) {
            godel.getAcsInterface().invoke(str, str2, str3);
        }
    }

    @JavascriptInterface
    public void onWebViewReady(String str, String str2, String str3, String str4) {
        if (str4.equalsIgnoreCase("base64")) {
            try {
                byte[] decode = Base64.decode(str3, 2);
                Godel godel = this.godelManager;
                if (godel != null) {
                    godel.onBrowserReady(this.activity, str2, new String(decode), "text/html", "UTF-8", (String) null, str);
                }
            } catch (Exception e) {
                this.sdkTracker.trackAndLogException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.ON_WEBVIEW_READY, "Exception while trying to decode content", e);
            }
        } else {
            String str5 = str3;
            Godel godel2 = this.godelManager;
            if (godel2 != null) {
                godel2.onBrowserReady(this.activity, str2, str3, "text/html", "UTF-8", (String) null, str);
            }
        }
    }

    @JavascriptInterface
    public void setSessionInfo() {
    }
}
