package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcxi extends zzdch {
    private boolean zzb = false;

    public zzcxi(Set set) {
        super(set);
    }

    public final synchronized void zza() {
        if (!this.zzb) {
            zzq(new zzcxh());
            this.zzb = true;
        }
    }
}
