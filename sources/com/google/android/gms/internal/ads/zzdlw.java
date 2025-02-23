package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzq;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdlw implements zzgbq {
    public final /* synthetic */ zzdme zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzfel zzc;
    public final /* synthetic */ zzfeo zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ String zzf;

    public /* synthetic */ zzdlw(zzdme zzdme, zzq zzq, zzfel zzfel, zzfeo zzfeo, String str, String str2) {
        this.zza = zzdme;
        this.zzb = zzq;
        this.zzc = zzfel;
        this.zzd = zzfeo;
        this.zze = str;
        this.zzf = str2;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, obj);
    }
}
