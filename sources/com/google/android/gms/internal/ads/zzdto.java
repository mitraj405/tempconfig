package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdto {
    /* access modifiers changed from: private */
    public Long zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public String zzc;
    /* access modifiers changed from: private */
    public Integer zzd;
    /* access modifiers changed from: private */
    public String zze;
    /* access modifiers changed from: private */
    public Integer zzf;

    public /* synthetic */ zzdto(String str, zzdtn zzdtn) {
        this.zzb = str;
    }

    public static /* bridge */ /* synthetic */ String zza(zzdto zzdto) {
        String str = (String) zzba.zzc().zza(zzbbw.zzjd);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("objectId", zzdto.zza);
            jSONObject.put("eventCategory", zzdto.zzb);
            jSONObject.putOpt("event", zzdto.zzc);
            jSONObject.putOpt("errorCode", zzdto.zzd);
            jSONObject.putOpt("rewardType", zzdto.zze);
            jSONObject.putOpt("rewardAmount", zzdto.zzf);
        } catch (JSONException unused) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
        String jSONObject2 = jSONObject.toString();
        return str + "(\"h5adsEvent\"," + jSONObject2 + ");";
    }
}
