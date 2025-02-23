package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcoq implements zzhfc {
    private final zzhfu zza;

    public zzcoq(zzhfu zzhfu) {
        this.zza = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcsl) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
