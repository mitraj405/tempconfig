package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzgnb {
    private final Class zza;
    private final Class zzb;

    public /* synthetic */ zzgnb(Class cls, Class cls2, zzgna zzgna) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgnb)) {
            return false;
        }
        zzgnb zzgnb = (zzgnb) obj;
        if (!zzgnb.zza.equals(this.zza) || !zzgnb.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return xx.D(this.zza.getSimpleName(), " with primitive type: ", this.zzb.getSimpleName());
    }
}
