package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzehj implements zzgbq {
    public final /* synthetic */ zzehn zza;
    public final /* synthetic */ zzdoa zzb;

    public /* synthetic */ zzehj(zzehn zzehn, zzdoa zzdoa) {
        this.zza = zzehn;
        this.zzb = zzdoa;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (JSONObject) obj);
    }
}
