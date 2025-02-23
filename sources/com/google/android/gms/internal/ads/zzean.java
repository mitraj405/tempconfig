package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzean implements Callable {
    public final /* synthetic */ zzbvb zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ ListenableFuture zzd;

    public /* synthetic */ zzean(zzbvb zzbvb, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) {
        this.zza = zzbvb;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = listenableFuture3;
    }

    public final Object call() {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && (bundle = this.zza.zzm) != null) {
            bundle.putLong(zzdrt.HTTP_RESPONSE_READY.zza(), zzu.zzB().currentTimeMillis());
        }
        ListenableFuture listenableFuture = this.zzd;
        return new zzeax((zzebl) this.zzb.get(), (JSONObject) this.zzc.get(), (zzbvd) listenableFuture.get());
    }
}
