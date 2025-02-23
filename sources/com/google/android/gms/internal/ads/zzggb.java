package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggb extends zzgex {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzgfz zzd;

    public /* synthetic */ zzggb(int i, int i2, int i3, zzgfz zzgfz, zzgga zzgga) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzgfz;
    }

    public static zzgfy zzd() {
        return new zzgfy((zzgfx) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggb)) {
            return false;
        }
        zzggb zzggb = (zzggb) obj;
        if (zzggb.zza == this.zza && zzggb.zzb == this.zzb && zzggb.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzggb.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd});
    }

    public final String toString() {
        StringBuilder K = xx.K("AesEax Parameters (variant: ", String.valueOf(this.zzd), ", ");
        K.append(this.zzb);
        K.append("-byte IV, 16-byte tag, and ");
        return lf.k(K, this.zza, "-byte key)");
    }

    public final boolean zza() {
        if (this.zzd != zzgfz.zzc) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzgfz zze() {
        return this.zzd;
    }
}
