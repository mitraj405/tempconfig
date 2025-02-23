package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdzs {
    private final zzgcu zza;
    private final zzdzn zzb;
    private final zzfjl zzc;

    public zzdzs(zzgcu zzgcu, zzdzn zzdzn, zzfjl zzfjl) {
        this.zza = zzgcu;
        this.zzb = zzdzn;
        this.zzc = zzfjl;
    }

    public final ListenableFuture zza(zzbvb zzbvb) {
        zzfjc zzb2 = this.zzc.zzb(zzfjf.GMS_SIGNALS, zzgcj.zzm(zzgcj.zzh((Object) null), new zzdzp(zzbvb), this.zza));
        zzdzn zzdzn = this.zzb;
        Objects.requireNonNull(zzdzn);
        return zzgcj.zzm(zzb2.zzf(new zzdzq(zzdzn)).zza(), new zzdzr(this, zzbvb), this.zza);
    }
}
