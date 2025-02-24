package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaus {
    /* access modifiers changed from: private */
    public NetworkCapabilities zza;

    public zzaus(ConnectivityManager connectivityManager) {
        if (connectivityManager != null) {
            try {
                connectivityManager.registerDefaultNetworkCallback(new zzaur(this));
            } catch (RuntimeException unused) {
                synchronized (zzaus.class) {
                    this.zza = null;
                }
            }
        }
    }

    public static zzaus zzc(Context context) {
        if (context != null) {
            return new zzaus((ConnectivityManager) context.getSystemService("connectivity"));
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza() {
        /*
            r3 = this;
            java.lang.Class<com.google.android.gms.internal.ads.zzaus> r0 = com.google.android.gms.internal.ads.zzaus.class
            monitor-enter(r0)
            android.net.NetworkCapabilities r1 = r3.zza     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002c
            r2 = 4
            boolean r1 = r1.hasTransport(r2)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x0012
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            r0 = 2
            return r0
        L_0x0012:
            android.net.NetworkCapabilities r1 = r3.zza     // Catch:{ all -> 0x0030 }
            r2 = 1
            boolean r1 = r1.hasTransport(r2)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            r0 = 1
            return r0
        L_0x001f:
            android.net.NetworkCapabilities r1 = r3.zza     // Catch:{ all -> 0x0030 }
            r2 = 0
            boolean r1 = r1.hasTransport(r2)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002c
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            r0 = 0
            return r0
        L_0x002c:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            r0 = -1
            return r0
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaus.zza():long");
    }

    public final NetworkCapabilities zzb() {
        return this.zza;
    }
}
