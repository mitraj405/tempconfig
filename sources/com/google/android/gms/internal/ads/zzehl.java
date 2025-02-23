package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzehl implements zzgbq {
    public final /* synthetic */ zzehn zza;
    public final /* synthetic */ zzfex zzb;
    public final /* synthetic */ zzfel zzc;

    public /* synthetic */ zzehl(zzehn zzehn, zzfex zzfex, zzfel zzfel) {
        this.zza = zzehn;
        this.zzb = zzfex;
        this.zzc = zzfel;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, this.zzc, (JSONArray) obj);
    }
}
