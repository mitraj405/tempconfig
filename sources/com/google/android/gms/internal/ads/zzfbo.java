package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfbo implements zzfcc {
    private final zzfgu zza;
    private final Executor zzb;
    private final zzgcf zzc = new zzfbm(this);

    public zzfbo(zzfgu zzfgu, Executor executor) {
        this.zza = zzfgu;
        this.zzb = executor;
    }

    public final /* synthetic */ ListenableFuture zza(zzcvx zzcvx, zzfbx zzfbx) throws Exception {
        zzfgu zzfgu = this.zza;
        zzfhe zzfhe = zzfbx.zzb;
        zzbvb zzbvb = zzfbx.zza;
        zzfhd zzb2 = zzfgu.zzb(zzfhe);
        if (!(zzb2 == null || zzbvb == null)) {
            zzgcj.zzr(zzcvx.zzb().zzh(zzbvb), this.zzc, this.zzb);
        }
        return zzgcj.zzh(new zzfbn(zzfhe, zzbvb, zzb2));
    }

    public final ListenableFuture zzb(zzfcd zzfcd, zzfcb zzfcb, zzcvx zzcvx) {
        return zzgcj.zze(zzgcj.zzn(zzgca.zzu(new zzfby(this.zza, zzcvx, this.zzb).zzc()), new zzfbk(this, zzcvx), this.zzb), Exception.class, new zzfbl(this), this.zzb);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcd zzfcd, zzfcb zzfcb, Object obj) {
        return zzb(zzfcd, zzfcb, (zzcvx) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
