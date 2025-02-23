package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzglk extends zzgen {
    private final zzgnm zza;

    public zzglk(zzgnm zzgnm) {
        this.zza = zzgnm;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzglk)) {
            return false;
        }
        zzgnm zzgnm = ((zzglk) obj).zza;
        if (!this.zza.zzc().zzg().equals(zzgnm.zzc().zzg()) || !this.zza.zzc().zzi().equals(zzgnm.zzc().zzi()) || !this.zza.zzc().zzh().equals(zzgnm.zzc().zzh())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzgnm zzgnm = this.zza;
        return Objects.hash(new Object[]{zzgnm.zzc(), zzgnm.zzd()});
    }

    public final String toString() {
        String str;
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zzc().zzi();
        int ordinal = this.zza.zzc().zzg().ordinal();
        if (ordinal == 1) {
            str = "TINK";
        } else if (ordinal == 2) {
            str = "LEGACY";
        } else if (ordinal == 3) {
            str = "RAW";
        } else if (ordinal != 4) {
            str = "UNKNOWN";
        } else {
            str = "CRUNCHY";
        }
        objArr[1] = str;
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public final boolean zza() {
        if (this.zza.zzc().zzg() != zzgtz.RAW) {
            return true;
        }
        return false;
    }

    public final zzgnm zzb() {
        return this.zza;
    }
}
