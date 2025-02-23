package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghh extends zzgex {
    private final zzghg zza;

    private zzghh(zzghg zzghg) {
        this.zza = zzghg;
    }

    public static zzghh zzc(zzghg zzghg) {
        return new zzghh(zzghg);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof zzghh) && ((zzghh) obj).zza == this.zza) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzghh.class, this.zza});
    }

    public final String toString() {
        return lf.j("ChaCha20Poly1305 Parameters (variant: ", this.zza.toString(), ")");
    }

    public final boolean zza() {
        if (this.zza != zzghg.zzc) {
            return true;
        }
        return false;
    }

    public final zzghg zzb() {
        return this.zza;
    }
}
