package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdmm implements zzgbq {
    public final /* synthetic */ zzdmw zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdmm(zzdmw zzdmw, JSONObject jSONObject) {
        this.zza = zzdmw;
        this.zzb = jSONObject;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (zzcej) obj);
    }
}
