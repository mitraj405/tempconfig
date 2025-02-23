package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeji implements zzeev {
    private final Map zza = new HashMap();
    private final zzdqb zzb;

    public zzeji(zzdqb zzdqb) {
        this.zzb = zzdqb;
    }

    public final zzeew zza(String str, JSONObject jSONObject) throws zzffn {
        zzeew zzeew;
        synchronized (this) {
            zzeew = (zzeew) this.zza.get(str);
            if (zzeew == null) {
                zzeew = new zzeew(this.zzb.zzc(str, jSONObject), new zzegq(), str);
                this.zza.put(str, zzeew);
            }
        }
        return zzeew;
    }
}
