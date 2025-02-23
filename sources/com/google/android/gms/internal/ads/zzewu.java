package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzewu implements zzevo {
    private final Executor zza;
    private final String zzb;

    public zzewu(zzbyv zzbyv, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zza = executor;
        this.zzb = str;
    }

    public final int zza() {
        return 41;
    }

    public final ListenableFuture zzb() {
        return zzgcj.zzf(zzgcj.zzm(zzgcj.zzh(this.zzb), new zzews(), this.zza), Throwable.class, new zzewt(this), this.zza);
    }

    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        return zzgcj.zzh(new zzewv(this.zzb));
    }
}
