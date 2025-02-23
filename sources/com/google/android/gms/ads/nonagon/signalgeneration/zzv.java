package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdoa;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzv implements zzgbq {
    public final /* synthetic */ zzak zza;
    public final /* synthetic */ zzdoa[] zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzv(zzak zzak, zzdoa[] zzdoaArr, String str) {
        this.zza = zzak;
        this.zzb = zzdoaArr;
        this.zzc = str;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzv(this.zzb, this.zzc, (zzdoa) obj);
    }
}
