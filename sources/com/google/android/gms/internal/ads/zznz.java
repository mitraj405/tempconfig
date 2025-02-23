package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zznz {
    public final String zza;
    private final zzny zzb;
    private final Object zzc;

    static {
        if (zzet.zza < 31) {
            new zznz("");
        } else {
            int i = zzny.zzb;
        }
    }

    public zznz(LogSessionId logSessionId, String str) {
        this.zzb = new zzny(logSessionId);
        this.zza = str;
        this.zzc = new Object();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zznz)) {
            return false;
        }
        zznz zznz = (zznz) obj;
        if (!Objects.equals(this.zza, zznz.zza) || !Objects.equals(this.zzb, zznz.zzb) || !Objects.equals(this.zzc, zznz.zzc)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb, this.zzc});
    }

    public final LogSessionId zza() {
        zzny zzny = this.zzb;
        zzny.getClass();
        return zzny.zza;
    }

    public zznz(String str) {
        zzdi.zzf(zzet.zza < 31);
        this.zza = str;
        this.zzb = null;
        this.zzc = new Object();
    }
}
