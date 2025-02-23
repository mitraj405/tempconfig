package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzck {
    public static final zzck zza = new zzck(zzfxr.zzm());
    private final zzfxr zzb;

    static {
        Integer.toString(0, 36);
    }

    public zzck(List list) {
        this.zzb = zzfxr.zzk(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzck.class != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzck) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzfxr zza() {
        return this.zzb;
    }

    public final boolean zzb(int i) {
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzcj zzcj = (zzcj) this.zzb.get(i2);
            if (zzcj.zzc() && zzcj.zza() == i) {
                return true;
            }
        }
        return false;
    }
}
