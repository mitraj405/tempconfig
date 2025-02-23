package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbvk extends zzbvm {
    private final String zza;
    private final int zzb;

    public zzbvk(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbvk)) {
            zzbvk zzbvk = (zzbvk) obj;
            if (Objects.equal(this.zza, zzbvk.zza)) {
                if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbvk.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
