package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdwy implements zzhfc {
    private final zzhfu zza;

    public zzdwy(zzhfu zzhfu) {
        this.zza = zzhfu;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = ((Context) this.zza.zzb()).getApplicationInfo();
        zzhfk.zzb(applicationInfo);
        return applicationInfo;
    }
}
