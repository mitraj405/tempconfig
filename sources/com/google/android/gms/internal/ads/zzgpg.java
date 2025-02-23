package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgpg extends zzgpj {
    private final int zza;
    private final int zzb;
    private final zzgpe zzc;
    private final zzgpd zzd;

    public /* synthetic */ zzgpg(int i, int i2, zzgpe zzgpe, zzgpd zzgpd, zzgpf zzgpf) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = zzgpe;
        this.zzd = zzgpd;
    }

    public static zzgpc zze() {
        return new zzgpc((zzgpb) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpg)) {
            return false;
        }
        zzgpg zzgpg = (zzgpg) obj;
        if (zzgpg.zza == this.zza && zzgpg.zzd() == zzd() && zzgpg.zzc == this.zzc && zzgpg.zzd == this.zzd) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgpg.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        StringBuilder b = C0437ME.b("HMAC Parameters (variant: ", String.valueOf(this.zzc), ", hashType: ", String.valueOf(this.zzd), ", ");
        b.append(this.zzb);
        b.append("-byte tags, and ");
        return lf.k(b, this.zza, "-byte key)");
    }

    public final boolean zza() {
        if (this.zzc != zzgpe.zzd) {
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
        zzgpe zzgpe = this.zzc;
        if (zzgpe == zzgpe.zzd) {
            return this.zzb;
        }
        if (zzgpe == zzgpe.zza || zzgpe == zzgpe.zzb || zzgpe == zzgpe.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final zzgpd zzf() {
        return this.zzd;
    }

    public final zzgpe zzg() {
        return this.zzc;
    }
}
