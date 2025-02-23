package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgdi extends zzgcs {
    final /* synthetic */ zzgdj zza;
    private final Callable zzb;

    public zzgdi(zzgdj zzgdj, Callable callable) {
        this.zza = zzgdj;
        callable.getClass();
        this.zzb = callable;
    }

    public final Object zza() throws Exception {
        return this.zzb.call();
    }

    public final String zzb() {
        return this.zzb.toString();
    }

    public final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    public final void zze(Object obj) {
        this.zza.zzc(obj);
    }

    public final boolean zzg() {
        return this.zza.isDone();
    }
}
