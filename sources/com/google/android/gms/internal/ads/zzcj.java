package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcj {
    public final int zza;
    private final zzcd zzb;
    private final boolean zzc;
    private final int[] zzd;
    private final boolean[] zze;

    static {
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    public zzcj(zzcd zzcd, boolean z, int[] iArr, boolean[] zArr) {
        boolean z2;
        int i = zzcd.zza;
        this.zza = i;
        boolean z3 = true;
        if (i == iArr.length && i == zArr.length) {
            z2 = true;
        } else {
            z2 = false;
        }
        zzdi.zzd(z2);
        this.zzb = zzcd;
        this.zzc = (!z || i <= 1) ? false : z3;
        this.zzd = (int[]) iArr.clone();
        this.zze = (boolean[]) zArr.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcj.class == obj.getClass()) {
            zzcj zzcj = (zzcj) obj;
            if (this.zzc != zzcj.zzc || !this.zzb.equals(zzcj.zzb) || !Arrays.equals(this.zzd, zzcj.zzd) || !Arrays.equals(this.zze, zzcj.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.zzd) + (((this.zzb.hashCode() * 31) + (this.zzc ? 1 : 0)) * 31);
        return Arrays.hashCode(this.zze) + (hashCode * 31);
    }

    public final int zza() {
        return this.zzb.zzc;
    }

    public final zzaf zzb(int i) {
        return this.zzb.zzb(i);
    }

    public final boolean zzc() {
        for (boolean z : this.zze) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzd(int i) {
        return this.zze[i];
    }
}
