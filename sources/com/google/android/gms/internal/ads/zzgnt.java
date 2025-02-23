package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgnt {
    private final Class zza;
    private final zzgvr zzb;

    public /* synthetic */ zzgnt(Class cls, zzgvr zzgvr, zzgns zzgns) {
        this.zza = cls;
        this.zzb = zzgvr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnt)) {
            return false;
        }
        zzgnt zzgnt = (zzgnt) obj;
        if (!zzgnt.zza.equals(this.zza) || !zzgnt.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return xx.D(this.zza.getSimpleName(), ", object identifier: ", String.valueOf(this.zzb));
    }
}
