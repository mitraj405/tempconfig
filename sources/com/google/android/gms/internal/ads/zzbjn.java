package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbjn implements zzbix {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    public final void zza(Object obj, Map map) {
        String str;
        String str2 = (String) map.get(FacebookMediationAdapter.KEY_ID);
        String str3 = (String) map.get("fail");
        String str4 = (String) map.get("fail_reason");
        String str5 = (String) map.get("fail_stack");
        String str6 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            str = "\n".concat(String.valueOf(str5));
        }
        synchronized (this.zza) {
            zzbjm zzbjm = (zzbjm) this.zzb.remove(str2);
            if (zzbjm == null) {
                zzm.zzj("Received result for unexpected method invocation: " + str2);
            } else if (!TextUtils.isEmpty(str3)) {
                zzbjm.zza(str4 + str);
            } else if (str6 == null) {
                zzbjm.zzb((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zze.zzc()) {
                        String jSONObject2 = jSONObject.toString(2);
                        zze.zza("Result GMSG: " + jSONObject2);
                    }
                    zzbjm.zzb(jSONObject);
                } catch (JSONException e) {
                    zzbjm.zza(e.getMessage());
                }
            }
        }
    }

    public final ListenableFuture zzb(zzbme zzbme, String str, JSONObject jSONObject) {
        zzbzt zzbzt = new zzbzt();
        zzu.zzp();
        String uuid = UUID.randomUUID().toString();
        zzc(uuid, new zzbjl(this, zzbzt));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FacebookMediationAdapter.KEY_ID, uuid);
            jSONObject2.put("args", jSONObject);
            zzbme.zzl(str, jSONObject2);
        } catch (Exception e) {
            zzbzt.zzd(e);
        }
        return zzbzt;
    }

    public final void zzc(String str, zzbjm zzbjm) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbjm);
        }
    }
}
