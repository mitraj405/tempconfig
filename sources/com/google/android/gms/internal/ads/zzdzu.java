package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdzu implements zzfio {
    public final /* synthetic */ JSONObject zza;
    public final /* synthetic */ zzbvd zzb;

    public /* synthetic */ zzdzu(JSONObject jSONObject, zzbvd zzbvd) {
        this.zza = jSONObject;
        this.zzb = zzbvd;
    }

    public final Object zza(Object obj) {
        return new zzeax(zzebl.zza(new InputStreamReader((InputStream) obj)), this.zza, this.zzb);
    }
}
