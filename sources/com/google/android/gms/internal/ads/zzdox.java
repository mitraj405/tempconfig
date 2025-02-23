package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbbc;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdox implements zzhfc {
    private final zzhfu zza;

    public zzdox(zzhfu zzhfu) {
        this.zza = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbbc.zza.C0034zza zza2;
        if (((zzcwh) this.zza).zza().zzo.zza == 3) {
            zza2 = zzbbc.zza.C0034zza.REWARDED_INTERSTITIAL;
        } else {
            zza2 = zzbbc.zza.C0034zza.REWARD_BASED_VIDEO_AD;
        }
        zzhfk.zzb(zza2);
        return zza2;
    }
}
