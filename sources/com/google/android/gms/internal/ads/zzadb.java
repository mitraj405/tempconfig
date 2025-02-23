package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadb implements zzadi {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzadb(long[] jArr, long[] jArr2, long j) {
        boolean z;
        boolean z2;
        int length = jArr.length;
        int length2 = jArr2.length;
        if (length == length2) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        if (length2 > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzd = z2;
        if (!z2 || jArr2[0] <= 0) {
            this.zza = jArr;
            this.zzb = jArr2;
        } else {
            int i = length2 + 1;
            long[] jArr3 = new long[i];
            this.zza = jArr3;
            long[] jArr4 = new long[i];
            this.zzb = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        }
        this.zzc = j;
    }

    public final long zza() {
        return this.zzc;
    }

    public final zzadg zzg(long j) {
        if (!this.zzd) {
            zzadj zzadj = zzadj.zza;
            return new zzadg(zzadj, zzadj);
        }
        int zzc2 = zzet.zzc(this.zzb, j, true, true);
        zzadj zzadj2 = new zzadj(this.zzb[zzc2], this.zza[zzc2]);
        if (zzadj2.zzb != j) {
            long[] jArr = this.zzb;
            if (zzc2 != jArr.length - 1) {
                int i = zzc2 + 1;
                return new zzadg(zzadj2, new zzadj(jArr[i], this.zza[i]));
            }
        }
        return new zzadg(zzadj2, zzadj2);
    }

    public final boolean zzh() {
        return this.zzd;
    }
}
