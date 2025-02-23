package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgb implements zzfr {
    private final zzgo zza = new zzgo();
    private zzgu zzb;
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzgb zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzgb zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzgb zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzgb zze(zzgu zzgu) {
        this.zzb = zzgu;
        return this;
    }

    public final zzgb zzf(String str) {
        this.zzc = str;
        return this;
    }

    /* renamed from: zzg */
    public final zzgg zza() {
        zzgg zzgg = new zzgg(this.zzc, this.zzd, this.zze, this.zzf, false, this.zza, (zzfuv) null, false, (zzgf) null);
        zzgu zzgu = this.zzb;
        if (zzgu != null) {
            zzgg.zzf(zzgu);
        }
        return zzgg;
    }
}
