package in.juspay.hypersdk.analytics;

import com.google.common.net.HttpHeaders;
import com.google.firebase.messaging.Constants;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogLevel;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.security.EncryptionHelper;
import in.juspay.hypersdk.security.JOSEUtils;
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.JuspayHttpsResponse;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogPusher {
    private static final String TAG = "LogPusher";
    /* access modifiers changed from: private */
    public static final Map<String, LogChannel> channels = new HashMap();
    private static JSONObject channelsFromSdkConfig = new JSONObject();
    private static int getLogsToPushErrorCounter = 0;
    private static boolean isSandboxEnv = false;
    private static JSONArray logChannelsConfig = new JSONArray();
    private static int logFlushTimerTaskErrorCounter = 0;
    /* access modifiers changed from: private */
    public static final AtomicInteger logPushIteration = new AtomicInteger(1);
    private static Timer logPushTimer = new Timer();
    private static TimerTask logPushTimerTask;
    private static int logPushTimerTaskErrorCounter = 0;
    private static final AtomicInteger logPusherNumCounter = new AtomicInteger(0);
    private static int setHeaderParametersErrorCounter = 0;
    private static boolean stopPushingLogs = false;

    public static class IterableJSONArray implements Iterable<JSONObject> {
        JSONArray original;

        public IterableJSONArray(JSONArray jSONArray) {
            this.original = jSONArray;
        }

        public Iterator<JSONObject> iterator() {
            return new Iterator<JSONObject>() {
                int curr = 0;

                public boolean hasNext() {
                    if (this.curr < IterableJSONArray.this.original.length()) {
                        return true;
                    }
                    return false;
                }

                public JSONObject next() {
                    try {
                        JSONArray jSONArray = IterableJSONArray.this.original;
                        int i = this.curr;
                        this.curr = i + 1;
                        return jSONArray.optJSONObject(i);
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        return null;
                    }
                }

                public void remove() {
                }
            };
        }
    }

    public static class LogPushTimerTask extends TimerTask {
        private static final String TAG = "LogPushTimerTask";
        private static boolean isExceptionTracked = false;

        private LogPushTimerTask() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0() {
            int access$300;
            if (LogConstants.shouldPush && LogUtils.isMinMemoryAvailable().booleanValue()) {
                int andIncrement = LogPusher.logPushIteration.getAndIncrement();
                for (Map.Entry entry : LogPusher.channels.entrySet()) {
                    LogChannel logChannel = (LogChannel) entry.getValue();
                    String str = (String) entry.getKey();
                    if (andIncrement % logChannel.getPriority() == 0) {
                        int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE + str);
                        int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE + str);
                        boolean z = true;
                        if (JuspayCoreLib.getApplicationContext() != null && (fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.maxFilesAllowed) {
                            while ((fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.numFilesToLeaveIfMaxFilesExceeded) {
                                File file = LogUtils.getFile(LogConstants.PERSISTENT_LOGS_FILE + str + fromSharedPreference + ".dat");
                                if (file != null) {
                                    try {
                                        file.delete();
                                    } catch (Exception unused) {
                                    }
                                }
                                fromSharedPreference++;
                            }
                            LogUtils.writeToSharedPreference(C0709Uj.i(LogConstants.PERSISTENT_LOGS_READING_FILE, str), String.valueOf(fromSharedPreference));
                        }
                        while (true) {
                            try {
                                if (logChannel.getLogsQueue().size() <= 0) {
                                    z = false;
                                    break;
                                }
                                JSONArray access$200 = LogPusher.getLogsToPush(logChannel);
                                if (access$200.length() > 0) {
                                    access$300 = LogPusher.pushLogsToServer(access$200, logChannel);
                                    if (access$300 == 200 || (logChannel.getRetryAttempts() != -1 && logChannel.getCurrentBatchRetryAttempts() >= logChannel.getRetryAttempts())) {
                                        logChannel.setCurrentBatchRetryAttempts(0);
                                        LogPusher.acknowledgeLogsPushed(access$200.length(), logChannel);
                                    }
                                }
                            } catch (Exception e) {
                                Exception exc = e;
                                if (!isExceptionTracked) {
                                    SdkTracker.trackAndLogBootException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Error while creating the payload to post", exc);
                                }
                                isExceptionTracked = true;
                            }
                        }
                        SdkTracker.trackBootAction(LogSubCategory.Action.SYSTEM, "error", Labels.System.LOG_PUSHER, "error_response", "" + access$300);
                        logChannel.setCurrentBatchRetryAttempts(logChannel.getCurrentBatchRetryAttempts() + 1);
                        if (z) {
                        }
                        int fromSharedPreference3 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE + str);
                        if (JuspayCoreLib.getApplicationContext() != null) {
                            for (int fromSharedPreference4 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE + str); fromSharedPreference4 <= fromSharedPreference3; fromSharedPreference4++) {
                                File cacheDir = JuspayCoreLib.getApplicationContext().getCacheDir();
                                new File(cacheDir, LogConstants.PERSISTENT_LOGS_FILE + str + fromSharedPreference4 + ".dat").delete();
                            }
                        }
                        LogUtils.writeToSharedPreference(C0709Uj.i(LogConstants.PERSISTENT_LOGS_READING_FILE, str), String.valueOf(0));
                        LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE + str, String.valueOf(0));
                    }
                }
            }
        }

        public void run() {
            ExecutorManager.runOnLogsPool(new b(0));
        }
    }

    static {
        ExecutorManager.runOnLogsPool(new d8(1));
    }

    /* access modifiers changed from: private */
    public static void acknowledgeLogsPushed(int i, LogChannel logChannel) {
        while (i > 0) {
            try {
                logChannel.pollLogsQueue();
                i--;
            } catch (Exception e) {
                logPushTimerTaskErrorCounter++;
                if (logPushTimerTaskErrorCounter <= 2) {
                    SdkTracker.trackAndLogBootException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Exception in removal of logs from persisted Queue file", e);
                    return;
                } else {
                    JuspayLogger.e(TAG, "Exception in removal of logs from persisted Queue file", e);
                    return;
                }
            }
        }
    }

    private static boolean addChannel(String str, int i, long j, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i2, String str4, String str5) {
        Map<String, LogChannel> map2 = channels;
        boolean containsKey = map2.containsKey(str);
        LogChannel makeChannel = makeChannel(str, i, j, str2, str3, jSONObject, jSONObject2, map, i2, str4, str5);
        map2.put(str, makeChannel);
        if (!containsKey) {
            String str6 = "";
            String anyFromSharedPreference = LogUtils.getAnyFromSharedPreference(LogConstants.LOG_CHANNEL_NAMES, str6);
            StringBuilder J = xx.J(anyFromSharedPreference);
            if (anyFromSharedPreference.length() != 0) {
                str6 = ",";
            }
            J.append(str6);
            J.append(str);
            LogUtils.writeToSharedPreference(LogConstants.LOG_CHANNEL_NAMES, J.toString());
        }
        LogUtils.writeToSharedPreference(C0709Uj.i("LOG_CHANNEL_INFO_", str), makeChannel.toString());
        return true;
    }

    public static boolean addChannelFromJS(String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        Map map;
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            int optInt = jSONObject3.optInt("retryAttempts", LogConstants.maxRetryPerBatch);
            long optLong = jSONObject3.optLong("batchCount", LogConstants.maxLogsPerPush);
            String optString = jSONObject3.optString("logsUrlKey", LogConstants.prodLogUrl);
            String optString2 = jSONObject3.optString("logsUrlKeySandbox", LogConstants.sandboxLogUrl);
            if (jSONObject3.has("publicKey")) {
                jSONObject = jSONObject3.getJSONObject("publicKey");
            } else {
                jSONObject = LogConstants.publicKey;
            }
            JSONObject jSONObject4 = jSONObject;
            if (jSONObject3.has("publicKeySandbox")) {
                jSONObject2 = jSONObject3.getJSONObject("publicKeySandbox");
            } else {
                jSONObject2 = LogConstants.publicKeySandbox;
            }
            JSONObject jSONObject5 = jSONObject2;
            if (jSONObject3.has("channelHeaders")) {
                map = LogUtils.toMap(jSONObject3.getJSONObject("channelHeaders"));
            } else {
                map = new HashMap();
            }
            return addChannel(str2, optInt, optLong, optString, optString2, jSONObject4, jSONObject5, map, jSONObject3.optInt("priority", LogConstants.defaultPriority), jSONObject3.optString(PaymentConstants.ENV, "all"), jSONObject3.optString("encryptionLevelKey", LogConstants.encryptionLevel));
        } catch (JSONException unused) {
            return false;
        }
    }

    public static void addLogLines(Iterable<JSONObject> iterable) {
        if (!stopPushingLogs) {
            ExecutorManager.runOnLogsPool(new C0140b6(iterable, 10));
        }
    }

    public static void addLogsFromSessioniser(Queue<JSONObject> queue) {
        ExecutorManager.runOnLogsPool(new C0140b6(queue, 11));
    }

    public static void addLogsToPersistedQueue(JSONObject jSONObject) {
        ExecutorManager.runOnLogsPool(new a(jSONObject, 0));
    }

    public static String[] getChannelNames() {
        return (String[]) channels.keySet().toArray(new String[0]);
    }

    private static LogChannel getChannelObject(String str) {
        Map<String, LogChannel> map = channels;
        if (!map.containsKey(str)) {
            str = LogConstants.DEFAULT_CHANNEL;
        }
        return map.get(str);
    }

    private static String getEndPoint(LogChannel logChannel) {
        if (isSandboxEnv) {
            return logChannel.getEndpointSBX();
        }
        return logChannel.getEndPointProd();
    }

    private static JSONArray getLogChannels(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2 = new JSONArray();
        if (jSONObject.has("channels")) {
            jSONArray2 = jSONObject.optJSONArray("channels");
        }
        if ((jSONArray2 == null || jSONArray2.length() == 0) && jSONObject.has("channel")) {
            if (jSONArray2 == null) {
                jSONArray2 = new JSONArray();
            }
            jSONArray2.put(jSONObject.optString("channel", LogConstants.DEFAULT_CHANNEL));
        }
        if (jSONArray2 != null && jSONArray2.length() != 0) {
            return jSONArray2;
        }
        if (LogConstants.defaultChannels != null) {
            jSONArray = new JSONArray(LogConstants.defaultChannels.toString());
        } else {
            jSONArray = new JSONArray();
        }
        JSONArray jSONArray3 = jSONArray;
        jSONArray3.put(LogConstants.DEFAULT_CHANNEL);
        return jSONArray3;
    }

    private static RSAPublicKey getLogEncryptionKey(LogChannel logChannel) {
        JSONObject jSONObject;
        if (isSandboxEnv) {
            jSONObject = logChannel.getKeySBX();
        } else {
            jSONObject = logChannel.getKeyProd();
        }
        try {
            return JOSEUtils.JWKtoRSAPublicKey(jSONObject);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getLogEncryptionLevel(LogChannel logChannel) {
        return logChannel.getEncryptionLevel();
    }

    /* access modifiers changed from: private */
    public static JSONArray getLogsToPush(LogChannel logChannel) {
        JSONArray jSONArray = new JSONArray();
        Iterator<byte[]> it = logChannel.getLogsQueue().iterator();
        while (true) {
            if ((logChannel.getBatchCount() == -1 || ((long) jSONArray.length()) < logChannel.getBatchCount()) && it.hasNext()) {
                try {
                    jSONArray.put(new JSONObject(new String(it.next())));
                } catch (JSONException e) {
                    JSONException jSONException = e;
                    it.remove();
                    int i = getLogsToPushErrorCounter + 1;
                    getLogsToPushErrorCounter = i;
                    if (i <= 2) {
                        SdkTracker.trackAndLogBootException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Bad JSON while reading the Persisted Queue for Logs", jSONException);
                    } else {
                        JuspayLogger.e(TAG, "Bad JSON while reading the Persisted Queue for Logs", jSONException);
                    }
                }
            }
        }
        return jSONArray;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0114 A[Catch:{ Exception -> 0x0124 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void lambda$addLogLines$5(java.lang.Iterable r28) {
        /*
            java.lang.String r1 = "PERSISTENT_LOGS_WRITING_FILE"
            java.lang.String r2 = ".dat"
            java.lang.String r3 = "juspay-logs-queue-"
            java.util.Iterator r6 = r28.iterator()     // Catch:{ Exception -> 0x0124 }
        L_0x000a:
            boolean r0 = r6.hasNext()     // Catch:{ Exception -> 0x0124 }
            if (r0 == 0) goto L_0x013d
            java.lang.Object r0 = r6.next()     // Catch:{ Exception -> 0x0124 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ Exception -> 0x0124 }
            boolean r7 = shouldDropLog(r0)     // Catch:{ Exception -> 0x0107 }
            if (r7 == 0) goto L_0x001d
            goto L_0x000a
        L_0x001d:
            org.json.JSONArray r7 = getLogChannels(r0)     // Catch:{ Exception -> 0x0107 }
            r9 = 0
        L_0x0022:
            int r10 = r7.length()     // Catch:{ Exception -> 0x0107 }
            if (r9 >= r10) goto L_0x000a
            java.lang.String r10 = r7.getString(r9)     // Catch:{ Exception -> 0x0107 }
            java.util.Map<java.lang.String, in.juspay.hypersdk.analytics.LogChannel> r11 = channels     // Catch:{ Exception -> 0x0107 }
            boolean r11 = r11.containsKey(r10)     // Catch:{ Exception -> 0x0107 }
            if (r11 != 0) goto L_0x0037
        L_0x0034:
            r11 = r6
            goto L_0x0102
        L_0x0037:
            in.juspay.hypersdk.analytics.LogChannel r11 = getChannelObject(r10)     // Catch:{ Exception -> 0x0107 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            r12.<init>()     // Catch:{ Exception -> 0x0107 }
            r12.append(r1)     // Catch:{ Exception -> 0x0107 }
            r12.append(r10)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x0107 }
            int r12 = in.juspay.hypersdk.analytics.LogUtils.getFromSharedPreference(r12)     // Catch:{ Exception -> 0x0107 }
            r13 = -1
            if (r12 != r13) goto L_0x0052
            r12 = 0
        L_0x0052:
            if (r11 == 0) goto L_0x0034
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            r13.<init>()     // Catch:{ Exception -> 0x0107 }
            r13.append(r0)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r14 = "LOG_DELIMITER"
            r13.append(r14)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0107 }
            java.nio.charset.Charset r14 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0107 }
            byte[] r13 = r13.getBytes(r14)     // Catch:{ Exception -> 0x0107 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0107 }
            r14.<init>()     // Catch:{ Exception -> 0x0107 }
            r14.append(r3)     // Catch:{ Exception -> 0x0107 }
            r14.append(r10)     // Catch:{ Exception -> 0x0107 }
            r14.append(r12)     // Catch:{ Exception -> 0x0107 }
            r14.append(r2)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r14 = r14.toString()     // Catch:{ Exception -> 0x0107 }
            long r14 = in.juspay.hypersdk.analytics.LogUtils.getFileLength(r14)     // Catch:{ Exception -> 0x0107 }
            java.lang.String r8 = r0.toString()     // Catch:{ Exception -> 0x0107 }
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x0107 }
            byte[] r4 = r8.getBytes(r4)     // Catch:{ Exception -> 0x0107 }
            r11.addToLogsQueue(r4)     // Catch:{ Exception -> 0x0107 }
            int r4 = r13.length     // Catch:{ Exception -> 0x0107 }
            r11 = r6
            long r5 = (long) r4
            long r14 = r14 + r5
            long r4 = in.juspay.hypersdk.analytics.LogConstants.maxLogFileSize     // Catch:{ Exception -> 0x0100 }
            int r4 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x00be
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
            r4.<init>()     // Catch:{ Exception -> 0x0100 }
            r4.append(r3)     // Catch:{ Exception -> 0x0100 }
            r4.append(r10)     // Catch:{ Exception -> 0x0100 }
            r4.append(r12)     // Catch:{ Exception -> 0x0100 }
            r4.append(r2)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0100 }
            java.io.File r4 = in.juspay.hypersdk.analytics.LogUtils.getFile(r4)     // Catch:{ Exception -> 0x0100 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0100 }
            r6 = 1
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0100 }
        L_0x00ba:
            r5.write(r13)     // Catch:{ Exception -> 0x0100 }
            goto L_0x00fc
        L_0x00be:
            int r4 = r13.length     // Catch:{ Exception -> 0x0100 }
            long r4 = (long) r4     // Catch:{ Exception -> 0x0100 }
            long r14 = in.juspay.hypersdk.analytics.LogConstants.maxLogLineSize     // Catch:{ Exception -> 0x0100 }
            int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r4 > 0) goto L_0x0102
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
            r4.<init>()     // Catch:{ Exception -> 0x0100 }
            r4.append(r1)     // Catch:{ Exception -> 0x0100 }
            r4.append(r10)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0100 }
            java.lang.String r5 = java.lang.String.valueOf(r12)     // Catch:{ Exception -> 0x0100 }
            in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r4, r5)     // Catch:{ Exception -> 0x0100 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0100 }
            r4.<init>()     // Catch:{ Exception -> 0x0100 }
            r4.append(r3)     // Catch:{ Exception -> 0x0100 }
            r4.append(r10)     // Catch:{ Exception -> 0x0100 }
            r4.append(r12)     // Catch:{ Exception -> 0x0100 }
            r4.append(r2)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0100 }
            java.io.File r4 = in.juspay.hypersdk.analytics.LogUtils.getFile(r4)     // Catch:{ Exception -> 0x0100 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0100 }
            r6 = 1
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x0100 }
            goto L_0x00ba
        L_0x00fc:
            r5.close()     // Catch:{ Exception -> 0x0100 }
            goto L_0x0102
        L_0x0100:
            r0 = move-exception
            goto L_0x0109
        L_0x0102:
            int r9 = r9 + 1
            r6 = r11
            goto L_0x0022
        L_0x0107:
            r0 = move-exception
            r11 = r6
        L_0x0109:
            r21 = r0
            int r0 = logFlushTimerTaskErrorCounter     // Catch:{ Exception -> 0x0124 }
            r4 = 1
            int r0 = r0 + r4
            logFlushTimerTaskErrorCounter = r0     // Catch:{ Exception -> 0x0124 }
            r4 = 2
            if (r0 > r4) goto L_0x0121
            java.lang.String r16 = "LogPusher"
            java.lang.String r17 = "action"
            java.lang.String r18 = "system"
            java.lang.String r19 = "log_pusher"
            java.lang.String r20 = "Exception while flushing the logs to persisted queue file"
            in.juspay.hypersdk.core.SdkTracker.trackAndLogBootException(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x0124 }
        L_0x0121:
            r6 = r11
            goto L_0x000a
        L_0x0124:
            r0 = move-exception
            r27 = r0
            int r0 = logFlushTimerTaskErrorCounter
            r1 = 1
            int r0 = r0 + r1
            logFlushTimerTaskErrorCounter = r0
            r1 = 2
            if (r0 > r1) goto L_0x013d
            java.lang.String r22 = "LogPusher"
            java.lang.String r23 = "action"
            java.lang.String r24 = "system"
            java.lang.String r25 = "log_pusher"
            java.lang.String r26 = "Exception while flushing the logs to persisted queue file"
            in.juspay.hypersdk.core.SdkTracker.trackAndLogBootException(r22, r23, r24, r25, r26, r27)
        L_0x013d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusher.lambda$addLogLines$5(java.lang.Iterable):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addLogsFromSessioniser$4(Queue queue) {
        try {
            if (LogConstants.shouldPush) {
                Iterator it = queue.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = (JSONObject) it.next();
                    if (!shouldDropLog(jSONObject)) {
                        JSONArray logChannels = getLogChannels(jSONObject);
                        for (int i = 0; i < logChannels.length(); i++) {
                            String string = logChannels.getString(i);
                            if (channels.containsKey(string)) {
                                LogChannel channelObject = getChannelObject(string);
                                byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
                                if (((long) bytes.length) <= LogConstants.maxLogLineSize) {
                                    channelObject.addToLogsQueue(bytes);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addLogsToPersistedQueue$3(JSONObject jSONObject) {
        if (LogConstants.shouldPush) {
            try {
                if (JuspayCoreLib.getApplicationContext() != null) {
                    File file = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), LogConstants.CRASH_LOGS_FILE);
                    byte[] bytes = (jSONObject.toString() + LogConstants.LOG_DELIMITER).getBytes(StandardCharsets.UTF_8);
                    if (((long) bytes.length) < LogConstants.maxLogLineSize) {
                        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                        fileOutputStream.write(bytes);
                        fileOutputStream.close();
                    }
                }
            } catch (Exception e) {
                JuspayLogger.e(TAG, "addLogsToPersistedQueue failed", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setHeaders$6(String str, JSONObject jSONObject) {
        LogChannel channelObject = getChannelObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                channelObject.getHeaders().put(next, jSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$setLogHeaderValues$7(String str, JSONObject jSONObject) {
        LogChannel channelObject = getChannelObject(str);
        JSONObject jSONObject2 = LogConstants.logHeaders;
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                String optString = jSONObject2.optString(next);
                int indexOf = optString.indexOf(36);
                int indexOf2 = optString.indexOf(123);
                int lastIndexOf = optString.lastIndexOf(125);
                if (!(indexOf == -1 || indexOf2 == -1 || lastIndexOf == -1 || indexOf2 - indexOf != 1 || indexOf2 >= lastIndexOf)) {
                    String substring = optString.substring(indexOf2 + 1, lastIndexOf);
                    String str2 = "${" + substring + "}";
                    if (jSONObject.has(substring)) {
                        optString = optString.replace(str2, jSONObject.optString(substring));
                    }
                }
                channelObject.getHeaders().put(next, optString);
            } catch (Exception unused) {
                int i = setHeaderParametersErrorCounter + 1;
                setHeaderParametersErrorCounter = i;
                if (i <= 2) {
                    SdkTracker.trackBootAction(LogSubCategory.LifeCycle.HYPER_SDK, LogLevel.WARNING, Labels.System.LOG_PUSHER, "sdk_config", "Unable log header properties in log headers");
                    return;
                }
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLogPusherTimer$1() {
        if (LogConstants.shouldPush) {
            try {
                if (logPusherNumCounter.getAndIncrement() == 0) {
                    stopPushingLogs = false;
                    LogSessioniser.startLogSessioniser();
                    logPushTimer = new Timer();
                    LogPushTimerTask logPushTimerTask2 = new LogPushTimerTask();
                    logPushTimerTask = logPushTimerTask2;
                    Timer timer = logPushTimer;
                    long j = (long) LogConstants.logPostInterval;
                    timer.scheduleAtFixedRate(logPushTimerTask2, j, j);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x015c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void lambda$static$0() {
        /*
            boolean r0 = in.juspay.hypersdk.analytics.LogConstants.shouldPush
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            org.json.JSONObject r0 = in.juspay.hypersdk.analytics.LogConstants.channels
            channelsFromSdkConfig = r0
            if (r0 == 0) goto L_0x002e
            java.util.Iterator r1 = r0.keys()
        L_0x000f:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x002e
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            org.json.JSONObject r2 = channelsFromSdkConfig     // Catch:{ JSONException -> 0x0029 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ JSONException -> 0x0029 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0029 }
            addChannelFromJS(r2, r0)     // Catch:{ JSONException -> 0x0029 }
            goto L_0x000f
        L_0x0029:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x000f
        L_0x002e:
            org.json.JSONArray r0 = in.juspay.hypersdk.analytics.LogConstants.logChannelsConfig
            logChannelsConfig = r0
            r1 = 0
            if (r0 == 0) goto L_0x0054
            r0 = r1
        L_0x0036:
            org.json.JSONArray r2 = logChannelsConfig     // Catch:{ JSONException -> 0x0054 }
            int r2 = r2.length()     // Catch:{ JSONException -> 0x0054 }
            if (r0 >= r2) goto L_0x0054
            org.json.JSONArray r2 = logChannelsConfig     // Catch:{ JSONException -> 0x0054 }
            org.json.JSONObject r2 = r2.getJSONObject(r0)     // Catch:{ JSONException -> 0x0054 }
            java.lang.String r3 = r2.toString()     // Catch:{ JSONException -> 0x0054 }
            java.lang.String r4 = "channel"
            java.lang.String r2 = r2.getString(r4)     // Catch:{ JSONException -> 0x0054 }
            addChannelFromJS(r3, r2)     // Catch:{ JSONException -> 0x0054 }
            int r0 = r0 + 1
            goto L_0x0036
        L_0x0054:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            long r2 = r0.getId()
            in.juspay.hyper.core.ExecutorManager.setLogsThreadId(r2)
            java.lang.String r0 = "LOG_CHANNEL_NAMES"
            java.lang.String r2 = ""
            java.lang.String r3 = in.juspay.hypersdk.analytics.LogUtils.getAnyFromSharedPreference(r0, r2)
            java.lang.String r4 = ","
            java.lang.String[] r3 = r3.split(r4)
            in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r0, r2)
            int r5 = in.juspay.hypersdk.analytics.LogConstants.maxRetryPerBatch
            long r6 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush
            java.lang.String r8 = in.juspay.hypersdk.analytics.LogConstants.prodLogUrl
            java.lang.String r9 = in.juspay.hypersdk.analytics.LogConstants.sandboxLogUrl
            org.json.JSONObject r10 = in.juspay.hypersdk.analytics.LogConstants.publicKey
            org.json.JSONObject r11 = in.juspay.hypersdk.analytics.LogConstants.publicKeySandbox
            java.util.HashMap r12 = new java.util.HashMap
            r12.<init>()
            int r13 = in.juspay.hypersdk.analytics.LogConstants.defaultPriority
            java.lang.String r15 = in.juspay.hypersdk.analytics.LogConstants.encryptionLevel
            java.lang.String r4 = "default"
            java.lang.String r14 = "all"
            addChannel(r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15)
            java.lang.String r0 = "default"
            in.juspay.hypersdk.analytics.LogChannel r0 = getChannelObject(r0)
            int r4 = r3.length
        L_0x0093:
            if (r1 >= r4) goto L_0x0169
            r15 = r3[r1]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "LOG_CHANNEL_INFO_"
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r5 = r5.toString()
            java.lang.String r5 = in.juspay.hypersdk.analytics.LogUtils.getAnyFromSharedPreference(r5, r2)
            java.util.Map<java.lang.String, in.juspay.hypersdk.analytics.LogChannel> r7 = channels
            boolean r7 = r7.containsKey(r15)
            if (r7 != 0) goto L_0x00c0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            r7.append(r15)
            java.lang.String r6 = r7.toString()
            in.juspay.hypersdk.analytics.LogUtils.removeFromSharedPreference(r6)
        L_0x00c0:
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0134
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0134 }
            r6.<init>(r5)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r5 = "retryAttempts"
            int r7 = in.juspay.hypersdk.analytics.LogConstants.maxRetryPerBatch     // Catch:{ JSONException -> 0x0134 }
            int r7 = r6.optInt(r5, r7)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r5 = "batchCount"
            long r8 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush     // Catch:{ JSONException -> 0x0134 }
            long r8 = r6.optLong(r5, r8)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r5 = "logsUrlKey"
            java.lang.String r10 = in.juspay.hypersdk.analytics.LogConstants.prodLogUrl     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r10 = r6.optString(r5, r10)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r5 = "logsUrlKeySandbox"
            java.lang.String r11 = in.juspay.hypersdk.analytics.LogConstants.sandboxLogUrl     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r11 = r6.optString(r5, r11)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r5 = "publicKey"
            org.json.JSONObject r12 = r6.getJSONObject(r5)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r5 = "publicKeySandbox"
            org.json.JSONObject r13 = r6.getJSONObject(r5)     // Catch:{ JSONException -> 0x0134 }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r14 = "headers"
            java.lang.String r14 = r6.getString(r14)     // Catch:{ JSONException -> 0x0134 }
            r5.<init>(r14)     // Catch:{ JSONException -> 0x0134 }
            java.util.Map r14 = in.juspay.hypersdk.analytics.LogUtils.toMap(r5)     // Catch:{ JSONException -> 0x0134 }
            java.lang.String r5 = "priority"
            r17 = r2
            int r2 = in.juspay.hypersdk.analytics.LogConstants.defaultPriority     // Catch:{ JSONException -> 0x0136 }
            int r2 = r6.optInt(r5, r2)     // Catch:{ JSONException -> 0x0136 }
            java.lang.String r5 = "environment"
            r18 = r3
            java.lang.String r3 = "all"
            java.lang.String r3 = r6.optString(r5, r3)     // Catch:{ JSONException -> 0x0138 }
            java.lang.String r5 = "encryptionLevelKey"
            r19 = r4
            java.lang.String r4 = in.juspay.hypersdk.analytics.LogConstants.encryptionLevel     // Catch:{ JSONException -> 0x013a }
            java.lang.String r16 = r6.optString(r5, r4)     // Catch:{ JSONException -> 0x013a }
            r5 = r15
            r6 = r7
            r7 = r8
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r2
            r2 = r15
            r15 = r3
            in.juspay.hypersdk.analytics.LogChannel r3 = makeChannel(r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ JSONException -> 0x013b }
            goto L_0x013c
        L_0x0134:
            r17 = r2
        L_0x0136:
            r18 = r3
        L_0x0138:
            r19 = r4
        L_0x013a:
            r2 = r15
        L_0x013b:
            r3 = 0
        L_0x013c:
            if (r3 != 0) goto L_0x015c
            int r6 = in.juspay.hypersdk.analytics.LogConstants.maxRetryPerBatch
            long r7 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush
            java.lang.String r9 = in.juspay.hypersdk.analytics.LogConstants.prodLogUrl
            java.lang.String r10 = in.juspay.hypersdk.analytics.LogConstants.sandboxLogUrl
            org.json.JSONObject r11 = r0.getKeyProd()
            org.json.JSONObject r12 = r0.getKeySBX()
            java.util.Map r13 = r0.getHeaders()
            java.lang.String r16 = in.juspay.hypersdk.analytics.LogConstants.encryptionLevel
            r14 = 1
            java.lang.String r15 = "all"
            r5 = r2
            in.juspay.hypersdk.analytics.LogChannel r3 = makeChannel(r5, r6, r7, r9, r10, r11, r12, r13, r14, r15, r16)
        L_0x015c:
            pushOldChannelLogs(r3)
            int r1 = r1 + 1
            r2 = r17
            r3 = r18
            r4 = r19
            goto L_0x0093
        L_0x0169:
            int r3 = in.juspay.hypersdk.analytics.LogConstants.maxRetryPerBatch
            long r4 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush
            java.lang.String r6 = in.juspay.hypersdk.analytics.LogConstants.prodLogUrl
            java.lang.String r7 = in.juspay.hypersdk.analytics.LogConstants.sandboxLogUrl
            org.json.JSONObject r8 = r0.getKeyProd()
            org.json.JSONObject r9 = r0.getKeySBX()
            java.util.Map r10 = r0.getHeaders()
            java.lang.String r13 = in.juspay.hypersdk.analytics.LogConstants.encryptionLevel
            java.lang.String r2 = ""
            r11 = 1
            java.lang.String r12 = "all"
            in.juspay.hypersdk.analytics.LogChannel r0 = makeChannel(r2, r3, r4, r6, r7, r8, r9, r10, r11, r12, r13)
            pushOldChannelLogs(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusher.lambda$static$0():void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopLogPusherOnTerminate$2() {
        if (LogConstants.shouldPush) {
            AtomicInteger atomicInteger = logPusherNumCounter;
            if (atomicInteger.decrementAndGet() <= 0) {
                atomicInteger.set(0);
                try {
                    LogSessioniser.stopLogSessioniserOnTerminate();
                    logPushTimer.cancel();
                    logPushTimer = new Timer();
                    LogPushTimerTask logPushTimerTask2 = new LogPushTimerTask();
                    logPushTimerTask = logPushTimerTask2;
                    logPushTimerTask2.run();
                    stopPushingLogs = true;
                } catch (Exception unused) {
                }
            }
        }
    }

    private static LogChannel makeChannel(String str, int i, long j, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i2, String str4, String str5) {
        return new LogChannel(i, j, str, str2, str3, jSONObject, jSONObject2, map, i2, str4, str5);
    }

    private static void pushAllFiles(int i, int i2, LogChannel logChannel) {
        while (i <= i2) {
            File file = LogUtils.getFile(LogConstants.PERSISTENT_LOGS_FILE + logChannel.getChannelName() + i + ".dat");
            if (file != null) {
                if (!file.exists() || !LogUtils.isFileEligibleToPush(file)) {
                    file.delete();
                } else {
                    pushFileContentToServer(file, logChannel);
                }
            }
            i++;
        }
        if (JuspayCoreLib.getApplicationContext() != null) {
            LogChannel channelObject = getChannelObject(LogConstants.DEFAULT_CHANNEL);
            File file2 = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), LogConstants.CRASH_LOGS_FILE);
            if (!file2.exists() || !LogUtils.isFileEligibleToPush(file2)) {
                file2.delete();
            } else {
                pushFileContentToServer(file2, channelObject);
            }
        }
    }

    private static void pushFileContentToServer(File file, LogChannel logChannel) {
        if (file != null) {
            Queue<JSONObject> logsFromFile = LogUtils.getLogsFromFile(file);
            try {
                JSONArray jSONArray = new JSONArray();
                boolean z = true;
                while (logsFromFile.size() > 0) {
                    while (true) {
                        if ((logChannel.getBatchCount() == -1 || ((long) jSONArray.length()) < logChannel.getBatchCount()) && logsFromFile.size() > 0) {
                            jSONArray.put(logsFromFile.poll());
                        }
                    }
                    if (pushLogsToServer(jSONArray, logChannel) != 200) {
                        z = false;
                    }
                    jSONArray = new JSONArray();
                }
                if (z) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public static int pushLogsToServer(JSONArray jSONArray, LogChannel logChannel) {
        JuspayHttpsResponse juspayHttpsResponse;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, jSONArray);
        byte[] bytes = jSONObject.toString().getBytes(StandardCharsets.UTF_8);
        String logEncryptionLevel = getLogEncryptionLevel(logChannel);
        RSAPublicKey logEncryptionKey = getLogEncryptionKey(logChannel);
        NetUtils netUtils = new NetUtils(10000, 10000);
        Map<String, String> headers = logChannel.getHeaders();
        headers.put("x-logscount", String.valueOf(jSONArray.length()));
        headers.put("channel", logChannel.getChannelName());
        if ("encryption".equals(logEncryptionLevel) && logEncryptionKey != null) {
            juspayHttpsResponse = new JuspayHttpsResponse(netUtils.doPost(new URL(getEndPoint(logChannel)), EncryptionHelper.gzipThenEncrypt(bytes, logEncryptionKey), "application/x-godel-gzip-pubkey-encrypted", headers, new JSONObject()));
        } else if ("gzip".equals(logEncryptionLevel)) {
            byte[] gzipContent = Utils.gzipContent(bytes);
            headers.put(HttpHeaders.CONTENT_ENCODING, "gzip");
            juspayHttpsResponse = new JuspayHttpsResponse(netUtils.doPost(new URL(getEndPoint(logChannel)), gzipContent, "application/gzip", headers, new JSONObject()));
        } else {
            juspayHttpsResponse = new JuspayHttpsResponse(netUtils.doPost(new URL(getEndPoint(logChannel)), bytes, "application/json", headers, new JSONObject()));
        }
        return juspayHttpsResponse.responseCode;
    }

    private static void pushOldChannelLogs(LogChannel logChannel) {
        int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE + logChannel.getChannelName());
        int i = 0;
        if (fromSharedPreference == -1) {
            LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_READING_FILE + logChannel.getChannelName(), String.valueOf(0));
            fromSharedPreference = 0;
        }
        int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE + logChannel.getChannelName());
        if (fromSharedPreference2 == -1) {
            LogUtils.writeToSharedPreference(LogConstants.PERSISTENT_LOGS_WRITING_FILE + logChannel.getChannelName(), String.valueOf(0));
        } else {
            i = fromSharedPreference2;
        }
        pushAllFiles(fromSharedPreference, i, logChannel);
    }

    public static void setEndPointSandbox(Boolean bool) {
        isSandboxEnv = bool.booleanValue();
    }

    public static void setHeaders(JSONObject jSONObject, String str) {
        ExecutorManager.runOnLogsPool(new C0428zq(10, str, jSONObject));
    }

    public static void setLogHeaderValues(JSONObject jSONObject, String str) {
        ExecutorManager.runOnLogsPool(new C1367ri(str, jSONObject));
    }

    private static boolean shouldDropLog(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("channel")) {
                return false;
            }
            return !channels.containsKey(jSONObject.getString("channel"));
        } catch (JSONException unused) {
            return false;
        }
    }

    public static void startLogPusherTimer() {
        ExecutorManager.runOnLogsPool(new d8(2));
    }

    public static void stopLogPusherOnTerminate() {
        ExecutorManager.runOnLogsPool(new b(2));
    }

    public static void addLogLines(JSONArray jSONArray) {
        if (!stopPushingLogs && LogConstants.shouldPush) {
            addLogLines((Iterable<JSONObject>) new IterableJSONArray(jSONArray));
        }
    }
}
