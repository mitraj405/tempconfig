package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzerd implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzerd(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzetw(((zzeqo) this.zza).zzb(), (long) ((Integer) zzba.zzc().zza(zzbbw.zzlw)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
