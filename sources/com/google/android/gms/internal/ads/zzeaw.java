package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzeaw implements zzbnh {
    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeax zzeax = (zzeax) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzit)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzeax.zzd.zzg());
            jSONObject2.put("ad_request_post_body", zzeax.zzd.zzf());
        }
        jSONObject2.put("base_url", zzeax.zzd.zzd());
        jSONObject2.put("signals", zzeax.zzc);
        jSONObject3.put("body", zzeax.zzb.zzc);
        jSONObject3.put("headers", zzay.zzb().zzj(zzeax.zzb.zzb));
        jSONObject3.put("response_code", zzeax.zzb.zza);
        jSONObject3.put("latency", zzeax.zzb.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzeax.zzd.zzi());
        return jSONObject;
    }
}
