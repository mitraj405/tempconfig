package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzefw implements zzgbq {
    public final /* synthetic */ zzefy zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzfel zzc;

    public /* synthetic */ zzefw(zzefy zzefy, View view, zzfel zzfel) {
        this.zza = zzefy;
        this.zzb = view;
        this.zzc = zzfel;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
