package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzkf {
    public final long zza;
    public final float zzb;
    public final long zzc;

    public /* synthetic */ zzkf(zzkd zzkd, zzke zzke) {
        this.zza = zzkd.zza;
        this.zzb = zzkd.zzb;
        this.zzc = zzkd.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkf)) {
            return false;
        }
        zzkf zzkf = (zzkf) obj;
        if (this.zza == zzkf.zza && this.zzb == zzkf.zzb && this.zzc == zzkf.zzc) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    public final zzkd zza() {
        return new zzkd(this, (zzkc) null);
    }
}
