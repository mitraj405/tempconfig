package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgfp extends zzgex {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzgfn zze;
    private final zzgfm zzf;

    public /* synthetic */ zzgfp(int i, int i2, int i3, int i4, zzgfn zzgfn, zzgfm zzgfm, zzgfo zzgfo) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = zzgfn;
        this.zzf = zzgfm;
    }

    public static zzgfl zzf() {
        return new zzgfl((zzgfk) null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgfp)) {
            return false;
        }
        zzgfp zzgfp = (zzgfp) obj;
        if (zzgfp.zza == this.zza && zzgfp.zzb == this.zzb && zzgfp.zzc == this.zzc && zzgfp.zzd == this.zzd && zzgfp.zze == this.zze && zzgfp.zzf == this.zzf) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgfp.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        StringBuilder b = C0437ME.b("AesCtrHmacAead Parameters (variant: ", String.valueOf(this.zze), ", hashType: ", String.valueOf(this.zzf), ", ");
        b.append(this.zzc);
        b.append("-byte IV, and ");
        b.append(this.zzd);
        b.append("-byte tags, and ");
        b.append(this.zza);
        b.append("-byte AES key, and ");
        return lf.k(b, this.zzb, "-byte HMAC key)");
    }

    public final boolean zza() {
        if (this.zze != zzgfn.zzc) {
            return true;
        }
        return false;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzgfm zzg() {
        return this.zzf;
    }

    public final zzgfn zzh() {
        return this.zze;
    }
}
