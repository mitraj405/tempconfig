package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzebq {
    private final zzbuv zza;

    public zzebq(zzbuv zzbuv) {
        this.zza = zzbuv;
    }

    public static void zza(Map map, JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("pii");
            if (optJSONObject != null) {
                if (!TextUtils.isEmpty(optJSONObject.optString("doritos", ""))) {
                    map.put("x-afma-drt-cookie", optJSONObject.optString("doritos", ""));
                }
                if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", ""))) {
                    map.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", ""));
                    return;
                }
                return;
            }
            zze.zza("DSID signal does not exist.");
        }
    }

    public final void zzb() {
        ListenableFuture zza2 = this.zza.zza();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgT)).booleanValue()) {
            zzbzr.zzb(zza2, "persistFlags");
        } else {
            zzbzr.zza(zza2, "persistFlags");
        }
    }
}
