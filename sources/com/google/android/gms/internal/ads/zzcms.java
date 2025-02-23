package com.google.android.gms.internal.ads;

import in.juspay.hypersdk.core.PaymentConstants;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcms implements zzclz {
    private final zzbxq zza;

    public zzcms(zzbxq zzbxq) {
        this.zza = zzbxq;
    }

    public final void zza(JSONObject jSONObject) {
        int i;
        long optLong = jSONObject.optLong(PaymentConstants.TIMESTAMP);
        if (jSONObject.optBoolean("npa_reset")) {
            i = -1;
        } else {
            i = jSONObject.optBoolean("npa");
        }
        this.zza.zzb(i, optLong);
    }
}
