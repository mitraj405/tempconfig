package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

class TopicsSyncTask implements Runnable {
    private static final Object TOPIC_SYNC_TASK_LOCK = new Object();
    private static Boolean hasAccessNetworkStatePermission;
    private static Boolean hasWakeLockPermission;
    /* access modifiers changed from: private */
    public final Context context;
    private final Metadata metadata;
    private final long nextDelaySeconds;
    private final PowerManager.WakeLock syncWakeLock;
    /* access modifiers changed from: private */
    public final TopicsSubscriber topicsSubscriber;

    public class ConnectivityChangeReceiver extends BroadcastReceiver {
        private TopicsSyncTask task;

        public ConnectivityChangeReceiver(TopicsSyncTask topicsSyncTask) {
            this.task = topicsSyncTask;
        }

        public synchronized void onReceive(Context context, Intent intent) {
            TopicsSyncTask topicsSyncTask = this.task;
            if (topicsSyncTask != null) {
                if (topicsSyncTask.isDeviceConnected()) {
                    boolean access$100 = TopicsSyncTask.isLoggable();
                    this.task.topicsSubscriber.scheduleSyncTaskWithDelaySeconds(this.task, 0);
                    context.unregisterReceiver(this);
                    this.task = null;
                }
            }
        }

        public void registerReceiver() {
            boolean unused = TopicsSyncTask.isLoggable();
            TopicsSyncTask.this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public TopicsSyncTask(TopicsSubscriber topicsSubscriber2, Context context2, Metadata metadata2, long j) {
        this.topicsSubscriber = topicsSubscriber2;
        this.context = context2;
        this.nextDelaySeconds = j;
        this.metadata = metadata2;
        this.syncWakeLock = ((PowerManager) context2.getSystemService("power")).newWakeLock(1, Constants.FCM_WAKE_LOCK);
    }

    private static String createPermissionMissingLog(String str) {
        return lf.j("Missing Permission: ", str, ". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
    }

    private static boolean hasAccessNetworkStatePermission(Context context2) {
        boolean z;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            Boolean bool = hasAccessNetworkStatePermission;
            if (bool == null) {
                z = hasPermission(context2, "android.permission.ACCESS_NETWORK_STATE", bool);
            } else {
                z = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            hasAccessNetworkStatePermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean hasPermission(Context context2, String str, Boolean bool) {
        boolean z;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context2.checkCallingOrSelfPermission(str) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z && Log.isLoggable(Constants.TAG, 3)) {
            createPermissionMissingLog(str);
        }
        return z;
    }

    private static boolean hasWakeLockPermission(Context context2) {
        boolean z;
        boolean booleanValue;
        synchronized (TOPIC_SYNC_TASK_LOCK) {
            Boolean bool = hasWakeLockPermission;
            if (bool == null) {
                z = hasPermission(context2, "android.permission.WAKE_LOCK", bool);
            } else {
                z = bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(z);
            hasWakeLockPermission = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public synchronized boolean isDeviceConnected() {
        NetworkInfo networkInfo;
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.context.getSystemService("connectivity");
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } else {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: private */
    public static boolean isLoggable() {
        if (!Log.isLoggable(Constants.TAG, 3)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"Wakelock"})
    public void run() {
        if (hasWakeLockPermission(this.context)) {
            this.syncWakeLock.acquire(Constants.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
        }
        try {
            this.topicsSubscriber.setSyncScheduledOrRunning(true);
            if (!this.metadata.isGmscorePresent()) {
                this.topicsSubscriber.setSyncScheduledOrRunning(false);
                if (hasWakeLockPermission(this.context)) {
                    try {
                        this.syncWakeLock.release();
                    } catch (RuntimeException unused) {
                    }
                }
            } else if (!hasAccessNetworkStatePermission(this.context) || isDeviceConnected()) {
                if (this.topicsSubscriber.syncTopics()) {
                    this.topicsSubscriber.setSyncScheduledOrRunning(false);
                } else {
                    this.topicsSubscriber.syncWithDelaySecondsInternal(this.nextDelaySeconds);
                }
                if (!hasWakeLockPermission(this.context)) {
                    return;
                }
                try {
                    this.syncWakeLock.release();
                } catch (RuntimeException unused2) {
                }
            } else {
                new ConnectivityChangeReceiver(this).registerReceiver();
                if (hasWakeLockPermission(this.context)) {
                    try {
                        this.syncWakeLock.release();
                    } catch (RuntimeException unused3) {
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
            this.topicsSubscriber.setSyncScheduledOrRunning(false);
            if (!hasWakeLockPermission(this.context)) {
            }
        } catch (Throwable th) {
            if (hasWakeLockPermission(this.context)) {
                try {
                    this.syncWakeLock.release();
                } catch (RuntimeException unused4) {
                }
            }
            throw th;
        }
    }
}
