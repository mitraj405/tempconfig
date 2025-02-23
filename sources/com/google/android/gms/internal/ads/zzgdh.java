package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgdh extends zzgcs {
    final /* synthetic */ zzgdj zza;
    private final zzgbp zzb;

    public zzgdh(zzgdj zzgdj, zzgbp zzgbp) {
        this.zza = zzgdj;
        this.zzb = zzgbp;
    }

    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgbp zzgbp = this.zzb;
        ListenableFuture zza2 = zzgbp.zza();
        zzfuu.zzd(zza2, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgbp);
        return zza2;
    }

    public final String zzb() {
        return this.zzb.toString();
    }

    public final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((ListenableFuture) obj);
    }

    public final boolean zzg() {
        return this.zza.isDone();
    }
}
