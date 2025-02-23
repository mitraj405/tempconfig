package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcgw implements zzhfc {
    private final zzhfu zza;

    public zzcgw(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzdup zzdup = (zzdup) this.zza.zzb();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbt)).booleanValue()) {
            set = Collections.singleton(new zzdei(zzdup, zzgcu));
        } else {
            set = Collections.emptySet();
        }
        zzhfk.zzb(set);
        return set;
    }
}
