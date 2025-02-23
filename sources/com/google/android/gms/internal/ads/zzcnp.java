package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcnp implements Runnable {
    public final /* synthetic */ zzcnu zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcnp(zzcnu zzcnu, int i, int i2) {
        this.zza = zzcnu;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
