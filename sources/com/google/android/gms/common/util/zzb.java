package com.google.android.gms.common.util;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class zzb {
    public static boolean zza() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }
}
