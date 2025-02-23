package com.google.android.gms.common.internal;

import android.content.Context;
import com.google.errorprone.annotations.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class zzah {
    private static final Object zza = new Object();
    @GuardedBy("lock")
    private static boolean zzb;
    private static String zzc;
    private static int zzd;

    public static int zza(Context context) {
        zzc(context);
        return zzd;
    }

    public static String zzb(Context context) {
        zzc(context);
        return zzc;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|17|18|19|20) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(android.content.Context r3) {
        /*
            java.lang.Object r0 = zza
            monitor-enter(r0)
            boolean r1 = zzb     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0009:
            r1 = 1
            zzb = r1     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r3.getPackageName()     // Catch:{ all -> 0x0032 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r3 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r3)     // Catch:{ all -> 0x0032 }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r1, r2)     // Catch:{ NameNotFoundException -> 0x0030 }
            android.os.Bundle r3 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0030 }
            if (r3 != 0) goto L_0x0020
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0020:
            java.lang.String r1 = "com.google.app.id"
            java.lang.String r1 = r3.getString(r1)     // Catch:{ NameNotFoundException -> 0x0030 }
            zzc = r1     // Catch:{ NameNotFoundException -> 0x0030 }
            java.lang.String r1 = "com.google.android.gms.version"
            int r3 = r3.getInt(r1)     // Catch:{ NameNotFoundException -> 0x0030 }
            zzd = r3     // Catch:{ NameNotFoundException -> 0x0030 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzah.zzc(android.content.Context):void");
    }
}
