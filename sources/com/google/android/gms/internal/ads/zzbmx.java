package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbmx implements Runnable {
    public final /* synthetic */ zzbmy zza;
    public final /* synthetic */ zzblv zzb;

    public /* synthetic */ zzbmx(zzbmy zzbmy, zzblv zzblv) {
        this.zza = zzbmy;
        this.zzb = zzblv;
    }

    public final void run() {
        zzblv zzblv = this.zzb;
        zzblv.zzr("/result", zzbiw.zzo);
        zzblv.zzc();
    }
}
