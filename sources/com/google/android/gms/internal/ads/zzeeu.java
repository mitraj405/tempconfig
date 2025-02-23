package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeeu implements zzeet {
    public final zzeet zza;
    private final zzful zzb;

    public zzeeu(zzeet zzeet, zzful zzful) {
        this.zza = zzeet;
        this.zzb = zzful;
    }

    public final ListenableFuture zza(zzfex zzfex, zzfel zzfel) {
        return zzgcj.zzm(this.zza.zza(zzfex, zzfel), this.zzb, zzbzo.zza);
    }

    public final boolean zzb(zzfex zzfex, zzfel zzfel) {
        return this.zza.zzb(zzfex, zzfel);
    }
}
