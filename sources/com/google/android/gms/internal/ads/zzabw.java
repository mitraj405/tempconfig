package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzabw implements zzadi {
    public final int zza;
    public final int[] zzb;
    public final long[] zzc;
    public final long[] zzd;
    public final long[] zze;
    private final long zzf;

    public zzabw(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = iArr;
        this.zzc = jArr;
        this.zzd = jArr2;
        this.zze = jArr3;
        int length = iArr.length;
        this.zza = length;
        if (length > 0) {
            int i = length - 1;
            this.zzf = jArr2[i] + jArr3[i];
            return;
        }
        this.zzf = 0;
    }

    public final String toString() {
        long[] jArr = this.zzd;
        long[] jArr2 = this.zze;
        long[] jArr3 = this.zzc;
        String arrays = Arrays.toString(this.zzb);
        String arrays2 = Arrays.toString(jArr3);
        String arrays3 = Arrays.toString(jArr2);
        String arrays4 = Arrays.toString(jArr);
        StringBuilder sb = new StringBuilder("ChunkIndex(length=");
        sb.append(this.zza);
        sb.append(", sizes=");
        sb.append(arrays);
        sb.append(", offsets=");
        sb.append(arrays2);
        sb.append(", timeUs=");
        sb.append(arrays3);
        sb.append(", durationsUs=");
        return C0709Uj.j(sb, arrays4, ")");
    }

    public final long zza() {
        return this.zzf;
    }

    public final zzadg zzg(long j) {
        long[] jArr = this.zze;
        int zzc2 = zzet.zzc(jArr, j, true, true);
        zzadj zzadj = new zzadj(jArr[zzc2], this.zzc[zzc2]);
        if (zzadj.zzb >= j || zzc2 == this.zza - 1) {
            return new zzadg(zzadj, zzadj);
        }
        int i = zzc2 + 1;
        return new zzadg(zzadj, new zzadj(this.zze[i], this.zzc[i]));
    }

    public final boolean zzh() {
        return true;
    }
}
