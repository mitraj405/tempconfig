package in.juspay.hypersdk.analytics;

import androidx.core.util.Pair;
import in.juspay.hyper.core.ExecutorManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogSessioniserExp {
    private final AtomicInteger batchNumber = new AtomicInteger(0);
    private ConcurrentHashMap<String, ArrayList<String>> currentFilesObj = new ConcurrentHashMap<>();
    private final ArrayList<String> filesObj = new ArrayList<>();
    private ConcurrentHashMap<String, FileOutputStream> fosMap = new ConcurrentHashMap<>();
    private LoggerState loggerState;
    private final ConcurrentHashMap<String, Pair<Integer, Integer>> logsCount = new ConcurrentHashMap<>();
    private TimerTask moveToPusher;
    private Timer moveToPusherTimer = new Timer();
    private final AtomicBoolean pushFileCreated = new AtomicBoolean(false);
    private String rawLogsrequestId = LogUtils.generateUUID().replace("-", "");
    private boolean tempFlipDone = false;

    public class LogSessioniserTimerTask extends TimerTask {
        private LogSessioniserTimerTask() {
        }

        public void run() {
            if (LogConstants.shouldPush && LogUtils.isMinMemoryAvailable().booleanValue()) {
                ExecutorManager.runOnLogSessioniserThread(new a(LogSessioniserExp.this, 2));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ee A[Catch:{ Exception -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00f7 A[Catch:{ Exception -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fa A[Catch:{ Exception -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x016a A[SYNTHETIC, Splitter:B:52:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a8 A[Catch:{ Exception -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01cb A[Catch:{ Exception -> 0x01fc }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01e8 A[Catch:{ Exception -> 0x01fc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addToLogs(java.lang.String r18, java.lang.String r19, org.json.JSONObject r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = in.juspay.hypersdk.analytics.LogConstants.fileFormat     // Catch:{ Exception -> 0x01fc }
            java.lang.String r5 = "ndJson"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r5 = ".ndjson"
            java.lang.String r6 = ".dat"
            if (r4 == 0) goto L_0x0018
            r4 = r5
            goto L_0x0019
        L_0x0018:
            r4 = r6
        L_0x0019:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.String>> r7 = r0.currentFilesObj     // Catch:{ Exception -> 0x01fc }
            boolean r7 = r7.containsKey(r1)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r8 = "%03d"
            r9 = 0
            r10 = 45
            r11 = 1
            java.lang.String r12 = "logs-"
            if (r7 == 0) goto L_0x00bd
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.String>> r7 = r0.currentFilesObj     // Catch:{ Exception -> 0x01fc }
            java.lang.Object r7 = r7.get(r1)     // Catch:{ Exception -> 0x01fc }
            java.util.ArrayList r7 = (java.util.ArrayList) r7     // Catch:{ Exception -> 0x01fc }
            if (r7 == 0) goto L_0x0091
            int r13 = r7.size()     // Catch:{ Exception -> 0x01fc }
            int r13 = r13 - r11
            java.lang.Object r7 = r7.get(r13)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r13 = r0.logsCount     // Catch:{ Exception -> 0x01fc }
            java.lang.Object r13 = r13.get(r7)     // Catch:{ Exception -> 0x01fc }
            if (r13 == 0) goto L_0x00e6
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r13 = r0.logsCount     // Catch:{ Exception -> 0x01fc }
            java.lang.Object r13 = r13.get(r7)     // Catch:{ Exception -> 0x01fc }
            androidx.core.util.Pair r13 = (androidx.core.util.Pair) r13     // Catch:{ Exception -> 0x01fc }
            if (r13 == 0) goto L_0x00e6
            F r13 = r13.a     // Catch:{ Exception -> 0x01fc }
            if (r13 == 0) goto L_0x00e6
            java.lang.Integer r13 = (java.lang.Integer) r13     // Catch:{ Exception -> 0x01fc }
            int r13 = r13.intValue()     // Catch:{ Exception -> 0x01fc }
            long r13 = (long) r13     // Catch:{ Exception -> 0x01fc }
            long r15 = in.juspay.hypersdk.analytics.LogConstants.maxLogsPerPush     // Catch:{ Exception -> 0x01fc }
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 < 0) goto L_0x00e6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fc }
            r7.<init>(r12)     // Catch:{ Exception -> 0x01fc }
            r7.append(r1)     // Catch:{ Exception -> 0x01fc }
            r7.append(r10)     // Catch:{ Exception -> 0x01fc }
            r7.append(r2)     // Catch:{ Exception -> 0x01fc }
            r7.append(r10)     // Catch:{ Exception -> 0x01fc }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ Exception -> 0x01fc }
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.atomic.AtomicInteger r12 = r0.batchNumber     // Catch:{ Exception -> 0x01fc }
            int r12 = r12.incrementAndGet()     // Catch:{ Exception -> 0x01fc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x01fc }
            r10[r9] = r12     // Catch:{ Exception -> 0x01fc }
            java.lang.String r2 = java.lang.String.format(r2, r8, r10)     // Catch:{ Exception -> 0x01fc }
            r7.append(r2)     // Catch:{ Exception -> 0x01fc }
        L_0x0089:
            r7.append(r4)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01fc }
            goto L_0x00e6
        L_0x0091:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fc }
            r7.<init>()     // Catch:{ Exception -> 0x01fc }
            r7.append(r12)     // Catch:{ Exception -> 0x01fc }
            r7.append(r1)     // Catch:{ Exception -> 0x01fc }
            r7.append(r10)     // Catch:{ Exception -> 0x01fc }
            r7.append(r2)     // Catch:{ Exception -> 0x01fc }
            r7.append(r10)     // Catch:{ Exception -> 0x01fc }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ Exception -> 0x01fc }
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.atomic.AtomicInteger r12 = r0.batchNumber     // Catch:{ Exception -> 0x01fc }
            int r12 = r12.incrementAndGet()     // Catch:{ Exception -> 0x01fc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x01fc }
            r10[r9] = r12     // Catch:{ Exception -> 0x01fc }
            java.lang.String r2 = java.lang.String.format(r2, r8, r10)     // Catch:{ Exception -> 0x01fc }
        L_0x00b9:
            r7.append(r2)     // Catch:{ Exception -> 0x01fc }
            goto L_0x0089
        L_0x00bd:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fc }
            r7.<init>()     // Catch:{ Exception -> 0x01fc }
            r7.append(r12)     // Catch:{ Exception -> 0x01fc }
            r7.append(r1)     // Catch:{ Exception -> 0x01fc }
            r7.append(r10)     // Catch:{ Exception -> 0x01fc }
            r7.append(r2)     // Catch:{ Exception -> 0x01fc }
            r7.append(r10)     // Catch:{ Exception -> 0x01fc }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ Exception -> 0x01fc }
            java.lang.Object[] r10 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.atomic.AtomicInteger r12 = r0.batchNumber     // Catch:{ Exception -> 0x01fc }
            int r12 = r12.incrementAndGet()     // Catch:{ Exception -> 0x01fc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x01fc }
            r10[r9] = r12     // Catch:{ Exception -> 0x01fc }
            java.lang.String r2 = java.lang.String.format(r2, r8, r10)     // Catch:{ Exception -> 0x01fc }
            goto L_0x00b9
        L_0x00e6:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.io.FileOutputStream> r2 = r0.fosMap     // Catch:{ Exception -> 0x01fc }
            boolean r2 = r2.containsKey(r7)     // Catch:{ Exception -> 0x01fc }
            if (r2 == 0) goto L_0x00f7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.io.FileOutputStream> r2 = r0.fosMap     // Catch:{ Exception -> 0x01fc }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ Exception -> 0x01fc }
            java.io.FileOutputStream r2 = (java.io.FileOutputStream) r2     // Catch:{ Exception -> 0x01fc }
            goto L_0x00f8
        L_0x00f7:
            r2 = 0
        L_0x00f8:
            if (r2 != 0) goto L_0x0160
            boolean r2 = r0.tempFlipDone     // Catch:{ Exception -> 0x01fc }
            if (r2 != 0) goto L_0x010c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fc }
            r2.<init>()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r4 = "temp/"
        L_0x0105:
            r2.append(r4)     // Catch:{ Exception -> 0x01fc }
            r2.append(r7)     // Catch:{ Exception -> 0x01fc }
            goto L_0x0114
        L_0x010c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fc }
            r2.<init>()     // Catch:{ Exception -> 0x01fc }
            java.lang.String r4 = "original/"
            goto L_0x0105
        L_0x0114:
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01fc }
            java.io.File r2 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r2)     // Catch:{ Exception -> 0x01fc }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x01fc }
            r4.<init>(r2, r11)     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.io.FileOutputStream> r2 = r0.fosMap     // Catch:{ Exception -> 0x01fc }
            r2.put(r7, r4)     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.String>> r2 = r0.currentFilesObj     // Catch:{ Exception -> 0x01fc }
            boolean r2 = r2.containsKey(r1)     // Catch:{ Exception -> 0x01fc }
            if (r2 == 0) goto L_0x013c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.String>> r2 = r0.currentFilesObj     // Catch:{ Exception -> 0x01fc }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ Exception -> 0x01fc }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ Exception -> 0x01fc }
            if (r1 == 0) goto L_0x0149
            r1.add(r7)     // Catch:{ Exception -> 0x01fc }
            goto L_0x0149
        L_0x013c:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x01fc }
            r2.<init>()     // Catch:{ Exception -> 0x01fc }
            r2.add(r7)     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.String>> r8 = r0.currentFilesObj     // Catch:{ Exception -> 0x01fc }
            r8.put(r1, r2)     // Catch:{ Exception -> 0x01fc }
        L_0x0149:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.pushFileCreated     // Catch:{ Exception -> 0x01fc }
            boolean r1 = r1.get()     // Catch:{ Exception -> 0x01fc }
            if (r1 == 0) goto L_0x015f
            boolean r1 = r0.tempFlipDone     // Catch:{ Exception -> 0x01fc }
            if (r1 != 0) goto L_0x015f
            b6 r1 = new b6     // Catch:{ Exception -> 0x01fc }
            r2 = 13
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x01fc }
            in.juspay.hyper.core.ExecutorManager.runOnBackgroundThread(r1)     // Catch:{ Exception -> 0x01fc }
        L_0x015f:
            r2 = r4
        L_0x0160:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r1 = r0.logsCount     // Catch:{ Exception -> 0x01fc }
            boolean r1 = r1.containsKey(r7)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r4 = "batch_number"
            if (r1 == 0) goto L_0x01a8
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r1 = r0.logsCount     // Catch:{ Exception -> 0x01fc }
            java.lang.Object r1 = r1.get(r7)     // Catch:{ Exception -> 0x01fc }
            androidx.core.util.Pair r1 = (androidx.core.util.Pair) r1     // Catch:{ Exception -> 0x01fc }
            if (r1 == 0) goto L_0x0184
            F r8 = r1.a     // Catch:{ Exception -> 0x01fc }
            if (r8 != 0) goto L_0x0179
            goto L_0x0180
        L_0x0179:
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x01fc }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x01fc }
            r9 = r8
        L_0x0180:
            S r1 = r1.b     // Catch:{ Exception -> 0x01fc }
            if (r1 != 0) goto L_0x0189
        L_0x0184:
            int r1 = in.juspay.hypersdk.analytics.LogPusherExp.getBatchNum(r7)     // Catch:{ Exception -> 0x01fc }
            goto L_0x018f
        L_0x0189:
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01fc }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01fc }
        L_0x018f:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r8 = r0.logsCount     // Catch:{ Exception -> 0x01fc }
            int r9 = r9 + r11
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x01fc }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01fc }
            androidx.core.util.Pair r10 = new androidx.core.util.Pair     // Catch:{ Exception -> 0x01fc }
            r10.<init>(r9, r1)     // Catch:{ Exception -> 0x01fc }
            r8.put(r7, r10)     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.atomic.AtomicInteger r1 = r0.batchNumber     // Catch:{ Exception -> 0x01fc }
            r3.put(r4, r1)     // Catch:{ Exception -> 0x01fc }
            goto L_0x01c1
        L_0x01a8:
            int r1 = in.juspay.hypersdk.analytics.LogPusherExp.getBatchNum(r7)     // Catch:{ Exception -> 0x01fc }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r8 = r0.logsCount     // Catch:{ Exception -> 0x01fc }
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x01fc }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01fc }
            androidx.core.util.Pair r11 = new androidx.core.util.Pair     // Catch:{ Exception -> 0x01fc }
            r11.<init>(r9, r10)     // Catch:{ Exception -> 0x01fc }
            r8.put(r7, r11)     // Catch:{ Exception -> 0x01fc }
            r3.put(r4, r1)     // Catch:{ Exception -> 0x01fc }
        L_0x01c1:
            java.lang.String r1 = r20.toString()     // Catch:{ Exception -> 0x01fc }
            boolean r3 = r7.contains(r5)     // Catch:{ Exception -> 0x01fc }
            if (r3 == 0) goto L_0x01dc
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01fc }
            r3.<init>()     // Catch:{ Exception -> 0x01fc }
            r3.append(r1)     // Catch:{ Exception -> 0x01fc }
            r1 = 10
            r3.append(r1)     // Catch:{ Exception -> 0x01fc }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x01fc }
        L_0x01dc:
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ Exception -> 0x01fc }
            byte[] r1 = r1.getBytes(r3)     // Catch:{ Exception -> 0x01fc }
            boolean r3 = r7.contains(r6)     // Catch:{ Exception -> 0x01fc }
            if (r3 == 0) goto L_0x01f9
            int r3 = r1.length     // Catch:{ Exception -> 0x01fc }
            r4 = 4
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)     // Catch:{ Exception -> 0x01fc }
            java.nio.ByteBuffer r3 = r4.putInt(r3)     // Catch:{ Exception -> 0x01fc }
            byte[] r3 = r3.array()     // Catch:{ Exception -> 0x01fc }
            r2.write(r3)     // Catch:{ Exception -> 0x01fc }
        L_0x01f9:
            r2.write(r1)     // Catch:{ Exception -> 0x01fc }
        L_0x01fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogSessioniserExp.addToLogs(java.lang.String, java.lang.String, org.json.JSONObject):void");
    }

    private void getAllTempFiles(JSONObject jSONObject) {
        Iterator<String> it = this.filesObj.iterator();
        while (it.hasNext()) {
            try {
                jSONObject.put(it.next(), "");
            } catch (Exception unused) {
            }
        }
        for (Map.Entry value : this.currentFilesObj.entrySet()) {
            try {
                Iterator it2 = ((ArrayList) value.getValue()).iterator();
                while (it2.hasNext()) {
                    jSONObject.put((String) it2.next(), "");
                }
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r0 != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0021, code lost:
        if (r0 != null) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getLogCount(java.lang.String r2) {
        /*
            r1 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r0 = r1.logsCount
            java.lang.Object r0 = r0.get(r2)
            if (r0 == 0) goto L_0x0024
            java.util.concurrent.ConcurrentHashMap<java.lang.String, androidx.core.util.Pair<java.lang.Integer, java.lang.Integer>> r0 = r1.logsCount
            java.lang.Object r0 = r0.get(r2)
            androidx.core.util.Pair r0 = (androidx.core.util.Pair) r0
            if (r0 == 0) goto L_0x001d
            F r0 = r0.a
            if (r0 == 0) goto L_0x001d
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r2 = r0.intValue()
            goto L_0x0030
        L_0x001d:
            java.io.File r0 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r2)
            if (r0 == 0) goto L_0x002f
            goto L_0x002a
        L_0x0024:
            java.io.File r0 = in.juspay.hypersdk.analytics.LogUtils.getFileExp(r2)
            if (r0 == 0) goto L_0x002f
        L_0x002a:
            int r2 = in.juspay.hypersdk.analytics.LogPusherExp.traverseTheFile(r2, r0)
            goto L_0x0030
        L_0x002f:
            r2 = 0
        L_0x0030:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.hypersdk.analytics.LogSessioniserExp.getLogCount(java.lang.String):int");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addLogLine$1(JSONObject jSONObject) {
        String str;
        if (LogConstants.shouldPush) {
            String optString = jSONObject.optString("channel", LogConstants.DEFAULT_CHANNEL);
            if (!LoggerState.BUFFERING.equals(this.loggerState) || !shouldAllowLog(jSONObject)) {
                addToLogs(optString, this.rawLogsrequestId, jSONObject);
                return;
            }
            if (LogConstants.fileFormat.equals("ndJson")) {
                str = ".ndjson";
            } else {
                str = ".dat";
            }
            StringBuilder K = xx.K("logs-", optString, "-");
            K.append(this.rawLogsrequestId);
            K.append(String.format(Locale.US, "-%03d", new Object[]{Integer.valueOf(this.batchNumber.incrementAndGet())}));
            K.append("-0001");
            K.append(str);
            String sb = K.toString();
            try {
                jSONObject.put("batch_number", this.batchNumber.get());
            } catch (Exception unused) {
            }
            File fileExp = LogUtils.getFileExp("original/" + sb);
            LogUtils.writeLogToFileExp(jSONObject, fileExp);
            File fileExp2 = LogUtils.getFileExp(sb);
            if (!(fileExp == null || fileExp2 == null)) {
                fileExp.renameTo(fileExp2);
            }
            LogPusherExp.addLogLines(optString, sb);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$pushToPusher$3(ConcurrentHashMap concurrentHashMap, boolean z) {
        StringBuilder sb;
        File fileExp;
        if (LoggerState.BUFFERING.equals(this.loggerState)) {
            for (Map.Entry value : concurrentHashMap.entrySet()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) value.getValue()).iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    int lastIndexOf = str.lastIndexOf(46);
                    String str2 = str.substring(0, lastIndexOf) + String.format(Locale.US, "-%04d", new Object[]{Integer.valueOf(getLogCount(str))}) + str.substring(lastIndexOf);
                    File fileExp2 = LogUtils.getFileExp("temp/".concat(str));
                    File fileExp3 = LogUtils.getFileExp("temp/" + str2);
                    if (fileExp2 != null && fileExp2.exists()) {
                        if (fileExp3 != null) {
                            fileExp2.renameTo(fileExp3);
                        }
                        arrayList.add(str2);
                    }
                }
                this.filesObj.addAll(arrayList);
            }
        }
        if (LoggerState.PUSHING.equals(this.loggerState)) {
            try {
                Iterator<String> it2 = this.filesObj.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    File fileExp4 = LogUtils.getFileExp("temp/" + next);
                    if (!(fileExp4 == null || !fileExp4.exists() || (fileExp = LogUtils.getFileExp(next)) == null)) {
                        fileExp4.renameTo(fileExp);
                    }
                }
            } catch (Exception unused) {
            }
            for (Map.Entry value2 : concurrentHashMap.entrySet()) {
                try {
                    Iterator it3 = ((ArrayList) value2.getValue()).iterator();
                    while (it3.hasNext()) {
                        String str3 = (String) it3.next();
                        if (z) {
                            sb = new StringBuilder();
                            sb.append("temp/");
                        } else {
                            sb = new StringBuilder();
                            sb.append("original/");
                        }
                        sb.append(str3);
                        File fileExp5 = LogUtils.getFileExp(sb.toString());
                        if (fileExp5 != null && fileExp5.exists()) {
                            int lastIndexOf2 = str3.lastIndexOf(46);
                            File fileExp6 = LogUtils.getFileExp(str3.substring(0, lastIndexOf2) + String.format(Locale.US, "-%04d", new Object[]{Integer.valueOf(getLogCount(str3))}) + str3.substring(lastIndexOf2));
                            if (fileExp6 != null) {
                                fileExp5.renameTo(fileExp6);
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startPushing$2() {
        LoggerState loggerState2 = LoggerState.PUSHING;
        if (!loggerState2.equals(this.loggerState)) {
            this.pushFileCreated.set(true);
            updatePushFile();
            synchronized (this.loggerState) {
                this.loggerState = loggerState2;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$stopLogSessioniserOnTerminate$0() {
        try {
            this.moveToPusher.cancel();
            this.moveToPusherTimer.cancel();
            if (LogConstants.shouldPush) {
                pushToPusher();
            }
            this.loggerState = LoggerState.TERMINATED;
        } catch (Exception unused) {
        }
        ExecutorManager.runOnLogPusherThread(new C1425ui(1));
    }

    /* access modifiers changed from: private */
    public void pushToPusher() {
        boolean z;
        this.rawLogsrequestId = LogUtils.generateUUID().replace("-", "");
        for (Map.Entry value : this.fosMap.entrySet()) {
            try {
                ((FileOutputStream) value.getValue()).close();
            } catch (Exception unused) {
            }
        }
        this.fosMap = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap = this.currentFilesObj;
        this.currentFilesObj = new ConcurrentHashMap<>();
        synchronized (this.loggerState) {
            if (!LoggerState.PUSHING.equals(this.loggerState) || this.tempFlipDone) {
                z = false;
            } else {
                z = true;
                this.tempFlipDone = true;
            }
            ExecutorManager.runOnBackgroundThread(new C1460wi(this, concurrentHashMap, z));
        }
    }

    private boolean shouldAllowLog(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        JSONArray jSONArray = LogConstants.allowWhileBuffering;
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (true) {
                        if (!keys.hasNext()) {
                            z = true;
                            break;
                        }
                        String next = keys.next();
                        if (jSONObject.has(next)) {
                            JSONArray jSONArray2 = jSONObject2.getJSONArray(next);
                            int i2 = 0;
                            while (true) {
                                if (i2 >= jSONArray2.length()) {
                                    break;
                                } else if (Objects.equals(jSONArray2.get(i2), jSONObject.get(next))) {
                                    z2 = true;
                                    continue;
                                    break;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        z2 = false;
                        continue;
                        if (!z2) {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        return true;
                    }
                } else {
                    continue;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void updatePushFile() {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        File fileExp = LogUtils.getFileExp("temp/push.json");
        if (fileExp != null) {
            JSONObject jSONObject = new JSONObject();
            if (fileExp.exists()) {
                try {
                    fileInputStream = new FileInputStream(fileExp);
                    byte[] bArr = new byte[((int) fileExp.length())];
                    fileInputStream.read(bArr);
                    JSONObject jSONObject2 = new JSONObject(new String(bArr));
                    try {
                        fileInputStream.close();
                    } catch (Exception unused) {
                    }
                    jSONObject = jSONObject2;
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
            getAllTempFiles(jSONObject);
            try {
                fileOutputStream = new FileOutputStream(fileExp);
                fileOutputStream.write(jSONObject.toString().getBytes(StandardCharsets.UTF_8));
                fileOutputStream.close();
                return;
            } catch (Exception unused3) {
                return;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            return;
        }
        throw th;
        throw th;
    }

    public void addLogLine(JSONObject jSONObject) {
        ExecutorManager.runOnLogSessioniserThread(new C0428zq(11, this, jSONObject));
    }

    public void startLogSessioniser() {
        if (!LoggerState.PUSHING.equals(this.loggerState)) {
            this.loggerState = LoggerState.BUFFERING;
            try {
                LogPusherExp.startLogPusher();
                File fileExp = LogUtils.getFileExp("temp/");
                if (fileExp != null) {
                    fileExp.mkdirs();
                }
                File fileExp2 = LogUtils.getFileExp("original/");
                if (fileExp2 != null) {
                    fileExp2.mkdirs();
                }
                this.moveToPusherTimer = new Timer();
                LogSessioniserTimerTask logSessioniserTimerTask = new LogSessioniserTimerTask();
                this.moveToPusher = logSessioniserTimerTask;
                this.moveToPusherTimer.scheduleAtFixedRate(logSessioniserTimerTask, 0, (long) LogConstants.logSessioniseInterval);
            } catch (Exception unused) {
            }
        }
    }

    public void startPushing() {
        ExecutorManager.runOnBackgroundThread(new C1442vi(this, 1));
    }

    public void stopLogSessioniserOnTerminate() {
        ExecutorManager.runOnLogSessioniserThread(new C1442vi(this, 0));
    }
}
