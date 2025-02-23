package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzgxh {
    private final Object zza;
    private final int zzb;

    public zzgxh(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgxh)) {
            return false;
        }
        zzgxh zzgxh = (zzgxh) obj;
        if (this.zza == zzgxh.zza && this.zzb == zzgxh.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
