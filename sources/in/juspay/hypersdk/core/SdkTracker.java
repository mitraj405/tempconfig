package in.juspay.hypersdk.core;

import android.app.ActivityManager;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hyper.core.TrackerInterface;
import in.juspay.hypersdk.analytics.LogConstants;
import in.juspay.hypersdk.analytics.LogPusher;
import in.juspay.hypersdk.analytics.LogPusherExp;
import in.juspay.hypersdk.analytics.LogSessioniser;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.data.SessionInfo;
import in.juspay.hypersdk.utils.IntegrationUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersmshandler.Tracker;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class SdkTracker implements TrackerInterface, Tracker {
    private static final String LOG_TAG = "SdkTracker";
    private static final int MAX_LOG_SIZE = 22528;
    private static final Queue<JSONObject> bootLogs = new ConcurrentLinkedQueue();
    private String godelBuildVersion = "";
    private String godelVersion = "";
    private String hyperSdkVersion = "";
    private final JuspayServices juspayServices;
    private final HashSet<String> labelsToDrop = new HashSet<>();
    private final JSONObject logProperties = new JSONObject();
    private AtomicInteger serialNumberCounter = new AtomicInteger(1);

    public SdkTracker(JuspayServices juspayServices2) {
        this.juspayServices = juspayServices2;
        try {
            this.hyperSdkVersion = IntegrationUtils.getSdkVersion(juspayServices2.getContext());
            this.godelVersion = IntegrationUtils.getGodelVersion(juspayServices2.getContext());
            this.godelBuildVersion = IntegrationUtils.getGodelBuildVersion(juspayServices2.getContext());
        } catch (Exception unused) {
        }
        ExecutorManager.runOnSdkTrackerPool(new C1489xv());
    }

    public static void addToBootLogs(String str) {
        ExecutorManager.runOnSdkTrackerPool(new u(str, 2));
    }

    private static JSONObject cloneJSON(JSONObject jSONObject) {
        JSONArray names = jSONObject.names();
        if (names == null) {
            names = new JSONArray();
        }
        JSONObject jSONObject2 = new JSONObject();
        for (int i = 0; i < names.length(); i++) {
            String str = (String) names.opt(i);
            Object opt = jSONObject.opt(str);
            if (opt instanceof JSONObject) {
                opt = cloneJSON((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = cloneJSONArray((JSONArray) opt);
            }
            jSONObject2.put(str, opt);
        }
        return jSONObject2;
    }

    private static JSONArray cloneJSONArray(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object opt = jSONArray.opt(i);
            if (opt instanceof JSONObject) {
                opt = cloneJSON((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                opt = cloneJSONArray((JSONArray) opt);
            }
            jSONArray2.put(opt);
        }
        return jSONArray2;
    }

    private static Object cloneObject(Object obj) {
        try {
            if (obj instanceof JSONObject) {
                return cloneJSON((JSONObject) obj);
            }
            if (obj instanceof JSONArray) {
                return cloneJSONArray((JSONArray) obj);
            }
            return obj;
        } catch (Exception unused) {
            return obj;
        }
    }

    private JSONObject createApiExceptionLog(String str, String str2, String str3, Long l, Long l2, Object obj, String str4, String str5, String str6, Throwable th, JSONArray jSONArray, JSONObject jSONObject) {
        JSONArray names;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("url", str4);
            jSONObject3.put("start_time", l);
            jSONObject3.put("end_time", l2);
            jSONObject3.put(PaymentConstants.PAYLOAD, obj == null ? JSONObject.NULL : cloneObject(obj));
            jSONObject3.put(FirebaseAnalytics.Param.METHOD, str5);
            jSONObject3.put("message", str6 + ". " + th.getLocalizedMessage());
            jSONObject3.put("stacktrace", formatThrowable(th));
            jSONObject2.put("category", str);
            jSONObject2.put("subcategory", str2);
            jSONObject2.put(FirebaseAnalytics.Param.LEVEL, "exception");
            jSONObject2.put(Constants.ScionAnalytics.PARAM_LABEL, str3 + "_" + Utils.getLogLevelFromThrowable(th));
            jSONObject2.put("value", jSONObject3);
            jSONObject2.put("at", System.currentTimeMillis());
            jSONObject2.put(PaymentConstants.SERVICE, PaymentConstants.Category.SDK);
            jSONObject2.put("channels", jSONArray);
            if (!(jSONObject == null || (names = jSONObject.names()) == null)) {
                for (int i = 0; i < names.length(); i++) {
                    String string = names.getString(i);
                    jSONObject2.put(string, jSONObject.getString(string));
                }
            }
        } catch (Exception e) {
            JuspayLogger.e(LOG_TAG, "Error while adding API exception log: ", e);
        }
        return jSONObject2;
    }

    private static JSONObject createApiLog(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("url", str4);
            jSONObject2.put("status_code", num);
            jSONObject2.put("start_time", l);
            jSONObject2.put("end_time", l2);
            jSONObject2.put(PaymentConstants.PAYLOAD, obj == null ? JSONObject.NULL : cloneObject(obj));
            jSONObject2.put("response", cloneObject(obj2));
            jSONObject2.put(FirebaseAnalytics.Param.METHOD, str5);
            jSONObject.put("category", LogCategory.API_CALL);
            jSONObject.put("subcategory", str);
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, str2);
            jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, str3);
            jSONObject.put("value", jSONObject2);
            jSONObject.put("at", System.currentTimeMillis());
            jSONObject.put(PaymentConstants.SERVICE, PaymentConstants.Category.SDK);
        } catch (JSONException e) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e);
        }
        return jSONObject;
    }

    private static JSONObject createExceptionLog(String str, String str2, String str3, String str4, Throwable th) {
        return createExceptionLog(str, str2, str3, str4, th, false);
    }

    private static JSONObject createLog(String str, String str2, String str3, String str4, String str5, Object obj) {
        Object obj2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (obj == null) {
            try {
                obj2 = JSONObject.NULL;
            } catch (JSONException e) {
                JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e);
            }
        } else {
            obj2 = cloneObject(obj);
        }
        jSONObject2.put(str5, obj2);
        jSONObject.put("category", str);
        jSONObject.put("subcategory", str2);
        jSONObject.put(FirebaseAnalytics.Param.LEVEL, str3);
        jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, str4);
        jSONObject.put("value", jSONObject2);
        jSONObject.put("at", System.currentTimeMillis());
        jSONObject.put(PaymentConstants.SERVICE, PaymentConstants.Category.SDK);
        return jSONObject;
    }

    private static JSONObject createLogWithValue(String str, String str2, String str3, String str4, Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", str);
            jSONObject.put("subcategory", str2);
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, str3);
            jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, str4);
            jSONObject.put("value", cloneObject(obj));
            jSONObject.put("at", System.currentTimeMillis());
            jSONObject.put(PaymentConstants.SERVICE, PaymentConstants.Category.SDK);
        } catch (JSONException e) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e);
        }
        return jSONObject;
    }

    private static String formatThrowable(Throwable th) {
        StringBuilder sb = new StringBuilder(getStackTraceAsString(th));
        while (true) {
            th = th.getCause();
            if (th == null) {
                return sb.toString();
            }
            sb.append("\nCaused by ");
            sb.append(getStackTraceAsString(th));
        }
    }

    private static String getStackTraceAsString(Throwable th) {
        StringBuilder sb = new StringBuilder(th.toString());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\n\tat ");
            sb.append(stackTraceElement.toString());
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogToPersistedQueue$14(JSONObject jSONObject) {
        if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
            LogPusher.addLogsToPersistedQueue(jSONObject);
        }
        if (this.juspayServices.getLogSessioniserExp() != null) {
            LogPusherExp.addLogsToPersistedQueue(jSONObject);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addToBootLogs$1(String str) {
        JuspayLogger.log(LOG_TAG, "DEBUG", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("at")) {
                jSONObject.put("at", System.currentTimeMillis());
            }
            bootLogs.add(jSONObject);
        } catch (Exception e) {
            JuspayLogger.e(LOG_TAG, "addToBootLogs", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setEndPointSandbox$18(Boolean bool) {
        if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
            LogPusher.setEndPointSandbox(bool);
        }
        if (this.juspayServices.getLogSessioniserExp() != null) {
            LogPusherExp.setEndPointSandbox(bool);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$track$17(JSONObject jSONObject) {
        try {
            if (!shouldDropLog(jSONObject.optString(Constants.ScionAnalytics.PARAM_LABEL, ""))) {
                jSONObject.put("at", System.currentTimeMillis());
                trackParsed(jSONObject);
            }
        } catch (JSONException e) {
            trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Exception while parsing the JSON", e);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackAction$8(String str, String str2, String str3, String str4, Object obj) {
        if (!shouldDropLog(str)) {
            JSONObject createLog = createLog(LogCategory.ACTION, str2, str3, str, str4, obj);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createLog);
            } else {
                bootLogs.add(createLog);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackAndLogApiException$16(String str, String str2, Throwable th, String str3, String str4, String str5, Long l, Long l2, Object obj, String str6, String str7, JSONArray jSONArray, JSONObject jSONObject) {
        JuspayLogger.e(str, str2, th);
        if (!shouldDropLog(str3)) {
            trackPhoneState();
            JSONObject createApiExceptionLog = createApiExceptionLog(str4, str5, str3, l, l2, obj, str6, str7, str2, th, jSONArray, jSONObject);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createApiExceptionLog);
            } else {
                bootLogs.add(createApiExceptionLog);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$trackAndLogBootException$5(String str, String str2, Throwable th, String str3, String str4, String str5) {
        JuspayLogger.e(str, str2, th);
        bootLogs.add(createExceptionLog(str3, str4, str5, str2, th));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackAndLogException$15(String str, String str2, String str3, Throwable th, String str4, String str5) {
        if (!shouldDropLog(str)) {
            JuspayLogger.e(str2, str3, th);
            trackPhoneState();
            JSONObject createExceptionLog = createExceptionLog(str4, str5, str, str3, th);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createExceptionLog);
            } else {
                bootLogs.add(createExceptionLog);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackApiCalls$10(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5, JSONArray jSONArray, JSONObject jSONObject) {
        JSONObject createApiLog = createApiLog(str, str2, str3, num, str4, l, l2, obj, obj2, str5, jSONArray, jSONObject);
        if (this.juspayServices.getSessionInfo().getSessionId() != null) {
            trackParsed(createApiLog);
        } else {
            bootLogs.add(createApiLog);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackApiCalls$9(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5) {
        if (!shouldDropLog(str)) {
            JSONObject createApiLog = createApiLog(str2, str3, str, num, str4, l, l2, obj, obj2, str5);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createApiLog);
            } else {
                bootLogs.add(createApiLog);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackContext$11(String str, String str2, String str3, String str4, Object obj) {
        if (!shouldDropLog(str)) {
            JSONObject createLog = createLog(LogCategory.CONTEXT, str2, str3, str, str4, obj);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createLog);
            } else {
                bootLogs.add(createLog);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackContext$12(String str, String str2, String str3, Object obj) {
        if (!shouldDropLog(str)) {
            JSONObject createLogWithValue = createLogWithValue(LogCategory.CONTEXT, str2, str3, str, obj);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createLogWithValue);
            } else {
                bootLogs.add(createLogWithValue);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackException$13(String str, String str2, String str3, String str4, Throwable th) {
        if (!shouldDropLog(str)) {
            JSONObject createExceptionLog = createExceptionLog(str2, str3, str, str4, th);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createExceptionLog);
            } else {
                bootLogs.add(createExceptionLog);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackLifecycle$6(String str, String str2, String str3, String str4, Object obj) {
        if (!shouldDropLog(str)) {
            JSONObject createLog = createLog(LogCategory.LIFECYCLE, str2, str3, str, str4, obj);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createLog);
            } else {
                bootLogs.add(createLog);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$trackLifecycle$7(String str, String str2, String str3, JSONObject jSONObject) {
        if (!shouldDropLog(str)) {
            JSONObject createLogWithValue = createLogWithValue(LogCategory.LIFECYCLE, str2, str3, str, jSONObject);
            if (this.juspayServices.getSessionInfo().getSessionId() != null) {
                trackParsed(createLogWithValue);
            } else {
                bootLogs.add(createLogWithValue);
            }
        }
    }

    private void processBootLogs() {
        while (true) {
            Queue<JSONObject> queue = bootLogs;
            if (!queue.isEmpty()) {
                JSONObject poll = queue.poll();
                if (poll != null) {
                    try {
                        if (!shouldDropLog(poll.optString(Constants.ScionAnalytics.PARAM_LABEL, ""))) {
                            signLog(poll);
                            if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
                                LogSessioniser.addLogLine(this.juspayServices.getSessionInfo().getSessionId(), poll);
                            }
                            if (this.juspayServices.getLogSessioniserExp() != null) {
                                this.juspayServices.getLogSessioniserExp().addLogLine(poll);
                            }
                        }
                    } catch (Exception e) {
                        trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Exception while signing log line", e);
                    }
                }
            } else {
                return;
            }
        }
    }

    private boolean shouldDropLog(String str) {
        return this.labelsToDrop.contains(str);
    }

    private void signLog(JSONObject jSONObject) {
        SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
        if (!jSONObject.has("session_id")) {
            jSONObject.put("session_id", sessionInfo.getSessionId());
        }
        String clientId = sessionInfo.getClientId();
        if (!jSONObject.has(PaymentConstants.CLIENT_ID) && !clientId.isEmpty()) {
            String[] split = clientId.split("_", 2);
            if (split.length > 0) {
                jSONObject.put(PaymentConstants.CLIENT_ID, split[0].toLowerCase());
            }
        }
        String merchantId = sessionInfo.getMerchantId();
        if (!merchantId.isEmpty() && !jSONObject.has(PaymentConstants.MERCHANT_ID)) {
            jSONObject.put(PaymentConstants.MERCHANT_ID, merchantId);
        }
        String orderId = sessionInfo.getOrderId();
        if (!orderId.isEmpty() && !jSONObject.has(PaymentConstants.ORDER_ID)) {
            jSONObject.put(PaymentConstants.ORDER_ID, orderId);
        }
        if (!jSONObject.has("package_name")) {
            jSONObject.put("package_name", sessionInfo.getPackageName());
        }
        if (!jSONObject.has("log_version")) {
            jSONObject.put("log_version", PaymentConstants.LOG_VERSION);
        }
        jSONObject.put("sn", this.serialNumberCounter.getAndIncrement());
        if (!jSONObject.has("hyper_sdk_version")) {
            jSONObject.put("hyper_sdk_version", this.hyperSdkVersion);
        }
        if (!jSONObject.has(PaymentConstants.GODEL_VERSION)) {
            jSONObject.put(PaymentConstants.GODEL_VERSION, this.godelVersion);
        }
        if (!jSONObject.has(PaymentConstants.GODEL_BUILD_VERSION)) {
            jSONObject.put(PaymentConstants.GODEL_BUILD_VERSION, this.godelBuildVersion);
        }
        Iterator<String> keys = this.logProperties.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject.put(next, this.logProperties.optString(next));
        }
    }

    public static void trackAndLogBootException(String str, String str2, String str3, String str4, String str5, Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new C1467wv(str, str5, th, str2, str3, str4));
    }

    public static void trackBootAction(String str, String str2, String str3, String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new a(str, str2, str3, str4, obj, 3));
    }

    public static void trackBootException(String str, String str2, String str3, String str4, Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new a(str, str2, str3, str4, th, 2));
    }

    public static void trackBootLifecycle(String str, String str2, String str3, String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new C1415tv(str, str2, str3, str4, obj));
    }

    private void trackParsed(JSONObject jSONObject) {
        try {
            if (!LogConstants.shouldPush) {
                bootLogs.clear();
                return;
            }
            truncateLog(jSONObject);
            signLog(jSONObject);
            if (Objects.equals(this.juspayServices.getWorkingLogger(), "json-array") || Objects.equals(this.juspayServices.getWorkingLogger(), "both")) {
                LogSessioniser.addLogLine(this.juspayServices.getSessionInfo().getSessionId(), jSONObject);
            }
            if (this.juspayServices.getLogSessioniserExp() != null) {
                this.juspayServices.getLogSessioniserExp().addLogLine(jSONObject);
            }
            processBootLogs();
        } catch (Exception e) {
            trackException(LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Exception while signing log line", e);
        }
    }

    private void trackPhoneState() {
        try {
            JSONObject jSONObject = new JSONObject();
            SessionInfo sessionInfo = this.juspayServices.getSessionInfo();
            ActivityManager.MemoryInfo memoryInfo = Utils.getMemoryInfo(this.juspayServices.getContext());
            if (memoryInfo != null) {
                jSONObject.put("available_memory", memoryInfo.availMem);
                jSONObject.put("threshold_memory", memoryInfo.threshold);
                jSONObject.put("total_memory", memoryInfo.totalMem);
            }
            jSONObject.put("network_info", sessionInfo.getNetworkInfo());
            jSONObject.put("network_type", String.valueOf(sessionInfo.getNetworkType()));
            jSONObject.put("ip_address", Utils.getIPAddress(this.juspayServices));
            trackContext(LogSubCategory.Context.DEVICE, "info", Labels.Device.PHONE_STATE, jSONObject);
        } catch (Exception unused) {
        }
    }

    private void truncateLog(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() > MAX_LOG_SIZE) {
                    jSONObject.put(next, str.substring(0, MAX_LOG_SIZE));
                }
            } else if (obj instanceof JSONObject) {
                truncateLog((JSONObject) obj);
            }
        }
    }

    public void addLogProperties(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = LogConstants.logProperties;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject2.getString(next);
                int indexOf = string.indexOf(36);
                int indexOf2 = string.indexOf(123);
                int lastIndexOf = string.lastIndexOf(125);
                if (!(indexOf == -1 || indexOf2 == -1 || lastIndexOf == -1 || indexOf2 - indexOf != 1 || indexOf2 >= lastIndexOf)) {
                    String substring = string.substring(indexOf2 + 1, lastIndexOf);
                    if (jSONObject.has(substring)) {
                        this.logProperties.put(next, string.replace("${" + substring + "}", jSONObject.optString(substring)));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void addLogToPersistedQueue(JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new A1(8, this, jSONObject));
    }

    public JSONObject getExceptionLog(String str, String str2, String str3, String str4, Throwable th) {
        JSONObject createExceptionLog = createExceptionLog(str, str2, str3, str4, th, true);
        try {
            signLog(createExceptionLog);
        } catch (Exception e) {
            JuspayLogger.e(LOG_TAG, "getExceptionLog failed", e);
        }
        return createExceptionLog;
    }

    public void resetSerialNumber() {
        this.serialNumberCounter = new AtomicInteger(1);
    }

    public void setEndPointSandbox(Boolean bool) {
        ExecutorManager.runOnLogSessioniserThread(new m(7, this, bool));
    }

    public void setLabelsToDrop(JSONObject jSONObject) {
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("labelsToDrop");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.labelsToDrop.add(jSONArray.getString(i));
            }
        } catch (Exception unused) {
        }
    }

    public void track(JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new m(6, this, jSONObject));
    }

    public void trackAction(String str, String str2, String str3, String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new C1335pv(this, str3, str, str2, str4, obj, 1));
    }

    public void trackAndLogApiException(String str, String str2, String str3, String str4, Long l, Long l2, Object obj, String str5, String str6, String str7, Throwable th, JSONArray jSONArray, JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new C1357qv(this, str, str7, th, str4, str2, str3, l, l2, obj, str5, str6, jSONArray, jSONObject));
    }

    public void trackAndLogException(String str, String str2, String str3, String str4, String str5, Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new C1521zv(this, str4, str, str5, th, str2, str3));
    }

    public void trackApiCalls(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5) {
        ExecutorManager.runOnSdkTrackerPool(new C1447vv(this, str3, str, str2, num, str4, l, l2, obj, obj2, str5));
    }

    public void trackContext(String str, String str2, String str3, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new C1504yv(this, str3, str, str2, obj, 1));
    }

    public void trackException(String str, String str2, String str3, String str4, Throwable th) {
        ExecutorManager.runOnSdkTrackerPool(new C1376rv(this, str3, str, str2, str4, th));
    }

    public void trackLifecycle(String str, String str2, String str3, String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new C1335pv(this, str3, str, str2, str4, obj, 0));
    }

    private static JSONObject createApiLog(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5, JSONArray jSONArray, JSONObject jSONObject) {
        JSONArray names;
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("url", str4);
            jSONObject3.put("status_code", num);
            jSONObject3.put("start_time", l);
            jSONObject3.put("end_time", l2);
            if (obj == null) {
                obj = JSONObject.NULL;
            }
            jSONObject3.put(PaymentConstants.PAYLOAD, obj);
            jSONObject3.put("response", obj2);
            jSONObject3.put(FirebaseAnalytics.Param.METHOD, str5);
            jSONObject2.put("category", LogCategory.API_CALL);
            jSONObject2.put("subcategory", str);
            jSONObject2.put(FirebaseAnalytics.Param.LEVEL, str2);
            jSONObject2.put(Constants.ScionAnalytics.PARAM_LABEL, str3);
            jSONObject2.put("channels", jSONArray);
            jSONObject2.put("value", jSONObject3);
            jSONObject2.put("at", System.currentTimeMillis());
            jSONObject2.put(PaymentConstants.SERVICE, PaymentConstants.Category.SDK);
            if (!(jSONObject == null || (names = jSONObject.names()) == null)) {
                for (int i = 0; i < names.length(); i++) {
                    String string = names.getString(i);
                    jSONObject2.put(string, jSONObject.getString(string));
                }
            }
        } catch (JSONException e) {
            JuspayLogger.e(LOG_TAG, "Error while adding boot log: ", e);
        }
        return jSONObject2;
    }

    private static JSONObject createExceptionLog(String str, String str2, String str3, String str4, Throwable th, boolean z) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("message", str4 + ". " + th.getLocalizedMessage());
            jSONObject2.put("stacktrace", z ? formatThrowable(th) : Log.getStackTraceString(th));
            jSONObject.put("category", str);
            jSONObject.put("subcategory", str2);
            jSONObject.put(FirebaseAnalytics.Param.LEVEL, "exception");
            jSONObject.put(Constants.ScionAnalytics.PARAM_LABEL, str3 + "_" + Utils.getLogLevelFromThrowable(th));
            jSONObject.put("value", jSONObject2);
            jSONObject.put(PaymentConstants.SERVICE, PaymentConstants.Category.SDK);
            jSONObject.put("at", System.currentTimeMillis());
        } catch (JSONException e) {
            JuspayLogger.e(LOG_TAG, "Error while adding log: ", e);
        }
        return jSONObject;
    }

    public void trackApiCalls(String str, String str2, String str3, Integer num, String str4, Long l, Long l2, Object obj, Object obj2, String str5, JSONArray jSONArray, JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new C1431uv(this, str, str2, str3, num, str4, l, l2, obj, obj2, str5, jSONArray, jSONObject));
    }

    public void trackContext(String str, String str2, String str3, String str4, Object obj) {
        ExecutorManager.runOnSdkTrackerPool(new C1397sv(this, str3, str, str2, str4, obj));
    }

    public void trackLifecycle(String str, String str2, String str3, JSONObject jSONObject) {
        ExecutorManager.runOnSdkTrackerPool(new C1504yv(this, str3, str, str2, jSONObject, 0));
    }
}
