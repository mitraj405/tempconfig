package com.google.android.gms.internal.cloudmessaging;

import android.os.Build;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.2.0 */
public final class zza {
    public static final int zza;

    static {
        int i;
        if (Build.VERSION.SDK_INT >= 31) {
            i = 33554432;
        } else {
            i = 0;
        }
        zza = i;
    }
}
