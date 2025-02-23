package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfbr implements zzfcc {
    private zzcvx zza;

    /* renamed from: zza */
    public final synchronized zzcvx zzd() {
        return this.zza;
    }

    public final synchronized ListenableFuture zzb(zzfcd zzfcd, zzfcb zzfcb, zzcvx zzcvx) {
        zzctc zzb;
        if (zzcvx != null) {
            this.zza = zzcvx;
        } else {
            this.zza = (zzcvx) zzfcb.zza(zzfcd.zzb).zzh();
        }
        zzb = this.zza.zzb();
        return zzb.zzi(zzb.zzj());
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcd zzfcd, zzfcb zzfcb, Object obj) {
        return zzb(zzfcd, zzfcb, (zzcvx) null);
    }
}
