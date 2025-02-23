package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcdh implements zzkb {
    private final zzyk zza = new zzyk(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    public final void zza(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zze();
        }
    }

    public final long zzb(zznz zznz) {
        return 0;
    }

    public final void zzc(zznz zznz) {
        zza(false);
    }

    public final void zzd(zznz zznz) {
        zza(true);
    }

    public final void zze(zznz zznz) {
        zza(true);
    }

    public final void zzf(zznz zznz, zzcc zzcc, zzui zzui, zzle[] zzleArr, zzwi zzwi, zzxv[] zzxvArr) {
        int i;
        int i2 = 0;
        this.zzf = 0;
        while (true) {
            int length = zzleArr.length;
            if (i2 < 2) {
                if (zzxvArr[i2] != null) {
                    int i3 = this.zzf;
                    if (zzleArr[i2].zzb() != 1) {
                        i = 131072000;
                    } else {
                        i = 13107200;
                    }
                    this.zzf = i3 + i;
                }
                i2++;
            } else {
                this.zza.zzf(this.zzf);
                return;
            }
        }
    }

    public final boolean zzg(zznz zznz) {
        return false;
    }

    public final boolean zzh(zzka zzka) {
        boolean z;
        long j = zzka.zzb;
        boolean z2 = true;
        if (j > this.zzc) {
            z = false;
        } else if (j < this.zzb) {
            z = true;
        } else {
            z = true;
        }
        int zza2 = this.zza.zza();
        int i = this.zzf;
        if (!z && (!z || !this.zzg || zza2 >= i)) {
            z2 = false;
        }
        this.zzg = z2;
        return z2;
    }

    public final boolean zzi(zzka zzka) {
        long j;
        if (zzka.zzd) {
            j = this.zze;
        } else {
            j = this.zzd;
        }
        if (j <= 0 || zzka.zzb >= j) {
            return true;
        }
        return false;
    }

    public final zzyk zzj() {
        return this.zza;
    }

    public final synchronized void zzk(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzl(int i) {
        this.zze = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zzb = ((long) i) * 1000;
    }
}
