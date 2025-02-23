package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzepc implements zzevo {
    private final Executor zza;
    private final zzbze zzb;

    public zzepc(Executor executor, zzbze zzbze) {
        this.zza = executor;
        this.zzb = zzbze;
    }

    public final int zza() {
        return 10;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcv)).booleanValue()) {
            return zzgcj.zzh((Object) null);
        }
        return zzgcj.zzm(this.zzb.zzk(), new zzepb(), this.zza);
    }
}
