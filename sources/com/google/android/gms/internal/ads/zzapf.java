package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzapf implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzaph zzc;

    public zzapf(zzaph zzaph, String str, long j) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzaph;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        zzaph zzaph = this.zzc;
        zzaph.zza.zzb(zzaph.toString());
    }
}
