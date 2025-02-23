package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaox implements Runnable {
    private final zzaph zza;
    private final zzapn zzb;
    private final Runnable zzc;

    public zzaox(zzaph zzaph, zzapn zzapn, Runnable runnable) {
        this.zza = zzaph;
        this.zzb = zzapn;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzw();
        zzapn zzapn = this.zzb;
        if (zzapn.zzc()) {
            this.zza.zzo(zzapn.zza);
        } else {
            this.zza.zzn(zzapn.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
