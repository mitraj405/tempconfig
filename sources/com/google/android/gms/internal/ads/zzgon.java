package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgon extends zzgpj {
    private final int zza;
    private final int zzb;
    private final zzgol zzc;

    public /* synthetic */ zzgon(int i, int i2, zzgol zzgol, zzgom zzgom) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgol;
    }

    public static zzgok zze() {
        return new zzgok((zzgoj) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgon)) {
            return false;
        }
        zzgon zzgon = (zzgon) obj;
        if (zzgon.zza == this.zza && zzgon.zzd() == zzd() && zzgon.zzc == this.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgon.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        StringBuilder K = xx.K("AES-CMAC Parameters (variant: ", String.valueOf(this.zzc), ", ");
        K.append(this.zzb);
        K.append("-byte tags, and ");
        return lf.k(K, this.zza, "-byte key)");
    }

    public final boolean zza() {
        if (this.zzc != zzgol.zzd) {
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

    public final int zzd() {
        zzgol zzgol = this.zzc;
        if (zzgol == zzgol.zzd) {
            return this.zzb;
        }
        if (zzgol == zzgol.zza || zzgol == zzgol.zzb || zzgol == zzgol.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgol zzf() {
        return this.zzc;
    }
}
