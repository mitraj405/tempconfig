package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdfl extends zzdch {
    private boolean zzb;

    public zzdfl(Set set) {
        super(set);
    }

    public final void zza() {
        zzq(new zzdfi());
    }

    public final void zzb() {
        zzq(new zzdfh());
    }

    public final synchronized void zzc() {
        if (!this.zzb) {
            zzq(new zzdfj());
            this.zzb = true;
        }
        zzq(new zzdfk());
    }

    public final synchronized void zzd() {
        zzq(new zzdfj());
        this.zzb = true;
    }
}
