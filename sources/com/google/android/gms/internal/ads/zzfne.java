package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfne {
    private static UiModeManager zza;

    public static zzflw zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzflw.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType == 1) {
            return zzflw.MOBILE;
        }
        if (currentModeType != 4) {
            return zzflw.OTHER;
        }
        return zzflw.CTV;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
