package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdeu {
    private final List zza;
    private final zzfll zzb;
    private boolean zzc;

    public zzdeu(zzfel zzfel, zzfll zzfll) {
        this.zza = zzfel.zzp;
        this.zzb = zzfll;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zzd(this.zza);
            this.zzc = true;
        }
    }
}
