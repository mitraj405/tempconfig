package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbs;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfeq {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    public zzfeq(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzi = zzbs.zzi(jsonReader);
        this.zzd = zzi;
        this.zza = zzi.optString("ad_html", (String) null);
        this.zzb = zzi.optString("ad_base_url", (String) null);
        this.zzc = zzi.optJSONObject("ad_json");
    }
}
