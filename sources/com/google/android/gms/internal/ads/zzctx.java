package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzctx implements zza {
    private final zzcub zza;
    private final zzffg zzb;

    public zzctx(zzcub zzcub, zzffg zzffg) {
        this.zza = zzcub;
        this.zzb = zzffg;
    }

    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
