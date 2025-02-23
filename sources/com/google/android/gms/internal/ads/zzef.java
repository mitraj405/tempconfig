package com.google.android.gms.internal.ads;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzef extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final zzei zza;

    public zzef(zzei zzei) {
        this.zza = zzei;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        boolean z;
        int a = telephonyDisplayInfo.getOverrideNetworkType();
        int i = 5;
        if (a == 3 || a == 4 || a == 5) {
            z = true;
        } else {
            z = false;
        }
        zzei zzei = this.zza;
        if (true == z) {
            i = 10;
        }
        zzei.zzc(zzei, i);
    }
}
