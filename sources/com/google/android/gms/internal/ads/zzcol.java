package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcol implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzcol(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzcof zzcof = (zzcof) this.zza.zzb();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        if (((JSONObject) this.zzb.zzb()) == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzdei(zzcof, zzgcu));
        }
        zzhfk.zzb(set);
        return set;
    }
}
