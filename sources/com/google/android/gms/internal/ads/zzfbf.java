package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfbf implements zzgbq {
    public final /* synthetic */ zzfbi zza;
    public final /* synthetic */ zzfcd zzb;
    public final /* synthetic */ zzfbh zzc;
    public final /* synthetic */ zzfcb zzd;
    public final /* synthetic */ zzcvx zze;

    public /* synthetic */ zzfbf(zzfbi zzfbi, zzfcd zzfcd, zzfbh zzfbh, zzfcb zzfcb, zzcvx zzcvx) {
        this.zza = zzfbi;
        this.zzb = zzfcd;
        this.zzc = zzfbh;
        this.zzd = zzfcb;
        this.zze = zzcvx;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze, (zzfbn) obj);
    }
}
