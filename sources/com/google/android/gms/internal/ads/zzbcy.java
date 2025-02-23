package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbcy implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzbcy(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    /* renamed from: zza */
    public final zzbcx zzb() {
        return new zzbcx((ScheduledExecutorService) this.zza.zzb(), (zze) this.zzb.zzb());
    }
}
