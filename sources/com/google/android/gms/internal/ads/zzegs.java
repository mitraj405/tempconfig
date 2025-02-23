package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzegs implements zzful {
    public final /* synthetic */ zzcej zza;
    public final /* synthetic */ zzfel zzb;
    public final /* synthetic */ zzdfp zzc;

    public /* synthetic */ zzegs(zzegw zzegw, zzcej zzcej, zzfel zzfel, zzdfp zzdfp) {
        this.zza = zzcej;
        this.zzb = zzfel;
        this.zzc = zzdfp;
    }

    public final Object apply(Object obj) {
        zzcej zzcej = this.zza;
        if (this.zzb.zzM) {
            zzcej.zzah();
        }
        zzdfp zzdfp = this.zzc;
        zzcej.zzab();
        zzcej.onPause();
        return zzdfp.zzg();
    }
}
