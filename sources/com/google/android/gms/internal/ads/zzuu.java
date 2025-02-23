package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzuu implements zzxv {
    private final zzxv zza;
    private final zzcd zzb;

    public zzuu(zzxv zzxv, zzcd zzcd) {
        this.zza = zzxv;
        this.zzb = zzcd;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuu)) {
            return false;
        }
        zzuu zzuu = (zzuu) obj;
        if (!this.zza.equals(zzuu.zza) || !this.zzb.equals(zzuu.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() + ((this.zzb.hashCode() + 527) * 31);
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int zzc() {
        return this.zza.zzc();
    }

    public final zzaf zzd(int i) {
        return this.zzb.zzb(this.zza.zza(i));
    }

    public final zzcd zze() {
        return this.zzb;
    }
}
