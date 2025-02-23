package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcne implements zzgbq {
    public final /* synthetic */ Uri.Builder zza;

    public /* synthetic */ zzcne(Uri.Builder builder) {
        this.zza = builder;
    }

    public final ListenableFuture zza(Object obj) {
        zzbbn zzbbn = zzbbw.zzjp;
        Uri.Builder builder = this.zza;
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbbn), "12");
        return zzgcj.zzh(builder.toString());
    }
}
