package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgnv {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgnv(Class cls, Class cls2, zzgnu zzgnu) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnv)) {
            return false;
        }
        zzgnv zzgnv = (zzgnv) obj;
        if (!zzgnv.zza.equals(this.zza) || !zzgnv.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return xx.D(this.zza.getSimpleName(), " with serialization type: ", this.zzb.getSimpleName());
    }
}
