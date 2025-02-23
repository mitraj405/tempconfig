package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzehi implements Callable {
    public final /* synthetic */ zzehn zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzfex zzd;
    public final /* synthetic */ zzfel zze;
    public final /* synthetic */ JSONObject zzf;

    public /* synthetic */ zzehi(zzehn zzehn, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzfex zzfex, zzfel zzfel, JSONObject jSONObject) {
        this.zza = zzehn;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzfex;
        this.zze = zzfel;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
