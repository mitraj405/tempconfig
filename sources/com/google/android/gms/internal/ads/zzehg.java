package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzehg implements zzeev {
    private final zzdqb zza;

    public zzehg(zzdqb zzdqb) {
        this.zza = zzdqb;
    }

    public final zzeew zza(String str, JSONObject jSONObject) throws zzffn {
        return new zzeew(this.zza.zzc(str, jSONObject), new zzegp(), str);
    }
}
