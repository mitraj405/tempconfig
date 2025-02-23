package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbnz implements zzbjm {
    private final zzbzt zza;

    public zzbnz(zzboa zzboa, zzbzt zzbzt) {
        this.zza = zzbzt;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zza.zzd(new zzbnd());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zza.zzd(new zzbnd(str));
        }
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zza.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zza.zzd(e);
        }
    }
}
