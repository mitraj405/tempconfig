package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghb extends zzgex {
    private final int zza;
    private final zzggz zzb;

    public /* synthetic */ zzghb(int i, zzggz zzggz, zzgha zzgha) {
        this.zza = i;
        this.zzb = zzggz;
    }

    public static zzggy zzc() {
        return new zzggy((zzggx) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghb)) {
            return false;
        }
        zzghb zzghb = (zzghb) obj;
        if (zzghb.zza == this.zza && zzghb.zzb == this.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzghb.class, Integer.valueOf(this.zza), this.zzb});
    }

    public final String toString() {
        return lf.k(xx.K("AesGcmSiv Parameters (variant: ", String.valueOf(this.zzb), ", "), this.zza, "-byte key)");
    }

    public final boolean zza() {
        if (this.zzb != zzggz.zzc) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzggz zzd() {
        return this.zzb;
    }
}
