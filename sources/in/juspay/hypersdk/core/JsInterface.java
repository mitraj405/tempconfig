package in.juspay.hypersdk.core;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniser;
import in.juspay.hypersdk.data.KeyValueStore;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.services.FileProviderService;
import in.juspay.hypersdk.services.RemoteAssetService;
import java.util.Arrays;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class JsInterface {
    private static final String LOG_TAG = "JsInterface";
    private final Context context;
    private final FileProviderService fileProviderService;
    protected final JuspayServices juspayServices;
    private final RemoteAssetService remoteAssetService;
    private final SdkTracker sdkTracker;
    private final SessionInfo sessionInfo;

    public JsInterface(JuspayServices juspayServices2) {
        this.context = juspayServices2.getContext();
        this.juspayServices = juspayServices2;
        this.sessionInfo = juspayServices2.getSessionInfo();
        this.sdkTracker = juspayServices2.getSdkTracker();
        this.remoteAssetService = juspayServices2.getRemoteAssetService();
        this.fileProviderService = juspayServices2.getFileProviderService();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogProperties$1(String str) {
        try {
            this.sdkTracker.addLogProperties(new JSONObject(str));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestPendingLogs$3(String str, String str2) {
        String str3;
        try {
            if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
                str3 = LogSessioniser.getLogsFromSessionId(new JSONObject(str));
                this.juspayServices.getJBridge().invokeCallbackInDUIWebview(str2, str3);
            }
        } catch (Exception unused) {
        }
        str3 = "{}";
        this.juspayServices.getJBridge().invokeCallbackInDUIWebview(str2, str3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setAnalyticsHeader$0(JSONObject jSONObject) {
        if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
            LogPusher.setHeaders(jSONObject, LogConstants.DEFAULT_CHANNEL);
        }
        if (this.juspayServices.getLogSessioniserExp() != null) {
            LogPusherExp.setHeaders(jSONObject, LogConstants.DEFAULT_CHANNEL);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setAnalyticsHeader$2(JSONObject jSONObject, String str) {
        if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
            LogPusher.setHeaders(jSONObject, str);
        }
        if (this.juspayServices.getLogSessioniserExp() != null) {
            LogPusherExp.setHeaders(jSONObject, str);
        }
    }

    @JavascriptInterface
    public boolean addChannel(String str, String str2) {
        if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
            return LogPusher.addChannelFromJS(str, str2);
        }
        return false;
    }

    @JavascriptInterface
    public boolean addChannelExp(String str, String str2) {
        if (this.juspayServices.getLogSessioniserExp() != null) {
            return LogPusherExp.addChannelFromJS(str, str2);
        }
        return false;
    }

    @JavascriptInterface
    public void addLogProperties(String str) {
        ExecutorManager.runOnSdkTrackerPool(new m(2, this, str));
    }

    @JavascriptInterface
    public void addToLogList(String str) {
        if (this.sessionInfo.getSessionId() != null) {
            try {
                this.sdkTracker.track(new JSONObject(str));
            } catch (JSONException e) {
                this.sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Exception while parsing the JSON", e);
            }
        } else {
            SdkTracker.addToBootLogs(str);
        }
    }

    @JavascriptInterface
    public String getChannelNames() {
        if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
            return Arrays.toString(LogPusher.getChannelNames());
        }
        return "[]";
    }

    @JavascriptInterface
    public String getChannelNamesExp() {
        if (this.juspayServices.getLogSessioniserExp() != null) {
            return Arrays.toString(LogPusherExp.getChannelNames());
        }
        return "[]";
    }

    @JavascriptInterface
    public String getFileDownloadTimes() {
        return this.remoteAssetService.getFileDownloadTimes().toString();
    }

    @JavascriptInterface
    public String getFilePath(String str) {
        return this.fileProviderService.appendSdkNameAndVersion(str);
    }

    @JavascriptInterface
    public String getFromSharedPrefs(String str) {
        return KeyValueStore.read(this.juspayServices, str, "__failed");
    }

    @JavascriptInterface
    public String getLogList() {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.getLogList() method. It will be removed in future.");
        return "[]";
    }

    @JavascriptInterface
    public String getMd5(String str) {
        return EncryptionHelper.md5(str.getBytes());
    }

    @JavascriptInterface
    public String getResourceById(int i) {
        return this.context.getResources().getString(i);
    }

    @JavascriptInterface
    public String getResourceByName(String str) {
        return getResourceById(this.context.getResources().getIdentifier(str, "string", this.context.getPackageName()));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051 A[Catch:{ JSONException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x003e A[Catch:{ JSONException -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0045 A[Catch:{ JSONException -> 0x005b }] */
    @android.webkit.JavascriptInterface
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getRootFragmentSize() {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            in.juspay.hypersdk.core.JuspayServices r1 = r5.juspayServices
            android.widget.FrameLayout r1 = r1.getContainer()
            java.lang.String r2 = "width"
            java.lang.String r3 = "height"
            java.lang.String r4 = ""
            if (r1 == 0) goto L_0x0060
            in.juspay.hypersdk.core.JuspayServices r1 = r5.juspayServices     // Catch:{ JSONException -> 0x0036 }
            android.widget.FrameLayout r1 = r1.getContainer()     // Catch:{ JSONException -> 0x0036 }
            int r1 = r1.getHeight()     // Catch:{ JSONException -> 0x0036 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ JSONException -> 0x0036 }
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0036 }
            in.juspay.hypersdk.core.JuspayServices r1 = r5.juspayServices     // Catch:{ JSONException -> 0x0036 }
            android.widget.FrameLayout r1 = r1.getContainer()     // Catch:{ JSONException -> 0x0036 }
            int r1 = r1.getWidth()     // Catch:{ JSONException -> 0x0036 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ JSONException -> 0x0036 }
            r0.put(r2, r1)     // Catch:{ JSONException -> 0x0036 }
            goto L_0x0084
        L_0x0036:
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x005b }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x005b }
            if (r1 == 0) goto L_0x0045
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x005b }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x005b }
            goto L_0x0046
        L_0x0045:
            r1 = r4
        L_0x0046:
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x005b }
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x005b }
            java.lang.String r1 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x005b }
            if (r1 == 0) goto L_0x0057
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x005b }
            java.lang.String r4 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x005b }
        L_0x0057:
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x005b }
            goto L_0x0084
        L_0x005b:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0084
        L_0x0060:
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x006f
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r1 = r1.getScreenHeight()     // Catch:{ JSONException -> 0x0084 }
            goto L_0x0070
        L_0x006f:
            r1 = r4
        L_0x0070:
            r0.put(r3, r1)     // Catch:{ JSONException -> 0x0084 }
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r1 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x0084 }
            if (r1 == 0) goto L_0x0081
            in.juspay.hypersdk.data.SessionInfo r1 = r5.sessionInfo     // Catch:{ JSONException -> 0x0084 }
            java.lang.String r4 = r1.getScreenWidth()     // Catch:{ JSONException -> 0x0084 }
        L_0x0081:
            r0.put(r2, r4)     // Catch:{ JSONException -> 0x0084 }
        L_0x0084:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.core.JsInterface.getRootFragmentSize():java.lang.String");
    }

    @JavascriptInterface
    public String getSessionAttribute(String str, String str2) {
        return this.sessionInfo.get(str, str2);
    }

    @JavascriptInterface
    public String getSessionId() {
        return this.sessionInfo.getSessionId();
    }

    @JavascriptInterface
    public String getSessionInfo() {
        this.sessionInfo.createSessionDataMap();
        return this.sessionInfo.toString();
    }

    @JavascriptInterface
    public boolean isFilePresent(String str) {
        return this.fileProviderService.isFilePresent(this.context, str);
    }

    @JavascriptInterface
    public boolean isNetworkAvailable() {
        return this.sessionInfo.isNetworkAvailable();
    }

    @JavascriptInterface
    public String loadFileInDUI(String str) {
        return this.fileProviderService.readFromFile(this.context, str);
    }

    @JavascriptInterface
    public void postLogs(String str, String str2) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.postLogs() method. It will be removed in future.");
    }

    @JavascriptInterface
    public void removeAttribute(String str) {
        this.sessionInfo.removeAttribute(str);
    }

    @JavascriptInterface
    public void removeDataFromSharedPrefs(String str) {
        KeyValueStore.remove(this.juspayServices, str);
    }

    @JavascriptInterface
    public void removeFromSharedPrefs(String str) {
        KeyValueStore.remove(this.juspayServices.getContext(), this.juspayServices.getSdkInfo().getSdkName(), str);
    }

    @JavascriptInterface
    public void renewFile(String str) {
        renewFile(str, (String) null, (String) null);
    }

    @JavascriptInterface
    public void renewSdkConfig() {
        this.juspayServices.getSdkConfigService().renewConfig(this.context);
    }

    @JavascriptInterface
    public String requestPendingLogs(String str) {
        try {
            return (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) ? LogSessioniser.getLogsFromSessionId(new JSONObject(str)) : "{}";
        } catch (JSONException unused) {
            return "{}";
        }
    }

    @JavascriptInterface
    public void sessioniseLogs(String str) {
        try {
            if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
                LogSessioniser.sessioniseLogs(new JSONObject(str));
            }
        } catch (JSONException e) {
            this.sdkTracker.trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.JBRIDGE, C0709Uj.i("Logs request has invalid format", str), e);
        }
    }

    @JavascriptInterface
    public void setAnalyticsEndPoint(String str) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.setAnalyticsEndPoint() method. It will be removed in future.");
    }

    @JavascriptInterface
    public boolean setAnalyticsHeader(String str) {
        try {
            ExecutorManager.runOnLogPusherThread(new A1(7, this, new JSONObject(str)));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @JavascriptInterface
    public void setInSharedPrefs(String str, String str2) {
        KeyValueStore.write(this.juspayServices, str, str2);
    }

    @JavascriptInterface
    public void setSessionAttribute(String str, String str2) {
        this.sessionInfo.set(str, str2);
    }

    @JavascriptInterface
    public void setSessionId(String str) {
        JuspayLogger.d(LOG_TAG, "JBridge.setSessionId() is intended for changing the Session ID of the SDK. Not to be called by each micro-app");
        JuspayLogger.d(LOG_TAG, "Attempted Session ID: " + str);
    }

    @JavascriptInterface
    public void startPushingLogs() {
        if (this.juspayServices.getLogSessioniserExp() != null) {
            this.juspayServices.getLogSessioniserExp().startPushing();
        }
    }

    @JavascriptInterface
    public void toast(String str) {
        Toast.makeText(this.context, str, 1).show();
    }

    @JavascriptInterface
    public void updateLogList(String str) {
        JuspayLogger.e(LOG_TAG, "No one should call JBridge.updateLogList() method. It will be removed in future.");
    }

    @JavascriptInterface
    public String loadFileInDUI(String str, int i) {
        return this.fileProviderService.readFromFile(this.context, str);
    }

    @JavascriptInterface
    public void renewFile(String str, String str2) {
        renewFile(str, str2, (String) null);
    }

    @JavascriptInterface
    public void requestPendingLogs(String str, String str2) {
        ExecutorManager.runOnLogsPool(new r(this, str, (Object) str2, 3));
    }

    @JavascriptInterface
    public boolean setAnalyticsHeader(String str, String str2) {
        try {
            ExecutorManager.runOnLogPusherThread(new iw(this, 3, new JSONObject(str), str2));
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    @JavascriptInterface
    public void renewFile(String str, String str2, String str3) {
        this.remoteAssetService.renewFile(this.context, str, str3, str2, System.currentTimeMillis());
    }

    @JavascriptInterface
    public void submitAllLogs() {
    }
}
