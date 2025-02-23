package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdhm implements zzhfc {
    private final zzhfu zza;

    public zzdhm(zzhfu zzhfu) {
        this.zza = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        if (((zzdhj) this.zza).zza().zze() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzhfk.zzb(set);
        return set;
    }
}
