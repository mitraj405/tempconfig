package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdrk implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzdrk(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3, zzhfu zzhfu4) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        String str = (String) this.zza.zzb();
        Context zza2 = ((zzcgp) this.zzb).zza();
        zzgcu zzgcu = zzbzo.zza;
        zzhfk.zzb(zzgcu);
        Map zzd = ((zzhfg) this.zzc).zzb();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzet)).booleanValue()) {
            zzbav zzbav = new zzbav(new zzbbb(zza2));
            zzbav.zzb(new zzdrl(str));
            set = Collections.singleton(new zzdei(new zzdrn(zzbav, zzd), zzgcu));
        } else {
            set = Collections.emptySet();
        }
        zzhfk.zzb(set);
        return set;
    }
}
