package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgiw extends zzgex {
    private final zzgiv zza;

    private zzgiw(zzgiv zzgiv) {
        this.zza = zzgiv;
    }

    public static zzgiw zzc(zzgiv zzgiv) {
        return new zzgiw(zzgiv);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzgiw) && ((zzgiw) obj).zza == this.zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgiw.class, this.zza});
    }

    public final String toString() {
        return lf.j("XChaCha20Poly1305 Parameters (variant: ", this.zza.toString(), ")");
    }

    public final boolean zza() {
        if (this.zza != zzgiv.zzc) {
            return true;
        }
        return false;
    }

    public final zzgiv zzb() {
        return this.zza;
    }
}
