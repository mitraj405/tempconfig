package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdzr implements zzful {
    public final /* synthetic */ zzbvb zza;

    public /* synthetic */ zzdzr(zzdzs zzdzs, zzbvb zzbvb) {
        this.zza = zzbvb;
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.zza.zza;
        if (bundle == null) {
            return jSONObject;
        }
        try {
            JSONObject zzi = zzay.zzb().zzi(bundle);
            try {
                zzay.zzb().zzl(jSONObject, zzi);
                return jSONObject;
            } catch (JSONException unused) {
                return zzi;
            }
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }
}
