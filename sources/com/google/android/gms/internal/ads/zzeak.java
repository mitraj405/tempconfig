package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeak implements zzgbq {
    public final /* synthetic */ zzewr zza;
    public final /* synthetic */ zzbvb zzb;

    public /* synthetic */ zzeak(zzewr zzewr, zzbvb zzbvb) {
        this.zza = zzewr;
        this.zzb = zzbvb;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb().zza(zzay.zzb().zzi((Bundle) obj), this.zzb.zzm);
    }
}
