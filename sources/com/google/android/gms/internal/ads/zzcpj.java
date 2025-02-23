package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcpj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzcpj(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    /* renamed from: zza */
    public final zzczj zzb() {
        return new zzczj((ScheduledExecutorService) this.zza.zzb(), (Clock) this.zzb.zzb());
    }
}
