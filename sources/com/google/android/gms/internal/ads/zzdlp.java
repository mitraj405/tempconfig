package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdlp implements Callable {
    public final /* synthetic */ zzfex zza;
    public final /* synthetic */ zzfel zzb;
    public final /* synthetic */ JSONObject zzc;

    public /* synthetic */ zzdlp(zzdlr zzdlr, zzfex zzfex, zzfel zzfel, JSONObject jSONObject) {
        this.zza = zzfex;
        this.zzb = zzfel;
        this.zzc = jSONObject;
    }

    public final Object call() {
        String str;
        zzdjb zzdjb = new zzdjb();
        JSONObject jSONObject = this.zzc;
        zzdjb.zzaa(jSONObject.optInt("template_id", -1));
        zzdjb.zzK(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        if (optJSONObject != null) {
            str = optJSONObject.optString("omid_partner_name");
        } else {
            str = null;
        }
        zzfex zzfex = this.zza;
        zzdjb.zzV(str);
        zzffg zzffg = zzfex.zza.zza;
        if (zzffg.zzg.contains(Integer.toString(zzdjb.zzc()))) {
            if (zzdjb.zzc() == 3) {
                if (zzdjb.zzA() == null) {
                    throw new zzeir(1, "No custom template id for custom template ad response.");
                } else if (!zzffg.zzh.contains(zzdjb.zzA())) {
                    throw new zzeir(1, "Unexpected custom template id in the response.");
                }
            }
            zzfel zzfel = this.zzb;
            zzdjb.zzY(jSONObject.optDouble("rating", -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzfel.zzM) {
                zzu.zzp();
                optString = xx.D(zzt.zzy(), " : ", optString);
            }
            zzdjb.zzZ("headline", optString);
            zzdjb.zzZ("body", jSONObject.optString("body", (String) null));
            zzdjb.zzZ("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdjb.zzZ("store", jSONObject.optString("store", (String) null));
            zzdjb.zzZ(FirebaseAnalytics.Param.PRICE, jSONObject.optString(FirebaseAnalytics.Param.PRICE, (String) null));
            zzdjb.zzZ("advertiser", jSONObject.optString("advertiser", (String) null));
            return zzdjb;
        }
        throw new zzeir(1, lf.h("Invalid template ID: ", zzdjb.zzc()));
    }
}
