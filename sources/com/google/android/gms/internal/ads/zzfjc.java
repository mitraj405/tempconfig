package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfjc {
    final /* synthetic */ zzfjd zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    private zzfjc(zzfjd zzfjd, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        this.zza = zzfjd;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }

    public final zzfiq zza() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        zzfiq zzfiq = new zzfiq(obj, str, this.zzf);
        this.zza.zzd.zza(zzfiq);
        ListenableFuture listenableFuture = this.zzd;
        zzfiz zzfiz = new zzfiz(this, zzfiq);
        zzgcu zzgcu = zzbzo.zzf;
        listenableFuture.addListener(zzfiz, zzgcu);
        zzgcj.zzr(zzfiq, new zzfja(this, zzfiq), zzgcu);
        return zzfiq;
    }

    public final zzfjc zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfjc zzc(Class cls, zzgbq zzgbq) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzf(this.zzf, cls, zzgbq, this.zza.zzb));
    }

    public final zzfjc zzd(ListenableFuture listenableFuture) {
        return zzg(new zzfiy(listenableFuture), zzbzo.zzf);
    }

    public final zzfjc zze(zzfio zzfio) {
        return zzf(new zzfix(zzfio));
    }

    public final zzfjc zzf(zzgbq zzgbq) {
        return zzg(zzgbq, this.zza.zzb);
    }

    public final zzfjc zzg(zzgbq zzgbq, Executor executor) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzn(this.zzf, zzgbq, executor));
    }

    public final zzfjc zzh(String str) {
        return new zzfjc(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfjc zzi(long j, TimeUnit timeUnit) {
        return new zzfjc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgcj.zzo(this.zzf, j, timeUnit, this.zza.zzc));
    }

    public /* synthetic */ zzfjc(zzfjd zzfjd, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2, zzfjb zzfjb) {
        this(zzfjd, obj, (String) null, listenableFuture, list, listenableFuture2);
    }
}
