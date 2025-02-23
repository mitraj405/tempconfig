package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzggo extends zzgex {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzggm zzd;

    public /* synthetic */ zzggo(int i, int i2, int i3, zzggm zzggm, zzggn zzggn) {
        this.zza = i;
        this.zzd = zzggm;
    }

    public static zzggl zzc() {
        return new zzggl((zzggk) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzggo)) {
            return false;
        }
        zzggo zzggo = (zzggo) obj;
        if (zzggo.zza == this.zza && zzggo.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzggo.class, Integer.valueOf(this.zza), 12, 16, this.zzd});
    }

    public final String toString() {
        return lf.k(xx.K("AesGcm Parameters (variant: ", String.valueOf(this.zzd), ", 12-byte IV, 16-byte tag, and "), this.zza, "-byte key)");
    }

    public final boolean zza() {
        if (this.zzd != zzggm.zzc) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzggm zzd() {
        return this.zzd;
    }
}
