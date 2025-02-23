package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzlj {
    public static final zzlj zza;
    public static final zzlj zzb;
    public final long zzc;
    public final long zzd;

    static {
        zzlj zzlj = new zzlj(0, 0);
        zza = zzlj;
        new zzlj(Long.MAX_VALUE, Long.MAX_VALUE);
        new zzlj(Long.MAX_VALUE, 0);
        new zzlj(0, Long.MAX_VALUE);
        zzb = zzlj;
    }

    public zzlj(long j, long j2) {
        boolean z;
        boolean z2 = true;
        if (j >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        zzdi.zzd(j2 < 0 ? false : z2);
        this.zzc = j;
        this.zzd = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlj.class == obj.getClass()) {
            zzlj zzlj = (zzlj) obj;
            if (this.zzc == zzlj.zzc && this.zzd == zzlj.zzd) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzc) * 31) + ((int) this.zzd);
    }
}
