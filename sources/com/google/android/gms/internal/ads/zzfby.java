package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfby {
    private final zzfgu zza;
    private final zzcvx zzb;
    private final Executor zzc;
    /* access modifiers changed from: private */
    public zzfbx zzd;

    public zzfby(zzfgu zzfgu, zzcvx zzcvx, Executor executor) {
        this.zza = zzfgu;
        this.zzb = zzcvx;
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzfhe zze() {
        zzffg zzg = this.zzb.zzg();
        return this.zza.zzc(zzg.zzd, zzg.zzf, zzg.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFuture;
        zzfbx zzfbx = this.zzd;
        if (zzfbx != null) {
            return zzgcj.zzh(zzfbx);
        }
        if (!((Boolean) zzbdz.zza.zze()).booleanValue()) {
            zzfbx zzfbx2 = new zzfbx((zzbvb) null, zze(), (zzfbw) null);
            this.zzd = zzfbx2;
            listenableFuture = zzgcj.zzh(zzfbx2);
        } else {
            Class<zzdyp> cls = zzdyp.class;
            listenableFuture = zzgcj.zze(zzgcj.zzm(zzgca.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfbv(this), this.zzc), cls, new zzfbu(this), this.zzc);
        }
        return zzgcj.zzm(listenableFuture, new zzfbt(), this.zzc);
    }
}
