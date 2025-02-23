package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ConfigAutoFetch {
    private static final int MAXIMUM_FETCH_ATTEMPTS = 3;
    private static final String REALTIME_DISABLED_KEY = "featureDisabled";
    private static final String TEMPLATE_VERSION_KEY = "latestTemplateVersionNumber";
    private final ConfigCacheClient activatedCache;
    private final ConfigFetchHandler configFetchHandler;
    private final Set<ConfigUpdateListener> eventListeners;
    private final HttpURLConnection httpURLConnection;
    private final Random random = new Random();
    private final ConfigUpdateListener retryCallback;
    private final ScheduledExecutorService scheduledExecutorService;

    public ConfigAutoFetch(HttpURLConnection httpURLConnection2, ConfigFetchHandler configFetchHandler2, ConfigCacheClient configCacheClient, Set<ConfigUpdateListener> set, ConfigUpdateListener configUpdateListener, ScheduledExecutorService scheduledExecutorService2) {
        this.httpURLConnection = httpURLConnection2;
        this.configFetchHandler = configFetchHandler2;
        this.activatedCache = configCacheClient;
        this.eventListeners = set;
        this.retryCallback = configUpdateListener;
        this.scheduledExecutorService = scheduledExecutorService2;
    }

    private void autoFetch(final int i, final long j) {
        if (i == 0) {
            propagateErrors(new FirebaseRemoteConfigServerException("Unable to fetch the latest version of the template.", FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED));
            return;
        }
        this.scheduledExecutorService.schedule(new Runnable() {
            public void run() {
                ConfigAutoFetch.this.fetchLatestConfig(i, j);
            }
        }, (long) this.random.nextInt(4), TimeUnit.SECONDS);
    }

    private synchronized void executeAllListenerCallbacks(ConfigUpdate configUpdate) {
        for (ConfigUpdateListener onUpdate : this.eventListeners) {
            onUpdate.onUpdate(configUpdate);
        }
    }

    private static Boolean fetchResponseIsUpToDate(ConfigFetchHandler.FetchResponse fetchResponse, long j) {
        boolean z = false;
        if (fetchResponse.getFetchedConfigs() != null) {
            if (fetchResponse.getFetchedConfigs().getTemplateVersionNumber() >= j) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        if (fetchResponse.getStatus() == 1) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r5.has(REALTIME_DISABLED_KEY) == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r5.getBoolean(REALTIME_DISABLED_KEY) == false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r8.retryCallback.onError(new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException("The server is temporarily unavailable. Try again in a few minutes.", com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        if (isEventListenersEmpty() == false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (r5.has(TEMPLATE_VERSION_KEY) == false) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        r6 = r8.configFetchHandler.getTemplateVersionNumber();
        r4 = r5.getLong(TEMPLATE_VERSION_KEY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0069, code lost:
        if (r4 <= r6) goto L_0x0012;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006b, code lost:
        autoFetch(3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
        r5 = new org.json.JSONObject(r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleNotifications(java.io.InputStream r9) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = "latestTemplateVersionNumber"
            java.lang.String r1 = "featureDisabled"
            java.io.BufferedReader r2 = new java.io.BufferedReader
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            java.lang.String r4 = "utf-8"
            r3.<init>(r9, r4)
            r2.<init>(r3)
            java.lang.String r3 = ""
        L_0x0012:
            r4 = r3
        L_0x0013:
            java.lang.String r5 = r2.readLine()
            if (r5 == 0) goto L_0x0082
            java.lang.String r4 = defpackage.C1058d.z(r4, r5)
            java.lang.String r6 = "}"
            boolean r5 = r5.contains(r6)
            if (r5 == 0) goto L_0x0013
            java.lang.String r4 = r8.parseAndValidateConfigUpdateMessage(r4)
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0030
            goto L_0x0013
        L_0x0030:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0070 }
            r5.<init>(r4)     // Catch:{ JSONException -> 0x0070 }
            boolean r4 = r5.has(r1)     // Catch:{ JSONException -> 0x0070 }
            if (r4 == 0) goto L_0x0050
            boolean r4 = r5.getBoolean(r1)     // Catch:{ JSONException -> 0x0070 }
            if (r4 == 0) goto L_0x0050
            com.google.firebase.remoteconfig.ConfigUpdateListener r4 = r8.retryCallback     // Catch:{ JSONException -> 0x0070 }
            com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException     // Catch:{ JSONException -> 0x0070 }
            java.lang.String r6 = "The server is temporarily unavailable. Try again in a few minutes."
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r7 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE     // Catch:{ JSONException -> 0x0070 }
            r5.<init>((java.lang.String) r6, (com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code) r7)     // Catch:{ JSONException -> 0x0070 }
            r4.onError(r5)     // Catch:{ JSONException -> 0x0070 }
            goto L_0x0082
        L_0x0050:
            boolean r4 = r8.isEventListenersEmpty()     // Catch:{ JSONException -> 0x0070 }
            if (r4 == 0) goto L_0x0057
            goto L_0x0082
        L_0x0057:
            boolean r4 = r5.has(r0)     // Catch:{ JSONException -> 0x0070 }
            if (r4 == 0) goto L_0x0012
            com.google.firebase.remoteconfig.internal.ConfigFetchHandler r4 = r8.configFetchHandler     // Catch:{ JSONException -> 0x0070 }
            long r6 = r4.getTemplateVersionNumber()     // Catch:{ JSONException -> 0x0070 }
            long r4 = r5.getLong(r0)     // Catch:{ JSONException -> 0x0070 }
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0012
            r6 = 3
            r8.autoFetch(r6, r4)     // Catch:{ JSONException -> 0x0070 }
            goto L_0x0012
        L_0x0070:
            r4 = move-exception
            com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException r5 = new com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException
            java.lang.Throwable r4 = r4.getCause()
            com.google.firebase.remoteconfig.FirebaseRemoteConfigException$Code r6 = com.google.firebase.remoteconfig.FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID
            java.lang.String r7 = "Unable to parse config update message."
            r5.<init>(r7, r4, r6)
            r8.propagateErrors(r5)
            goto L_0x0012
        L_0x0082:
            r2.close()
            r9.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigAutoFetch.handleNotifications(java.io.InputStream):void");
    }

    private synchronized boolean isEventListenersEmpty() {
        return this.eventListeners.isEmpty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Task lambda$fetchLatestConfig$0(Task task, Task task2, long j, int i, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to auto-fetch config update.", (Throwable) task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Failed to get activated config for auto-fetch", (Throwable) task2.getException()));
        }
        ConfigFetchHandler.FetchResponse fetchResponse = (ConfigFetchHandler.FetchResponse) task.getResult();
        ConfigContainer configContainer = (ConfigContainer) task2.getResult();
        if (!fetchResponseIsUpToDate(fetchResponse, j).booleanValue()) {
            autoFetch(i, j);
            return Tasks.forResult(null);
        } else if (fetchResponse.getFetchedConfigs() == null) {
            return Tasks.forResult(null);
        } else {
            if (configContainer == null) {
                configContainer = ConfigContainer.newBuilder().build();
            }
            Set<String> changedParams = configContainer.getChangedParams(fetchResponse.getFetchedConfigs());
            if (changedParams.isEmpty()) {
                return Tasks.forResult(null);
            }
            executeAllListenerCallbacks(ConfigUpdate.create(changedParams));
            return Tasks.forResult(null);
        }
    }

    private String parseAndValidateConfigUpdateMessage(String str) {
        int indexOf = str.indexOf(123);
        int lastIndexOf = str.lastIndexOf(125);
        if (indexOf < 0 || lastIndexOf < 0 || indexOf >= lastIndexOf) {
            return "";
        }
        return str.substring(indexOf, lastIndexOf + 1);
    }

    private synchronized void propagateErrors(FirebaseRemoteConfigException firebaseRemoteConfigException) {
        for (ConfigUpdateListener onError : this.eventListeners) {
            onError.onError(firebaseRemoteConfigException);
        }
    }

    public synchronized Task<Void> fetchLatestConfig(int i, long j) {
        int i2;
        Task<ConfigFetchHandler.FetchResponse> fetchNowWithTypeAndAttemptNumber;
        Task<ConfigContainer> task;
        i2 = i - 1;
        fetchNowWithTypeAndAttemptNumber = this.configFetchHandler.fetchNowWithTypeAndAttemptNumber(ConfigFetchHandler.FetchType.REALTIME, 3 - i2);
        task = this.activatedCache.get();
        return Tasks.whenAllComplete((Task<?>[]) new Task[]{fetchNowWithTypeAndAttemptNumber, task}).continueWithTask(this.scheduledExecutorService, new C0417z6(this, fetchNowWithTypeAndAttemptNumber, task, j, i2));
    }

    public void listenForNotifications() {
        HttpURLConnection httpURLConnection2 = this.httpURLConnection;
        if (httpURLConnection2 != null) {
            try {
                InputStream inputStream = httpURLConnection2.getInputStream();
                handleNotifications(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.httpURLConnection.disconnect();
                throw th;
            }
            this.httpURLConnection.disconnect();
        }
    }
}
