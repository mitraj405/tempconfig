package in.juspay.hypersdk.analytics;

import in.juspay.hyper.core.ExecutorManager;
import in.juspay.hyper.core.JuspayCoreLib;
import in.juspay.hyper.core.JuspayLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogSessioniser {
    /* access modifiers changed from: private */
    public static final ArrayList<String> activeRequestIDs = new ArrayList<>();
    /* access modifiers changed from: private */
    public static JSONObject logs = new JSONObject();
    private static TimerTask moveToPusher;
    /* access modifiers changed from: private */
    public static Timer moveToPusherTimer = new Timer();
    /* access modifiers changed from: private */
    public static JSONObject rawLogs = new JSONObject();
    private static boolean stopPushingLogs = false;
    /* access modifiers changed from: private */
    public static int timerModulus = 0;
    /* access modifiers changed from: private */
    public static boolean timerStopped = false;

    public static class LogSessioniserTimerTask extends TimerTask {
        private LogSessioniserTimerTask() {
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0() {
            boolean z;
            if (LogConstants.shouldPush && LogUtils.isMinMemoryAvailable().booleanValue()) {
                int i = 0;
                if (LogSessioniser.timerModulus == 1) {
                    z = true;
                } else {
                    z = false;
                }
                LogSessioniser.deleteOldFileIfNecessary(LogConstants.LOGS_READING_FILE, LogConstants.LOGS_WRITING_FILE, LogConstants.LOGS_FILE, ".dat");
                LogSessioniser.deleteOldFileIfNecessary(LogConstants.TEMP_LOGS_READING_FILE, LogConstants.TEMP_LOGS_WRITING_FILE, LogConstants.TEMP_LOGS_FILE, ".dat");
                if (z) {
                    LogSessioniser.activeRequestIDs.clear();
                    boolean unused = LogSessioniser.pushLogsFromJsonToPusher(LogSessioniser.logs);
                    LogSessioniser.clearAllLogFiles(LogConstants.TEMP_LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE), LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE));
                    LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
                    LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
                }
                if (z) {
                    JSONObject unused2 = LogSessioniser.logs = LogSessioniser.rawLogs;
                    JSONObject unused3 = LogSessioniser.rawLogs = new JSONObject();
                } else {
                    LogSessioniser.clearAllLogFiles(LogConstants.LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE), LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE));
                    LogUtils.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
                    LogUtils.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
                    try {
                        LogSessioniser.pushJsonToFile(LogSessioniser.rawLogs, LogConstants.LOGS_FILE, ".dat", LogConstants.LOGS_WRITING_FILE, 0);
                    } catch (Exception unused4) {
                    }
                }
                if (z) {
                    int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE);
                    if (fromSharedPreference != -1) {
                        i = fromSharedPreference;
                    }
                    try {
                        LogSessioniser.pushJsonToFile(LogSessioniser.logs, LogConstants.TEMP_LOGS_FILE, ".dat", LogConstants.TEMP_LOGS_WRITING_FILE, i);
                    } catch (Exception unused5) {
                    }
                }
                if (LogSessioniser.logs.length() == 0 && LogSessioniser.rawLogs.length() == 0) {
                    LogSessioniser.moveToPusherTimer.cancel();
                    boolean unused6 = LogSessioniser.timerStopped = true;
                }
                LogSessioniser.access$004();
                LogSessioniser.access$044(5);
            }
        }

        public void run() {
            ExecutorManager.runOnLogsPool(new c(0));
        }
    }

    static {
        ExecutorManager.runOnLogsPool(new d8(5));
    }

    public static /* synthetic */ int access$004() {
        int i = timerModulus + 1;
        timerModulus = i;
        return i;
    }

    public static /* synthetic */ int access$044(int i) {
        int i2 = timerModulus % i;
        timerModulus = i2;
        return i2;
    }

    public static void addLogLine(String str, JSONObject jSONObject) {
        if (!stopPushingLogs && LogConstants.shouldPush) {
            ExecutorManager.runOnLogsPool(new C1367ri(jSONObject, str));
        }
    }

    /* access modifiers changed from: private */
    public static void clearAllLogFiles(String str, String str2, int i, int i2) {
        while (i <= i2) {
            try {
                File file = LogUtils.getFile(str + i + str2);
                if (file != null) {
                    file.delete();
                }
            } catch (Exception unused) {
            }
            i++;
        }
    }

    private static String constructErrorMessage(String str, String str2) {
        return C1058d.A("{\"requestId\":\"", str2, "\",\"error\":true,\"logs\":{},\"errorMessage\":\"", str, "\"}");
    }

    /* access modifiers changed from: private */
    public static void deleteOldFileIfNecessary(String str, String str2, String str3, String str4) {
        int fromSharedPreference = LogUtils.getFromSharedPreference(str);
        int fromSharedPreference2 = LogUtils.getFromSharedPreference(str2);
        if (JuspayCoreLib.getApplicationContext() != null && (fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.maxFilesAllowed) {
            while ((fromSharedPreference2 - fromSharedPreference) + 1 > LogConstants.numFilesToLeaveIfMaxFilesExceeded) {
                File file = LogUtils.getFile(str3 + fromSharedPreference + str4);
                if (file != null) {
                    try {
                        file.delete();
                    } catch (Exception unused) {
                    }
                }
                fromSharedPreference++;
            }
            LogUtils.writeToSharedPreference(str, String.valueOf(fromSharedPreference));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLogsFromSessionId(org.json.JSONObject r6) {
        /*
            java.lang.String r0 = "requestId"
            java.lang.String r1 = ""
            if (r6 == 0) goto L_0x005c
            java.lang.String r2 = r6.getString(r0)     // Catch:{ JSONException -> 0x0041 }
            java.lang.String r3 = "sessionId"
            java.lang.String r6 = r6.getString(r3)     // Catch:{ JSONException -> 0x003f }
            java.util.ArrayList<java.lang.String> r3 = activeRequestIDs     // Catch:{ JSONException -> 0x0043 }
            r3.add(r2)     // Catch:{ JSONException -> 0x0043 }
            org.json.JSONObject r3 = logs     // Catch:{ JSONException -> 0x0043 }
            org.json.JSONArray r3 = r3.optJSONArray(r6)     // Catch:{ JSONException -> 0x0043 }
            if (r3 == 0) goto L_0x0038
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0043 }
            r4.<init>()     // Catch:{ JSONException -> 0x0043 }
            org.json.JSONObject r0 = r4.put(r0, r2)     // Catch:{ JSONException -> 0x0043 }
            java.lang.String r4 = "error"
            r5 = 0
            org.json.JSONObject r0 = r0.put(r4, r5)     // Catch:{ JSONException -> 0x0043 }
            java.lang.String r4 = "logs"
            org.json.JSONObject r0 = r0.put(r4, r3)     // Catch:{ JSONException -> 0x0043 }
            java.lang.String r6 = r0.toString()     // Catch:{ JSONException -> 0x0043 }
            return r6
        L_0x0038:
            java.lang.String r6 = "No logs saved to file"
            java.lang.String r6 = constructErrorMessage(r6, r2)
            return r6
        L_0x003f:
            r6 = r1
            goto L_0x0043
        L_0x0041:
            r6 = r1
            r2 = r6
        L_0x0043:
            boolean r0 = r2.equals(r1)
            if (r0 == 0) goto L_0x004c
            java.lang.String r6 = "RequestId not sent"
            goto L_0x0057
        L_0x004c:
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0055
            java.lang.String r6 = "SessionId not sent"
            goto L_0x0057
        L_0x0055:
            java.lang.String r6 = "Request invalid"
        L_0x0057:
            java.lang.String r6 = constructErrorMessage(r6, r2)
            return r6
        L_0x005c:
            java.lang.String r6 = "Request Invalid"
            java.lang.String r6 = constructErrorMessage(r6, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogSessioniser.getLogsFromSessionId(org.json.JSONObject):java.lang.String");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$addLogLine$4(JSONObject jSONObject, String str) {
        try {
            if (((long) jSONObject.getJSONObject("value").toString().getBytes().length) > LogConstants.maxLogValueSize) {
                jSONObject.put("value", "Filtered");
                JuspayLogger.i("LogSessioniser", "Filtering the value of log as the size of value is greater than 32 KB");
            }
            startLogSessioniserOnLogCount();
            if (!rawLogs.has(str)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                rawLogs.put(str, jSONArray);
                return;
            }
            rawLogs.accumulate(str, jSONObject);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$sessioniseLogs$5(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("sessionId");
            String string2 = jSONObject.getString("requestId");
            JSONArray jSONArray = jSONObject.getJSONArray("logs");
            if (activeRequestIDs.contains(string2) && ((long) jSONArray.toString().getBytes().length) <= LogConstants.maxLogLineSize) {
                startLogSessioniserOnLogCount();
                logs.put(string, jSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLogSessioniser$1() {
        try {
            stopPushingLogs = false;
            moveToPusherTimer = new Timer();
            LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
            moveToPusher = logSessioniserTimerTask;
            moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0, (long) LogConstants.logSessioniseInterval);
            timerStopped = false;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$startLogSessioniserOnLogCount$2() {
        try {
            if (timerStopped) {
                moveToPusherTimer = new Timer();
                LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
                moveToPusher = logSessioniserTimerTask;
                moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0, (long) LogConstants.logSessioniseInterval);
                timerStopped = false;
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0() {
        if (LogConstants.shouldPush) {
            ExecutorManager.setLogsThreadId(Thread.currentThread().getId());
            int fromSharedPreference = LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE);
            int fromSharedPreference2 = LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE);
            if (fromSharedPreference == -1) {
                LogUtils.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
                fromSharedPreference = 0;
            }
            if (fromSharedPreference2 == -1) {
                LogUtils.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
                fromSharedPreference2 = 0;
            }
            int fromSharedPreference3 = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE);
            int fromSharedPreference4 = LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE);
            if (fromSharedPreference3 == -1) {
                LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
                fromSharedPreference3 = 0;
            }
            if (fromSharedPreference4 == -1) {
                LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
                fromSharedPreference4 = 0;
            }
            deleteOldFileIfNecessary(LogConstants.LOGS_READING_FILE, LogConstants.LOGS_WRITING_FILE, LogConstants.LOGS_FILE, ".dat");
            deleteOldFileIfNecessary(LogConstants.TEMP_LOGS_READING_FILE, LogConstants.TEMP_LOGS_WRITING_FILE, LogConstants.TEMP_LOGS_FILE, ".dat");
            while (fromSharedPreference4 <= fromSharedPreference3) {
                try {
                    String str = LogConstants.TEMP_LOGS_FILE + fromSharedPreference4 + ".dat";
                    if (JuspayCoreLib.getApplicationContext() != null) {
                        File file = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str);
                        if (file.length() <= LogConstants.maxLogFileSize && file.exists() && LogUtils.isFileEligibleToPush(file)) {
                            LogPusher.addLogsFromSessioniser(LogUtils.getLogsFromFile(file));
                        }
                        file.delete();
                    }
                } catch (Exception unused) {
                }
                fromSharedPreference4++;
            }
            LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
            LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
            while (fromSharedPreference2 <= fromSharedPreference) {
                try {
                    String str2 = LogConstants.LOGS_FILE + fromSharedPreference2 + ".dat";
                    if (JuspayCoreLib.getApplicationContext() != null) {
                        File file2 = new File(JuspayCoreLib.getApplicationContext().getCacheDir(), str2);
                        if (file2.length() <= LogConstants.maxLogFileSize && file2.exists() && LogUtils.isFileEligibleToPush(file2)) {
                            LogPusher.addLogsFromSessioniser(LogUtils.getLogsFromFile(file2));
                        }
                        file2.delete();
                    }
                } catch (Exception unused2) {
                }
                fromSharedPreference2++;
            }
            LogUtils.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
            LogUtils.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$stopLogSessioniserOnTerminate$3() {
        try {
            moveToPusherTimer.cancel();
            if (pushLogsFromJsonToPusher(logs)) {
                logs = new JSONObject();
                clearAllLogFiles(LogConstants.TEMP_LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_READING_FILE), LogUtils.getFromSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE));
                LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_READING_FILE, String.valueOf(0));
                LogUtils.writeToSharedPreference(LogConstants.TEMP_LOGS_WRITING_FILE, String.valueOf(0));
            }
            if (pushLogsFromJsonToPusher(rawLogs)) {
                rawLogs = new JSONObject();
                clearAllLogFiles(LogConstants.LOGS_FILE, ".dat", LogUtils.getFromSharedPreference(LogConstants.LOGS_READING_FILE), LogUtils.getFromSharedPreference(LogConstants.LOGS_WRITING_FILE));
                LogUtils.writeToSharedPreference(LogConstants.LOGS_READING_FILE, String.valueOf(0));
                LogUtils.writeToSharedPreference(LogConstants.LOGS_WRITING_FILE, String.valueOf(0));
            }
            timerStopped = true;
            stopPushingLogs = true;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static void pushJsonToFile(JSONObject jSONObject, String str, String str2, String str3, int i) {
        String str4 = str;
        String str5 = str2;
        Iterator<String> keys = jSONObject.keys();
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        int i2 = i;
        sb.append(i2);
        sb.append(str5);
        FileOutputStream fileOutputStream = new FileOutputStream(LogUtils.getFile(sb.toString()), true);
        while (keys.hasNext()) {
            JSONArray jSONArray = jSONObject.getJSONArray(keys.next());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                byte[] bytes = (jSONObject2.toString() + LogConstants.LOG_DELIMITER).getBytes(StandardCharsets.UTF_8);
                long length = (long) bytes.length;
                if (LogUtils.getFileLength(str4 + i2 + str5) + length <= LogConstants.maxLogFileSize) {
                    fileOutputStream.write(bytes);
                } else if (length <= LogConstants.maxLogLineSize) {
                    i2++;
                    LogUtils.writeToSharedPreference(str3, String.valueOf(i2));
                    FileOutputStream fileOutputStream2 = new FileOutputStream(LogUtils.getFile(str4 + i2 + str5), true);
                    fileOutputStream2.write(bytes);
                    fileOutputStream = fileOutputStream2;
                }
                String str6 = str3;
            }
            String str7 = str3;
        }
        fileOutputStream.close();
    }

    /* access modifiers changed from: private */
    public static boolean pushLogsFromJsonToPusher(JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                LogPusher.addLogLines(jSONObject.getJSONArray(keys.next()));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void sessioniseLogs(JSONObject jSONObject) {
        if (!stopPushingLogs && LogConstants.shouldPush) {
            ExecutorManager.runOnLogsPool(new C0140b6(jSONObject, 12));
        }
    }

    public static void startLogSessioniser() {
        ExecutorManager.runOnLogsPool(new C1425ui(0));
    }

    private static void startLogSessioniserOnLogCount() {
        ExecutorManager.runOnLogsPool(new d8(4));
    }

    public static void stopLogSessioniserOnTerminate() {
        ExecutorManager.runOnLogsPool(new b(3));
    }
}
