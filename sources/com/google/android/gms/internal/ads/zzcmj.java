package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcmj implements zzclz {
    private final zzdvi zza;

    public zzcmj(zzdvi zzdvi) {
        this.zza = zzdvi;
    }

    public final void zza(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zziq)).booleanValue()) {
                this.zza.zzn(jSONObject);
            }
        }
    }
}
