package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzffj {
    private final JSONObject zza;

    public zzffj(JSONObject jSONObject) {
        this.zza = jSONObject;
    }

    public final String zza() {
        if (zzc() - 1 != 1) {
            return "javascript";
        }
        return null;
    }

    public final boolean zzb() {
        zzbbn zzbbn = zzbbw.zzeD;
        return this.zza.optBoolean((String) zzba.zzc().zza(zzbbn), true);
    }

    public final int zzc() {
        int optInt = this.zza.optInt("media_type", -1);
        if (optInt == 0) {
            return 2;
        }
        if (optInt != 1) {
            return 3;
        }
        return 1;
    }
}
