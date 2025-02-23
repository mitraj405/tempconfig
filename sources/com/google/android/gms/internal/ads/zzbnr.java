package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbnr implements zzbjm {
    final /* synthetic */ zzbns zza;
    private final zzbmu zzb;
    private final zzbzt zzc;

    public zzbnr(zzbns zzbns, zzbmu zzbmu, zzbzt zzbzt) {
        this.zza = zzbns;
        this.zzb = zzbmu;
        this.zzc = zzbzt;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzc.zzd(new zzbnd());
            } catch (IllegalStateException unused) {
            } catch (Throwable th) {
                this.zzb.zzb();
                throw th;
            }
        } else {
            this.zzc.zzd(new zzbnd(str));
        }
        this.zzb.zzb();
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzc.zzc(this.zza.zza.zza(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzc.zzd(e);
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        this.zzb.zzb();
    }
}
