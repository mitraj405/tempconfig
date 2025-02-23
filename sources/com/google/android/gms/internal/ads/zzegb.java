package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzegb implements zzgbq {
    public final /* synthetic */ zzege zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzfel zzc;

    public /* synthetic */ zzegb(zzege zzege, View view, zzfel zzfel) {
        this.zza = zzege;
        this.zzb = view;
        this.zzc = zzfel;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
