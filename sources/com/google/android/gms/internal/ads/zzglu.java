package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzglu {
    private final zzgln zza;
    private final List zzb;
    private final Integer zzc;

    public /* synthetic */ zzglu(zzgln zzgln, List list, Integer num, zzglt zzglt) {
        this.zza = zzgln;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzglu)) {
            return false;
        }
        zzglu zzglu = (zzglu) obj;
        if (!this.zza.equals(zzglu.zza) || !this.zzb.equals(zzglu.zzb) || !Objects.equals(this.zzc, zzglu.zzc)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }
}
