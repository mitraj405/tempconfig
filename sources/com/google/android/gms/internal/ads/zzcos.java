package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;
import in.juspay.hyper.constants.LogCategory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcos {
    private final zzdsk zza;
    private final zzfex zzb;

    public zzcos(zzdsk zzdsk, zzfex zzfex) {
        this.zza = zzdsk;
        this.zzb = zzfex;
    }

    public final void zza(long j, int i) {
        String str;
        zzdsj zza2 = this.zza.zza();
        zza2.zzd(this.zzb.zzb.zzb);
        zza2.zzb(LogCategory.ACTION, "ad_closed");
        zza2.zzb("show_time", String.valueOf(j));
        zza2.zzb(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        int i2 = i - 1;
        if (i2 == 0) {
            str = "h";
        } else if (i2 == 1) {
            str = "bb";
        } else if (i2 == 2) {
            str = "cc";
        } else if (i2 == 3) {
            str = "cb";
        } else if (i2 != 4) {
            str = "u";
        } else {
            str = "ac";
        }
        zza2.zzb("acr", str);
        zza2.zzf();
    }
}
