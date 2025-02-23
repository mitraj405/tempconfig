package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzdfc;
import com.google.android.gms.internal.ads.zzdsf;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzm implements zzdfc {
    private final zzdsf zza;
    private final zzl zzb;
    private final String zzc;

    public zzm(zzdsf zzdsf, zzl zzl, String str) {
        this.zza = zzdsf;
        this.zzb = zzl;
        this.zzc = str;
    }

    public final void zze(zzay zzay) {
        if (zzay != null) {
            this.zzb.zzd(this.zzc, zzay.zzb, this.zza);
        }
    }

    public final void zzf(String str) {
    }
}
