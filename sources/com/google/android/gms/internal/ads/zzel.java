package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzel {
    public static final zzel zza = new zzel(-1, -1);
    private final int zzb;
    private final int zzc;

    static {
        new zzel(0, 0);
    }

    public zzel(int i, int i2) {
        boolean z = false;
        if ((i == -1 || i >= 0) && (i2 == -1 || i2 >= 0)) {
            z = true;
        }
        zzdi.zzd(z);
        this.zzb = i;
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzel) {
            zzel zzel = (zzel) obj;
            if (this.zzb == zzel.zzb && this.zzc == zzel.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        return ((i >>> 16) | (i << 16)) ^ this.zzc;
    }

    public final String toString() {
        return this.zzb + "x" + this.zzc;
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }
}
