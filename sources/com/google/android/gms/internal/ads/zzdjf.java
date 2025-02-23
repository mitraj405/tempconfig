package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbs;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdjf extends zzdjg {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final JSONObject zzh;

    public zzdjf(zzfel zzfel, JSONObject jSONObject) {
        super(zzfel);
        JSONObject jSONObject2;
        this.zzb = zzbs.zzh(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzc = zzbs.zzl(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = zzbs.zzl(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zze = zzbs.zzl(false, jSONObject, "enable_omid");
        this.zzg = zzbs.zzb("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null ? true : z;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeF)).booleanValue()) {
            jSONObject2 = jSONObject.optJSONObject("omid_settings");
        } else {
            jSONObject2 = null;
        }
        this.zzh = jSONObject2;
    }

    public final zzffj zza() {
        JSONObject jSONObject = this.zzh;
        if (jSONObject != null) {
            return new zzffj(jSONObject);
        }
        return this.zza.zzV;
    }

    public final String zzb() {
        return this.zzg;
    }

    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
