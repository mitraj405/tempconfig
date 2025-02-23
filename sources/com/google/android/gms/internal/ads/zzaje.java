package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaje implements zzajj {
    private final zzacv zza;
    private final zzacu zzb;
    private long zzc = -1;
    private long zzd = -1;

    public zzaje(zzacv zzacv, zzacu zzacu) {
        this.zza = zzacv;
        this.zzb = zzacu;
    }

    public final void zza(long j) {
        this.zzc = j;
    }

    public final long zzd(zzacl zzacl) {
        long j = this.zzd;
        if (j < 0) {
            return -1;
        }
        this.zzd = -1;
        return -(j + 2);
    }

    public final zzadi zze() {
        boolean z;
        if (this.zzc != -1) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        return new zzact(this.zza, this.zzc);
    }

    public final void zzg(long j) {
        long[] jArr = this.zzb.zza;
        this.zzd = jArr[zzet.zzc(jArr, j, true, true)];
    }
}
