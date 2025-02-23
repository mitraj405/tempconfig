package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzact implements zzadi {
    private final zzacv zza;
    private final long zzb;

    public zzact(zzacv zzacv, long j) {
        this.zza = zzacv;
        this.zzb = j;
    }

    private final zzadj zzb(long j, long j2) {
        return new zzadj((j * 1000000) / ((long) this.zza.zze), this.zzb + j2);
    }

    public final long zza() {
        return this.zza.zza();
    }

    public final zzadg zzg(long j) {
        long j2;
        zzdi.zzb(this.zza.zzk);
        zzacv zzacv = this.zza;
        zzacu zzacu = zzacv.zzk;
        long[] jArr = zzacu.zza;
        long[] jArr2 = zzacu.zzb;
        int zzc = zzet.zzc(jArr, zzacv.zzb(j), true, false);
        long j3 = 0;
        if (zzc == -1) {
            j2 = 0;
        } else {
            j2 = jArr[zzc];
        }
        if (zzc != -1) {
            j3 = jArr2[zzc];
        }
        zzadj zzb2 = zzb(j2, j3);
        if (zzb2.zzb == j || zzc == jArr.length - 1) {
            return new zzadg(zzb2, zzb2);
        }
        int i = zzc + 1;
        return new zzadg(zzb2, zzb(jArr[i], jArr2[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
