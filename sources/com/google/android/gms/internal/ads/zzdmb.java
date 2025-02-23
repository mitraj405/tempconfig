package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdmb implements zzful {
    public final /* synthetic */ zzdme zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdmb(zzdme zzdme, JSONObject jSONObject) {
        this.zza = zzdme;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zza(this.zzb, (List) obj);
    }
}
