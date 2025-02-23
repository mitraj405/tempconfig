package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;

@KeepForSdk
public class ServiceStarter {
    static final String ACTION_MESSAGING_EVENT = "com.google.firebase.MESSAGING_EVENT";
    static final int ERROR_ILLEGAL_STATE_EXCEPTION = 402;
    static final int ERROR_ILLEGAL_STATE_EXCEPTION_FALLBACK_TO_BIND = 403;
    static final int ERROR_NOT_FOUND = 404;
    static final int ERROR_SECURITY_EXCEPTION = 401;
    @KeepForSdk
    public static final int ERROR_UNKNOWN = 500;
    private static final String EXTRA_WRAPPED_INTENT = "wrapped_intent";
    private static final String PERMISSIONS_MISSING_HINT = "this should normally be included by the manifest merger, but may needed to be manually added to your manifest";
    public static final int SUCCESS = -1;
    private static ServiceStarter instance;
    private String firebaseMessagingServiceClassName = null;
    private Boolean hasAccessNetworkStatePermission = null;
    private Boolean hasWakeLockPermission = null;
    private final Queue<Intent> messagingEvents = new ArrayDeque();

    private ServiceStarter() {
    }

    private int doStartService(Context context, Intent intent) {
        ComponentName componentName;
        String resolveServiceClassName = resolveServiceClassName(context, intent);
        if (resolveServiceClassName != null) {
            Log.isLoggable(Constants.TAG, 3);
            intent.setClassName(context.getPackageName(), resolveServiceClassName);
        }
        try {
            if (hasWakeLockPermission(context)) {
                componentName = WakeLockHolder.startWakefulService(context, intent);
            } else {
                componentName = context.startService(intent);
            }
            if (componentName == null) {
                return ERROR_NOT_FOUND;
            }
            return -1;
        } catch (SecurityException unused) {
            return ERROR_SECURITY_EXCEPTION;
        } catch (IllegalStateException e) {
            e.toString();
            return ERROR_ILLEGAL_STATE_EXCEPTION;
        }
    }

    public static synchronized ServiceStarter getInstance() {
        ServiceStarter serviceStarter;
        synchronized (ServiceStarter.class) {
            if (instance == null) {
                instance = new ServiceStarter();
            }
            serviceStarter = instance;
        }
        return serviceStarter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.String resolveServiceClassName(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.firebaseMessagingServiceClassName     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return r0
        L_0x0007:
            android.content.pm.PackageManager r0 = r4.getPackageManager()     // Catch:{ all -> 0x0055 }
            r1 = 0
            android.content.pm.ResolveInfo r5 = r0.resolveService(r5, r1)     // Catch:{ all -> 0x0055 }
            r0 = 0
            if (r5 == 0) goto L_0x0053
            android.content.pm.ServiceInfo r5 = r5.serviceInfo     // Catch:{ all -> 0x0055 }
            if (r5 != 0) goto L_0x0018
            goto L_0x0053
        L_0x0018:
            java.lang.String r1 = r4.getPackageName()     // Catch:{ all -> 0x0055 }
            java.lang.String r2 = r5.packageName     // Catch:{ all -> 0x0055 }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x0055 }
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r5.name     // Catch:{ all -> 0x0055 }
            if (r1 != 0) goto L_0x0029
            goto L_0x0051
        L_0x0029:
            java.lang.String r0 = "."
            boolean r0 = r1.startsWith(r0)     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0049
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
            r0.<init>()     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ all -> 0x0055 }
            r0.append(r4)     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r5.name     // Catch:{ all -> 0x0055 }
            r0.append(r4)     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0055 }
            r3.firebaseMessagingServiceClassName = r4     // Catch:{ all -> 0x0055 }
            goto L_0x004d
        L_0x0049:
            java.lang.String r4 = r5.name     // Catch:{ all -> 0x0055 }
            r3.firebaseMessagingServiceClassName = r4     // Catch:{ all -> 0x0055 }
        L_0x004d:
            java.lang.String r4 = r3.firebaseMessagingServiceClassName     // Catch:{ all -> 0x0055 }
            monitor-exit(r3)
            return r4
        L_0x0051:
            monitor-exit(r3)
            return r0
        L_0x0053:
            monitor-exit(r3)
            return r0
        L_0x0055:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.ServiceStarter.resolveServiceClassName(android.content.Context, android.content.Intent):java.lang.String");
    }

    public static void setForTesting(ServiceStarter serviceStarter) {
        instance = serviceStarter;
    }

    public Intent getMessagingEvent() {
        return this.messagingEvents.poll();
    }

    public boolean hasAccessNetworkStatePermission(Context context) {
        boolean z;
        if (this.hasAccessNetworkStatePermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                z = true;
            } else {
                z = false;
            }
            this.hasAccessNetworkStatePermission = Boolean.valueOf(z);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasAccessNetworkStatePermission.booleanValue();
    }

    public boolean hasWakeLockPermission(Context context) {
        boolean z;
        if (this.hasWakeLockPermission == null) {
            if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                z = true;
            } else {
                z = false;
            }
            this.hasWakeLockPermission = Boolean.valueOf(z);
        }
        if (!this.hasWakeLockPermission.booleanValue()) {
            Log.isLoggable(Constants.TAG, 3);
        }
        return this.hasWakeLockPermission.booleanValue();
    }

    public int startMessagingService(Context context, Intent intent) {
        Log.isLoggable(Constants.TAG, 3);
        this.messagingEvents.offer(intent);
        Intent intent2 = new Intent(ACTION_MESSAGING_EVENT);
        intent2.setPackage(context.getPackageName());
        return doStartService(context, intent2);
    }
}
