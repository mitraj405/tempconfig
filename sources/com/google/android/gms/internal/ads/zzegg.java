package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzegg implements zzgbq {
    public final /* synthetic */ zzegi zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ zzfex zzc;
    public final /* synthetic */ zzfel zzd;

    public /* synthetic */ zzegg(zzegi zzegi, Uri uri, zzfex zzfex, zzfel zzfel) {
        this.zza = zzegi;
        this.zzb = uri;
        this.zzc = zzfex;
        this.zzd = zzfel;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, obj);
    }
}
