package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzclw {
    private final Map zza;
    private final Map zzb;

    public zzclw(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfex zzfex) throws Exception {
        for (zzfev zzfev : zzfex.zzb.zzc) {
            if (this.zza.containsKey(zzfev.zza)) {
                ((zzclz) this.zza.get(zzfev.zza)).zza(zzfev.zzb);
            } else if (this.zzb.containsKey(zzfev.zza)) {
                zzcly zzcly = (zzcly) this.zzb.get(zzfev.zza);
                JSONObject jSONObject = zzfev.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzcly.zza(hashMap);
            }
        }
    }
}
