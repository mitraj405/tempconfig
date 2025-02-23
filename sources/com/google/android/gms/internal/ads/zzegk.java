package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzegk implements Runnable {
    public final /* synthetic */ zzegn zza;
    public final /* synthetic */ zzfex zzb;
    public final /* synthetic */ zzfel zzc;

    public /* synthetic */ zzegk(zzegn zzegn, zzfex zzfex, zzfel zzfel) {
        this.zza = zzegn;
        this.zzb = zzfex;
        this.zzc = zzfel;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc);
    }
}
