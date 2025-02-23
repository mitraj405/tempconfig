package in.juspay.hypersdk.core;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.a;
import com.google.firebase.messaging.Constants;
import in.juspay.hyper.bridge.BridgeList;
import in.juspay.hyper.bridge.HyperBridge;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.BridgeComponents;
import in.juspay.hyper.core.CallbackInvoker;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.FileProviderInterface;
import in.juspay.hyper.core.FragmentHooks;
import in.juspay.hyper.core.JsCallback;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.TrackerInterface;
import in.juspay.hyperapay.APayBridge;
import in.juspay.hyperapayupi.APayUPIBridge;
import in.juspay.hypergpay.GPayBridge;
import in.juspay.hypergpayintl.GPayIntlBridge;
import in.juspay.hypernfc.NfcBridge;
import in.juspay.hyperpaypal.PaypalBridge;
import in.juspay.hyperpayu.PayUBridge;
import in.juspay.hyperqr.QrBridge;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniserExp;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.PaymentSessionInfo;
import in.juspay.hypersdk.data.SdkInfo;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.lifecycle.FragmentEvent;
import in.juspay.hypersdk.lifecycle.HyperActivityLaunchDelegate;
import in.juspay.hypersdk.lifecycle.HyperFragment;
import in.juspay.hypersdk.lifecycle.HyperIntentSenderDelegate;
import in.juspay.hypersdk.lifecycle.HyperRequestPermissionDelegate;
import in.juspay.hypersdk.mystique.Callback;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.services.RemoteAssetService;
import in.juspay.hypersdk.services.SdkConfigService;
import in.juspay.hypersdk.ui.ActivityLaunchDelegate;
import in.juspay.hypersdk.ui.HyperPaymentsCallback;
import in.juspay.hypersdk.ui.IntentSenderDelegate;
import in.juspay.hypersdk.ui.RequestPermissionDelegate;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersimpl.SimplBridge;
import in.juspay.hypersmshandler.SmsComponents;
import in.juspay.hypersmshandler.SmsEventInterface;
import in.juspay.hypersmshandler.SmsServices;
import in.juspay.hypersmshandler.Tracker;
import in.juspay.hypertrident.TridentBridge;
import in.juspay.hyperupi.UPIBridge;
import in.juspay.mobility.app.MobilityAppBridge;
import in.juspay.mobility.customer.MobilityCustomerBridge;
import in.juspay.mobility.driver.MobilityDriverBridge;
import in.juspay.services.TenantParams;
import java.io.File;
import java.lang.reflect.Constructor;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class JuspayServices implements FragmentHooks {
    private static final String fragmentTag = "JuspayServiceFragment";
    private final String LOG_TAG = getClass().getSimpleName();
    /* access modifiers changed from: private */
    public FragmentActivity activity;
    private ActivityLaunchDelegate activityLaunchDelegate;
    private final BridgeComponents bridgeComponents;
    private final BridgeList bridgeList = new BridgeList();
    private final String buildId;
    private JSONObject bundleParameters;
    private FrameLayout container;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final DynamicUI dynamicUI;
    /* access modifiers changed from: private */
    public final FileProviderService fileProviderService;
    HyperFragment fragment;
    private final List<FragmentEvent> fragmentEvents;
    private HyperPaymentsCallback hyperCallback;
    private IntentSenderDelegate intentSenderDelegate;
    private boolean isPrefetch;
    private boolean isWebViewAvailable;
    /* access modifiers changed from: private */
    public final JBridge jBridge;
    private JSONObject lastProcessPayload;
    private LogSessioniserExp logSessioniserExp;
    private String merchantClientId;
    private boolean paused;
    private final PaymentSessionInfo paymentSessionInfo;
    private final RemoteAssetService remoteAssetService;
    private RequestPermissionDelegate requestPermissionDelegate;
    /* access modifiers changed from: private */
    public final SdkConfigService sdkConfigService;
    /* access modifiers changed from: private */
    public final SdkInfo sdkInfo;
    /* access modifiers changed from: private */
    public final SdkTracker sdkTracker;
    private final SessionInfo sessionInfo;
    SmsComponents smsComponents;
    private final SmsServices smsServices;
    private final TenantParams tenantParams;
    private JuspayWebViewConfigurationCallback webViewConfigurationCallback;
    Runnable webViewCrashCallback;
    private String workingLogger;

    /* renamed from: in.juspay.hypersdk.core.JuspayServices$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                in.juspay.hypersdk.lifecycle.FragmentEvent[] r0 = in.juspay.hypersdk.lifecycle.FragmentEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent = r0
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onPause     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onResume     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent     // Catch:{ NoSuchFieldError -> 0x0028 }
                in.juspay.hypersdk.lifecycle.FragmentEvent r1 = in.juspay.hypersdk.lifecycle.FragmentEvent.onAttach     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JuspayServices.AnonymousClass5.<clinit>():void");
        }
    }

    public JuspayServices(Context context2, TenantParams tenantParams2) {
        String str = null;
        this.fragment = null;
        this.paused = false;
        this.isPrefetch = false;
        this.isWebViewAvailable = true;
        this.workingLogger = "json-array";
        this.smsComponents = new SmsComponents() {
            public Context getContext() {
                return JuspayServices.this.context;
            }

            public SmsEventInterface getSmsEventInterface() {
                return JuspayServices.this.jBridge.getSmsEventInterface();
            }

            public Tracker getTracker() {
                return JuspayServices.this.sdkTracker;
            }
        };
        this.tenantParams = tenantParams2;
        this.sdkInfo = IntegrationUtils.getSdkInfo(context2);
        this.context = context2.getApplicationContext();
        this.buildId = "jus_" + IntegrationUtils.getSdkVersion(context2, "_") + "_" + IntegrationUtils.getAssetAarVersion(context2);
        AnonymousClass1 r6 = new Callback() {
            public void onError(String str, String str2) {
                JuspayLogger.e("DynamicUI", String.format("%s %s", new Object[]{str, str2}));
                JuspayServices.this.sdkTracker.trackAction(LogSubCategory.Action.DUI, "error", Labels.HyperSdk.MYSTIQUE, str.toLowerCase(), str2);
            }

            public void onException(String str, String str2, Throwable th) {
                JuspayLogger.e("DynamicUI", String.format("%s %s", new Object[]{str, str2}));
                JuspayServices.this.sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.DUI, Labels.HyperSdk.MYSTIQUE, str2, th);
            }

            public void webViewLoaded(Exception exc) {
                Runnable runnable;
                if (!(exc == null || (runnable = JuspayServices.this.webViewCrashCallback) == null)) {
                    runnable.run();
                }
                JuspayServices.this.webViewCrashCallback = null;
            }
        };
        AnonymousClass2 r5 = new DuiLogger() {
            public void e(String str, String str2) {
                JuspayLogger.e(str, str2);
                JuspayServices.this.sdkTracker.trackAction(LogSubCategory.Action.DUI, "error", Labels.HyperSdk.MYSTIQUE, str.toLowerCase(), str2);
            }

            public void d(String str, String str2) {
            }

            public void i(String str, String str2) {
            }
        };
        SdkTracker sdkTracker2 = new SdkTracker(this);
        this.sdkTracker = sdkTracker2;
        SdkConfigService sdkConfigService2 = new SdkConfigService(this);
        this.sdkConfigService = sdkConfigService2;
        this.sessionInfo = new SessionInfo(this);
        this.fileProviderService = new FileProviderService(this);
        this.remoteAssetService = new RemoteAssetService(this);
        this.jBridge = new JBridge(this);
        this.activityLaunchDelegate = new HyperActivityLaunchDelegate(this);
        this.intentSenderDelegate = new HyperIntentSenderDelegate(this);
        this.requestPermissionDelegate = new HyperRequestPermissionDelegate(this);
        sdkConfigService2.renewConfig(context2);
        BridgeComponents createBridgeComponents = createBridgeComponents();
        this.bridgeComponents = createBridgeComponents;
        this.dynamicUI = new DynamicUI(context2, r5, r6, createBridgeComponents, tenantParams2 != null ? tenantParams2.getBaseContent() : str, getJavaScriptInterfaces());
        this.paymentSessionInfo = new PaymentSessionInfo(this);
        logMemoryInfo(sdkTracker2, context2);
        logEncryptionSupport(sdkTracker2, context2);
        this.fragmentEvents = Arrays.asList(FragmentEvent.values());
        this.smsServices = new SmsServices(this.smsComponents);
        JSONObject optJSONObject = sdkConfigService2.getSdkConfig().optJSONObject("logsConfig");
        if (optJSONObject != null) {
            ExecutorManager.runOnBackgroundThread(new C0428zq(13, this, optJSONObject));
            String optString = optJSONObject.optString("workingLogger", "json-array");
            this.workingLogger = optString;
            if (Objects.equals(optString, "byte-d-json") || Objects.equals(this.workingLogger, "both")) {
                this.logSessioniserExp = new LogSessioniserExp();
            }
        }
    }

    private void addFragment(FragmentActivity fragmentActivity) {
        ExecutorManager.runOnMainThread(new m(4, this, fragmentActivity));
    }

    private void commitFragmentTransaction(FragmentTransaction fragmentTransaction) {
        if (useCommit()) {
            fragmentTransaction.d();
        } else {
            fragmentTransaction.e();
        }
    }

    private BridgeComponents createBridgeComponents() {
        return new BridgeComponents() {
            public Activity getActivity() {
                return JuspayServices.this.activity;
            }

            public CallbackInvoker getCallbackInvoker() {
                return JuspayServices.this.jBridge;
            }

            public String getClientId() {
                try {
                    return JuspayServices.this.getSessionInfo().getClientId();
                } catch (Exception unused) {
                    return null;
                }
            }

            public Context getContext() {
                return JuspayServices.this.context;
            }

            public FileProviderInterface getFileProviderInterface() {
                return JuspayServices.this.fileProviderService;
            }

            public FragmentHooks getFragmentHooks() {
                return JuspayServices.this;
            }

            public JsCallback getJsCallback() {
                return JuspayServices.this.dynamicUI;
            }

            public JSONObject getSdkConfig() {
                return JuspayServices.this.sdkConfigService.getSdkConfig();
            }

            public String getSdkName() {
                return JuspayServices.this.sdkInfo.getSdkName();
            }

            public TrackerInterface getTrackerInterface() {
                return JuspayServices.this.sdkTracker;
            }

            public JBridge getReceiverInterface() {
                return JuspayServices.this.jBridge;
            }
        };
    }

    private FrameLayout createSubLayout(Activity activity2) {
        FrameLayout frameLayout = new FrameLayout(activity2);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.setVisibility(0);
        return frameLayout;
    }

    private static void deleteFiles(Context context2) {
        try {
            File[] listFiles = new File(String.valueOf(context2.getCacheDir())).listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    String name = file.getName();
                    if (name.startsWith(LogConstants.PERSISTENT_LOGS_FILE) || name.startsWith(LogConstants.LOGS_FILE) || name.startsWith(LogConstants.TEMP_LOGS_FILE)) {
                        file.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private void firstTimeSetup() {
        String sdkName = this.sdkInfo.getSdkName();
        if (!KeyValueStore.read(this.context, sdkName, PaymentConstants.BUILD_ID, "__failed").equals(this.buildId)) {
            this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.FIRST_TIME_SETUP, "started", (Object) null);
            KeyValueStore.write(this.context, sdkName, PaymentConstants.BUILD_ID, this.buildId);
            KeyValueStore.remove(this.context, sdkName, "asset_metadata.json");
            File dir = this.context.getDir("juspay", 0);
            if (dir.exists()) {
                Utils.deleteRecursive(dir);
            }
            try {
                new File(this.context.getCacheDir(), "juspay-logs-queue.dat").delete();
                new File(this.context.getCacheDir(), "temp-logs-queue.dat").delete();
                new File(this.context.getCacheDir(), "juspay-pre-logs-queue.dat").delete();
                deleteFiles(this.context);
                this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.FIRST_TIME_SETUP, "completed", (Object) null);
            } catch (Exception e) {
                this.sdkTracker.trackAndLogException(this.LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.FIRST_TIME_SETUP, "Exception while fetching meta-data for manifest.json file", e);
            }
        }
    }

    private String getBootloaderEndpoint(JSONObject jSONObject) {
        String str;
        TenantParams tenantParams2 = this.tenantParams;
        if (tenantParams2 != null) {
            return tenantParams2.getBootLoaderEndpoint();
        }
        String str2 = "common";
        if (jSONObject == null || !jSONObject.optBoolean(PaymentConstants.BETA_ASSETS, false)) {
            String str3 = this.merchantClientId;
            if (str3 != null) {
                str2 = str3.toLowerCase().split("_")[0];
            }
            str = "";
        } else {
            str = "sandbox.";
        }
        return String.format(Constants.BOOTLOADER_REMOTE_ASSET_PATH_FORMAT, new Object[]{str, str2});
    }

    private Map<String, Object> getJavaScriptInterfaces() {
        HashMap hashMap = new HashMap();
        hashMap.put("JBridge", this.jBridge);
        hashMap.put(this.bridgeList.getInterfaceName(), this.bridgeList);
        if (PaymentUtils.isClassAvailable("in.juspay.hyperupi.UPIBridge")) {
            this.bridgeList.addHyperBridge(new UPIBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperapayupi.APayUPIBridge")) {
            this.bridgeList.addHyperBridge(new APayUPIBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypersimpl.SimplBridge")) {
            this.bridgeList.addHyperBridge(new SimplBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypergpayintl.GPayIntlBridge")) {
            this.bridgeList.addHyperBridge(new GPayIntlBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperapay.APayBridge")) {
            this.bridgeList.addHyperBridge(new APayBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperpaypal.PaypalBridge")) {
            this.bridgeList.addHyperBridge(new PaypalBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperqr.QrBridge")) {
            this.bridgeList.addHyperBridge(new QrBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypernfc.NfcBridge")) {
            this.bridgeList.addHyperBridge(new NfcBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypergpay.GPayBridge")) {
            this.bridgeList.addHyperBridge(new GPayBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hyperpayu.PayUBridge")) {
            this.bridgeList.addHyperBridge(new PayUBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.hypertrident.TridentBridge")) {
            this.bridgeList.addHyperBridge(new TridentBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.mobility.customer.MobilityCustomerBridge")) {
            this.bridgeList.addHyperBridge(new MobilityCustomerBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.mobility.driver.MobilityDriverBridge")) {
            this.bridgeList.addHyperBridge(new MobilityDriverBridge(this.bridgeComponents));
        }
        if (PaymentUtils.isClassAvailable("in.juspay.mobility.app.MobilityAppBridge")) {
            this.bridgeList.addHyperBridge(new MobilityAppBridge(this.bridgeComponents));
        }
        try {
            TenantParams tenantParams2 = this.tenantParams;
            if (tenantParams2 != null) {
                for (Class<? extends HyperBridge> constructors : tenantParams2.getBridgeClasses()) {
                    for (Constructor constructor : constructors.getConstructors()) {
                        if (constructor.getParameterTypes().length == 1 && constructor.getParameterTypes()[0].equals(BridgeComponents.class)) {
                            this.bridgeList.addHyperBridge((HyperBridge) constructor.newInstance(new Object[]{this.bridgeComponents}));
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(this.LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.ADD_BRIDGE, "Exception while trying to add tenant bridge", e);
        }
        hashMap.putAll(this.bridgeList.getBridgeList());
        return hashMap;
    }

    private void insetUpdated(WindowInsets windowInsets) {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            float f = fragmentActivity.getResources().getDisplayMetrics().density;
            float systemWindowInsetTop = ((float) windowInsets.getSystemWindowInsetTop()) / f;
            float systemWindowInsetRight = ((float) windowInsets.getSystemWindowInsetRight()) / f;
            float systemWindowInsetBottom = ((float) windowInsets.getSystemWindowInsetBottom()) / f;
            float systemWindowInsetLeft = ((float) windowInsets.getSystemWindowInsetLeft()) / f;
            float stableInsetTop = ((float) windowInsets.getStableInsetTop()) / f;
            float stableInsetRight = ((float) windowInsets.getStableInsetRight()) / f;
            float stableInsetBottom = ((float) windowInsets.getStableInsetBottom()) / f;
            float stableInsetLeft = ((float) windowInsets.getStableInsetLeft()) / f;
            this.dynamicUI.addJsToWebView("window.insetUpdated(" + systemWindowInsetTop + "," + systemWindowInsetRight + "," + systemWindowInsetBottom + "," + systemWindowInsetLeft + "," + stableInsetTop + "," + stableInsetRight + "," + stableInsetBottom + "," + stableInsetLeft + ",)");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addFragment$6(FragmentEvent fragmentEvent, String str) {
        int i = AnonymousClass5.$SwitchMap$in$juspay$hypersdk$lifecycle$FragmentEvent[fragmentEvent.ordinal()];
        if (i == 1) {
            this.paused = true;
        } else if (i == 2) {
            this.paused = false;
        } else if (i == 3) {
            ActivityLaunchDelegate activityLaunchDelegate2 = this.activityLaunchDelegate;
            if (activityLaunchDelegate2 instanceof HyperActivityLaunchDelegate) {
                ((HyperActivityLaunchDelegate) activityLaunchDelegate2).fragmentAttached();
            }
            RequestPermissionDelegate requestPermissionDelegate2 = this.requestPermissionDelegate;
            if (requestPermissionDelegate2 instanceof HyperRequestPermissionDelegate) {
                ((HyperRequestPermissionDelegate) requestPermissionDelegate2).fragmentAttached();
            }
            IntentSenderDelegate intentSenderDelegate2 = this.intentSenderDelegate;
            if (intentSenderDelegate2 instanceof HyperIntentSenderDelegate) {
                ((HyperIntentSenderDelegate) intentSenderDelegate2).fragmentAttached();
            }
        }
        this.jBridge.invokeFnInDUIWebview(fragmentEvent.toString(), str);
    }

    /* access modifiers changed from: private */
    public void lambda$addFragment$7(FragmentActivity fragmentActivity) {
        try {
            this.fragment = new HyperFragment();
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            supportFragmentManager.getClass();
            a aVar = new a(supportFragmentManager);
            aVar.g(0, this.fragment, fragmentTag, 1);
            commitFragmentTransaction(aVar);
            for (FragmentEvent next : this.fragmentEvents) {
                this.fragment.registerForEvent(next, new C1092eh(this, next));
            }
            this.fragment.registerOnActivityResult(new C1113fh(this));
            this.fragment.registerOnRequestPermissionResult(new C1134gh(this));
        } catch (Exception e) {
            this.sdkTracker.trackException(LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.ANDROID, Labels.Android.FRAGMENT_OPERATION, "Exception while committing fragment", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$logEncryptionSupport$1(JSONObject jSONObject, SdkTracker sdkTracker2) {
        try {
            if (KeyValueStore.read(this, "isHardwareBacked", (String) null) == null) {
                KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                instance.initialize(new KeyGenParameterSpec.Builder("juspay", 3).build());
                PrivateKey privateKey = instance.generateKeyPair().getPrivate();
                KeyInfo keyInfo = (KeyInfo) KeyFactory.getInstance(privateKey.getAlgorithm(), "AndroidKeyStore").getKeySpec(privateKey, KeyInfo.class);
                jSONObject.put("isHardwareBacked", keyInfo.isInsideSecureHardware());
                KeyValueStore.write(this, "isHardwareBacked", keyInfo.isInsideSecureHardware() + "");
                sdkTracker2.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.PHONE_STATE, jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(JSONObject jSONObject) {
        this.sdkTracker.setLabelsToDrop(jSONObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ WindowInsets lambda$process$3(View view, WindowInsets windowInsets) {
        view.onApplyWindowInsets(windowInsets);
        insetUpdated(windowInsets);
        return windowInsets;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$process$4(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        FrameLayout frameLayout;
        if (!(this.activity == fragmentActivity && ((frameLayout = this.container) == null || frameLayout.getParent() == viewGroup))) {
            this.jBridge.clearMerchantViews(this.activity);
            this.jBridge.clearMerchantViews(fragmentActivity);
        }
        if (fragmentActivity != this.activity) {
            removeFragment();
            addFragment(fragmentActivity);
            this.activity = fragmentActivity;
            this.jBridge.setActivity(fragmentActivity);
            this.dynamicUI.setActivity(fragmentActivity);
        }
        FrameLayout frameLayout2 = this.container;
        if (frameLayout2 == null || frameLayout2.getParent() != viewGroup) {
            FrameLayout createSubLayout = createSubLayout(fragmentActivity);
            viewGroup.addView(createSubLayout);
            FrameLayout frameLayout3 = this.container;
            if (frameLayout3 != null) {
                ViewParent parent = frameLayout3.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.container);
                }
            }
            this.dynamicUI.setContainer(createSubLayout);
            viewGroup.setOnApplyWindowInsetsListener(new C1071dh(this));
            this.container = createSubLayout;
            this.jBridge.setContainer(viewGroup);
            this.dynamicUI.setContainer(createSubLayout);
        }
    }

    /* access modifiers changed from: private */
    public void lambda$removeFragment$8() {
        HyperFragment hyperFragment;
        if (!(this.activity == null || (hyperFragment = this.fragment) == null || !hyperFragment.isAdded())) {
            try {
                FragmentManager supportFragmentManager = this.activity.getSupportFragmentManager();
                if (!supportFragmentManager.f2096e && supportFragmentManager.C(fragmentTag) != null) {
                    a aVar = new a(supportFragmentManager);
                    aVar.n(this.fragment);
                    commitFragmentTransaction(aVar);
                }
            } catch (Exception e) {
                this.sdkTracker.trackException(LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.ANDROID, Labels.Android.FRAGMENT_OPERATION, "Exception while removing fragment", e);
            }
        }
        this.fragment = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$reset$5() {
        this.jBridge.clearMerchantViews(this.activity);
        removeFragment();
        this.activity = null;
        this.jBridge.setActivity((Activity) null);
        this.dynamicUI.resetActivity();
        resetBridges();
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.container);
            }
        }
        this.container = null;
        this.dynamicUI.setContainer((FrameLayout) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setBundleParameter$2(JSONObject jSONObject) {
        if (Objects.equals(this.workingLogger, "json-array") || Objects.equals(this.workingLogger, "both")) {
            LogPusher.setLogHeaderValues(jSONObject, LogConstants.DEFAULT_CHANNEL);
        }
        if (this.logSessioniserExp != null) {
            LogPusherExp.setLogHeaderValues(jSONObject, LogConstants.DEFAULT_CHANNEL);
        }
    }

    private void logMemoryInfo(SdkTracker sdkTracker2, Context context2) {
        ActivityManager.MemoryInfo memoryInfo = Utils.getMemoryInfo(context2);
        if (memoryInfo != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("available_memory", memoryInfo.availMem);
                jSONObject.put("threshold_memory", memoryInfo.threshold);
                jSONObject.put("total_memory", memoryInfo.totalMem);
                sdkTracker2.trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.MEMORY, "memory_info", jSONObject);
            } catch (Exception e) {
                SdkTracker sdkTracker3 = sdkTracker2;
                sdkTracker3.trackAndLogException(this.LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, "session_info", "Exception while logging memory_info", e);
            }
        }
    }

    private void prefetchBootLoaderFile(JSONObject jSONObject) {
        this.remoteAssetService.renewFile(this.context, getBootloaderEndpoint(jSONObject), (String) null, "v1-boot_loader.zip", System.currentTimeMillis());
    }

    private void removeFragment() {
        ExecutorManager.runOnMainThread(new C0492E9(this, 2));
    }

    private void resetBridges() {
        for (HyperBridge reset : this.bridgeList.getBridgeList().values()) {
            reset.reset();
        }
    }

    private void setLastProcessPayload(JSONObject jSONObject) {
        this.lastProcessPayload = jSONObject;
    }

    private boolean useCommit() {
        if (this.merchantClientId == null) {
            return true;
        }
        return !Utils.optJSONObject(this.sdkConfigService.getSdkConfig(), "useCommitNowClientIds").optString(this.merchantClientId.toLowerCase().split("_")[0]).equals("true");
    }

    public void addJsToWebView(String str) {
        this.dynamicUI.addJsToWebView(str);
    }

    public Activity getActivity() {
        return this.activity;
    }

    public JSONObject getBundleParameters() {
        return this.bundleParameters;
    }

    public FrameLayout getContainer() {
        return this.container;
    }

    public Context getContext() {
        return this.context;
    }

    public DynamicUI getDynamicUI() {
        return this.dynamicUI;
    }

    public FileProviderService getFileProviderService() {
        return this.fileProviderService;
    }

    public HyperFragment getFragment() {
        return this.fragment;
    }

    public HyperPaymentsCallback getHyperCallback() {
        return this.hyperCallback;
    }

    public JBridge getJBridge() {
        return this.jBridge;
    }

    public Map<String, HyperBridge> getJBridgeList() {
        return this.bridgeList.getBridgeList();
    }

    public JSONObject getLastProcessPayload() {
        return this.lastProcessPayload;
    }

    public LogSessioniserExp getLogSessioniserExp() {
        return this.logSessioniserExp;
    }

    public PaymentSessionInfo getPaymentSessionInfo() {
        return this.paymentSessionInfo;
    }

    public RemoteAssetService getRemoteAssetService() {
        return this.remoteAssetService;
    }

    public SdkConfigService getSdkConfigService() {
        return this.sdkConfigService;
    }

    public final SdkInfo getSdkInfo() {
        return this.sdkInfo;
    }

    public SdkTracker getSdkTracker() {
        return this.sdkTracker;
    }

    public SessionInfo getSessionInfo() {
        return this.sessionInfo;
    }

    public SmsServices getSmsServices() {
        return this.smsServices;
    }

    public JuspayWebViewConfigurationCallback getWebViewConfigurationCallback() {
        return this.webViewConfigurationCallback;
    }

    public String getWorkingLogger() {
        return this.workingLogger;
    }

    public void initiate(Runnable runnable) {
        firstTimeSetup();
        prefetchBootLoaderFile(this.bundleParameters);
        if (!this.dynamicUI.initiate()) {
            if (this.dynamicUI.getWebViewCrashException() != null) {
                this.sdkTracker.trackAndLogException(this.LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.ANDROID, Labels.Android.WEBVIEW, "WebView creation failed", this.dynamicUI.getWebViewCrashException());
            }
            this.isWebViewAvailable = false;
            runnable.run();
            return;
        }
        this.webViewCrashCallback = runnable;
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.HyperSdk.JUSPAY_SERVICES, "url_loaded", "base.html");
    }

    public boolean isPaused() {
        return this.paused;
    }

    public boolean isPrefetch() {
        return this.isPrefetch;
    }

    public boolean isWebViewAvailable() {
        return this.isWebViewAvailable;
    }

    public void logEncryptionSupport(SdkTracker sdkTracker2, Context context2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                jSONObject.put("isStrongBoxBacked", context2.getPackageManager().hasSystemFeature("android.hardware.strongbox_keystore"));
            }
        } catch (Exception e) {
            sdkDebug(this.LOG_TAG, Arrays.toString(e.getStackTrace()));
        }
        ExecutorManager.runOnBackgroundThread(new r((Object) this, 4, (Object) jSONObject, (Object) sdkTracker2));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = i;
        int i4 = i2;
        Intent intent2 = intent;
        if (i4 == -1) {
            this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.ON_ACTIVITY_RESULT, "result_code", "RESULT_OK");
            if (!(intent2 == null || intent.getExtras() == null)) {
                this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.ON_ACTIVITY_RESULT, "result_code", Utils.toJSON(intent.getExtras()));
            }
        } else if (i4 == 0) {
            this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.HYPER_SDK, "info", Labels.Android.ON_ACTIVITY_RESULT, "result_code", "RESULT_CANCELLED");
        }
        for (HyperBridge onActivityResult : this.bridgeList.getBridgeList().values()) {
            if (onActivityResult.onActivityResult(i3, i4, intent2)) {
                return;
            }
        }
        this.jBridge.onActivityResult(i3, i4, intent2);
    }

    public void onBackPressed() {
        this.sdkTracker.trackLifecycle(LogSubCategory.LifeCycle.ANDROID, "info", Labels.Android.BACK_PRESSED, "class", "juspayServices");
        this.jBridge.requestKeyboardHide();
        this.jBridge.invokeFnInDUIWebview("onBackPressed", "{\"shouldShowBackPressDialog\":true}");
    }

    public void onMerchantEvent(String str, JSONObject jSONObject) {
        if (str.equals(Labels.HyperSdk.PROCESS)) {
            setLastProcessPayload(jSONObject);
        }
        this.jBridge.invokeCustomFnInDUIWebview(String.format("window.onMerchantEvent('%s',%s);", new Object[]{str, this.dynamicUI.encodeUtfAndWrapDecode(jSONObject.toString(), this.LOG_TAG)}));
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        SdkTracker sdkTracker2 = this.sdkTracker;
        StringBuilder m = lf.m("requestCode = [", i, "],permissions = [");
        m.append(Arrays.toString(strArr));
        m.append("], grantResults = [");
        m.append(Arrays.toString(iArr));
        m.append("]");
        sdkTracker2.trackAction(LogSubCategory.Action.SYSTEM, "info", Labels.System.ON_REQUEST_PERMISSION_RESULT, Constants.ScionAnalytics.MessageType.DATA_MESSAGE, m.toString());
        for (HyperBridge onRequestPermissionResult : this.bridgeList.getBridgeList().values()) {
            if (onRequestPermissionResult.onRequestPermissionResult(i, strArr, iArr)) {
                return;
            }
        }
        this.jBridge.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void process(FragmentActivity fragmentActivity, ViewGroup viewGroup) {
        FrameLayout frameLayout;
        this.smsServices.createSMSConsent();
        if (fragmentActivity != this.activity || (frameLayout = this.container) == null || viewGroup != frameLayout.getParent()) {
            ExecutorManager.runOnMainThread(new r((Object) this, 5, (Object) fragmentActivity, (Object) viewGroup));
        }
    }

    public void requestPermission(String[] strArr, int i) {
        this.requestPermissionDelegate.requestPermission(strArr, i);
    }

    public void reset() {
        ExecutorManager.runOnMainThread(new C0492E9(this, 1));
    }

    public void sdkDebug(String str, String str2) {
        if (this.sdkInfo.isSdkDebuggable()) {
            JuspayLogger.d(str, str2);
        }
    }

    public void setActivityLaunchDelegate(ActivityLaunchDelegate activityLaunchDelegate2) {
        this.activityLaunchDelegate = activityLaunchDelegate2;
    }

    public void setBundleParameter(JSONObject jSONObject) {
        boolean z;
        try {
            jSONObject.put(PaymentConstants.SDK_NAME, this.sdkInfo.getSdkName());
            jSONObject.put("sdkVersion", this.sdkInfo.getSdkVersion());
            this.bundleParameters = jSONObject;
            JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.PAYLOAD);
            if (jSONObject2.has(PaymentConstants.ENV)) {
                z = jSONObject2.getString(PaymentConstants.ENV).equalsIgnoreCase(PaymentConstants.ENVIRONMENT.SANDBOX);
            } else {
                z = false;
            }
            this.sdkTracker.setEndPointSandbox(Boolean.valueOf(z));
            if (jSONObject2.has(PaymentConstants.CLIENT_ID_CAMEL)) {
                this.merchantClientId = jSONObject2.getString(PaymentConstants.CLIENT_ID_CAMEL);
            }
            setUpMerchantFragments(jSONObject2);
            this.sessionInfo.setBundleParams(jSONObject);
            this.sessionInfo.createSessionDataMap();
            this.sessionInfo.logDeviceIdentifiers();
            JSONObject sessionData = this.sessionInfo.getSessionData();
            sessionData.put(PaymentConstants.MERCHANT_ID, this.sessionInfo.getMerchantId());
            sessionData.put(PaymentConstants.CLIENT_ID, this.sessionInfo.getClientId().split("_")[0].toLowerCase());
            sessionData.put("session_id", this.sessionInfo.getSessionId());
            this.sessionInfo.logSessionInfo();
            ExecutorManager.runOnLogSessioniserThread(new m(3, this, sessionData));
        } catch (Exception e) {
            this.sdkTracker.trackAndLogException(this.LOG_TAG, LogCategory.LIFECYCLE, LogSubCategory.LifeCycle.HYPER_SDK, Labels.HyperSdk.SET_BUNDLE_PARAMS, "Exception while setting bundle parameter", e);
        }
    }

    public void setHyperCallback(HyperPaymentsCallback hyperPaymentsCallback) {
        this.hyperCallback = hyperPaymentsCallback;
    }

    public void setIntentSenderDelegate(IntentSenderDelegate intentSenderDelegate2) {
        this.intentSenderDelegate = intentSenderDelegate2;
    }

    public void setPrefetch(boolean z) {
        this.isPrefetch = z;
    }

    public void setRequestPermissionDelegate(RequestPermissionDelegate requestPermissionDelegate2) {
        this.requestPermissionDelegate = requestPermissionDelegate2;
    }

    public void setUpMerchantFragments(JSONObject jSONObject) {
        if (jSONObject.has(PaymentConstants.FRAGMENT_VIEW_GROUPS) && this.activity != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(PaymentConstants.FRAGMENT_VIEW_GROUPS);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject2.opt(next);
                    if (opt instanceof ViewGroup) {
                        FrameLayout createSubLayout = createSubLayout(this.activity);
                        ((ViewGroup) opt).addView(createSubLayout);
                        jSONObject2.put(next, this.dynamicUI.addToContainerList(createSubLayout));
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void setWebViewConfigurationCallback(JuspayWebViewConfigurationCallback juspayWebViewConfigurationCallback) {
        this.webViewConfigurationCallback = juspayWebViewConfigurationCallback;
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        this.activityLaunchDelegate.startActivityForResult(intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.intentSenderDelegate.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void terminate() {
        MPINUtil.closeAllConnections(getContext());
        this.jBridge.reset();
        for (HyperBridge terminate : this.bridgeList.getBridgeList().values()) {
            terminate.terminate();
        }
        ActivityLaunchDelegate activityLaunchDelegate2 = this.activityLaunchDelegate;
        if (activityLaunchDelegate2 instanceof HyperActivityLaunchDelegate) {
            ((HyperActivityLaunchDelegate) activityLaunchDelegate2).clearQueue();
        }
        IntentSenderDelegate intentSenderDelegate2 = this.intentSenderDelegate;
        if (intentSenderDelegate2 instanceof HyperIntentSenderDelegate) {
            ((HyperIntentSenderDelegate) intentSenderDelegate2).clearQueue();
        }
        RequestPermissionDelegate requestPermissionDelegate2 = this.requestPermissionDelegate;
        if (requestPermissionDelegate2 instanceof HyperRequestPermissionDelegate) {
            ((HyperRequestPermissionDelegate) requestPermissionDelegate2).clearQueue();
        }
        this.dynamicUI.terminate();
        this.smsServices.unregisterSmsConsent();
    }

    public void onMerchantEvent(JSONObject jSONObject) {
        onMerchantEvent(LogConstants.DEFAULT_CHANNEL, jSONObject);
    }
}
