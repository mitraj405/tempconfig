package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfbd implements zzfcc {
    private zzcvx zza;
    private final Executor zzb = zzgda.zzb();

    public final zzcvx zza() {
        return this.zza;
    }

    public final ListenableFuture zzb(zzfcd zzfcd, zzfcb zzfcb, zzcvx zzcvx) {
        zzcvw zza2 = zzfcb.zza(zzfcd.zzb);
        zza2.zzb(new zzfcg(true));
        zzcvx zzcvx2 = (zzcvx) zza2.zzh();
        this.zza = zzcvx2;
        zzctc zzb2 = zzcvx2.zzb();
        zzfhd zzfhd = new zzfhd();
        return zzgcj.zzm(zzgcj.zzn(zzgca.zzu(zzb2.zzj()), new zzfbb(this, zzfhd, zzb2), this.zzb), new zzfbc(zzfhd), this.zzb);
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfcd zzfcd, zzfcb zzfcb, Object obj) {
        return zzb(zzfcd, zzfcb, (zzcvx) null);
    }

    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
