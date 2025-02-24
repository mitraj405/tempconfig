package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Process;
import android.os.UserManager;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public class zzgi {
    private static UserManager zza;
    private static volatile boolean zzb = (!zza());

    private zzgi() {
    }

    public static boolean zza() {
        return true;
    }

    public static boolean zzb(Context context) {
        if (!zza() || zzc(context)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        return r3;
     */
    @android.annotation.TargetApi(24)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(android.content.Context r3) {
        /*
            boolean r0 = zzb
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.measurement.zzgi> r0 = com.google.android.gms.internal.measurement.zzgi.class
            monitor-enter(r0)
            boolean r2 = zzb     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000f:
            boolean r3 = zzd(r3)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0017
            zzb = r3     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgi.zzc(android.content.Context):boolean");
    }

    @TargetApi(24)
    private static boolean zzd(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (zza == null) {
                zza = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = zza;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
                z = z2;
            } catch (NullPointerException unused) {
                zza = null;
                i++;
            }
        }
        if (z) {
            zza = null;
        }
        return z;
    }

    public static boolean zza(Context context) {
        return zza() && !zzc(context);
    }
}
