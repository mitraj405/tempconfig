package in.juspay.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.R;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogSessioniserExp;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.core.JuspayWebViewConfigurationCallback;
import in.juspay.hypersdk.core.MerchantViewType;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.PrefetchServices;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.data.JuspayResponseHandler;
import in.juspay.hypersdk.data.JuspayResponseHandlerDummyImpl;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.LogType;
import in.juspay.hypersdk.utils.TrackerFallback;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
public class HyperServices {
    private static final String LOG_TAG = "HyperServices";
    private static final String REQUEST_ID = "requestId";
    protected FragmentActivity activity;
    private final HashMap<WeakReference<FragmentActivity>, String> activityIds;
    protected ViewGroup container;
    private final Context context;
    private String currentActivityId;
    private HyperExceptionHandler hyperExceptionHandler;
    protected boolean jpConsumingBackPress;
    /* access modifiers changed from: private */
    public final JuspayServices juspayServices;
    protected HyperPaymentsCallback merchantCallback;
    private final Bn onBackPressedCallback;
    private final Queue<Runnable> processWaitingQueue;
    private final AtomicReference<SDKState> sdkStateReference;
    private final TrackerFallback trackerFallBack;

    /* renamed from: in.juspay.services.HyperServices$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$services$SDKState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                in.juspay.services.SDKState[] r0 = in.juspay.services.SDKState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$in$juspay$services$SDKState = r0
                in.juspay.services.SDKState r1 = in.juspay.services.SDKState.INSTANTIATED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$in$juspay$services$SDKState     // Catch:{ NoSuchFieldError -> 0x001d }
                in.juspay.services.SDKState r1 = in.juspay.services.SDKState.INITIATE_STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$in$juspay$services$SDKState     // Catch:{ NoSuchFieldError -> 0x0028 }
                in.juspay.services.SDKState r1 = in.juspay.services.SDKState.INITIATE_COMPLETED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$in$juspay$services$SDKState     // Catch:{ NoSuchFieldError -> 0x0033 }
                in.juspay.services.SDKState r1 = in.juspay.services.SDKState.TERMINATED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.HyperServices.AnonymousClass3.<clinit>():void");
        }
    }

    public static class HyperExceptionHandler implements Thread.UncaughtExceptionHandler {
        private static final String LOG_TAG = "UncaughtExceptionHandler";
        private WeakReference<HyperServices> hyperServices;
        private Thread.UncaughtExceptionHandler merchantHandler;

        public HyperExceptionHandler(HyperServices hyperServices2) {
            this.hyperServices = new WeakReference<>(hyperServices2);
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "created HyperExceptionHandler");
        }

        public void clearHyperExceptionHandler() {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.merchantHandler;
            if (uncaughtExceptionHandler == null || !(uncaughtExceptionHandler instanceof HyperExceptionHandler)) {
                Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            this.hyperServices = new WeakReference<>((Object) null);
            this.merchantHandler = null;
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "destroyed HyperExceptionHandler and registered merchant's exception handler as default");
        }

        public void setAsDefaultExceptionHandler() {
            this.merchantHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            SdkTracker.trackBootLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.EXCEPTION_HANDLER, "ExceptionHandler", "registered HyperExceptionHandler as default uncaught exception handler");
        }

        public void uncaughtException(Thread thread, Throwable th) {
            HyperServices hyperServices2 = this.hyperServices.get();
            if (hyperServices2 != null) {
                JuspayLogger.w(LOG_TAG, "sending crash to tracker");
                hyperServices2.uncaughtException(th);
            }
            if (this.merchantHandler != null) {
                JuspayLogger.w(LOG_TAG, "forwarding crash to merchant");
                this.merchantHandler.uncaughtException(thread, th);
                return;
            }
            JuspayLogger.e(LOG_TAG, "merchant exception handler not found, exiting");
            System.exit(1);
        }
    }

    @Deprecated
    @Keep
    public HyperServices(Activity activity2) {
        String str;
        this.processWaitingQueue = new LinkedList();
        if (activity2 != null) {
            str = String.format(" (%s)", new Object[]{activity2.getClass().getName()});
        } else {
            str = "";
        }
        throw new InstantiationException(lf.j("Instantiating HyperServices with plain Activity", str, " is not allowed, please pass FragmentActivity"));
    }

    private void doProcess(JSONObject jSONObject) {
        int i;
        try {
            logSafeEvents("info", Labels.HyperSdk.PROCESS, "started", jSONObject);
            this.trackerFallBack.log(jSONObject, this.juspayServices, LogType.PROCESS_START);
            JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.PAYLOAD);
            ViewGroup viewGroup = this.container;
            int i2 = -1;
            if (viewGroup != null) {
                i = String.valueOf(viewGroup.getId());
            } else {
                i = -1;
            }
            jSONObject2.put("merchant_root_view", i);
            FragmentActivity fragmentActivity = this.activity;
            if (fragmentActivity != null) {
                i2 = fragmentActivity.getWindow().getAttributes().softInputMode;
            }
            jSONObject2.put("merchant_keyboard_mode", i2);
            jSONObject2.put("processStartedTime", System.currentTimeMillis());
            jSONObject2.put("currentActivityId", this.currentActivityId);
            jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
            this.juspayServices.setUpMerchantFragments(jSONObject2);
        } catch (JSONException unused) {
        }
        if (!jSONObject.has(REQUEST_ID)) {
            logSafeEvents("error", Labels.HyperSdk.PROCESS, "request_id_present", Boolean.FALSE);
        } else {
            ExecutorManager.runOnMainThread(new C1090ef(this, System.currentTimeMillis(), jSONObject));
        }
    }

    private String getIdForActivity(FragmentActivity fragmentActivity) {
        for (Map.Entry next : this.activityIds.entrySet()) {
            if (((FragmentActivity) ((WeakReference) next.getKey()).get()) == fragmentActivity) {
                return (String) next.getValue();
            }
        }
        String uuid = UUID.randomUUID().toString();
        this.activityIds.put(new WeakReference(fragmentActivity), uuid);
        return uuid;
    }

    @Keep
    public static JSONObject getVersions(Context context2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkVersion", IntegrationUtils.getSdkVersion(context2));
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    private void initiateNotCalled() {
        throw new IllegalStateException("initiate() must be called before calling process()");
    }

    private void initiateTerminated(JSONObject jSONObject) {
        notifyMerchant("JP_017", "process() called after terminate()", "process_result", jSONObject);
        logSafeEvents("error", Labels.HyperSdk.PROCESS, "interrupted", "process() called after terminate()");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doProcess$6(long j, JSONObject jSONObject) {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, LogLevel.DEBUG, Labels.HyperSdk.PROCESS, "main_thread_handover", Long.valueOf(System.currentTimeMillis() - j));
        this.juspayServices.onMerchantEvent(Labels.HyperSdk.PROCESS, jSONObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$1(JSONObject jSONObject) {
        if (this.juspayServices.getLogSessioniserExp() != null) {
            this.juspayServices.getLogSessioniserExp().startLogSessioniser();
            shouldPushLogs(Labels.HyperSdk.INITIATE, jSONObject);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$2() {
        if (this.hyperExceptionHandler == null) {
            this.hyperExceptionHandler = new HyperExceptionHandler(this);
        }
        this.hyperExceptionHandler.setAsDefaultExceptionHandler();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initiate$3(long j, JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, LogLevel.DEBUG, Labels.HyperSdk.INITIATE, "main_thread_handover", Long.valueOf(System.currentTimeMillis() - j));
        setupJuspayServices(jSONObject, hyperPaymentsCallback);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$runProcessWaitQueue$4() {
        logSafeEvents("info", Labels.HyperSdk.PROCESS_WAIT_QUEUE, "pending_processes", Integer.valueOf(this.processWaitingQueue.size()));
        while (!this.processWaitingQueue.isEmpty()) {
            Runnable poll = this.processWaitingQueue.poll();
            if (poll != null) {
                poll.run();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setupJuspayServices$0(JSONObject jSONObject) {
        this.sdkStateReference.set(SDKState.INITIATE_COMPLETED);
        notifyMerchant("JP_020", "No web view is present in the device", "initiate_result", jSONObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$terminate$7(long j) {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, LogLevel.DEBUG, Labels.HyperSdk.TERMINATE, "main_thread_handover", Long.valueOf(System.currentTimeMillis() - j));
        try {
            this.juspayServices.terminate();
        } catch (Exception e) {
            this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.TERMINATE, "Failed to remove the fragment", e);
        }
        this.container = null;
        this.activity = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$uncaughtException$8(Throwable th) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        sdkTracker.addLogToPersistedQueue(sdkTracker.getExceptionLog(LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.System.SDK_CRASHED, "SDK Crashed Uncaught exception handler", th));
    }

    private void logSafeEvents(String str, String str2, String str3, Object obj) {
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, str, str2, str3, obj);
    }

    private void logSafeExceptions(String str, String str2, String str3, Throwable th) {
        this.juspayServices.getSdkTracker().trackAndLogException(LOG_TAG, LogCategory.LIFECYCLE, str, str2, str3, th);
    }

    private JSONObject notifyMerchant(HyperPaymentsCallback hyperPaymentsCallback, String str, String str2, String str3, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(REQUEST_ID, jSONObject.optString(REQUEST_ID, ""));
            jSONObject2.put(PaymentConstants.SERVICE, jSONObject.optString(PaymentConstants.SERVICE, PaymentConstants.SERVICE));
            jSONObject2.put("error", true);
            jSONObject2.put("errorCode", str);
            jSONObject2.put("errorMessage", str2);
            jSONObject2.put("event", str3);
            jSONObject2.put(PaymentConstants.PAYLOAD, new JSONObject());
            hyperPaymentsCallback.onEvent(jSONObject2, new JuspayResponseHandlerDummyImpl());
        } catch (Exception e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.HyperSdk.EXIT_SDK_ERROR, "Error while sending response to merchant", e);
        }
        return jSONObject2;
    }

    private boolean objectMatch(Object obj, Object obj2) {
        if (Objects.equals(obj, (Object) null) || Objects.equals(obj2, (Object) null) || !obj.getClass().equals(obj2.getClass())) {
            return false;
        }
        if (obj2 instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj2;
            if (jSONObject.length() == 0) {
                return false;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!objectMatch(jSONObject2.opt(next), jSONObject.opt(next))) {
                    return false;
                }
            }
            return true;
        } else if (obj2 instanceof String) {
            return obj2.equals(obj);
        } else {
            if (obj == obj2) {
                return true;
            }
            return false;
        }
    }

    @Keep
    public static void preFetch(Context context2, JSONObject jSONObject) {
        PrefetchServices.preFetch(context2, jSONObject);
    }

    private void runProcessWaitQueue() {
        ExecutorManager.runOnBackgroundThread(new gA(this, 13));
    }

    private void setupJuspayServices(JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        this.merchantCallback = hyperPaymentsCallback;
        modifyParams(jSONObject);
        this.juspayServices.setBundleParameter(jSONObject);
        this.juspayServices.setHyperCallback(new HyperPaymentsCallbackAdapter() {
            public WebViewClient createJuspaySafeWebViewClient() {
                return HyperServices.this.merchantCallback.createJuspaySafeWebViewClient();
            }

            public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
                return HyperServices.this.merchantCallback.getMerchantView(viewGroup, merchantViewType);
            }

            public void onEvent(JSONObject jSONObject, JuspayResponseHandler juspayResponseHandler) {
                if (HyperServices.this.handleOnEvent(jSONObject)) {
                    HyperServices.this.merchantCallback.onEvent(jSONObject, juspayResponseHandler);
                }
            }

            public void onStartWaitingDialogCreated(View view) {
                HyperServices.this.merchantCallback.onStartWaitingDialogCreated(view);
            }
        });
        this.juspayServices.initiate(new A1(9, this, jSONObject));
    }

    private void shouldPushLogs(String str, JSONObject jSONObject) {
        LogSessioniserExp logSessioniserExp = this.juspayServices.getLogSessioniserExp();
        if (logSessioniserExp != null) {
            try {
                JSONObject optJSONObject = this.juspayServices.getSdkConfigService().getSdkConfig().optJSONObject("logsConfig");
                if (optJSONObject == null || (str.equals(optJSONObject.optString("bufferLogsTill", str)) && shouldStopBuffer(optJSONObject, jSONObject))) {
                    logSessioniserExp.startPushing();
                }
            } catch (Exception unused) {
                logSessioniserExp.startPushing();
            }
        }
    }

    private boolean shouldStopBuffer(JSONObject jSONObject, JSONObject jSONObject2) {
        if (!jSONObject.has("dontStopBufferOn")) {
            return true;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dontStopBufferOn");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (objectMatch(jSONObject2, jSONArray.get(i))) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void uncaughtException(Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new PC(6, this, th));
    }

    public boolean checkAndStartInitiate(JSONObject jSONObject) {
        SDKState sDKState = this.sdkStateReference.get();
        SDKState sDKState2 = SDKState.INITIATE_STARTED;
        if (sDKState == sDKState2 || sDKState == SDKState.INITIATE_COMPLETED) {
            notifyMerchant("JP_017", "initiate() can only be called once without terminate()", "initiate_result", jSONObject);
            logSafeEvents("error", Labels.HyperSdk.INITIATE, "interrupted", "initiate() can only be called once without terminate()");
            return false;
        }
        this.sdkStateReference.set(sDKState2);
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "started", "Started initiating the SDK");
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a5 A[Catch:{ Exception -> 0x00cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleOnEvent(org.json.JSONObject r12) {
        /*
            r11 = this;
            java.lang.String r0 = "event"
            java.lang.String r1 = "on_event"
            java.lang.String r2 = "payload"
            r3 = 1
            org.json.JSONObject r4 = r12.optJSONObject(r2)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r5 = r12.optString(r0)     // Catch:{ Exception -> 0x00cf }
            int r6 = r5.hashCode()     // Catch:{ Exception -> 0x00cf }
            r7 = -1917311628(0xffffffff8db82574, float:-1.1348892E-30)
            java.lang.String r8 = "jp_consuming_backpress"
            r9 = -1
            r10 = 0
            if (r6 == r7) goto L_0x002a
            r7 = 731104317(0x2b93c43d, float:1.0499445E-12)
            if (r6 == r7) goto L_0x0022
            goto L_0x0034
        L_0x0022:
            boolean r5 = r5.equals(r8)     // Catch:{ Exception -> 0x00cf }
            if (r5 == 0) goto L_0x0034
            r5 = r10
            goto L_0x0035
        L_0x002a:
            java.lang.String r6 = "onJOSReady"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x00cf }
            if (r5 == 0) goto L_0x0034
            r5 = r3
            goto L_0x0035
        L_0x0034:
            r5 = r9
        L_0x0035:
            if (r5 == 0) goto L_0x00a5
            if (r5 == r3) goto L_0x00a4
            java.lang.String r4 = "default"
            java.lang.String r0 = r12.optString(r0, r4)     // Catch:{ Exception -> 0x008a }
            int r4 = r0.hashCode()     // Catch:{ Exception -> 0x008a }
            r5 = 24468461(0x1755bed, float:4.5065347E-38)
            if (r4 == r5) goto L_0x0058
            r5 = 1858061443(0x6ebfc483, float:2.9674602E28)
            if (r4 == r5) goto L_0x004e
            goto L_0x0061
        L_0x004e:
            java.lang.String r4 = "initiate_result"
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0061
            r9 = r3
            goto L_0x0061
        L_0x0058:
            java.lang.String r4 = "process_result"
            boolean r0 = r0.equals(r4)     // Catch:{ Exception -> 0x008a }
            if (r0 == 0) goto L_0x0061
            r9 = r10
        L_0x0061:
            java.lang.String r0 = "ended"
            java.lang.String r4 = "info"
            if (r9 == 0) goto L_0x007c
            if (r9 == r3) goto L_0x006d
            r11.logSafeEvents(r4, r1, r2, r12)     // Catch:{ Exception -> 0x008a }
            goto L_0x008a
        L_0x006d:
            in.juspay.hypersdk.utils.TrackerFallback r2 = r11.trackerFallBack     // Catch:{ Exception -> 0x008a }
            in.juspay.hypersdk.core.JuspayServices r5 = r11.juspayServices     // Catch:{ Exception -> 0x008a }
            in.juspay.hypersdk.utils.LogType r6 = in.juspay.hypersdk.utils.LogType.INITIATE_RESULT     // Catch:{ Exception -> 0x008a }
            r2.log(r12, r5, r6)     // Catch:{ Exception -> 0x008a }
            java.lang.String r2 = "initiate"
            r11.logSafeEvents(r4, r2, r0, r12)     // Catch:{ Exception -> 0x008a }
            goto L_0x008a
        L_0x007c:
            java.lang.String r2 = "process"
            r11.logSafeEvents(r4, r2, r0, r12)     // Catch:{ Exception -> 0x008a }
            in.juspay.hypersdk.utils.TrackerFallback r0 = r11.trackerFallBack     // Catch:{ Exception -> 0x008a }
            in.juspay.hypersdk.core.JuspayServices r2 = r11.juspayServices     // Catch:{ Exception -> 0x008a }
            in.juspay.hypersdk.utils.LogType r4 = in.juspay.hypersdk.utils.LogType.PROCESS_END     // Catch:{ Exception -> 0x008a }
            r0.log(r12, r2, r4)     // Catch:{ Exception -> 0x008a }
        L_0x008a:
            java.lang.String r0 = "action"
            java.lang.String r2 = ""
            java.lang.String r12 = r12.optString(r0, r2)     // Catch:{ Exception -> 0x00cf }
            java.lang.String r0 = "DUI_READY"
            boolean r12 = r12.equals(r0)     // Catch:{ Exception -> 0x00cf }
            if (r12 == 0) goto L_0x00d7
            java.util.concurrent.atomic.AtomicReference<in.juspay.services.SDKState> r12 = r11.sdkStateReference     // Catch:{ Exception -> 0x00cf }
            in.juspay.services.SDKState r0 = in.juspay.services.SDKState.INITIATE_COMPLETED     // Catch:{ Exception -> 0x00cf }
            r12.set(r0)     // Catch:{ Exception -> 0x00cf }
            r11.runProcessWaitQueue()     // Catch:{ Exception -> 0x00cf }
        L_0x00a4:
            return r10
        L_0x00a5:
            if (r4 != 0) goto L_0x00aa
            r11.jpConsumingBackPress = r3     // Catch:{ Exception -> 0x00cf }
            goto L_0x00b0
        L_0x00aa:
            boolean r12 = r4.getBoolean(r8)     // Catch:{ Exception -> 0x00cf }
            r11.jpConsumingBackPress = r12     // Catch:{ Exception -> 0x00cf }
        L_0x00b0:
            in.juspay.hypersdk.core.JuspayServices r12 = r11.juspayServices     // Catch:{ Exception -> 0x00cf }
            in.juspay.hypersdk.core.SdkTracker r4 = r12.getSdkTracker()     // Catch:{ Exception -> 0x00cf }
            java.lang.String r5 = "hypersdk"
            java.lang.String r6 = "info"
            java.lang.String r7 = "jp_consuming_backpress"
            java.lang.String r8 = "jp_consuming_backpress"
            boolean r12 = r11.jpConsumingBackPress     // Catch:{ Exception -> 0x00cf }
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r12)     // Catch:{ Exception -> 0x00cf }
            r4.trackLifecycle(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00cf }
            Bn r12 = r11.onBackPressedCallback     // Catch:{ Exception -> 0x00cf }
            boolean r0 = r11.jpConsumingBackPress     // Catch:{ Exception -> 0x00cf }
            r12.setEnabled(r0)     // Catch:{ Exception -> 0x00cf }
            return r10
        L_0x00cf:
            r12 = move-exception
            java.lang.String r0 = "android"
            java.lang.String r2 = "on_event_failed_during_evaluation"
            r11.logSafeExceptions(r0, r1, r2, r12)
        L_0x00d7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.services.HyperServices.handleOnEvent(org.json.JSONObject):boolean");
    }

    @Keep
    public void initiate(FragmentActivity fragmentActivity, ViewGroup viewGroup, JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        this.container = viewGroup;
        initiate(fragmentActivity, jSONObject, hyperPaymentsCallback);
    }

    @Keep
    public boolean isInitialised() {
        boolean z;
        SDKState sDKState = this.sdkStateReference.get();
        if (sDKState == SDKState.INITIATE_STARTED || sDKState == SDKState.INITIATE_COMPLETED) {
            z = true;
        } else {
            z = false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdkState", String.valueOf(sDKState));
            jSONObject.put("isInitialised", z);
        } catch (JSONException unused) {
        }
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "isInitialised()", jSONObject);
        return z;
    }

    public void modifyParams(JSONObject jSONObject) {
        try {
            jSONObject.put("service_based", true);
            jSONObject.put("use_local_assets", this.context.getResources().getBoolean(R.bool.use_local_assets));
            jSONObject.getJSONObject(PaymentConstants.PAYLOAD).put("currentActivityId", this.currentActivityId);
        } catch (Exception e) {
            JuspayLogger.e(LOG_TAG, "Failed to write to JSON", e);
        }
    }

    @Keep
    public void onActivityResult(int i, int i2, Intent intent) {
        this.juspayServices.onActivityResult(i & 65535, i2, intent);
    }

    @Keep
    public boolean onBackPressed() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consuming_backpress", this.jpConsumingBackPress);
            jSONObject.put("triggered_on", "HyperServices.onBackPressed()");
        } catch (Exception unused) {
        }
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.ANDROID, "info", Labels.Android.BACK_PRESSED, jSONObject);
        if (!this.jpConsumingBackPress) {
            return false;
        }
        this.juspayServices.onBackPressed();
        return true;
    }

    @Keep
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.juspayServices.onRequestPermissionsResult(i & 65535, strArr, iArr);
    }

    @Keep
    /* renamed from: process */
    public void lambda$process$5(FragmentActivity fragmentActivity, ViewGroup viewGroup, JSONObject jSONObject) {
        int i = AnonymousClass3.$SwitchMap$in$juspay$services$SDKState[this.sdkStateReference.get().ordinal()];
        if (i == 1) {
            logSafeEvents("error", Labels.HyperSdk.PROCESS, "called_before_initiate", jSONObject);
            initiateNotCalled();
        } else if (i == 2) {
            this.trackerFallBack.log(jSONObject, this.juspayServices, LogType.PROCESS_QUEUED);
            logSafeEvents("info", Labels.HyperSdk.PROCESS, "queued", jSONObject);
            this.processWaitingQueue.add(new w8(this, fragmentActivity, viewGroup, jSONObject, 2));
        } else if (i == 3) {
            logSafeEvents("info", Labels.HyperSdk.PROCESS, "called_and_started", jSONObject);
            if (!this.juspayServices.isWebViewAvailable()) {
                notifyMerchant("JP_020", "No web view is present in the device", "process_result", jSONObject);
                return;
            }
            if (fragmentActivity != this.activity) {
                logSafeEvents("info", Labels.HyperSdk.PROCESS, "activity_changed", "true");
            }
            OnBackPressedDispatcher onBackPressedDispatcher = fragmentActivity.getOnBackPressedDispatcher();
            Bn bn = this.onBackPressedCallback;
            onBackPressedDispatcher.getClass();
            C1177ig.f(bn, "onBackPressedCallback");
            onBackPressedDispatcher.b(bn);
            this.container = viewGroup;
            this.activity = fragmentActivity;
            this.currentActivityId = getIdForActivity(fragmentActivity);
            this.juspayServices.getSessionInfo().addOrderIdInSessionData(jSONObject);
            this.juspayServices.process(fragmentActivity, this.container);
            if (this.juspayServices.getLogSessioniserExp() != null) {
                shouldPushLogs(Labels.HyperSdk.PROCESS, jSONObject);
            }
            doProcess(jSONObject);
        } else if (i == 4) {
            logSafeEvents("error", Labels.HyperSdk.PROCESS, "called_after_terminate", jSONObject);
            initiateTerminated(jSONObject);
        }
    }

