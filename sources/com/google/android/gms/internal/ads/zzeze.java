package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeze implements zzevo {
    private final zzbze zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzgcu zze;

    public zzeze(zzbze zzbze, boolean z, boolean z2, zzbyt zzbyt, zzgcu zzgcu, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzbze;
        this.zzb = z;
        this.zzc = z2;
        this.zze = zzgcu;
        this.zzd = scheduledExecutorService;
    }

    public final int zza() {
        return 50;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzgu)).booleanValue() && this.zzc) {
            return zzgcj.zzh((Object) null);
        }
        if (!this.zzb) {
            return zzgcj.zzh((Object) null);
        }
        return zzgcj.zze(zzgcj.zzo(zzgcj.zzm(zzgcj.zzh((Object) null), new zzezc(), this.zze), ((Long) zzbeg.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzezd(this), this.zze);
    }

    public final /* synthetic */ zzezf zzc(Exception exc) {
        this.zza.zzw(exc, "TrustlessTokenSignal");
        return null;
    }
}
