package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcnd implements zzgbq {
    public final /* synthetic */ zzcni zza;
    public final /* synthetic */ Uri.Builder zzb;

    public /* synthetic */ zzcnd(zzcni zzcni, Uri.Builder builder) {
        this.zza = zzcni;
        this.zzb = builder;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zze(this.zzb, (Throwable) obj);
    }
}
