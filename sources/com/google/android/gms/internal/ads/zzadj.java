package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadj {
    public static final zzadj zza = new zzadj(0, 0);
    public final long zzb;
    public final long zzc;

    public zzadj(long j, long j2) {
        this.zzb = j;
        this.zzc = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadj.class == obj.getClass()) {
            zzadj zzadj = (zzadj) obj;
            if (this.zzb == zzadj.zzb && this.zzc == zzadj.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[timeUs=");
        sb.append(this.zzb);
        sb.append(", position=");
        return lf.l(sb, this.zzc, "]");
    }
}
