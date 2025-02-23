package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzghr extends zzgex {
    private final String zza;
    private final zzghq zzb;

    private zzghr(String str, zzghq zzghq) {
        this.zza = str;
        this.zzb = zzghq;
    }

    public static zzghr zzc(String str, zzghq zzghq) {
        return new zzghr(str, zzghq);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghr)) {
            return false;
        }
        zzghr zzghr = (zzghr) obj;
        if (!zzghr.zza.equals(this.zza) || !zzghr.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzghr.class, this.zza, this.zzb});
    }

    public final String toString() {
        String zzghq = this.zzb.toString();
        return "LegacyKmsAead Parameters (keyUri: " + this.zza + ", variant: " + zzghq + ")";
    }

    public final boolean zza() {
        if (this.zzb != zzghq.zzb) {
            return true;
        }
        return false;
    }

    public final zzghq zzb() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zza;
    }
}
