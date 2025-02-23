package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdqv implements zzhfc {
    private final zzhfu zza;

    public zzdqv(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        zzdrn zza2 = ((zzdro) this.zza).zzb();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzet)).booleanValue()) {
            set = Collections.singleton(new zzdei(zza2, zzgcu));
        } else {
            set = Collections.emptySet();
        }
        zzhfk.zzb(set);
        return set;
    }
}
