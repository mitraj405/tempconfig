package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzvh {
    public final int zza;
    public final boolean zzb;

    public zzvh(int i, boolean z) {
        this.zza = i;
        this.zzb = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzvh.class == obj.getClass()) {
            zzvh zzvh = (zzvh) obj;
            if (this.zza == zzvh.zza && this.zzb == zzvh.zzb) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
