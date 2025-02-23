package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzerc implements zzhfc {
    private final zzhfu zza;

    public zzerc(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxw zzfxw;
        zzeqi zza2 = zzeqk.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdG)).booleanValue()) {
            zzfxw = zzfxw.zzo(new zzetw(zza2, (long) ((Integer) zzba.zzc().zza(zzbbw.zzdH)).intValue(), scheduledExecutorService));
        } else {
            zzfxw = zzfxw.zzn();
        }
        zzhfk.zzb(zzfxw);
        return zzfxw;
    }
}
