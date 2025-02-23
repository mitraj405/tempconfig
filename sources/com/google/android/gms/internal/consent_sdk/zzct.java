package com.google.android.gms.internal.consent_sdk;

import android.os.Build;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final class zzct {
    public static boolean zza(boolean z) {
        if (Build.VERSION.SDK_INT < 31) {
            return Build.DEVICE.startsWith("generic");
        }
        String str = Build.FINGERPRINT;
        if (str.contains("generic") || str.contains("emulator") || Build.HARDWARE.contains("ranchu")) {
            return true;
        }
        return false;
    }
}
