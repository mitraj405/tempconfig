package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzerl implements zzhfc {
    private final zzhfu zza;

    public zzerl(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzetw(zzetd.zza(), (long) ((Integer) zzba.zzc().zza(zzbbw.zzlk)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
