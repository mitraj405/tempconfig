package in.juspay.hypersdk.analytics;

import androidx.core.util.Pair;
import com.google.common.net.HttpHeaders;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
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
import in.juspay.hypersdk.utils.Utils;
import in.juspay.hypersdk.utils.network.JuspayHttpsResponse;
import in.juspay.hypersdk.utils.network.NetUtils;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogPusherExp {
    private static final String TAG = "LogPusher";
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, LogChannelExp> channels = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer> fileCountMap = new ConcurrentHashMap<>();
    private static boolean isSandboxEnv = false;
    private static int logFlushTimerTaskErrorCounter = 0;
    private static Timer logPushTimer = new Timer();
    private static TimerTask logPushTimerTask;
    private static final AtomicInteger logPusherNumCounter = new AtomicInteger(0);
    private static int setHeaderParametersErrorCounter = 0;

    public static class LogPushTimerTask extends TimerTask {
        private static final String TAG = "LogPushTimerTask";
        private static boolean isExceptionTracked = false;

        private LogPushTimerTask() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0() {
            File fileExp;
            File fileExp2;
            if (LogConstants.shouldPush && LogUtils.isMinMemoryAvailable().booleanValue()) {
                for (Map.Entry value : LogPusherExp.channels.entrySet()) {
                    LogChannelExp logChannelExp = (LogChannelExp) value.getValue();
                    LogPusherExp.checkFolderLimit();
                    try {
                        ArrayList arrayList = new ArrayList();
                        Iterator<String> it = logChannelExp.getLogsQueueExp().iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (next.contains(".ndjson") && (fileExp2 = LogUtils.getFileExp(next)) != null && fileExp2.exists()) {
                                arrayList.add(fileExp2);
                            }
                        }
                        LogPusherExp.pushNdJsonFiles(arrayList, logChannelExp, true);
                        arrayList.clear();
                        Iterator<String> it2 = logChannelExp.getLogsQueueExp().iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            if (next2.contains(".dat") && (fileExp = LogUtils.getFileExp(next2)) != null && fileExp.exists()) {
                                arrayList.add(fileExp);
                            }
                        }
                        LogPusherExp.pushDatFiles(arrayList, logChannelExp, true);
                    } catch (Exception e) {
                        Exception exc = e;
                        if (!isExceptionTracked) {
                            SdkTracker.trackAndLogBootException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Error while creating the payload to post", exc);
                        }
                        isExceptionTracked = true;
                    }
                }
                for (Map.Entry entry : LogPusherExp.channels.entrySet()) {
                    LogPusherExp.pushChannelFiles((String) entry.getKey(), (LogChannelExp) entry.getValue());
                }
            }
        }

        public void run() {
            ExecutorManager.runOnLogPusherThread(new b(1));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0296 A[SYNTHETIC] */
    static {
        /*
            java.lang.String r1 = "fallBackPublicKeys"
            java.lang.String r2 = "fallBackUrls"
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            channels = r0
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r3 = 0
            r0.<init>(r3)
            logPusherNumCounter = r0
            logFlushTimerTaskErrorCounter = r3
            setHeaderParametersErrorCounter = r3
            isSandboxEnv = r3
            java.util.Timer r0 = new java.util.Timer
            r0.<init>()
            logPushTimer = r0
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>()
            fileCountMap = r0
            boolean r0 = in.juspay.hypersdk.analytics.LogConstants.shouldPush
            if (r0 == 0) goto L_0x02be
            java.lang.String r4 = "temp/"
            java.io.File r5 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r4)
            r6 = 0
            if (r5 == 0) goto L_0x0121
            boolean r0 = r5.exists()
            if (r0 == 0) goto L_0x0121
            java.io.File[] r8 = r5.listFiles()
            java.lang.String r0 = "temp/push.json"
            java.io.File r0 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r0)
            if (r0 == 0) goto L_0x0107
            boolean r9 = r0.exists()
            if (r9 == 0) goto L_0x0107
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00bd }
            r9.<init>(r0)     // Catch:{ Exception -> 0x00bd }
            long r10 = r0.length()     // Catch:{ all -> 0x00b1 }
            int r0 = (int) r10     // Catch:{ all -> 0x00b1 }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x00b1 }
            r9.read(r0)     // Catch:{ all -> 0x00b1 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x00b1 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x00b1 }
            r11.<init>(r0)     // Catch:{ all -> 0x00b1 }
            r10.<init>(r11)     // Catch:{ all -> 0x00b1 }
            java.util.Iterator r0 = r10.keys()     // Catch:{ all -> 0x00b1 }
        L_0x006a:
            boolean r10 = r0.hasNext()     // Catch:{ all -> 0x00b1 }
            if (r10 == 0) goto L_0x00ad
            java.lang.Object r10 = r0.next()     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00b1 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b1 }
            r11.<init>()     // Catch:{ all -> 0x00b1 }
            r11.append(r4)     // Catch:{ all -> 0x00b1 }
            r11.append(r10)     // Catch:{ all -> 0x00b1 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00b1 }
            java.io.File r11 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r11)     // Catch:{ all -> 0x00b1 }
            if (r11 == 0) goto L_0x006a
            boolean r12 = r11.exists()     // Catch:{ all -> 0x00b1 }
            if (r12 == 0) goto L_0x006a
            long r12 = r11.length()     // Catch:{ all -> 0x00b1 }
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x00a9
            boolean r12 = in.juspay.hypersdk.analytics.LogUtils.isFileEligibleToPush(r11)     // Catch:{ all -> 0x00b1 }
            if (r12 == 0) goto L_0x00a9
            java.io.File r10 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r10)     // Catch:{ all -> 0x00b1 }
            if (r10 == 0) goto L_0x006a
            r11.renameTo(r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x006a
        L_0x00a9:
            r11.delete()     // Catch:{ all -> 0x00b1 }
            goto L_0x006a
        L_0x00ad:
            r9.close()     // Catch:{ Exception -> 0x00bd }
            goto L_0x0107
        L_0x00b1:
            r0 = move-exception
            r10 = r0
            r9.close()     // Catch:{ all -> 0x00b7 }
            goto L_0x00bc
        L_0x00b7:
            r0 = move-exception
            r9 = r0
            r10.addSuppressed(r9)     // Catch:{ Exception -> 0x00bd }
        L_0x00bc:
            throw r10     // Catch:{ Exception -> 0x00bd }
        L_0x00bd:
            if (r8 == 0) goto L_0x0107
            int r0 = r8.length
            r9 = r3
        L_0x00c1:
            if (r9 >= r0) goto L_0x0107
            r10 = r8[r9]
            java.lang.String r10 = r10.getName()
            java.lang.String r11 = "push.json"
            boolean r11 = r11.equals(r10)
            if (r11 != 0) goto L_0x0104
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>(r4)
            r11.append(r10)
            java.lang.String r11 = r11.toString()
            java.io.File r11 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r11)
            if (r11 == 0) goto L_0x0104
            boolean r12 = r11.exists()
            if (r12 == 0) goto L_0x0104
            long r12 = r11.length()
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x0101
            boolean r12 = in.juspay.hypersdk.analytics.LogUtils.isFileEligibleToPush(r11)
            if (r12 == 0) goto L_0x0101
            java.io.File r10 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r10)
            if (r10 == 0) goto L_0x0104
            r11.renameTo(r10)
            goto L_0x0104
        L_0x0101:
            r11.delete()
        L_0x0104:
            int r9 = r9 + 1
            goto L_0x00c1
        L_0x0107:
            java.io.File[] r0 = r5.listFiles()
            if (r0 == 0) goto L_0x0121
            int r4 = r0.length
            r5 = r3
        L_0x010f:
            if (r5 >= r4) goto L_0x0121
            r8 = r0[r5]
            if (r8 == 0) goto L_0x011e
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x011e
            r8.delete()
        L_0x011e:
            int r5 = r5 + 1
            goto L_0x010f
        L_0x0121:
            java.lang.String r0 = "original/"
            java.io.File r0 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r0)
            if (r0 == 0) goto L_0x0169
            boolean r4 = r0.exists()
            if (r4 == 0) goto L_0x0169
            java.io.File[] r0 = r0.listFiles()
            if (r0 == 0) goto L_0x0169
            int r4 = r0.length
            r5 = r3
        L_0x0137:
            if (r5 >= r4) goto L_0x0169
            r8 = r0[r5]
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x0166
            boolean r9 = r8.isFile()
            if (r9 == 0) goto L_0x0166
            long r9 = r8.length()
            int r9 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x0163
            boolean r9 = in.juspay.hypersdk.analytics.LogUtils.isFileEligibleToPush(r8)
            if (r9 == 0) goto L_0x0163
            java.lang.String r9 = r8.getName()
            java.io.File r9 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r9)
            if (r9 == 0) goto L_0x0166
            r8.renameTo(r9)
            goto L_0x0166
        L_0x0163:
            r8.delete()
        L_0x0166:
            int r5 = r5 + 1
            goto L_0x0137
        L_0x0169:
            java.lang.String r0 = "LOG_CHANNEL_NAMES"
            java.lang.String r4 = ""
            java.lang.String r5 = in.juspay.hypersdk.analytics.LogUtils.getAnyFromSharedPreference(r0, r4)
            java.lang.String r6 = ","
            java.lang.String[] r5 = r5.split(r6)
            in.juspay.hypersdk.analytics.LogUtils.writeToSharedPreference(r0, r4)
            int r7 = in.juspay.hypersdk.analytics.LogConstants.maxRetryPerBatch
            long r8 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush
            java.lang.String r10 = in.juspay.hypersdk.analytics.LogConstants.prodLogUrl
            java.lang.String r11 = in.juspay.hypersdk.analytics.LogConstants.sandboxLogUrl
            org.json.JSONObject r12 = in.juspay.hypersdk.analytics.LogConstants.publicKey
            org.json.JSONObject r13 = in.juspay.hypersdk.analytics.LogConstants.publicKeySandbox
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            int r15 = in.juspay.hypersdk.analytics.LogConstants.defaultPriority
            java.lang.String r17 = in.juspay.hypersdk.analytics.LogConstants.encryptionLevel
            org.json.JSONArray r18 = in.juspay.hypersdk.analytics.LogConstants.fallBackUrl
            org.json.JSONArray r19 = in.juspay.hypersdk.analytics.LogConstants.fallBackPublicKeys
            java.lang.String r20 = in.juspay.hypersdk.analytics.LogConstants.errorUrl
            java.lang.String r6 = "default"
            java.lang.String r16 = "all"
            addChannel(r6, r7, r8, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            d8 r0 = new d8
            r4 = 3
            r0.<init>(r4)
            in.juspay.hyper.core.ExecutorManager.runOnLogPusherThread(r0)
            java.lang.String r0 = "default"
            in.juspay.hypersdk.analytics.LogChannelExp r4 = getChannelObject(r0)
            int r6 = r5.length
        L_0x01ac:
            if (r3 >= r6) goto L_0x02a9
            r15 = r5[r3]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "LOG_CHANNEL_INFO_"
            r7.<init>(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "{}"
            java.lang.String r7 = in.juspay.hypersdk.analytics.LogUtils.getAnyFromSharedPreference(r7, r8)
            int r8 = r7.length()
            if (r8 == 0) goto L_0x0267
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0267 }
            r8.<init>(r7)     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r7 = "retryAttempts"
            int r9 = in.juspay.hypersdk.analytics.LogConstants.maxRetryPerBatch     // Catch:{ JSONException -> 0x0267 }
            int r9 = r8.optInt(r7, r9)     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r7 = "batchCount"
            long r10 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush     // Catch:{ JSONException -> 0x0267 }
            long r10 = r8.optLong(r7, r10)     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r7 = "endPointProd"
            java.lang.String r12 = in.juspay.hypersdk.analytics.LogConstants.prodLogUrl     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r12 = r8.optString(r7, r12)     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r7 = "endpointSBX"
            java.lang.String r13 = in.juspay.hypersdk.analytics.LogConstants.sandboxLogUrl     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r13 = r8.optString(r7, r13)     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r7 = "keyProd"
            org.json.JSONObject r14 = r8.getJSONObject(r7)     // Catch:{ JSONException -> 0x0267 }
            java.lang.String r7 = "keySBX"
            org.json.JSONObject r16 = r8.getJSONObject(r7)     // Catch:{ JSONException -> 0x0267 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0267 }
            r22 = r5
            java.lang.String r5 = "headers"
            java.lang.String r5 = r8.getString(r5)     // Catch:{ JSONException -> 0x0264 }
            r7.<init>(r5)     // Catch:{ JSONException -> 0x0264 }
            java.util.Map r5 = in.juspay.hypersdk.analytics.LogUtils.toMap(r7)     // Catch:{ JSONException -> 0x0264 }
            java.lang.String r7 = "priority"
            r23 = r6
            int r6 = in.juspay.hypersdk.analytics.LogConstants.defaultPriority     // Catch:{ JSONException -> 0x0261 }
            int r6 = r8.optInt(r7, r6)     // Catch:{ JSONException -> 0x0261 }
            java.lang.String r7 = "environment"
            r24 = r0
            java.lang.String r0 = "all"
            java.lang.String r17 = r8.optString(r7, r0)     // Catch:{ JSONException -> 0x026d }
            java.lang.String r0 = "encryptionLevel"
            java.lang.String r7 = in.juspay.hypersdk.analytics.LogConstants.encryptionLevel     // Catch:{ JSONException -> 0x026d }
            java.lang.String r18 = r8.optString(r0, r7)     // Catch:{ JSONException -> 0x026d }
            org.json.JSONArray r0 = r8.optJSONArray(r2)     // Catch:{ JSONException -> 0x026d }
            if (r0 != 0) goto L_0x0233
            org.json.JSONArray r0 = in.juspay.hypersdk.analytics.LogConstants.fallBackUrl     // Catch:{ JSONException -> 0x026d }
        L_0x0230:
            r19 = r0
            goto L_0x0238
        L_0x0233:
            org.json.JSONArray r0 = r8.optJSONArray(r2)     // Catch:{ JSONException -> 0x026d }
            goto L_0x0230
        L_0x0238:
            org.json.JSONArray r0 = r8.optJSONArray(r1)     // Catch:{ JSONException -> 0x026d }
            if (r0 != 0) goto L_0x0243
            org.json.JSONArray r0 = in.juspay.hypersdk.analytics.LogConstants.fallBackPublicKeys     // Catch:{ JSONException -> 0x026d }
        L_0x0240:
            r20 = r0
            goto L_0x0248
        L_0x0243:
            org.json.JSONArray r0 = r8.optJSONArray(r1)     // Catch:{ JSONException -> 0x026d }
            goto L_0x0240
        L_0x0248:
            java.lang.String r0 = "errorUrl"
            java.lang.String r7 = in.juspay.hypersdk.analytics.LogConstants.errorUrl     // Catch:{ JSONException -> 0x026d }
            java.lang.String r21 = r8.optString(r0, r7)     // Catch:{ JSONException -> 0x026d }
            r7 = r15
            r8 = r9
            r9 = r10
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r16
            r0 = r15
            r15 = r5
            r16 = r6
            in.juspay.hypersdk.analytics.LogChannelExp r5 = makeChannel(r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ JSONException -> 0x026e }
            goto L_0x026f
        L_0x0261:
            r24 = r0
            goto L_0x026d
        L_0x0264:
            r24 = r0
            goto L_0x026b
        L_0x0267:
            r24 = r0
            r22 = r5
        L_0x026b:
            r23 = r6
        L_0x026d:
            r0 = r15
        L_0x026e:
            r5 = 0
        L_0x026f:
            if (r5 != 0) goto L_0x0296
            int r8 = in.juspay.hypersdk.analytics.LogConstants.maxRetryPerBatch
            long r9 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush
            java.lang.String r11 = in.juspay.hypersdk.analytics.LogConstants.prodLogUrl
            java.lang.String r12 = in.juspay.hypersdk.analytics.LogConstants.sandboxLogUrl
            org.json.JSONObject r13 = r4.getKeyProd()
            org.json.JSONObject r14 = r4.getKeySBX()
            java.util.Map r15 = r4.getHeaders()
            java.lang.String r18 = in.juspay.hypersdk.analytics.LogConstants.encryptionLevel
            org.json.JSONArray r19 = in.juspay.hypersdk.analytics.LogConstants.fallBackUrl
            org.json.JSONArray r20 = in.juspay.hypersdk.analytics.LogConstants.fallBackPublicKeys
            java.lang.String r21 = in.juspay.hypersdk.analytics.LogConstants.errorUrl
            r16 = 1
            java.lang.String r17 = "all"
            r7 = r0
            in.juspay.hypersdk.analytics.LogChannelExp r5 = makeChannel(r7, r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
        L_0x0296:
            PC r6 = new PC
            r7 = 4
            r6.<init>(r7, r0, r5)
            in.juspay.hyper.core.ExecutorManager.runOnLogPusherThread(r6)
            int r3 = r3 + 1
            r5 = r22
            r6 = r23
            r0 = r24
            goto L_0x01ac
        L_0x02a9:
            r24 = r0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, in.juspay.hypersdk.analytics.LogChannelExp> r0 = channels
            r1 = r24
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x02be
            in.juspay.hypersdk.analytics.c r0 = new in.juspay.hypersdk.analytics.c
            r1 = 1
            r0.<init>(r1)
            in.juspay.hyper.core.ExecutorManager.runOnLogPusherThread(r0)
        L_0x02be:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusherExp.<clinit>():void");
    }

    private static void acknowledgeLogsPushed(ArrayList<String> arrayList, LogChannelExp logChannelExp) {
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            logChannelExp.pollLogsQueue(it.next());
        }
    }

    private static boolean addChannel(String str, int i, long j, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i2, String str4, String str5, JSONArray jSONArray, JSONArray jSONArray2, String str6) {
        String str7 = str;
        ConcurrentHashMap<String, LogChannelExp> concurrentHashMap = channels;
        boolean containsKey = concurrentHashMap.containsKey(str);
        LogChannelExp makeChannel = makeChannel(str, i, j, str2, str3, jSONObject, jSONObject2, map, i2, str4, str5, jSONArray, jSONArray2, str6);
        concurrentHashMap.put(str, makeChannel);
        if (!containsKey) {
            String str8 = "";
            String anyFromSharedPreference = LogUtils.getAnyFromSharedPreference(LogConstants.LOG_CHANNEL_NAMES, str8);
            StringBuilder J = xx.J(anyFromSharedPreference);
            if (anyFromSharedPreference.length() != 0) {
                str8 = ",";
            }
            J.append(str8);
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
        JSONArray jSONArray;
        JSONArray jSONArray2;
        try {
            JSONObject jSONObject3 = new JSONObject(str);
            int optInt = jSONObject3.optInt("retryAttempts", LogConstants.maxRetryPerBatch);
            long optLong = jSONObject3.optLong("batchCount", LogConstants.maxLogsPerPush);
            String optString = jSONObject3.optString("endPointProd", LogConstants.prodLogUrl);
            String optString2 = jSONObject3.optString("endpointSBX", LogConstants.sandboxLogUrl);
            if (jSONObject3.has("keyProd")) {
                jSONObject = jSONObject3.getJSONObject("keyProd");
            } else {
                jSONObject = LogConstants.publicKey;
            }
            JSONObject jSONObject4 = jSONObject;
            if (jSONObject3.has("keySBX")) {
                jSONObject2 = jSONObject3.getJSONObject("keySBX");
            } else {
                jSONObject2 = LogConstants.publicKeySandbox;
            }
            JSONObject jSONObject5 = jSONObject2;
            if (jSONObject3.has("channelHeaders")) {
                map = LogUtils.toMap(jSONObject3.getJSONObject("channelHeaders"));
            } else {
                map = new HashMap();
            }
            Map map2 = map;
            int optInt2 = jSONObject3.optInt("priority", LogConstants.defaultPriority);
            String optString3 = jSONObject3.optString(PaymentConstants.ENV, "all");
            String optString4 = jSONObject3.optString("encryptionLevel", LogConstants.encryptionLevel);
            if (jSONObject3.has("fallBackUrls")) {
                jSONArray = jSONObject3.optJSONArray("fallBackUrls");
            } else {
                jSONArray = LogConstants.fallBackUrl;
            }
            JSONArray jSONArray3 = jSONArray;
            if (jSONObject3.has("fallBackPublicKeys")) {
                jSONArray2 = jSONObject3.optJSONArray("fallBackPublicKeys");
            } else {
                jSONArray2 = LogConstants.fallBackPublicKeys;
            }
            return addChannel(str2, optInt, optLong, optString, optString2, jSONObject4, jSONObject5, map2, optInt2, optString3, optString4, jSONArray3, jSONArray2, jSONObject3.optString("errorUrl", LogConstants.errorUrl));
        } catch (JSONException unused) {
            return false;
        }
    }

    public static void addLogLines(String str, String str2) {
        ExecutorManager.runOnLogPusherThread(new Ft(4, str, str2));
    }

    public static void addLogsToPersistedQueue(JSONObject jSONObject) {
        ExecutorManager.runOnLogSessioniserThread(new a(jSONObject, 1));
    }

    /* access modifiers changed from: private */
    public static void checkFolderLimit() {
        File[] listFiles;
        File fileExp = LogUtils.getFileExp("");
        if (fileExp != null && fileExp.exists() && (listFiles = fileExp.listFiles()) != null) {
            int i = 0;
            long j = 0;
            for (File file : listFiles) {
                if (file != null && file.exists() && file.isFile()) {
                    j = file.length() + j;
                }
            }
            if (j >= LogConstants.folderSizeLimit) {
                Arrays.sort(listFiles, new C1407ti());
                long j2 = (long) (((double) LogConstants.folderSizeLimit) * 0.8d);
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2 != null && file2.exists() && file2.isFile()) {
                        file2.delete();
                        j -= file2.length();
                    }
                    if (j > j2) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public static int getBatchNum(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        int i = lastIndexOf - 5;
        if (str.charAt(i) == '-') {
            str2 = str.substring(lastIndexOf - 8, i);
        } else {
            str2 = str.substring(lastIndexOf - 3, lastIndexOf);
        }
        return Integer.parseInt(str2);
    }

    private static JSONArray getBatchNumArray(ArrayList<String> arrayList) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.put(getBatchNum(it.next()));
        }
        return jSONArray;
    }

    public static String[] getChannelNames() {
        return (String[]) channels.keySet().toArray(new String[0]);
    }

    private static LogChannelExp getChannelObject(String str) {
        ConcurrentHashMap<String, LogChannelExp> concurrentHashMap = channels;
        if (!concurrentHashMap.containsKey(str)) {
            str = LogConstants.DEFAULT_CHANNEL;
        }
        return concurrentHashMap.get(str);
    }

    private static String getEndPoint(LogChannelExp logChannelExp) {
        if (isSandboxEnv) {
            return logChannelExp.getEndpointSBX();
        }
        return logChannelExp.getEndPointProd();
    }

    private static int getFileCount(String str, File file) {
        int i;
        Integer num;
        ConcurrentHashMap<String, Integer> concurrentHashMap = fileCountMap;
        if (concurrentHashMap.containsKey(str) && (num = concurrentHashMap.get(str)) != null) {
            return num.intValue();
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (str.charAt(lastIndexOf - 5) == '-') {
            i = Integer.parseInt(str.substring(lastIndexOf - 4, lastIndexOf));
        } else {
            i = traverseTheFile(str, file);
        }
        concurrentHashMap.put(str, Integer.valueOf(i));
        return i;
    }

    private static Pair<byte[], Integer> getFilesContent(ArrayList<String> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = arrayList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            File fileExp = LogUtils.getFileExp(next);
            if (fileExp != null && fileExp.exists() && fileExp.length() > 0) {
                byte[] logsFromFileExp = LogUtils.getLogsFromFileExp(fileExp);
                i += logsFromFileExp.length;
                arrayList2.add(logsFromFileExp);
                i2 += getFileCount(next, fileExp);
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(i);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            allocate.put((byte[]) it2.next());
        }
        return new Pair<>(allocate.array(), Integer.valueOf(i2));
    }

    private static JSONObject getFirstLog(String str) {
        JSONObject jSONObject = new JSONObject();
        if (str.contains(".ndjson")) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(LogUtils.getFileExp(str)));
                try {
                    JSONObject jSONObject2 = new JSONObject(bufferedReader.readLine());
                    bufferedReader.close();
                    return jSONObject2;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } catch (Exception unused) {
            }
        } else {
            if (str.contains(".dat")) {
                byte[] bArr = new byte[4];
                File fileExp = LogUtils.getFileExp(str);
                if (fileExp != null && fileExp.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(fileExp);
                    try {
                        fileInputStream.read(bArr);
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        allocate.put(bArr);
                        allocate.rewind();
                        int i = allocate.getInt();
                        if (i < 102400) {
                            byte[] bArr2 = new byte[i];
                            fileInputStream.read(bArr2);
                            JSONObject jSONObject3 = new JSONObject(new String(bArr2, StandardCharsets.UTF_8));
                            fileInputStream.close();
                            return jSONObject3;
                        }
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream.close();
                        throw th;
                    }
                }
            }
            return jSONObject;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.security.interfaces.RSAPublicKey getLogEncryptionKey(in.juspay.hypersdk.analytics.LogChannelExp r2, int r3) {
        /*
            org.json.JSONArray r0 = r2.getFallBackPublicKeys()
            int r0 = r0.length()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            if (r3 < 0) goto L_0x0018
            org.json.JSONArray r0 = r2.getFallBackPublicKeys()     // Catch:{ Exception -> 0x0018 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ Exception -> 0x0018 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r3 = r1
        L_0x0019:
            if (r3 != 0) goto L_0x0028
            boolean r3 = isSandboxEnv
            if (r3 == 0) goto L_0x0024
            org.json.JSONObject r3 = r2.getKeySBX()
            goto L_0x0028
        L_0x0024:
            org.json.JSONObject r3 = r2.getKeyProd()
        L_0x0028:
            java.security.interfaces.RSAPublicKey r2 = in.juspay.hypersdk.security.JOSEUtils.JWKtoRSAPublicKey(r3)     // Catch:{ Exception -> 0x002d }
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusherExp.getLogEncryptionKey(in.juspay.hypersdk.analytics.LogChannelExp, int):java.security.interfaces.RSAPublicKey");
    }

    private static String getLogEncryptionLevel(LogChannelExp logChannelExp) {
        return logChannelExp.getEncryptionLevel();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:4|5|6|(1:8)(1:9)|10|11|12|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void hitErrorUrl(java.lang.String r5, in.juspay.hypersdk.analytics.LogChannelExp r6, int r7) {
        /*
            java.lang.String r0 = "session_id"
            java.lang.String r1 = ""
            java.lang.String r2 = r6.getErrorUrl()     // Catch:{ Exception -> 0x0074 }
            boolean r2 = java.util.Objects.equals(r2, r1)     // Catch:{ Exception -> 0x0074 }
            if (r2 != 0) goto L_0x0074
            org.json.JSONObject r2 = getFirstLog(r5)     // Catch:{ Exception -> 0x0074 }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ Exception -> 0x0074 }
            r3.<init>()     // Catch:{ Exception -> 0x0074 }
            java.lang.String r1 = r2.optString(r0, r1)     // Catch:{ Exception -> 0x0058 }
            r3.put(r0, r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r0 = "start_with"
            java.lang.String r1 = "sn"
            r4 = 0
            int r1 = r2.optInt(r1, r4)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0058 }
            r3.put(r0, r1)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r0 = "total_count"
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r1 = fileCountMap     // Catch:{ Exception -> 0x0058 }
            boolean r2 = r1.containsKey(r5)     // Catch:{ Exception -> 0x0058 }
            if (r2 == 0) goto L_0x0041
            java.lang.Object r5 = r1.get(r5)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x0058 }
            goto L_0x0043
        L_0x0041:
            java.lang.String r5 = "unknown"
        L_0x0043:
            r3.put(r0, r5)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r5 = "channel_name"
            java.lang.String r0 = r6.getChannelName()     // Catch:{ Exception -> 0x0058 }
            r3.put(r5, r0)     // Catch:{ Exception -> 0x0058 }
            java.lang.String r5 = "response_code"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0058 }
            r3.put(r5, r7)     // Catch:{ Exception -> 0x0058 }
        L_0x0058:
            in.juspay.hypersdk.utils.network.NetUtils r5 = new in.juspay.hypersdk.utils.network.NetUtils     // Catch:{ Exception -> 0x0074 }
            r7 = 30000(0x7530, float:4.2039E-41)
            r5.<init>(r7, r7)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r6 = r6.getErrorUrl()     // Catch:{ Exception -> 0x0074 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ Exception -> 0x0074 }
            r7.<init>()     // Catch:{ Exception -> 0x0074 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0074 }
            r0.<init>()     // Catch:{ Exception -> 0x0074 }
            javax.net.ssl.HttpsURLConnection r5 = r5.doGet(r6, r7, r3, r0)     // Catch:{ Exception -> 0x0074 }
            r5.getResponseCode()     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusherExp.hitErrorUrl(java.lang.String, in.juspay.hypersdk.analytics.LogChannelExp, int):void");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addLogLines$3(String str, String str2) {
        if (LogConstants.shouldPush) {
            try {
                LogChannelExp channelObject = getChannelObject(str);
                if (channelObject == null) {
                    channelObject = getChannelObject(LogConstants.DEFAULT_CHANNEL);
                }
                File fileExp = LogUtils.getFileExp(str2);
                if (fileExp != null && fileExp.exists() && fileExp.length() > 0) {
                    channelObject.addToLogsQueue(str2);
                }
            } catch (Exception e) {
                Exception exc = e;
                int i = logFlushTimerTaskErrorCounter + 1;
                logFlushTimerTaskErrorCounter = i;
                if (i <= 2) {
                    SdkTracker.trackAndLogBootException(TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.LOG_PUSHER, "Exception while flushing the logs to persisted queue file", exc);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addLogsToPersistedQueue$2(JSONObject jSONObject) {
        if (LogConstants.shouldPush) {
            try {
                LogUtils.writeLogToFileExp(jSONObject, LogUtils.getFileExp(LogConstants.CRASH_LOGS_FILE));
            } catch (Exception e) {
                JuspayLogger.e(TAG, "addLogsToPersistedQueue failed", e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(String str, LogChannelExp logChannelExp) {
        pushChannelFiles(str, logChannelExp);
        LogUtils.removeFromSharedPreference("LOG_CHANNEL_INFO_" + str);
    }

    private static LogChannelExp makeChannel(String str, int i, long j, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, Map<String, String> map, int i2, String str4, String str5, JSONArray jSONArray, JSONArray jSONArray2, String str6) {
        return new LogChannelExp(i, j, str, str2, str3, jSONObject, jSONObject2, map, i2, str4, str5, jSONArray, jSONArray2, str6);
    }

    /* access modifiers changed from: private */
    public static void pushChannelFiles(String str, LogChannelExp logChannelExp) {
        try {
            File fileExp = LogUtils.getFileExp("");
            if (fileExp != null && fileExp.exists() && fileExp.isDirectory()) {
                File[] listFiles = fileExp.listFiles(new C1388si(str));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (file != null && file.exists() && file.isFile()) {
                            if (file.length() <= 0 || !LogUtils.isFileEligibleToPush(file)) {
                                file.delete();
                            } else if (file.getName().contains(".ndjson")) {
                                arrayList.add(file);
                            } else {
                                arrayList2.add(file);
                            }
                        }
                    }
                }
                pushNdJsonFiles(arrayList, logChannelExp, false);
                pushDatFiles(arrayList2, logChannelExp, false);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void pushCrashLogFile() {
        if (JuspayCoreLib.getApplicationContext() != null) {
            LogChannelExp channelObject = getChannelObject(LogConstants.DEFAULT_CHANNEL);
            File fileExp = LogUtils.getFileExp(LogConstants.CRASH_LOGS_FILE);
            if (fileExp != null && fileExp.exists()) {
                if (fileExp.length() <= 0 || !LogUtils.isFileEligibleToPush(fileExp)) {
                    fileExp.delete();
                } else {
                    pushFileContentToServer(fileExp, channelObject);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009a, code lost:
        if (r14 != false) goto L_0x009c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void pushDatFiles(java.util.ArrayList<java.io.File> r12, in.juspay.hypersdk.analytics.LogChannelExp r13, boolean r14) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b8 }
            r0.<init>()     // Catch:{ Exception -> 0x00b8 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x00b8 }
        L_0x0009:
            boolean r1 = r12.hasNext()     // Catch:{ Exception -> 0x00b8 }
            if (r1 == 0) goto L_0x00b5
            java.lang.Object r1 = r12.next()     // Catch:{ Exception -> 0x00b8 }
            java.io.File r1 = (java.io.File) r1     // Catch:{ Exception -> 0x00b8 }
            if (r1 == 0) goto L_0x00a8
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00b8 }
            if (r2 == 0) goto L_0x00a8
            long r2 = r1.length()     // Catch:{ Exception -> 0x00b8 }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x00a8
            java.lang.String r2 = r1.getName()     // Catch:{ Exception -> 0x00b8 }
            long r6 = r1.length()     // Catch:{ Exception -> 0x00b8 }
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a0
            byte[] r3 = in.juspay.hypersdk.analytics.LogUtils.getLogsFromFileExp(r1)     // Catch:{ Exception -> 0x00b8 }
            int r4 = getFileCount(r2, r1)     // Catch:{ Exception -> 0x00b8 }
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ Exception -> 0x00b8 }
            r5.<init>()     // Catch:{ Exception -> 0x00b8 }
            int r6 = getBatchNum(r2)     // Catch:{ Exception -> 0x00b8 }
            org.json.JSONArray r5 = r5.put(r6)     // Catch:{ Exception -> 0x00b8 }
            r6 = 0
            int r3 = pushLogsToServer(r3, r4, r5, r13, r6)     // Catch:{ Exception -> 0x00b8 }
            r4 = -1
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 == r5) goto L_0x007a
            int r7 = r13.getRetryAttempts()     // Catch:{ Exception -> 0x00b8 }
            if (r7 == r4) goto L_0x0062
            int r7 = r13.getCurrentBatchRetryAttempts()     // Catch:{ Exception -> 0x00b8 }
            int r8 = r13.getRetryAttempts()     // Catch:{ Exception -> 0x00b8 }
            if (r7 >= r8) goto L_0x007a
        L_0x0062:
            java.lang.String r7 = "system"
            java.lang.String r8 = "error"
            java.lang.String r9 = "log_pusher"
            java.lang.String r10 = "error_response"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x00b8 }
            in.juspay.hypersdk.core.SdkTracker.trackBootAction(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00b8 }
            int r7 = r13.getCurrentBatchRetryAttempts()     // Catch:{ Exception -> 0x00b8 }
            int r7 = r7 + 1
            r13.setCurrentBatchRetryAttempts(r7)     // Catch:{ Exception -> 0x00b8 }
        L_0x007a:
            int r7 = r13.getRetryAttempts()     // Catch:{ Exception -> 0x00b8 }
            if (r7 == r4) goto L_0x0095
            int r4 = r13.getCurrentBatchRetryAttempts()     // Catch:{ Exception -> 0x00b8 }
            int r7 = r13.getRetryAttempts()     // Catch:{ Exception -> 0x00b8 }
            if (r4 < r7) goto L_0x0095
            hitErrorUrl(r2, r13, r3)     // Catch:{ Exception -> 0x00b8 }
            r13.setCurrentBatchRetryAttempts(r6)     // Catch:{ Exception -> 0x00b8 }
            if (r14 == 0) goto L_0x0095
            r0.add(r2)     // Catch:{ Exception -> 0x00b8 }
        L_0x0095:
            if (r3 != r5) goto L_0x0009
            r13.setCurrentBatchRetryAttempts(r6)     // Catch:{ Exception -> 0x00b8 }
            if (r14 == 0) goto L_0x00a3
        L_0x009c:
            r0.add(r2)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00a3
        L_0x00a0:
            if (r14 == 0) goto L_0x00a3
            goto L_0x009c
        L_0x00a3:
            r1.delete()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x0009
        L_0x00a8:
            if (r1 == 0) goto L_0x0009
            if (r14 == 0) goto L_0x0009
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x00b8 }
            r0.add(r1)     // Catch:{ Exception -> 0x00b8 }
            goto L_0x0009
        L_0x00b5:
            acknowledgeLogsPushed(r0, r13)     // Catch:{ Exception -> 0x00b8 }
        L_0x00b8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogPusherExp.pushDatFiles(java.util.ArrayList, in.juspay.hypersdk.analytics.LogChannelExp, boolean):void");
    }

    private static void pushFileContentToServer(File file, LogChannelExp logChannelExp) {
        try {
            if (pushLogsToServer(LogUtils.getLogsFromFileExp(file), getFileCount(file.getName(), file), new JSONArray().put(1), logChannelExp, false) == 200) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    private static int pushLogsToServer(byte[] bArr, int i, JSONArray jSONArray, LogChannelExp logChannelExp, boolean z) {
        String str;
        JuspayHttpsResponse juspayHttpsResponse;
        int currentBatchRetryAttempts;
        String logEncryptionLevel = getLogEncryptionLevel(logChannelExp);
        RSAPublicKey logEncryptionKey = getLogEncryptionKey(logChannelExp, logChannelExp.getRetryAttempts() - 1);
        NetUtils netUtils = new NetUtils(10000, 10000);
        Map<String, String> headers = logChannelExp.getHeaders();
        headers.put("x-logscount", String.valueOf(i));
        headers.put("channel", logChannelExp.getChannelName());
        if (z) {
            str = "ndjson";
        } else {
            str = "byte-d-json";
        }
        headers.put("x-log-format", str);
        headers.put("x-batch-no", jSONArray.toString());
        String endPoint = getEndPoint(logChannelExp);
        JSONArray fallBackUrls = logChannelExp.getFallBackUrls();
        if (fallBackUrls.length() != 0 && (currentBatchRetryAttempts = logChannelExp.getCurrentBatchRetryAttempts()) > 0) {
            endPoint = fallBackUrls.getString((currentBatchRetryAttempts - 1) % fallBackUrls.length());
        }
        if ("encryption".equals(logEncryptionLevel) && logEncryptionKey != null) {
            juspayHttpsResponse = new JuspayHttpsResponse(netUtils.doPost(new URL(endPoint), EncryptionHelper.gzipThenEncryptExp(bArr, logEncryptionKey, headers), "application/x-godel-gzip-pubkey-encrypted", headers, new JSONObject()));
        } else if ("gzip".equals(logEncryptionLevel)) {
            byte[] gzipContent = Utils.gzipContent(bArr);
            headers.put(HttpHeaders.CONTENT_ENCODING, "gzip");
            juspayHttpsResponse = new JuspayHttpsResponse(netUtils.doPost(new URL(endPoint), gzipContent, "application/gzip", headers, new JSONObject()));
        } else {
            juspayHttpsResponse = new JuspayHttpsResponse(netUtils.doPost(new URL(endPoint), bArr, "application/json", headers, new JSONObject()));
        }
        return juspayHttpsResponse.responseCode;
    }

    public static void pushNdJsonFiles(ArrayList<File> arrayList, LogChannelExp logChannelExp, boolean z) {
        int i;
        try {
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i2 < arrayList.size()) {
                    long j = 0;
                    while (i2 < arrayList.size()) {
                        File file = arrayList.get(i2);
                        if (file != null && file.exists()) {
                            int fileCount = getFileCount(file.getName(), file);
                            if (j != 0 && ((long) fileCount) + j > logChannelExp.getBatchCount()) {
                                break;
                            }
                            j += (long) fileCount;
                        }
                        i2++;
                    }
                    if (j != 0) {
                        ArrayList arrayList3 = new ArrayList();
                        for (int i4 = i3; i4 < i2; i4++) {
                            arrayList3.add(arrayList.get(i4).getName());
                        }
                        Pair<byte[], Integer> filesContent = getFilesContent(arrayList3);
                        JSONArray batchNumArray = getBatchNumArray(arrayList3);
                        F f = filesContent.a;
                        if (f == null || ((byte[]) f).length <= 0) {
                            while (i3 < i2) {
                                if (z) {
                                    arrayList2.add(arrayList.get(i3).getName());
                                }
                                arrayList.get(i3).delete();
                                i3++;
                            }
                        } else {
                            byte[] bArr = (byte[]) f;
                            S s = filesContent.b;
                            if (s == null) {
                                i = 1;
                            } else {
                                i = ((Integer) s).intValue();
                            }
                            int pushLogsToServer = pushLogsToServer(bArr, i, batchNumArray, logChannelExp, true);
                            if (pushLogsToServer != 200 && (logChannelExp.getRetryAttempts() == -1 || logChannelExp.getCurrentBatchRetryAttempts() < logChannelExp.getRetryAttempts())) {
                                SdkTracker.trackBootAction(LogSubCategory.Action.SYSTEM, "error", Labels.System.LOG_PUSHER, "error_response", Integer.valueOf(pushLogsToServer));
                                logChannelExp.setCurrentBatchRetryAttempts(logChannelExp.getCurrentBatchRetryAttempts() + 1);
                            }
                            if (logChannelExp.getRetryAttempts() != -1 && logChannelExp.getCurrentBatchRetryAttempts() >= logChannelExp.getRetryAttempts()) {
                                for (int i5 = i3; i5 < i2; i5++) {
                                    String name = arrayList.get(i5).getName();
                                    hitErrorUrl(name, logChannelExp, pushLogsToServer);
                                    if (z) {
                                        arrayList2.add(name);
                                    }
                                }
                                logChannelExp.setCurrentBatchRetryAttempts(0);
                            }
                            if (pushLogsToServer == 200) {
                                logChannelExp.setCurrentBatchRetryAttempts(0);
                                while (i3 < i2) {
                                    if (z) {
                                        arrayList2.add(arrayList.get(i3).getName());
                                    }
                                    arrayList.get(i3).delete();
                                    i3++;
                                }
                            }
                        }
                    } else {
                        while (i3 < i2) {
                            if (z) {
                                arrayList2.add(arrayList.get(i3).getName());
                            }
                            arrayList.get(i3).delete();
                            i3++;
                        }
                    }
                } else {
                    acknowledgeLogsPushed(arrayList2, logChannelExp);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void setEndPointSandbox(Boolean bool) {
        isSandboxEnv = bool.booleanValue();
    }

    public static void setHeaders(JSONObject jSONObject, String str) {
        LogChannelExp channelObject = getChannelObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                channelObject.getHeaders().put(next, jSONObject.getString(next));
            } catch (JSONException unused) {
            }
        }
    }

    public static void setLogHeaderValues(JSONObject jSONObject, String str) {
        LogChannelExp channelObject = getChannelObject(str);
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

    public static void startLogPusher() {
        if (LogConstants.shouldPush) {
            try {
                if (logPusherNumCounter.getAndIncrement() == 0) {
                    logPushTimer = new Timer();
                    LogPushTimerTask logPushTimerTask2 = new LogPushTimerTask();
                    logPushTimerTask = logPushTimerTask2;
                    logPushTimer.scheduleAtFixedRate(logPushTimerTask2, 0, (long) LogConstants.logPostInterval);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void stopLogPusherOnTerminate() {
        if (LogConstants.shouldPush) {
            AtomicInteger atomicInteger = logPusherNumCounter;
            if (atomicInteger.decrementAndGet() <= 0) {
                atomicInteger.set(0);
                try {
                    logPushTimer.cancel();
                    logPushTimer = new Timer();
                    LogPushTimerTask logPushTimerTask2 = new LogPushTimerTask();
                    logPushTimerTask = logPushTimerTask2;
                    logPushTimerTask2.run();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static int traverseTheFile(String str, File file) {
        BufferedInputStream bufferedInputStream;
        int i = 0;
        if (str.contains(".dat")) {
            long length = file.length();
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                int i2 = 0;
                while (((long) i) < length) {
                    try {
                        byte[] bArr = new byte[4];
                        fileInputStream.read(bArr);
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        allocate.put(bArr);
                        allocate.rewind();
                        int i3 = allocate.getInt();
                        if (i3 > 102400) {
                            fileInputStream.close();
                            return i2;
                        }
                        long j = (long) i3;
                        if (fileInputStream.skip(j) < j) {
                            fileInputStream.close();
                            return i2;
                        }
                        i += i3 + 4;
                        i2++;
                    } catch (Exception unused) {
                        i = i2;
                        return i;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                }
                fileInputStream.close();
                return i2;
            } catch (Exception unused2) {
                return i;
            }
        } else if (!str.contains(".ndjson")) {
            return 1;
        } else {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(LogUtils.getFileExp(str)));
                byte[] bArr2 = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
                boolean z = false;
                int i4 = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    for (int i5 = 0; i5 < read; i5++) {
                        if (bArr2[i5] == 10) {
                            i4++;
                        }
                    }
                    if (bArr2[read - 1] != 10) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    i4++;
                }
                i = i4;
                bufferedInputStream.close();
            } catch (Exception unused3) {
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            return i;
        }
        throw th;
        throw th;
    }
}