    @Keep
    public void resetActivity(FragmentActivity fragmentActivity) {
        if (fragmentActivity == this.activity) {
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.TERMINATE, "resetActivity()", "called");
            this.juspayServices.reset();
            this.onBackPressedCallback.remove();
            this.activity = null;
            this.currentActivityId = null;
            this.container = null;
        }
    }

    @Keep
    public void setActivityLaunchDelegate(ActivityLaunchDelegate activityLaunchDelegate) {
        this.juspayServices.setActivityLaunchDelegate(activityLaunchDelegate);
    }

    @Keep
    public void setIntentSenderDelegate(IntentSenderDelegate intentSenderDelegate) {
        this.juspayServices.setIntentSenderDelegate(intentSenderDelegate);
    }

    @Keep
    public void setRequestPermissionDelegate(RequestPermissionDelegate requestPermissionDelegate) {
        this.juspayServices.setRequestPermissionDelegate(requestPermissionDelegate);
    }

    @Keep
    public void setWebViewConfigurationCallback(JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback) {
        this.juspayServices.setWebViewConfigurationCallback(juspayWebViewConfigurationCallback);
    }

    @Keep
    public void terminate() {
        SdkTracker sdkTracker;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        SDKState sDKState = this.sdkStateReference.get();
        SDKState sDKState2 = SDKState.TERMINATED;
        if (sDKState == sDKState2) {
            sdkTracker = this.juspayServices.getSdkTracker();
            str = LogSubCategory.LifeCycle.HYPER_SDK;
            str2 = LogLevel.WARNING;
            str3 = Labels.HyperSdk.TERMINATE;
            str4 = "started";
            str5 = "Terminate called again, skipping";
        } else if (sDKState == SDKState.INSTANTIATED) {
            sdkTracker = this.juspayServices.getSdkTracker();
            str = LogSubCategory.LifeCycle.HYPER_SDK;
            str2 = LogLevel.WARNING;
            str3 = Labels.HyperSdk.TERMINATE;
            str4 = "started";
            str5 = "Terminate called without initiate, skipping";
        } else {
            this.sdkStateReference.set(sDKState2);
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.TERMINATE, "started", "Terminating the SDK");
            this.jpConsumingBackPress = false;
            HyperExceptionHandler hyperExceptionHandler2 = this.hyperExceptionHandler;
            if (hyperExceptionHandler2 != null) {
                hyperExceptionHandler2.clearHyperExceptionHandler();
                this.hyperExceptionHandler = null;
            }
            resetActivity(this.activity);
            ExecutorManager.runOnMainThread(new C1111ff(this, System.currentTimeMillis()));
            this.juspayServices.getSessionInfo().resetSession();
            if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
                LogPusher.stopLogPusherOnTerminate();
            }
            if (this.juspayServices.getLogSessioniserExp() != null) {
                this.juspayServices.getLogSessioniserExp().stopLogSessioniserOnTerminate();
                return;
            }
            return;
        }
        sdkTracker.trackLifecycle(str, str2, str3, str4, str5);
    }

    private void notifyMerchant(String str, String str2, String str3, JSONObject jSONObject) {
        HyperPaymentsCallback hyperPaymentsCallback = this.merchantCallback;
        if (hyperPaymentsCallback != null) {
            logSafeEvents("error", str3.equals("initiate_result") ? Labels.HyperSdk.INITIATE : Labels.HyperSdk.PROCESS, "ended", notifyMerchant(hyperPaymentsCallback, str, str2, str3, jSONObject));
        }
    }

    @Keep
    public void initiate(FragmentActivity fragmentActivity, JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        if (this.activity != fragmentActivity) {
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "activity_changed", "true");
        }
        this.activity = fragmentActivity;
        this.currentActivityId = getIdForActivity(fragmentActivity);
        initiate(jSONObject, hyperPaymentsCallback);
    }

    public void terminate(JSONObject jSONObject) {
        logSafeEvents("info", Labels.HyperSdk.TERMINATE_PROCESS, "request", jSONObject);
        this.juspayServices.onMerchantEvent(Labels.HyperSdk.TERMINATE, jSONObject);
    }

    @Keep
    public void initiate(JSONObject jSONObject, HyperPaymentsCallback hyperPaymentsCallback) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.PAYLOAD);
            jSONObject2.put("initiateStartedTime", System.currentTimeMillis());
            jSONObject.put(PaymentConstants.PAYLOAD, jSONObject2);
        } catch (JSONException unused) {
        }
        if (checkAndStartInitiate(jSONObject)) {
            this.trackerFallBack.log(jSONObject, this.juspayServices, LogType.INITIATE_START);
            this.juspayServices.getSdkTracker().resetSerialNumber();
            this.juspayServices.getSessionInfo().setSessionId();
            if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
                LogPusher.startLogPusherTimer();
            }
            ExecutorManager.runOnLogSessioniserThread(new Ft(8, this, jSONObject));
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "started", jSONObject);
            this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.INITIATE, "fragment_activity_used", String.valueOf(this.activity != null));
            ExecutorManager.runOnBackgroundThread(new C0189f6(this, 9));
            ExecutorManager.runOnMainThread(new C1069df(this, System.currentTimeMillis(), jSONObject, hyperPaymentsCallback));
        }
    }

    @Keep
    public void process(FragmentActivity fragmentActivity, JSONObject jSONObject) {
        lambda$process$5(fragmentActivity, (ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(16908290), jSONObject);
    }

    @Keep
    public void process(JSONObject jSONObject) {
        SDKState sDKState = this.sdkStateReference.get();
        if (sDKState == SDKState.INSTANTIATED) {
            initiateNotCalled();
        } else if (sDKState == SDKState.TERMINATED) {
            initiateTerminated(jSONObject);
        } else {
            FragmentActivity fragmentActivity = this.activity;
            if (fragmentActivity == null) {
                notifyMerchant("JP_003", "FragmentActivity needs to be send in process", "process_result", jSONObject);
                return;
            }
            ViewGroup viewGroup = this.container;
            if (viewGroup != null) {
                lambda$process$5(fragmentActivity, viewGroup, jSONObject);
            } else {
                process(fragmentActivity, jSONObject);
            }
        }
    }

    @Keep
    public HyperServices(Context context2) {
        this(context2, (TenantParams) null);
    }

    public HyperServices(Context context2, TenantParams tenantParams) {
        this.processWaitingQueue = new LinkedList();
        this.context = context2;
        JuspayCoreLib.setApplicationContext(context2.getApplicationContext());
        this.activityIds = new HashMap<>();
        this.jpConsumingBackPress = false;
        JuspayServices juspayServices2 = new JuspayServices(context2, tenantParams);
        this.juspayServices = juspayServices2;
        this.hyperExceptionHandler = new HyperExceptionHandler(this);
        this.sdkStateReference = new AtomicReference<>(SDKState.INSTANTIATED);
        this.trackerFallBack = new TrackerFallback(juspayServices2.getSdkConfigService().getSdkConfig());
        this.onBackPressedCallback = new Bn(false) {
            public void handleOnBackPressed() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("triggered_on", "onBackPressedCallback.handleOnBackPressed()");
                } catch (Exception unused) {
                }
                HyperServices.this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.ANDROID, "info", Labels.Android.BACK_PRESSED, jSONObject);
                HyperServices.this.juspayServices.onBackPressed();
            }
        };
    }

    @Keep
    public HyperServices(FragmentActivity fragmentActivity) {
        this(fragmentActivity, (ViewGroup) fragmentActivity.getWindow().getDecorView().findViewById(16908290));
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.HYPER_SERVICE, "view_group", Boolean.FALSE);
    }

    @Keep
    public HyperServices(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        this(fragmentActivity.getApplicationContext());
        this.activity = fragmentActivity;
        this.container = viewGroup;
        this.currentActivityId = getIdForActivity(fragmentActivity);
        this.juspayServices.getSdkTracker().trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.HYPER_SERVICE, "sdk_create", FirebaseAnalytics.Param.SUCCESS);
    }
}
