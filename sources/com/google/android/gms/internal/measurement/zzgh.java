package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzgh extends zzhg {
    private final Context zza;
    private final Supplier<Optional<zzgt>> zzb;

    public zzgh(Context context, Supplier<Optional<zzgt>> supplier) {
        if (context != null) {
            this.zza = context;
            this.zzb = supplier;
            return;
        }
        throw new NullPointerException("Null context");
    }

    public final boolean equals(Object obj) {
        Supplier<Optional<zzgt>> supplier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzhg) {
            zzhg zzhg = (zzhg) obj;
            if (!this.zza.equals(zzhg.zza()) || ((supplier = this.zzb) != null ? !supplier.equals(zzhg.zzb()) : zzhg.zzb() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        Supplier<Optional<zzgt>> supplier = this.zzb;
        if (supplier == null) {
            i = 0;
        } else {
            i = supplier.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        return C1058d.A("FlagsContext{context=", String.valueOf(this.zza), ", hermeticFileOverrides=", String.valueOf(this.zzb), "}");
    }

    public final Context zza() {
        return this.zza;
    }

    public final Supplier<Optional<zzgt>> zzb() {
        return this.zzb;
    }
}
