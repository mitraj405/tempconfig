package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfbg implements zzfho {
    private final zzfcc zza;

    public zzfbg(zzfcc zzfcc) {
        this.zza = zzfcc;
    }

    public final ListenableFuture zza(zzfhp zzfhp) {
        zzfbh zzfbh = (zzfbh) zzfhp;
        return ((zzfbd) this.zza).zzb(zzfbh.zzb, zzfbh.zza, (zzcvx) null);
    }

    public final void zzb(zzfhd zzfhd) {
        zzfhd.zza = ((zzfbd) this.zza).zza();
    }
}
