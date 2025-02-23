package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadg {
    public final zzadj zza;
    public final zzadj zzb;

    public zzadg(zzadj zzadj, zzadj zzadj2) {
        this.zza = zzadj;
        this.zzb = zzadj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzadg.class == obj.getClass()) {
            zzadg zzadg = (zzadg) obj;
            if (!this.zza.equals(zzadg.zza) || !this.zzb.equals(zzadg.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode() + (this.zza.hashCode() * 31);
    }

    public final String toString() {
        String str;
        zzadj zzadj = this.zza;
        zzadj zzadj2 = this.zzb;
        String zzadj3 = zzadj.toString();
        if (zzadj.equals(zzadj2)) {
            str = "";
        } else {
            str = ", ".concat(this.zzb.toString());
        }
        return "[" + zzadj3 + str + "]";
    }
}
