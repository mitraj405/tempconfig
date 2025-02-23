package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcqt implements zzhfc {
    private final zzhfu zza;

    public zzcqt(zzhfu zzhfu) {
        this.zza = zzhfu;
    }

    /* renamed from: zza */
    public final Boolean zzb() {
        boolean z = true;
        if (((zzcwh) this.zza).zza().zza() == null) {
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzeV)).booleanValue()) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
