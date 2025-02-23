package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeas implements zzgbq {
    public final /* synthetic */ zzevr zza;
    public final /* synthetic */ zzbvb zzb;

    public /* synthetic */ zzeas(zzevr zzevr, zzbvb zzbvb) {
        this.zza = zzevr;
        this.zzb = zzbvb;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zza(zzay.zzb().zzi((Bundle) obj), this.zzb.zzm);
    }
}
