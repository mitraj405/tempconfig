package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzui {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    private zzui(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzui)) {
            return false;
        }
        zzui zzui = (zzui) obj;
        if (this.zza.equals(zzui.zza) && this.zzb == zzui.zzb && this.zzc == zzui.zzc && this.zzd == zzui.zzd && this.zze == zzui.zze) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzui zza(Object obj) {
        if (this.zza.equals(obj)) {
            return this;
        }
        return new zzui(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        if (this.zzb != -1) {
            return true;
        }
        return false;
    }

    public zzui(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    public zzui(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public zzui(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
