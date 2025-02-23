package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfbs implements zzfcc {
    private final zzfcc zza;
    private zzcvx zzb;

    public zzfbs(zzfcc zzfcc) {
        this.zza = zzfcc;
    }

    /* renamed from: zza */
    public final synchronized zzcvx zzd() {
        return this.zzb;
    }

    public final synchronized ListenableFuture zzb(zzfcd zzfcd, zzfcb zzfcb, zzcvx zzcvx) {
        this.zzb = zzcvx;
        if (zzfcd.zza != null) {
            zzctc zzb2 = zzcvx.zzb();
            return zzb2.zzi(zzb2.zzk(zzgcj.zzh(zzfcd.zza)));
        }
        return ((zzfbr) this.zza).zzb(zzfcd, zzfcb, zzcvx);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcd zzfcd, zzfcb zzfcb, Object obj) {
        return zzb(zzfcd, zzfcb, (zzcvx) null);
    }
}
